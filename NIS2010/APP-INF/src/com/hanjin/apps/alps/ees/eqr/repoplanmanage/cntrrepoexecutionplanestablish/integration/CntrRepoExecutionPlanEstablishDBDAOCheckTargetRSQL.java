/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOCheckTargetRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.11.17 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoExecutionPlanEstablishDBDAOCheckTargetRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vol Change된 Bkg의 테이블 찾기
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOCheckTargetRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOCheckTargetRSQL").append("\n"); 
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
		query.append("SELECT	 GUBUN" ).append("\n"); 
		query.append(",CHK" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT	'V' AS GUBUN, DECODE(COUNT(*),0,'N','Y') CHK" ).append("\n"); 
		query.append("FROM	EQR_VSL_LODG_DCHG_EXE_PLN" ).append("\n"); 
		query.append("WHERE	MTY_BKG_NO  = @[mty_bkg_no]" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT	'W' AS GUBUN, DECODE(COUNT(*),0,'N','Y') CHK" ).append("\n"); 
		query.append("FROM	EQR_INLND_TRSP_EXE_PLN" ).append("\n"); 
		query.append("WHERE	MTY_BKG_NO  = @[mty_bkg_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE	CHK = 'Y'" ).append("\n"); 

	}
}