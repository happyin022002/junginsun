/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodeManageDBDAOSearchCostCodeInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 이정혜
*@LastVersion : 1.0
* 2009.11.18 이정혜
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.codemanage.codemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HARRY
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodeManageDBDAOSearchCostCodeInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCostCodeInfo
	  * </pre>
	  */
	public CodeManageDBDAOSearchCostCodeInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.codemanage.codemanage.integration").append("\n"); 
		query.append("FileName : CodeManageDBDAOSearchCostCodeInfoRSQL").append("\n"); 
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
		query.append(", LGS_COST_SUBJ_CD" ).append("\n"); 
		query.append(", LGS_COST_DTL_CD" ).append("\n"); 
		query.append(", LGS_COST_CD_CLSS_LVL" ).append("\n"); 
		query.append(", LGS_COST_OPT_NO" ).append("\n"); 
		query.append(", LGS_COST_ABBR_NM" ).append("\n"); 
		query.append(", ACCT_CD" ).append("\n"); 
		query.append(", LGS_COST_RMK" ).append("\n"); 
		query.append(", THRP_FLG" ).append("\n"); 
		query.append(", CRR_ACCT_CD" ).append("\n"); 
		query.append(", DELT_FLG" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("FROM TES_LGS_COST" ).append("\n"); 
		query.append("WHERE LGS_COST_CD = @[lgs_cost_cd]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 

	}
}