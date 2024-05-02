/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListGetSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.05
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2010.01.05 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListGetSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Temp table 에서 사용할 Sequence No 채번
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListGetSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListGetSeqRSQL").append("\n"); 
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
		query.append("SELECT TRS_TRSP_SVC_ORD_TMP_SEQ1.NEXTVAL SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}