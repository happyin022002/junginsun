/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SCGroupLocationProposalDBDAORsltGrpLocDtlHistoryListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGroupLocationProposalDBDAORsltGrpLocDtlHistoryListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Location Group History 조회
	  * 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
	  * </pre>
	  */
	public SCGroupLocationProposalDBDAORsltGrpLocDtlHistoryListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_loc_seq",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.integration").append("\n"); 
		query.append("FileName : SCGroupLocationProposalDBDAORsltGrpLocDtlHistoryListVORSQL").append("\n"); 
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
		query.append("	 , A.AMDT_SEQ" ).append("\n"); 
		query.append("	 , A.SVC_SCP_CD" ).append("\n"); 
		query.append("	 , A.GRP_LOC_SEQ" ).append("\n"); 
		query.append("	 , A.GRP_LOC_DTL_SEQ" ).append("\n"); 
		query.append("	 , A.LOC_CD" ).append("\n"); 
		query.append("	 , MDM.LOC_NM" ).append("\n"); 
		query.append("	 , '' RANK_SEQ" ).append("\n"); 
		query.append("	 , A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("	 , ( SELECT TO_CHAR(EFF_DT, 'YYYYMMDD') " ).append("\n"); 
		query.append("		   FROM PRI_SP_SCP_MN " ).append("\n"); 
		query.append("		  WHERE PROP_NO = A.PROP_NO " ).append("\n"); 
		query.append("		 	AND AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ  " ).append("\n"); 
		query.append("			AND SVC_SCP_CD = A.SVC_SCP_CD) EFF_DT" ).append("\n"); 
		query.append("	 , CASE WHEN A.AMDT_SEQ = @[amdt_seq] THEN TO_CHAR(M.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("        	ELSE (    " ).append("\n"); 
		query.append("        			SELECT CASE WHEN M.EFF_DT <= N.EXP_DT THEN TO_CHAR(M.EFF_DT - 1,'YYYYMMDD')" ).append("\n"); 
		query.append("               		   	   ELSE TO_CHAR(N.EXP_DT,'YYYYMMDD') END AS EXP_DT" ).append("\n"); 
		query.append("        			  FROM PRI_SP_SCP_MN N" ).append("\n"); 
		query.append("        			 WHERE PROP_NO = M.PROP_NO " ).append("\n"); 
		query.append("					   AND AMDT_SEQ = M.AMDT_SEQ-1 " ).append("\n"); 
		query.append("					   AND SVC_SCP_CD = M.SVC_SCP_CD ) END  EXP_DT" ).append("\n"); 
		query.append("	 , A.SRC_INFO_CD" ).append("\n"); 
		query.append("	 , A.PRC_PROG_STS_CD " ).append("\n"); 
		query.append("	 , A.ACPT_OFC_CD" ).append("\n"); 
		query.append("	 , TO_CHAR(A.ACPT_DT, 'YYYYMMDD') ACPT_DT" ).append("\n"); 
		query.append("	 , (SELECT USR_NM FROM COM_USER WHERE USR_ID = A.ACPT_USR_ID)||' / '||A.ACPT_OFC_CD ACPT_USR_NM" ).append("\n"); 
		query.append("  FROM PRI_SP_SCP_GRP_LOC_DTL	A" ).append("\n"); 
		query.append("	 , PRI_SP_SCP_MN			M" ).append("\n"); 
		query.append("	 , MDM_LOCATION				MDM" ).append("\n"); 
		query.append(" WHERE M.PROP_NO			= A.PROP_NO" ).append("\n"); 
		query.append("   AND M.AMDT_SEQ			= @[amdt_seq]" ).append("\n"); 
		query.append("   AND M.SVC_SCP_CD			= A.SVC_SCP_CD " ).append("\n"); 
		query.append("   AND A.LOC_CD				= MDM.LOC_CD" ).append("\n"); 
		query.append("   AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND A.GRP_LOC_SEQ = @[grp_loc_seq]" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ IN ( @[amdt_seq], DECODE((SELECT LGCY_IF_FLG FROM PRI_SP_MN TMP WHERE TMP.PROP_NO = @[prop_no] AND TMP.AMDT_SEQ = @[amdt_seq]), 'Y', @[amdt_seq], @[amdt_seq]-1))" ).append("\n"); 
		query.append("   AND ( (A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("			AND A.SRC_INFO_CD <> DECODE((SELECT LGCY_IF_FLG FROM PRI_SP_MN TMP WHERE TMP.PROP_NO = @[prop_no] AND TMP.AMDT_SEQ = @[amdt_seq]),'Y','AD','ZZ')" ).append("\n"); 
		query.append("#if (${con_flg} == '0')" ).append("\n"); 
		query.append(" 			AND A.N1ST_CMNC_AMDT_SEQ = DECODE((SELECT LGCY_IF_FLG FROM PRI_SP_MN TMP WHERE TMP.PROP_NO = @[prop_no] AND TMP.AMDT_SEQ = @[amdt_seq]),'Y', A.N1ST_CMNC_AMDT_SEQ , A.AMDT_SEQ)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		  )" ).append("\n"); 
		query.append("       OR ( A.AMDT_SEQ = @[amdt_seq]-1" ).append("\n"); 
		query.append("            AND  A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("            AND  NOT EXISTS ( SELECT 'x' FROM PRI_SP_SCP_GRP_LOC_DTL B" ).append("\n"); 
		query.append("                               WHERE " ).append("\n"); 
		query.append("                			       B.PROP_NO         = A.PROP_NO " ).append("\n"); 
		query.append("                			   AND B.AMDT_SEQ        = @[amdt_seq]" ).append("\n"); 
		query.append("                			   AND B.SVC_SCP_CD      = A.SVC_SCP_CD " ).append("\n"); 
		query.append("                			   AND B.GRP_LOC_SEQ     = A.GRP_LOC_SEQ" ).append("\n"); 
		query.append("                               AND B.GRP_LOC_DTL_SEQ = A.GRP_LOC_DTL_SEQ " ).append("\n"); 
		query.append("                			   AND B.N1ST_CMNC_AMDT_SEQ    = A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("			                 )" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append(" #if (${con_flg} == '0') " ).append("\n"); 
		query.append("AND  0=0" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND 1=1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY FIRST_VALUE(A.LOC_CD) OVER ( PARTITION BY A.GRP_LOC_DTL_SEQ ORDER BY A.AMDT_SEQ ), A.AMDT_SEQ" ).append("\n"); 

	}
}