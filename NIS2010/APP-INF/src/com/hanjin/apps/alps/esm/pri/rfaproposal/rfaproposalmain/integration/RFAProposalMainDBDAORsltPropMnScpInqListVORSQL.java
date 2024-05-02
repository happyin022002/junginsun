/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAProposalMainDBDAORsltPropMnScpInqListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.11.20 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAORsltPropMnScpInqListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * scope inquiry
	  * </pre>
	  */
	public RFAProposalMainDBDAORsltPropMnScpInqListVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAORsltPropMnScpInqListVORSQL").append("\n"); 
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
		query.append(",MN.PROP_SCP_OFC_CD" ).append("\n"); 
		query.append(",MN.TGT_MVC_QTY" ).append("\n"); 
		query.append(",UT.INTG_CD_VAL_DP_DESC CNTR_LOD_UT_CD" ).append("\n"); 
		query.append(",MN.PROP_SCP_SREP_CD" ).append("\n"); 
		query.append(",DECODE (DUR.CTRT_EFF_DT, TO_DATE('99991231','YYYYMMDD'), '', TO_CHAR (DUR.CTRT_EFF_DT, 'YYYYMMDD')) CTRT_EFF_DT" ).append("\n"); 
		query.append(",DECODE (DUR.CTRT_EFF_DT, TO_DATE('99991231','YYYYMMDD'), '', TO_CHAR (DUR.CTRT_EXP_DT, 'YYYYMMDD')) CTRT_EXP_DT" ).append("\n"); 
		query.append(",STS_CD.INTG_CD_VAL_DP_DESC PROP_SCP_STS_CD" ).append("\n"); 
		query.append("FROM   PRI_RP_SCP_MN MN" ).append("\n"); 
		query.append(",PRI_RP_SCP_DUR DUR" ).append("\n"); 
		query.append(",COM_INTG_CD_DTL STS_CD" ).append("\n"); 
		query.append(",COM_INTG_CD_DTL UT" ).append("\n"); 
		query.append("WHERE MN.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND MN.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND DUR.PROP_NO(+) = MN.PROP_NO" ).append("\n"); 
		query.append("AND DUR.AMDT_SEQ(+) = MN.AMDT_SEQ" ).append("\n"); 
		query.append("AND DUR.SVC_SCP_CD(+) = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("AND STS_CD.INTG_CD_ID = 'CD01719'" ).append("\n"); 
		query.append("AND STS_CD.INTG_CD_VAL_CTNT = MN.PROP_SCP_STS_CD" ).append("\n"); 
		query.append("AND UT.INTG_CD_ID(+)               = 'CD00897'" ).append("\n"); 
		query.append("AND UT.INTG_CD_VAL_CTNT(+)         = MN.CNTR_LOD_UT_CD" ).append("\n"); 
		query.append("ORDER BY MN.CRE_DT" ).append("\n"); 

	}
}