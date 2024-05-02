/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCRateProposalDBDAOLoadExcelCheckGrpLocRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.17
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2015.06.17 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAOLoadExcelCheckGrpLocRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Group Location Check
	  * </pre>
	  */
	public SCRateProposalDBDAOLoadExcelCheckGrpLocRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAOLoadExcelCheckGrpLocRSQL").append("\n"); 
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
		query.append("SELECT A.PRC_GRP_LOC_CD AS CD" ).append("\n"); 
		query.append("      ,A.PRC_GRP_LOC_DESC AS NM" ).append("\n"); 
		query.append("  FROM PRI_SP_SCP_GRP_LOC A" ).append("\n"); 
		query.append(" WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND PRC_GRP_LOC_CD = @[cd]" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("          FROM PRI_SP_SCP_GRP_LOC_DTL S" ).append("\n"); 
		query.append("         WHERE S.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("           AND S.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("           AND S.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND S.GRP_LOC_SEQ = A.GRP_LOC_SEQ" ).append("\n"); 
		query.append("           AND S.SRC_INFO_CD <> 'AD')" ).append("\n"); 

	}
}