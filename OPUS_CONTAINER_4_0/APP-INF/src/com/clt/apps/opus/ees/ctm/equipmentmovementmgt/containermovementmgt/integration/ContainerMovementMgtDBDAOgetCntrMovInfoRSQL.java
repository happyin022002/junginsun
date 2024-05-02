/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOgetCntrMovInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOgetCntrMovInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CTM_MOVEMENT TABLE에서 컨테이너 정보가 존재하고 있는지 확인한다.
	  * 입력 SEQ 정보를 역으로 가져 온다.
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOgetCntrMovInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOgetCntrMovInfoRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_DESC(CTM_MOVEMENT XUK1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("       CNTR_NO," ).append("\n"); 
		query.append("       BKG_CGO_TP_CD," ).append("\n"); 
		query.append("       MVMT_STS_CD," ).append("\n"); 
		query.append("       ORG_YD_CD," ).append("\n"); 
		query.append("       RTRIM (DEST_YD_CD) AS DESC_YD_CD," ).append("\n"); 
		query.append("       CNMV_SPLIT_NO," ).append("\n"); 
		query.append("       CNMV_LVL_NO," ).append("\n"); 
		query.append("       TRNK_VSL_CD," ).append("\n"); 
		query.append("       TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("       TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("       OB_CNTR_FLG," ).append("\n"); 
		query.append("       FCNTR_FLG," ).append("\n"); 
		query.append("       CNTR_SEAL_NO," ).append("\n"); 
		query.append("       TO_CHAR (CNMV_EVNT_DT, 'YYYYMMDD') AS CNTR_EVNT_DT," ).append("\n"); 
		query.append("       CNMV_CYC_NO," ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("       BKG_KNT," ).append("\n"); 
		query.append("       TO_DATE (@[evnt_dt], 'YYYYMMDDHH24MI') AS EVNT_DT," ).append("\n"); 
		query.append("       '' AS CM_MSG_ID," ).append("\n"); 
		query.append("       SYS_AREA_GRP_ID AS CNTR_SVR_ID," ).append("\n"); 
		query.append("       CNTR_ACT_CD AS ACIAC_DIV_CD," ).append("\n"); 
		query.append("       MVMT_CRE_TP_CD," ).append("\n"); 
		query.append("       BL_NO," ).append("\n"); 
		query.append("       CNMV_YR," ).append("\n"); 
		query.append("       CNMV_ID_NO," ).append("\n"); 
		query.append("       CNMV_SEQ," ).append("\n"); 
		query.append("       MVMT_INP_TP_CD," ).append("\n"); 
		query.append("       TO_CHAR (CNMV_EVNT_DT, 'YYYYMMDDHH24MI') AS CNMV_EVNT_DT," ).append("\n"); 
		query.append("       DEST_YD_CD," ).append("\n"); 
		query.append("       CRNT_VSL_CD," ).append("\n"); 
		query.append("       CRNT_SKD_VOY_NO," ).append("\n"); 
		query.append("       CRNT_SKD_DIR_CD," ).append("\n"); 
		query.append("       'Z' AS NEW_FLG," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       IMDT_EXT_FLG," ).append("\n"); 
		query.append("	   CNTR_XCH_CD," ).append("\n"); 
		query.append("       CNTR_RFUB_FLG," ).append("\n"); 
		query.append("       CNTR_HNGR_RCK_FLG," ).append("\n"); 
		query.append("       CNTR_DMG_FLG," ).append("\n"); 
		query.append("       CNTR_DISP_FLG," ).append("\n"); 
		query.append("       CNTR_ACT_CD," ).append("\n"); 
		query.append("       PRE_STS_FLG," ).append("\n"); 
		query.append("	   TO_CHAR (DMG_FLG_DT, 'YYYYMMDDHH24MI') AS DMG_FLG_DT," ).append("\n"); 
		query.append("	   TO_CHAR (DMG_UNFLG_DT, 'YYYYMMDDHH24MI') AS DMG_UNFLG_DT," ).append("\n"); 
		query.append("       MTY_PLN_NO," ).append("\n"); 
		query.append("       MTY_REPO_NO" ).append("\n"); 
		query.append("  FROM CTM_MOVEMENT" ).append("\n"); 
		query.append(" WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}