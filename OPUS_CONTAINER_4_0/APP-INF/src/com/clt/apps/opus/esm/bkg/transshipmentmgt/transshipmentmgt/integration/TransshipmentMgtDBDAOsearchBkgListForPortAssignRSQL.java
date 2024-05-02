/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TransshipmentMgtDBDAOsearchBkgListForPortAssignRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransshipmentMgtDBDAOsearchBkgListForPortAssignRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * route 별로 group으로 조회한 것을 기준으로 상세 Booking들을 조회한다.
	  * </pre>
	  */
	public TransshipmentMgtDBDAOsearchBkgListForPortAssignRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("post_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tvvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.integration").append("\n"); 
		query.append("FileName : TransshipmentMgtDBDAOsearchBkgListForPortAssignRSQL").append("\n"); 
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
		query.append("        , bl_no" ).append("\n"); 
		query.append("        , pol" ).append("\n"); 
		query.append("        , ts1" ).append("\n"); 
		query.append("        , decode(ts2, pod_cd, '', ts2) ts2" ).append("\n"); 
		query.append("        , decode(ts3, pod_cd, '', ts3) ts3" ).append("\n"); 
		query.append("        , pod_cd" ).append("\n"); 
		query.append("        , result" ).append("\n"); 
		query.append("		, por_cd" ).append("\n"); 
		query.append("		, del_cd" ).append("\n"); 
		query.append("		, substr(por_nod_cd,6,2) as por_nod_cd" ).append("\n"); 
		query.append("		, substr(pol_nod_cd,6,2) as pol_nod_cd" ).append("\n"); 
		query.append("		, substr(pod_nod_cd,6,2) as pod_nod_cd" ).append("\n"); 
		query.append("        , substr(del_nod_cd,6,2) as del_nod_cd" ).append("\n"); 
		query.append("        , ORG_TRNS_MOD_CD" ).append("\n"); 
		query.append("        , DEST_TRNS_MOD_CD" ).append("\n"); 
		query.append("  from (select bk.bkg_no" ).append("\n"); 
		query.append("                , bk.bl_no" ).append("\n"); 
		query.append("                , bk.pol_cd||'/'||(select pol.slan_cd " ).append("\n"); 
		query.append("                                     from bkg_vvd pol " ).append("\n"); 
		query.append("                                    where bk.bkg_no = pol.bkg_no" ).append("\n"); 
		query.append("                                      and bk.pol_cd = pol.pol_cd" ).append("\n"); 
		query.append("                                      and pol.vsl_pre_pst_cd in ('S', 'T')) pol" ).append("\n"); 
		query.append("                , (select max(decode(rownum,1,ts1.pod_cd))" ).append("\n"); 
		query.append("        			from bkg_vvd ts1" ).append("\n"); 
		query.append("        			where bk.bkg_no = ts1.bkg_no) ts1" ).append("\n"); 
		query.append("                , (select max(decode(rownum,2,ts2.pod_cd))" ).append("\n"); 
		query.append("        			from bkg_vvd ts2" ).append("\n"); 
		query.append("        			where bk.bkg_no = ts2.bkg_no) ts2" ).append("\n"); 
		query.append("                , (select max(decode(rownum,3,ts3.pod_cd))" ).append("\n"); 
		query.append("        			from bkg_vvd ts3" ).append("\n"); 
		query.append("        			where bk.bkg_no = ts3.bkg_no) ts3        " ).append("\n"); 
		query.append("                , bk.pod_cd" ).append("\n"); 
		query.append("                , '' result" ).append("\n"); 
		query.append("				, bk.por_cd" ).append("\n"); 
		query.append("				, bk.del_cd" ).append("\n"); 
		query.append("				, bk.por_nod_cd" ).append("\n"); 
		query.append("				, bk.pol_nod_cd" ).append("\n"); 
		query.append("				, bk.pod_nod_cd" ).append("\n"); 
		query.append("                , bk.del_nod_cd" ).append("\n"); 
		query.append("                , bk.ORG_TRNS_MOD_CD" ).append("\n"); 
		query.append("                , bk.DEST_TRNS_MOD_CD	" ).append("\n"); 
		query.append("          from bkg_booking bk" ).append("\n"); 
		query.append("                , bkg_vvd tvvd" ).append("\n"); 
		query.append("                , bkg_vvd in_vvd" ).append("\n"); 
		query.append("         #if (${pre_vvd} !='')" ).append("\n"); 
		query.append("        	, bkg_vvd pre_vvd" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("         #if (${post_vvd} !='')" ).append("\n"); 
		query.append("        	, bkg_vvd post_vvd" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("         where bk.bkg_no = tvvd.bkg_no " ).append("\n"); 
		query.append("           and bk.bkg_sts_cd NOT IN ('X','S')" ).append("\n"); 
		query.append("           and 'T'       = tvvd.vsl_pre_pst_cd" ).append("\n"); 
		query.append("           and bk.pol_cd = @[pol_cd]" ).append("\n"); 
		query.append("           and bk.pod_cd = @[pod_cd]" ).append("\n"); 
		query.append("           and tvvd.vsl_cd     = substr(@[tvvd], 1, 4)" ).append("\n"); 
		query.append("           and tvvd.skd_voy_no = substr(@[tvvd], 5, 4)" ).append("\n"); 
		query.append("           and tvvd.skd_dir_cd = substr(@[tvvd], 9, 1)" ).append("\n"); 
		query.append("           and bk.bkg_no         = in_vvd.bkg_no" ).append("\n"); 
		query.append("           and in_vvd.vsl_cd     = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("           and in_vvd.skd_voy_no = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("           and in_vvd.skd_dir_cd = substr(@[vvd], 9, 1)" ).append("\n"); 
		query.append("           #if (${port}!='')" ).append("\n"); 
		query.append("           and in_vvd.pod_cd     = @[port]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${bkg_ofc_cd}!='')" ).append("\n"); 
		query.append("        	  and bk.bkg_ofc_cd = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("         #if (${pre_vvd} !='')" ).append("\n"); 
		query.append("           and bk.bkg_no = pre_vvd.bkg_no   " ).append("\n"); 
		query.append("           and 'S'       = pre_vvd.vsl_pre_pst_cd" ).append("\n"); 
		query.append("           and pre_vvd.vsl_cd     = substr(@[pre_vvd], 1, 4)" ).append("\n"); 
		query.append("           and pre_vvd.skd_voy_no = substr(@[pre_vvd], 5, 4)" ).append("\n"); 
		query.append("           and pre_vvd.skd_dir_cd = substr(@[pre_vvd], 9, 1)" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("         #if (${post_vvd} !='')" ).append("\n"); 
		query.append("           and bk.bkg_no = post_vvd.bkg_no   " ).append("\n"); 
		query.append("           and 'U'       = post_vvd.vsl_pre_pst_cd" ).append("\n"); 
		query.append("           and post_vvd.vsl_cd     = substr(@[post_vvd], 1, 4)" ).append("\n"); 
		query.append("           and post_vvd.skd_voy_no = substr(@[post_vvd], 5, 4)" ).append("\n"); 
		query.append("           and post_vvd.skd_dir_cd = substr(@[post_vvd], 9, 1)" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         #if (${por_cd}!='')" ).append("\n"); 
		query.append("        	  and bk.por_cd = @[por_cd]" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("         #if (${del_cd}!='')" ).append("\n"); 
		query.append("        	  and bk.del_cd = @[del_cd]" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}