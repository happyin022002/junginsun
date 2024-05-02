/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : FaxEmailDBDAOSearchAfterBookingUserEmailByDARNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FaxEmailDBDAOSearchAfterBookingUserEmailByDARNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 승인시 After Booking DAR 을 요청한 사용자에게 메일을 보내기 위해서 메일정보를 조회하기 위한 쿼리
	  * </pre>
	  */
	public FaxEmailDBDAOSearchAfterBookingUserEmailByDARNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.integration").append("\n"); 
		query.append("FileName : FaxEmailDBDAOSearchAfterBookingUserEmailByDARNoRSQL").append("\n"); 
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
		query.append("SELECT BKG_JOIN_FNC(CURSOR((" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT C.USR_EML" ).append("\n"); 
		query.append("        FROM DMT_AFT_BKG_APRO_PATH A, DMT_USR_ROLE_MTCH B, COM_USER C" ).append("\n"); 
		query.append("        WHERE A.AFT_EXPT_DAR_NO = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("        AND A.AFT_BKG_PATH_LVL = (" ).append("\n"); 
		query.append("                                SELECT MIN(AFT_BKG_PATH_LVL) " ).append("\n"); 
		query.append("                                FROM DMT_AFT_BKG_APRO_PATH" ).append("\n"); 
		query.append("                                WHERE AFT_EXPT_DAR_NO = A.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                                AND AFT_BKG_PATH_CPLS_FLG = 'Y'" ).append("\n"); 
		query.append("                                AND DMDT_EXPT_RQST_STS_CD IS NULL )" ).append("\n"); 
		query.append("        AND DECODE(A.APRO_OFC_CD,'SELHO',SUBSTR(A.APRO_OFC_CD,1,5),SUBSTR(C.OFC_CD,1,5)) = SUBSTR(A.APRO_OFC_CD,1,5)" ).append("\n"); 
		query.append("        AND C.USR_ID = B.USR_ID" ).append("\n"); 
		query.append("        AND C.USE_FLG = 'Y'" ).append("\n"); 
		query.append("        AND CASE WHEN A.AFT_BKG_PATH_CD = 'SSZMGR' THEN 'DMT50'" ).append("\n"); 
		query.append("                 WHEN A.AFT_BKG_PATH_CD = 'BBOPIC' THEN 'DMT30'" ).append("\n"); 
		query.append("                 WHEN A.AFT_BKG_PATH_CD = 'BBGMGR' THEN 'DMT03'" ).append("\n"); 
		query.append("                 WHEN A.AFT_BKG_PATH_CD = 'RHQPIC' THEN 'DMT02'" ).append("\n"); 
		query.append("                 WHEN A.AFT_BKG_PATH_CD = 'RHQMGR' THEN 'DMT20'" ).append("\n"); 
		query.append("                 WHEN A.AFT_BKG_PATH_CD = 'HDOPIC' THEN 'DMT01'" ).append("\n"); 
		query.append("                 WHEN A.AFT_BKG_PATH_CD = 'HDOMGR' THEN 'DMT10'" ).append("\n"); 
		query.append("                 ELSE '0' END = B.USR_ROLE_CD" ).append("\n"); 
		query.append("		AND NOT EXISTS ( SELECT 'X' FROM DMT_AFT_BKG_ADJ_RQST WHERE AFT_EXPT_DAR_NO = A.AFT_EXPT_DAR_NO AND DMDT_EXPT_RQST_STS_CD IN ( 'O', 'J' ))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT	COM_USER.USR_EML" ).append("\n"); 
		query.append("        FROM	DMT_AFT_BKG_ADJ_PROG ADJ_PROG" ).append("\n"); 
		query.append("        	,	COM_USER" ).append("\n"); 
		query.append("        WHERE	ADJ_PROG.AFT_EXPT_DAR_NO = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("        	AND	ADJ_PROG.PROG_SEQ >=" ).append("\n"); 
		query.append("        		(" ).append("\n"); 
		query.append("        			SELECT	/*+ INDEX_DESC(DMT_AFT_BKG_ADJ_PROG XPKDMT_AFT_BKG_ADJ_PROG) */ PROG_SEQ" ).append("\n"); 
		query.append("        			FROM	DMT_AFT_BKG_ADJ_PROG" ).append("\n"); 
		query.append("        			WHERE	AFT_EXPT_DAR_NO = ADJ_PROG.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("        				AND	DMDT_EXPT_RQST_STS_CD = 'R'" ).append("\n"); 
		query.append("        				AND ROWNUM = 1" ).append("\n"); 
		query.append("        		)		" ).append("\n"); 
		query.append("        	AND	ADJ_PROG.PROG_USR_ID = COM_USER.USR_ID" ).append("\n"); 
		query.append("        	AND ADJ_PROG.PROG_SEQ != " ).append("\n"); 
		query.append("        	   (" ).append("\n"); 
		query.append("        			SELECT	/*+ INDEX_DESC(DMT_AFT_BKG_ADJ_PROG XPKDMT_AFT_BKG_ADJ_PROG) */ PROG_SEQ" ).append("\n"); 
		query.append("        			FROM	DMT_AFT_BKG_ADJ_PROG" ).append("\n"); 
		query.append("        			WHERE	AFT_EXPT_DAR_NO = ADJ_PROG.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("        				AND ROWNUM = 1" ).append("\n"); 
		query.append("        		)	)),';')" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}