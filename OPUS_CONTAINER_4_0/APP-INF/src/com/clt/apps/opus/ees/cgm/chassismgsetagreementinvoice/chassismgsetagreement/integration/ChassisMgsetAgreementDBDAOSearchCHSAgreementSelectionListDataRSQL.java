/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisMgsetAgreementDBDAOSearchCHSAgreementSelectionListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.04
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2015.02.04 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK KWANG SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetAgreementDBDAOSearchCHSAgreementSelectionListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetAgreementDB.SearchCHSAgreementSelectionListData
	  * </pre>
	  */
	public ChassisMgsetAgreementDBDAOSearchCHSAgreementSelectionListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_agmt_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration").append("\n"); 
		query.append("FileName : ChassisMgsetAgreementDBDAOSearchCHSAgreementSelectionListDataRSQL").append("\n"); 
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
		query.append("	A.AGMT_OFC_CTY_CD, " ).append("\n"); 
		query.append("    A.AGMT_SEQ," ).append("\n"); 
		query.append("	A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0') AS AGMT_NO," ).append("\n"); 
		query.append("	A.AGMT_VER_NO," ).append("\n"); 
		query.append("	A.LST_VER_FLG," ).append("\n"); 
		query.append("	A.AGMT_REF_NO," ).append("\n"); 
		query.append("    A.AGMT_ISS_OFC_CD," ).append("\n"); 
		query.append("    A.AGMT_DT AS CRE_DT," ).append("\n"); 
		query.append("    A.AGMT_LSTM_CD," ).append("\n"); 
		query.append("	A.EFF_DT,  " ).append("\n"); 
		query.append("    A.EXP_DT," ).append("\n"); 
		query.append("    A.VNDR_SEQ, " ).append("\n"); 
		query.append("    (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR" ).append("\n"); 
		query.append("     WHERE VNDR_SEQ = A.VNDR_SEQ) AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM CGM_AGREEMENT A, MDM_VENDOR B" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("	  AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("	  AND A.LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("#if (${agmt_ofc_cty_cd} != '')" ).append("\n"); 
		query.append("	  AND A.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_seq} != '')" ).append("\n"); 
		query.append("	  AND A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_iss_ofc_cd} != '')" ).append("\n"); 
		query.append("	  AND A.AGMT_ISS_OFC_CD = @[agmt_iss_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_lstm_cd} != '')" ).append("\n"); 
		query.append("	  AND A.AGMT_LSTM_CD = @[agmt_lstm_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_ref_no} != '')" ).append("\n"); 
		query.append("	  AND INSTR(A.AGMT_REF_NO, @[agmt_ref_no]) > 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("	  AND B.VNDR_SEQ IN ($vndr_seq)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${old_agmt_no} != '')" ).append("\n"); 
		query.append("AND   A.OLD_AGMT_NO = @[old_agmt_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	  AND A.DELT_FLG = 'N'" ).append("\n"); 

	}
}