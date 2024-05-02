/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetAgreementDBDAOSearchMGSAgreementListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.03.24 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetAgreementDBDAOSearchMGSAgreementListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetAgreementDB.SearchMGSAgreementListData
	  * </pre>
	  */
	public ChassisMgsetAgreementDBDAOSearchMGSAgreementListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration").append("\n"); 
		query.append("FileName : ChassisMgsetAgreementDBDAOSearchMGSAgreementListDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("A.AGMT_SEQ," ).append("\n"); 
		query.append("A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ,6,'0') AS AGMT_NO," ).append("\n"); 
		query.append("A.AGMT_REF_NO," ).append("\n"); 
		query.append("A.AGMT_ISS_OFC_CD," ).append("\n"); 
		query.append("TO_CHAR(A.AGMT_DT,'YYYY-MM-DD') AS AGMT_DT," ).append("\n"); 
		query.append("A.AGMT_LSTM_CD," ).append("\n"); 
		query.append("TO_CHAR(A.AGMT_EFF_DT,'YYYY-MM-DD') || ' ~ ' || TO_CHAR(A.AGMT_EXP_DT,'YYYY-MM-DD') AS EFFECTIVE_DATE," ).append("\n"); 
		query.append("A.VNDR_SEQ," ).append("\n"); 
		query.append("(SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = A.VNDR_SEQ) AS VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("(SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = A.VNDR_SEQ) AS VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("(select TO_CHAR(b.CRE_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("from CGM_AGREEMENT b" ).append("\n"); 
		query.append("where b.AGMT_OFC_CTY_CD = A.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("and b.AGMT_SEQ = a.AGMT_SEQ" ).append("\n"); 
		query.append("and b.AGMT_VER_NO=1 )  AS CRE_DT," ).append("\n"); 
		query.append("(select b.CRE_USR_ID" ).append("\n"); 
		query.append("from CGM_AGREEMENT b" ).append("\n"); 
		query.append("where b.AGMT_OFC_CTY_CD = A.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("and b.AGMT_SEQ = a.AGMT_SEQ" ).append("\n"); 
		query.append("and b.AGMT_VER_NO=1 ) CRE_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(A.UPD_DT,'YYYY-MM-DD') AS UPD_DT," ).append("\n"); 
		query.append("A.UPD_USR_ID" ).append("\n"); 
		query.append("FROM CGM_AGREEMENT A" ).append("\n"); 
		query.append("WHERE A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("#if (${agmt_iss_ofc_cd} != '')" ).append("\n"); 
		query.append("AND   A.AGMT_ISS_OFC_CD = @[agmt_iss_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("#if (${agmt_dt_fr} != '')" ).append("\n"); 
		query.append("AND A.AGMT_DT >= TO_DATE(@[agmt_dt_fr],'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_dt_to} != '')" ).append("\n"); 
		query.append("AND A.AGMT_DT < TO_DATE(@[agmt_dt_to],'YYYYMMDD') + 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_lstm_cd} != '')" ).append("\n"); 
		query.append("AND A.AGMT_LSTM_CD = @[agmt_lstm_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("AND A.VNDR_SEQ IN ($vndr_seq)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eff_flag} == 'Y')" ).append("\n"); 
		query.append("AND AGMT_EFF_DT < TO_DATE(TO_CHAR(SYSDATE,'YYYYMMDD'),'YYYYMMDD')" ).append("\n"); 
		query.append("AND AGMT_EXP_DT >= TO_DATE(TO_CHAR(SYSDATE,'YYYYMMDD'),'YYYYMMDD') + 1" ).append("\n"); 
		query.append("#elseif (${eff_flag} == 'N')" ).append("\n"); 
		query.append("AND (AGMT_EXP_DT < TO_DATE(TO_CHAR(SYSDATE,'YYYYMMDD'),'YYYYMMDD') OR" ).append("\n"); 
		query.append("AGMT_EFF_DT >= TO_DATE(TO_CHAR(SYSDATE,'YYYYMMDD'),'YYYYMMDD') + 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 

	}
}