/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchBlIssRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.11.05 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchBlIssRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * obl이 release 되었는지 조회한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchBlIssRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchBlIssRSQL").append("\n"); 
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
		query.append("select nvl(max(OBL_RLSE_FLG), 'N') OBL_RLSE_FLG" ).append("\n"); 
		query.append("from bkg_bl_iss" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]" ).append("\n"); 

	}
}