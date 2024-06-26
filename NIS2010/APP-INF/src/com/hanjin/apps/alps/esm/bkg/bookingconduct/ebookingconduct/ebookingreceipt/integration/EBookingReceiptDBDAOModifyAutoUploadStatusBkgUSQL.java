/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOModifyAutoUploadStatusBkgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.13 
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

public class EBookingReceiptDBDAOModifyAutoUploadStatusBkgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_BOOKING 의 SYS_UPLD_FLG 를 업데이트 한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOModifyAutoUploadStatusBkgUSQL(){
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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOModifyAutoUploadStatusBkgUSQL").append("\n"); 
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
		query.append("UPDATE BKG_BOOKING" ).append("\n"); 
		query.append("   SET SYS_UPLD_FLG = ( SELECT SYS_UPLD_FLG" ).append("\n"); 
		query.append("                          FROM BKG_XTER_RQST_MST" ).append("\n"); 
		query.append("                         WHERE XTER_SNDR_ID  = @[sender_id]" ).append("\n"); 
		query.append("                           AND XTER_RQST_NO  = @[rqst_no]" ).append("\n"); 
		query.append("                           AND XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("                           AND ROWNUM = 1 )" ).append("\n"); 
		query.append("     , UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" 	 , UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND ( SELECT DOC_TP_CD" ).append("\n"); 
		query.append("                          FROM BKG_XTER_RQST_MST" ).append("\n"); 
		query.append("                         WHERE XTER_SNDR_ID  = @[sender_id]" ).append("\n"); 
		query.append("                           AND XTER_RQST_NO  = @[rqst_no]" ).append("\n"); 
		query.append("                           AND XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("                           AND ROWNUM = 1 ) = 'B'" ).append("\n"); 
		query.append("   AND SYS_UPLD_FLG IS NULL" ).append("\n"); 

	}
}