/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GEMCommonDBDAOModifyRsltSmryInitByYrmonUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.03.12 진윤오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMCommonDBDAOModifyRsltSmryInitByYrmonUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 누적 0 으로 초기화 해당 년월
	  * </pre>
	  */
	public GEMCommonDBDAOModifyRsltSmryInitByYrmonUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rslt_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.gem.gemcommon.gemcommon.integration").append("\n"); 
		query.append("FileName : GEMCommonDBDAOModifyRsltSmryInitByYrmonUSQL").append("\n"); 
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
		query.append("UPDATE GEM_RSLT_SMRY SET " ).append("\n"); 
		query.append("	SLP_PERF_AMT = 0" ).append("\n"); 
		query.append("WHERE	RSLT_YRMON = @[rslt_yrmon]" ).append("\n"); 
		query.append("AND   OFC_CO_DIV_CD = 'O'" ).append("\n"); 

	}
}