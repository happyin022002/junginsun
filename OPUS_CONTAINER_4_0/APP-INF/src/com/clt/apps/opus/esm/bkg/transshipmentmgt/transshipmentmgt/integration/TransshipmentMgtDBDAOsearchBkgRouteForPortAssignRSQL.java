/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TransshipmentMgtDBDAOsearchBkgRouteForPortAssignRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.04
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2016.03.04 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransshipmentMgtDBDAOsearchBkgRouteForPortAssignRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조건에 맞는 Booking을 route 별로 group으로 조회한다.
	  * </pre>
	  */
	public TransshipmentMgtDBDAOsearchBkgRouteForPortAssignRSQL(){
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
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.integration").append("\n"); 
		query.append("FileName : TransshipmentMgtDBDAOsearchBkgRouteForPortAssignRSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("		 por_cd" ).append("\n"); 
		query.append("		, pol_nod_cd pol_cd" ).append("\n"); 
		query.append("        , pod_nod_cd pod_cd" ).append("\n"); 
		query.append("		, del_cd" ).append("\n"); 
		query.append("        , count(1) bkg_count" ).append("\n"); 
		query.append("        , tvvd" ).append("\n"); 
		query.append("        , pre_vvd" ).append("\n"); 
		query.append("        , pre_relay" ).append("\n"); 
		query.append("        , post_vvd" ).append("\n"); 
		query.append("        , post_relay" ).append("\n"); 
		query.append("        , (select VPS_RMK " ).append("\n"); 
		query.append("             from vsk_vsl_port_skd in_vvd" ).append("\n"); 
		query.append("            where in_vvd.vsl_cd     = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("              and in_vvd.skd_voy_no = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("              and in_vvd.skd_dir_cd = substr(@[vvd], 9, 1)" ).append("\n"); 
		query.append("              and in_vvd.vps_port_cd= in_pod --[portCd]" ).append("\n"); 
		query.append("              and rownum = 1) rmk" ).append("\n"); 
		query.append("        , nvl(por_cd,'')||'|'||nvl(pol_nod_cd,'')||'|'||nvl(pod_nod_cd,'')||'|'||nvl(del_cd,'')||'|'||nvl(tvvd,'')" ).append("\n"); 
		query.append("          ||'|'||nvl(pre_vvd,'')||'|'||nvl(pre_relay,'')||'|'||nvl(post_vvd,'')||'|'||nvl(post_relay,'') route_key" ).append("\n"); 
		query.append("  from (select bk.bkg_no" ).append("\n"); 
		query.append("				, bk.por_cd" ).append("\n"); 
		query.append("                , bk.pol_nod_cd" ).append("\n"); 
		query.append("                , bk.pod_nod_cd" ).append("\n"); 
		query.append("				, bk.del_cd" ).append("\n"); 
		query.append("                , tvvd.vsl_cd||tvvd.skd_voy_no||tvvd.skd_dir_cd tvvd" ).append("\n"); 
		query.append("                , (select pre_vvd.vsl_cd||pre_vvd.skd_voy_no||pre_vvd.skd_dir_cd " ).append("\n"); 
		query.append("                     from bkg_vvd pre_vvd" ).append("\n"); 
		query.append("                    where bk.bkg_no   = pre_vvd.bkg_no" ).append("\n"); 
		query.append("                      and 'S'         = pre_vvd.vsl_pre_pst_cd " ).append("\n"); 
		query.append("                      and tvvd.pol_cd = pre_vvd.pod_cd" ).append("\n"); 
		query.append("					  and rownum      = 1) pre_vvd" ).append("\n"); 
		query.append("                , (select pre_vvd.pod_yd_cd" ).append("\n"); 
		query.append("                     from bkg_vvd pre_vvd" ).append("\n"); 
		query.append("                    where bk.bkg_no   = pre_vvd.bkg_no" ).append("\n"); 
		query.append("                      and 'S'         = pre_vvd.vsl_pre_pst_cd" ).append("\n"); 
		query.append("                      and tvvd.pol_cd = pre_vvd.pod_cd" ).append("\n"); 
		query.append("					  and rownum      = 1) pre_relay" ).append("\n"); 
		query.append("                , (select post_vvd.vsl_cd||post_vvd.skd_voy_no||post_vvd.skd_dir_cd " ).append("\n"); 
		query.append("                     from bkg_vvd post_vvd" ).append("\n"); 
		query.append("                    where bk.bkg_no   = post_vvd.bkg_no" ).append("\n"); 
		query.append("                      and 'U'         = post_vvd.vsl_pre_pst_cd" ).append("\n"); 
		query.append("                      and tvvd.pod_cd = post_vvd.pol_cd" ).append("\n"); 
		query.append("					  and rownum      = 1) post_vvd" ).append("\n"); 
		query.append("                , (select post_vvd.pol_yd_cd" ).append("\n"); 
		query.append("                     from bkg_vvd post_vvd" ).append("\n"); 
		query.append("                    where bk.bkg_no   = post_vvd.bkg_no" ).append("\n"); 
		query.append("                      and 'U'         = post_vvd.vsl_pre_pst_cd" ).append("\n"); 
		query.append("                      and tvvd.pod_cd = post_vvd.pol_cd" ).append("\n"); 
		query.append("					  and rownum      = 1) post_relay" ).append("\n"); 
		query.append("		#if (${vvd}!='')" ).append("\n"); 
		query.append("		        ,in_vvd.pod_cd AS in_pod" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("		        ,'' AS in_pod" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("          from bkg_booking bk" ).append("\n"); 
		query.append("                , bkg_vvd tvvd  " ).append("\n"); 
		query.append("		#if (${vvd}!='')" ).append("\n"); 
		query.append("                , bkg_vvd in_vvd  " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("         where bk.bkg_no = tvvd.bkg_no           " ).append("\n"); 
		query.append("           and bk.bkg_sts_cd NOT IN ('X','S')" ).append("\n"); 
		query.append("           and 'T'       = tvvd.vsl_pre_pst_cd" ).append("\n"); 
		query.append("		#if (${vvd}!='')" ).append("\n"); 
		query.append("           and exists (" ).append("\n"); 
		query.append("		       select *" ).append("\n"); 
		query.append("		       from bkg_vvd vvd" ).append("\n"); 
		query.append("			   where bk.bkg_no = vvd.bkg_no" ).append("\n"); 
		query.append("               and vvd.vsl_cd     = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("               and vvd.skd_voy_no = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("               and vvd.skd_dir_cd = substr(@[vvd], 9, 1)" ).append("\n"); 
		query.append("  		       #if(${pol} !='')" ).append("\n"); 
		query.append("			       and vvd.pol_cd = @[pol]" ).append("\n"); 
		query.append("		       #end " ).append("\n"); 
		query.append("  		       #if(${pol_yd_cd} !='')" ).append("\n"); 
		query.append("			       and substr(vvd.pol_yd_cd,6,2) = @[pol_yd_cd]" ).append("\n"); 
		query.append("		       #end " ).append("\n"); 
		query.append("  		       #if(${pod} !='')" ).append("\n"); 
		query.append("			       and vvd.pod_cd = @[pod]" ).append("\n"); 
		query.append("		       #end " ).append("\n"); 
		query.append("  		       #if(${pod_yd_cd} !='')" ).append("\n"); 
		query.append("			       and substr(vvd.pod_yd_cd,6,2) = @[pod_yd_cd]" ).append("\n"); 
		query.append("		       #end " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("           and bk.bkg_no         = in_vvd.bkg_no" ).append("\n"); 
		query.append("           and in_vvd.vsl_cd     = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("           and in_vvd.skd_voy_no = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("           and in_vvd.skd_dir_cd = substr(@[vvd], 9, 1)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${bkg_ofc_cd}!='')" ).append("\n"); 
		query.append("		   and bk.bkg_ofc_cd = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("		#if (${bkgNos} != '')" ).append("\n"); 
		query.append("			AND bk.bkg_no IN (" ).append("\n"); 
		query.append("				#foreach($multiBkgNoVal IN ${bkgNos})        " ).append("\n"); 
		query.append("					#if($velocityCount < $bkgNos.size()) '$multiBkgNoVal', #else '$multiBkgNoVal' #end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        )        " ).append("\n"); 
		query.append("-- where trim(pre_relay||post_relay) is not null" ).append("\n"); 
		query.append("   where 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" group by " ).append("\n"); 
		query.append("	     por_cd" ).append("\n"); 
		query.append("		, pol_nod_cd" ).append("\n"); 
		query.append("        , pod_nod_cd" ).append("\n"); 
		query.append("		, del_cd" ).append("\n"); 
		query.append("        , tvvd" ).append("\n"); 
		query.append("        , pre_vvd" ).append("\n"); 
		query.append("        , pre_relay" ).append("\n"); 
		query.append("        , post_vvd" ).append("\n"); 
		query.append("        , post_relay" ).append("\n"); 
		query.append("        , in_pod" ).append("\n"); 
		query.append("order by pol_cd" ).append("\n"); 
		query.append("		, pol_nod_cd" ).append("\n"); 
		query.append("        , pod_nod_cd" ).append("\n"); 
		query.append("		, del_cd" ).append("\n"); 
		query.append("        , tvvd" ).append("\n"); 
		query.append("        , pre_vvd" ).append("\n"); 
		query.append("        , pre_relay" ).append("\n"); 
		query.append("        , post_vvd" ).append("\n"); 
		query.append("        , post_relay" ).append("\n"); 

	}
}