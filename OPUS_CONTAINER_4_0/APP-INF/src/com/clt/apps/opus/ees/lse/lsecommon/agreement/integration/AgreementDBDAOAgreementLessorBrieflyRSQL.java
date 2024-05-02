/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AgreementDBDAOAgreementLessorBrieflyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.22
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2014.08.22 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.agreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementDBDAOAgreementLessorBrieflyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lease Agreement Lessor Briefly Search
	  * </pre>
	  */
	public AgreementDBDAOAgreementLessorBrieflyRSQL(){
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
		params.put("vndr_lgl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.lsecommon.agreement.integration").append("\n"); 
		query.append("FileName : AgreementDBDAOAgreementLessorBrieflyRSQL").append("\n"); 
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
		query.append("SELECT VNDR_SEQ" ).append("\n"); 
		query.append("      , VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      , LSTM_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT DISTINCT A.VNDR_SEQ" ).append("\n"); 
		query.append("     , C.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("     , A.LSTM_CD" ).append("\n"); 
		query.append("FROM   LSE_AGREEMENT A" ).append("\n"); 
		query.append("     , MDM_VENDOR C" ).append("\n"); 
		query.append("WHERE  A.VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 
		query.append("#if (${vndr_seq} != \"\") " ).append("\n"); 
		query.append("AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lstm_cd} != \"\") " ).append("\n"); 
		query.append("AND A.LSTM_CD IN ( DECODE(@[lstm_cd], 'LPOL', 'LP', @[lstm_cd]), DECODE(@[lstm_cd], 'LPOL', 'OL', @[lstm_cd]))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_lgl_eng_nm} != \"\") " ).append("\n"); 
		query.append("AND C.VNDR_LGL_ENG_NM LIKE '%'||@[vndr_lgl_eng_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY VNDR_LGL_ENG_NM" ).append("\n"); 

	}
}