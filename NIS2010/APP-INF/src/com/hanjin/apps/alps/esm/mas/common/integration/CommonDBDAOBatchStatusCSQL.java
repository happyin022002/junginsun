/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CommonDBDAOBatchStatusCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOBatchStatusCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 배치 상태 등록
	  * </pre>
	  */
	public CommonDBDAOBatchStatusCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_uc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOBatchStatusCSQL").append("\n"); 
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
		query.append("MERGE INTO MAS_UT_COST_CRE_STS A1" ).append("\n"); 
		query.append("  USING (" ).append("\n"); 
		query.append("         SELECT DECODE(@[f_uc_cd], 'TVVD', @[f_year]||'00', 'BKOP', @[f_year]||'00', 'BKUC', @[f_year]||'00', @[f_cost_yrmon]) COST_YRMON" ).append("\n"); 
		query.append("               ,DECODE(@[f_uc_cd], 'TVVD', '00', @[f_fm_wk]) COST_WK" ).append("\n"); 
		query.append("               ,@[f_uc_cd] CM_UC_CD" ).append("\n"); 
		query.append("               ,'P' COST_CRE_STS_CD" ).append("\n"); 
		query.append("           FROM DUAL" ).append("\n"); 
		query.append("        ) A2" ).append("\n"); 
		query.append("  ON (    A1.COST_YRMON      = A2.COST_YRMON" ).append("\n"); 
		query.append("      AND A1.COST_WK         = A2.COST_WK" ).append("\n"); 
		query.append("      AND A1.CM_UC_CD        = A2.CM_UC_CD" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("  WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("     INSERT(A1.COST_YRMON, A1.COST_WK, A1.CM_UC_CD, A1.COST_CRE_STS_CD, A1.COST_IF_STS_CD" ).append("\n"); 
		query.append("           ,A1.COST_SRC_FM_YRMON, A1.COST_SRC_TO_YRMON, A1.CRE_USR_ID, A1.CRE_DT, A1.UPD_USR_ID, A1.UPD_DT)" ).append("\n"); 
		query.append("     VALUES(A2.COST_YRMON, A2.COST_WK, A2.CM_UC_CD, A2.COST_CRE_STS_CD, ''" ).append("\n"); 
		query.append("           ,'', '',@[f_usr_id], SYSDATE,@[f_usr_id], SYSDATE )" ).append("\n"); 
		query.append("  WHEN MATCHED THEN" ).append("\n"); 
		query.append("     UPDATE" ).append("\n"); 
		query.append("        SET A1.COST_CRE_STS_CD = A2.COST_CRE_STS_CD" ).append("\n"); 
		query.append("           ,A1.UPD_USR_ID      = @[f_usr_id]" ).append("\n"); 
		query.append("           ,A1.UPD_DT          = SYSDATE" ).append("\n"); 

	}
}