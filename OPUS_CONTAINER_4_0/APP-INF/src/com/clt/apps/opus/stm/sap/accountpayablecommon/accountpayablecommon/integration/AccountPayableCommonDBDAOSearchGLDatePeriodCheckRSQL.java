/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableCommonDBDAOSearchGLDatePeriodCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.22
*@LastModifier : ORKIM
*@LastVersion : 1.0
* 2014.05.22 ORKIM
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ORKIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableCommonDBDAOSearchGLDatePeriodCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력된 G/L Date에 대해서 회계 Period을 Check하여 해당 월이 입력 가능한 Open월인지 확인 ( O : open , C : Close )
	  * </pre>
	  */
	public AccountPayableCommonDBDAOSearchGLDatePeriodCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOSearchGLDatePeriodCheckRSQL").append("\n"); 
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
		query.append("  SELECT DECODE( CHK1, '', DECODE(CHK2, '', CHK3, CHK2), CHK1 ) CHK_PRD" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("      SELECT MAX(CHK1) CHK1, MAX(CHK2) CHK2, MAX(CHK3) CHK3 " ).append("\n"); 
		query.append("      FROM" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("		SELECT  CLZ_STS_CD  AS CHK1 , '' CHK2, '' CHK3 " ).append("\n"); 
		query.append("		FROM AP_PERIOD " ).append("\n"); 
		query.append("		WHERE EFF_YRMON = SUBSTR(REPLACE(@[gl_dt],'-'),0,6) " ).append("\n"); 
		query.append("		AND SYS_DIV_CD = '34' " ).append("\n"); 
		query.append("		AND OFC_CD = @[ofc_cd] --  INPUT" ).append("\n"); 
		query.append("		AND AR_AP_DIV_CD = 'P'" ).append("\n"); 
		query.append("		UNION " ).append("\n"); 
		query.append("		SELECT  '' CHK1, CLZ_STS_CD AS CHK2 , '' CHK3" ).append("\n"); 
		query.append("		FROM    AP_PERIOD AP" ).append("\n"); 
		query.append("		      , MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("		WHERE   AP.EFF_YRMON  = SUBSTR(REPLACE(@[gl_dt],'-'),0,6) " ).append("\n"); 
		query.append("		AND AP.SYS_DIV_CD = '34' " ).append("\n"); 
		query.append("		AND MO.OFC_CD = @[ofc_cd]    " ).append("\n"); 
		query.append("		AND AP.AR_AP_DIV_CD = 'P'" ).append("\n"); 
		query.append("		AND     AP.OFC_CD = MO.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("		SELECT  '' CHK1, '' CHK2, prd_sts_cd  AS CHK3" ).append("\n"); 
		query.append("		FROM sco_period " ).append("\n"); 
		query.append("		WHERE eff_yrmon = SUBSTR(REPLACE(@[gl_dt],'-'),0,6) " ).append("\n"); 
		query.append("		AND prd_appl_cd = 'AP'" ).append("\n"); 
		query.append("      ) A" ).append("\n"); 
		query.append("  )" ).append("\n"); 

	}
}