/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchPartialCntrBkgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.09.09 김병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KimByungKyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchPartialCntrBkgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container별 Booking 정보를 조회한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchPartialCntrBkgInfoRSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOSearchPartialCntrBkgInfoRSQL").append("\n"); 
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
		query.append("select bk.bkg_no" ).append("\n"); 
		query.append(", bk.por_cd" ).append("\n"); 
		query.append(", substr(bk.por_nod_cd, 6, 2) por_nod_cd" ).append("\n"); 
		query.append(", bk.pol_cd" ).append("\n"); 
		query.append(", substr(bk.pol_nod_cd, 6, 2) pol_nod_cd" ).append("\n"); 
		query.append(", '' ob_so" ).append("\n"); 
		query.append(", vvd1.vsl_Cd||vvd1.skd_voy_no||vvd1.skd_dir_cd vvd1" ).append("\n"); 
		query.append(", vvd1.pol_cd                   pol1" ).append("\n"); 
		query.append(", substr(vvd1.pol_yd_cd, 6, 2)  polYd1" ).append("\n"); 
		query.append(", vvd1.pod_cd                   pod1" ).append("\n"); 
		query.append(", substr(vvd1.pod_yd_cd, 6, 2)  podYd1" ).append("\n"); 
		query.append(", vvd2.vsl_Cd||vvd2.skd_voy_no||vvd2.skd_dir_cd vvd2" ).append("\n"); 
		query.append(", vvd2.pol_cd                   pol2" ).append("\n"); 
		query.append(", substr(vvd2.pol_yd_cd, 6, 2)  polYd2" ).append("\n"); 
		query.append(", vvd2.pod_cd                   pod2" ).append("\n"); 
		query.append(", substr(vvd2.pod_yd_cd, 6, 2)  podYd2" ).append("\n"); 
		query.append(", vvd3.vsl_Cd||vvd3.skd_voy_no||vvd3.skd_dir_cd vvd3" ).append("\n"); 
		query.append(", vvd3.pol_cd                   pol3" ).append("\n"); 
		query.append(", substr(vvd3.pol_yd_cd, 6, 2)  polYd3" ).append("\n"); 
		query.append(", vvd3.pod_cd                   pod3" ).append("\n"); 
		query.append(", substr(vvd3.pod_yd_cd, 6, 2)  podYd3" ).append("\n"); 
		query.append(", vvd4.vsl_Cd||vvd4.skd_voy_no||vvd4.skd_dir_cd vvd4" ).append("\n"); 
		query.append(", vvd4.pol_cd                   pol4" ).append("\n"); 
		query.append(", substr(vvd4.pol_yd_cd, 6, 2)  polYd4" ).append("\n"); 
		query.append(", vvd4.pod_cd                   pod4" ).append("\n"); 
		query.append(", substr(vvd4.pod_yd_cd, 6, 2)  podYd4" ).append("\n"); 
		query.append(", bk.pod_cd" ).append("\n"); 
		query.append(", substr(bk.pod_nod_cd, 6, 2) pod_nod_cd" ).append("\n"); 
		query.append(", bk.del_cd" ).append("\n"); 
		query.append(", substr(bk.del_nod_cd, 6, 2) del_nod_cd" ).append("\n"); 
		query.append(", 'N' org" ).append("\n"); 
		query.append(", 'N' dest" ).append("\n"); 
		query.append(", bk.rcv_term_cd" ).append("\n"); 
		query.append(", bk.de_term_cd" ).append("\n"); 
		query.append("from bkg_booking bk" ).append("\n"); 
		query.append(", (select rownum ord, bkg_no, vsl_cd, skd_voy_no, skd_dir_cd, pol_cd, pol_yd_cd, pod_cd, pod_yd_cd" ).append("\n"); 
		query.append("from bkg_vvd where bkg_no = @[bkg_no]) vvd1" ).append("\n"); 
		query.append(", (select rownum ord, bkg_no, vsl_cd, skd_voy_no, skd_dir_cd, pol_cd, pol_yd_cd, pod_cd, pod_yd_cd" ).append("\n"); 
		query.append("from bkg_vvd where bkg_no = @[bkg_no]) vvd2" ).append("\n"); 
		query.append(", (select rownum ord, bkg_no, vsl_cd, skd_voy_no, skd_dir_cd, pol_cd, pol_yd_cd, pod_cd, pod_yd_cd" ).append("\n"); 
		query.append("from bkg_vvd where bkg_no = @[bkg_no]) vvd3" ).append("\n"); 
		query.append(", (select rownum ord, bkg_no, vsl_cd, skd_voy_no, skd_dir_cd, pol_cd, pol_yd_cd, pod_cd, pod_yd_cd" ).append("\n"); 
		query.append("from bkg_vvd where bkg_no = @[bkg_no]) vvd4" ).append("\n"); 
		query.append("where bk.bkg_no        = vvd1.bkg_no" ).append("\n"); 
		query.append("and 1                = vvd1.ord" ).append("\n"); 
		query.append("and bk.bkg_no        = vvd2.bkg_no(+)" ).append("\n"); 
		query.append("and 2                = vvd2.ord(+)" ).append("\n"); 
		query.append("and bk.bkg_no        = vvd3.bkg_no(+)" ).append("\n"); 
		query.append("and 3                = vvd3.ord(+)" ).append("\n"); 
		query.append("and bk.bkg_no        = vvd4.bkg_no(+)" ).append("\n"); 
		query.append("and 4                = vvd4.ord(+)" ).append("\n"); 

	}
}