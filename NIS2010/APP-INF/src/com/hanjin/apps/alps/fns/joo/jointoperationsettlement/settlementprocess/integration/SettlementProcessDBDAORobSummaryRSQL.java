/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SettlementProcessDBDAORobSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SettlementProcessDBDAORobSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROB 컨테이너 조회
	  * </pre>
	  */
	public SettlementProcessDBDAORobSummaryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration").append("\n"); 
		query.append("FileName : SettlementProcessDBDAORobSummaryRSQL").append("\n"); 
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
		query.append("WITH SKD AS (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("             AA.VSL_CD" ).append("\n"); 
		query.append("            ,AA.SKD_VOY_NO" ).append("\n"); 
		query.append("            ,AA.SKD_DIR_CD  " ).append("\n"); 
		query.append("            ,AA.VPS_PORT_CD" ).append("\n"); 
		query.append("            ,AA.TML_CD" ).append("\n"); 
		query.append("            ,AA.SPLIT_NO" ).append("\n"); 
		query.append("            ,AA.CLPT_SEQ" ).append("\n"); 
		query.append("            ,AA.VPS_ETD_DT" ).append("\n"); 
		query.append("            ,AA.YD_CD" ).append("\n"); 
		query.append("            ,AA.CLPT_IND_SEQ" ).append("\n"); 
		query.append("            ,CASE WHEN V.RDR_FLG = 'Y' THEN 'R'" ).append("\n"); 
		query.append("                  WHEN V.RDR_FLG = 'N' THEN ''" ).append("\n"); 
		query.append("                  ELSE DECODE(AA.VPS_PORT_CD,H.PORT_CD,'R','')" ).append("\n"); 
		query.append("                  END AS RDR_FLG" ).append("\n"); 
		query.append("           , (" ).append("\n"); 
		query.append("               SELECT DECODE(INTG_CD_VAL_DP_DESC, NULL, INTG_CD_VAL_DESC, INTG_CD_VAL_DP_DESC) AS CODE_DESC" ).append("\n"); 
		query.append("                 FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                WHERE INTG_CD_ID = 'CD01821'" ).append("\n"); 
		query.append("                  AND INTG_CD_VAL_CTNT = AA.PORT_SKD_STS_CD" ).append("\n"); 
		query.append("             ) AS PORT_SKD_STS" ).append("\n"); 
		query.append("           , MIN(AA.VSL_CD || AA.SKD_VOY_NO || AA.SKD_DIR_CD || AA.VPS_ETD_DT) OVER (PARTITION BY AA.VSL_CD || AA.SKD_VOY_NO || AA.SKD_DIR_CD) AS VVD_ETD_GROUP" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT               " ).append("\n"); 
		query.append("                     K.VSL_CD" ).append("\n"); 
		query.append("                    ,K.SKD_VOY_NO" ).append("\n"); 
		query.append("                    ,K.SKD_DIR_CD       " ).append("\n"); 
		query.append("                    ,SUBSTR(K.YD_CD,1,5) 	AS VPS_PORT_CD" ).append("\n"); 
		query.append("                    ,SUBSTR(K.YD_CD,6,2) 	AS TML_CD" ).append("\n"); 
		query.append("                    ,K.CLPT_IND_SEQ 		AS SPLIT_NO " ).append("\n"); 
		query.append("                    ,K.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                    ,TO_CHAR(K.VPS_ETD_DT,'YYYYMMDDHH24MISS') AS VPS_ETD_DT" ).append("\n"); 
		query.append("                    ,K.CLPT_SEQ" ).append("\n"); 
		query.append("                    ,K.SLAN_CD            " ).append("\n"); 
		query.append("                    ,K.YD_CD " ).append("\n"); 
		query.append("                    ,K.PORT_SKD_STS_CD" ).append("\n"); 
		query.append("               FROM VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("              WHERE SLAN_CD LIKE @[rlane_cd] || '%'" ).append("\n"); 
		query.append("				AND K.VPS_ETD_DT BETWEEN TO_DATE(@[pre_fr] || '000000' , 'YYYY-MM-DDHH24MISS') AND TO_DATE(@[pre_to] || '235959' , 'YYYY-MM-DDHH24MISS')" ).append("\n"); 
		query.append("                AND TURN_PORT_IND_CD NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("                AND NVL(K.SKD_CNG_STS_CD, 'A') <>  'S'  " ).append("\n"); 
		query.append("				#if (${vvd} != '') " ).append("\n"); 
		query.append("				AND K.VSL_CD || K.SKD_VOY_NO || K.SKD_DIR_CD LIKE @[vvd] || '%' " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${skd_dir_cd} != '') " ).append("\n"); 
		query.append("				AND K.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("        ) AA, RDR_HEADER H, JOO_RDR_PORT V        " ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND AA.VSL_CD 		= H.VSL_CD(+)" ).append("\n"); 
		query.append("        AND AA.SKD_VOY_NO 	= H.VOY_NO(+)" ).append("\n"); 
		query.append("        AND AA.SKD_DIR_CD 	= H.DIR_CD(+)  " ).append("\n"); 
		query.append("        AND AA.VPS_PORT_CD 	= H.PORT_CD(+)" ).append("\n"); 
		query.append("        AND AA.VSL_CD       = V.VSL_CD(+)" ).append("\n"); 
		query.append("        AND AA.SKD_VOY_NO   = V.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("        AND AA.SKD_DIR_CD   = V.SKD_DIR_CD(+)  " ).append("\n"); 
		query.append("        AND AA.VPS_PORT_CD  = V.VPS_PORT_CD(+)  " ).append("\n"); 
		query.append("        AND AA.SPLIT_NO     = V.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("        AND AA.SLAN_CD      = V.SLAN_CD(+)" ).append("\n"); 
		query.append("        AND AA.YD_CD        = V.YD_CD(+)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT TGT.REV_YRMON" ).append("\n"); 
		query.append("     , TGT.REV_YRMON_SEQ" ).append("\n"); 
		query.append("     , TGT.JO_STL_STS_CD" ).append("\n"); 
		query.append("     , NVL(TGT.STL_TGT_FLG,'0') AS STL_TGT_FLG" ).append("\n"); 
		query.append("     , NVL(TGT.STL_TGT_FLG,'0') AS STL_TGT_FLG2" ).append("\n"); 
		query.append("     , NVL(TGT.STL_CLZ_FLG,'0') AS STL_CLZ_FLG" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("        SELECT NVL(MAX(J3.ACCT_YRMON),'999912') AS ACCT_YRMON " ).append("\n"); 
		query.append("          FROM JOO_STL_TGT J2, JOO_SETTLEMENT J3" ).append("\n"); 
		query.append("         WHERE J2.REV_YRMON = TGT.REV_YRMON" ).append("\n"); 
		query.append("           AND J2.REV_YRMON_SEQ = TGT.REV_YRMON_SEQ" ).append("\n"); 
		query.append("           AND J2.ACCT_YRMON = J3.ACCT_YRMON(+)" ).append("\n"); 
		query.append("           AND J2.STL_VVD_SEQ = J3.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("           AND J2.STL_SEQ = J3.STL_SEQ(+)" ).append("\n"); 
		query.append("       ) ACCT_YRMON" ).append("\n"); 
		query.append("     , VVD_ETD_GROUP" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("			SELECT " ).append("\n"); 
		query.append("				NVL(SUM(CASE WHEN LENGTH(E.SLP_TP_CD||E.SLP_FUNC_CD||E.SLP_OFC_CD||TO_CHAR(TO_DATE(E.SLP_ISS_DT,'YYYYMMDD'),'RRMMDD')||E.SLP_SER_NO) > 0 " ).append("\n"); 
		query.append("						 THEN DECODE(A.RE_DIVR_CD,'R',A.STL_LOCL_AMT,A.STL_LOCL_AMT*-1) " ).append("\n"); 
		query.append("						 ELSE 0" ).append("\n"); 
		query.append("						 END" ).append("\n"); 
		query.append("					),0) AS STL_LOCL_AMT" ).append("\n"); 
		query.append("			FROM    JOO_SETTLEMENT  A" ).append("\n"); 
		query.append("				   ,JOO_STL_DTL     B" ).append("\n"); 
		query.append("				   ,JOO_STL_CMB_DTL D" ).append("\n"); 
		query.append("				   ,JOO_STL_CMB     E       " ).append("\n"); 
		query.append("				   ,JOO_CSR R" ).append("\n"); 
		query.append("			WHERE  1=1" ).append("\n"); 
		query.append("			AND    A.ACCT_YRMON  = B.ACCT_YRMON (+) " ).append("\n"); 
		query.append("			AND    A.STL_VVD_SEQ = B.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("			AND    A.STL_SEQ     = B.STL_SEQ    (+)" ).append("\n"); 
		query.append("		-------------------------------------------    " ).append("\n"); 
		query.append("			AND    A.TRD_CD = ROB.TRD_CD" ).append("\n"); 
		query.append("		    AND    A.JO_CRR_CD = ROB.CRR_CD" ).append("\n"); 
		query.append("		    AND    A.RE_DIVR_CD = ROB.RE_DIVR_CD" ).append("\n"); 
		query.append("			AND    A.JO_STL_ITM_CD = 'R/F'" ).append("\n"); 
		query.append("			AND    A.VSL_CD = ROB.VSL_CD" ).append("\n"); 
		query.append("			AND    A.SKD_VOY_NO = ROB.SKD_VOY_NO" ).append("\n"); 
		query.append("			AND    A.SKD_DIR_CD = ROB.SKD_DIR_CD" ).append("\n"); 
		query.append("		-------------------------------------------        " ).append("\n"); 
		query.append("			AND    E.RVS_CMB_FLG  = 'N'" ).append("\n"); 
		query.append("			AND    E.RJCT_CMB_FLG = 'N'" ).append("\n"); 
		query.append("			AND    A.ACCT_YRMON  = D.ACCT_YRMON" ).append("\n"); 
		query.append("			AND    A.STL_VVD_SEQ = D.STL_VVD_SEQ" ).append("\n"); 
		query.append("			AND    A.STL_SEQ     = D.STL_SEQ" ).append("\n"); 
		query.append("			AND    E.ACCT_YRMON  = D.ACCT_YRMON" ).append("\n"); 
		query.append("			AND    E.JO_CRR_CD   = D.JO_CRR_CD" ).append("\n"); 
		query.append("			AND    E.STL_CMB_SEQ = D.STL_CMB_SEQ" ).append("\n"); 
		query.append("			AND    E.RE_DIVR_CD  = D.RE_DIVR_CD" ).append("\n"); 
		query.append("			AND    E.SLP_SER_NO IS NOT NULL" ).append("\n"); 
		query.append("			AND    NVL(E.RVS_CMB_FLG ,'N') = 'N'" ).append("\n"); 
		query.append("			AND    NVL(E.RJCT_CMB_FLG,'N') = 'N'" ).append("\n"); 
		query.append("			AND    E.SLP_FUNC_CD = R.SLP_FUNC_CD" ).append("\n"); 
		query.append("			AND    E.SLP_OFC_CD = R.SLP_OFC_CD" ).append("\n"); 
		query.append("			AND    E.SLP_ISS_DT = R.SLP_ISS_DT" ).append("\n"); 
		query.append("			AND    E.SLP_SER_NO = R.SLP_SER_NO    " ).append("\n"); 
		query.append("       ) AS RF_20FT_CNTR_STL_AMT" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("			SELECT " ).append("\n"); 
		query.append("				NVL(SUM(CASE WHEN LENGTH(E.SLP_TP_CD||E.SLP_FUNC_CD||E.SLP_OFC_CD||TO_CHAR(TO_DATE(E.SLP_ISS_DT,'YYYYMMDD'),'RRMMDD')||E.SLP_SER_NO) > 0 " ).append("\n"); 
		query.append("						 THEN DECODE(A.RE_DIVR_CD,'R',A.STL_LOCL_AMT,A.STL_LOCL_AMT*-1) " ).append("\n"); 
		query.append("						 ELSE 0" ).append("\n"); 
		query.append("						 END" ).append("\n"); 
		query.append("					),0) AS STL_LOCL_AMT" ).append("\n"); 
		query.append("			FROM    JOO_SETTLEMENT  A" ).append("\n"); 
		query.append("				   ,JOO_STL_DTL     B" ).append("\n"); 
		query.append("				   ,JOO_STL_CMB_DTL D" ).append("\n"); 
		query.append("				   ,JOO_STL_CMB     E       " ).append("\n"); 
		query.append("				   ,JOO_CSR R" ).append("\n"); 
		query.append("			WHERE  1=1" ).append("\n"); 
		query.append("			AND    A.ACCT_YRMON  = B.ACCT_YRMON (+) " ).append("\n"); 
		query.append("			AND    A.STL_VVD_SEQ = B.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("			AND    A.STL_SEQ     = B.STL_SEQ    (+)" ).append("\n"); 
		query.append("		-------------------------------------------    " ).append("\n"); 
		query.append("			AND    A.TRD_CD = ROB.TRD_CD" ).append("\n"); 
		query.append("		    AND    A.JO_CRR_CD = ROB.CRR_CD" ).append("\n"); 
		query.append("		    AND    A.RE_DIVR_CD = ROB.RE_DIVR_CD" ).append("\n"); 
		query.append("			AND    A.JO_STL_ITM_CD = 'OUS'" ).append("\n"); 
		query.append("			AND    A.VSL_CD = ROB.VSL_CD" ).append("\n"); 
		query.append("			AND    A.SKD_VOY_NO = ROB.SKD_VOY_NO" ).append("\n"); 
		query.append("			AND    A.SKD_DIR_CD = ROB.SKD_DIR_CD" ).append("\n"); 
		query.append("		-------------------------------------------        " ).append("\n"); 
		query.append("			AND    E.RVS_CMB_FLG  = 'N'" ).append("\n"); 
		query.append("			AND    E.RJCT_CMB_FLG = 'N'" ).append("\n"); 
		query.append("			AND    A.ACCT_YRMON  = D.ACCT_YRMON" ).append("\n"); 
		query.append("			AND    A.STL_VVD_SEQ = D.STL_VVD_SEQ" ).append("\n"); 
		query.append("			AND    A.STL_SEQ     = D.STL_SEQ" ).append("\n"); 
		query.append("			AND    E.ACCT_YRMON  = D.ACCT_YRMON" ).append("\n"); 
		query.append("			AND    E.JO_CRR_CD   = D.JO_CRR_CD" ).append("\n"); 
		query.append("			AND    E.STL_CMB_SEQ = D.STL_CMB_SEQ" ).append("\n"); 
		query.append("			AND    E.RE_DIVR_CD  = D.RE_DIVR_CD" ).append("\n"); 
		query.append("			AND    E.SLP_SER_NO IS NOT NULL" ).append("\n"); 
		query.append("			AND    NVL(E.RVS_CMB_FLG ,'N') = 'N'" ).append("\n"); 
		query.append("			AND    NVL(E.RJCT_CMB_FLG,'N') = 'N'" ).append("\n"); 
		query.append("			AND    E.SLP_FUNC_CD = R.SLP_FUNC_CD" ).append("\n"); 
		query.append("			AND    E.SLP_OFC_CD = R.SLP_OFC_CD" ).append("\n"); 
		query.append("			AND    E.SLP_ISS_DT = R.SLP_ISS_DT" ).append("\n"); 
		query.append("			AND    E.SLP_SER_NO = R.SLP_SER_NO    " ).append("\n"); 
		query.append("       ) AS OVR_USD_SLT_AMT " ).append("\n"); 
		query.append("--     , DECODE(RL.ALL_TEU2,0,J.ALOC_TEU_KNT,RL.ALL_TEU2) AS ALL_TEU " ).append("\n"); 
		query.append("--     , DECODE(RL.ALL_WGT2,0,J.ALOC_TEU_WGT,ALL_WGT2) 	  AS ALL_WGT " ).append("\n"); 
		query.append("     , TGT.JO_STL_RMK_CD  AS RMK_FLG" ).append("\n"); 
		query.append("     , TGT.JO_STL_RMK  AS RMK" ).append("\n"); 
		query.append("     , NVL(ROB.TRD_CD,'XXX') AS TRD_CD" ).append("\n"); 
		query.append("     , 'SML' AS CRR_CD                --" ).append("\n"); 
		query.append("     , NVL(ROB.RLANE_CD,'XXXXX') AS RLANE_CD" ).append("\n"); 
		query.append("     , ROB.RE_DIVR_CD" ).append("\n"); 
		query.append("     , SKD.VSL_CD" ).append("\n"); 
		query.append("     , SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("     , SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("     , SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("     , SKD.TML_CD" ).append("\n"); 
		query.append("     , NVL(ROB.YD_CD ,'XXXXXXX') AS YD_CD" ).append("\n"); 
		query.append("     , SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("     , SKD.VPS_ETD_DT" ).append("\n"); 
		query.append("     , SKD.RDR_FLG" ).append("\n"); 
		query.append("     , SKD.PORT_SKD_STS " ).append("\n"); 
		query.append("     , ROB.REV_DIR_CD" ).append("\n"); 
		query.append("     , ROB.ROB_CNTR_WGT		AS GRAND_TTL_WGT" ).append("\n"); 
		query.append("     , ROB.FCNTR_20FT_KNT 	AS FULL_20" ).append("\n"); 
		query.append("     , ROB.MCNTR_20FT_KNT	AS MT_20" ).append("\n"); 
		query.append("     , ROB.FCNTR_40FT_KNT	AS FULL_40" ).append("\n"); 
		query.append("     , ROB.MCNTR_40FT_KNT	AS MT_40" ).append("\n"); 
		query.append("     , ROB.HC_20FT_FCNTR_KNT	AS HC_LD_20		" ).append("\n"); 
		query.append("     , ROB.HC_20FT_MCNTR_KNT	AS HC_BSA_20 " ).append("\n"); 
		query.append("     , ROB.HC_40FT_FCNTR_KNT	AS HC_LD_40 " ).append("\n"); 
		query.append("     , ROB.HC_40FT_MCNTR_KNT	AS HC_BSA_40 " ).append("\n"); 
		query.append("     , ROB.FCNTR_45FT_KNT		AS HC_LD_45" ).append("\n"); 
		query.append("     , ROB.MCNTR_45FT_KNT		AS HC_BSA_45 " ).append("\n"); 
		query.append("     , ROB.AWK_CNTR_KNT			AS AK_UNIT" ).append("\n"); 
		query.append("     , ROB.RF_20FT_CNTR_KNT		AS RF_20_QTY" ).append("\n"); 
		query.append("     , ROB.RF_ROB_CNTR_KNT 		AS RF_RDR_QTY" ).append("\n"); 
		query.append("     , ROB.RF_40FT_ROB_CNTR_KNT AS RF_RDR_40_QTY" ).append("\n"); 
		query.append("     , ROB.RF_40FT_CNTR_KNT		AS RF_40_QTY" ).append("\n"); 
		query.append("     , ROB.DG_20FT_CNTR_KNT		AS DG_20" ).append("\n"); 
		query.append("     , ROB.DG_40FT_CNTR_KNT		AS DG_40" ).append("\n"); 
		query.append("     , ROB.OVR_VOID_SLT_QTY 	AS AK_VOID" ).append("\n"); 
		query.append("     , DECODE(ROB.ROB_ENBL_FLG,'Y','P','NP')	AS PASS" ).append("\n"); 
		query.append("     , '1' AS SUB_CHK" ).append("\n"); 
		query.append("     , NVL(BKG.ROB_CNTR_WGT, 0)	    	AS BKG_GRAND_TTL_WGT" ).append("\n"); 
		query.append("     , NVL(BKG.FCNTR_20FT_KNT, 0)   	AS BKG_FULL_20" ).append("\n"); 
		query.append("     , NVL(BKG.MCNTR_20FT_KNT, 0)   	AS BKG_MT_20" ).append("\n"); 
		query.append("     , NVL(BKG.FCNTR_40FT_KNT, 0)   	AS BKG_FULL_40" ).append("\n"); 
		query.append("     , NVL(BKG.MCNTR_40FT_KNT, 0)   	AS BKG_MT_40" ).append("\n"); 
		query.append("     , NVL(BKG.HC_20FT_FCNTR_KNT, 0)	AS BKG_HC_LD_20		" ).append("\n"); 
		query.append("     , NVL(BKG.HC_20FT_MCNTR_KNT, 0)	AS BKG_HC_BSA_20 " ).append("\n"); 
		query.append("     , NVL(BKG.HC_40FT_FCNTR_KNT, 0)	AS BKG_HC_LD_40 " ).append("\n"); 
		query.append("     , NVL(BKG.HC_40FT_MCNTR_KNT, 0)	AS BKG_HC_BSA_40 " ).append("\n"); 
		query.append("     , NVL(BKG.FCNTR_45FT_KNT, 0)		AS BKG_HC_LD_45" ).append("\n"); 
		query.append("     , NVL(BKG.MCNTR_45FT_KNT, 0)		AS BKG_HC_BSA_45 " ).append("\n"); 
		query.append("     , NVL(BKG.AWK_CNTR_KNT, 0)			AS BKG_AK_UNIT" ).append("\n"); 
		query.append("     , NVL(BKG.RF_20FT_CNTR_KNT, 0)		AS BKG_RF_20_QTY" ).append("\n"); 
		query.append("     , NVL(BKG.RF_ROB_CNTR_KNT, 0) 		AS BKG_RF_RDR_QTY" ).append("\n"); 
		query.append("     , NVL(BKG.RF_40FT_ROB_CNTR_KNT, 0) AS BKG_RF_RDR_40_QTY" ).append("\n"); 
		query.append("     , NVL(BKG.RF_40FT_CNTR_KNT, 0)		AS BKG_RF_40_QTY" ).append("\n"); 
		query.append("     , NVL(BKG.DG_20FT_CNTR_KNT, 0)		AS BKG_DG_20" ).append("\n"); 
		query.append("     , NVL(BKG.DG_40FT_CNTR_KNT, 0)		AS BKG_DG_40" ).append("\n"); 
		query.append("     , NVL(BKG.OVR_VOID_SLT_QTY, 0) 	AS BKG_AK_VOID" ).append("\n"); 
		query.append("     -- JOO BSA AGMT 데이터 출력 DECODE(PORT_BSA, NULL, ALL_BSA, PORT_BSA) 1순위 : PORT별설정, 2순위 ALL설정, 3순위 NULL" ).append("\n"); 
		query.append("     , DECODE(PRT_BSA.TRD_CD,   NULL,   NVL(ALL_BSA.JO_20FT_OVR_RTO, 0),        NVL(PRT_BSA.JO_20FT_OVR_RTO, 0)) * 2        AS JO_20FT_N1ST_RTO" ).append("\n"); 
		query.append("     , DECODE(PRT_BSA.TRD_CD,   NULL,   NVL(ALL_BSA.JO_20FT_SUB_TEU_QTY, 0),    NVL(PRT_BSA.JO_20FT_SUB_TEU_QTY, 0))		AS JO_20FT_SUB_TEU_QTY" ).append("\n"); 
		query.append("     , DECODE(PRT_BSA.TRD_CD,   NULL,   NVL(ALL_BSA.JO_40FT_OVR_RTO, 0),        NVL(PRT_BSA.JO_40FT_OVR_RTO, 0)) * 2        AS JO_40FT_N1ST_RTO" ).append("\n"); 
		query.append("     , DECODE(PRT_BSA.TRD_CD,   NULL,   NVL(ALL_BSA.JO_40FT_SUB_TEU_QTY, 0),    NVL(PRT_BSA.JO_40FT_SUB_TEU_QTY, 0))		AS JO_40FT_SUB_TEU_QTY" ).append("\n"); 
		query.append("     , DECODE(PRT_BSA.TRD_CD,   NULL,   NVL(ALL_BSA.JO_45FT_UND_RTO, 0),        NVL(PRT_BSA.JO_45FT_UND_RTO, 0)) * 2        AS JO_45FT_N1ST_RTO" ).append("\n"); 
		query.append("     , DECODE(PRT_BSA.TRD_CD,   NULL,   NVL(ALL_BSA.JO_45FT_OVR_RTO, 0),        NVL(PRT_BSA.JO_45FT_OVR_RTO, 0)) * 2		AS JO_45FT_N2ND_RTO" ).append("\n"); 
		query.append("     , DECODE(PRT_BSA.TRD_CD,   NULL,   NVL(ALL_BSA.JO_45FT_SUB_TEU_QTY, 0),    NVL(PRT_BSA.JO_45FT_SUB_TEU_QTY, 0))		AS JO_45FT_SUB_TEU_QTY	" ).append("\n"); 
		query.append("     , DECODE(PRT_BSA.TRD_CD,   NULL,   NVL(ALL_BSA.JO_RND_RULE_LVL, 4),        NVL(PRT_BSA.JO_RND_RULE_LVL, 4))    		AS JO_RND_RULE_LVL" ).append("\n"); 
		query.append("     , DECODE(PRT_BSA.TRD_CD,   NULL,   NVL(ALL_BSA.JO_TON_TEU_QTY, 0),         NVL(PRT_BSA.JO_TON_TEU_QTY, 0)) 			AS TEU_QTY  " ).append("\n"); 
		query.append("     , DECODE(PRT_BSA.TRD_CD,   NULL,   NVL(ALL_BSA.JO_OVR_BSA_TEU_QTY, 0),     NVL(PRT_BSA.JO_OVR_BSA_TEU_QTY, 0))         AS ALL_TEU" ).append("\n"); 
		query.append("     , DECODE(PRT_BSA.TRD_CD,   NULL,   NVL(ALL_BSA.JO_OVR_TON_WGT, 0),         NVL(PRT_BSA.JO_OVR_TON_WGT, 0))             AS ALL_WGT" ).append("\n"); 
		query.append("     , DECODE(PRT_BSA.TRD_CD,   NULL,   NVL(ALL_BSA.JO_OVR_BSA_TEU_QTY, 0),     NVL(PRT_BSA.JO_OVR_BSA_TEU_QTY, 0))         AS ALL_TEU2" ).append("\n"); 
		query.append("     , DECODE(PRT_BSA.TRD_CD,   NULL,   NVL(ALL_BSA.JO_OVR_TON_WGT, 0),         NVL(PRT_BSA.JO_OVR_TON_WGT, 0))             AS ALL_WGT2" ).append("\n"); 
		query.append("     , '0' AS mt_teu" ).append("\n"); 
		query.append("     , '0' AS mt_wt " ).append("\n"); 
		query.append("     , DECODE(PRT_BSA.TRD_CD,   NULL,   NVL(ALL_BSA.PORT_CD, 0),         NVL(PRT_BSA.PORT_CD, 0))             AS PORT_CD" ).append("\n"); 
		query.append("	 , DECODE(PRT_BSA.TRD_CD,   NULL,   NVL(ALL_BSA.PORT_SEQ, 0),         NVL(PRT_BSA.PORT_SEQ, 0))             AS PORT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , CASE WHEN PRT_BSA.TRD_CD IS NULL AND ALL_BSA.TRD_CD IS NULL THEN ''" ).append("\n"); 
		query.append("            WHEN PRT_BSA.TRD_CD IS NOT NULL THEN 'P'" ).append("\n"); 
		query.append("       ELSE 'A'" ).append("\n"); 
		query.append("       END BSA_FLG" ).append("\n"); 
		query.append("     , 'IST'  AS SOURCE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM SKD SKD" ).append("\n"); 
		query.append("     , JOO_ROB_CNTR_SMRY ROB" ).append("\n"); 
		query.append("     , JOO_BKG_CNTR_SMRY BKG" ).append("\n"); 
		query.append("     , JOO_BSA_AGMT ALL_BSA" ).append("\n"); 
		query.append("     , JOO_BSA_AGMT PRT_BSA" ).append("\n"); 
		query.append("     , JOO_LODG_TGT TGT" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   -- SKD ROB DATA JOIN START --------------------" ).append("\n"); 
		query.append("   AND SKD.VSL_CD = ROB.VSL_CD(+)" ).append("\n"); 
		query.append("   AND SKD.SKD_VOY_NO = ROB.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND SKD.SKD_DIR_CD = ROB.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND SKD.VPS_PORT_CD = ROB.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND SKD.YD_CD = ROB.YD_CD(+)" ).append("\n"); 
		query.append("   AND SKD.CLPT_IND_SEQ = ROB.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("   -- SKD ROB DATA JOIN END ----------------------" ).append("\n"); 
		query.append("   ----- ROB BKG DATA JOIN START -----------------" ).append("\n"); 
		query.append("   AND ROB.VSL_CD = BKG.VSL_CD(+)" ).append("\n"); 
		query.append("   AND ROB.SKD_VOY_NO = BKG.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND ROB.SKD_DIR_CD = BKG.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND ROB.VPS_PORT_CD = BKG.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND ROB.YD_CD = BKG.YD_CD(+)" ).append("\n"); 
		query.append("   AND ROB.CLPT_IND_SEQ = BKG.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("   AND ROB.TRD_CD = BKG.TRD_CD(+)" ).append("\n"); 
		query.append("   AND ROB.RLANE_CD = BKG.RLANE_CD(+)" ).append("\n"); 
		query.append("   ----- ROB BKG DATA JOIN END --------------------" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   ----- BSA ALL DATA JOIN START ------------------" ).append("\n"); 
		query.append("   AND ROB.TRD_CD = ALL_BSA.TRD_CD(+)" ).append("\n"); 
		query.append("   AND ROB.RLANE_CD = ALL_BSA.RLANE_CD(+)" ).append("\n"); 
		query.append("   AND ROB.VSL_CD = ALL_BSA.VSL_CD(+)" ).append("\n"); 
		query.append("   AND ROB.SKD_VOY_NO = ALL_BSA.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND ROB.SKD_DIR_CD = ALL_BSA.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND ALL_BSA.JO_CRR_CD(+) = 'SML'" ).append("\n"); 
		query.append("   AND ROB.RE_DIVR_CD = ALL_BSA.RE_DIVR_CD(+)" ).append("\n"); 
		query.append("   AND ALL_BSA.PORT_CD(+) = 'ALL'" ).append("\n"); 
		query.append("   AND ALL_BSA.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("   AND ALL_BSA.RE_DIVR_CD(+) = 'E'" ).append("\n"); 
		query.append("   ----- BSA PORT ALL DATA JOIN END ---------------" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   ----- BSA PORT 개별 DATA JOIN START ------------" ).append("\n"); 
		query.append("   AND ROB.TRD_CD = PRT_BSA.TRD_CD(+)" ).append("\n"); 
		query.append("   AND ROB.RLANE_CD = PRT_BSA.RLANE_CD(+)" ).append("\n"); 
		query.append("   AND ROB.VSL_CD = PRT_BSA.VSL_CD(+)" ).append("\n"); 
		query.append("   AND ROB.SKD_VOY_NO = PRT_BSA.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND ROB.SKD_DIR_CD = PRT_BSA.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND ROB.VPS_PORT_CD = PRT_BSA.PORT_CD(+)" ).append("\n"); 
		query.append("   AND ROB.CLPT_IND_SEQ = PRT_BSA.PORT_SEQ(+)" ).append("\n"); 
		query.append("   AND PRT_BSA.JO_CRR_CD(+) = 'SML'" ).append("\n"); 
		query.append("   AND ROB.RE_DIVR_CD = PRT_BSA.RE_DIVR_CD(+)" ).append("\n"); 
		query.append("   AND PRT_BSA.DELT_FLG(+) = 'N'	" ).append("\n"); 
		query.append("   AND PRT_BSA.RE_DIVR_CD(+) = 'E'" ).append("\n"); 
		query.append("   ----- BSA PORT 개별 DATA JOIN END --------------" ).append("\n"); 
		query.append("   ----- LODG TGT DATA JOIN START -----------------" ).append("\n"); 
		query.append("   AND ROB.TRD_CD = NVL(TGT.TRD_CD(+),'XXX')" ).append("\n"); 
		query.append("   AND TGT.CRR_CD(+) = 'SML'" ).append("\n"); 
		query.append("   AND ROB.RLANE_CD = NVL(TGT.RLANE_CD(+),'XXXXX')" ).append("\n"); 
		query.append("   AND ROB.VSL_CD = TGT.VSL_CD(+)" ).append("\n"); 
		query.append("   AND ROB.SKD_VOY_NO = TGT.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND ROB.SKD_DIR_CD = TGT.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND ROB.VPS_PORT_CD = TGT.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND ROB.YD_CD = NVL(TGT.YD_CD(+),'XXXXXXX')" ).append("\n"); 
		query.append("   AND ROB.CLPT_IND_SEQ  = TGT.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("   AND TGT.RE_DIVR_CD(+) = 'E'" ).append("\n"); 
		query.append("   ----- LODG TGT DATA JOIN END -------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND ROB.RLANE_CD(+) LIKE @[rlane_cd] || '%'" ).append("\n"); 
		query.append("   AND ROB.VPS_ETD_DT(+) BETWEEN TO_DATE(@[pre_fr] || '000000' , 'YYYY-MM-DDHH24MISS') AND TO_DATE(@[pre_to] || '235959' , 'YYYY-MM-DDHH24MISS')" ).append("\n"); 
		query.append("   #if (${vvd} != '') " ).append("\n"); 
		query.append("   AND SKD.VSL_CD || SKD.SKD_VOY_NO || SKD.SKD_DIR_CD LIKE @[vvd] || '%' " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${skd_dir_cd} != '') " ).append("\n"); 
		query.append("   AND SKD.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${opt_tgt} == 'T') " ).append("\n"); 
		query.append("   AND TGT.STL_TGT_FLG = '1'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${opt_tgt} == 'N')" ).append("\n"); 
		query.append("   AND TGT.STL_TGT_FLG(+) = '0' " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${opt_clz} == 'C') " ).append("\n"); 
		query.append("   AND TGT.STL_CLZ_FLG = '1'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${opt_clz} == 'N')" ).append("\n"); 
		query.append("   AND TGT.STL_CLZ_FLG(+) = '0' " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("ORDER BY SUBSTR(VVD_ETD_GROUP, 10), SKD.VSL_CD || SKD.SKD_VOY_NO || SKD.SKD_DIR_CD, SKD.VPS_ETD_DT, SKD.VPS_PORT_CD, ROB.CRR_CD" ).append("\n"); 

	}
}