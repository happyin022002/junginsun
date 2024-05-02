/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ManualRegisterDBDAOSearchGetTPBDtlSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.12
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2010.07.12 변종건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Geon Byeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualRegisterDBDAOSearchGetTPBDtlSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TPB_OTS_DTL의 Seq
	  * </pre>
	  */
	public ManualRegisterDBDAOSearchGetTPBDtlSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.integration").append("\n"); 
		query.append("FileName : ManualRegisterDBDAOSearchGetTPBDtlSeqRSQL").append("\n"); 
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
		query.append("SELECT TPB_OTS_DTL_SEQ1.NEXTVAL AS OTS_DTL_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

	}
}