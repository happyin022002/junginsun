/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchQueueDetailReturnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.05
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.03.05 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchQueueDetailReturnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOSearchQueueDetailReturnRSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchQueueDetailReturnRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_his_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchQueueDetailReturnRSQL").append("\n"); 
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
		query.append("*" ).append("\n"); 
		query.append("FROM  (SELECT" ).append("\n"); 
		query.append("SR_KND_CD," ).append("\n"); 
		query.append("SR_NO," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("SR_HIS_SEQ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SR_STS_CD," ).append("\n"); 
		query.append("SR_PROC_STS_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ATND_USR_ID,/*로그인 ID*/" ).append("\n"); 
		query.append("ST_DT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FNT_OFC_RTN_CD AS UI_GRP_CD, /* UI WRK_GRP_CD 상에서 FO 'S', INPUTER 'I', RATER 'R' */" ).append("\n"); 
		query.append("DIFF_RMK AS MESSAGE," ).append("\n"); 
		query.append("SR_RTN_TO_STS_CD,/* UI WRK_GRP_CD 상에서 FO 'S', INPUTER 'I', RATER 'R' */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("RTN_TO_USR_ID,/*로그인 ID*/" ).append("\n"); 
		query.append("RTN_TO_RTN_STS_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("RTN_TO_RTN_USR_ID,/*로그인 ID*/" ).append("\n"); 
		query.append("RTN_DT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("RSN_BKG_MN_FLG    AS RSN_BKG_MN_FLG,    /*BKG Main*/" ).append("\n"); 
		query.append("RSN_CUST_INFO_FLG AS RSN_CUST_INFO_FLG, /*Customer INFO*/" ).append("\n"); 
		query.append("RSN_FRT_CHG_FLG   AS RSN_FRT_CHG_FLG,   /*FRT & Charge*/" ).append("\n"); 
		query.append("RSN_CNTR_FLG      AS RSN_CNTR_FLG,      /*Container*/" ).append("\n"); 
		query.append("RSN_CNTR_MF_FLG   AS RSN_CNTR_MF_FLG,   /*Container Manifest*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("RSN_DCGO_FLG      AS RSN_DCGO_FLG,      /*Danger*/" ).append("\n"); 
		query.append("RSN_AWK_CGO_FLG   AS RSN_AWK_CGO_FLG,   /*Awkward*/" ).append("\n"); 
		query.append("RSN_RC_FLG        AS RSN_RC_FLG,        /*Reefer*/" ).append("\n"); 
		query.append("RSN_BB_CGO_FLG    AS RSN_BB_CGO_FLG,    /*B/Bulk*/" ).append("\n"); 
		query.append("RSN_RLY_PORT_FLG  AS RSN_RLY_PORT_FLG,  /*RLY VVD & Port*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("RSN_NEW_BKG_FLG   AS RSN_NEW_BKG_FLG,   /*New BKG*/" ).append("\n"); 
		query.append("RSN_SPLIT_FLG     AS RSN_SPLIT_FLG,     /*BKG Split*/" ).append("\n"); 
		query.append("RSN_BL_INFO_FLG   AS RSN_BL_INFO_FLG,   /*BL Inform*/" ).append("\n"); 
		query.append("RSN_HBL_FLG       AS RSN_HBL_FLG,        /*NVO House BL*/" ).append("\n"); 
		query.append("RSN_MK_DESC_FLG   AS CUST_VERIF_FLG    /*Customer Verification*/" ).append("\n"); 
		query.append("FROM BKG_SR_HIS" ).append("\n"); 
		query.append("WHERE SR_KND_CD = @[src_cd] /* 0421의 SRC_CD*/" ).append("\n"); 
		query.append("AND  SR_NO    = @[sr_no]" ).append("\n"); 
		query.append("AND  BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sr_his_seq} != '')" ).append("\n"); 
		query.append("AND  SR_HIS_SEQ   = @[sr_his_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY SR_HIS_SEQ DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM =1" ).append("\n"); 

	}
}