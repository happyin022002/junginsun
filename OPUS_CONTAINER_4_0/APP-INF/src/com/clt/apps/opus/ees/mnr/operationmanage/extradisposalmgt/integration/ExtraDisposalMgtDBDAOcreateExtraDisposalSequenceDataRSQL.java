/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExtraDisposalMgtDBDAOcreateExtraDisposalSequenceDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.09.09 김완규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.extradisposalmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author WanGyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExtraDisposalMgtDBDAOcreateExtraDisposalSequenceDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Scrapping/Donation Creation 에서 Sequence 생성 조회
	  * </pre>
	  */
	public ExtraDisposalMgtDBDAOcreateExtraDisposalSequenceDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.extradisposalmgt.integration ").append("\n"); 
		query.append("FileName : ExtraDisposalMgtDBDAOcreateExtraDisposalSequenceDataRSQL").append("\n"); 
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
		query.append("SELECT MNR_XTRA_DISP_SEQ.NEXTVAL AS SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}