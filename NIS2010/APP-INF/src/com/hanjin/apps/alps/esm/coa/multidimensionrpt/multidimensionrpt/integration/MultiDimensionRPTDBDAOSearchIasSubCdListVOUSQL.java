/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MultiDimensionRPTDBDAOSearchIasSubCdListVOUSQL.java
*@FileTitle : IAS 협의체별 Scop 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.20
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.08.20 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MultiDimensionRPTDBDAOSearchIasSubCdListVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *       IAS 협의체별 Scop 관리(ESM_COA_0178)
	  * </pre>
	  */
	public MultiDimensionRPTDBDAOSearchIasSubCdListVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cd_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.integration").append("\n"); 
		query.append("FileName : MultiDimensionRPTDBDAOSearchIasSubCdListVOUSQL").append("\n"); 
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
		query.append("UPDATE COA_IAS_SUB" ).append("\n"); 
		query.append("  SET    CD_RMK     = @[cd_rmk]" ).append("\n"); 
		query.append("        ,UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("        ,UPD_DT     = sysdate" ).append("\n"); 
		query.append("  WHERE  IAS_SUB_CD = @[ias_sub_cd " ).append("\n"); 
		query.append("  AND    POL_CNT_CD = @[pol_cnt_cd " ).append("\n"); 
		query.append("  AND    POD_CNT_CD = @[pod_cnt_cd" ).append("\n"); 

	}
}