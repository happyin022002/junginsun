/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostStructureDBDAOModifyUSAServiceModeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.20
*@LastModifier : 김창헌
*@LastVersion : 1.0
* 2012.04.20 김창헌
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang Hun Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostStructureDBDAOModifyUSAServiceModeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyUSAServiceMode
	  * </pre>
	  */
	public CostStructureDBDAOModifyUSAServiceModeUSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration ").append("\n"); 
		query.append("FileName : CostStructureDBDAOModifyUSAServiceModeUSQL").append("\n"); 
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
		query.append("UPDATE COA_USA_SVC_MOD SET " ).append("\n"); 
		query.append("	SVC_MOD_CD = @[svc_mod_cd]," ).append("\n"); 
		query.append("	UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("	UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("	AND ORG_RGN_CD = @[org_rgn_cd]" ).append("\n"); 
		query.append("	AND DEST_RGN_CD = @[dest_rgn_cd]" ).append("\n"); 

	}
}