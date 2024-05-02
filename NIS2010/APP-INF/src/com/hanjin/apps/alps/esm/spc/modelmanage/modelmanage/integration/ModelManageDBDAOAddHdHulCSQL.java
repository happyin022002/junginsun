/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ModelManageDBDAOAddHdHulCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.10
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2013.04.10 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAOAddHdHulCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 노선별 Head Hual Bound 정보를 저장한다.
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * </pre>
	  */
	public ModelManageDBDAOAddHdHulCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOAddHdHulCSQL").append("\n"); 
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
		query.append("MERGE INTO SPC_HD_HUL_MST M" ).append("\n"); 
		query.append("USING (SELECT @[trd_cd]     AS TRD_CD," ).append("\n"); 
		query.append("              @[sub_trd_cd] AS SUB_TRD_CD," ).append("\n"); 
		query.append("              @[rlane_cd]   AS RLANE_CD," ).append("\n"); 
		query.append("              @[dir_cd]     AS DIR_CD," ).append("\n"); 
		query.append("              @[usr_id]     AS UPD_USR_ID" ).append("\n"); 
		query.append("         FROM DUAL) A" ).append("\n"); 
		query.append("   ON (" ).append("\n"); 
		query.append("           A.TRD_CD   = M.TRD_CD" ).append("\n"); 
		query.append("       AND A.RLANE_CD = M.RLANE_CD" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("       M.DIR_CD     = A.DIR_CD," ).append("\n"); 
		query.append("       M.UPD_USR_ID = A.UPD_USR_ID," ).append("\n"); 
		query.append("       M.UPD_DT     = SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("          M.TRD_CD," ).append("\n"); 
		query.append("          M.SUB_TRD_CD," ).append("\n"); 
		query.append("          M.RLANE_CD," ).append("\n"); 
		query.append("          M.DIR_CD," ).append("\n"); 
		query.append("          M.CRE_USR_ID," ).append("\n"); 
		query.append("          M.CRE_DT," ).append("\n"); 
		query.append("          M.UPD_USR_ID," ).append("\n"); 
		query.append("          M.UPD_DT" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("VALUES (   " ).append("\n"); 
		query.append("           A.TRD_CD," ).append("\n"); 
		query.append("           A.SUB_TRD_CD," ).append("\n"); 
		query.append("           A.RLANE_CD," ).append("\n"); 
		query.append("           A.DIR_CD," ).append("\n"); 
		query.append("           A.UPD_USR_ID," ).append("\n"); 
		query.append("           SYSDATE," ).append("\n"); 
		query.append("           A.UPD_USR_ID," ).append("\n"); 
		query.append("           SYSDATE" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}