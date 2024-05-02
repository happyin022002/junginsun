/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchXterTroForAckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.26
*@LastModifier : 
*@LastVersion : 1.0
* 2011.12.26 
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

public class EBookingReceiptDBDAOSearchXterTroForAckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * auto confirm edi 중 tro 정보를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchXterTroForAckRSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchXterTroForAckRSQL").append("\n"); 
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
		query.append("SELECT  '{I_BKG_TRO'                                ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_TRO_SEQ:'       || DECODE(H.ATTR_CTNT1,NULL,X.TRO_SEQ,NVL(T.TRO_SEQ,X.TRO_SEQ))     ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_TRO_ACUST_NM:'  || DECODE(H.ATTR_CTNT1,NULL,X.ACT_SHPR_NM,NVL(T.ACT_SHPR_NM,X.ACT_SHPR_NM))||CHR(10)||" ).append("\n"); 
		query.append("        'IB_TRO_PERSON:'    || DECODE(H.ATTR_CTNT1,NULL,X.CNTC_PSON_NM,NVL(T.CNTC_PSON_NM,X.CNTC_PSON_NM))         ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_TRO_TEL:'       || DECODE(H.ATTR_CTNT1,NULL,X.CNTC_PHN_NO_CTNT,NVL(T.ACT_SHPR_PHN_NO,X.CNTC_PHN_NO_CTNT))     ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_TRO_DOOR_LOC:'  || DECODE(H.ATTR_CTNT1,NULL,X.DOR_LOC_CD,NVL(T.DOR_PST_NO,X.DOR_LOC_CD))           ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_TRO_REMARK:'    || DECODE(H.ATTR_CTNT1,NULL,X.TRO_RMK,NVL(T.DIFF_RMK,X.TRO_RMK))              ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_TRO_POL_YD_LOC:'|| DECODE(H.ATTR_CTNT1,NULL,X.FULL_RTN_YD_LOC_CD,NVL(T.RTN_LOC_CD,X.FULL_RTN_YD_LOC_CD))   ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_TRO_POL_YD_NM:' || DECODE(H.ATTR_CTNT1,NULL,X.FULL_RTN_YD_NM,NVL(T.RTN_YD_NM,X.FULL_RTN_YD_NM))       ||CHR(10)||" ).append("\n"); 
		query.append("        '}I_BKG_TRO'                                ||CHR(10) FLAT_FILE" ).append("\n"); 
		query.append("  FROM BKG_XTER_TRO X, BKG_HRD_CDG_CTNT H," ).append("\n"); 
		query.append("      (SELECT T.TRO_SEQ, " ).append("\n"); 
		query.append("              ACT_SHPR_NM," ).append("\n"); 
		query.append("              CNTC_PSON_NM," ).append("\n"); 
		query.append("              ACT_SHPR_PHN_NO," ).append("\n"); 
		query.append("              DOR_PST_NO," ).append("\n"); 
		query.append("              DIFF_RMK," ).append("\n"); 
		query.append("              MAX(D.RTN_LOC_CD) RTN_LOC_CD," ).append("\n"); 
		query.append("              MAX((SELECT YD_NM FROM MDM_YARD WHERE YD_CD = D.RTN_YD_CD)) RTN_YD_NM" ).append("\n"); 
		query.append("       FROM BKG_TRO T, BKG_TRO_DTL D" ).append("\n"); 
		query.append("       WHERE T.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("       AND T.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("       AND T.RTN_TRO_FLG = 'N'" ).append("\n"); 
		query.append("       AND T.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("       AND T.IO_BND_CD = D.IO_BND_CD" ).append("\n"); 
		query.append("       AND T.RTN_TRO_FLG = D.RTN_TRO_FLG" ).append("\n"); 
		query.append("       AND T.TRO_SEQ = D.TRO_SEQ" ).append("\n"); 
		query.append("       GROUP BY T.TRO_SEQ, ACT_SHPR_NM, CNTC_PSON_NM, ACT_SHPR_PHN_NO, DOR_PST_NO, DIFF_RMK" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("       SELECT T.TRO_SEQ, " ).append("\n"); 
		query.append("              '' ACT_SHPR_NM," ).append("\n"); 
		query.append("              CNTC_PSON_NM," ).append("\n"); 
		query.append("              CNTC_PHN_NO ACT_SHPR_PHN_NO," ).append("\n"); 
		query.append("              D.DOR_ZIP_ID DOR_PST_NO," ).append("\n"); 
		query.append("              T.SPCL_INSTR_RMK DIFF_RMK," ).append("\n"); 
		query.append("              SUBSTR(T.CNTR_RTN_YD_CD,1,5) RTN_LOC_CD," ).append("\n"); 
		query.append("              (SELECT YD_NM FROM MDM_YARD WHERE YD_CD = T.CNTR_RTN_YD_CD) RTN_YD_NM" ).append("\n"); 
		query.append("       FROM BKG_EUR_TRO T, BKG_EUR_TRO_DTL D" ).append("\n"); 
		query.append("       WHERE T.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("       AND T.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("       AND T.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("       AND T.IO_BND_CD = D.IO_BND_CD" ).append("\n"); 
		query.append("       AND T.TRO_SEQ = D.TRO_SEQ" ).append("\n"); 
		query.append("       AND D.TRO_SUB_SEQ = 1) T" ).append("\n"); 
		query.append(" WHERE XTER_SNDR_ID  = @[sender_id]" ).append("\n"); 
		query.append("   AND XTER_RQST_NO  = @[rqst_no]" ).append("\n"); 
		query.append("   AND XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("   AND XTER_SNDR_ID = H.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("   AND H.HRD_CDG_ID(+) = 'XTER_AUTO_BOKCON'" ).append("\n"); 
		query.append("   AND X.TRO_SEQ = T.TRO_SEQ(+)" ).append("\n"); 

	}
}