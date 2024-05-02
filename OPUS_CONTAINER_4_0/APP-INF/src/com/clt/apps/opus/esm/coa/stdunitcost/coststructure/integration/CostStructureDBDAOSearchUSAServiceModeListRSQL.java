/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostStructureDBDAOSearchUSAServiceModeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.23
*@LastModifier : 김창헌
*@LastVersion : 1.0
* 2012.04.23 김창헌
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang Hun Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostStructureDBDAOSearchUSAServiceModeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchUSAServiceModeList
	  * </pre>
	  */
	public CostStructureDBDAOSearchUSAServiceModeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration").append("\n"); 
		query.append("FileName : CostStructureDBDAOSearchUSAServiceModeListRSQL").append("\n"); 
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
		query.append("SELECT /*+ index_asc(COA_USA_SVC_MOD XPKCOA_USA_SVC_MOD)*/ " ).append("\n"); 
		query.append("	ORG_RGN_CD," ).append("\n"); 
		query.append("	DEST_RGN_CD," ).append("\n"); 
		query.append("	SVC_MOD_CD" ).append("\n"); 
		query.append("FROM COA_USA_SVC_MOD" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${org_rgn_cd} != ''&& ${org_rgn_cd} !='All') " ).append("\n"); 
		query.append("	AND ORG_RGN_CD = @[org_rgn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dest_rgn_cd} != ''&& ${dest_rgn_cd} !='All') " ).append("\n"); 
		query.append("	AND DEST_RGN_CD = @[dest_rgn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${svc_mod_cd} != ''&& ${svc_mod_cd} !='All') " ).append("\n"); 
		query.append("	AND SVC_MOD_CD = @[svc_mod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}