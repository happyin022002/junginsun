/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IncidentSurveyDBDAOSearchIncidentClaimInquiryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2009.12.30 양정란
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yang jung ran
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IncidentSurveyDBDAOSearchIncidentClaimInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ncidentClaimInquiry 조회
	  * </pre>
	  */
	public IncidentSurveyDBDAOSearchIncidentClaimInquiryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_inci_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.integration").append("\n"); 
		query.append("FileName : IncidentSurveyDBDAOSearchIncidentClaimInquiryListRSQL").append("\n"); 
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
		query.append("CGO_CLM_DIV_CD 		--AS CL" ).append("\n"); 
		query.append(", CGO_CLM_NO     		--AS CLM_NO" ).append("\n"); 
		query.append(", CLM_AREA_CD1   		--AS A" ).append("\n"); 
		query.append(", HDLR_OFC_CD    		--AS HOFC" ).append("\n"); 
		query.append(", CGO_CLM_STS_CD      --AS STS" ).append("\n"); 
		query.append(", SMNS_SVE_DT	   		--AS LIT" ).append("\n"); 
		query.append(", CS_CLZ_DT           --AS DOC" ).append("\n"); 
		query.append(", PRLM_CLM_NTC_DT     --AS NOPC_DATE" ).append("\n"); 
		query.append(", FMAL_CLM_RCV_DT     --AS DOF" ).append("\n"); 
		query.append(", UPD_DT1             --AS UPDATED" ).append("\n"); 
		query.append(", PTY_NM1             --AS CLAIMANT" ).append("\n"); 
		query.append(", TRNK_REF_VVD_NO     --AS VVD" ).append("\n"); 
		query.append(", CGO_CLM_REF_BL_NO   --AS BL_NO" ).append("\n"); 
		query.append(", CGO_CLM_REF_CNTR_NO --AS CNTR_NO" ).append("\n"); 
		query.append(", CRR_TERM_CD			--AS CT" ).append("\n"); 
		query.append(", POR_CD 				--AS POR" ).append("\n"); 
		query.append(", POL_CD 				--AS POL" ).append("\n"); 
		query.append(", POD_CD 				--AS POD" ).append("\n"); 
		query.append(", DEL_CD 				--AS DEL" ).append("\n"); 
		query.append(", DE_DT  				--AS DDL" ).append("\n"); 
		query.append(", N1ST_PRE_REF_VVD_NO --AS FVD" ).append("\n"); 
		query.append(", N1ST_PRE_TS_LOC_CD  --AS PRE_POT" ).append("\n"); 
		query.append(", N1ST_PST_TS_LOC_CD  --AS ON_POT" ).append("\n"); 
		query.append(", CGO_QLTY_DESC       --AS CARGO" ).append("\n"); 
		query.append(", CGO_CLM_TP_CD       --AS TOC" ).append("\n"); 
		query.append(", CLMT_LOCL_AMT       --AS CLAIM_AMOUNT" ).append("\n"); 
		query.append(", CGO_CLM_STL_TP_CD   --AS TOS" ).append("\n"); 
		query.append(", CGO_CLM_STL_DT      --AS DOS" ).append("\n"); 
		query.append(", CGO_CLM_STL_USD_AMT --AS SETTLED_AMOUNT" ).append("\n"); 
		query.append(", PTY_NM2      		--AS SURVEYOR" ).append("\n"); 
		query.append(", SVEY_INP_DT         --AS DOSV" ).append("\n"); 
		query.append(", SVYR_FEE_USD_AMT    --AS SURVEY_FEE" ).append("\n"); 
		query.append(", ROW_NUM" ).append("\n"); 
		query.append(", TOTAL" ).append("\n"); 
		query.append(", CGO_CLM_INCI_NO" ).append("\n"); 
		query.append(", CLM_AREA_CD2    	--AS INCI_A" ).append("\n"); 
		query.append(", CRE_OFC_CD      	--AS INCI_RGOFC" ).append("\n"); 
		query.append(", CRE_USR_ID      	--AS INCI_REGISTER" ).append("\n"); 
		query.append(", CRE_DT          	--AS INCI_DORG" ).append("\n"); 
		query.append(", UPD_DT2         	--AS INCI_UPDATE" ).append("\n"); 
		query.append(", INCI_PLC_TP_CD  	--AS INCI_POI" ).append("\n"); 
		query.append(", INCI_REF_VVD_NO 	--AS INCI_VVD" ).append("\n"); 
		query.append(", INCI_LOC_CD     	--AS INCI_LOCATION" ).append("\n"); 
		query.append(", INCI_OCCR_DT    	--AS INCI_DOI" ).append("\n"); 
		query.append(", INCI_SUBJ_NM    	--AS INCI_SUBJECT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CLM.CGO_CLM_DIV_CD AS CGO_CLM_DIV_CD     			--AS CL" ).append("\n"); 
		query.append(", CLM.CGO_CLM_NO                           			--AS CLM_NO" ).append("\n"); 
		query.append(", CLM.CLM_AREA_CD AS CLM_AREA_CD1          			--AS A" ).append("\n"); 
		query.append(", CLM.HDLR_OFC_CD                          			--AS HOFC" ).append("\n"); 
		query.append(", CGO_CLM_STS_CD AS CGO_CLM_STS_CD 					--AS STS" ).append("\n"); 
		query.append(", DECODE(SMNS_SVE_DT, NULL, 'N', 'Y' ) AS SMNS_SVE_DT -- LIT" ).append("\n"); 
		query.append(", CLM.CS_CLZ_DT                               		--AS DOC" ).append("\n"); 
		query.append(", CLM.PRLM_CLM_NTC_DT                         		--AS NOPC_DATE" ).append("\n"); 
		query.append(", CLM.FMAL_CLM_RCV_DT                         		--AS DOFDATE OF FORMAL CLAIM" ).append("\n"); 
		query.append(", TO_CHAR (CLM.UPD_DT, 'YYYYMMDD') AS UPD_DT1 		--AS UPDATED" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("PTY_NM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CNI_PARTY" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("CLM_PTY_NO = CLM.CLMT_CLM_PTY_NO" ).append("\n"); 
		query.append(") AS PTY_NM1                 --AS CLAIMANT" ).append("\n"); 
		query.append(", CLM.TRNK_REF_VVD_NO          --AS VVD" ).append("\n"); 
		query.append(", BL_DTL.CGO_CLM_REF_BL_NO     --AS BL_NO" ).append("\n"); 
		query.append(", CNTR_DTL.CGO_CLM_REF_CNTR_NO --AS CNTR_NO" ).append("\n"); 
		query.append(", CLM.CRR_TERM_CD              --AS TERM" ).append("\n"); 
		query.append(", CLM.POR_CD                   --AS POR    -- Place of Receipt" ).append("\n"); 
		query.append(", CLM.POL_CD                   --AS POL    -- Port of Loading" ).append("\n"); 
		query.append(", CLM.POD_CD                   --AS POD    -- Port of Discharging" ).append("\n"); 
		query.append(", CLM.DEL_CD                   --AS DEL    -- Place of Delivery" ).append("\n"); 
		query.append(", CLM.DE_DT                    --AS DDL    -- Date of Delivery" ).append("\n"); 
		query.append(", CLM.N1ST_PRE_REF_VVD_NO      --AS FVD                    --Feeder Voyage Direction" ).append("\n"); 
		query.append(", CLM.N1ST_PRE_TS_LOC_CD       --AS PRE_POT                --Pre-Carriage 최초 Port of Transshipment" ).append("\n"); 
		query.append(", CLM.N1ST_PST_TS_LOC_CD       --AS ON_POT                 --On-Carriage 최초 Port of Transshipment" ).append("\n"); 
		query.append(", CLM.CGO_QLTY_DESC            --AS CARGO" ).append("\n"); 
		query.append(", CLM.CGO_CLM_TP_CD                                                   --AS TOC --Type of Claim" ).append("\n"); 
		query.append(", CLM.CLMT_LOCL_AMT                                                   --AS CLAIM_AMOUNT" ).append("\n"); 
		query.append(", CLM.CGO_CLM_STL_TP_CD                                               --AS TOS  --Type of Settlement" ).append("\n"); 
		query.append(", CLM.CGO_CLM_STL_DT                                                  --AS DOS ---Date of Settlement" ).append("\n"); 
		query.append(", CLM.CGO_CLM_STL_USD_AMT                                             --AS SETTLED_AMOUNT" ).append("\n"); 
		query.append(", PARTY.PTY_NM AS PTY_NM2                                             --AS SURVEYOR" ).append("\n"); 
		query.append(", CLM.SVEY_INP_DT                                                     --AS DOSV --Survey 일자" ).append("\n"); 
		query.append(", CLM.SVYR_FEE_USD_AMT                                                --AS SURVEY_FEE" ).append("\n"); 
		query.append(", INCI.CGO_CLM_INCI_NO                                                --AS CGO_CLM_INCI_NO" ).append("\n"); 
		query.append(", CLM_AREA_CD AS CLM_AREA_CD2                                    		--AS INCI_A" ).append("\n"); 
		query.append(", CLM.CRE_OFC_CD                                                      --AS INCI_RGOFC" ).append("\n"); 
		query.append(", INCI.CRE_USR_ID                                                     --AS INCI_REGISTER" ).append("\n"); 
		query.append(", TO_CHAR (INCI.CRE_DT, 'YYYY-MM-DD') AS CRE_DT                       --AS INCI_DORG" ).append("\n"); 
		query.append(", TO_CHAR (INCI.UPD_DT, 'YYYY-MM-DD') AS UPD_DT2                      --AS INCI_UPDATE" ).append("\n"); 
		query.append(", CLM.INCI_PLC_TP_CD                                                  --AS INCI_POI" ).append("\n"); 
		query.append(", CLM.INCI_REF_VVD_NO                                                 --AS INCI_VVD" ).append("\n"); 
		query.append(", CLM.INCI_LOC_CD                                                     --AS INCI_LOCATION" ).append("\n"); 
		query.append(", TO_CHAR (TO_DATE (CLM.INCI_OCCR_DT,'YYYYMMDD'), 'YYYY-MM-DD') AS INCI_OCCR_DT  --AS INCI_DOI" ).append("\n"); 
		query.append(", CLM.INCI_SUBJ_NM                                                    --AS INCI_SUBJECT" ).append("\n"); 
		query.append(", ROW_NUMBER () OVER (ORDER BY CLM.CGO_CLM_NO DESC) ROW_NUM" ).append("\n"); 
		query.append(", COUNT ( *) OVER () TOTAL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CNI_CLM_V CLM" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CGO_CLM_NO" ).append("\n"); 
		query.append(", CGO_CLM_REF_BL_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CNI_CGO_CLM_BL_DTL" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("MN_BL_FLG = 'Y' --대표 B/L 번호" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("BL_DTL" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CGO_CLM_NO" ).append("\n"); 
		query.append(", CGO_CLM_REF_CNTR_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CNI_CGO_CLM_CNTR_DTL" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("MN_CNTR_FLG = 'Y'--대표 컨테이너 번호" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("CNTR_DTL" ).append("\n"); 
		query.append(", CNI_PARTY PARTY" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CGO_CLM_INCI_NO" ).append("\n"); 
		query.append(", CRE_OFC_CD" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", INCI_PLC_TP_CD" ).append("\n"); 
		query.append(", INCI_REF_VVD_NO" ).append("\n"); 
		query.append(", INCI_LOC_CD" ).append("\n"); 
		query.append(", INCI_OCCR_DT" ).append("\n"); 
		query.append(", INCI_SUBJ_NM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CNI_CGO_CLM_INCI" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("CGO_CLM_INCI_NO = @[cgo_clm_inci_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("INCI" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("CLM.CGO_CLM_NO           = BL_DTL.CGO_CLM_NO(+)" ).append("\n"); 
		query.append("AND CLM.CGO_CLM_NO       = CNTR_DTL.CGO_CLM_NO (+)" ).append("\n"); 
		query.append("AND CLM.SVEY_CLM_PTY_NO  = PARTY.CLM_PTY_NO(+)" ).append("\n"); 
		query.append("AND CLM.CGO_CLM_INCI_NO  = INCI.CGO_CLM_INCI_NO" ).append("\n"); 
		query.append("AND CLM.CGO_CLM_INCI_NO  = @[cgo_clm_inci_no]" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("CLM.CGO_CLM_NO DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${start_page} != '')" ).append("\n"); 
		query.append("WHERE ROW_NUM BETWEEN ${start_page} AND ${end_page}" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}