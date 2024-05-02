/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CommonDBDAOSearchUserRoleYnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.13
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.06.13 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchUserRoleYnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.07.26 김종준 [SRM-201118467] Daily F"cast Status 화면 alloc display 보완 USR_ROLE 체크
	  * 2011.08.26 이행지 선반영 - RHQ(HAMRU, NYCRA, SHARC, SINRS) =>SHARC, SINRS 제외
	  * 2011.08.30 이행지 선반영 취소 원복
	  * 2011.10.12 김종준 [CHM-201113896-01] Login Office가 ISTSC인 경우에는 Origin Office가 아닌 Login Office가 Loading Office와 일치할 경우 Alloc 이 조회될 수 있도록 수정 요청
	  * 2011.11.10 김종준 [CHM-201114445-01] f"cast history 화면 RGN Office 창 활성화
	  * 2013.06.13 진마리아 SELCDO 팀코드 변경 (SELCTY)
	  * </pre>
	  */
	public CommonDBDAOSearchUserRoleYnRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_role_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ui_name",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchUserRoleYnRSQL").append("\n"); 
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
		query.append("    'Y' USR_ROLE_YN" ).append("\n"); 
		query.append("FROM COM_USR_ROLE_MTCH A," ).append("\n"); 
		query.append("     COM_USER B" ).append("\n"); 
		query.append("WHERE A.USR_ID=B.USR_ID" ).append("\n"); 
		query.append("AND A.USR_ID= @[usr_id]" ).append("\n"); 
		query.append("#if (${ui_name} == 'EsmSpc0021')" ).append("\n"); 
		query.append("	AND (A.USR_ROLE_CD = @[usr_role_cd] " ).append("\n"); 
		query.append("	OR SPC_SCR_OFC_CONV_FNC(B.OFC_CD, @[ui_name]) IN ('HAMRU','NYCRA','SHARC','SINRS','ISTSC', 'SELCDO', 'SELCTY') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	-- Office Type이 SC이면서 RHQ가 NYCRA인 경우에만" ).append("\n"); 
		query.append("	OR ( SPC_SCR_OFC_CONV_FNC(@[ofc_cd], @[ui_name]) = 'NYCRA'" ).append("\n"); 
		query.append("    	   AND 'SC' = (SELECT OFC_TP_CD" ).append("\n"); 
		query.append("        	             FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("            	        WHERE OFC_CD = @[ofc_cd])  )" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND A.USR_ROLE_CD = @[usr_role_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
