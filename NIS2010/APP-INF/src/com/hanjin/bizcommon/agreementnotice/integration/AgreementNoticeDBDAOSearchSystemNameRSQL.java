/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AgreementNoticeDBDAOSearchSystemNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.07
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2014.02.07 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.agreementnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementNoticeDBDAOSearchSystemNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search System Name
	  * </pre>
	  */
	public AgreementNoticeDBDAOSearchSystemNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.agreementnotice.integration").append("\n"); 
		query.append("FileName : AgreementNoticeDBDAOSearchSystemNameRSQL").append("\n"); 
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
		query.append("SELECT 'ACM' AS CD ,(SELECT PGM_NM FROM COM_PROGRAM WHERE PGM_NO = 'ESM_ACM_M001') AS NM FROM DUAL -- Agent Commission Management" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'CHS' AS CD ,(SELECT PGM_NM FROM COM_PROGRAM WHERE PGM_NO = 'EES_CGM_M001') AS NM FROM DUAL -- Chassis" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'LSE' AS CD ,(SELECT PGM_NM FROM COM_PROGRAM WHERE PGM_NO = 'EES_LSE_M001') AS NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'FMS' AS CD ,(SELECT PGM_NM FROM COM_PROGRAM WHERE PGM_NO = 'ESM_FMS_M001') AS NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'MNR' AS CD ,(SELECT PGM_NM FROM COM_PROGRAM WHERE PGM_NO = 'EES_MNR_M001') AS NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'MGS' AS CD ,(SELECT PGM_NM FROM COM_PROGRAM WHERE PGM_NO = 'EES_CGM_M019') AS NM FROM DUAL -- M.G.SET" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'TES' AS CD ,(SELECT PGM_NM FROM COM_PROGRAM WHERE PGM_NO = 'ESD_TES_M001') AS NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'TRS' AS CD ,(SELECT PGM_NM FROM COM_PROGRAM WHERE PGM_NO = 'ESD_TRS_M001') AS NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'PSO' AS CD ,(SELECT PGM_NM FROM COM_PROGRAM WHERE PGM_NO = 'VOP_PSO_M001') AS NM FROM DUAL" ).append("\n"); 

	}
}