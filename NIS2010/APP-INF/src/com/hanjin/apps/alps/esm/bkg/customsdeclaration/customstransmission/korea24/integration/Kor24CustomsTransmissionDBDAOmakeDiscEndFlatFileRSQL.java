/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Kor24CustomsTransmissionDBDAOmakeDiscEndFlatFileRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.08.10 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24CustomsTransmissionDBDAOmakeDiscEndFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * End Flat File  생성
	  * </pre>
	  */
	public Kor24CustomsTransmissionDBDAOmakeDiscEndFlatFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.integration ").append("\n");
		query.append("FileName : Kor24CustomsTransmissionDBDAOmakeDiscEndFlatFileRSQL").append("\n");
		query.append("*/").append("\n");
	}

	public String getSQL(){
		return query.toString();
	}

	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT '}BL_CNTR'  ||CHR(10)  END_FLAT_FILE" ).append("\n");
		query.append("FROM DUAL" ).append("\n");

	}
}