/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CopDetailReceiveDBDAOModifyTrsRailSoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.27
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.27 
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

public class CopDetailReceiveDBDAOModifyTrsRailSoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyTrsRailSo
	  * </pre>
	  */
	public CopDetailReceiveDBDAOModifyTrsRailSoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOModifyTrsRailSoUSQL").append("\n"); 
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
		query.append("merge into  trs_trsp_rail_bil_ord  d" ).append("\n"); 
		query.append("using ( select a.trsp_so_ofc_cty_cd,a.trsp_so_seq,a.cop_no, a.cost_act_grp_seq" ).append("\n"); 
		query.append("from   trs_trsp_rail_bil_ord a" ).append("\n"); 
		query.append("where  a.cop_no      = @[cop_no]" ).append("\n"); 
		query.append("and    a.trsp_bnd_cd = 'I'" ).append("\n"); 
		query.append("and    a.delt_flg    = 'N'" ).append("\n"); 
		query.append("group by a.trsp_so_ofc_cty_cd,a.trsp_so_seq,a.cop_no, a.cost_act_grp_seq" ).append("\n"); 
		query.append(") s" ).append("\n"); 
		query.append("on    ( d.trsp_so_ofc_cty_cd = s.trsp_so_ofc_cty_cd and d.trsp_so_seq = s.trsp_so_seq )" ).append("\n"); 
		query.append("when matched then update set  d.tml_nod_cd = @[nod_cd]" ).append("\n"); 
		query.append("#if (${act_sts_mapg_cd} == 'VD')" ).append("\n"); 
		query.append(",d.vd_dt      = TO_DATE(@[act_dt],'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",d.log_upd_dt = sysdate" ).append("\n"); 

	}
}