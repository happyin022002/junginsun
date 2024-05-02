/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CMPBGuidelineDBDAOPriCmpbGlineCheckDurationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.07.16 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CMPBGuidelineDBDAOPriCmpbGlineCheckDurationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Duration uniq check
	  * </pre>
	  */
	public CMPBGuidelineDBDAOPriCmpbGlineCheckDurationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prs_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.integration").append("\n"); 
		query.append("FileName : CMPBGuidelineDBDAOPriCmpbGlineCheckDurationRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) AS CHK" ).append("\n"); 
		query.append("FROM PRI_CMPB_GLINE_MN A" ).append("\n"); 
		query.append(",	   PRI_CMPB_GLINE_CUST B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("(TO_CHAR(A.EFF_DT, 'YYYY-MM-DD') BETWEEN @[eff_dt] AND @[exp_dt]" ).append("\n"); 
		query.append("OR TO_CHAR(A.EXP_DT, 'YYYY-MM-DD') BETWEEN @[eff_dt] AND @[exp_dt]" ).append("\n"); 
		query.append("OR (TO_CHAR(A.EFF_DT, 'YYYY-MM-DD') <= @[eff_dt] AND TO_CHAR(A.EXP_DT, 'YYYY-MM-DD') >= @[exp_dt]))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND	A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND	A.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND A.CRE_OFC_CD = B.CRE_OFC_CD" ).append("\n"); 
		query.append("AND A.GLINE_SEQ = B.GLINE_SEQ" ).append("\n"); 
		query.append("#if (${gline_seq} != '')" ).append("\n"); 
		query.append("AND A.GLINE_SEQ <> @[gline_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND B.PRS_CUST_TP_CD = @[prs_cust_tp_cd]" ).append("\n"); 

	}
}