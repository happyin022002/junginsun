/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCContractPartyProposalDBDAOPriSpCtrtPtyHistoryFontVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2010.02.24 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JaeYeon Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCContractPartyProposalDBDAOPriSpCtrtPtyHistoryFontVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Contract Party History Option font
	  * </pre>
	  */
	public SCContractPartyProposalDBDAOPriSpCtrtPtyHistoryFontVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.integration").append("\n"); 
		query.append("FileName : SCContractPartyProposalDBDAOPriSpCtrtPtyHistoryFontVORSQL").append("\n"); 
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
		query.append("SELECT PRC_CTRT_PTY_TP_CD CD" ).append("\n"); 
		query.append(",AMDT_FLG" ).append("\n"); 
		query.append(",ACPT_FLG" ).append("\n"); 
		query.append(",  CASE ACT_CNT" ).append("\n"); 
		query.append("WHEN 'Y' THEN '3'" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("CASE AMDT_FLG||AMD_CNT" ).append("\n"); 
		query.append("WHEN 'YY' THEN DECODE(@[amdt_seq],'0','1','2')" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("CASE AMD_CNT WHEN 'N' THEN '0'" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("'1'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("END ETC1" ).append("\n"); 
		query.append("FROM   PRI_SP_AMDT_SMRY C" ).append("\n"); 
		query.append(", (SELECT '04' PROP_TERM_TP_CD" ).append("\n"); 
		query.append(",PRC_CTRT_PTY_TP_CD" ).append("\n"); 
		query.append(",DECODE(N1ST_CMNC_AMDT_SEQ,DECODE((SELECT LGCY_IF_FLG FROM PRI_SP_MN TMP WHERE TMP.PROP_NO = @[prop_no] AND TMP.AMDT_SEQ = @[amdt_seq]), 'Y', N1ST_CMNC_AMDT_SEQ, @[amdt_seq]),'Y','N') AMD_CNT" ).append("\n"); 
		query.append(",DECODE(N1ST_CMNC_AMDT_SEQ,AMDT_SEQ,DECODE(PRC_PROG_STS_CD,'A','Y','N'),'N') ACT_CNT" ).append("\n"); 
		query.append("FROM   PRI_SP_CTRT_PTY" ).append("\n"); 
		query.append("WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("GROUP BY PRC_CTRT_PTY_TP_CD ,N1ST_CMNC_AMDT_SEQ,AMDT_SEQ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append("WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND    C.PROP_TERM_TP_CD = D.PROP_TERM_TP_CD" ).append("\n"); 

	}
}