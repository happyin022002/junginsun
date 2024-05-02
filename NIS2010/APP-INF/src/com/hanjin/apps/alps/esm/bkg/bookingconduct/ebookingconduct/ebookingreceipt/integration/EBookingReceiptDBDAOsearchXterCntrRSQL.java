/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.28
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.28 
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

public class EBookingReceiptDBDAOsearchXterCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterCntr
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterCntrRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterCntrRSQL").append("\n"); 
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
		query.append("SELECT UPPER(CNTR.CNTR_NO) CNTR_NO" ).append("\n"); 
		query.append("        , CNTR.CNTR_NO CNTR_NO_OLD" ).append("\n"); 
		query.append("        , CNTR.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("        , UPPER(SEAL.XTER_CNTR_SEAL_NO) CNTR_SEAL_NO" ).append("\n"); 
		query.append("        , CNTR.CNTR_SEQ" ).append("\n"); 
		query.append("        , CNTR.PCK_QTY" ).append("\n"); 
		query.append("        , CNTR.PCK_TP_CD" ).append("\n"); 
		query.append("        , CNTR.CNTR_WGT" ).append("\n"); 
		query.append("        , CNTR.WGT_UT_CD" ).append("\n"); 
		query.append("        , CNTR.MEAS_QTY" ).append("\n"); 
		query.append("        , CNTR.MEAS_UT_CD" ).append("\n"); 
		query.append("        , CNTR.PO_NO" ).append("\n"); 
		query.append("		, CNTR.PRT_FLG" ).append("\n"); 
		query.append("        , CNTR.VGM_WGT" ).append("\n"); 
		query.append("        , CNTR.VGM_WGT_UT_CD" ).append("\n"); 
		query.append("        ,CNTR.VGM_DTMN_DT" ).append("\n"); 
		query.append("		,CNTR.VGM_MZD_TP_CD" ).append("\n"); 
		query.append("		,CNTR.VGM_VRFY_DT" ).append("\n"); 
		query.append("		,CNTR.VGM_VRFY_SIG_CTNT" ).append("\n"); 
		query.append("  FROM BKG_XTER_CNTR CNTR, BKG_XTER_CNTR_SEAL_NO SEAL" ).append("\n"); 
		query.append(" WHERE CNTR.XTER_SNDR_ID = SEAL.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("   AND CNTR.XTER_RQST_NO = SEAL.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("   AND CNTR.XTER_RQST_SEQ= SEAL.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("   AND CNTR.CNTR_NO      = SEAL.CNTR_NO      (+)" ).append("\n"); 
		query.append("   AND 1                 = SEAL.CNTR_SEAL_SEQ(+)" ).append("\n"); 
		query.append("   AND CNTR.CNTR_SEQ     = SEAL.CNTR_SEQ(+)" ).append("\n"); 
		query.append("   AND CNTR.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("   AND CNTR.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("   AND CNTR.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("ORDER BY CNTR.CNTR_SEQ" ).append("\n"); 

	}
}