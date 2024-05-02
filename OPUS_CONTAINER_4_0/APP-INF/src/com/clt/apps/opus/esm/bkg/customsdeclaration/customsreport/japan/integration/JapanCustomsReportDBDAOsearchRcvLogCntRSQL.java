/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanCustomsReportDBDAOsearchRcvLogCntRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.08.20 김승민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEUN GMIN KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanCustomsReportDBDAOsearchRcvLogCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchRcvLogCnt
	  * </pre>
	  */
	public JapanCustomsReportDBDAOsearchRcvLogCntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.integration").append("\n");
		query.append("FileName : JapanCustomsReportDBDAOsearchRcvLogCntRSQL").append("\n");
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
		query.append("COUNT('1') RCV_COUNT" ).append("\n");
		query.append("FROM" ).append("\n");
		query.append("BKG_CSTMS_JP_RCV_LOG" ).append("\n");
		query.append("WHERE JP_MSG_TP_ID LIKE 'MFR%'" ).append("\n");
		query.append("AND	VSL_CD IS NULL" ).append("\n");

	}
}