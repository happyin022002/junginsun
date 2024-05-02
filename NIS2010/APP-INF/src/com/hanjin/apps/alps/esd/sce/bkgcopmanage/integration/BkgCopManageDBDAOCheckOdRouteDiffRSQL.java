/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCopManageDBDAOCheckOdRouteDiffRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.30
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.12.30 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOCheckOdRouteDiffRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OD-SO 구간의 route 정보 중 틀린 구간이 존재할 경우 data 가 return 된다.
	  * </pre>
	  */
	public BkgCopManageDBDAOCheckOdRouteDiffRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOCheckOdRouteDiffRSQL").append("\n"); 
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
		query.append("select N1ST_NOD_CD," ).append("\n"); 
		query.append("  N2ND_NOD_CD," ).append("\n"); 
		query.append("  N3RD_NOD_CD," ).append("\n"); 
		query.append("  N4TH_NOD_CD," ).append("\n"); 
		query.append("  TRSP_MOD_CD," ).append("\n"); 
		query.append("  INLND_ROUT_INV_BIL_PATT_CD," ).append("\n"); 
		query.append("  INV_BIL_PATT_DIV_FLG," ).append("\n"); 
		query.append("  CTRL_OFC_CD" ).append("\n"); 
		query.append("from sce_pln_so_list" ).append("\n"); 
		query.append("where cop_no = @[fm_cop_no]" ).append("\n"); 
		query.append("  and cost_act_grp_cd like 'OD%'" ).append("\n"); 
		query.append("minus" ).append("\n"); 
		query.append("select N1ST_NOD_CD," ).append("\n"); 
		query.append("  N2ND_NOD_CD," ).append("\n"); 
		query.append("  N3RD_NOD_CD," ).append("\n"); 
		query.append("  N4TH_NOD_CD," ).append("\n"); 
		query.append("  TRSP_MOD_CD," ).append("\n"); 
		query.append("  INLND_ROUT_INV_BIL_PATT_CD," ).append("\n"); 
		query.append("  INV_BIL_PATT_DIV_FLG," ).append("\n"); 
		query.append("  CTRL_OFC_CD" ).append("\n"); 
		query.append("from sce_pln_so_list" ).append("\n"); 
		query.append("where cop_no = @[to_cop_no]" ).append("\n"); 
		query.append("  and cost_act_grp_cd like 'OD%'" ).append("\n"); 

	}
}