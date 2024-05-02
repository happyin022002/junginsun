/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CandidateConfirmDBDAOSearchUpdatedListRSQL.java
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

public class CandidateConfirmDBDAOSearchUpdatedListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchUpdatedList
	  * </pre>
	  */
	public CandidateConfirmDBDAOSearchUpdatedListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.candidatemanage.candidateconfirm.integration").append("\n"); 
		query.append("FileName : CandidateConfirmDBDAOSearchUpdatedListRSQL").append("\n"); 
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
		query.append("	CASE NVL((SELECT MAX(N3PTY_NO_DP_SEQ)" ).append("\n"); 
		query.append("				FROM TPB_OTS_DTL" ).append("\n"); 
		query.append("				WHERE N3PTY_NO = A.N3PTY_NO),0" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("        WHEN 0 THEN 0" ).append("\n"); 
		query.append("        WHEN 1 THEN 1" ).append("\n"); 
		query.append("        ELSE 0" ).append("\n"); 
		query.append("        END CFM_I" ).append("\n"); 
		query.append("   ,CASE NVL(	(SELECT MAX(N3PTY_NO_DP_SEQ)" ).append("\n"); 
		query.append("   				FROM TPB_OTS_DTL" ).append("\n"); 
		query.append("   				WHERE N3PTY_NO = A.N3PTY_NO),0" ).append("\n"); 
		query.append("   			)" ).append("\n"); 
		query.append("        WHEN 0 THEN 0" ).append("\n"); 
		query.append("        WHEN 1 THEN 0" ).append("\n"); 
		query.append("        ELSE 1" ).append("\n"); 
		query.append("        END CFM_G" ).append("\n"); 
		query.append("   ,CASE NVL(	(SELECT COUNT(OTS_DTL_SEQ)" ).append("\n"); 
		query.append("   				FROM TPB_OTS_DTL" ).append("\n"); 
		query.append("   				WHERE OTS_DTL_SEQ = A.OTS_DTL_SEQ" ).append("\n"); 
		query.append("   				AND N3PTY_CFM_CD = 'N'),0" ).append("\n"); 
		query.append("   			)" ).append("\n"); 
		query.append("        WHEN 0 THEN 0" ).append("\n"); 
		query.append("        WHEN 1 THEN 1" ).append("\n"); 
		query.append("        END CFM_N" ).append("\n"); 
		query.append("	 ,NVL( (SELECT COUNT(OTS_DTL_SEQ)" ).append("\n"); 
		query.append("		   FROM TPB_OTS_DTL" ).append("\n"); 
		query.append("		   WHERE OTS_DTL_SEQ = A.OTS_DTL_SEQ" ).append("\n"); 
		query.append("		   AND N3PTY_CFM_CD = 'R'),0 ) CFM_R" ).append("\n"); 
		query.append("   ,CASE A.N3PTY_DELT_TP_CD" ).append("\n"); 
		query.append("        WHEN 'D' THEN 1" ).append("\n"); 
		query.append("        ELSE 0" ).append("\n"); 
		query.append("        END CFM_D" ).append("\n"); 
		query.append("   ,CASE A.CXL_FLG" ).append("\n"); 
		query.append("        WHEN 'Y' THEN 1" ).append("\n"); 
		query.append("        ELSE 0" ).append("\n"); 
		query.append("        END CFM_C" ).append("\n"); 
		query.append("   ,A.OTS_DTL_SEQ                                                               /* HIDDEN */" ).append("\n"); 
		query.append("   ,A.N3PTY_NO                                                                  /* TPB NO. */" ).append("\n"); 
		query.append("   ,A.N3PTY_SRC_SUB_SYS_CD                                                      /* EXP.TYPE - MAIN */" ).append("\n"); 
		query.append("   ,TPB_GET_N3PTY_BIL_TP_NM_FNC(A.N3PTY_BIL_TP_CD) N3PTY_BIL_TP_NM              /* EXP.TYPE - SUB */" ).append("\n"); 
		query.append("   ,A.N3PTY_SRC_NO                                                              /* S/P INV NO. */" ).append("\n"); 
		query.append("   ,A.VNDR_CUST_DIV_CD                                                          /* 3RD PARTY - TYPE */" ).append("\n"); 
		query.append("   ,CASE A.VNDR_CUST_DIV_CD                                                     /* 3RD PARTY - CODE */" ).append("\n"); 
		query.append("       WHEN 'V' THEN LPAD(A.VNDR_SEQ,6,0)" ).append("\n"); 
		query.append("       WHEN 'C' THEN A.CUST_CNT_CD||LPAD(A.CUST_SEQ,6,0)" ).append("\n"); 
		query.append("       WHEN 'S' THEN A.N3PTY_OFC_CD END" ).append("\n"); 
		query.append("       TRD_PARTY_VAL" ).append("\n"); 
		query.append("   ,COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD01132',A.EQ_KND_CD) AS EQ_KND_NM" ).append("\n"); 
		query.append("   ,A.EQ_NO" ).append("\n"); 
		query.append("   ,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("   ,A.BKG_NO G_BKG_NO_ALL" ).append("\n"); 
		query.append("   ,A.BL_NO  G_BL_NO_ALL" ).append("\n"); 
		query.append("   ,DECODE(A.N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("           ,'JO',A.VVD_CD" ).append("\n"); 
		query.append("           ,A.VSL_CD||A.SKD_VOY_NO||SUBSTR(A.FINC_DIR_CD,1,1)) G_VVD" ).append("\n"); 
		query.append("   ,CASE" ).append("\n"); 
		query.append("       WHEN (A.CFM_CURR_CD IN ('USD','CAD','EUR') ) THEN A.CFM_CURR_CD" ).append("\n"); 
		query.append("       WHEN (A.CFM_CURR_CD = TPB_GET_OFC_BIL_CURR_CD_FNC(@[s_if_ofc_cd]) ) THEN A.CFM_CURR_CD" ).append("\n"); 
		query.append("       ELSE 'USD'" ).append("\n"); 
		query.append("       END IF_CURR_CD" ).append("\n"); 
		query.append("   ,CASE" ).append("\n"); 
		query.append("       WHEN (A.CFM_CURR_CD IN ('USD','CAD','EUR') ) THEN A.CFM_AMT							" ).append("\n"); 
		query.append("       WHEN (A.CFM_CURR_CD = TPB_GET_OFC_BIL_CURR_CD_FNC(@[s_if_ofc_cd]) ) THEN A.CFM_AMT	" ).append("\n"); 
		query.append("       ELSE TPB_GET_INV_CURR_CHG_FNC(A.CFM_CURR_CD,'USD',A.CFM_AMT, SYSDATE)				" ).append("\n"); 
		query.append("       END IF_AMT" ).append("\n"); 
		query.append("   ,TPB_GET_INV_CURR_CHG_FNC(A.CFM_CURR_CD,'USD',A.IF_AMT, SYSDATE) IF_AMT_USD" ).append("\n"); 
		query.append("   --,DECODE(NVL(A.IF_RMK,''),'','N','Y')  IF_RMK_FLAG                            /* INTERFACED REMARK */" ).append("\n"); 
		query.append("   ,A.IF_RMK" ).append("\n"); 
		query.append("   ,A.CFM_AMT                                                                   /* CONFIRMED AMOUNT */" ).append("\n"); 
		query.append("   ,TO_CHAR(TPB_GET_LCL_DATE_FNC(A.IF_DT,@[s_if_ofc_cd]),'YYYY-MM-DD HH24:MI') IF_DT         /* I/F DATE */" ).append("\n"); 
		query.append("   ,A.IF_OFC_CD                                                                 /* INTERFACED BY - OFFICE */" ).append("\n"); 
		query.append("   ,A.IF_USR_ID                                                                 /* INTERFACED BY - ID */" ).append("\n"); 
		query.append("   /* 2009-01-28 O WAN-KI 1.2 INTERFACED BY NAME 추가. */" ).append("\n"); 
		query.append("   ,(SELECT USR_NM FROM COM_USER WHERE USR_ID = A.IF_USR_ID) AS IF_USR_NM       /* INTERFACED BY - NAME */" ).append("\n"); 
		query.append("   ,A.CFM_RMK                                                                   /* DESCRIPTION */" ).append("\n"); 
		query.append("   ,A.RVW_OFC_CD                                                                /* REVIEWED BY - OFFICE */" ).append("\n"); 
		query.append("   ,A.RVW_USR_ID                                                                /* REVIEWED BY - ID */" ).append("\n"); 
		query.append("   ,A.N3PTY_NON_CFM_RSN_CD                                                      /* REASON FOR NON-TPB */" ).append("\n"); 
		query.append("   ,A.CSR_NO                                                                    /* CSR NO. */" ).append("\n"); 
		query.append("   ,A.VNDR_CNT_CD                                                               /* HIDDEN */" ).append("\n"); 
		query.append("   ,A.VNDR_SEQ  	                                                              /* HIDDEN */" ).append("\n"); 
		query.append("   ,A.CUST_CNT_CD                                                               /* HIDDEN */" ).append("\n"); 
		query.append("   ,A.CUST_SEQ 	                                                             		/* HIDDEN */" ).append("\n"); 
		query.append("   ,A.N3PTY_OFC_CD                                                              /* HIDDEN */" ).append("\n"); 
		query.append("   ,A.N3PTY_IF_TP_CD                                                            /* HIDDEN */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   ,A.SRC_VNDR_SEQ                                                              /* HIDDEN */" ).append("\n"); 
		query.append("   ,A.TML_INV_TP_CD TES_GUBUN                                                   /* HIDDEN */" ).append("\n"); 
		query.append("   ,(SELECT COUNT(0)FROM COM_INTG_CD_DTL                                        /* HIDDEN */" ).append("\n"); 
		query.append("     WHERE INTG_CD_ID = 'CD00921' AND INTG_CD_VAL_CTNT = A.SRC_VNDR_SEQ) TRS_GUBUN   /* HIDDEN */" ).append("\n"); 
		query.append("   ,A.ESTM_SEQ_NO                                                               /* HIDDEN */" ).append("\n"); 
		query.append("   ,A.ESTM_RVIS_NO                                                              /* HIDDEN */" ).append("\n"); 
		query.append("   ,A.ESTM_DTL_SEQ_NO                                                           /* HIDDEN */" ).append("\n"); 
		query.append("   ,A.ESTM_SYS_AREA_GRP_ID ESTM_SVR_ID                                                               /* HIDDEN */" ).append("\n"); 
		query.append("   ,NVL(A.COST_EXPT_FLG,'N') COST_EXPT_FLG                                      /* HIDDEN */" ).append("\n"); 
		query.append("   ,CASE WHEN A.N3PTY_IF_TP_CD = 'S' AND A.N3PTY_EXPN_TP_CD IN ('TRS','TES')    /* HIDDEN */" ).append("\n"); 
		query.append("         THEN (CASE WHEN LENGTH(A.FINC_DIR_CD)=2 THEN 'Y' ELSE 'N' END)         /* HIDDEN */" ).append("\n"); 
		query.append("         ELSE 'Y' END CHECK_FINC_DIR_CD  			                             			/* HIDDEN */" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("   TPB_OTS_DTL A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${in_ots_dtl_seq} != '') " ).append("\n"); 
		query.append("   AND A.OTS_DTL_SEQ IN($in_ots_dtl_seq)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY OTS_DTL_SEQ" ).append("\n"); 

	}
}