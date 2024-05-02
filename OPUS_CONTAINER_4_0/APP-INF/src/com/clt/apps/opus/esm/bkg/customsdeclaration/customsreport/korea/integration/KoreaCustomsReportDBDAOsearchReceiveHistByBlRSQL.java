/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : KoreaCustomsReportDBDAOsearchReceiveHistByBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KoreaCustomsReportDBDAOsearchReceiveHistByBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 관세청에서 수신된 응답문서들의 현황을 MSG Type(5CG)과 B/L No로 조회
	  * </pre>
	  */
	public KoreaCustomsReportDBDAOsearchReceiveHistByBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("msg_log_tp_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.integration").append("\n"); 
		query.append("FileName : KoreaCustomsReportDBDAOsearchReceiveHistByBlRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT RLOG.MSG_LOG_TP_CD AS MSG_LOG_TP_CD" ).append("\n"); 
		query.append("     , TO_CHAR(RLOG.RCV_DT,'yyyy-mm-dd hh24:mi:ss') AS RCV_DT" ).append("\n"); 
		query.append("     , SLOG.VSL_CD||SLOG.SKD_VOY_NO||SLOG.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("     , SLOG.POL_CD AS POL_CD" ).append("\n"); 
		query.append("     , SLOG.POD_CD AS POD_CD" ).append("\n"); 
		query.append("     , SLOG.OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("     , RLOG.BL_NO AS BL_NO" ).append("\n"); 
		query.append("     , RLOG.SMT_AMD_NO AS SMT_AMD_NO" ).append("\n"); 
		query.append("     , DECODE(RLOG.KR_CSTMS_ACPT_CD,'1','승인','2','부분 승인','3','오류') AS MSG_STS" ).append("\n"); 
		query.append("     , RLOG.KR_CSTMS_RJCT_RSN1 AS MSG_TEXT" ).append("\n"); 
		query.append("     , SLOG.CRE_USR_ID AS USER_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_KR_RCV_LOG RLOG," ).append("\n"); 
		query.append("       BKG_CSTMS_KR_SND_LOG SLOG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE RLOG.SMT_AMD_NO = SLOG.SMT_AMD_NO(+)" ).append("\n"); 
		query.append("   AND RLOG.MSG_LOG_TP_CD = NVL(@[msg_log_tp_id],RLOG.MSG_LOG_TP_CD)" ).append("\n"); 
		query.append("   AND RLOG.BL_NO = @[bl_no]" ).append("\n"); 
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

	}
}