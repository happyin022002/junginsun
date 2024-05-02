/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PoolChassisHistoryDBDAOsearchPoolChsUseddaysFileStatusDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.27
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2010.01.27 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PoolChassisHistoryDBDAOsearchPoolChsUseddaysFileStatusDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PoolChassisHistoryDBDAOsearchPoolChsUseddaysFileStatusDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_pool_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.integration").append("\n"); 
		query.append("FileName : PoolChassisHistoryDBDAOsearchPoolChsUseddaysFileStatusDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.FILE_SEQ" ).append("\n"); 
		query.append(", A.ORG_FILE_NM" ).append("\n"); 
		query.append(", A.SAV_FILE_NM" ).append("\n"); 
		query.append(", A.CHSS_POOL_CD" ).append("\n"); 
		query.append(", A.COST_YRMON" ).append("\n"); 
		query.append(", A.FILE_IMP_PROC_STS_CD" ).append("\n"); 
		query.append(", B.INTG_CD_VAL_DP_DESC FILE_IMP_PROC_STS_NM" ).append("\n"); 
		query.append(", A.IMP_RSLT_DESC" ).append("\n"); 
		query.append(", to_char(A.FILE_IMP_DT,'yyyy-mm-dd hh24:mi:ss') FILE_IMP_DT" ).append("\n"); 
		query.append(", A.CRE_USR_ID" ).append("\n"); 
		query.append(", A.CRE_DT" ).append("\n"); 
		query.append(", A.UPD_USR_ID" ).append("\n"); 
		query.append(", A.UPD_DT" ).append("\n"); 
		query.append("FROM CGM_POOL_CHSS_IMP_FILE A" ).append("\n"); 
		query.append(", COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("WHERE B.INTG_CD_ID ='CD02552'" ).append("\n"); 
		query.append("AND A.FILE_IMP_PROC_STS_CD = B.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND A.CHSS_POOL_CD =  @[chss_pool_cd]" ).append("\n"); 
		query.append("AND A.COST_YRMON = @[cost_yrmon]" ).append("\n"); 

	}
}