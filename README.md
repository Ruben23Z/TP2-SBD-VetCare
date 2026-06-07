# VetCare — Veterinary Clinic Management System

> A full-stack web platform for operational management of a veterinary clinic chain, developed for the **Database Systems** course at ISEL.

---

## Context

Managing veterinary clinics involves multiple interconnected processes that, when handled manually or in isolation, create operational inefficiencies: missed appointments, incomplete clinical histories, and no consolidated view of clinic activity.

**VetCare** addresses this with a centralised information system covering the full lifecycle of a veterinary patient — from animal and owner registration, through appointment scheduling, to detailed clinical history and staff administration.

The project was built as the final assignment for the Database Systems course (LEIM — ISEL), applying relational modelling, referential integrity, transactions, triggers, and views in a practical context.

---

## Features

**User Profiles & Access Control**
- Four distinct roles — Client (Owner), Receptionist, Vet, and Manager — each restricted to their relevant functionality
- Registration and authentication with automatic redirection to the role-specific dashboard

**Patients & Owners**
- Full pet registration including clinical data, photo, microchip (transponder), and breed/species
- Association with individual or corporate owners, with NIF and address validation
- Interactive **genealogy tree** per patient, with navigation across ancestor generations

**Medical Service Scheduling**
- Create, reschedule, and cancel appointments from any authorised role
- Six service types: Consultation, Surgery, Vaccination, Deworming, Therapeutic Treatment, and Examination (with sub-types: X-Ray, Ultrasound, Lab Analysis)
- Attendance confirmation and status management (pending, active, rescheduled, cancelled)

**Clinical Records**
- Full service history per patient, with vet-editable clinical notes
- Daily call list per veterinarian
- Real-time patient search by owner name with auto-suggest

**Statistics & Reports (Manager Panel)**
- Animals that have exceeded their species' average life expectancy
- Animals overweight relative to their breed standard
- Ranking of owners with the most cancellations in the last quarter
- Weekly forecast of scheduled services by type

**Data Import / Export**
- Export individual clinical records as **JSON** or **XML**
- Import records from the same formats, with data validation

**Schedule Management**
- Assign vets to clinics and working days, with automatic conflict validation

---

## Technologies

- **Java (Jakarta EE / Servlets)** — business logic and application flow
- **JSP (JavaServer Pages)** — server-side UI rendering
- **MySQL** — relational database with triggers, views, and integrity constraints
- **JDBC** — direct Java-to-database communication
- **Bootstrap 5** — UI components and responsive design
- **HTML5 / CSS3 / JavaScript** — client-side interface and interactivity
- **Apache Tomcat** — web application server

---

## What I Learned

**Database design:** modelling specialisation hierarchies (a medical service can be a consultation, surgery, or examination — each with distinct attributes) while enforcing exclusivity via triggers. Atomic transaction management — e.g. simultaneously creating a user and their role-specific profile — required careful reasoning about consistency and data integrity.

**Application architecture:** MVC pattern with clear separation between data access (DAOs), control logic (Servlets), and presentation (JSPs). Role-based access control via session filters introduced real security and authorisation concerns.

VetCare demonstrates the ability to design, model, and implement a multi-role web application with complex business rules and a robust relational database — skills directly transferable to professional software development.

---

> **Authors:** Ruben Zhang (51388) · Marcelo Almeida (51888) · Gonçalo Ribeiro (51813)
> **Course:** Database Systems — LEIM, ISEL
