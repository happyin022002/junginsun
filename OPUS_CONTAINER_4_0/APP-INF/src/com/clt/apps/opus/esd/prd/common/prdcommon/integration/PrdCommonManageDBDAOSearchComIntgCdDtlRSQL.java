/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PrdCommonManageDBDAOSearchComIntgCdDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCommonManageDBDAOSearchComIntgCdDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PrdCommonManageDBDAOSearchComIntgCdDtl
	  * </pre>
	  */
	public PrdCommonManageDBDAOSearchComIntgCdDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intg_cd_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.common.prdcommon.integration").append("\n"); 
		query.append("FileName : PrdCommonManageDBDAOSearchComIntgCdDtlRSQL").append("\n"); 
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
		query.append("select intg_cd_id" ).append("\n"); 
		query.append("			,intg_cd_val_ctnt" ).append("\n"); 
		query.append("			,intg_cd_val_dp_desc" ).append("\n"); 
		query.append("			,intg_cd_val_desc" ).append("\n"); 
		query.append("			,intg_cd_val_dp_seq" ).append("\n"); 
		query.append("			,aply_st_dt" ).append("\n"); 
		query.append("			,aply_end_dt" ).append("\n"); 
		query.append("			,cre_usr_id" ).append("\n"); 
		query.append("			,cre_dt" ).append("\n"); 
		query.append("			,upd_usr_id" ).append("\n"); 
		query.append("			,upd_dt" ).append("\n"); 
		query.append("			,intg_cd_val_eng_desc" ).append("\n"); 
		query.append("			,edw_upd_dt" ).append("\n"); 
		query.append("	from com_intg_cd_dtl" ).append("\n"); 
		query.append(" WHERE INTG_CD_ID = @[intg_cd_id]" ).append("\n"); 
		query.append(" ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}