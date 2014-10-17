/**
 * Author : Gregory Vander Schueren
 * Date : 16/10/2014
 */

package Lib;

public class EmptyStackException extends Exception {
	private static final long serialVersionUID = 1L;

	public EmptyStackException(String message) {
        super(message);
    }
}