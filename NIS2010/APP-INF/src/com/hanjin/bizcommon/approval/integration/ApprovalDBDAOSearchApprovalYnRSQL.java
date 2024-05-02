/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ApprovalDBDAOSearchApprovalYnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.17
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2014.07.17 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.approval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApprovalDBDAOSearchApprovalYnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 금액이 10만불인 경우 결재라인에 CEO가 있는지 조회
	  * </pre>
	  */
	public ApprovalDBDAOSearchApprovalYnRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_amt",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.approval.integration").append("\n"); 
		query.append("FileName : ApprovalDBDAOSearchApprovalYnRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("        CASE WHEN A.CNT < 2 THEN  'N'     --결재라인은 최소 2건이상" ).append("\n"); 
		query.append("             ELSE" ).append("\n"); 
		query.append("                CASE WHEN B.AMT_YN = 'Y' AND A.SEQ = 1 AND A.CEO_YN = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                     WHEN B.AMT_YN = 'N' AND A.SEQ = 1 AND A.CHARGE_YN = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                     ELSE 'N'" ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("        END AS APPROVAL_YN" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT  A.APRO_SEQ," ).append("\n"); 
		query.append("                A.APRO_USR_ID," ).append("\n"); 
		query.append("                A.APRO_USR_NM," ).append("\n"); 
		query.append("                B.OFC_CD APRO_OFC_CD," ).append("\n"); 
		query.append("                A.APRO_USR_JB_TIT_NM" ).append("\n"); 
		query.append("                ,COUNT(1) OVER() AS CNT" ).append("\n"); 
		query.append("                ,ROW_NUMBER() OVER(ORDER BY A.APRO_SEQ DESC) AS SEQ" ).append("\n"); 
		query.append("                ,AP_COM_CHECK_CEO_YN_FNC(A.APRO_USR_ID)      AS CEO_YN	 			-- CEO여부" ).append("\n"); 
		query.append("                ,AP_COM_CHECK_MGR_YN_FNC(A.APRO_USR_ID)   	 AS CHARGE_YN			-- 본부장여부" ).append("\n"); 
		query.append("        FROM COM_APRO_ROUT_DFLT_DTL A, COM_USER B" ).append("\n"); 
		query.append("        WHERE B.USE_FLG = 'Y'" ).append("\n"); 
		query.append("        AND NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("        AND A.APRO_USR_ID IN (B.USR_ID, B.EP_ID)" ).append("\n"); 
		query.append("        AND A.APRO_ROUT_SEQ = (" ).append("\n"); 
		query.append("                                SELECT APRO_ROUT_SEQ" ).append("\n"); 
		query.append("                                FROM COM_APRO_ROUT_DFLT" ).append("\n"); 
		query.append("                                WHERE SUB_SYS_CD = DECODE(@[sub_sys_cd],'TLL','MNR',@[sub_sys_cd])" ).append("\n"); 
		query.append("                                AND OFC_CD     = @[ofc_cd]        " ).append("\n"); 
		query.append("                              )  " ).append("\n"); 
		query.append("        AND ROWNUM = 1                      " ).append("\n"); 
		query.append("    ) A                              " ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("             CASE WHEN ROUND(NVL(@[locl_amt]/ DECODE(@[curr_cd],'USD',1, " ).append("\n"); 
		query.append("					                                                  (SELECT NVL(EX1.USD_LOCL_XCH_RT, 1) " ).append("\n"); 
		query.append("                        	                                           FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("                               					                       WHERE EX1.CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("                                                   					     AND EX1.ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE,'YYYYMM')" ).append("\n"); 
		query.append("					                                                     AND EX1.ACCT_XCH_RT_LVL = '1')" ).append("\n"); 
		query.append("                    					                            )" ).append("\n"); 
		query.append("                             ,0),2) >= 100000 THEN 'Y'" ).append("\n"); 
		query.append("                   ELSE 'N'" ).append("\n"); 
		query.append("                   END AS AMT_YN" ).append("\n"); 
		query.append("        FROM DUAL" ).append("\n"); 
		query.append("    ) B" ).append("\n"); 

	}
}