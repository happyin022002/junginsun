/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFARateProposalDBDAOPriRpScpRtScgAmdVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.11
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.01.11 공백진
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

public class RFARateProposalDBDAOPriRpScpRtScgAmdVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AMEND REQUEST
	  * </pre>
	  */
	public RFARateProposalDBDAOPriRpScpRtScgAmdVOCSQL(){
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
		query.append("FileName : RFARateProposalDBDAOPriRpScpRtScgAmdVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RP_SCP_RT_SCG(" ).append("\n"); 
		query.append("         SVC_SCP_CD" ).append("\n"); 
		query.append("        ,AMDT_SEQ" ).append("\n"); 
		query.append("        ,PROP_NO" ).append("\n"); 
		query.append("        ,CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        ,ROUT_SEQ" ).append("\n"); 
		query.append("        ,RT_SEQ" ).append("\n"); 
		query.append("        ,CHG_CD" ).append("\n"); 
		query.append("        ,BKG_RAT_UT_CD" ).append("\n"); 
		query.append("        ,CURR_CD" ).append("\n"); 
		query.append("        ,TRF_SCG_AMT" ).append("\n"); 
		query.append("        ,ADJ_SCG_AMT" ).append("\n"); 
		query.append("        ,ADJ_SCG_USD_AMT" ).append("\n"); 
		query.append("        ,TRF_SCG_RMK" ).append("\n"); 
		query.append("        ,TRF_ADJ_TP_CD" ).append("\n"); 
		query.append("        ,ADJ_FLG" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("        ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT   " ).append("\n"); 
		query.append("	     SCG.SVC_SCP_CD" ).append("\n"); 
		query.append("        ,SCG.AMDT_SEQ + 1" ).append("\n"); 
		query.append("        ,SCG.PROP_NO" ).append("\n"); 
		query.append("        ,SCG.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        ,SCG.ROUT_SEQ" ).append("\n"); 
		query.append("        ,SCG.RT_SEQ" ).append("\n"); 
		query.append("        ,SCG.CHG_CD" ).append("\n"); 
		query.append("        ,SCG.BKG_RAT_UT_CD" ).append("\n"); 
		query.append("        ,SCG.CURR_CD" ).append("\n"); 
		query.append("        ,SCG.TRF_SCG_AMT" ).append("\n"); 
		query.append("        ,SCG.ADJ_SCG_AMT" ).append("\n"); 
		query.append("        ,SCG.ADJ_SCG_USD_AMT" ).append("\n"); 
		query.append("        ,SCG.TRF_SCG_RMK" ).append("\n"); 
		query.append("        ,SCG.TRF_ADJ_TP_CD" ).append("\n"); 
		query.append("        ,SCG.ADJ_FLG" ).append("\n"); 
		query.append("        ,@[cre_usr_id]" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("        ,@[upd_usr_id]" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    PRI_RP_SCP_RT_SCG SCG" ).append("\n"); 
		query.append("	,PRI_RP_SCP_RT RT" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    SCG.PROP_NO     = @[prop_no]" ).append("\n"); 
		query.append("AND SCG.AMDT_SEQ    = @[amdt_seq]" ).append("\n"); 
		query.append("AND SCG.PROP_NO             = RT.PROP_NO" ).append("\n"); 
		query.append("AND SCG.AMDT_SEQ            = RT.AMDT_SEQ" ).append("\n"); 
		query.append("AND SCG.SVC_SCP_CD          = RT.SVC_SCP_CD" ).append("\n"); 
		query.append("AND SCG.CMDT_HDR_SEQ        = RT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND SCG.ROUT_SEQ            = RT.ROUT_SEQ" ).append("\n"); 
		query.append("AND SCG.RT_SEQ              = RT.RT_SEQ" ).append("\n"); 
		query.append("AND RT.SRC_INFO_CD          <> 'AD'" ).append("\n"); 

	}
}