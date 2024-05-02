/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOSearchTerminalAgreeementSummaryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

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
		params.put("cre_ofc_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eff_on",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration").append("\n"); 
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
		query.append("SELECT A.TML_AGMT_OFC_CTY_CD " ).append("\n"); 
		query.append("     , A.TML_AGMT_SEQ " ).append("\n"); 
		query.append("     , A.TML_AGMT_OFC_CTY_CD || LPAD( A.TML_AGMT_SEQ, 5, '0' ) AS AGMT_NO " ).append("\n"); 
		query.append("     , A.TML_AGMT_VER_NO " ).append("\n"); 
		query.append("     , CASE WHEN LENGTH(A.TML_AGMT_VER_NO) = 3 " ).append("\n"); 
		query.append("     		THEN LPAD(SUBSTR( A.TML_AGMT_VER_NO, 0, 1 ), 2, '0') || '.' || SUBSTR( A.TML_AGMT_VER_NO, 2, 2 ) " ).append("\n"); 
		query.append("            ELSE SUBSTR( A.TML_AGMT_VER_NO, 0, 2 ) || '.' || SUBSTR( A.TML_AGMT_VER_NO, 3, 2 ) " ).append("\n"); 
		query.append("     	END VER_NO " ).append("\n"); 
		query.append("     , A.YD_CD " ).append("\n"); 
		query.append("     , LPAD(A.VNDR_SEQ, 6, '0') VNDR_SEQ " ).append("\n"); 
		query.append("     , C.YD_NM " ).append("\n"); 
		query.append("     , D.VNDR_LGL_ENG_NM " ).append("\n"); 
		query.append("     , TO_CHAR(A.EFF_FM_DT,'yyyy-mm-dd') EFF_FM_DT " ).append("\n"); 
		query.append("     , TO_CHAR(A.EFF_TO_DT,'yyyy-mm-dd') EFF_TO_DT " ).append("\n"); 
		query.append("     , A.AUTO_XTD_FLG " ).append("\n"); 
		query.append("     , A.CTRT_OFC_CD " ).append("\n"); 
		query.append("     , B.CURR_CD " ).append("\n"); 
		query.append("     , TO_CHAR(A.CRE_DT,'yyyy-mm-dd') CRE_DT " ).append("\n"); 
		query.append("     , A.CRE_USR_ID " ).append("\n"); 
		query.append("     , TO_CHAR(A.UPD_DT,'yyyy-mm-dd') UPD_DT " ).append("\n"); 
		query.append("     , A.UPD_USR_ID " ).append("\n"); 
		query.append("     , A.DELT_FLG " ).append("\n"); 
		query.append("     , A.TML_AGMT_STS_CD " ).append("\n"); 
		query.append("     , A.CRE_OFC_CD " ).append("\n"); 
		query.append("  FROM TES_TML_AGMT_HDR A" ).append("\n"); 
		query.append("     , TES_TML_AGMT_DTL B" ).append("\n"); 
		query.append("     , MDM_YARD C" ).append("\n"); 
		query.append("     , MDM_VENDOR D " ).append("\n"); 
		query.append(" WHERE 1 = 1 " ).append("\n"); 
		query.append("#if (${yd_cd} != '') " ).append("\n"); 
		query.append("       AND A.YD_CD = @[yd_cd] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${vndr_seq} != '') " ).append("\n"); 
		query.append("       AND A.VNDR_SEQ = @[vndr_seq] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${eff_agmt} == 'C') " ).append("\n"); 
		query.append("       AND GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]) BETWEEN A.EFF_FM_DT AND A.EFF_TO_DT " ).append("\n"); 
		query.append("#elseif (${eff_agmt} == 'P') " ).append("\n"); 
		query.append("       AND GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]) > EFF_TO_DT " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${eff_on} != '') " ).append("\n"); 
		query.append("       AND @[eff_on] BETWEEN TO_CHAR(A.EFF_FM_DT,'yyyy-mm-dd') AND TO_CHAR(A.EFF_TO_DT,'yyyy-mm-dd') " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${ctrt_ofc_cd} != '') " ).append("\n"); 
		query.append("       AND A.CTRT_OFC_CD = @[ctrt_ofc_cd] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${delt_flg} != '') " ).append("\n"); 
		query.append("       AND A.DELT_FLG = @[delt_flg] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${tml_agmt_sts_cd} != '') " ).append("\n"); 
		query.append("       AND A.TML_AGMT_STS_CD = @[tml_agmt_sts_cd] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${cre_ofc_cd2} != '') " ).append("\n"); 
		query.append("       AND A.CRE_OFC_CD = @[cre_ofc_cd2] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${lgs_cost_cd} != '') " ).append("\n"); 
		query.append("       AND B.LGS_COST_CD = @[lgs_cost_cd] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("       AND A.TML_AGMT_OFC_CTY_CD = B.TML_AGMT_OFC_CTY_CD(+) " ).append("\n"); 
		query.append("       AND A.TML_AGMT_SEQ = B.TML_AGMT_SEQ(+) " ).append("\n"); 
		query.append("       AND A.TML_AGMT_VER_NO = B.TML_AGMT_VER_NO(+) " ).append("\n"); 
		query.append("       AND A.YD_CD = C.YD_CD " ).append("\n"); 
		query.append("       AND A.VNDR_SEQ = D.VNDR_SEQ " ).append("\n"); 
		query.append(" GROUP BY A.TML_AGMT_OFC_CTY_CD " ).append("\n"); 
		query.append("     , A.TML_AGMT_SEQ " ).append("\n"); 
		query.append("     , A.TML_AGMT_VER_NO " ).append("\n"); 
		query.append("     , A.YD_CD " ).append("\n"); 
		query.append("     , LPAD(A.VNDR_SEQ, 6, '0') " ).append("\n"); 
		query.append("     , C.YD_NM " ).append("\n"); 
		query.append("     , D.VNDR_LGL_ENG_NM " ).append("\n"); 
		query.append("     , TO_CHAR(A.EFF_FM_DT,'yyyy-mm-dd') " ).append("\n"); 
		query.append("     , TO_CHAR(A.EFF_TO_DT,'yyyy-mm-dd') " ).append("\n"); 
		query.append("     , A.AUTO_XTD_FLG " ).append("\n"); 
		query.append("     , A.CTRT_OFC_CD " ).append("\n"); 
		query.append("     , B.CURR_CD " ).append("\n"); 
		query.append("     , TO_CHAR(A.CRE_DT,'yyyy-mm-dd') " ).append("\n"); 
		query.append("     , A.CRE_USR_ID " ).append("\n"); 
		query.append("     , TO_CHAR(A.UPD_DT,'yyyy-mm-dd') " ).append("\n"); 
		query.append("     , A.UPD_USR_ID " ).append("\n"); 
		query.append("     , A.DELT_FLG " ).append("\n"); 
		query.append("     , A.TML_AGMT_STS_CD " ).append("\n"); 
		query.append("     , A.CRE_OFC_CD " ).append("\n"); 
		query.append("ORDER BY A.TML_AGMT_OFC_CTY_CD " ).append("\n"); 
		query.append("     , A.TML_AGMT_SEQ " ).append("\n"); 
		query.append("     , A.TML_AGMT_VER_NO" ).append("\n"); 

	}
}