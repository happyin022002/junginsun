/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IndemnityDBDAOSearchLiablePartyInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2009.12.15 박제성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.indemnityclaim.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Je Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndemnityDBDAOSearchLiablePartyInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LiableParty 조회
	  * </pre>
	  */
	public IndemnityDBDAOSearchLiablePartyInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaim.indemnityclaim.integration").append("\n"); 
		query.append("FileName : IndemnityDBDAOSearchLiablePartyInfoRSQL").append("\n"); 
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
		query.append("CLM.CGO_CLM_NO                   AS CGO_CLM_NO" ).append("\n"); 
		query.append(", CLM.CLM_AREA_CD                  AS CLM_AREA_CD  /*AREA*/" ).append("\n"); 
		query.append(", CLM.HDLR_OFC_CD                  AS HDLR_OFC_CD  /*HOFC*/" ).append("\n"); 
		query.append(", CLM.HDLR_USR_ID                  AS HDLR_USR_ID  /*HANDLER*/" ).append("\n"); 
		query.append(", TO_CHAR (CLM.UPD_DT, 'YYYY-MM-DD') AS UPD_DT   /*UPDATED*/" ).append("\n"); 
		query.append(", CLM.CGO_CLM_INCI_NO              AS CGO_CLM_INCI_NO   /*INC_NO*/" ).append("\n"); 
		query.append(", CLM.CRM_VOC_NO                   AS CRM_VOC_NO   /*VOC_NO*/" ).append("\n"); 
		query.append(", MISC.CLM_MISC_CD                 AS CLM_MISC_CD   /*CLM_STS_CD*/" ).append("\n"); 
		query.append(", MISC.CLM_MISC_NM                 AS CLM_MISC_NM  /*CLM_STS_NM*/  /* STATUS */" ).append("\n"); 
		query.append(", (TO_DATE(NVL(CLM.CS_CLZ_DT, TO_CHAR(SYSDATE,'YYYYMMDD')),'YYYYMMDD') - TO_DATE(CLM.PRLM_CLM_NTC_DT,'YYYYMMDD')) + 1 AS HPC" ).append("\n"); 
		query.append(", (TO_DATE(NVL(CLM.CGO_CLM_STL_DT, TO_CHAR(SYSDATE,'YYYYMMDD')),'YYYYMMDD') -  TO_DATE(CLM.FMAL_CLM_RCV_DT,'YYYYMMDD')) + 1  AS NHP" ).append("\n"); 
		query.append(", CLM.CGO_CLM_STL_TP_CD            AS CGO_CLM_STL_TP_CD   /*TOS*/" ).append("\n"); 
		query.append(", TO_CHAR (TO_DATE(CLM.CS_CLZ_DT,'YYYYMMDD'), 'YYYY-MM-DD')                    AS CS_CLZ_DT  /*DOC*/" ).append("\n"); 
		query.append(", TO_CHAR (TO_DATE(CLM.CLM_TM_BAR_DT,'YYYYMMDD'), 'YYYY-MM-DD')                AS CLM_TM_BAR_DT   /*TB_DATE*/    /* Time Bar Date */" ).append("\n"); 
		query.append(", TO_CHAR (TO_DATE(CLM.SMNS_SVE_DT,'YYYYMMDD'), 'YYYY-MM-DD')                  AS SMNS_SVE_DT     /*SMNS_SVE_DT*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", BL.CGO_CLM_REF_BL_NO	AS  CGO_CLM_REF_BL_NO" ).append("\n"); 
		query.append(", CTRT.CRR_TERM_CD		AS CRR_TERM_CD" ).append("\n"); 
		query.append(", CTRT.POR_CD		AS POR_CD" ).append("\n"); 
		query.append(", TO_CHAR (TO_DATE(CTRT.RCT_DT,'YYYYMMDD'), 'YYYY-MM-DD')			AS RCT_DT" ).append("\n"); 
		query.append(", CTRT.POL_CD		AS POL_CD" ).append("\n"); 
		query.append(", CTRT.POD_CD		AS POD_CD" ).append("\n"); 
		query.append(", CTRT.DEL_CD		AS DEL_CD" ).append("\n"); 
		query.append(", TO_CHAR (TO_DATE(CTRT.DE_DT,'YYYYMMDD'), 'YYYY-MM-DD')			AS DE_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", CLM.CGO_CLM_TP_CD                AS CGO_CLM_TP_CD    /*TOC*/    /* Type Of Claim */" ).append("\n"); 
		query.append(", CLM.MJR_CLM_DMG_LSS_CD           AS MJR_CLM_DMG_LSS_CD    /*CODL1*/" ).append("\n"); 
		query.append(", CLM.MINR_CLM_DMG_LSS_CD          AS MINR_CLM_DMG_LSS_CD    /*CODL2*/" ).append("\n"); 
		query.append(", CLM.INCI_PLC_TP_CD		         AS INCI_PLC_TP_CD	 /*POI*/" ).append("\n"); 
		query.append(", TO_CHAR (TO_DATE(CLM.INCI_OCCR_DT,'YYYYMMDD'), 'YYYY-MM-DD')		         AS  INCI_OCCR_DT   /*DOI*/" ).append("\n"); 
		query.append(", CLM.CLM_CGO_TP_CD		         AS CLM_CGO_TP_CD	  /*CARGO*/" ).append("\n"); 
		query.append(", CLM.CGO_QLTY_DESC		         AS CGO_QLTY_DESC	  /*CARGO_NAME*/" ).append("\n"); 
		query.append(", CLM.CLMT_LOCL_AMT	         	 AS CLMT_LOCL_AMT   /* Claim Amount */" ).append("\n"); 
		query.append(", CLM.CLMT_LOCL_CURR_CD		     AS CLMT_LOCL_CURR_CD" ).append("\n"); 
		query.append(", TO_CHAR (TO_DATE(CLM.FMAL_CLM_RCV_DT,'YYYYMMDD'), 'YYYY-MM-DD')  		         AS FMAL_CLM_RCV_DT" ).append("\n"); 
		query.append(", CLM.CLMT_LOCL_XCH_RT		     AS CLMT_LOCL_XCH_RT" ).append("\n"); 
		query.append(", CLM.CLMT_USD_AMT			     AS CLMT_USD_AMT" ).append("\n"); 
		query.append(", CLM.CGO_CLM_STL_LOCL_AMT		 AS CGO_CLM_STL_LOCL_AMT    /* Settled Amount  */" ).append("\n"); 
		query.append(", CLM.CGO_CLM_STL_LOCL_CURR_CD	 AS CGO_CLM_STL_LOCL_CURR_CD" ).append("\n"); 
		query.append(", TO_CHAR (TO_DATE(CLM.CGO_CLM_STL_DT,'YYYYMMDD'), 'YYYY-MM-DD')  		         AS CGO_CLM_STL_DT" ).append("\n"); 
		query.append(", CLM.CGO_CLM_STL_XCH_RT		     AS CGO_CLM_STL_XCH_RT" ).append("\n"); 
		query.append(", CLM.CGO_CLM_STL_USD_AMT			 AS CGO_CLM_STL_USD_AMT" ).append("\n"); 
		query.append(", LP.CLM_PTY_NO		     AS CLM_PTY_NO /* SURVEYOR */" ).append("\n"); 
		query.append(", PARTY.CLM_PTY_ABBR_NM		 AS CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append(", PARTY.PTY_NM		     AS PTY_NM" ).append("\n"); 
		query.append(", LP.HNDL_OFC_CD		     AS HNDL_OFC_CD" ).append("\n"); 
		query.append(", TO_CHAR (TO_DATE(LP.LABL_PTY_PRLM_CLM_NTFY_DT,'YYYYMMDD'), 'YYYY-MM-DD')		 AS LABL_PTY_PRLM_CLM_NTFY_DT" ).append("\n"); 
		query.append(", TO_CHAR (TO_DATE(LP.TM_BAR_DT,'YYYYMMDD'), 'YYYY-MM-DD')		 AS TM_BAR_DT" ).append("\n"); 
		query.append(", LP.LABL_PTY_DMND_AMT		     AS LABL_PTY_DMND_AMT" ).append("\n"); 
		query.append(", LP.LABL_PTY_DMND_CURR_CD		     AS LABL_PTY_DMND_CURR_CD" ).append("\n"); 
		query.append(", TO_CHAR (TO_DATE(LP.LABL_PTY_FMAL_CLM_DT,'YYYYMMDD'), 'YYYY-MM-DD')  		     AS LABL_PTY_FMAL_CLM_DT" ).append("\n"); 
		query.append(", LP.LABL_PTY_XCH_RT		     AS LABL_PTY_XCH_RT" ).append("\n"); 
		query.append(", LP.LABL_PTY_DMND_USD_AMT		     AS LABL_PTY_DMND_USD_AMT" ).append("\n"); 
		query.append(", LP.LABL_PTY_RCVR_LOCL_AMT		     AS LABL_PTY_RCVR_LOCL_AMT" ).append("\n"); 
		query.append(", LP.LABL_PTY_RCVR_LOCL_CURR_CD		     AS LABL_PTY_RCVR_LOCL_CURR_CD" ).append("\n"); 
		query.append(", TO_CHAR (TO_DATE(LP.LABL_PTY_RCVR_DT,'YYYYMMDD'), 'YYYY-MM-DD')  		     AS LABL_PTY_RCVR_DT" ).append("\n"); 
		query.append(", LP.LABL_PTY_RCVR_LOCL_XCH_RT		     AS LABL_PTY_RCVR_LOCL_XCH_RT" ).append("\n"); 
		query.append(", LP.LABL_PTY_RCVR_USD_AMT		     AS LABL_PTY_RCVR_USD_AMT" ).append("\n"); 
		query.append(", LP.LABL_PTY_CLM_RMK		     AS LABL_PTY_CLM_RMK" ).append("\n"); 
		query.append(", LP.UPD_USR_ID		     AS UPD_USR_ID    /*SV_UPDATER*/" ).append("\n"); 
		query.append(", TO_CHAR (LP.UPD_DT, 'YYYY-MM-DD') AS UPD_DT    /*SV_UPDATED*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CNI_CLM_V CLM" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("*" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CNI_MISC_CD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("CLSS_CLM_MISC_CD = '08'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("MISC" ).append("\n"); 
		query.append(", CNI_PARTY PARTY" ).append("\n"); 
		query.append(", CNI_CGO_CLM_LABL_PTY LP" ).append("\n"); 
		query.append(", CNI_CGO_CLM_CTRT CTRT" ).append("\n"); 
		query.append(", CNI_CGO_CLM_BL_DTL  BL" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("CLM.CGO_CLM_STS_CD  = MISC.CLM_MISC_CD" ).append("\n"); 
		query.append("AND CLM.CGO_CLM_NO  = LP.CGO_CLM_NO(+)" ).append("\n"); 
		query.append("AND LP.CLM_PTY_NO = PARTY.CLM_PTY_NO(+)" ).append("\n"); 
		query.append("AND CLM.CGO_CLM_NO  = CTRT.CGO_CLM_NO(+)" ).append("\n"); 
		query.append("AND CLM.CGO_CLM_NO  = BL.CGO_CLM_NO(+)" ).append("\n"); 
		query.append("AND BL.MN_BL_FLG = 'Y'" ).append("\n"); 
		query.append("AND CLM.CGO_CLM_NO  = @[cgo_clm_no]" ).append("\n"); 

	}
}