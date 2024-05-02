/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RateMgtDBDAOsearchAGMTHDRDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RateMgtDBDAOsearchAGMTHDRDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 헤더 데이타 조회
	  * -- 2014.11 10만불 결제관련
	  * -- [CHM-201433304]
	  *   CSR 승인 강화에 따른 ALPS MNR-AGMT에 GW Document Contract Link 관련 추가 요청 사항
	  * </pre>
	  */
	public RateMgtDBDAOsearchAGMTHDRDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.integration").append("\n"); 
		query.append("FileName : RateMgtDBDAOsearchAGMTHDRDataRSQL").append("\n"); 
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
		query.append("		MNR_COMMON_PKG.MNR_CONV_AGMT_NO_FNC(A.AGMT_OFC_CTY_CD, A.AGMT_SEQ) AS AGMT_NO" ).append("\n"); 
		query.append("   		,A.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,A.AGMT_SEQ" ).append("\n"); 
		query.append("        ,A.AGMT_VER_NO" ).append("\n"); 
		query.append("        ,A.EQ_KND_CD" ).append("\n"); 
		query.append("        ,A.AGMT_LST_VER_FLG" ).append("\n"); 
		query.append("        ,MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(A.VNDR_SEQ) AS VNDR_SEQ" ).append("\n"); 
		query.append("        ,A.PAY_TERM_DYS" ).append("\n"); 
		query.append("        ,A.AGMT_REF_NO" ).append("\n"); 
		query.append("        ,TO_CHAR(A.AGMT_DT, 'yyyy-mm-dd') AGMT_DT" ).append("\n"); 
		query.append("        ,TO_CHAR(A.EFF_DT, 'yyyy-mm-dd') EFF_DT" ).append("\n"); 
		query.append("        ,TO_CHAR(A.EXP_DT, 'yyyy-mm-dd') EXP_DT" ).append("\n"); 
		query.append("        ,A.CURR_CD" ).append("\n"); 
		query.append("        ,A.DELT_FLG" ).append("\n"); 
		query.append("        ,A.AGMT_RMK" ).append("\n"); 
		query.append("        ,A.AGMT_OFC_CD" ).append("\n"); 
		query.append("        ,A.TRF_NO" ).append("\n"); 
		query.append("        ,A.CRE_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(A.CRE_DT, 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append("        ,A.UPD_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(A.UPD_DT, 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("        ,B.VNDR_LGL_ENG_NM AS VNDR_NM" ).append("\n"); 
		query.append("        ,nvl(A.FILE_ATCH_FLG, 'N') AS FILE_ATCH_FLG" ).append("\n"); 
		query.append("FROM MNR_AGMT_HDR A,MDM_VENDOR B" ).append("\n"); 
		query.append("WHERE A.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND   A.AGMT_SEQ = @[agmt_seq] " ).append("\n"); 
		query.append("AND   A.AGMT_VER_NO = @[agmt_ver_no]" ).append("\n"); 
		query.append("AND   A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 

	}
}