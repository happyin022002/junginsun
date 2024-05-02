/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CimCommonDBODAOscarContainerInformationListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CimCommonDBODAOscarContainerInformationListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Information 조회
	  * </pre>
	  */
	public CimCommonDBODAOscarContainerInformationListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration").append("\n"); 
		query.append("FileName : CimCommonDBODAOscarContainerInformationListRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("	ROW_NUMBER() OVER (ORDER BY BC.CNTR_NO) AS CNTR_ROW_SEQ" ).append("\n"); 
		query.append("    , DECODE(" ).append("\n"); 
		query.append("		(SELECT COUNT(CNTR_NO) FROM CTM_MVMT_EDI_MSG EM WHERE EM.CNTR_NO=BC.CNTR_NO AND    EM.MVMT_EDI_RSLT_CD != 'Y')" ).append("\n"); 
		query.append("		,0,'','Y') AS CNTR_ERR_CNT" ).append("\n"); 
		query.append("	, BC.CNMV_CYC_NO						AS CNTR_CNMV_CYC_NO" ).append("\n"); 
		query.append("	, BC.CNTR_NO							AS CNTR_NO" ).append("\n"); 
		query.append("	, BC.CNTR_TPSZ_CD						AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	, BC.RCV_TERM_CD						AS CNTR_RCV_TERM_CD" ).append("\n"); 
		query.append("	, BC.DE_TERM_CD							AS CNTR_DE_TERM_CD" ).append("\n"); 
		query.append("	, BC.CNTR_VOL_QTY						AS CNTR_VOL_QTY" ).append("\n"); 
		query.append("	, BC.DCGO_FLG							AS CNTR_DCGO_FLG" ).append("\n"); 
		query.append("	, BC.RC_FLG								AS CNTR_RC_FLG" ).append("\n"); 
		query.append("	, BC.BB_CGO_FLG							AS CNTR_BB_CGO_FLG" ).append("\n"); 
		query.append("	, BC.AWK_CGO_FLG						AS CNTR_AWK_CGO_FLG" ).append("\n"); 
		query.append("	, BC.RD_CGO_FLG							AS CNTR_RD_CGO_FLG" ).append("\n"); 
		query.append("	, BC.CNTR_CFM_FLG						AS CNTR_CFM_FLG" ).append("\n"); 
		query.append("	, LA.VNDR_SEQ							AS CNTR_VNDR_SEQ" ).append("\n"); 
		query.append("	,(SELECT MV.VNDR_ABBR_NM" ).append("\n"); 
		query.append("	   FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("	  WHERE MV.VNDR_SEQ = LA.VNDR_SEQ" ).append("\n"); 
		query.append("	  AND    ROWNUM      = 1" ).append("\n"); 
		query.append("	) 										AS CNTR_VNDR_ABBR_NM" ).append("\n"); 
		query.append("	, LA.LSTM_CD							AS CNTR_LSTM_CD" ).append("\n"); 
		query.append("	, LA.AGMT_CTY_CD || LPAD(LA.AGMT_SEQ,6,'0') 						AS CNTR_AGMT_CTY_CD" ).append("\n"); 
		query.append("	, LA.AGMT_SEQ							AS CNTR_AGMT_SEQ" ).append("\n"); 
		query.append("	, LA.REF_NO								AS CNTR_REF_NO" ).append("\n"); 
		query.append("	, TO_CHAR(MC.ONH_DT,'YYYYMMDD') 		AS CNTR_ONH_DT" ).append("\n"); 
		query.append("	, MC.ONH_YD_CD							AS CNTR_ONH_YD_CD" ).append("\n"); 
		query.append("	, MC.ONH_FREE_DYS						AS CNTR_ONH_FREE_DYS" ).append("\n"); 
		query.append("	, MC.MIN_ONH_DYS						AS CNTR_MIN_ONH_DYS" ).append("\n"); 
		query.append("	, CASE WHEN MC.LSTM_CD IN('OW','LP','OL') THEN " ).append("\n"); 
		query.append("			ROUND(SYSDATE - MC.MFT_DT)" ).append("\n"); 
		query.append("	  ELSE " ).append("\n"); 
		query.append("			ROUND(SYSDATE - MC.ONH_DT) " ).append("\n"); 
		query.append("	  END 									AS CNTR_USED_DYS" ).append("\n"); 
		query.append("	, TO_CHAR(MC.CNMV_DT,'YYYYMMDD') 		AS CNTR_CNMV_DT " ).append("\n"); 
		query.append("	, MC.CNTR_STS_CD						AS CNTR_STS_CD" ).append("\n"); 
		query.append("	, MC.CNMV_STS_CD						AS CNTR_CNMV_STS_CD" ).append("\n"); 
		query.append("	, MC.CRNT_YD_CD							AS CNTR_CRNT_YD_CD" ).append("\n"); 
		query.append("    , BC.CRE_USR_ID                         AS CRE_USR_ID" ).append("\n"); 
		query.append("    , BC.UPD_USR_ID                         AS UPD_USR_ID" ).append("\n"); 
		query.append("    , TO_CHAR(BC.OSCA_CRE_DT,'YYYY.MM.DD HH24:MI:SS') 		AS CRE_DT" ).append("\n"); 
		query.append("    , TO_CHAR(BC.OSCA_UPD_DT,'YYYY.MM.DD HH24:MI:SS') 		AS UPD_DT" ).append("\n"); 
		query.append("FROM  " ).append("\n"); 
		query.append("	CIM_BKG_CNTR_V BC " ).append("\n"); 
		query.append("	,  MST_CONTAINER MC" ).append("\n"); 
		query.append("	,  LSE_AGREEMENT LA            " ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     BC.CNTR_NO      = MC.CNTR_NO(+)" ).append("\n"); 
		query.append("AND     MC.AGMT_CTY_CD 	= LA.AGMT_CTY_CD(+)       " ).append("\n"); 
		query.append("AND     MC.AGMT_SEQ     = LA.AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND     BC.BKG_NO       = @[h_bkg_no]" ).append("\n"); 
		query.append("ORDER BY BC.CNTR_NO" ).append("\n"); 

	}
}