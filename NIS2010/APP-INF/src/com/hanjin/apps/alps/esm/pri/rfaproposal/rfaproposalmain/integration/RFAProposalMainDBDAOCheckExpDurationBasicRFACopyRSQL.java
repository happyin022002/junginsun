/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFAProposalMainDBDAOCheckExpDurationBasicRFACopyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAOCheckExpDurationBasicRFACopyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFAProposalMainDBDAOCheckDurationBasicRFACopyRSQL
	  * 
	  * * history
	  * * 2016.07.20 [CHM-201642287] Basic RFA의 amdt가 0일때는 Copy한 Master의 Exp date를, amdt가 0이 아닐 때는 auto amend 대상 amdt의 Exp date를 취득한다.
	  * </pre>
	  */
	public RFAProposalMainDBDAOCheckExpDurationBasicRFACopyRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAOCheckExpDurationBasicRFACopyRSQL").append("\n"); 
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
		query.append("SELECT B.PROP_NO" ).append("\n"); 
		query.append("     , MAX(B.AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("     , MAX(TO_CHAR(B.EXP_DT, 'YYYYMMDD')) AS ORG_EXP_DT" ).append("\n"); 
		query.append("  FROM PRI_RP_HDR A" ).append("\n"); 
		query.append("     , PRI_RP_MN B" ).append("\n"); 
		query.append(" WHERE A.PROP_NO    = B.PROP_NO" ).append("\n"); 
		query.append("   AND A.RFA_NO     = (SELECT A.MST_RFA_NO   FROM PRI_RP_HDR A WHERE A.PROP_NO  = @[prop_no])" ).append("\n"); 
		query.append("#if (${amdt_seq} == '0') " ).append("\n"); 
		query.append("  -- Copyed Basic" ).append("\n"); 
		query.append("   AND B.AMDT_SEQ   = (SELECT A.MST_AMDT_SEQ FROM PRI_RP_HDR A WHERE A.PROP_NO  = @[prop_no])" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("  -- Basic Auto Amend" ).append("\n"); 
		query.append("   AND PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" GROUP BY B.PROP_NO" ).append("\n"); 

	}
}