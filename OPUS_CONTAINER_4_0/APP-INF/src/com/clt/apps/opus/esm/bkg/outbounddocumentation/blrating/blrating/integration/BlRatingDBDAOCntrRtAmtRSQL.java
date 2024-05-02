/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BlRatingDBDAOCntrRtAmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.11.18 김영출
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOCntrRtAmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BlRatingDBDAOCntrRtAmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOCntrRtAmtRSQL").append("\n"); 
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
		query.append("SELECT CUST_TP, CURR_CD, sum(CHG_AMT) CHG_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT FRT_TERM_CD||nvl2(N3PTY_RCV_OFC_CD, 'Y', 'N') CUST_TP" ).append("\n"); 
		query.append(",      CURR_CD" ).append("\n"); 
		query.append(",      CHG_AMT" ).append("\n"); 
		query.append("FROM   BKG_CHG_RT" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY CUST_TP, CURR_CD" ).append("\n"); 

	}
}