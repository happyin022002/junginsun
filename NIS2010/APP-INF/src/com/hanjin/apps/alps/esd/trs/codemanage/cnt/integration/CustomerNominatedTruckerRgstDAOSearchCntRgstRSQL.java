/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CustomerNominatedTruckerRgstDAOSearchCntRgstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.20
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2016.07.20 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.cnt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerNominatedTruckerRgstDAOSearchCntRgstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2014_06_11 생성
	  * </pre>
	  */
	public CustomerNominatedTruckerRgstDAOSearchCntRgstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.cnt.integration").append("\n"); 
		query.append("FileName : CustomerNominatedTruckerRgstDAOSearchCntRgstRSQL").append("\n"); 
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
		query.append("SELECT A.PRC_CTRT_TP_CD" ).append("\n"); 
		query.append("      ,A.PRC_CTRT_NO" ).append("\n"); 
		query.append("      ,A.SLS_OFC_CD" ).append("\n"); 
		query.append("      ,A.CTRT_CUST_SREP_CD " ).append("\n"); 
		query.append("      ,(SELECT X.SREP_NM FROM MDM_SLS_REP X WHERE X.SREP_CD = A.CTRT_CUST_SREP_CD) AS CTRT_CUST_SREP_NM" ).append("\n"); 
		query.append("      ,A.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("	  ,CTRT_CUST_CNT_CD || LPAD(CTRT_CUST_SEQ, 6, 0) AS CTRT_CUST_CD" ).append("\n"); 
		query.append("      ,A.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("      ,(SELECT X.CUST_LGL_ENG_NM FROM MDM_CUSTOMER X WHERE X.CUST_CNT_CD = A.CTRT_CUST_CNT_CD AND X.CUST_SEQ = A.CTRT_CUST_SEQ) CTRT_CUST_NM      " ).append("\n"); 
		query.append("      ,A.CTRT_EFF_DT" ).append("\n"); 
		query.append("      ,A.CTRT_EXP_DT" ).append("\n"); 
		query.append("      ,A.FNL_MQC_DESC" ).append("\n"); 
		query.append("      ,LPAD(A.VNDR_SEQ, 6, '0') AS VNDR_SEQ" ).append("\n"); 
		query.append("      ,(SELECT X.VNDR_LGL_ENG_NM FROM MDM_VENDOR X WHERE X.VNDR_SEQ = A.VNDR_SEQ) VNDR_NM" ).append("\n"); 
		query.append("      ,(SELECT X.USA_EDI_CD FROM MDM_VENDOR X WHERE X.VNDR_SEQ = A.VNDR_SEQ) USA_EDI_CD      " ).append("\n"); 
		query.append("      ,A.IO_BND_CD" ).append("\n"); 
		query.append("      ,SUBSTR(A.ORG_NOD_CD,1,5)  AS ORG_NOD_CD" ).append("\n"); 
		query.append("      ,SUBSTR(A.ORG_NOD_CD,6)    AS ORG_NOD_YARD" ).append("\n"); 
		query.append("      ,SUBSTR(A.ORG_NOD_CD,6)    AS ORG_NOD_YARD2" ).append("\n"); 
		query.append("      ,SUBSTR(A.DEST_NOD_CD,1,5) AS DEST_NOD_CD" ).append("\n"); 
		query.append("      ,SUBSTR(A.DEST_NOD_CD,6)   AS DEST_NOD_YARD" ).append("\n"); 
		query.append("      ,SUBSTR(A.DEST_NOD_CD,6)   AS DEST_NOD_YARD2" ).append("\n"); 
		query.append("      ,MTY_PKUP_RTN_YD_CD      " ).append("\n"); 
		query.append("      ,(SELECT X.YD_NM" ).append("\n"); 
		query.append("          FROM MDM_YARD X" ).append("\n"); 
		query.append("         WHERE YD_CD = A.MTY_PKUP_RTN_YD_CD)" ).append("\n"); 
		query.append("     ||(SELECT X.LSE_CO_YD_NM" ).append("\n"); 
		query.append("          FROM MDM_LSE_CO_YD X" ).append("\n"); 
		query.append("         WHERE LSE_CO_YD_CD = A.MTY_PKUP_RTN_YD_CD) AS MTY_PKUP_RTN_YD_NM" ).append("\n"); 
		query.append("      ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,A.CUST_NOMI_TRKR_BZC_AMT" ).append("\n"); 
		query.append("      ,A.CUST_NOMI_TRKR_FUEL_DIV_CD" ).append("\n"); 
		query.append("      ,A.CUST_NOMI_TRKR_FUEL_RTO" ).append("\n"); 
		query.append("      ,A.CUST_NOMI_TRKR_FUEL_AMT" ).append("\n"); 
		query.append("      ,A.COST_DESC" ).append("\n"); 
		query.append("      ,A.DISP_STS_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(A.CUST_NOMI_TRKR_SAV_DT, 'YYYYMMDD')  AS CUST_NOMI_TRKR_SAV_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.CUST_NOMI_TRKR_RQST_DT, 'YYYYMMDD') AS CUST_NOMI_TRKR_RQST_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.CUST_NOMI_TRKR_RJCT_DT, 'YYYYMMDD') AS CUST_NOMI_TRKR_RJCT_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.CUST_NOMI_TRKR_APRO_DT, 'YYYYMMDD') AS CUST_NOMI_TRKR_APRO_DT" ).append("\n"); 
		query.append("      ,A.RGST_USR_ID" ).append("\n"); 
		query.append("      ,(SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = A.RGST_USR_ID) RGST_USR_NM" ).append("\n"); 
		query.append("      , APRO_NO" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("  FROM TRS_CUST_NOMI_TRKR A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if (${s_fm_dt} != '')" ).append("\n"); 
		query.append("    #if (${s_to_dt} != '')" ).append("\n"); 
		query.append("   -- Saved Date로 조회시" ).append("\n"); 
		query.append("		#if (${s_dt_div_cd} == '00')" ).append("\n"); 
		query.append("   AND A.CUST_NOMI_TRKR_SAV_DT  BETWEEN TO_DATE(@[s_fm_dt], 'YYYYMMDD') AND TO_DATE(@[s_to_dt], 'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("   -- Requested Date로 조회시" ).append("\n"); 
		query.append("		#if (${s_dt_div_cd} == '01')" ).append("\n"); 
		query.append("   AND A.CUST_NOMI_TRKR_RQST_DT BETWEEN TO_DATE(@[s_fm_dt], 'YYYYMMDD') AND TO_DATE(@[s_to_dt], 'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("   -- Rejected Date로 조회시" ).append("\n"); 
		query.append("		#if (${s_dt_div_cd} == '02')" ).append("\n"); 
		query.append("   AND A.CUST_NOMI_TRKR_RJCT_DT BETWEEN TO_DATE(@[s_fm_dt], 'YYYYMMDD') AND TO_DATE(@[s_to_dt], 'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("   -- Approved Date로 조회시" ).append("\n"); 
		query.append("		#if (${s_dt_div_cd} == '03')" ).append("\n"); 
		query.append("   AND A.CUST_NOMI_TRKR_APRO_DT BETWEEN TO_DATE(@[s_fm_dt], 'YYYYMMDD') AND TO_DATE(@[s_to_dt], 'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   -- Effective Date로 조회시" ).append("\n"); 
		query.append("#if (${s_eff_dt} != '')" ).append("\n"); 
		query.append("   AND TO_DATE(@[s_eff_dt], 'YYYYMMDD') BETWEEN A.CTRT_EFF_DT AND A.CTRT_EXP_DT   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   -- Contract No로 조회시" ).append("\n"); 
		query.append("#if (${s_ctrt_no} != '')" ).append("\n"); 
		query.append("   AND A.PRC_CTRT_NO = @[s_ctrt_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("-- Status로 조회시 (MULTI 리스트로 파라메터 받아 loop문에서 처리)" ).append("\n"); 
		query.append("#if ($s_disp_sts_cd.size() > 0)" ).append("\n"); 
		query.append("      AND A.DISP_STS_CD IN (" ).append("\n"); 
		query.append("	#foreach($key in ${s_disp_sts_cd}) " ).append("\n"); 
		query.append("		#if($velocityCount < $s_disp_sts_cd.size()) " ).append("\n"); 
		query.append("			'$key', " ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			'$key' " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   -- Customer로 조회시" ).append("\n"); 
		query.append("#if (${s_cust_seq} != '')" ).append("\n"); 
		query.append("   AND (A.CTRT_CUST_CNT_CD, A.CTRT_CUST_SEQ) = ( ( SUBSTR(@[s_cust_seq],1,2), SUBSTR(@[s_cust_seq],3))  )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   -- Trucker로 조회시" ).append("\n"); 
		query.append("#if (${s_vndr_seq} != '')" ).append("\n"); 
		query.append("   AND A.VNDR_SEQ = @[s_vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_dest_nod_cd} != '')" ).append("\n"); 
		query.append("   AND SUBSTR(DECODE(A.IO_BND_CD, 'I', A.DEST_NOD_CD, 'O', A.ORG_NOD_CD), 1, 5) = @[s_dest_nod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}