/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : IMDGJMSQueueEAIDAOScgImdgSubsRskLblVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.15
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2014.07.15 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Won, Jong-Kyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IMDGJMSQueueEAIDAOScgImdgSubsRskLblVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCG_IMDG_SUBS_RSK_LBL 조회
	  * </pre>
	  */
	public IMDGJMSQueueEAIDAOScgImdgSubsRskLblVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration").append("\n"); 
		query.append("FileName : IMDGJMSQueueEAIDAOScgImdgSubsRskLblVORSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("IMDG_UN_NO, IMDG_UN_NO_SEQ, IMDG_SUBS_RSK_LBL_CD, " ).append("\n"); 
		query.append("   CRE_USR_ID, CRE_DT, UPD_USR_ID, " ).append("\n"); 
		query.append("   UPD_DT, EAI_IF_FLG, EAI_EVNT_DT, " ).append("\n"); 
		query.append("   EAI_IF_ID" ).append("\n"); 
		query.append("FROM SCG_IMDG_SUBS_RSK_LBL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${ibflag} == 'D')" ).append("\n"); 
		query.append("	AND	IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("	AND	IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND EAI_IF_FLG is null" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}