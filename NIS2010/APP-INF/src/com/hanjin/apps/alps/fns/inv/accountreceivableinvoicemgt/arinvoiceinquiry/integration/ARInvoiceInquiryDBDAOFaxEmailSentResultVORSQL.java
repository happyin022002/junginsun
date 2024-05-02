/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOFaxEmailSentResultVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOFaxEmailSentResultVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOFaxEmailSentResultVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sent_by",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOFaxEmailSentResultVORSQL").append("\n"); 
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
		query.append("#if (${svr_id} != 'KOR')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT T00.ISS_OFC_CD, " ).append("\n"); 
		query.append("       T00.CRE_USR_ID, " ).append("\n"); 
		query.append("       T00.SENT_BY, " ).append("\n"); 
		query.append("       T00.INV_NO, " ).append("\n"); 
		query.append("	   T00.AUTO_INV_ISS_FLG," ).append("\n"); 
		query.append("       T00.INV_SEQ, " ).append("\n"); 
		query.append("	   --T00.CURR_CD," ).append("\n"); 
		query.append("	   --T00.CHG_AMT," ).append("\n"); 
		query.append("       T00.BL_SRC_NO, " ).append("\n"); 
		query.append("       T00.CUST_CODE, " ).append("\n"); 
		query.append("       T00.RECEIVED_NO,  " ).append("\n"); 
		query.append("       T00.TIME_REQUESTED, " ).append("\n"); 
		query.append("       T00.RESULT,  " ).append("\n"); 
		query.append("       T00.TIME_SENT, " ).append("\n"); 
		query.append("       T00.VVD, " ).append("\n"); 
		query.append("       T00.IO_BND_CD, " ).append("\n"); 
		query.append("       T00.PORT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("		SELECT DISTINCT" ).append("\n"); 
		query.append("		       T05.ISS_OFC_CD AS ISS_OFC_CD" ).append("\n"); 
		query.append("		     , T05.CRE_USR_ID AS CRE_USR_ID" ).append("\n"); 
		query.append("		     , CASE WHEN T01.INV_ISS_SND_TP_CD = 'E' THEN 'e-mail'" ).append("\n"); 
		query.append("		            WHEN T01.INV_ISS_SND_TP_CD = 'F' THEN 'FAX'" ).append("\n"); 
		query.append("		            WHEN T01.INV_ISS_SND_TP_CD = 'P' THEN 'Paper'" ).append("\n"); 
		query.append("		            WHEN T01.INV_ISS_SND_TP_CD_CHK IS NOT NULL THEN ''" ).append("\n"); 
		query.append("					ELSE 'Unperformed'" ).append("\n"); 
		query.append("		       END AS SENT_BY" ).append("\n"); 
		query.append("		    , T01.INV_NO" ).append("\n"); 
		query.append("		    , T01.INV_SEQ" ).append("\n"); 
		query.append(" 			, T01.AUTO_INV_ISS_FLG" ).append("\n"); 
		query.append("			--, T01.CURR_CD" ).append("\n"); 
		query.append("			--, T01.CHG_AMT" ).append("\n"); 
		query.append("		    , T02.BL_SRC_NO" ).append("\n"); 
		query.append("		    , T02.ACT_CUST_CNT_CD||'-'||TO_CHAR(T02.ACT_CUST_SEQ, 'FM000000')  AS CUST_CODE" ).append("\n"); 
		query.append("		    , T01.INV_SND_CUST_NO RECEIVED_NO" ).append("\n"); 
		query.append("		    , T01.INV_SND_DT TIME_REQUESTED" ).append("\n"); 
		query.append("		    , CASE WHEN T01.INV_ISS_SND_TP_CD = 'E' THEN" ).append("\n"); 
		query.append("		                CASE WHEN (SELECT S.AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION S WHERE T05.ISS_OFC_CD = S.OFC_CD) = 'HAMRU' THEN" ).append("\n"); 
		query.append("		                    -- Email 일 경우 Issue Office가 구주지역일 경우 구주 인증 메일 서버에서 최종 전송할 결과를 표시한다." ).append("\n"); 
		query.append("		                    DECODE(NVL(T01.EUR_EML_SND_RSLT_CD, 'N'), 'S', 'RECEIVED', 'F', 'FAIL', 'N', DECODE(NVL(T03.EML_PROC_STS_CD, 'N'), '1', 'SENDING', '3', 'SENT', 'FAIL'))" ).append("\n"); 
		query.append("		                ELSE" ).append("\n"); 
		query.append("		                    -- 기타 지역에 Email 전송은 ALPS 메일 서버에서 전송할 결과를 표시한다." ).append("\n"); 
		query.append("		                    DECODE(NVL(T03.EML_PROC_STS_CD, 'N'), '1', 'SENDING', '3', 'SUCCESS',                 'FAIL')" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("		                END" ).append("\n"); 
		query.append("		           WHEN T01.INV_ISS_SND_TP_CD = 'F' THEN DECODE(NVL(T04.FAX_PROC_STS_CD, 'N'), '1', 'SENDING', '3', 'SENDING', '5', 'SUCCESS', 'FAIL')" ).append("\n"); 
		query.append("		           WHEN T01.INV_ISS_SND_TP_CD = 'P' THEN 'SUCCESS'" ).append("\n"); 
		query.append("		      END                                                   AS RESULT" ).append("\n"); 
		query.append("		    , CASE WHEN T01.INV_ISS_SND_TP_CD = 'E' THEN (SELECT GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELHO', T03.EML_DT, T05.ISS_OFC_CD) FROM DUAL)" ).append("\n"); 
		query.append("		           WHEN T01.INV_ISS_SND_TP_CD = 'F' THEN (SELECT GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELHO', T04.FAX_DT, T05.ISS_OFC_CD) FROM DUAL)" ).append("\n"); 
		query.append("		           WHEN T01.INV_ISS_SND_TP_CD = 'P' THEN (SELECT GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELHO', T05.CRE_DT, T05.ISS_OFC_CD) FROM DUAL)" ).append("\n"); 
		query.append("		      END                                                    AS TIME_SENT" ).append("\n"); 
		query.append("		    , T02.VSL_CD||T02.SKD_VOY_NO||T02.SKD_DIR_CD             AS VVD" ).append("\n"); 
		query.append("		    , DECODE(T02.IO_BND_CD,'I','I/B', 'O/B')                 AS IO_BND_CD" ).append("\n"); 
		query.append("		    , DECODE(T02.IO_BND_CD,'I', T02.POD_CD, 'O', T02.POL_CD) AS PORT" ).append("\n"); 
		query.append("		FROM    (" ).append("\n"); 
		query.append("		        SELECT  T3.INV_NO " ).append("\n"); 
		query.append("						,T3.INV_SEQ" ).append("\n"); 
		query.append("						, CASE WHEN   NVL(T3.AUTO_INV_ISS_FLG,'N') ='Y' THEN 'A'  ELSE 'M'  END  AUTO_INV_ISS_FLG" ).append("\n"); 
		query.append("						--, T4.CURR_CD" ).append("\n"); 
		query.append("						--, SUM(T4.CHG_AMT) AS CHG_AMT" ).append("\n"); 
		query.append("		                , T1.INV_ISS_SND_TP_CD" ).append("\n"); 
		query.append("		                , (SELECT MAX(INV_ISS_SND_TP_CD)  FROM INV_AR_ISS_SND WHERE INV_NO = T3.INV_NO) INV_ISS_SND_TP_CD_CHK" ).append("\n"); 
		query.append("		                , T1.INV_SND_CUST_NO" ).append("\n"); 
		query.append("		                , T1.INV_SND_DT" ).append("\n"); 
		query.append("		                , T1.INV_SND_NO" ).append("\n"); 
		query.append("		                , T2.AR_IF_NO" ).append("\n"); 
		query.append("		                , T1.EUR_EML_SND_RSLT_CD" ).append("\n"); 
		query.append("		                , T1.SND_DT" ).append("\n"); 
		query.append("		        FROM    INV_AR_ISS T3, INV_AR_ISS_SND T1, INV_AR_ISS_DTL T2,INV_AR_CHG T4" ).append("\n"); 
		query.append("		        WHERE   1=1" ).append("\n"); 
		query.append("		        AND     T1.INV_NO(+)   = T3.INV_NO" ).append("\n"); 
		query.append("		        AND     T1.INV_SEQ(+)   = T3.INV_SEQ" ).append("\n"); 
		query.append("		        AND     T3.INV_NO       = T2.INV_NO" ).append("\n"); 
		query.append("				AND     T2.AR_IF_NO     = T4.AR_IF_NO " ).append("\n"); 
		query.append("				AND     T2.CHG_SEQ      = T4.CHG_SEQ  " ).append("\n"); 
		query.append("		        #if (${from_dt} != '' && ${to_dt} != '' && ${date_type} == 'S')" ).append("\n"); 
		query.append("		        AND     T1.INV_SND_DT BETWEEN REPLACE(TO_DATE(@[from_dt],'YYYYMMDD'), '-', '') AND REPLACE(TO_DATE(@[to_dt],'YYYYMMDD'), '-', '')" ).append("\n"); 
		query.append("		        #end" ).append("\n"); 
		query.append(" 				#if (${from_dt} != '' && ${to_dt} != ''  && ${date_type} == 'C')" ).append("\n"); 
		query.append("		        AND     T3.ISS_DT BETWEEN REPLACE(@[from_dt], '-', '') AND REPLACE(@[to_dt], '-', '')" ).append("\n"); 
		query.append("		        #end" ).append("\n"); 
		query.append("		        #if (${sent_by} != '')" ).append("\n"); 
		query.append("		        AND     T1.INV_ISS_SND_TP_CD IN (@[sent_by])" ).append("\n"); 
		query.append("		        #end" ).append("\n"); 
		query.append("		        GROUP BY T3.INV_NO" ).append("\n"); 
		query.append("						, T3.INV_SEQ" ).append("\n"); 
		query.append("						, T3.AUTO_INV_ISS_FLG" ).append("\n"); 
		query.append("						--, T4.CURR_CD" ).append("\n"); 
		query.append("		                , T1.INV_ISS_SND_TP_CD" ).append("\n"); 
		query.append("		                , T1.INV_SND_CUST_NO" ).append("\n"); 
		query.append("		                , T1.INV_SND_NO" ).append("\n"); 
		query.append("		                , T1.INV_SND_DT" ).append("\n"); 
		query.append("		                , T2.AR_IF_NO" ).append("\n"); 
		query.append("		                , T1.EUR_EML_SND_RSLT_CD" ).append("\n"); 
		query.append("		                , T1.SND_DT" ).append("\n"); 
		query.append("		        ) T01, INV_AR_MN T02, COM_EML_SND_INFO T03, COM_FAX_SND_INFO T04, INV_AR_ISS T05" ).append("\n"); 
		query.append("		WHERE   1=1" ).append("\n"); 
		query.append("		AND     T01.AR_IF_NO    = T02.AR_IF_NO" ).append("\n"); 
		query.append("		AND     T01.INV_SND_NO  = T03.EML_SND_NO (+)" ).append("\n"); 
		query.append("		AND     T01.INV_SND_NO  = T04.FAX_SND_NO (+)" ).append("\n"); 
		query.append("		AND     T01.INV_NO      = T05.INV_NO" ).append("\n"); 
		query.append("		AND     T01.INV_SEQ     = T05.INV_SEQ" ).append("\n"); 
		query.append("		#if  (${ofc_cd} == '')" ).append("\n"); 
		query.append("		AND     T02.AR_OFC_CD IN (" ).append("\n"); 
		query.append("		                    SELECT AR_OFC_CD" ).append("\n"); 
		query.append("		                    FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("		                    WHERE  OFC_CD           = AR_OFC_CD" ).append("\n"); 
		query.append("		                    AND    AR_HD_QTR_OFC_CD = (" ).append("\n"); 
		query.append("		                                              SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("		                                              FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("		                                              WHERE  OFC_CD = @[user_ofc_cd]" ).append("\n"); 
		query.append("		                                              )  " ).append("\n"); 
		query.append(" 		                   )" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("		AND     T02.AR_OFC_CD  = @[ofc_cd]" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND		(T02.INV_SRC_NO IS NULL   OR NVL(T02.INV_SRC_NO,'N') != T05.INV_NO)" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("		#if (${act_cust_cnt_cd} != '')" ).append("\n"); 
		query.append("		AND     T02.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${act_cust_seq} != '')" ).append("\n"); 
		query.append("		AND     T02.ACT_CUST_SEQ    = @[act_cust_seq]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("		AND     T02.VSL_CD          = @[vsl_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("		AND     T02.SKD_VOY_NO      = @[skd_voy_no]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("		AND     T02.SKD_DIR_CD      = @[skd_dir_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${bl_src_no} != '')		" ).append("\n"); 
		query.append("		AND     T02.BL_SRC_NO       = @[bl_src_no]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("		AND     T02.SVC_SCP_CD      = @[svc_scp_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${io_bnd_cd} != '')" ).append("\n"); 
		query.append("		AND     T02.IO_BND_CD       = @[io_bnd_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${port} != '')" ).append("\n"); 
		query.append("		AND    ((T02.IO_BND_CD      = 'I' AND T02.POD_CD = @[port]) OR (T02.IO_BND_CD = 'O' AND T02.POL_CD = @[port])) " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${inv_no} != '')" ).append("\n"); 
		query.append("		AND     T05.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${iss_ofc_cd} != '')" ).append("\n"); 
		query.append("		AND     T05.ISS_OFC_CD  = @[iss_ofc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${cre_usr_id} != '')" ).append("\n"); 
		query.append("		AND     T05.CRE_USR_ID  = @[cre_usr_id]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--ORDER BY T05.ISS_OFC_CD, T05.CRE_USR_ID, T01.INV_NO, T01.INV_SEQ, T02.BL_SRC_NO, CUST_CODE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT DISTINCT" ).append("\n"); 
		query.append("		       T05.ISS_OFC_CD AS ISS_OFC_CD" ).append("\n"); 
		query.append("		     , T05.CRE_USR_ID AS CRE_USR_ID" ).append("\n"); 
		query.append("		     , CASE WHEN T01.INV_ISS_SND_TP_CD = 'E' THEN 'e-mail'" ).append("\n"); 
		query.append("		            WHEN T01.INV_ISS_SND_TP_CD = 'F' THEN 'FAX'" ).append("\n"); 
		query.append("		            WHEN T01.INV_ISS_SND_TP_CD = 'P' THEN 'Paper'" ).append("\n"); 
		query.append("		            WHEN T01.INV_ISS_SND_TP_CD_CHK IS NOT NULL THEN ''" ).append("\n"); 
		query.append("					ELSE 'Unperformed'" ).append("\n"); 
		query.append("		       END AS SENT_BY" ).append("\n"); 
		query.append("		    , T01.INV_NO" ).append("\n"); 
		query.append("		    , T01.INV_SEQ" ).append("\n"); 
		query.append("			, 'N' AUTO_INV_ISS_FLG" ).append("\n"); 
		query.append("			--, T01.CURR_CD" ).append("\n"); 
		query.append("			--, T01.CHG_AMT" ).append("\n"); 
		query.append("		    , T02.BL_SRC_NO" ).append("\n"); 
		query.append("		    , T02.ACT_CUST_CNT_CD||'-'||TO_CHAR(T02.ACT_CUST_SEQ, 'FM000000')  AS CUST_CODE" ).append("\n"); 
		query.append("		    , T01.INV_SND_CUST_NO RECEIVED_NO" ).append("\n"); 
		query.append("		    , T01.INV_SND_DT TIME_REQUESTED" ).append("\n"); 
		query.append("		    , CASE WHEN T01.INV_ISS_SND_TP_CD = 'E' THEN" ).append("\n"); 
		query.append("		                CASE WHEN (SELECT S.AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION S WHERE T05.ISS_OFC_CD = S.OFC_CD) = 'HAMRU' THEN" ).append("\n"); 
		query.append("		                    -- Email 일 경우 Issue Office가 구주지역일 경우 구주 인증 메일 서버에서 최종 전송할 결과를 표시한다." ).append("\n"); 
		query.append("		                    DECODE(NVL(T01.EUR_EML_SND_RSLT_CD, 'N'), 'S', 'RECEIVED', 'F', 'FAIL', 'N', DECODE(NVL(T03.EML_PROC_STS_CD, 'N'), '1', 'SENDING', '3', 'SENT', 'FAIL'))" ).append("\n"); 
		query.append("		                ELSE" ).append("\n"); 
		query.append("		                    -- 기타 지역에 Email 전송은 ALPS 메일 서버에서 전송할 결과를 표시한다." ).append("\n"); 
		query.append("		                    DECODE(NVL(T03.EML_PROC_STS_CD, 'N'), '1', 'SENDING', '3', 'SUCCESS',                 'FAIL')" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("		                END" ).append("\n"); 
		query.append("		           WHEN T01.INV_ISS_SND_TP_CD = 'F' THEN DECODE(NVL(T04.FAX_PROC_STS_CD, 'N'), '1', 'SENDING', '3', 'SENDING', '5', 'SUCCESS', 'FAIL')" ).append("\n"); 
		query.append("		           WHEN T01.INV_ISS_SND_TP_CD = 'P' THEN 'SUCCESS'" ).append("\n"); 
		query.append("		      END                                                   AS RESULT" ).append("\n"); 
		query.append("		    , CASE WHEN T01.INV_ISS_SND_TP_CD = 'E' THEN (SELECT GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELHO', T03.EML_DT, T05.ISS_OFC_CD) FROM DUAL)" ).append("\n"); 
		query.append("		           WHEN T01.INV_ISS_SND_TP_CD = 'F' THEN (SELECT GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELHO', T04.FAX_DT, T05.ISS_OFC_CD) FROM DUAL)" ).append("\n"); 
		query.append("		           WHEN T01.INV_ISS_SND_TP_CD = 'P' THEN (SELECT GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELHO', T05.CRE_DT, T05.ISS_OFC_CD) FROM DUAL)" ).append("\n"); 
		query.append("		      END                                                    AS TIME_SENT" ).append("\n"); 
		query.append("		    , T02.VSL_CD||T02.SKD_VOY_NO||T02.SKD_DIR_CD             AS VVD" ).append("\n"); 
		query.append("		    , DECODE(T02.IO_BND_CD,'I','I/B', 'O/B')                 AS IO_BND_CD" ).append("\n"); 
		query.append("		    , DECODE(T02.IO_BND_CD,'I', T02.POD_CD, 'O', T02.POL_CD) AS PORT" ).append("\n"); 
		query.append("		FROM    (" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("		        SELECT    T2.INV_NO " ).append("\n"); 
		query.append("						, T2.INV_SEQ" ).append("\n"); 
		query.append("						--, T3.CURR_CD" ).append("\n"); 
		query.append("						--, SUM(T3.CHG_AMT) AS CHG_AMT" ).append("\n"); 
		query.append("		                , T1.INV_ISS_SND_TP_CD" ).append("\n"); 
		query.append("		                , (SELECT MAX(INV_ISS_SND_TP_CD)  FROM INV_AR_ISS_SND WHERE INV_NO = T2.INV_NO) INV_ISS_SND_TP_CD_CHK" ).append("\n"); 
		query.append("		                , T1.INV_SND_CUST_NO" ).append("\n"); 
		query.append("		                , T1.INV_SND_DT" ).append("\n"); 
		query.append("		                , T1.INV_SND_NO" ).append("\n"); 
		query.append("		                , T2.AR_IF_NO" ).append("\n"); 
		query.append("		                , T1.EUR_EML_SND_RSLT_CD" ).append("\n"); 
		query.append("		                , T1.SND_DT" ).append("\n"); 
		query.append("		        FROM    INV_AR_ISS_SND T1, INV_AR_SPLIT_ISS T2 , INV_AR_CHG T3" ).append("\n"); 
		query.append("		        WHERE   1=1" ).append("\n"); 
		query.append("		        AND     T1.INV_NO(+)   = T2.INV_NO" ).append("\n"); 
		query.append("		        AND     T1.INV_SEQ(+)  = T2.INV_SEQ" ).append("\n"); 
		query.append("				AND     T2.AR_IF_NO    = T3.AR_IF_NO" ).append("\n"); 
		query.append("				#if (${from_dt} != '' && ${to_dt} != '' && ${date_type} == 'S')" ).append("\n"); 
		query.append("				AND     T1.INV_SND_DT BETWEEN REPLACE(TO_DATE(@[from_dt],'YYYYMMDD'), '-', '') AND REPLACE(TO_DATE(@[to_dt],'YYYYMMDD'), '-', '')" ).append("\n"); 
		query.append("		        #end" ).append("\n"); 
		query.append(" 				#if (${from_dt} != '' && ${to_dt} != ''  && ${date_type} == 'C')" ).append("\n"); 
		query.append("		        AND     T2.ISS_DT BETWEEN REPLACE(@[from_dt], '-', '') AND REPLACE(@[to_dt], '-', '')" ).append("\n"); 
		query.append("		        #end" ).append("\n"); 
		query.append("		        #if (${sent_by} != '')" ).append("\n"); 
		query.append("		        AND     T1.INV_ISS_SND_TP_CD IN (@[sent_by])" ).append("\n"); 
		query.append("		        #end" ).append("\n"); 
		query.append("		        GROUP BY T2.INV_NO, T2.INV_SEQ --, T3.CURR_CD" ).append("\n"); 
		query.append("		                , T1.INV_ISS_SND_TP_CD" ).append("\n"); 
		query.append("		                , T1.INV_SND_CUST_NO" ).append("\n"); 
		query.append("		                , T1.INV_SND_NO" ).append("\n"); 
		query.append("		                , T1.INV_SND_DT" ).append("\n"); 
		query.append("		                , T2.AR_IF_NO" ).append("\n"); 
		query.append("		                , T1.EUR_EML_SND_RSLT_CD" ).append("\n"); 
		query.append("		                , T1.SND_DT              " ).append("\n"); 
		query.append("                               " ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("		        ) T01, INV_AR_MN T02, COM_EML_SND_INFO T03, COM_FAX_SND_INFO T04, --INV_AR_ISS T05" ).append("\n"); 
		query.append("		        ( SELECT INV_NO, INV_SEQ, ISS_OFC_CD, CRE_USR_ID, CRE_DT" ).append("\n"); 
		query.append("		          FROM   INV_AR_ISS " ).append("\n"); 
		query.append("		          UNION ALL" ).append("\n"); 
		query.append("		          SELECT INV_NO, INV_SEQ, AR_OFC_CD AS ISS_OFC_CD, CRE_USR_ID, CRE_DT" ).append("\n"); 
		query.append("		          FROM   INV_AR_SPLIT_ISS" ).append("\n"); 
		query.append("		        ) T05" ).append("\n"); 
		query.append("		WHERE   1=1" ).append("\n"); 
		query.append("		AND     T01.AR_IF_NO    = T02.AR_IF_NO" ).append("\n"); 
		query.append("		AND     T01.INV_SND_NO  = T03.EML_SND_NO (+)" ).append("\n"); 
		query.append("		AND     T01.INV_SND_NO  = T04.FAX_SND_NO (+)" ).append("\n"); 
		query.append("		AND     T01.INV_NO      = T05.INV_NO" ).append("\n"); 
		query.append("		AND     T01.INV_SEQ     = T05.INV_SEQ" ).append("\n"); 
		query.append("		#if  (${ofc_cd} == '')" ).append("\n"); 
		query.append("		AND     T02.AR_OFC_CD IN (" ).append("\n"); 
		query.append("		                    SELECT AR_OFC_CD" ).append("\n"); 
		query.append("		                    FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("		                    WHERE  OFC_CD           = AR_OFC_CD" ).append("\n"); 
		query.append("		                    AND    AR_HD_QTR_OFC_CD = (" ).append("\n"); 
		query.append("		                                              SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("		                                              FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("		                                              WHERE  OFC_CD = @[user_ofc_cd]" ).append("\n"); 
		query.append("		                                              )  " ).append("\n"); 
		query.append("		                    )		" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("		AND     T02.AR_OFC_CD  = @[ofc_cd]" ).append("\n"); 
		query.append("		#end    " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("		AND		(T02.INV_SRC_NO IS NULL OR NVL(T02.INV_SRC_NO,'N') != T05.INV_NO)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${act_cust_cnt_cd} != '')" ).append("\n"); 
		query.append("		AND     T02.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${act_cust_seq} != '')" ).append("\n"); 
		query.append("		AND     T02.ACT_CUST_SEQ    = @[act_cust_seq]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${vsl_cd} != '')		" ).append("\n"); 
		query.append("		AND     T02.VSL_CD          = @[vsl_cd]		" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("		AND     T02.SKD_VOY_NO      = @[skd_voy_no]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("		AND     T02.SKD_DIR_CD      = @[skd_dir_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${bl_src_no} != '')" ).append("\n"); 
		query.append("		AND     T02.BL_SRC_NO       = @[bl_src_no]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("		AND     T02.SVC_SCP_CD      = @[svc_scp_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${io_bnd_cd} != '')" ).append("\n"); 
		query.append("		AND     T02.IO_BND_CD       = @[io_bnd_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${port} != '')" ).append("\n"); 
		query.append("		AND    ((T02.IO_BND_CD      = 'I' AND T02.POD_CD = @[port]) OR (T02.IO_BND_CD = 'O' AND T02.POL_CD = @[port])) " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${inv_no} != '')" ).append("\n"); 
		query.append("		AND     T05.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${iss_ofc_cd} != '')" ).append("\n"); 
		query.append("		AND     T05.ISS_OFC_CD  = @[iss_ofc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		#if (${cre_usr_id} != '')" ).append("\n"); 
		query.append("		AND     T05.CRE_USR_ID  = @[cre_usr_id]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		) T00" ).append("\n"); 
		query.append("WHERE T00.SENT_BY IS NOT NULL" ).append("\n"); 
		query.append("ORDER BY ISS_OFC_CD, CRE_USR_ID, INV_NO, INV_SEQ, BL_SRC_NO, CUST_CODE" ).append("\n"); 
		query.append("--ORDER BY T05.ISS_OFC_CD, T05.CRE_USR_ID, T01.INV_NO, T01.INV_SEQ, T02.BL_SRC_NO, CUST_CODE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else ------------------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DISTINCT A.AR_OFC_CD ISS_OFC_CD" ).append("\n"); 
		query.append("     , A.CRE_USR_ID CRE_USR_ID" ).append("\n"); 
		query.append("     , CASE WHEN A.EML_SND_NO IS NOT NULL THEN 'e-mail'" ).append("\n"); 
		query.append("            WHEN A.FAX_SND_NO IS NOT NULL THEN 'FAX'" ).append("\n"); 
		query.append("            ELSE 'Paper'" ).append("\n"); 
		query.append("       END SENT_BY" ).append("\n"); 
		query.append("     , CASE WHEN A.EML_SND_NO IS NOT NULL THEN DECODE(NVL(E.EML_PROC_STS_CD, 'N'), '1', 'SENDING', '3', 'SUCCESS', 'FAIL')" ).append("\n"); 
		query.append("            WHEN A.FAX_SND_NO IS NOT NULL THEN DECODE(NVL(F.FAX_PROC_STS_CD, 'N'), '1', 'SENDING', '3', 'SENDING', '5', 'SUCCESS', 'FAIL')" ).append("\n"); 
		query.append("            ELSE 'SUCCESS'" ).append("\n"); 
		query.append("       END RESULT" ).append("\n"); 
		query.append("     , A.INV_NO" ).append("\n"); 
		query.append("     , A.INV_SEQ" ).append("\n"); 
		query.append("	 , 'N' AUTO_INV_ISS_FLG" ).append("\n"); 
		query.append("	 --, B.CURR_CD" ).append("\n"); 
		query.append("	 --, B.CHG_AMT" ).append("\n"); 
		query.append("	 --, SUM(B.CHG_AMT) AS CHG_AMT" ).append("\n"); 
		query.append("     , B.BL_SRC_NO" ).append("\n"); 
		query.append("     , A.ACT_CUST_CNT_CD||'-'||TO_CHAR(A.ACT_CUST_SEQ, 'FM000000')  CUST_CODE" ).append("\n"); 
		query.append("     , CASE WHEN A.EML_SND_NO IS NOT NULL THEN A.CUST_EML" ).append("\n"); 
		query.append("            WHEN A.FAX_SND_NO IS NOT NULL THEN A.CUST_FAX_NO" ).append("\n"); 
		query.append("            ELSE ''" ).append("\n"); 
		query.append("       END  RECEIVED_NO" ).append("\n"); 
		query.append("     , CASE WHEN A.EML_SND_NO IS NOT NULL THEN A.EML_SND_DT" ).append("\n"); 
		query.append("            WHEN A.FAX_SND_NO IS NOT NULL THEN A.FAX_SND_DT" ).append("\n"); 
		query.append("            ELSE A.CRE_DT" ).append("\n"); 
		query.append("       END  TIME_REQUESTED" ).append("\n"); 
		query.append("     , CASE WHEN A.EML_SND_NO IS NOT NULL THEN (SELECT GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELHO', E.EML_DT, A.AR_OFC_CD) FROM DUAL)" ).append("\n"); 
		query.append("            WHEN A.FAX_SND_NO IS NOT NULL THEN (SELECT GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELHO', F.FAX_DT, A.AR_OFC_CD) FROM DUAL)" ).append("\n"); 
		query.append("            ELSE (SELECT GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELHO', A.CRE_DT, A.AR_OFC_CD) FROM DUAL)" ).append("\n"); 
		query.append("       END TIME_SENT" ).append("\n"); 
		query.append("       , B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("     , DECODE(B.IO_BND_CD,'I','I/B','O/B') IO_BND_CD" ).append("\n"); 
		query.append("     , DECODE(B.IO_BND_CD,'I', B.POD_CD, 'O',B.POL_CD) PORT" ).append("\n"); 
		query.append("FROM INV_AR_KR_ISS A, INV_AR_KR_ISS_CHG B, COM_EML_SND_INFO E, COM_FAX_SND_INFO F" ).append("\n"); 
		query.append("WHERE A.EML_SND_NO = E.EML_SND_NO(+)" ).append("\n"); 
		query.append("AND A.FAX_SND_NO = F.FAX_SND_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if  (${ofc_cd} == '')" ).append("\n"); 
		query.append("AND A.AR_OFC_CD IN (" ).append("\n"); 
		query.append("        SELECT AR_OFC_CD" ).append("\n"); 
		query.append("        FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("        WHERE AR_HD_QTR_OFC_CD = (" ).append("\n"); 
		query.append("            SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("            FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("            WHERE OFC_CD = @[user_ofc_cd])" ).append("\n"); 
		query.append("          AND OFC_CD = AR_OFC_CD )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("AND A.INV_SEQ = B.INV_SEQ" ).append("\n"); 
		query.append("AND DECODE(A.RISS_DT, '', A.ISS_DT,  A.RISS_DT) BETWEEN REPLACE(@[from_dt], '-', '') AND REPLACE(@[to_dt], '-', '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${iss_ofc_cd} != '')" ).append("\n"); 
		query.append("AND A.AR_OFC_CD = @[iss_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cre_usr_id} != '')" ).append("\n"); 
		query.append("AND A.CRE_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${act_cust_cnt_cd} != '')" ).append("\n"); 
		query.append("AND A.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${act_cust_seq} != '')" ).append("\n"); 
		query.append("AND A.ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("AND B.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("AND B.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("AND B.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bl_src_no} != '')" ).append("\n"); 
		query.append("AND B.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inv_no} != '')" ).append("\n"); 
		query.append("AND A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != '')" ).append("\n"); 
		query.append("AND B.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${port} != '')" ).append("\n"); 
		query.append("AND ((B.IO_BND_CD = 'I' AND B.POD_CD = @[port]) OR (B.IO_BND_CD = 'O' AND B.POL_CD = @[port])) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sent_by} != '')" ).append("\n"); 
		query.append("       #if (${sent_by} == 'P')" ).append("\n"); 
		query.append("             AND A.EML_SND_NO IS NULL AND A.FAX_SND_NO IS NULL" ).append("\n"); 
		query.append("       #elseif (${sent_by} == 'E')" ).append("\n"); 
		query.append("             AND A.EML_SND_NO IS NOT NULL" ).append("\n"); 
		query.append("       #elseif (${sent_by} == 'F')" ).append("\n"); 
		query.append("             AND A.FAX_SND_NO IS NOT NULL" ).append("\n"); 
		query.append("       #elseif (${sent_by} == 'P,E')" ).append("\n"); 
		query.append("             AND A.FAX_SND_NO IS NULL" ).append("\n"); 
		query.append("       #elseif (${sent_by} == 'P,F')" ).append("\n"); 
		query.append("             AND A.EML_SND_NO IS NULL" ).append("\n"); 
		query.append("       #elseif (${sent_by} == 'E,F')" ).append("\n"); 
		query.append("             AND (A.EML_SND_NO IS NOT NULL OR A.FAX_SND_NO IS NOT NULL)" ).append("\n"); 
		query.append("       #end   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.AR_OFC_CD, A.CRE_USR_ID, A.INV_NO, A.INV_SEQ, B.BL_SRC_NO, CUST_CODE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}