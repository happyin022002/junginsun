/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountDBDAOSearchChargeCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.10
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.04.10 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.account.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountDBDAOSearchChargeCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.02.19 조인영 Charge Code 정보를 조회한다.
	  * </pre>
	  */
	public AccountDBDAOSearchChargeCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.account.integration").append("\n"); 
		query.append("FileName : AccountDBDAOSearchChargeCodeRSQL").append("\n"); 
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
		query.append("SELECT CHG_CD" ).append("\n"); 
		query.append("       ,CHG_NM" ).append("\n"); 
		query.append("       ,FRT_CHG_TP_CD" ).append("\n"); 
		query.append("       ,CO_CHG_ACCT_CD" ).append("\n"); 
		query.append("       ,REP_CHG_CD" ).append("\n"); 
		query.append("       ,CHG_REV_TP_CD" ).append("\n"); 
		query.append("       ,CHG_APLY_TP_CD" ).append("\n"); 
		query.append("       ,CHG_APLY_AREA_CD" ).append("\n"); 
		query.append("       ,CY_RD_TERM_FLG" ).append("\n"); 
		query.append("       ,CFS_RD_TERM_FLG" ).append("\n"); 
		query.append("       ,DOR_RD_TERM_FLG" ).append("\n"); 
		query.append("       ,NA_RD_TERM_FLG" ).append("\n"); 
		query.append("       ,TKL_TML_FLG" ).append("\n"); 
		query.append("       ,APLY_SVC_MOD_FLG" ).append("\n"); 
		query.append("       ,USE_CO_TP_CD" ).append("\n"); 
		query.append("       ,AUTO_RAT_FLG" ).append("\n"); 
		query.append("       ,CHG_EDI_CD" ).append("\n"); 
		query.append("       ,DP_SEQ" ).append("\n"); 
		query.append("       ,CHG_STS_CD" ).append("\n"); 
		query.append("       ,CRE_USR_ID" ).append("\n"); 
		query.append("       ,CRE_DT" ).append("\n"); 
		query.append("       ,UPD_USR_ID" ).append("\n"); 
		query.append("       ,UPD_DT" ).append("\n"); 
		query.append("       ,DELT_FLG" ).append("\n"); 
		query.append("       ,EAI_EVNT_DT" ).append("\n"); 
		query.append("       ,EAI_IF_ID" ).append("\n"); 
		query.append("	   ,TAX_FLG" ).append("\n"); 
		query.append("	   ,TAX_CNT_CD" ).append("\n"); 
		query.append(" FROM MDM_CHARGE" ).append("\n"); 
		query.append(" WHERE CHG_CD = @[chg_cd]" ).append("\n"); 

	}
}