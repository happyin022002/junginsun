/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchRejectEdiHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.08.03 전용진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun Yong Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchRejectEdiHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRejectEdiHeader
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchRejectEdiHeaderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration ").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchRejectEdiHeaderRSQL").append("\n"); 
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
		query.append("select attr_ctnt2 rcv_id, ATTR_CTNT3 sndr_id, ATTR_CTNT4 flat_file_type" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select 1 rnk1, attr_ctnt2, ATTR_CTNT3, ATTR_CTNT4" ).append("\n"); 
		query.append("from bkg_hrd_cdg_ctnt" ).append("\n"); 
		query.append("where HRD_CDG_ID = 'REJECT_HOST_TP_ID'" ).append("\n"); 
		query.append("and ATTR_CTNT2 = @[rcv_id]" ).append("\n"); 
		query.append("union" ).append("\n"); 
		query.append("select 2 rnk1, attr_ctnt2, ATTR_CTNT3, ATTR_CTNT4" ).append("\n"); 
		query.append("from bkg_hrd_cdg_ctnt" ).append("\n"); 
		query.append("where HRD_CDG_ID = 'REJECT_HOST_TP_ID'" ).append("\n"); 
		query.append("and ATTR_CTNT1 like substr(@[rcv_id], 1, 4)||'%'" ).append("\n"); 
		query.append("union" ).append("\n"); 
		query.append("select 3 rnk1, attr_ctnt2, ATTR_CTNT3, ATTR_CTNT4" ).append("\n"); 
		query.append("from bkg_hrd_cdg_ctnt" ).append("\n"); 
		query.append("where HRD_CDG_ID = 'REJECT_HOST_TP_ID'" ).append("\n"); 
		query.append("and ATTR_CTNT1 = 'IKEA.EBCCNS1'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("where rownum = 1" ).append("\n"); 

	}
}