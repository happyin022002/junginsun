/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchKrXptLicNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.26
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.08.26 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchKrXptLicNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * korea export licens no 조회
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchKrXptLicNoRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchKrXptLicNoRSQL").append("\n"); 
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
		query.append("SELECT XPT_LIC_NO           XPT_LIC_NO2" ).append("\n"); 
		query.append("        , DECODE(CGO_DIVD_FLG, 'Y', DIVD_PCK_QTY, PCK_QTY )      PCK_QTY2" ).append("\n"); 
		query.append("        , DECODE(CGO_DIVD_FLG, 'Y', DIVD_PCK_TP_CD, PCK_TP_CD )  PCK_TP_CD2" ).append("\n"); 
		query.append("        , DECODE(CGO_DIVD_FLG, 'Y', DIVD_WGT, CNTR_WGT )         MF_WGT2" ).append("\n"); 
		query.append("        , DECODE(SUBSTR(DECODE(CGO_DIVD_FLG, 'Y', DIVD_WGT_UT_CD, WGT_UT_CD ),1,1), 'K', 'KGS', DECODE(CGO_DIVD_FLG, 'Y', DIVD_WGT_UT_CD, WGT_UT_CD ) )        WGT_UT_CD2" ).append("\n"); 
		query.append("        , CGO_DIVD_FLG		CGO_DIVD_FLG2" ).append("\n"); 
		query.append("        , DIVD_SEQ          DIVD_SEQ2" ).append("\n"); 
		query.append("        , STY_ID            SAM_PCK_ID2" ).append("\n"); 
		query.append("--        , DIVD_PCK_QTY      SAM_PCK_QTY2" ).append("\n"); 
		query.append("--        , DIVD_PCK_TP_CD    SAM_PCK_TP_CD2" ).append("\n"); 
		query.append("--        , DIVD_WGT			DIVD_WGT2" ).append("\n"); 
		query.append("--        , DIVD_WGT_UT_CD	DIVD_WGT_UT_CD2" ).append("\n"); 
		query.append("        , TO_CHAR(XPT_LIC_NO_FILE_DT, 'yyyy-mm-dd') XPT_LIC_NO_FILE_DT2" ).append("\n"); 
		query.append("        , XTER_TRSP_STS_CD" ).append("\n"); 
		query.append("        , SAM_PCK_QTY SAM_PCK_QTY2" ).append("\n"); 
		query.append("        , SAM_PCK_TP_CD SAM_PCK_TP_CD2" ).append("\n"); 
		query.append("  FROM BKG_XTER_XPT_LIC_NO MST" ).append("\n"); 
		query.append(" WHERE MST.XTER_SNDR_ID  = @[sender_id]" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_NO  = @[rqst_no]" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("   and (MST.CNT_CD is null or MST.CNT_CD = 'KR')" ).append("\n"); 

	}
}