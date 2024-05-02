/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementRegistrationDBDAOAgreementListBrieflyCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.12
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.07.12 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementRegistrationDBDAOAgreementListBrieflyCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lease Agreement List Total Count Search
	  * </pre>
	  */
	public AgreementRegistrationDBDAOAgreementListBrieflyCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_lgl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vndr_abbr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_act_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.integration").append("\n"); 
		query.append("FileName : AgreementRegistrationDBDAOAgreementListBrieflyCountRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("FROM   LSE_AGREEMENT A" ).append("\n"); 
		query.append("     , MDM_VENDOR C" ).append("\n"); 
		query.append("	 ,(SELECT  A.AGMT_CTY_CD, A.AGMT_SEQ, 'A' AS AGMT_ACT_FLG                   " ).append("\n"); 
		query.append("       FROM    LSE_AGREEMENT A," ).append("\n"); 
		query.append("               MST_CONTAINER B" ).append("\n"); 
		query.append("       WHERE   A.AGMT_CTY_CD = B.AGMT_CTY_CD(+)" ).append("\n"); 
		query.append("       AND     A.AGMT_SEQ = B.AGMT_SEQ(+)        " ).append("\n"); 
		query.append("       AND    (B.ACIAC_DIV_CD = 'A' OR  (B.ACIAC_DIV_CD = 'I' " ).append("\n"); 
		query.append("       AND     B.CNTR_STS_CD IN('SBO','MUO','LST','SRO'))) " ).append("\n"); 
		query.append("       GROUP BY A.AGMT_CTY_CD, A.AGMT_SEQ) B" ).append("\n"); 
		query.append("WHERE  A.VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 
		query.append("AND    A.AGMT_CTY_CD = B.AGMT_CTY_CD(+)" ).append("\n"); 
		query.append("AND    A.AGMT_SEQ = B.AGMT_SEQ(+)" ).append("\n"); 
		query.append("#if (${agmt_cty_cd} != '') " ).append("\n"); 
		query.append("AND    A.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_seq} != '') " ).append("\n"); 
		query.append("AND    A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '') " ).append("\n"); 
		query.append("AND    A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lstm_cd} != '') " ).append("\n"); 
		query.append("AND    A.LSTM_CD = @[lstm_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != '') " ).append("\n"); 
		query.append("AND    A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ref_no} != '') " ).append("\n"); 
		query.append("AND    A.LSE_CTRT_NO LIKE '%'||@[ref_no]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_lgl_eng_nm} != '') " ).append("\n"); 
		query.append("AND    UPPER(C.VNDR_LGL_ENG_NM) LIKE UPPER('%'||@[vndr_lgl_eng_nm]||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_abbr_nm} != '') " ).append("\n"); 
		query.append("AND    UPPER(C.VNDR_ABBR_NM) LIKE UPPER('%'||@[vndr_abbr_nm]||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_act_flg} == 'A') " ).append("\n"); 
		query.append("AND    B.AGMT_ACT_FLG = @[agmt_act_flg]" ).append("\n"); 
		query.append("#elseif (${agmt_act_flg} == 'I') " ).append("\n"); 
		query.append("AND    B.AGMT_ACT_FLG IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}