/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCProposalMainDBDAORsltPriSpAmdHstMnVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.02.18 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAORsltPriSpAmdHstMnVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCProposalMainDBDAO
	  * </pre>
	  */
	public SCProposalMainDBDAORsltPriSpAmdHstMnVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAORsltPriSpAmdHstMnVORSQL").append("\n"); 
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
		query.append("SELECT HDR.SC_NO" ).append("\n"); 
		query.append("	  ,MN.PROP_NO" ).append("\n"); 
		query.append("      ,MN.AMDT_SEQ" ).append("\n"); 
		query.append("      ,CUST.CTRT_PTY_NM" ).append("\n"); 
		query.append("      ,TO_CHAR(DUR.CTRT_EFF_DT, 'YYYY-MM-DD') CTRT_EFF_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(DUR.CTRT_EXP_DT, 'YYYY-MM-DD') CTRT_EXP_DT" ).append("\n"); 
		query.append("	  ,MN.LGCY_IF_FLG" ).append("\n"); 
		query.append("FROM   PRI_SP_MN MN" ).append("\n"); 
		query.append("      ,PRI_SP_HDR HDR" ).append("\n"); 
		query.append("      ,PRI_SP_DUR DUR" ).append("\n"); 
		query.append("      ,PRI_SP_CTRT_PTY CUST" ).append("\n"); 
		query.append("WHERE  HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("AND    MN.PROP_NO = DUR.PROP_NO" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ = DUR.AMDT_SEQ" ).append("\n"); 
		query.append("AND    MN.PROP_NO = CUST.PROP_NO" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ = CUST.AMDT_SEQ" ).append("\n"); 
		query.append("AND    HDR.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("AND    CUST.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ = (SELECT MAX (AMDT_SEQ)" ).append("\n"); 
		query.append("                      FROM   PRI_SP_MN" ).append("\n"); 
		query.append("                      WHERE  PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("                      AND    PROP_STS_CD = 'F')" ).append("\n"); 

	}
}