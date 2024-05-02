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

public class GEMMasterCodeMgtDBDAORemoveExchangeRateInterfaceDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 기존 I환율정보 년단위 삭제
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAORemoveExchangeRateInterfaceDSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("delete from gem_xch_rt" ).append("\n"); 
		query.append("where   acct_xch_rt_yrmon like @[acct_xch_rt_yrmon] || '%'" ).append("\n"); 
		query.append("and   GEN_EXPN_XCH_RT_DIV_CD = 'M'" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.cps.gem.gemcommon.gemmastercodemgt.integration").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAORemoveExchangeRateInterfaceDSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}