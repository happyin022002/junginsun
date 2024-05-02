/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : QtaAdjustmentDBDAOManageQtaAdjustmentRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.15
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.03.15 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QtaAdjustmentDBDAOManageQtaAdjustmentRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [QTA Adjustment by VVD &  QTA Adjustment by VVD For Sector]  화면에서 사용하는 VO 쿼리
	  * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public QtaAdjustmentDBDAOManageQtaAdjustmentRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOManageQtaAdjustmentRSQL").append("\n"); 
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
		query.append(" SELECT '' QTA_TGT_CD" ).append("\n"); 
		query.append("        ,'' F_QTA_TGT_CD" ).append("\n"); 
		query.append("        ,'' MAS_BSE_WK" ).append("\n"); 
		query.append("        ,'' F_DIR_CD" ).append("\n"); 
		query.append("        ,'' ISA_RGN_CD" ).append("\n"); 
		query.append("        ,'' TRD_CD" ).append("\n"); 
		query.append("        ,'' RLANE_CD" ).append("\n"); 
		query.append("        ,'' MAS_BSE_MON" ).append("\n"); 
		query.append("        ,'' F_BSE_YR" ).append("\n"); 
		query.append("        ,'' FNL_BSA_CAPA" ).append("\n"); 
		query.append("        ,'' BSE_QTR_CD" ).append("\n"); 
		query.append("        ,'' BSE_MON" ).append("\n"); 
		query.append("        ,'' USR_ID" ).append("\n"); 
		query.append("        ,'' POTN_LNK" ).append("\n"); 
		query.append("        ,'' BSE_TP_CD" ).append("\n"); 
		query.append("        ,'' DIR_CD" ).append("\n"); 
		query.append("        ,'' F_BSE_QTR_CD" ).append("\n"); 
		query.append("        ,'' SPL_POTN" ).append("\n"); 
		query.append("        ,'' QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("        ,'' IOC_CD" ).append("\n"); 
		query.append("        ,'' LOD_QTY" ).append("\n"); 
		query.append("        ,'' F_CLICK" ).append("\n"); 
		query.append("        ,'' MAS_LOD_QTY" ).append("\n"); 
		query.append("        ,'' MAS_SLS_YRMON" ).append("\n"); 
		query.append("        ,'' MAS_COST_YRMON" ).append("\n"); 
		query.append("        ,'' BSE_YR" ).append("\n"); 
		query.append("        ,'' BSE_WK" ).append("\n"); 
		query.append("        ,'' F_BSE_TP_CD" ).append("\n"); 
		query.append("        ,'' MAS_VVD" ).append("\n"); 
		query.append("        ,'' MAS_FNL_BSA_CAPA" ).append("\n"); 
		query.append("        ,'' F_USR_ID" ).append("\n"); 
		query.append("        ,'' VVD" ).append("\n"); 
		query.append("        ,'' F_TRD_CD" ).append("\n"); 
		query.append("        ,'' FLAG" ).append("\n"); 
		query.append("        ,'' GRS_REV" ).append("\n"); 
		query.append("        ,'' MAS_GRS_REV" ).append("\n"); 
		query.append("        ,'' COPY_VVD" ).append("\n"); 
		query.append("        ,'' SUB_TRD_CD" ).append("\n"); 
		query.append("        ,'' ADJ_VVD" ).append("\n"); 
		query.append("        ,'' AS PF_GRP_CD" ).append("\n"); 
		query.append("        ,'' AS MAS_PF_GRP_CD" ).append("\n"); 
		query.append("        ,'' PF_GRP_TP" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 

	}
}