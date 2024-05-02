/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerMovementValidationDBDAOSearchUserCntCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.03.18 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementValidationDBDAOSearchUserCntCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 로그인 사용자의 Office코드로 Country코드 조회
	  * </pre>
	  */
	public ContainerMovementValidationDBDAOSearchUserCntCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.integration").append("\n"); 
		query.append("FileName : ContainerMovementValidationDBDAOSearchUserCntCodeRSQL").append("\n"); 
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
		query.append("SELECT S.CNT_CD" ).append("\n"); 
		query.append("FROM COM_SYS_AREA_GRP_ID S," ).append("\n"); 
		query.append("MDM_ORGANIZATION O" ).append("\n"); 
		query.append("WHERE S.CO_IND_CD = 'H'" ).append("\n"); 
		query.append("AND S.CNT_CD = SUBSTR (O.LOC_CD, 1, 2)" ).append("\n"); 
		query.append("AND O.OFC_CD = @[ofc_cd]" ).append("\n"); 

	}
}