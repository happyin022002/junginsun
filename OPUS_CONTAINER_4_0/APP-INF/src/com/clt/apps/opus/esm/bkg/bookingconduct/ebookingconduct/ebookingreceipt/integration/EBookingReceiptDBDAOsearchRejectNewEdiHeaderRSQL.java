/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchRejectNewEdiHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.05 
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

public class EBookingReceiptDBDAOsearchRejectNewEdiHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EBookingReceiptDBDAOsearchRejectNewEdiHeaderRSQL
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchRejectNewEdiHeaderRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hrd_cdg_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchRejectNewEdiHeaderRSQL").append("\n"); 
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
		query.append("SELECT BHCC.ATTR_CTNT3 AS RCV_ID" ).append("\n"); 
		query.append("     , BHCC.ATTR_CTNT4 AS SNDR_ID" ).append("\n"); 
		query.append("     , 'A' FLAT_FILE_TYPE" ).append("\n"); 
		query.append("FROM BKG_HRD_CDG_CTNT BHCC" ).append("\n"); 
		query.append("WHERE BHCC.HRD_CDG_ID = @[hrd_cdg_id]" ).append("\n"); 
		query.append("AND BHCC.ATTR_CTNT2 = (SELECT CASE WHEN MST.XTER_SNDR_ID = 'PEGASUS' THEN " ).append("\n"); 
		query.append("                                   (SELECT BHCC1.ATTR_CTNT2" ).append("\n"); 
		query.append("                                    FROM BKG_HRD_CDG_CTNT BHCC1" ).append("\n"); 
		query.append("                                    WHERE BHCC1.HRD_CDG_ID = 'CUSTOMER_301_EDI_ID'" ).append("\n"); 
		query.append("                                    AND   BHCC1.ATTR_CTNT1 = MST.PGSS_EDI_ID" ).append("\n"); 
		query.append("                                    AND   ROWNUM = 1)" ).append("\n"); 
		query.append("                              ELSE MST.XTER_SNDR_ID END" ).append("\n"); 
		query.append("                       FROM BKG_XTER_RQST_MST MST " ).append("\n"); 
		query.append("                       WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("                       AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("                       AND MST.XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}