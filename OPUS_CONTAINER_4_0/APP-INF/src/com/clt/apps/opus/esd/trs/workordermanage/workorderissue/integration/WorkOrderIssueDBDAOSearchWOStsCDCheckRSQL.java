/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderIssueDBDAOSearchWOStsCDCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderIssueDBDAOSearchWOStsCDCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchWOStsCDCheck
	  * </pre>
	  */
	public WorkOrderIssueDBDAOSearchWOStsCDCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderissue.integration").append("\n"); 
		query.append("FileName : WorkOrderIssueDBDAOSearchWOStsCDCheckRSQL").append("\n"); 
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
		query.append("select count(*) CNT" ).append("\n"); 
		query.append("	from trs_trsp_svc_ord o" ).append("\n"); 
		query.append(" where o.trsp_wo_ofc_cty_cd =  @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("	and o.trsp_wo_seq = @[trsp_wo_seq]" ).append("\n"); 
		query.append("	and o.trsp_so_sts_cd NOT IN ('I', 'R')" ).append("\n"); 

	}
}