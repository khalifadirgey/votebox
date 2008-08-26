/**
  * This file is part of VoteBox.
  * 
  * VoteBox is free software: you can redistribute it and/or modify
  * it under the terms of the GNU General Public License as published by
  * the Free Software Foundation, either version 3 of the License, or
  * (at your option) any later version.
  * 
  * VoteBox is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  * 
  * You should have received a copy of the GNU General Public License
  * along with VoteBox.  If not, see <http://www.gnu.org/licenses/>.
 */
package verifier.value;

public class True extends TruthValue {

	public static final True SINGLETON = new True();

	private True() {
	}

	public Value execute(IValueVisitor visitor) {
		return visitor.forTrue(this);
	}

	public TruthValue not() {
		return False.SINGLETON;
	}

	@Override
	public String toString() {
		return "true";
	}
}