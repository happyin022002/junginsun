/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOAddCntrStatusHistorysByMNRStatusDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.18
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2014.08.18 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOAddCntrStatusHistorysByMNRStatusDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddCntrStatusHistorysByMNRStatusData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOAddCntrStatusHistorysByMNRStatusDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flag_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_ntfy_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flag_user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flag_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flag_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flag_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOAddCntrStatusHistorysByMNRStatusDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	 CNTR_NO" ).append("\n"); 
		query.append("	,CNTR_STS_SEQ" ).append("\n"); 
		query.append("	,CO_CD" ).append("\n"); 
		query.append("	,YD_CD" ).append("\n"); 
		query.append("	,LOC_CD" ).append("\n"); 
		query.append("	,SCC_CD" ).append("\n"); 
		query.append("	,LCC_CD" ).append("\n"); 
		query.append("	,ECC_CD" ).append("\n"); 
		query.append("	,RCC_CD" ).append("\n"); 
		query.append("	,AGMT_CTY_CD" ).append("\n"); 
		query.append("	,AGMT_SEQ" ).append("\n"); 
		query.append("	,CNTR_STS_CD" ).append("\n"); 
		query.append("	,OFC_CD" ).append("\n"); 
		query.append("	,CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("	,PRNR_YD_CD" ).append("\n"); 
		query.append("	,PRNR_STS_SEQ" ).append("\n"); 
		query.append("	,CNTR_STS_RMK" ).append("\n"); 
		query.append("	,CNMV_STS_CD" ).append("\n"); 
		query.append("	,CNTR_FULL_FLG  " ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append("    ,CNTR_LOST_NTFY_DT" ).append("\n"); 
		query.append("    ,CUST_CNT_CD" ).append("\n"); 
		query.append("    ,CUST_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	  @[eq_no]							AS CNTR_NO" ).append("\n"); 
		query.append("	, MST_CNTR_STS_HIS_SEQ.NEXTVAL		AS CNTR_STS_SEQ" ).append("\n"); 
		query.append("	, 'O'								AS CO_CD" ).append("\n"); 
		query.append("	, @[flag_yd_cd]						AS YD_CD" ).append("\n"); 
		query.append("	, SUBSTR(@[flag_yd_cd], 1, 5)		AS LOC_CD" ).append("\n"); 
		query.append("	, MST_LOC_FNC(SUBSTR(@[flag_yd_cd], 1, 5),'SCC')	AS SCC_CD" ).append("\n"); 
		query.append("	, MST_LOC_FNC(SUBSTR(@[flag_yd_cd], 1, 5),'LCC')	AS LCC_CD" ).append("\n"); 
		query.append("	, MST_LOC_FNC(SUBSTR(@[flag_yd_cd], 1, 5),'ECC')	AS ECC_CD" ).append("\n"); 
		query.append("	, MST_LOC_FNC(SUBSTR(@[flag_yd_cd], 1, 5),'RCC')	AS RCC_CD" ).append("\n"); 
		query.append("	, B.AGMT_CTY_CD						AS AGMT_CTY_CD" ).append("\n"); 
		query.append("	, B.AGMT_SEQ						AS AGMT_SEQ" ).append("\n"); 
		query.append("    , B.CNTR_STS_CD                     AS CNTR_STS_CD" ).append("\n"); 
		query.append("	, @[flag_ofc_cd]					AS OFC_CD" ).append("\n"); 
		query.append("	, TRUNC(TO_DATE(@[flag_dt],'YYYYMMDD HH24:MI'))   AS CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("	, C.PRNR_YD_CD				AS PRNR_YD_CD" ).append("\n"); 
		query.append("	, C.PRNR_STS_SEQ			AS PRNR_STS_SEQ" ).append("\n"); 
		query.append("	, NULL						AS CNTR_STS_RMK" ).append("\n"); 
		query.append("	, B.CNMV_STS_CD				AS CNMV_STS_CD" ).append("\n"); 
		query.append("	, B.FULL_FLG				AS CNTR_FULL_FLG" ).append("\n"); 
		query.append("	, @[flag_user_id]			AS CRE_USR_ID" ).append("\n"); 
		query.append("	, SYSDATE					AS CRE_DT" ).append("\n"); 
		query.append("	, @[flag_user_id]			AS UPD_USR_ID" ).append("\n"); 
		query.append("	, SYSDATE					AS UPD_DT" ).append("\n"); 
		query.append("    , TRUNC(TO_DATE(NVL(@[ttl_lss_ntfy_dt],@[flag_dt]) ,'YYYYMMDD HH24:MI')) AS CNTR_LOST_NTFY_DT" ).append("\n"); 
		query.append("    , @[cust_cnt_cd]            AS CUST_CNT_CD" ).append("\n"); 
		query.append("    , @[cust_seq]               AS CUST_SEQ" ).append("\n"); 
		query.append("FROM	DUAL A, " ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		SELECT A.FULL_FLG, A.AGMT_CTY_CD, A.AGMT_SEQ, " ).append("\n"); 
		query.append("               DECODE(@[sts_flag],'Y',@[flag_type],DECODE(B.LSTM_CD,'OW','OWN','LSI')) CNTR_STS_CD, " ).append("\n"); 
		query.append("               A.CNMV_STS_CD" ).append("\n"); 
		query.append("		FROM MST_CONTAINER A, LSE_AGREEMENT B " ).append("\n"); 
		query.append("        WHERE A.CNTR_NO = @[eq_no]" ).append("\n"); 
		query.append("        AND   A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND   A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("	) B," ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("			MAX(A.YD_CD)            AS PRNR_YD_CD," ).append("\n"); 
		query.append("			MAX(A.CNTR_STS_SEQ)    	AS PRNR_STS_SEQ " ).append("\n"); 
		query.append("		FROM" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT /*+ INDEX_DESC(H XAK1MST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("					H.CNTR_STS_SEQ," ).append("\n"); 
		query.append("					H.YD_CD" ).append("\n"); 
		query.append("			FROM MST_CNTR_STS_HIS H" ).append("\n"); 
		query.append("			WHERE CNTR_NO = @[eq_no]" ).append("\n"); 
		query.append("			AND CNTR_STS_CD IN('LSI','DII','OWN')" ).append("\n"); 
		query.append("                        AND @[sts_flag] = 'Y' " ).append("\n"); 
		query.append("			AND ROWNUM = 1" ).append("\n"); 
		query.append("			UNION " ).append("\n"); 
		query.append("			SELECT NULL CNTR_STS_SEQ, NULL YD_CD  FROM DUAL" ).append("\n"); 
		query.append("		) A" ).append("\n"); 
		query.append("	) C" ).append("\n"); 

	}
}