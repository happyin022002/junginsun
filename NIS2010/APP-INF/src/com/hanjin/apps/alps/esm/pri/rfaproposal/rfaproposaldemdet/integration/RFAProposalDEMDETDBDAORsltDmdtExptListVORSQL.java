/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAProposalDEMDETDBDAORsltDmdtExptListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.09.29 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposaldemdet.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JaeYeon Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalDEMDETDBDAORsltDmdtExptListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFA DEMDET List 조회
	  * </pre>
	  */
	public RFAProposalDEMDETDBDAORsltDmdtExptListVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposaldemdet.integration").append("\n"); 
		query.append("FileName : RFAProposalDEMDETDBDAORsltDmdtExptListVORSQL").append("\n"); 
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
		query.append("SELECT A.PROP_NO" ).append("\n"); 
		query.append(", A.AMDT_SEQ" ).append("\n"); 
		query.append(", A.DMDT_FT_TP_CD" ).append("\n"); 
		query.append(", A.PRC_PROG_STS_CD" ).append("\n"); 
		query.append(", A.SRC_INFO_CD" ).append("\n"); 
		query.append(", A.ACPT_USR_ID" ).append("\n"); 
		query.append(", A.ACPT_OFC_CD" ).append("\n"); 
		query.append(", A.ACPT_DT" ).append("\n"); 
		query.append(", A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(", (SELECT TO_CHAR(EFF_DT, 'YYYYMMDD') FROM PRI_RP_MN WHERE PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ  ) EFF_DT" ).append("\n"); 
		query.append(", CASE" ).append("\n"); 
		query.append("WHEN A.AMDT_SEQ = @[amdt_seq] THEN TO_CHAR(M.EXP_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("ELSE (" ).append("\n"); 
		query.append("SELECT CASE WHEN M.EFF_DT <= N.EXP_DT THEN TO_CHAR(M.EFF_DT - 1,'YYYYMMDD')" ).append("\n"); 
		query.append("ELSE TO_CHAR(N.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("END AS EXP_DT" ).append("\n"); 
		query.append("FROM PRI_RP_MN N" ).append("\n"); 
		query.append("WHERE PROP_NO = M.PROP_NO AND AMDT_SEQ = M.AMDT_SEQ-1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("END  EXP_DT" ).append("\n"); 
		query.append("FROM PRI_RP_DMDT A" ).append("\n"); 
		query.append(", PRI_RP_MN M" ).append("\n"); 
		query.append("WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND A.AMDT_SEQ IN (@[amdt_seq], @[amdt_seq]-1)" ).append("\n"); 
		query.append("AND M.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND M.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND (A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("OR (A.AMDT_SEQ = @[amdt_seq]-1" ).append("\n"); 
		query.append("AND A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT 'X' FROM PRI_RP_DMDT C" ).append("\n"); 
		query.append("WHERE C.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND C.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND C.N1ST_CMNC_AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY A.AMDT_SEQ" ).append("\n"); 

	}
}