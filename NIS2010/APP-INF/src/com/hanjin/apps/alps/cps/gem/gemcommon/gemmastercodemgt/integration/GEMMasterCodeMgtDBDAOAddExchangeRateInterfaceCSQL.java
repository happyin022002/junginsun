/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.04.29 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see 
 * @since J2EE 1.4
 */

public class GEMMasterCodeMgtDBDAOAddExchangeRateInterfaceCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 일반관리비 비용실적 집계시 USD , KRW , LCL 로 환산하기 위한 경리환율을 I/F 받아 생성한다
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOAddExchangeRateInterfaceCSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_xch_rt_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("insert into GEM_XCH_RT" ).append("\n"); 
		query.append("( ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append(",GEN_EXPN_XCH_RT_DIV_CD" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",USD_LOCL_XCH_RT" ).append("\n"); 
		query.append(",LOCL_KRW_XCH_RT" ).append("\n"); 
		query.append(",USD_KRW_XCH_RT" ).append("\n"); 
		query.append(",DELT_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("select ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append(",'M'" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",USD_LOCL_XCH_RT" ).append("\n"); 
		query.append(",LOCL_KRW_XCH_RT" ).append("\n"); 
		query.append(",USD_KRW_XCH_RT" ).append("\n"); 
		query.append(",DELT_FLG" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append("from GL_MON_XCH_RT" ).append("\n"); 
		query.append("where ACCT_XCH_RT_YRMON LIKE @[acct_xch_rt_yrmon] || '%'" ).append("\n"); 
		query.append("and ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("and DELT_FLG = 'N'" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.cps.gem.gemcommon.gemmastercodemgt.integration").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAOAddExchangeRateInterfaceCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}