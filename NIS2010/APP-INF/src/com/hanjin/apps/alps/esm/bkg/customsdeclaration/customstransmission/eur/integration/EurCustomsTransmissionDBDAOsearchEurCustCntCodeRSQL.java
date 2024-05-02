/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOsearchEurCustCntCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOsearchEurCustCntCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EurCustomsTransmissionDBDAOsearchEurCustCntCodeRSQL
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOsearchEurCustCntCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cm_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOsearchEurCustCntCodeRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    LTRIM (SYS_CONNECT_BY_PATH (INTG_CD_VAL_DESC, '|'), '|') AS CNT_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("        ,ROW_NUMBER () OVER (ORDER BY INTG_CD_VAL_DESC) RN" ).append("\n"); 
		query.append("        ,COUNT (*) OVER () CNT    " ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("            INTG_CD_VAL_DESC " ).append("\n"); 
		query.append("        FROM     COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE    INTG_CD_ID = @[cm_code]" ).append("\n"); 
		query.append("        GROUP BY INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE RN = CNT" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR RN = RN - 1" ).append("\n"); 

	}
}