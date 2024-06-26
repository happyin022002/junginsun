/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IncomeMgtDBDAOsearchReceivableInvSeqDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.09.23 함형석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.accountmanage.incomemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HamHyungSeok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IncomeMgtDBDAOsearchReceivableInvSeqDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IncomeMgtDBDAOsearchReceivableInvSeqDataRSQL
	  * </pre>
	  */
	public IncomeMgtDBDAOsearchReceivableInvSeqDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.accountmanage.incomemgt.integration").append("\n"); 
		query.append("FileName : IncomeMgtDBDAOsearchReceivableInvSeqDataRSQL").append("\n"); 
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
		query.append("SELECT MNR_RCV_INV_SEQ.NEXTVAL AS SEQ FROM DUAL" ).append("\n"); 

	}
}