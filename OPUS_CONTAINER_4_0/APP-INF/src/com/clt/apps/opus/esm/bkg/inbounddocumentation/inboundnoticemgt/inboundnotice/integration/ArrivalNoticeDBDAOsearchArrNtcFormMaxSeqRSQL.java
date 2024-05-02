/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ArrivalNoticeDBDAOsearchArrNtcFormMaxSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOsearchArrNtcFormMaxSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Get bkg_arr_ntc_wd max sequence
	  * </pre>
	  */
	public ArrivalNoticeDBDAOsearchArrNtcFormMaxSeqRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("SELECT /*+ INDEX_DESC(A XPKBKG_ARR_NTC_WD) */ NVL(MAX(AN_SEQ),0) AS AN_SEQ" ).append("\n"); 
		query.append("FROM BKG_ARR_NTC_WD A" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOsearchArrNtcFormMaxSeqRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}