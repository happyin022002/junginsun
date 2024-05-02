/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CMPBGuidelineDBDAOPriCmpbGlineMnVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.02
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.12.02 이승준
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

public class CMPBGuidelineDBDAOPriCmpbGlineMnVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public CMPBGuidelineDBDAOPriCmpbGlineMnVORSQL(){
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

		tmp = java.sql.Types.NUMERIC + ",N";
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
		query.append("FileName : CMPBGuidelineDBDAOPriCmpbGlineMnVORSQL").append("\n"); 
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
		query.append("SELECT  A1.SVC_SCP_CD" ).append("\n"); 
		query.append(",       A1.CRE_OFC_CD" ).append("\n"); 
		query.append(",       A1.GLINE_SEQ" ).append("\n"); 
		query.append(",       TO_CHAR(A1.EFF_DT,'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append(",       TO_CHAR(A1.EXP_DT,'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append(",       DECODE(A1.CFM_FLG,'N','No','Y','Yes',A1.CFM_FLG) AS CFM_FLG" ).append("\n"); 
		query.append(",       B1.PRS_CUST_TP_CD" ).append("\n"); 
		query.append(",       TO_CHAR(A1.CRE_DT,'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append(",       B1.CUST_CNT_CD" ).append("\n"); 
		query.append(",       B1.CUST_SEQ" ).append("\n"); 
		query.append(",		(A1.GLINE_SEQ || ';' || A1.CRE_OFC_CD || ';' || B1.PRS_CUST_TP_CD) AS DURATION_KEY" ).append("\n"); 
		query.append("FROM    PRI_CMPB_GLINE_MN A1" ).append("\n"); 
		query.append(",       PRI_CMPB_GLINE_CUST B1" ).append("\n"); 
		query.append("WHERE   A1.SVC_SCP_CD = B1.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     A1.CRE_OFC_CD = B1.CRE_OFC_CD" ).append("\n"); 
		query.append("AND     A1.GLINE_SEQ = B1.GLINE_SEQ" ).append("\n"); 
		query.append("AND     A1.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#if (${cre_ofc_cd} != '')" ).append("\n"); 
		query.append("AND		A1.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${prs_cust_tp_cd} != '')" ).append("\n"); 
		query.append("AND		B1.PRS_CUST_TP_CD = @[prs_cust_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${max_gline_seq} == '')" ).append("\n"); 
		query.append("#if (${gline_seq} != '')" ).append("\n"); 
		query.append("AND		A1.GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eff_dt} != '')" ).append("\n"); 
		query.append("AND 	TO_CHAR(A1.EFF_DT, 'YYYY-MM-DD') = @[eff_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${exp_dt} != '')" ).append("\n"); 
		query.append("AND 	TO_CHAR(A1.EXP_DT, 'YYYY-MM-DD') = @[exp_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${max_gline_seq} != '')" ).append("\n"); 
		query.append("AND	(TO_CHAR(A1.EFF_DT, 'YYYY-MM-DD') BETWEEN @[eff_dt] AND @[exp_dt]" ).append("\n"); 
		query.append("OR TO_CHAR(A1.EXP_DT, 'YYYY-MM-DD') BETWEEN @[eff_dt] AND @[exp_dt]" ).append("\n"); 
		query.append("OR (TO_CHAR(A1.EFF_DT, 'YYYY-MM-DD') <= @[eff_dt] AND TO_CHAR(A1.EXP_DT, 'YYYY-MM-DD') >= @[exp_dt]))" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("ORDER BY A1.UPD_DT DESC" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}