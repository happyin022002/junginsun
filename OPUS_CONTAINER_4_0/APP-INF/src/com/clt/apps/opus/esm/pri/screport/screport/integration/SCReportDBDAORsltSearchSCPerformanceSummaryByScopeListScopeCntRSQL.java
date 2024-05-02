/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCReportDBDAORsltSearchSCPerformanceSummaryByScopeListScopeCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.11.11 김대호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author day-hoh Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltSearchSCPerformanceSummaryByScopeListScopeCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RsltSearchSCPerformanceSummaryByScopeListScopeCnt
	  * </pre>
	  */
	public SCReportDBDAORsltSearchSCPerformanceSummaryByScopeListScopeCntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltSearchSCPerformanceSummaryByScopeListScopeCntRSQL").append("\n"); 
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
		query.append("SELECT  COUNT(DISTINCT SS.SVC_SCP_CD) AS CNT" ).append("\n"); 
		query.append("FROM    PRI_SP_HDR          SH  ," ).append("\n"); 
		query.append("PRI_SP_SCP_MN       SS" ).append("\n"); 
		query.append("WHERE   SH.PROP_NO  = SS.PROP_NO" ).append("\n"); 
		query.append("AND     SH.SC_NO	LIKE @[sc_no] || '%'   -- S/C No" ).append("\n"); 

	}
}