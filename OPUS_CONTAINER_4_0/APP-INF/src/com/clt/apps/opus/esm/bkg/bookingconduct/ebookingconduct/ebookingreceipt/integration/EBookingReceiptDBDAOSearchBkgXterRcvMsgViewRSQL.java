/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchBkgXterRcvMsgViewRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.17
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2015.06.17 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE, do hyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchBkgXterRcvMsgViewRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EBookingReceiptDBDAOSearchBkgXterRcvMsgViewRSQL
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchBkgXterRcvMsgViewRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_from_dt",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upld_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchBkgXterRcvMsgViewRSQL").append("\n"); 
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
		query.append("SELECT BKG_XTER_RCV_MSG_SEQ" ).append("\n"); 
		query.append("     , UPLD_FLG" ).append("\n"); 
		query.append("     , XTER_SNDR_ID" ).append("\n"); 
		query.append("     , XTER_RQST_NO" ).append("\n"); 
		query.append("     , XTER_RQST_SEQ" ).append("\n"); 
		query.append("     , REPLACE(XML_AND_EDI_MSG_DESC, '?', '※') AS XML_AND_EDI_MSG_DESC" ).append("\n"); 
		query.append("     , TO_CHAR(CRE_DT, 'YYYY-MM-DD HH24:MI') AS CRE_DT" ).append("\n"); 
		query.append("     , UPD_DT " ).append("\n"); 
		query.append("  FROM BKG_XTER_RCV_MSG " ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${rcv_from_dt} != '' && ${rcv_to_dt} != '')" ).append("\n"); 
		query.append("  AND CRE_DT BETWEEN TO_DATE(@[rcv_from_dt],'YYYY-MM-DD') AND TO_DATE(@[rcv_to_dt],'YYYY-MM-DD')+0.99999 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${upld_flg} != '')" ).append("\n"); 
		query.append("  AND UPLD_FLG = @[upld_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${xter_sndr_id} != '')" ).append("\n"); 
		query.append("  AND XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${xter_rqst_no} != '')" ).append("\n"); 
		query.append("  AND XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${xter_rqst_seq} != '')" ).append("\n"); 
		query.append("  AND XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_xter_rcv_msg_seq} != '')" ).append("\n"); 
		query.append("  AND BKG_XTER_RCV_MSG_SEQ = @[bkg_xter_rcv_msg_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY BKG_XTER_RCV_MSG_SEQ DESC" ).append("\n"); 

	}
}