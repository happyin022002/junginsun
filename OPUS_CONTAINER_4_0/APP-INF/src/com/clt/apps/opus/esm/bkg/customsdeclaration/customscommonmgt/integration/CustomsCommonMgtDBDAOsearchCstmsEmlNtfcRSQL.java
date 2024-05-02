/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CustomsCommonMgtDBDAOsearchCstmsEmlNtfcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomsCommonMgtDBDAOsearchCstmsEmlNtfcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public CustomsCommonMgtDBDAOsearchCstmsEmlNtfcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.integration").append("\n"); 
		query.append("FileName : CustomsCommonMgtDBDAOsearchCstmsEmlNtfcRSQL").append("\n"); 
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
		query.append("SELECT C_EML.CNT_CD," ).append("\n"); 
		query.append("       DECODE(C_EML.CNT_CD, 'US', 'United States', 'CA', 'Canada', 'EU', 'Europe', 'CN', 'China', 'JP', 'Japan') AS CNT_NM," ).append("\n"); 
		query.append("       C_EML.EDI_MSG," ).append("\n"); 
		query.append("       C_EML.EDI_MSG_TP_ID," ).append("\n"); 
		query.append("       TRIM(C_EML.POL_CD) AS POL_CD," ).append("\n"); 
		query.append("       (SELECT M_LOC.LOC_NM" ).append("\n"); 
		query.append("          FROM MDM_LOCATION M_LOC" ).append("\n"); 
		query.append("         WHERE M_LOC.LOC_CD = C_EML.POL_CD) AS POL_NM," ).append("\n"); 
		query.append("       TRIM(C_EML.POD_CD) AS POD_CD," ).append("\n"); 
		query.append("       (SELECT M_LOC.LOC_NM" ).append("\n"); 
		query.append("          FROM MDM_LOCATION M_LOC" ).append("\n"); 
		query.append("         WHERE M_LOC.LOC_CD = C_EML.POD_CD) AS POD_NM," ).append("\n"); 
		query.append("       C_EML.TO_EML_CTNT," ).append("\n"); 
		query.append("       C_EML.CC_EML_CTNT," ).append("\n"); 
		query.append("       C_EML.UPD_USR_ID AS USR_ID," ).append("\n"); 
		query.append("       TO_CHAR(C_EML.UPD_DT, 'YYYY-MM-DD HH24:MI') AS UPD_DT," ).append("\n"); 
		query.append("       C_EML.EDI_MSG AS ORG_EDI_MSG," ).append("\n"); 
		query.append("       C_EML.EDI_MSG_TP_ID AS ORG_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("       C_EML.POL_CD AS ORG_POL_CD," ).append("\n"); 
		query.append("       C_EML.POD_CD AS ORG_POD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_EML_NTFC C_EML" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" WHERE C_EML.CNT_CD = @[cnt_cd]" ).append("\n"); 

	}
}