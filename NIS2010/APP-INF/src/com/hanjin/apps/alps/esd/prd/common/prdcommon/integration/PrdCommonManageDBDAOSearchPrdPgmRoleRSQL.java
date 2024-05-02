/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PrdCommonManageDBDAOSearchPrdPgmRoleRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.21
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.common.prdcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCommonManageDBDAOSearchPrdPgmRoleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPrdPgmRole
	  * </pre>
	  */
	public PrdCommonManageDBDAOSearchPrdPgmRoleRSQL(){
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
		params.put("pgm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.common.prdcommon.integration ").append("\n"); 
		query.append("FileName : PrdCommonManageDBDAOSearchPrdPgmRoleRSQL").append("\n"); 
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
		query.append("select PGM_NO," ).append("\n"); 
		query.append("min(decode(priority,1,PCTL_PGM_ROLE_CD)) PCTL_PGM_ROLE_CD1, -- R" ).append("\n"); 
		query.append("min(decode(priority,2,PCTL_PGM_ROLE_CD)) PCTL_PGM_ROLE_CD2, -- D" ).append("\n"); 
		query.append("min(decode(priority,3,PCTL_PGM_ROLE_CD)) PCTL_PGM_ROLE_CD3, -- U" ).append("\n"); 
		query.append("min(decode(priority,4,PCTL_PGM_ROLE_CD)) PCTL_PGM_ROLE_CD4, -- C" ).append("\n"); 
		query.append("min(decode(ADD_priority,5,PCTL_PGM_ROLE_CD)) ADD_PCTL_PGM_ROLE_CD, -- OCN_FLG" ).append("\n"); 
		query.append("case max(priority)" ).append("\n"); 
		query.append("when 5 then 'S'" ).append("\n"); 
		query.append("when 4 then 'C'" ).append("\n"); 
		query.append("when 3 then 'U'" ).append("\n"); 
		query.append("when 2 then 'D'" ).append("\n"); 
		query.append("when 1 then 'R'" ).append("\n"); 
		query.append("end CRUD" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select pr.PGM_NO, pr.usr_role_cd ,prd.PCTL_PGM_ROLE_CD," ).append("\n"); 
		query.append("ROW_NUMBER() OVER(PARTITION BY pr.PGM_NO   ORDER BY pr.usr_role_cd ) r," ).append("\n"); 
		query.append("case prd.PCTL_PGM_ROLE_CD" ).append("\n"); 
		query.append("when 'S' then 5" ).append("\n"); 
		query.append("when 'C' then 4" ).append("\n"); 
		query.append("when 'U' then 3" ).append("\n"); 
		query.append("when 'D' then 2" ).append("\n"); 
		query.append("when 'R' then 1" ).append("\n"); 
		query.append("end   priority" ).append("\n"); 
		query.append(",case prd.PCTL_PGM_ROLE_CD          when 'S' then 5      end   ADD_priority from COM_PGM_ROLE pr, COM_USR_ROLE_MTCH ur, PRD_PGM_ROLE prd" ).append("\n"); 
		query.append("where pr.USR_ROLE_CD = ur.USR_ROLE_CD" ).append("\n"); 
		query.append("and pr.PGM_NO like '%'||@[pgm_no]||'%'" ).append("\n"); 
		query.append("and pr.PGM_NO = prd.PGM_NO" ).append("\n"); 
		query.append("and pr.USR_ROLE_CD = prd.USR_ROLE_CD" ).append("\n"); 
		query.append("and ur.USR_ID= @[usr_id]" ).append("\n"); 
		query.append(") tab1" ).append("\n"); 
		query.append("group by PGM_NO" ).append("\n"); 

	}
}