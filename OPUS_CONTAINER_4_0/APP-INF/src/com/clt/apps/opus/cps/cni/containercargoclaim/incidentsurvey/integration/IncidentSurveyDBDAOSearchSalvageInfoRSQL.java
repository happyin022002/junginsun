/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IncidentSurveyDBDAOSearchSalvageInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.24
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2009.11.24 양정란
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yang jung ran
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IncidentSurveyDBDAOSearchSalvageInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Salvage 조회
	  * </pre>
	  */
	public IncidentSurveyDBDAOSearchSalvageInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.integration").append("\n"); 
		query.append("FileName : IncidentSurveyDBDAOSearchSalvageInfoRSQL").append("\n"); 
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
		query.append("CLM.CGO_CLM_NO" ).append("\n"); 
		query.append(", CLM.CLM_AREA_CD                    /* AREA */" ).append("\n"); 
		query.append(", CLM.HDLR_OFC_CD                    /* HOFC */" ).append("\n"); 
		query.append(", CLM.HDLR_USR_ID                    /* HANDLER */" ).append("\n"); 
		query.append(", TO_CHAR (CLM.UPD_DT, 'YYYY-MM-DD') AS UPD_DT1 /* UPDATED */" ).append("\n"); 
		query.append(", CLM.CGO_CLM_INCI_NO                /* INC_NO */" ).append("\n"); 
		query.append(", CLM.CRM_VOC_NO                     /* VOC_NO */" ).append("\n"); 
		query.append(", MISC.CLM_MISC_CD                   /* CLM_STS_CD */" ).append("\n"); 
		query.append(", MISC.CLM_MISC_NM                   /* STATUS */" ).append("\n"); 
		query.append(", (TO_DATE (NVL (CLM.CS_CLZ_DT, TO_CHAR (SYSDATE, 'YYYYMMDD')), 'YYYYMMDD')      - TO_DATE (CLM.PRLM_CLM_NTC_DT, 'YYYYMMDD')) + 1 AS HPC" ).append("\n"); 
		query.append(", (TO_DATE (NVL (CLM.CGO_CLM_STL_DT, TO_CHAR (SYSDATE, 'YYYYMMDD')), 'YYYYMMDD') - TO_DATE (CLM.FMAL_CLM_RCV_DT, 'YYYYMMDD')) + 1 AS NHP" ).append("\n"); 
		query.append(", CLM.CGO_CLM_STL_TP_CD              /* TOS */" ).append("\n"); 
		query.append(", TO_CHAR (TO_DATE (CLM.CS_CLZ_DT,'YYYYMMDD'), 'YYYY-MM-DD')   AS CS_CLZ_DT    /* DOC */" ).append("\n"); 
		query.append(", TO_CHAR (TO_DATE (CLM.CLM_TM_BAR_DT,'YYYYMMDD'), 'YYYY-MM-DD') AS CLM_TM_BAR_DT /* TB_DATE */" ).append("\n"); 
		query.append(", TO_CHAR (TO_DATE (CLM.SMNS_SVE_DT,'YYYYMMDD'), 'YYYY-MM-DD') AS SMNS_SVE_DT" ).append("\n"); 
		query.append(", CLM.CGO_CLM_TP_CD                                 /* TOC */" ).append("\n"); 
		query.append(", CLM.MJR_CLM_DMG_LSS_CD  /* CODL1 */" ).append("\n"); 
		query.append(", CLM.MINR_CLM_DMG_LSS_CD /* CODL2 */" ).append("\n"); 
		query.append(", CLM.CLM_CGO_TP_CD       /* CARGO */" ).append("\n"); 
		query.append(", CLM.CGO_QLTY_DESC       /* CARGO_NAME */" ).append("\n"); 
		query.append(", CLM.CLMT_USD_AMT        /* Claim Amount */" ).append("\n"); 
		query.append(", CLM.SLAN_CD             /* LANE */" ).append("\n"); 
		query.append(", CLM.CLM_INCI_PLC_TP_CD  /* POI */" ).append("\n"); 
		query.append(", TO_CHAR (TO_DATE (CLM.INCI_OCCR_DT,'YYYYMMDD'), 'YYYY-MM-DD') AS INCI_OCCR_DT /* DOI */" ).append("\n"); 
		query.append(", CLM.INSUR_CLM_PTY_NO" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CNI_PARTY" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("CLM_PTY_NO = CLM.INSUR_CLM_PTY_NO" ).append("\n"); 
		query.append(")                AS CLM_PTY_ABBR_NM1 /* INSURER */" ).append("\n"); 
		query.append(", CLM.INSUR_REF_NO" ).append("\n"); 
		query.append(", SLV.CLM_PTY_NO   AS CLM_PTY_NO    /* SALVAGE */" ).append("\n"); 
		query.append(", PARTY.CLM_PTY_ABBR_NM   AS CLM_PTY_ABBR_NM2  /* SALVAGER */" ).append("\n"); 
		query.append(", PARTY.PTY_NM                                 /* SALVAGER_NAME */" ).append("\n"); 
		query.append(", CLM.REF_SLV_NO" ).append("\n"); 
		query.append(", TO_CHAR (TO_DATE (CLM.SLV_DT,'YYYYMMDD'), 'YYYY-MM-DD') AS SLV_DT /* SALVAGED_DATE */" ).append("\n"); 
		query.append(", SLV.UPD_USR_ID AS UPD_USR_ID    /*SL_UPDATER*/" ).append("\n"); 
		query.append(", TO_CHAR (SLV.UPD_DT, 'YYYY-MM-DD') AS UPD_DT2 /*SL_UPDATED*/" ).append("\n"); 
		query.append(", CLM.SLV_LOCL_AMT AS SLV_LOCL_AMT    /* SALVAE AMOUNT */" ).append("\n"); 
		query.append(", CLM.SLV_LOCL_CURR_CD AS SLV_LOCL_CURR_CD    /* SLV_LOCL_CURR_CD*/" ).append("\n"); 
		query.append(", CLM.SLV_XCH_RT  AS SLV_XCH_RT" ).append("\n"); 
		query.append(", CLM.SLV_USD_AMT AS SLV_USD_AMT" ).append("\n"); 
		query.append(", CLM.SLV_DESC    AS SLV_DESC" ).append("\n"); 
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
		query.append(", CNI_CGO_CLM_SLV SLV" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("CLM.CGO_CLM_STS_CD = MISC.CLM_MISC_CD" ).append("\n"); 
		query.append("AND CLM.CGO_CLM_NO = SLV.CGO_CLM_NO(+)" ).append("\n"); 
		query.append("AND SLV.CLM_PTY_NO = PARTY.CLM_PTY_NO(+)" ).append("\n"); 
		query.append("AND CLM.CGO_CLM_NO  = @[cgo_clm_no]" ).append("\n"); 

	}
}