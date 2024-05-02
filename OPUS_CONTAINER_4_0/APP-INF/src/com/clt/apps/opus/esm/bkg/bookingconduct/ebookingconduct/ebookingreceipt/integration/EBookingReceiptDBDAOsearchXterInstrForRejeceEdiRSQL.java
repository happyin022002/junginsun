/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterInstrForRejeceEdiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchXterInstrForRejeceEdiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterInstrForRejeceEdi
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterInstrForRejeceEdiRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterInstrForRejeceEdiRSQL").append("\n"); 
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
		query.append("SELECT MST.XTER_RQST_NO                        XTER_RQST_NO" ).append("\n"); 
		query.append("    , MST.XTER_SNDR_ID                         XTER_SNDR_ID" ).append("\n"); 
		query.append("    , MST.POL_CD                               POL_CD" ).append("\n"); 
		query.append("    , MST.POD_CD                               POD_CD" ).append("\n"); 
		query.append("    , TO_CHAR(MST.RQST_DEP_DT, 'YYYYMMDD')     RQST_DEP_DT" ).append("\n"); 
		query.append("    , TO_CHAR(MST.MTY_PKUP_DT, 'RRRRMMDD')     MTY_PKUP_DT" ).append("\n"); 
		query.append("    , TO_CHAR(MST.RQST_ARR_DT, 'YYYYMMDD')     RQST_ARR_DT" ).append("\n"); 
		query.append("    , NULL                                     CNTRTS_CD" ).append("\n"); 
		query.append("    , INS.POR_CTNT                             POR_CTNT" ).append("\n"); 
		query.append("    , INS.POR_NM                               POR_NM" ).append("\n"); 
		query.append("    , INS.POL_CTNT                             POL_CTNT  " ).append("\n"); 
		query.append("    , INS.POL_NM                               POL_NM" ).append("\n"); 
		query.append("    , INS.POD_CTNT                             POD_CTNT" ).append("\n"); 
		query.append("    , INS.POD_NM                               POD_NM" ).append("\n"); 
		query.append("    , INS.DEL_CTNT                             DEL_CTNT" ).append("\n"); 
		query.append("    , INS.DEL_NM                               DEL_NM" ).append("\n"); 
		query.append("    , INS.TRNS_IND_CTNT                        TRNS_IND_CTNT" ).append("\n"); 
		query.append("    , NULL                                     IB_EDI_ORG_ID" ).append("\n"); 
		query.append("    , NULL                                     IB_EDI_ID" ).append("\n"); 
		query.append("    , NULL                                     IB_POL_CD" ).append("\n"); 
		query.append("    , NULL                                     IB_POD_CD" ).append("\n"); 
		query.append("    , MST.ACT_CUST_REF_NO" ).append("\n"); 
		query.append("    , MST.RCV_TERM_CD" ).append("\n"); 
		query.append("    , MST.DE_TERM_CD" ).append("\n"); 
		query.append("    , QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    , INS.XTER_POR_TP_CD" ).append("\n"); 
		query.append("    , INS.XTER_POL_TP_CD" ).append("\n"); 
		query.append("    , INS.XTER_POD_TP_CD" ).append("\n"); 
		query.append("    , INS.XTER_DEL_TP_CD" ).append("\n"); 
		query.append("    , INS.PRNR_MSG_DT" ).append("\n"); 
		query.append("    , TO_CHAR(INS.PRNR_MSG_DT, 'RRRRMMDD')		PRNR_MSG_DT" ).append("\n"); 
		query.append("    , MST.XTER_BKG_RQST_STS_CD" ).append("\n"); 
		query.append("    , REPLACE(REPLACE(MST.XTER_BKG_RMK1,CHR(10),' '),CHR(13),' ') XTER_BKG_RMK1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_XTER_INSTR INS" ).append("\n"); 
		query.append("     , BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("	 , BKG_XTER_QTY QTY" ).append("\n"); 
		query.append(" WHERE MST.XTER_RQST_NO   = INS.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_SEQ  = INS.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("   AND MST.XTER_SNDR_ID   = INS.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("   AND MST.XTER_SNDR_ID   = QTY.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_NO   = QTY.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_SEQ  = QTY.XTER_RQST_SEQ(+)   " ).append("\n"); 
		query.append("   AND MST.XTER_RQST_NO   = @[rqst_no]" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_SEQ  = @[rqst_seq]" ).append("\n"); 
		query.append("   AND MST.XTER_SNDR_ID   = @[sender_id]" ).append("\n"); 

	}
}