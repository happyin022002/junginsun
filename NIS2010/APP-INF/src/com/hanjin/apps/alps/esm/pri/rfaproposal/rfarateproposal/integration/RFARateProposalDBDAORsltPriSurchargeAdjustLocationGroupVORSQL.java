/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFARateProposalDBDAORsltPriSurchargeAdjustLocationGroupVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.08.04 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAORsltPriSurchargeAdjustLocationGroupVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    Surcharge Adjust Location Group 조회
	  * </pre>
	  */
	public RFARateProposalDBDAORsltPriSurchargeAdjustLocationGroupVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("select_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAORsltPriSurchargeAdjustLocationGroupVORSQL").append("\n"); 
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
		query.append("WITH dstct_rout_pnt AS (" ).append("\n"); 
		query.append("SELECT DISTINCT rout_pnt.rout_pnt_loc_def_cd" ).append("\n"); 
		query.append(", rout_pnt.prop_no,rout_pnt.amdt_seq,rout_pnt.svc_scp_cd, rout_pnt.rout_pnt_loc_tp_cd ,rout_pnt.org_dest_tp_cd" ).append("\n"); 
		query.append("FROM pri_rp_scp_rt_rout_pnt rout_pnt" ).append("\n"); 
		query.append("WHERE rout_pnt.prop_no = @[prop_no]" ).append("\n"); 
		query.append("AND rout_pnt.amdt_seq = @[amdt_seq]" ).append("\n"); 
		query.append("AND rout_pnt.svc_scp_cd = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND rout_pnt.org_dest_tp_cd = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("AND @[select_type] = 'ORI'" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("dstct_rout_via AS (" ).append("\n"); 
		query.append("SELECT DISTINCT rout_via.rout_via_port_def_cd" ).append("\n"); 
		query.append(", rout_via.prop_no,rout_via.amdt_seq,rout_via.svc_scp_cd, rout_via.rout_via_port_tp_cd ,rout_via.org_dest_tp_cd" ).append("\n"); 
		query.append("FROM pri_rp_scp_rt_rout_via rout_via" ).append("\n"); 
		query.append("WHERE rout_via.prop_no = @[prop_no]" ).append("\n"); 
		query.append("AND rout_via.amdt_seq = @[amdt_seq]" ).append("\n"); 
		query.append("AND rout_via.svc_scp_cd = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND rout_via.org_dest_tp_cd = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("AND @[select_type] = 'VIA'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT loc_def_cd , prc_grp_loc_desc" ).append("\n"); 
		query.append(", prop_no,amdt_seq,svc_scp_cd, grp_loc_seq,  rout_loc_tp_cd ,org_dest_tp_cd" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("-- Origin/Destination Begin" ).append("\n"); 
		query.append("SELECT rout_pnt.rout_pnt_loc_def_cd as  loc_def_cd , grp_loc.prc_grp_loc_desc as prc_grp_loc_desc" ).append("\n"); 
		query.append(", grp_loc.prop_no,grp_loc.amdt_seq,grp_loc.svc_scp_cd, grp_loc.grp_loc_seq, rout_pnt.rout_pnt_loc_tp_cd as rout_loc_tp_cd ,rout_pnt.org_dest_tp_cd" ).append("\n"); 
		query.append("FROM dstct_rout_pnt rout_pnt" ).append("\n"); 
		query.append(", pri_rp_scp_grp_loc grp_loc" ).append("\n"); 
		query.append("WHERE  rout_pnt.rout_pnt_loc_tp_cd = 'G'" ).append("\n"); 
		query.append("AND rout_pnt.prop_no = grp_loc.prop_no" ).append("\n"); 
		query.append("AND rout_pnt.amdt_seq = grp_loc.amdt_seq" ).append("\n"); 
		query.append("AND rout_pnt.svc_scp_cd = grp_loc.svc_scp_cd" ).append("\n"); 
		query.append("AND rout_pnt.rout_pnt_loc_def_cd = grp_loc.prc_grp_loc_cd" ).append("\n"); 
		query.append("AND @[select_type] = 'ORI'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT mdm_loc.loc_cd  , mdm_loc.loc_nm" ).append("\n"); 
		query.append(", rout_pnt.prop_no,rout_pnt.amdt_seq,rout_pnt.svc_scp_cd, 0 grp_loc_seq, rout_pnt.rout_pnt_loc_tp_cd,rout_pnt.org_dest_tp_cd" ).append("\n"); 
		query.append("FROM dstct_rout_pnt rout_pnt" ).append("\n"); 
		query.append(", mdm_location mdm_loc" ).append("\n"); 
		query.append("WHERE  rout_pnt.rout_pnt_loc_tp_cd = 'L'" ).append("\n"); 
		query.append("AND mdm_loc.delt_flg = 'N'" ).append("\n"); 
		query.append("AND rout_pnt.rout_pnt_loc_def_cd = mdm_loc.loc_cd" ).append("\n"); 
		query.append("AND @[select_type] = 'ORI'" ).append("\n"); 
		query.append("-- Origin/Destination End" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("-- Origin Via/Destination Via Begin" ).append("\n"); 
		query.append("SELECT rout_via.rout_via_port_def_cd , grp_loc.prc_grp_loc_desc" ).append("\n"); 
		query.append(", grp_loc.prop_no,grp_loc.amdt_seq,grp_loc.svc_scp_cd,grp_loc.grp_loc_seq, rout_via.rout_via_port_tp_cd as rout_loc_tp_cd ,rout_via.org_dest_tp_cd" ).append("\n"); 
		query.append("FROM dstct_rout_via rout_via" ).append("\n"); 
		query.append(", pri_rp_scp_grp_loc grp_loc" ).append("\n"); 
		query.append("WHERE  rout_via.rout_via_port_tp_cd = 'G'" ).append("\n"); 
		query.append("AND rout_via.prop_no = grp_loc.prop_no" ).append("\n"); 
		query.append("AND rout_via.amdt_seq = grp_loc.amdt_seq" ).append("\n"); 
		query.append("AND rout_via.svc_scp_cd = grp_loc.svc_scp_cd" ).append("\n"); 
		query.append("AND rout_via.rout_via_port_def_cd = grp_loc.prc_grp_loc_cd" ).append("\n"); 
		query.append("AND @[select_type] = 'VIA'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT mdm_loc.loc_cd  , mdm_loc.loc_nm" ).append("\n"); 
		query.append(", rout_via.prop_no,rout_via.amdt_seq,rout_via.svc_scp_cd, 0 grp_loc_seq, rout_via.rout_via_port_tp_cd,rout_via.org_dest_tp_cd" ).append("\n"); 
		query.append("FROM dstct_rout_via rout_via" ).append("\n"); 
		query.append(", mdm_location mdm_loc" ).append("\n"); 
		query.append("WHERE   rout_via.rout_via_port_tp_cd = 'L'" ).append("\n"); 
		query.append("AND mdm_loc.delt_flg = 'N'" ).append("\n"); 
		query.append("AND rout_via.rout_via_port_def_cd = mdm_loc.loc_cd" ).append("\n"); 
		query.append("AND @[select_type] = 'VIA'" ).append("\n"); 
		query.append("-- Origin Via/Destination Via End" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY loc_def_cd" ).append("\n"); 

	}
}