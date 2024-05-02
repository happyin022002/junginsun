/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : UnmatchBLDBDAOSearchWscBkgListForAuditRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.13
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.13 
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

public class UnmatchBLDBDAOSearchWscBkgListForAuditRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WSC BKG Inquiry for Audit 화면을 조회한다.
	  * </pre>
	  */
	public UnmatchBLDBDAOSearchWscBkgListForAuditRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOSearchWscBkgListForAuditRSQL").append("\n"); 
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
		query.append("#if (${search_option} == 'A') " ).append("\n"); 
		query.append("-- Application Date" ).append("\n"); 
		query.append("WITH BKG  AS(" ).append("\n"); 
		query.append("    SELECT DISTINCT" ).append("\n"); 
		query.append("           BK.BKG_NO," ).append("\n"); 
		query.append("           BK.RCV_TERM_CD," ).append("\n"); 
		query.append("           BK.DE_TERM_CD," ).append("\n"); 
		query.append("           BK.SVC_SCP_CD," ).append("\n"); 
		query.append("           BK.POR_CD," ).append("\n"); 
		query.append("           BK.POL_CD," ).append("\n"); 
		query.append("           BK.POD_CD," ).append("\n"); 
		query.append("           BK.DEL_CD," ).append("\n"); 
		query.append("           BCNTR.CNTR_NO," ).append("\n"); 
		query.append("           DECODE(BR.BKG_CTRT_TP_CD, 'S', BK.SC_NO, 'R', BK.RFA_NO, BK.TAA_NO) CTRT_NO," ).append("\n"); 
		query.append("           BCR.RAT_UT_CD," ).append("\n"); 
		query.append("           BCR.CURR_CD," ).append("\n"); 
		query.append("           BCR.CHG_AMT" ).append("\n"); 
		query.append("    FROM   BKG_BOOKING BK," ).append("\n"); 
		query.append("           BKG_RATE  BR," ).append("\n"); 
		query.append("           BKG_CHG_RT BCR," ).append("\n"); 
		query.append("           BKG_CONTAINER   BCNTR" ).append("\n"); 
		query.append("    WHERE  BK.BKG_NO = BR.BKG_NO" ).append("\n"); 
		query.append("    AND    BK.BKG_NO = BCR.BKG_NO(+)" ).append("\n"); 
		query.append("    AND    BK.BKG_NO = BCNTR.BKG_NO" ).append("\n"); 
		query.append("    AND    (BK.POL_CD IN ('USLAX','USLGB') AND BK.POL_CD != BK.POR_CD" ).append("\n"); 
		query.append("     OR     BK.POD_CD IN ('USLAX','USLGB') AND BK.POD_CD != BK.DEL_CD)" ).append("\n"); 
		query.append("    AND    BCNTR.CNTR_TPSZ_CD like '%2'" ).append("\n"); 
		query.append("    AND    BCNTR.CNTR_WGT >= DECODE(BCNTR.WGT_UT_CD,'KGS',17240,'LBS',38007.694, 17240)" ).append("\n"); 
		query.append("    AND    BCR.CHG_CD(+) = 'WSC'" ).append("\n"); 
		query.append("    AND    BR.RT_APLY_DT BETWEEN TO_DATE(REPLACE(@[from_dt],'-',''),'YYYY-MM-DD') AND TO_DATE(REPLACE(@[to_dt],'-',''),'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("    #if (${rcv_term_cd} != '')" ).append("\n"); 
		query.append("    AND    BK.RCV_TERM_CD = @[rcv_term_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${de_term_cd} != '')" ).append("\n"); 
		query.append("    AND    BK.DE_TERM_CD = @[de_term_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("    AND    BK.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("TRS AS(" ).append("\n"); 
		query.append(" SELECT  DISTINCT " ).append("\n"); 
		query.append("        BKG.BKG_NO," ).append("\n"); 
		query.append("		BKG.RCV_TERM_CD," ).append("\n"); 
		query.append("		BKG.DE_TERM_CD, " ).append("\n"); 
		query.append("		BKG.SVC_SCP_CD," ).append("\n"); 
		query.append("		BKG.POR_CD," ).append("\n"); 
		query.append("		BKG.POL_CD," ).append("\n"); 
		query.append("		BKG.POD_CD," ).append("\n"); 
		query.append("		BKG.DEL_CD," ).append("\n"); 
		query.append("		BKG.CTRT_NO," ).append("\n"); 
		query.append("		BKG.RAT_UT_CD," ).append("\n"); 
		query.append("		BKG.CURR_CD," ).append("\n"); 
		query.append("		BKG.CHG_AMT," ).append("\n"); 
		query.append("		SO.BKG_NO TRS_BKG_NO," ).append("\n"); 
		query.append("		SO.EQ_TPSZ_CD," ).append("\n"); 
		query.append("		SO.EQ_NO," ).append("\n"); 
		query.append("		(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("           FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("          WHERE INTG_CD_ID = 'CD00594'" ).append("\n"); 
		query.append("            AND INTG_CD_VAL_CTNT = SO.TRSP_COST_DTL_MOD_CD) TRSP_COST_DTL_MOD," ).append("\n"); 
		query.append("		WK.WO_RMK," ).append("\n"); 
		query.append("		TO_CHAR(WK.LOCL_CRE_DT, 'YYYY-MM-DD HH24:MI:SS') LOCL_CRE_DT," ).append("\n"); 
		query.append("		WK.TRSP_WO_OFC_CTY_CD||WK.TRSP_WO_SEQ WO_NO," ).append("\n"); 
		query.append("        SO.TRSP_CRR_MOD_CD," ).append("\n"); 
		query.append("        SO.FM_NOD_CD," ).append("\n"); 
		query.append("        SO.TO_NOD_CD" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("FROM    TRS_TRSP_SVC_ORD SO," ).append("\n"); 
		query.append("		TRS_TRSP_WRK_ORD WK," ).append("\n"); 
		query.append("		BKG" ).append("\n"); 
		query.append("WHERE SO.TRSP_WO_OFC_CTY_CD = WK.TRSP_WO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND   SO.TRSP_WO_SEQ = WK.TRSP_WO_SEQ(+)" ).append("\n"); 
		query.append("--AND   SO.TRSP_COST_DTL_MOD_CD(+) = 'LS'" ).append("\n"); 
		query.append("AND   SO.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("AND   BKG.BKG_NO = SO.BKG_NO(+)" ).append("\n"); 
		query.append("AND   BKG.CNTR_NO = SO.EQ_NO(+)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  DISTINCT " ).append("\n"); 
		query.append("        TRS.BKG_NO," ).append("\n"); 
		query.append("		TRS.RCV_TERM_CD," ).append("\n"); 
		query.append("		TRS.DE_TERM_CD, " ).append("\n"); 
		query.append("		TRS.SVC_SCP_CD," ).append("\n"); 
		query.append("		TRS.POR_CD," ).append("\n"); 
		query.append("		TRS.POL_CD," ).append("\n"); 
		query.append("		TRS.POD_CD," ).append("\n"); 
		query.append("		TRS.DEL_CD," ).append("\n"); 
		query.append("		TRS.CTRT_NO," ).append("\n"); 
		query.append("		TRS.RAT_UT_CD," ).append("\n"); 
		query.append("		TRS.CURR_CD," ).append("\n"); 
		query.append("		TRS.CHG_AMT," ).append("\n"); 
		query.append("		TRS.TRS_BKG_NO," ).append("\n"); 
		query.append("		TRS.EQ_TPSZ_CD," ).append("\n"); 
		query.append("		TRS.EQ_NO," ).append("\n"); 
		query.append("		TRS.TRSP_COST_DTL_MOD," ).append("\n"); 
		query.append("        TRS.TRSP_CRR_MOD_CD," ).append("\n"); 
		query.append("        TRS.FM_NOD_CD," ).append("\n"); 
		query.append("        TRS.TO_NOD_CD," ).append("\n"); 
		query.append("		TRS.WO_RMK," ).append("\n"); 
		query.append("		TRS.LOCL_CRE_DT," ).append("\n"); 
		query.append("		TRS.WO_NO," ).append("\n"); 
		query.append("		TPB.TPB_BKG_NO," ).append("\n"); 
		query.append("		TPB.MAIN," ).append("\n"); 
		query.append("		TPB.SUB," ).append("\n"); 
		query.append("		TPB.N3PTY_NO," ).append("\n"); 
		query.append("		TPB.CFM_CURR_CD," ).append("\n"); 
		query.append("		TPB.INV_AMT," ).append("\n"); 
		query.append("		COUNT(DISTINCT TRS.BKG_NO) OVER () AS  BKG_CNT  " ).append("\n"); 
		query.append("FROM    " ).append("\n"); 
		query.append("        TRS," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("			SELECT  DISTINCT" ).append("\n"); 
		query.append("			        TOD.BKG_NO TPB_BKG_NO," ).append("\n"); 
		query.append("			        TOD.N3PTY_EXPN_TP_CD MAIN," ).append("\n"); 
		query.append("			        TPB_GET_N3PTY_BIL_TP_NM_FNC(TOD.N3PTY_BIL_TP_CD) SUB," ).append("\n"); 
		query.append("			        TOG.N3PTY_NO," ).append("\n"); 
		query.append("			        DECODE(TOD.INV_AMT,NULL,'',TOD.CFM_CURR_CD) AS CFM_CURR_CD," ).append("\n"); 
		query.append("			        NVL(TOD.INV_AMT,0) INV_AMT," ).append("\n"); 
		query.append("					TOD.EQ_NO     " ).append("\n"); 
		query.append("			FROM    TPB_OTS_GRP TOG," ).append("\n"); 
		query.append("			        TPB_OTS_DTL TOD," ).append("\n"); 
		query.append("					TRS" ).append("\n"); 
		query.append("			WHERE   1=1" ).append("\n"); 
		query.append("			AND     TOG.N3PTY_NO = TOD.N3PTY_NO" ).append("\n"); 
		query.append("			AND		TOD.BKG_NO(+) = TRS.BKG_NO" ).append("\n"); 
		query.append("			AND     TOD.IF_RHQ_CD='NYCRA' " ).append("\n"); 
		query.append("			AND     TOD.N3PTY_NO IS NOT NULL " ).append("\n"); 
		query.append("			AND     TOD.N3PTY_DELT_TP_CD ='N'" ).append("\n"); 
		query.append("			AND     TOD.N3PTY_BIL_TP_CD = 'OW'  --OVER WEIGHT" ).append("\n"); 
		query.append("		) TPB" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     TRS.BKG_NO = TPB.TPB_BKG_NO(+)" ).append("\n"); 
		query.append("AND     TRS.EQ_NO  = TPB.EQ_NO(+)" ).append("\n"); 
		query.append("ORDER BY TRS.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("-- Work Order Issue Date" ).append("\n"); 
		query.append("WITH TRS_BKG  AS(" ).append("\n"); 
		query.append("SELECT DISTINCT SO.BKG_NO TRS_BKG_NO," ).append("\n"); 
		query.append("       SO.EQ_TPSZ_CD," ).append("\n"); 
		query.append("       SO.EQ_NO," ).append("\n"); 
		query.append("       WK.WO_RMK," ).append("\n"); 
		query.append("	   TO_CHAR(WK.LOCL_CRE_DT, 'YYYY-MM-DD HH24:MI:SS') LOCL_CRE_DT," ).append("\n"); 
		query.append("       WK.TRSP_WO_OFC_CTY_CD||WK.TRSP_WO_SEQ WO_NO," ).append("\n"); 
		query.append("      (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("         FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE INTG_CD_ID = 'CD00594'" ).append("\n"); 
		query.append("          AND INTG_CD_VAL_CTNT = SO.TRSP_COST_DTL_MOD_CD) TRSP_COST_DTL_MOD," ).append("\n"); 
		query.append("      SO.TRSP_CRR_MOD_CD," ).append("\n"); 
		query.append("      SO.FM_NOD_CD," ).append("\n"); 
		query.append("      SO.TO_NOD_CD," ).append("\n"); 
		query.append("      BK.RCV_TERM_CD," ).append("\n"); 
		query.append("      BK.DE_TERM_CD," ).append("\n"); 
		query.append("      BK.POR_CD," ).append("\n"); 
		query.append("      BK.POL_CD," ).append("\n"); 
		query.append("      BK.POD_CD," ).append("\n"); 
		query.append("      BK.DEL_CD," ).append("\n"); 
		query.append("      BK.SVC_SCP_CD," ).append("\n"); 
		query.append("      DECODE(RT.BKG_CTRT_TP_CD, 'S', BK.SC_NO, 'R', BK.RFA_NO, BK.TAA_NO) CTRT_NO" ).append("\n"); 
		query.append("FROM   TRS_TRSP_SVC_ORD SO," ).append("\n"); 
		query.append("       TRS_TRSP_WRK_ORD WK," ).append("\n"); 
		query.append("       BKG_BOOKING BK," ).append("\n"); 
		query.append("       BKG_CONTAINER CON," ).append("\n"); 
		query.append("       BKG_RATE RT" ).append("\n"); 
		query.append("WHERE SO.TRSP_WO_OFC_CTY_CD =WK.TRSP_WO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND   SO.TRSP_WO_SEQ = WK.TRSP_WO_SEQ(+)" ).append("\n"); 
		query.append("--AND   SO.TRSP_COST_DTL_MOD_CD = 'LS'" ).append("\n"); 
		query.append("AND   SO.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND   SO.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("AND   BK.BKG_NO = CON.BKG_NO" ).append("\n"); 
		query.append("AND   BK.BKG_NO = RT.BKG_NO" ).append("\n"); 
		query.append("AND   CON.CNTR_NO = SO.EQ_NO" ).append("\n"); 
		query.append("AND   WK.LOCL_CRE_DT BETWEEN TO_DATE(REPLACE(@[from_dt],'-',''),'YYYY-MM-DD') AND TO_DATE(REPLACE(@[to_dt],'-',''),'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("AND   BK.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    (BK.POL_CD IN ('USLAX','USLGB') AND BK.POL_CD != BK.POR_CD" ).append("\n"); 
		query.append(" OR     BK.POD_CD IN ('USLAX','USLGB') AND BK.POD_CD != BK.DEL_CD)" ).append("\n"); 
		query.append("AND    CON.CNTR_TPSZ_CD like '%2'" ).append("\n"); 
		query.append("AND    CON.CNTR_WGT >= DECODE(CON.WGT_UT_CD,'KGS',17240,'LBS',38007.694, 17240)" ).append("\n"); 
		query.append("#if (${rcv_term_cd} != '')" ).append("\n"); 
		query.append("AND    BK.RCV_TERM_CD = @[rcv_term_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${de_term_cd} != '')" ).append("\n"); 
		query.append("AND    BK.DE_TERM_CD = @[de_term_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("CHG AS (" ).append("\n"); 
		query.append("      SELECT TRS_BKG.*," ).append("\n"); 
		query.append("             CHG.RAT_UT_CD," ).append("\n"); 
		query.append("             CHG.CURR_CD," ).append("\n"); 
		query.append("             CHG.CHG_AMT" ).append("\n"); 
		query.append("        FROM TRS_BKG" ).append("\n"); 
		query.append("            ,BKG_CHG_RT CHG" ).append("\n"); 
		query.append("       WHERE TRS_BKG.TRS_BKG_NO = CHG.BKG_NO(+)" ).append("\n"); 
		query.append("         AND CHG.CHG_CD(+) = 'WSC'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  DISTINCT " ).append("\n"); 
		query.append("        CHG.TRS_BKG_NO AS BKG_NO," ).append("\n"); 
		query.append("		CHG.RCV_TERM_CD," ).append("\n"); 
		query.append("		CHG.DE_TERM_CD, " ).append("\n"); 
		query.append("		CHG.SVC_SCP_CD," ).append("\n"); 
		query.append("		CHG.POR_CD," ).append("\n"); 
		query.append("		CHG.POL_CD," ).append("\n"); 
		query.append("		CHG.POD_CD," ).append("\n"); 
		query.append("		CHG.DEL_CD," ).append("\n"); 
		query.append("		CHG.CTRT_NO," ).append("\n"); 
		query.append("		CHG.RAT_UT_CD," ).append("\n"); 
		query.append("		CHG.CURR_CD," ).append("\n"); 
		query.append("		CHG.CHG_AMT," ).append("\n"); 
		query.append("		CHG.TRS_BKG_NO," ).append("\n"); 
		query.append("		CHG.EQ_TPSZ_CD," ).append("\n"); 
		query.append("		CHG.EQ_NO," ).append("\n"); 
		query.append("		CHG.TRSP_COST_DTL_MOD," ).append("\n"); 
		query.append("        CHG.TRSP_CRR_MOD_CD," ).append("\n"); 
		query.append("        CHG.FM_NOD_CD," ).append("\n"); 
		query.append("        CHG.TO_NOD_CD," ).append("\n"); 
		query.append("		CHG.WO_RMK," ).append("\n"); 
		query.append("		CHG.LOCL_CRE_DT," ).append("\n"); 
		query.append("		CHG.WO_NO," ).append("\n"); 
		query.append("		TPB.TPB_BKG_NO," ).append("\n"); 
		query.append("		TPB.MAIN," ).append("\n"); 
		query.append("		TPB.SUB," ).append("\n"); 
		query.append("		TPB.N3PTY_NO," ).append("\n"); 
		query.append("		TPB.CFM_CURR_CD," ).append("\n"); 
		query.append("		TPB.INV_AMT," ).append("\n"); 
		query.append("		COUNT(DISTINCT CHG.TRS_BKG_NO) OVER () AS  BKG_CNT  " ).append("\n"); 
		query.append("FROM    CHG," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("			SELECT  TOD.BKG_NO TPB_BKG_NO," ).append("\n"); 
		query.append("			        TOD.N3PTY_EXPN_TP_CD MAIN," ).append("\n"); 
		query.append("			        TPB_GET_N3PTY_BIL_TP_NM_FNC(TOD.N3PTY_BIL_TP_CD) SUB," ).append("\n"); 
		query.append("			        TOG.N3PTY_NO," ).append("\n"); 
		query.append("			        TOD.CFM_CURR_CD," ).append("\n"); 
		query.append("			        TOD.INV_AMT," ).append("\n"); 
		query.append("					TOD.EQ_NO     " ).append("\n"); 
		query.append("			FROM    TPB_OTS_GRP TOG," ).append("\n"); 
		query.append("			        TPB_OTS_DTL TOD," ).append("\n"); 
		query.append("					CHG" ).append("\n"); 
		query.append("			WHERE   1=1" ).append("\n"); 
		query.append("			AND     TOG.N3PTY_NO = TOD.N3PTY_NO" ).append("\n"); 
		query.append("			AND     TOD.IF_RHQ_CD='NYCRA' " ).append("\n"); 
		query.append("			AND     TOD.N3PTY_NO IS NOT NULL " ).append("\n"); 
		query.append("			AND     TOD.N3PTY_DELT_TP_CD ='N'" ).append("\n"); 
		query.append("			AND     TOD.N3PTY_BIL_TP_CD = 'OW'  --Over Weight" ).append("\n"); 
		query.append("			AND     TOD.BKG_NO = CHG.TRS_BKG_NO" ).append("\n"); 
		query.append("		) TPB" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     CHG.TRS_BKG_NO = TPB.TPB_BKG_NO(+)" ).append("\n"); 
		query.append("AND     CHG.EQ_NO  = TPB.EQ_NO(+)" ).append("\n"); 
		query.append("ORDER BY CHG.TRS_BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}