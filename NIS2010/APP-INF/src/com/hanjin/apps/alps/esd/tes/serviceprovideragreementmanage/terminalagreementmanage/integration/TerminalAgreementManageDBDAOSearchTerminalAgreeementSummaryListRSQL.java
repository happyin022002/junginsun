/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOSearchTerminalAgreeementSummaryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalAgreementManageDBDAOSearchTerminalAgreeementSummaryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TerminalAgreementManage의 모든 목록을 가져온다
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOSearchTerminalAgreeementSummaryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("tml_agmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_on",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAOSearchTerminalAgreeementSummaryListRSQL").append("\n"); 
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
		query.append("#if (${eff_agmt} == 'L')" ).append("\n"); 
		query.append("SELECT	X.TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("		, X.TML_AGMT_SEQ " ).append("\n"); 
		query.append("		, X.AGMT_NO" ).append("\n"); 
		query.append("		, X.TML_AGMT_VER_NO" ).append("\n"); 
		query.append("		, X.VER_NO" ).append("\n"); 
		query.append("		, X.YD_CD" ).append("\n"); 
		query.append("		, X.VNDR_SEQ" ).append("\n"); 
		query.append("		, X.YD_NM" ).append("\n"); 
		query.append("		, X.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("		, X.EFF_FM_DT" ).append("\n"); 
		query.append("		, X.EFF_TO_DT" ).append("\n"); 
		query.append("		, X.AUTO_XTD_FLG" ).append("\n"); 
		query.append("		, X.CTRT_OFC_CD" ).append("\n"); 
		query.append("		, X.CURR_CD" ).append("\n"); 
		query.append("		, X.CRE_DT" ).append("\n"); 
		query.append("		, X.CRE_USR_ID" ).append("\n"); 
		query.append("		, X.CRE_USR_NM" ).append("\n"); 
		query.append("		, X.UPD_DT" ).append("\n"); 
		query.append("		, X.UPD_USR_ID" ).append("\n"); 
		query.append("		, X.UPD_USR_NM" ).append("\n"); 
		query.append("		, X.DELT_FLG" ).append("\n"); 
		query.append("		, X.TML_AGMT_STS_CD" ).append("\n"); 
		query.append("		, X.CRE_OFC_CD" ).append("\n"); 
		query.append("		, X.AGMT_APRO_DT" ).append("\n"); 
		query.append("		, X.AGMT_CFM_DT" ).append("\n"); 
		query.append("		, X.AGMT_CFM_FLG" ).append("\n"); 
		query.append("		, X.AGMT_CFM_USR_NM" ).append("\n"); 
		query.append("		, X.AGMT_CFM_USR_ID" ).append("\n"); 
		query.append("		, X.GW_CONT_YN" ).append("\n"); 
		query.append("		, X.AGMT_DOC_NO" ).append("\n"); 
		query.append("		, X.AGMT_DOC_DESC" ).append("\n"); 
		query.append("		, X.AGMT_DOC_EFF_FM_DT" ).append("\n"); 
		query.append("		, X.AGMT_DOC_EFF_TO_DT" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			SELECT	A.TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("					, A.TML_AGMT_SEQ " ).append("\n"); 
		query.append("					, A.TML_AGMT_OFC_CTY_CD || LPAD( A.TML_AGMT_SEQ, 5, '0' ) AS AGMT_NO" ).append("\n"); 
		query.append("					, A.TML_AGMT_VER_NO" ).append("\n"); 
		query.append("					, CASE 		WHEN LENGTH(A.TML_AGMT_VER_NO) = 3" ).append("\n"); 
		query.append("								THEN LPAD(SUBSTR( A.TML_AGMT_VER_NO, 0, 1 ), 2, '0') || '.' || SUBSTR( A.TML_AGMT_VER_NO, 2, 2 )" ).append("\n"); 
		query.append("								ELSE SUBSTR( A.TML_AGMT_VER_NO, 0, 2 ) || '.' || SUBSTR( A.TML_AGMT_VER_NO, 3, 2 )" ).append("\n"); 
		query.append("					  END VER_NO" ).append("\n"); 
		query.append("					, A.YD_CD" ).append("\n"); 
		query.append("					, LPAD(A.VNDR_SEQ, 6, '0') VNDR_SEQ" ).append("\n"); 
		query.append("					, C.YD_NM" ).append("\n"); 
		query.append("					, D.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("					, TO_CHAR(A.EFF_FM_DT, 'YYYY-MM-DD')	EFF_FM_DT" ).append("\n"); 
		query.append("					, TO_CHAR(A.EFF_TO_DT, 'YYYY-MM-DD')	EFF_TO_DT" ).append("\n"); 
		query.append("					, A.AUTO_XTD_FLG" ).append("\n"); 
		query.append("					, A.CTRT_OFC_CD" ).append("\n"); 
		query.append("					, B.CURR_CD" ).append("\n"); 
		query.append("					, TO_CHAR(A.CRE_DT, 'YYYY-MM-DD')	CRE_DT" ).append("\n"); 
		query.append("					, A.CRE_USR_ID" ).append("\n"); 
		query.append("					, (SELECT USR_NM FROM COM_USER WHERE USR_ID = A.CRE_USR_ID) CRE_USR_NM" ).append("\n"); 
		query.append("					, TO_CHAR(A.UPD_DT, 'YYYY-MM-DD')	UPD_DT" ).append("\n"); 
		query.append("					, A.UPD_USR_ID" ).append("\n"); 
		query.append("					, (SELECT USR_NM FROM COM_USER WHERE USR_ID = A.UPD_USR_ID) UPD_USR_NM" ).append("\n"); 
		query.append("					, A.DELT_FLG" ).append("\n"); 
		query.append("					, A.TML_AGMT_STS_CD" ).append("\n"); 
		query.append("					, A.CRE_OFC_CD" ).append("\n"); 
		query.append("					, TO_CHAR(A.AGMT_APRO_DT, 'YYYY-MM-DD') AGMT_APRO_DT" ).append("\n"); 
		query.append("					, TO_CHAR(A.AGMT_CFM_DT, 'YYYY-MM-DD') AGMT_CFM_DT" ).append("\n"); 
		query.append("					, A.AGMT_CFM_FLG" ).append("\n"); 
		query.append("					, AGMT_CFM_USR_NM" ).append("\n"); 
		query.append("					, AGMT_CFM_USR_ID" ).append("\n"); 
		query.append("					-- 비용지급 전표 결재 기능 - 3차 추가(4347-09-25)" ).append("\n"); 
		query.append("					, DECODE(A.AGMT_DOC_NO, NULL, 'N', 'Y') AS GW_CONT_YN" ).append("\n"); 
		query.append("					, A.AGMT_DOC_NO" ).append("\n"); 
		query.append("					, A.AGMT_DOC_DESC" ).append("\n"); 
		query.append("					, A.AGMT_DOC_EFF_FM_DT" ).append("\n"); 
		query.append("					, A.AGMT_DOC_EFF_TO_DT" ).append("\n"); 
		query.append("					, RANK() OVER (PARTITION BY A.TML_AGMT_OFC_CTY_CD, A.TML_AGMT_SEQ, A.YD_CD, LPAD(A.VNDR_SEQ, 6, '0')" ).append("\n"); 
		query.append("									ORDER BY A.TML_AGMT_VER_NO DESC) AS RANK_NO" ).append("\n"); 
		query.append("			FROM	TES_TML_AGMT_HDR A, TES_TML_AGMT_DTL B, MDM_YARD C, MDM_VENDOR D" ).append("\n"); 
		query.append("			WHERE	1	= 1" ).append("\n"); 
		query.append("			#if (${yd_cd} != '')" ).append("\n"); 
		query.append("			AND		A.YD_CD		= @[yd_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("			AND		A.VNDR_SEQ	= @[vndr_seq]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${eff_agmt} == 'C' || ${eff_agmt} == 'L')" ).append("\n"); 
		query.append("			AND		GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]) BETWEEN A.EFF_FM_DT AND A.EFF_TO_DT" ).append("\n"); 
		query.append("			#elseif (${eff_agmt} == 'P')" ).append("\n"); 
		query.append("			AND		GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]) > EFF_TO_DT" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${eff_on} != '')" ).append("\n"); 
		query.append("			AND		@[eff_on] BETWEEN TO_CHAR(A.EFF_FM_DT, 'YYYY-MM-DD') AND TO_CHAR(A.EFF_TO_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${ctrt_ofc_cd} != '')" ).append("\n"); 
		query.append("				#if($sub_ofc_cd1.size() > 0)" ).append("\n"); 
		query.append("				AND     A.CTRT_OFC_CD IN (" ).append("\n"); 
		query.append("				#foreach($sub_ofc_cd1_num IN ${sub_ofc_cd1})" ).append("\n"); 
		query.append("					#if($velocityCount < $sub_ofc_cd1.size()) " ).append("\n"); 
		query.append("						'$sub_ofc_cd1_num', " ).append("\n"); 
		query.append("					#else " ).append("\n"); 
		query.append("						'$sub_ofc_cd1_num' " ).append("\n"); 
		query.append("					#end " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("				AND		A.CTRT_OFC_CD = @[ctrt_ofc_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${delt_flg} != '')" ).append("\n"); 
		query.append("			AND		A.DELT_FLG = @[delt_flg]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${tml_agmt_sts_cd} != '')" ).append("\n"); 
		query.append("			AND		A.TML_AGMT_STS_CD = @[tml_agmt_sts_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if (${cre_ofc_cd2} != '')" ).append("\n"); 
		query.append("				#if($sub_ofc_cd2.size() > 0)" ).append("\n"); 
		query.append("				AND     A.CRE_OFC_CD IN (" ).append("\n"); 
		query.append("				#foreach($sub_ofc_cd2_num IN ${sub_ofc_cd2})" ).append("\n"); 
		query.append("					#if($velocityCount < $sub_ofc_cd2.size()) " ).append("\n"); 
		query.append("						'$sub_ofc_cd2_num', " ).append("\n"); 
		query.append("					#else " ).append("\n"); 
		query.append("						'$sub_ofc_cd2_num' " ).append("\n"); 
		query.append("					#end " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("				AND		A.CRE_OFC_CD = @[cre_ofc_cd2]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end			" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			AND		A.TML_AGMT_OFC_CTY_CD	= B.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("			AND		A.TML_AGMT_SEQ			= B.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("			AND		A.TML_AGMT_VER_NO		= B.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("			AND		A.YD_CD					= C.YD_CD" ).append("\n"); 
		query.append("			AND		A.VNDR_SEQ				= D.VNDR_SEQ" ).append("\n"); 
		query.append("			AND     B.TMP_SAV_FLG IS NULL -- [CHM-201535964]Agreement Summary화면에서 Currency는 Creation화면의 Apply버튼으로 최종 확정된 분만 반영 " ).append("\n"); 
		query.append("			GROUP BY" ).append("\n"); 
		query.append("					A.TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("					, A.TML_AGMT_SEQ" ).append("\n"); 
		query.append("					, A.TML_AGMT_VER_NO" ).append("\n"); 
		query.append("					, A.YD_CD" ).append("\n"); 
		query.append("					, LPAD(A.VNDR_SEQ, 6, '0')" ).append("\n"); 
		query.append("					, C.YD_NM" ).append("\n"); 
		query.append("					, D.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("					, TO_CHAR(A.EFF_FM_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("					, TO_CHAR(A.EFF_TO_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("					, A.AUTO_XTD_FLG" ).append("\n"); 
		query.append("					, A.CTRT_OFC_CD" ).append("\n"); 
		query.append("					, B.CURR_CD" ).append("\n"); 
		query.append("					, TO_CHAR(A.CRE_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("					, A.CRE_USR_ID" ).append("\n"); 
		query.append("					, TO_CHAR(A.UPD_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("					, A.UPD_USR_ID" ).append("\n"); 
		query.append("					, A.DELT_FLG" ).append("\n"); 
		query.append("					, A.TML_AGMT_STS_CD" ).append("\n"); 
		query.append("					, A.CRE_OFC_CD" ).append("\n"); 
		query.append("					, TO_CHAR(A.AGMT_APRO_DT, 'YYYY-MM-DD') " ).append("\n"); 
		query.append("					, TO_CHAR(A.AGMT_CFM_DT, 'YYYY-MM-DD') " ).append("\n"); 
		query.append("					, AGMT_CFM_USR_NM" ).append("\n"); 
		query.append("					, AGMT_CFM_USR_ID" ).append("\n"); 
		query.append("					, A.AGMT_CFM_FLG" ).append("\n"); 
		query.append("					, DECODE(A.AGMT_DOC_NO, NULL, 'N', 'Y')" ).append("\n"); 
		query.append("					, A.AGMT_DOC_NO" ).append("\n"); 
		query.append("					, A.AGMT_DOC_DESC" ).append("\n"); 
		query.append("					, A.AGMT_DOC_EFF_FM_DT" ).append("\n"); 
		query.append("					, A.AGMT_DOC_EFF_TO_DT" ).append("\n"); 
		query.append("			ORDER BY  A.TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("					, A.TML_AGMT_SEQ" ).append("\n"); 
		query.append("					, A.TML_AGMT_VER_NO" ).append("\n"); 
		query.append("#if (${eff_agmt} == 'L')" ).append("\n"); 
		query.append("		) X" ).append("\n"); 
		query.append("WHERE	RANK_NO = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}