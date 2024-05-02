/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QtaAdjustmentDBDAOManageQtaAdjustmentRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
	  * </pre>
	  */
	public QtaAdjustmentDBDAOManageQtaAdjustmentRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration").append("\n"); 
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
		query.append("SELECT   '' AS F_BSE_TP_CD" ).append("\n"); 
		query.append("        ,'' AS F_USR_ID" ).append("\n"); 
		query.append("        ,'' AS F_TRD_CD" ).append("\n"); 
		query.append("        ,'' AS F_QTA_TGT_CD" ).append("\n"); 
		query.append("        ,'' AS F_DIR_CD" ).append("\n"); 
		query.append("        ,'' AS F_BSE_YR" ).append("\n"); 
		query.append("        ,'' AS F_BSE_QTR_CD" ).append("\n"); 
		query.append("        ,'' AS QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("        ,'' AS BSE_TP_CD" ).append("\n"); 
		query.append("        ,'' AS BSE_YR" ).append("\n"); 
		query.append("        ,'' AS BSE_QTR_CD" ).append("\n"); 
		query.append("        ,'' AS QTA_TGT_CD" ).append("\n"); 
		query.append("        ,'' AS TRD_CD" ).append("\n"); 
		query.append("        ,'' AS RLANE_CD" ).append("\n"); 
		query.append("        ,'' AS DIR_CD" ).append("\n"); 
		query.append("        ,'' AS SUB_TRD_CD " ).append("\n"); 
		query.append("        ,'' AS BSE_MON" ).append("\n"); 
		query.append("        ,'' AS BSE_WK" ).append("\n"); 
		query.append("        ,'' AS IOC_CD" ).append("\n"); 
		query.append("        ,'' AS VVD" ).append("\n"); 
		query.append("        ,'' AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("        ,'' AS GRS_REV" ).append("\n"); 
		query.append("        ,'' AS LOD_QTY" ).append("\n"); 
		query.append("        ,'' AS COA_BSE_MON" ).append("\n"); 
		query.append("        ,'' AS COA_BSE_WK" ).append("\n"); 
		query.append("        ,'' AS COA_VVD" ).append("\n"); 
		query.append("        ,'' AS COA_FNL_BSA_CAPA" ).append("\n"); 
		query.append("        ,'' AS COA_LOD_QTY" ).append("\n"); 
		query.append("        ,'' AS COA_GRS_REV" ).append("\n"); 
		query.append("        ,'' AS COPY_VVD" ).append("\n"); 
		query.append("        ,'' AS F_CLICK" ).append("\n"); 
		query.append("        ,'' AS POTN_LNK" ).append("\n"); 
		query.append("        ,'' AS SPL_POTN" ).append("\n"); 
		query.append("        ,'' AS FLAG" ).append("\n"); 
		query.append("        ,'' AS USR_ID" ).append("\n"); 
		query.append("        ,'' AS ISA_RGN_CD" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}