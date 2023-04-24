/**
 * UserRepository.java
 * 
 * @copyright 2023, Christian Ariel Modesto Duarte. All rights reserved.
 */

package ar.com.camd.bidfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.camd.bidfinder.model.User;

/**
 * <code>UserRepository</code>
 * Insert class description here.
 * 
 * @author   Christian Ariel Modesto Duarte <duarte.camd@gmail.com>
 * @version  1.0.0-SNAPSHOT
 */
public interface UserRepository extends JpaRepository<User, String> {

	/**
	 * Retrieve the user by username.
	 * @param username The user username.
	 * @return The user.
	 */
	User findUserByUsername(String username);
}
