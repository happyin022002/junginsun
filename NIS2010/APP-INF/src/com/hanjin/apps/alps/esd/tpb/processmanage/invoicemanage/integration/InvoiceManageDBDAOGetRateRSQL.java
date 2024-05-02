/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceManageDBDAOGetRateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2010.03.29 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOGetRateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getIndiaTaxInfo
	  * </pre>
	  */
	public InvoiceManageDBDAOGetRateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOGetRateRSQL").append("\n"); 
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
		query.append("SELECT ROUND((A.USD_LOCL_XCH_RT / B.USD_LOCL_XCH_RT),6) AS RATE" ).append("\n"); 
		query.append("FROM GL_MON_XCH_RT A," ).append("\n"); 
		query.append("GL_MON_XCH_RT B" ).append("\n"); 
		query.append("WHERE A.ACCT_XCH_RT_YRMON = REPLACE(SUBSTR(@[cre_dt],1,7),'-','')" ).append("\n"); 
		query.append("AND A.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("AND A.CURR_CD = ( SELECT AR_CURR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[user_ofc_cd])" ).append("\n"); 
		query.append("AND B.ACCT_XCH_RT_YRMON = REPLACE(SUBSTR(@[cre_dt],1,7),'-','')" ).append("\n"); 
		query.append("AND B.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("AND B.CURR_CD = @[chg_curr_cd]" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 

	}
}