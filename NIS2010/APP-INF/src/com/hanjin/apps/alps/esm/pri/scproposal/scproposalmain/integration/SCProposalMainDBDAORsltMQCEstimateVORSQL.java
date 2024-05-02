/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCProposalMainDBDAORsltMQCEstimateVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.11
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.05.11 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAORsltMQCEstimateVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCProposalMainDBDAORsltMQCEstimateVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAORsltMQCEstimateVORSQL").append("\n"); 
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
		query.append("    ,MN.AMDT_SEQ" ).append("\n"); 
		query.append("    ,MN.SVC_SCP_CD" ).append("\n"); 
		query.append("    ,MN.PRS_PROP_SCP_MQC_QTY" ).append("\n"); 
		query.append("    ,MQC.CNTR_LOD_UT_CD" ).append("\n"); 
		query.append("    ,UNIT.INTG_CD_VAL_DP_DESC UNIT_NM" ).append("\n"); 
		query.append("    ,MN.PROP_SCP_STS_CD" ).append("\n"); 
		query.append("    ,DECODE(PRS_GEN_RT_CMPB_CALC_FLG,'N',PRS_SPCL_RT_CMPB_CALC_FLG,PRS_GEN_RT_CMPB_CALC_FLG) AS CALC_FLG" ).append("\n"); 
		query.append("	,SUM(MN.PRS_PROP_SCP_MQC_QTY) OVER() AS SUM_MQC" ).append("\n"); 
		query.append("FROM   PRI_SP_SCP_MN MN" ).append("\n"); 
		query.append(",PRI_SP_SCP_MQC MQC" ).append("\n"); 
		query.append(",COM_INTG_CD_DTL UNIT" ).append("\n"); 
		query.append("WHERE  MN.PROP_NO = MQC.PROP_NO" ).append("\n"); 
		query.append("AND MN.AMDT_SEQ = MQC.AMDT_SEQ" ).append("\n"); 
		query.append("AND MN.SVC_SCP_CD = MQC.SVC_SCP_CD" ).append("\n"); 
		query.append("AND MQC.CNTR_LOD_UT_CD = UNIT.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND UNIT.INTG_CD_ID = 'CD00897'" ).append("\n"); 
		query.append("AND MN.PROP_NO = @[frm_prop_no]" ).append("\n"); 
		query.append("AND MN.AMDT_SEQ = @[frm_amdt_seq]" ).append("\n"); 
		query.append("ORDER BY MN.CRE_DT, MN.SVC_SCP_CD" ).append("\n"); 

	}
}