/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CodeManageDBDAOModifyCostCodeDeleteUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.18
*@LastModifier : 김용진
*@LastVersion : 1.0
* 2011.03.18 김용진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.codemanage.codemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KimYongJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodeManageDBDAOModifyCostCodeDeleteUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCostCodeDelete
	  * </pre>
	  */
	public CodeManageDBDAOModifyCostCodeDeleteUSQL(){
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
		query.append("FileName : CodeManageDBDAOModifyCostCodeDeleteUSQL").append("\n"); 
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
		query.append("--UPDATE TES_LGS_COST SET DELT_FLG ='Y' WHERE LGS_COST_CD = [lgs_cost_cd]" ).append("\n"); 
		query.append("DELETE TES_LGS_COST WHERE LGS_COST_CD = @[lgs_cost_cd]" ).append("\n"); 

	}
}