/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TAAProposalDBDAOPriTaaMnVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.taaproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TAAProposalDBDAOPriTaaMnVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TAAProposalDBDAOPriTaaMnVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("taa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.triproposal.taaproposal.integration").append("\n"); 
		query.append("FileName : TAAProposalDBDAOPriTaaMnVORSQL").append("\n"); 
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
		query.append("SELECT TD.TAA_NO" ).append("\n"); 
		query.append("     , TA.TAA_PROP_NO" ).append("\n"); 
		query.append("     , TA.AMDT_SEQ" ).append("\n"); 
		query.append("     , TA.SVC_SCP_CD" ).append("\n"); 
		query.append("     , MS.SVC_SCP_NM" ).append("\n"); 
		query.append("     , TO_CHAR(TA.EFF_DT,'YYYYMMDD') EFF_DT" ).append("\n"); 
		query.append("     , TO_CHAR(TA.EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("     , TO_CHAR(TA.CFM_EXP_DT,'YYYYMMDD') CFM_EXP_DT" ).append("\n"); 
		query.append("     , TA.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("     , TA.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("     , TA.PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append("     , MC.CUST_LGL_ENG_NM AS CTRT_CUST_NM" ).append("\n"); 
		query.append("     , TA.CTRT_CUST_VAL_SGM_CD" ).append("\n"); 
		query.append("     , TA.RESPB_SLS_OFC_CD" ).append("\n"); 
		query.append("     , TA.RESPB_SREP_CD" ).append("\n"); 
		query.append("     , MR.SREP_NM AS RESPB_SREP_NM" ).append("\n"); 
		query.append("     , TA.CFM_FLG" ).append("\n"); 
		query.append("     , DECODE(TA.CFM_FLG, 'Y', 'Yes', 'No') AS CFM_NM" ).append("\n"); 
		query.append("     , TA.CRE_USR_ID AS CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("     , '' AS UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("     , 0 AS OLD_AMDT_SEQ" ).append("\n"); 
		query.append("     , '' AS CTRT_CUST_CD" ).append("\n"); 
		query.append("     , '' AS TAA_STS" ).append("\n"); 
		query.append("FROM PRI_TAA_HDR TD" ).append("\n"); 
		query.append("   , PRI_TAA_MN TA" ).append("\n"); 
		query.append("   , MDM_SVC_SCP MS" ).append("\n"); 
		query.append("   , MDM_CUSTOMER MC" ).append("\n"); 
		query.append("   , MDM_SLS_REP MR" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   TD.TAA_NO = @[taa_no]" ).append("\n"); 
		query.append("AND   TA.TAA_PROP_NO = TD.TAA_PROP_NO" ).append("\n"); 
		query.append("#if (${amdt_seq} != '') " ).append("\n"); 
		query.append("AND   TA.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("AND   TA.AMDT_SEQ = (SELECT MAX(TM.AMDT_SEQ)" ).append("\n"); 
		query.append("                     FROM PRI_TAA_MN TM" ).append("\n"); 
		query.append("                     WHERE TM.TAA_PROP_NO = TA.TAA_PROP_NO)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   MS.SVC_SCP_CD = TA.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   MC.CUST_CNT_CD = TA.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("AND   MC.CUST_SEQ = TA.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("AND   MR.SREP_CD = TA.RESPB_SREP_CD" ).append("\n"); 

	}
}