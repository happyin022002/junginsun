/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CopDetailReceiveDBDAOCheckUSBndForCSMRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2017.01.19 홍성필
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hong Seong Pil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOCheckUSBndForCSMRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MVMT 가 CSM 전송 대상 (bkg 이 가진 VVD 로 볼때 POD / DEL 도착 전 미국 기항을 하는 MVMT) 인지 확인한다.
	  * </pre>
	  */
	public CopDetailReceiveDBDAOCheckUSBndForCSMRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_sts_mapg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOCheckUSBndForCSMRSQL").append("\n"); 
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
		query.append("select 'US_BOUND'" ).append("\n"); 
		query.append("from ctm_movement a," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    select cntr_no," ).append("\n"); 
		query.append("      cnmv_yr," ).append("\n"); 
		query.append("      cnmv_id_no," ).append("\n"); 
		query.append("      mvmt_sts_cd," ).append("\n"); 
		query.append("      v.vsl_cd," ).append("\n"); 
		query.append("      v.skd_voy_no," ).append("\n"); 
		query.append("      v.skd_dir_cd," ).append("\n"); 
		query.append("      max(case when b.pod_cd = c.vps_port_cd then clpt_seq else null end) as pod_clpt_seq," ).append("\n"); 
		query.append("      max(case when b.del_cd = c.vps_port_cd then clpt_seq else null end) as del_clpt_seq" ).append("\n"); 
		query.append("    from ctm_movement a," ).append("\n"); 
		query.append("      bkg_booking b," ).append("\n"); 
		query.append("      bkg_vvd v," ).append("\n"); 
		query.append("      vsk_vsl_port_skd c" ).append("\n"); 
		query.append("    where" ).append("\n"); 
		query.append("     (cntr_no, cnmv_yr, cnmv_id_no) in " ).append("\n"); 
		query.append("		(select cntr_no, cnmv_yr, cnmv_id_no " ).append("\n"); 
		query.append("			from ctm_movement " ).append("\n"); 
		query.append("			where bkg_no = @[bkg_no] and cntr_no = @[cntr_no]" ).append("\n"); 
		query.append("						and mvmt_sts_cd = @[act_sts_mapg_cd] and org_yd_cd = @[nod_cd]" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("      and a.bkg_no = b.bkg_no" ).append("\n"); 
		query.append("      and a.bkg_no = v.bkg_no" ).append("\n"); 
		query.append("      and v.vsl_cd = c.vsl_cd" ).append("\n"); 
		query.append("      and v.skd_voy_no = c.skd_voy_no" ).append("\n"); 
		query.append("      and v.skd_dir_cd = c.skd_dir_cd" ).append("\n"); 
		query.append("    group by cntr_no, cnmv_yr, cnmv_id_no, mvmt_sts_cd, v.vsl_cd, v.skd_voy_no, v.skd_dir_cd ) b" ).append("\n"); 
		query.append("where a.cntr_no = b.cntr_no" ).append("\n"); 
		query.append("  and a.cnmv_yr = b.cnmv_yr" ).append("\n"); 
		query.append("  and a.cnmv_id_no = b.cnmv_id_no" ).append("\n"); 
		query.append("  and a.mvmt_sts_cd = b.mvmt_sts_cd" ).append("\n"); 
		query.append("  and exists (" ).append("\n"); 
		query.append("    select '1'" ).append("\n"); 
		query.append("    from vsk_vsl_port_skd c" ).append("\n"); 
		query.append("    where b.vsl_cd = c.vsl_cd" ).append("\n"); 
		query.append("      and b.skd_voy_no = c.skd_voy_no" ).append("\n"); 
		query.append("      and b.skd_dir_cd = c.skd_dir_cd" ).append("\n"); 
		query.append("      and ( (c.clpt_seq <= pod_clpt_seq" ).append("\n"); 
		query.append("              and c.vps_port_cd like 'US%')" ).append("\n"); 
		query.append("          or (c.clpt_seq <= del_clpt_seq" ).append("\n"); 
		query.append("              and c.vps_port_cd like 'US%') ) )" ).append("\n"); 
		query.append("union" ).append("\n"); 
		query.append("select 'US_BOUND'" ).append("\n"); 
		query.append("	from bkg_booking" ).append("\n"); 
		query.append("	where " ).append("\n"); 
		query.append("		bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("		and (pol_cd like 'US%' or del_cd like 'US%')" ).append("\n"); 

	}
}