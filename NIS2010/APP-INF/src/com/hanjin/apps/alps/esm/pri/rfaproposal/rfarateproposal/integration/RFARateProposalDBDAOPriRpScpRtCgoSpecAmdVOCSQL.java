/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFARateProposalDBDAOPriRpScpRtCgoSpecAmdVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.03.15 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAOPriRpScpRtCgoSpecAmdVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AMEND REQUEST
	  * </pre>
	  */
	public RFARateProposalDBDAOPriRpScpRtCgoSpecAmdVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAOPriRpScpRtCgoSpecAmdVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RP_SCP_RT_CGO_SPEC(" ).append("\n"); 
		query.append("         PROP_NO" ).append("\n"); 
		query.append("        ,AMDT_SEQ" ).append("\n"); 
		query.append("        ,SVC_SCP_CD" ).append("\n"); 
		query.append("        ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        ,ROUT_SEQ" ).append("\n"); 
		query.append("        ,RT_SEQ" ).append("\n"); 
		query.append("        ,ACT_CGO_LEN" ).append("\n"); 
		query.append("        ,ACT_CGO_WDT" ).append("\n"); 
		query.append("        ,ACT_CGO_HGT" ).append("\n"); 
		query.append("        ,ACT_CGO_WGT" ).append("\n"); 
		query.append("        ,CGO_SPEC_RMK" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("        ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT   SPC.PROP_NO" ).append("\n"); 
		query.append("        ,SPC.AMDT_SEQ + 1" ).append("\n"); 
		query.append("        ,SPC.SVC_SCP_CD" ).append("\n"); 
		query.append("        ,SPC.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        ,SPC.ROUT_SEQ" ).append("\n"); 
		query.append("        ,SPC.RT_SEQ" ).append("\n"); 
		query.append("        ,SPC.ACT_CGO_LEN" ).append("\n"); 
		query.append("        ,SPC.ACT_CGO_WDT" ).append("\n"); 
		query.append("        ,SPC.ACT_CGO_HGT" ).append("\n"); 
		query.append("        ,SPC.ACT_CGO_WGT" ).append("\n"); 
		query.append("        ,SPC.CGO_SPEC_RMK" ).append("\n"); 
		query.append("        ,@[cre_usr_id]" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("        ,@[upd_usr_id]" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("FROM     PRI_RP_SCP_RT_CGO_SPEC SPC" ).append("\n"); 
		query.append("		,PRI_RP_SCP_RT RT" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    SPC.PROP_NO     = @[prop_no]" ).append("\n"); 
		query.append("AND SPC.AMDT_SEQ    = @[amdt_seq]" ).append("\n"); 
		query.append("AND SPC.PROP_NO             = RT.PROP_NO" ).append("\n"); 
		query.append("AND SPC.AMDT_SEQ            = RT.AMDT_SEQ" ).append("\n"); 
		query.append("AND SPC.SVC_SCP_CD          = RT.SVC_SCP_CD" ).append("\n"); 
		query.append("AND SPC.CMDT_HDR_SEQ        = RT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND SPC.ROUT_SEQ            = RT.ROUT_SEQ" ).append("\n"); 
		query.append("AND SPC.RT_SEQ              = RT.RT_SEQ" ).append("\n"); 
		query.append("AND RT.SRC_INFO_CD          <> 'AD'" ).append("\n"); 

	}
}