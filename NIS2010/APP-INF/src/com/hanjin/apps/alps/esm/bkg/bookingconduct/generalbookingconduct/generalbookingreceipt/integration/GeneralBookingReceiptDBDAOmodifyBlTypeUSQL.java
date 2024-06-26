/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOmodifyBlTypeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.31
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2009.12.31 신자영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jin Seo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOmodifyBlTypeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyBlType
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOmodifyBlTypeUSQL(){
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
		params.put("blTpCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOmodifyBlTypeUSQL").append("\n"); 
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
		query.append("UPDATE" ).append("\n"); 
		query.append("BKG_BOOKING" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("BL_TP_CD	= DECODE(@[blTpCd], 'B', '', @[blTpCd])" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("BKG_NO		= @[bkg_no]" ).append("\n"); 

	}
}