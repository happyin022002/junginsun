/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOSearchTrunkVesselAndFeederCntrRepoPlanBKGINFORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.10.16 이행지
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

public class CntrRepoExecutionPlanEstablishDBDAOSearchTrunkVesselAndFeederCntrRepoPlanBKGINFORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PAST PLAN SPLIT BOOKING 기본 정보 조회
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOSearchTrunkVesselAndFeederCntrRepoPlanBKGINFORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_bkgno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOSearchTrunkVesselAndFeederCntrRepoPlanBKGINFORSQL").append("\n"); 
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
		query.append("SELECT	 DISTINCT EXE_PLN.CO_CD" ).append("\n"); 
		query.append(",EXE_PLN.FM_YD_CD" ).append("\n"); 
		query.append(",TO_CHAR(EXE_PLN.FM_ETD_DT,'YYYY-MM-DD HH24:MI:SS') ETD" ).append("\n"); 
		query.append("--,TO_CHAR(EXE_PLN.TO_ETB_DT,'YYYY-MM-DD HH24:MI:SS') ETB" ).append("\n"); 
		query.append("#foreach( ${key} in ${arrtpsz})" ).append("\n"); 
		query.append(",NVL(SUM(DECODE(EXE_QTY.CNTR_TPSZ_CD, '${key}', EXE_QTY.PLN_UC_AMT)),0)			${key}UNITCOST --HIDDEN" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#foreach( ${key} in ${arrtpsz})" ).append("\n"); 
		query.append(",NVL(SUM(DECODE(EXE_QTY.CNTR_TPSZ_CD, '${key}', EXE_QTY.LODG_PORT_UC_AMT)),0)	${key}FROMCOST --HIDDEN" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#foreach( ${key} in ${arrtpsz})" ).append("\n"); 
		query.append(",NVL(SUM(DECODE(EXE_QTY.CNTR_TPSZ_CD, '${key}', EXE_QTY.DCHG_PORT_UC_AMT)),0)	${key}TOCOST   --HIDDEN" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM	 EQR_VSL_LODG_DCHG_EXE_PLN	EXE_PLN" ).append("\n"); 
		query.append(",EQR_VSL_EXE_PLN_QTY		EXE_QTY" ).append("\n"); 
		query.append("WHERE	EXE_PLN.REPO_PLN_ID			= EXE_QTY.REPO_PLN_ID" ).append("\n"); 
		query.append("AND	EXE_PLN.PLN_YRWK			= EXE_QTY.PLN_YRWK" ).append("\n"); 
		query.append("AND	EXE_PLN.PLN_SEQ				= EXE_QTY.PLN_SEQ" ).append("\n"); 
		query.append("AND	EXE_PLN.MTY_BKG_NO			= @[search_bkgno]" ).append("\n"); 
		query.append("AND	EXE_PLN.SPLIT_REPO_PLN_FLG	= 'N'" ).append("\n"); 
		query.append("GROUP BY EXE_PLN.CO_CD" ).append("\n"); 
		query.append(",EXE_PLN.FM_YD_CD" ).append("\n"); 
		query.append(",TO_CHAR(EXE_PLN.FM_ETD_DT,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",TO_CHAR(EXE_PLN.TO_ETB_DT,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 

	}
}