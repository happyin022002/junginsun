/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFARateQuotationDBDAORsltPriSurchargeAdjustLocationGroupVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.08.04 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateQuotationDBDAORsltPriSurchargeAdjustLocationGroupVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    Surcharge Adjust Location Group 조회
	  * </pre>
	  */
	public RFARateQuotationDBDAORsltPriSurchargeAdjustLocationGroupVORSQL(){
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
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration").append("\n"); 
		query.append("FileName : RFARateQuotationDBDAORsltPriSurchargeAdjustLocationGroupVORSQL").append("\n"); 
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
		query.append(", rout_pnt.qttn_no,rout_pnt.qttn_ver_no, rout_pnt.rout_pnt_loc_tp_cd ,rout_pnt.org_dest_tp_cd" ).append("\n"); 
		query.append("FROM pri_rq_rt_rout_pnt rout_pnt" ).append("\n"); 
		query.append("WHERE rout_pnt.qttn_no = @[qttn_no]" ).append("\n"); 
		query.append("AND rout_pnt.qttn_ver_no = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND rout_pnt.org_dest_tp_cd = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("AND @[select_type] = 'ORI'" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("dstct_rout_via AS (" ).append("\n"); 
		query.append("SELECT DISTINCT rout_via.rout_via_port_def_cd" ).append("\n"); 
		query.append(", rout_via.qttn_no,rout_via.qttn_ver_no, rout_via.rout_via_port_tp_cd ,rout_via.org_dest_tp_cd" ).append("\n"); 
		query.append("FROM pri_rq_rt_rout_via rout_via" ).append("\n"); 
		query.append("WHERE rout_via.qttn_no = @[qttn_no]" ).append("\n"); 
		query.append("AND rout_via.qttn_ver_no = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND rout_via.org_dest_tp_cd = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("AND @[select_type] = 'VIA'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT loc_def_cd , prc_grp_loc_desc" ).append("\n"); 
		query.append(", qttn_no,qttn_ver_no, grp_loc_seq,  rout_loc_tp_cd ,org_dest_tp_cd" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("-- Origin/Destination Begin" ).append("\n"); 
		query.append("SELECT rout_pnt.rout_pnt_loc_def_cd as  loc_def_cd , grp_loc.prc_grp_loc_desc as prc_grp_loc_desc" ).append("\n"); 
		query.append(", grp_loc.qttn_no,grp_loc.qttn_ver_no, grp_loc.grp_loc_seq, rout_pnt.rout_pnt_loc_tp_cd as rout_loc_tp_cd ,rout_pnt.org_dest_tp_cd" ).append("\n"); 
		query.append("FROM dstct_rout_pnt rout_pnt" ).append("\n"); 
		query.append(", pri_rq_grp_loc grp_loc" ).append("\n"); 
		query.append("WHERE  rout_pnt.rout_pnt_loc_tp_cd = 'G'" ).append("\n"); 
		query.append("AND rout_pnt.qttn_no = grp_loc.qttn_no" ).append("\n"); 
		query.append("AND rout_pnt.qttn_ver_no = grp_loc.qttn_ver_no" ).append("\n"); 
		query.append("AND rout_pnt.rout_pnt_loc_def_cd = grp_loc.prc_grp_loc_cd" ).append("\n"); 
		query.append("AND @[select_type] = 'ORI'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT mdm_loc.loc_cd  , mdm_loc.loc_nm" ).append("\n"); 
		query.append(", rout_pnt.qttn_no,rout_pnt.qttn_ver_no, 0 grp_loc_seq, rout_pnt.rout_pnt_loc_tp_cd,rout_pnt.org_dest_tp_cd" ).append("\n"); 
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
		query.append(", grp_loc.qttn_no,grp_loc.qttn_ver_no,grp_loc.grp_loc_seq, rout_via.rout_via_port_tp_cd as rout_loc_tp_cd ,rout_via.org_dest_tp_cd" ).append("\n"); 
		query.append("FROM dstct_rout_via rout_via" ).append("\n"); 
		query.append(", pri_rq_grp_loc grp_loc" ).append("\n"); 
		query.append("WHERE  rout_via.rout_via_port_tp_cd = 'G'" ).append("\n"); 
		query.append("AND rout_via.qttn_no = grp_loc.qttn_no" ).append("\n"); 
		query.append("AND rout_via.qttn_ver_no = grp_loc.qttn_ver_no" ).append("\n"); 
		query.append("AND rout_via.rout_via_port_def_cd = grp_loc.prc_grp_loc_cd" ).append("\n"); 
		query.append("AND @[select_type] = 'VIA'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT mdm_loc.loc_cd  , mdm_loc.loc_nm" ).append("\n"); 
		query.append(", rout_via.qttn_no,rout_via.qttn_ver_no, 0 grp_loc_seq, rout_via.rout_via_port_tp_cd,rout_via.org_dest_tp_cd" ).append("\n"); 
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