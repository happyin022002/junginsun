/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DMTCommonFaxEmailDBDAOSearchEmailByPayerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfaxemail.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonFaxEmailDBDAOSearchEmailByPayerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DMTCommonFaxEmailDBDAOSearchEmailByPayerRSQL
	  * </pre>
	  */
	public DMTCommonFaxEmailDBDAOSearchEmailByPayerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("payer_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfaxemail.integration").append("\n"); 
		query.append("FileName : DMTCommonFaxEmailDBDAOSearchEmailByPayerRSQL").append("\n"); 
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
		query.append("SELECT BKG_JOIN_CLOB_FNC(CURSOR(" ).append("\n"); 
		query.append("	SELECT PAYR_CNTC_PNT_EML AS CUST_EML" ).append("\n"); 
		query.append("	FROM DMT_PAYR_CNTC_PNT" ).append("\n"); 
		query.append("	WHERE SYS_AREA_GRP_ID 	= (SELECT SYS_AREA_GRP_ID FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("							               WHERE CNT_CD = (SELECT SUBSTR(LOC_CD, 1, 2) FROM MDM_ORGANIZATION  WHERE OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("							               AND CO_IND_CD = 'H')" ).append("\n"); 
		query.append("      AND CUST_CNT_CD 	= DECODE(LENGTH(@[payer_cd]),6, CUST_CNT_CD, SUBSTR(@[payer_cd],1,2))" ).append("\n"); 
		query.append("      AND CUST_SEQ 		= DECODE(LENGTH(@[payer_cd]),6, @[payer_cd], SUBSTR(@[payer_cd],3) )" ).append("\n"); 
		query.append("      AND OTS_SND_FLG = 'Y' " ).append("\n"); 
		query.append("      AND PAYR_CNTC_PNT_EML LIKE '%@%'" ).append("\n"); 
		query.append("      )) AS CUST_EML" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}