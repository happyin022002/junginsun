/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BRKGAuditDBDAOSearchAPActualApprovalRequestListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.21
*@LastModifier : 이정수
*@LastVersion : 1.0
* 2011.12.21 이정수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jeong Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BRKGAuditDBDAOSearchAPActualApprovalRequestListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Brokerage Approval & Request 할 대상리스트를 가져온다
	  * </pre>
	  */
	public BRKGAuditDBDAOSearchAPActualApprovalRequestListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.integration").append("\n"); 
		query.append("FileName : BRKGAuditDBDAOSearchAPActualApprovalRequestListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	FWDR, " ).append("\n"); 
		query.append("	VNDR_SEQ, " ).append("\n"); 
		query.append("	AP_OFC_CD, " ).append("\n"); 
		query.append("	FINC_RGN_CD " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("		DISTINCT A.FRT_FWRD_CNT_CD||TO_CHAR(A.FRT_FWRD_SEQ, 'FM000000')  AS FWDR," ).append("\n"); 
		query.append("			A.VNDR_SEQ AS VNDR_SEQ, " ).append("\n"); 
		query.append("			A.AP_OFC_CD AS AP_OFC_CD, " ).append("\n"); 
		query.append("			FINC_RGN_CD" ).append("\n"); 
		query.append("	FROM AGT_BROG_COMM A, " ).append("\n"); 
		query.append("			MDM_ORGANIZATION B, " ).append("\n"); 
		query.append("			AGT_COMM_BKG_INFO C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sts_option} == '1') " ).append("\n"); 
		query.append(" WHERE A.VSL_DEP_DT BETWEEN TO_DATE(REPLACE(@[search_dt_fr], '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(@[search_dt_to], '-'), 'YYYYMMDD')+0.999999--//:stsOpt,:frDate,:toDate" ).append("\n"); 
		query.append("#elseif (${sts_option} == '2') " ).append("\n"); 
		query.append(" WHERE A.CRE_DT BETWEEN TO_DATE(REPLACE(@[search_dt_fr], '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(@[search_dt_to], '-'), 'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND A.COMM_PROC_STS_CD IN('CS','CM','CA')" ).append("\n"); 
		query.append("    AND A.FRT_FWRD_CNT_CD||TO_CHAR(A.FRT_FWRD_SEQ,'FM000000')||A.VNDR_SEQ||A.AP_OFC_CD IN(${fwdr_vndr_seq_ap_ofc_cd})" ).append("\n"); 
		query.append("    AND A.BROG_IF_DT IS NULL" ).append("\n"); 
		query.append("    AND A.CRE_USR_ID != 'COST'" ).append("\n"); 
		query.append("    AND A.AP_OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("    AND A.BKG_NO       = C.BKG_NO" ).append("\n"); 
		query.append("    AND C.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("    AND A.BROG_SEQ = (" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("			MAX(D.BROG_SEQ)" ).append("\n"); 
		query.append("        FROM AGT_BROG_COMM D" ).append("\n"); 
		query.append("        WHERE D.BKG_NO = A.BKG_NO--//:stsOpt,:frDate,:toDate" ).append("\n"); 
		query.append("        AND D.FRT_FWRD_CNT_CD||TO_CHAR(D.FRT_FWRD_SEQ,'FM000000')||D.VNDR_SEQ||D.AP_OFC_CD IN(${fwdr_vndr_seq_ap_ofc_cd})" ).append("\n"); 
		query.append("        AND BROG_IF_DT IS NULL" ).append("\n"); 
		query.append("        GROUP BY D.BKG_NO" ).append("\n"); 
		query.append("	) " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}