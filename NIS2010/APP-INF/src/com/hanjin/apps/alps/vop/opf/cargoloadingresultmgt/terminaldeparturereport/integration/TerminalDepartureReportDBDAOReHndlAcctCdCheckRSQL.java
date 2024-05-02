/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOReHndlAcctCdCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.23
*@LastModifier : 
*@LastVersion : 1.0
* 2011.08.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOReHndlAcctCdCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ReHandling Account ( Carrier ) Code Check
	  * ===========================================================
	  * History
	  * 2011.08.16 김민아 [CHM-201112982] [TDR] R/H의 acct 관련 보완요청 : 모든 Reason에 대하여 Carrier code (3digits)로 선택 또는 입력 가능하도록 수정
	  *                                                                                      UNION ALL 'CUS', 'TML' 제거
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOReHndlAcctCdCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("account",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOReHndlAcctCdCheckRSQL").append("\n"); 
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
		query.append("SELECT	VAL, NAME" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("#if (${opr_cd} != '') " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 	CRR_CD	AS VAL," ).append("\n"); 
		query.append("		CRR_NM  AS NAME" ).append("\n"); 
		query.append("FROM  	MDM_CARRIER" ).append("\n"); 
		query.append("WHERE 	NVL(DELT_FLG, 'N') 	<> 	'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE	VAL = @[opr_cd]" ).append("\n"); 
		query.append("#elseif (${account} != '') " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 	CRR_CD	AS VAL," ).append("\n"); 
		query.append("		CRR_NM  AS NAME" ).append("\n"); 
		query.append("FROM  	MDM_CARRIER" ).append("\n"); 
		query.append("WHERE 	NVL(DELT_FLG, 'N') 	<> 	'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE	VAL = @[account]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}