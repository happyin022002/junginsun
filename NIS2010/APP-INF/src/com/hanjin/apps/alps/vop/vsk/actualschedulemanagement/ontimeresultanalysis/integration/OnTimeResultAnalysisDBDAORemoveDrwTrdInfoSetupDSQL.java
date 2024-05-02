/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OnTimeResultAnalysisDBDAORemoveDrwTrdInfoSetupDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnTimeResultAnalysisDBDAORemoveDrwTrdInfoSetupDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Drewry Report의 Trade Setup에서 Trade 정보를 삭제한다.
	  * </pre>
	  */
	public OnTimeResultAnalysisDBDAORemoveDrwTrdInfoSetupDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drw_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration").append("\n"); 
		query.append("FileName : OnTimeResultAnalysisDBDAORemoveDrwTrdInfoSetupDSQL").append("\n"); 
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
		query.append("MERGE INTO VSK_DRW_TGT_TRD DRW" ).append("\n"); 
		query.append("    USING" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT  @[drw_trd_cd]                DRW_TRD_CD" ).append("\n"); 
		query.append("        FROM    DUAL" ).append("\n"); 
		query.append("    )   SRC" ).append("\n"); 
		query.append("    ON" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("                DRW.DRW_TRD_CD = SRC.DRW_TRD_CD	" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHEN MATCHED THEN " ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET       " ).append("\n"); 
		query.append("                  DELT_FLG          = 'Y'" ).append("\n"); 
		query.append("                , UPD_USR_ID        = @[upd_usr_id]" ).append("\n"); 
		query.append("                , UPD_DT            = SYSDATE" ).append("\n"); 

	}
}