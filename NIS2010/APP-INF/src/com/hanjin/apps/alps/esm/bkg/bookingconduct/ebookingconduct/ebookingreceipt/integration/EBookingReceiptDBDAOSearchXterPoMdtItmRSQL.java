/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchXterPoMdtItmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.09
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2012.11.09 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchXterPoMdtItmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PO NO 기준 ITEM 조회
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchXterPoMdtItmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sh_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nf_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sh_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cn_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nf_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cn_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchXterPoMdtItmRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(MAX(SYS_CONNECT_BY_PATH(ITEM, ',')), 2) AS PATH_ITEM" ).append("\n"); 
		query.append("  FROM (SELECT ROWNUM AS RID, ITEM" ).append("\n"); 
		query.append("          FROM (SELECT DISTINCT DTL.BKG_MDT_ITM_CD AS ITEM" ).append("\n"); 
		query.append("                  FROM (SELECT MDT_ITM_SEQ" ).append("\n"); 
		query.append("                          FROM (SELECT A1.BKG_NO," ).append("\n"); 
		query.append("                                       DECODE(A2.BKG_CUST_TP_CD,'S','SH','C','CN','N','NT','') AS MDT_CUST_TP_CD," ).append("\n"); 
		query.append("                                       NVL(A2.CUST_CNT_CD, '0') AS CUST_CNT_CD," ).append("\n"); 
		query.append("                                       NVL(A2.CUST_SEQ, '0') AS CUST_SEQ," ).append("\n"); 
		query.append("                                       NVL(A1.SC_NO, '0') AS SC_NO," ).append("\n"); 
		query.append("                                       NVL(A1.RFA_NO, '0') AS RFA_NO," ).append("\n"); 
		query.append("                                       NVL(A1.SVC_SCP_CD, '0') AS SVC_SCP_CD," ).append("\n"); 
		query.append("                                       NVL(A1.POR_CD, '0') AS POR_CD," ).append("\n"); 
		query.append("                                       NVL(A1.DEL_CD, '0') AS DEL_CD," ).append("\n"); 
		query.append("                                       NVL(A3.CUST_GRP_ID, '0') AS CUST_GRP_ID" ).append("\n"); 
		query.append("                                  FROM --BKG_BOOKING  A1," ).append("\n"); 
		query.append("                                       (SELECT @[bkg_no] AS BKG_NO, @[sc_no] AS SC_NO, @[rfa_no] AS RFA_NO, " ).append("\n"); 
		query.append("                                               @[svc_scp_cd] AS SVC_SCP_CD, @[por_cd] AS POR_CD, @[del_cd] AS DEL_CD" ).append("\n"); 
		query.append("                                       FROM DUAL) A1, " ).append("\n"); 
		query.append("                                       --BKG_CUSTOMER A2," ).append("\n"); 
		query.append("                                       (SELECT 'S' AS BKG_CUST_TP_CD, @[sh_cust_cnt_cd] AS CUST_CNT_CD, @[sh_cust_seq] AS CUST_SEQ" ).append("\n"); 
		query.append("                                        FROM DUAL" ).append("\n"); 
		query.append("                                        union all" ).append("\n"); 
		query.append("                                        SELECT 'C' AS BKG_CUST_TP_CD, @[cn_cust_cnt_cd] AS CUST_CNT_CD, @[cn_cust_seq] AS CUST_SEQ" ).append("\n"); 
		query.append("                                        FROM DUAL" ).append("\n"); 
		query.append("                                        union all" ).append("\n"); 
		query.append("                                        SELECT 'N' AS BKG_CUST_TP_CD, @[nf_cust_cnt_cd] AS CUST_CNT_CD, @[nf_cust_seq] AS CUST_SEQ" ).append("\n"); 
		query.append("                                        FROM DUAL) A2," ).append("\n"); 
		query.append("                                       MDM_CUSTOMER A3" ).append("\n"); 
		query.append("                                 WHERE " ).append("\n"); 
		query.append("                                       A2.CUST_CNT_CD = A3.CUST_CNT_CD" ).append("\n"); 
		query.append("                                   AND A2.CUST_SEQ = A3.CUST_SEQ) B1," ).append("\n"); 
		query.append("                               (SELECT MDT_ITM_SEQ," ).append("\n"); 
		query.append("                                       DECODE(CUST_GRP_ID," ).append("\n"); 
		query.append("                                              'G'," ).append("\n"); 
		query.append("                                              CUST_GRP_ID || '-' || CUST_CNT_CD ||" ).append("\n"); 
		query.append("                                              LPAD(CUST_SEQ, 6, 0)) AS CUST_GRP_ID," ).append("\n"); 
		query.append("                                       MDT_CUST_TP_CD," ).append("\n"); 
		query.append("                                       CUST_CNT_CD," ).append("\n"); 
		query.append("                                       CUST_SEQ," ).append("\n"); 
		query.append("                                       SC_NO," ).append("\n"); 
		query.append("                                       RFA_NO," ).append("\n"); 
		query.append("                                       SVC_SCP_CD," ).append("\n"); 
		query.append("                                       POR_CD," ).append("\n"); 
		query.append("                                       DEL_CD" ).append("\n"); 
		query.append("                                  FROM BKG_MDT_ITM) B2" ).append("\n"); 
		query.append("                         WHERE 1 = 1" ).append("\n"); 
		query.append("                           AND B1.MDT_CUST_TP_CD =" ).append("\n"); 
		query.append("                               DECODE(B2.MDT_CUST_TP_CD," ).append("\n"); 
		query.append("                                      'Al'," ).append("\n"); 
		query.append("                                      B1.MDT_CUST_TP_CD," ).append("\n"); 
		query.append("                                      B2.MDT_CUST_TP_CD)" ).append("\n"); 
		query.append("                           AND B1.CUST_GRP_ID =" ).append("\n"); 
		query.append("                               NVL(B2.CUST_GRP_ID, B1.CUST_GRP_ID)" ).append("\n"); 
		query.append("                           AND B1.CUST_CNT_CD =" ).append("\n"); 
		query.append("                               NVL(B2.CUST_CNT_CD, B1.CUST_CNT_CD)" ).append("\n"); 
		query.append("                           AND B1.CUST_SEQ = NVL(B2.CUST_SEQ, B1.CUST_SEQ)" ).append("\n"); 
		query.append("                           AND B1.SC_NO = NVL(B2.SC_NO, B1.SC_NO)" ).append("\n"); 
		query.append("                           AND B1.RFA_NO = NVL(B2.RFA_NO, B1.RFA_NO)" ).append("\n"); 
		query.append("                           AND B1.SVC_SCP_CD =" ).append("\n"); 
		query.append("                               NVL(B2.SVC_SCP_CD, B1.SVC_SCP_CD)" ).append("\n"); 
		query.append("                           AND B1.POR_CD LIKE B2.POR_CD || '%'" ).append("\n"); 
		query.append("                           AND B1.DEL_CD LIKE B2.DEL_CD || '%') ITM," ).append("\n"); 
		query.append("                       BKG_MDT_ITM_DTL DTL" ).append("\n"); 
		query.append("                 WHERE ITM.MDT_ITM_SEQ = DTL.MDT_ITM_SEQ))" ).append("\n"); 
		query.append(" START WITH RID = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR RID + 1 = RID" ).append("\n"); 

	}
}