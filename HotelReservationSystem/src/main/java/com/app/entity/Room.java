package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rooms")
public class Room {

//	Room ID, room number, type (single, double, suite), price, availability
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="room_id")
	private Integer roomId;
	
	@Column(name="room_number")
	private int roomNumber;
	
	@Column(name="room_type")
	@Enumerated(EnumType.STRING)
	private RoomType roomType;
	
	@Column
	private double price;
	
	@Column
	private boolean availability;
	
}
