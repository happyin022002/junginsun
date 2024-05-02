/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOSearchCHSEqHistorySeqDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOSearchCHSEqHistorySeqDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetOnOffhireDB.SearchCHSEqHistorySeqData
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOSearchCHSEqHistorySeqDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOSearchCHSEqHistorySeqDataRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(EQ_STS_SEQ), 0) + 1 AS EQ_STS_SEQ " ).append("\n"); 
		query.append("FROM CGM_EQ_STS_HIS" ).append("\n"); 

	}
}