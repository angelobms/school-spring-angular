/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.bmsti.school.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Model <b>Student</b> represents the table <b>student</b> in database
 * <b>school</b>. A persistent object of this class represents a record in the
 * table student.
 * 
 * @author Angelo Brandao - (angelobms@gmail.com)
 * @version 1.0
 */
@Data
@Entity
@Table(name = "student")
public final class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final Long id;
	private final Long registry;
	private final String name;
	private final String email;
	private final String phone;
	private final BigDecimal grade;
	
	private Student(Builder builder) {
		id = builder.id;
		registry = builder.registry;
		name = builder.name;
		email = builder.email;
		phone = builder.phone;
		grade = builder.grade;
	}
	
	/*static Builder getBuilder() {
        return new Builder();
	}*/

	// Builder Pattern
	public static class Builder {

		// Required parameters
		private final Long id;
		private final Long registry;
		private final String name;

		// Optional parameters - initialized to default values
		private String email = "";
		private String phone = "";
		private BigDecimal grade = BigDecimal.ZERO;						

		public Builder(Long id, Long registry, String name) {
			this.id = id;
			this.registry = registry;
			this.name = name;
		}

		//private Builder() {}

		public Builder email(String value) {
			email = value;
			return this;
		}

		public Builder phone(String value) {
			phone = value;
			return this;
		}

		public Builder grade(BigDecimal value) {
			grade = value;
			return this;
		}

		public Student build() {
			return new Student(this);
		}

	}

}
