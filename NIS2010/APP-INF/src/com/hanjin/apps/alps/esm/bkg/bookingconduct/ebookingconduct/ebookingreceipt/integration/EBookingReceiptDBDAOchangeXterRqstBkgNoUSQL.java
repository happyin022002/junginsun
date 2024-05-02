/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : EBookingReceiptDBDAOchangeXterRqstBkgNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.31
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.31 
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

public class EBookingReceiptDBDAOchangeXterRqstBkgNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EBookingReceiptDBDAOchangeXterRqstBkgNo
	  * </pre>
	  */
	public EBookingReceiptDBDAOchangeXterRqstBkgNoUSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOchangeXterRqstBkgNoUSQL").append("\n"); 
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
		query.append("UPDATE BKG_XTER_RQST_MST" ).append("\n"); 
		query.append("SET BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("WHERE ( XTER_SNDR_ID, XTER_RQST_NO, NVL(SNACCS_SPLIT_NO, ' '), SNACCS_MSG_TP_CD ) IN (" ).append("\n"); 
		query.append("    SELECT XTER_SNDR_ID, XTER_RQST_NO, NVL(SNACCS_SPLIT_NO, ' '), SNACCS_MSG_TP_CD" ).append("\n"); 
		query.append("    FROM BKG_XTER_RQST_MST" ).append("\n"); 
		query.append("    WHERE XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("    AND	XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("    AND	XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT XTER_SNDR_ID, XTER_RQST_NO, NVL(SNACCS_SPLIT_NO, ' '), DECODE(SNACCS_MSG_TP_CD,'SAT049', 'SAT050', 'SAT053','SAT054','SAT140','SAT141','SAT145','SAT146','')" ).append("\n"); 
		query.append("    FROM BKG_XTER_RQST_MST" ).append("\n"); 
		query.append("    WHERE XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("    AND	XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("    AND	XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT XTER_SNDR_ID, XTER_RQST_NO, NVL(SNACCS_SPLIT_NO, ' '), DECODE(SNACCS_MSG_TP_CD,'SAT140','SAT142','SAT145','SAT147','')" ).append("\n"); 
		query.append("    FROM BKG_XTER_RQST_MST" ).append("\n"); 
		query.append("    WHERE XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("    AND	XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("    AND	XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("     )" ).append("\n"); 

	}
}