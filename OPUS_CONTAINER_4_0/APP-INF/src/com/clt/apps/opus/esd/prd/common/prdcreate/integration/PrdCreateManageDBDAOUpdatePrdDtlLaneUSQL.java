/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PrdCreateManageDBDAOUpdatePrdDtlLaneUSQL.java
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

public class PrdCreateManageDBDAOUpdatePrdDtlLaneUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdatePrdDtlLane
	  * </pre>
	  */
	public PrdCreateManageDBDAOUpdatePrdDtlLaneUSQL(){
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
		query.append("FileName : PrdCreateManageDBDAOUpdatePrdDtlLaneUSQL").append("\n"); 
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
		query.append("MERGE INTO PRD_PROD_CTL_ROUT_DTL X" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("SELECT D.PCTL_NO,D.PCTL_SEQ,V.VSL_SLAN_CD" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL D,VSK_VSL_SKD V,MDM_VSL_SVC_LANE M" ).append("\n"); 
		query.append("WHERE PCTL_NO LIKE @[hd_pctl_no]||'%'" ).append("\n"); 
		query.append("AND D.VSL_CD=V.VSL_CD" ).append("\n"); 
		query.append("AND D.SKD_VOY_NO=V.SKD_VOY_NO" ).append("\n"); 
		query.append("AND D.SKD_DIR_CD=V.SKD_DIR_CD" ).append("\n"); 
		query.append("AND D.VSL_SLAN_CD <> V.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND M.VSL_SLAN_CD=V.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND M.VSL_SVC_TP_CD ='O' ) B" ).append("\n"); 
		query.append("ON (    X.PCTL_NO=B.PCTL_NO" ).append("\n"); 
		query.append("AND X.PCTL_SEQ=B.PCTL_SEQ)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET X.VSL_SLAN_CD = B.VSL_SLAN_CD" ).append("\n"); 

	}
}