/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PoolChassisHistoryDBDAOsearchPoolMnrHistoryDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2010.02.01 최민회
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

public class PoolChassisHistoryDBDAOsearchPoolMnrHistoryDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PoolChassisHistoryDBDAOsearchPoolMnrHistoryDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_pool_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.integration").append("\n"); 
		query.append("FileName : PoolChassisHistoryDBDAOsearchPoolMnrHistoryDataRSQL").append("\n"); 
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
		query.append("SELECT  A.VNDR_NM" ).append("\n"); 
		query.append(", A.VNDR_LOC_NM" ).append("\n"); 
		query.append(", A.INV_NO" ).append("\n"); 
		query.append(", TO_CHAR(A.INV_CRE_DT ,'YYYY-MM-DD') INV_CRE_DT" ).append("\n"); 
		query.append(", A.CHSS_NO" ).append("\n"); 
		query.append(", DECODE(B.EQ_NO,NULL,'N','Y') MST_CHK" ).append("\n"); 
		query.append(", TO_CHAR(A.RPR_RQST_DT,'YYYY-MM-DD') RPR_RQST_DT" ).append("\n"); 
		query.append(", TO_CHAR(A.RPR_CMPL_DT,'YYYY-MM-DD') RPR_CMPL_DT" ).append("\n"); 
		query.append(", A.CHSS_CMPO_NM" ).append("\n"); 
		query.append(", A.CHSS_LOC_NM" ).append("\n"); 
		query.append(", A.DMG_DESC" ).append("\n"); 
		query.append(", A.RPR_DESC" ).append("\n"); 
		query.append(", A.SPL_CMPO_TP_CD" ).append("\n"); 
		query.append(", A.RPR_INSP_TP_DESC" ).append("\n"); 
		query.append(", A.RPR_HRS" ).append("\n"); 
		query.append(", A.LBR_COST_AMT" ).append("\n"); 
		query.append(", A.MTRL_COST_AMT" ).append("\n"); 
		query.append(", A.TAX_AMT" ).append("\n"); 
		query.append(", A.COST_TTL_AMT" ).append("\n"); 
		query.append("FROM CGM_POOL_MAINT_RPR_HIS A" ).append("\n"); 
		query.append(",CGM_EQUIPMENT B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.CHSS_NO  = B.EQ_NO(+)" ).append("\n"); 
		query.append("AND ( A.CHSS_POOL_CD =  @[chss_pool_cd] OR   B.CHSS_POOL_CD =  @[chss_pool_cd] )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${sort} == '0'  )" ).append("\n"); 
		query.append("AND A.INV_CRE_DT BETWEEN  TO_DATE(@[mvmt_dt_fr],'RRRR-MM' ) AND  ADD_MONTHS(TO_DATE(@[mvmt_dt_to]   ,'RRRR-MM' ),1)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.RPR_RQST_DT BETWEEN  TO_DATE(@[mvmt_dt_fr],'YYYY-MM-DD' ) AND  TO_DATE(@[mvmt_dt_to],'YYYY-MM-DD' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}