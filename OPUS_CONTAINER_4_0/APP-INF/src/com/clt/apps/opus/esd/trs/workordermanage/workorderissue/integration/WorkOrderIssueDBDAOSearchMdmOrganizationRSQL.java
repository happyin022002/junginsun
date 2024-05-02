/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : WorkOrderIssueDBDAOSearchMdmOrganizationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.07
*@LastModifier : 
*@LastVersion : 1.0
* 2010.09.07 
* 1.0 Creation
* 1.1 2010.09.09 이재위 [SRM-201008617] [TRS] More candidate 조회 조건 수정 / (2) S/P select default 값 정정 요청 CSR
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderissue.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderIssueDBDAOSearchMdmOrganizationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Bill Currency 와 ContiCd 가져옴
	  * </pre>
	  */
	public WorkOrderIssueDBDAOSearchMdmOrganizationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderissue.integration ").append("\n"); 
		query.append("FileName : WorkOrderIssueDBDAOSearchMdmOrganizationRSQL").append("\n"); 
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
		query.append("SELECT A.BIL_CURR_CD, B.CONTI_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append(",MDM_LOCATION     B" ).append("\n"); 
		query.append("WHERE A.LOC_CD = B.LOC_CD(+)" ).append("\n"); 
		query.append("AND A.OFC_CD = @[ofc_cd]" ).append("\n"); 

	}
}