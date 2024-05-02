/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ContinentDBDAOMdmSubcontinentVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.15
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2011.07.15 서미진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.continent.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO MI JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContinentDBDAOMdmSubcontinentVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ContinentDBDAOMdmSubcontinentVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sconti_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sconti_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.continent.integration").append("\n"); 
		query.append("FileName : ContinentDBDAOMdmSubcontinentVORSQL").append("\n"); 
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
		query.append("	SCONTI_CD" ).append("\n"); 
		query.append(",	SCONTI_NM" ).append("\n"); 
		query.append("FROM MDM_SUBCONTINENT" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${conti_cd} != '')" ).append("\n"); 
		query.append("AND CONTI_CD = @[conti_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sconti_cd} != '')" ).append("\n"); 
		query.append("AND SCONTI_CD LIKE ('%'||@[sconti_cd]||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sconti_nm} != '')" ).append("\n"); 
		query.append("AND SCONTI_NM LIKE ('%'||UPPER(@[sconti_nm])||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND	DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY SCONTI_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}