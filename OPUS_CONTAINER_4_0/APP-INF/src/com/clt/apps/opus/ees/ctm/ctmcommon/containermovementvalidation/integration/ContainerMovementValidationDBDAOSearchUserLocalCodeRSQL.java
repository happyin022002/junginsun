/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementValidationDBDAOSearchUserLocalCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.09.15 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementValidationDBDAOSearchUserLocalCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 로그인 사용자의 Country코드로 Lacal코드 조회
	  * </pre>
	  */
	public ContainerMovementValidationDBDAOSearchUserLocalCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.integration").append("\n"); 
		query.append("FileName : ContainerMovementValidationDBDAOSearchUserLocalCodeRSQL").append("\n"); 
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
		query.append("SELECT SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append("FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("WHERE CO_IND_CD = 'H'" ).append("\n"); 
		query.append("#if (${cnt_cd} != '')" ).append("\n"); 
		query.append("AND CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}