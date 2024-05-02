/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOaddMstTempSequenceDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeCheckMgtDBDAOaddMstTempSequenceDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 시퀸스를 받아와 리턴한다.
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOaddMstTempSequenceDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.integration ").append("\n"); 
		query.append("FileName : GeneralCodeCheckMgtDBDAOaddMstTempSequenceDataRSQL").append("\n"); 
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
		query.append("SELECT EQR_CTRL_DAT_VRFY_SEQ.NEXTVAL AS SEQ FROM DUAL" ).append("\n"); 

	}
}