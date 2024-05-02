/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOSearchSendMailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.09 백형인
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

public class EacMgtDBDAOSearchSendMailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 메일 팩스등의 전송정보를 조회한다.
	  * </pre>
	  */
	public EacMgtDBDAOSearchSendMailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOSearchSendMailRSQL").append("\n"); 
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
		query.append("SELECT EML_SUBJ_CTNT" ).append("\n"); 
		query.append("     , REPLACE(EML_CTNT,CHR(13),'</br>') AS EML_CTNT" ).append("\n"); 
		query.append("     , B.PHN_NO" ).append("\n"); 
		query.append("     , B.FAX_NO" ).append("\n"); 
		query.append("     , B.VNDR_EML" ).append("\n"); 
		query.append("FROM   EAS_EXPN_AUD_CS_MGMT A" ).append("\n"); 
		query.append("     , EAS_EXPN_AUD_CS_CNTC_PNT B" ).append("\n"); 
		query.append("WHERE  A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("AND    A.VNDR_CNTC_PNT_SEQ = B.VNDR_CNTC_PNT_SEQ" ).append("\n"); 
		query.append("AND    A.EAC_NO = @[eac_no]" ).append("\n"); 

	}
}