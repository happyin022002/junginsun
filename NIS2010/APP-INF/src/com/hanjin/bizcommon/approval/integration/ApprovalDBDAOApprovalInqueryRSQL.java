/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ApprovalDBDAOApprovalInqueryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.02.12
*@LastModifier : 
*@LastVersion : 1.0
* 2018.02.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.approval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApprovalDBDAOApprovalInqueryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Csr의 목록을 가져온다.
	  * </pre>
	  */
	public ApprovalDBDAOApprovalInqueryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_csr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edate",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.approval.integration").append("\n"); 
		query.append("FileName : ApprovalDBDAOApprovalInqueryRSQL").append("\n"); 
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
		query.append("SELECT T.APRO_RQST_NO" ).append("\n"); 
		query.append("      ,T.CRNT_APRO_SEQ" ).append("\n"); 
		query.append("      --,DECODE(T.PAY_DT,'',T.APSTS_CD,'Paid') APSTS_CD" ).append("\n"); 
		query.append("	  ,T.APSTS_CD ALPS_STATUS" ).append("\n"); 
		query.append("      ,T.IF_STATUS" ).append("\n"); 
		query.append("      ,T.SUB_SYS_CD" ).append("\n"); 
		query.append("      ,T.RQST_ST_DT" ).append("\n"); 
		query.append("      ,T.COST_OFC_CD" ).append("\n"); 
		query.append("      ,T.CSR_NO" ).append("\n"); 
		query.append("      ,T.INV_KNT" ).append("\n"); 
		query.append("      ,T.VNDR_SEQ" ).append("\n"); 
		query.append("      ,T.VNDR_NM" ).append("\n"); 
		query.append("      ,T.PAY_DUE_DT" ).append("\n"); 
		query.append("      ,T.PAY_DT	" ).append("\n"); 
		query.append("      ,T.CURR_CD" ).append("\n"); 
		query.append("      ,T.APRO_TTL_AMT" ).append("\n"); 
		query.append("	  ,DECODE(T.APRO_TTL_AMT,0,T.ASA_AMT,0) ASA_AMT" ).append("\n"); 
		query.append("      ,T.APRO_RMK" ).append("\n"); 
		query.append("      ,T.APPYN" ).append("\n"); 
		query.append("      ,'' FRST_APRO_USR_ID" ).append("\n"); 
		query.append("      ,'' APRO_STEP" ).append("\n"); 
		query.append("      ,'' APRO_SEQ_KEY" ).append("\n"); 
		query.append("      ,'' USR_ID" ).append("\n"); 
		query.append("      ,'' USR_NM" ).append("\n"); 
		query.append("      ,'' OFC_CD" ).append("\n"); 
		query.append("      ,'' APRO_RQST_SEQ" ).append("\n"); 
		query.append("      ,'' INV_SUB_SYS_CD" ).append("\n"); 
		query.append("	  ,T.AGMT_DOC_CFM_CD" ).append("\n"); 
		query.append("	  ,T.AGMT_FILE_CFM_CD" ).append("\n"); 
		query.append("	  ,DECODE(T.APRO_TTL_AMT,0,T.ASA_NO,'') ASA_NO" ).append("\n"); 
		query.append("	  ,(CASE WHEN" ).append("\n"); 
		query.append("        		NVL(( SELECT COUNT(F.ATCH_FILE_ID)" ).append("\n"); 
		query.append("        				FROM COM_AP_FILE_UPLD F" ).append("\n"); 
		query.append("        				WHERE 1=1" ).append("\n"); 
		query.append("        				AND F.AP_FILE_DIV_CD = 'C'" ).append("\n"); 
		query.append("        				AND F.CSR_NO = T.CSR_NO " ).append("\n"); 
		query.append("        				AND F.CSR_FILE_UPLD_TP_CD = 'FU'" ).append("\n"); 
		query.append("						AND NVL(F.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("        			),0) > 0 THEN 'Y'    " ).append("\n"); 
		query.append("    	  	ELSE 'N'" ).append("\n"); 
		query.append("          	END ) FILE_UPLD_FLG" ).append("\n"); 
		query.append("  FROM ( SELECT ROW_NUMBER() OVER (ORDER BY RQST_ST_DT DESC) no" ).append("\n"); 
		query.append("               ,A.APRO_RQST_NO" ).append("\n"); 
		query.append("	           ,A.CRNT_APRO_SEQ" ).append("\n"); 
		query.append("			   ,CASE WHEN (E.AFT_ACT_FLG = 'N' OR E.AFT_ACT_FLG = 'X') THEN 'Canceled'" ).append("\n"); 
		query.append("                  	 ELSE D.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("             	END APSTS_CD" ).append("\n"); 
		query.append("			   ,CASE WHEN E.PAY_DT IS NOT NULL THEN 'Paid'" ).append("\n"); 
		query.append("                     WHEN E.RCV_ERR_FLG = 'E' THEN 'A/P Rejected'" ).append("\n"); 
		query.append("		             WHEN E.IF_FLG = 'E' THEN 'I/F Error'" ).append("\n"); 
		query.append("		             WHEN E.IF_FLG = 'Y' AND E.RCV_ERR_FLG IS NULL THEN 'I/F Success'" ).append("\n"); 
		query.append("                END IF_STATUS   " ).append("\n"); 
		query.append("	           ,A.SUB_SYS_CD" ).append("\n"); 
		query.append("	           ,TO_CHAR(A.RQST_ST_DT, 'YYYY-MM-DD') RQST_ST_DT" ).append("\n"); 
		query.append("	           ,B.COST_OFC_CD" ).append("\n"); 
		query.append("	           ,B.CSR_NO" ).append("\n"); 
		query.append("	           ,B.INV_KNT" ).append("\n"); 
		query.append("	           ,TO_CHAR(B.VNDR_SEQ, '000000') VNDR_SEQ" ).append("\n"); 
		query.append("               ,V.VNDR_LGL_ENG_NM VNDR_NM" ).append("\n"); 
		query.append("	           ,B.PAY_DUE_DT" ).append("\n"); 
		query.append("               ,E.PAY_DT" ).append("\n"); 
		query.append("	           ,B.CURR_CD" ).append("\n"); 
		query.append("			   ,B.APRO_TTL_AMT" ).append("\n"); 
		query.append("			   ,CASE WHEN A.SUB_SYS_CD = 'TES' " ).append("\n"); 
		query.append("							THEN NVL((SELECT SUM(TTL_INV_AMT) AMT FROM TES_TML_SO_HDR WHERE CSR_NO = B.CSR_NO AND NVL(DELT_FLG,'N') <> 'Y'), B.APRO_TTL_AMT)" ).append("\n"); 
		query.append("					 WHEN A.SUB_SYS_CD = 'TRS' THEN" ).append("\n"); 
		query.append("							(SELECT " ).append("\n"); 
		query.append("  								SUM(NVL(INV_WRK.INV_BZC_AMT , RAIL_WRK.INV_BZC_AMT )) INV_BZC_AMT" ).append("\n"); 
		query.append("							FROM AP_INV_HDR DTRB , TRS_TRSP_INV_WRK INV_WRK , TRS_TRSP_RAIL_INV_WRK RAIL_WRK" ).append("\n"); 
		query.append("							WHERE DTRB.CSR_NO = INV_WRK.CSR_NO(+)" ).append("\n"); 
		query.append("  							AND DTRB.CSR_NO = RAIL_WRK.CSR_NO(+)" ).append("\n"); 
		query.append("  							AND DTRB.CSR_NO = B.CSR_NO)" ).append("\n"); 
		query.append("					 WHEN A.SUB_SYS_CD IN ('LSE','CHS','MGS','MNR','PSO','TLL','CNI')" ).append("\n"); 
		query.append("							THEN (SELECT SUM(NVL(T.INV_NET_AMT ,0)) TTL_INV_AMT FROM AP_PAY_INV T , AP_INV_HDR A WHERE  T.CSR_NO = A.CSR_NO AND T.CSR_NO = B.CSR_NO AND NVL(T.DELT_FLG,'N') <> 'Y')" ).append("\n"); 
		query.append("					 WHEN A.SUB_SYS_CD IN ('ACM','FMS') " ).append("\n"); 
		query.append("							THEN (SELECT SUM(INV_AMT) FROM AP_INV_DTRB WHERE CSR_NO = B.CSR_NO AND ATTR_CTNT1 IS NOT NULL AND DTRB_COA_ACCT_CD <> '954113')" ).append("\n"); 
		query.append("					 ELSE 0" ).append("\n"); 
		query.append("	            END AS ASA_AMT" ).append("\n"); 
		query.append("	           ,CASE WHEN A.APSTS_CD = 'C' THEN 'Y' -- approved" ).append("\n"); 
		query.append("        	         WHEN A.APSTS_CD = 'D' THEN 'Y' -- Canceled" ).append("\n"); 
		query.append("          	         WHEN A.APSTS_CD = 'R' THEN 'Y' -- Disapproved" ).append("\n"); 
		query.append("          	         ELSE DECODE(NVL(C.APSTS_CD, ''), '', 'N', 'Y') " ).append("\n"); 
		query.append("          	     END AS APPYN" ).append("\n"); 
		query.append("	           ,C.APRO_RMK" ).append("\n"); 
		query.append("			   ,( CASE WHEN E.GW_AGMT_DOC_CFM_CD IS NOT NULL" ).append("\n"); 
		query.append("           		  	THEN ( CASE WHEN E.GW_AGMT_DOC_CFM_CD = 'P' THEN 'Y'" ).append("\n"); 
		query.append("                       			WHEN E.GW_AGMT_DOC_CFM_CD = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                       			ELSE 'N'" ).append("\n"); 
		query.append("                  			END )" ).append("\n"); 
		query.append("         			ELSE NVL(E.AGMT_DOC_CFM_CD,'N')" ).append("\n"); 
		query.append("    			END ) AGMT_DOC_CFM_CD " ).append("\n"); 
		query.append("			   ,NVL(E.AGMT_FILE_CFM_CD,'N') AGMT_FILE_CFM_CD  --추가" ).append("\n"); 
		query.append("      		   ,E.ATTR_CTNT2 AS ASA_NO" ).append("\n"); 
		query.append("	       FROM COM_APRO_RQST_HDR  A" ).append("\n"); 
		query.append("	           ,COM_APRO_CSR_DTL   B" ).append("\n"); 
		query.append("	           ,COM_APRO_RQST_ROUT C" ).append("\n"); 
		query.append("			   ,COM_INTG_CD_DTL    D" ).append("\n"); 
		query.append("               ,AP_INV_HDR         E" ).append("\n"); 
		query.append("               ,MDM_VENDOR         V" ).append("\n"); 
		query.append("	      WHERE 1 = 1" ).append("\n"); 
		query.append("	        AND A.SUB_SYS_CD NOT IN ('JOO')  --// FMS의 OA계정으로 FMS는 ALPS결재도 가능함에 FMS를 제외에서 뺌" ).append("\n"); 
		query.append("	        AND NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${sub_sys_cd} != '')" ).append("\n"); 
		query.append("            AND A.SUB_SYS_CD = @[sub_sys_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" 		    AND A.APRO_RQST_NO = B.APRO_RQST_NO" ).append("\n"); 
		query.append("    	    AND A.APRO_RQST_NO = C.APRO_RQST_NO" ).append("\n"); 
		query.append("			AND A.APSTS_CD = D.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("            AND 'CD01474' = D.INTG_CD_ID(+)" ).append("\n"); 
		query.append("            AND B.CSR_NO = E.CSR_NO" ).append("\n"); 
		query.append("			AND A.CRNT_APRO_SEQ = C.APRO_RQST_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${alps_status} == 'P')  -- Requested" ).append("\n"); 
		query.append("            AND A.APSTS_CD = 'P'" ).append("\n"); 
		query.append("           #elseif (${alps_status} == 'C') -- Approved" ).append("\n"); 
		query.append("            AND NVL(A.APSTS_CD, ' ') = 'C' AND E.AFT_ACT_FLG IS NULL " ).append("\n"); 
		query.append("           #elseif (${alps_status} == 'R') -- Disapproved" ).append("\n"); 
		query.append("            AND NVL(A.APSTS_CD, ' ') = 'R' AND E.AFT_ACT_FLG IS NULL" ).append("\n"); 
		query.append("		   #elseif(${alps_status} == 'X') -- Canceled" ).append("\n"); 
		query.append("            AND (E.AFT_ACT_FLG = 'N' OR E.AFT_ACT_FLG = 'X')" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		   	#if (${if_status} == 'P') -- Paid" ).append("\n"); 
		query.append("				AND E.PAY_DT IS NOT NULL" ).append("\n"); 
		query.append("           	#elseif (${if_status} == 'R') -- A/P Rejected" ).append("\n"); 
		query.append("            	AND E.RCV_ERR_FLG = 'E'" ).append("\n"); 
		query.append("		   	#elseif (${if_status} == 'E') -- I/F Error" ).append("\n"); 
		query.append("            	AND E.IF_FLG = 'E' AND E.RCV_ERR_FLG IS NULL" ).append("\n"); 
		query.append("		   	#elseif (${if_status} == 'S') -- I/F Success" ).append("\n"); 
		query.append("            	AND E.IF_FLG = 'Y' AND E.RCV_ERR_FLG IS NULL AND E.PAY_DT IS NULL" ).append("\n"); 
		query.append("           	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            AND B.VNDR_SEQ = V.VNDR_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		   #if(${rhq_ofc_cd} != 'ALL')" ).append("\n"); 
		query.append("				#if(${ofc_cd} == 'ALL')" ).append("\n"); 
		query.append("            		AND A.RQST_OFC_CD IN ( 	SELECT DISTINCT LL.OFC_N5TH_LVL_CD AS OFC_CD" ).append("\n"); 
		query.append("										   	FROM MAS_OFC_LVL LL				" ).append("\n"); 
		query.append(" 										   	WHERE 1 = 1				" ).append("\n"); 
		query.append("   											AND (CASE (SELECT OFC_LVL				" ).append("\n"); 
		query.append("               											FROM (SELECT L.OFC_LVL				" ).append("\n"); 
		query.append("                       										    FROM MAS_OFC_LVL L				" ).append("\n"); 
		query.append("                      										   WHERE L.OFC_N3RD_LVL_CD IS NOT NULL				" ).append("\n"); 
		query.append("                        										 AND L.OFC_N5TH_LVL_CD IS NOT NULL				" ).append("\n"); 
		query.append("                        										 AND L.OFC_CD = @[rhq_ofc_cd] /* LOGIN-OFFICE CODE BINDING */				" ).append("\n"); 
		query.append("                      										ORDER BY L.OFC_APLY_TO_YRMON DESC )				" ).append("\n"); 
		query.append("              											WHERE ROWNUM = 1 )				" ).append("\n"); 
		query.append("           										WHEN '1' THEN 'XXXXX'				" ).append("\n"); 
		query.append("           										WHEN '2' THEN LL.OFC_N3RD_LVL_CD				" ).append("\n"); 
		query.append("           										WHEN '3' THEN LL.OFC_N3RD_LVL_CD				" ).append("\n"); 
		query.append("           										WHEN '4' THEN LL.OFC_CD				" ).append("\n"); 
		query.append("           										WHEN '5' THEN LL.OFC_CD				" ).append("\n"); 
		query.append("           										WHEN '6' THEN LL.OFC_CD				" ).append("\n"); 
		query.append("           										WHEN '7' THEN LL.OFC_CD				" ).append("\n"); 
		query.append("           										WHEN '9' THEN 'XXXXX'				" ).append("\n"); 
		query.append("         										ELSE 'XXXXX'				" ).append("\n"); 
		query.append("       											END = @[rhq_ofc_cd] /* LOGIN-OFFICE CODE BINDING */				" ).append("\n"); 
		query.append("       											OR LL.OFC_CD = @[rhq_ofc_cd]" ).append("\n"); 
		query.append("       											)" ).append("\n"); 
		query.append("   											AND LL.OFC_N5TH_LVL_CD IS NOT NULL" ).append("\n"); 
		query.append("   											AND LL.OFC_APLY_TO_YRMON ='999912'				                                              " ).append("\n"); 
		query.append("                                			)" ).append("\n"); 
		query.append("		   	    #elseif(${ofc_cd} != 'ALL')" ).append("\n"); 
		query.append("            		AND A.RQST_OFC_CD IN ( SELECT X.SUB_OFC_CD" ).append("\n"); 
		query.append("  									 FROM (SELECT DISTINCT LL.OFC_CD AS SUB_OFC_CD				" ).append("\n"); 
		query.append("									         FROM MAS_OFC_LVL LL				" ).append("\n"); 
		query.append("									        WHERE 1 = 1				" ).append("\n"); 
		query.append("									          AND CASE (SELECT OFC_LVL				" ).append("\n"); 
		query.append("									                      FROM (SELECT L.OFC_LVL				" ).append("\n"); 
		query.append("									                              FROM MAS_OFC_LVL L				" ).append("\n"); 
		query.append("									                             WHERE L.OFC_N3RD_LVL_CD IS NOT NULL				" ).append("\n"); 
		query.append("									                               AND L.OFC_N5TH_LVL_CD IS NOT NULL				" ).append("\n"); 
		query.append("									                               AND L.OFC_CD = @[ofc_cd] /* LOGIN-OFFICE CODE BINDING */				" ).append("\n"); 
		query.append("									                             ORDER BY L.OFC_APLY_TO_YRMON DESC )				" ).append("\n"); 
		query.append("										                  WHERE ROWNUM = 1 )				" ).append("\n"); 
		query.append("                    						      		WHEN '1' THEN 'XXXXX'				" ).append("\n"); 
		query.append("									                    WHEN '2' THEN 'XXXXX'				" ).append("\n"); 
		query.append("									                    WHEN '3' THEN 'XXXXX'				" ).append("\n"); 
		query.append("									                    WHEN '4' THEN LL.OFC_N5TH_LVL_CD				" ).append("\n"); 
		query.append("									                    WHEN '5' THEN LL.OFC_N5TH_LVL_CD				" ).append("\n"); 
		query.append("									                    WHEN '6' THEN LL.OFC_N5TH_LVL_CD				" ).append("\n"); 
		query.append("									                    WHEN '7' THEN LL.OFC_N5TH_LVL_CD				" ).append("\n"); 
		query.append("									                    WHEN '9' THEN 'XXXXX'				" ).append("\n"); 
		query.append("									                    ELSE 'XXXXX'				" ).append("\n"); 
		query.append("										            END = @[ofc_cd] /* LOGIN-OFFICE CODE BINDING */				" ).append("\n"); 
		query.append("									             OR LL.OFC_CD = @[ofc_cd] /* LOGIN-OFFICE CODE BINDING */				" ).append("\n"); 
		query.append("								     ) X" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("		   	 #end" ).append("\n"); 
		query.append("           #elseif(${rhq_ofc_cd} == 'ALL')" ).append("\n"); 
		query.append("			 #if(${ofc_cd} != 'ALL')" ).append("\n"); 
		query.append("            		AND A.RQST_OFC_CD IN ( SELECT X.SUB_OFC_CD" ).append("\n"); 
		query.append("  									 FROM (SELECT DISTINCT LL.OFC_CD AS SUB_OFC_CD				" ).append("\n"); 
		query.append("									         FROM MAS_OFC_LVL LL				" ).append("\n"); 
		query.append("									        WHERE 1 = 1				" ).append("\n"); 
		query.append("									          AND CASE (SELECT OFC_LVL				" ).append("\n"); 
		query.append("									                      FROM (SELECT L.OFC_LVL				" ).append("\n"); 
		query.append("									                              FROM MAS_OFC_LVL L				" ).append("\n"); 
		query.append("									                             WHERE L.OFC_N3RD_LVL_CD IS NOT NULL				" ).append("\n"); 
		query.append("									                               AND L.OFC_N5TH_LVL_CD IS NOT NULL				" ).append("\n"); 
		query.append("									                               AND L.OFC_CD = @[ofc_cd] /* LOGIN-OFFICE CODE BINDING */				" ).append("\n"); 
		query.append("									                             ORDER BY L.OFC_APLY_TO_YRMON DESC )				" ).append("\n"); 
		query.append("										                  WHERE ROWNUM = 1 )				" ).append("\n"); 
		query.append("                    						      		WHEN '1' THEN 'XXXXX'				" ).append("\n"); 
		query.append("									                    WHEN '2' THEN 'XXXXX'				" ).append("\n"); 
		query.append("									                    WHEN '3' THEN 'XXXXX'				" ).append("\n"); 
		query.append("									                    WHEN '4' THEN LL.OFC_N5TH_LVL_CD				" ).append("\n"); 
		query.append("									                    WHEN '5' THEN LL.OFC_N5TH_LVL_CD				" ).append("\n"); 
		query.append("									                    WHEN '6' THEN LL.OFC_N5TH_LVL_CD				" ).append("\n"); 
		query.append("									                    WHEN '7' THEN LL.OFC_N5TH_LVL_CD				" ).append("\n"); 
		query.append("									                    WHEN '9' THEN 'XXXXX'				" ).append("\n"); 
		query.append("									                    ELSE 'XXXXX'				" ).append("\n"); 
		query.append("										            END = @[ofc_cd] /* LOGIN-OFFICE CODE BINDING */				" ).append("\n"); 
		query.append("									             OR LL.OFC_CD = @[ofc_cd] /* LOGIN-OFFICE CODE BINDING */				" ).append("\n"); 
		query.append("								     ) X" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("           #if (${sdate} != '')" ).append("\n"); 
		query.append("            AND TO_CHAR(A.RQST_ST_DT, 'YYYY-MM-DD') >= @[sdate]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${edate} != '')" ).append("\n"); 
		query.append("            AND TO_CHAR(A.RQST_ST_DT, 'YYYY-MM-DD') <= @[edate]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("		   #if (${s_csr_no} != '')" ).append("\n"); 
		query.append("		    AND E.CSR_NO LIKE '%'||@[s_csr_no]||'%'" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("     ) T" ).append("\n"); 

	}
}