/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOMDMSPInformationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.07
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.07 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOMDMSPInformationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/P Contact point 의  MDM S/P Information 을 조회한다
	  * </pre>
	  */
	public EacMgtDBDAOMDMSPInformationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOMDMSPInformationRSQL").append("\n"); 
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
		query.append("SELECT A.VNDR_SEQ" ).append("\n"); 
		query.append("      ,A.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,A.ZIP_CD" ).append("\n"); 
		query.append("      ,A.ENG_ADDR" ).append("\n"); 
		query.append("      ,'' CTY_NM -- MDM에서 정보를 못 찾음" ).append("\n"); 
		query.append("      ,(SELECT Y.STE_NM " ).append("\n"); 
		query.append("          FROM MDM_LOCATION X" ).append("\n"); 
		query.append("              ,MDM_STATE    Y" ).append("\n"); 
		query.append("         WHERE X.CNT_CD = Y.CNT_CD" ).append("\n"); 
		query.append("           AND X.STE_CD = Y.STE_CD" ).append("\n"); 
		query.append("           AND X.LOC_CD = A.LOC_CD" ).append("\n"); 
		query.append("       ) STE_NM" ).append("\n"); 
		query.append("      ,(SELECT X.PHN_NO" ).append("\n"); 
		query.append("          FROM MDM_VNDR_CNTC_PNT X" ).append("\n"); 
		query.append("         WHERE X.PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("           AND X.CNTC_DIV_CD = 'PHN'" ).append("\n"); 
		query.append("           AND X.DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND X.VNDR_SEQ = A.VNDR_SEQ" ).append("\n"); 
		query.append("       ) PHN_NO" ).append("\n"); 
		query.append("      ,(SELECT X.VNDR_EML" ).append("\n"); 
		query.append("          FROM MDM_VNDR_CNTC_PNT X" ).append("\n"); 
		query.append("         WHERE X.PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("           AND X.CNTC_DIV_CD = 'EMAIL'" ).append("\n"); 
		query.append("           AND X.DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND X.VNDR_SEQ = A.VNDR_SEQ           " ).append("\n"); 
		query.append("       ) VNDR_EML" ).append("\n"); 
		query.append("      ,(SELECT X.FAX_NO" ).append("\n"); 
		query.append("          FROM MDM_VNDR_CNTC_PNT X" ).append("\n"); 
		query.append("         WHERE X.PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("           AND X.CNTC_DIV_CD = 'FAX'" ).append("\n"); 
		query.append("           AND X.DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND X.VNDR_SEQ = A.VNDR_SEQ           " ).append("\n"); 
		query.append("       ) FAX_NO" ).append("\n"); 
		query.append("      FROM MDM_VENDOR A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${s_cnt_cd} != '')" ).append("\n"); 
		query.append("     AND UPPER(VNDR_CNT_CD) like UPPER(@[s_cnt_cd]) || '%'" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${s_ofc_cd} != '')" ).append("\n"); 
		query.append("     AND UPPER(OFC_CD) like UPPER(@[s_ofc_cd]) || '%'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${s_vndr_seq} != '') " ).append("\n"); 
		query.append("AND   A.VNDR_SEQ = @[s_vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${contact_point_exists} == 'Y') " ).append("\n"); 
		query.append("AND   EXISTS (SELECT 1 FROM EAS_EXPN_AUD_CS_CNTC_PNT X WHERE X.VNDR_SEQ = A.VNDR_SEQ)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${contact_point_exists} == 'N') " ).append("\n"); 
		query.append("AND   NOT EXISTS (SELECT 1 FROM EAS_EXPN_AUD_CS_CNTC_PNT X WHERE X.VNDR_SEQ = A.VNDR_SEQ)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.VNDR_SEQ ASC" ).append("\n"); 

	}
}