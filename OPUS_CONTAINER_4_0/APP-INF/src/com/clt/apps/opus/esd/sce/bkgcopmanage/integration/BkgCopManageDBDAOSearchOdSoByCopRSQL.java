/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchOdSoByCopRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.10
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.12.10 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchOdSoByCopRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COP No 로 OD-SO 를 조회한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchOdSoByCopRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchOdSoByCopRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("trsp_so_ofc_cty_cd," ).append("\n"); 
		query.append("trsp_so_seq," ).append("\n"); 
		query.append("cop_no," ).append("\n"); 
		query.append("cost_act_grp_seq" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("trs_trsp_svc_ord" ).append("\n"); 
		query.append("where cop_no = @[cop_no]" ).append("\n"); 
		query.append("and cost_act_grp_cd like 'OD%'" ).append("\n"); 
		query.append("and nvl(delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("trsp_so_ofc_cty_cd," ).append("\n"); 
		query.append("trsp_so_seq," ).append("\n"); 
		query.append("cop_no," ).append("\n"); 
		query.append("cost_act_grp_seq" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("trs_trsp_rail_bil_ord" ).append("\n"); 
		query.append("where cop_no = @[cop_no]" ).append("\n"); 
		query.append("and cost_act_grp_cd like 'OD%'" ).append("\n"); 
		query.append("and nvl(delt_flg, 'N') = 'N'" ).append("\n"); 

	}
}