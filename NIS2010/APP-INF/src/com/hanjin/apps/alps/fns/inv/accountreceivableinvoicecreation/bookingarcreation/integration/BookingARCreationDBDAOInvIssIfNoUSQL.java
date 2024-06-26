/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BookingARCreationDBDAOInvIssIfNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOInvIssIfNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvIssIfNo
	  * </pre>
	  */
	public BookingARCreationDBDAOInvIssIfNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wrk_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("login_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ind_iss_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOInvIssIfNoUSQL").append("\n"); 
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
		query.append("MERGE INTO INV_AR_MN X" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("SELECT B.AR_IF_NO" ).append("\n"); 
		query.append("       ,CASE WHEN B.DUE_DT_LAST  > TO_CHAR(LAST_DAY(TO_DATE(SUBSTR(B.DUE_DT_LAST,1,6),'YYYYMM')),'YYYYMMDD') THEN TO_CHAR(LAST_DAY(TO_DATE(SUBSTR(B.DUE_DT_LAST,1,6),'YYYYMM')),'YYYYMMDD')" ).append("\n"); 
		query.append("             ELSE B.DUE_DT_LAST" ).append("\n"); 
		query.append("        END DUE_DT_LAST  " ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT B.AR_IF_NO" ).append("\n"); 
		query.append("      ,CASE WHEN OTS_SMRY_CD = 'INV' THEN" ).append("\n"); 
		query.append("                                           CASE WHEN PAY_DT_DY1 IS NULL AND PAY_DT_DY2 IS NULL AND PAY_DT_DY3 IS NULL AND PAY_DT_DY4 IS NULL" ).append("\n"); 
		query.append("                                                 THEN DUE_DT" ).append("\n"); 
		query.append("                                                WHEN TO_NUMBER(SUBSTRB(DUE_DT,-2)) > GREATEST(NVL(TO_NUMBER(PAY_DT_DY1),0), NVL(TO_NUMBER(PAY_DT_DY2),0), NVL(TO_NUMBER(PAY_DT_DY3),0), NVL(TO_NUMBER(PAY_DT_DY4),0)) " ).append("\n"); 
		query.append("                                                THEN TO_CHAR(ADD_MONTHS(TO_DATE(SUBSTRB(DUE_DT,1,6),'YYYYMM'),1),'YYYYMM')||TRIM(TO_CHAR(LEAST(NVL(TO_NUMBER(PAY_DT_DY1),99), NVL(TO_NUMBER(PAY_DT_DY2),99), NVL(TO_NUMBER(PAY_DT_DY3),99), NVL(TO_NUMBER(PAY_DT_DY4),99)),'09'))" ).append("\n"); 
		query.append("                                                ELSE SUBSTRB(DUE_DT,1,6)||TRIM(TO_CHAR(LEAST(NVL(TO_NUMBER(PAY_DT_DY1_NEW),99), NVL(TO_NUMBER(PAY_DT_DY2_NEW),99), NVL(TO_NUMBER(PAY_DT_DY3_NEW),99),NVL(TO_NUMBER(PAY_DT_DY4_NEW),99)),'09'))" ).append("\n"); 
		query.append("                                           END " ).append("\n"); 
		query.append("             ELSE (SELECT P.DUE_DT FROM INV_AR_MN P WHERE P.AR_IF_NO = B.MAX_AR_IF_NO) " ).append("\n"); 
		query.append("       END DUE_DT_LAST                                    " ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT A.*" ).append("\n"); 
		query.append("               ,SUBSTRB(DUE_DT,-2)" ).append("\n"); 
		query.append("               ,CASE WHEN NVL(TO_NUMBER(PAY_DT_DY1),0) >= TO_NUMBER(SUBSTRB(DUE_DT,-2)) THEN NVL(TO_NUMBER(PAY_DT_DY1),0) END PAY_DT_DY1_NEW   " ).append("\n"); 
		query.append("               ,CASE WHEN NVL(TO_NUMBER(PAY_DT_DY2),0) >= TO_NUMBER(SUBSTRB(DUE_DT,-2)) THEN NVL(TO_NUMBER(PAY_DT_DY2),0) END PAY_DT_DY2_NEW" ).append("\n"); 
		query.append("               ,CASE WHEN NVL(TO_NUMBER(PAY_DT_DY3),0) >= TO_NUMBER(SUBSTRB(DUE_DT,-2)) THEN NVL(TO_NUMBER(PAY_DT_DY3),0) END PAY_DT_DY3_NEW" ).append("\n"); 
		query.append("               ,CASE WHEN NVL(TO_NUMBER(PAY_DT_DY4),0) >= TO_NUMBER(SUBSTRB(DUE_DT,-2)) THEN NVL(TO_NUMBER(PAY_DT_DY4),0) END PAY_DT_DY4_NEW  " ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT  CASE WHEN CUST_CR_FLG = 'Y'" ).append("\n"); 
		query.append("                        THEN CASE WHEN REV_TP_CD = 'M' OR TRSP_RQST_ORD_FLG = 'Y' " ).append("\n"); 
		query.append("                             THEN CASE WHEN NVL(B.CUST_CR_DUE_DT_DIV_CD,'S') ='S'" ).append("\n"); 
		query.append("                                        THEN TO_CHAR(CASE WHEN E.AR_IF_NO IS NULL THEN TO_DATE(SAIL_ARR_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                                                           ELSE TO_DATE(@[iss_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("                                                     END      " ).append("\n"); 
		query.append("                                               + CASE WHEN CUST_CR_FLG = 'Y' AND IO_BND_CD = 'O' THEN DECODE(NVL(B.OB_CR_TERM_DYS,0),0,NVL(C.OB_CR_TERM_DYS,0),NVL(B.OB_CR_TERM_DYS,0))                                                                                    " ).append("\n"); 
		query.append("                                                      WHEN CUST_CR_FLG = 'Y' AND IO_BND_CD = 'I' THEN DECODE(NVL(B.IB_CR_TERM_DYS,0),0,NVL(C.IB_CR_TERM_DYS,0),NVL(B.IB_CR_TERM_DYS,0))   " ).append("\n"); 
		query.append("                                                      WHEN CUST_CR_FLG = 'N' AND IO_BND_CD = 'O' THEN NVL(C.OB_CR_TERM_DYS,0)                                                                                                           " ).append("\n"); 
		query.append("                                                      WHEN CUST_CR_FLG = 'N' AND IO_BND_CD = 'I' THEN DECODE(A.AR_OFC_CD, 'BOMSC', DECODE(A.DEL_CD, 'INDEL', 25, 'INLDH', 25,  NVL(C.IB_CR_TERM_DYS,0)))" ).append("\n"); 
		query.append("                                                 END,'YYYYMMDD') " ).append("\n"); 
		query.append("                                       ELSE TO_CHAR(TO_DATE(@[iss_dt],'YYYYMMDD') " ).append("\n"); 
		query.append("                                               + CASE WHEN CUST_CR_FLG = 'Y' AND IO_BND_CD = 'O' THEN DECODE(NVL(B.OB_CR_TERM_DYS,0),0,NVL(C.OB_CR_TERM_DYS,0),NVL(B.OB_CR_TERM_DYS,0))                                                                                    " ).append("\n"); 
		query.append("                                                      WHEN CUST_CR_FLG = 'Y' AND IO_BND_CD = 'I' THEN DECODE(NVL(B.IB_CR_TERM_DYS,0),0,NVL(C.IB_CR_TERM_DYS,0),NVL(B.IB_CR_TERM_DYS,0))   " ).append("\n"); 
		query.append("                                                      WHEN CUST_CR_FLG = 'N' AND IO_BND_CD = 'O' THEN NVL(C.OB_CR_TERM_DYS,0)                                                                                                           " ).append("\n"); 
		query.append("                                                      WHEN CUST_CR_FLG = 'N' AND IO_BND_CD = 'I' THEN DECODE(A.AR_OFC_CD, 'BOMSC', DECODE(A.DEL_CD, 'INDEL', 25, 'INLDH', 25,  NVL(C.IB_CR_TERM_DYS,0)))" ).append("\n"); 
		query.append("                                                 END,'YYYYMMDD')                                                   " ).append("\n"); 
		query.append("                                  END               " ).append("\n"); 
		query.append("                             ELSE CASE WHEN NVL(B.CUST_CR_DUE_DT_DIV_CD,'S') ='S' " ).append("\n"); 
		query.append("                                        THEN TO_CHAR(TO_DATE(SAIL_ARR_DT,'YYYYMMDD') " ).append("\n"); 
		query.append("                                               + CASE WHEN CUST_CR_FLG = 'Y' AND IO_BND_CD = 'O' THEN DECODE(NVL(B.OB_CR_TERM_DYS,0),0,NVL(C.OB_CR_TERM_DYS,0),NVL(B.OB_CR_TERM_DYS,0))                                                                                    " ).append("\n"); 
		query.append("                                                      WHEN CUST_CR_FLG = 'Y' AND IO_BND_CD = 'I' THEN DECODE(NVL(B.IB_CR_TERM_DYS,0),0,NVL(C.IB_CR_TERM_DYS,0),NVL(B.IB_CR_TERM_DYS,0))   " ).append("\n"); 
		query.append("                                                      WHEN CUST_CR_FLG = 'N' AND IO_BND_CD = 'O' THEN NVL(C.OB_CR_TERM_DYS,0)                                                                                                           " ).append("\n"); 
		query.append("                                                      WHEN CUST_CR_FLG = 'N' AND IO_BND_CD = 'I' THEN DECODE(A.AR_OFC_CD, 'BOMSC', DECODE(A.DEL_CD, 'INDEL', 25, 'INLDH', 25,  NVL(C.IB_CR_TERM_DYS,0)))" ).append("\n"); 
		query.append("                                                 END,'YYYYMMDD') " ).append("\n"); 
		query.append("                                       ELSE TO_CHAR(TO_DATE(@[iss_dt],'YYYYMMDD') " ).append("\n"); 
		query.append("                                               + CASE WHEN CUST_CR_FLG = 'Y' AND IO_BND_CD = 'O' THEN DECODE(NVL(B.OB_CR_TERM_DYS,0),0,NVL(C.OB_CR_TERM_DYS,0),NVL(B.OB_CR_TERM_DYS,0))                                                                                    " ).append("\n"); 
		query.append("                                                      WHEN CUST_CR_FLG = 'Y' AND IO_BND_CD = 'I' THEN DECODE(NVL(B.IB_CR_TERM_DYS,0),0,NVL(C.IB_CR_TERM_DYS,0),NVL(B.IB_CR_TERM_DYS,0))   " ).append("\n"); 
		query.append("                                                      WHEN CUST_CR_FLG = 'N' AND IO_BND_CD = 'O' THEN NVL(C.OB_CR_TERM_DYS,0)                                                                                                           " ).append("\n"); 
		query.append("                                                      WHEN CUST_CR_FLG = 'N' AND IO_BND_CD = 'I' THEN DECODE(A.AR_OFC_CD, 'BOMSC', DECODE(A.DEL_CD, 'INDEL', 25, 'INLDH', 25,  NVL(C.IB_CR_TERM_DYS,0)))" ).append("\n"); 
		query.append("                                                 END,'YYYYMMDD')  " ).append("\n"); 
		query.append("                                  END " ).append("\n"); 
		query.append("                             END" ).append("\n"); 
		query.append("                        ELSE A.DUE_DT              " ).append("\n"); 
		query.append("                        END DUE_DT" ).append("\n"); 
		query.append("                        ,B.PAY_DT_DY1, B.PAY_DT_DY2, B.PAY_DT_DY3, B.PAY_DT_DY4" ).append("\n"); 
		query.append("                        ,B.CUST_CNT_CD" ).append("\n"); 
		query.append("                        ,B.CUST_SEQ" ).append("\n"); 
		query.append("                        ,D.OTS_SMRY_CD" ).append("\n"); 
		query.append("                        ,A.INV_DELT_DIV_CD" ).append("\n"); 
		query.append("                        ,A.AR_IF_NO" ).append("\n"); 
		query.append("                        ,MAX(CASE WHEN NVL(A.INV_DELT_DIV_CD,'N') <> 'Y'THEN A.AR_IF_NO END) OVER (PARTITION BY A.BL_SRC_NO,A.AR_OFC_CD) MAX_AR_IF_NO " ).append("\n"); 
		query.append("                  FROM INV_AR_MN A,MDM_CR_CUST B,MDM_ORGANIZATION C,INV_AR_STUP_OFC D," ).append("\n"); 
		query.append("                       (SELECT AR_IF_NO" ).append("\n"); 
		query.append("                          FROM INV_AR_ISS_FTR A" ).append("\n"); 
		query.append("                         WHERE INV_ISS_WRK_NO = @[wrk_no]" ).append("\n"); 
		query.append("                           AND BL_SRC_NO IN (SELECT BL_SRC_NO" ).append("\n"); 
		query.append("                                               FROM (SELECT BL_SRC_NO,AR_IF_NO " ).append("\n"); 
		query.append("                                                           ,COUNT(*) OVER (PARTITION BY BL_SRC_NO) CNT " ).append("\n"); 
		query.append("                                                       FROM (SELECT DISTINCT BL_SRC_NO,AR_IF_NO " ).append("\n"); 
		query.append("                                                               FROM INV_AR_ISS_FTR   " ).append("\n"); 
		query.append("                                                              WHERE INV_ISS_WRK_NO = @[wrk_no] ) " ).append("\n"); 
		query.append("                                                     )" ).append("\n"); 
		query.append("                                              WHERE CNT = 1  " ).append("\n"); 
		query.append("                                             )" ).append("\n"); 
		query.append("                       ) E                  " ).append("\n"); 
		query.append("                 WHERE A.ACT_CUST_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("                   AND A.ACT_CUST_SEQ = B.CUST_SEQ(+)" ).append("\n"); 
		query.append("                   AND A.AR_OFC_CD = C.OFC_CD(+)" ).append("\n"); 
		query.append("                   AND A.AR_OFC_CD = D.AR_OFC_CD(+)" ).append("\n"); 
		query.append("                   AND A.AR_IF_NO = E.AR_IF_NO(+)   " ).append("\n"); 
		query.append("            		#if (${rev_type} != '')" ).append("\n"); 
		query.append("						#if (${rev_type} == 'M')     " ).append("\n"); 
		query.append("   						AND A.REV_TP_CD = 'M'" ).append("\n"); 
		query.append("						#elseif (${rev_type} == 'F')     " ).append("\n"); 
		query.append("   						AND A.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("                   AND A.AR_IF_NO IN (  SELECT V1.AR_IF_NO " ).append("\n"); 
		query.append("                                          FROM INV_AR_ISS_FTR V1" ).append("\n"); 
		query.append("                                         WHERE INV_ISS_WRK_NO = @[wrk_no] " ).append("\n"); 
		query.append("                                         GROUP BY V1.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("                                             , V1.ACT_CUST_SEQ" ).append("\n"); 
		query.append("                                             , V1.VSL_CD" ).append("\n"); 
		query.append("                                             , V1.SKD_VOY_NO" ).append("\n"); 
		query.append("                                             , V1.SKD_DIR_CD" ).append("\n"); 
		query.append("                                             , V1.IO_BND_CD" ).append("\n"); 
		query.append("                                             , V1.PORT_CD" ).append("\n"); 
		query.append("                                             , V1.SVC_SCP_CD" ).append("\n"); 
		query.append("                                        #if (${inv_mlt_bl_iss_flg} != 'Y') " ).append("\n"); 
		query.append("                                             , V1.BL_SRC_NO" ).append("\n"); 
		query.append("                                        #end" ).append("\n"); 
		query.append("                                             , V1.INV_ISS_TP_CD" ).append("\n"); 
		query.append("                                             , V1.INV_SPLIT_CD" ).append("\n"); 
		query.append("                                             , V1.USD_XCH_RT" ).append("\n"); 
		query.append("                                             , V1.AR_OFC_CD" ).append("\n"); 
		query.append("                                             , V1.AR_IF_NO " ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("                ) A" ).append("\n"); 
		query.append("      ) B ) B GROUP BY B.AR_IF_NO, B.DUE_DT_LAST ) Y" ).append("\n"); 
		query.append("    ON (    X.AR_IF_NO = Y.AR_IF_NO )      " ).append("\n"); 
		query.append("  WHEN MATCHED THEN UPDATE SET X.DUE_DT = Y.DUE_DT_LAST " ).append("\n"); 
		query.append("                              ,X.INV_ISS_FLG ='Y'" ).append("\n"); 
		query.append("                              --,X.INV_CLR_FLG ='N'   " ).append("\n"); 
		query.append("                              ,X.UPD_USR_ID = @[user_id]" ).append("\n"); 
		query.append("                              ,X.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("							  ,X.ISS_DT = TO_CHAR(TO_DATE(@[iss_dt],'YYYYMMDD'),'YYYYMMDD')" ).append("\n"); 
		query.append("							  #if (${ofc_cd} == 'DXBSC')" ).append("\n"); 
		query.append("							  ,X.INV_NO = (SELECT MAX(K.INV_NO) FROM INV_AR_ISS_DTL K WHERE K.AR_IF_NO = Y.AR_IF_NO " ).append("\n"); 
		query.append("                    						AND SUBSTR(K.INV_NO,4) = (SELECT MAX(SUBSTR(M.INV_NO,4)) FROM INV_AR_ISS_DTL M WHERE M.AR_IF_NO = K.AR_IF_NO) )" ).append("\n"); 
		query.append("							  #elseif (${ofc_cd} == 'BOMSC')		--2017.07.20 인도 GST 세법 변경 관련 보완" ).append("\n"); 
		query.append("							  ,X.INV_NO = (SELECT MAX(INV_NO) FROM INV_AR_ISS_DTL WHERE INV_NO LIKE TRIM(REPLACE(@[ind_iss_tp_cd], 'T', '')||SUBSTR(@[login_ofc_cd], 1, 4)||TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[login_ofc_cd]), 'YYMM'))||'%'  AND AR_IF_NO = Y.AR_IF_NO)" ).append("\n"); 
		query.append("							  #else" ).append("\n"); 
		query.append("							  ,X.INV_NO = (SELECT MAX(INV_NO) FROM INV_AR_ISS_DTL WHERE AR_IF_NO = Y.AR_IF_NO)" ).append("\n"); 
		query.append("							  #end" ).append("\n"); 

	}
}