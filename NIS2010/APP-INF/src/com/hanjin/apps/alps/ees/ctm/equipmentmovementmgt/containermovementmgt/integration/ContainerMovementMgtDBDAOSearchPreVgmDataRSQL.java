/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOSearchPreVgmDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.18 
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

public class ContainerMovementMgtDBDAOSearchPreVgmDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 이번 movement에서 VGM 데이터 조회.
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOSearchPreVgmDataRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOSearchPreVgmDataRSQL").append("\n"); 
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
		query.append("SELECT VGM_MZD_TP_CD," ).append("\n"); 
		query.append("  VGM_WGT_UT_CD," ).append("\n"); 
		query.append("  VGM_WGT_QTY," ).append("\n"); 
		query.append("  TO_CHAR(VGM_VRFY_DT, 'YYYYMMDDHH24MI') AS VGM_VRFY_DT," ).append("\n"); 
		query.append("  VGM_SIG_CTNT," ).append("\n"); 
		query.append("  VGM_REF_NO," ).append("\n"); 
		query.append("  VGM_WGT_PTY_CTNT," ).append("\n"); 
		query.append("  VGM_VRFY_ORD_CTNT," ).append("\n"); 
		query.append("  OB_CNTR_FLG" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT CTM" ).append("\n"); 
		query.append("WHERE CTM.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("  AND (CTM.CNMV_YR, CTM.CNMV_ID_NO) = (SELECT /*+ INDEX_DESC(CTM_MOVEMENT XFN1CTM_MOVEMENT) */ CNMV_YR, CNMV_ID_NO" ).append("\n"); 
		query.append("                                       FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("                                       WHERE CNTR_NO = CTM.CNTR_NO" ).append("\n"); 
		query.append("                                         AND ROWNUM = 1" ).append("\n"); 
		query.append("                                      )" ).append("\n"); 

	}
}