/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : USA404EDIStatusInquiryDBDAOSearchFaxNoVndrEmlByVndrSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USA404EDIStatusInquiryDBDAOSearchFaxNoVndrEmlByVndrSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchFaxNoVndrEmlByVndrSeq
	  * </pre>
	  */
	public USA404EDIStatusInquiryDBDAOSearchFaxNoVndrEmlByVndrSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration").append("\n"); 
		query.append("FileName : USA404EDIStatusInquiryDBDAOSearchFaxNoVndrEmlByVndrSeqRSQL").append("\n"); 
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
		query.append("      ,A.VNDR_LOCL_LANG_NM" ).append("\n"); 
		query.append("      ,B.FAX_NO" ).append("\n"); 
		query.append("      ,B.VNDR_EML" ).append("\n"); 
		query.append("  FROM MDM_VENDOR        A" ).append("\n"); 
		query.append("      ,MDM_VNDR_CNTC_PNT B" ).append("\n"); 
		query.append(" WHERE A.VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("   AND B.PRMRY_CHK_FLG(+) = 'Y'" ).append("\n"); 
		query.append("   AND B.DELT_FLG(+) <> 'Y'" ).append("\n"); 
		query.append("   AND NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("   AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 

	}
}