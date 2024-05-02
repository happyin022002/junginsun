/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchSamsungEDIByBLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchSamsungEDIByBLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchSamsungEDIByBLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchSamsungEDIByBLRSQL").append("\n"); 
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
		query.append("SELECT TB.BL_SRC_NO,												" ).append("\n"); 
		query.append("(   SELECT CUST_REF_NO_CTNT " ).append("\n"); 
		query.append("  FROM BKG_REFERENCE" ).append("\n"); 
		query.append(" WHERE BKG_NO = TB.BKG_NO" ).append("\n"); 
		query.append("   AND BKG_REF_TP_CD ='ESRF'" ).append("\n"); 
		query.append("   AND ROWNUM = 1 ) SR_INV_NO, " ).append("\n"); 
		query.append("  MAX(TB.CNTR_NO) CNTR_NO,												" ).append("\n"); 
		query.append("  TB.POR_CD,												" ).append("\n"); 
		query.append("  TB.POL_CD,												" ).append("\n"); 
		query.append("  TB.POD_CD,												" ).append("\n"); 
		query.append("  TB.DEL_CD,												" ).append("\n"); 
		query.append("  (												" ).append("\n"); 
		query.append("    SELECT SUM(RAT_AS_QTY)												" ).append("\n"); 
		query.append("    FROM BKG_CHG_RT												" ).append("\n"); 
		query.append("    WHERE BKG_NO = TB.BKG_NO												" ).append("\n"); 
		query.append("      AND CHG_CD ='OFT'												" ).append("\n"); 
		query.append("      AND CURR_CD = 'USD'												" ).append("\n"); 
		query.append("      AND RAT_UT_CD IN ('D2', '20') ) INV_EDI_D2_QTY,												" ).append("\n"); 
		query.append("  (												" ).append("\n"); 
		query.append("    SELECT SUM(RAT_AS_QTY)												" ).append("\n"); 
		query.append("    FROM BKG_CHG_RT												" ).append("\n"); 
		query.append("    WHERE BKG_NO = TB.BKG_NO												" ).append("\n"); 
		query.append("      AND CHG_CD ='OFT'												" ).append("\n"); 
		query.append("      AND CURR_CD = 'USD'												" ).append("\n"); 
		query.append("      AND RAT_UT_CD IN ('D4', '40') ) INV_EDI_D4_QTY,												" ).append("\n"); 
		query.append("  (												" ).append("\n"); 
		query.append("    SELECT SUM(RAT_AS_QTY)												" ).append("\n"); 
		query.append("    FROM BKG_CHG_RT												" ).append("\n"); 
		query.append("    WHERE BKG_NO = TB.BKG_NO												" ).append("\n"); 
		query.append("      AND CHG_CD ='OFT'												" ).append("\n"); 
		query.append("      AND CURR_CD = 'USD'												" ).append("\n"); 
		query.append("      AND RAT_UT_CD = 'D5' ) INV_EDI_D5_QTY,												" ).append("\n"); 
		query.append("  (												" ).append("\n"); 
		query.append("    SELECT SUM(RAT_AS_QTY)												" ).append("\n"); 
		query.append("    FROM BKG_CHG_RT												" ).append("\n"); 
		query.append("    WHERE BKG_NO = TB.BKG_NO												" ).append("\n"); 
		query.append("      AND CHG_CD ='OFT'												" ).append("\n"); 
		query.append("      AND CURR_CD = 'USD'												" ).append("\n"); 
		query.append("      AND RAT_UT_CD IN ('D7', '45') ) INV_EDI_D7_QTY,												" ).append("\n"); 
		query.append("  (												" ).append("\n"); 
		query.append("    SELECT SUM(RAT_AS_QTY)												" ).append("\n"); 
		query.append("    FROM BKG_CHG_RT												" ).append("\n"); 
		query.append("    WHERE BKG_NO = TB.BKG_NO												" ).append("\n"); 
		query.append("      AND CHG_CD ='OFT'												" ).append("\n"); 
		query.append("      AND CURR_CD = 'USD'												" ).append("\n"); 
		query.append("      AND RAT_UT_CD NOT IN ('D2', '20', 'D4', '40', 'D5', 'D7', '45') ) INV_EDI_ETC_QTY,												" ).append("\n"); 
		query.append("  TB.GRS_CNTR_WGT,												" ).append("\n"); 
		query.append("  TB.GRS_CBM_CAPA,												" ).append("\n"); 
		query.append("  SUM(TB.OFT_AMT) OFT_AMT,												" ).append("\n"); 
		query.append("  SUM(TB.CMS_AMT) CMS_AMT,												" ).append("\n"); 
		query.append("  SUM(TB.THC_AMT) THC_AMT,												" ).append("\n"); 
		query.append("  SUM(TB.DHF_AMT) DHF_AMT,												" ).append("\n"); 
		query.append("  SUM(TB.WHF_AMT) WHF_AMT,												" ).append("\n"); 
		query.append("  SUM(TB.OTR_AMT) OTR_AMT,												" ).append("\n"); 
		query.append("  --SUM(TB.CFR_AMT) CFR_AMT, -- 항목에서 삭제												" ).append("\n"); 
		query.append("  --SUM(TB.BAF_AMT) BAF_AMT, -- 항목에서 삭제												" ).append("\n"); 
		query.append("  SUM(TB.SLF_AMT) SLF_AMT,   -- 2011.05.23 추가												" ).append("\n"); 
		query.append("  SUM(TB.OTH_AMT) OTH_AMT												" ).append("\n"); 
		query.append("FROM(												" ).append("\n"); 
		query.append("    SELECT A.BL_SRC_NO,												" ).append("\n"); 
		query.append("      rtrim(XMLAGG(XMLELEMENT(C, CNTR_NO, '|') ORDER BY A.BL_SRC_NO, C.CNTR_NO).EXTRACT( '//text()'), '|') CNTR_NO,												" ).append("\n"); 
		query.append("      A.BKG_NO,												" ).append("\n"); 
		query.append("      A.POR_CD,												" ).append("\n"); 
		query.append("      A.POL_CD,												" ).append("\n"); 
		query.append("      A.POD_CD,												" ).append("\n"); 
		query.append("      A.DEL_CD,												" ).append("\n"); 
		query.append("      ROUND(A.CGO_WGT, 3) GRS_CNTR_WGT,												" ).append("\n"); 
		query.append("      ROUND(A.CGO_MEAS_QTY, 3) GRS_CBM_CAPA,												" ).append("\n"); 
		query.append("      SUM(DECODE(B.CHG_CD, 'OFT', DECODE(B.CURR_CD, 'USD', B.CHG_AMT, 0), 0)) OFT_AMT,												" ).append("\n"); 
		query.append("      SUM(DECODE(B.CHG_CD, 'CMS', DECODE(B.CURR_CD, 'USD', B.CHG_AMT, 0), 0)) CMS_AMT,												" ).append("\n"); 
		query.append("      SUM(DECODE(B.CHG_CD, 'OTH', B.CHG_AMT, 0)) * B.INV_XCH_RT THC_AMT,												" ).append("\n"); 
		query.append("      SUM(DECODE(B.CHG_CD, 'DHF', B.CHG_AMT, 0)) * B.INV_XCH_RT DHF_AMT,												" ).append("\n"); 
		query.append("      SUM(DECODE(B.CHG_CD, 'WHF', B.CHG_AMT, 0)) * B.INV_XCH_RT WHF_AMT,												" ).append("\n"); 
		query.append("      SUM(DECODE(B.CHG_CD, 'O/F', DECODE(B.CURR_CD, 'USD', B.CHG_AMT, 0), 0)) OTR_AMT,												" ).append("\n"); 
		query.append("      --SUM(DECODE(B.CHG_CD, 'CFR', B.CHG_AMT, 0)) * B.INV_XCH_RT CFR_AMT, -- 항목에서 삭제/OTHER에 추가												" ).append("\n"); 
		query.append("      --SUM(DECODE(B.CHG_CD, 'BAF', B.CHG_AMT, 0)) * B.INV_XCH_RT BAF_AMT, -- 항목에서 삭제/OTHER에 추가												" ).append("\n"); 
		query.append("      SUM(DECODE(B.CHG_CD, 'SLF', DECODE(B.CURR_CD, 'KRW', B.CHG_AMT, 0), 0)) SLF_AMT,     -- 2011.05.23 추가												" ).append("\n"); 
		query.append("      SUM(DECODE(B.CHG_CD, 'OTH', 0, 'DHF', 0, 'WHF', 0, 'OFT', DECODE(B.CURR_CD, 'USD', 0, B.CHG_AMT), 'CMS', DECODE(B.CURR_CD, 'USD', 0, B.CHG_AMT), 'O/F', DECODE(B.CURR_CD, 'USD', 0, B.CHG_AMT), 'SLF', DECODE(B.CURR_CD, 'KRW', 0, B.CHG_AMT, B.CHG_AMT)) * B.INV_XCH_RT) OTH_AMT												" ).append("\n"); 
		query.append("    FROM INV_AR_MN A," ).append("\n"); 
		query.append("      INV_AR_CHG B, BKG_CONTAINER C" ).append("\n"); 
		query.append("    WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("      AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("      AND A.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("      AND A.AR_OFC_CD IN ( SELECT OFC_CD" ).append("\n"); 
		query.append("                             FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                            WHERE AR_HD_QTR_OFC_CD IN ('SHARC','SELIB')" ).append("\n"); 
		query.append("                              AND SUBSTR(LOC_CD, 1, 2) = 'KR'" ).append("\n"); 
		query.append("                              AND DELT_FLG = 'N' )" ).append("\n"); 
		query.append("      AND A.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("      AND A.ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("      AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("      AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("      AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("      AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("      AND A.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("      AND A.INV_TTL_LOCL_AMT > 0" ).append("\n"); 
		query.append("      AND 'X' NOT IN (SELECT INV_DELT_DIV_CD" ).append("\n"); 
		query.append("                        FROM INV_AR_MN" ).append("\n"); 
		query.append("                       WHERE AR_IF_NO = (SELECT MAX(AR_IF_NO)" ).append("\n"); 
		query.append("                                           FROM INV_AR_MN" ).append("\n"); 
		query.append("                                          WHERE AR_OFC_CD IN ( SELECT OFC_CD" ).append("\n"); 
		query.append("                                                                 FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                                WHERE AR_HD_QTR_OFC_CD IN ('SHARC','SELIB')" ).append("\n"); 
		query.append("                                                                  AND SUBSTR(LOC_CD, 1, 2) = 'KR'" ).append("\n"); 
		query.append("                                                                  AND DELT_FLG = 'N' )" ).append("\n"); 
		query.append("                                            AND ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("                                            AND ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("                                            AND BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("                                            AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                                            AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                                            AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                            AND NVL(INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("                                            AND REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                                          --AND INV_TTL_LOCL_AMT > 0" ).append("\n"); 
		query.append("                                          GROUP BY BL_SRC_NO )" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("    GROUP BY A.BL_SRC_NO, A.BKG_NO, A.POR_CD, A.POL_CD, A.POD_CD, A.DEL_CD, A.BKG_NO, A.CGO_WGT, A.CGO_MEAS_QTY, B.INV_XCH_RT) TB" ).append("\n"); 
		query.append("GROUP BY TB.BL_SRC_NO, TB.BKG_NO, TB.POR_CD, TB.POL_CD, TB.POD_CD, TB.DEL_CD, TB.GRS_CNTR_WGT, TB.GRS_CBM_CAPA" ).append("\n"); 

	}
}