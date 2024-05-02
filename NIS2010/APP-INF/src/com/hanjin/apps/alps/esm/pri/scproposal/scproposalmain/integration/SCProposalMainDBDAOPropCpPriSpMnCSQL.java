/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCProposalMainDBDAOPropCpPriSpMnCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.25
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2010.05.25 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOPropCpPriSpMnCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Proposal Copy PRI_SP_MN Insert
	  * </pre>
	  */
	public SCProposalMainDBDAOPropCpPriSpMnCSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOPropCpPriSpMnCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SP_MN (" ).append("\n"); 
		query.append("    PROP_NO" ).append("\n"); 
		query.append("  , AMDT_SEQ" ).append("\n"); 
		query.append("  , EFF_DT" ).append("\n"); 
		query.append("  , EXP_DT" ).append("\n"); 
		query.append("  , PROP_SREP_CD" ).append("\n"); 
		query.append("  , PROP_OFC_CD" ).append("\n"); 
		query.append("  , PROP_APRO_OFC_CD" ).append("\n"); 
		query.append("  , PROP_STS_CD" ).append("\n"); 
		query.append("  , RESPB_SREP_CD" ).append("\n"); 
		query.append("  , RESPB_SLS_OFC_CD" ).append("\n"); 
		query.append("  , REAL_CUST_CNT_CD" ).append("\n"); 
		query.append("  , REAL_CUST_SEQ" ).append("\n"); 
		query.append("  , REAL_CUST_VAL_SGM_CD" ).append("\n"); 
		query.append("  , REAL_CUST_TP_CD" ).append("\n"); 
		query.append("  , REAL_CUST_SREP_CD" ).append("\n"); 
		query.append("  , REAL_CUST_SLS_OFC_CD" ).append("\n"); 
		query.append("  , RF_FLG" ).append("\n"); 
		query.append("  , GAMT_FLG" ).append("\n"); 
		query.append("  , CRE_USR_ID" ).append("\n"); 
		query.append("  , CRE_DT" ).append("\n"); 
		query.append("  , UPD_USR_ID" ).append("\n"); 
		query.append("  , UPD_DT)" ).append("\n"); 
		query.append("SELECT @[new_prop_no] AS PROP_NO" ).append("\n"); 
		query.append("     , 0 AS AMDT_SEQ" ).append("\n"); 
		query.append("     , TO_DATE('99991231', 'YYYYMMDD') AS EFF_DT" ).append("\n"); 
		query.append("     , TO_DATE('99991231', 'YYYYMMDD') AS EXP_DT" ).append("\n"); 
		query.append("     , @[srep_cd] AS PROP_SREP_CD" ).append("\n"); 
		query.append("     , @[ofc_cd] AS PROP_OFC_CD" ).append("\n"); 
		query.append("     , MN.PROP_APRO_OFC_CD" ).append("\n"); 
		query.append("     , 'I' AS PROP_STS_CD" ).append("\n"); 
		query.append("     , DECODE(MN.REAL_CUST_TP_CD, 'N', " ).append("\n"); 
		query.append("              (SELECT MD.SREP_CD" ).append("\n"); 
		query.append("               FROM MDM_CUSTOMER MD" ).append("\n"); 
		query.append("               WHERE MD.CUST_CNT_CD = MN.REAL_CUST_CNT_CD" ).append("\n"); 
		query.append("               AND   MD.CUST_SEQ = MN.REAL_CUST_SEQ), " ).append("\n"); 
		query.append("              (SELECT MM.SREP_CD" ).append("\n"); 
		query.append("               FROM PRI_SP_CTRT_PTY PT" ).append("\n"); 
		query.append("                  , MDM_CUSTOMER MM" ).append("\n"); 
		query.append("               WHERE PT.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("               AND   PT.AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("               AND   PT.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("               AND   MM.CUST_CNT_CD = PT.CUST_CNT_CD" ).append("\n"); 
		query.append("               AND   MM.CUST_SEQ = PT.CUST_SEQ" ).append("\n"); 
		query.append("              )) AS RESPB_SREP_CD" ).append("\n"); 
		query.append("     , DECODE(MN.REAL_CUST_TP_CD, 'N', " ).append("\n"); 
		query.append("              (SELECT MD.OFC_CD" ).append("\n"); 
		query.append("               FROM MDM_CUSTOMER MD" ).append("\n"); 
		query.append("               WHERE MD.CUST_CNT_CD = MN.REAL_CUST_CNT_CD" ).append("\n"); 
		query.append("               AND   MD.CUST_SEQ = MN.REAL_CUST_SEQ), " ).append("\n"); 
		query.append("              (SELECT MM.OFC_CD " ).append("\n"); 
		query.append("               FROM PRI_SP_CTRT_PTY PT" ).append("\n"); 
		query.append("                  , MDM_CUSTOMER MM" ).append("\n"); 
		query.append("               WHERE PT.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("               AND   PT.AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("               AND   PT.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("               AND   MM.CUST_CNT_CD = PT.CUST_CNT_CD" ).append("\n"); 
		query.append("               AND   MM.CUST_SEQ = PT.CUST_SEQ" ).append("\n"); 
		query.append("              )) AS RESPB_SLS_OFC_CD" ).append("\n"); 
		query.append("     , DECODE(MN.REAL_CUST_TP_CD, 'N', MN.REAL_CUST_CNT_CD, NULL) AS REAL_CUST_CNT_CD" ).append("\n"); 
		query.append("     , DECODE(MN.REAL_CUST_TP_CD, 'N', MN.REAL_CUST_SEQ, NULL) AS REAL_CUST_SEQ" ).append("\n"); 
		query.append("     , DECODE(MN.REAL_CUST_TP_CD, 'N', " ).append("\n"); 
		query.append("              (SELECT MD.VBS_CLSS_CD" ).append("\n"); 
		query.append("               FROM MDM_CUSTOMER MD" ).append("\n"); 
		query.append("               WHERE MD.CUST_CNT_CD = MN.REAL_CUST_CNT_CD" ).append("\n"); 
		query.append("               AND   MD.CUST_SEQ = MN.REAL_CUST_SEQ), NULL) AS REAL_CUST_VAL_SGM_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , DECODE(MN.REAL_CUST_TP_CD, 'N', MN.REAL_CUST_TP_CD, NULL) AS REAL_CUST_TP_CD" ).append("\n"); 
		query.append("     , DECODE(MN.REAL_CUST_TP_CD, 'N', " ).append("\n"); 
		query.append("              (SELECT MD.SREP_CD" ).append("\n"); 
		query.append("               FROM MDM_CUSTOMER MD" ).append("\n"); 
		query.append("               WHERE MD.CUST_CNT_CD = MN.REAL_CUST_CNT_CD" ).append("\n"); 
		query.append("               AND   MD.CUST_SEQ = MN.REAL_CUST_SEQ), NULL) AS REAL_CUST_SREP_CD" ).append("\n"); 
		query.append("     , DECODE(MN.REAL_CUST_TP_CD, 'N', " ).append("\n"); 
		query.append("              (SELECT MD.OFC_CD" ).append("\n"); 
		query.append("               FROM MDM_CUSTOMER MD" ).append("\n"); 
		query.append("               WHERE MD.CUST_CNT_CD = MN.REAL_CUST_CNT_CD" ).append("\n"); 
		query.append("               AND   MD.CUST_SEQ = MN.REAL_CUST_SEQ), NULL) AS REAL_CUST_SLS_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , MN.RF_FLG" ).append("\n"); 
		query.append("     , MN.GAMT_FLG" ).append("\n"); 
		query.append("     , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("     , @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM PRI_SP_MN MN" ).append("\n"); 
		query.append("WHERE MN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   MN.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 

	}
}