/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOSearchMovementStatusEdiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.12
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.05.12 김상수
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

public class ContainerMovementMgtDBDAOSearchMovementStatusEdiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 컨테이너 번호를 입력 받고 해당 컨테이너의 최종 상태 값을 읽어온다.
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOSearchMovementStatusEdiRSQL(){
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
		params.put("ord",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOSearchMovementStatusEdiRSQL").append("\n"); 
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
		query.append("SELECT MVMT_STS_CD," ).append("\n"); 
		query.append("ORG_YD_CD," ).append("\n"); 
		query.append("CM_MSG_ID," ).append("\n"); 
		query.append("BKG_CGO_TP_CD," ).append("\n"); 
		query.append("DEST_YD_CD," ).append("\n"); 
		query.append("CNMV_SEQ," ).append("\n"); 
		query.append("CNMV_SPLIT_NO," ).append("\n"); 
		query.append("CNMV_LVL_NO," ).append("\n"); 
		query.append("CNMV_CYC_NO," ).append("\n"); 
		query.append("TRNK_VSL_CD," ).append("\n"); 
		query.append("TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("OB_CNTR_FLG," ).append("\n"); 
		query.append("FCNTR_FLG," ).append("\n"); 
		query.append("CNTR_SEAL_NO," ).append("\n"); 
		query.append("CNTR_EVNT_DT," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("CNMV_YR," ).append("\n"); 
		query.append("CNMV_ID_NO," ).append("\n"); 
		query.append("'' AS EVNT_DT" ).append("\n"); 
		query.append("FROM (SELECT /*+ INDEX_DESC(CTM_MOVEMENT XUK1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("ROWNUM AS RNUM," ).append("\n"); 
		query.append("MVMT_STS_CD," ).append("\n"); 
		query.append("ORG_YD_CD," ).append("\n"); 
		query.append("NVL (MVMT_EDI_MSG_TP_ID, 'MAN') AS CM_MSG_ID," ).append("\n"); 
		query.append("BKG_CGO_TP_CD," ).append("\n"); 
		query.append("DEST_YD_CD," ).append("\n"); 
		query.append("CNMV_SEQ," ).append("\n"); 
		query.append("CNMV_SPLIT_NO," ).append("\n"); 
		query.append("CNMV_LVL_NO," ).append("\n"); 
		query.append("CNMV_CYC_NO," ).append("\n"); 
		query.append("TRNK_VSL_CD," ).append("\n"); 
		query.append("TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("OB_CNTR_FLG," ).append("\n"); 
		query.append("FCNTR_FLG," ).append("\n"); 
		query.append("CNTR_SEAL_NO," ).append("\n"); 
		query.append("TO_CHAR (CNMV_EVNT_DT, 'YYYYMMDDHH24MI') AS CNTR_EVNT_DT," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("CNMV_YR," ).append("\n"); 
		query.append("CNMV_ID_NO," ).append("\n"); 
		query.append("'' AS EVNT_DT" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND ROWNUM < 3)" ).append("\n"); 
		query.append("WHERE RNUM = @[ord]" ).append("\n"); 

	}
}