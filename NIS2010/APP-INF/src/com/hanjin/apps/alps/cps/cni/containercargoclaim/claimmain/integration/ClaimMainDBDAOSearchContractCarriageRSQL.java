/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ClaimMainDBDAOSearchContractCarriageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ClaimMainDBDAOSearchContractCarriageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ContractCarriage 조회
	  * </pre>
	  */
	public ClaimMainDBDAOSearchContractCarriageRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration").append("\n"); 
		query.append("FileName : ClaimMainDBDAOSearchContractCarriageRSQL").append("\n"); 
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
		query.append("  , CLM.CLM_AREA_CD                  AS CLM_AREA_CD   " ).append("\n"); 
		query.append("  , CLM.HDLR_OFC_CD                  AS HDLR_OFC_CD     " ).append("\n"); 
		query.append("  , CLM.HDLR_USR_ID                  AS HDLR_USR_ID   " ).append("\n"); 
		query.append("  , TO_CHAR (CLM.UPD_DT, 'YYYY-MM-DD') AS UPD_DT    /*UPDATED*/" ).append("\n"); 
		query.append("  , CLM.CGO_CLM_INCI_NO              AS CGO_CLM_INCI_NO  " ).append("\n"); 
		query.append("  , CLM.CRM_VOC_NO                   AS CRM_VOC_NO  /*CLM_MISC_CD*/    " ).append("\n"); 
		query.append("  , MISC.CLM_MISC_CD                 AS CLM_MISC_CD   /*CLM_STS_CD*/" ).append("\n"); 
		query.append("  , MISC.CLM_MISC_NM                 AS CLM_MISC_NM        /* STATUS */" ).append("\n"); 
		query.append("  , (TO_DATE(NVL(CLM.CS_CLZ_DT, TO_CHAR(SYSDATE,'YYYYMMDD')),'YYYYMMDD') - TO_DATE(CLM.PRLM_CLM_NTC_DT,'YYYYMMDD')) + 1 AS HPC" ).append("\n"); 
		query.append("  , (TO_DATE(NVL(CLM.CGO_CLM_STL_DT, TO_CHAR(SYSDATE,'YYYYMMDD')),'YYYYMMDD') -  TO_DATE(CLM.FMAL_CLM_RCV_DT,'YYYYMMDD')) + 1  AS NHP " ).append("\n"); 
		query.append("  , CLM.CGO_CLM_STL_TP_CD            AS CGO_CLM_STL_TP_CD   " ).append("\n"); 
		query.append("  , TO_CHAR (TO_DATE(CLM.CS_CLZ_DT,'YYYYMMDD'), 'YYYY-MM-DD')                    AS CS_CLZ_DT    /* Date of Formal Claim */" ).append("\n"); 
		query.append("  , TO_CHAR (TO_DATE(CLM.CLM_TM_BAR_DT,'YYYYMMDD'), 'YYYY-MM-DD')                AS CLM_TM_BAR_DT  /* Time Bar Date */" ).append("\n"); 
		query.append("  , TO_CHAR (TO_DATE(CLM.SMNS_SVE_DT,'YYYYMMDD'), 'YYYY-MM-DD')                  AS SMNS_SVE_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  , CLM.CLMT_CLM_PTY_NO  AS CLMT_CLM_PTY_NO" ).append("\n"); 
		query.append("  , PARTY.CLM_PTY_ABBR_NM  AS CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append("  , PARTY.PTY_NM  AS PTY_NM" ).append("\n"); 
		query.append("  , CLM.CLMT_CLM_TP_CD  AS CLMT_CLM_TP_CD" ).append("\n"); 
		query.append("  , CLM.FMAL_CLM_RCV_OFC_CD  AS  FMAL_CLM_RCV_OFC_CD     /*ROFC*/ " ).append("\n"); 
		query.append("  , TO_CHAR (TO_DATE(CLM.FMAL_CLM_RCV_DT,'YYYYMMDD'), 'YYYY-MM-DD')	  AS  FMAL_CLM_RCV_DT  /*DOF */ " ).append("\n"); 
		query.append("  , CLM.CGO_CLM_TP_CD                AS CGO_CLM_TP_CD    /*TOC*/    " ).append("\n"); 
		query.append("  , CLM.MJR_CLM_DMG_LSS_CD           AS MJR_CLM_DMG_LSS_CD   /*CODL1*/" ).append("\n"); 
		query.append("  , CLM.N3RD_LABL_PTY_CD          AS N3RD_LABL_PTY_CD   /*CODL2*/  " ).append("\n"); 
		query.append("  , CLM.INCI_PLC_TP_CD		         AS INCI_PLC_TP_CD   /*POI*/" ).append("\n"); 
		query.append("  , TO_CHAR (TO_DATE(CLM.INCI_OCCR_DT,'YYYYMMDD'), 'YYYY-MM-DD')		         AS INCI_OCCR_DT  /*DOI*/ " ).append("\n"); 
		query.append("  , CLM.CLMT_USD_AMT			     AS CLMT_USD_AMT  " ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   , CTRT.TRNK_REF_VVD_NO	AS TRNK_REF_VVD_NO" ).append("\n"); 
		query.append("   , CLM.SLAN_CD	         AS SLAN_CD" ).append("\n"); 
		query.append("   , CTRT.CRR_TERM_CD		AS CRR_TERM_CD" ).append("\n"); 
		query.append("   , CTRT.POR_CD		AS POR_CD" ).append("\n"); 
		query.append("   , TO_CHAR (TO_DATE(CTRT.RCT_DT,'YYYYMMDD'), 'YYYY-MM-DD')			AS RCT_DT" ).append("\n"); 
		query.append("   , CTRT.POL_CD		AS POL_CD" ).append("\n"); 
		query.append("   , TO_CHAR (TO_DATE(CTRT.LODG_DT,'YYYYMMDD'), 'YYYY-MM-DD')		AS LODG_DT" ).append("\n"); 
		query.append("   , CTRT.POD_CD		AS POD_CD" ).append("\n"); 
		query.append("   , TO_CHAR (TO_DATE(CTRT.DCHG_DT,'YYYYMMDD'), 'YYYY-MM-DD')		AS DCHG_DT" ).append("\n"); 
		query.append("   , CTRT.DEL_CD		AS DEL_CD" ).append("\n"); 
		query.append("   , TO_CHAR (TO_DATE(CTRT.DE_DT,'YYYYMMDD'), 'YYYY-MM-DD')			AS DE_DT  " ).append("\n"); 
		query.append("   , CTRT.SHPR_NM		AS SHPR_NM" ).append("\n"); 
		query.append("   , CTRT.CNEE_NM		AS CNEE_NM" ).append("\n"); 
		query.append("   , CTRT.NTFY_NM		AS NTFY_NM" ).append("\n"); 
		query.append("   , CTRT.CLM_CGO_TP_CD		AS CLM_CGO_TP_CD	" ).append("\n"); 
		query.append("   , CTRT.CGO_QLTY_DESC		AS CGO_QLTY_DESC   " ).append("\n"); 
		query.append("   , CTRT.CLM_OFRT_AMT		AS CLM_OFRT_AMT" ).append("\n"); 
		query.append("   , CTRT.CLM_OFRT_TERM_CD	AS CLM_OFRT_TERM_CD" ).append("\n"); 
		query.append("   , CTRT.CLM_OFRT_FLG		AS CLM_OFRT_FLG" ).append("\n"); 
		query.append("   , CTRT.N1ST_PRE_REF_VVD_NO	AS N1ST_PRE_REF_VVD_NO" ).append("\n"); 
		query.append("   , CTRT.N2ND_PRE_REF_VVD_NO	AS N2ND_PRE_REF_VVD_NO" ).append("\n"); 
		query.append("   , CTRT.N3RD_PRE_REF_VVD_NO	AS N3RD_PRE_REF_VVD_NO" ).append("\n"); 
		query.append("   , CTRT.N1ST_PRE_TS_LOC_CD	AS N1ST_PRE_TS_LOC_CD" ).append("\n"); 
		query.append("   , TO_CHAR (TO_DATE(CTRT.N1ST_PRE_TS_DT,'YYYYMMDD'), 'YYYY-MM-DD')	AS N1ST_PRE_TS_DT 	" ).append("\n"); 
		query.append("   , CTRT.N2ND_PRE_TS_LOC_CD	AS N2ND_PRE_TS_LOC_CD" ).append("\n"); 
		query.append("   , TO_CHAR (TO_DATE(CTRT.N2ND_PRE_TS_DT,'YYYYMMDD'), 'YYYY-MM-DD')	AS  N2ND_PRE_TS_DT" ).append("\n"); 
		query.append("   , CTRT.N3RD_PRE_TS_LOC_CD	AS N3RD_PRE_TS_LOC_CD" ).append("\n"); 
		query.append("   , TO_CHAR (TO_DATE(CTRT.N3RD_PRE_TS_DT,'YYYYMMDD'), 'YYYY-MM-DD')	AS N3RD_PRE_TS_DT" ).append("\n"); 
		query.append("   , CTRT.N1ST_PST_REF_VVD_NO	AS N1ST_PST_REF_VVD_NO" ).append("\n"); 
		query.append("   , CTRT.N2ND_PST_REF_VVD_NO	AS N2ND_PST_REF_VVD_NO" ).append("\n"); 
		query.append("   , CTRT.N3RD_PST_REF_VVD_NO	AS N3RD_PST_REF_VVD_NO" ).append("\n"); 
		query.append("   , CTRT.N1ST_PST_TS_LOC_CD	AS N1ST_PST_TS_LOC_CD" ).append("\n"); 
		query.append("   , TO_CHAR (TO_DATE(CTRT.N1ST_PST_TS_DT,'YYYYMMDD'), 'YYYY-MM-DD')	AS N1ST_PST_TS_DT" ).append("\n"); 
		query.append("   , CTRT.N2ND_PST_TS_LOC_CD	AS N2ND_PST_TS_LOC_CD" ).append("\n"); 
		query.append("   , TO_CHAR (TO_DATE(CTRT.N2ND_PST_TS_DT,'YYYYMMDD'), 'YYYY-MM-DD')	AS N2ND_PST_TS_DT" ).append("\n"); 
		query.append("   , CTRT.N3RD_PST_TS_LOC_CD	AS N3RD_PST_TS_LOC_CD" ).append("\n"); 
		query.append("   , TO_CHAR (TO_DATE(CTRT.N3RD_PST_TS_DT,'YYYYMMDD'), 'YYYY-MM-DD')	AS N3RD_PST_TS_DT" ).append("\n"); 
		query.append("   , CTRT.REP_CMDT_CD		AS REP_CMDT_CD" ).append("\n"); 
		query.append("   , CTRT.N3RD_REF_VVD_NO	AS N3RD_REF_VVD_NO   " ).append("\n"); 
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
		query.append("  , CNI_CGO_CLM_CTRT CTRT" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    CLM.CGO_CLM_STS_CD  = MISC.CLM_MISC_CD" ).append("\n"); 
		query.append("    AND CLM.CGO_CLM_NO  = CTRT.CGO_CLM_NO(+) " ).append("\n"); 
		query.append("	AND CLM.CLMT_CLM_PTY_NO= PARTY.CLM_PTY_NO(+) " ).append("\n"); 
		query.append("    AND CLM.CGO_CLM_NO  = @[cgo_clm_no]" ).append("\n"); 

	}
}