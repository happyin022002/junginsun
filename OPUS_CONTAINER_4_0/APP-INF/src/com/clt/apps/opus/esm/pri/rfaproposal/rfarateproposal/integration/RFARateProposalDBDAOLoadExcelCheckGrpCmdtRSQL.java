/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFARateProposalDBDAOLoadExcelCheckGrpCmdtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.28
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2010.01.28 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAOLoadExcelCheckGrpCmdtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Group Commodity Check
	  * </pre>
	  */
	public RFARateProposalDBDAOLoadExcelCheckGrpCmdtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAOLoadExcelCheckGrpCmdtRSQL").append("\n"); 
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
		query.append("SELECT PRC_GRP_CMDT_CD AS CD" ).append("\n"); 
		query.append("      ,PRC_GRP_CMDT_DESC AS NM" ).append("\n"); 
		query.append("  FROM PRI_RP_SCP_GRP_CMDT A" ).append("\n"); 
		query.append(" WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND PRC_GRP_CMDT_CD = @[cd]" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("               FROM PRI_RP_SCP_GRP_CMDT_DTL S" ).append("\n"); 
		query.append("               WHERE S.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("               AND   S.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("               AND   S.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("               AND   S.GRP_CMDT_SEQ = A.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("               AND   S.SRC_INFO_CD <> 'AD')" ).append("\n"); 

	}
}