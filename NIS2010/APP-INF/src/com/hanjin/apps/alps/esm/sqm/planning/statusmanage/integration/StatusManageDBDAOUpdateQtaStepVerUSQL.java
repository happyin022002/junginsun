/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : StatusManageDBDAOUpdateQtaStepVerUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.03
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2013.09.03 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.statusmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusManageDBDAOUpdateQtaStepVerUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cancel Confirm
	  * </pre>
	  */
	public StatusManageDBDAOUpdateQtaStepVerUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("qta_step_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conv_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("qta_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.planning.statusmanage.integration").append("\n"); 
		query.append("FileName : StatusManageDBDAOUpdateQtaStepVerUSQL").append("\n"); 
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
		query.append("UPDATE SQM_QTA_STEP_VER" ).append("\n"); 
		query.append("   SET SQM_VER_STS_CD = 'P'" ).append("\n"); 
		query.append("      ,CFM_GDT        = NULL" ).append("\n"); 
		query.append("      ,UPD_USR_ID     = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT         = SYSDATE" ).append("\n"); 
		query.append(" WHERE BSE_TP_CD      = @[bse_tp_cd]" ).append("\n"); 
		query.append("   AND BSE_YR         = @[bse_yr]" ).append("\n"); 
		query.append("   AND BSE_QTR_CD     = DECODE(@[bse_tp_cd], 'Y', '00', @[bse_qtr_cd])" ).append("\n"); 
		query.append("   AND OFC_VW_CD      = DECODE(@[qta_step_cd], '01', OFC_VW_CD, @[ofc_vw_cd])" ).append("\n"); 
		query.append("   AND QTA_STEP_CD    = @[qta_step_cd]" ).append("\n"); 
		query.append("   AND QTA_VER_NO     = @[qta_ver_no]" ).append("\n"); 
		query.append("   AND TRD_CD         = @[trd_cd]" ).append("\n"); 
		query.append("   AND CONV_DIR_CD    = @[conv_dir_cd]" ).append("\n"); 
		query.append("   AND SQM_VER_STS_CD = 'C'" ).append("\n"); 

	}
}