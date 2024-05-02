/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOaddBkgXterRcvMsgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.03 
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

public class EBookingReceiptDBDAOaddBkgXterRcvMsgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EBookingReceiptDBDAOaddBkgXterRcvMsgCSQL
	  * </pre>
	  */
	public EBookingReceiptDBDAOaddBkgXterRcvMsgCSQL(){
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
		params.put("upld_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_xter_rcv_msg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flat_file_str",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOaddBkgXterRcvMsgCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_XTER_RCV_MSG (" ).append("\n"); 
		query.append("     BKG_XTER_RCV_MSG_SEQ" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPLD_FLG" ).append("\n"); 
		query.append("	,XML_AND_EDI_MSG_DESC" ).append("\n"); 
		query.append("	,XTER_RQST_NO" ).append("\n"); 
		query.append("	,XTER_SNDR_ID" ).append("\n"); 
		query.append(") VALUES ( " ).append("\n"); 
		query.append("	 @[bkg_xter_rcv_msg_seq]" ).append("\n"); 
		query.append("	,SYSDATE" ).append("\n"); 
		query.append("	,'SYSTEM'" ).append("\n"); 
		query.append("	,SYSDATE" ).append("\n"); 
		query.append("	,'SYSTEM'" ).append("\n"); 
		query.append("    ,@[upld_flg]" ).append("\n"); 
		query.append("    ,@[flat_file_str]" ).append("\n"); 
		query.append("    ,@[rqst_no]" ).append("\n"); 
		query.append("    ,@[sender_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}