/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TransshipmentMgtDBDAOsearchRlyVslGrpAssignRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.23 
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

public class TransshipmentMgtDBDAOsearchRlyVslGrpAssignRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Relay Vessel Group Assign by Relay Port 화면에서 assing을 위해 list를 조회한다.
	  * </pre>
	  */
	public TransshipmentMgtDBDAOsearchRlyVslGrpAssignRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("relayport_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("relayPort_yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("next_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("next_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etb_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etb_to",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("former_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.integration").append("\n"); 
		query.append("FileName : TransshipmentMgtDBDAOsearchRlyVslGrpAssignRSQL").append("\n"); 
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
		query.append("        , bk.bl_no||bk.bl_tp_cd bl_no" ).append("\n"); 
		query.append("        , nvl(bk.pol_nod_cd, bk.pol_cd) pol_cd" ).append("\n"); 
		query.append("        , nvl(bk.pod_nod_cd, bk.pod_cd) pod_cd" ).append("\n"); 
		query.append("        , former_vvd.vsl_cd||former_vvd.skd_voy_no||former_vvd.skd_dir_cd former_vvd" ).append("\n"); 
		query.append("        , former_vvd.slan_cd former_slan_cd" ).append("\n"); 
		query.append("        , to_char(former_skd.vps_etb_dt, 'yyyymmdd') etb" ).append("\n"); 
		query.append("        , nvl(former_vvd.pod_yd_cd, former_vvd.pod_cd) relay" ).append("\n"); 
		query.append("        , next_vvd.vsl_cd||next_vvd.skd_voy_no||next_vvd.skd_dir_cd next_vvd" ).append("\n"); 
		query.append("        , next_vvd.slan_cd next_slan_cd" ).append("\n"); 
		query.append("        , to_char(next_skd.vps_etd_dt, 'yyyymmdd') etd" ).append("\n"); 
		query.append("        , case when (select 'Y' from BKG_DG_CGO dg where bk.BKG_NO = dg.BKG_NO and rownum = 1 ) = 'Y' then 'DG'" ).append("\n"); 
		query.append("               when (select 'Y' from BKG_RF_CGO dg where bk.BKG_NO = dg.BKG_NO and rownum = 1 ) = 'Y' then 'RF'" ).append("\n"); 
		query.append("               when (select 'Y' from BKG_AWK_CGO dg where bk.BKG_NO = dg.BKG_NO and rownum = 1 ) = 'Y' then 'AK'" ).append("\n"); 
		query.append("               when (select 'Y' from BKG_BB_CGO dg where bk.BKG_NO = dg.BKG_NO and rownum = 1 ) = 'Y' then 'BB' end spcl" ).append("\n"); 
		query.append("        ,former_vvd.vsl_pre_pst_cd former_vsl_pre_pst_cd" ).append("\n"); 
		query.append("		,next_vvd.vsl_pre_pst_cd next_vsl_pre_pst_cd" ).append("\n"); 
		query.append("	    ,former_skd.yd_cd former_yd_cd" ).append("\n"); 
		query.append("		,next_skd.yd_cd next_yd_cd" ).append("\n"); 
		query.append("  from bkg_booking bk" ).append("\n"); 
		query.append("        , bkg_vvd former_vvd" ).append("\n"); 
		query.append("        , bkg_vvd next_vvd" ).append("\n"); 
		query.append("        , vsk_vsl_port_skd former_skd" ).append("\n"); 
		query.append("        , vsk_vsl_port_skd next_skd" ).append("\n"); 
		query.append(" where bk.bkg_no               = former_vvd.bkg_no " ).append("\n"); 
		query.append("   and bk.bkg_no               = next_vvd.bkg_no " ).append("\n"); 
		query.append("   and former_vvd.pod_cd       = next_vvd.pol_cd" ).append("\n"); 
		query.append("   and bk.bkg_sts_cd           NOT IN ('X','S')" ).append("\n"); 
		query.append("   and former_vvd.vsl_cd            = former_skd.vsl_cd(+)" ).append("\n"); 
		query.append("   and former_vvd.skd_voy_no        = former_skd.skd_voy_no(+)" ).append("\n"); 
		query.append("   and former_vvd.skd_dir_cd        = former_skd.skd_dir_cd(+)" ).append("\n"); 
		query.append("   and former_vvd.pod_cd            = former_skd.vps_port_cd(+)" ).append("\n"); 
		query.append("   and former_vvd.pod_CLPT_IND_SEQ  = former_skd.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("   and next_vvd.vsl_cd              = next_skd.vsl_cd(+)" ).append("\n"); 
		query.append("   and next_vvd.skd_voy_no          = next_skd.skd_voy_no(+)" ).append("\n"); 
		query.append("   and next_vvd.skd_dir_cd          = next_skd.skd_dir_cd(+)" ).append("\n"); 
		query.append("   and next_vvd.pol_cd              = next_skd.vps_port_cd(+)" ).append("\n"); 
		query.append("   and next_vvd.pol_CLPT_IND_SEQ    = next_skd.CLPT_IND_SEQ(+) " ).append("\n"); 
		query.append("   #if (${relayport_cd}!='') " ).append("\n"); 
		query.append("   	and former_vvd.pod_cd        = @[relayport_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${relayPort_yard_cd}!='') " ).append("\n"); 
		query.append("   	and former_vvd.pod_yd_cd     = @[relayport_cd]||@[relayPort_yard_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if(${etb_from}!='' && ${etb_to}) " ).append("\n"); 
		query.append("   	and former_skd.vps_etb_dt    > to_date(@[etb_from], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("   	and former_skd.vps_etb_dt    < to_date(@[etb_to],   'yyyy-mm-dd') + 1" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${former_vvd} !='') " ).append("\n"); 
		query.append("   	and former_vvd.vsl_cd        = substr(@[former_vvd], 1, 4)" ).append("\n"); 
		query.append("   	and former_vvd.skd_voy_no    = substr(@[former_vvd], 5, 4)" ).append("\n"); 
		query.append("   	and former_vvd.skd_dir_cd    = substr(@[former_vvd], 9, 1)" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${next_vvd}!='')" ).append("\n"); 
		query.append("   	and next_vvd.vsl_cd          = substr(@[next_vvd], 1, 4)" ).append("\n"); 
		query.append("   	and next_vvd.skd_voy_no      = substr(@[next_vvd], 5, 4)" ).append("\n"); 
		query.append("   	and next_vvd.skd_dir_cd      = substr(@[next_vvd], 9, 1)" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${next_port} !='')" ).append("\n"); 
		query.append("   	and next_vvd.pod_cd          = @[next_port]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${pol_cd}!='')" ).append("\n"); 
		query.append("   	and bk.pol_cd                = @[pol_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${pod_cd}!='')" ).append("\n"); 
		query.append("   	and bk.pod_cd                = @[pod_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   order by former_skd.vps_etd_dt" ).append("\n"); 

	}
}