/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UnmatchBLDBDAOSearchNonAutoratedChargeForAuditRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.14 
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

public class UnmatchBLDBDAOSearchNonAutoratedChargeForAuditRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 심사를 위한 Non Autorated Charge 목록을 조회한다.
	  * </pre>
	  */
	public UnmatchBLDBDAOSearchNonAutoratedChargeForAuditRSQL(){
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
		params.put("auto_rat_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOSearchNonAutoratedChargeForAuditRSQL").append("\n"); 
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
		query.append("WITH BK AS(" ).append("\n"); 
		query.append("SELECT (" ).append("\n"); 
		query.append("        SELECT  A.OFC_CD" ).append("\n"); 
		query.append("        FROM    MDM_ORGANIZATION A" ).append("\n"); 
		query.append("        WHERE   A.OFC_TP_CD = 'HQ'" ).append("\n"); 
		query.append("        START   WITH A.OFC_CD = BK.BKG_OFC_CD" ).append("\n"); 
		query.append("        CONNECT BY PRIOR A.PRNT_OFC_CD = A.OFC_CD" ).append("\n"); 
		query.append("       ) BKG_RHQ_CD," ).append("\n"); 
		query.append("       BK.BKG_OFC_CD," ).append("\n"); 
		query.append("       BK.BKG_NO," ).append("\n"); 
		query.append("       TO_CHAR(BR.RT_APLY_DT, 'YYYY-MM-DD') RT_APLY_DT," ).append("\n"); 
		query.append("       BD.BDR_FLG," ).append("\n"); 
		query.append("       BK.CMDT_CD," ).append("\n"); 
		query.append("       (SELECT CMDT_NM FROM MDM_COMMODITY M WHERE M.CMDT_CD = BK.CMDT_CD) CMDT_NM," ).append("\n"); 
		query.append("       BK.SVC_SCP_CD," ).append("\n"); 
		query.append("       BKG_GET_AUTO_RT_HIS_FNC(BK.BKG_NO,1) RT_CNG_HIS," ).append("\n"); 
		query.append("       BK.POR_CD," ).append("\n"); 
		query.append("       BK.POL_CD," ).append("\n"); 
		query.append("       BK.POD_CD," ).append("\n"); 
		query.append("       BK.DEL_CD," ).append("\n"); 
		query.append("       (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE INTG_CD_ID ='CD01716'" ).append("\n"); 
		query.append("        AND INTG_CD_VAL_CTNT = BR.BKG_CTRT_TP_CD) BKG_CTRT_TP_CD ," ).append("\n"); 
		query.append("       CASE WHEN BR.BKG_CTRT_TP_CD = 'R' THEN BK.RFA_NO" ).append("\n"); 
		query.append("            WHEN BR.BKG_CTRT_TP_CD = 'S' THEN BK.SC_NO" ).append("\n"); 
		query.append("            WHEN BR.BKG_CTRT_TP_CD = 'T' THEN BK.TAA_NO" ).append("\n"); 
		query.append("       END CTRT_NO" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK," ).append("\n"); 
		query.append("     BKG_RATE BR," ).append("\n"); 
		query.append("     BKG_BL_DOC BD," ).append("\n"); 
		query.append("    (SELECT	OFC_CD " ).append("\n"); 
		query.append("     FROM	MDM_ORGANIZATION A" ).append("\n"); 
		query.append(" #if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("     WHERE	OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("     START WITH	A.OFC_CD = @[bkg_rhq_cd]" ).append("\n"); 
		query.append("     CONNECT BY	PRIOR A.OFC_CD	= A.PRNT_OFC_CD  " ).append("\n"); 
		query.append("     ) OG" ).append("\n"); 
		query.append("#if (${search_date} == 'ETD')" ).append("\n"); 
		query.append("    ,(SELECT DISTINCT B.BKG_NO" ).append("\n"); 
		query.append("      FROM BKG_BOOKING B, BKG_VVD BV, VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("      WHERE B.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("      AND B.POL_CD = BV.POL_CD" ).append("\n"); 
		query.append("      AND V.VSL_CD = BV.VSL_CD" ).append("\n"); 
		query.append("      AND V.SKD_VOY_NO = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND V.SKD_DIR_CD = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND V.VPS_PORT_CD = BV.POL_CD" ).append("\n"); 
		query.append("      AND V.CLPT_IND_SEQ = BV.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("      AND V.VPS_ETD_DT BETWEEN TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("      ) V" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("#elseif (${search_date} == 'APPL')" ).append("\n"); 
		query.append("WHERE BR.RT_APLY_DT BETWEEN TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("WHERE BK.BKG_CRE_DT BETWEEN TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND BK.BKG_STS_CD	<> 'X'" ).append("\n"); 
		query.append("AND	BK.BKG_CGO_TP_CD	<> 'P'" ).append("\n"); 
		query.append("AND	BK.BKG_NO		= BR.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_NO = BD.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_OFC_CD = OG.OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" #if (${svc_scp_cd} != '') " ).append("\n"); 
		query.append("AND BK.SVC_SCP_CD   = @[svc_scp_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${cmdt_cd} != '') " ).append("\n"); 
		query.append("AND BK.CMDT_CD = @[cmdt_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${bkg_ctrt_tp_cd} != '') " ).append("\n"); 
		query.append("AND     CASE" ).append("\n"); 
		query.append("             WHEN    BK.TAA_NO IS NOT NULL THEN  'T'" ).append("\n"); 
		query.append("             WHEN    BK.RFA_NO IS NOT NULL THEN  'R'" ).append("\n"); 
		query.append("             ELSE    'S'" ).append("\n"); 
		query.append("        END                     = @[bkg_ctrt_tp_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" #if (${ctrt_no} != '') " ).append("\n"); 
		query.append("AND     CASE" ).append("\n"); 
		query.append("             WHEN    BK.TAA_NO IS NOT NULL THEN  BK.TAA_NO" ).append("\n"); 
		query.append("             WHEN    BK.RFA_NO IS NOT NULL THEN  BK.RFA_NO" ).append("\n"); 
		query.append("             ELSE    BK.SC_NO" ).append("\n"); 
		query.append("        END                     LIKE @[ctrt_no] || '%'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" #if (${por_cd} != '') " ).append("\n"); 
		query.append("AND BK.POR_CD   LIKE @[por_cd]||'%'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${pol_cd} != '') " ).append("\n"); 
		query.append("AND BK.POL_CD   LIKE @[pol_cd]||'%'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${pod_cd} != '') " ).append("\n"); 
		query.append("AND BK.POD_CD   LIKE @[pod_cd]||'%'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${del_cd} != '') " ).append("\n"); 
		query.append("AND BK.DEL_CD   LIKE @[del_cd]||'%'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#if (${bdr_flg} != '') " ).append("\n"); 
		query.append("AND BD.BDR_FLG   = @[bdr_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("RT AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT NVL(BKG.BKG_NO, HIS.BKG_NO) BKG_NO," ).append("\n"); 
		query.append("       BKG.CHG_CD       BKG_CHG_CD, " ).append("\n"); 
		query.append("       BKG.CURR_CD      BKG_CURR_CD, " ).append("\n"); 
		query.append("       BKG.CHG_UT_AMT   BKG_CHG_UT_AMT, " ).append("\n"); 
		query.append("       BKG.RAT_UT_CD    BKG_RAT_UT_CD," ).append("\n"); 
		query.append("       BKG.RAT_AS_QTY   BKG_RAT_AS_QTY, " ).append("\n"); 
		query.append("       BKG.CHG_AMT      BKG_CHG_AMT, " ).append("\n"); 
		query.append("       BKG.AUTO_RAT_CD  BKG_AUTO_RAT_CD," ).append("\n"); 
		query.append("       HIS.CHG_CD       HIS_CHG_CD, " ).append("\n"); 
		query.append("       HIS.CURR_CD      HIS_CURR_CD, " ).append("\n"); 
		query.append("       HIS.CHG_UT_AMT   HIS_CHG_UT_AMT," ).append("\n"); 
		query.append("       HIS.RAT_UT_CD    HIS_RAT_UT_CD," ).append("\n"); 
		query.append("       HIS.RAT_AS_QTY   HIS_RAT_AS_QTY," ).append("\n"); 
		query.append("       HIS.CHG_AMT      HIS_CHG_AMT" ).append("\n"); 
		query.append("FROM (SELECT BK.BKG_NO," ).append("\n"); 
		query.append("             RT.CHG_CD, RT.CURR_CD, RT.CHG_UT_AMT, RT.RAT_UT_CD, RT.RAT_AS_QTY, RT.CHG_AMT, RT.AUTO_RAT_CD" ).append("\n"); 
		query.append("      FROM BK, BKG_CHG_RT RT" ).append("\n"); 
		query.append("      WHERE BK.BKG_NO = RT.BKG_NO(+)) BKG" ).append("\n"); 
		query.append("      FULL OUTER JOIN" ).append("\n"); 
		query.append("      (SELECT BK.BKG_NO," ).append("\n"); 
		query.append("             RT.CHG_CD, RT.CURR_CD, RT.CHG_UT_AMT, RT.RAT_UT_CD, RT.RAT_AS_QTY, RT.CHG_AMT" ).append("\n"); 
		query.append("      FROM BK, BKG_AUTO_RT_HIS RT" ).append("\n"); 
		query.append("      WHERE BK.BKG_NO = RT.BKG_NO" ).append("\n"); 
		query.append("      AND CURR_CD IS NOT NULL) HIS" ).append("\n"); 
		query.append(" ON BKG.BKG_NO = HIS.BKG_NO" ).append("\n"); 
		query.append("AND BKG.CHG_CD = HIS.CHG_CD" ).append("\n"); 
		query.append("AND BKG.RAT_UT_CD = HIS.RAT_UT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${auto_rat_cd} == 'X')" ).append("\n"); 
		query.append(" AND BKG.AUTO_RAT_CD IS NULL" ).append("\n"); 
		query.append("#elseif (${auto_rat_cd} != '')  " ).append("\n"); 
		query.append(" AND BKG.AUTO_RAT_CD = @[auto_rat_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chg_cd} != '')  " ).append("\n"); 
		query.append(" AND BKG.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT BK.BKG_RHQ_CD," ).append("\n"); 
		query.append("       BK.BKG_OFC_CD," ).append("\n"); 
		query.append("       BK.BKG_NO," ).append("\n"); 
		query.append("       BK.RT_APLY_DT," ).append("\n"); 
		query.append("       BK.BDR_FLG," ).append("\n"); 
		query.append("       BK.CMDT_CD," ).append("\n"); 
		query.append("       BK.CMDT_NM," ).append("\n"); 
		query.append("       BK.SVC_SCP_CD," ).append("\n"); 
		query.append("       BK.RT_CNG_HIS," ).append("\n"); 
		query.append("       BK.POR_CD," ).append("\n"); 
		query.append("       BK.POL_CD," ).append("\n"); 
		query.append("       BK.POD_CD," ).append("\n"); 
		query.append("       BK.DEL_CD," ).append("\n"); 
		query.append("       BK.BKG_CTRT_TP_CD," ).append("\n"); 
		query.append("       BK.CTRT_NO," ).append("\n"); 
		query.append("       RT.BKG_CHG_CD," ).append("\n"); 
		query.append("       RT.BKG_CURR_CD," ).append("\n"); 
		query.append("       RT.BKG_CHG_UT_AMT," ).append("\n"); 
		query.append("       RT.BKG_RAT_UT_CD," ).append("\n"); 
		query.append("       RT.BKG_RAT_AS_QTY," ).append("\n"); 
		query.append("       RT.BKG_CHG_AMT," ).append("\n"); 
		query.append("       RT.BKG_AUTO_RAT_CD," ).append("\n"); 
		query.append("       RT.HIS_CHG_CD," ).append("\n"); 
		query.append("       RT.HIS_CURR_CD," ).append("\n"); 
		query.append("       RT.HIS_CHG_UT_AMT," ).append("\n"); 
		query.append("       RT.HIS_RAT_UT_CD," ).append("\n"); 
		query.append("       RT.HIS_RAT_AS_QTY," ).append("\n"); 
		query.append("       RT.HIS_CHG_AMT," ).append("\n"); 
		query.append("       COUNT(DISTINCT RT.BKG_NO) OVER () AS  BL_CNT," ).append("\n"); 
		query.append("       '' search_date," ).append("\n"); 
		query.append("       '' fm_dt," ).append("\n"); 
		query.append("       '' to_dt       " ).append("\n"); 
		query.append("FROM BK, RT" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = RT.BKG_NO" ).append("\n"); 
		query.append("ORDER BY BK.BKG_RHQ_CD, BK.BKG_OFC_CD, BK.BKG_NO, RT.BKG_CHG_CD, RT.HIS_CHG_CD" ).append("\n"); 

	}
}