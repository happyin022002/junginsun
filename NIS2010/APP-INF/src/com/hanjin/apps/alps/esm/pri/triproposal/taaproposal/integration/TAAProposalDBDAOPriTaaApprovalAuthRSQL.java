/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TAAProposalDBDAOPriTaaApprovalAuthRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.11
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2010.01.11 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TAAProposalDBDAOPriTaaApprovalAuthRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TAA 승인권한을 조회한다.
	  * </pre>
	  */
	public TAAProposalDBDAOPriTaaApprovalAuthRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.integration ").append("\n"); 
		query.append("FileName : TAAProposalDBDAOPriTaaApprovalAuthRSQL").append("\n"); 
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
		query.append("SELECT USR_ID" ).append("\n"); 
		query.append("FROM PRI_AUTHORIZATION" ).append("\n"); 
		query.append("WHERE PRC_CTRT_TP_CD = 'S'" ).append("\n"); 
		query.append("AND   SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   USR_ID = @[usr_id]" ).append("\n"); 
		query.append("AND   SYSDATE BETWEEN EFF_DT AND EXP_DT" ).append("\n"); 

	}
}