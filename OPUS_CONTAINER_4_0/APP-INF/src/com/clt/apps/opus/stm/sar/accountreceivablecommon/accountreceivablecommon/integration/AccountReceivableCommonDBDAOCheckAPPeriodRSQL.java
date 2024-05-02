/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableCommonDBDAOCheckAPPeriodRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableCommonDBDAOCheckAPPeriodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Check AP period
	  * </pre>
	  */
	public AccountReceivableCommonDBDAOCheckAPPeriodRSQL(){
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
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration ").append("\n"); 
		query.append("FileName : AccountReceivableCommonDBDAOCheckAPPeriodRSQL").append("\n"); 
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
		query.append("SELECT DECODE(NVL(MAX(CHK_PRD1), 'N')||NVL(MAX(CHK_PRD2), 'N'), 'CC', 'C', 'CO', 'C', 'NC', 'C', 'NN', 'C', 'O') CHK_PRD " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("	(SELECT CLZ_STS_CD AS CHK_PRD1, NULL AS CHK_PRD2" ).append("\n"); 
		query.append("	 FROM AP_PERIOD " ).append("\n"); 
		query.append("	 WHERE EFF_YRMON = SUBSTR(REPLACE(@[gl_dt], '-'), 0, 6) " ).append("\n"); 
		query.append("	 AND SYS_DIV_CD = '34' " ).append("\n"); 
		query.append("	 AND OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("	 AND AR_AP_DIV_CD = 'P'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 SELECT NULL AS CHG_PRD1, CLZ_STS_CD AS CHK_PRD2" ).append("\n"); 
		query.append("	 FROM AP_PERIOD AP" ).append("\n"); 
		query.append("      	  , MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("	 WHERE AP.EFF_YRMON = SUBSTR(REPLACE(@[gl_dt], '-'), 0, 6) " ).append("\n"); 
		query.append("	 AND AP.SYS_DIV_CD = '34' " ).append("\n"); 
		query.append("	 AND MO.OFC_CD = @[ofc_cd]   " ).append("\n"); 
		query.append("	 AND AP.AR_AP_DIV_CD = 'P'" ).append("\n"); 
		query.append("	 AND AP.OFC_CD = MO.AR_HD_QTR_OFC_CD)" ).append("\n"); 

	}
}