/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementValidationDBDAOSearchOfcCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementValidationDBDAOSearchOfcCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOfcCd
	  * </pre>
	  */
	public ContainerMovementValidationDBDAOSearchOfcCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.integration").append("\n"); 
		query.append("FileName : ContainerMovementValidationDBDAOSearchOfcCdRSQL").append("\n"); 
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
		query.append("SELECT OFC_N8TH_LVL_CD" ).append("\n"); 
		query.append("  FROM DMT_OFC_LVL_V" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if (${ofc_lvl} == '1') " ).append("\n"); 
		query.append("   AND OFC_N1ST_LVL_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#elseif (${ofc_lvl} == '2') " ).append("\n"); 
		query.append("   AND OFC_N2ND_LVL_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#elseif (${ofc_lvl} == '3') " ).append("\n"); 
		query.append("   AND OFC_N3RD_LVL_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#elseif (${ofc_lvl} == '4') " ).append("\n"); 
		query.append("   AND OFC_N4TH_LVL_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#elseif (${ofc_lvl} == '5') " ).append("\n"); 
		query.append("   AND OFC_N5TH_LVL_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND OFC_N8TH_LVL_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND OFC_N8TH_LVL_CD = @[yd_ofc]" ).append("\n"); 

	}
}