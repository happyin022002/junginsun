/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchBkgForCargoClosingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.24
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.11.24 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchBkgForCargoClosingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchBkgForCargoClosingRSQL(){
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
		query.append("FileName : GeneralBookingSearchDBDAOsearchBkgForCargoClosingRSQL").append("\n"); 
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
		query.append(", vvd.vsl_Cd||vvd.skd_voy_no||vvd.skd_dir_cd vvd" ).append("\n"); 
		query.append(", bk.pol_cd" ).append("\n"); 
		query.append(", to_char(skd.vps_etb_dt, 'yyyy-mm-dd hh24:mi') etb" ).append("\n"); 
		query.append(", to_char(skd.vps_etd_dt, 'yyyy-mm-dd hh24:mi') etd" ).append("\n"); 
		query.append("from bkg_booking bk" ).append("\n"); 
		query.append(", bkg_vvd vvd" ).append("\n"); 
		query.append(", vsk_vsl_port_skd skd" ).append("\n"); 
		query.append("where bk.bkg_no       = vvd.bkg_no" ).append("\n"); 
		query.append("and bk.pol_cd       = vvd.pol_cd" ).append("\n"); 
		query.append("and vvd.vsl_pre_pst_cd in ('S', 'T')" ).append("\n"); 
		query.append("and vvd.vsl_cd       = skd.vsl_cd(+)" ).append("\n"); 
		query.append("and vvd.skd_voy_no   = skd.skd_voy_no(+)" ).append("\n"); 
		query.append("and vvd.skd_dir_cd   = skd.skd_dir_cd(+)" ).append("\n"); 
		query.append("and vvd.pol_cd       = skd.vps_port_cd(+)" ).append("\n"); 
		query.append("and vvd.POL_CLPT_IND_SEQ = skd.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("and BK.bkg_no = @[bkg_no]" ).append("\n"); 

	}
}