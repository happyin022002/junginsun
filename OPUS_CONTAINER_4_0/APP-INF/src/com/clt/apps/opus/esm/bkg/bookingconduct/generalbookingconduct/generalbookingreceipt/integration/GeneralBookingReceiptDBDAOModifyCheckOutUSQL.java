/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyCheckOutUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOModifyCheckOutUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Check Out
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyCheckOutUSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOModifyCheckOutUSQL").append("\n"); 
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
		query.append("UPDATE MST_CONTAINER MC" ).append("\n"); 
		query.append("   SET LOC_CD       = (SELECT BB.POL_CD FROM BKG_BOOKING BB WHERE BB.BKG_NO =@[bkg_no]) " ).append("\n"); 
		query.append(",  CNMV_STS_CD = 'MT'" ).append("\n"); 
		query.append(",  ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("WHERE CNTR_NO IN" ).append("\n"); 
		query.append("( #foreach($key IN ${cntr_cd})" ).append("\n"); 
		query.append("	 #if($velocityCount < $cntr_cd.size())" ).append("\n"); 
		query.append("	      '$key'," ).append("\n"); 
		query.append("	 #else" ).append("\n"); 
		query.append("	       '$key'" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append(" #end " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}