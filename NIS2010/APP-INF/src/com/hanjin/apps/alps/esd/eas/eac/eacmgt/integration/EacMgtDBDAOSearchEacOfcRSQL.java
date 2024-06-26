/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOSearchEacOfcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.05 백형인
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

public class EacMgtDBDAOSearchEacOfcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office Config 를 조회 한다
	  * </pre>
	  */
	public EacMgtDBDAOSearchEacOfcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOSearchEacOfcRSQL").append("\n"); 
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
		query.append("SELECT EAC_OFC_CD" ).append("\n"); 
		query.append("     , OFC_ENG_NM" ).append("\n"); 
		query.append("     , OFC_ADDR" ).append("\n"); 
		query.append("     , STE_NM" ).append("\n"); 
		query.append("     , CTY_NM" ).append("\n"); 
		query.append("     , OFC_ZIP_CD" ).append("\n"); 
		query.append("     , OFC_PHN_NO" ).append("\n"); 
		query.append("     , OFC_FAX_NO" ).append("\n"); 
		query.append("     , OFC_EML" ).append("\n"); 
		query.append("     , EAC_OFC_URL" ).append("\n"); 
		query.append("     , FTR_CTNT" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("FROM   EAS_EXPN_AUD_CS_OFC_CFG" ).append("\n"); 
		query.append("WHERE  EAC_OFC_CD = @[eac_ofc_cd]" ).append("\n"); 

	}
}