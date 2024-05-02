/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UtilDBDAOSearchVenderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.25
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.25 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.common.util.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UtilDBDAOSearchVenderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 사용자가 입력한 Vender 코드로 조회한다
	  * </pre>
	  */
	public UtilDBDAOSearchVenderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.common.util.integration").append("\n"); 
		query.append("FileName : UtilDBDAOSearchVenderRSQL").append("\n"); 
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
		query.append("SELECT LPAD(VNDR_SEQ, 6, '0') AS VNDR_SEQ" ).append("\n"); 
		query.append("     , VNDR_LGL_ENG_NM VNDR_NM" ).append("\n"); 
		query.append("     , '' AS EG_RHQ_CD" ).append("\n"); 
		query.append("     , OFC_CD AS EG_OFC_CD" ).append("\n"); 
		query.append("  FROM MDM_VENDOR" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND VNDR_SEQ= @[sp_seq]" ).append("\n"); 
		query.append("  AND NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 

	}
}