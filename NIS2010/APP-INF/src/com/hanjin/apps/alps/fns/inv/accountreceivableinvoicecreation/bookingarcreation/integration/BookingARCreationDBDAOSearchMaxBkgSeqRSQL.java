/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchMaxBkgSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.24
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.06.24 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOSearchMaxBkgSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingARCreationDBDAOSearchMaxBkgSeqRSQL
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchMaxBkgSeqRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchMaxBkgSeqRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(BKG_SEQ)+1,1) MAX_BKG_SEQ" ).append("\n"); 
		query.append("  FROM (SELECT MAX(BKG_SEQ) BKG_SEQ" ).append("\n"); 
		query.append("          FROM INV_BKG_IF_MN " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("         UNION " ).append("\n"); 
		query.append("        SELECT MAX(BKG_SEQ) BKG_SEQ" ).append("\n"); 
		query.append("          FROM INV_BKG_IF_CHG " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("        SELECT MAX(BKG_SEQ) BKG_SEQ" ).append("\n"); 
		query.append("          FROM INV_BKG_IF_CNTR" ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no])" ).append("\n"); 

	}
}