/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SCRateProposalDBDAOPriSpScpRtCnoteVOForExlCSQLCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.12
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2016.10.12 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAOPriSpScpRtCnoteVOForExlCSQLCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Copy existed note to the new rates ( Horizontal )
	  * </pre>
	  */
	public SCRateProposalDBDAOPriSpScpRtCnoteVOForExlCSQLCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration ").append("\n"); 
		query.append("FileName : SCRateProposalDBDAOPriSpScpRtCnoteVOForExlCSQLCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SP_SCP_RT_CNOTE (" ).append("\n"); 
		query.append("    PROP_NO" ).append("\n"); 
		query.append("  , AMDT_SEQ" ).append("\n"); 
		query.append("  , SVC_SCP_CD" ).append("\n"); 
		query.append("  , GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("  , CMDT_HDR_SEQ" ).append("\n"); 
		query.append("  , CMDT_NOTE_SEQ" ).append("\n"); 
		query.append("  , NOTE_CLSS_CD" ).append("\n"); 
		query.append("  , CHG_CD" ).append("\n"); 
		query.append("  , NOTE_CTNT" ).append("\n"); 
		query.append("  , NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("  , NOTE_CHG_TP_CD" ).append("\n"); 
		query.append("  , PRC_PROG_STS_CD" ).append("\n"); 
		query.append("  , SRC_INFO_CD" ).append("\n"); 
		query.append("  , N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("  , ACPT_USR_ID" ).append("\n"); 
		query.append("  , ACPT_OFC_CD" ).append("\n"); 
		query.append("  , ACPT_DT" ).append("\n"); 
		query.append("  , CRE_USR_ID" ).append("\n"); 
		query.append("  , CRE_DT" ).append("\n"); 
		query.append("  , UPD_USR_ID" ).append("\n"); 
		query.append("  , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT PROP_NO" ).append("\n"); 
		query.append("  , AMDT_SEQ" ).append("\n"); 
		query.append("  , SVC_SCP_CD" ).append("\n"); 
		query.append("  , GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("  , CMDT_HDR_SEQ" ).append("\n"); 
		query.append("  , CMDT_NOTE_SEQ" ).append("\n"); 
		query.append("  , NOTE_CLSS_CD" ).append("\n"); 
		query.append("  , CHG_CD" ).append("\n"); 
		query.append("  , NOTE_CTNT" ).append("\n"); 
		query.append("  , TO_SINGLE_BYTE(SYS_GUID()) AS NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("  , NOTE_CHG_TP_CD" ).append("\n"); 
		query.append("  , 'I' AS PRC_PROG_STS_CD" ).append("\n"); 
		query.append("  , 'NW' AS SRC_INFO_CD" ).append("\n"); 
		query.append("  , @[amdt_seq] AS N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("  , '' AS ACPT_USR_ID" ).append("\n"); 
		query.append("  , '' AS ACPT_OFC_CD" ).append("\n"); 
		query.append("  , '' AS ACPT_DT" ).append("\n"); 
		query.append("  , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("  , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("  , @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("  , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append(" FROM PRI_SP_SCP_RT_CNOTE" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("  AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("  AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("  AND GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("  AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 

	}
}