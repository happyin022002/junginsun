/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementRegistrationDBDAOAgreementListBrieflyRSQL.java
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

public class AgreementRegistrationDBDAOAgreementListBrieflyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lease Agreement List Search
	  * </pre>
	  */
	public AgreementRegistrationDBDAOAgreementListBrieflyRSQL(){
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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endno",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : AgreementRegistrationDBDAOAgreementListBrieflyRSQL").append("\n"); 
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
		query.append("SELECT AA.AGMT_NO      " ).append("\n"); 
		query.append("     , AA.AGMT_CTY_CD                               " ).append("\n"); 
		query.append("     , AA.AGMT_SEQ                                  " ).append("\n"); 
		query.append("     , AA.AGMT_LST_VER_SEQ                          " ).append("\n"); 
		query.append("     , AA.VNDR_SEQ                                  " ).append("\n"); 
		query.append("     , AA.LSTM_CD                                   " ).append("\n"); 
		query.append("     , AA.OFC_CD                                    " ).append("\n"); 
		query.append("     , AA.CURR_CD                                   " ).append("\n"); 
		query.append("     , AA.REF_NO                                    " ).append("\n"); 
		query.append("	 , AA.LSE_CTRT_NO" ).append("\n"); 
		query.append("     , AA.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("     , AA.VNDR_ABBR_NM                           " ).append("\n"); 
		query.append("     , AA.EFF_DT" ).append("\n"); 
		query.append("     , AA.EXP_DT" ).append("\n"); 
		query.append("     , AA.LSE_FREE_DYS" ).append("\n"); 
		query.append("     , AA.CRE_USR_ID" ).append("\n"); 
		query.append("     , AA.CRE_DT" ).append("\n"); 
		query.append("     , AA.UPD_USR_ID" ).append("\n"); 
		query.append("     , AA.UPD_DT" ).append("\n"); 
		query.append("	 , AA.AGMT_ACT_FLG" ).append("\n"); 
		query.append("FROM  (" ).append("\n"); 
		query.append("		SELECT ROW_NUMBER() OVER (ORDER BY A.AGMT_SEQ DESC) AS NO" ).append("\n"); 
		query.append("		     , A.AGMT_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0') AS AGMT_NO" ).append("\n"); 
		query.append("		     , A.AGMT_CTY_CD" ).append("\n"); 
		query.append("		     , A.AGMT_SEQ" ).append("\n"); 
		query.append("		     , A.AGMT_LST_VER_SEQ" ).append("\n"); 
		query.append("		     , A.VNDR_SEQ" ).append("\n"); 
		query.append("		     , A.LSTM_CD" ).append("\n"); 
		query.append("		     , A.OFC_CD" ).append("\n"); 
		query.append("		     , A.CURR_CD" ).append("\n"); 
		query.append("		     , A.REF_NO" ).append("\n"); 
		query.append("			 , A.LSE_CTRT_NO" ).append("\n"); 
		query.append("		     , C.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("             , C.VNDR_ABBR_NM" ).append("\n"); 
		query.append("		     , TO_CHAR(A.LST_EFF_DT,'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("			 , TO_CHAR(A.LST_EXP_DT,'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append("			 , A.LSE_FREE_DYS" ).append("\n"); 
		query.append("             , A.CRE_USR_ID" ).append("\n"); 
		query.append("             , TO_CHAR(A.CRE_DT, 'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("             , A.UPD_USR_ID" ).append("\n"); 
		query.append("             , TO_CHAR(A.UPD_DT, 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("			 , NVL(B.AGMT_ACT_FLG, 'I') AS AGMT_ACT_FLG " ).append("\n"); 
		query.append("		FROM   LSE_AGREEMENT A" ).append("\n"); 
		query.append("		     , MDM_VENDOR C" ).append("\n"); 
		query.append("			 ,(SELECT  A.AGMT_CTY_CD, A.AGMT_SEQ, 'A' AS AGMT_ACT_FLG                   " ).append("\n"); 
		query.append("               FROM    LSE_AGREEMENT A," ).append("\n"); 
		query.append("                       MST_CONTAINER B" ).append("\n"); 
		query.append("               WHERE   A.AGMT_CTY_CD = B.AGMT_CTY_CD(+)" ).append("\n"); 
		query.append("               AND     A.AGMT_SEQ = B.AGMT_SEQ(+)        " ).append("\n"); 
		query.append("               AND    (B.ACIAC_DIV_CD = 'A' OR  (B.ACIAC_DIV_CD = 'I' " ).append("\n"); 
		query.append("               AND     B.CNTR_STS_CD IN('SBO','MUO','LST','SRO'))) " ).append("\n"); 
		query.append("               GROUP BY A.AGMT_CTY_CD, A.AGMT_SEQ) B" ).append("\n"); 
		query.append("		WHERE  A.VNDR_SEQ = C.VNDR_SEQ(+)" ).append("\n"); 
		query.append("		AND    A.AGMT_CTY_CD = B.AGMT_CTY_CD(+)" ).append("\n"); 
		query.append("        AND    A.AGMT_SEQ = B.AGMT_SEQ(+)" ).append("\n"); 
		query.append("#if (${agmt_cty_cd} != '') " ).append("\n"); 
		query.append("		AND    A.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_seq} != '') " ).append("\n"); 
		query.append("		AND    A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '') " ).append("\n"); 
		query.append("		AND    A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lstm_cd} != '') " ).append("\n"); 
		query.append("		AND    A.LSTM_CD = @[lstm_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != '') " ).append("\n"); 
		query.append("		AND    A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ref_no} != '') " ).append("\n"); 
		query.append("		AND    A.LSE_CTRT_NO LIKE '%'||@[ref_no]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_lgl_eng_nm} != '') " ).append("\n"); 
		query.append("		AND    UPPER(C.VNDR_LGL_ENG_NM) LIKE UPPER('%'||@[vndr_lgl_eng_nm]||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_abbr_nm} != '') " ).append("\n"); 
		query.append("        AND    UPPER(C.VNDR_ABBR_NM) LIKE UPPER('%'||@[vndr_abbr_nm]||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_act_flg} == 'A') " ).append("\n"); 
		query.append("		AND    B.AGMT_ACT_FLG = @[agmt_act_flg]" ).append("\n"); 
		query.append("#elseif (${agmt_act_flg} == 'I') " ).append("\n"); 
		query.append("        AND    B.AGMT_ACT_FLG IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	) AA" ).append("\n"); 
		query.append("#if (${startno} != '') " ).append("\n"); 
		query.append("WHERE AA.NO BETWEEN @[startno] AND @[endno]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}