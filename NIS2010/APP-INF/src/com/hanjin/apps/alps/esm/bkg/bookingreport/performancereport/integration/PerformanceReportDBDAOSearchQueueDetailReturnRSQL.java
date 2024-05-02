/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchQueueDetailReturnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.13
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("*" ).append("\n"); 
		query.append("FROM  (SELECT " ).append("\n"); 
		query.append("              H.SR_KND_CD," ).append("\n"); 
		query.append("              H.SR_NO," ).append("\n"); 
		query.append("              H.BKG_NO," ).append("\n"); 
		query.append("              H.SR_HIS_SEQ," ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              H.SR_STS_CD," ).append("\n"); 
		query.append("              H.SR_PROC_STS_CD," ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              H.ATND_USR_ID,/*로그인 ID*/" ).append("\n"); 
		query.append("              TO_CHAR(H.ST_DT,'YYYY-MM-DD HH24:MI') ST_DT," ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              H.FNT_OFC_RTN_CD AS UI_GRP_CD, /* UI WRK_GRP_CD 상에서 FO 'S', INPUTER 'I', RATER 'R' */" ).append("\n"); 
		query.append("              H.DIFF_RMK AS MESSAGE," ).append("\n"); 
		query.append("              H.SR_RTN_TO_STS_CD,/* UI WRK_GRP_CD 상에서 FO 'S', INPUTER 'I', RATER 'R' */" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              H.RTN_TO_USR_ID,/*로그인 ID*/" ).append("\n"); 
		query.append("              H.RTN_TO_RTN_STS_CD," ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              H.RTN_TO_RTN_USR_ID,/*로그인 ID*/" ).append("\n"); 
		query.append("              H.RTN_DT," ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              H.RTN_TO_USR_EML," ).append("\n"); 
		query.append("              H.RSN_BKG_MN_FLG    AS RSN_BKG_MN_FLG,    /*BKG Main*/" ).append("\n"); 
		query.append("              H.RSN_CUST_INFO_FLG AS RSN_CUST_INFO_FLG, /*Customer INFO*/" ).append("\n"); 
		query.append("              H.RSN_FRT_CHG_FLG   AS RSN_FRT_CHG_FLG,   /*FRT & Charge*/" ).append("\n"); 
		query.append("              H.RSN_CNTR_FLG      AS RSN_CNTR_FLG,      /*Container*/" ).append("\n"); 
		query.append("              H.RSN_CNTR_MF_FLG   AS RSN_CNTR_MF_FLG,   /*Container Manifest*/" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              H.RSN_DCGO_FLG      AS RSN_DCGO_FLG,      /*Danger*/" ).append("\n"); 
		query.append("              H.RSN_AWK_CGO_FLG   AS RSN_AWK_CGO_FLG,   /*Awkward*/" ).append("\n"); 
		query.append("              H.RSN_RC_FLG        AS RSN_RC_FLG,        /*Reefer*/" ).append("\n"); 
		query.append("              H.RSN_BB_CGO_FLG    AS RSN_BB_CGO_FLG,    /*B/Bulk*/" ).append("\n"); 
		query.append("              H.RSN_RLY_PORT_FLG  AS RSN_RLY_PORT_FLG,  /*RLY VVD & Port*/" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              H.RSN_NEW_BKG_FLG   AS RSN_NEW_BKG_FLG,   /*New BKG*/" ).append("\n"); 
		query.append("              H.RSN_SPLIT_FLG     AS RSN_SPLIT_FLG,     /*BKG Split*/" ).append("\n"); 
		query.append("              H.RSN_BL_INFO_FLG   AS RSN_BL_INFO_FLG,   /*BL Inform*/" ).append("\n"); 
		query.append("              H.RSN_HBL_FLG       AS RSN_HBL_FLG,        /*NVO House BL*/" ).append("\n"); 
		query.append("              H.RSN_MK_DESC_FLG   AS CUST_VERIF_FLG,    /*Customer Verification*/" ).append("\n"); 
		query.append("				(SELECT '{' || U.USR_EML || '}' FROM COM_USER U WHERE U.USR_ID = DECODE(RQ.SR_KND_CD,'M',NVL((SELECT NVL(F.MTCH_USR_ID,BK.DOC_USR_ID)" ).append("\n"); 
		query.append("                                                                                                  FROM   BKG_SR_FAX F" ).append("\n"); 
		query.append("                                                                                                  WHERE  1=1" ).append("\n"); 
		query.append("                                                                                                  AND  F.SR_KND_CD = RQ.SR_KND_CD" ).append("\n"); 
		query.append("                                                                                                  AND  F.SR_NO = RQ.SR_NO" ).append("\n"); 
		query.append("                                                                                                  AND  F.BKG_NO = RQ.BKG_NO),BK.DOC_USR_ID),'F', RQ.FNT_OFC_SNDR_ID,BK.DOC_USR_ID)  ) || '=>' ||DECODE(RQ.SR_KND_CD,'M','Email','F','Fax','BKG Staff') AS FNT_OFC_EML," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			  (SELECT '{' || U.USR_EML || '}' FROM Com_User U WHERE U.USR_ID = RQ.BL_DOC_INP_USR_ID) AS INPUTER_EML," ).append("\n"); 
		query.append("              (SELECT '{' || U.USR_EML || '}' FROM Com_User U WHERE U.USR_ID = RQ.BL_RT_USR_ID) AS RATER_EML," ).append("\n"); 
		query.append("              (SELECT '{' || M.SREP_EML || '}' FROM MDM_SLS_REP M   WHERE M.SREP_CD = BK.OB_SREP_CD) AS SREP_EML,   " ).append("\n"); 
		query.append("			  NVL(NVL((SELECT '{' || F.FNT_OFC_EML || '}=>Mail' FROM BKG_SR_FAX F WHERE F.SR_NO = RQ.SR_NO AND F.SR_KND_CD = RQ.SR_KND_CD AND F.BKG_NO = RQ.BKG_NO AND F.FNT_OFC_EML  IS NOT NULL AND ROWNUM =1) ," ).append("\n"); 
		query.append("                      (SELECT '{' || XTER.SI_CNTC_EML || '}=>e-SI' FROM BKG_XTER_RQST_MST XTER WHERE XTER.XTER_RQST_NO = RQ.XTER_RQST_NO  AND XTER.XTER_RQST_SEQ  = RQ.XTER_RQST_SEQ   AND  XTER.XTER_SNDR_ID = RQ.XTER_SNDR_ID))," ).append("\n"); 
		query.append("                      (SELECT '{' || CNTC_PSON_EML || '}=>S/I Contact' FROM  BKG_CNTC_PSON P WHERE P.BKG_CNTC_PSON_TP_CD ='SI' AND P.BKG_NO =  RQ.BKG_NO))" ).append("\n"); 
		query.append("                    AS CUST_EML," ).append("\n"); 
		query.append("				H.EML_SUBJ_CTNT," ).append("\n"); 
		query.append("				H.EML_CPY_TO_CUST_FLG," ).append("\n"); 
		query.append("				BKG_GET_FNT_RCV_EML_FNC('BL',H.BKG_NO,@[usr_id],'EM') AS FO_RCV_EML	" ).append("\n"); 
		query.append("      FROM BKG_SR_HIS H" ).append("\n"); 
		query.append("      ,    BKG_SR_CRNT_RQST RQ" ).append("\n"); 
		query.append("	  ,    BKG_BOOKING BK		" ).append("\n"); 
		query.append("      WHERE RQ.SR_KND_CD = @[src_cd] /* 0421의 SRC_CD*/" ).append("\n"); 
		query.append("      AND   RQ.SR_NO    = @[sr_no]" ).append("\n"); 
		query.append("      AND   RQ.BKG_NO   = @[bkg_no] " ).append("\n"); 
		query.append("	  AND   RQ.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("    --  AND   H.SR_PROC_STS_CD(+) = 'R'" ).append("\n"); 
		query.append("      AND  H.SR_KND_CD(+) = RQ.SR_KND_CD" ).append("\n"); 
		query.append("      AND  H.SR_NO(+) = RQ.SR_NO" ).append("\n"); 
		query.append("      AND  H.BKG_NO(+) = RQ.BKG_NO" ).append("\n"); 
		query.append("      #if (${sr_his_seq} != '') " ).append("\n"); 
		query.append("      AND  SR_HIS_SEQ   = @[sr_his_seq] " ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      ORDER BY SR_HIS_SEQ DESC" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("WHERE ROWNUM =1" ).append("\n"); 

	}
}