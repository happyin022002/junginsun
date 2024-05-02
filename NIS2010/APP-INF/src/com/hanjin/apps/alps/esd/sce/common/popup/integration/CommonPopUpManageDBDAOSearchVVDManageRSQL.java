/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CommonPopUpManageDBDAOSearchVVDManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.21
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.03.21 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.common.popup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonPopUpManageDBDAOSearchVVDManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchVVDManage
	  * </pre>
	  */
	public CommonPopUpManageDBDAOSearchVVDManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skdvoyno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("selvslcd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("selpod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skddircd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sellane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("selpol",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.common.popup.integration").append("\n"); 
		query.append("FileName : CommonPopUpManageDBDAOSearchVVDManageRSQL").append("\n"); 
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
		query.append("select sk.vsl_cd||sk.skd_voy_no||sk.skd_dir_cd vvd, sk.slan_cd slane," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - seletad */" ).append("\n"); 
		query.append("#if (${seletad} == 'ETD')" ).append("\n"); 
		query.append("vd.pol_cd port, to_char(sk.vps_etd_dt, 'yyyy-mm-dd hh24:mm:ss') etdate" ).append("\n"); 
		query.append("#elseif (${seletad} == 'ETA')" ).append("\n"); 
		query.append("vd.pod_cd port, to_char(sk.vps_eta_dt, 'yyyy-mm-dd hh24:mm:ss') etdate" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("from vsk_vsl_port_skd sk, bkg_vvd vd" ).append("\n"); 
		query.append("where" ).append("\n"); 
		query.append("sk.vsl_cd = vd.vsl_cd" ).append("\n"); 
		query.append("and sk.skd_voy_no = vd.skd_voy_no" ).append("\n"); 
		query.append("and sk.skd_dir_cd = vd.skd_dir_cd" ).append("\n"); 
		query.append("and sk.slan_cd = vd.slan_cd" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - seletad */" ).append("\n"); 
		query.append("#if (${seletad} == 'ETD')" ).append("\n"); 
		query.append("and sk.vps_port_cd = vd.pol_cd" ).append("\n"); 
		query.append("#elseif (${seletad} == 'ETA')" ).append("\n"); 
		query.append("and sk.vps_port_cd = vd.pod_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - selpol */" ).append("\n"); 
		query.append("#if (${seletad} == 'ETD' && ${selpol} != '')" ).append("\n"); 
		query.append("and vd.pol_cd = @[selpol]" ).append("\n"); 
		query.append("#elseif (${seletad} == 'ETA' && ${selpod} != '')" ).append("\n"); 
		query.append("and vd.pod_cd = @[selpod]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - sellane */" ).append("\n"); 
		query.append("#if (${sellane} != '')" ).append("\n"); 
		query.append("and vd.slan_cd = @[sellane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - selvvd */" ).append("\n"); 
		query.append("#if (${selvvd} != '')" ).append("\n"); 
		query.append("and vd.vsl_cd = @[selvslcd]" ).append("\n"); 
		query.append("and vd.skd_voy_no = @[skdvoyno]" ).append("\n"); 
		query.append("and vd.skd_dir_cd = @[skddircd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - selfdate */" ).append("\n"); 
		query.append("#if (${seletad} == 'ETD' && ${sdate} != '')" ).append("\n"); 
		query.append("and sk.vps_etd_dt between to_date(@[sdate],'yyyymmdd') and to_date(@[edate],'yyyymmdd') + 0.99999" ).append("\n"); 
		query.append("/* condition - seltdate */" ).append("\n"); 
		query.append("#elseif (${seletad} == 'ETA' && ${edate} != '')" ).append("\n"); 
		query.append("and sk.vps_eta_dt between to_date(@[sdate],'yyyymmdd') and to_date(@[edate],'yyyymmdd') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("group by sk.vsl_cd, sk.skd_voy_no, sk.skd_dir_cd, sk.slan_cd," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - seletad */" ).append("\n"); 
		query.append("#if (${seletad} == 'ETD')" ).append("\n"); 
		query.append("vd.pol_cd, sk.vps_etd_dt" ).append("\n"); 
		query.append("#elseif (${seletad} == 'ETA')" ).append("\n"); 
		query.append("vd.pod_cd, sk.vps_eta_dt" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${seletad} == 'ETD')" ).append("\n"); 
		query.append("order by to_char(sk.vps_etd_dt, 'yyyy-mm-dd hh24:mm:ss')" ).append("\n"); 
		query.append("#elseif (${seletad} == 'ETA')" ).append("\n"); 
		query.append("order by to_char(sk.vps_eta_dt, 'yyyy-mm-dd hh24:mm:ss')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}