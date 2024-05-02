/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingUtilDBDAOSearchOfcChgProcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.23
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.12.23 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchOfcChgProcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOfcChgProc
	  * 2010.11.22 이일민 [CHM-201005869-01] Collection Office / Code자동 업데이트 관련 수정 요청 (Customer Code 변경 및 B/L Issue 화면 연동)
	  * </pre>
	  */
	public BookingUtilDBDAOSearchOfcChgProcRSQL(){
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
		params.put("nf_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ppd_rcv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_to_ord_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cn_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchOfcChgProcRSQL").append("\n"); 
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
		query.append("SELECT NVL(DECODE(@[type]," ).append("\n"); 
		query.append("           'R'," ).append("\n"); 
		query.append("           (SELECT CASE WHEN 'Y' = @[ca_flg]" ).append("\n"); 
		query.append("                        THEN (SELECT 'N'" ).append("\n"); 
		query.append("                                FROM BKG_RT_HIS" ).append("\n"); 
		query.append("                               WHERE @[bkg_no] = BKG_NO" ).append("\n"); 
		query.append("                                 AND 'TMP0000001' = CORR_NO" ).append("\n"); 
		query.append("                                 AND @[ppd_rcv_ofc_cd] = PPD_RCV_OFC_CD)" ).append("\n"); 
		query.append("                        ELSE (SELECT 'N'" ).append("\n"); 
		query.append("                                FROM BKG_RATE" ).append("\n"); 
		query.append("                               WHERE @[bkg_no] = BKG_NO" ).append("\n"); 
		query.append("                                 AND @[ppd_rcv_ofc_cd] = PPD_RCV_OFC_CD)" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("              FROM DUAL)," ).append("\n"); 
		query.append("           'C'," ).append("\n"); 
		query.append("           (SELECT CASE WHEN 'Y' = @[ca_flg]" ).append("\n"); 
		query.append("                        THEN (SELECT CASE WHEN COUNT(1) =" ).append("\n"); 
		query.append("                                               MAX((SELECT COUNT(1)" ).append("\n"); 
		query.append("                                                      FROM BKG_CUST_HIS" ).append("\n"); 
		query.append("                                                     WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                                       AND CORR_NO = B.CORR_NO" ).append("\n"); 
		query.append("                                                       AND 'S' = BKG_CUST_TP_CD))" ).append("\n"); 
		query.append("                                          THEN 'N' ELSE 'Y' END" ).append("\n"); 
		query.append("                                FROM BKG_BKG_HIS A," ).append("\n"); 
		query.append("                                     BKG_CUST_HIS B" ).append("\n"); 
		query.append("                               WHERE @[bkg_no] = A.BKG_NO" ).append("\n"); 
		query.append("                                 AND 'TMP0000001' = A.CORR_NO" ).append("\n"); 
		query.append("                                 AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                                 AND B.CORR_NO = A.CORR_NO" ).append("\n"); 
		query.append("                                 AND @[cust_to_ord_flg] = A.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("                                 AND 'S'||@[sh_cust_cnt_cd]||@[sh_cust_seq] = B.BKG_CUST_TP_CD||B.CUST_CNT_CD||LPAD(B.CUST_SEQ,6,0))" ).append("\n"); 
		query.append("                        ELSE (SELECT CASE WHEN COUNT(1) =" ).append("\n"); 
		query.append("                                               MAX((SELECT COUNT(1)" ).append("\n"); 
		query.append("                                                      FROM BKG_CUSTOMER" ).append("\n"); 
		query.append("                                                     WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                                       AND 'S' = BKG_CUST_TP_CD))" ).append("\n"); 
		query.append("                                          THEN 'N' ELSE 'Y' END" ).append("\n"); 
		query.append("                                FROM BKG_BOOKING A," ).append("\n"); 
		query.append("                                     BKG_CUSTOMER B" ).append("\n"); 
		query.append("                               WHERE @[bkg_no] = A.BKG_NO" ).append("\n"); 
		query.append("                                 AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                                 AND @[cust_to_ord_flg] = A.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("                                 AND 'S'||@[sh_cust_cnt_cd]||@[sh_cust_seq] = B.BKG_CUST_TP_CD||B.CUST_CNT_CD||LPAD(B.CUST_SEQ,6,0))" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("              FROM DUAL)," ).append("\n"); 
		query.append("           'M'," ).append("\n"); 
		query.append("           (SELECT CASE WHEN 'Y' = @[ca_flg]" ).append("\n"); 
		query.append("                        THEN (SELECT CASE WHEN 1 = COUNT(1) THEN 'N' ELSE 'Y' END" ).append("\n"); 
		query.append("                                FROM BKG_BKG_HIS A," ).append("\n"); 
		query.append("                                     BKG_CUST_HIS B" ).append("\n"); 
		query.append("                               WHERE @[bkg_no] = A.BKG_NO" ).append("\n"); 
		query.append("                                 AND 'TMP0000001' = A.CORR_NO" ).append("\n"); 
		query.append("                                 AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                                 AND B.CORR_NO = A.CORR_NO" ).append("\n"); 
		query.append("                                 AND NVL(@[cust_to_ord_flg],A.CUST_TO_ORD_FLG) = A.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("                                 AND 'S'||@[sh_cust_cnt_cd]||@[sh_cust_seq] = B.BKG_CUST_TP_CD||B.CUST_CNT_CD||LPAD(B.CUST_SEQ,6,0))" ).append("\n"); 
		query.append("                        ELSE (SELECT CASE WHEN 1 = COUNT(1) THEN 'N' ELSE 'Y' END" ).append("\n"); 
		query.append("                                FROM BKG_BOOKING A," ).append("\n"); 
		query.append("                                     BKG_CUSTOMER B" ).append("\n"); 
		query.append("                               WHERE @[bkg_no] = A.BKG_NO" ).append("\n"); 
		query.append("                                 AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                                 AND NVL(@[cust_to_ord_flg],A.CUST_TO_ORD_FLG) = A.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("                                 AND 'S'||@[sh_cust_cnt_cd]||@[sh_cust_seq] = B.BKG_CUST_TP_CD||B.CUST_CNT_CD||LPAD(B.CUST_SEQ,6,0))" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("              FROM DUAL)" ).append("\n"); 
		query.append("       ),'Y') AS OFC_CHG_PPD_PROC," ).append("\n"); 
		query.append("       NVL(DECODE(@[type]," ).append("\n"); 
		query.append("           'R'," ).append("\n"); 
		query.append("           (SELECT CASE WHEN 'Y' = @[ca_flg]" ).append("\n"); 
		query.append("                        THEN (SELECT 'N'" ).append("\n"); 
		query.append("                                FROM BKG_RT_HIS" ).append("\n"); 
		query.append("                               WHERE @[bkg_no] = BKG_NO" ).append("\n"); 
		query.append("                                 AND 'TMP0000001' = CORR_NO" ).append("\n"); 
		query.append("                                 AND @[clt_ofc_cd] = CLT_OFC_CD)" ).append("\n"); 
		query.append("                        ELSE (SELECT 'N'" ).append("\n"); 
		query.append("                                FROM BKG_RATE" ).append("\n"); 
		query.append("                               WHERE @[bkg_no] = BKG_NO" ).append("\n"); 
		query.append("                                 AND @[clt_ofc_cd] = CLT_OFC_CD)" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("              FROM DUAL)," ).append("\n"); 
		query.append("           'C'," ).append("\n"); 
		query.append("           (SELECT CASE WHEN 'Y' = @[ca_flg]" ).append("\n"); 
		query.append("                        THEN (SELECT CASE WHEN COUNT(1) =" ).append("\n"); 
		query.append("                                               MAX((SELECT COUNT(1)" ).append("\n"); 
		query.append("                                                      FROM BKG_CUST_HIS" ).append("\n"); 
		query.append("                                                     WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                                       AND CORR_NO = B.CORR_NO" ).append("\n"); 
		query.append("                                                       AND BKG_CUST_TP_CD IN ('C','N')))" ).append("\n"); 
		query.append("                                          THEN 'N' ELSE 'Y' END" ).append("\n"); 
		query.append("                                FROM BKG_BKG_HIS A," ).append("\n"); 
		query.append("                                     BKG_CUST_HIS B" ).append("\n"); 
		query.append("                               WHERE @[bkg_no] = A.BKG_NO" ).append("\n"); 
		query.append("                                 AND 'TMP0000001' = A.CORR_NO" ).append("\n"); 
		query.append("                                 AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                                 AND B.CORR_NO = A.CORR_NO" ).append("\n"); 
		query.append("                                 AND @[cust_to_ord_flg] = A.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("                                 AND B.BKG_CUST_TP_CD||B.CUST_CNT_CD||LPAD(B.CUST_SEQ,6,0) IN" ).append("\n"); 
		query.append("                                     ('C'||@[cn_cust_cnt_cd]||@[cn_cust_seq]," ).append("\n"); 
		query.append("                                      'N'||@[nf_cust_cnt_cd]||@[nf_cust_seq]))" ).append("\n"); 
		query.append("                        ELSE (SELECT CASE WHEN COUNT(1) =" ).append("\n"); 
		query.append("                                               MAX((SELECT COUNT(1)" ).append("\n"); 
		query.append("                                                      FROM BKG_CUSTOMER" ).append("\n"); 
		query.append("                                                     WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                                       AND BKG_CUST_TP_CD IN ('C','N')))" ).append("\n"); 
		query.append("                                          THEN 'N' ELSE 'Y' END" ).append("\n"); 
		query.append("                                FROM BKG_BOOKING A," ).append("\n"); 
		query.append("                                     BKG_CUSTOMER B" ).append("\n"); 
		query.append("                               WHERE @[bkg_no] = A.BKG_NO" ).append("\n"); 
		query.append("                                 AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                                 AND @[cust_to_ord_flg] = A.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("                                 AND B.BKG_CUST_TP_CD||B.CUST_CNT_CD||LPAD(B.CUST_SEQ,6,0) IN" ).append("\n"); 
		query.append("                                     ('C'||@[cn_cust_cnt_cd]||@[cn_cust_seq]," ).append("\n"); 
		query.append("                                      'N'||@[nf_cust_cnt_cd]||@[nf_cust_seq]))" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("              FROM DUAL)," ).append("\n"); 
		query.append("           'M'," ).append("\n"); 
		query.append("           (SELECT CASE WHEN 'Y' = @[ca_flg]" ).append("\n"); 
		query.append("                        THEN (SELECT CASE WHEN 1 = COUNT(1) THEN 'N' ELSE 'Y' END" ).append("\n"); 
		query.append("                                FROM BKG_BKG_HIS A," ).append("\n"); 
		query.append("                                     BKG_CUST_HIS B" ).append("\n"); 
		query.append("                               WHERE @[bkg_no] = A.BKG_NO" ).append("\n"); 
		query.append("                                 AND 'TMP0000001' = A.CORR_NO" ).append("\n"); 
		query.append("                                 AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                                 AND B.CORR_NO = A.CORR_NO" ).append("\n"); 
		query.append("                                 AND NVL(@[cust_to_ord_flg],A.CUST_TO_ORD_FLG) = A.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("                                 AND 'C'||@[cn_cust_cnt_cd]||@[cn_cust_seq] = B.BKG_CUST_TP_CD||B.CUST_CNT_CD||LPAD(B.CUST_SEQ,6,0))" ).append("\n"); 
		query.append("                        ELSE (SELECT CASE WHEN 1 = COUNT(1) THEN 'N' ELSE 'Y' END" ).append("\n"); 
		query.append("                                FROM BKG_BOOKING A," ).append("\n"); 
		query.append("                                     BKG_CUSTOMER B" ).append("\n"); 
		query.append("                               WHERE @[bkg_no] = A.BKG_NO" ).append("\n"); 
		query.append("                                 AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                                 AND NVL(@[cust_to_ord_flg],A.CUST_TO_ORD_FLG) = A.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("                                 AND 'C'||@[cn_cust_cnt_cd]||@[cn_cust_seq] = B.BKG_CUST_TP_CD||B.CUST_CNT_CD||LPAD(B.CUST_SEQ,6,0))" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("              FROM DUAL)" ).append("\n"); 
		query.append("       ),'Y') AS OFC_CHG_CCT_PROC" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}