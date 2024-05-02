/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACommAgreementDBDAOGetTemplateMailLocalDateInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.30
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.30 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmagreement.facommagreement.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACommAgreementDBDAOGetTemplateMailLocalDateInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 지역 현재 날짜 가져오기
	  * </pre>
	  */
	public FACommAgreementDBDAOGetTemplateMailLocalDateInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmagreement.facommagreement.integration ").append("\n"); 
		query.append("FileName : FACommAgreementDBDAOGetTemplateMailLocalDateInfoRSQL").append("\n"); 
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
		query.append("	TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', SYSDATE, LOC_CD), 'DD-MM-YYYY HH:MI:SS') AS LOC_DT" ).append("\n"); 
		query.append("FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE  OFC_CD = @[fac_ofc_cd]" ).append("\n"); 

	}
}