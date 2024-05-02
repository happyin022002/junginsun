/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OnhireApprovalDBDAOsearchApprovalOwnListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.30
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2015.06.30 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnhireApprovalDBDAOsearchApprovalOwnListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 자가컨테이너 pick up 한 장비에 auth no를 붙이기 위한 조회 처리
	  * </pre>
	  */
	public OnhireApprovalDBDAOsearchApprovalOwnListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.integration").append("\n"); 
		query.append("FileName : OnhireApprovalDBDAOsearchApprovalOwnListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("      A.CNTR_NO             CNTR_NO" ).append("\n"); 
		query.append("    , A.CNTR_TPSZ_CD        TYSZ" ).append("\n"); 
		query.append("    , SUBSTR(B.YD_CD,1,7)   PUP_YARD" ).append("\n"); 
		query.append("    , TO_CHAR(B.CNTR_STS_EVNT_DT,'YYYY-MM-DD') PUP_DATE" ).append("\n"); 
		query.append("    , B.CNTR_AUTH_NO        AUTH_NO" ).append("\n"); 
		query.append("    , C.AGMT_CTY_CD         AGMT_NO1" ).append("\n"); 
		query.append("    , C.AGMT_SEQ            AGMT_NO2" ).append("\n"); 
		query.append("    , C.AGMT_CTY_CD || LTRIM(To_CHAR(C.AGMT_SEQ,'000000')) AGMT_NO" ).append("\n"); 
		query.append("    , DECODE(B.CNTR_OLD_VAN_FLG,'Y','New','Old') NEW_VAN_TYPE" ).append("\n"); 
		query.append("    , B.CNTR_STS_SEQ" ).append("\n"); 
		query.append("    , C.LSTM_CD    " ).append("\n"); 
		query.append("    ,'' AUTH_VOL" ).append("\n"); 
		query.append("    ,'' PUP_VOL    " ).append("\n"); 
		query.append("    ,'' REMARK" ).append("\n"); 
		query.append("    ,'' PKUP_DUE_DT" ).append("\n"); 
		query.append("    ,'' AUTH_CNTR_VOL" ).append("\n"); 
		query.append("    ,'' PICKUP_VOL" ).append("\n"); 
		query.append("    ,A.CNTR_TPSZ_CD || SUBSTR(B.YD_CD,1,5) || C.AGMT_CTY_CD|| LTRIM(To_CHAR(C.AGMT_SEQ,'000000')) LIST_KEY" ).append("\n"); 
		query.append("    ,'' AUTH_CNTR_VOL_ORG" ).append("\n"); 
		query.append("FROM MST_CONTAINER A, MST_CNTR_STS_HIS B , LSE_AGREEMENT C " ).append("\n"); 
		query.append("WHERE A.CNTR_NO   = B.CNTR_NO" ).append("\n"); 
		query.append("AND B.AGMT_CTY_CD = C.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND B.AGMT_SEQ    = C.AGMT_SEQ" ).append("\n"); 
		query.append("AND C.LSTM_CD IN ('OW','LP','OL')" ).append("\n"); 
		query.append("AND B.CNTR_STS_EVNT_DT >= TO_DATE('20150801','RRRRMMDD')" ).append("\n"); 
		query.append("AND B.CNTR_AUTH_NO IS NULL" ).append("\n"); 
		query.append("AND B.CNTR_STS_CD IN ('OWN','LSI')" ).append("\n"); 
		query.append("AND B.CNTR_LSTM_CNG_FLG = 'N'" ).append("\n"); 
		query.append("AND A.CO_CRE_FLG       = 'N'" ).append("\n"); 
		query.append("AND A.ACIAC_DIV_CD      = 'A'" ).append("\n"); 
		query.append("AND SUBSTR(B.YD_CD,1,5) IN ( SELECT SCC_CD" ).append("\n"); 
		query.append("                             FROM   MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("                             WHERE  DECODE(@[loc_tp] ,'R', RCC_CD,'L', LCC_CD) = @[loc_cd])" ).append("\n"); 

	}
}