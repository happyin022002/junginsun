/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AgreementNoticeDBDAOSearchOfficeValidRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.12
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2014.02.12 CHLOE MIJIN SEO
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

public class AgreementNoticeDBDAOSearchOfficeValidRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOfficeValid
	  * </pre>
	  */
	public AgreementNoticeDBDAOSearchOfficeValidRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.agreementnotice.integration").append("\n"); 
		query.append("FileName : AgreementNoticeDBDAOSearchOfficeValidRSQL").append("\n"); 
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
		query.append("SELECT OFC_CD AS CD FROM MDM_ORGANIZATION WHERE 1=1" ).append("\n"); 
		query.append("#if(${nm} == 'HO') " ).append("\n"); 
		query.append("   AND OFC_TP_CD IN ('HT','HO')" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("#if(${nm} == 'HQ') " ).append("\n"); 
		query.append("   AND OFC_TP_CD IN ('HQ','QT')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${nm} == 'BB') " ).append("\n"); 
		query.append("   AND OFC_TP_CD NOT IN ('HT','HO','HQ','QT')" ).append("\n"); 
		query.append("#end       " ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND OFC_CD = @[cd]" ).append("\n"); 

	}
}