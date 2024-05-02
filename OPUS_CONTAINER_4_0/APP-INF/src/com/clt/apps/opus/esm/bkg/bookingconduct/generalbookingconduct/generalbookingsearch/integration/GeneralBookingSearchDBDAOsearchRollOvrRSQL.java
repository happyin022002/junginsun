/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchRollOvrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchRollOvrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 booking의 roll over 정보를 조회
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchRollOvrRSQL(){
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
		query.append("FileName : GeneralBookingSearchDBDAOsearchRollOvrRSQL").append("\n"); 
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
		query.append("select OVR.new_vsl_cd||OVR.new_skd_voy_no||OVR.new_skd_dir_cd||' ('||TO_CHAR(OVR.NEW_ETD_DT, 'yyyy-mm-dd hh24:mi')||')' newDate" ).append("\n"); 
		query.append("        , pre_vsl_cd||pre_skd_voy_no||pre_skd_dir_cd||' ('||to_char(PRE_ETD_DT, 'yyyy-mm-dd hh24:mi')||')' preDate" ).append("\n"); 
		query.append("        , ovr.roll_ovr_rsn_cd" ).append("\n"); 
		query.append("        , ovr.upd_usr_id" ).append("\n"); 
		query.append("        , to_char(evnt_dt, 'yyyy-mm-dd hh24:mi') evnt_dt" ).append("\n"); 
		query.append("        , ovr.diff_rmk" ).append("\n"); 
		query.append("        , (SELECT USR_NM FROM COM_USER WHERE Upper(USR_ID)=upper(ovr.upd_usr_id)) upd_usr_nm" ).append("\n"); 
		query.append("        , ROLL_OVR_SEQ" ).append("\n"); 
		query.append("  from bkg_roll_ovr ovr" ).append("\n"); 
		query.append(" where OVR.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   --AND NEW_VSL_CD IS NOT NULL" ).append("\n"); 
		query.append("   and ROLL_OVR_SEQ < (select max(ROLL_OVR_SEQ) from bkg_roll_ovr max_seq where max_seq.bkg_no = ovr.bkg_no)" ).append("\n"); 
		query.append(" ORDER BY OVR.CRE_DT" ).append("\n"); 

	}
}