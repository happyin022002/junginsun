/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOSearchTpbIfInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.05 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOSearchTpbIfInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TPB I/F 내역을 조회회한다.
	  * </pre>
	  */
	public EacMgtDBDAOSearchTpbIfInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOSearchTpbIfInfoRSQL").append("\n"); 
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
		query.append("SELECT -- 공통" ).append("\n"); 
		query.append("      TPB_OTS_DTL_SEQ1.NEXTVAL AS OTS_DTL_SEQ" ).append("\n"); 
		query.append("      ,'' as ibflag" ).append("\n"); 
		query.append("       -- CreateTPBCandidateVO (TPB 데이타 등록용)" ).append("\n"); 
		query.append("      ,B.VNDR_CUST_DIV_CD AS s_vndr_cust_div_cd" ).append("\n"); 
		query.append("      ,B.VNDR_CNT_CD AS s_vndr_cnt_cd" ).append("\n"); 
		query.append("      ,B.VNDR_SEQ AS s_vndr_seq" ).append("\n"); 
		query.append("      ,B.CUST_CNT_CD AS s_cust_cnt_cd" ).append("\n"); 
		query.append("      ,B.CUST_SEQ AS s_cust_seq" ).append("\n"); 
		query.append("      ,B.N3PTY_BIL_TP_CD AS s_n3pty_bil_tp_cd" ).append("\n"); 
		query.append("      ,A.RESPB_OFC_CD    AS s_if_ofc_cd" ).append("\n"); 
		query.append("      ,A.RESPB_OFC_CD    AS user_ofc_cd" ).append("\n"); 
		query.append("      ,B.N3PTY_EXPN_TP_CD AS s_n3pty_expn_tp_cd" ).append("\n"); 
		query.append("      ,A.N3PTY_SRC_NO AS s_n3pty_src_no" ).append("\n"); 
		query.append("      ,'' AS s_so_no" ).append("\n"); 
		query.append("      ,B.BKG_NO AS s_bkg_no" ).append("\n"); 
		query.append("      ,B.BKG_NO AS s_bkg_no_all" ).append("\n"); 
		query.append("      ,B.BL_NO  AS s_bl_no" ).append("\n"); 
		query.append("      ,C.EQ_NO  AS eq_no" ).append("\n"); 
		query.append("      ,C.EQ_NO as s_vvd" ).append("\n"); 
		query.append("      ,SUBSTR(C.EQ_NO, 0,4) AS s_vsl_cd" ).append("\n"); 
		query.append("      ,SUBSTR(C.EQ_NO, 5,4) AS s_skd_voy_no" ).append("\n"); 
		query.append("      ,SUBSTR(C.EQ_NO, 9,1) AS s_skd_dir_cd" ).append("\n"); 
		query.append("      ,A.CURR_CD AS s_curr_cd" ).append("\n"); 
		query.append("      ,'' AS s_file_no" ).append("\n"); 
		query.append("      ,C.DIFF_INV_AMT AS if_amt" ).append("\n"); 
		query.append("      ,'' AS s_if_rmk" ).append("\n"); 
		query.append("      ,C.EQ_KND_CD AS eq_knd_cd" ).append("\n"); 
		query.append("      ,C.EQ_TPSZ_CD AS eq_tpsz_cd" ).append("\n"); 
		query.append("      ,B.N3PTY_OFC_CD AS s_n3pty_ofc_cd" ).append("\n"); 
		query.append("      ,A.YD_CD AS s_yd_cd" ).append("\n"); 
		query.append("      ,(SELECT X.VNDR_CNT_CD FROM MDM_VENDOR X WHERE X.VNDR_SEQ = A.VNDR_SEQ) AS s_src_vndr_cnt_cd" ).append("\n"); 
		query.append("      ,A.VNDR_SEQ AS s_src_vndr_seq" ).append("\n"); 
		query.append("      ,'' s_mnl_inp_tp_cd" ).append("\n"); 
		query.append("      ,(SELECT X.VNDR_LGL_ENG_NM FROM MDM_VENDOR X WHERE X.VNDR_SEQ = B.VNDR_SEQ) AS s_vndr_lgl_eng_nm" ).append("\n"); 
		query.append("      ,(SELECT X.CUST_LGL_ENG_NM FROM MDM_CUSTOMER X WHERE X.CUST_CNT_CD = B.CUST_CNT_CD AND X.CUST_SEQ = B.CUST_SEQ) AS s_vndr_lgl_eng_nm" ).append("\n"); 
		query.append("       -- SearchCandidateListVO (TPB Confirm용)" ).append("\n"); 
		query.append("      ,'1' AS cfm_g" ).append("\n"); 
		query.append("      ,''  AS cfm_rmk" ).append("\n"); 
		query.append("      ,''  AS n3pty_non_cfm_rsn_cd" ).append("\n"); 
		query.append("      ,A.CURR_CD AS if_curr_cd" ).append("\n"); 
		query.append("      ,C.DIFF_INV_AMT AS cfm_amt      " ).append("\n"); 
		query.append("      ,CASE WHEN B.VNDR_CUST_DIV_CD = 'V' THEN TO_CHAR(B.VNDR_SEQ)" ).append("\n"); 
		query.append("            WHEN B.VNDR_CUST_DIV_CD = 'C' THEN B.CUST_CNT_CD||B.CUST_SEQ" ).append("\n"); 
		query.append("            WHEN B.VNDR_CUST_DIV_CD = 'S' THEN B.N3PTY_OFC_CD" ).append("\n"); 
		query.append("       END AS trd_party_val" ).append("\n"); 
		query.append("      ,'S' AS s_n3pty_if_tp_cd" ).append("\n"); 
		query.append("      ,'' as cfm_i" ).append("\n"); 
		query.append("      ,'' as cfm_n" ).append("\n"); 
		query.append("      ,'' as cfm_r" ).append("\n"); 
		query.append("      ,'' as cfm_d" ).append("\n"); 
		query.append("      ,B.VNDR_CUST_DIV_CD AS vndr_cust_div_cd" ).append("\n"); 
		query.append("      ,B.VNDR_CNT_CD AS vndr_cnt_cd" ).append("\n"); 
		query.append("      ,B.VNDR_SEQ AS vndr_seq" ).append("\n"); 
		query.append("      ,B.CUST_CNT_CD AS cust_cnt_cd" ).append("\n"); 
		query.append("      ,B.CUST_SEQ AS cust_seq" ).append("\n"); 
		query.append("  FROM EAS_EXPN_AUD_CS_MGMT A" ).append("\n"); 
		query.append("      ,EAS_EXPN_AUD_CS_N3RD_PTY B" ).append("\n"); 
		query.append("      ,EAS_EXPN_AUD_N3RD_PTY_DTL C" ).append("\n"); 
		query.append(" WHERE A.EAC_NO = B.EAC_NO" ).append("\n"); 
		query.append("   AND A.EAC_NO = C.EAC_NO" ).append("\n"); 
		query.append("   AND A.EAC_NO =  @[eac_no] -- EAC NO" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}