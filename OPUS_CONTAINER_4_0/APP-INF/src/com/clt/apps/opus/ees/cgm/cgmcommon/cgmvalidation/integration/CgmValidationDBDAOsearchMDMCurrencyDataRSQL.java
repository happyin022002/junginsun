/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CgmValidationDBDAOsearchMDMCurrencyDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.09.17 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmValidationDBDAOsearchMDMCurrencyDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public CgmValidationDBDAOsearchMDMCurrencyDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.integration").append("\n"); 
		query.append("FileName : CgmValidationDBDAOsearchMDMCurrencyDataRSQL").append("\n"); 
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
		query.append("SELECT A.CURR_CD" ).append("\n"); 
		query.append(",A.CURR_NM" ).append("\n"); 
		query.append(",A.CURR_DESC" ).append("\n"); 
		query.append(",A.CNT_CD" ).append("\n"); 
		query.append(",A.FM_EFF_DT" ).append("\n"); 
		query.append(",A.TO_EFF_DT" ).append("\n"); 
		query.append(",A.DP_PRCS_KNT" ).append("\n"); 
		query.append(",A.XTD_PRCS_KNT" ).append("\n"); 
		query.append("FROM MDM_CURRENCY A" ).append("\n"); 
		query.append("WHERE A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND  A.CURR_CD =  @[curr_cd]" ).append("\n"); 

	}
}