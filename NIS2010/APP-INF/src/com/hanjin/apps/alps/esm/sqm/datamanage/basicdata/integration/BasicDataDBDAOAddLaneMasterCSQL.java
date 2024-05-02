/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BasicDataDBDAOAddLaneMasterCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BasicDataDBDAOAddLaneMasterCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [Lane Master]을 [저장] 합니다.
	  * 2014.01.10 박은주 [CHM-201328244] IAS Sector Sales 판매시스템 개발(IAS_SCTR_FLG 추가)
	  * </pre>
	  */
	public BasicDataDBDAOAddLaneMasterCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ias_sctr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sqm_act_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOAddLaneMasterCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_QTA_LANE_MGMT (  " ).append("\n"); 
		query.append("             TRD_CD" ).append("\n"); 
		query.append("            ,RLANE_CD" ).append("\n"); 
		query.append("            ,SUB_TRD_CD" ).append("\n"); 
		query.append("            ,LANE_DIR_CD" ).append("\n"); 
		query.append("            ,IAS_SCTR_FLG   " ).append("\n"); 
		query.append("            ,SQM_ACT_FLG   " ).append("\n"); 
		query.append("            ,CRE_USR_ID          " ).append("\n"); 
		query.append("            ,CRE_DT              " ).append("\n"); 
		query.append("            ,UPD_USR_ID         " ).append("\n"); 
		query.append("            ,UPD_DT           )  " ).append("\n"); 
		query.append(" VALUES (                       " ).append("\n"); 
		query.append("            @[trd_cd]" ).append("\n"); 
		query.append("            ,@[rlane_cd]" ).append("\n"); 
		query.append("            ,@[sub_trd_cd]" ).append("\n"); 
		query.append("            ,@[lane_dir_cd]" ).append("\n"); 
		query.append("            ,DECODE(@[ias_sctr_flg],1,'Y',0,'N',NULL)                  " ).append("\n"); 
		query.append("            ,DECODE(@[sqm_act_flg] , 1,'Y','N')                  " ).append("\n"); 
		query.append("            ,@[cre_usr_id]                   " ).append("\n"); 
		query.append("            ,SYSDATE             " ).append("\n"); 
		query.append("            ,@[cre_usr_id]                 " ).append("\n"); 
		query.append("            ,SYSDATE )" ).append("\n"); 

	}
}