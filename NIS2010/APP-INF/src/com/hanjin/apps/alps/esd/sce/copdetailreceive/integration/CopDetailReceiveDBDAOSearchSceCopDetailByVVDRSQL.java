/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchSceCopDetailByVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchSceCopDetailByVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSceCopDetailByVVD
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchSceCopDetailByVVDRSQL(){
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
		params.put("act_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchSceCopDetailByVVDRSQL").append("\n"); 
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
		query.append("select s2.cop_no, to_char(s2.cop_dtl_seq) as fm_cop_dtl_seq, s2.nod_cd, s2.act_cd" ).append("\n"); 
		query.append(",s2.estm_gap rcv_evnt_gap_desc, s2.vl_row, s2.trnk_cop " ).append("\n"); 
		query.append("from ( " ).append("\n"); 
		query.append("select s1.cop_no " ).append("\n"); 
		query.append("      ,max(decode(s1.slt_flg,'Y',s1.cop_dtl_seq)) cop_dtl_seq " ).append("\n"); 
		query.append("      ,max(decode(s1.slt_flg,'Y',s1.nod_cd)) nod_cd " ).append("\n"); 
		query.append("      ,max(decode(s1.slt_flg,'Y',s1.act_cd)) act_cd " ).append("\n"); 
		query.append("      ,max(decode(s1.slt_flg,'Y',s1.estm_gap)) estm_gap " ).append("\n"); 
		query.append("      ,min(s1.vl_row) vl_row " ).append("\n"); 
		query.append("      ,nvl(min(s1.trnk_cop),'N') trnk_cop " ).append("\n"); 
		query.append("from ( " ).append("\n"); 
		query.append("select a.cop_no " ).append("\n"); 
		query.append("     ,a.cop_dtl_seq " ).append("\n"); 
		query.append("     ,a.nod_cd " ).append("\n"); 
		query.append("     ,a.act_cd " ).append("\n"); 
		query.append("     ,to_char(to_date(@[act_dt],'YYYY/MM/DD HH24:MI:SS') - a.estm_dt,'0.0000000000') estm_gap        " ).append("\n"); 
		query.append("     ,a.cop_no||a.cop_dtl_seq vl_row " ).append("\n"); 
		query.append("     ,(case when substr(a.act_cd,5,1) = substr(@[act_sts_mapg_cd],3,1) then 'Y' else 'N' end) slt_flg " ).append("\n"); 
		query.append("     ,(case when substr(a.act_cd,5,1) = substr(@[act_sts_mapg_cd],3,1)  " ).append("\n"); 
		query.append("            then (select min(sc.cop_no||sc.cop_dtl_seq)  " ).append("\n"); 
		query.append("                  from   sce_cop_dtl sc " ).append("\n"); 
		query.append("                  where  sc.cop_no = a.cop_no " ).append("\n"); 
		query.append("                  and    (sc.vsl_cd||sc.skd_voy_no||sc.skd_dir_cd) = substr((select min(sg.cop_dtl_seq||sg.vsl_cd||sg.skd_voy_no||sg.skd_dir_cd)  " ).append("\n"); 
		query.append("                                                                      from   sce_cop_dtl sg " ).append("\n"); 
		query.append("                                                                      where  sg.cop_no      = a.cop_no " ).append("\n"); 
		query.append("                                                                      -- mother vvd 이거나 feeder 라도 schedule이 확정된 vvd의 경우는 gap 계산이 없도록 한다." ).append("\n"); 
		query.append("                                                                      and    (substr(sg.act_cd,3,1) = 'V' or (substr(sg.act_cd,3,1) = 'W' and sg.vsl_cd is not null))" ).append("\n"); 
		query.append("                                                                      and    sg.cop_dtl_seq > (select max(ssg.cop_dtl_seq) from sce_cop_dtl ssg " ).append("\n"); 
		query.append("                                                                                               where ssg.cop_no    = b.cop_no  " ).append("\n"); 
		query.append("                                                                                               and substr(ssg.act_cd,3,1) IN ('V','W')" ).append("\n"); 
		query.append("                                                                                               and (ssg.vsl_cd||ssg.skd_voy_no||ssg.skd_dir_cd||ssg.vps_port_cd) = (@[vsl_cd]||@[skd_voy_no]||@[skd_dir_cd]||@[vps_port_cd])) " ).append("\n"); 
		query.append("                                                                      ),5,9) " ).append("\n"); 
		query.append("                 )  " ).append("\n"); 
		query.append("            end) trnk_cop " ).append("\n"); 
		query.append("from   sce_cop_dtl a, sce_cop_hdr b " ).append("\n"); 
		query.append("where  a.vsl_cd                = @[vsl_cd]   " ).append("\n"); 
		query.append("and    a.skd_voy_no            = @[skd_voy_no]  " ).append("\n"); 
		query.append("and    a.skd_dir_cd            = @[skd_dir_cd]   " ).append("\n"); 
		query.append("and    substr(a.nod_cd,1,5)    = @[vps_port_cd] " ).append("\n"); 
		query.append("and    nvl(a.clpt_ind_seq,'1') = nvl(@[clpt_ind_seq],'1') " ).append("\n"); 
		query.append("and    b.cop_no                = a.cop_no " ).append("\n"); 
		query.append("and    b.cop_sts_cd            in ('C','T') ) s1 " ).append("\n"); 
		query.append("group by cop_no ) s2 " ).append("\n"); 
		query.append("where substr(s2.act_cd,5,1) = substr(@[act_sts_mapg_cd],3,1)" ).append("\n"); 

	}
}