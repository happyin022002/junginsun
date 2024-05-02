/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterBkgAckReceiverRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.31
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2012.10.31 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchXterBkgAckReceiverRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterBkgAckReceiver
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterBkgAckReceiverRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOsearchXterBkgAckReceiverRSQL").append("\n"); 
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
		query.append("select 'Y' ACK_RECEIVER" ).append("\n"); 
		query.append("  from bkg_hrd_cdg_ctnt" ).append("\n"); 
		query.append(" where HRD_CDG_ID = 'XTER_ACK_RECEIVER'" ).append("\n"); 
		query.append("   and ATTR_CTNT1 = @[sender_id]" ).append("\n"); 
		query.append("  and exists (select 'x'" ).append("\n"); 
		query.append("                 from bkg_xter_rqst_mst" ).append("\n"); 
		query.append("                where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("                  and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("                  and xter_rqst_seq = @[rqst_seq] " ).append("\n"); 
		query.append("                  and xter_rqst_via_cd = 'EDI' )" ).append("\n"); 

	}
}