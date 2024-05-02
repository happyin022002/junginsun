/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOSearchEacRegistrationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.19
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.03.19 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOSearchEacRegistrationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EAC Registration 데이터를 조회한다.
	  * </pre>
	  */
	public EacMgtDBDAOSearchEacRegistrationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOSearchEacRegistrationRSQL").append("\n"); 
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
		query.append("SELECT A.EAC_NO" ).append("\n"); 
		query.append("     , TO_CHAR(A.EAC_INP_DT,'YYYY-MM-DD') AS EAC_INP_DT " ).append("\n"); 
		query.append("     , A.AUDR_USR_ID" ).append("\n"); 
		query.append("     , A.AUDR_OFC_CD" ).append("\n"); 
		query.append("     ,(SELECT USR_NM FROM COM_USER WHERE USR_ID =A.AUDR_USR_ID) AS EAC_REG_USR_NM" ).append("\n"); 
		query.append("     , A.EAC_APRO_TP_CD" ).append("\n"); 
		query.append("     , A.EAC_STS_CD -- CD03337" ).append("\n"); 
		query.append("     ,CASE WHEN A.EAC_STS_CD = 'IS' AND A.EAC_SYS_IF_CD IS NOT NULL AND A.CRE_DT = A.UPD_DT" ).append("\n"); 
		query.append("           THEN A.EAC_SYS_IF_CD || ' I/F'" ).append("\n"); 
		query.append("           ELSE (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL X WHERE X.INTG_CD_ID = 'CD03337' AND X.INTG_CD_VAL_CTNT = A.EAC_STS_CD) " ).append("\n"); 
		query.append("      END AS EAC_STS_NM -- Status" ).append("\n"); 
		query.append("     , A.EAC_EXPN_TP_CD" ).append("\n"); 
		query.append("     , A.EAC_TP_CD" ).append("\n"); 
		query.append("     , A.EAC_BIL_TP_CD" ).append("\n"); 
		query.append("     , A.EAC_COST_DESC" ).append("\n"); 
		query.append("     , A.RESPB_OFC_CD" ).append("\n"); 
		query.append("     , A.VNDR_SEQ" ).append("\n"); 
		query.append("     , (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = A.VNDR_SEQ) AS VNDR_NM" ).append("\n"); 
		query.append("     , A.N3PTY_SRC_NO" ).append("\n"); 
		query.append("     , TO_CHAR(A.N3PTY_SRC_DT,'YYYY-MM-DD') AS N3PTY_SRC_DT" ).append("\n"); 
		query.append("     , A.YD_CD" ).append("\n"); 
		query.append("     , A.VVD_CD_CTNT" ).append("\n"); 
		query.append("     , A.CURR_CD" ).append("\n"); 
		query.append("     , A.INV_AMT" ).append("\n"); 
		query.append("     , A.INV_CNG_AMT" ).append("\n"); 
		query.append("     , A.INV_AUD_AMT" ).append("\n"); 
		query.append("     , A.INV_AUD_USD_AMT" ).append("\n"); 
		query.append("     , A.STL_AMT" ).append("\n"); 
		query.append("     , A.EXPN_EVID_DESC" ).append("\n"); 
		query.append("     , TO_CHAR(TO_DATE(A.EAC_YRMON,'YYYYMM'),'YYYY-MM') AS EAC_YRMON" ).append("\n"); 
		query.append("     , A.EAC_RSN_CD" ).append("\n"); 
		query.append("     , A.EAC_DESC" ).append("\n"); 
		query.append("     , A.EAC_INTER_RMK" ).append("\n"); 
		query.append("     , A.EAC_RSN_DESC" ).append("\n"); 
		query.append("     , A.EAC_CMPL_CD" ).append("\n"); 
		query.append("     , A.EAC_CMPL_DT" ).append("\n"); 
		query.append("     , A.NTC_HIS_SEQ" ).append("\n"); 
		query.append("     , A.VNDR_CNTC_PNT_SEQ" ).append("\n"); 
		query.append("     , A.EML_SUBJ_CTNT" ).append("\n"); 
		query.append("     , A.EML_CTNT" ).append("\n"); 
		query.append("     , TO_CHAR(A.EML_SND_DT,'YYYY-MM-DD') AS EML_SND_DT" ).append("\n"); 
		query.append("     , A.EAC_SYS_IF_CD" ).append("\n"); 
		query.append("     , A.DELT_FLG" ).append("\n"); 
		query.append("     , A.WO_NO_CTNT" ).append("\n"); 
		query.append("     , B.N3PTY_EXPN_TP_CD" ).append("\n"); 
		query.append("     , B.N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("     , B.BKG_NO" ).append("\n"); 
		query.append("     , B.BL_NO" ).append("\n"); 
		query.append("     , B.VNDR_CUST_DIV_CD" ).append("\n"); 
		query.append("     , B.VNDR_CNT_CD AS TPB_VNDR_CNT_CD" ).append("\n"); 
		query.append("     , B.VNDR_SEQ    AS TPB_VNDR_SEQ" ).append("\n"); 
		query.append("     , (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = B.VNDR_SEQ) AS TPB_VNDR_NM" ).append("\n"); 
		query.append("     , B.CUST_CNT_CD" ).append("\n"); 
		query.append("     , B.CUST_SEQ" ).append("\n"); 
		query.append("     , (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD= B.CUST_CNT_CD AND CUST_SEQ = B.CUST_SEQ ) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("     , B.N3PTY_OFC_CD" ).append("\n"); 
		query.append("     , (SELECT OFC_ENG_NM FROM MDM_ORGANIZATION WHERE OFC_CD = B.N3PTY_OFC_CD) AS OFC_ENG_NM" ).append("\n"); 
		query.append("     , B.N3PTY_NO" ).append("\n"); 
		query.append("     , C.EAC_RJCT_OFC_CD" ).append("\n"); 
		query.append("     , C.EAC_RJCT_USR_NM" ).append("\n"); 
		query.append("     , A.EAC_RJCT_RSN AS EAC_RJCT_DESC  -- Reason of rejection" ).append("\n"); 
		query.append("     , C.EAC_RJCT_RSN -- Reason of Unapproval" ).append("\n"); 
		query.append("     , D.EAC_NO AS ISFLAG" ).append("\n"); 
		query.append("     , (SELECT DECODE(COUNT(1),0,'N','Y') FROM EAS_EXPN_AUD_CS_ATCH_FILE WHERE EAC_NO = A.EAC_NO ) AS FILEFLAG" ).append("\n"); 
		query.append("     , A.KPI_OFC_CD" ).append("\n"); 
		query.append("FROM   EAS_EXPN_AUD_CS_MGMT A" ).append("\n"); 
		query.append("     , EAS_EXPN_AUD_CS_N3RD_PTY B" ).append("\n"); 
		query.append("     , (SELECT X.EAC_NO" ).append("\n"); 
		query.append("              ,X.APRO_OFC_CD  AS EAC_RJCT_OFC_CD" ).append("\n"); 
		query.append("              ,X.EAC_APRO_RSN AS EAC_RJCT_RSN" ).append("\n"); 
		query.append("              ,(SELECT USR_NM FROM COM_USER XX WHERE XX.USR_ID = X.APRO_USR_ID) AS EAC_RJCT_USR_NM" ).append("\n"); 
		query.append("          FROM EAS_EXPN_AUD_CS_APRO_STEP X" ).append("\n"); 
		query.append("         WHERE X.EAC_NO = @[eac_no]" ).append("\n"); 
		query.append("           AND X.EAC_STS_CD IN ('RR', 'HR')" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) C" ).append("\n"); 
		query.append("     , EAS_EXPN_AUD_CS_RJCT_HIS D" ).append("\n"); 
		query.append("WHERE  A.EAC_NO = B.EAC_NO" ).append("\n"); 
		query.append("AND    A.EAC_NO = C.EAC_NO(+)" ).append("\n"); 
		query.append("AND    A.EAC_NO = D.EAC_NO(+)" ).append("\n"); 
		query.append("AND    A.EAC_NO =  @[eac_no]" ).append("\n"); 

	}
}