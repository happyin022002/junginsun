/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyCustomizedConditionDBDAOMonthlyCustomizedConditionTabLaneBoundSaveVO0163Tab02USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2010.02.23 주선영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.monthlycustomizedcondition.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ju Sun Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyCustomizedConditionDBDAOMonthlyCustomizedConditionTabLaneBoundSaveVO0163Tab02USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public MonthlyCustomizedConditionDBDAOMonthlyCustomizedConditionTabLaneBoundSaveVO0163Tab02USQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.basicdatamanage.monthlycustomizedcondition.integration").append("\n"); 
		query.append("FileName : MonthlyCustomizedConditionDBDAOMonthlyCustomizedConditionTabLaneBoundSaveVO0163Tab02USQL").append("\n"); 
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
		query.append("UPDATE SAQ_MON_DIR_CONV             " ).append("\n"); 
		query.append("   SET COND_STS_CD = @[cond_sts_cd]," ).append("\n"); 
		query.append("       UPD_USR_ID  = @[upd_usr_id], " ).append("\n"); 
		query.append("       UPD_DT      = SYSDATE        " ).append("\n"); 
		query.append(" WHERE BSE_YR      = @[bse_yr]      " ).append("\n"); 
		query.append("   AND BSE_QTR_CD  = @[bse_qtr_cd]" ).append("\n"); 

	}
}