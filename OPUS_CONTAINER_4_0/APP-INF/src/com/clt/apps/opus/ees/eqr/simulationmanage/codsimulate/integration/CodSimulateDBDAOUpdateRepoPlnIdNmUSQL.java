/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CodSimulateDBDAOUpdateRepoPlnIdNmUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodSimulateDBDAOUpdateRepoPlnIdNmUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 신규 Repo Plan 제목 수정시에 EQR_EQ_REPO_PLN의 REPO_PLN_RMK 정보를 업데이트한다.
	  * </pre>
	  */
	public CodSimulateDBDAOUpdateRepoPlnIdNmUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration").append("\n"); 
		query.append("FileName : CodSimulateDBDAOUpdateRepoPlnIdNmUSQL").append("\n"); 
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
		query.append("UPDATE EQR_EQ_REPO_PLN PN" ).append("\n"); 
		query.append("   SET PN.REPO_PLN_RMK = DECODE(TRIM(@[repo_pln_rmk]), NULL, 'Created by '||(SELECT CU.USR_NM||' ['||CU.OFC_CD||']' " ).append("\n"); 
		query.append("                                                                            FROM COM_USER CU " ).append("\n"); 
		query.append("                                                                           WHERE CU.USR_ID = PN.CRE_USR_ID" ).append("\n"); 
		query.append("                                                                             AND ROWNUM = 1)" ).append("\n"); 
		query.append("                                            , @[repo_pln_rmk])," ).append("\n"); 
		query.append("       PN.UPD_USR_ID   = @[upd_usr_id]," ).append("\n"); 
		query.append("       PN.UPD_DT       = sysdate" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND PN.REPO_PLN_ID  = @[repo_pln_id]" ).append("\n"); 
		query.append("   AND PN.SCNR_ID      = @[scnr_id] " ).append("\n"); 

	}
}