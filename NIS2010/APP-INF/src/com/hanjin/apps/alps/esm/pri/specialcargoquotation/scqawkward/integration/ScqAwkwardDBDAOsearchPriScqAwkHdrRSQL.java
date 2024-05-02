/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ScqAwkwardDBDAOsearchPriScqAwkHdrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.23
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2015.04.23 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHojin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqAwkwardDBDAOsearchPriScqAwkHdrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_SCQ_AWK_MN 
	  * PRI_SCQ_PROG
	  * 
	  * * History
	  * 2013.06.26 이혜민 [CHM-201325215] Special cargo Quotation System 수정 요청 - Approver Name 추가, Request ID는 Requester Name으로 변경
	  * 2013.07.22 송호진 [CHM-201325102] Special cargo Quotation System 추가 수정 요청건 - Approval 상태 Cancel, Delete 기능 추가
	  * 2015.04.23 송호진 [CHM-201533702] SCQ내에 Unit Dual (cm/Inch) System 개발 요청
	  * </pre>
	  */
	public ScqAwkwardDBDAOsearchPriScqAwkHdrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration").append("\n"); 
		query.append("FileName : ScqAwkwardDBDAOsearchPriScqAwkHdrRSQL").append("\n"); 
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
		query.append("SELECT MN.SCQ_RQST_NO                      " ).append("\n"); 
		query.append("     , MN.SCQ_VER_NO                       " ).append("\n"); 
		query.append("     , MN.PROG_STS_CD                      " ).append("\n"); 
		query.append("     , MN.RQST_OFC_CD                      " ).append("\n"); 
		query.append("     , MN.RQST_SREP_CD                     " ).append("\n"); 
		query.append("     , MN.POR_CD                           " ).append("\n"); 
		query.append("     , MN.POL_CD                           " ).append("\n"); 
		query.append("     , MN.POL_YD_CD                        " ).append("\n"); 
		query.append("     , MN.POD_CD                           " ).append("\n"); 
		query.append("     , MN.POD_YD_CD                        " ).append("\n"); 
		query.append("     , MN.DEL_CD                           " ).append("\n"); 
		query.append("     , MN.SVC_SCP_CD                       " ).append("\n"); 
		query.append("     , MN.CUST_CNT_CD                      " ).append("\n"); 
		query.append("     , MN.CUST_SEQ                         " ).append("\n"); 
		query.append("     , MN.RCV_TERM_CD                      " ).append("\n"); 
		query.append("     , MN.DE_TERM_CD                       " ).append("\n"); 
		query.append("     , TO_CHAR(MN.PROP_EFF_DT,'YYYY-MM-DD') AS PROP_EFF_DT                     " ).append("\n"); 
		query.append("     , TO_CHAR(MN.PROP_EXP_DT,'YYYY-MM-DD') AS PROP_EXP_DT                     " ).append("\n"); 
		query.append("     , TO_CHAR(MN.APRO_EFF_DT,'YYYY-MM-DD') AS APRO_EFF_DT                     " ).append("\n"); 
		query.append("     , TO_CHAR(MN.APRO_EXP_DT,'YYYY-MM-DD') AS APRO_EXP_DT                     " ).append("\n"); 
		query.append("     , MN.DELT_FLG                         " ).append("\n"); 
		query.append("     , MN.CRE_USR_ID                " ).append("\n"); 
		query.append("     , MN.CRE_DT                           " ).append("\n"); 
		query.append("     , MN.UPD_USR_ID                       " ).append("\n"); 
		query.append("     , MN.UPD_DT   " ).append("\n"); 
		query.append("     , MN.APRO_OFC_CD                         " ).append("\n"); 
		query.append("     , PG.SPCL_CGO_TP_CD                   " ).append("\n"); 
		query.append("     , PG.PROG_SEQ                               " ).append("\n"); 
		query.append("     , PG.PROG_STS_CD    AS PG_PROG_STS_CD         " ).append("\n"); 
		query.append("     , PG.PROG_OFC_CD                       " ).append("\n"); 
		query.append("     , (SELECT USR_NM FROM COM_USER WHERE USR_ID = PG.PROG_USR_ID) PROG_USR_NM" ).append("\n"); 
		query.append("     , PG.PROG_USR_ID                    " ).append("\n"); 
		query.append("     , PG.PROG_DT                          " ).append("\n"); 
		query.append("     , PG.PROG_RMK" ).append("\n"); 
		query.append("     , (SELECT SREP_NM NM" ).append("\n"); 
		query.append("          FROM MDM_SLS_REP" ).append("\n"); 
		query.append("         WHERE SREP_CD      = MN.RQST_SREP_CD" ).append("\n"); 
		query.append("           AND SREP_STS_CD  = 'N'" ).append("\n"); 
		query.append("           AND ROWNUM <= 1) AS RQST_SREP_NM" ).append("\n"); 
		query.append("     , (SELECT CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("          FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("         WHERE CUST_CNT_CD  = MN.CUST_CNT_CD" ).append("\n"); 
		query.append("           AND CUST_SEQ     = MN.CUST_SEQ" ).append("\n"); 
		query.append("           AND ROWNUM <= 1) AS CUST_LGL_ENG_NM    " ).append("\n"); 
		query.append("     , (SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID       = 'CD03161'" ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = MN.PROG_STS_CD" ).append("\n"); 
		query.append("           AND ROWNUM <= 1)     AS PROG_STS_NM  " ).append("\n"); 
		query.append("     , (SELECT 1 FROM PRI_AUTHORIZATION AUTH" ).append("\n"); 
		query.append("         WHERE PRC_CTRT_TP_CD >= ' '" ).append("\n"); 
		query.append("           AND AUTH.SVC_SCP_CD = MN.SVC_SCP_CD        " ).append("\n"); 
		query.append("		   AND USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("           AND ROWNUM <= 1) AS AUTH             " ).append("\n"); 
		query.append("     , NVL2 ( " ).append("\n"); 
		query.append("       (SELECT 1 FROM PRI_SCQ_AWK_MN MX" ).append("\n"); 
		query.append("         WHERE MX.SCQ_RQST_NO = MN.SCQ_RQST_NO" ).append("\n"); 
		query.append("           AND MX.SCQ_VER_NO > MN.SCQ_VER_NO " ).append("\n"); 
		query.append("           AND ROWNUM <= 1 ), 'N', 'Y' ) AS LAST_FLG" ).append("\n"); 
		query.append("     , MN.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("     , MN.ACT_CUST_SEQ" ).append("\n"); 
		query.append("     , NVL ( MN.ACT_CUST_NM, " ).append("\n"); 
		query.append("       (SELECT CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("          FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("         WHERE CUST_CNT_CD  = MN.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("           AND CUST_SEQ     = MN.ACT_CUST_SEQ" ).append("\n"); 
		query.append("           AND ROWNUM <= 1) ) AS ACT_CUST_NM  " ).append("\n"); 
		query.append("     , MN.SCQ_BID_FLG " ).append("\n"); 
		query.append("     , NVL ( MN.MEAS_SYS_CD, 'M' ) AS MEAS_SYS_CD" ).append("\n"); 
		query.append("     , NVL ( MN.MEAS_SYS_CD, 'M' ) AS MEAS_SYS_CD_VW" ).append("\n"); 
		query.append("     , '' AS PRE_PROG_STS_CD" ).append("\n"); 
		query.append("     , '' AS RSLT_FLG" ).append("\n"); 
		query.append("     , '' AS SCQ_RQST_NO_TMP" ).append("\n"); 
		query.append("     , '' AS SCQ_VER_NO_TMP" ).append("\n"); 
		query.append("  FROM PRI_SCQ_AWK_MN MN                   " ).append("\n"); 
		query.append("     , PRI_SCQ_PROG PG                     " ).append("\n"); 
		query.append(" WHERE MN.SCQ_RQST_NO = @[scq_rqst_no]     " ).append("\n"); 
		query.append("   AND MN.SCQ_VER_NO = @[scq_ver_no]       " ).append("\n"); 
		query.append("   AND PG.SCQ_RQST_NO = MN.SCQ_RQST_NO     " ).append("\n"); 
		query.append("   AND PG.SCQ_VER_NO = MN.SCQ_VER_NO" ).append("\n"); 
		query.append("   AND PG.SPCL_CGO_TP_CD = 'AK'       " ).append("\n"); 
		query.append("ORDER BY PROG_SEQ DESC" ).append("\n"); 

	}
}