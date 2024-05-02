/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SupplementSOManageDBDAOCreateNewSOSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.supplementsomanage.supplementsomanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SupplementSOManageDBDAOCreateNewSOSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 새로운 SO 시퀀스 값을 생성한다.
	  * </pre>
	  */
	public SupplementSOManageDBDAOCreateNewSOSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.supplementsomanage.supplementsomanage.integration ").append("\n"); 
		query.append("FileName : SupplementSOManageDBDAOCreateNewSOSeqRSQL").append("\n"); 
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
		query.append("SELECT	TRS_TRSP_SVC_ORD_SEQ1.NEXTVAL FROM DUAL" ).append("\n"); 

	}
}