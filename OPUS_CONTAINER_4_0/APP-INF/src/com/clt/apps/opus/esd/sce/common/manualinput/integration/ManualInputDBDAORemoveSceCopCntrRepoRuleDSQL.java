/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ManualInputDBDAORemoveSceCopCntrRepoRuleDSQL.java
*@FileTitle : SCE_COP_CNTR_REPO_RULE Manage
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.24
*@LastModifier : 이준근
*@LastVersion : 1.0
* 2012.04.24 이준근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.common.manualinput.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LeeJunKun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualInputDBDAORemoveSceCopCntrRepoRuleDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RemoveSceCopCntrRepoRule
	  * </pre>
	  */
	public ManualInputDBDAORemoveSceCopCntrRepoRuleDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.common.manualinput.integration ").append("\n"); 
		query.append("FileName : ManualInputDBDAORemoveSceCopCntrRepoRuleDSQL").append("\n"); 
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
		query.append("DELETE SCE_COP_CNTR_REPO_RULE" ).append("\n"); 
		query.append(" WHERE CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 

	}
}