/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchMqXlsBkgMappingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.31
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchMqXlsBkgMappingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EBookingReceiptDBDAOsearchMqXlsBkgMappingListRSQL
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchMqXlsBkgMappingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt10",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration ").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchMqXlsBkgMappingListRSQL").append("\n"); 
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
		query.append("SELECT A.ATTR_CTNT1," ).append("\n"); 
		query.append("A.ATTR_CTNT2," ).append("\n"); 
		query.append("A.ATTR_CTNT3," ).append("\n"); 
		query.append("B.ATTR_CTNT4," ).append("\n"); 
		query.append("B.ATTR_CTNT5" ).append("\n"); 
		query.append("FROM BKG_HRD_CDG_CTNT A, BKG_HRD_CDG_CTNT B" ).append("\n"); 
		query.append("WHERE 'XTER_BKG_RCT_XLS_BKG' = A.HRD_CDG_ID" ).append("\n"); 
		query.append("AND 'XTER_BKG_RCT_ORD_BKG' = B.HRD_CDG_ID" ).append("\n"); 
		query.append("AND @[attr_ctnt10] = B.ATTR_CTNT10" ).append("\n"); 
		query.append("AND A.ATTR_CTNT1 = B.ATTR_CTNT1" ).append("\n"); 
		query.append("AND A.ATTR_CTNT10 = B.ATTR_CTNT10" ).append("\n"); 
		query.append("ORDER BY TO_NUMBER (B.ATTR_CTNT2), A.HRD_CDG_ID_SEQ" ).append("\n"); 

	}
}