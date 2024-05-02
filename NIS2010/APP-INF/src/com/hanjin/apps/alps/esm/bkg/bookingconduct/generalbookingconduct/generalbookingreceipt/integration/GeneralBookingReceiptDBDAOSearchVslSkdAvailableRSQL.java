/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchVslSkdAvailableRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.12
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.11.12 류대영
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

public class GeneralBookingReceiptDBDAOSearchVslSkdAvailableRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 유효한 Route인지 여부 확인
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchVslSkdAvailableRSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOSearchVslSkdAvailableRSQL").append("\n"); 
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
		query.append("select 	vvd_count-skd_count CNT" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("(select count(1) vvd_count" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("from bkg_vvd_his" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("from bkg_vvd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("where bkg_no           = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and vsl_cd is not null" ).append("\n"); 
		query.append(") vvd" ).append("\n"); 
		query.append(", (select count(1) skd_count" ).append("\n"); 
		query.append("from vsk_vsl_port_skd pol," ).append("\n"); 
		query.append("vsk_vsl_port_skd pod," ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("bkg_vvd_his vvd" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("bkg_vvd vvd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("where bkg_no           = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("AND   vvd.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and vvd.vsl_cd       = pol.vsl_cd" ).append("\n"); 
		query.append("and vvd.skd_voy_no   = pol.skd_voy_no" ).append("\n"); 
		query.append("and vvd.skd_dir_cd   = pol.skd_dir_cd" ).append("\n"); 
		query.append("and vvd.pol_cd       = pol.vps_port_cd" ).append("\n"); 
		query.append("and NVL(vvd.POl_CLPT_IND_SEQ, 1) = pol.CLPT_IND_SEQ" ).append("\n"); 
		query.append("and NVL(pol.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("and vvd.vsl_cd       = pod.vsl_cd" ).append("\n"); 
		query.append("and vvd.skd_voy_no   = pod.skd_voy_no" ).append("\n"); 
		query.append("and vvd.skd_dir_cd   = pod.skd_dir_cd" ).append("\n"); 
		query.append("and vvd.pod_cd       = pod.vps_port_cd" ).append("\n"); 
		query.append("and NVL(vvd.POd_CLPT_IND_SEQ, 1) = pod.CLPT_IND_SEQ" ).append("\n"); 
		query.append("and NVL(pod.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append(") skd" ).append("\n"); 

	}
}