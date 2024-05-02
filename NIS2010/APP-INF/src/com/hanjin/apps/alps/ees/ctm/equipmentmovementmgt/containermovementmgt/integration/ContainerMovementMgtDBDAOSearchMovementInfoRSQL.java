/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOSearchMovementInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOSearchMovementInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Movement row 단위 조회.
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOSearchMovementInfoRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_id_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOSearchMovementInfoRSQL").append("\n"); 
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
		query.append("SELECT NVL(DECODE(FCNTR_FLG, 'Y', 'F', 'N', 'M', FCNTR_FLG), 'N') AS FCNTR_FLG," ).append("\n"); 
		query.append("  DECODE(OB_CNTR_FLG, 'Y', 'O', 'N', 'I', OB_CNTR_FLG) AS OB_CNTR_FLG," ).append("\n"); 
		query.append("  VNDR_SEQ," ).append("\n"); 
		query.append("  CNMV_RMK," ).append("\n"); 
		query.append("  USR_NM," ).append("\n"); 
		query.append("  WBL_NO," ).append("\n"); 
		query.append("  PKUP_NO," ).append("\n"); 
		query.append("  CNMV_CO_CD," ).append("\n"); 
		query.append("  CNMV_SPLIT_NO," ).append("\n"); 
		query.append("  MVMT_STS_CD," ).append("\n"); 
		query.append("  BKG_NO," ).append("\n"); 
		query.append("  BL_NO," ).append("\n"); 
		query.append("  CNMV_CYC_NO," ).append("\n"); 
		query.append("  BKG_CGO_TP_CD," ).append("\n"); 
		query.append("  DEST_YD_CD," ).append("\n"); 
		query.append("  INP_YD_CD," ).append("\n"); 
		query.append("  ORG_YD_CD," ).append("\n"); 
		query.append("  CHSS_NO," ).append("\n"); 
		query.append("  MGST_NO," ).append("\n"); 
		query.append("  CRNT_VSL_CD || CRNT_SKD_VOY_NO || CRNT_SKD_DIR_CD AS CNTR_ID," ).append("\n"); 
		query.append("  CNTR_SEAL_NO," ).append("\n"); 
		query.append("  CNTR_DMG_FLG," ).append("\n"); 
		query.append("  CNTR_DISP_FLG," ).append("\n"); 
		query.append("  IMDT_EXT_FLG," ).append("\n"); 
		query.append("  CNTR_XCH_CD," ).append("\n"); 
		query.append("  SPCL_CGO_FLG," ).append("\n"); 
		query.append("  TO_CHAR (CNMV_EVNT_DT, 'YYYYMMDDHH24MI') AS CNMV_EVNT_DT," ).append("\n"); 
		query.append("  MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("  MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("  MVMT_CRE_TP_CD," ).append("\n"); 
		query.append("  OFC_CD," ).append("\n"); 
		query.append("  CNT_CD" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("  AND CNMV_YR = @[cnmv_yr]" ).append("\n"); 
		query.append("  AND CNMV_ID_NO = @[cnmv_id_no]" ).append("\n"); 

	}
}