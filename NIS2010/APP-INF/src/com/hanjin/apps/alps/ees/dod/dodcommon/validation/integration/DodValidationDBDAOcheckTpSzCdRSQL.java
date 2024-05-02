/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DodValidationDBDAOcheckTpSzCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.19
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2015.11.19 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodcommon.validation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DodValidationDBDAOcheckTpSzCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Type Size 유효성 검증
	  * </pre>
	  */
	public DodValidationDBDAOcheckTpSzCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_value",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.dodcommon.validation.integration ").append("\n"); 
		query.append("FileName : DodValidationDBDAOcheckTpSzCdRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1) CNT" ).append("\n"); 
		query.append("  FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append(" WHERE CNTR_TPSZ_CD = @[s_value]" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}