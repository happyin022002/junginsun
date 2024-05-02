/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterSIBlRiderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.24
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.08.24 Do Soon Choi
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do Soon Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchXterSIBlRiderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RSQL
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterSIBlRiderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterSIBlRiderRSQL").append("\n"); 
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
		query.append("MST.BKG_NO" ).append("\n"); 
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
		query.append(",MST.XTER_SNDR_ID" ).append("\n"); 
		query.append(",MST.XTER_RQST_NO" ).append("\n"); 
		query.append(",MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append(",'I' IBFLAG" ).append("\n"); 
		query.append("FROM BKG_XTER_IMG_STO IMG, COM_UPLD_FILE UPLD, BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("WHERE MST.XTER_SNDR_ID  = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO  = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("AND MST.XTER_SNDR_ID  = IMG.XTER_SNDR_ID" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO  = IMG.XTER_RQST_NO" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = IMG.XTER_RQST_SEQ " ).append("\n"); 
		query.append("AND IMG.FILE_SAV_ID = UPLD.FILE_SAV_ID" ).append("\n"); 
		query.append("AND IMG.RIDR_TP_CD ='G'" ).append("\n"); 
		query.append("ORDER BY IMG.IMG_SEQ" ).append("\n"); 

	}
}