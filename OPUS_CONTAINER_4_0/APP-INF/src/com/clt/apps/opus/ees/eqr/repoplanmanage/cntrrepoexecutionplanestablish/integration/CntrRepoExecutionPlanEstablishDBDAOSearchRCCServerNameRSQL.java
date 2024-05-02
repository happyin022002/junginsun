/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOSearchRCCServerNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.15
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2015.09.15 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoExecutionPlanEstablishDBDAOSearchRCCServerNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COM_INTG_CD_DTL 테이블에서 특정 RCC 의 해당 서버네임 검색
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOSearchRCCServerNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_name",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOSearchRCCServerNameRSQL").append("\n"); 
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
		query.append("SELECT DECODE(SYS_AREA_GRP_ID, 'USA', 'DUS'" ).append("\n"); 
		query.append("                             , 'EUR', 'DEU'" ).append("\n"); 
		query.append("                             , 'SWA', 'DSW'" ).append("\n"); 
		query.append("                             , 'CHN', 'DCH'" ).append("\n"); 
		query.append("                             , 'DKR'" ).append("\n"); 
		query.append("             ) AS SERVERNAME" ).append("\n"); 
		query.append("FROM COM_SYS_AREA_GRP_ID " ).append("\n"); 
		query.append("WHERE CNT_CD    = SUBSTR(@[rcc_name], 1, 2)" ).append("\n"); 
		query.append("AND   ROWNUM    = 1" ).append("\n"); 

	}
}