/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMovementHistoryDBDAOsearchCgmEqAtchDtchHisDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.09.24 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMovementHistoryDBDAOsearchCgmEqAtchDtchHisDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChassisMovementHistoryDBDAOsearchCgmEqAtchDtchHisDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.integration").append("\n"); 
		query.append("FileName : ChassisMovementHistoryDBDAOsearchCgmEqAtchDtchHisDataRSQL").append("\n"); 
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
		query.append("SELECT A.EQ_NO" ).append("\n"); 
		query.append(", A.CNTR_NO" ).append("\n"); 
		query.append(", A.ATCH_YD_CD" ).append("\n"); 
		query.append(", TO_CHAR(A.ATCH_DT,'YYYYMMDDHH24MISS' ) ATCH_DT" ).append("\n"); 
		query.append(", A.DTCH_YD_CD" ).append("\n"); 
		query.append(", TO_CHAR(A.DTCH_DT,'YYYYMMDDHH24MISS' ) DTCH_DT" ).append("\n"); 
		query.append(", LAG(A.DTCH_YD_CD) OVER (ORDER BY A.EQ_NO, TO_CHAR(A.ATCH_DT,'YYYYMMDDHH24MISS' )) LAG_DT_YD" ).append("\n"); 
		query.append(", LAG(TO_CHAR(A.DTCH_DT,'YYYYMMDDHH24MISS' )) OVER (ORDER BY A.EQ_NO, TO_CHAR(A.ATCH_DT,'YYYYMMDDHH24MISS' )) LAG_DT" ).append("\n"); 
		query.append(", LEAD(A.ATCH_YD_CD) OVER (ORDER BY A.EQ_NO, TO_CHAR(A.ATCH_DT,'YYYYMMDDHH24MISS' )) LEAD_DT_YD" ).append("\n"); 
		query.append(", LEAD(TO_CHAR(A.ATCH_DT,'YYYYMMDDHH24MISS' )) OVER (ORDER BY A.EQ_NO, TO_CHAR(A.ATCH_DT,'YYYYMMDDHH24MISS' )) LEAD_DT" ).append("\n"); 
		query.append("FROM CGM_EQ_ATCH_DTCH_HIS A" ).append("\n"); 
		query.append("WHERE A.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("AND  A.ATCH_DT  = TO_DATE(@[atch_dt] ,'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("ORDER BY A.ATCH_DT" ).append("\n"); 

	}
}