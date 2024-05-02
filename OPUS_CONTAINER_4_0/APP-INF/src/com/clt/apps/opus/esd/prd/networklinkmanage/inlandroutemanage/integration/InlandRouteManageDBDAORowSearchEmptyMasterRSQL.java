/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InlandRouteManageDBDAORowSearchEmptyMasterRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.11
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRouteManageDBDAORowSearchEmptyMasterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RowSearchEmptyMaster
	  * </pre>
	  */
	public InlandRouteManageDBDAORowSearchEmptyMasterRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration").append("\n"); 
		query.append("FileName : InlandRouteManageDBDAORowSearchEmptyMasterRSQL").append("\n"); 
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
		query.append("SELECT ROWNUM rn, rout_org_nod_cd, rout_dest_nod_cd," ).append("\n"); 
		query.append("SUBSTR( rout_org_nod_cd,1,5) org_loc, SUBSTR( rout_org_nod_cd,6) org_loc_type," ).append("\n"); 
		query.append("SUBSTR( rout_dest_nod_cd,1,5) dest_loc, SUBSTR( rout_dest_nod_cd,6) dest_loc_type," ).append("\n"); 
		query.append("rout_seq, nvl(prio_seq,0) prio_seq, inlnd_rout_inv_bil_patt_cd,rout_pln_cd,cre_usr_id,cre_ofc_cd,to_char(cre_dt,'yyyy-mm-dd') cre_dt,inlnd_rout_rmk ," ).append("\n"); 
		query.append("rail_crr_tp_cd ,inlnd_rout_junc_nm" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT rout_org_nod_cd, rout_dest_nod_cd, rout_seq, prio_seq" ).append("\n"); 
		query.append(",MAX(DECODE(cnt,1, inlnd_rout_inv_bil_patt_cd, DECODE(rout_dtl_seq,1, inlnd_rout_inv_bil_patt_cd))) inlnd_rout_inv_bil_patt_cd" ).append("\n"); 
		query.append(",MAX(DECODE(cnt,1, rout_pln_cd, DECODE(rout_dtl_seq,1, rout_pln_cd))) rout_pln_cd" ).append("\n"); 
		query.append(",MAX(DECODE(cnt,1, cre_usr_id, DECODE(rout_dtl_seq,1, cre_usr_id))) cre_usr_id" ).append("\n"); 
		query.append(",MAX(DECODE(cnt,1, cre_ofc_cd, DECODE(rout_dtl_seq,1, cre_ofc_cd))) cre_ofc_cd" ).append("\n"); 
		query.append(",MAX(DECODE(cnt,1, cre_dt, DECODE(rout_dtl_seq,1, cre_dt))) cre_dt" ).append("\n"); 
		query.append(",MAX(DECODE(cnt,1, inlnd_rout_rmk, DECODE(rout_dtl_seq,1, inlnd_rout_rmk))) inlnd_rout_rmk" ).append("\n"); 
		query.append(",MAX(DECODE(cnt,1, rail_crr_tp_cd, DECODE(rout_dtl_seq,1, rail_crr_tp_cd))) rail_crr_tp_cd" ).append("\n"); 
		query.append(",MAX(DECODE(cnt,1, inlnd_rout_junc_nm, DECODE(rout_dtl_seq,1, inlnd_rout_junc_nm))) inlnd_rout_junc_nm" ).append("\n"); 
		query.append(",rout_org_nod_cd AS pod0" ).append("\n"); 
		query.append(",rout_dest_nod_cd AS del" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT rout_org_nod_cd, rout_dest_nod_cd, rout_seq, prio_seq,inlnd_rout_bkg_flg ," ).append("\n"); 
		query.append("rout_dtl_seq, cnt,lnk_org_nod_cd, lnk_dest_nod_cd,trsp_mod_cd," ).append("\n"); 
		query.append("inlnd_rout_inv_bil_patt_cd,rout_pln_cd,cre_usr_id,cre_ofc_cd,cre_dt," ).append("\n"); 
		query.append("inlnd_rout_rmk ,rail_crr_tp_cd ,inlnd_rout_junc_nm" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq, decode(m.prio_seq,0,null,m.prio_seq) prio_seq,m.inlnd_rout_bkg_flg ," ).append("\n"); 
		query.append("d.lnk_org_nod_cd,d.lnk_dest_nod_cd, d.rout_dtl_seq,d.trsp_mod_cd," ).append("\n"); 
		query.append("COUNT (*) OVER (PARTITION BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq" ).append("\n"); 
		query.append("ORDER BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq) AS cnt ," ).append("\n"); 
		query.append("m.inlnd_rout_inv_bil_patt_cd,m.rout_pln_cd,m.cre_usr_id,m.cre_ofc_cd,m.cre_dt," ).append("\n"); 
		query.append("m.inlnd_rout_rmk,d.rail_crr_tp_cd,d.inlnd_rout_junc_nm" ).append("\n"); 
		query.append("FROM prd_inlnd_rout_mst m, prd_inlnd_rout_dtl d" ).append("\n"); 
		query.append("WHERE m.rout_org_nod_cd = @[i_rout_org_nod_cd]" ).append("\n"); 
		query.append("AND m.rout_dest_nod_cd = @[i_rout_dest_nod_cd]" ).append("\n"); 
		query.append("AND m.rout_seq = @[i_rout_seq]" ).append("\n"); 
		query.append("AND NVL(m.DELT_FLG,'N') ='N'" ).append("\n"); 
		query.append("AND m.rout_org_nod_cd = d.rout_org_nod_cd" ).append("\n"); 
		query.append("AND m.rout_dest_nod_cd = d.rout_dest_nod_cd" ).append("\n"); 
		query.append("AND m.rout_seq = d.rout_seq" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND m.pctl_io_bnd_cd ='M'" ).append("\n"); 
		query.append("AND EXISTS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 'X' FROM prd_node N" ).append("\n"); 
		query.append("WHERE n.nod_cd = m.rout_org_nod_cd" ).append("\n"); 
		query.append("AND  n.nod_tp_cd  != 'Z'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND EXISTS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 'X' FROM prd_node n" ).append("\n"); 
		query.append("WHERE n.nod_cd = m.rout_dest_nod_cd" ).append("\n"); 
		query.append("AND  n.nod_tp_cd  != 'Z'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY m.rout_seq, d.rout_dtl_seq" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") m" ).append("\n"); 
		query.append("GROUP BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq, m.prio_seq" ).append("\n"); 
		query.append("ORDER BY rout_org_nod_cd, rout_dest_nod_cd, prio_seq" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}