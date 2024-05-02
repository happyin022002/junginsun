/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WorkOrderIssueDBDAOsearchWoIssuedSoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2009.09.21 양봉준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderIssueDBDAOsearchWoIssuedSoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchWoIssuedSoList
	  * </pre>
	  */
	public WorkOrderIssueDBDAOsearchWoIssuedSoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_prv_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_iss_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.integration ").append("\n"); 
		query.append("FileName : WorkOrderIssueDBDAOsearchWoIssuedSoListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ" ).append("\n"); 
		query.append("FROM   TRS_TRSP_WRK_ORD_PRV_TMP" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("#if (${wo_prv_grp_seq} == \"\")" ).append("\n"); 
		query.append("AND 1=2" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    WO_PRV_GRP_SEQ		= @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("AND    WO_ISS_NO			= @[wo_iss_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}