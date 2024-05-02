/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChassisMgsetAgreementDBDAOSearchCHSCpsAgreementMainDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetAgreementDBDAOSearchCHSCpsAgreementMainDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CPS Agreement No로 기존에 등록된 CPS Agreement 정보가 있는지 조회한다.
	  * -- 2014.11 10만불 결제관련
	  * </pre>
	  */
	public ChassisMgsetAgreementDBDAOSearchCHSCpsAgreementMainDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration").append("\n"); 
		query.append("FileName : ChassisMgsetAgreementDBDAOSearchCHSCpsAgreementMainDataRSQL").append("\n"); 
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
		query.append("SELECT A.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("       A.AGMT_SEQ," ).append("\n"); 
		query.append("       (A.AGMT_OFC_CTY_CD || A.AGMT_SEQ) AGMT_NO," ).append("\n"); 
		query.append("       A.AGMT_VER_NO," ).append("\n"); 
		query.append("       A.LST_VER_FLG," ).append("\n"); 
		query.append("       A.CHSS_POOL_CD," ).append("\n"); 
		query.append("       A.CURR_CD," ).append("\n"); 
		query.append("       TO_CHAR(A.AGMT_EFF_DT,'YYYY-MM-DD') AS AGMT_EFF_DT," ).append("\n"); 
		query.append("       TO_CHAR(A.AGMT_EXP_DT,'YYYY-MM-DD') AS AGMT_EXP_DT," ).append("\n"); 
		query.append("       (A.AGMT_EXP_DT - A.AGMT_EFF_DT) AS DURATION," ).append("\n"); 
		query.append("       A.CTRT_NO," ).append("\n"); 
		query.append("       A.AGMT_REF_NO," ).append("\n"); 
		query.append("       A.VNDR_SEQ," ).append("\n"); 
		query.append("       B.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("       A.PAY_TERM_DYS," ).append("\n"); 
		query.append("       A.AGMT_ISS_OFC_CD," ).append("\n"); 
		query.append("       A.CRE_USR_ID," ).append("\n"); 
		query.append("       TO_CHAR(A.CRE_DT,'YYYY-MM-DD') AS CRE_DT," ).append("\n"); 
		query.append("       A.DIFF_RMK," ).append("\n"); 
		query.append("       A.GW_UQ_DOC_TIT_NM," ).append("\n"); 
		query.append("       A.GW_UQ_DOC_NO" ).append("\n"); 
		query.append("FROM CGM_AGREEMENT A, MDM_VENDOR B" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("	  AND A.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("	  AND A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("#if (${agmt_ver_no} != '')" ).append("\n"); 
		query.append("	  AND A.AGMT_VER_NO = @[agmt_ver_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND A.AGMT_LSTM_CD = 'ZP'" ).append("\n"); 
		query.append("	  AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY A.AGMT_VER_NO" ).append("\n"); 

	}
}