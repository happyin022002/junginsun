/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DryWetClaimDBDAOSearchRoeListVORSQL.java
*@FileTitle : Vessel Code & Particular Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.28 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DryWetClaimDBDAOSearchRoeListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 경리환율 정보를 조회한다
	  * </pre>
	  */
	public DryWetClaimDBDAOSearchRoeListVORSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration").append("\n"); 
		query.append("FileName : DryWetClaimDBDAOSearchRoeListVORSQL").append("\n"); 
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
		query.append("B.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append(",	B.CURR_CD" ).append("\n"); 
		query.append(",	A.CURR_NM" ).append("\n"); 
		query.append(",	TO_CHAR(B.USD_LOCL_XCH_RT,'FM999,990.00000') USD_LOCL_XCH_RT" ).append("\n"); 
		query.append(",	TO_CHAR(B.LOCL_KRW_XCH_RT,'FM999,990.00000') LOCL_KRW_XCH_RT" ).append("\n"); 
		query.append(",	TO_CHAR(B.USD_KRW_XCH_RT,'FM999,990.00000') USD_KRW_XCH_RT" ).append("\n"); 
		query.append(",	TO_CHAR(B.UPD_DT,'YYYYMMDD') UPD_DT" ).append("\n"); 
		query.append(",	TO_CHAR(B.CRE_DT,'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append("FROM MDM_CURRENCY A, GL_MON_XCH_RT B" ).append("\n"); 
		query.append("WHERE A.CURR_CD = B.CURR_CD" ).append("\n"); 
		query.append("AND	B.ACCT_XCH_RT_YRMON BETWEEN @[fm_dt] AND @[to_dt]" ).append("\n"); 
		query.append("AND	B.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("AND	B.CURR_CD LIKE @[curr_cd]||'%'" ).append("\n"); 
		query.append("AND	B.DELT_FLG = 'N'" ).append("\n"); 

	}
}