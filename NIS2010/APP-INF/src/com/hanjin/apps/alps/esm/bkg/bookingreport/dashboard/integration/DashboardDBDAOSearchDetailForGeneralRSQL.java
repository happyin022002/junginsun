/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : DashboardDBDAOSearchDetailForGeneralRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DashboardDBDAOSearchDetailForGeneralRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * General Detail 항목을 조회한다.
	  * </pre>
	  */
	public DashboardDBDAOSearchDetailForGeneralRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rep_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dbd_cre_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo_gcust",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pod_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_staff_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pol_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dbd_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_irr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo_cust",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_gcust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dest_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.integration").append("\n"); 
		query.append("FileName : DashboardDBDAOSearchDetailForGeneralRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("  A.BKG_NO" ).append("\n"); 
		query.append(", (SELECT C.CUST_CNT_CD||C.CUST_SEQ FROM BKG_CUSTOMER C WHERE A.BKG_NO = C.BKG_NO AND BKG_CUST_TP_CD='S' AND ROWNUM=1) AS SHRP" ).append("\n"); 
		query.append(", (SELECT C.CUST_CNT_CD||C.CUST_SEQ FROM BKG_CUSTOMER C WHERE A.BKG_NO = C.BKG_NO AND BKG_CUST_TP_CD='N' AND ROWNUM=1) AS NTFY" ).append("\n"); 
		query.append(", (SELECT C.CUST_CNT_CD||C.CUST_SEQ FROM BKG_CUSTOMER C WHERE A.BKG_NO = C.BKG_NO AND BKG_CUST_TP_CD='C' AND ROWNUM=1) AS CNEE" ).append("\n"); 
		query.append(", B.POR_NOD_CD" ).append("\n"); 
		query.append(", B.POL_NOD_CD" ).append("\n"); 
		query.append(", B.POD_NOD_CD" ).append("\n"); 
		query.append(", B.DEL_NOD_CD" ).append("\n"); 
		query.append(", B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD T_VVD" ).append("\n"); 
		query.append(", COALESCE(B.SC_NO, B.RFA_NO, B.TAA_NO) CTRT_NO" ).append("\n"); 
		query.append(", (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD00769' AND INTG_CD_VAL_CTNT = B.BKG_STS_CD) BKG_STS_CD" ).append("\n"); 
		query.append(", (SELECT CRNT_YD_CD FROM MST_CONTAINER M, BKG_CONTAINER C WHERE A.BKG_NO=C.BKG_NO AND C.CNTR_NO = M.CNTR_NO AND ROWNUM=1)  CRNT_YD_CD" ).append("\n"); 
		query.append(", (SELECT /*+ INDEX(B XAK6SCE_COP_DTL) */ MAX(TRUNC(SYSDATE - L.ACT_DT))" ).append("\n"); 
		query.append("     FROM SCE_COP_HDR H, SCE_COP_DTL L WHERE 1=1" ).append("\n"); 
		query.append("      AND A.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("      AND H.COP_NO = L.COP_NO" ).append("\n"); 
		query.append("      AND L.ACT_CD ='FLVMLO'" ).append("\n"); 
		query.append("      AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("      AND L.ACT_DT IS NOT NULL ) ACCR_DT" ).append("\n"); 
		query.append(", ( SELECT " ).append("\n"); 
		query.append("    TO_CHAR(NVL(H.MNL_SET_DT, H.SYS_SET_DT), 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("    FROM BKG_CLZ_TM H" ).append("\n"); 
		query.append("    WHERE A.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("      AND H.CLZ_TP_CD = 'T' ) AS POL_CCT" ).append("\n"); 
		query.append(", ( SELECT " ).append("\n"); 
		query.append("    TO_CHAR(NVL(H.MNL_SET_DT, H.SYS_SET_DT), 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("    FROM BKG_CLZ_TM H" ).append("\n"); 
		query.append("    WHERE A.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("      AND H.CLZ_TP_CD = 'D' ) AS POL_DCT" ).append("\n"); 
		query.append(", TO_CHAR(B.PORT_CLZ_DT, 'YYYY-MM-DD HH24:MI:SS') PORT_CLZ_DT" ).append("\n"); 
		query.append(", ( SELECT TO_CHAR(H.BDR_DT, 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("      FROM BKG_BL_DOC H" ).append("\n"); 
		query.append("     WHERE A.BKG_NO = H.BKG_NO ) AS BDR_DT" ).append("\n"); 
		query.append(", ( SELECT /*+ INDEX_DESC(VVD XPKBKG_VVD) */ TO_CHAR(SKD.VPS_ETA_DT, 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("      FROM BKG_VVD VVD, VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND A.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("       AND B.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("       AND VVD.VSL_CD = SKD.VSL_CD " ).append("\n"); 
		query.append("       AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND VVD.POL_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("       AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("       AND VSL_PRE_PST_CD IN ('S','T')" ).append("\n"); 
		query.append("       AND ROWNUM=1 ) AS POL_ETA_DT" ).append("\n"); 
		query.append(", ( SELECT /*+ INDEX_DESC(VVD XPKBKG_VVD) */ TO_CHAR(SKD.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("      FROM BKG_VVD VVD, VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND A.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("       AND B.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("       AND VVD.VSL_CD = SKD.VSL_CD " ).append("\n"); 
		query.append("       AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND VVD.POL_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("       AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("       AND VSL_PRE_PST_CD IN ('S','T')" ).append("\n"); 
		query.append("       AND ROWNUM=1 ) AS POL_ETD_DT" ).append("\n"); 
		query.append(", ( SELECT /*+ INDEX_ASC(VVD XPKBKG_VVD) */ TO_CHAR(SKD.VPS_ETA_DT, 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("      FROM BKG_VVD VVD, VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND A.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("       AND B.POD_CD = VVD.POD_CD" ).append("\n"); 
		query.append("       AND VVD.VSL_CD = SKD.VSL_CD " ).append("\n"); 
		query.append("       AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND VVD.POD_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("       AND VVD.POD_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("       AND VSL_PRE_PST_CD IN ('T','U')" ).append("\n"); 
		query.append("       AND ROWNUM=1 ) AS POD_ETA_DT" ).append("\n"); 
		query.append(", ( SELECT /*+ INDEX_ASC(VVD XPKBKG_VVD) */ TO_CHAR(SKD.ACT_ARR_DT, 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("      FROM BKG_VVD VVD, VSK_ACT_PORT_SKD SKD" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND A.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("       AND B.POD_CD = VVD.POD_CD" ).append("\n"); 
		query.append("       AND VVD.VSL_CD = SKD.VSL_CD " ).append("\n"); 
		query.append("       AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND VVD.POD_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("       AND VVD.POD_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("       AND VSL_PRE_PST_CD IN ('T','U')" ).append("\n"); 
		query.append("       AND SKD.PORT_SKD_STS_CD = 'A'" ).append("\n"); 
		query.append("       AND ROWNUM=1 ) AS POD_ATA_DT" ).append("\n"); 
		query.append("#if (${f_irr_tp_cd} == 'vsl_skd')" ).append("\n"); 
		query.append(", ( SELECT ROUND(MAX((SYSDATE-D.ACT_DT)),1) MAX_TM FROM SCE_COP_HDR H, SCE_COP_DTL D WHERE 1=1 " ).append("\n"); 
		query.append("       AND A.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("       AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("       AND H.CNTR_NO <> 'SMCU0000000'" ).append("\n"); 
		query.append("       AND H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("       AND D.ACT_CD = 'FLVMLO' ) VSL_SKD" ).append("\n"); 
		query.append("#elseif(${f_irr_tp_cd} == 'dwl_ntfc')" ).append("\n"); 
		query.append(", ( SELECT DWLL_TM_TP_CD FROM SCE_DWLL_NTFC_EML_SND_RSLT N WHERE 1=1" ).append("\n"); 
		query.append("       AND N.EML_SND_DT = @[f_dbd_cre_dt]" ).append("\n"); 
		query.append("       AND N.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("       AND ROWNUM=1 ) DWL_NTFC" ).append("\n"); 
		query.append("#elseif(${f_irr_tp_cd} == 'port_skip')" ).append("\n"); 
		query.append(", ( SELECT   COALESCE(V.POL_CD, V.POD_CD) AS PORT" ).append("\n"); 
		query.append("    FROM     BKG_VVD V, VSK_VSL_PORT_SKD  PSL, VSK_VSL_PORT_SKD  PSD" ).append("\n"); 
		query.append("    WHERE    1 = 1" ).append("\n"); 
		query.append("    AND      A.BKG_NO           = V.BKG_NO" ).append("\n"); 
		query.append("    AND      PSL.SKD_CNG_STS_CD = 'S'" ).append("\n"); 
		query.append("    AND      PSL.VSL_CD         = V.VSL_CD" ).append("\n"); 
		query.append("    AND      PSL.SKD_VOY_NO     = V.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND      PSL.SKD_DIR_CD     = V.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND      PSL.VPS_PORT_CD    = V.POL_CD " ).append("\n"); 
		query.append("    AND      PSL.CLPT_IND_SEQ   = V.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("    AND      PSD.SKD_CNG_STS_CD = 'S'" ).append("\n"); 
		query.append("    AND      PSD.VSL_CD         = V.VSL_CD" ).append("\n"); 
		query.append("    AND      PSD.SKD_VOY_NO     = V.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND      PSD.SKD_DIR_CD     = V.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND      PSD.VPS_PORT_CD    = V.POD_CD " ).append("\n"); 
		query.append("    AND      PSD.CLPT_IND_SEQ   = V.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("    AND      ROWNUM = 1 ) PORT_SKIP" ).append("\n"); 
		query.append("#elseif(${f_irr_tp_cd} == 'obl_rls')" ).append("\n"); 
		query.append(", (SELECT MAX(TO_CHAR(M.CNMV_EVNT_DT,'YYYY-MM-DD HH24:MI:SS')) FROM BKG_CONTAINER N, CTM_MOVEMENT M" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("      AND A.BKG_NO = N.BKG_NO" ).append("\n"); 
		query.append("      AND N.CNTR_NO = M.CNTR_NO" ).append("\n"); 
		query.append("      AND N.CNMV_YR = M.CNMV_YR" ).append("\n"); 
		query.append("      AND N.CNMV_CYC_NO = M.CNMV_CYC_NO" ).append("\n"); 
		query.append("      AND M.MVMT_STS_CD ='VD' ) OBL_RLS" ).append("\n"); 
		query.append("#elseif(${f_irr_tp_cd} == 'rate')" ).append("\n"); 
		query.append(", (SELECT TO_CHAR(B.PORT_CLZ_DT,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("     FROM BKG_RATE R" ).append("\n"); 
		query.append("    WHERE R.RT_CHK_RSLT_CD = 'F'" ).append("\n"); 
		query.append("      AND R.BKG_NO = B.BKG_NO ) RATE" ).append("\n"); 
		query.append("#elseif(${f_irr_tp_cd} == 'cod')" ).append("\n"); 
		query.append(", (SELECT /*+ INDEX_DESC(COD XPKBKG_COD) */ CD.INTG_CD_VAL_DESC " ).append("\n"); 
		query.append("     FROM BKG_COD COD, COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("    WHERE COD.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("      AND CD.INTG_CD_ID = 'CD02153'" ).append("\n"); 
		query.append("      AND CD.INTG_CD_VAL_CTNT = COD.COD_RQST_RSN_CD" ).append("\n"); 
		query.append("      AND ROWNUM = 1) COD" ).append("\n"); 
		query.append("#elseif(${f_irr_tp_cd} == 'vsl_skd_dly_ntc')" ).append("\n"); 
		query.append(", NVL(  (SELECT DISTINCT 'Y'" ).append("\n"); 
		query.append("              FROM BKG_VVD VVD, VSK_VSL_SKD_HIS VSL" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("               AND A.BKG_NO            = VVD.BKG_NO" ).append("\n"); 
		query.append("               AND VVD.VSL_CD           = VSL.BFR_VSL_CD" ).append("\n"); 
		query.append("               AND VVD.SKD_VOY_NO       = VSL.BFR_SKD_VOY_NO" ).append("\n"); 
		query.append("               AND VVD.SKD_DIR_CD       = VSL.BFR_SKD_DIR_CD" ).append("\n"); 
		query.append("               AND VVD.POD_CD           = VSL.BFR_VPS_PORT_CD" ).append("\n"); 
		query.append("               AND VVD.POD_CLPT_IND_SEQ = VSL.BFR_CLPT_IND_SEQ" ).append("\n"); 
		query.append("               AND VSL.VSKD_CNG_TP_CD   = 'E'" ).append("\n"); 
		query.append("               AND ROUND(VSL.AFT_VPS_ETA_DT - VSL.BFR_VPS_ETA_DT, 10) >= ROUND(1 / 24 * 10, 10) --10시간 이상" ).append("\n"); 
		query.append("           ), 'N') VSL_SKD_DLY_NTC" ).append("\n"); 
		query.append("#elseif(${f_irr_tp_cd} == 'phse_out')" ).append("\n"); 
		query.append(", COALESCE(" ).append("\n"); 
		query.append("     ( SELECT V.POL_CD" ).append("\n"); 
		query.append("         FROM BKG_VVD V" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("          AND A.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("          AND NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                            FROM   VSK_VSL_PORT_SKD   PS" ).append("\n"); 
		query.append("                           WHERE  PS.VSL_CD          = V.VSL_CD" ).append("\n"); 
		query.append("                             AND    PS.SKD_VOY_NO      = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                             AND    PS.SKD_DIR_CD      = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                             AND    PS.VPS_PORT_CD     IN (V.POL_CD, V.POD_CD)" ).append("\n"); 
		query.append("                             AND    PS.CLPT_IND_SEQ = V.POL_CLPT_IND_SEQ))" ).append("\n"); 
		query.append("   ,( SELECT V.POL_CD" ).append("\n"); 
		query.append("         FROM BKG_VVD V" ).append("\n"); 
		query.append("            , VSK_VSL_PORT_SKD  PS" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("          AND A.BKG_NO          = V.BKG_NO        " ).append("\n"); 
		query.append("          AND PS.SKD_CNG_STS_CD = 'O'" ).append("\n"); 
		query.append("          AND PS.VSL_CD         = V.VSL_CD" ).append("\n"); 
		query.append("          AND PS.SKD_VOY_NO     = V.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND PS.SKD_DIR_CD     = V.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND PS.VPS_PORT_CD    = V.POL_CD " ).append("\n"); 
		query.append("          AND PS.CLPT_IND_SEQ   = V.POL_CLPT_IND_SEQ ) ) PHSE_OUT" ).append("\n"); 
		query.append("#elseif(${f_irr_tp_cd} == 'bkg_rcp_ntc')" ).append("\n"); 
		query.append(", TO_CHAR(B.BKG_CRE_DT, 'YYYY-MM-DD HH24:MI:SS') BKG_CRE_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("  BKG_DBD_RPT A" ).append("\n"); 
		query.append(", BKG_BOOKING B" ).append("\n"); 
		query.append(", BKG_DBD_RPT_COL C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("    AND A.DBD_CRE_DT = @[f_dbd_cre_dt]" ).append("\n"); 
		query.append("    AND A.DBD_CRE_SEQ = @[f_dbd_cre_seq]" ).append("\n"); 
		query.append("    AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("    AND B.POD_NOD_CD LIKE @[f_dest_cnt_cd]||'%'" ).append("\n"); 
		query.append("    AND C.RPT_ID = 'DBD1'" ).append("\n"); 
		query.append("    AND C.COL_NM = UPPER(@[f_irr_tp_cd])" ).append("\n"); 
		query.append("    AND C.DBD_IRR_TP_CD = A.DBD_IRR_TP_CD" ).append("\n"); 
		query.append("    AND A.BKG_OFC_CD = @[s_bkg_ofc_cd]" ).append("\n"); 
		query.append("#if (${s_kind} == 'rhq')" ).append("\n"); 
		query.append("	#if (${f_rhq_cd} != '')" ).append("\n"); 
		query.append("	AND A.BKG_OFC_CD IN (SELECT OFC_CD FROM MDM_ORGANIZATION CONNECT BY PRIOR OFC_CD = PRNT_OFC_CD START WITH OFC_CD = @[f_rhq_cd])" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif (${s_kind} == 'ofc')" ).append("\n"); 
		query.append("	#if (${f_sub_bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("	AND A.BKG_OFC_CD IN (${f_sub_bkg_ofc_list})" ).append("\n"); 
		query.append("	#elseif (${f_bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("    AND A.BKG_OFC_CD = @[f_bkg_ofc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif (${s_kind} == 'bkgno')" ).append("\n"); 
		query.append("	#if (${f_bkg_no} != '')" ).append("\n"); 
		query.append("	AND A.BKG_NO = @[f_bkg_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif (${s_kind} == 'cust')" ).append("\n"); 
		query.append("	AND EXISTS (SELECT 'X' FROM BKG_CUSTOMER CU WHERE A.BKG_NO = CU.BKG_NO" ).append("\n"); 
		query.append("	#if (${combo_cust} != 'Z' && ${combo_cust} != '')" ).append("\n"); 
		query.append("                   AND CU.BKG_CUST_TP_CD = @[combo_cust]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${f_cust_cd} != '')" ).append("\n"); 
		query.append("                   AND (CU.CUST_CNT_CD,CU.CUST_SEQ) IN (( SUBSTR(@[f_cust_cd],1,2),SUBSTR(@[f_cust_cd],3) ))" ).append("\n"); 
		query.append("	#end       )" ).append("\n"); 
		query.append("#elseif (${s_kind} == 'gcust')" ).append("\n"); 
		query.append("	AND EXISTS (SELECT 'X' FROM BKG_CUSTOMER CU, MDM_CUSTOMER M WHERE A.BKG_NO = CU.BKG_NO" ).append("\n"); 
		query.append("                   AND CU.CUST_CNT_CD = M.CUST_CNT_CD" ).append("\n"); 
		query.append("                   AND CU.CUST_SEQ = M.CUST_SEQ" ).append("\n"); 
		query.append("	#if (${combo_gcust} != 'Z' && ${combo_gcust} != '')" ).append("\n"); 
		query.append("                   AND CU.BKG_CUST_TP_CD = @[combo_gcust]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${f_gcust_cd} != '')" ).append("\n"); 
		query.append("                   AND M.CUST_GRP_ID = @[f_gcust_cd]" ).append("\n"); 
		query.append("	#end       )" ).append("\n"); 
		query.append("#elseif (${s_kind} == 'ctrt')" ).append("\n"); 
		query.append("	#if (${combo_ctrt} == 'S')" ).append("\n"); 
		query.append("	AND B.SC_NO = @[f_ctrt_no]" ).append("\n"); 
		query.append("	#elseif (${combo_ctrt} == 'R')" ).append("\n"); 
		query.append("    AND B.RFA_NO = @[f_ctrt_no]" ).append("\n"); 
		query.append("	#elseif (${combo_ctrt} == 'T')" ).append("\n"); 
		query.append("    AND B.TAA_NO = @[f_ctrt_no]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("    AND @[f_ctrt_no] IN (B.SC_NO, B.RFA_NO, B.TAA_NO)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_pol_nod_cd} != '')" ).append("\n"); 
		query.append("	AND B.POL_NOD_CD LIKE @[f_pol_nod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_pod_nod_cd} != '')" ).append("\n"); 
		query.append("	AND B.POD_NOD_CD LIKE @[f_pod_nod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_vvd} != '')" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X' FROM BKG_VVD V WHERE 1=1" ).append("\n"); 
		query.append("               AND A.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("               AND (V.VSL_CD,V.SKD_VOY_NO,V.SKD_DIR_CD) IN ((SUBSTR(@[f_vvd],1,4),SUBSTR(@[f_vvd],5,4),SUBSTR(@[f_vvd],9,1)))" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_staff_id} != '')" ).append("\n"); 
		query.append("	AND B.DOC_USR_ID = @[f_staff_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rep_id} != '')" ).append("\n"); 
		query.append("	AND B.OB_SREP_CD = @[f_rep_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}