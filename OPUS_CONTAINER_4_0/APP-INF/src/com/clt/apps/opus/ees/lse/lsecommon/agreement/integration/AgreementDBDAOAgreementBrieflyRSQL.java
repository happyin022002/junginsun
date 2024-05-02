/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AgreementDBDAOAgreementBrieflyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.agreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementDBDAOAgreementBrieflyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lease Agreement Briefly Search
	  * </pre>
	  */
	public AgreementDBDAOAgreementBrieflyRSQL(){
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
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.lsecommon.agreement.integration").append("\n"); 
		query.append("FileName : AgreementDBDAOAgreementBrieflyRSQL").append("\n"); 
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
		query.append("SELECT A.AGMT_CTY_CD || A.AGMT_SEQ AS AGMT_NO" ).append("\n"); 
		query.append("     , A.AGMT_CTY_CD" ).append("\n"); 
		query.append("     , A.AGMT_SEQ" ).append("\n"); 
		query.append("     , A.AGMT_LST_VER_SEQ" ).append("\n"); 
		query.append("     , A.VNDR_SEQ" ).append("\n"); 
		query.append("     , A.LSTM_CD" ).append("\n"); 
		query.append("     , A.OFC_CD" ).append("\n"); 
		query.append("     , A.CURR_CD" ).append("\n"); 
		query.append("     , A.REF_NO" ).append("\n"); 
		query.append("	 , A.LSE_CTRT_NO" ).append("\n"); 
		query.append("     , C.VNDR_LGL_ENG_NM AS VNDR_NM" ).append("\n"); 
		query.append("     , C.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("     , TO_CHAR(A.LST_EFF_DT,'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("     , TO_CHAR(A.LST_EXP_DT,'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append("     , SUBSTR(C.VNDR_ABBR_NM,0,3)         AS VNDR_ABBR_NM" ).append("\n"); 
		query.append("	 , A.LSE_FREE_DYS" ).append("\n"); 
		query.append("FROM   LSE_AGREEMENT A" ).append("\n"); 
		query.append("     , MDM_VENDOR C" ).append("\n"); 
		query.append("WHERE  A.VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 
		query.append("#if (${agmt_cty_cd} != \"\") " ).append("\n"); 
		query.append("AND A.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_seq} != \"\") " ).append("\n"); 
		query.append("AND A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != \"\") " ).append("\n"); 
		query.append("AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lstm_cd} != \"\") " ).append("\n"); 
		query.append("AND A.LSTM_CD = @[lstm_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != \"\") " ).append("\n"); 
		query.append("AND A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ref_no} != \"\") " ).append("\n"); 
		query.append("AND A.REF_NO LIKE '%'||@[ref_no]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_lgl_eng_nm} != \"\") " ).append("\n"); 
		query.append("AND C.VNDR_LGL_ENG_NM LIKE '%'||@[vndr_lgl_eng_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}