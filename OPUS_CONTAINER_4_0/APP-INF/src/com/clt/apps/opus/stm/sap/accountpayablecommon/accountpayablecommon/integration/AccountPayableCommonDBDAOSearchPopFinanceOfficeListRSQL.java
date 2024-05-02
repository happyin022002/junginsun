/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableCommonDBDAOSearchPopFinanceOfficeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableCommonDBDAOSearchPopFinanceOfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * STM_SAP_0500
	  * </pre>
	  */
	public AccountPayableCommonDBDAOSearchPopFinanceOfficeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOSearchPopFinanceOfficeListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT ALL_OFC.OFFICE_TYPE AS OFC_TP" ).append("\n"); 
		query.append("     , ALL_OFC.USER_ID              AS USER_ID" ).append("\n"); 
		query.append("     , MO.OFC_CD                    AS OFC_CD" ).append("\n"); 
		query.append("     , MO.OFC_ENG_NM                AS OFC_ENG_NM" ).append("\n"); 
		query.append("     , ALL_OFC.CONTROL_OFFICE_CODE  AS CTRL_OFC_CD" ).append("\n"); 
		query.append("FROM   MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("      ,(SELECT  DISTINCT 'AP'         AS OFFICE_TYPE" ).append("\n"); 
		query.append("              , MO.CRE_USR_ID         AS USER_ID" ).append("\n"); 
		query.append("              , MO.AP_OFC_CD          AS OFFICE_CODE" ).append("\n"); 
		query.append("              , MO.AP_CTRL_OFC_CD     AS CONTROL_OFFICE_CODE" ).append("\n"); 
		query.append("        FROM    MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("        WHERE   MO.OFC_CD IN (SELECT AP_OFC_CD FROM MDM_ORGANIZATION)" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  DISTINCT 'AP'         AS OFFICE_TYPE" ).append("\n"); 
		query.append("              , MO.CRE_USR_ID         AS USER_ID" ).append("\n"); 
		query.append("              , MO_1.AP_OFC_CD        AS OFFICE_CODE" ).append("\n"); 
		query.append("              , MO_1.AP_CTRL_OFC_CD   AS CONTROL_OFFICE_CODE" ).append("\n"); 
		query.append("        FROM    MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("             ,  MDM_ORGANIZATION MO_1" ).append("\n"); 
		query.append("        WHERE   MO.OFC_CD IN (SELECT AP_OFC_CD FROM MDM_ORGANIZATION)" ).append("\n"); 
		query.append("        AND     MO.AP_OFC_CD = MO_1.AP_CTRL_OFC_CD" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  DISTINCT 'AR'          AS OFFICE_TYPE" ).append("\n"); 
		query.append("              , MO.CRE_USR_ID          AS USER_ID" ).append("\n"); 
		query.append("              , MO.AR_OFC_CD           AS OFFICE_CODE" ).append("\n"); 
		query.append("              , MO.AR_HD_QTR_OFC_CD    AS CONTROL_OFFICE_CODE" ).append("\n"); 
		query.append("        FROM    MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("        WHERE   MO.OFC_CD IN (SELECT AR_OFC_CD FROM MDM_ORGANIZATION)" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  DISTINCT 'AR'          AS OFFICE_TYPE" ).append("\n"); 
		query.append("              , MO_1.CRE_USR_ID        AS USER_ID" ).append("\n"); 
		query.append("              , MO_1.AR_OFC_CD         AS OFFICE_CODE" ).append("\n"); 
		query.append("              , MO_1.AR_HD_QTR_OFC_CD  AS CONTROL_OFFICE_CODE" ).append("\n"); 
		query.append("        FROM    MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("             ,  MDM_ORGANIZATION MO_1" ).append("\n"); 
		query.append("             ,  SCO_OFC_INFO SOI" ).append("\n"); 
		query.append("        WHERE   MO.OFC_CD IN (SELECT AR_OFC_CD FROM MDM_ORGANIZATION)" ).append("\n"); 
		query.append("        AND     MO.OFC_CD = SOI.OFC_CD " ).append("\n"); 
		query.append("        AND     DECODE(SOI.OFC_INQ_LVL_CD, 'BA', MO.AR_OFC_CD, MO.AR_HD_QTR_OFC_CD) = MO_1.AR_HD_QTR_OFC_CD " ).append("\n"); 
		query.append("        ) ALL_OFC" ).append("\n"); 
		query.append("WHERE  MO.OFC_CD = ALL_OFC.OFFICE_CODE" ).append("\n"); 
		query.append("#if (${ofc_type} != '' && ${ofc_type} !='ALL')" ).append("\n"); 
		query.append("AND    ALL_OFC.OFFICE_TYPE = @[ofc_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_code} != '')" ).append("\n"); 
		query.append("AND    MO.OFC_CD = @[ofc_code]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}