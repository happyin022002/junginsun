/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OnOffHireAuditDBDAOsearchAuditResultOnOffHirelistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.17
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2010.02.17 진준성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containercostanalysis.onoffhireaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jin Jun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnOffHireAuditDBDAOsearchAuditResultOnOffHirelistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Audit Result 리스트를 조회
	  * </pre>
	  */
	public OnOffHireAuditDBDAOsearchAuditResultOnOffHirelistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("audit_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aud_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_aud_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containercostanalysis.onoffhireaudit.integration").append("\n"); 
		query.append("FileName : OnOffHireAuditDBDAOsearchAuditResultOnOffHirelistRSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("    A.AGMT_CTY_CD|| LTRIM(TO_CHAR(A.AGMT_SEQ,'000000')) AGMT_NO" ).append("\n"); 
		query.append("   ,A.AGMT_CTY_CD" ).append("\n"); 
		query.append("   ,A.AGMT_SEQ" ).append("\n"); 
		query.append("   ,A.REF_NO " ).append("\n"); 
		query.append("   ,A.LSTM_CD" ).append("\n"); 
		query.append("   ,A.CNTR_NO" ).append("\n"); 
		query.append("   ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("   ,TO_CHAR(A.ONH_DT , 'YYYY-MM-DD') ONH_DT" ).append("\n"); 
		query.append("   ,A.ONH_LOC_CD" ).append("\n"); 
		query.append("   ,TO_CHAR(A.OFFH_DT, 'YYYY-MM-DD') OFFH_DT" ).append("\n"); 
		query.append("   ,A.OFFH_LOC_CD" ).append("\n"); 
		query.append("   ,TO_CHAR(A.LR_ONH_DT, 'YYYY-MM-DD') LR_ONH_DT " ).append("\n"); 
		query.append("   ,A.LR_ONH_LOC_CD " ).append("\n"); 
		query.append("   ,TO_CHAR(A.LR_OFFH_DT, 'YYYY-MM-DD') LR_OFFH_DT " ).append("\n"); 
		query.append("   ,A.LR_OFFH_LOC_CD " ).append("\n"); 
		query.append("   ,A.VNDR_SEQ" ).append("\n"); 
		query.append("   ,TO_CHAR(A.BIL_FM_DT, 'YYYY-MM-DD') BIL_FM_DT" ).append("\n"); 
		query.append("   ,TO_CHAR(A.BIL_TO_DT, 'YYYY-MM-DD') BIL_TO_DT" ).append("\n"); 
		query.append("   ,A.LSE_AUD_TP_CD" ).append("\n"); 
		query.append("   ,A.ONF_HIR_STS_CD " ).append("\n"); 
		query.append("   ,'' CONTRACT_NO" ).append("\n"); 
		query.append("   ,'' SEARCH_STDT" ).append("\n"); 
		query.append("   ,'' SEARCH_ENDDT" ).append("\n"); 
		query.append("   ,'' SEARCH_MONTH" ).append("\n"); 
		query.append("   , @[audit_tp] AUDIT_TYPE" ).append("\n"); 
		query.append("   ,'' ROW_COUNT" ).append("\n"); 
		query.append("   ,'' AUD_SEQ" ).append("\n"); 
		query.append("   ,'' AUD_VER_SEQ" ).append("\n"); 
		query.append("   ,'' AUDIT_VERSION " ).append("\n"); 
		query.append("   ,'' FILE_AUD_VER_SEQ" ).append("\n"); 
		query.append("   ,A.AUD_RMK AUDIT_REMARK   " ).append("\n"); 
		query.append("from lse_onf_hir_aud A " ).append("\n"); 
		query.append("WHERE   A.VNDR_SEQ   = @[vndr_seq]" ).append("\n"); 
		query.append("AND   A.AUD_VER_SEQ  = @[aud_ver_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lse_aud_tp_cd} == '' ) " ).append("\n"); 
		query.append("AND ( A.LSE_AUD_TP_CD in ( 'C' , 'D' , 'L' ) OR  A.LSE_AUD_TP_CD IS NULL )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.LSE_AUD_TP_CD = @[lse_aud_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}