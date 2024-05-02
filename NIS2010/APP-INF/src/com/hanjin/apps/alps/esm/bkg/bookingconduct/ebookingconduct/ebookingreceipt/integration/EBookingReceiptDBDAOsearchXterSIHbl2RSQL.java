/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterSIHbl2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.20
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.10.20 Do Soon Choi
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

public class EBookingReceiptDBDAOsearchXterSIHbl2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterHbl2
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterSIHbl2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("xter_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterSIHbl2RSQL").append("\n"); 
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
		query.append("SELECT X.USA_CSTMS_FILE_NO" ).append("\n"); 
		query.append(", X.SCAC_CD" ).append("\n"); 
		query.append(", X.PCK_QTY" ).append("\n"); 
		query.append(", DECODE( B.USA_CSTMS_FILE_NO,null,'I','U') IBFLAG" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST X" ).append("\n"); 
		query.append("     ,BKG_USA_CSTMS_FILE_NO B" ).append("\n"); 
		query.append(" WHERE  X.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("   AND  X.XTER_RQST_SEQ= @[xter_rqst_seq]" ).append("\n"); 
		query.append("   AND NVL( X.XTER_BL_TP_CD, ' ') = 'H'" ).append("\n"); 
		query.append("AND X.USA_CSTMS_FILE_NO IS NOT NULL" ).append("\n"); 
		query.append("AND X.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("AND X.USA_CSTMS_FILE_NO = B.USA_CSTMS_FILE_NO(+)" ).append("\n"); 
		query.append("ORDER BY X.USA_CSTMS_FILE_NO" ).append("\n"); 

	}
}