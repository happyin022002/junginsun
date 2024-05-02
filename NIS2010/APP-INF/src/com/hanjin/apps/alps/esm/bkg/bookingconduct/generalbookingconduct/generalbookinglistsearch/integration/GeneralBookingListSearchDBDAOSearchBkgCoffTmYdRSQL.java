/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingListSearchDBDAOSearchBkgCoffTmYdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingListSearchDBDAOSearchBkgCoffTmYdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking Close for Bay Plan 의 Yard , Calling seq 를 조회 한다.
	  * </pre>
	  */
	public GeneralBookingListSearchDBDAOSearchBkgCoffTmYdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingListSearchDBDAOSearchBkgCoffTmYdRSQL").append("\n"); 
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
		query.append("SELECT POL_YD_CD," ).append("\n"); 
		query.append("               POL_CLPT_IND_SEQ_LIST," ).append("\n"); 
		query.append("               POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("        select 	substr(pol.yd_cd, 6, 2) pol_yd_cd" ).append("\n"); 
		query.append("                , ' |'||REPLACE(BKG_JOIN_FNC(CURSOR(SELECT clpt_ind_seq" ).append("\n"); 
		query.append("                                FROM vsk_vsl_port_skd pol" ).append("\n"); 
		query.append("                               where pol.vsl_cd       = @[vsl_cd]" ).append("\n"); 
		query.append("                                 and pol.skd_voy_no   = @[skd_voy_no]" ).append("\n"); 
		query.append("                                 and pol.skd_dir_cd   = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                 and pol.vps_port_cd = @[pol_cd]  )),',','|') pol_clpt_ind_seq_list" ).append("\n"); 
		query.append("                , pol.clpt_ind_seq pol_clpt_ind_seq" ).append("\n"); 
		query.append("                , MAX (POL.CLPT_IND_SEQ) OVER() MAX_POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("          from vsk_vsl_port_skd pol" ).append("\n"); 
		query.append("         where pol.vps_port_cd  = @[pol_cd] " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${clpt_ind_seq} != '')" ).append("\n"); 
		query.append("           and pol.clpt_ind_seq = trim(@[clpt_ind_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     --      and pol.yd_cd = :pol_cd ||:pol_yd_cd " ).append("\n"); 
		query.append("           and pol.clpt_ind_seq in (select clpt_ind_seq" ).append("\n"); 
		query.append("				                      from vsk_vsl_port_skd skd" ).append("\n"); 
		query.append("							         where skd.vsl_cd       = @[vsl_cd]" ).append("\n"); 
		query.append("							           and skd.skd_voy_no   = @[skd_voy_no]" ).append("\n"); 
		query.append("							           and skd.skd_dir_cd   = @[skd_dir_cd]" ).append("\n"); 
		query.append("						               and skd.vps_port_cd  = @[pol_cd] " ).append("\n"); 
		query.append("						               and nvl(skd.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("			--				           and skd.yd_cd = :pol_cd ||:pol_yd_cd " ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("              and pol.vsl_cd       = @[vsl_cd]" ).append("\n"); 
		query.append("              and pol.skd_voy_no   = @[skd_voy_no]" ).append("\n"); 
		query.append("              and pol.skd_dir_cd   = @[skd_dir_cd]" ).append("\n"); 
		query.append("              and nvl(pol.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("       WHERE POL_CLPT_IND_SEQ = MAX_POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append(" and 1 = ROWNUM" ).append("\n"); 

	}
}