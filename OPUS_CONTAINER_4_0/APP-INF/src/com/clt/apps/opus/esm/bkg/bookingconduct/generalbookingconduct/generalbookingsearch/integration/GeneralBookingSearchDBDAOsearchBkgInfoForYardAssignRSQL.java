/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchBkgInfoForYardAssignRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.12
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.02.12 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchBkgInfoForYardAssignRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * booking에 대한 booking Qty,P/UpCy,Return CY를 조회
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchBkgInfoForYardAssignRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchBkgInfoForYardAssignRSQL").append("\n"); 
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
		query.append("select bkg_no" ).append("\n"); 
		query.append(", mty_pkup_yd_cd" ).append("\n"); 
		query.append(", full_rtn_yd_cd" ).append("\n"); 
		query.append(", BKG_JOIN_FNC( CURSOR(SELECT CNTR_TPSZ_CD||'-'||ltrim(TO_CHAR(NVL(OP_CNTR_QTY, 0),'990.99'))" ).append("\n"); 
		query.append("FROM BKG_QUANTITY" ).append("\n"); 
		query.append("WHERE BKG_NO = bk.BKG_NO" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD IS NOT NULL)) qty_vol" ).append("\n"); 
		query.append("from bkg_booking bk" ).append("\n"); 
		query.append("where bkg_no =@[bkg_no]" ).append("\n"); 

	}
}