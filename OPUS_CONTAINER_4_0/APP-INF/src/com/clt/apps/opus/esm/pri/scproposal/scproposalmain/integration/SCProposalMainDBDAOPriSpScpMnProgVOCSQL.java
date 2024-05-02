/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCProposalMainDBDAOPriSpScpMnProgVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOPriSpScpMnProgVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCOPE 메인의 상태로 INSERT한다.
	  * </pre>
	  */
	public SCProposalMainDBDAOPriSpScpMnProgVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prog_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prog_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOPriSpScpMnProgVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SP_SCP_PROG (" ).append("\n"); 
		query.append("  PROP_NO" ).append("\n"); 
		query.append(", AMDT_SEQ" ).append("\n"); 
		query.append(", SVC_SCP_CD" ).append("\n"); 
		query.append(", PROP_SCP_PROG_SEQ" ).append("\n"); 
		query.append(", PROP_SCP_STS_CD" ).append("\n"); 
		query.append(", PROG_USR_ID" ).append("\n"); 
		query.append(", PROG_OFC_CD" ).append("\n"); 
		query.append(", PROG_DT" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT /*+INDEX_DESC(PRI_SP_SCP_PROG XPKPRI_SP_SCP_PROG)*/" ).append("\n"); 
		query.append("    @[prop_no]                          ," ).append("\n"); 
		query.append("    @[amdt_seq]                         ," ).append("\n"); 
		query.append("    @[svc_scp_cd]                       ," ).append("\n"); 
		query.append("    NVL(MAX(PROP_SCP_PROG_SEQ)+1,1)     ," ).append("\n"); 
		query.append("    MAX((SELECT PROP_SCP_STS_CD" ).append("\n"); 
		query.append("    	 FROM   PRI_SP_SCP_MN" ).append("\n"); 
		query.append("    	 WHERE  PROP_NO    = @[prop_no]" ).append("\n"); 
		query.append("    	 AND    AMDT_SEQ   = @[amdt_seq]" ).append("\n"); 
		query.append("    	 AND    SVC_SCP_CD = @[svc_scp_cd]))," ).append("\n"); 
		query.append("    @[prog_usr_id]                  ," ).append("\n"); 
		query.append("    @[prog_ofc_cd]                  ," ).append("\n"); 
		query.append("    SYSDATE                         ," ).append("\n"); 
		query.append("    @[cre_usr_id]                   ," ).append("\n"); 
		query.append("    SYSDATE                         ," ).append("\n"); 
		query.append("    @[upd_usr_id]                   ," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    PRI_SP_SCP_PROG    " ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    PROP_NO  = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}