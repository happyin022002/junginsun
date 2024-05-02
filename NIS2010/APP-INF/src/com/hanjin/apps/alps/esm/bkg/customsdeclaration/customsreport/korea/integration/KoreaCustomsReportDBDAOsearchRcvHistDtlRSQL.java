/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : KoreaCustomsReportDBDAOsearchRcvHistDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.25
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

public class KoreaCustomsReportDBDAOsearchRcvHistDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Korea에서 입/출항 선박 신고 적하목록 전송 문서의 상세내역 조회
	  * </pre>
	  */
	public KoreaCustomsReportDBDAOsearchRcvHistDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("smt_amd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flt_file_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.integration").append("\n"); 
		query.append("FileName : KoreaCustomsReportDBDAOsearchRcvHistDtlRSQL").append("\n"); 
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
		query.append("SELECT RDTL.EDI_RCV_MSG AS EDI_RCV_MSG" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_KR_RCV_LOG RLOG, BKG_CSTMS_KR_RCV_LOG_DTL RDTL" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND RLOG.FLT_FILE_REF_NO = RDTL.FLT_FILE_REF_NO" ).append("\n"); 
		query.append("   AND RLOG.RCV_SEQ = RDTL.RCV_SEQ" ).append("\n"); 
		query.append("   AND RLOG.RCV_DT = RDTL.RCV_DT" ).append("\n"); 
		query.append("   AND RLOG.MSG_LOG_TP_CD = @[msg_log_tp_id]" ).append("\n"); 
		query.append("   AND RLOG.RCV_DT = TO_DATE(@[rcv_dt], 'YYYY-MM-DD hh24:mi:ss')" ).append("\n"); 
		query.append("   AND RLOG.RCV_SEQ = @[rcv_seq]" ).append("\n"); 
		query.append("   AND RLOG.FLT_FILE_REF_NO = @[flt_file_ref_no]" ).append("\n"); 
		query.append("#if(${msg_log_tp_id} == 'SCA' || ${msg_log_tp_id} == '5LI' || ${msg_log_tp_id} == '5LK')" ).append("\n"); 
		query.append("   AND RLOG.SMT_AMD_NO = @[smt_amd_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY RDTL.LOG_DTL_SEQ" ).append("\n"); 

	}
}