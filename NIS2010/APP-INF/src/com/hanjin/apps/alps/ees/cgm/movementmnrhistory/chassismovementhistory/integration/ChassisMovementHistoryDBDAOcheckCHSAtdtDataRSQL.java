/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMovementHistoryDBDAOcheckCHSAtdtDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.09.17 최민회
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

public class ChassisMovementHistoryDBDAOcheckCHSAtdtDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChassisMovementHistoryDBDAOcheckCHSAtdtDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.integration").append("\n"); 
		query.append("FileName : ChassisMovementHistoryDBDAOcheckCHSAtdtDataRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("SELECT  to_char( AA.ATCH_DT ,'yyyymmddHH24MIss') AS atch_dt" ).append("\n"); 
		query.append(", AA.DTCH_YD_CD AS dtch_yd_cd" ).append("\n"); 
		query.append(", AA.EQ_NO      AS eq_no" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.ATCH_DT" ).append("\n"); 
		query.append(", A.DTCH_YD_CD" ).append("\n"); 
		query.append(", A.EQ_NO" ).append("\n"); 
		query.append("FROM CGM_EQ_ATCH_DTCH_HIS A" ).append("\n"); 
		query.append("WHERE A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND  A.EQ_KND_CD = 'Z'" ).append("\n"); 
		query.append("ORDER BY A.ATCH_DT DESC" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append("WHERE ROWNUM =1" ).append("\n"); 

	}
}