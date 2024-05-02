/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : FaxEmailDBDAOSearchAfterBookingAproUserEmailByDARNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.08
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.08 
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

public class FaxEmailDBDAOSearchAfterBookingAproUserEmailByDARNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FaxEmailDBDAOSearchAfterBookingAproUserEmailByDARNoRSQL
	  * </pre>
	  */
	public FaxEmailDBDAOSearchAfterBookingAproUserEmailByDARNoRSQL(){
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
		query.append("FileName : FaxEmailDBDAOSearchAfterBookingAproUserEmailByDARNoRSQL").append("\n"); 
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
		query.append("SELECT  BKG_JOIN_FNC(CURSOR((" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	--// 다음 승인단계 승인권자 메일주소 조회" ).append("\n"); 
		query.append("	SELECT  T4.USR_EML" ).append("\n"); 
		query.append("	  FROM  DMT_AFT_BKG_APRO_PATH 	T1" ).append("\n"); 
		query.append("		   ,DMT_HRD_CDG_CTNT		T2" ).append("\n"); 
		query.append("		   ,DMT_USR_ROLE_MTCH		T3" ).append("\n"); 
		query.append("		   ,COM_USER				T4" ).append("\n"); 
		query.append("	 WHERE  T1.AFT_EXPT_DAR_NO  = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("	   AND  T1.AFT_BKG_PATH_LVL = " ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				SELECT  MIN(AFT_BKG_PATH_LVL) " ).append("\n"); 
		query.append("				  FROM  DMT_AFT_BKG_APRO_PATH" ).append("\n"); 
		query.append("				 WHERE  AFT_EXPT_DAR_NO       = T1.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("				   AND  AFT_BKG_PATH_CPLS_FLG = 'Y'" ).append("\n"); 
		query.append("				   AND  DMDT_EXPT_RQST_STS_CD IS NULL 		" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("	   AND  T2.HRD_CDG_ID       = 'AFT_BKG_APRO_PATH'" ).append("\n"); 
		query.append("	   AND  T2.HRD_CDG_ID_SEQ   = T1.AFT_BKG_PATH_LVL" ).append("\n"); 
		query.append("	   AND  T2.ATTR_CTNT6       = T3.USR_ROLE_CD" ).append("\n"); 
		query.append("	   AND  T3.USR_ID           = T4.USR_ID" ).append("\n"); 
		query.append("	   AND  T4.USE_FLG          = 'Y'   " ).append("\n"); 
		query.append("	   AND  T1.APRO_OFC_CD      = DECODE(T1.APRO_OFC_CD, 'SELHO', T1.APRO_OFC_CD, T4.OFC_CD)" ).append("\n"); 
		query.append("       AND  NOT EXISTS " ).append("\n"); 
		query.append("			( " ).append("\n"); 
		query.append("				SELECT  'X' " ).append("\n"); 
		query.append("				  FROM  DMT_AFT_BKG_ADJ_RQST " ).append("\n"); 
		query.append("				 WHERE  AFT_EXPT_DAR_NO = T1.AFT_EXPT_DAR_NO " ).append("\n"); 
		query.append("				   AND  DMDT_EXPT_RQST_STS_CD IN ('O', 'J')" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append("	--// 다음 승인단계 승인권자를 제외한 요청 사용자부터 현재 승인단계의 승인권자까지의 메일주소 조회" ).append("\n"); 
		query.append("	SELECT  T2.USR_EML" ).append("\n"); 
		query.append("	  FROM  DMT_AFT_BKG_ADJ_PROG	T1" ).append("\n"); 
		query.append("           ,COM_USER				T2" ).append("\n"); 
		query.append("	 WHERE  T1.AFT_EXPT_DAR_NO = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("	   AND  T1.PROG_SEQ >=" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				SELECT	/*+ INDEX_DESC(DMT_AFT_BKG_ADJ_PROG XPKDMT_AFT_BKG_ADJ_PROG) */ PROG_SEQ" ).append("\n"); 
		query.append("				  FROM  DMT_AFT_BKG_ADJ_PROG" ).append("\n"); 
		query.append("				 WHERE  AFT_EXPT_DAR_NO       = T1.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("				   AND  DMDT_EXPT_RQST_STS_CD = 'R'" ).append("\n"); 
		query.append("				   AND  ROWNUM                = 1" ).append("\n"); 
		query.append("			)		" ).append("\n"); 
		query.append("	   AND  T1.PROG_SEQ   != " ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				SELECT  /*+ INDEX_DESC(DMT_AFT_BKG_ADJ_PROG XPKDMT_AFT_BKG_ADJ_PROG) */ PROG_SEQ" ).append("\n"); 
		query.append("				  FROM  DMT_AFT_BKG_ADJ_PROG" ).append("\n"); 
		query.append("				 WHERE  AFT_EXPT_DAR_NO = T1.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("				   AND  ROWNUM          = 1" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("	   AND  T1.PROG_USR_ID = T2.USR_ID" ).append("\n"); 
		query.append("	   AND  T2.USE_FLG     = 'Y'" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append("	)),';')" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("  FROM  DUAL" ).append("\n"); 

	}
}