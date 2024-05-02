/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InterfaceScheduleToIBISDBDAOVskPfSkdSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceScheduleToIBISDBDAOVskPfSkdSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSK_VSL_PF_SKD_IBIS_IF_SEQ 조회
	  * </pre>
	  */
	public InterfaceScheduleToIBISDBDAOVskPfSkdSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.integration").append("\n"); 
		query.append("FileName : InterfaceScheduleToIBISDBDAOVskPfSkdSeqRSQL").append("\n"); 
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
		query.append("SELECT VSK_PF_SKD_IBIS_IF_SEQ.NEXTVAL AS IBIS_IF_SEQ FROM DUAL" ).append("\n"); 

	}
}