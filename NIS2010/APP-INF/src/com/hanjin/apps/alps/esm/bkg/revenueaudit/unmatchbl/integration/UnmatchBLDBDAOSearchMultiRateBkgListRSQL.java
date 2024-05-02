/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : UnmatchBLDBDAOSearchMultiRateBkgListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.31
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOSearchMultiRateBkgListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * rating시 OFT가 2개 이상 뜨는 건에 대해 조회한다.
	  * </pre>
	  */
	public UnmatchBLDBDAOSearchMultiRateBkgListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bdr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_pol_equals",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_del_equals",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("t_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("multi_cntr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOSearchMultiRateBkgListRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("      ,RCT_RHQ_CD  " ).append("\n"); 
		query.append("      ,BKG_OFC_CD" ).append("\n"); 
		query.append("      ,SVC_SCP_CD" ).append("\n"); 
		query.append("      ,RT_APLY_DT" ).append("\n"); 
		query.append("      ,BDR_FLG" ).append("\n"); 
		query.append("      ,CTRT_TP_CD" ).append("\n"); 
		query.append("      ,CTRT_NO" ).append("\n"); 
		query.append("      ,CMDT_CD" ).append("\n"); 
		query.append("      ,(SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD = BKG.CMDT_CD AND DELT_FLG = 'N') CMDT_NM" ).append("\n"); 
		query.append("      ,BKG_CGO_TP_CD" ).append("\n"); 
		query.append("      ,POR_CD" ).append("\n"); 
		query.append("      ,POL_CD" ).append("\n"); 
		query.append("      ,POD_CD" ).append("\n"); 
		query.append("      ,DEL_CD" ).append("\n"); 
		query.append("      ,DCGO_FLG" ).append("\n"); 
		query.append("      ,RC_FLG" ).append("\n"); 
		query.append("      ,AWK_CGO_FLG" ).append("\n"); 
		query.append("      ,BB_CGO_FLG" ).append("\n"); 
		query.append("      ,RD_CGO_FLG" ).append("\n"); 
		query.append("      ,HNGR_FLG" ).append("\n"); 
		query.append("      ,T_VVD" ).append("\n"); 
		query.append("      ,COUNT(1) OVER (PARTITION BY 1) BL_CNT" ).append("\n"); 
		query.append("      ,POR_POL_EQUALS" ).append("\n"); 
		query.append("      ,POD_DEL_EQUALS" ).append("\n"); 
		query.append("      ,MULTI_CNTR" ).append("\n"); 
		query.append("  from (" ).append("\n"); 
		query.append("        SELECT BKG.BKG_NO" ).append("\n"); 
		query.append("               ,(" ).append("\n"); 
		query.append("                SELECT  A.OFC_CD" ).append("\n"); 
		query.append("                FROM    MDM_ORGANIZATION A" ).append("\n"); 
		query.append("                WHERE   A.OFC_TP_CD = 'HQ'" ).append("\n"); 
		query.append("                START   WITH A.OFC_CD = BKG.BKG_OFC_CD" ).append("\n"); 
		query.append("                CONNECT BY PRIOR A.PRNT_OFC_CD = A.OFC_CD" ).append("\n"); 
		query.append("               ) RCT_RHQ_CD  " ).append("\n"); 
		query.append("              ,BKG.BKG_OFC_CD" ).append("\n"); 
		query.append("              ,BKG.SVC_SCP_CD" ).append("\n"); 
		query.append("              ,TO_CHAR(RT.RT_APLY_DT,'YYYY-MM-DD') RT_APLY_DT" ).append("\n"); 
		query.append("              ,DECODE(DOC.BDR_FLG , 'N', 'NO', 'Y', 'YES', 'NO')  BDR_FLG" ).append("\n"); 
		query.append("              ,DECODE(RT.BKG_CTRT_TP_CD, 'R', 'RFA', 'S', 'S/C', 'TAA')  CTRT_TP_CD" ).append("\n"); 
		query.append("              ,DECODE(RT.BKG_CTRT_TP_CD, 'R', BKG.RFA_NO, 'S', BKG.SC_NO, BKG.TAA_NO) CTRT_NO" ).append("\n"); 
		query.append("              ,BKG.CMDT_CD" ).append("\n"); 
		query.append("              ,BKG.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("              ,BKG.POR_CD" ).append("\n"); 
		query.append("              ,BKG.POL_CD" ).append("\n"); 
		query.append("              ,BKG.POD_CD" ).append("\n"); 
		query.append("              ,BKG.DEL_CD" ).append("\n"); 
		query.append("              ,BKG.DCGO_FLG" ).append("\n"); 
		query.append("              ,BKG.RC_FLG" ).append("\n"); 
		query.append("              ,BKG.AWK_CGO_FLG" ).append("\n"); 
		query.append("              ,BKG.BB_CGO_FLG" ).append("\n"); 
		query.append("              ,BKG.RD_CGO_FLG" ).append("\n"); 
		query.append("              ,BKG.HNGR_FLG" ).append("\n"); 
		query.append("              ,BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD T_VVD" ).append("\n"); 
		query.append("              ,DECODE(BKG.POR_CD, BKG.POL_CD, 'Y', 'N') AS POR_POL_EQUALS" ).append("\n"); 
		query.append("              ,DECODE(BKG.POD_CD, BKG.DEL_CD, 'Y', 'N') AS POD_DEL_EQUALS" ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("                SELECT DECODE(COUNT(DISTINCT CNTR_TPSZ_CD), 1, 'N', 'Y')" ).append("\n"); 
		query.append("                  FROM BKG_QTY_DTL " ).append("\n"); 
		query.append("                 WHERE BKG_NO = BKG.BKG_NO " ).append("\n"); 
		query.append("                   AND CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("                ) AS MULTI_CNTR" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("              ,BKG_RATE RT" ).append("\n"); 
		query.append("              ,BKG_REV_COST REV" ).append("\n"); 
		query.append("              ,BKG_BL_DOC DOC" ).append("\n"); 
		query.append("        #if (${dt_type} == 'ETD') " ).append("\n"); 
		query.append("              ,BKG_VVD VVD" ).append("\n"); 
		query.append("              ,VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        WHERE BKG.BKG_NO = RT.BKG_NO" ).append("\n"); 
		query.append("          AND BKG.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("          AND BKG.BKG_NO = REV.BKG_NO" ).append("\n"); 
		query.append("        #if (${from_dt} != '' && ${to_dt} != '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${dt_type} == 'BKG')" ).append("\n"); 
		query.append("          AND BKG.BKG_CRE_DT		>= TO_DATE(@[from_dt], 'YYYY-MM-DD') " ).append("\n"); 
		query.append("          AND BKG.BKG_CRE_DT		<= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999 " ).append("\n"); 
		query.append("        #elseif (${dt_type} == 'APPL') " ).append("\n"); 
		query.append("          AND RT.RT_APLY_DT		    >= TO_DATE(@[from_dt], 'YYYY-MM-DD') " ).append("\n"); 
		query.append("          AND RT.RT_APLY_DT		    <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999 " ).append("\n"); 
		query.append("        #elseif (${dt_type} == 'ETD') " ).append("\n"); 
		query.append("          AND SKD.VPS_ETD_DT        >= TO_DATE(@[from_dt], 'YYYY-MM-DD') " ).append("\n"); 
		query.append("          AND SKD.VPS_ETD_DT		<= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("          AND VVD.VSL_PRE_PST_CD || VVD.VSL_SEQ = (SELECT MIN(VSL_PRE_PST_CD||VSL_SEQ) FROM BKG_VVD WHERE BKG_NO = BKG.BKG_NO)" ).append("\n"); 
		query.append("          AND VVD.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("          AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND VVD.POL_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("          AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("          AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("          AND REV.SGL_REV_FLG = 'N'" ).append("\n"); 
		query.append("          AND REV.REV_COST_SEQ = (SELECT MAX(REV_COST_SEQ) FROM BKG_REV_COST WHERE BKG.BKG_NO = BKG_NO)" ).append("\n"); 
		query.append("          AND BKG.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("        #if (${t_vvd} != '')" ).append("\n"); 
		query.append("          AND BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD LIKE '%'||@[t_vvd]||'%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("          AND BKG.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${bkg_ctrt_tp_cd} != '')" ).append("\n"); 
		query.append("          AND RT.BKG_CTRT_TP_CD = @[bkg_ctrt_tp_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${ctrt_no} != '')" ).append("\n"); 
		query.append("          AND @[ctrt_no] IN (BKG.SC_NO,BKG.RFA_NO,BKG.TAA_NO)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${por_cd} != '')" ).append("\n"); 
		query.append("          AND BKG.POR_CD = @[por_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${pol_cd} != '')" ).append("\n"); 
		query.append("          AND BKG.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${pod_cd} != '')" ).append("\n"); 
		query.append("          AND BKG.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${del_cd} != '')" ).append("\n"); 
		query.append("          AND BKG.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${bdr_flg} != '')" ).append("\n"); 
		query.append("          AND DOC.BDR_FLG = @[bdr_flg]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("         ) BKG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE RCT_RHQ_CD = @[rct_rhq_cd]" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("  AND BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_pol_equals} != '')" ).append("\n"); 
		query.append("  AND POR_POL_EQUALS = @[por_pol_equals]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_del_equals} != '')" ).append("\n"); 
		query.append("  AND POD_DEL_EQUALS = @[pod_del_equals]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${multi_cntr} != '')" ).append("\n"); 
		query.append("  AND MULTI_CNTR = @[multi_cntr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY BKG_NO" ).append("\n"); 

	}
}