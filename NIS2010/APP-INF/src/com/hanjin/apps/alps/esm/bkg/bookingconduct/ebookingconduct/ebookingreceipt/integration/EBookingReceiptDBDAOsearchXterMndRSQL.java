/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterMndRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.12.11
*@LastModifier : 
*@LastVersion : 1.0
* 2017.12.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchXterMndRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterMnd
	  * 
	  * [CHM-201113675] 2011.10.04 정선용 SEA-NACCS 조회조건 변경
	  * (Key Value = Request No + Split No)
	  * 2011.10.18  정선용  [ CHM-201114011]            BKG No + Sea NACCS Split 을 Key 로 Mark 정보 조회하도록 수정
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterMndRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterMndRSQL").append("\n"); 
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
		query.append("SELECT NVL(( SELECT substr(MK_DESC,1,BKG_GET_ENTER_FNC(MK_DESC)) " ).append("\n"); 
		query.append("                  FROM BKG_XTER_RQST_MST " ).append("\n"); 
		query.append("                 WHERE XTER_SNDR_ID = MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("                   AND BKG_NO = MST.BKG_NO" ).append("\n"); 
		query.append("                   AND NVL(SNACCS_SPLIT_NO,'0') = NVL(MST.SNACCS_SPLIT_NO,'0')" ).append("\n"); 
		query.append("                   AND SNACCS_MSG_TP_CD IN ( 'SAT050', 'SAT054', 'SAT141', 'SAT146' )" ).append("\n"); 
		query.append("                   AND XTER_SNDR_ID = 'SEANACCS' " ).append("\n"); 
		query.append("                   AND XTER_RQST_SEQ BETWEEN MST.XTER_RQST_SEQ AND MST.XTER_RQST_SEQ +2" ).append("\n"); 
		query.append("				   AND ROWNUM = 1  ), " ).append("\n"); 
		query.append("         substr(MST.MK_DESC,1,BKG_GET_ENTER_FNC(MST.MK_DESC)) ) AS MK_DESC" ).append("\n"); 
		query.append("        , PCK_QTY" ).append("\n"); 
		query.append("        , PCK_TP_CD" ).append("\n"); 
		query.append("        , ESTM_WGT ACT_WGT" ).append("\n"); 
		query.append("        , ESTM_WGT_UT_CD WGT_UT_CD" ).append("\n"); 
		query.append("        , MEAS_QTY" ).append("\n"); 
		query.append("        , MEAS_UT_CD " ).append("\n"); 
		query.append("        , REPLACE(REPLACE(REPLACE(" ).append("\n"); 
		query.append("            NVL((SELECT substr(GDS_DESC,1,BKG_GET_ENTER_FNC(GDS_DESC)) " ).append("\n"); 
		query.append("                  FROM BKG_XTER_RQST_MST " ).append("\n"); 
		query.append("                 WHERE XTER_SNDR_ID = MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("                   AND BKG_NO = MST.BKG_NO" ).append("\n"); 
		query.append("                   AND NVL(SNACCS_SPLIT_NO,'0') = NVL(MST.SNACCS_SPLIT_NO,'0')" ).append("\n"); 
		query.append("                   AND SNACCS_MSG_TP_CD IN ( 'SAT142', 'SAT147' )" ).append("\n"); 
		query.append("                   AND XTER_SNDR_ID = 'SEANACCS' " ).append("\n"); 
		query.append("                   AND XTER_RQST_SEQ BETWEEN MST.XTER_RQST_SEQ AND MST.XTER_RQST_SEQ +2" ).append("\n"); 
		query.append("				   AND ROWNUM = 1  )," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            substr(GDS_DESC,1,BKG_GET_ENTER_FNC(GDS_DESC)) )" ).append("\n"); 
		query.append("            , CHR(13)||CHR(10), CHR(13)), CHR(10), CHR(13)), CHR(13), CHR(13)||CHR(10)) CMDT_DESC" ).append("\n"); 
		query.append("        , MISC_DESC" ).append("\n"); 
		query.append("        , DECODE(NVL(MISC_DESC, 'N'), 'N', 'N', 'Y') MISC--MISC.INFORMATION FLAG활성화 FLAG" ).append("\n"); 
		query.append("        , DECODE((SELECT 'Y'" ).append("\n"); 
		query.append("                   FROM BKG_XTER_AES" ).append("\n"); 
		query.append("                   WHERE XTER_SNDR_ID  = MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("                     AND XTER_RQST_NO  = MST.XTER_RQST_NO" ).append("\n"); 
		query.append("                     AND XTER_RQST_SEQ = MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                     AND ROWNUM = 1" ).append("\n"); 
		query.append("                  UNION" ).append("\n"); 
		query.append("                  SELECT 'Y'" ).append("\n"); 
		query.append("                    FROM BKG_XTER_CAED" ).append("\n"); 
		query.append("                   WHERE XTER_SNDR_ID  = MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("                     AND XTER_RQST_NO  = MST.XTER_RQST_NO" ).append("\n"); 
		query.append("                     AND XTER_RQST_SEQ = MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                     AND ROWNUM = 1" ).append("\n"); 
		query.append("                  UNION" ).append("\n"); 
		query.append("                  SELECT 'Y'" ).append("\n"); 
		query.append("                    FROM BKG_XTER_XPT_LIC_NO" ).append("\n"); 
		query.append("                   WHERE XTER_SNDR_ID  = MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("                     AND XTER_RQST_NO  = MST.XTER_RQST_NO" ).append("\n"); 
		query.append("                     AND XTER_RQST_SEQ = MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                     AND ROWNUM = 1" ).append("\n"); 
		query.append("                  UNION" ).append("\n"); 
		query.append("                  SELECT 'Y'" ).append("\n"); 
		query.append("                    FROM BKG_XTER_CUST" ).append("\n"); 
		query.append("                    WHERE XTER_SNDR_ID  = MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("                     AND XTER_RQST_NO  = MST.XTER_RQST_NO" ).append("\n"); 
		query.append("                     AND XTER_RQST_SEQ = MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                     AND MX_TAX_ID IS NOT NULL" ).append("\n"); 
		query.append("                     AND ROWNUM =1" ).append("\n"); 
		query.append("                  UNION" ).append("\n"); 
		query.append("                  SELECT 'Y'" ).append("\n"); 
		query.append("                    FROM BKG_XTER_CUST" ).append("\n"); 
		query.append("                    WHERE XTER_SNDR_ID  = MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("                     AND XTER_RQST_NO  = MST.XTER_RQST_NO" ).append("\n"); 
		query.append("                     AND XTER_RQST_SEQ = MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                     AND TR_TAX_ID IS NOT NULL" ).append("\n"); 
		query.append("                     AND ROWNUM =1" ).append("\n"); 
		query.append("                  UNION" ).append("\n"); 
		query.append("                  SELECT 'Y'" ).append("\n"); 
		query.append("                    FROM BKG_XTER_CUST" ).append("\n"); 
		query.append("                    WHERE XTER_SNDR_ID  = MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("                     AND XTER_RQST_NO  = MST.XTER_RQST_NO" ).append("\n"); 
		query.append("                     AND XTER_RQST_SEQ = MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                     AND IL_TAX_ID IS NOT NULL" ).append("\n"); 
		query.append("                     AND ROWNUM =1" ).append("\n"); 
		query.append("                  UNION" ).append("\n"); 
		query.append("                  SELECT 'Y'" ).append("\n"); 
		query.append("                    FROM BKG_XTER_CUST" ).append("\n"); 
		query.append("                    WHERE XTER_SNDR_ID  = MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("                     AND XTER_RQST_NO  = MST.XTER_RQST_NO" ).append("\n"); 
		query.append("                     AND XTER_RQST_SEQ = MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                     AND LB_TAX_ID IS NOT NULL" ).append("\n"); 
		query.append("                     AND ROWNUM =1" ).append("\n"); 
		query.append("                  UNION" ).append("\n"); 
		query.append("                  SELECT 'Y'" ).append("\n"); 
		query.append("                    FROM BKG_XTER_CUST" ).append("\n"); 
		query.append("                    WHERE XTER_SNDR_ID  = MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("                     AND XTER_RQST_NO  = MST.XTER_RQST_NO" ).append("\n"); 
		query.append("                     AND XTER_RQST_SEQ = MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                     AND BRZ_TAX_ID IS NOT NULL" ).append("\n"); 
		query.append("                     AND ROWNUM =1  ), 'Y', 'Y', 'N') XPT_IMP --EXPORT IMPORT INFORMATION 활성화 FLAG" ).append("\n"); 
		query.append("		, PO_NO BKPO2" ).append("\n"); 
		query.append("		, LC_NO LCNO2" ).append("\n"); 
		query.append("		, INV_NO_CTNT HINV2" ).append("\n"); 
		query.append("		, TO_CHAR(LC_EXP_DT, 'YYYY-MM-DD') LCDT2" ).append("\n"); 
		query.append("        , DECODE(NVL(PO_NO||LC_NO||INV_NO_CTNT||TO_CHAR(LC_EXP_DT), 'N'), 'N', 'N', 'Y') PO_NO --P/O OTHER NO 활성화 FLAG" ).append("\n"); 
		query.append("        , 'N' RIDER --B/L RIDER 활성화 FLAG" ).append("\n"); 
		query.append("		, NVL(NVL(POR_CD, POL_CD), (SELECT LOC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[usr_ofc])) POL_CD" ).append("\n"); 
		query.append("		, MST.CSTMS_DESC" ).append("\n"); 
		query.append("		, (SELECT COUNT(1)" ).append("\n"); 
		query.append("			 FROM BKG_XPT_IMP_LIC LIC" ).append("\n"); 
		query.append("			WHERE LIC.BKG_NO = MST.BKG_NO" ).append("\n"); 
		query.append("			  AND LIC.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("			  AND LIC.CNT_CD = 'KR')" ).append("\n"); 
		query.append("		+ (SELECT COUNT(1)" ).append("\n"); 
		query.append("			 FROM BKG_XTER_XPT_LIC_NO LIC" ).append("\n"); 
		query.append("			WHERE LIC.XTER_SNDR_ID = MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("			  AND LIC.XTER_RQST_NO = MST.XTER_RQST_NO" ).append("\n"); 
		query.append("		  	  AND LIC.XTER_RQST_SEQ = MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("			  AND (LIC.CNT_CD IS NULL OR LIC.CNT_CD = 'KR')) KR_XPT_LIC_CNT" ).append("\n"); 
		query.append("		, (SELECT COUNT(1)" ).append("\n"); 
		query.append("			 FROM BKG_XPT_IMP_LIC LIC" ).append("\n"); 
		query.append("			WHERE LIC.BKG_NO = MST.BKG_NO" ).append("\n"); 
		query.append("			  AND LIC.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("			  AND LIC.CNT_CD = 'ID')" ).append("\n"); 
		query.append("		+ (SELECT COUNT(1)" ).append("\n"); 
		query.append("			 FROM BKG_XTER_XPT_LIC_NO LIC" ).append("\n"); 
		query.append("			WHERE LIC.XTER_SNDR_ID = MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("			  AND LIC.XTER_RQST_NO = MST.XTER_RQST_NO" ).append("\n"); 
		query.append("		  	  AND LIC.XTER_RQST_SEQ = MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("			  AND LIC.CNT_CD = 'ID') ID_XPT_LIC_CNT" ).append("\n"); 
		query.append("  FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append(" WHERE XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("   AND XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("   AND XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 

	}
}