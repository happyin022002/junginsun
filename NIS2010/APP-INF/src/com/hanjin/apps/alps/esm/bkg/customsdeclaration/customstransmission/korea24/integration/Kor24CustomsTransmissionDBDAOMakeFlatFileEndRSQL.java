/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Kor24CustomsTransmissionDBDAOMakeFlatFileEndRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.02 손윤석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son Yun Seuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24CustomsTransmissionDBDAOMakeFlatFileEndRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * MakeFlatFileEnd
	  * </pre>
	  */
	public Kor24CustomsTransmissionDBDAOMakeFlatFileEndRSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
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
		query.append("SELECT '}BL_CNTR'  ||CHR(10) TMP_DATA  /*  END of E/L Block    */" ).append("\n");
		query.append("FROM DUAL" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.customsdeclaration.customstransmission.korea24.integration ").append("\n");
		query.append("FileName : Kor24CustomsTransmissionDBDAOMakeFlatFileEndRSQL").append("\n");
		query.append("*/").append("\n");
	}
}