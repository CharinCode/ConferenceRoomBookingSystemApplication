-- สร้างตาราง meeting_room
CREATE TABLE IF NOT EXISTS meeting_room (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    capacity INT NOT NULL
);

-- เพิ่มข้อมูลตัวอย่างลงในตาราง meeting_room
INSERT INTO meeting_room (name, capacity) VALUES
('Room A', 10),
('Room B', 20),
('Room C', 30);

-- สร้างตาราง booking
CREATE TABLE IF NOT EXISTS booking (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    meeting_room_id BIGINT,
    booked_by VARCHAR(255) NOT NULL,
    start_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    end_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP + INTERVAL '1' HOUR,
    FOREIGN KEY (meeting_room_id) REFERENCES meeting_room(id)
);

-- เพิ่มข้อมูลตัวอย่างลงในตาราง booking
INSERT INTO booking (meeting_room_id, booked_by) VALUES
(1, 'Sumly'),
(2, 'Charin');
