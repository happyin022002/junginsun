/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : INVCommonDBDAOSearchLatestRateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.29 
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

public class INVCommonDBDAOSearchLatestRateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchLatestRate
	  * </pre>
	  */
	public INVCommonDBDAOSearchLatestRateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.invcommon.invcommon.integration").append("\n"); 
		query.append("FileName : INVCommonDBDAOSearchLatestRateRSQL").append("\n"); 
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
		query.append("SELECT SUM(O_INV_XCH_RT) O_INV_XCH_RT, SUM(I_INV_XCH_RT) AS I_INV_XCH_RT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT   MAX(INV_XCH_RT) KEEP (DENSE_RANK FIRST ORDER BY TO_DT DESC) AS O_INV_XCH_RT, 0 AS I_INV_XCH_RT" ).append("\n"); 
		query.append("FROM INV_CUST_AND_DLY_XCH_RT A   " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   A.LOCL_CURR_CD = @[from_curr_cd]" ).append("\n"); 
		query.append("AND   A.CHG_CURR_CD = @[to_curr_cd]" ).append("\n"); 
		query.append("AND   A.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("AND   A.CUST_CNT_CD ='XX'" ).append("\n"); 
		query.append("AND   A.CUST_SEQ = 0" ).append("\n"); 
		query.append("AND   NVL(A.XCH_RT_TP_CD,'V') = NVL('V','V')" ).append("\n"); 
		query.append("AND   A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   0, MAX(INV_XCH_RT) KEEP (DENSE_RANK FIRST ORDER BY TO_DT DESC) AS I_INV_XCH_RT" ).append("\n"); 
		query.append("FROM INV_CUST_AND_DLY_XCH_RT A   " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   A.LOCL_CURR_CD = @[from_curr_cd]" ).append("\n"); 
		query.append("AND   A.CHG_CURR_CD = @[to_curr_cd]" ).append("\n"); 
		query.append("AND   A.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("AND   A.CUST_CNT_CD ='XX'" ).append("\n"); 
		query.append("AND   A.CUST_SEQ = 0" ).append("\n"); 
		query.append("AND   NVL(A.XCH_RT_TP_CD,'V') = NVL('V','V')" ).append("\n"); 
		query.append("AND   A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append(") AA" ).append("\n"); 

	}
}