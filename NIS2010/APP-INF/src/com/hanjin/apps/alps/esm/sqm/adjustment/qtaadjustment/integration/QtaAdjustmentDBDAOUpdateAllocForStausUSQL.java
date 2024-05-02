/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : QtaAdjustmentDBDAOUpdateAllocForStausUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QtaAdjustmentDBDAOUpdateAllocForStausUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 확정 쿼타에 반영된 오피스들에 대해서 [Allocation = QTA Setting]의 상태를  [업데이트] 합니다.
	  * </pre>
	  */
	public QtaAdjustmentDBDAOUpdateAllocForStausUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOUpdateAllocForStausUSQL").append("\n"); 
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
		query.append("MERGE INTO SQM_ALOC_QTA X" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("        SELECT BSE_YR" ).append("\n"); 
		query.append("              ,TRD_CD" ).append("\n"); 
		query.append("              ,RLANE_CD" ).append("\n"); 
		query.append("              ,DIR_CD" ).append("\n"); 
		query.append("              ,VSL_CD" ).append("\n"); 
		query.append("              ,SKD_VOY_NO" ).append("\n"); 
		query.append("              ,SKD_DIR_CD" ).append("\n"); 
		query.append("              ,RGN_OFC_CD " ).append("\n"); 
		query.append("          FROM SQM_CFM_QTA" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND BSE_TP_CD     = 'Q'" ).append("\n"); 
		query.append("           AND BSE_YR        = @[bse_yr]" ).append("\n"); 
		query.append("           AND OFC_VW_CD     = 'L'" ).append("\n"); 
		query.append("           AND SQM_CNG_TP_CD = 'A'" ).append("\n"); 
		query.append("           AND VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("           AND SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("           AND SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("       ) Y" ).append("\n"); 
		query.append("ON  (" ).append("\n"); 
		query.append("         X.BSE_YR     = Y.BSE_YR     " ).append("\n"); 
		query.append("     AND X.TRD_CD     = Y.TRD_CD     " ).append("\n"); 
		query.append("     AND X.RLANE_CD   = Y.RLANE_CD   " ).append("\n"); 
		query.append("     AND X.DIR_CD     = Y.DIR_CD     " ).append("\n"); 
		query.append("     AND X.VSL_CD     = Y.VSL_CD" ).append("\n"); 
		query.append("     AND X.SKD_VOY_NO = Y.SKD_VOY_NO " ).append("\n"); 
		query.append("     AND X.SKD_DIR_CD = Y.SKD_DIR_CD     " ).append("\n"); 
		query.append("     AND X.RGN_OFC_CD = Y.RGN_OFC_CD " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("     UPDATE SET APLY_FLG   = 'Y'" ).append("\n"); 
		query.append("               ,UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("               ,UPD_DT     = SYSDATE" ).append("\n"); 

	}
}