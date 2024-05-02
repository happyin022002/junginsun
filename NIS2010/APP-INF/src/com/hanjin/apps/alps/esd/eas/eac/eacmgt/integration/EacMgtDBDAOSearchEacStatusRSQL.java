/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOSearchEacStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.01
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.12.01 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOSearchEacStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EAC Status 콤보 조회
	  * </pre>
	  */
	public EacMgtDBDAOSearchEacStatusRSQL(){
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
		query.append("FileName : EacMgtDBDAOSearchEacStatusRSQL").append("\n"); 
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
		query.append("SELECT A.EAC_STS_CD AS DIS_EAC_STS_CD" ).append("\n"); 
		query.append("      ,B.INTG_CD_VAL_DP_DESC AS DIS_EAC_STS_NM" ).append("\n"); 
		query.append("      ,C.USR_NM AS APRO_USR_NM" ).append("\n"); 
		query.append("  FROM EAS_EXPN_AUD_CS_APRO_STEP A" ).append("\n"); 
		query.append("      ,COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("      ,COM_USER C" ).append("\n"); 
		query.append(" WHERE B.INTG_CD_ID = 'CD03337'" ).append("\n"); 
		query.append("   AND A.EAC_STS_CD = B.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("   AND A.APRO_USR_ID = C.USR_ID(+)" ).append("\n"); 
		query.append("   AND EAC_NO = @[eac_no]" ).append("\n"); 
		query.append("ORDER BY A.APRO_STEP_SEQ" ).append("\n"); 

	}
}