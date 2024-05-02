/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UnmatchBLDBDAOSearchDiversionCAListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.25 
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

public class UnmatchBLDBDAOSearchDiversionCAListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Merchant Request에 의한 Diversion C/A 목록을 조회한다
	  * </pre>
	  */
	public UnmatchBLDBDAOSearchDiversionCAListRSQL(){
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
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOSearchDiversionCAListRSQL").append("\n"); 
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
		query.append("SELECT DENSE_RANK() OVER(ORDER BY BK.BKG_NO, BK.BL_NO) SEQ," ).append("\n"); 
		query.append("        (SELECT  OFC_CD " ).append("\n"); 
		query.append("         FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("         WHERE DELT_FLG = 'N' " ).append("\n"); 
		query.append("         AND OFC_TP_CD = 'HQ' " ).append("\n"); 
		query.append("         START WITH OFC_CD = BK.BKG_OFC_CD" ).append("\n"); 
		query.append("         CONNECT BY PRIOR PRNT_OFC_CD = OFC_CD) RHQ_CD," ).append("\n"); 
		query.append("       BK.BKG_OFC_CD," ).append("\n"); 
		query.append("       BK.SVC_SCP_CD," ).append("\n"); 
		query.append("       BK.BL_NO||BK.BL_NO_TP||BK.BL_TP_CD BL_NO," ).append("\n"); 
		query.append("       BK.BKG_NO," ).append("\n"); 
		query.append("       BD.BDR_FLG," ).append("\n"); 
		query.append("       TO_CHAR(BR.RT_APLY_DT, 'YYYY-MM-DD')      AS RT_APLY_DT,   " ).append("\n"); 
		query.append("       TO_CHAR(VV.VPS_ETD_DT, 'YYYY-MM-DD')      AS VPS_ETD_DT,       " ).append("\n"); 
		query.append("       (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE INTG_CD_ID ='CD01716'" ).append("\n"); 
		query.append("        AND INTG_CD_VAL_CTNT = BR.BKG_CTRT_TP_CD) BKG_CTRT_TP_CD ," ).append("\n"); 
		query.append("       CASE WHEN BR.BKG_CTRT_TP_CD = 'R' THEN BK.RFA_NO" ).append("\n"); 
		query.append("            WHEN BR.BKG_CTRT_TP_CD = 'S' THEN BK.SC_NO" ).append("\n"); 
		query.append("            WHEN BR.BKG_CTRT_TP_CD = 'T' THEN BK.TAA_NO" ).append("\n"); 
		query.append("       END CTRT_NO," ).append("\n"); 
		query.append("       NEW.CORR_NO NEW_CORR_NO," ).append("\n"); 
		query.append("       OLD.CORR_NO OLD_CORR_NO," ).append("\n"); 
		query.append("       RANK() OVER (PARTITION BY BK.BKG_NO ORDER BY NEW.CORR_DT) CA_SEQ," ).append("\n"); 
		query.append("       NRT.POR_CD NEW_POR_CD," ).append("\n"); 
		query.append("       NRT.POL_CD NEW_POL_CD," ).append("\n"); 
		query.append("       NRT.POD_CD NEW_POD_CD," ).append("\n"); 
		query.append("       NRT.DEL_CD NEW_DEL_CD," ).append("\n"); 
		query.append("       ORT.POR_CD OLD_POR_CD," ).append("\n"); 
		query.append("       ORT.POL_CD OLD_POL_CD," ).append("\n"); 
		query.append("       ORT.POD_CD OLD_POD_CD," ).append("\n"); 
		query.append("       ORT.DEL_CD OLD_DEL_CD," ).append("\n"); 
		query.append("       DVC.CURR_CD    DVC_CURR_CD," ).append("\n"); 
		query.append("       DVC.CHG_UT_AMT DVC_CHG_UT_AMT," ).append("\n"); 
		query.append("       DVC.RAT_AS_QTY DVC_RAT_AS_QTY," ).append("\n"); 
		query.append("       DVC.RAT_UT_CD  DVC_RAT_UT_CD," ).append("\n"); 
		query.append("       DVC.CHG_AMT    DVC_CHG_AMT," ).append("\n"); 
		query.append("       COUNT (DISTINCT BK.BKG_NO) OVER (PARTITION BY 1) BL_CNT," ).append("\n"); 
		query.append("--------------VO 작성용----------------" ).append("\n"); 
		query.append("       '' date_type," ).append("\n"); 
		query.append("       '' fm_dt," ).append("\n"); 
		query.append("       '' to_dt" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK," ).append("\n"); 
		query.append("     BKG_RATE BR," ).append("\n"); 
		query.append("     BKG_BL_DOC BD," ).append("\n"); 
		query.append("     BKG_VVD BV, " ).append("\n"); 
		query.append("     VSK_VSL_PORT_SKD VV," ).append("\n"); 
		query.append("     BKG_CORRECTION NEW, " ).append("\n"); 
		query.append("     BKG_CORRECTION OLD," ).append("\n"); 
		query.append("     BKG_BKG_HIS NRT," ).append("\n"); 
		query.append("     BKG_BKG_HIS ORT," ).append("\n"); 
		query.append("     BKG_CHG_RT DVC," ).append("\n"); 
		query.append("    (SELECT	OFC_CD " ).append("\n"); 
		query.append("     FROM	MDM_ORGANIZATION A" ).append("\n"); 
		query.append(" #if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("     WHERE	OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("     START WITH	A.OFC_CD = @[rhq_cd]" ).append("\n"); 
		query.append("     CONNECT BY	PRIOR A.OFC_CD	= A.PRNT_OFC_CD  " ).append("\n"); 
		query.append("     ) OG" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${date_type} == 'B')" ).append("\n"); 
		query.append("AND BK.BKG_CRE_DT BETWEEN TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#elseif (${date_type} == 'A')" ).append("\n"); 
		query.append("AND BR.RT_APLY_DT BETWEEN TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#elseif (${date_type} == 'E')" ).append("\n"); 
		query.append("AND VV.VPS_ETD_DT BETWEEN TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND BK.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("AND BK.BKG_NO = BR.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_NO = BD.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("AND BK.POL_CD = BV.POL_CD" ).append("\n"); 
		query.append("AND BV.VSL_CD = VV.VSL_CD" ).append("\n"); 
		query.append("AND BV.SKD_VOY_NO = VV.SKD_VOY_NO" ).append("\n"); 
		query.append("AND BV.SKD_DIR_CD = VV.SKD_DIR_CD" ).append("\n"); 
		query.append("AND BV.POL_CD = VV.VPS_PORT_CD" ).append("\n"); 
		query.append("AND BV.POL_YD_CD = VV.YD_CD" ).append("\n"); 
		query.append("AND BV.POL_CLPT_IND_SEQ = VV.CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND BK.BKG_OFC_CD = OG.OFC_CD" ).append("\n"); 
		query.append("AND BK.BKG_NO = NEW.BKG_NO" ).append("\n"); 
		query.append("AND NEW.CA_RSN_CD = 'D'" ).append("\n"); 
		query.append("AND NEW.BKG_NO = OLD.BKG_NO" ).append("\n"); 
		query.append("AND NEW.CORR_DT > OLD.CORR_DT" ).append("\n"); 
		query.append("AND OLD.CORR_DT = (SELECT MAX(CORR_DT)" ).append("\n"); 
		query.append("                   FROM BKG_CORRECTION T" ).append("\n"); 
		query.append("                   WHERE T.BKG_NO = OLD.BKG_NO" ).append("\n"); 
		query.append("                   AND T.CORR_DT < NEW.CORR_DT)" ).append("\n"); 
		query.append("AND NEW.BKG_NO = NRT.BKG_NO" ).append("\n"); 
		query.append("AND NEW.CORR_NO = NRT.CORR_NO" ).append("\n"); 
		query.append("AND OLD.BKG_NO = ORT.BKG_NO" ).append("\n"); 
		query.append("AND OLD.CORR_NO = ORT.CORR_NO" ).append("\n"); 
		query.append("AND BK.BKG_NO = DVC.BKG_NO(+)" ).append("\n"); 
		query.append("AND DVC.CHG_CD(+) = 'DVC'" ).append("\n"); 
		query.append("AND BK.SVC_SCP_CD = NVL(@[svc_scp_cd], BK.SVC_SCP_CD)" ).append("\n"); 
		query.append("AND BR.BKG_CTRT_TP_CD = NVL(@[bkg_ctrt_tp_cd], BR.BKG_CTRT_TP_CD)" ).append("\n"); 
		query.append("ORDER BY BK.BKG_NO, NEW.CORR_DT" ).append("\n"); 

	}
}