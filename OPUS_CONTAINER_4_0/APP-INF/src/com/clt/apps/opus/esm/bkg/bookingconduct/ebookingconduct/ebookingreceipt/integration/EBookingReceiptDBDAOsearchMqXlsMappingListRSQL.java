/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchMqXlsMappingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.30
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.30 
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

public class EBookingReceiptDBDAOsearchMqXlsMappingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchMqXlsMappingList
	  * 2010.12.30 이일민 [CHM-201007165-01] Split 01-Simple EDI 개발 요청
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchMqXlsMappingListRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchMqXlsMappingListRSQL").append("\n"); 
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
		query.append("SELECT a.attr_ctnt1," ).append("\n"); 
		query.append("         a.attr_ctnt2," ).append("\n"); 
		query.append("         a.attr_ctnt3," ).append("\n"); 
		query.append("         b.attr_ctnt4," ).append("\n"); 
		query.append("         b.attr_ctnt5" ).append("\n"); 
		query.append("    FROM bkg_hrd_cdg_ctnt a, bkg_hrd_cdg_ctnt b" ).append("\n"); 
		query.append("   WHERE 'XTER_BKG_RECEIPT_XLS' = a.hrd_cdg_id" ).append("\n"); 
		query.append("     AND 'XTER_BKG_RECEIPT_ORD' = b.hrd_cdg_id" ).append("\n"); 
		query.append("     AND @[attr_ctnt10] = b.attr_ctnt10" ).append("\n"); 
		query.append("     AND a.attr_ctnt1 = b.attr_ctnt1" ).append("\n"); 
		query.append("     AND a.attr_ctnt10 = b.attr_ctnt10" ).append("\n"); 
		query.append("ORDER BY TO_NUMBER (b.attr_ctnt2), a.hrd_cdg_id_seq" ).append("\n"); 

	}
}