/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOcheckMainCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StevedoreDamageMgtDBDAOcheckMainCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSL,VVD,Port,Lane의 유효성 검사
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOcheckMainCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration").append("\n"); 
		query.append("FileName : StevedoreDamageMgtDBDAOcheckMainCodeRSQL").append("\n"); 
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
		query.append("#if (${auto_skd_cng_flg} =='VSL')" ).append("\n"); 
		query.append("  select vsl_cd as CODE" ).append("\n"); 
		query.append("    from vsk_vsl_skd" ).append("\n"); 
		query.append("   where vsl_cd = @[vsl_cd]" ).append("\n"); 
		query.append("     and rownum = 1" ).append("\n"); 
		query.append("  union " ).append("\n"); 
		query.append("  select vsl_cd as CODE" ).append("\n"); 
		query.append("    from ar_mst_rev_vvd" ).append("\n"); 
		query.append("   where vsl_cd = @[vsl_cd]    " ).append("\n"); 
		query.append("     and rownum = 1" ).append("\n"); 
		query.append("#elseif (${auto_skd_cng_flg} =='VVD')" ).append("\n"); 
		query.append("  select VSL_CD||SKD_VOY_NO||SKD_DIR_CD as CODE" ).append("\n"); 
		query.append("    from vsk_vsl_skd" ).append("\n"); 
		query.append("   where vsl_cd     = @[vsl_cd]" ).append("\n"); 
		query.append("     and skd_voy_no = @[skd_voy_no]" ).append("\n"); 
		query.append("     and skd_dir_cd = @[skd_dir_cd]" ).append("\n"); 
		query.append("     and rownum = 1" ).append("\n"); 
		query.append("  union " ).append("\n"); 
		query.append("  select VSL_CD||SKD_VOY_NO||SKD_DIR_CD as CODE" ).append("\n"); 
		query.append("    from ar_mst_rev_vvd" ).append("\n"); 
		query.append("   where vsl_cd     = @[vsl_cd]  " ).append("\n"); 
		query.append("     and skd_voy_no = @[skd_voy_no]" ).append("\n"); 
		query.append("     and skd_dir_cd = @[skd_dir_cd]     " ).append("\n"); 
		query.append("     and rownum = 1" ).append("\n"); 
		query.append("#elseif (${auto_skd_cng_flg} =='PORT')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  select 'VSK'||a.vps_port_cd as CODE" ).append("\n"); 
		query.append("   from vsk_vsl_port_skd a" ).append("\n"); 
		query.append("  where vsl_cd     = @[vsl_cd]  " ).append("\n"); 
		query.append("    and skd_voy_no  = @[skd_voy_no]" ).append("\n"); 
		query.append("    and skd_dir_cd  = @[skd_dir_cd]     " ).append("\n"); 
		query.append("    and vps_port_cd = @[vps_port_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  union " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  select 'MDM'||loc_cd as CODE" ).append("\n"); 
		query.append("   from mdm_location" ).append("\n"); 
		query.append("  where loc_cd = @[vps_port_cd]" ).append("\n"); 
		query.append("    and call_port_flg = 'Y'" ).append("\n"); 
		query.append("    and not exists (" ).append("\n"); 
		query.append("                    select '1'" ).append("\n"); 
		query.append("                      from vsk_vsl_port_skd b" ).append("\n"); 
		query.append("                     where b.vsl_cd     = @[vsl_cd]  " ).append("\n"); 
		query.append("                       and b.skd_voy_no = @[skd_voy_no]" ).append("\n"); 
		query.append("                       and b.skd_dir_cd = @[skd_dir_cd]     " ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${auto_skd_cng_flg} =='LANE')" ).append("\n"); 
		query.append("    select vsl_slan_cd as CODE" ).append("\n"); 
		query.append("    from mdm_vsl_svc_lane" ).append("\n"); 
		query.append("    where vsl_slan_cd = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}