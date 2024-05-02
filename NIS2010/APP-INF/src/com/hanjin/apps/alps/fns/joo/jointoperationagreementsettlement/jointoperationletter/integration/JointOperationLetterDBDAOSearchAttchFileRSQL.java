/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationLetterDBDAOSearchAttchFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.10.26 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationLetterDBDAOSearchAttchFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JointOperationLetterDBDAOSearchAttchFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ltr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration ").append("\n"); 
		query.append("FileName : JointOperationLetterDBDAOSearchAttchFileRSQL").append("\n"); 
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
		query.append("SELECT    A.EML_SND_NO," ).append("\n"); 
		query.append("B.JO_LTR_SEQ," ).append("\n"); 
		query.append("B.FILE_SAV_ID," ).append("\n"); 
		query.append("(SELECT  S2.EML_FILE_PATH_URL_CTNT FROM COM_EML_SND_INFO S2 WHERE S2.EML_SND_NO = A.EML_SND_NO)" ).append("\n"); 
		query.append("EML_FILE_PATH_URL_CTNT," ).append("\n"); 
		query.append("B.CRE_DT," ).append("\n"); 
		query.append("B.CRE_USR_ID,--EML_FILE_PATH_URL_CTNT" ).append("\n"); 
		query.append("(SELECT S1.USR_NM FROM COM_USER S1 WHERE S1.USR_ID = B.CRE_USR_ID)USR_NM" ).append("\n"); 
		query.append("FROM    JOO_LETTER A," ).append("\n"); 
		query.append("JOO_LTR_ATCH_FILE B" ).append("\n"); 
		query.append("WHERE    A.JO_LTR_SEQ  = B.JO_LTR_SEQ" ).append("\n"); 
		query.append("AND    A.JO_LTR_SEQ = @[jo_ltr_seq]" ).append("\n"); 

	}
}