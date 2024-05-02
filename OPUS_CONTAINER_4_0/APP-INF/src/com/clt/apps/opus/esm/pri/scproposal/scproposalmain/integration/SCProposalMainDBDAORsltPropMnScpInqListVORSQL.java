/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCProposalMainDBDAORsltPropMnScpInqListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.11.17 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAORsltPropMnScpInqListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Scope Inquiry List
	  * </pre>
	  */
	public SCProposalMainDBDAORsltPropMnScpInqListVORSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAORsltPropMnScpInqListVORSQL").append("\n"); 
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
		query.append("SELECT MN.PROP_NO" ).append("\n"); 
		query.append(",MN.AMDT_SEQ" ).append("\n"); 
		query.append(",MN.SVC_SCP_CD" ).append("\n"); 
		query.append(",MN.PROP_SCP_APRO_OFC_CD" ).append("\n"); 
		query.append(",MN.PROP_SCP_OFC_CD" ).append("\n"); 
		query.append(",MQC.PROP_SCP_MQC_QTY" ).append("\n"); 
		query.append(",MQC.CNTR_LOD_UT_CD" ).append("\n"); 
		query.append(",UNIT.INTG_CD_VAL_DP_DESC UNIT_NM" ).append("\n"); 
		query.append(",MN.PROP_SCP_SREP_CD" ).append("\n"); 
		query.append(",DECODE (DUR.CTRT_EFF_DT, TO_DATE('99991231','YYYYMMDD'), '', TO_CHAR (DUR.CTRT_EFF_DT, 'YYYYMMDD')) CTRT_EFF_DT" ).append("\n"); 
		query.append(",DECODE (DUR.CTRT_EFF_DT, TO_DATE('99991231','YYYYMMDD'), '', TO_CHAR (DUR.CTRT_EXP_DT, 'YYYYMMDD')) CTRT_EXP_DT" ).append("\n"); 
		query.append(",MN.PROP_SCP_STS_CD" ).append("\n"); 
		query.append(",STS_CD.INTG_CD_VAL_DP_DESC PROP_SCP_STS" ).append("\n"); 
		query.append("FROM   PRI_SP_SCP_MN MN" ).append("\n"); 
		query.append(",PRI_SP_SCP_DUR DUR" ).append("\n"); 
		query.append(",PRI_SP_SCP_MQC MQC" ).append("\n"); 
		query.append(",COM_INTG_CD_DTL STS_CD" ).append("\n"); 
		query.append(",COM_INTG_CD_DTL UNIT" ).append("\n"); 
		query.append("WHERE MN.PROP_NO = DUR.PROP_NO" ).append("\n"); 
		query.append("AND MN.AMDT_SEQ = DUR.AMDT_SEQ" ).append("\n"); 
		query.append("AND MN.SVC_SCP_CD = DUR.SVC_SCP_CD" ).append("\n"); 
		query.append("AND MN.PROP_NO = MQC.PROP_NO" ).append("\n"); 
		query.append("AND MN.AMDT_SEQ = MQC.AMDT_SEQ" ).append("\n"); 
		query.append("AND MN.SVC_SCP_CD = MQC.SVC_SCP_CD" ).append("\n"); 
		query.append("AND STS_CD.INTG_CD_VAL_CTNT = MN.PROP_SCP_STS_CD" ).append("\n"); 
		query.append("AND STS_CD.INTG_CD_ID = 'CD01719'" ).append("\n"); 
		query.append("AND MQC.CNTR_LOD_UT_CD = UNIT.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND UNIT.INTG_CD_ID = 'CD00897'" ).append("\n"); 
		query.append("AND MN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND MN.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("ORDER BY MN.CRE_DT, MN.SVC_SCP_CD" ).append("\n"); 

	}
}