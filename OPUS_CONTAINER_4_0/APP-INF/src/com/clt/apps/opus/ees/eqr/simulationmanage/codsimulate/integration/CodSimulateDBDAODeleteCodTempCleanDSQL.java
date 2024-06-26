/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CodSimulateDBDAODeleteCodTempCleanDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.25
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.01.25 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodSimulateDBDAODeleteCodTempCleanDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * QTY가 없는 COD Temp를 삭제 하도록 기능 변경
	  * </pre>
	  */
	public CodSimulateDBDAODeleteCodTempCleanDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration ").append("\n"); 
		query.append("FileName : CodSimulateDBDAODeleteCodTempCleanDSQL").append("\n"); 
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
		query.append("DELETE FROM  EQR_VSL_LDIS_PLN_COD_TMP PLN" ).append("\n"); 
		query.append("WHERE PLN.REPO_PLN_ID = @[repo_pln_id] " ).append("\n"); 
		query.append("AND NOT EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                   FROM EQR_VSL_PLN_COD_QTY QTY" ).append("\n"); 
		query.append("                  WHERE PLN.REPO_PLN_ID = QTY.REPO_PLN_ID" ).append("\n"); 
		query.append("                    AND PLN.REPO_PLN_ID = QTY.REPO_PLN_ID" ).append("\n"); 
		query.append("                    AND PLN.PLN_YRWK    = QTY.PLN_YRWK" ).append("\n"); 
		query.append("                    AND PLN.PLN_SEQ       = QTY.PLN_SEQ)" ).append("\n"); 

	}
}