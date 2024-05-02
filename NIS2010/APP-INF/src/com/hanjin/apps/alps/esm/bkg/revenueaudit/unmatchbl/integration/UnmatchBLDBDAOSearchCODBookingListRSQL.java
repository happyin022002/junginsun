/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UnmatchBLDBDAOSearchCODBookingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.18 
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

public class UnmatchBLDBDAOSearchCODBookingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COD BKG List를 조회한다.
	  * </pre>
	  */
	public UnmatchBLDBDAOSearchCODBookingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cod_rqst_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOSearchCODBookingListRSQL").append("\n"); 
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
		query.append("SELECT DENSE_RANK() OVER(ORDER BY B.BKG_NO, B.BL_NO) SEQ," ).append("\n"); 
		query.append("       O.REGION RHQ_CD, B.BKG_OFC_CD, B.SVC_SCP_CD, B.BKG_NO, B.BL_NO, D.BDR_FLG, " ).append("\n"); 
		query.append("       TO_CHAR(R.RT_APLY_DT,'YYYYMMDD') RT_APLY_DT, TO_CHAR(V.VPS_ETD_DT,'YYYYMMDD') VPS_ETD_DT," ).append("\n"); 
		query.append("       DECODE(R.BKG_CTRT_TP_CD, 'S', B.SC_NO, 'R', B.RFA_NO, 'T', B.TAA_NO) CTRT_NO, " ).append("\n"); 
		query.append("       DECODE(N.RDN_NO,NULL,' ',N.RDN_NO) RDN_NO, ' ' SELF_AUDIT," ).append("\n"); 
		query.append("       N.RVIS_SEQ, C.COD_RQST_SEQ," ).append("\n"); 
		query.append("       C.OLD_POR_YD_CD, C.OLD_POL_YD_CD, C.OLD_POD_YD_CD, C.OLD_DEL_YD_CD, " ).append("\n"); 
		query.append("       C.NEW_POR_YD_CD, C.NEW_POL_YD_CD, C.NEW_POD_YD_CD, C.NEW_DEL_YD_CD," ).append("\n"); 
		query.append("       NVL(SUM(OFT.CHG_AMT),0) OFT_AMT, NVL(OFT.RAT_UT_CD,' ') OFT_RAT_UT_CD, NVL(OFT.CURR_CD,' ') OFT_CURR_CD," ).append("\n"); 
		query.append("       NVL(SUM(DVC.CHG_AMT),0) DVC_AMT, NVL(DVC.RAT_UT_CD,' ') DVC_RAT_UT_CD, NVL(DVC.CURR_CD,' ') DVC_CURR_CD," ).append("\n"); 
		query.append("       NVL(COD.CHG_CD,' ') COD_CHG_CD, NVL(SUM(COD.CHG_AMT),0) COD_AMT, NVL(COD.RAT_UT_CD,' ') COD_RAT_UT_CD, NVL(COD.CURR_CD,' ') COD_CURR_CD," ).append("\n"); 
		query.append("       COUNT (DISTINCT B.BKG_NO) OVER (PARTITION BY 1) BL_CNT," ).append("\n"); 
		query.append("       (SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("	    FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("		WHERE INTG_CD_ID = 'CD01716'" ).append("\n"); 
		query.append("		AND INTG_CD_VAL_CTNT = BKG_CTRT_TP_CD) BKG_CTRT_TP_CD, " ).append("\n"); 
		query.append("       (SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("	    FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("		WHERE INTG_CD_ID = 'CD02153'" ).append("\n"); 
		query.append("		AND INTG_CD_VAL_CTNT = COD_RQST_RSN_CD) COD_RQST_RSN_CD, " ).append("\n"); 
		query.append("       NVL((SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("	    FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("		WHERE INTG_CD_ID = 'CD01568'" ).append("\n"); 
		query.append("		AND INTG_CD_VAL_CTNT = RDN_STS_CD),' ') RDN_STS_NM, " ).append("\n"); 
		query.append("       NVL((SELECT  UMCH_RSN_RMK  " ).append("\n"); 
		query.append("        FROM BKG_REV_AUD_RSLT UB " ).append("\n"); 
		query.append("        WHERE UB.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("        AND UB.BKG_REV_AUD_TP_CD='C' " ).append("\n"); 
		query.append("        ),' ') UMCH_RSN_RMK," ).append("\n"); 
		query.append("       NVL(( SELECT RGN_GRP_AVC_RMK " ).append("\n"); 
		query.append("         FROM BKG_REV_AUD_RSLT UB " ).append("\n"); 
		query.append("        WHERE UB.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("         AND UB.BKG_REV_AUD_TP_CD='C'" ).append("\n"); 
		query.append("        ),' ') RGN_GRP_AVC_RMK" ).append("\n"); 
		query.append("FROM BKG_BOOKING B, BKG_RATE R, BKG_COD C, BKG_BL_DOC D, BKG_OFC_LVL_V O," ).append("\n"); 
		query.append("     BKG_VVD BV, VSK_VSL_PORT_SKD V, BKG_REV_DR_NOTE N, BKG_CHG_RT OFT, BKG_CHG_RT DVC, BKG_COD_COST COD" ).append("\n"); 
		query.append("WHERE B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND B.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("AND R.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("#if (${date_type} == 'B')" ).append("\n"); 
		query.append("AND B.BKG_CRE_DT BETWEEN TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#elseif (${date_type} == 'A')" ).append("\n"); 
		query.append("AND R.RT_APLY_DT BETWEEN TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#elseif (${date_type} == 'E')" ).append("\n"); 
		query.append("AND V.VPS_ETD_DT BETWEEN TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND C.COD_RQST_SEQ = (SELECT MAX (COD_RQST_SEQ) FROM BKG_COD WHERE BKG_NO = C.BKG_NO)" ).append("\n"); 
		query.append("AND C.COD_STS_CD = 'F'" ).append("\n"); 
		query.append("AND B.BKG_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("AND O.REGION = NVL(@[rhq_cd], O.REGION)" ).append("\n"); 
		query.append("AND B.BKG_OFC_CD = NVL(@[bkg_ofc_cd], B.BKG_OFC_CD)" ).append("\n"); 
		query.append("AND B.SVC_SCP_CD = NVL(@[svc_scp_cd], B.SVC_SCP_CD)" ).append("\n"); 
		query.append("AND R.BKG_CTRT_TP_CD = NVL(@[bkg_ctrt_tp_cd], R.BKG_CTRT_TP_CD)" ).append("\n"); 
		query.append("AND C.COD_RQST_RSN_CD = NVL(@[cod_rqst_rsn_cd], C.COD_RQST_RSN_CD)" ).append("\n"); 
		query.append("AND D.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("AND B.POL_CD = BV.POL_CD" ).append("\n"); 
		query.append("AND BV.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("AND BV.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("AND BV.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("AND BV.POL_CD = V.VPS_PORT_CD" ).append("\n"); 
		query.append("AND BV.POL_YD_CD = V.YD_CD" ).append("\n"); 
		query.append("AND BV.POL_CLPT_IND_SEQ = V.CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND C.BKG_NO = N.BKG_NO(+)" ).append("\n"); 
		query.append("AND (N.RVIS_SEQ = (SELECT MAX(RVIS_SEQ) FROM BKG_REV_DR_NOTE WHERE BKG_NO = C.BKG_NO)" ).append("\n"); 
		query.append("    OR N.RVIS_SEQ IS NULL)" ).append("\n"); 
		query.append("AND C.BKG_NO = OFT.BKG_NO(+)" ).append("\n"); 
		query.append("AND OFT.CHG_CD(+) = 'OFT'" ).append("\n"); 
		query.append("AND C.BKG_NO = DVC.BKG_NO(+)" ).append("\n"); 
		query.append("AND DVC.CHG_CD(+) = 'DVC'" ).append("\n"); 
		query.append("AND C.BKG_NO = COD.BKG_NO(+)" ).append("\n"); 
		query.append("AND C.COD_RQST_SEQ = COD.COD_RQST_SEQ(+)" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("		OFT.RAT_UT_CD = COD.RAT_UT_CD" ).append("\n"); 
		query.append("	OR	COD.RAT_UT_CD IS NULL" ).append("\n"); 
		query.append("	OR  OFT.RAT_UT_CD  IN ( 'BX', 'BL' ) " ).append("\n"); 
		query.append("	OR  COD.RAT_UT_CD  IN ( 'BX', 'BL' ) " ).append("\n"); 
		query.append("	OR (	( SELECT A.CNTR_SZ_CD FROM PRI_RAT_UT A WHERE A.RAT_UT_CD = OFT.RAT_UT_CD )" ).append("\n"); 
		query.append("		=	( SELECT A.CNTR_SZ_CD FROM PRI_RAT_UT A WHERE A.RAT_UT_CD = COD.RAT_UT_CD )" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("GROUP BY O.REGION, B.BKG_OFC_CD, B.SVC_SCP_CD, B.BKG_NO, B.BL_NO, D.BDR_FLG, R.RT_APLY_DT, V.VPS_ETD_DT," ).append("\n"); 
		query.append("       R.BKG_CTRT_TP_CD, DECODE(R.BKG_CTRT_TP_CD, 'S', B.SC_NO, 'R', B.RFA_NO, 'T', B.TAA_NO), " ).append("\n"); 
		query.append("       N.RDN_NO, N.RDN_STS_CD, C.COD_RQST_RSN_CD, C.COD_RQST_SEQ, N.RVIS_SEQ," ).append("\n"); 
		query.append("       C.OLD_POR_YD_CD, C.OLD_POL_YD_CD, C.OLD_POD_YD_CD, C.OLD_DEL_YD_CD, " ).append("\n"); 
		query.append("       C.NEW_POR_YD_CD, C.NEW_POL_YD_CD, C.NEW_POD_YD_CD, C.NEW_DEL_YD_CD," ).append("\n"); 
		query.append("       OFT.RAT_UT_CD, OFT.CURR_CD, DVC.RAT_UT_CD, DVC.CURR_CD, COD.RAT_UT_CD, COD.CURR_CD, COD.CHG_CD" ).append("\n"); 

	}
}