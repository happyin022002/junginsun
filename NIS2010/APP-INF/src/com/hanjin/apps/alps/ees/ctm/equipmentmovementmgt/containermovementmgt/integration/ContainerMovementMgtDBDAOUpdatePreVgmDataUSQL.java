/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOUpdatePreVgmDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.19 
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

public class ContainerMovementMgtDBDAOUpdatePreVgmDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 이전 movement에 VGM 데이터 업데이트
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOUpdatePreVgmDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_wgt_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_wgt_pty_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vgm_mzd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_sig_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_vrfy_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_vrfy_ord_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOUpdatePreVgmDataUSQL").append("\n"); 
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
		query.append("UPDATE CTM_MOVEMENT" ).append("\n"); 
		query.append("SET VGM_MZD_TP_CD = @[vgm_mzd_tp_cd]," ).append("\n"); 
		query.append("  VGM_WGT_UT_CD = @[vgm_wgt_ut_cd]," ).append("\n"); 
		query.append("  VGM_WGT_QTY = TO_NUMBER(@[vgm_wgt_qty])," ).append("\n"); 
		query.append("  VGM_VRFY_DT = TO_DATE(@[vgm_vrfy_dt], 'YYYYMMDDHH24MI')," ).append("\n"); 
		query.append("  VGM_SIG_CTNT = @[vgm_sig_ctnt]," ).append("\n"); 
		query.append("  VGM_REF_NO = @[vgm_ref_no]," ).append("\n"); 
		query.append("  VGM_WGT_PTY_CTNT = @[vgm_wgt_pty_ctnt]," ).append("\n"); 
		query.append("  VGM_VRFY_ORD_CTNT = @[vgm_vrfy_ord_ctnt]," ).append("\n"); 
		query.append("  MVMT_CRE_TP_CD = 'G'" ).append("\n"); 
		query.append("WHERE (CNTR_NO, CNMV_YR, CNMV_ID_NO) = (SELECT /*+ INDEX_DESC(CTM_MOVEMENT XFN1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("                                          CNTR_NO, CNMV_YR, CNMV_ID_NO" ).append("\n"); 
		query.append("                                        FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("                                        WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                                          AND MVMT_STS_CD <> 'IC'" ).append("\n"); 
		query.append("                                          AND ROWNUM = 1" ).append("\n"); 
		query.append("                                       )" ).append("\n"); 

	}
}