/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOupdateEdiMsgFromBkgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.08
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.03.08 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOupdateEdiMsgFromBkgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG에 제공.
	  * MT VL에 Bkg를 Update할때 EDI Message를 Update하도록 한다
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOupdateEdiMsgFromBkgUSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_id_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crnt_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOupdateEdiMsgFromBkgUSQL").append("\n"); 
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
		query.append("UPDATE CTM_MVMT_EDI_MSG" ).append("\n"); 
		query.append("SET CRNT_VSL_CD = @[crnt_vsl_cd]," ).append("\n"); 
		query.append("CRNT_SKD_VOY_NO = @[crnt_skd_voy_no]," ).append("\n"); 
		query.append("CRNT_SKD_DIR_CD = @[crnt_skd_dir_cd]," ).append("\n"); 
		query.append("BKG_NO = @[bkg_no]," ).append("\n"); 
		query.append("EDI_BL_NO = @[bl_no]" ).append("\n"); 
		query.append("WHERE (MVMT_EDI_TP_CD," ).append("\n"); 
		query.append("MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("MVMT_EDI_MSG_AREA_CD," ).append("\n"); 
		query.append("MVMT_EDI_MSG_YRMONDY," ).append("\n"); 
		query.append("MVMT_EDI_MSG_SEQ) IN (SELECT MVMT_EDI_TP_CD," ).append("\n"); 
		query.append("MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("MVMT_EDI_MSG_AREA_CD," ).append("\n"); 
		query.append("MVMT_EDI_MSG_YRMONDY," ).append("\n"); 
		query.append("MVMT_EDI_MSG_SEQ" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND CNMV_YR = @[cnmv_yr]" ).append("\n"); 
		query.append("AND CNMV_ID_NO = @[cnmv_id_no]" ).append("\n"); 
		query.append("AND PRE_STS_FLG = 'Y'" ).append("\n"); 
		query.append("AND MVMT_STS_CD = 'VL')" ).append("\n"); 

	}
}