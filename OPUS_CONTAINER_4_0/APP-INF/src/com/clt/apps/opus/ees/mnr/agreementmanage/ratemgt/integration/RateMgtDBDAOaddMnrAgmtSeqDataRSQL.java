/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RateMgtDBDAOaddMnrAgmtSeqDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.06.23 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RateMgtDBDAOaddMnrAgmtSeqDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MnrAgmtSeq
	  * </pre>
	  */
	public RateMgtDBDAOaddMnrAgmtSeqDataRSQL(){
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
		query.append("SELECT MNR_AGMT_SEQ.NEXTVAL AS SEQ FROM DUAL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.integration").append("\n"); 
		query.append("FileName : RateMgtDBDAOaddMnrAgmtSeqDataRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}