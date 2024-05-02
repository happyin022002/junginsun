/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchMqXmlMappingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.21
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.06.21 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchMqXmlMappingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchMqXmlMappingList
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchMqXmlMappingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hrd_cdg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchMqXmlMappingListRSQL").append("\n"); 
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
		query.append("SELECT ATTR_CTNT1" ).append("\n"); 
		query.append("     , ATTR_CTNT2" ).append("\n"); 
		query.append("     , ATTR_CTNT3" ).append("\n"); 
		query.append("     , ATTR_CTNT4" ).append("\n"); 
		query.append("     , ATTR_CTNT5" ).append("\n"); 
		query.append("     , ATTR_CTNT6" ).append("\n"); 
		query.append("     , ATTR_CTNT7" ).append("\n"); 
		query.append("     , ATTR_CTNT8" ).append("\n"); 
		query.append("     , ATTR_CTNT9" ).append("\n"); 
		query.append("     , ATTR_CTNT10" ).append("\n"); 
		query.append("FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("WHERE HRD_CDG_ID = @[hrd_cdg_id]" ).append("\n"); 
		query.append("#if (${attr_ctnt3} != '') " ).append("\n"); 
		query.append("AND ATTR_CTNT3 = @[attr_ctnt3]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY TO_NUMBER (ATTR_CTNT1) ASC" ).append("\n"); 

	}
}