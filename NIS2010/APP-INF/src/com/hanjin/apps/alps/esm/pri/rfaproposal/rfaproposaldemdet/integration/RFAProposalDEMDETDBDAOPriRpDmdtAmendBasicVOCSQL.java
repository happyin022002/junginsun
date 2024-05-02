/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : RFAProposalDEMDETDBDAOPriRpDmdtAmendBasicVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.31
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposaldemdet.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalDEMDETDBDAOPriRpDmdtAmendBasicVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFAProposalDEMDETDBDAOPriRpDmdtAmendBasicVOCSQL.Query
	  * </pre>
	  */
	public RFAProposalDEMDETDBDAOPriRpDmdtAmendBasicVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("mst_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposaldemdet.integration").append("\n"); 
		query.append("FileName : RFAProposalDEMDETDBDAOPriRpDmdtAmendBasicVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RP_DMDT (" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append(" 	PROP_NO" ).append("\n"); 
		query.append(",	AMDT_SEQ" ).append("\n"); 
		query.append(",	DMDT_FT_TP_CD" ).append("\n"); 
		query.append(",	PRC_PROG_STS_CD" ).append("\n"); 
		query.append(",	SRC_INFO_CD" ).append("\n"); 
		query.append(",	ACPT_USR_ID" ).append("\n"); 
		query.append(",	ACPT_OFC_CD" ).append("\n"); 
		query.append(",	ACPT_DT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("WITH MASTER_RFA_INFO AS (" ).append("\n"); 
		query.append("    SELECT MN.PROP_NO, MAX(MN.AMDT_SEQ) AS AMDT_SEQ" ).append("\n"); 
		query.append("       FROM PRI_RP_MN MN, PRI_RP_DMDT DMDT" ).append("\n"); 
		query.append("      WHERE MN.PROP_NO = (SELECT PROP_NO FROM PRI_RP_HDR WHERE RFA_NO = @[mst_rfa_no]) -- Mst RFA No" ).append("\n"); 
		query.append("        AND MN.PROP_NO = DMDT.PROP_NO" ).append("\n"); 
		query.append("        AND MN.AMDT_SEQ = DMDT.AMDT_SEQ" ).append("\n"); 
		query.append("        AND PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("      GROUP BY MN.PROP_NO" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("BASIC_RFA_INFO AS (" ).append("\n"); 
		query.append("	SELECT PROP_NO, AMDT_SEQ" ).append("\n"); 
		query.append("	  FROM PRI_RP_DMDT" ).append("\n"); 
		query.append("	 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("	   AND AMDT_SEQ =  @[amdt_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT B.PROP_NO" ).append("\n"); 
		query.append("	  ,B.AMDT_SEQ + 1" ).append("\n"); 
		query.append("	  ,M.DMDT_FT_TP_CD" ).append("\n"); 
		query.append("	,DECODE(M.SRC_INFO_CD, 'AM', 'I', 'AD', 'I', M.PRC_PROG_STS_CD)" ).append("\n"); 
		query.append("	,M.SRC_INFO_CD" ).append("\n"); 
		query.append("    	,B.ACPT_USR_ID" ).append("\n"); 
		query.append("    	,B.ACPT_OFC_CD" ).append("\n"); 
		query.append("    	,B.ACPT_DT" ).append("\n"); 
		query.append("	  , @[cre_usr_id] " ).append("\n"); 
		query.append("	  ,SYSDATE " ).append("\n"); 
		query.append("	  ,@[upd_usr_id]" ).append("\n"); 
		query.append("	  ,SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 ,	CASE	WHEN M.SRC_INFO_CD IN ('AM', 'AD') THEN B.AMDT_SEQ+1 " ).append("\n"); 
		query.append("			ELSE B.AMDT_SEQ " ).append("\n"); 
		query.append("		END AS N1ST_CMNC_AMDT_SEQ " ).append("\n"); 
		query.append(" FROM MASTER_RFA_INFO MST_INFO," ).append("\n"); 
		query.append("       PRI_RP_DMDT M,-- Master" ).append("\n"); 
		query.append("       BASIC_RFA_INFO BSC_INFO," ).append("\n"); 
		query.append("       PRI_RP_DMDT B -- Basic" ).append("\n"); 
		query.append(" WHERE " ).append("\n"); 
		query.append("   -- Master" ).append("\n"); 
		query.append("       M.PROP_NO = MST_INFO.PROP_NO" ).append("\n"); 
		query.append("   AND M.AMDT_SEQ = MST_INFO.AMDT_SEQ" ).append("\n"); 
		query.append("   -- Basic" ).append("\n"); 
		query.append("   AND B.PROP_NO = BSC_INFO.PROP_NO" ).append("\n"); 
		query.append("   AND B.AMDT_SEQ = BSC_INFO.AMDT_SEQ" ).append("\n"); 

	}
}