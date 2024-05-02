/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RFAProposalMainDBDAORsltPriRpAmdHstMnSpotVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.26
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2014.09.26 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sunghwan Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAORsltPriRpAmdHstMnSpotVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2014.09.15 최성환  [CHM-201431899] Guideline RFA 생성 요청 
	  * </pre>
	  */
	public RFAProposalMainDBDAORsltPriRpAmdHstMnSpotVORSQL(){
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
		query.append("FileName : RFAProposalMainDBDAORsltPriRpAmdHstMnSpotVORSQL").append("\n"); 
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
		query.append("      ,'' CTRT_PTY_NM" ).append("\n"); 
		query.append("      ,TO_CHAR(DUR.CTRT_EFF_DT, 'YYYY-MM-DD') CTRT_EFF_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(DUR.CTRT_EXP_DT, 'YYYY-MM-DD') CTRT_EXP_DT" ).append("\n"); 
		query.append("      ,'Spot Guide' AS RFA_CTRT_TP_CD" ).append("\n"); 
		query.append("FROM   PRI_RP_MN MN" ).append("\n"); 
		query.append("      ,PRI_RP_HDR HDR" ).append("\n"); 
		query.append("      ,PRI_RP_DUR DUR" ).append("\n"); 
		query.append("WHERE  HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("AND    MN.PROP_NO = DUR.PROP_NO" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ = DUR.AMDT_SEQ" ).append("\n"); 
		query.append("AND    HDR.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("AND    MN.RFA_CTRT_TP_CD = 'G'" ).append("\n"); 
		query.append("AND    MN.AMDT_SEQ = (SELECT /*+ INDEX_DESC(B XPKPRI_RP_MN)*/ AMDT_SEQ" ).append("\n"); 
		query.append("                      FROM   PRI_RP_MN B" ).append("\n"); 
		query.append("                      WHERE  PROP_NO =MN.PROP_NO" ).append("\n"); 
		query.append("                      AND    PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("					  AND    ROWNUM = 1)" ).append("\n"); 

	}
}