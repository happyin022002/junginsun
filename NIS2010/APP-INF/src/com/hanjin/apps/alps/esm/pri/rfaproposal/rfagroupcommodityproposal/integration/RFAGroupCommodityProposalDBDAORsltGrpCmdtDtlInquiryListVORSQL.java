/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFAGroupCommodityProposalDBDAORsltGrpCmdtDtlInquiryListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAGroupCommodityProposalDBDAORsltGrpCmdtDtlInquiryListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inquiry 조회
	  * </pre>
	  */
	public RFAGroupCommodityProposalDBDAORsltGrpCmdtDtlInquiryListVORSQL(){
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
		params.put("grp_cmdt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.integration").append("\n"); 
		query.append("FileName : RFAGroupCommodityProposalDBDAORsltGrpCmdtDtlInquiryListVORSQL").append("\n"); 
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
		query.append("	 , A.SVC_SCP_CD " ).append("\n"); 
		query.append("	 , A.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("	 , A.GRP_CMDT_DTL_SEQ	" ).append("\n"); 
		query.append("	 , A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("	 , A.PRC_CMDT_TP_CD" ).append("\n"); 
		query.append("     , CASE WHEN A.PRC_CMDT_TP_CD = 'C' THEN MDM.CMDT_NM" ).append("\n"); 
		query.append("            WHEN A.PRC_CMDT_TP_CD = 'R' THEN MRC.REP_CMDT_NM" ).append("\n"); 
		query.append("            END PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("	 , A.N1ST_CMNC_AMDT_SEQ  " ).append("\n"); 
		query.append("     , (SELECT TO_CHAR(EFF_DT, 'YYYYMMDD') " ).append("\n"); 
		query.append("		  FROM PRI_RP_SCP_MN " ).append("\n"); 
		query.append("		 WHERE PROP_NO = A.PROP_NO " ).append("\n"); 
		query.append("		   AND AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ  " ).append("\n"); 
		query.append("		   AND SVC_SCP_CD = A.SVC_SCP_CD ) EFF_DT " ).append("\n"); 
		query.append("     , CASE WHEN A.AMDT_SEQ = @[amdt_seq] THEN TO_CHAR(M.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("        	ELSE (    " ).append("\n"); 
		query.append("        			SELECT CASE WHEN M.EFF_DT <= N.EXP_DT THEN TO_CHAR(M.EFF_DT - 1,'YYYYMMDD')" ).append("\n"); 
		query.append("               			   		ELSE TO_CHAR(N.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("               				END AS EXP_DT" ).append("\n"); 
		query.append("        			  FROM PRI_RP_SCP_MN N" ).append("\n"); 
		query.append("        			 WHERE PROP_NO = M.PROP_NO AND AMDT_SEQ = M.AMDT_SEQ-1 AND SVC_SCP_CD = M.SVC_SCP_CD )    " ).append("\n"); 
		query.append("    	END EXP_DT " ).append("\n"); 
		query.append("	 , A.SRC_INFO_CD  " ).append("\n"); 
		query.append("	 , A.PRC_PROG_STS_CD " ).append("\n"); 
		query.append("	 , A.ACPT_OFC_CD" ).append("\n"); 
		query.append("	 , TO_CHAR(A.ACPT_DT, 'YYYYMMDD') ACPT_DT" ).append("\n"); 
		query.append("	 , (SELECT USR_NM FROM COM_USER WHERE USR_ID = A.ACPT_USR_ID)||' / '||A.ACPT_OFC_CD ACPT_USR_NM" ).append("\n"); 
		query.append("  FROM PRI_RP_SCP_GRP_CMDT_DTL A" ).append("\n"); 
		query.append("	 , PRI_RP_SCP_MN M " ).append("\n"); 
		query.append("	 , MDM_COMMODITY MDM" ).append("\n"); 
		query.append("     , MDM_REP_CMDT MRC" ).append("\n"); 
		query.append(" WHERE M.PROP_NO		= A.PROP_NO" ).append("\n"); 
		query.append("   AND M.AMDT_SEQ		= A.AMDT_SEQ " ).append("\n"); 
		query.append("   AND M.SVC_SCP_CD		= A.SVC_SCP_CD" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ		= @[amdt_seq] " ).append("\n"); 
		query.append("   AND A.PROP_NO		= @[prop_no]" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD		= @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND A.GRP_CMDT_SEQ	= @[grp_cmdt_seq]" ).append("\n"); 
		query.append("   AND A.SRC_INFO_CD 	<> 'AD'" ).append("\n"); 
		query.append("   AND A.PRC_CMDT_DEF_CD = MDM.CMDT_CD(+)" ).append("\n"); 
		query.append("   AND A.PRC_CMDT_DEF_CD = MRC.REP_CMDT_CD(+)" ).append("\n"); 
		query.append(" ORDER BY A.PRC_CMDT_TP_CD DESC, A.PRC_CMDT_DEF_CD ASC" ).append("\n"); 

	}
}