/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOAutoEventDateUpdateHistoryParmVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.17
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2012.12.17 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sangbo La
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOAutoEventDateUpdateHistoryParmVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AutoEventDateUpdateHistoryParmVO
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOAutoEventDateUpdateHistoryParmVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tar_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOAutoEventDateUpdateHistoryParmVOCSQL").append("\n"); 
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
		query.append("INSERT INTO CTM_MVMT_EVNT_DT_HIS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("CNTR_NO" ).append("\n"); 
		query.append(",CNMV_YR" ).append("\n"); 
		query.append(",CNMV_ID_NO" ).append("\n"); 
		query.append(",CNMV_UPD_HIS_SEQ" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",MVMT_STS_CD" ).append("\n"); 
		query.append(",PRE_CNMV_EVNT_DT" ).append("\n"); 
		query.append(",CRNT_CNMV_EVNT_DT" ).append("\n"); 
		query.append(",CRNT_VSL_CD" ).append("\n"); 
		query.append(",CRNT_SKD_VOY_NO" ).append("\n"); 
		query.append(",CRNT_SKD_DIR_CD" ).append("\n"); 
		query.append(",FCNTR_FLG" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(",BL_NO" ).append("\n"); 
		query.append(",MVMT_EDI_MSG_TP_ID" ).append("\n"); 
		query.append(",OFC_CD" ).append("\n"); 
		query.append(",CRE_LOCL_DT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",UPD_LOCL_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",ORG_YD_CD" ).append("\n"); 
		query.append(",CNMV_RMK" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append(" CNTR_NO" ).append("\n"); 
		query.append(",CNMV_YR" ).append("\n"); 
		query.append(",CNMV_ID_NO" ).append("\n"); 
		query.append(",(SELECT NVL(MAX(CNMV_UPD_HIS_SEQ),0)+1" ).append("\n"); 
		query.append("    FROM CTM_MVMT_EVNT_DT_HIS " ).append("\n"); 
		query.append("   WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("     AND CNMV_YR = @[cnmv_yr]" ).append("\n"); 
		query.append("     AND CNMV_ID_NO  = @[cnmv_id])" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",MVMT_STS_CD" ).append("\n"); 
		query.append(",CNMV_EVNT_DT" ).append("\n"); 
		query.append(",TO_DATE (@[tar_date], 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append(",CRNT_VSL_CD" ).append("\n"); 
		query.append(",CRNT_SKD_VOY_NO" ).append("\n"); 
		query.append(",CRNT_SKD_DIR_CD" ).append("\n"); 
		query.append(",FCNTR_FLG" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(",BL_NO" ).append("\n"); 
		query.append(",MVMT_EDI_MSG_TP_ID" ).append("\n"); 
		query.append(",OFC_CD" ).append("\n"); 
		query.append(",CRE_LOCL_DT" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_LOCL_DT" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",ORG_YD_CD" ).append("\n"); 
		query.append(",@[cnmv_rmk]" ).append("\n"); 
		query.append(" FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("  AND CNMV_YR = @[cnmv_yr]" ).append("\n"); 
		query.append("  AND CNMV_ID_NO  = @[cnmv_id]" ).append("\n"); 
		query.append("  AND TO_CHAR(CNMV_EVNT_DT, 'YYYYMMDD') <> substr(@[tar_date], 1, 8)" ).append("\n"); 

	}
}