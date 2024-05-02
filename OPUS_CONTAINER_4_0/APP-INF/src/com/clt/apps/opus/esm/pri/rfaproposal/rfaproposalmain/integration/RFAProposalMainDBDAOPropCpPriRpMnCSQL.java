/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RFAProposalMainDBDAOPropCpPriRpMnCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAOPropCpPriRpMnCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Proposal Copy PRI_SP_MN Insert
	  * </pre>
	  */
	public RFAProposalMainDBDAOPropCpPriRpMnCSQL(){
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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAOPropCpPriRpMnCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RP_MN (" ).append("\n"); 
		query.append("    PROP_NO" ).append("\n"); 
		query.append(",   AMDT_SEQ" ).append("\n"); 
		query.append(",   EFF_DT" ).append("\n"); 
		query.append(",   EXP_DT" ).append("\n"); 
		query.append(",   CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append(",   CTRT_CUST_SEQ" ).append("\n"); 
		query.append(",   PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append(",   PROP_SREP_CD" ).append("\n"); 
		query.append(",   PROP_OFC_CD" ).append("\n"); 
		query.append(",   PROP_APRO_OFC_CD" ).append("\n"); 
		query.append(",   PROP_STS_CD" ).append("\n"); 
		query.append(",   RESPB_SREP_CD" ).append("\n"); 
		query.append(",   RESPB_SLS_OFC_CD" ).append("\n"); 
		query.append(",   CNTR_LOD_UT_CD" ).append("\n"); 
		query.append(",   TGT_MVC_QTY" ).append("\n"); 
		query.append(",   CRE_USR_ID" ).append("\n"); 
		query.append(",   CRE_DT" ).append("\n"); 
		query.append(",   UPD_USR_ID" ).append("\n"); 
		query.append(",   UPD_DT" ).append("\n"); 
		query.append(",   TRF_CTRT_FLG" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[new_prop_no] AS PROP_NO" ).append("\n"); 
		query.append("     , 0 AS AMDT_SEQ" ).append("\n"); 
		query.append("     , TO_DATE('99991231', 'YYYYMMDD') AS EFF_DT" ).append("\n"); 
		query.append("     , TO_DATE('99991231', 'YYYYMMDD') AS EXP_DT" ).append("\n"); 
		query.append("     , RP.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("     , RP.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("     , (SELECT MD.CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("        FROM MDM_CUSTOMER MD" ).append("\n"); 
		query.append("        WHERE MD.CUST_CNT_CD = RP.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("        AND   MD.CUST_SEQ = RP.CTRT_CUST_SEQ) AS PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append("     , @[srep_cd] AS PROP_SREP_CD" ).append("\n"); 
		query.append("     , @[ofc_cd] AS PROP_OFC_CD" ).append("\n"); 
		query.append("     , RP.PROP_APRO_OFC_CD" ).append("\n"); 
		query.append("     , 'I' AS PROP_STS_CD" ).append("\n"); 
		query.append("     , (SELECT MD.SREP_CD" ).append("\n"); 
		query.append("        FROM MDM_CUSTOMER MD" ).append("\n"); 
		query.append("        WHERE MD.CUST_CNT_CD = RP.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("        AND   MD.CUST_SEQ = RP.CTRT_CUST_SEQ) AS RESPB_SREP_CD" ).append("\n"); 
		query.append("     , (SELECT MD.OFC_CD" ).append("\n"); 
		query.append("        FROM MDM_CUSTOMER MD" ).append("\n"); 
		query.append("        WHERE MD.CUST_CNT_CD = RP.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("        AND   MD.CUST_SEQ = RP.CTRT_CUST_SEQ) AS RESPB_SLS_OFC_CD" ).append("\n"); 
		query.append("     , RP.CNTR_LOD_UT_CD" ).append("\n"); 
		query.append("     , RP.TGT_MVC_QTY" ).append("\n"); 
		query.append("     , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("     , @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("     , CASE WHEN (SELECT CASE WHEN NVL(COUNT(*),0) <= 0  THEN 'N' ELSE 'Y' END ISROLE" ).append("\n"); 
		query.append("                    FROM COM_USR_ROLE_MTCH" ).append("\n"); 
		query.append("                   WHERE USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("                     AND USR_ROLE_CD = (SELECT ATTR_CTNT1" ).append("\n"); 
		query.append("                                          FROM PRI_PARA_CD_DTL" ).append("\n"); 
		query.append("                                         WHERE HRD_CDG_ID = 'PRICD0002')) = 'Y' THEN RP.TRF_CTRT_FLG" ).append("\n"); 
		query.append("            ELSE 'N'" ).append("\n"); 
		query.append("         END TRF_CTRT_FLG" ).append("\n"); 
		query.append("FROM PRI_RP_MN RP" ).append("\n"); 
		query.append("WHERE RP.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   RP.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 

	}
}