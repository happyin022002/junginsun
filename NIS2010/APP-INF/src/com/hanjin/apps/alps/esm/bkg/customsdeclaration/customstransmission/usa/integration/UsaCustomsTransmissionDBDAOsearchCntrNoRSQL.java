/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchCntrNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.28
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.04.28 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchCntrNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCntrNo
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchCntrNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchCntrNoRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN CNTR_NO LIKE TRIM(@[cntr_no]) || '%' THEN TRIM(@[cntr_no])" ).append("\n"); 
		query.append("            ELSE SUBSTR(@[cntr_no], 1, 4) || TRIM(SUBSTR(@[cntr_no], 6))" ).append("\n"); 
		query.append("        END CNTR_NO" ).append("\n"); 
		query.append("  FROM MST_CONTAINER" ).append("\n"); 
		query.append(" WHERE CNTR_NO LIKE TRIM(@[cntr_no]) || '%'" ).append("\n"); 
		query.append("    OR (" ).append("\n"); 
		query.append("        SUBSTR(@[cntr_no], 5, 1) = '0'" ).append("\n"); 
		query.append("        AND" ).append("\n"); 
		query.append("        CNTR_NO LIKE SUBSTR(@[cntr_no], 1, 4) || TRIM(SUBSTR(@[cntr_no], 6)) || '%'" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}