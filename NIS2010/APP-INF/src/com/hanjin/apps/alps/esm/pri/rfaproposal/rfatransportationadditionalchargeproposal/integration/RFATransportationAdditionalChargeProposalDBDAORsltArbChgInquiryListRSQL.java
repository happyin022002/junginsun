/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFATransportationAdditionalChargeProposalDBDAORsltArbChgInquiryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.26
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.06.26 서미진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO MI JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFATransportationAdditionalChargeProposalDBDAORsltArbChgInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFA Arbitrary Inquiry List
	  * 2011.06.15 [CHM-201111444-01] RFA 삭제 후 upload 시 삭제된 데이터 중복 처리 안되도록 시스템 업데이트 요청
	  *                                                 비교를 위한 조회쿼리에 Amend Delete 를 제외하는 조건 추가
	  * </pre>
	  */
	public RFATransportationAdditionalChargeProposalDBDAORsltArbChgInquiryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("add_chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.integration").append("\n"); 
		query.append("FileName : RFATransportationAdditionalChargeProposalDBDAORsltArbChgInquiryListRSQL").append("\n"); 
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
		query.append("	 , A.ADD_CHG_TP_CD" ).append("\n"); 
		query.append("	 , A.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("	 , A.ADD_CHG_SEQ" ).append("\n"); 
		query.append("	 , A.ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append("	 , A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("	 , (SELECT LOC_NM " ).append("\n"); 
		query.append("          FROM MDM_LOCATION " ).append("\n"); 
		query.append("         WHERE LOC_CD = A.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("           AND DELT_FLG = 'N') AS ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append("	 , A.BSE_PORT_TP_CD" ).append("\n"); 
		query.append("	 , A.BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("	 , A.RAT_UT_CD" ).append("\n"); 
		query.append("	 , A.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("	 , A.PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("	 , A.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("	 , A.MIN_CGO_WGT" ).append("\n"); 
		query.append("	 , A.MAX_CGO_WGT" ).append("\n"); 
		query.append("	 , A.CUST_CNT_CD||LPAD(A.CUST_SEQ,6,0) AS CUST_CNT_CD" ).append("\n"); 
		query.append("     , (SELECT CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("          FROM MDM_CUSTOMER " ).append("\n"); 
		query.append("         WHERE CUST_CNT_CD = A.CUST_CNT_CD " ).append("\n"); 
		query.append("           AND CUST_SEQ = A.CUST_SEQ " ).append("\n"); 
		query.append("           AND DELT_FLG = 'N') AS CUST_NM" ).append("\n"); 
		query.append("	 , A.CURR_CD" ).append("\n"); 
		query.append("	 , A.PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("	 , A.COFFR_FRT_RT_AMT" ).append("\n"); 
		query.append("	 , A.FNL_FRT_RT_AMT" ).append("\n"); 
		query.append("	 , A.PRC_PROG_STS_CD" ).append("\n"); 
		query.append("	 , A.SRC_INFO_CD" ).append("\n"); 
		query.append("	 , A.ACPT_USR_ID" ).append("\n"); 
		query.append("	 , (SELECT USR_NM FROM COM_USER WHERE USR_ID = A.ACPT_USR_ID) AS ACPT_USR_NM" ).append("\n"); 
		query.append("	 , A.ACPT_OFC_CD" ).append("\n"); 
		query.append("	 , TO_CHAR(A.ACPT_DT, 'YYYYMMDD') AS ACPT_DT" ).append("\n"); 
		query.append("	 , A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("	 , (SELECT TO_CHAR(EFF_DT, 'YYYYMMDD') FROM PRI_RP_SCP_MN WHERE PROP_NO = A.PROP_NO " ).append("\n"); 
		query.append("             AND AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ AND SVC_SCP_CD = A.SVC_SCP_CD) EFF_DT" ).append("\n"); 
		query.append("     , CASE WHEN A.AMDT_SEQ = @[amdt_seq] THEN TO_CHAR(B.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("     		ELSE (SELECT CASE WHEN A.AMDT_SEQ <= N.AMDT_SEQ THEN TO_CHAR(B.EFF_DT - 1,'YYYYMMDD')" ).append("\n"); 
		query.append("                              ELSE TO_CHAR(N.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                         END AS EXP_DT" ).append("\n"); 
		query.append("                    FROM PRI_RP_SCP_MN N" ).append("\n"); 
		query.append("                   WHERE PROP_NO = B.PROP_NO AND AMDT_SEQ = B.AMDT_SEQ-1 AND SVC_SCP_CD = B.SVC_SCP_CD)    " ).append("\n"); 
		query.append("       END EXP_DT" ).append("\n"); 
		query.append("	 , A.CRE_USR_ID" ).append("\n"); 
		query.append("	 , A.CRE_DT" ).append("\n"); 
		query.append("	 , A.UPD_USR_ID" ).append("\n"); 
		query.append("	 , A.UPD_DT" ).append("\n"); 
		query.append("     , A.FIC_GLINE_RT_AMT" ).append("\n"); 
		query.append("     , TO_CHAR(A.FIC_GLINE_UPD_DT, 'YYYYMMDD') FIC_GLINE_UPD_DT" ).append("\n"); 
		query.append("     , A.OPTM_TRSP_MOD_FLG" ).append("\n"); 
		query.append("     , A.FIC_ROUT_CMB_TP_CD" ).append("\n"); 
		query.append("     , A.FIC_RT_USE_STS_CD     " ).append("\n"); 
		query.append("  FROM PRI_RP_SCP_TRSP_ADD_CHG A" ).append("\n"); 
		query.append("     , PRI_RP_SCP_MN B" ).append("\n"); 
		query.append(" WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND A.ADD_CHG_TP_CD = @[add_chg_tp_cd]" ).append("\n"); 
		query.append("   AND A.ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("   AND A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("   AND B.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("   AND A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("ORDER BY LAST_VALUE(A.ROUT_PNT_LOC_DEF_CD) OVER (PARTITION BY A.ADD_CHG_SEQ ORDER BY A.AMDT_SEQ ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) NULLS FIRST " ).append("\n"); 
		query.append("    , LAST_VALUE(A.BSE_PORT_DEF_CD) OVER (PARTITION BY A.ADD_CHG_SEQ ORDER BY A.AMDT_SEQ ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) NULLS FIRST" ).append("\n"); 
		query.append("    , LAST_VALUE(A.PRC_TRSP_MOD_CD) OVER (PARTITION BY A.ADD_CHG_SEQ ORDER BY A.AMDT_SEQ ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) NULLS FIRST" ).append("\n"); 
		query.append("    , LAST_VALUE(A.RCV_DE_TERM_CD) OVER (PARTITION BY A.ADD_CHG_SEQ ORDER BY A.AMDT_SEQ ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) NULLS FIRST" ).append("\n"); 
		query.append("    , LAST_VALUE(A.PRC_CGO_TP_CD) OVER (PARTITION BY A.ADD_CHG_SEQ ORDER BY A.AMDT_SEQ ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) NULLS FIRST" ).append("\n"); 
		query.append("    , LAST_VALUE(A.RAT_UT_CD) OVER (PARTITION BY A.ADD_CHG_SEQ ORDER BY A.AMDT_SEQ ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) NULLS FIRST" ).append("\n"); 
		query.append("    , LAST_VALUE(A.CURR_CD) OVER (PARTITION BY A.ADD_CHG_SEQ ORDER BY A.AMDT_SEQ ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) NULLS FIRST" ).append("\n"); 
		query.append("    , A.ADD_CHG_SEQ, A.AMDT_SEQ" ).append("\n"); 

	}
}