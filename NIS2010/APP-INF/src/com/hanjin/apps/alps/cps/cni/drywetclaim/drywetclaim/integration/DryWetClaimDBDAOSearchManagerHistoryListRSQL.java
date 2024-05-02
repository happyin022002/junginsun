/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DryWetClaimDBDAOSearchManagerHistoryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.20
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2010.04.20 정행룡
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONG HAENG RYONG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DryWetClaimDBDAOSearchManagerHistoryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ManagerHistoryList
	  * </pre>
	  */
	public DryWetClaimDBDAOSearchManagerHistoryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dw_clm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration").append("\n"); 
		query.append("FileName : DryWetClaimDBDAOSearchManagerHistoryListRSQL").append("\n"); 
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
		query.append("    DW_CLM_NO" ).append("\n"); 
		query.append("  , DW_CLM_HIS_SEQ" ).append("\n"); 
		query.append("  , DW_CLM_STS_CD" ).append("\n"); 
		query.append("  , HDLR_USR_ID" ).append("\n"); 
		query.append("  , HDLR_OFC_CD" ).append("\n"); 
		query.append("  , UPD_USR_ID" ).append("\n"); 
		query.append("  , TO_CHAR (UPD_DT, 'YYYYMMDD') UPD_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    CNI_DW_CLM_HIS " ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("    DW_CLM_NO =@[dw_clm_no]" ).append("\n"); 
		query.append("    AND MGR_HDLR_DIV_CD = 'M'" ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("    DW_CLM_HIS_SEQ DESC" ).append("\n"); 

	}
}