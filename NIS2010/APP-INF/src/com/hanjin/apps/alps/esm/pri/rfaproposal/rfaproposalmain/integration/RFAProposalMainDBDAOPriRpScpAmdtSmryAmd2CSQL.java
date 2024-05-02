/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFAProposalMainDBDAOPriRpScpAmdtSmryAmd2CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAOPriRpScpAmdtSmryAmd2CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Summary에 IHC(73)가 없는 경우 IHC 추가
	  * </pre>
	  */
	public RFAProposalMainDBDAOPriRpScpAmdtSmryAmd2CSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAOPriRpScpAmdtSmryAmd2CSQL").append("\n"); 
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
		query.append("MERGE INTO PRI_RP_SCP_AMDT_SMRY A" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("    SELECT A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("      FROM PRI_RP_SCP_AMDT_SMRY A, COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("     WHERE PROP_NO	 = @[prop_no]" ).append("\n"); 
		query.append("       AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("       AND INTG_CD_ID = 'CD01740'" ).append("\n"); 
		query.append("       AND INTG_CD_VAL_CTNT = '73' -- IHC" ).append("\n"); 
		query.append("       AND PROP_SCP_TERM_TP_CD IN ('71', '73')" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("    A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("AND A.PROP_SCP_TERM_TP_CD = B.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("-- IHC가 없는 경우" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("    A.PROP_NO," ).append("\n"); 
		query.append("    A.AMDT_SEQ," ).append("\n"); 
		query.append("    A.SVC_SCP_CD," ).append("\n"); 
		query.append("    A.PROP_SCP_TERM_TP_CD," ).append("\n"); 
		query.append("    A.AMDT_FLG," ).append("\n"); 
		query.append("    A.ACPT_FLG," ).append("\n"); 
		query.append("    A.CRE_USR_ID," ).append("\n"); 
		query.append("    A.CRE_DT," ).append("\n"); 
		query.append("    A.UPD_USR_ID," ).append("\n"); 
		query.append("    A.UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    B.PROP_NO," ).append("\n"); 
		query.append("    B.AMDT_SEQ+1," ).append("\n"); 
		query.append("    B.SVC_SCP_CD," ).append("\n"); 
		query.append("    '73'," ).append("\n"); 
		query.append("    'N'," ).append("\n"); 
		query.append("    'N'," ).append("\n"); 
		query.append("    @[cre_usr_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    @[upd_usr_id]," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}