/*
   (C) Copyright 2013-2016 The RISCOSS Project Consortium
   
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

*/

package eu.riscoss.reasoner;

/**
 * A field of a Chunk; it is responsibility of the engine to ensure that
 * the DataType matches the class type of the value
 * 
 * @author albertosiena
 *
 */
public class Field {
	DataType	datatype;
	Object		value;
	
	public <T> Field( DataType dt, T value ) {
		this.datatype = dt;
		setValue( value );
	}
	
	public <T> T getValue() {
		return getValue( null );
	}

	@SuppressWarnings("unchecked")
	public <T> T getValue( T def ) {
		try {
			return (T)value;
		}
		catch( Exception ex ) {
			ex.printStackTrace();
			return def;
		}
	}
	
	public DataType getDataType() {
		return datatype;
	}
	
	public <T> void setValue( T value ) {
		this.value = value;
	}
}
