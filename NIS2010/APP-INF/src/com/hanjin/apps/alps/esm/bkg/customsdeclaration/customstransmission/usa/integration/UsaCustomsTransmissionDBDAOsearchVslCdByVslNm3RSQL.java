/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchVslCdByVslNm3RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.07
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.04.07 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchVslCdByVslNm3RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 미세관응답메세지 수신 outVO : VslNameVO
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchVslCdByVslNm3RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchVslCdByVslNm3RSQL").append("\n"); 
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
		query.append("SELECT B.VSL_CD" ).append("\n"); 
		query.append("  FROM MDM_VSL_CNTR A" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_SND_LOG B" ).append("\n"); 
		query.append(" WHERE A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("   AND B.CNT_CD = 'US'" ).append("\n"); 
		query.append("   AND B.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND (SUBSTR(A.VSL_EDI_NM, 1, 23) = REPLACE(TRIM(@[vsl_eng_nm]), ' ', '') " ).append("\n"); 
		query.append("     OR SUBSTR(A.VSL_ENG_NM, 1, 23) = TRIM(@[vsl_eng_nm]))" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}