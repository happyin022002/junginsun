/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PrdCommonManageDBDAOValidationLaneVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.05
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2012.03.05 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.common.prdcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCommonManageDBDAOValidationLaneVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD와 Lane이 서로 유효한지 검사한다.
	  * 둘 다 입력되었을 때에만 검사하고, 한 가지만 입력되었을 경우, Validation하지 않는다.
	  * </pre>
	  */
	public PrdCommonManageDBDAOValidationLaneVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.common.prdcommon.integration").append("\n"); 
		query.append("FileName : PrdCommonManageDBDAOValidationLaneVvdRSQL").append("\n"); 
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
		query.append("SELECT DECODE(TRIM(@[vvd])" ).append("\n"); 
		query.append("             , NULL, 'Y'" ).append("\n"); 
		query.append("             , DECODE(TRIM(@[lane_code])" ).append("\n"); 
		query.append("                     , NULL, 'Y'" ).append("\n"); 
		query.append("                     , VSL.VSL_SLAN_CD, 'Y'" ).append("\n"); 
		query.append("                     , 'FDR', DECODE(LAN.VSL_SVC_TP_CD, 'O', 'Y', 'N')  " ).append("\n"); 
		query.append("                     ,'N')" ).append("\n"); 
		query.append("              ) AS CHECK_DATA" ).append("\n"); 
		query.append("FROM COM_CPY_NO CPY" ).append("\n"); 
		query.append("     LEFT OUTER JOIN VSK_VSL_SKD VSL" ).append("\n"); 
		query.append("      ON (VSL.VSL_CD    = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("          AND VSL.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("          AND VSL.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("     LEFT OUTER JOIN MDM_VSL_SVC_LANE LAN" ).append("\n"); 
		query.append("          ON (LAN.VSL_SLAN_CD = VSL.VSL_SLAN_CD)" ).append("\n"); 
		query.append("WHERE CPY_NO = 0" ).append("\n"); 

	}
}