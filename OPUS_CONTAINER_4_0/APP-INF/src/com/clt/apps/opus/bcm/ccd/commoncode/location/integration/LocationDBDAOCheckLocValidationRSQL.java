/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : LocationDBDAOCheckLocValidationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.26
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.location.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LocationDBDAOCheckLocValidationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Location Validation
	  * </pre>
	  */
	public LocationDBDAOCheckLocValidationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.location.integration").append("\n"); 
		query.append("FileName : LocationDBDAOCheckLocValidationRSQL").append("\n"); 
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
		query.append("SELECT  COUNT(1)" ).append("\n"); 
		query.append("  FROM  MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("   AND  SCC_CD <> @[scc_cd]" ).append("\n"); 
		query.append("#if(${div} == 'RL')" ).append("\n"); 
		query.append("   AND  LCC_CD = @[lcc_cd]" ).append("\n"); 
		query.append("   AND  RCC_CD <> @[rcc_cd]" ).append("\n"); 
		query.append("#elseif(${div} == 'LE')" ).append("\n"); 
		query.append("   AND  ECC_CD = @[ecc_cd]" ).append("\n"); 
		query.append("   AND  LCC_CD <> @[lcc_cd]" ).append("\n"); 
		query.append("#elseif(${div} == 'RE')" ).append("\n"); 
		query.append("   AND  ECC_CD = @[ecc_cd]" ).append("\n"); 
		query.append("   AND  RCC_CD <> @[rcc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}