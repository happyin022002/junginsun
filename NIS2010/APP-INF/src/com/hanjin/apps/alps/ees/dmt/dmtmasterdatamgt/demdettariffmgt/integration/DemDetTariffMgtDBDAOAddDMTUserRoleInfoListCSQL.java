/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DemDetTariffMgtDBDAOAddDMTUserRoleInfoListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.18
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2013.07.18 임창빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lim Chang Bin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemDetTariffMgtDBDAOAddDMTUserRoleInfoListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DMT User별 Role 정보를 생성 합니다.
	  * </pre>
	  */
	public DemDetTariffMgtDBDAOAddDMTUserRoleInfoListCSQL(){
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration").append("\n"); 
		query.append("FileName : DemDetTariffMgtDBDAOAddDMTUserRoleInfoListCSQL").append("\n"); 
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
		query.append("-- merge문을 사용한 이유는 화면에서 User ID, Role Code를 중복 Check를 할 수 없다." ).append("\n"); 
		query.append("-- 조회 후 PK를 변경할 수 있는 화면 구조이다." ).append("\n"); 
		query.append("-- 기 동록되어 있는 정보에 대해서는 Update 처리한다." ).append("\n"); 
		query.append("MERGE INTO DMT_USR_ROLE_MTCH" ).append("\n"); 
		query.append("USING DUAL" ).append("\n"); 
		query.append("ON    (     USR_ID      = @[usr_id]" ).append("\n"); 
		query.append("      AND   USR_ROLE_CD = @[usr_role_cd]" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET     " ).append("\n"); 
		query.append("       UPD_DT       = SYSDATE" ).append("\n"); 
		query.append("     , UPD_USR_ID   = @[cre_usr_id]" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("        USR_ID" ).append("\n"); 
		query.append("      , USR_ROLE_CD" ).append("\n"); 
		query.append("      , CRE_USR_ID" ).append("\n"); 
		query.append("      , CRE_DT" ).append("\n"); 
		query.append("      , UPD_USR_ID" ).append("\n"); 
		query.append("      , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("        @[usr_id]" ).append("\n"); 
		query.append("      , @[usr_role_cd]" ).append("\n"); 
		query.append("      , @[cre_usr_id]" ).append("\n"); 
		query.append("      , SYSDATE" ).append("\n"); 
		query.append("      , @[cre_usr_id]" ).append("\n"); 
		query.append("      , SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}