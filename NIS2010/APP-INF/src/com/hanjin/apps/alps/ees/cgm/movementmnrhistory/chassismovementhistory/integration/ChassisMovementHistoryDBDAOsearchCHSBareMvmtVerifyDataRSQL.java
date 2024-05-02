/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMovementHistoryDBDAOsearchCHSBareMvmtVerifyDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.11.17 최민회
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

public class ChassisMovementHistoryDBDAOsearchCHSBareMvmtVerifyDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChassisMovementHistoryDBDAOsearchCHSBareMvmtVerifyDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_dt_day",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_dt_hd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.integration").append("\n"); 
		query.append("FileName : ChassisMovementHistoryDBDAOsearchCHSBareMvmtVerifyDataRSQL").append("\n"); 
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
		query.append("CASE" ).append("\n"); 
		query.append("WHEN   SYSDATE  < TO_DATE(@[mvmt_dt_day]||' '|| @[mvmt_dt_hd] ,'YYYY-MM-DD HH24:MI:SS')  THEN" ).append("\n"); 
		query.append("'The time is invalid.'" ).append("\n"); 
		query.append("WHEN  (( SELECT  COUNT(BB.CHSS_NO)" ).append("\n"); 
		query.append("FROM CGM_CHSS_MVMT_HIS BB" ).append("\n"); 
		query.append("WHERE BB.CHSS_NO = @[eq_no]" ).append("\n"); 
		query.append("AND  BB.MVMT_DT = TO_DATE(@[mvmt_dt_day]||' '||@[mvmt_dt_hd],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("AND  BB.YD_CD = @[dest_yd_cd]) >0)  THEN" ).append("\n"); 
		query.append("'Already data exists.'" ).append("\n"); 
		query.append("WHEN  ( (SELECT ACIAC_DIV_CD FROM CGM_EQUIPMENT" ).append("\n"); 
		query.append("WHERE EQ_NO =@[eq_no]) ='I') THEN" ).append("\n"); 
		query.append("'Chassis is inactive.'" ).append("\n"); 
		query.append("WHEN  ( (SELECT ACIAC_DIV_CD FROM CGM_EQUIPMENT" ).append("\n"); 
		query.append("WHERE EQ_NO =@[mgst_no]) ='I')" ).append("\n"); 
		query.append("THEN" ).append("\n"); 
		query.append("'M.G. Set is inactive.'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("'OK'" ).append("\n"); 
		query.append("END AS VERIFY" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}