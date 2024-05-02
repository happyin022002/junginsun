/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterHbl2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.11 
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

public class EBookingReceiptDBDAOsearchXterHbl2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterHbl2
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterHbl2RSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterHbl2RSQL").append("\n"); 
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
		query.append("SELECT USA_CSTMS_FILE_NO" ).append("\n"); 
		query.append(", SCAC_CD" ).append("\n"); 
		query.append(", PCK_QTY" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST" ).append("\n"); 
		query.append("WHERE BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("AND NVL(XTER_BL_TP_CD, ' ') = 'H'" ).append("\n"); 
		query.append("AND USA_CSTMS_FILE_NO IS NOT NULL" ).append("\n"); 
		query.append("ORDER BY USA_CSTMS_FILE_NO" ).append("\n"); 

	}
}