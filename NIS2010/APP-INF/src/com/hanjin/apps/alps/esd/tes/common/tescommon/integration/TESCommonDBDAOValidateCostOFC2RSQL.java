/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TESCommonDBDAOValidateCostOFC2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2010.02.04 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tescommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESCommonDBDAOValidateCostOFC2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * validate Cost Office Inquiry
	  * </pre>
	  */
	public TESCommonDBDAOValidateCostOFC2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.tescommon.integration").append("\n"); 
		query.append("FileName : TESCommonDBDAOValidateCostOFC2RSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("CASE WHEN COUNT(O.OFC_CD)>0 THEN 'Y' ELSE 'N' END IS_EXISTING_OFC_CD" ).append("\n"); 
		query.append(", (SELECT CASE WHEN COUNT(Y.YD_CD)>0" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END IS_VALID_YD_CD" ).append("\n"); 
		query.append("FROM	MDM_YARD Y" ).append("\n"); 
		query.append("WHERE	Y.OFC_CD = @[cost_ofc_cd]" ).append("\n"); 
		query.append("AND	Y.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append(") IS_VALID_YD_CD" ).append("\n"); 
		query.append(", O.DELT_FLG" ).append("\n"); 
		query.append("FROM	MDM_ORGANIZATION O" ).append("\n"); 
		query.append("WHERE	O.OFC_CD = @[cost_ofc_cd]" ).append("\n"); 
		query.append("GROUP BY O.OFC_CD" ).append("\n"); 
		query.append(", O.DELT_FLG" ).append("\n"); 

	}
}