/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SettlementProcessDBDAOStlTgtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.24
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2016.05.24 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SettlementProcessDBDAOStlTgtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Settlement Target 페이지 조회
	  * </pre>
	  */
	public SettlementProcessDBDAOStlTgtRSQL(){
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
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rev_yrmon_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon_fr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration").append("\n"); 
		query.append("FileName : SettlementProcessDBDAOStlTgtRSQL").append("\n"); 
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
		query.append("WITH SLT_TGT AS ( " ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("         J.REV_YRMON" ).append("\n"); 
		query.append("        ,J.REV_YRMON_SEQ" ).append("\n"); 
		query.append("        ,S.REV_SEQ" ).append("\n"); 
		query.append("        ,J.TRD_CD" ).append("\n"); 
		query.append("        ,J.CRR_CD" ).append("\n"); 
		query.append("        ,J.RLANE_CD" ).append("\n"); 
		query.append("        ,J.RE_DIVR_CD" ).append("\n"); 
		query.append("        ,J.VSL_CD" ).append("\n"); 
		query.append("        ,J.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,J.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,J.LST_LODG_PORT_CD AS VPS_PORT_CD" ).append("\n"); 
		query.append("        ,'' AS YD_CD" ).append("\n"); 
		query.append("        ,'' AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("        ,'' AS RDR_FLG" ).append("\n"); 
		query.append("        ,J.N1ST_LODG_PORT_ETD_DT AS VPS_ETD_DT" ).append("\n"); 
		query.append("        ,J.ACCT_CD" ).append("\n"); 
		query.append("        ,J.JO_STL_JB_CD" ).append("\n"); 
		query.append("        ,J.JO_STL_STS_CD            --Maual Setting" ).append("\n"); 
		query.append("        ,'S/H' AS JO_STL_ITM_CD" ).append("\n"); 
		query.append("        ,DECODE(J.FNL_BSA_QTY,NULL,J.BSA_QTY,J.FNL_BSA_QTY) 			  AS BSA_QTY" ).append("\n"); 
		query.append("        ,DECODE(J.FNL_BSA_SLT_PRC ,NULL,J.BSA_SLT_PRC,J.FNL_BSA_SLT_PRC ) AS BSA_SLT_PRC    " ).append("\n"); 
		query.append("		,S.FNL_BSA_QTY " ).append("\n"); 
		query.append("		,S.FNL_BSA_SLT_PRC " ).append("\n"); 
		query.append("        ,NVL(S.LOCL_CURR_CD,'USD') AS LOCL_CURR_CD" ).append("\n"); 
		query.append("        ,S.STL_LOCL_AMT" ).append("\n"); 
		query.append("        ,S.STL_RMK" ).append("\n"); 
		query.append("        ,'S/H' AS JO_STL_TGT_ITM_CD" ).append("\n"); 
		query.append("        ,J.ESTM_STL_AMT         --추정금액" ).append("\n"); 
		query.append("        ,J.ACT_STL_AMT          --정산금액" ).append("\n"); 
		query.append("        ,'' AS RF_SCG_STL_TP_CD     --T(TDR), R(RDR), I(User INPUT)" ).append("\n"); 
		query.append("        ,1 AS LEV" ).append("\n"); 
		query.append("        ,MIN(J.VSL_CD || J.SKD_VOY_NO || J.SKD_DIR_CD || J.REV_YRMON) OVER (PARTITION BY J.VSL_CD || J.SKD_VOY_NO || J.SKD_DIR_CD) AS VVD_ETD_GROUP" ).append("\n"); 
		query.append("        ,(" ).append("\n"); 
		query.append("			SELECT NVL(MAX(J3.ACCT_YRMON),'999912') AS ACCT_YRMON FROM JOO_STL_TGT J2, JOO_SETTLEMENT J3" ).append("\n"); 
		query.append("			WHERE J2.REV_YRMON = S.REV_YRMON" ).append("\n"); 
		query.append("			AND J2.REV_YRMON_SEQ = S.REV_YRMON_SEQ" ).append("\n"); 
		query.append("            AND J2.REV_SEQ = S.REV_SEQ" ).append("\n"); 
		query.append("			AND J2.ACCT_YRMON = J3.ACCT_YRMON(+)" ).append("\n"); 
		query.append("			AND J2.STL_VVD_SEQ = J3.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("			AND J2.STL_SEQ = J3.STL_SEQ(+)" ).append("\n"); 
		query.append("          ) ACCT_YRMON   " ).append("\n"); 
		query.append("        ,S.STL_VVD_SEQ" ).append("\n"); 
		query.append("        ,S.STL_SEQ " ).append("\n"); 
		query.append("        ,S.STL_TGT_FLG" ).append("\n"); 
		query.append("        ,S.STL_TGT_FLG AS STL_TGT_FLG2" ).append("\n"); 
		query.append("        ,S.STL_CLZ_FLG " ).append("\n"); 
		query.append("        ,J.REV_DIR_CD" ).append("\n"); 
		query.append("        ,'' AS TML" ).append("\n"); 
		query.append("        ,NULL AS REV_BSA_QTY" ).append("\n"); 
		query.append("        ,NULL AS REV_BSA_SLT_PRC" ).append("\n"); 
		query.append("        ,NULL AS REV_ENBL_FLG " ).append("\n"); 
		query.append("        ,'Y' AS REV_SHW_FLG" ).append("\n"); 
		query.append("        ,NULL AS REV_CRR_CD" ).append("\n"); 
		query.append("        ,NULL AS N2ND_REV_BSA_QTY" ).append("\n"); 
		query.append("        ,NULL AS N2ND_REV_BSA_SLT_PRC" ).append("\n"); 
		query.append("        ,NULL AS N2ND_REV_ENBL_FLG" ).append("\n"); 
		query.append("        ,NULL AS N2ND_REV_CRR_CD" ).append("\n"); 
		query.append("        ,NULL AS N3RD_REV_BSA_QTY" ).append("\n"); 
		query.append("        ,NULL AS N3RD_REV_BSA_SLT_PRC" ).append("\n"); 
		query.append("        ,NULL AS N3RD_REV_ENBL_FLG" ).append("\n"); 
		query.append("        ,NULL AS N3RD_REV_CRR_CD    " ).append("\n"); 
		query.append("        ,NULL AS REV_CHK" ).append("\n"); 
		query.append("        ,NULL AS N2ND_REV_CHK" ).append("\n"); 
		query.append("        ,NULL AS N3RD_REV_CHK  " ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("			SELECT " ).append("\n"); 
		query.append("                 J.REV_YRMON" ).append("\n"); 
		query.append("                ,J.REV_YRMON_SEQ" ).append("\n"); 
		query.append("                ,J.TRD_CD" ).append("\n"); 
		query.append("                ,J.CRR_CD" ).append("\n"); 
		query.append("                ,J.RLANE_CD" ).append("\n"); 
		query.append("                ,J.RE_DIVR_CD" ).append("\n"); 
		query.append("                ,J.VSL_CD" ).append("\n"); 
		query.append("                ,J.SKD_VOY_NO" ).append("\n"); 
		query.append("                ,J.SKD_DIR_CD" ).append("\n"); 
		query.append("                ,J.LST_LODG_PORT_CD" ).append("\n"); 
		query.append("                ,J.N1ST_LODG_PORT_ETD_DT" ).append("\n"); 
		query.append("                ,J.ACCT_CD" ).append("\n"); 
		query.append("                ,J.JO_STL_JB_CD" ).append("\n"); 
		query.append("                ,J.JO_STL_STS_CD        " ).append("\n"); 
		query.append("                ,J.BSA_QTY" ).append("\n"); 
		query.append("                ,J.FNL_BSA_QTY" ).append("\n"); 
		query.append("                ,J.BSA_SLT_PRC" ).append("\n"); 
		query.append("                ,J.FNL_BSA_SLT_PRC" ).append("\n"); 
		query.append("                ,J.ESTM_STL_AMT         " ).append("\n"); 
		query.append("                ,J.ACT_STL_AMT          " ).append("\n"); 
		query.append("                ,J.REV_DIR_CD " ).append("\n"); 
		query.append("                ,J.JO_FSH_FLG" ).append("\n"); 
		query.append("			FROM JOO_SLT_TGT J" ).append("\n"); 
		query.append("			WHERE 1=1" ).append("\n"); 
		query.append("			AND J.JO_FSH_FLG = '1'" ).append("\n"); 
		query.append("		    AND J.REV_YRMON BETWEEN REPLACE(@[rev_yrmon_fr],'-','') AND REPLACE(@[rev_yrmon_to],'-','')" ).append("\n"); 
		query.append("		    #if (${re_divr_cd} != '')			" ).append("\n"); 
		query.append("		    AND J.RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		    #if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("		    AND J.CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		    #if (${trd_cd} != '')" ).append("\n"); 
		query.append("		    AND J.TRD_CD    = @[trd_cd]" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		    #if (${rlane_cd} != '')" ).append("\n"); 
		query.append("		    AND J.RLANE_CD  = @[rlane_cd]" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		    #if (${vvd} != '')" ).append("\n"); 
		query.append("			AND (J.VSL_CD || J.SKD_VOY_NO || J.SKD_DIR_CD)	LIKE @[vvd] || '%'" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		 ) J" ).append("\n"); 
		query.append("		 ,(" ).append("\n"); 
		query.append("			SELECT " ).append("\n"); 
		query.append("                 S.FNL_BSA_QTY " ).append("\n"); 
		query.append("                ,S.FNL_BSA_SLT_PRC " ).append("\n"); 
		query.append("                ,S.LOCL_CURR_CD" ).append("\n"); 
		query.append("                ,S.STL_LOCL_AMT" ).append("\n"); 
		query.append("                ,S.STL_RMK" ).append("\n"); 
		query.append("                ,S.STL_VVD_SEQ" ).append("\n"); 
		query.append("                ,S.STL_SEQ " ).append("\n"); 
		query.append("                ,S.STL_TGT_FLG" ).append("\n"); 
		query.append("                ,S.STL_CLZ_FLG              " ).append("\n"); 
		query.append("                ,S.REV_YRMON" ).append("\n"); 
		query.append("                ,S.REV_YRMON_SEQ" ).append("\n"); 
		query.append("                ,S.REV_SEQ" ).append("\n"); 
		query.append("                ,S.TRD_CD" ).append("\n"); 
		query.append("                ,S.CRR_CD" ).append("\n"); 
		query.append("                ,S.RLANE_CD" ).append("\n"); 
		query.append("                ,S.VSL_CD" ).append("\n"); 
		query.append("                ,S.SKD_VOY_NO" ).append("\n"); 
		query.append("                ,S.SKD_DIR_CD			" ).append("\n"); 
		query.append("            FROM JOO_STL_TGT S" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("        	AND S.JO_STL_ITM_CD  = 'S/H'" ).append("\n"); 
		query.append("		    AND S.REV_YRMON BETWEEN REPLACE(@[rev_yrmon_fr],'-','') AND REPLACE(@[rev_yrmon_to],'-','')" ).append("\n"); 
		query.append("		    #if (${re_divr_cd} != '')			" ).append("\n"); 
		query.append("		    AND S.RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		    #if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("		    AND S.CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		    #if (${trd_cd} != '')" ).append("\n"); 
		query.append("		    AND S.TRD_CD    = @[trd_cd]" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		    #if (${rlane_cd} != '')" ).append("\n"); 
		query.append("		    AND S.RLANE_CD  = @[rlane_cd]" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		    #if (${vvd} != '')" ).append("\n"); 
		query.append("			AND (S.VSL_CD || S.SKD_VOY_NO || S.SKD_DIR_CD)	LIKE @[vvd] || '%'" ).append("\n"); 
		query.append("		    #end  " ).append("\n"); 
		query.append("		 ) S" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND J.JO_FSH_FLG = '1'" ).append("\n"); 
		query.append("    AND J.REV_YRMON = S.REV_YRMON(+)" ).append("\n"); 
		query.append("    AND J.REV_YRMON_SEQ = S.REV_YRMON_SEQ(+)" ).append("\n"); 
		query.append("	AND J.TRD_CD = S.TRD_CD(+)" ).append("\n"); 
		query.append("	AND J.CRR_CD = S.CRR_CD(+)" ).append("\n"); 
		query.append(" 	AND J.RLANE_CD = S.RLANE_CD(+)" ).append("\n"); 
		query.append("    AND J.VSL_CD = S.VSL_CD(+)" ).append("\n"); 
		query.append("    AND J.SKD_VOY_NO = S.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("    AND J.SKD_DIR_CD = S.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("), STL_TGT AS (    " ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("         S.REV_YRMON" ).append("\n"); 
		query.append("        ,S.REV_YRMON_SEQ" ).append("\n"); 
		query.append("        ,S.REV_SEQ" ).append("\n"); 
		query.append("        ,S.TRD_CD" ).append("\n"); 
		query.append("        ,S.CRR_CD" ).append("\n"); 
		query.append("        ,S.RLANE_CD" ).append("\n"); 
		query.append("        ,S.RE_DIVR_CD" ).append("\n"); 
		query.append("        ,S.VSL_CD" ).append("\n"); 
		query.append("        ,S.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,S.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,S.VPS_PORT_CD" ).append("\n"); 
		query.append("        ,S.YD_CD" ).append("\n"); 
		query.append("        ,S.CLPT_IND_SEQ" ).append("\n"); 
		query.append("        ,S.RDR_FLG" ).append("\n"); 
		query.append("        ,S.VPS_ETD_DT" ).append("\n"); 
		query.append("        ,S.ACCT_CD" ).append("\n"); 
		query.append("        ,S.JO_STL_JB_CD" ).append("\n"); 
		query.append("        ,S.JO_STL_STS_CD" ).append("\n"); 
		query.append("        ,S.JO_STL_ITM_CD" ).append("\n"); 
		query.append("        ,S.BSA_QTY" ).append("\n"); 
		query.append("        ,S.BSA_SLT_PRC" ).append("\n"); 
		query.append("        ,S.FNL_BSA_QTY" ).append("\n"); 
		query.append("        ,S.FNL_BSA_SLT_PRC" ).append("\n"); 
		query.append("        ,S.LOCL_CURR_CD" ).append("\n"); 
		query.append("        ,S.STL_LOCL_AMT" ).append("\n"); 
		query.append("        ,S.STL_RMK" ).append("\n"); 
		query.append("        ,S.JO_STL_TGT_ITM_CD" ).append("\n"); 
		query.append("--        ,S.ESTM_STL_AMT" ).append("\n"); 
		query.append("--        ,S.ACT_STL_AMT" ).append("\n"); 
		query.append("--        ,S.RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("        ,S.LEV" ).append("\n"); 
		query.append("        ,S.VVD_ETD_GROUP" ).append("\n"); 
		query.append("        ,S.ACCT_YRMON" ).append("\n"); 
		query.append("        ,S.STL_VVD_SEQ" ).append("\n"); 
		query.append("        ,S.STL_SEQ" ).append("\n"); 
		query.append("        ,S.STL_TGT_FLG" ).append("\n"); 
		query.append("        ,S.STL_TGT_FLG2" ).append("\n"); 
		query.append("        ,S.STL_CLZ_FLG" ).append("\n"); 
		query.append("        ,S.REV_DIR_CD" ).append("\n"); 
		query.append("        ,S.TML" ).append("\n"); 
		query.append("        ,S.REV_BSA_QTY" ).append("\n"); 
		query.append("        ,S.REV_BSA_SLT_PRC" ).append("\n"); 
		query.append("        ,S.REV_ENBL_FLG" ).append("\n"); 
		query.append("        ,S.REV_SHW_FLG" ).append("\n"); 
		query.append("        ,S.REV_CRR_CD" ).append("\n"); 
		query.append("        ,S.N2ND_REV_BSA_QTY" ).append("\n"); 
		query.append("        ,S.N2ND_REV_BSA_SLT_PRC" ).append("\n"); 
		query.append("        ,S.N2ND_REV_ENBL_FLG" ).append("\n"); 
		query.append("        ,S.N2ND_REV_CRR_CD" ).append("\n"); 
		query.append("        ,S.N3RD_REV_BSA_QTY" ).append("\n"); 
		query.append("        ,S.N3RD_REV_BSA_SLT_PRC" ).append("\n"); 
		query.append("        ,S.N3RD_REV_ENBL_FLG" ).append("\n"); 
		query.append("        ,S.N3RD_REV_CRR_CD" ).append("\n"); 
		query.append("        ,S.REV_CHK" ).append("\n"); 
		query.append("        ,S.N2ND_REV_CHK" ).append("\n"); 
		query.append("        ,S.N3RD_REV_CHK    " ).append("\n"); 
		query.append("    FROM SLT_TGT S" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("         S.REV_YRMON" ).append("\n"); 
		query.append("        ,S.REV_YRMON_SEQ" ).append("\n"); 
		query.append("        ,S.REV_SEQ" ).append("\n"); 
		query.append("        ,S.TRD_CD" ).append("\n"); 
		query.append("        ,S.CRR_CD" ).append("\n"); 
		query.append("        ,S.RLANE_CD" ).append("\n"); 
		query.append("        ,S.RE_DIVR_CD" ).append("\n"); 
		query.append("        ,S.VSL_CD" ).append("\n"); 
		query.append("        ,S.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,S.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,S.VPS_PORT_CD" ).append("\n"); 
		query.append("        ,S.YD_CD" ).append("\n"); 
		query.append("        ,S.CLPT_IND_SEQ" ).append("\n"); 
		query.append("        ,S.RDR_FLG" ).append("\n"); 
		query.append("        ,S.VPS_ETD_DT" ).append("\n"); 
		query.append("        ,S.ACCT_CD" ).append("\n"); 
		query.append("        ,S.JO_STL_JB_CD" ).append("\n"); 
		query.append("        ,S.JO_STL_STS_CD" ).append("\n"); 
		query.append("        ,S.JO_STL_ITM_CD" ).append("\n"); 
		query.append("        ,S.BSA_QTY" ).append("\n"); 
		query.append("        ,S.BSA_SLT_PRC" ).append("\n"); 
		query.append("        ,S.FNL_BSA_QTY" ).append("\n"); 
		query.append("        ,S.FNL_BSA_SLT_PRC" ).append("\n"); 
		query.append("        ,S.LOCL_CURR_CD" ).append("\n"); 
		query.append("        ,S.STL_LOCL_AMT" ).append("\n"); 
		query.append("        ,S.STL_RMK" ).append("\n"); 
		query.append("        ,'S/H' AS JO_STL_TGT_ITM_CD" ).append("\n"); 
		query.append("--        ,NULL AS ESTM_STL_AMT" ).append("\n"); 
		query.append("--        ,0 AS ACT_STL_AMT" ).append("\n"); 
		query.append("--        ,S.RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("        ,1 AS LEV" ).append("\n"); 
		query.append("        ,MIN(VSL_CD || SKD_VOY_NO || SKD_DIR_CD || REV_YRMON) OVER (PARTITION BY VSL_CD || SKD_VOY_NO || SKD_DIR_CD) AS VVD_ETD_GROUP " ).append("\n"); 
		query.append("        ,S.ACCT_YRMON" ).append("\n"); 
		query.append("        ,S.STL_VVD_SEQ" ).append("\n"); 
		query.append("        ,S.STL_SEQ" ).append("\n"); 
		query.append("        ,S.STL_TGT_FLG" ).append("\n"); 
		query.append("        ,S.STL_TGT_FLG AS STL_TGT_FLG2" ).append("\n"); 
		query.append("        ,S.STL_CLZ_FLG" ).append("\n"); 
		query.append("        ,S.REV_DIR_CD" ).append("\n"); 
		query.append("        ,'' AS TML" ).append("\n"); 
		query.append("        ,NULL AS REV_BSA_QTY" ).append("\n"); 
		query.append("        ,NULL AS REV_BSA_SLT_PRC" ).append("\n"); 
		query.append("        ,NULL AS REV_ENBL_FLG " ).append("\n"); 
		query.append("        ,S.REV_SHW_FLG" ).append("\n"); 
		query.append("        ,NULL AS REV_CRR_CD" ).append("\n"); 
		query.append("        ,NULL AS N2ND_REV_BSA_QTY" ).append("\n"); 
		query.append("        ,NULL AS N2ND_REV_BSA_SLT_PRC" ).append("\n"); 
		query.append("        ,NULL AS N2ND_REV_ENBL_FLG" ).append("\n"); 
		query.append("        ,NULL AS N2ND_REV_CRR_CD" ).append("\n"); 
		query.append("        ,NULL AS N3RD_REV_BSA_QTY" ).append("\n"); 
		query.append("        ,NULL AS N3RD_REV_BSA_SLT_PRC" ).append("\n"); 
		query.append("        ,NULL AS N3RD_REV_ENBL_FLG" ).append("\n"); 
		query.append("        ,NULL AS N3RD_REV_CRR_CD    " ).append("\n"); 
		query.append("        ,NULL AS REV_CHK" ).append("\n"); 
		query.append("        ,NULL AS N2ND_REV_CHK" ).append("\n"); 
		query.append("        ,NULL AS N3RD_REV_CHK    " ).append("\n"); 
		query.append("    FROM JOO_STL_TGT S    " ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND S.REV_SHW_FLG IN ('A','C','S')" ).append("\n"); 
		query.append("    AND S.JO_STL_ITM_CD  = 'S/H'" ).append("\n"); 
		query.append("		    AND S.REV_YRMON BETWEEN REPLACE(@[rev_yrmon_fr],'-','') AND REPLACE(@[rev_yrmon_to],'-','')" ).append("\n"); 
		query.append("		    #if (${re_divr_cd} != '')			" ).append("\n"); 
		query.append("		    AND S.RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		    #if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("		    AND S.CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		    #if (${trd_cd} != '')" ).append("\n"); 
		query.append("		    AND S.TRD_CD    = @[trd_cd]" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		    #if (${rlane_cd} != '')" ).append("\n"); 
		query.append("		    AND S.RLANE_CD  = @[rlane_cd]" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		    #if (${vvd} != '')" ).append("\n"); 
		query.append("			AND (S.VSL_CD || S.SKD_VOY_NO || S.SKD_DIR_CD)	LIKE @[vvd] || '%'" ).append("\n"); 
		query.append("		    #end  " ).append("\n"); 
		query.append("), STL_TGT2 AS ( " ).append("\n"); 
		query.append("    SELECT  " ).append("\n"); 
		query.append("         S.REV_YRMON" ).append("\n"); 
		query.append("        ,S.REV_YRMON_SEQ" ).append("\n"); 
		query.append("        ,S.REV_SEQ" ).append("\n"); 
		query.append("        ,S.TRD_CD" ).append("\n"); 
		query.append("        ,S.CRR_CD" ).append("\n"); 
		query.append("        ,S.RLANE_CD" ).append("\n"); 
		query.append("        ,S.RE_DIVR_CD" ).append("\n"); 
		query.append("        ,S.VSL_CD" ).append("\n"); 
		query.append("        ,S.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,S.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,S.VPS_PORT_CD" ).append("\n"); 
		query.append("        ,S.YD_CD" ).append("\n"); 
		query.append("        ,S.CLPT_IND_SEQ" ).append("\n"); 
		query.append("        ,S.RDR_FLG" ).append("\n"); 
		query.append("        ,S.VPS_ETD_DT" ).append("\n"); 
		query.append("        ,S.ACCT_CD" ).append("\n"); 
		query.append("        ,S.JO_STL_JB_CD" ).append("\n"); 
		query.append("        ,S.JO_STL_STS_CD" ).append("\n"); 
		query.append("        ,S.JO_STL_ITM_CD" ).append("\n"); 
		query.append("        ,S.BSA_QTY" ).append("\n"); 
		query.append("        ,S.BSA_SLT_PRC" ).append("\n"); 
		query.append("        ,S.FNL_BSA_QTY" ).append("\n"); 
		query.append("        ,S.FNL_BSA_SLT_PRC" ).append("\n"); 
		query.append("        ,S.LOCL_CURR_CD" ).append("\n"); 
		query.append("        ,S.STL_LOCL_AMT" ).append("\n"); 
		query.append("        ,S.STL_RMK" ).append("\n"); 
		query.append("        ,S.JO_STL_TGT_ITM_CD" ).append("\n"); 
		query.append("--        ,S.ESTM_STL_AMT" ).append("\n"); 
		query.append("--        ,S.ACT_STL_AMT" ).append("\n"); 
		query.append("--        ,S.RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("        ,S.LEV" ).append("\n"); 
		query.append("        ,S.VVD_ETD_GROUP" ).append("\n"); 
		query.append("        ,S.ACCT_YRMON" ).append("\n"); 
		query.append("        ,S.STL_VVD_SEQ" ).append("\n"); 
		query.append("        ,S.STL_SEQ" ).append("\n"); 
		query.append("        ,S.STL_TGT_FLG" ).append("\n"); 
		query.append("        ,S.STL_TGT_FLG2" ).append("\n"); 
		query.append("        ,S.STL_CLZ_FLG" ).append("\n"); 
		query.append("        ,S.REV_DIR_CD" ).append("\n"); 
		query.append("        ,S.TML" ).append("\n"); 
		query.append("        ,S.REV_BSA_QTY" ).append("\n"); 
		query.append("        ,S.REV_BSA_SLT_PRC" ).append("\n"); 
		query.append("        ,S.REV_ENBL_FLG" ).append("\n"); 
		query.append("        ,S.REV_SHW_FLG" ).append("\n"); 
		query.append("        ,S.REV_CRR_CD" ).append("\n"); 
		query.append("        ,S.N2ND_REV_BSA_QTY" ).append("\n"); 
		query.append("        ,S.N2ND_REV_BSA_SLT_PRC" ).append("\n"); 
		query.append("        ,S.N2ND_REV_ENBL_FLG" ).append("\n"); 
		query.append("        ,S.N2ND_REV_CRR_CD" ).append("\n"); 
		query.append("        ,S.N3RD_REV_BSA_QTY" ).append("\n"); 
		query.append("        ,S.N3RD_REV_BSA_SLT_PRC" ).append("\n"); 
		query.append("        ,S.N3RD_REV_ENBL_FLG" ).append("\n"); 
		query.append("        ,S.N3RD_REV_CRR_CD" ).append("\n"); 
		query.append("        ,S.REV_CHK" ).append("\n"); 
		query.append("        ,S.N2ND_REV_CHK" ).append("\n"); 
		query.append("        ,S.N3RD_REV_CHK      " ).append("\n"); 
		query.append("    FROM STL_TGT S" ).append("\n"); 
		query.append("    ORDER BY VVD_ETD_GROUP, VPS_ETD_DT, LEV, REV_YRMON_SEQ, REV_SEQ ASC          " ).append("\n"); 
		query.append(")    " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("     ROWNUM AS SEQ_NO" ).append("\n"); 
		query.append("    ,REV_YRMON" ).append("\n"); 
		query.append("    ,REV_YRMON_SEQ" ).append("\n"); 
		query.append("    ,REV_SEQ" ).append("\n"); 
		query.append("    ,TRD_CD" ).append("\n"); 
		query.append("    ,CRR_CD" ).append("\n"); 
		query.append("    ,RLANE_CD" ).append("\n"); 
		query.append("    ,RE_DIVR_CD" ).append("\n"); 
		query.append("    ,VSL_CD" ).append("\n"); 
		query.append("    ,SKD_VOY_NO" ).append("\n"); 
		query.append("    ,SKD_DIR_CD" ).append("\n"); 
		query.append("    ,VPS_PORT_CD" ).append("\n"); 
		query.append("    ,YD_CD" ).append("\n"); 
		query.append("    ,CLPT_IND_SEQ" ).append("\n"); 
		query.append("    ,RDR_FLG" ).append("\n"); 
		query.append("    ,VPS_ETD_DT" ).append("\n"); 
		query.append("    ,ACCT_CD" ).append("\n"); 
		query.append("    ,JO_STL_JB_CD" ).append("\n"); 
		query.append("    ,JO_STL_STS_CD" ).append("\n"); 
		query.append("    ,JO_STL_ITM_CD" ).append("\n"); 
		query.append("    ,BSA_QTY" ).append("\n"); 
		query.append("    ,BSA_SLT_PRC" ).append("\n"); 
		query.append("    ,FNL_BSA_QTY" ).append("\n"); 
		query.append("    ,FNL_BSA_SLT_PRC" ).append("\n"); 
		query.append("    ,LOCL_CURR_CD" ).append("\n"); 
		query.append("    ,STL_LOCL_AMT" ).append("\n"); 
		query.append("    ,STL_RMK" ).append("\n"); 
		query.append("    ,JO_STL_TGT_ITM_CD" ).append("\n"); 
		query.append("    ,NULL AS ESTM_STL_AMT" ).append("\n"); 
		query.append("    ,NULL AS ACT_STL_AMT" ).append("\n"); 
		query.append("    ,NULL AS RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("    ,LEV" ).append("\n"); 
		query.append("    ,VVD_ETD_GROUP" ).append("\n"); 
		query.append("    ,NVL(ACCT_YRMON,'999912') AS ACCT_YRMON" ).append("\n"); 
		query.append("    ,STL_VVD_SEQ" ).append("\n"); 
		query.append("    ,STL_SEQ" ).append("\n"); 
		query.append("    ,STL_TGT_FLG" ).append("\n"); 
		query.append("    ,STL_TGT_FLG2" ).append("\n"); 
		query.append("    ,STL_CLZ_FLG" ).append("\n"); 
		query.append("    ,REV_DIR_CD" ).append("\n"); 
		query.append("    ,TML" ).append("\n"); 
		query.append("    ,REV_BSA_QTY" ).append("\n"); 
		query.append("    ,REV_BSA_SLT_PRC" ).append("\n"); 
		query.append("    ,REV_ENBL_FLG" ).append("\n"); 
		query.append("    ,REV_SHW_FLG" ).append("\n"); 
		query.append("    ,REV_CRR_CD" ).append("\n"); 
		query.append("    ,N2ND_REV_BSA_QTY" ).append("\n"); 
		query.append("    ,N2ND_REV_BSA_SLT_PRC" ).append("\n"); 
		query.append("    ,N2ND_REV_ENBL_FLG" ).append("\n"); 
		query.append("    ,N2ND_REV_CRR_CD" ).append("\n"); 
		query.append("    ,N3RD_REV_BSA_QTY" ).append("\n"); 
		query.append("    ,N3RD_REV_BSA_SLT_PRC" ).append("\n"); 
		query.append("    ,N3RD_REV_ENBL_FLG" ).append("\n"); 
		query.append("    ,N3RD_REV_CRR_CD" ).append("\n"); 
		query.append("    ,REV_CHK" ).append("\n"); 
		query.append("    ,N2ND_REV_CHK" ).append("\n"); 
		query.append("    ,N3RD_REV_CHK	" ).append("\n"); 
		query.append("FROM STL_TGT2" ).append("\n"); 

	}
}