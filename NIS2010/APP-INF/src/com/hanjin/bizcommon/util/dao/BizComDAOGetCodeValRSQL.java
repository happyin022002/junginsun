/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BizComDAOGetCodeValRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.util.dao;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BizComDAOGetCodeValRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetCodeVal
	  * </pre>
	  */
	public BizComDAOGetCodeValRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.util.dao").append("\n"); 
		query.append("FileName : BizComDAOGetCodeValRSQL").append("\n"); 
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
		query.append("#if (${jobcode} == 'CNT') " ).append("\n"); 
		query.append("SELECT CNT_NM CODEVAL" ).append("\n"); 
		query.append("  FROM MDM_COUNTRY" ).append("\n"); 
		query.append(" WHERE CNT_CD = @[code]" ).append("\n"); 
		query.append("#elseif (${jobcode} == 'STE') " ).append("\n"); 
		query.append("SELECT STE_NM CODEVAL" ).append("\n"); 
		query.append("  FROM MDM_STATE" ).append("\n"); 
		query.append(" WHERE STE_CD = @[code]" ).append("\n"); 
		query.append("#elseif (${jobcode} == 'LOC') " ).append("\n"); 
		query.append("SELECT LOC_NM CODEVAL" ).append("\n"); 
		query.append("  FROM MDM_LOCATION" ).append("\n"); 
		query.append(" WHERE LOC_CD = @[code]" ).append("\n"); 
		query.append("#elseif (${jobcode} == 'STE_EXIST') " ).append("\n"); 
		query.append("SELECT DECODE(NVL(COUNT(STE_CD), 0), 0, 'N', 'Y') CODEVAL" ).append("\n"); 
		query.append("  FROM MDM_STATE" ).append("\n"); 
		query.append(" WHERE CNT_CD = @[code]" ).append("\n"); 
		query.append("#elseif (${jobcode} == 'LOC_EXIST') " ).append("\n"); 
		query.append("SELECT DECODE(NVL(COUNT(LOC_CD), 0), 0, 'N', 'Y') CODEVAL" ).append("\n"); 
		query.append("  FROM MDM_LOCATION" ).append("\n"); 
		query.append(" WHERE CNT_CD = @[code]" ).append("\n"); 
		query.append("#elseif (${jobcode} == 'STE_LOC') " ).append("\n"); 
		query.append("SELECT STE_CD CODEVAL" ).append("\n"); 
		query.append("  FROM MDM_LOCATION" ).append("\n"); 
		query.append(" WHERE LOC_CD = @[code] " ).append("\n"); 
		query.append("#elseif (${jobcode} == 'CONTI_CNT') " ).append("\n"); 
		query.append("SELECT C.CONTI_CD CODEVAL" ).append("\n"); 
		query.append("  FROM MDM_COUNTRY A, MDM_SUBCONTINENT B, MDM_CONTINENT" ).append("\n"); 
		query.append(" WHERE A.CNT_CD = @[code] " ).append("\n"); 
		query.append("   AND A.SCONTI_CD=B.SCONTI_CD " ).append("\n"); 
		query.append("   AND B.CONTI_CD=C.CONTI_C" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}