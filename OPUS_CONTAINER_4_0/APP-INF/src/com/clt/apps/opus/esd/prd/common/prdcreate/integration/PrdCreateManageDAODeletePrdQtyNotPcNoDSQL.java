/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PrdCreateManageDAODeletePrdQtyNotPcNoDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.09.09 정선용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author sun yong Jung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCreateManageDAODeletePrdQtyNotPcNoDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DeletePrdQtyNotPcNo
	  * </pre>
	  */
	public PrdCreateManageDAODeletePrdQtyNotPcNoDSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.prd.common.prdcreate.integration").append("\n"); 
		query.append("FileName : PrdCreateManageDAODeletePrdQtyNotPcNoDSQL").append("\n"); 
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
		query.append("DELETE FROM PRD_PROD_CTL_QTY Q" ).append("\n"); 
		query.append("WHERE NOT EXISTS" ).append("\n"); 
		query.append("(SELECT 'X' FROM PRD_PROD_CTL_ROUT_DTL D" ).append("\n"); 
		query.append("WHERE D.PCTL_NO = Q.PCTL_NO)" ).append("\n"); 
		query.append("AND PCTL_NO LIKE @[hd_pctl_no]||'%'" ).append("\n"); 

	}
}