/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TransshipmentMgtDBDAOsearchVslDischargingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.12
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.04.12 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransshipmentMgtDBDAOsearchVslDischargingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회 조건에 맞는 vessel schedule과 지정되어 있는 crn, uvi no를 조회한다.
	  * </pre>
	  */
	public TransshipmentMgtDBDAOsearchVslDischargingRSQL(){
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
		params.put("vps_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_oher_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration").append("\n"); 
		query.append("FileName : TransshipmentMgtDBDAOsearchVslDischargingRSQL").append("\n"); 
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
		query.append("select vps.vsl_cd||vps.skd_voy_no||vps.skd_dir_cd vvd" ).append("\n"); 
		query.append("        , vps.slan_cd lane" ).append("\n"); 
		query.append("		, vps.clpt_ind_seq skd_call_seq" ).append("\n"); 
		query.append("        , vps.vps_port_cd clpt_cd " ).append("\n"); 
		query.append("        , to_char(vps.vps_etb_dt,'yyyy-mm-dd') etb" ).append("\n"); 
		query.append("        , SUBSTR(dchg.yd_cd, 6, 2) ydcd" ).append("\n"); 
		query.append("        , dchg.cvy_ref_no " ).append("\n"); 
		query.append("        , dchg.uq_vsl_id_no " ).append("\n"); 
		query.append("        , vps.vsl_cd" ).append("\n"); 
		query.append("        , vps.skd_voy_no" ).append("\n"); 
		query.append("        , vps.skd_dir_cd" ).append("\n"); 
		query.append("        , dchg.yd_cd yd_cd" ).append("\n"); 
		query.append("  from vsk_vsl_port_skd vps, bkg_vsl_dchg_yd dchg, mdm_vsl_cntr vsl" ).append("\n"); 
		query.append(" where vps.vsl_cd = dchg.vsl_cd(+)" ).append("\n"); 
		query.append("   and vps.skd_voy_no = dchg.skd_voy_no(+)" ).append("\n"); 
		query.append("   and vps.skd_dir_cd = dchg.skd_dir_cd(+)" ).append("\n"); 
		query.append("   and vps.vps_port_cd = dchg.port_cd(+)" ).append("\n"); 
		query.append("   and vps.CLPT_IND_SEQ = dchg.clpt_ind_seq(+)" ).append("\n"); 
		query.append("   and vps.vsl_cd = vsl.vsl_cd" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vps_etb_dt} != '') " ).append("\n"); 
		query.append("   and vps.vps_etb_dt  >= TO_DATE(@[vps_etb_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vps_etd_dt} != '') " ).append("\n"); 
		query.append("   and vps.vps_etd_dt  <= TO_DATE(@[vps_etd_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vps_port_cd} != '') " ).append("\n"); 
		query.append("   and vps.VPS_PORT_CD = @[vps_port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vps_oher_port_cd} != '') " ).append("\n"); 
		query.append(" and  (vps.vsl_cd, vps.skd_voy_no, vps.skd_dir_cd)" ).append("\n"); 
		query.append("        in (select vsl_cd, skd_voy_no, skd_dir_cd" ).append("\n"); 
		query.append("            from vsk_vsl_port_skd where vps_port_cd = @[vps_oher_port_cd]) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd} != '') " ).append("\n"); 
		query.append("   and vps.VSL_CD||vps.SKD_VOY_NO||vps.SKD_DIR_CD like @[vvd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lane} != '') " ).append("\n"); 
		query.append("   and vps.slan_cd  = @[lane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${crr_cd} != '') " ).append("\n"); 
		query.append("   and vsl.crr_cd  = @[crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}