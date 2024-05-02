/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PrdCreateManageDAODeletePrdMstNotPcNoDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.08.25 정선용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.common.prdcreate.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author sun yong Jung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCreateManageDBDAODeletePrdMstNotPcNoDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DeletePrdMstNotPcNo
	  * </pre>
	  */
	public PrdCreateManageDBDAODeletePrdMstNotPcNoDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.common.prdcreate.integration ").append("\n"); 
		query.append("FileName : PrdCreateManageDAODeletePrdMstNotPcNoDSQL").append("\n"); 
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
		query.append("DELETE FROM PRD_PROD_CTL_MST M" ).append("\n"); 
		query.append("WHERE NOT EXISTS" ).append("\n"); 
		query.append("(SELECT 'X' FROM PRD_PROD_CTL_ROUT_DTL D" ).append("\n"); 
		query.append("WHERE D.PCTL_NO = M.PCTL_NO)" ).append("\n"); 
		query.append("AND PCTL_NO LIKE @[hd_pctl_no]||'%'" ).append("\n"); 

	}
}