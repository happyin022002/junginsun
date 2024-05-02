/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchQtyInfoForYardAssignRSQL.java
*@FileTitle : Yard Assign by CNTR
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.10.28 최영희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Yeoung Hee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchQtyInfoForYardAssignRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * edi 전송시 type/size별 yard 구분을 위해 기초 정보를 조회
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchQtyInfoForYardAssignRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration ").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchQtyInfoForYardAssignRSQL").append("\n"); 
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
		query.append("select qty.cntr_tpsz_cd" ).append("\n"); 
		query.append(", qty.op_cntr_qty" ).append("\n"); 
		query.append(", bk.mty_pkup_yd_cd" ).append("\n"); 
		query.append(", bk.full_rtn_yd_cd" ).append("\n"); 
		query.append("from bkg_quantity qty,bkg_booking bk" ).append("\n"); 
		query.append("where bk.bkg_no = qty.bkg_no" ).append("\n"); 
		query.append("and bk.bkg_no = @[bkg_no]" ).append("\n"); 

	}
}