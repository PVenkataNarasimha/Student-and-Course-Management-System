-- Insert Students (10 rows)
INSERT INTO students (first_name, last_name, email, enrollment_year) VALUES
('Aarav', 'Sharma', 'aarav.sharma@email.com', 2022),
('Vihaan', 'Verma', 'vihaan.verma@email.com', 2022),
('Ananya', 'Reddy', 'ananya.reddy@email.com', 2023),
('Ishaan', 'Patel', 'ishaan.patel@email.com', 2021),
('Sanya', 'Gupta', 'sanya.gupta@email.com', 2022),
('Rohan', 'Nair', 'rohan.nair@email.com', 2023),
('Diya', 'Joshi', 'diya.joshi@email.com', 2021),
('Aditya', 'Singh', 'aditya.singh@email.com', 2022),
('Kavya', 'Mehta', 'kavya.mehta@email.com', 2023),
('Arjun', 'Desai', 'arjun.desai@email.com', 2020);

-- Insert Courses (10 rows)
INSERT INTO courses (course_code, course_name, credits, instructor) VALUES
('CS101', 'Introduction to Programming', 4, 'Dr. Rajesh Sharma'),
('CS102', 'Data Structures', 4, 'Dr. Priya Verma'),
('CS103', 'Database Management', 3, 'Prof. Amit Singh'),
('CS104', 'Operating Systems', 3, 'Dr. Sunita Patel'),
('CS105', 'Web Development', 4, 'Prof. Vikram Reddy'),
('CS106', 'Software Engineering', 3, 'Dr. Neha Gupta'),
('CS107', 'Computer Networks', 4, 'Prof. Sanjay Joshi'),
('CS108', 'Artificial Intelligence', 4, 'Dr. Kavita Nair'),
('CS109', 'Cybersecurity', 3, 'Prof. Rahul Mehta'),
('CS110', 'Cloud Computing', 3, 'Dr. Anjali Desai');

-- Insert Enrollments (many-to-many relationships)
INSERT INTO enrollments (student_id, course_id) VALUES
(1, 1), (1, 2), (1, 3),  -- Aarav takes 3 courses
(2, 1), (2, 4),          -- Vihaan takes 2 courses
(3, 2), (3, 5), (3, 6),  -- Ananya takes 3 courses
(4, 3), (4, 7),          -- Ishaan takes 2 courses
(5, 1), (5, 4), (5, 8),  -- Sanya takes 3 courses
(6, 5), (6, 9),          -- Rohan takes 2 courses
(7, 2), (7, 6), (7, 10), -- Diya takes 3 courses
(8, 3), (8, 7),          -- Aditya takes 2 courses
(9, 4), (9, 8), (9, 9),  -- Kavya takes 3 courses
(10, 1), (10, 5), (10, 10); -- Arjun takes 3 courses
