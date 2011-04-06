import org.motechproject.tama.Clinic
import org.motechproject.tama.Doctor
import org.motechproject.tama.Gender
import org.motechproject.tama.InterventionProgram
import org.motechproject.tama.Patient
import org.motechproject.tama.PatientService
import org.motechproject.tama.Status
import org.motechproject.tama.dao.ClinicDao
import org.motechproject.tama.dao.DoctorDao
import org.motechproject.tama.dao.PatientDao

class BootStrap {

	def DoctorDao tamaDoctorDao
	def ClinicDao tamaClinicDao
	def PatientDao tamaPatientDao
	def PatientService patientService

	def init = { servletContext ->
		//FIXME: delete these once we have UI for managing doctor, clinic, etc.
		String clinicId="1"
		String doctorXId="1"
		String doctorYId="2"
		String patientId="1"

		if (!tamaClinicDao.contains(clinicId)){
			Clinic clinic = new Clinic(
					id: clinicId,
					name:"Test Clinic"
					)
			tamaClinicDao.add(clinic)
		}

		if (!tamaDoctorDao.contains(doctorXId)){
			Doctor doctorX = new Doctor(
					id: doctorXId,
					clinicId:clinicId,
					name:"Doctor X"
					)
			tamaDoctorDao.add(doctorX)
		}
		
		if (!tamaDoctorDao.contains(doctorYId)){
			Doctor doctorY = new Doctor(
					id: doctorYId,
					clinicId:clinicId,
					name:"Doctor Y"
					)
			tamaDoctorDao.add(doctorY)
		}
		
		if (!tamaPatientDao.contains(patientId)) {
			Patient patient = new Patient(
				id:patientId,
				clinicPatientId:"1234",
				gender:Gender.MALE,
				clinicId:clinicId,
				doctorId:doctorXId,
				passcode:"passwd",
				phoneNumber:"6046894123",
				interventionProgram: InterventionProgram.PROGRAM,
				dateOfBirth: new Date(),
				status:Status.ACTIVE
				)
			patientService.createPatient(patient)
		}
	}

	def destroy = {
	}
}
