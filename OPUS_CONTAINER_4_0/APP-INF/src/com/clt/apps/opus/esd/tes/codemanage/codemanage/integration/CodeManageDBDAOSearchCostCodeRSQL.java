/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodeManageDBDAOSearchCostCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 이정혜
*@LastVersion : 1.0
* 2009.11.18 이정혜
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.codemanage.codemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HARRY
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodeManageDBDAOSearchCostCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCostCode
	  * </pre>
	  */
	public CodeManageDBDAOSearchCostCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_subj_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_dtl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.codemanage.codemanage.integration ").append("\n"); 
		query.append("FileName : CodeManageDBDAOSearchCostCodeRSQL").append("\n"); 
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
		query.append("LGS_COST_CD" ).append("\n"); 
		query.append(", LGS_COST_FULL_NM" ).append("\n"); 
		query.append(", LGS_COST_OPT_NO" ).append("\n"); 
		query.append(", LGS_COST_RMK" ).append("\n"); 
		query.append(", DELT_FLG" ).append("\n"); 
		query.append(", TO_CHAR(UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("FROM TES_LGS_COST" ).append("\n"); 
		query.append("WHERE LGS_COST_CD IS NOT NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lgs_cost_subj_cd} != '')" ).append("\n"); 
		query.append("AND LGS_COST_SUBJ_CD = @[lgs_cost_subj_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lgs_cost_dtl_cd} != '')" ).append("\n"); 
		query.append("AND LGS_COST_DTL_CD = @[lgs_cost_dtl_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY LGS_COST_OPT_NO" ).append("\n"); 

	}
}