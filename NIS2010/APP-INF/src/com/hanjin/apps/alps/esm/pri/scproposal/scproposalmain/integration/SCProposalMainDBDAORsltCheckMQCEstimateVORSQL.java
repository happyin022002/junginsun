/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCProposalMainDBDAORsltCheckMQCEstimateVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.13
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.05.13 송민석
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

public class SCProposalMainDBDAORsltCheckMQCEstimateVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCProposalMainDBDAORsltCheckMQCEstimateVORSQL(){
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
		query.append("FileName : SCProposalMainDBDAORsltCheckMQCEstimateVORSQL").append("\n"); 
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
		query.append("FROM   PRI_SP_SCP_MN MN" ).append("\n"); 
		query.append("WHERE  MN.PROP_NO = @[frm_prop_no]" ).append("\n"); 
		query.append("    AND MN.AMDT_SEQ = @[frm_amdt_seq]" ).append("\n"); 
		query.append("    AND MN.PRS_GEN_RT_CMPB_CALC_FLG = 'N'" ).append("\n"); 
		query.append("    AND MN.PRS_SPCL_RT_CMPB_CALC_FLG = 'N'" ).append("\n"); 
		query.append("	AND MN.PRS_PROP_SCP_MQC_QTY IS NULL" ).append("\n"); 

	}
}