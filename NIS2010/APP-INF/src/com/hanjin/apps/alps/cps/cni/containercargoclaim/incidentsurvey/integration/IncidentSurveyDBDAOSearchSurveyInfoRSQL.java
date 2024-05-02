/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : IncidentSurveyDBDAOSearchSurveyInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IncidentSurveyDBDAOSearchSurveyInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Survey 조회
	  * </pre>
	  */
	public IncidentSurveyDBDAOSearchSurveyInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.integration").append("\n"); 
		query.append("FileName : IncidentSurveyDBDAOSearchSurveyInfoRSQL").append("\n"); 
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
		query.append("    CLM.CGO_CLM_NO                   " ).append("\n"); 
		query.append("  , CLM.CLM_AREA_CD                  /* AREA */" ).append("\n"); 
		query.append("  , CLM.HDLR_OFC_CD                  /* HOFC */" ).append("\n"); 
		query.append("  , CLM.HDLR_USR_ID                  /* HANDLER */" ).append("\n"); 
		query.append("  , TO_CHAR (CLM.UPD_DT, 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("  , CLM.CGO_CLM_INCI_NO              /* INC_NO */" ).append("\n"); 
		query.append("  , CLM.CRM_VOC_NO                   /* VOC_NO */" ).append("\n"); 
		query.append("  , MISC.CLM_MISC_CD                 /* CLM_STS_CD */" ).append("\n"); 
		query.append("  , MISC.CLM_MISC_NM                 /* STATUS */" ).append("\n"); 
		query.append("  , (TO_DATE(NVL(CLM.CS_CLZ_DT, TO_CHAR(SYSDATE,'YYYYMMDD')),'YYYYMMDD') - TO_DATE(CLM.PRLM_CLM_NTC_DT,'YYYYMMDD')) + 1 AS HPC" ).append("\n"); 
		query.append("  , (TO_DATE(NVL(CLM.CGO_CLM_STL_DT, TO_CHAR(SYSDATE,'YYYYMMDD')),'YYYYMMDD') -  TO_DATE(CLM.FMAL_CLM_RCV_DT,'YYYYMMDD')) + 1  AS NHP " ).append("\n"); 
		query.append("  , CLM.CGO_CLM_STL_TP_CD            /* TOS */" ).append("\n"); 
		query.append("  , TO_CHAR (TO_DATE(CLM.CS_CLZ_DT,'YYYYMMDD'), 'YYYY-MM-DD')                    AS CS_CLZ_DT /* DOC */" ).append("\n"); 
		query.append("  , TO_CHAR (TO_DATE(CLM.CLM_TM_BAR_DT,'YYYYMMDD'), 'YYYY-MM-DD')                AS CLM_TM_BAR_DT /* TB_DATE */" ).append("\n"); 
		query.append("  , TO_CHAR (TO_DATE(CLM.SMNS_SVE_DT,'YYYYMMDD'), 'YYYY-MM-DD')                  AS SMNS_SVE_DT /* SMNS_SVE_DT */" ).append("\n"); 
		query.append("  , CLM.CGO_CLM_TP_CD                /* TOC */" ).append("\n"); 
		query.append("  , CLM.MJR_CLM_DMG_LSS_CD           /* CODL1 */" ).append("\n"); 
		query.append("  , CLM.N3RD_LABL_PTY_CD         /* CODL2 */" ).append("\n"); 
		query.append("  , CLM.CLM_CGO_TP_CD		         /* CARGO */" ).append("\n"); 
		query.append("  , CLM.CGO_QLTY_DESC		         /* CARGO_NAME */" ).append("\n"); 
		query.append("  , CLM.CLMT_USD_AMT		         /*CLMT_USD_AMT */" ).append("\n"); 
		query.append("  , CLM.SLAN_CD			             /* LANE */" ).append("\n"); 
		query.append("  , CLM.CLM_INCI_PLC_TP_CD		     /* POI */" ).append("\n"); 
		query.append("  , TO_CHAR (TO_DATE(CLM.INCI_OCCR_DT,'YYYYMMDD'), 'YYYY-MM-DD')		         AS INCI_OCCR_DT /* DOI */" ).append("\n"); 
		query.append("  , CLM.INSUR_CLM_PTY_NO	         " ).append("\n"); 
		query.append("  , (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("            CNI_PARTY" ).append("\n"); 
		query.append("        WHERE" ).append("\n"); 
		query.append("            CLM_PTY_NO = CLM.INSUR_CLM_PTY_NO" ).append("\n"); 
		query.append("    )				     AS CLM_PTY_ABBR_NM1 /* INSURER */" ).append("\n"); 
		query.append("  , CLM.INSUR_REF_NO		 " ).append("\n"); 
		query.append("  , SVEY.CLM_PTY_NO		     /* SURVEYOR */" ).append("\n"); 
		query.append("  , PARTY.CLM_PTY_ABBR_NM	AS CLM_PTY_ABBR_NM2 " ).append("\n"); 
		query.append("  , PARTY.PTY_NM		     /* SURVEYOR_NAME */" ).append("\n"); 
		query.append("  , CLM.SVYR_TP_CD		     " ).append("\n"); 
		query.append("  , CLM.REF_SVYR_NO		     " ).append("\n"); 
		query.append("  , TO_CHAR (TO_DATE(CLM.SVYR_APNT_DT,'YYYYMMDD'), 'YYYY-MM-DD')		 AS SVYR_APNT_DT    /* APPOINTED_DATE */" ).append("\n"); 
		query.append("  , TO_CHAR (TO_DATE(CLM.SVEY_INP_DT,'YYYYMMDD'), 'YYYY-MM-DD')		     AS SVEY_INP_DT    /* SURVEYED_DATE */" ).append("\n"); 
		query.append("  , SVEY.UPD_USR_ID		       /*SV_UPDATER*/" ).append("\n"); 
		query.append("  , TO_CHAR (SVEY.UPD_DT, 'YYYY-MM-DD') AS UPD_DT2    /*SV_UPDATED*/" ).append("\n"); 
		query.append("  , CLM.SVYR_FEE_LOCL_AMT	 /* SURVEY_FEE */" ).append("\n"); 
		query.append("  , CLM.SVYR_LOCL_CURR_CD	 /* LOCL_CURR_CD */" ).append("\n"); 
		query.append("  , CLM.SVYR_XCH_RT		     " ).append("\n"); 
		query.append("  , CLM.SVYR_FEE_USD_AMT	 " ).append("\n"); 
		query.append("  , CLM.SVYR_FACT_FND_DESC	 " ).append("\n"); 
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
		query.append("  , CNI_CGO_CLM_SVEY SVEY" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    CLM.CGO_CLM_STS_CD  = MISC.CLM_MISC_CD" ).append("\n"); 
		query.append("    AND CLM.CGO_CLM_NO  = SVEY.CGO_CLM_NO(+)" ).append("\n"); 
		query.append("    AND SVEY.CLM_PTY_NO = PARTY.CLM_PTY_NO(+)" ).append("\n"); 
		query.append("    AND CLM.CGO_CLM_NO  = @[cgo_clm_no]" ).append("\n"); 

	}
}