/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TerminalProductivityDBDAOSelectTmlProdTgtInpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.terminalproductivity.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalProductivityDBDAOSelectTmlProdTgtInpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Terminal Productivity Target Input 을 조회한다.
	  * </pre>
	  */
	public TerminalProductivityDBDAOSelectTmlProdTgtInpRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ev_svc_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eg_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_tml_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_sp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ev_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.performancemanagement.terminalproductivity.integration").append("\n"); 
		query.append("FileName : TerminalProductivityDBDAOSelectTmlProdTgtInpRSQL").append("\n"); 
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
		query.append("SELECT AA.EG_ID" ).append("\n"); 
		query.append("     , AA.EG_NM" ).append("\n"); 
		query.append("     , BB.EV_YR" ).append("\n"); 
		query.append("     , LPAD(BB.SP_SEQ, 6, '0') AS SP_SEQ" ).append("\n"); 
		query.append("     , (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ= BB.SP_SEQ AND NVL(DELT_FLG, 'N') <> 'Y') SP_NAME" ).append("\n"); 
		query.append("     , BB.TML_CD     " ).append("\n"); 
		query.append("     , (SELECT ROUND(SUM((JAN_RTO+FEB_RTO+MAR_RTO+APR_RTO+MAY_RTO+JUN_RTO+JUL_RTO+AUG_RTO+SEP_RTO+OCT_RTO+NOV_RTO+DEC_RTO)/12)/COUNT(1),2) " ).append("\n"); 
		query.append("        	  FROM SPE_EV_GRP_KPI_PERF KP" ).append("\n"); 
		query.append("                 , SPE_SP_SVC_CATE_KPI SCKP" ).append("\n"); 
		query.append("        	 WHERE KP.SP_KPI_ID = SCKP.SP_KPI_ID" ).append("\n"); 
		query.append("               AND KP.EG_ID = BB.EG_ID" ).append("\n"); 
		query.append("        	   AND SCKP.SP_KPI_TP_CD = 'P'" ).append("\n"); 
		query.append("               AND EV_SVC_CATE_CD = AA.EV_SVC_CATE_CD" ).append("\n"); 
		query.append("               AND SP_SEQ = BB.SP_SEQ" ).append("\n"); 
		query.append("        	   AND KP.EV_YR = TO_NUMBER(BB.EV_YR)-1" ).append("\n"); 
		query.append("       ) AS PRE_PERF_RTO" ).append("\n"); 
		query.append("     , (SELECT SUM(KPI_TGT_RTO) " ).append("\n"); 
		query.append("          FROM SPE_EV_GRP_TML_PROD_TGT " ).append("\n"); 
		query.append("         WHERE EG_ID = BB.EG_ID" ).append("\n"); 
		query.append("           AND SP_SEQ = BB.SP_SEQ" ).append("\n"); 
		query.append("           AND TML_CD = BB.TML_CD" ).append("\n"); 
		query.append("           AND EV_YR  = TO_NUMBER(BB.EV_YR)-1) AS PRE_TGT_RTO" ).append("\n"); 
		query.append("     , BB.KPI_TGT_RTO" ).append("\n"); 
		query.append("     , BB.KPI_RMK" ).append("\n"); 
		query.append("     , BB.EG_TML_PROD_TGT_SEQ" ).append("\n"); 
		query.append("     , DECODE(BB.EG_TML_PROD_TGT_SEQ,NULL,'N','Y') AS ISFLAG" ).append("\n"); 
		query.append("  FROM SPE_EV_GRP AA" ).append("\n"); 
		query.append("     , (SELECT B.EG_ID" ).append("\n"); 
		query.append("             , A.EG_TML_PROD_TGT_SEQ" ).append("\n"); 
		query.append("             , B.EV_YR" ).append("\n"); 
		query.append("             , B.SP_SEQ" ).append("\n"); 
		query.append("             , A.TML_CD" ).append("\n"); 
		query.append("             , A.KPI_TGT_RTO" ).append("\n"); 
		query.append("             , A.KPI_WGT_RTO" ).append("\n"); 
		query.append("             , A.KPI_RMK" ).append("\n"); 
		query.append("             , B.BZC_EV_GRD_CD" ).append("\n"); 
		query.append("          FROM SPE_EV_GRP_TML_PROD_TGT A" ).append("\n"); 
		query.append("             , SPE_SP_BZC_EV_GRP B" ).append("\n"); 
		query.append("         WHERE A.SP_SEQ(+) = B.SP_SEQ" ).append("\n"); 
		query.append("           AND A.EG_ID(+)  = B.EG_ID" ).append("\n"); 
		query.append("           AND A.EV_YR(+)  = B.EV_YR" ).append("\n"); 
		query.append("           AND B.EV_YR     = @[s_ev_yr]" ).append("\n"); 
		query.append("        ) BB" ).append("\n"); 
		query.append("     , (SELECT A.EG_ID" ).append("\n"); 
		query.append("             , A.SP_KPI_ID" ).append("\n"); 
		query.append("             , A.EV_YR" ).append("\n"); 
		query.append("          FROM SPE_EV_GRP_KPI_PERF_TGT A" ).append("\n"); 
		query.append("             , SPE_SP_SVC_CATE_KPI B" ).append("\n"); 
		query.append("         WHERE A.SP_KPI_ID = B.SP_KPI_ID" ).append("\n"); 
		query.append("           AND B.SP_KPI_TP_CD = 'P'" ).append("\n"); 
		query.append("           AND A.EV_YR     =  @[s_ev_yr]" ).append("\n"); 
		query.append("       ) CC" ).append("\n"); 
		query.append(" WHERE AA.EG_ID = BB.EG_ID(+)" ).append("\n"); 
		query.append("   AND AA.EG_ID = CC.EG_ID(+) " ).append("\n"); 
		query.append("   AND BB.BZC_EV_GRD_CD IS NOT NULL" ).append("\n"); 
		query.append("   AND AA.DELT_FLG         = 'N'" ).append("\n"); 
		query.append("   AND AA.EG_RHQ_CD        = @[s_eg_rhq_cd]" ).append("\n"); 
		query.append("   AND AA.EG_OFC_CD        = @[s_eg_ofc_cd]" ).append("\n"); 
		query.append("   AND AA.EV_SVC_CATE_CD   = @[s_ev_svc_cate_cd]" ).append("\n"); 
		query.append("#if(${s_tml_cd}!='')" ).append("\n"); 
		query.append("   AND BB.TML_CD           = @[s_tml_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_sp_seq}!='')" ).append("\n"); 
		query.append("   AND BB.SP_SEQ          = @[s_sp_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY BB.EV_YR DESC,AA.EG_ID, BB.SP_SEQ" ).append("\n"); 

	}
}