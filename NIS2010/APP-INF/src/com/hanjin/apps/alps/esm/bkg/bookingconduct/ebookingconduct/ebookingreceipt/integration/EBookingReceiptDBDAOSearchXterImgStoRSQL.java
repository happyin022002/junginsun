/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchXterImgStoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.29
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.29 
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

public class EBookingReceiptDBDAOSearchXterImgStoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EBookingReceiptDBDAOSearchXterImgStoRSQL
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchXterImgStoRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOSearchXterImgStoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("IMG.XTER_SNDR_ID" ).append("\n"); 
		query.append(",IMG.XTER_RQST_NO" ).append("\n"); 
		query.append(",IMG.XTER_RQST_SEQ" ).append("\n"); 
		query.append(",IMG.IMG_SEQ" ).append("\n"); 
		query.append(",IMG.RIDR_TP_CD" ).append("\n"); 
		query.append(",IMG.DCGO_SEQ" ).append("\n"); 
		query.append(",IMG.AWK_CGO_SEQ" ).append("\n"); 
		query.append(",IMG.BB_CGO_SEQ" ).append("\n"); 
		query.append(",IMG.FILE_NM" ).append("\n"); 
		query.append(",UPLD.FILE_SZ_CAPA AS FILE_SIZE" ).append("\n"); 
		query.append(",IMG.FILE_PATH_RMK" ).append("\n"); 
		query.append(",IMG.FILE_SAV_ID" ).append("\n"); 
		query.append(",IMG.FILE_DESC" ).append("\n"); 
		query.append("FROM BKG_XTER_IMG_STO IMG, COM_UPLD_FILE UPLD" ).append("\n"); 
		query.append("WHERE IMG.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("AND IMG.FILE_SAV_ID = UPLD.FILE_SAV_ID" ).append("\n"); 
		query.append("AND IMG.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("AND IMG.XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("AND IMG.RIDR_TP_CD ='G'" ).append("\n"); 
		query.append("ORDER BY IMG.IMG_SEQ" ).append("\n"); 

	}
}