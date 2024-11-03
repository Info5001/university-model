/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseSchedule;

import CourseCatalog.Course;
import Persona.Faculty.FacultyAssignment;
import Persona.Faculty.FacultyProfile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */

// Course offer is a Course taught in a
// certain semester by a faculty and it has Seats
public class CourseOffer {
    Course course;
    ArrayList<Seat> seatlist;
    FacultyAssignment facultyassignment;

    public CourseOffer(Course c) {
        course = c;
        seatlist = new ArrayList();
    }

    public void assignAsTeacher(FacultyProfile fp) {
        facultyassignment = new FacultyAssignment(fp, this);
    }

    public FacultyProfile getFacultyProfile() {
        return facultyassignment.getFacultyProfile();
    }

    public String getCourseNumber() {
        return course.getCOurseNumber();
    }

    public void generateSeats(int n) {
        for (int i = 0; i < n; i++) {
            seatlist.add(new Seat(this, i));
        }
    }

    public Seat getEmptySeat() {
        for (Seat s : seatlist) {
            if (!s.isOccupied()) {
                return s;
            }
        }
        return null;
    }

    public int getEmptySeatsCount() {
        int counter = 0;

        for (Seat s : seatlist) {
            if (!s.isOccupied()) {
                counter++; // counter = counter + 1;
            }
        }
        return counter;
    }

    public SeatAssignment assignEmptySeat(CourseLoad cl) {
        Seat seat = getEmptySeat();
        if (seat == null) {
            return null;
        }
        SeatAssignment sa = seat.newSeatAssignment(cl); // seat is already linked to course offer
        cl.registerStudent(sa); // coures offer seat is now linked to student
        return sa;
    }

    public int getTotalCourseRevenues() {
        int sum = 0;
        for (Seat s : seatlist) {
            if (s.isOccupied() == true) {
                sum = sum + course.getCoursePrice();
            }

        }
        return sum;
    }

    public Course getSubjectCourse() {
        return course;
    }

    public int getCreditHours() {
        return course.getCredits();
    }

    public void printCourseOfferInformation() {
        System.out.print(course.getName() + " | ");
        System.out.print(getCourseNumber() + " | ");
        System.out.print(getCreditHours() + " credit hours | ");
        System.out.print(getEmptySeatsCount() + " avail. / ");
        System.out.println("" + seatlist.size() + " total seats.");
    }

}
