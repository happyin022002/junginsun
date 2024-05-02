/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchBkgDgCgoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.28
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchBkgDgCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgDgCgo
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchBkgDgCgoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration ").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchBkgDgCgoRSQL").append("\n"); 
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
		query.append("SELECT 'Seq : '||DCGO_SEQ||', Un No : '||IMDG_UN_NO||', Class : '||IMDG_CLSS_CD DIFF_RMK" ).append("\n"); 
		query.append(", DCGO_SEQ" ).append("\n"); 
		query.append(", CNTR_NO" ).append("\n"); 
		query.append("FROM BKG_DG_CGO" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}