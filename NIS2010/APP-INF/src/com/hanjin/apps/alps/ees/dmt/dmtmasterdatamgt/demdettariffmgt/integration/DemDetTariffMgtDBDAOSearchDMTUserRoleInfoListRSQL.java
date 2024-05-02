/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DemDetTariffMgtDBDAOSearchDMTUserRoleInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.09
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2013.09.09 임창빈
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

public class DemDetTariffMgtDBDAOSearchDMTUserRoleInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DMT User별 Role 정보를 조회한다.
	  * </pre>
	  */
	public DemDetTariffMgtDBDAOSearchDMTUserRoleInfoListRSQL(){
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
		params.put("usr_locl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration").append("\n"); 
		query.append("FileName : DemDetTariffMgtDBDAOSearchDMTUserRoleInfoListRSQL").append("\n"); 
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
		query.append("SELECT  T1.USR_ID" ).append("\n"); 
		query.append("      , T2.USR_NM" ).append("\n"); 
		query.append("      , T2.OFC_CD" ).append("\n"); 
		query.append("      , T1.USR_ROLE_CD" ).append("\n"); 
		query.append("      , T1.CRE_USR_ID, TO_CHAR(T1.CRE_DT, 'YYYY-MM-DD HH24:MI') AS CRE_DT" ).append("\n"); 
		query.append("      , T1.UPD_USR_ID, TO_CHAR(T1.UPD_DT, 'YYYY-MM-DD HH24:MI') AS UPD_DT" ).append("\n"); 
		query.append("FROM    DMT_USR_ROLE_MTCH T1, COM_USER T2" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     T1.USR_ID       = T2.USR_ID" ).append("\n"); 
		query.append("#if (${usr_id} != '')" ).append("\n"); 
		query.append("AND		T1.USR_ID       = @[usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${usr_locl_nm} != '')" ).append("\n"); 
		query.append("AND		T2.USR_LOCL_NM       LIKE @[usr_locl_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("AND		T2.OFC_CD       = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${usr_role_cd_list} != '')" ).append("\n"); 
		query.append("AND		T1.USR_ROLE_CD  IN (" ).append("\n"); 
		query.append("			#foreach($usr_role_cd in ${usr_role_cd_list} )" ).append("\n"); 
		query.append("				#if($velocityCount < $usr_role_cd_list.size()) '$usr_role_cd', #else '$usr_role_cd' #end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY 1, 4" ).append("\n"); 

	}
}