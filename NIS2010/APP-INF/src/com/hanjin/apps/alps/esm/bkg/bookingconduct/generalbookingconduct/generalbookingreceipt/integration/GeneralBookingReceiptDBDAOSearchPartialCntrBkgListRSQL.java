/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchPartialCntrBkgListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.17
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.02.17 류대영
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

public class GeneralBookingReceiptDBDAOSearchPartialCntrBkgListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 Booking에 속한 Container가 다른 Booking에 속해잇는지 조회한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchPartialCntrBkgListRSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOSearchPartialCntrBkgListRSQL").append("\n"); 
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
		query.append("select distinct bk2.bkg_no" ).append("\n"); 
		query.append("from bkg_booking bk1, bkg_container cntr1" ).append("\n"); 
		query.append(", bkg_booking bk2, bkg_container cntr2" ).append("\n"); 
		query.append("where bk1.bkg_no = cntr1.bkg_no" ).append("\n"); 
		query.append("and bk2.bkg_no = cntr2.bkg_no" ).append("\n"); 
		query.append("and bk1.bkg_sts_cd    <> 'X'" ).append("\n"); 
		query.append("and bk2.bkg_sts_cd    <> 'X'" ).append("\n"); 
		query.append("and bk1.bkg_cgo_tp_cd = bk2.bkg_cgo_tp_Cd" ).append("\n"); 
		query.append("and bk1.pol_cd        = bk2.pol_cd" ).append("\n"); 
		query.append("and bk1.pod_cd        = bk2.pod_cd" ).append("\n"); 
		query.append("and bk1.vsl_cd        = bk2.vsl_cd" ).append("\n"); 
		query.append("and bk1.skd_voy_no    = bk2.skd_voy_no" ).append("\n"); 
		query.append("and bk1.skd_dir_cd    = bk2.skd_dir_cd" ).append("\n"); 
		query.append("and cntr1.cntr_prt_flg= 'Y'" ).append("\n"); 
		query.append("and cntr2.cntr_prt_flg= 'Y'" ).append("\n"); 
		query.append("and cntr1.cntr_no     = cntr2.cntr_no" ).append("\n"); 
		query.append("and bk1.bkg_no  in (select distinct bk2.bkg_no" ).append("\n"); 
		query.append("from bkg_booking bk1, bkg_container cntr1" ).append("\n"); 
		query.append(", bkg_booking bk2, bkg_container cntr2" ).append("\n"); 
		query.append("where bk1.bkg_no = cntr1.bkg_no" ).append("\n"); 
		query.append("and bk2.bkg_no = cntr2.bkg_no" ).append("\n"); 
		query.append("and bk1.bkg_cgo_tp_cd = bk2.bkg_cgo_tp_Cd" ).append("\n"); 
		query.append("and bk1.pol_cd        = bk2.pol_cd" ).append("\n"); 
		query.append("and bk1.pod_cd        = bk2.pod_cd" ).append("\n"); 
		query.append("and bk1.vsl_cd        = bk2.vsl_cd" ).append("\n"); 
		query.append("and bk1.skd_voy_no    = bk2.skd_voy_no" ).append("\n"); 
		query.append("and bk1.skd_dir_cd    = bk2.skd_dir_cd" ).append("\n"); 
		query.append("and cntr1.cntr_prt_flg= 'Y'" ).append("\n"); 
		query.append("and cntr2.cntr_prt_flg= 'Y'" ).append("\n"); 
		query.append("and cntr1.cntr_no     = cntr2.cntr_no" ).append("\n"); 
		query.append("and bk1.bkg_no        = @[bkg_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}