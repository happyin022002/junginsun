/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScOftAutoRatingDBDAOSearchSurchargePercentBaseChargeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.11.06 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScOftAutoRatingDBDAOSearchSurchargePercentBaseChargeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ScOftAutoRatingDBDAOSearchSurchargePercentBaseChargeListRSQL
	  * </pre>
	  */
	public ScOftAutoRatingDBDAOSearchSurchargePercentBaseChargeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration ").append("\n"); 
		query.append("FileName : ScOftAutoRatingDBDAOSearchSurchargePercentBaseChargeListRSQL").append("\n"); 
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
		query.append("SELECT C.PCT_BSE_CD, C.CHG_CD, D.CNT" ).append("\n"); 
		query.append("FROM PRI_SCG_PCT_BSE_CHG C," ).append("\n"); 
		query.append("(SELECT PCT_BSE_CD PCT_BSE_CD, COUNT(PCT_BSE_CD) CNT" ).append("\n"); 
		query.append("FROM PRI_SCG_PCT_BSE_CHG" ).append("\n"); 
		query.append("GROUP BY PCT_BSE_CD) D" ).append("\n"); 
		query.append("WHERE C.PCT_BSE_CD = D.PCT_BSE_CD" ).append("\n"); 

	}
}