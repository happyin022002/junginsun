/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementImportDBDAOSearchSubOfcCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.04
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2010.05.04 최종혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementImportDBDAOSearchSubOfcCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office의 Sub Office 조회
	  * </pre>
	  */
	public AgreementImportDBDAOSearchSubOfcCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration ").append("\n"); 
		query.append("FileName : AgreementImportDBDAOSearchSubOfcCdRSQL").append("\n"); 
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
		query.append("#foreach( ${key} in ${arr_office})" ).append("\n"); 
		query.append("#if($velocityCount != 1)" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SELECT OFC_CD FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("START WITH OFC_CD = '$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}