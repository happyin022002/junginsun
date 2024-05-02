/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Edi324SendDBDAOGetSndSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.28
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi324send.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi324SendDBDAOGetSndSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Edi324SendDBDAOGetSndSeq
	  * </pre>
	  */
	public Edi324SendDBDAOGetSndSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi324send.integration ").append("\n"); 
		query.append("FileName : Edi324SendDBDAOGetSndSeqRSQL").append("\n"); 
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
		query.append("to_char(sysdate,'yymmdd')                           FF_YYMMDD" ).append("\n"); 
		query.append(",substr(to_char(sysdate,'yymmdd'),2,5)               FF_YMMDD" ).append("\n"); 
		query.append(",to_char(SCE_FLT_FILE_NO_GEN_SEQ1.NEXTVAL)           FF_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}