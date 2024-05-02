/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PRISimulationDBDAOSearchRateByPctlNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.prisimulation.prisimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRISimulationDBDAOSearchRateByPctlNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * retrieving summarized rate
	  * </pre>
	  */
	public PRISimulationDBDAOSearchRateByPctlNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.prisimulation.prisimulation.integration").append("\n"); 
		query.append("FileName : PRISimulationDBDAOSearchRateByPctlNoRSQL").append("\n"); 
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
		query.append("SELECT X.*" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("                 PCTL_NO" ).append("\n"); 
		query.append("                 ,CNTR_SZ_CD AS ORG_CNTR_SZ_CD" ).append("\n"); 
		query.append("                 ,(SELECT CNTR_SZ_CD ||'0' " ).append("\n"); 
		query.append("                     FROM MDM_CNTR_TP_SZ " ).append("\n"); 
		query.append("                    WHERE CNTR_TPSZ_CD = RT.CNTR_SZ_CD " ).append("\n"); 
		query.append("                      AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                      AND ROWNUM =1 ) AS CNTR_SZ_CD" ).append("\n"); 
		query.append("                ,CMDT_CD AS GRP_CMDT" ).append("\n"); 
		query.append("                ,CMDT_CD" ).append("\n"); 
		query.append("                ,CMDT_SEQ" ).append("\n"); 
		query.append("                ,'' AS GRP_CMDT_NM" ).append("\n"); 
		query.append("                ,(SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD = RT.CMDT_CD) CMDT_NM" ).append("\n"); 
		query.append("                ,RT_SEQ" ).append("\n"); 
		query.append("                ,FRT_TERM_CD" ).append("\n"); 
		query.append("                ,CGO_CATE_CD" ).append("\n"); 
		query.append("                ,IMDG_CLSS_CD" ).append("\n"); 
		query.append("                ,CHG_CD" ).append("\n"); 
		query.append("                ,CURR_CD" ).append("\n"); 
		query.append("                ,RAT_UT_CD" ).append("\n"); 
		query.append("                ,BKG_QTY" ).append("\n"); 
		query.append("                ,RAT_AS_QTY" ).append("\n"); 
		query.append("                ,CHG_UT_AMT" ).append("\n"); 
		query.append("                ,CHG_AMT AS BASE_RT" ).append("\n"); 
		query.append("                ,RCV_TERM_CD" ).append("\n"); 
		query.append("                ,DE_TERM_CD" ).append("\n"); 
		query.append("                ,FRT_INCL_XCLD_DIV_CD" ).append("\n"); 
		query.append("                ,APLY_XCH_RTO" ).append("\n"); 
		query.append("                ,NOTE_RT_SEQ" ).append("\n"); 
		query.append("                ,PROP_NO" ).append("\n"); 
		query.append("                ,AMDT_SEQ" ).append("\n"); 
		query.append("                ,SVC_SCP_CD" ).append("\n"); 
		query.append("                ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                ,ROUT_SEQ" ).append("\n"); 
		query.append("                ,CRE_USR_ID" ).append("\n"); 
		query.append("                ,CRE_DT" ).append("\n"); 
		query.append("                ,UPD_USR_ID" ).append("\n"); 
		query.append("                ,UPD_DT" ).append("\n"); 
		query.append("                ,(SELECT TO_CHAR(RT_APLY_DT,'YYYYMMDD') FROM PRI_SIM_RT WHERE PCTL_NO = RT.PCTL_NO AND ROWNUM = 1) RT_APLY_DT" ).append("\n"); 
		query.append("           FROM PRI_SIM_CHG_RT RT" ).append("\n"); 
		query.append("          WHERE PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("            AND CMDT_CD NOT LIKE 'G%'" ).append("\n"); 
		query.append("            AND CHG_CD = 'OFT'" ).append("\n"); 
		query.append("#if (${ctrt_tp} == 'S' || ${ctrt_tp} == 'R') " ).append("\n"); 
		query.append("          UNION ALL" ).append("\n"); 
		query.append("          SELECT " ).append("\n"); 
		query.append("                 RT.PCTL_NO" ).append("\n"); 
		query.append("                ,RT.CNTR_SZ_CD AS ORG_CNTR_SZ_CD" ).append("\n"); 
		query.append("                ,(SELECT CNTR_SZ_CD ||'0' " ).append("\n"); 
		query.append("                     FROM MDM_CNTR_TP_SZ " ).append("\n"); 
		query.append("                    WHERE CNTR_TPSZ_CD = RT.CNTR_SZ_CD " ).append("\n"); 
		query.append("                      AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                      AND ROWNUM =1 ) AS CNTR_SZ_CD" ).append("\n"); 
		query.append("                ,PRC_GRP_CMDT_CD AS GRP_CMDT" ).append("\n"); 
		query.append("                ,PRC_CMDT_DEF_CD AS CMDT_CD" ).append("\n"); 
		query.append("                ,RT.CMDT_SEQ" ).append("\n"); 
		query.append("                ,PRC_GRP_CMDT_DESC AS GRP_CMDT_NM" ).append("\n"); 
		query.append("                ,(SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD = GRP_CMDT.PRC_CMDT_DEF_CD) CMDT_NM" ).append("\n"); 
		query.append("                ,RT.RT_SEQ" ).append("\n"); 
		query.append("                ,RT.FRT_TERM_CD" ).append("\n"); 
		query.append("                ,RT.CGO_CATE_CD" ).append("\n"); 
		query.append("                ,RT.IMDG_CLSS_CD" ).append("\n"); 
		query.append("                ,RT.CHG_CD" ).append("\n"); 
		query.append("                ,RT.CURR_CD" ).append("\n"); 
		query.append("                ,RT.RAT_UT_CD" ).append("\n"); 
		query.append("                ,RT.BKG_QTY" ).append("\n"); 
		query.append("                ,RT.RAT_AS_QTY" ).append("\n"); 
		query.append("                ,RT.CHG_UT_AMT" ).append("\n"); 
		query.append("                ,RT.CHG_AMT  AS BASE_RT" ).append("\n"); 
		query.append("                ,RT.RCV_TERM_CD" ).append("\n"); 
		query.append("                ,RT.DE_TERM_CD" ).append("\n"); 
		query.append("                ,RT.FRT_INCL_XCLD_DIV_CD" ).append("\n"); 
		query.append("                ,RT.APLY_XCH_RTO" ).append("\n"); 
		query.append("                ,RT.NOTE_RT_SEQ" ).append("\n"); 
		query.append("                ,RT.PROP_NO" ).append("\n"); 
		query.append("                ,RT.AMDT_SEQ" ).append("\n"); 
		query.append("                ,RT.SVC_SCP_CD" ).append("\n"); 
		query.append("                ,RT.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                ,RT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                ,RT.ROUT_SEQ" ).append("\n"); 
		query.append("                ,RT.CRE_USR_ID" ).append("\n"); 
		query.append("                ,RT.CRE_DT" ).append("\n"); 
		query.append("                ,RT.UPD_USR_ID" ).append("\n"); 
		query.append("                ,RT.UPD_DT" ).append("\n"); 
		query.append("                ,(SELECT TO_CHAR(RT_APLY_DT,'YYYYMMDD') FROM PRI_SIM_RT WHERE PCTL_NO = RT.PCTL_NO AND ROWNUM = 1 ) RT_APLY_DT" ).append("\n"); 
		query.append("           FROM PRI_SIM_CHG_RT RT, " ).append("\n"); 
		query.append("                    (SELECT   G.PRC_GRP_CMDT_CD     ," ).append("\n"); 
		query.append("                              D.PRC_CMDT_TP_CD      ," ).append("\n"); 
		query.append("                              D.PRC_CMDT_DEF_CD     ," ).append("\n"); 
		query.append("                              G.PROP_NO             ," ).append("\n"); 
		query.append("                              G.AMDT_SEQ            ," ).append("\n"); 
		query.append("                              G.SVC_SCP_CD          ," ).append("\n"); 
		query.append("                              G.PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append("#if (${ctrt_tp} == 'S') " ).append("\n"); 
		query.append("                      FROM    PRI_SP_SCP_GRP_CMDT     G ," ).append("\n"); 
		query.append("                              PRI_SP_SCP_GRP_CMDT_DTL D" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                      FROM    PRI_RP_SCP_GRP_CMDT     G ," ).append("\n"); 
		query.append("                              PRI_RP_SCP_GRP_CMDT_DTL D" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                      WHERE   D.PROP_NO         = G.PROP_NO" ).append("\n"); 
		query.append("                      AND     D.AMDT_SEQ        = G.AMDT_SEQ" ).append("\n"); 
		query.append("                      AND     D.SVC_SCP_CD      = G.SVC_SCP_CD" ).append("\n"); 
		query.append("                      AND     D.GRP_CMDT_SEQ    = G.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("                      AND     D.SRC_INFO_CD     <> 'AD'" ).append("\n"); 
		query.append("                     ) GRP_CMDT" ).append("\n"); 
		query.append("           WHERE 1=1" ).append("\n"); 
		query.append("           AND RT.PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("           AND RT.PROP_NO = GRP_CMDT.PROP_NO" ).append("\n"); 
		query.append("           AND RT.AMDT_SEQ = GRP_CMDT.AMDT_SEQ" ).append("\n"); 
		query.append("           AND RT.SVC_SCP_CD = GRP_CMDT.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND RT.CMDT_CD = GRP_CMDT.PRC_GRP_CMDT_CD" ).append("\n"); 
		query.append("           AND CHG_CD = 'OFT'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append(" WHERE CNTR_SZ_CD IS NOT NULL" ).append("\n"); 
		query.append("#if (${cmdt_cd} != '') " ).append("\n"); 
		query.append("   AND CMDT_CD = @[cmdt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY PCTL_NO, CMDT_NM, CMDT_CD, GRP_CMDT, ORG_CNTR_SZ_CD, CMDT_SEQ" ).append("\n"); 

	}
}