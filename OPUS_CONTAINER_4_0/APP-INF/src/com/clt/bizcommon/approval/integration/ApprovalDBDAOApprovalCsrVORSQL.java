/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ApprovalDBDAOApprovalCsrVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.08 
* 1.0 Creation
=========================================================*/
package com.clt.bizcommon.approval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApprovalDBDAOApprovalCsrVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Csr의 목록을 가져온다.
	  * </pre>
	  */
	public ApprovalDBDAOApprovalCsrVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_sys_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.bizcommon.approval.integration").append("\n"); 
		query.append("FileName : ApprovalDBDAOApprovalCsrVORSQL").append("\n"); 
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
		query.append("SELECT T.APRO_RQST_NO      	" ).append("\n"); 
		query.append("     , T.CRNT_APRO_SEQ		" ).append("\n"); 
		query.append("     , T.APSTS_CD  		" ).append("\n"); 
		query.append("     , T.SUB_SYS_CD 				" ).append("\n"); 
		query.append("     , T.RQST_ST_DT 		" ).append("\n"); 
		query.append("     , T.COST_OFC_CD 		" ).append("\n"); 
		query.append("     , T.CSR_NO  		" ).append("\n"); 
		query.append("     , T.INV_KNT 		" ).append("\n"); 
		query.append("     , T.VNDR_SEQ 		" ).append("\n"); 
		query.append("     , T.PAY_DUE_DT		" ).append("\n"); 
		query.append("     , T.CURR_CD  				" ).append("\n"); 
		query.append("     , T.APRO_TTL_AMT  		" ).append("\n"); 
		query.append("     , T.APRO_RMK  		" ).append("\n"); 
		query.append("     , T.APPYN  " ).append("\n"); 
		query.append("     , '' FRST_APRO_USR_ID" ).append("\n"); 
		query.append("     , '' APRO_STEP" ).append("\n"); 
		query.append("     , '' APRO_SEQ_KEY		" ).append("\n"); 
		query.append("     , '' USR_ID" ).append("\n"); 
		query.append("     , '' USR_NM" ).append("\n"); 
		query.append("     , '' OFC_CD" ).append("\n"); 
		query.append("     , '' APRO_RQST_SEQ" ).append("\n"); 
		query.append("     , '' INV_SUB_SYS_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT ROW_NUMBER() OVER (ORDER BY RQST_ST_DT DESC) no  	" ).append("\n"); 
		query.append("             , A.APRO_RQST_NO             " ).append("\n"); 
		query.append("	         , A.CRNT_APRO_SEQ" ).append("\n"); 
		query.append("             , DECODE(A.APSTS_CD, 'P', 'Processing', 'R', 'Disapproved', DECODE(D.IF_FLG,'E','Error','Approved')) APSTS_CD" ).append("\n"); 
		query.append("	         , A.SUB_SYS_CD          	 " ).append("\n"); 
		query.append("	         , TO_CHAR(A.RQST_ST_DT, 'YYYY-MM-DD') RQST_ST_DT          	 " ).append("\n"); 
		query.append("	         , B.COST_OFC_CD          	 " ).append("\n"); 
		query.append("	         , B.CSR_NO          	 " ).append("\n"); 
		query.append("	         , B.INV_KNT          	 " ).append("\n"); 
		query.append("	         , TO_CHAR(B.VNDR_SEQ, '000000') VNDR_SEQ          	 " ).append("\n"); 
		query.append("	         , B.PAY_DUE_DT          	 " ).append("\n"); 
		query.append("	         , B.CURR_CD          	 " ).append("\n"); 
		query.append("	         , B.APRO_TTL_AMT          	 " ).append("\n"); 
		query.append("	         , DECODE(NVL(C.APSTS_CD, ''), '', 'N', 'Y') APPYN         	 " ).append("\n"); 
		query.append("	         , DECODE(D.IF_FLG,'E','I/F Error : '||D.IF_ERR_RSN,C.APRO_RMK) APRO_RMK  " ).append("\n"); 
		query.append("	      FROM COM_APRO_RQST_HDR  A" ).append("\n"); 
		query.append("	         , COM_APRO_CSR_DTL   B" ).append("\n"); 
		query.append("	         , COM_APRO_RQST_ROUT C" ).append("\n"); 
		query.append("             , AP_INV_HDR D" ).append("\n"); 
		query.append("	     WHERE 1 = 1  " ).append("\n"); 
		query.append("	       AND A.SUB_SYS_CD <> 'JOO'										" ).append("\n"); 
		query.append("	       AND NVL(A.DELT_FLG, 'N') <> 'Y'    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${sub_sys_cd} != '')" ).append("\n"); 
		query.append("           AND A.SUB_SYS_CD = @[sub_sys_cd]" ).append("\n"); 
		query.append("           #end   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		   AND A.APRO_RQST_NO = B.APRO_RQST_NO" ).append("\n"); 
		query.append("    	   AND A.APRO_RQST_NO = C.APRO_RQST_NO" ).append("\n"); 
		query.append("           AND B.CSR_NO = D.CSR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${status} == 'P') " ).append("\n"); 
		query.append("           AND A.APSTS_CD = 'P'" ).append("\n"); 
		query.append("           AND A.CRNT_APRO_SEQ = C.APRO_RQST_SEQ" ).append("\n"); 
		query.append("           #elseif (${status} == 'C') " ).append("\n"); 
		query.append("           AND NVL(C.APSTS_CD, ' ') = 'C' AND D.IF_FLG = 'Y'" ).append("\n"); 
		query.append("           #elseif (${status} == 'R')" ).append("\n"); 
		query.append("           AND NVL(C.APSTS_CD, ' ') = 'R'" ).append("\n"); 
		query.append("           #elseif (${status} == 'E')" ).append("\n"); 
		query.append("           AND D.IF_FLG = 'E' " ).append("\n"); 
		query.append("           #else" ).append("\n"); 
		query.append("           AND A.CRNT_APRO_SEQ >= C.APRO_RQST_SEQ" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${status} != 'P')" ).append("\n"); 
		query.append("           AND EXISTS (SELECT 'A' FROM TES_TML_SO_HDR TTSH WHERE TTSH.CSR_NO = B.CSR_NO AND NVL(TTSH.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                       UNION ALL" ).append("\n"); 
		query.append("                       SELECT 'A' FROM TRS_TRSP_INV_WRK TTIW WHERE TTIW.CSR_NO = B.CSR_NO AND NVL(TTIW.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                       UNION ALL" ).append("\n"); 
		query.append("                       SELECT 'A' FROM TRS_TRSP_RAIL_INV_WRK TTRIW WHERE TTRIW.CSR_NO = B.CSR_NO AND NVL(TTRIW.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                       UNION ALL" ).append("\n"); 
		query.append("                       SELECT 'A' FROM ACM_AGN_COMM AAC WHERE AAC.CSR_NO = B.CSR_NO" ).append("\n"); 
		query.append("                       UNION ALL" ).append("\n"); 
		query.append("                       SELECT 'A' FROM ACM_AGN_OTR_COMM AAOC, AP_INV_HDR AIH WHERE AAOC.CSR_NO = B.CSR_NO AND B.CSR_NO = AIH.CSR_NO" ).append("\n"); 
		query.append("                       AND    (A.APSTS_CD = 'P' OR (NVL(C.APSTS_CD, ' ') = 'C' AND D.IF_FLG = 'Y' AND AIH.RCV_ERR_FLG IS NULL))" ).append("\n"); 
		query.append("                       UNION ALL" ).append("\n"); 
		query.append("                       SELECT 'A' FROM ACM_FF_CMPN AFC WHERE AFC.CSR_NO = B.CSR_NO" ).append("\n"); 
		query.append("                       UNION ALL" ).append("\n"); 
		query.append("                       SELECT 'A' FROM ACM_SPCL_CMPN ACMS WHERE ACMS.CSR_NO = B.CSR_NO" ).append("\n"); 
		query.append("                       UNION ALL" ).append("\n"); 
		query.append("                       SELECT 'A' FROM AP_PAY_INV API WHERE API.CSR_NO = B.CSR_NO AND NVL(API.DELT_FLG, 'N') <> 'Y')" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND C.APRO_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${sdate} != '')" ).append("\n"); 
		query.append("           AND TO_CHAR(A.RQST_ST_DT, 'YYYY-MM-DD') >= @[sdate]" ).append("\n"); 
		query.append("           #end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${edate} != '')" ).append("\n"); 
		query.append("           AND TO_CHAR(A.RQST_ST_DT, 'YYYY-MM-DD') <= @[edate]" ).append("\n"); 
		query.append("           #end           " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("       ) T" ).append("\n"); 

	}
}