/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMSetupDBDAOsearchRevenueStrcSetChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.07
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSetupDBDAOsearchRevenueStrcSetChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRevenueStrcSetChk
	  * </pre>
	  */
	public ACMSetupDBDAOsearchRevenueStrcSetChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.integration").append("\n"); 
		query.append("FileName : ACMSetupDBDAOsearchRevenueStrcSetChkRSQL").append("\n"); 
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
		query.append("SELECT REV_CHG_SEQ ," ).append("\n"); 
		query.append("  CHG_CD ," ).append("\n"); 
		query.append("  REV_FM_DT_CD ," ).append("\n"); 
		query.append("  REV_FM_DT ," ).append("\n"); 
		query.append("  REV_TO_DT_CD ," ).append("\n"); 
		query.append("  REV_TO_DT ," ).append("\n"); 
		query.append("  RHQ_CD AS RHQ_OFC_CD," ).append("\n"); 
		query.append("  SVC_SCP_CD AS SCP_CD," ).append("\n"); 
		query.append("  CRE_USR_ID ," ).append("\n"); 
		query.append("  CRE_DT ," ).append("\n"); 
		query.append("  UPD_USR_ID ," ).append("\n"); 
		query.append("  UPD_DT" ).append("\n"); 
		query.append("FROM ACM_AGN_SET_REV_CHG_CD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${rev_chg_seq} != '')" ).append("\n"); 
		query.append("  AND REV_CHG_SEQ <> @[rev_chg_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("  AND ( " ).append("\n"); 
		query.append("        (@[rev_fm_dt] BETWEEN REV_FM_DT AND REV_TO_DT) " ).append("\n"); 
		query.append("     OR (@[rev_to_dt] BETWEEN REV_FM_DT AND REV_TO_DT)" ).append("\n"); 
		query.append("     OR (REV_FM_DT BETWEEN @[rev_fm_dt] AND @[rev_to_dt]) " ).append("\n"); 
		query.append("     OR (REV_TO_DT BETWEEN @[rev_fm_dt] AND @[rev_to_dt])" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("  AND NVL (RHQ_CD, '*') = NVL (@[rhq_ofc_cd], '*')" ).append("\n"); 
		query.append("  AND NVL (SVC_SCP_CD, '*') = NVL (@[scp_cd], '*')" ).append("\n"); 

	}
}