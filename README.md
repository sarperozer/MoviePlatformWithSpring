# Movie Review Platform API

A RESTful API for a movie review platform where users can create reviews on movies and read others reviews.

## Tech Stack

- **Backend Framework:** Spring Boot 3.x
- **Security:** Spring Security + JWT
- **Database:** PostgreSQL
- **Build Tool:** Maven
- **Java Version:** 17+

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+

### Installation

1. Clone the repository
```bash
git clone https://github.com/sarperozer/MoviePlatformWithSpring.git
cd MoviePlatformWithSpring
```

2. Create `.env` file in the project root

3. Configure your environment variables in `.env`
```
DB_URL=jdbc:postgresql://localhost:5432/moviedb
DB_USERNAME=your_username
DB_PASSWORD=your_password

SECRET_KEY=your-secret-key-here-make-it-long-and-secure
```

3. Build the project
```bash
mvn clean install
```

4. Run the application
```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`

## API Endpoints

### Authentication

| Method | Endpoint | Description | Access |
|--------|----------|-------------|--------|
| POST | `/api/auth/register` | Register new user | Public |
| POST | `/api/auth/login` | Login user | Public |

### Movies

| Method | Endpoint | Description | Access |
|--------|----------|-------------|--------|
| GET | `/api/movies` | Get all movies | Public |
| GET | `/api/movies/{id}` | Get movie by ID | Public |
| POST | `/api/admin/movies` | Create new movie | Admin |
| PUT | `/api/admin/movies/{id}` | Update movie | Admin |
| DELETE | `/api/admin/movies/{id}` | Delete movie | Admin |

### Comments

| Method | Endpoint | Description | Access |
|--------|----------|-------------|--------|
| GET | `/api/movies/{movieId}/comments` | Get movie comments | Public |
| POST | `/api/movies/{movieId}/comments` | Add comment | Authenticated |
| PUT | `/api/movies/comments/{commentId}` | Update own comment | Authenticated |
| DELETE | `/api/movies/comments/{commentId}` | Delete own comment | Authenticated |
| DELETE | `/api/admin/comments/{commentId}` | Delete any comment | Admin |


## Roles & Permissions

### USER
- View movies
- Add comments
- Edit/delete own comments

### ADMIN
- All USER permissions
- Create/update/delete movies
- Delete any comment (moderation)

## Database Schema

### Users Table
- `id` (PRIMARY KEY)
- `username` (UNIQUE)
- `password` (ENCRYPTED)
- `role` (USER/ADMIN)

### Movies Table
- `id` (PRIMARY KEY)
- `title`
- `description`
- `year`

### Comments Table
- `id` (PRIMARY KEY)
- `movie_id` (FOREIGN KEY)
- `user_id` (FOREIGN KEY)
- `text`
- `created_at`
- `updated_at`

