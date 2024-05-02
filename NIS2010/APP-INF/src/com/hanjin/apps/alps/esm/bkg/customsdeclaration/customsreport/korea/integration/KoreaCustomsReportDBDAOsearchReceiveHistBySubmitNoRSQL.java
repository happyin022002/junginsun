/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : KoreaCustomsReportDBDAOsearchReceiveHistBySubmitNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.24
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KoreaCustomsReportDBDAOsearchReceiveHistBySubmitNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 관세청에서 수신된 응답문서들의 현황을 Submit No로 조회
	  * </pre>
	  */
	public KoreaCustomsReportDBDAOsearchReceiveHistBySubmitNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cboMsgTp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("smt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.integration").append("\n"); 
		query.append("FileName : KoreaCustomsReportDBDAOsearchReceiveHistBySubmitNoRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT RLOG.MSG_LOG_TP_CD MSG_LOG_TP_CD" ).append("\n"); 
		query.append("     , TO_CHAR(RLOG.RCV_DT,'yyyy-mm-dd hh24:mi:ss') RCV_DT" ).append("\n"); 
		query.append("     , SLOG.VSL_CD||SLOG.SKD_VOY_NO||SLOG.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("     , SLOG.POL_CD POL_CD" ).append("\n"); 
		query.append("     , SLOG.POD_CD POD_CD" ).append("\n"); 
		query.append("     , SLOG.OFC_CD OFC_CD" ).append("\n"); 
		query.append("     , RLOG.BL_NO BL_NO" ).append("\n"); 
		query.append("     , RLOG.SMT_AMD_NO SMT_AMD_NO" ).append("\n"); 
		query.append("     , DECODE(RLOG.KR_CSTMS_ACPT_CD,'1','승인','2','부분 승인','3','오류') MSG_STS" ).append("\n"); 
		query.append("     , RDTL.KR_CSTMS_RJCT_RSN1 MSG_TEXT" ).append("\n"); 
		query.append("     , SLOG.CRE_USR_ID USER_ID" ).append("\n"); 
		query.append("	 , RLOG.RCV_SEQ" ).append("\n"); 
		query.append(" 	 , RLOG.FLT_FILE_REF_NO" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_RCV_LOG RLOG, BKG_CSTMS_KR_RCV_LOG_DTL RDTL, BKG_CSTMS_KR_SND_LOG SLOG" ).append("\n"); 
		query.append(" WHERE RLOG.MSG_LOG_TP_CD = RDTL.MSG_LOG_TP_CD" ).append("\n"); 
		query.append("   AND RLOG.RCV_DT        = RDTL.RCV_DT" ).append("\n"); 
		query.append("   AND RLOG.RCV_SEQ       = RDTL.RCV_SEQ" ).append("\n"); 
		query.append("   AND RLOG.FLT_FILE_REF_NO = RDTL.FLT_FILE_REF_NO" ).append("\n"); 
		query.append("   AND RLOG.SMT_AMD_NO    = SLOG.SMT_AMD_NO" ).append("\n"); 
		query.append("   AND RLOG.MSG_LOG_TP_CD = @[cboMsgTp] 	" ).append("\n"); 
		query.append("   AND RLOG.SMT_AMD_NO    = @[smt_no]" ).append("\n"); 
		query.append("#if(${tp_cd} != 'D')" ).append("\n"); 
		query.append("   AND NVL(SLOG.KR_CSTMS_DECL_CD,' ') LIKE @[tp_cd]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${pol_cd} != '')" ).append("\n"); 
		query.append("   AND SLOG.POL_CD LIKE @[pol_cd]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${pod_cd} != '')" ).append("\n"); 
		query.append("   AND SLOG.POD_CD LIKE @[pod_cd]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ofc_cd} != '')" ).append("\n"); 
		query.append("   AND SLOG.OFC_CD LIKE @[ofc_cd]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${user_id} != '')" ).append("\n"); 
		query.append("   AND SLOG.TRSM_USR_ID LIKE @[user_id]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY RCV_DT DESC" ).append("\n"); 

	}
}