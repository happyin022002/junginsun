/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchDiffRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.25
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.03.25 김인수
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

public class BkgCopManageDBDAOSearchDiffRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * planned s/o list 에서 cost_act_grp_cd, n1st_nod_cd, trsp_mod_cd, n1st_nod_cd, n2nd_nod_cd, n3rd_nod_cd, n4th_nod_cd
	  * 를 비교하여 destination cop 와 일치하지 않을 경우를 판단한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchDiffRouteRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchDiffRouteRSQL").append("\n"); 
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
		query.append("select cost_act_grp_cd," ).append("\n"); 
		query.append("cost_act_grp_seq," ).append("\n"); 
		query.append("trsp_mod_cd," ).append("\n"); 
		query.append("n1st_nod_cd," ).append("\n"); 
		query.append("n2nd_nod_cd," ).append("\n"); 
		query.append("n3rd_nod_cd," ).append("\n"); 
		query.append("n4th_nod_cd" ).append("\n"); 
		query.append("from sce_pln_so_list" ).append("\n"); 
		query.append("where cop_no = @[org_cop_no]" ).append("\n"); 
		query.append("and cost_act_grp_cd != 'COMN'" ).append("\n"); 
		query.append("union" ).append("\n"); 
		query.append("select cost_act_grp_cd," ).append("\n"); 
		query.append("cost_act_grp_seq," ).append("\n"); 
		query.append("trsp_mod_cd," ).append("\n"); 
		query.append("n1st_nod_cd," ).append("\n"); 
		query.append("n2nd_nod_cd," ).append("\n"); 
		query.append("n3rd_nod_cd," ).append("\n"); 
		query.append("n4th_nod_cd" ).append("\n"); 
		query.append("from sce_pln_so_list" ).append("\n"); 
		query.append("where cop_no = @[dest_cop_no]" ).append("\n"); 
		query.append("and cost_act_grp_cd != 'COMN'" ).append("\n"); 
		query.append("minus" ).append("\n"); 
		query.append("select cost_act_grp_cd," ).append("\n"); 
		query.append("cost_act_grp_seq," ).append("\n"); 
		query.append("trsp_mod_cd," ).append("\n"); 
		query.append("n1st_nod_cd," ).append("\n"); 
		query.append("n2nd_nod_cd," ).append("\n"); 
		query.append("n3rd_nod_cd," ).append("\n"); 
		query.append("n4th_nod_cd" ).append("\n"); 
		query.append("from sce_pln_so_list" ).append("\n"); 
		query.append("where cop_no = @[dest_cop_no]" ).append("\n"); 
		query.append("and cost_act_grp_cd != 'COMN'" ).append("\n"); 

	}
}