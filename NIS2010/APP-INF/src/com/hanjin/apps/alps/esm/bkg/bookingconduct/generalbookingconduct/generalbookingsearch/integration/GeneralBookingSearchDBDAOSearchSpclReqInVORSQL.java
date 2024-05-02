/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchSpclReqInVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.27
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.05.27 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Daeyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchSpclReqInVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * spcl cgo 재 req를 위한 seq를 조회한다.
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchSpclReqInVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchSpclReqInVORSQL").append("\n"); 
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
		query.append("select 'R' apro_cd, nvl(dcgo_seq, 0) dcgo_seq, 0 rc_seq, 0 awk_cgo_seq, 0 bb_cgo_seq" ).append("\n"); 
		query.append("from bkg_dg_cgo" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and SPCL_CGO_APRO_CD in ('R', 'Y', 'P')" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("select 'R' apro_cd, 0 dcgo_seq, nvl(rc_seq, 0) rc_seq, 0 awk_cgo_seq, 0 bb_cgo_seq" ).append("\n"); 
		query.append("from bkg_rf_cgo" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and SPCL_CGO_APRO_CD in ('R', 'Y', 'P')" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("select 'R' apro_cd, 0  dcgo_seq, 0 rc_seq, nvl(awk_cgo_seq, 0) awk_cgo_seq, 0 bb_cgo_seq" ).append("\n"); 
		query.append("from bkg_awk_cgo" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and SPCL_CGO_APRO_CD in ('R', 'Y', 'P')" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("select 'R' apro_cd, 0 dcgo_seq, 0 rc_seq, 0 awk_cgo_seq, nvl(bb_cgo_seq, 0) bb_cgo_seq" ).append("\n"); 
		query.append("from bkg_bb_cgo" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and SPCL_CGO_APRO_CD in ('R', 'Y', 'P')" ).append("\n"); 

	}
}