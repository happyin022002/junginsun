/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SettlementProcessDBDAOExpRptRSQL.java
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

public class SettlementProcessDBDAOExpRptRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Jo Expense Report 조회
	  * </pre>
	  */
	public SettlementProcessDBDAOExpRptRSQL(){
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
		query.append("FileName : SettlementProcessDBDAOExpRptRSQL").append("\n"); 
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
		query.append("            ,CASE WHEN V.RDR_FLG = 'Y' THEN 'R'" ).append("\n"); 
		query.append("                  WHEN V.RDR_FLG = 'N' THEN ''" ).append("\n"); 
		query.append("                  ELSE DECODE(AA.VPS_PORT_CD,H.PORT_CD,'R','')" ).append("\n"); 
		query.append("                  END AS RDR_FLG" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT               " ).append("\n"); 
		query.append("                     K.VSL_CD" ).append("\n"); 
		query.append("                    ,K.SKD_VOY_NO" ).append("\n"); 
		query.append("                    ,K.SKD_DIR_CD       " ).append("\n"); 
		query.append("                    ,SUBSTR(K.YD_CD,1,5) 	AS VPS_PORT_CD" ).append("\n"); 
		query.append("                    ,SUBSTR(K.YD_CD,6,2) 	AS TML_CD" ).append("\n"); 
		query.append("                    ,K.CLPT_IND_SEQ 		AS SPLIT_NO " ).append("\n"); 
		query.append("                    ,TO_CHAR(K.VPS_ETD_DT,'YYYYMMDDHH24MISS') AS VPS_ETD_DT" ).append("\n"); 
		query.append("                    ,K.CLPT_SEQ" ).append("\n"); 
		query.append("                    ,K.SLAN_CD            " ).append("\n"); 
		query.append("                    ,K.YD_CD " ).append("\n"); 
		query.append("               FROM VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("              WHERE 1=1" ).append("\n"); 
		query.append("				#if (${rlane_cd} != '') " ).append("\n"); 
		query.append("			    AND SLAN_CD LIKE @[rlane_cd] || '%'" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${vvd} != '') " ).append("\n"); 
		query.append("				AND K.VSL_CD || K.SKD_VOY_NO || K.SKD_DIR_CD LIKE @[vvd] || '%' " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${skd_dir_cd} != '') " ).append("\n"); 
		query.append("				AND K.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("                AND ( (VPS_ETD_DT BETWEEN TO_DATE (REPLACE (@[pre_fr], '-', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("				                      AND TO_DATE (REPLACE (@[pre_to], '-', ''), 'YYYYMMDD') + 0.99999) OR VPS_ETD_DT IS NULL )" ).append("\n"); 
		query.append("                AND TURN_PORT_IND_CD NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("                AND NVL(K.SKD_CNG_STS_CD, 'A') <>  'S'  " ).append("\n"); 
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
		query.append("), ROB_LIST AS (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("     S.VSL_CD" ).append("\n"); 
		query.append("    ,S.SKD_VOY_NO" ).append("\n"); 
		query.append("    ,S.SKD_DIR_CD" ).append("\n"); 
		query.append("    ,S.VPS_PORT_CD" ).append("\n"); 
		query.append("    ,S.TML_CD" ).append("\n"); 
		query.append("    ,S.SPLIT_NO     AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("    ,S.VPS_ETD_DT" ).append("\n"); 
		query.append("    ,S.RDR_FLG" ).append("\n"); 
		query.append("    ,J.TRD_CD           " ).append("\n"); 
		query.append("    ,'SML' AS CRR_CD" ).append("\n"); 
		query.append("    ,J.RLANE_CD" ).append("\n"); 
		query.append("    ,J.RE_DIVR_CD" ).append("\n"); 
		query.append("    ,J.YD_CD" ).append("\n"); 
		query.append("    ,J.ROB_CNTR_WGT" ).append("\n"); 
		query.append("    ,J.FCNTR_20FT_KNT" ).append("\n"); 
		query.append("    ,J.MCNTR_20FT_KNT" ).append("\n"); 
		query.append("    ,J.FCNTR_40FT_KNT" ).append("\n"); 
		query.append("    ,J.MCNTR_40FT_KNT" ).append("\n"); 
		query.append("    ,J.HC_20FT_FCNTR_KNT" ).append("\n"); 
		query.append("    ,J.HC_20FT_MCNTR_KNT" ).append("\n"); 
		query.append("    ,J.HC_40FT_FCNTR_KNT" ).append("\n"); 
		query.append("    ,J.HC_40FT_MCNTR_KNT" ).append("\n"); 
		query.append("    ,J.FCNTR_45FT_KNT" ).append("\n"); 
		query.append("    ,J.MCNTR_45FT_KNT" ).append("\n"); 
		query.append("    ,J.AWK_CNTR_KNT" ).append("\n"); 
		query.append("    ,J.RF_20FT_CNTR_KNT" ).append("\n"); 
		query.append("    ,J.RF_ROB_CNTR_KNT" ).append("\n"); 
		query.append("    ,J.RF_40FT_CNTR_KNT" ).append("\n"); 
		query.append("    ,J.DG_20FT_CNTR_KNT" ).append("\n"); 
		query.append("    ,J.DG_40FT_CNTR_KNT" ).append("\n"); 
		query.append("    ,J.OVR_VOID_SLT_QTY" ).append("\n"); 
		query.append("	,DECODE(J.ROB_ENBL_FLG,'Y','P','NP')	AS ROB_ENBL_FLG	" ).append("\n"); 
		query.append("    ,J.REV_DIR_CD" ).append("\n"); 
		query.append("    FROM SKD S, JOO_ROB_CNTR_SMRY J" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND S.VSL_CD = J.VSL_CD(+)" ).append("\n"); 
		query.append("    AND S.SKD_VOY_NO = J.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("    AND S.SKD_DIR_CD = J.SKD_DIR_CD(+) " ).append("\n"); 
		query.append("    AND S.VPS_PORT_CD = J.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("    AND S.TML_CD = SUBSTR(J.YD_CD(+),6,2)" ).append("\n"); 
		query.append("    AND S.SPLIT_NO = J.CLPT_IND_SEQ(+) " ).append("\n"); 
		query.append("), ROB_LIST2 AS (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("             J.TRD_CD" ).append("\n"); 
		query.append("            ,J.CRR_CD" ).append("\n"); 
		query.append("            ,J.RLANE_CD" ).append("\n"); 
		query.append("            ,J.RE_DIVR_CD" ).append("\n"); 
		query.append("            ,J.VSL_CD" ).append("\n"); 
		query.append("            ,J.SKD_VOY_NO" ).append("\n"); 
		query.append("            ,J.SKD_DIR_CD " ).append("\n"); 
		query.append("            ,J.VPS_PORT_CD" ).append("\n"); 
		query.append("            ,J.TML_CD  " ).append("\n"); 
		query.append("            ,J.YD_CD " ).append("\n"); 
		query.append("            ,J.CLPT_IND_SEQ		" ).append("\n"); 
		query.append("            ,J.VPS_ETD_DT" ).append("\n"); 
		query.append("            ,J.RDR_FLG" ).append("\n"); 
		query.append("		    ,J.REV_DIR_CD" ).append("\n"); 
		query.append("            ,J.ROB_CNTR_WGT		AS grand_ttl_wgt" ).append("\n"); 
		query.append("            ,J.FCNTR_20FT_KNT 	AS full_20" ).append("\n"); 
		query.append("            ,J.MCNTR_20FT_KNT	AS mt_20" ).append("\n"); 
		query.append("            ,J.FCNTR_40FT_KNT	AS full_40" ).append("\n"); 
		query.append("            ,J.MCNTR_40FT_KNT	AS mt_40" ).append("\n"); 
		query.append("            ,J.HC_20FT_FCNTR_KNT	AS hc_ld_20		" ).append("\n"); 
		query.append("            ,J.HC_20FT_MCNTR_KNT	AS hc_bsa_20 " ).append("\n"); 
		query.append("            ,J.HC_40FT_FCNTR_KNT	AS hc_ld_40 " ).append("\n"); 
		query.append("            ,J.HC_40FT_MCNTR_KNT	AS hc_bsa_40 " ).append("\n"); 
		query.append("            ,J.FCNTR_45FT_KNT		AS hc_ld_45" ).append("\n"); 
		query.append("            ,J.MCNTR_45FT_KNT		AS hc_bsa_45 " ).append("\n"); 
		query.append("            ,J.AWK_CNTR_KNT			AS ak_unit" ).append("\n"); 
		query.append("            ,J.RF_20FT_CNTR_KNT		AS rf_20_qty" ).append("\n"); 
		query.append("            ,J.RF_ROB_CNTR_KNT 		AS rf_rdr_qty" ).append("\n"); 
		query.append("            ,J.RF_40FT_CNTR_KNT		AS rf_40_qty" ).append("\n"); 
		query.append("            ,J.DG_20FT_CNTR_KNT		AS dg_20" ).append("\n"); 
		query.append("            ,J.DG_40FT_CNTR_KNT		AS dg_40" ).append("\n"); 
		query.append("            ,J.OVR_VOID_SLT_QTY 	AS ak_void" ).append("\n"); 
		query.append("			,J.ROB_ENBL_FLG			AS pass" ).append("\n"); 
		query.append("            ,'1' AS sub_chk" ).append("\n"); 
		query.append("            ,CASE WHEN ((J.VPS_PORT_CD || J.CLPT_IND_SEQ = BB.PORT_CD || PORT_SEQ) OR BB.PORT_CD = 'ALL') AND J.VSL_CD = BB.VSL_CD " ).append("\n"); 
		query.append("                                                                          AND J.SKD_VOY_NO = BB.SKD_VOY_NO " ).append("\n"); 
		query.append("                                                                          AND J.SKD_DIR_CD = BB.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                          THEN BB.JO_OVR_BSA_TEU_QTY" ).append("\n"); 
		query.append("                 ELSE 0" ).append("\n"); 
		query.append("                 END ALL_TEU2" ).append("\n"); 
		query.append("            ,CASE WHEN ((J.VPS_PORT_CD || J.CLPT_IND_SEQ = BB.PORT_CD || PORT_SEQ) OR BB.PORT_CD = 'ALL') AND J.VSL_CD = BB.VSL_CD " ).append("\n"); 
		query.append("                                                                          AND J.SKD_VOY_NO = BB.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                          AND J.SKD_DIR_CD = BB.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                          THEN BB.JO_OVR_TON_WGT" ).append("\n"); 
		query.append("                 ELSE 0" ).append("\n"); 
		query.append("                 END ALL_WGT2" ).append("\n"); 
		query.append("            ,'IST'  AS source" ).append("\n"); 
		query.append("            ,BB.jo_20ft_sub_teu_qty   " ).append("\n"); 
		query.append("            ,BB.JO_20FT_OVR_RTO*2     AS jo_20ft_n1st_rto   " ).append("\n"); 
		query.append("            ,BB.jo_40ft_sub_teu_qty   " ).append("\n"); 
		query.append("            ,BB.JO_40FT_OVR_RTO*2     AS jo_40ft_n1st_rto   " ).append("\n"); 
		query.append("            ,BB.jo_45ft_sub_teu_qty   " ).append("\n"); 
		query.append("            ,BB.JO_45FT_OVR_RTO*2     AS jo_45ft_n2nd_rto       " ).append("\n"); 
		query.append("            ,BB.JO_45FT_UND_RTO*2     AS jo_45ft_n1st_rto   " ).append("\n"); 
		query.append("            ,BB.jo_rnd_rule_lvl   " ).append("\n"); 
		query.append("            ,BB.JO_TON_TEU_QTY 		AS teu_qty" ).append("\n"); 
		query.append("            ,'0' AS mt_teu" ).append("\n"); 
		query.append("            ,'0' AS mt_wt " ).append("\n"); 
		query.append("            ,BB.PORT_CD" ).append("\n"); 
		query.append("			,BB.PORT_SEQ" ).append("\n"); 
		query.append("            ---------------" ).append("\n"); 
		query.append("            ,BB.JO_BSA_TEU_QTY" ).append("\n"); 
		query.append("            ,BB.JO_OVR_BSA_TEU_QTY" ).append("\n"); 
		query.append("            ,BB.JO_OVR_TON_WGT" ).append("\n"); 
		query.append("            ,BB.JO_RDR_PORT_CD            " ).append("\n"); 
		query.append("    FROM ROB_LIST J" ).append("\n"); 
		query.append("        ,(" ).append("\n"); 
		query.append("              SELECT *" ).append("\n"); 
		query.append("			  FROM JOO_BSA_AGMT BB   " ).append("\n"); 
		query.append("              WHERE 1=1" ).append("\n"); 
		query.append("				AND BB.DELT_FLG = 'N'" ).append("\n"); 
		query.append("				#if (${vvd} != '') " ).append("\n"); 
		query.append("				AND BB.VSL_CD || BB.SKD_VOY_NO || BB.SKD_DIR_CD LIKE @[vvd] || '%' " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${skd_dir_cd} != '') " ).append("\n"); 
		query.append("				AND BB.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${rlane_cd} != '') " ).append("\n"); 
		query.append("    	        AND BB.RLANE_CD LIKE @[rlane_cd] || '%' " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("         ) BB" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND J.TRD_CD = BB.TRD_CD(+)" ).append("\n"); 
		query.append("    AND J.RLANE_CD = BB.RLANE_CD(+)    " ).append("\n"); 
		query.append("    AND J.VSL_CD = BB.VSL_CD(+)" ).append("\n"); 
		query.append("    AND J.SKD_VOY_NO = BB.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("    AND J.SKD_DIR_CD = BB.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("	AND J.CRR_CD = 'SML'" ).append("\n"); 
		query.append("    AND J.CRR_CD = BB.JO_CRR_CD(+)" ).append("\n"); 
		query.append("--    AND J.VPS_PORT_CD = BB.PORT_CD(+)" ).append("\n"); 
		query.append("--    AND J.CLPT_IND_SEQ = BB.PORT_SEQ(+)" ).append("\n"); 
		query.append("), ROB_LIST3 AS (" ).append("\n"); 
		query.append("	SELECT * FROM ROB_LIST2" ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("	AND (PORT_CD IS NULL" ).append("\n"); 
		query.append("		 OR PORT_CD = 'ALL' " ).append("\n"); 
		query.append("		 OR (PORT_CD || PORT_SEQ = VPS_PORT_CD || CLPT_IND_SEQ)" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("    AND VPS_PORT_CD = JO_RDR_PORT_CD" ).append("\n"); 
		query.append(")    " ).append("\n"); 
		query.append("SELECT  R.*" ).append("\n"); 
		query.append("        ,(" ).append("\n"); 
		query.append("  		        SELECT " ).append("\n"); 
		query.append("                    NVL(SUM(A4.CRR_BSA_CAPA),0)" ).append("\n"); 
		query.append("                FROM BSA_VVD_CRR_PERF A4" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND A4.TRD_CD = R.TRD_CD" ).append("\n"); 
		query.append("                AND A4.RLANE_CD =  R.RLANE_CD" ).append("\n"); 
		query.append("                AND A4.VSL_CD = R.VSL_CD" ).append("\n"); 
		query.append("                AND A4.SKD_VOY_NO = R.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND A4.SKD_DIR_CD = R.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND A4.BSA_OP_JB_CD IN ('001','002','004')" ).append("\n"); 
		query.append("                --AND CRR_CD = ''" ).append("\n"); 
		query.append("         ) AS SUBLET_TEU" ).append("\n"); 
		query.append("FROM ROB_LIST3 R" ).append("\n"); 
		query.append("ORDER BY R.TRD_CD, R.RLANE_CD, R.VPS_ETD_DT ASC" ).append("\n"); 

	}
}