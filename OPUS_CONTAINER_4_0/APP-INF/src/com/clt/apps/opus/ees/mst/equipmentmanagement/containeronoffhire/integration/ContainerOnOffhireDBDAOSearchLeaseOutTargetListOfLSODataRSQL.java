/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOSearchLeaseOutTargetListOfLSODataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.11
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOSearchLeaseOutTargetListOfLSODataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchLeaseOutTargetListOfLSOData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOSearchLeaseOutTargetListOfLSODataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hire_date",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOSearchLeaseOutTargetListOfLSODataRSQL").append("\n"); 
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
		query.append("SELECT  AA.CNTR_NO" ).append("\n"); 
		query.append("        , AA.OFFH_STS_CD" ).append("\n"); 
		query.append("        , AA.OFFH_DUE_DT" ).append("\n"); 
		query.append("        , AA.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , AA.LSTM_CD" ).append("\n"); 
		query.append("        , AA.AGMT_CTY_CD" ).append("\n"); 
		query.append("        , AA.AGMT_NO" ).append("\n"); 
		query.append("        , AA.REF_NO" ).append("\n"); 
		query.append("        , AA.VNDR_SEQ" ).append("\n"); 
		query.append("        , AA.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("        , AA.CNTR_STS_CD" ).append("\n"); 
		query.append("        , AA.CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("        , AA.FULL_FLG" ).append("\n"); 
		query.append("        , AA.CNMV_STS_CD" ).append("\n"); 
		query.append("        , AA.CRNT_YD_CD" ).append("\n"); 
		query.append("        , AA.CNMV_DT" ).append("\n"); 
		query.append("        , AA.CNTR_DOC_CHG_AMT AS CNTR_DRFF_AMT   " ).append("\n"); 
		query.append("        , '' CNTR_DRFF_CR_AMT" ).append("\n"); 
		query.append("        , AA.CNTR_LFT_CHG_AMT" ).append("\n"); 
		query.append("        , AA.CNTR_LFT_CHG_CUR" ).append("\n"); 
		query.append("        , '' RNTL_CHG_FREE_DYS" ).append("\n"); 
		query.append("        , '' CNTR_OLD_VAN_FLG" ).append("\n"); 
		query.append("        , '' CNTR_PKUP_CHG_AMT" ).append("\n"); 
		query.append("        , '' CNTR_PKUP_CR_CHG_AMT" ).append("\n"); 
		query.append("        , '' CNTR_RMK" ).append("\n"); 
		query.append("        , AA.OFFH_YD_CD LSE_CO_RTN_YD_CD" ).append("\n"); 
		query.append("		, AA.EFF_DT" ).append("\n"); 
		query.append("        , AA.EXP_DT " ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  #if (${agmt_cty_cd} == '' || ${agmt_seq} == '')" ).append("\n"); 
		query.append("                  /*+ LEADING(A B) USE_NL(A B) */" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                  A.OFFH_YD_CD" ).append("\n"); 
		query.append("                , B.CNTR_NO" ).append("\n"); 
		query.append("                , CASE WHEN A.OFFH_STS_CD = 'C' THEN 'Y'" ).append("\n"); 
		query.append("                     ELSE ''                  END AS OFFH_STS_CD" ).append("\n"); 
		query.append("                , CASE WHEN A.OFFH_STS_CD = 'C' THEN TO_CHAR(TO_DATE(A.OFFH_DUE_DT,'YYYY-MM-DD'), 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                     ELSE ''                  END AS OFFH_DUE_DT" ).append("\n"); 
		query.append("                , B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                , B.LSTM_CD" ).append("\n"); 
		query.append("                , B.AGMT_CTY_CD" ).append("\n"); 
		query.append("                , MST_COMMON_PKG.MST_AGMT_NO_CONV_FNC(B.AGMT_CTY_CD, B.AGMT_SEQ)  AS AGMT_NO" ).append("\n"); 
		query.append("                , C.REF_NO" ).append("\n"); 
		query.append("                , B.VNDR_SEQ" ).append("\n"); 
		query.append("                , D.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                , B.CNTR_STS_CD" ).append("\n"); 
		query.append("                , (" ).append("\n"); 
		query.append("                SELECT  /*+ INDEX_DESC(H XAK1MST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("                        TO_CHAR(H.CNTR_STS_EVNT_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("                FROM    MST_CNTR_STS_HIS H" ).append("\n"); 
		query.append("                WHERE   H.CNTR_NO       = B.CNTR_NO" ).append("\n"); 
		query.append("                AND     H.CNTR_STS_SEQ  = B.LST_STS_SEQ" ).append("\n"); 
		query.append("                AND     ROWNUM          = 1" ).append("\n"); 
		query.append("                )  AS CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("      	        , NVL(MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC(NVL(@[agmt_cty_cd], C.AGMT_CTY_CD), NVL(@[agmt_seq], C.AGMT_SEQ), 'LOF', B.CNTR_TPSZ_CD, @[sts_evnt_yd_cd]), 0) AS CNTR_LFT_CHG_AMT" ).append("\n"); 
		query.append("      	        , NVL(MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC(NVL(@[agmt_cty_cd], C.AGMT_CTY_CD), NVL(@[agmt_seq], C.AGMT_SEQ), 'DOC', B.CNTR_TPSZ_CD, @[sts_evnt_yd_cd]), 0) AS CNTR_DOC_CHG_AMT" ).append("\n"); 
		query.append("                , (" ).append("\n"); 
		query.append("                SELECT CURR_CD" ).append("\n"); 
		query.append("                FROM    LSE_AGREEMENT" ).append("\n"); 
		query.append("                WHERE   AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("                AND     AGMT_SEQ    = B.AGMT_SEQ" ).append("\n"); 
		query.append("                ) AS CNTR_LFT_CHG_CUR" ).append("\n"); 
		query.append("                , DECODE(B.FULL_FLG, 'Y', 'F', 'N', 'M') FULL_FLG" ).append("\n"); 
		query.append("                , B.CNMV_STS_CD" ).append("\n"); 
		query.append("                , B.CRNT_YD_CD" ).append("\n"); 
		query.append("                , TO_CHAR(B.CNMV_DT, 'YYYY-MM-DD') CNMV_DT" ).append("\n"); 
		query.append("				, TO_CHAR(C.LST_EFF_DT,'YYYY-MM-DD') AS EFF_DT " ).append("\n"); 
		query.append("                , TO_CHAR(C.LST_EXP_DT,'YYYY-MM-DD') AS EXP_DT      " ).append("\n"); 
		query.append("        FROM    LSE_AVAL_OFFH   A," ).append("\n"); 
		query.append("                MST_CONTAINER   B," ).append("\n"); 
		query.append("                LSE_AGREEMENT   C," ).append("\n"); 
		query.append("                MDM_VENDOR      D" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("        #if (${agmt_cty_cd} != '' && ${agmt_seq} != '')" ).append("\n"); 
		query.append("        AND   A.AGMT_CTY_CD  =  @[agmt_cty_cd]" ).append("\n"); 
		query.append("        AND   A.AGMT_SEQ     =  TO_NUMBER(@[agmt_seq])" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        AND   A.CNTR_NO      = B.CNTR_NO" ).append("\n"); 
		query.append("        AND   A.OFFH_STS_CD  = 'C'" ).append("\n"); 
		query.append("        AND   B.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("        AND   C.AGMT_CTY_CD  = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND   C.AGMT_SEQ     = A.AGMT_SEQ" ).append("\n"); 
		query.append("        AND   D.VNDR_SEQ     = A.VNDR_SEQ" ).append("\n"); 
		query.append("        AND   B.CNMV_STS_CD IN ('MT', 'ID', 'TN', 'EN')" ).append("\n"); 
		query.append("        AND   B.CRNT_YD_CD   = @[sts_evnt_yd_cd]" ).append("\n"); 
		query.append("        AND   TRUNC(B.CNMV_DT) <= TO_DATE(REPLACE(@[hire_date],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("        ) AA" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 

	}
}