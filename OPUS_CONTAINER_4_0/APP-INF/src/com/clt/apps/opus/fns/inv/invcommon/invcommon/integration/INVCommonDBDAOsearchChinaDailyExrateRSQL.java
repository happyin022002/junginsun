/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : INVCommonDBDAOsearchChinaDailyExrateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.invcommon.invcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class INVCommonDBDAOsearchChinaDailyExrateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INVCommonDBDAOsearchChinaDailyExrateRSQL
	  * </pre>
	  */
	public INVCommonDBDAOsearchChinaDailyExrateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lcl_curr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exrate_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sa_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.invcommon.invcommon.integration").append("\n"); 
		query.append("FileName : INVCommonDBDAOsearchChinaDailyExrateRSQL").append("\n"); 
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
		query.append("SELECT NVL(A.INV_XCH_RT, '0') EX_RATE" ).append("\n"); 
		query.append("FROM  INV_CUST_AND_DLY_XCH_RT A" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD = 'XX'" ).append("\n"); 
		query.append("AND   A.CUST_SEQ  = '0'" ).append("\n"); 
		query.append("AND   A.IO_BND_CD = @[bnd]" ).append("\n"); 
		query.append("AND   REPLACE(@[sa_dt],'-','') BETWEEN A.FM_DT AND A.TO_DT" ).append("\n"); 
		query.append("AND   A.CHG_CURR_CD = @[curr]" ).append("\n"); 
		query.append("AND   A.LOCL_CURR_CD = @[lcl_curr]" ).append("\n"); 
		query.append("AND   A.XCH_RT_TP_CD = @[exrate_type]" ).append("\n"); 
		query.append("AND   A.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 

	}
}