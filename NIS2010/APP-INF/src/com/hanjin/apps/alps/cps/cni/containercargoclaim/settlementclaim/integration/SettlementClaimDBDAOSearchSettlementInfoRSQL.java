/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SettlementClaimDBDAOSearchSettlementInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SettlementClaimDBDAOSearchSettlementInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Settlement 조회
	  * </pre>
	  */
	public SettlementClaimDBDAOSearchSettlementInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.integration").append("\n"); 
		query.append("FileName : SettlementClaimDBDAOSearchSettlementInfoRSQL").append("\n"); 
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
		query.append("    CLM.CGO_CLM_NO                   AS CGO_CLM_NO" ).append("\n"); 
		query.append("  , CLM.CLM_AREA_CD                  AS CLM_AREA_CD  /*AREA*/" ).append("\n"); 
		query.append("  , CLM.HDLR_OFC_CD                  AS HDLR_OFC_CD  /*HOFC*/" ).append("\n"); 
		query.append("  , CLM.HDLR_USR_ID                  AS HDLR_USR_ID  /*HANDLER*/" ).append("\n"); 
		query.append("  , TO_CHAR (CLM.UPD_DT, 'YYYY-MM-DD') AS UPD_DT   /*UPDATED*/" ).append("\n"); 
		query.append("  , CLM.CGO_CLM_INCI_NO              AS CGO_CLM_INCI_NO   /*INC_NO*/" ).append("\n"); 
		query.append("  , CLM.CRM_VOC_NO                   AS CRM_VOC_NO   /*VOC_NO*/" ).append("\n"); 
		query.append("  , MISC.CLM_MISC_CD                 AS CLM_MISC_CD   /*CLM_STS_CD*/" ).append("\n"); 
		query.append("  , MISC.CLM_MISC_NM                 AS CLM_MISC_NM  /*CLM_STS_NM*/  /* STATUS */" ).append("\n"); 
		query.append("  , (TO_DATE(NVL(CLM.CS_CLZ_DT, TO_CHAR(SYSDATE,'YYYYMMDD')),'YYYYMMDD') - TO_DATE(CLM.PRLM_CLM_NTC_DT,'YYYYMMDD')) + 1 AS HPC" ).append("\n"); 
		query.append("  , (TO_DATE(NVL(CLM.CGO_CLM_STL_DT, TO_CHAR(SYSDATE,'YYYYMMDD')),'YYYYMMDD') -  TO_DATE(CLM.FMAL_CLM_RCV_DT,'YYYYMMDD')) + 1  AS NHP " ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("  , TO_CHAR (TO_DATE(CLM.CS_CLZ_DT,'YYYYMMDD'), 'YYYY-MM-DD')                    AS CS_CLZ_DT  /*DOC*/" ).append("\n"); 
		query.append("  , TO_CHAR (TO_DATE(CLM.CLM_TM_BAR_DT,'YYYYMMDD'), 'YYYY-MM-DD')                AS CLM_TM_BAR_DT   /*TB_DATE*/    /* Time Bar Date */" ).append("\n"); 
		query.append("  , TO_CHAR (TO_DATE(CLM.SMNS_SVE_DT,'YYYYMMDD'), 'YYYY-MM-DD')                  AS SMNS_SVE_DT     /*SMNS_SVE_DT*/" ).append("\n"); 
		query.append("  , CLM.CGO_CLM_TP_CD                AS CGO_CLM_TP_CD    /*TOC*/    /* Type Of Claim */" ).append("\n"); 
		query.append("  , CLM.MJR_CLM_DMG_LSS_CD           AS MJR_CLM_DMG_LSS_CD    /*CODL1*/" ).append("\n"); 
		query.append("  , CLM.N3RD_LABL_PTY_CD          AS N3RD_LABL_PTY_CD    /*CODL2*/  " ).append("\n"); 
		query.append("  , CLM.INCI_PLC_TP_CD		         AS INCI_PLC_TP_CD	 /*POI*/" ).append("\n"); 
		query.append("  , TO_CHAR (TO_DATE(CLM.INCI_OCCR_DT,'YYYYMMDD'), 'YYYY-MM-DD')		         AS  INCI_OCCR_DT   /*DOI*/" ).append("\n"); 
		query.append("  , CLM.CLM_CGO_TP_CD		         AS CLM_CGO_TP_CD	  /*CARGO*/" ).append("\n"); 
		query.append("  , CLM.CGO_QLTY_DESC		         AS CGO_QLTY_DESC	  /*CARGO_NAME*/" ).append("\n"); 
		query.append("  , STL.CGO_CLM_STL_TP_CD            AS CGO_CLM_STL_TP_CD   /*TOS*/" ).append("\n"); 
		query.append("  , CLM.CLMT_LOCL_AMT	         	 AS CLMT_LOCL_AMT   /* Claim Amount */  " ).append("\n"); 
		query.append("  , CLM.CLMT_LOCL_CURR_CD		     AS CLMT_LOCL_CURR_CD" ).append("\n"); 
		query.append("  , TO_CHAR (TO_DATE(CLM.FMAL_CLM_RCV_DT,'YYYYMMDD'), 'YYYY-MM-DD')  		         AS FMAL_CLM_RCV_DT" ).append("\n"); 
		query.append("  , CLM.CLMT_LOCL_XCH_RT		     AS CLMT_LOCL_XCH_RT" ).append("\n"); 
		query.append("  , CLM.CLMT_USD_AMT			     AS CLMT_USD_AMT  " ).append("\n"); 
		query.append("  , CLM.CGO_CLM_STL_LOCL_AMT		 AS CGO_CLM_STL_LOCL_AMT    /* Settled Amount  */  " ).append("\n"); 
		query.append("  , CLM.CGO_CLM_STL_LOCL_CURR_CD	 AS CGO_CLM_STL_LOCL_CURR_CD" ).append("\n"); 
		query.append("  , TO_CHAR (TO_DATE(CLM.CGO_CLM_STL_DT,'YYYYMMDD'), 'YYYY-MM-DD')  		         AS CGO_CLM_STL_DT" ).append("\n"); 
		query.append("  , CLM.CGO_CLM_STL_XCH_RT		     AS CGO_CLM_STL_XCH_RT" ).append("\n"); 
		query.append("  , CLM.CGO_CLM_STL_USD_AMT			 AS CGO_CLM_STL_USD_AMT" ).append("\n"); 
		query.append("  , CLM.CLMT_CLM_PTY_NO    AS CLM_PTY_NO " ).append("\n"); 
		query.append("  , PARTY.CLM_PTY_ABBR_NM		 AS CLM_PTY_ABBR_NM	" ).append("\n"); 
		query.append("  , PARTY.PTY_NM		     AS PTY_NM	" ).append("\n"); 
		query.append("  , LP.HNDL_OFC_CD		     AS HNDL_OFC_CD    " ).append("\n"); 
		query.append("  , TO_CHAR (TO_DATE(LP.LABL_PTY_PRLM_CLM_NTFY_DT,'YYYYMMDD'), 'YYYY-MM-DD')		 AS LABL_PTY_PRLM_CLM_NTFY_DT   " ).append("\n"); 
		query.append("  , TO_CHAR (TO_DATE(LP.TM_BAR_DT,'YYYYMMDD'), 'YYYY-MM-DD')		 AS TM_BAR_DT  " ).append("\n"); 
		query.append("  , LP.LABL_PTY_DMND_AMT		     AS LABL_PTY_DMND_AMT" ).append("\n"); 
		query.append("  , LP.LABL_PTY_DMND_CURR_CD		     AS LABL_PTY_DMND_CURR_CD" ).append("\n"); 
		query.append("  , TO_CHAR (TO_DATE(LP.LABL_PTY_FMAL_CLM_DT,'YYYYMMDD'), 'YYYY-MM-DD')  		     AS LABL_PTY_FMAL_CLM_DT" ).append("\n"); 
		query.append("  , LP.LABL_PTY_XCH_RT		     AS LABL_PTY_XCH_RT" ).append("\n"); 
		query.append("  , LP.LABL_PTY_DMND_USD_AMT		     AS LABL_PTY_DMND_USD_AMT  " ).append("\n"); 
		query.append("  , LP.LABL_PTY_RCVR_LOCL_AMT		     AS LABL_PTY_RCVR_LOCL_AMT" ).append("\n"); 
		query.append("  , LP.LABL_PTY_RCVR_LOCL_CURR_CD		     AS LABL_PTY_RCVR_LOCL_CURR_CD" ).append("\n"); 
		query.append("  , TO_CHAR (TO_DATE(LP.LABL_PTY_RCVR_DT,'YYYYMMDD'), 'YYYY-MM-DD')  		     AS LABL_PTY_RCVR_DT" ).append("\n"); 
		query.append("  , LP.LABL_PTY_RCVR_LOCL_XCH_RT		     AS LABL_PTY_RCVR_LOCL_XCH_RT" ).append("\n"); 
		query.append("  , LP.LABL_PTY_RCVR_USD_AMT		     AS LABL_PTY_RCVR_USD_AMT  " ).append("\n"); 
		query.append("  , STL.CGO_CLM_STL_TP_CD        AS CGO_CLM_STL_TP_CD" ).append("\n"); 
		query.append("  , TO_CHAR (TO_DATE(STL.CGO_CLM_STL_DT,'YYYYMMDD'), 'YYYY-MM-DD')  	         AS CGO_CLM_STL_DT" ).append("\n"); 
		query.append("  , STL.CGO_CLM_STL_RMK		     AS CGO_CLM_STL_RMK " ).append("\n"); 
		query.append("  , STL.UPD_USR_ID		     AS UPD_USR_ID    /*UPDATER*/" ).append("\n"); 
		query.append("  , TO_CHAR (STL.UPD_DT, 'YYYY-MM-DD') AS UPD_DT    /*UPDATED*/ " ).append("\n"); 
		query.append("  , STL.CGO_CLM_STL_DESC   AS  CGO_CLM_STL_DESC  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  , CLM.CLM_STL_AUTH_CD    AS  CLM_STL_AUTH_CD" ).append("\n"); 
		query.append("  , CNI_GET_CLM_MISC_NM_FNC ('38', CLM.CLM_STL_AUTH_CD, '2') AS  CLM_STL_AUTH_CD_NM" ).append("\n"); 
		query.append("  , CLM.CLM_STL_AUTH_NO    AS  CLM_STL_AUTH_NO" ).append("\n"); 
		query.append("  , CLM.CLM_STL_AUTH_RMK   AS  CLM_STL_AUTH_RMK  " ).append("\n"); 
		query.append("  , TO_CHAR (TO_DATE(CLM.CLM_STL_APPL_DT ,'YYYYMMDD'), 'YYYY-MM-DD')  AS  CLM_STL_APPL_DT" ).append("\n"); 
		query.append("  , CLM.CLM_STL_APPL_USR_ID   AS  CLM_STL_APPL_USR_ID" ).append("\n"); 
		query.append("  , CLM.CLM_STL_APPL_OFC_CD   AS  CLM_STL_APPL_OFC_CD  " ).append("\n"); 
		query.append("  , TO_CHAR (TO_DATE(CLM.CLM_STL_AUTH_DT ,'YYYYMMDD'), 'YYYY-MM-DD')  AS  CLM_STL_AUTH_DT" ).append("\n"); 
		query.append("  , CLM.CLM_STL_AUTH_USR_ID   AS  CLM_STL_AUTH_USR_ID" ).append("\n"); 
		query.append("  , CLM.CLM_STL_AUTH_OFC_CD   AS  CLM_STL_AUTH_OFC_CD" ).append("\n"); 
		query.append("  , CLM.INSUR_RCVR_USD_AMT    AS  INSUR_RCVR_USD_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    CNI_CLM_V CLM" ).append("\n"); 
		query.append("  , (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            *" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("            CNI_MISC_CD" ).append("\n"); 
		query.append("        WHERE" ).append("\n"); 
		query.append("            CLSS_CLM_MISC_CD = '08'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    MISC" ).append("\n"); 
		query.append("  , CNI_PARTY PARTY" ).append("\n"); 
		query.append("  , CNI_CGO_CLM_LABL_PTY LP" ).append("\n"); 
		query.append("  , CNI_CGO_CLM_STL STL" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    CLM.CGO_CLM_STS_CD  = MISC.CLM_MISC_CD" ).append("\n"); 
		query.append("    AND CLM.CGO_CLM_NO  = LP.CGO_CLM_NO(+)" ).append("\n"); 
		query.append(" --   AND LP.CLM_PTY_NO = PARTY.CLM_PTY_NO(+)" ).append("\n"); 
		query.append("	AND CLM.CLMT_CLM_PTY_NO = PARTY.CLM_PTY_NO(+)" ).append("\n"); 
		query.append("    AND CLM.CGO_CLM_NO  = STL.CGO_CLM_NO(+)" ).append("\n"); 
		query.append("    AND CLM.CGO_CLM_NO  = @[cgo_clm_no]" ).append("\n"); 

	}
}