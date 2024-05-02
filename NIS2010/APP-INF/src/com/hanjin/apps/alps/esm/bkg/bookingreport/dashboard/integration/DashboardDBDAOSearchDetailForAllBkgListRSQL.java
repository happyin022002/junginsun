/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DashboardDBDAOSearchDetailForAllBkgListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.10
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.10 
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

public class DashboardDBDAOSearchDetailForAllBkgListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 모든 bkg list의 General Detail 항목을 조회한다.
	  * </pre>
	  */
	public DashboardDBDAOSearchDetailForAllBkgListRSQL(){
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
		params.put("f_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_dbd_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : DashboardDBDAOSearchDetailForAllBkgListRSQL").append("\n"); 
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
		query.append("  DISTINCT" ).append("\n"); 
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
		query.append(", (SELECT TO_CHAR(SKD.VPS_ETD_DT,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("      FROM BKG_VVD VVD, VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("     WHERE A.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("       AND VVD.VSL_PRE_PST_CD IN ('S','T')" ).append("\n"); 
		query.append("       AND B.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("       AND VVD.VSL_PRE_PST_CD||VVD.VSL_SEQ = (SELECT MIN(VVD2.VSL_PRE_PST_CD||VVD2.VSL_SEQ)" ).append("\n"); 
		query.append("                                                FROM BKG_VVD VVD2" ).append("\n"); 
		query.append("                                               WHERE VVD.BKG_NO = VVD2.BKG_NO" ).append("\n"); 
		query.append("                                                  AND VVD.POL_CD  = VVD2.POL_CD)" ).append("\n"); 
		query.append("       AND VVD.VSL_CD             = SKD.VSL_CD" ).append("\n"); 
		query.append("       AND VVD.SKD_VOY_NO         = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND VVD.SKD_DIR_CD         = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND VVD.POL_CD             = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("       AND VVD.POL_CLPT_IND_SEQ   = SKD.CLPT_IND_SEQ ) VPS_ETD_DT" ).append("\n"); 
		query.append(", (SELECT /*+ INDEX(B XAK6SCE_COP_DTL) */ MAX(TRUNC(SYSDATE - L.ACT_DT))" ).append("\n"); 
		query.append("     FROM SCE_COP_HDR H, SCE_COP_DTL L WHERE 1=1" ).append("\n"); 
		query.append("      AND A.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("      AND H.COP_NO = L.COP_NO" ).append("\n"); 
		query.append("      AND L.ACT_CD ='FLVMLO'" ).append("\n"); 
		query.append("      AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("      AND L.ACT_DT IS NOT NULL ) ACCR_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("  BKG_DBD_BAT_CNDDT A" ).append("\n"); 
		query.append(", BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("    AND A.DBD_CRE_DT = @[f_dbd_cre_dt]" ).append("\n"); 
		query.append("    AND A.DBD_CRE_SEQ = @[f_dbd_cre_seq]" ).append("\n"); 
		query.append("    AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("    AND B.POD_NOD_CD LIKE @[f_dest_cnt_cd]||'%'" ).append("\n"); 
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