function fetchAndPopulateStudentDetails() {
	$.ajax({
		url: 'fetchStudentDetails',
		method: 'GET',
		dataType: "json",
		success: function(data) {
			let table = $('#detailsTable tbody');
			table.empty();
			for (var i = 0; i < data.length; i++) {
				table.append(
					`<tr>
                        <td>${data[i].name}</td>
                        <td>${data[i].phoneno}</td>
                        <td>${data[i].state}</td>
                        <td>${data[i].district}</td>
                        <td>${data[i].emailId}</td>
                         <td>
                            <button class="edit-btn" data-username="${data[i].username}">Edit</button>
                        </td>
                    </tr>`
				);
			}
			$('.edit-btn').click(function() {
				const username = $(this).data('username');
				editStudent(username);
			});

		},
		error: function(error) {
			console.error('Error fetching student details:', error);
		}
	});
}

function editStudent(username) {

	$.ajax({
		url: 'getStudentDetails', // Endpoint to get details of a specific student
		method: 'GET',
		data: { username: username },
		dataType: "json",
		success: function(response) {
			console.log(response);
			$('#editStudentName').val(response.name);
			$('#editStudentPhone').val(response.phoneno);
			$('#editStudentEmail').val(response.emailId);
			$('#editStudentUsername').val(response.username);
			$.ajax({
				type: "GET",
				url: "getStates",
				dataType: "json",
				success: function(data) {
					console.log(data);
					var options = "<option value=''>Select State</option>";
					for (var i = 0; i < data.length; i++) {
						options += "<option value='" + data[i].stateId + "'>" + data[i].name + "</option>";
					}
					$('#editstate').html(options);
					const value = getStateIdFromName(data, response.state);
					$('#editstate option[value="' + value + '"]').prop('selected', true);
					fetchDistricts(value, response.district);
				},
				error: function(jqXHR, textStatus, errorThrown) {
					console.error("Error fetching states: " + errorThrown);
				}
			});
			function getStateIdFromName(states, stateName) {
				for (var i = 0; i < states.length; i++) {
					if (states[i].name === stateName) {
						return states[i].stateId;
					}
				}
				return ''; 
			}
			$('#editStudentModal').show();
		},
		error: function(error) {
			console.error('Error fetching student details:', error);
		}
	});
}

function fetchDistricts(stateId, studentDistrict) {
	if (stateId) {
		$.ajax({
			type: "GET",
			url: "getDistricts", 
			dataType: "json",
			data: { stateId: stateId },
			success: function(data) {
				var id;
				var options = "<option value=''>Select District</option>";
				for (var i = 0; i < data.length; i++) {
					options += "<option value='" + data[i].districtId + "'>" + data[i].name + "</option>";
					if (studentDistrict===data[i].name) {
						id=data[i].districtId;
					$('#editDistrict option[value="' + data[i].districtId + '"]').prop('selected', true);
				}
				}

				$('#editDistrict').html(options);
				if(studentDistrict!==-1)
				{
					
					$('#editDistrict option[value="' + id + '"]').prop('selected', true);
				}
				
			},
			error: function(jqXHR, textStatus, errorThrown) {
				console.error("Error fetching districts: " + errorThrown);
			}
		});
	} else {
		$('#editDistrict').empty(); // Clear district dropdown if no state is selected
	}
}

$(document).ready(function() {



	// Event listener for change in state dropdown
	$('#editstate').change(function() {
		var selectedStateId = $(this).val();
		var studentDistrictId = $('#editStudentDistrict').val(); // Get the student's district ID
		fetchDistricts(selectedStateId, -1);
	});

	$.ajax({
		type: "GET",
		url: "getStates",
		dataType: "json",
		success: function(data) {
			var options = "<option value=''>Select State</option>";
			for (var i = 0; i < data.length; i++) {
				options += "<option value='" + data[i].stateId + "'>" + data[i].name + "</option>";
			}
			$('#state').html(options);
		},
		error: function(jqXHR, textStatus, errorThrown) {
			console.error("Error fetching states: " + errorThrown);
		}
	});


	$('#addStudentForm').submit(function(event) {
		event.preventDefault(); // Prevent default form submission
		var formData = $(this).serialize(); // Serialize form data

		// AJAX call to submit form data
		$.ajax({
			url: 'addStudent', // Endpoint to handle form submission
			method: 'POST',
			data: formData,
			success: function(response) {
				fetchAndPopulateStudentDetails();
				$('#addStudentForm')[0].reset();

			},
			error: function(jqXHR, textStatus, errorThrown) {
				console.error('Error adding student:', errorThrown);
			}
		});
	});

	$('.edit-btn').click(function() {
		const username = $(this).data('username');
		editStudent(username);
	});


	fetchAndPopulateStudentDetails();

	$('#state').on('change', function() {
		var stateId = $(this).val();
		if (stateId) {
			$.ajax({
				type: "GET",
				url: "getDistricts", // Adjust URL to match your backend endpoint
				data: { stateId: stateId },
				dataType: "json",
				success: function(data) {
					console.log(data);
					var options = "<option value=''>Select District</option>";
					for (var i = 0; i < data.length; i++) {
						options += "<option value='" + data[i].districtId + "'>" + data[i].name + "</option>";
					}
					$('#district').html(options);
				},
				error: function(jqXHR, textStatus, errorThrown) {
					console.error("Error fetching districts: " + errorThrown);
				}


			});
		} else {
			$('#district').html("<option value=''>Select District</option>");
		}
	});
	$('#editStudentForm').submit(function(event) {
		event.preventDefault(); // Prevent default form submission
		var formData = $(this).serialize(); // Serialize form data

		// AJAX call to submit edited form data
		$.ajax({
			url: 'updateStudent', // Endpoint to handle student update
			method: 'POST',
			data: formData,
			success: function(response) {

				$('#editStudentModal').hide();

				fetchAndPopulateStudentDetails()
			},
			error: function(jqXHR, textStatus, errorThrown) {
				console.error('Error updating student:', errorThrown);
			}
		});
	});
	$('.close').click(function() {
		$('#editStudentModal').hide();
	});

	// Close the modal when the user clicks anywhere outside of the modal
	$(window).click(function(event) {
		if (event.target == document.getElementById('editStudentModal')) {
			$('#editStudentModal').hide();
		}
	});


	




});