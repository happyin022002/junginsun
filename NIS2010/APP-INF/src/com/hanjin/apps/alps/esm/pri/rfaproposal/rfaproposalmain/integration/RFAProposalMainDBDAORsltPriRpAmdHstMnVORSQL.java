/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : RFAProposalMainDBDAORsltPriRpAmdHstMnVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.28
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2013.11.28 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAORsltPriRpAmdHstMnVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 1
	  * </pre>
	  */
	public RFAProposalMainDBDAORsltPriRpAmdHstMnVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAORsltPriRpAmdHstMnVORSQL").append("\n"); 
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
		query.append("SELECT HDR.RFA_NO" ).append("\n"); 
		query.append("	  ,MN.PROP_NO" ).append("\n"); 
		query.append("      ,MN.AMDT_SEQ" ).append("\n"); 
		query.append("      ,CUST.CUST_LGL_ENG_NM CTRT_PTY_NM" ).append("\n"); 
		query.append("      ,TO_CHAR(DUR.CTRT_EFF_DT, 'YYYY-MM-DD') CTRT_EFF_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(DUR.CTRT_EXP_DT, 'YYYY-MM-DD') CTRT_EXP_DT" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03264' AND INTG_CD_VAL_CTNT = MN.RFA_CTRT_TP_CD) AS RFA_CTRT_TP_CD" ).append("\n"); 
		query.append("FROM   PRI_RP_MN MN" ).append("\n"); 
		query.append("      ,PRI_RP_HDR HDR" ).append("\n"); 
		query.append("      ,PRI_RP_DUR DUR" ).append("\n"); 
		query.append("	  ,MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("WHERE  HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("AND    MN.PROP_NO = DUR.PROP_NO" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ = DUR.AMDT_SEQ" ).append("\n"); 
		query.append("AND    MN.CTRT_CUST_CNT_CD = CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("AND    MN.CTRT_CUST_SEQ = CUST_SEQ" ).append("\n"); 
		query.append("AND    CUST.CNTR_DIV_FLG = 'Y'" ).append("\n"); 
		query.append("AND    HDR.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ = (SELECT /*+ INDEX_DESC(B XPKPRI_RP_MN)*/ AMDT_SEQ" ).append("\n"); 
		query.append("                      FROM   PRI_RP_MN B" ).append("\n"); 
		query.append("                      WHERE  PROP_NO =MN.PROP_NO" ).append("\n"); 
		query.append("                      AND    PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("					  AND    ROWNUM = 1)" ).append("\n"); 

	}
}