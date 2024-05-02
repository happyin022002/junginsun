/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CandidateConfirmDBDAOSearchCandidateListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.candidatemanage.candidateconfirm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CandidateConfirmDBDAOSearchCandidateListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public CandidateConfirmDBDAOSearchCandidateListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_src_sub_sys_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_bl_no_all",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_bkg_no_all",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_edate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_csr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_sdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_bil_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.candidatemanage.candidateconfirm.integration").append("\n"); 
		query.append("FileName : CandidateConfirmDBDAOSearchCandidateListRSQL").append("\n"); 
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
		query.append("SELECT '0' CFM_I" ).append("\n"); 
		query.append("      ,'0' CFM_G" ).append("\n"); 
		query.append("      ,'0' CFM_N" ).append("\n"); 
		query.append("      ,'0' CFM_R" ).append("\n"); 
		query.append("      ,'0' CFM_D" ).append("\n"); 
		query.append("      ,'0' CFM_C" ).append("\n"); 
		query.append("      ,A.OTS_DTL_SEQ                                                               /* HIDDEN */" ).append("\n"); 
		query.append("      ,A.N3PTY_NO                                                                  /* TPB NO. */" ).append("\n"); 
		query.append("      ,A.N3PTY_SRC_SUB_SYS_CD                                                      /* EXP.TYPE - MAIN */" ).append("\n"); 
		query.append("      ,TPB_GET_N3PTY_BIL_TP_NM_FNC(A.N3PTY_BIL_TP_CD) N3PTY_BIL_TP_NM              /* EXP.TYPE - SUB */" ).append("\n"); 
		query.append("      ,A.N3PTY_SRC_NO                                                              /* S/P INV NO. */" ).append("\n"); 
		query.append("      ,A.VNDR_CUST_DIV_CD                                                          /* 3RD PARTY - TYPE */" ).append("\n"); 
		query.append("      ,CASE A.VNDR_CUST_DIV_CD                                                     /* 3RD PARTY - CODE */" ).append("\n"); 
		query.append("            WHEN 'V' THEN LPAD(A.VNDR_SEQ,6,0)" ).append("\n"); 
		query.append("            WHEN 'C' THEN A.CUST_CNT_CD||LPAD(A.CUST_SEQ,6,0)" ).append("\n"); 
		query.append("            WHEN 'S' THEN A.N3PTY_OFC_CD" ).append("\n"); 
		query.append("       END TRD_PARTY_VAL" ).append("\n"); 
		query.append("      ,COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD01132',A.EQ_KND_CD) EQ_KND_NM" ).append("\n"); 
		query.append("      ,A.EQ_KND_CD" ).append("\n"); 
		query.append("      ,A.EQ_NO" ).append("\n"); 
		query.append("      ,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,A.BKG_NO           G_BKG_NO_ALL" ).append("\n"); 
		query.append("      ,A.BL_NO   G_BL_NO_ALL" ).append("\n"); 
		query.append("      ,DECODE(A.N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("      ,'JO',VVD_CD" ).append("\n"); 
		query.append("      ,A.VSL_CD||A.SKD_VOY_NO||SUBSTR(A.FINC_DIR_CD,1,1)) G_VVD" ).append("\n"); 
		query.append("      ,CASE WHEN (A.IF_CURR_CD IN ('USD','CAD','EUR') ) THEN A.IF_CURR_CD" ).append("\n"); 
		query.append("            WHEN (A.IF_CURR_CD = TPB_GET_OFC_BIL_CURR_CD_FNC(@[s_if_ofc_cd]) ) THEN A.IF_CURR_CD" ).append("\n"); 
		query.append("            ELSE 'USD'" ).append("\n"); 
		query.append("       END IF_CURR_CD" ).append("\n"); 
		query.append("      ,CASE WHEN (A.IF_CURR_CD IN ('USD','CAD','EUR') ) THEN A.IF_AMT" ).append("\n"); 
		query.append("            WHEN (A.IF_CURR_CD = TPB_GET_OFC_BIL_CURR_CD_FNC(@[s_if_ofc_cd]) ) THEN A.IF_AMT" ).append("\n"); 
		query.append("            ELSE TPB_GET_INV_CURR_CHG_FNC(A.IF_CURR_CD,'USD',A.IF_AMT, SYSDATE)" ).append("\n"); 
		query.append("       END IF_AMT" ).append("\n"); 
		query.append("      ,TPB_GET_INV_CURR_CHG_FNC(A.IF_CURR_CD,'USD',A.IF_AMT, SYSDATE) IF_AMT_USD" ).append("\n"); 
		query.append("      --,DECODE(NVL(A.IF_RMK,''),'','N','Y')  IF_RMK_FLAG " ).append("\n"); 
		query.append("	  ,A.IF_RMK                            	/* INTERFACED REMARK */" ).append("\n"); 
		query.append("      ,A.CFM_AMT                                                                   	/* CONFIRMED AMOUNT */" ).append("\n"); 
		query.append("      ,TO_CHAR(TPB_GET_LCL_DATE_FNC(A.IF_DT,@[s_if_ofc_cd]),'YYYY-MM-DD HH24:MI') IF_DT/* I/F DATE */" ).append("\n"); 
		query.append("      ,A.IF_OFC_CD                                                                 	/* INTERFACED BY - OFFICE */" ).append("\n"); 
		query.append("      ,A.IF_USR_ID                                                                 	/* INTERFACED BY - ID */" ).append("\n"); 
		query.append("      /* 2009-01-28 O WAN-KI 1.2 INTERFACED BY NAME 추가. */" ).append("\n"); 
		query.append("      ,(SELECT USR_NM FROM COM_USER WHERE USR_ID = A.IF_USR_ID) AS IF_USR_NM     	 	/* INTERFACED BY - NAME */" ).append("\n"); 
		query.append("      ,A.CFM_RMK                                                               	    /* DESCRIPTION */" ).append("\n"); 
		query.append("      ,A.RVW_OFC_CD                                                                	/* REVIEWED BY - OFFICE */" ).append("\n"); 
		query.append("      ,A.RVW_USR_ID                                                                	/* REVIEWED BY - ID */" ).append("\n"); 
		query.append("      ,A.N3PTY_NON_CFM_RSN_CD                                                      	/* REASON FOR NON-TPB */" ).append("\n"); 
		query.append("      ,A.CSR_NO                                                                    	/* CSR NO. (ONLY JO CASE) */" ).append("\n"); 
		query.append("      ,A.VNDR_CNT_CD                                                               	/* HIDDEN */" ).append("\n"); 
		query.append("      ,A.VNDR_SEQ  	                                                             	/* HIDDEN */" ).append("\n"); 
		query.append("      ,A.CUST_CNT_CD                                                               	/* HIDDEN */" ).append("\n"); 
		query.append("      ,A.CUST_SEQ 	                                                             		/* HIDDEN */" ).append("\n"); 
		query.append("      ,A.N3PTY_OFC_CD                                                              	/* HIDDEN */" ).append("\n"); 
		query.append("      ,A.N3PTY_IF_TP_CD                                                            	/* HIDDEN */" ).append("\n"); 
		query.append("      ,A.SRC_VNDR_SEQ                                                              	/* HIDDEN */" ).append("\n"); 
		query.append("      ,A.TML_INV_TP_CD TES_GUBUN                                                   	/* HIDDEN */" ).append("\n"); 
		query.append("      ,(SELECT COUNT(0)FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD00921' AND INTG_CD_VAL_CTNT = A.SRC_VNDR_SEQ) TRS_GUBUN  /* HIDDEN */" ).append("\n"); 
		query.append("      ,A.ESTM_SEQ_NO                                                              		/* HIDDEN */" ).append("\n"); 
		query.append("      ,A.ESTM_RVIS_NO                                                              	/* HIDDEN */" ).append("\n"); 
		query.append("      ,A.ESTM_DTL_SEQ_NO                                                           	/* HIDDEN */" ).append("\n"); 
		query.append("      ,A.ESTM_SYS_AREA_GRP_ID  ESTM_SVR_ID                                         	/* HIDDEN */" ).append("\n"); 
		query.append("      ,NVL(A.COST_EXPT_FLG,'N') COST_EXPT_FLG                                      	/* HIDDEN */" ).append("\n"); 
		query.append("      ,CASE WHEN A.N3PTY_IF_TP_CD = 'S' AND A.N3PTY_EXPN_TP_CD IN ('TRS','TES') THEN (CASE WHEN LENGTH(A.FINC_DIR_CD)=2 THEN 'Y' ELSE 'N' END)" ).append("\n"); 
		query.append("            ELSE 'Y'" ).append("\n"); 
		query.append("       END CHECK_FINC_DIR_CD  			                             	/* HIDDEN */" ).append("\n"); 
		query.append("/* 2009-01-22 O WAN-KI 1.1 CANDIDATE 조회쿼리 보완. */" ).append("\n"); 
		query.append("      ,A.OFC_CD                                                                    	/* HIDDEN */" ).append("\n"); 
		query.append("  FROM TPB_OTS_DTL A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.N3PTY_BIL_TP_CD != 'JO'" ).append("\n"); 
		query.append("   AND A.N3PTY_BIL_TP_CD NOT IN (" ).append("\n"); 
		query.append("                                	SELECT N3PTY_BIL_TP_CD " ).append("\n"); 
		query.append("                                	  FROM TPB_N3RD_PTY_BIL_TP " ).append("\n"); 
		query.append("                                     WHERE ACT_FLG = 'N')" ).append("\n"); 
		query.append("#if (${s_vvd} != '') " ).append("\n"); 
		query.append("   AND DECODE(A.N3PTY_BIL_TP_CD,'JO',VVD_CD,A.VSL_CD||A.SKD_VOY_NO||SUBSTR(A.FINC_DIR_CD,1,1)) = @[s_vvd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_bkg_no_all} != '') " ).append("\n"); 
		query.append("   AND A.BKG_NO = @[s_bkg_no_all]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_bl_no_all} != '') " ).append("\n"); 
		query.append("   AND A.BL_NO = @[s_bl_no_all]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${s_csr_no} != '') " ).append("\n"); 
		query.append("   AND A.CSR_NO = @[s_csr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_n3pty_src_no} != '') " ).append("\n"); 
		query.append("   AND N3PTY_SRC_NO = @[s_n3pty_src_no]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${s_n3pty_src_sub_sys_cd} != '')" ).append("\n"); 
		query.append("   AND N3PTY_SRC_SUB_SYS_CD = @[s_n3pty_src_sub_sys_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${s_n3pty_bil_tp_cd} != '')" ).append("\n"); 
		query.append("   AND N3PTY_BIL_TP_CD = @[s_n3pty_bil_tp_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("   /* 2009-03-27 O Wan-Ki 1.3 N200903170210, Cancel Flag 추가에 의한 보완. */" ).append("\n"); 
		query.append("   AND A.CXL_FLG IS NULL" ).append("\n"); 
		query.append("   AND A.N3PTY_DELT_TP_CD IN ('N', 'S')                                        " ).append("\n"); 
		query.append("   AND A.OFC_CD IN (  SELECT OFC_CD" ).append("\n"); 
		query.append("                        FROM TPB_HNDL_OFC" ).append("\n"); 
		query.append("                       WHERE N3PTY_OFC_TP_CD = 'T'" ).append("\n"); 
		query.append("                         AND DELT_FLG='N'" ).append("\n"); 
		query.append("                         AND OFC_CD = @[s_if_ofc_cd]" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("   AND ( " ).append("\n"); 
		query.append("#if (${s_nr} == 'I' || ${s_nr} == 'IR') " ).append("\n"); 
		query.append("   (                                           " ).append("\n"); 
		query.append("     A.N3PTY_CFM_CD = 'I'" ).append("\n"); 
		query.append("     AND (A.IF_DT >= TPB_GET_SRCH_DATE_FNC(@[s_sdate],'YYYY-MM-DD',@[s_if_ofc_cd])" ).append("\n"); 
		query.append("     AND A.IF_DT < TPB_GET_SRCH_DATE_FNC(@[s_edate],'YYYY-MM-DD',@[s_if_ofc_cd])+1 )" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${s_nr} == 'IR') " ).append("\n"); 
		query.append("   OR" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${s_nr} == 'R' || ${s_nr} == 'IR')" ).append("\n"); 
		query.append("   (" ).append("\n"); 
		query.append("       A.N3PTY_CFM_CD = 'R'" ).append("\n"); 
		query.append("       AND (A.RVW_DT >= TPB_GET_SRCH_DATE_FNC(@[s_sdate],'YYYY-MM-DD',@[s_if_ofc_cd])" ).append("\n"); 
		query.append("       AND A.RVW_DT < TPB_GET_SRCH_DATE_FNC(@[s_edate],'YYYY-MM-DD',@[s_if_ofc_cd])+1 )" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_nr} == 'N') " ).append("\n"); 
		query.append("   (" ).append("\n"); 
		query.append("       A.N3PTY_CFM_CD = 'N'" ).append("\n"); 
		query.append("       AND (A.CFM_DT >= TPB_GET_SRCH_DATE_FNC(@[s_sdate],'YYYY-MM-DD',@[s_if_ofc_cd])" ).append("\n"); 
		query.append("       AND A.CFM_DT < TPB_GET_SRCH_DATE_FNC(@[s_edate],'YYYY-MM-DD',@[s_if_ofc_cd])+1 )" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("ORDER BY OTS_DTL_SEQ" ).append("\n"); 

	}
}