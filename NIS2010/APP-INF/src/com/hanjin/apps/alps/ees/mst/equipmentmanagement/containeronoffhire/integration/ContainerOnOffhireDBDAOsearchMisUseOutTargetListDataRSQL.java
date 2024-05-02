/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOsearchMisUseOutTargetListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.17
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOsearchMisUseOutTargetListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchMisUseOutTargetListData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOsearchMisUseOutTargetListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_drff_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_evnt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_drff_cr_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOsearchMisUseOutTargetListDataRSQL").append("\n"); 
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
		query.append("SELECT                                                                                                " ).append("\n"); 
		query.append("	AA.EEFLG,                                                                                             " ).append("\n"); 
		query.append("	AA.CNTR_NO,                                                                                           " ).append("\n"); 
		query.append("	'' OFFH_STS_CD,                                                                                       " ).append("\n"); 
		query.append("	'' OFFH_DUE_DT,                                                                                       " ).append("\n"); 
		query.append("	AA.CNTR_TPSZ_CD,                                                                                      " ).append("\n"); 
		query.append("	AA.LSTM_CD,                                                                                           " ).append("\n"); 
		query.append("	AA.AGMT_CTY_CD,                                                                                       " ).append("\n"); 
		query.append("	AA.AGMT_NO,                                                                                           " ).append("\n"); 
		query.append("	AA.REF_NO,                                                                                            " ).append("\n"); 
		query.append("	AA.VNDR_SEQ,                                                                                          " ).append("\n"); 
		query.append("	AA.VNDR_LGL_ENG_NM,                                                                                   " ).append("\n"); 
		query.append("	AA.CNTR_STS_CD,                                                                                       " ).append("\n"); 
		query.append("	AA.CNTR_STS_EVNT_DT,                                                                                  " ).append("\n"); 
		query.append("	AA.FULL_FLG,                                                                                          " ).append("\n"); 
		query.append("	AA.CNMV_STS_CD,                                                                                       " ).append("\n"); 
		query.append("	AA.CRNT_YD_CD,                                                                                        " ).append("\n"); 
		query.append("	AA.CNMV_DT," ).append("\n"); 
		query.append("#if(${cntr_drff_amt} != '')" ).append("\n"); 
		query.append("	@[cntr_drff_amt] CNTR_DRFF_AMT," ).append("\n"); 
		query.append("#else                                                                                            " ).append("\n"); 
		query.append("	AA.CNTR_DRFF_AMT,                                                                                     " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	@[cntr_drff_cr_amt] CNTR_DRFF_CR_AMT," ).append("\n"); 
		query.append("	AA.CNTR_LFT_CHG_AMT,                                                                                  " ).append("\n"); 
		query.append("	AA.CNTR_LFT_CHG_CUR,                                                                                  " ).append("\n"); 
		query.append("	'' RNTL_CHG_FREE_DYS,                                                                                 " ).append("\n"); 
		query.append("	'' CNTR_OLD_VAN_FLG,                                                                                  " ).append("\n"); 
		query.append("	'' CNTR_PKUP_CHG_AMT,                                                                                 " ).append("\n"); 
		query.append("	'' CNTR_PKUP_CR_CHG_AMT,                                                                              " ).append("\n"); 
		query.append("	@[cntr_rmk] CNTR_RMK                                                                                           " ).append("\n"); 
		query.append("FROM                                                                                                  " ).append("\n"); 
		query.append("(                                                                                                     " ).append("\n"); 
		query.append("	SELECT                                                                                                " ).append("\n"); 
		query.append("		'' EEFLG,  " ).append("\n"); 
		query.append("		B.CNTR_NO,                                                                                            " ).append("\n"); 
		query.append("		B.CNTR_TPSZ_CD,                                                                                       " ).append("\n"); 
		query.append("		B.LSTM_CD,                                                                                            " ).append("\n"); 
		query.append("		B.AGMT_CTY_CD,                                                                                        " ).append("\n"); 
		query.append("		MST_COMMON_PKG.MST_AGMT_NO_CONV_FNC(B.AGMT_CTY_CD,B.AGMT_SEQ)  AS AGMT_NO,                            " ).append("\n"); 
		query.append("		C.REF_NO,                                                                                             " ).append("\n"); 
		query.append("		B.VNDR_SEQ,                                                                                           " ).append("\n"); 
		query.append("		D.VNDR_LGL_ENG_NM,                                                                                    " ).append("\n"); 
		query.append("		B.CNTR_STS_CD,                                                                                        " ).append("\n"); 
		query.append("		(SELECT /*+ INDEX_DESC(H XAK1MST_CNTR_STS_HIS) */ TO_CHAR(H.CNTR_STS_EVNT_DT,'YYYY-MM-DD')             " ).append("\n"); 
		query.append("		FROM MST_CNTR_STS_HIS H                                                                               " ).append("\n"); 
		query.append("		WHERE H.CNTR_NO = B.CNTR_NO                                                                           " ).append("\n"); 
		query.append("        AND   H.CNTR_STS_SEQ = B.LST_STS_SEQ                                                            " ).append("\n"); 
		query.append("		AND   ROWNUM = 1                                                                                      " ).append("\n"); 
		query.append("		) CNTR_STS_EVNT_DT,                                                                                   " ).append("\n"); 
		query.append("		DECODE(B.FULL_FLG, 'Y', 'F', 'M') FULL_FLG,                                                           " ).append("\n"); 
		query.append("		B.CNMV_STS_CD,                                                                                        " ).append("\n"); 
		query.append("		B.CRNT_YD_CD,                                                                                         " ).append("\n"); 
		query.append("		TO_CHAR(B.CNMV_DT, 'YYYY-MM-DD') CNMV_DT,                                                             " ).append("\n"); 
		query.append("		(SELECT N1ST_CHG_AMT                                                                                  " ).append("\n"); 
		query.append("		FROM LSE_AGMT_RT                                                                                      " ).append("\n"); 
		query.append("		WHERE 1 = 1                                                                                           " ).append("\n"); 
		query.append("		AND   (AGMT_CTY_CD, AGMT_SEQ) =                                                                       " ).append("\n"); 
		query.append("		(SELECT /*+ INDEX_DESC(H XAK1MST_CNTR_STS_HIS) */ H.AGMT_CTY_CD, H.AGMT_SEQ                            " ).append("\n"); 
		query.append("		FROM MST_CNTR_STS_HIS H                                                                               " ).append("\n"); 
		query.append("		WHERE H.CNTR_NO = B.CNTR_NO " ).append("\n"); 
		query.append("        AND   H.CNTR_STS_CD = 'MUO'                                                                             " ).append("\n"); 
		query.append("		AND   ROWNUM = 1)                                                                                     " ).append("\n"); 
		query.append("		AND   CNTR_RNTL_CHG_TP_CD ='DOCV'                                                                     " ).append("\n"); 
		query.append("		AND   LOC_CD       = (SELECT  SCC_CD                                                                  " ).append("\n"); 
		query.append("		FROM MDM_LOCATION                                                                                     " ).append("\n"); 
		query.append("		WHERE LOC_CD = SUBSTR(@[sts_evnt_yd_cd], 1, 5))                                                       " ).append("\n"); 
		query.append("		AND   CNTR_TPSZ_CD = B.CNTR_TPSZ_CD                                                                   " ).append("\n"); 
		query.append("		) CNTR_DRFF_AMT,                                                                                      " ).append("\n"); 
		query.append("		(SELECT N2ND_CHG_AMT                                                                                  " ).append("\n"); 
		query.append("		FROM LSE_AGMT_RT                                                                                      " ).append("\n"); 
		query.append("		WHERE 1 = 1                                                                                           " ).append("\n"); 
		query.append("		AND   (AGMT_CTY_CD, AGMT_SEQ) =                                                                       " ).append("\n"); 
		query.append("		(SELECT /*+ INDEX_DESC(H XAK1MST_CNTR_STS_HIS) */ H.AGMT_CTY_CD, H.AGMT_SEQ                            " ).append("\n"); 
		query.append("		FROM MST_CNTR_STS_HIS H                                                                               " ).append("\n"); 
		query.append("		WHERE H.CNTR_NO = B.CNTR_NO " ).append("\n"); 
		query.append("        AND   H.CNTR_STS_CD = 'MUO'                                                                            " ).append("\n"); 
		query.append("		AND   ROWNUM = 1)                                                                                     " ).append("\n"); 
		query.append("		AND   CNTR_RNTL_CHG_TP_CD ='LIFV'                                                                     " ).append("\n"); 
		query.append("		AND   LOC_CD       = (SELECT  SCC_CD                                                                  " ).append("\n"); 
		query.append("		FROM MDM_LOCATION                                                                                     " ).append("\n"); 
		query.append("		WHERE LOC_CD = SUBSTR(@[sts_evnt_yd_cd], 1, 5))                                                       " ).append("\n"); 
		query.append("		AND   CNTR_TPSZ_CD = B.CNTR_TPSZ_CD                                                                   " ).append("\n"); 
		query.append("		) CNTR_LFT_CHG_AMT,                                                                                   " ).append("\n"); 
		query.append("		(SELECT CURR_CD                                                                                       " ).append("\n"); 
		query.append("		FROM LSE_AGREEMENT                                                                                    " ).append("\n"); 
		query.append("		WHERE AGMT_CTY_CD = B.AGMT_CTY_CD                                                                     " ).append("\n"); 
		query.append("		AND   AGMT_SEQ    = B.AGMT_SEQ                                                                        " ).append("\n"); 
		query.append("		) CNTR_LFT_CHG_CUR                                                                                    " ).append("\n"); 
		query.append("	FROM                                                                                                  " ).append("\n"); 
		query.append("		MST_CONTAINER  B,                                                                                     " ).append("\n"); 
		query.append("		LSE_AGREEMENT C,                                                                                      " ).append("\n"); 
		query.append("		MDM_VENDOR D                                                                                          " ).append("\n"); 
		query.append("	WHERE 1 = 1                                                                                           " ).append("\n"); 
		query.append("		--AND  B.CNTR_STS_CD = 'MUO'   " ).append("\n"); 
		query.append("		AND  B.CNTR_NO        = @[cntr_no]                                                                         " ).append("\n"); 
		query.append("		AND  C.AGMT_CTY_CD    = B.AGMT_CTY_CD                                                                 " ).append("\n"); 
		query.append("		AND  C.AGMT_SEQ       = B.AGMT_SEQ                                                                    " ).append("\n"); 
		query.append("		AND  D.VNDR_SEQ       = B.VNDR_SEQ                                                                    " ).append("\n"); 
		query.append(") AA" ).append("\n"); 

	}
}