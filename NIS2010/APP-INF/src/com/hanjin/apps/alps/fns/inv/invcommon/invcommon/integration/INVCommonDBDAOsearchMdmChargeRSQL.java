/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : INVCommonDBDAOsearchMdmChargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.04
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.invcommon.invcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class INVCommonDBDAOsearchMdmChargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INV(CHM-201006884) ui 2개 신규 개발
	  * charge code 가져오기
	  * </pre>
	  */
	public INVCommonDBDAOsearchMdmChargeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.invcommon.invcommon.integration").append("\n"); 
		query.append("FileName : INVCommonDBDAOsearchMdmChargeRSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("CHG_CD," ).append("\n"); 
		query.append("DECODE(CHG_CD,'JOP','TERMINAL STEVEDORAGE','CRC', 'MIS. REVENUE(CNTR) - EQ RENTAL', CHG_NM) CHG_NM," ).append("\n"); 
		query.append("FRT_CHG_TP_CD," ).append("\n"); 
		query.append("SEN_CHG_ACCT_CD," ).append("\n"); 
		query.append("HJS_CHG_ACCT_CD," ).append("\n"); 
		query.append("REP_CHG_CD," ).append("\n"); 
		query.append("CHG_REV_TP_CD, " ).append("\n"); 
		query.append("CHG_APLY_TP_CD," ).append("\n"); 
		query.append("CHG_APLY_AREA_CD," ).append("\n"); 
		query.append("CY_RD_TERM_FLG," ).append("\n"); 
		query.append("CFS_RD_TERM_FLG," ).append("\n"); 
		query.append("DOR_RD_TERM_FLG," ).append("\n"); 
		query.append("NA_RD_TERM_FLG," ).append("\n"); 
		query.append("TKL_TML_FLG," ).append("\n"); 
		query.append("APLY_SVC_MOD_FLG," ).append("\n"); 
		query.append("USE_CO_TP_CD," ).append("\n"); 
		query.append("AUTO_RAT_FLG," ).append("\n"); 
		query.append("SEN_GRP_CHG_CD," ).append("\n"); 
		query.append("CHG_EDI_CD," ).append("\n"); 
		query.append("DP_SEQ," ).append("\n"); 
		query.append("CHG_STS_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("DELT_FLG," ).append("\n"); 
		query.append("EAI_EVNT_DT," ).append("\n"); 
		query.append("EAI_IF_ID" ).append("\n"); 
		query.append("from mdm_charge" ).append("\n"); 
		query.append("where chg_cd = @[code]" ).append("\n"); 

	}
}