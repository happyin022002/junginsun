/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOSearchEdi315FlatFileKeyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.12
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2010.05.12 오현경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Oh hyun-kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchEdi315FlatFileKeyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search flat file key
	  * </pre>
	  */
	public Edi315SendDBDAOSearchEdi315FlatFileKeyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchEdi315FlatFileKeyRSQL").append("\n"); 
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
		query.append("select TO_CHAR(SYSDATE,'YYYYMMDD') AS EDI_SND_DT" ).append("\n"); 
		query.append(", TO_CHAR(SYSDATE,'HH24')  AS EDI_SND_HR" ).append("\n"); 
		query.append(", SCE_FLT_FILE_MSG_SEQ.NEXTVAL AS EDI_SND_SEQ" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}