/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RASCommonDBDAOPriRatingUnitRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.12
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.07.12 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RASCommonDBDAOPriRatingUnitRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rating Unit Code 를 조회한다.
	  * </pre>
	  */
	public RASCommonDBDAOPriRatingUnitRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.integration").append("\n"); 
		query.append("FileName : RASCommonDBDAOPriRatingUnitRSQL").append("\n"); 
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
		query.append("SELECT  RAT_UT_CD   CD  ," ).append("\n"); 
		query.append("        RAT_UT_DESC NM" ).append("\n"); 
		query.append("FROM    PRI_RAT_UT" ).append("\n"); 
		query.append("WHERE   DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("        RAT_UT_CD" ).append("\n"); 

	}
}