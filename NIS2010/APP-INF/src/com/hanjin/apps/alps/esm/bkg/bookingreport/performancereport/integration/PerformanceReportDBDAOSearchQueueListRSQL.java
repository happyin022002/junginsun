/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchQueueListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.13 
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

public class PerformanceReportDBDAOSearchQueueListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOSearchQueueListRSQL
	  * VBS_CLSS_CD,VBS_CLSS_NM , Doc.Cut Off-time 추가
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchQueueListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_amd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dpcs_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rows_per_page",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dura_to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pic_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dura_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("return_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rate",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_page",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchQueueListRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM   (SELECT  COUNT(BKG_NO) OVER() AS TOTAL_CNT" ).append("\n"); 
		query.append("                ,ROWNUM AS RNUM" ).append("\n"); 
		query.append("               ,Z.*" ).append("\n"); 
		query.append("               ,BKG_GET_TOKEN_FNC(BKG_HIS_VALUES, 1, '☜☞') AS RTN_TO_USR_EML " ).append("\n"); 
		query.append("               ,BKG_GET_TOKEN_FNC(BKG_HIS_VALUES, 2, '☜☞') AS RTN_TO_USR_REMARK" ).append("\n"); 
		query.append("       FROM   (SELECT  CASE WHEN NVL(X.RETURN_TO_CD,' ') = ' ' THEN '' ELSE DECODE(FNT_OFC_RTN_CD,'S','FO','I','Inputter','R','Rater','C','Customer','P','S.REP') || ' ' || X.RETURN_TO_CD END AS RETURN_CD" ).append("\n"); 
		query.append("                       ,X.RETURN_FROM_CD AS RETURN_TO" ).append("\n"); 
		query.append("                       ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                         FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                         WHERE  INTG_CD_ID = 'CD01577'" ).append("\n"); 
		query.append("                         AND    (APLY_ST_DT < TO_CHAR(SYSDATE, 'YYYYMMDD') AND APLY_END_DT > TO_CHAR(SYSDATE, 'YYYYMMDD'))" ).append("\n"); 
		query.append("                         AND    INTG_CD_VAL_CTNT = SR_KIND_CD) AS SR_KIND" ).append("\n"); 
		query.append("                       ,COUNT(DISTINCT X.BKG_NO) OVER() AS TOTAL_BKG" ).append("\n"); 
		query.append("                       ,COUNT(DISTINCT X.SR_NO) OVER() AS TOTAL_SR" ).append("\n"); 
		query.append("                       ,SUM(DECODE(X.BL_DOC_INP_FLG,'Y',1,0)) OVER() AS TOTAL_INPUT" ).append("\n"); 
		query.append("                       ,SUM(DECODE(X.BL_RT_FLG,'Y',1,0)) OVER() AS TOTAL_RATE" ).append("\n"); 
		query.append("                       ,SUM(DECODE(X.BL_AUD_FLG,'Y',1,0)) OVER() AS TOTAL_QA" ).append("\n"); 
		query.append("                       ,SUM(DECODE(X.BL_DRFT_FAX_OUT_FLG,'Y',1,0)) OVER() AS TOTAL_FAX" ).append("\n"); 
		query.append("                       ,SUM(DECODE(X.SR_WRK_STS_CD,'P',1,0)) OVER() AS TOTAL_PENDING" ).append("\n"); 
		query.append("                       ,SUM(DECODE(X.SR_WRK_STS_CD,'W',1,0)) OVER() AS TOTAL_WORKING" ).append("\n"); 
		query.append("                       ,SUM(DECODE(X.SR_WRK_STS_CD,'X',1,0)) OVER() AS TOTAL_CANCELED" ).append("\n"); 
		query.append("                       ,SUM(DECODE(X.SR_WRK_STS_CD,'Y',1,0)) OVER() AS TOTAL_COMPLETED" ).append("\n"); 
		query.append("                       ,SUM(DECODE(X.SR_WRK_STS_CD,'P',0,'W',0,'X',0,'Y',0,1)) OVER() AS TOTAL_NA" ).append("\n"); 
		query.append("                       ,SUM(DECODE(TO_CHAR(X.TRNK_ESTM_BDR_DT,'RRMMDD'),TO_CHAR(SYSDATE,'RRMMDD'),1,0)) OVER() AS TOTAL_BDR" ).append("\n"); 
		query.append("                       ,SUM(DECODE(TO_CHAR(X.PCT_DATE,'RRMMDD'),TO_CHAR(SYSDATE,'RRMMDD'),1,0)) OVER() AS TOTAL_PCT	" ).append("\n"); 
		query.append("                       ,SUM(DECODE(URGENCY,'U',1,0)) OVER() AS TOTAL_URGENT" ).append("\n"); 
		query.append("                       ,SUM(DECODE(URGENCY,'V',1,0)) OVER() AS TOTAL_VIP" ).append("\n"); 
		query.append("                       ,SUM(DECODE(URGENCY,'N',1,0)) OVER() AS TOTAL_NORMAL" ).append("\n"); 
		query.append("                       ,SUM(CASE WHEN SR_WRK_STS_DT >= DOC_CCT THEN 1 ELSE 0 END) OVER() AS TOTAL_CUTOFF" ).append("\n"); 
		query.append("                       ,SUM(DECODE(X.RETURN_TO_CD,'->>',1,0))  OVER() AS TOTAL_RTN       -- TF RETURN TO RETURN" ).append("\n"); 
		query.append("                       ,SUM(DECODE(X.SR_CRNT_INFO_CD,'R',DECODE(X.FNT_OFC_RTN_CD,'C',1,0),0)) OVER() AS TOTAL_RTN_CUST --add Customer" ).append("\n"); 
		query.append("                       ,SUM(DECODE(X.SR_CRNT_INFO_CD,'R',DECODE(X.FNT_OFC_RTN_CD,'S',1,0),0)) OVER() AS TOTAL_RTN_FO  --add FO" ).append("\n"); 
		query.append("                       ,TO_CHAR(X.TRNK_ESTM_BDR_DT,'YYYY-MM-DD HH24:MI') AS BDR_DATE" ).append("\n"); 
		query.append("                       ,X.*" ).append("\n"); 
		query.append(",nvl((" ).append("\n"); 
		query.append("SELECT SUM(OP_CNTR_QTY) " ).append("\n"); 
		query.append("FROM BKG_QUANTITY" ).append("\n"); 
		query.append("WHERE SUBSTR(CNTR_TPSZ_CD, 2, 1) = '2'" ).append("\n"); 
		query.append("AND BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("),0) VOL20     " ).append("\n"); 
		query.append(",nvl((" ).append("\n"); 
		query.append("SELECT SUM(OP_CNTR_QTY) " ).append("\n"); 
		query.append("FROM BKG_QUANTITY" ).append("\n"); 
		query.append("WHERE SUBSTR(CNTR_TPSZ_CD, 2, 1) <> '2'" ).append("\n"); 
		query.append("AND BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("),0) VOL40" ).append("\n"); 
		query.append("               FROM   (SELECT " ).append("\n"); 
		query.append("							#if ('' == ${vvd_cd})	" ).append("\n"); 
		query.append("								/*+ORDERED */" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("                              '//a_dpcs/module/BKG/' || CASE WHEN INSTR(A.IMG_FILE_PATH_CTNT,'STIFF') > 0 THEN '' ELSE A.RCV_OFC_CD || '/' END || A.IMG_FILE_PATH_CTNT||A.IMG_FILE_NM AS IMG_FILE_REAL_PATH" ).append("\n"); 
		query.append("                              ,A.SR_URG_CD AS URGENCY" ).append("\n"); 
		query.append("                              ,A.SR_AMD_TP_CD AS SR_KIND_CD" ).append("\n"); 
		query.append("                              ,DECODE(DECODE (A.SR_CRNT_INFO_CD,'R','RT','T','TF')" ).append("\n"); 
		query.append("                                                    ,'RT','<<-','TF','->>',NULL) AS RETURN_TO_CD" ).append("\n"); 
		query.append("                              ,(SELECT FNT_OFC_RTN_CD " ).append("\n"); 
		query.append("													FROM BKG_SR_HIS H " ).append("\n"); 
		query.append("													WHERE H.BKG_NO = A.BKG_NO " ).append("\n"); 
		query.append("													AND H.SR_NO = A.SR_NO " ).append("\n"); 
		query.append("													AND H.SR_KND_CD = A.SR_KND_CD " ).append("\n"); 
		query.append("													AND H.SR_STS_CD = 'RR' " ).append("\n"); 
		query.append("													AND H.SR_HIS_SEQ = (SELECT MAX(H2.SR_HIS_SEQ)  " ).append("\n"); 
		query.append("                                                    					FROM   BKG_SR_HIS H2 " ).append("\n"); 
		query.append("                                                    					WHERE  H.BKG_NO   = H2.BKG_NO  " ).append("\n"); 
		query.append("                                                    					AND    H.SR_NO    = H2.SR_NO " ).append("\n"); 
		query.append("																		AND    H2.SR_STS_CD = 'RR' " ).append("\n"); 
		query.append("                                                    					AND    H.SR_KND_CD = H2.SR_KND_CD)) AS FNT_OFC_RTN_CD 								" ).append("\n"); 
		query.append("							  ,(SELECT DECODE(COUNT(H.SR_HIS_SEQ),0,NULL,COUNT(1))  FROM BKG_SR_HIS H WHERE H.BKG_NO = A.BKG_NO AND H.SR_NO = A.SR_NO AND H.SR_KND_CD = A.SR_KND_CD AND H.SR_STS_CD = 'RR') AS RTN_FREQ" ).append("\n"); 
		query.append("                              ,DECODE(A.SR_CRNT_INFO_CD" ).append("\n"); 
		query.append("                                                    ,'R', A.RTN_TO_USR_ID" ).append("\n"); 
		query.append("                                                    ,'T', A.RTN_TO_RTN_USR_ID) AS RETURN_FROM_CD" ).append("\n"); 
		query.append("                              ,DECODE(SR_CRNT_INFO_CD,'T',DECODE(@[usr_id],NVL(A.RTN_TO_RTN_USR_ID,''),'TT'" ).append("\n"); 
		query.append("                              ,NVL(A.RTN_FM_USR_ID,''),'TF','EE'),'R',DECODE(@[usr_id],NVL(A.RTN_TO_USR_ID,''),'RT'" ).append("\n"); 
		query.append("                                                    ,NVL(A.RTN_FM_USR_ID,''),'RF','EE'),'EE') AS RETURN_SRC" ).append("\n"); 
		query.append("                              ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                                FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                WHERE  INTG_CD_ID = 'CD01581'" ).append("\n"); 
		query.append("                                AND    APLY_ST_DT < TO_CHAR(SYSDATE, 'YYYYMMDD')" ).append("\n"); 
		query.append("                                AND    APLY_END_DT > TO_CHAR(SYSDATE, 'YYYYMMDD')" ).append("\n"); 
		query.append("                                AND    INTG_CD_VAL_CTNT = A.SR_KND_CD) AS SRC" ).append("\n"); 
		query.append("                              ,A.SR_KND_CD AS SRC_CD" ).append("\n"); 
		query.append("                              ,A.SR_KND_CD AS SR_KND_CD" ).append("\n"); 
		query.append("                              ,A.BKG_NO AS BKG_NO" ).append("\n"); 
		query.append("							  ,(SELECT USR_NM FROM COM_USER USR WHERE USR.USR_ID = B.DOC_USR_ID) AS BKG_STAFF" ).append("\n"); 
		query.append("                              ,REPLACE(S.CUST_NM,CHR(13)||CHR(10),' ') AS SHIPPER" ).append("\n"); 
		query.append("                     							  ,S.CUST_CNT_CD " ).append("\n"); 
		query.append("                     							  ,S.CUST_SEQ" ).append("\n"); 
		query.append("							  " ).append("\n"); 
		query.append("                              ,B.POL_CD AS POL_CD" ).append("\n"); 
		query.append("                              ,B.POD_CD AS POD_CD" ).append("\n"); 
		query.append("                              ,B.PORT_CLZ_DT AS PCT_DATE" ).append("\n"); 
		query.append("                              ,(SELECT TRNK_ESTM_BDR_DT" ).append("\n"); 
		query.append("                                FROM   BKG_VVD_BDR_LOG BDR" ).append("\n"); 
		query.append("                                WHERE  B.VSL_CD = BDR.VSL_CD" ).append("\n"); 
		query.append("                                AND B.SKD_VOY_NO = BDR.SKD_VOY_NO" ).append("\n"); 
		query.append("                                AND B.SKD_DIR_CD = BDR.SKD_DIR_CD" ).append("\n"); 
		query.append("                                AND NVL(B.PRE_RLY_PORT_CD, B.POL_CD) = BDR.POL_CD" ).append("\n"); 
		query.append("                                AND NVL(B.PST_RLY_PORT_CD, B.POD_CD) = BDR.POD_CD" ).append("\n"); 
		query.append("                                AND ROWNUM = 1) AS TRNK_ESTM_BDR_DT" ).append("\n"); 
		query.append("                              ,A.SR_WRK_STS_DT AS SR_DATE" ).append("\n"); 
		query.append("                              ,TO_CHAR(A.CRNT_DT,'YYYY-MM-DD HH24:MI') AS LAST_DATE" ).append("\n"); 
		query.append("                              ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                                FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                WHERE  INTG_CD_ID = 'CD01579'" ).append("\n"); 
		query.append("                                AND    (APLY_ST_DT < TO_CHAR(SYSDATE, 'YYYYMMDD') AND APLY_END_DT > TO_CHAR(SYSDATE, 'YYYYMMDD'))" ).append("\n"); 
		query.append("                                AND    INTG_CD_VAL_CTNT = DECODE(B.BKG_STS_CD, 'X', 'XX', A.SR_CRNT_STS_CD)) AS QUEUE_STATUS" ).append("\n"); 
		query.append("                              ,DECODE(A.SR_CRNT_STS_CD,'DF','Y','N') AS FAX" ).append("\n"); 
		query.append("                              ,DECODE(A.DIFF_RMK,NULL,'','Y') AS MESSAGE_YN" ).append("\n"); 
		query.append("                              ,DECODE(A.SR_WRK_STS_CD,'P',(SELECT /*+ INDEX_DESC(BKG_SR_HIS XPKBKG_SR_HIS) */ DIFF_RMK " ).append("\n"); 
		query.append("                                                           FROM BKG_SR_HIS" ).append("\n"); 
		query.append("                                                           WHERE SR_KND_CD = A.SR_KND_CD" ).append("\n"); 
		query.append("                                                           AND SR_NO = A.SR_NO" ).append("\n"); 
		query.append("                                                           AND BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                                                           AND SR_STS_CD = 'PN'" ).append("\n"); 
		query.append("                                                           AND ROWNUM = 1)," ).append("\n"); 
		query.append("                                                           DECODE(A.SR_CRNT_INFO_CD, 'R', (SELECT /*+ INDEX_DESC(BKG_SR_HIS XPKBKG_SR_HIS) */ DIFF_RMK " ).append("\n"); 
		query.append("                                                           FROM BKG_SR_HIS" ).append("\n"); 
		query.append("                                                           WHERE SR_KND_CD = A.SR_KND_CD" ).append("\n"); 
		query.append("                                                           AND SR_NO = A.SR_NO" ).append("\n"); 
		query.append("                                                           AND BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                                                           AND SR_STS_CD = 'RR'" ).append("\n"); 
		query.append("                                                           AND ROWNUM = 1), A.DIFF_RMK)" ).append("\n"); 
		query.append("                                      )  AS MESSAGE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                              ,(SELECT BDR_FLG" ).append("\n"); 
		query.append("                                FROM   BKG_BL_DOC" ).append("\n"); 
		query.append("                                WHERE  BKG_NO = B.BKG_NO) AS BDR_FLG" ).append("\n"); 
		query.append("                                ,A.SR_CRNT_INFO_CD AS SR_CRNT_INFO_CD" ).append("\n"); 
		query.append("                              ,(SELECT MAX(SR_NO)" ).append("\n"); 
		query.append("                                FROM   BKG_SR_CRNT_RQST" ).append("\n"); 
		query.append("                                WHERE  SR_KND_CD = A.SR_KND_CD" ).append("\n"); 
		query.append("                                AND    BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                                AND    SR_AMD_TP_CD = A.SR_AMD_TP_CD" ).append("\n"); 
		query.append("                                AND    SR_AMD_SEQ = A.SR_AMD_SEQ) AS MAX_SR_NO" ).append("\n"); 
		query.append("                              ,A.CRNT_USR_ID AS CRNT_USR_ID" ).append("\n"); 
		query.append("                              ,A.IMG_FILE_IP AS IMG_FILE_IP" ).append("\n"); 
		query.append("                              ,A.IMG_FILE_PATH_CTNT AS IMG_FILE_PATH_CTNT" ).append("\n"); 
		query.append("                              ,A.IMG_FILE_NM AS IMG_FILE_NM" ).append("\n"); 
		query.append("                              ,B.BKG_STS_CD AS BKG_STS_CD" ).append("\n"); 
		query.append("                              ,A.RTN_FM_USR_ID AS RTN_FM_USR_ID" ).append("\n"); 
		query.append("                              ,A.RTN_TO_USR_ID AS RTN_TO_USR_ID" ).append("\n"); 
		query.append("                              ,A.RTN_TO_RTN_USR_ID AS RTN_TO_RTN_USR_ID" ).append("\n"); 
		query.append("                              ,A.SR_CRNT_STS_CD AS SR_STS_CD" ).append("\n"); 
		query.append("                              ,A.PND_FLG AS PND_FLG  /* Y 일경우 PIC change 버튼 활성화*/" ).append("\n"); 
		query.append("                              ,A.SR_CRNT_STS_CD AS SR_CRNT_STS_CD" ).append("\n"); 
		query.append("                              ,CASE WHEN A.PIC_CNG_USR_ID IS NULL AND" ).append("\n"); 
		query.append("                                        (SELECT 'Y'" ).append("\n"); 
		query.append("							             FROM   BKG_SR_CRNT_RQST" ).append("\n"); 
		query.append("							             WHERE  BL_DOC_INP_FLG = 'Y' " ).append("\n"); 
		query.append("                                         AND    BL_RT_FLG = 'Y' " ).append("\n"); 
		query.append("                                         AND    BL_AUD_FLG = 'Y' " ).append("\n"); 
		query.append("                                         AND    BL_DRFT_FAX_OUT_FLG = 'Y' " ).append("\n"); 
		query.append("                                         AND    BKG_NO = A.BKG_NO " ).append("\n"); 
		query.append("                                         AND    SR_AMD_TP_CD IN ('N', 'O') " ).append("\n"); 
		query.append("                                         AND    ROWNUM = 1) = 'Y' THEN" ).append("\n"); 
		query.append("					                    (SELECT C.USR_ID||'('||C.USR_NM||')'" ).append("\n"); 
		query.append("					                     FROM   BKG_SR_HIS H, COM_USER C" ).append("\n"); 
		query.append("					                     WHERE  H.BKG_NO = A.BKG_NO " ).append("\n"); 
		query.append("                                         AND    SR_STS_CD = 'AD'" ).append("\n"); 
		query.append("                                         AND    H.ATND_USR_ID = C.USR_ID" ).append("\n"); 
		query.append("                                         AND    H.ST_DT = (SELECT MAX(ST_DT)" ).append("\n"); 
		query.append("									                       FROM   BKG_SR_HIS" ).append("\n"); 
		query.append("									                       WHERE  BKG_NO = H.BKG_NO AND SR_STS_CD = 'AD')" ).append("\n"); 
		query.append("                                         AND    ROWNUM = 1" ).append("\n"); 
		query.append("                                         )" ).append("\n"); 
		query.append("				                   ELSE (SELECT C.USR_ID||'('||C.USR_NM||')' FROM COM_USER C WHERE C.USR_ID = A.PIC_CNG_USR_ID) " ).append("\n"); 
		query.append("			                    END PIC_ID" ).append("\n"); 
		query.append("							  ,A.PIC_CNG_USR_ID AS PIC_CNG_ID" ).append("\n"); 
		query.append("                              ,NVL(DECODE(A.SR_CRNT_INFO_CD,'R'" ).append("\n"); 
		query.append("                              ,DECODE(NVL(A.RTN_TO_USR_ID,''),@[usr_id],'RT'),'T'" ).append("\n"); 
		query.append("                              ,DECODE('IN-SU','SU','TF'" ).append("\n"); 
		query.append("                              ,DECODE(NVL(A.RTN_TO_USR_ID,''),@[usr_id],'TF'))) ||" ).append("\n"); 
		query.append("                              DECODE(A.SR_CRNT_INFO_CD,'R'" ).append("\n"); 
		query.append("                              ,DECODE(NVL(A.RTN_FM_USR_ID,''),@[usr_id],'RF'),'T'" ).append("\n"); 
		query.append("                              ,DECODE(NVL(A.RTN_TO_USR_ID,''),@[usr_id],'TT')),'NM') AS FILTER" ).append("\n"); 
		query.append("                              ,NVL(A.BL_DOC_INP_FLG,'N') AS BL_DOC_INP_FLG" ).append("\n"); 
		query.append("                              ,NVL(A.BL_RT_FLG,'N') AS BL_RT_FLG" ).append("\n"); 
		query.append("                              ,NVL(A.BL_AUD_FLG,'N') AS BL_AUD_FLG" ).append("\n"); 
		query.append("                              ,NVL(A.BL_DRFT_FAX_OUT_FLG,'N') AS BL_DRFT_FAX_OUT_FLG" ).append("\n"); 
		query.append("                              ,NVL(A.BL_FNT_OFC_FLG,'N') AS BL_FNT_OFC_FLG" ).append("\n"); 
		query.append("                              ,DECODE(A.SR_WRK_STS_CD,'T',NULL,A.SR_WRK_STS_CD) AS SR_WRK_STS_CD" ).append("\n"); 
		query.append("                              ,A.SR_WRK_STS_USR_ID" ).append("\n"); 
		query.append("                              ,(SELECT U.USR_NM FROM COM_USER U WHERE U.USR_ID = A.SR_WRK_STS_USR_ID) SR_WRK_STS_USR_NM" ).append("\n"); 
		query.append("                              ,DECODE(A.SR_WRK_STS_CD,'P', A.SR_WRK_STS_USR_ID) PND_USR_ID" ).append("\n"); 
		query.append("                              ,DECODE(A.SR_WRK_STS_CD,'P',(SELECT U.USR_NM FROM COM_USER U WHERE U.USR_ID = A.SR_WRK_STS_USR_ID)) PND_USR_NM" ).append("\n"); 
		query.append("                              ,B.BKG_OFC_CD" ).append("\n"); 
		query.append("                              ,A.SR_NO" ).append("\n"); 
		query.append("                              ,TO_CHAR(BKG_GET_DCT_FNC(A.BKG_NO),'YYYY-MM-DD') AS DOC_CCT" ).append("\n"); 
		query.append("                              ,RC_INP_FLG" ).append("\n"); 
		query.append("                              ,TO_CHAR(SR_WRK_STS_DT,'YYYY-MM-DD') AS SR_WRK_STS_DT" ).append("\n"); 
		query.append("                              ,nvl(A.FAX_LOG_REF_NO, xter.FAX_LOG_REF_NO) FAX_LOG_REF_NO" ).append("\n"); 
		query.append("                              ,(SELECT S.EML_SUBJ_CTNT FROM BKG_SR_FAX S WHERE S.SR_NO = A.SR_NO  AND S.FAX_LOG_REF_NO = A.FAX_LOG_REF_NO AND S.SR_KND_CD = A.SR_KND_CD) AS EML_SUBJ_CTNT" ).append("\n"); 
		query.append("                              ,(SELECT H.RTN_TO_USR_EML || '☜☞' || H.DIFF_RMK FROM BKG_SR_HIS H " ).append("\n"); 
		query.append("                              WHERE H.BKG_NO = A.BKG_NO " ).append("\n"); 
		query.append("                              AND   H.SR_NO = A.SR_NO " ).append("\n"); 
		query.append("                              AND   H.SR_KND_CD = A.SR_KND_CD" ).append("\n"); 
		query.append("                              AND   H.SR_HIS_SEQ = (SELECT MAX(H2.SR_HIS_SEQ)  " ).append("\n"); 
		query.append("                                                    FROM   BKG_SR_HIS H2 " ).append("\n"); 
		query.append("                                                    WHERE  H.BKG_NO   = H2.BKG_NO  " ).append("\n"); 
		query.append("                                                    AND    H.SR_NO    = H2.SR_NO " ).append("\n"); 
		query.append("                                                    AND    H.SR_KND_CD = H2.SR_KND_CD)" ).append("\n"); 
		query.append("                              ) AS BKG_HIS_VALUES" ).append("\n"); 
		query.append("                              ,VVD.SLAN_CD      " ).append("\n"); 
		query.append("                              ,VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD AS VVD_CD " ).append("\n"); 
		query.append("							  ,TO_CHAR(VPS.VPS_ETD_DT,'YYYY-MM-DD') AS VPS_ETD_DT" ).append("\n"); 
		query.append("                              ,(SELECT COUNT(1) FROM BKG_SR_HIS H ,BKG_SR_CRNT_RQST RQ  WHERE H.BKG_NO = A.BKG_NO  AND H.SR_STS_CD = 'SR' AND H.SR_KND_CD = RQ.SR_KND_CD AND H.SR_NO = RQ.SR_NO AND H.BKG_NO = RQ.BKG_NO) AS SR_AMD_SEQ 	" ).append("\n"); 
		query.append("                              ,COALESCE((SELECT CS.CSTMS_MF_TP_CD FROM   BKG_CSTMS_ADV_BL CS WHERE CS.BKG_NO = B.BKG_NO  AND CS.BL_NO = B.BL_NO AND ROWNUM = 1)," ).append("\n"); 
		query.append("                              " ).append("\n"); 
		query.append("                                ( -- 구주" ).append("\n"); 
		query.append("                                SELECT DECODE(R.ACK_RCV_STS_CD, 'A', 'ENS') " ).append("\n"); 
		query.append("                                FROM   BKG_CSTMS_EUR_BL      A" ).append("\n"); 
		query.append("                                      ,BKG_CSTMS_ADV_EUR_RCV R" ).append("\n"); 
		query.append("                                WHERE  A.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("                                AND    R.EUR_EDI_MSG_TP_ID = 'A' " ).append("\n"); 
		query.append("                                AND    A.MSG_SND_NO = R.MSG_RCV_NO " ).append("\n"); 
		query.append("                                AND	   R.ACK_RCV_STS_CD = 'A'" ).append("\n"); 
		query.append("                                AND    R.EDI_RCV_SEQ =  (SELECT MAX(R2.EDI_RCV_SEQ)" ).append("\n"); 
		query.append("                                              				FROM   BKG_CSTMS_ADV_EUR_RCV R2" ).append("\n"); 
		query.append("                                              				WHERE  R2.EUR_EDI_MSG_TP_ID = 'A' " ).append("\n"); 
		query.append("                                                      		AND    R2.MSG_RCV_NO = R.MSG_RCV_NO" ).append("\n"); 
		query.append("                                                      		--AND    R2.EDI_RCV_DT = R.EDI_RCV_DT" ).append("\n"); 
		query.append("                                                           )" ).append("\n"); 
		query.append("                                AND 	ROWNUM =1" ).append("\n"); 
		query.append("                                ),(SELECT NC.NTC_KND_CD FROM BKG_NTC_HIS NC" ).append("\n"); 
		query.append("                                   WHERE NC.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                     AND NC.NTC_KND_CD= 'IM'" ).append("\n"); 
		query.append("                                     AND NC.EDI_ID = 'MEXCUS'  ----Mexico 세관 전송 내역 " ).append("\n"); 
		query.append("                                     AND ROWNUM = 1)" ).append("\n"); 
		query.append("                              ) AS  CSTMS_MF_TP_CD" ).append("\n"); 
		query.append("                             ,XTER.BKG_UPLD_STS_CD" ).append("\n"); 
		query.append("                             ,B.OB_SREP_CD" ).append("\n"); 
		query.append("                             ,A.SR_AMD_TP_CD" ).append("\n"); 
		query.append("                             ,B.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("                             ,XTER.XTER_SNDR_ID" ).append("\n"); 
		query.append("                             ,XTER.XTER_RQST_NO" ).append("\n"); 
		query.append("                             ,XTER.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                             ,XTER.DOC_TP_CD" ).append("\n"); 
		query.append("                             ,B.SPLIT_FLG" ).append("\n"); 
		query.append("							,(SELECT DISTINCT RGN_OFC_CD" ).append("\n"); 
		query.append("                               FROM  BKG_EML_ACCT_STUP " ).append("\n"); 
		query.append("                               WHERE BKG_OFC_CD = B.BKG_OFC_CD" ).append("\n"); 
		query.append("                               AND DELT_FLG = 'N') RGN_OFC_CD" ).append("\n"); 
		query.append("                             ,CASE WHEN NVL(XTER.SPLIT_STS_CD,' ')= ' ' THEN NVL((SELECT DECODE(COUNT(1),0,'','S') FROM BKG_XTER_RQST_MST M2 WHERE M2.BKG_NO = B.BKG_NO AND M2.SPLIT_STS_CD IN ('W','S','F')),A.SPLIT_STS_CD) ELSE XTER.SPLIT_STS_CD END SPLIT_STS_CD " ).append("\n"); 
		query.append("                             ,NVL(NVL((SELECT BXRM.XTER_RQST_VIA_CD " ).append("\n"); 
		query.append("                    						 FROM   BKG_XTER_RQST_MST BXRM " ).append("\n"); 
		query.append("                    						 WHERE  BXRM.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("                    						 AND    BXRM.DOC_TP_CD = 'S' " ).append("\n"); 
		query.append("                    						 AND    TO_CHAR(BXRM.UPLD_GDT,'YYYYMMDDHH24MISS')||BXRM.XTER_RQST_SEQ = " ).append("\n"); 
		query.append("        				   							(SELECT MAX(TO_CHAR(BXRM1.UPLD_GDT,'YYYYMMDDHH24MISS')||BXRM1.XTER_RQST_SEQ)" ).append("\n"); 
		query.append("                  									FROM   BKG_XTER_RQST_MST BXRM1" ).append("\n"); 
		query.append("                  									WHERE  BXRM1.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("													AND    BXRM1.UPLD_GDT IS NOT NULL" ).append("\n"); 
		query.append("                  									AND    BXRM1.DOC_TP_CD = 'S'))" ).append("\n"); 
		query.append("                 						,DECODE(B.XTER_SI_CD,'NIS', 'OFF', 'APS', 'OFF',B.XTER_SI_CD) )" ).append("\n"); 
		query.append("										,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                   						  FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                   						  WHERE  INTG_CD_ID = 'CD01581'" ).append("\n"); 
		query.append("                                          AND    (APLY_ST_DT < TO_CHAR(SYSDATE, 'YYYYMMDD') AND APLY_END_DT > TO_CHAR(SYSDATE, 'YYYYMMDD'))" ).append("\n"); 
		query.append("                                          AND    INTG_CD_VAL_CTNT = A.SR_KND_CD))  AS XTER_SI_CD" ).append("\n"); 
		query.append("                            ,nvl(decode( (select count(cntr_no)" ).append("\n"); 
		query.append("                                              from bkg_xter_cntr xcntr" ).append("\n"); 
		query.append("                                             where 1=1" ).append("\n"); 
		query.append("                                               AND XTER.XTER_SNDR_ID = XCNTR.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("                                               AND XTER.XTER_RQST_NO = XCNTR.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("                                               AND XTER.XTER_RQST_SEQ = XCNTR.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("                                               and ((xcntr.vgm_wgt is not null" ).append("\n"); 
		query.append("                                                               and to_number(xcntr.vgm_wgt) > 0)" ).append("\n"); 
		query.append("                                                        or xcntr.vgm_wgt_ut_cd is not null" ).append("\n"); 
		query.append("                                                        or xcntr.VGM_VRFY_SIG_CTNT is not null) ), '0', 'N', " ).append("\n"); 
		query.append("                                      ( (select count(cntr_no)" ).append("\n"); 
		query.append("                                          from bkg_xter_cntr xcntr" ).append("\n"); 
		query.append("                                         where 1=1" ).append("\n"); 
		query.append("                                           AND XTER.XTER_SNDR_ID = XCNTR.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("                                           AND XTER.XTER_RQST_NO= XCNTR.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("                                           AND XTER.XTER_RQST_SEQ = XCNTR.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("                                           and ((xcntr.vgm_wgt is not null" ).append("\n"); 
		query.append("                                                           and to_number(xcntr.vgm_wgt) > 0)" ).append("\n"); 
		query.append("                                                    or xcntr.vgm_wgt_ut_cd is not null" ).append("\n"); 
		query.append("                                                    or xcntr.VGM_VRFY_SIG_CTNT is not null)) - " ).append("\n"); 
		query.append("                                        (select count(cntr_no)" ).append("\n"); 
		query.append("                                          from bkg_xter_cntr xcntr" ).append("\n"); 
		query.append("                                         where 1=1" ).append("\n"); 
		query.append("                                           AND XTER.XTER_SNDR_ID = XCNTR.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("                                           AND XTER.XTER_RQST_NO = XCNTR.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("                                           AND XTER.XTER_RQST_SEQ = XCNTR.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("                                           and (xcntr.vgm_wgt is null" ).append("\n"); 
		query.append("                                                    or to_number(xcntr.vgm_wgt) <= 0" ).append("\n"); 
		query.append("                                                    or xcntr.vgm_wgt_ut_cd is null" ).append("\n"); 
		query.append("                                                    or xcntr.VGM_VRFY_SIG_CTNT is null)) ), 'Y', 'I') ,SF.VGM_FLG ) VGM_FLG" ).append("\n"); 
		query.append("                       FROM   BKG_SR_CRNT_RQST A" ).append("\n"); 
		query.append("                             ,BKG_BOOKING B" ).append("\n"); 
		query.append("                             ,BKG_XTER_RQST_MST XTER" ).append("\n"); 
		query.append("                             ,BKG_CUSTOMER S" ).append("\n"); 
		query.append("                             ,BKG_CUSTOMER C" ).append("\n"); 
		query.append("                             ,BKG_CUSTOMER N" ).append("\n"); 
		query.append("                             ,BKG_CUSTOMER F" ).append("\n"); 
		query.append("                             ,MDM_LOCATION POR, MDM_LOCATION POL, MDM_LOCATION POD, MDM_LOCATION DEL" ).append("\n"); 
		query.append("                             ,BKG_VVD VVD" ).append("\n"); 
		query.append("							 ,VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("							 ,BKG_SR_FAX sf " ).append("\n"); 
		query.append("                       WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                       AND A.DPCS_OFC_CD = NVL(@[dpcs_ofc_cd], A.DPCS_OFC_CD)" ).append("\n"); 
		query.append("                     --  AND   A.SR_CRNT_STS_CD <> 'XX'" ).append("\n"); 
		query.append("                       AND   A.XTER_SNDR_ID       = XTER.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("                       AND   A.XTER_RQST_NO       = XTER.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("                       AND   A.XTER_RQST_SEQ      = XTER.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("                       AND    NVL(XTER.SNACCS_MSG_TP_CD, ' ')  NOT IN ( 'SAT050', 'SAT054' )" ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                       AND   B.POR_CD = POR.LOC_CD(+)" ).append("\n"); 
		query.append("                       AND 	 B.POL_CD = POL.LOC_CD(+)" ).append("\n"); 
		query.append("                       AND 	 B.POD_CD = POD.LOC_CD(+)" ).append("\n"); 
		query.append("                       AND 	 B.DEL_CD = DEL.LOC_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					   and Sf.SR_NO(+)= A.SR_NO  AND Sf.FAX_LOG_REF_NO(+)= A.FAX_LOG_REF_NO  AND Sf.SR_KND_CD(+)= A.SR_KND_CD --work                                       " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                       AND   VPS.VSL_CD(+)         =   VVD.VSL_CD" ).append("\n"); 
		query.append("                       AND   VPS.SKD_VOY_NO(+)     =   VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                       AND   VPS.SKD_DIR_CD(+)     =   VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                       AND   VPS.CLPT_IND_SEQ(+)   =   VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                       AND	 VPS.VPS_PORT_CD(+)    =   VVD.POL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                       AND   S.BKG_NO(+) = A.BKG_NO" ).append("\n"); 
		query.append("                       AND   S.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("                       AND   C.BKG_NO(+) = A.BKG_NO" ).append("\n"); 
		query.append("                       AND   C.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("                       AND   N.BKG_NO(+) = A.BKG_NO" ).append("\n"); 
		query.append("                       AND   N.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("                       AND   F.BKG_NO(+) = A.BKG_NO" ).append("\n"); 
		query.append("                       AND   F.BKG_CUST_TP_CD(+) = 'F'" ).append("\n"); 
		query.append("                       AND   VVD.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                       AND   VVD.VSL_PRE_PST_CD || VVD.VSL_SEQ =   (SELECT MIN(BV.VSL_PRE_PST_CD || BV.VSL_SEQ) " ).append("\n"); 
		query.append("                                                  	FROM   BKG_VVD BV" ).append("\n"); 
		query.append("                                                  	WHERE  BV.BKG_NO = VVD.BKG_NO)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                       /* Duration */" ).append("\n"); 
		query.append("                       #if (''==${bkg_no} && ''!=${dura_from_dt} && ''!=${dura_to_dt})" ).append("\n"); 
		query.append("					   	#if (${prd_flg} == 'T')" ).append("\n"); 
		query.append("                       	AND   A.SR_WRK_STS_DT >= TO_DATE(@[dura_from_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("                       	AND   A.SR_WRK_STS_DT < TO_DATE(@[dura_to_dt],'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("					   	#else" ).append("\n"); 
		query.append("                       	AND   A.CRNT_DT >= TO_DATE(@[dura_from_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("                       	AND   A.CRNT_DT < TO_DATE(@[dura_to_dt],'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                       /* Input */" ).append("\n"); 
		query.append("                       #if (''!=${input})" ).append("\n"); 
		query.append("                       AND   @[input] = NVL(A.BL_DOC_INP_FLG,'N')" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                       /* Rate */" ).append("\n"); 
		query.append("                       #if (''!=${rate})" ).append("\n"); 
		query.append("                       AND   @[rate] = NVL(A.BL_RT_FLG,'N')" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                       /* Qa */" ).append("\n"); 
		query.append("                       #if (''!=${qa})" ).append("\n"); 
		query.append("                       AND   @[qa] = NVL(A.BL_AUD_FLG,'N')" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                       /* Fax */" ).append("\n"); 
		query.append("                       #if (''!=${fax})" ).append("\n"); 
		query.append("                       AND   @[fax] = NVL(A.BL_DRFT_FAX_OUT_FLG,'N')" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                       /* Region */" ).append("\n"); 
		query.append("                       #if ('Y'!=${region_a} && ('Y'==${region_e} || 'Y'==${region_j} || 'Y'==${region_s}" ).append("\n"); 
		query.append("                       || 'Y'==${region_u} || 'Y'==${region_k} || 'Y'==${region_n}))" ).append("\n"); 
		query.append("                       AND   B.BKG_OFC_CD IN (" ).append("\n"); 
		query.append("                       #if ('Y'==${region_e})" ).append("\n"); 
		query.append("						(SELECT DISTINCT BKG_OFC_CD FROM BKG_EML_ACCT_STUP WHERE RGN_OFC_CD  ='E')" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                       #if ('Y'==${region_j})" ).append("\n"); 
		query.append("                       'KIJBA','OSASO','TYOSC'" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                       #if ('Y'==${region_s})" ).append("\n"); 
		query.append("                       'PENSO','PGUSO','PKGSC','SINSC'" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                       #if ('Y'==${region_u})" ).append("\n"); 
		query.append("                       'PHXSA','ATLSA','TORSC'" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                       #if ('Y'==${region_k})" ).append("\n"); 
		query.append("                       SELECT DISTINCT CRE_OFC_CD FROM BKG_INTG_NO_GEN  WHERE BKG_NO_GEN_DIV_CD ='BKG'" ).append("\n"); 
		query.append("                               AND    CRE_OFC_CD IN (SELECT DISTINCT  OFC_CD FROM MDM_ORGANIZATION WHERE SUBSTR(LOC_CD,1,2) IN ('KR'))" ).append("\n"); 
		query.append("                       #end	" ).append("\n"); 
		query.append("                       #if ('Y'==${region_n})" ).append("\n"); 
		query.append("                       SELECT DISTINCT CRE_OFC_CD FROM BKG_INTG_NO_GEN  WHERE BKG_NO_GEN_DIV_CD ='BKG'" ).append("\n"); 
		query.append("                               AND    CRE_OFC_CD IN (SELECT DISTINCT  OFC_CD FROM MDM_ORGANIZATION WHERE SUBSTR(LOC_CD,1,2) IN ('US','CA'))" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("						                 )" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                       #if ('Y'==${region_o})" ).append("\n"); 
		query.append("                       AND (B.BKG_OFC_CD NOT IN ('ANRSO','BRESO','DUSSO','FRASO','FXTBO','HAMSC','LONBB','MANBS','MUCSO','RTMSC','FXTSC','HAMRUG'," ).append("\n"); 
		query.append("                                 												'KIJBA','OSASO','TYOSC'," ).append("\n"); 
		query.append("                                 												'PENSO','PGUSO','PKGSC','SINSC'," ).append("\n"); 
		query.append("                                 												'PHXSA','ATLSA','TORSC','LEHSC','MARBB')" ).append("\n"); 
		query.append("                                       AND" ).append("\n"); 
		query.append("                                       B.BKG_OFC_CD NOT IN (SELECT DISTINCT CRE_OFC_CD " ).append("\n"); 
		query.append("                                                            FROM BKG_INTG_NO_GEN  " ).append("\n"); 
		query.append("                                                            WHERE BKG_NO_GEN_DIV_CD ='BKG'" ).append("\n"); 
		query.append("                                                            AND    CRE_OFC_CD IN (SELECT DISTINCT  OFC_CD FROM MDM_ORGANIZATION WHERE SUBSTR(LOC_CD,1,2) IN ('KR','US','CA'))" ).append("\n"); 
		query.append("                                                            )" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                       /* VVD */" ).append("\n"); 
		query.append("                       #if (''!=${vvd_cd})" ).append("\n"); 
		query.append("                       AND   SUBSTRB(@[vvd_cd],1,4) = VVD.VSL_CD" ).append("\n"); 
		query.append("                       AND   SUBSTRB(@[vvd_cd],5,4) = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                       AND   SUBSTRB(@[vvd_cd],9,1) = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                       /* POL */" ).append("\n"); 
		query.append("                       #if (''!=${pol_cd})" ).append("\n"); 
		query.append("                       AND   B.POL_CD LIKE RTRIM(@[pol_cd]) ||'%'" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                       /* POD */" ).append("\n"); 
		query.append("                       #if (''!=${pod_cd})" ).append("\n"); 
		query.append("                       AND   B.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                       /* Booking No */" ).append("\n"); 
		query.append("                       #if (''!=${bkg_no})" ).append("\n"); 
		query.append("                       AND   B.BKG_NO LIKE @[bkg_no]||'%'" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                       /* Booking Office */" ).append("\n"); 
		query.append("                       #if (''!=${bkg_ofc_cd})" ).append("\n"); 
		query.append("                       AND   B.BKG_OFC_CD LIKE '%'||@[bkg_ofc_cd]||'%'" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                       /* STS */" ).append("\n"); 
		query.append("                       #if ('X'==${sts} || 'F' == ${sr_amd_tp_cd})" ).append("\n"); 
		query.append("                       AND   'XX' = A.SR_CRNT_STS_CD" ).append("\n"); 
		query.append("                       #elseif (''!=${sts} && 'A'!=${sts})" ).append("\n"); 
		query.append("                       AND   @[sts] = A.SR_WRK_STS_CD" ).append("\n"); 
		query.append("                       AND	 A.SR_CRNT_STS_CD <> 'XX'" ).append("\n"); 
		query.append("                       #else" ).append("\n"); 
		query.append("                       AND	 A.SR_CRNT_STS_CD <> 'XX'" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                       /* SRC */" ).append("\n"); 
		query.append("                       #if (${src_cd} != '') " ).append("\n"); 
		query.append("                       AND   @[src_cd] = A.SR_KND_CD" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                       /* S/R KIND */" ).append("\n"); 
		query.append("                       #if (${sr_amd_tp_cd} != '' && ${sr_amd_tp_cd} != 'L') " ).append("\n"); 
		query.append("                       AND   @[sr_amd_tp_cd] = A.SR_AMD_TP_CD " ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                       /* LANE */" ).append("\n"); 
		query.append("                       #if (${slan_cd} != '' && ${slan_cd} != 'All') " ).append("\n"); 
		query.append("                       AND   @[slan_cd] = VVD.SLAN_CD " ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                       #if (${set_qry_where} != '') " ).append("\n"); 
		query.append("                          ${set_qry_where} )" ).append("\n"); 
		query.append("                 	   #end" ).append("\n"); 
		query.append("                      ## Customer Type에 따른 Customer Code 및 Customer Name이 조건으로 들어온 경우 <S>" ).append("\n"); 
		query.append("                      #if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("                      	#if (${bkg_cust_tp_cd} == 'S')" ).append("\n"); 
		query.append("                      		AND S.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("                      	#elseif (${bkg_cust_tp_cd} == 'C')" ).append("\n"); 
		query.append("                      		AND C.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("                        #elseif (${bkg_cust_tp_cd} == 'N')" ).append("\n"); 
		query.append("                      		AND N.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("                      	#elseif (${bkg_cust_tp_cd} == 'F')" ).append("\n"); 
		query.append("                      		AND F.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("                      	#end" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("                      #if (${cust_seq} != '')" ).append("\n"); 
		query.append("                      	#if (${bkg_cust_tp_cd} == 'S')" ).append("\n"); 
		query.append("                      		AND S.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("                      	#elseif (${bkg_cust_tp_cd} == 'C')" ).append("\n"); 
		query.append("                      		AND C.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("                        #elseif (${bkg_cust_tp_cd} == 'N')" ).append("\n"); 
		query.append("                      		AND N.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("                      	#elseif (${bkg_cust_tp_cd} == 'F')" ).append("\n"); 
		query.append("                      		AND F.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("                      	#end" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("                      #if (${cust_nm} != '')" ).append("\n"); 
		query.append("                      	#if (${bkg_cust_tp_cd} == 'S')" ).append("\n"); 
		query.append("                      		AND UPPER(S.CUST_NM) LIKE @[cust_nm] || '%'" ).append("\n"); 
		query.append("                      	#elseif (${bkg_cust_tp_cd} == 'C')" ).append("\n"); 
		query.append("                      		AND UPPER(C.CUST_NM) LIKE @[cust_nm] || '%'" ).append("\n"); 
		query.append("                        #elseif (${bkg_cust_tp_cd} == 'N')" ).append("\n"); 
		query.append("                      		AND UPPER(N.CUST_NM) LIKE @[cust_nm] || '%'" ).append("\n"); 
		query.append("                      	#elseif (${bkg_cust_tp_cd} == 'F')" ).append("\n"); 
		query.append("                      		AND UPPER(F.CUST_NM) LIKE @[cust_nm] || '%'" ).append("\n"); 
		query.append("                      	#end" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                      ## Customer Type에 따른 Customer Code 및 Customer Name이 조건으로 들어온 경우 <E>" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("                      #if (${srep_cd} != '') " ).append("\n"); 
		query.append("                          AND NVL(B.OB_SREP_CD, XTER.SREP_CD) = @[srep_cd]" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                          AND B.BKG_STS_CD != 'X'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                      #if (${split_only_flg} != '') " ).append("\n"); 
		query.append("                          AND (CASE WHEN NVL(XTER.SPLIT_STS_CD,' ')= ' ' THEN (SELECT DECODE(COUNT(1),0,'','S') FROM BKG_XTER_RQST_MST M2 WHERE M2.BKG_NO = B.BKG_NO AND M2.SPLIT_STS_CD IN ('W','S','F')) ELSE XTER.SPLIT_STS_CD END)     IN ('W','S','F')" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* RETURN TYPE CD 체크 추가 2016.01.05 " ).append("\n"); 
		query.append("   FNT_OFC_RTN_CD 'S','FO','I','Inputter','R','Rater','C','Customer','P','S.REP'" ).append("\n"); 
		query.append("   DECODE(DECODE (A.SR_CRNT_INFO_CD,'R','RT','T','TF') ,'RT','<<-','TF','->>'" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("             #if (${return_tp_cd} != '') " ).append("\n"); 
		query.append("				AND A.SR_CRNT_INFO_CD = BKG_GET_TOKEN_FNC(@[return_tp_cd],2)" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                       ) X" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("/* RETURN TYPE CD 체크 추가 2016.01.05 " ).append("\n"); 
		query.append("   FNT_OFC_RTN_CD 'S','FO','I','Inputter','R','Rater','C','Customer','P','S.REP'" ).append("\n"); 
		query.append("   DECODE(DECODE (A.SR_CRNT_INFO_CD,'R','RT','T','TF') ,'RT','<<-','TF','->>'" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("             #if (${return_tp_cd} != '') " ).append("\n"); 
		query.append("				AND X.FNT_OFC_RTN_CD  = BKG_GET_TOKEN_FNC(@[return_tp_cd],1)" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             AND ((SR_DATE < TO_DATE('20120415','YYYYMMDD') AND VVD_CD IS NOT NULL)" ).append("\n"); 
		query.append("                OR SR_DATE >= TO_DATE('20120415','YYYYMMDD') )" ).append("\n"); 
		query.append("             #if (${return_to} != '') " ).append("\n"); 
		query.append("	             AND   X.RETURN_FROM_CD IN (${return_to})" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("			 #if (${pic_id} !='')" ).append("\n"); 
		query.append(" 		     	AND (" ).append("\n"); 
		query.append("                     UPPER(SUBSTR(PIC_ID,1,INSTR(PIC_ID,'(') -1)) LIKE '%'||UPPER(@[pic_id])||'%'" ).append("\n"); 
		query.append("                    OR" ).append("\n"); 
		query.append("                     UPPER(CRNT_USR_ID) LIKE '%'||UPPER(@[pic_id])||'%'" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("			 #end" ).append("\n"); 
		query.append("             ORDER BY SRC,BL_DOC_INP_FLG,BL_RT_FLG,BL_AUD_FLG,BL_DRFT_FAX_OUT_FLG,BKG_NO ) Z" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE  RNUM BETWEEN NVL(@[rows_per_page],50) * (NVL(@[curr_page],1)-1)+1" ).append("\n"); 
		query.append("AND     NVL(@[rows_per_page],50) * NVL(@[curr_page],1)" ).append("\n"); 

	}
}