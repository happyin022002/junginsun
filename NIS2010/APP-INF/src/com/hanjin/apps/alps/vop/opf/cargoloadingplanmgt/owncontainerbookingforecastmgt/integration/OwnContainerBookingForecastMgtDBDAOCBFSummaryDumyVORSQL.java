/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFSummaryDumyVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2010.02.18 김현욱
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Hyun Uk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOCBFSummaryDumyVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CBFSummaryVO 생성을 위한 더미쿼리
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFSummaryDumyVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFSummaryDumyVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' AS VSL_CD" ).append("\n"); 
		query.append(", '' AS SKD_VOY_NO" ).append("\n"); 
		query.append(", '' AS SKD_DIR_CD" ).append("\n"); 
		query.append(", '' AS OPR_CD" ).append("\n"); 
		query.append(", '' AS POD" ).append("\n"); 
		query.append(", '' AS MLB" ).append("\n"); 
		query.append(", '' AS WG" ).append("\n"); 
		query.append(", '' AS FM" ).append("\n"); 
		query.append(", '' AS YD_CD" ).append("\n"); 
		query.append(", '' AS YD_NM" ).append("\n"); 
		query.append(", '' AS UNIT2" ).append("\n"); 
		query.append(", '' AS UNIT4" ).append("\n"); 
		query.append(", '' AS LOC_NM" ).append("\n"); 
		query.append(", '' AS CRR_CD" ).append("\n"); 
		query.append(", '' AS CRR_CD2" ).append("\n"); 
		query.append(", '' AS POD_CD" ).append("\n"); 
		query.append(", '' AS MLB_CD" ).append("\n"); 
		query.append(", '' AS DCGO_FLG" ).append("\n"); 
		query.append(", '' AS RC_FLG" ).append("\n"); 
		query.append(", '' AS AWK_CGO_FLG" ).append("\n"); 
		query.append(", '' AS BB_CGO_FLG" ).append("\n"); 
		query.append(", '' AS STWG_CGO_FLG" ).append("\n"); 
		query.append(", '' AS PC_CGO_FLG" ).append("\n"); 
		query.append(", '' AS STWG_CD" ).append("\n"); 
		query.append(", '' AS STWG_NM" ).append("\n"); 
		query.append(", '' AS BKG_SHPR_OWNR_FLG" ).append("\n"); 
		query.append(", '' AS CBF_IND_FLG" ).append("\n"); 
		query.append(", '' AS CRE_USR_ID" ).append("\n"); 
		query.append(", '' AS CRE_DT" ).append("\n"); 
		query.append(", '' AS UPD_USR_ID" ).append("\n"); 
		query.append(", '' AS UPD_DT" ).append("\n"); 
		query.append(", '' AS SORT" ).append("\n"); 
		query.append(", '' AS TOT_QTY_2" ).append("\n"); 
		query.append(", '' AS TOT_QTY_2H" ).append("\n"); 
		query.append(", '' AS TOT_QTY_4" ).append("\n"); 
		query.append(", '' AS TOT_QTY_4H" ).append("\n"); 
		query.append(", '' AS TOT_QTY_45" ).append("\n"); 
		query.append(", '' AS TOT_TTL" ).append("\n"); 
		query.append(", '' AS TOT_TEU" ).append("\n"); 
		query.append(", '' AS TOT_WGT_2" ).append("\n"); 
		query.append(", '' AS TOT_WGT_2H" ).append("\n"); 
		query.append(", '' AS TOT_WGT_4" ).append("\n"); 
		query.append(", '' AS TOT_WGT_4H" ).append("\n"); 
		query.append(", '' AS TOT_WGT_45" ).append("\n"); 
		query.append(", '' AS OPR1" ).append("\n"); 
		query.append(", '' AS OPR2" ).append("\n"); 
		query.append(", '' AS OPR3" ).append("\n"); 
		query.append(", '' AS OPR4" ).append("\n"); 
		query.append(", '' AS OPR5" ).append("\n"); 
		query.append(", '' AS OPR6" ).append("\n"); 
		query.append(", '' AS OPR7" ).append("\n"); 
		query.append(", '' AS OPR8" ).append("\n"); 
		query.append(", '' AS OPR9" ).append("\n"); 
		query.append(", '' AS OPR10" ).append("\n"); 
		query.append(", '' AS QTY1" ).append("\n"); 
		query.append(", '' AS QTY2" ).append("\n"); 
		query.append(", '' AS QTY3" ).append("\n"); 
		query.append(", '' AS QTY4" ).append("\n"); 
		query.append(", '' AS QTY5" ).append("\n"); 
		query.append(", '' AS QTY6" ).append("\n"); 
		query.append(", '' AS QTY7" ).append("\n"); 
		query.append(", '' AS QTY8" ).append("\n"); 
		query.append(", '' AS QTY9" ).append("\n"); 
		query.append(", '' AS QTY10" ).append("\n"); 
		query.append(", '' AS AV_WGT_2" ).append("\n"); 
		query.append(", '' AS AV_WGT_4" ).append("\n"); 
		query.append(", '' AS OPR1_QTY_2" ).append("\n"); 
		query.append(", '' AS OPR1_QTY_2H" ).append("\n"); 
		query.append(", '' AS OPR1_QTY_4" ).append("\n"); 
		query.append(", '' AS OPR1_QTY_4H" ).append("\n"); 
		query.append(", '' AS OPR1_QTY_45" ).append("\n"); 
		query.append(", '' AS OPR1_TEU" ).append("\n"); 
		query.append(", '' AS OPR1_WGT_2" ).append("\n"); 
		query.append(", '' AS OPR1_WGT_2H" ).append("\n"); 
		query.append(", '' AS OPR1_WGT_4" ).append("\n"); 
		query.append(", '' AS OPR1_WGT_4H" ).append("\n"); 
		query.append(", '' AS OPR1_WGT_45" ).append("\n"); 
		query.append(", '' AS OPR2_QTY_2" ).append("\n"); 
		query.append(", '' AS OPR2_QTY_2H" ).append("\n"); 
		query.append(", '' AS OPR2_QTY_4" ).append("\n"); 
		query.append(", '' AS OPR2_QTY_4H" ).append("\n"); 
		query.append(", '' AS OPR2_QTY_45" ).append("\n"); 
		query.append(", '' AS OPR2_TEU" ).append("\n"); 
		query.append(", '' AS OPR2_WGT_2" ).append("\n"); 
		query.append(", '' AS OPR2_WGT_2H" ).append("\n"); 
		query.append(", '' AS OPR2_WGT_4" ).append("\n"); 
		query.append(", '' AS OPR2_WGT_4H" ).append("\n"); 
		query.append(", '' AS OPR2_WGT_45" ).append("\n"); 
		query.append(", '' AS OPR3_QTY_2" ).append("\n"); 
		query.append(", '' AS OPR3_QTY_2H" ).append("\n"); 
		query.append(", '' AS OPR3_QTY_4" ).append("\n"); 
		query.append(", '' AS OPR3_QTY_4H" ).append("\n"); 
		query.append(", '' AS OPR3_QTY_45" ).append("\n"); 
		query.append(", '' AS OPR3_TEU" ).append("\n"); 
		query.append(", '' AS OPR3_WGT_2" ).append("\n"); 
		query.append(", '' AS OPR3_WGT_2H" ).append("\n"); 
		query.append(", '' AS OPR3_WGT_4" ).append("\n"); 
		query.append(", '' AS OPR3_WGT_4H" ).append("\n"); 
		query.append(", '' AS OPR3_WGT_45" ).append("\n"); 
		query.append(", '' AS OPR4_QTY_2" ).append("\n"); 
		query.append(", '' AS OPR4_QTY_2H" ).append("\n"); 
		query.append(", '' AS OPR4_QTY_4" ).append("\n"); 
		query.append(", '' AS OPR4_QTY_4H" ).append("\n"); 
		query.append(", '' AS OPR4_QTY_45" ).append("\n"); 
		query.append(", '' AS OPR4_TEU" ).append("\n"); 
		query.append(", '' AS OPR4_WGT_2" ).append("\n"); 
		query.append(", '' AS OPR4_WGT_2H" ).append("\n"); 
		query.append(", '' AS OPR4_WGT_4" ).append("\n"); 
		query.append(", '' AS OPR4_WGT_4H" ).append("\n"); 
		query.append(", '' AS OPR4_WGT_45" ).append("\n"); 
		query.append(", '' AS OPR5_QTY_2" ).append("\n"); 
		query.append(", '' AS OPR5_QTY_2H" ).append("\n"); 
		query.append(", '' AS OPR5_QTY_4" ).append("\n"); 
		query.append(", '' AS OPR5_QTY_4H" ).append("\n"); 
		query.append(", '' AS OPR5_QTY_45" ).append("\n"); 
		query.append(", '' AS OPR5_TEU" ).append("\n"); 
		query.append(", '' AS OPR5_WGT_2" ).append("\n"); 
		query.append(", '' AS OPR5_WGT_2H" ).append("\n"); 
		query.append(", '' AS OPR5_WGT_4" ).append("\n"); 
		query.append(", '' AS OPR5_WGT_4H" ).append("\n"); 
		query.append(", '' AS OPR5_WGT_45" ).append("\n"); 
		query.append(", '' AS OPR6_QTY_2" ).append("\n"); 
		query.append(", '' AS OPR6_QTY_2H" ).append("\n"); 
		query.append(", '' AS OPR6_QTY_4" ).append("\n"); 
		query.append(", '' AS OPR6_QTY_4H" ).append("\n"); 
		query.append(", '' AS OPR6_QTY_45" ).append("\n"); 
		query.append(", '' AS OPR6_TEU" ).append("\n"); 
		query.append(", '' AS OPR6_WGT_2" ).append("\n"); 
		query.append(", '' AS OPR6_WGT_2H" ).append("\n"); 
		query.append(", '' AS OPR6_WGT_4" ).append("\n"); 
		query.append(", '' AS OPR6_WGT_4H" ).append("\n"); 
		query.append(", '' AS OPR6_WGT_45" ).append("\n"); 
		query.append(", '' AS OPR7_QTY_2" ).append("\n"); 
		query.append(", '' AS OPR7_QTY_2H" ).append("\n"); 
		query.append(", '' AS OPR7_QTY_4" ).append("\n"); 
		query.append(", '' AS OPR7_QTY_4H" ).append("\n"); 
		query.append(", '' AS OPR7_QTY_45" ).append("\n"); 
		query.append(", '' AS OPR7_TEU" ).append("\n"); 
		query.append(", '' AS OPR7_WGT_2" ).append("\n"); 
		query.append(", '' AS OPR7_WGT_2H" ).append("\n"); 
		query.append(", '' AS OPR7_WGT_4" ).append("\n"); 
		query.append(", '' AS OPR7_WGT_4H" ).append("\n"); 
		query.append(", '' AS OPR7_WGT_45" ).append("\n"); 
		query.append(", '' AS OPR8_QTY_2" ).append("\n"); 
		query.append(", '' AS OPR8_QTY_2H" ).append("\n"); 
		query.append(", '' AS OPR8_QTY_4" ).append("\n"); 
		query.append(", '' AS OPR8_QTY_4H" ).append("\n"); 
		query.append(", '' AS OPR8_QTY_45" ).append("\n"); 
		query.append(", '' AS OPR8_TEU" ).append("\n"); 
		query.append(", '' AS OPR8_WGT_2" ).append("\n"); 
		query.append(", '' AS OPR8_WGT_2H" ).append("\n"); 
		query.append(", '' AS OPR8_WGT_4" ).append("\n"); 
		query.append(", '' AS OPR8_WGT_4H" ).append("\n"); 
		query.append(", '' AS OPR8_WGT_45" ).append("\n"); 
		query.append(", '' AS OPR9_QTY_2" ).append("\n"); 
		query.append(", '' AS OPR9_QTY_2H" ).append("\n"); 
		query.append(", '' AS OPR9_QTY_4" ).append("\n"); 
		query.append(", '' AS OPR9_QTY_4H" ).append("\n"); 
		query.append(", '' AS OPR9_QTY_45" ).append("\n"); 
		query.append(", '' AS OPR9_TEU" ).append("\n"); 
		query.append(", '' AS OPR9_WGT_2" ).append("\n"); 
		query.append(", '' AS OPR9_WGT_2H" ).append("\n"); 
		query.append(", '' AS OPR9_WGT_4" ).append("\n"); 
		query.append(", '' AS OPR9_WGT_4H" ).append("\n"); 
		query.append(", '' AS OPR9_WGT_45" ).append("\n"); 
		query.append(", '' AS OPR10_QTY_2" ).append("\n"); 
		query.append(", '' AS OPR10_QTY_2H" ).append("\n"); 
		query.append(", '' AS OPR10_QTY_4" ).append("\n"); 
		query.append(", '' AS OPR10_QTY_4H" ).append("\n"); 
		query.append(", '' AS OPR10_QTY_45" ).append("\n"); 
		query.append(", '' AS OPR10_TEU" ).append("\n"); 
		query.append(", '' AS OPR10_WGT_2" ).append("\n"); 
		query.append(", '' AS OPR10_WGT_2H" ).append("\n"); 
		query.append(", '' AS OPR10_WGT_4" ).append("\n"); 
		query.append(", '' AS OPR10_WGT_4H" ).append("\n"); 
		query.append(", '' AS OPR10_WGT_45" ).append("\n"); 
		query.append(", '' AS DG_20_TOT" ).append("\n"); 
		query.append(", '' AS DG_2H_TOT" ).append("\n"); 
		query.append(", '' AS DG_40_TOT" ).append("\n"); 
		query.append(", '' AS DG_4H_TOT" ).append("\n"); 
		query.append(", '' AS DG_45_TOT" ).append("\n"); 
		query.append(", '' AS RF_20_TOT" ).append("\n"); 
		query.append(", '' AS RF_2H_TOT" ).append("\n"); 
		query.append(", '' AS RF_40_TOT" ).append("\n"); 
		query.append(", '' AS RF_4H_TOT" ).append("\n"); 
		query.append(", '' AS RF_45_TOT" ).append("\n"); 
		query.append(", '' AS AK_20_TOT" ).append("\n"); 
		query.append(", '' AS AK_40_TOT" ).append("\n"); 
		query.append(", '' AS AK_4H_TOT" ).append("\n"); 
		query.append(", '' AS AK_45_TOT" ).append("\n"); 
		query.append(", '' AS BB_20_TOT" ).append("\n"); 
		query.append(", '' AS BB_40_TOT" ).append("\n"); 
		query.append(", '' AS DG_20_OPR1" ).append("\n"); 
		query.append(", '' AS DG_2H_OPR1" ).append("\n"); 
		query.append(", '' AS DG_40_OPR1" ).append("\n"); 
		query.append(", '' AS DG_4H_OPR1" ).append("\n"); 
		query.append(", '' AS DG_45_OPR1" ).append("\n"); 
		query.append(", '' AS RF_20_OPR1" ).append("\n"); 
		query.append(", '' AS RF_2H_OPR1" ).append("\n"); 
		query.append(", '' AS RF_40_OPR1" ).append("\n"); 
		query.append(", '' AS RF_4H_OPR1" ).append("\n"); 
		query.append(", '' AS RF_45_OPR1" ).append("\n"); 
		query.append(", '' AS AK_20_OPR1" ).append("\n"); 
		query.append(", '' AS AK_2H_OPR1" ).append("\n"); 
		query.append(", '' AS AK_40_OPR1" ).append("\n"); 
		query.append(", '' AS AK_4H_OPR1" ).append("\n"); 
		query.append(", '' AS AK_45_OPR1" ).append("\n"); 
		query.append(", '' AS BB_20_OPR1" ).append("\n"); 
		query.append(", '' AS BB_2H_OPR1" ).append("\n"); 
		query.append(", '' AS BB_40_OPR1" ).append("\n"); 
		query.append(", '' AS BB_4H_OPR1" ).append("\n"); 
		query.append(", '' AS BB_45_OPR1" ).append("\n"); 
		query.append(", '' AS DG_20_OPR2" ).append("\n"); 
		query.append(", '' AS DG_2H_OPR2" ).append("\n"); 
		query.append(", '' AS DG_40_OPR2" ).append("\n"); 
		query.append(", '' AS DG_4H_OPR2" ).append("\n"); 
		query.append(", '' AS DG_45_OPR2" ).append("\n"); 
		query.append(", '' AS RF_20_OPR2" ).append("\n"); 
		query.append(", '' AS RF_2H_OPR2" ).append("\n"); 
		query.append(", '' AS RF_40_OPR2" ).append("\n"); 
		query.append(", '' AS RF_4H_OPR2" ).append("\n"); 
		query.append(", '' AS RF_45_OPR2" ).append("\n"); 
		query.append(", '' AS AK_20_OPR2" ).append("\n"); 
		query.append(", '' AS AK_2H_OPR2" ).append("\n"); 
		query.append(", '' AS AK_40_OPR2" ).append("\n"); 
		query.append(", '' AS AK_4H_OPR2" ).append("\n"); 
		query.append(", '' AS AK_45_OPR2" ).append("\n"); 
		query.append(", '' AS BB_20_OPR2" ).append("\n"); 
		query.append(", '' AS BB_2H_OPR2" ).append("\n"); 
		query.append(", '' AS BB_40_OPR2" ).append("\n"); 
		query.append(", '' AS BB_4H_OPR2" ).append("\n"); 
		query.append(", '' AS BB_45_OPR2" ).append("\n"); 
		query.append(", '' AS DG_20_OPR3" ).append("\n"); 
		query.append(", '' AS DG_2H_OPR3" ).append("\n"); 
		query.append(", '' AS DG_40_OPR3" ).append("\n"); 
		query.append(", '' AS DG_4H_OPR3" ).append("\n"); 
		query.append(", '' AS DG_45_OPR3" ).append("\n"); 
		query.append(", '' AS RF_20_OPR3" ).append("\n"); 
		query.append(", '' AS RF_2H_OPR3" ).append("\n"); 
		query.append(", '' AS RF_40_OPR3" ).append("\n"); 
		query.append(", '' AS RF_4H_OPR3" ).append("\n"); 
		query.append(", '' AS RF_45_OPR3" ).append("\n"); 
		query.append(", '' AS AK_20_OPR3" ).append("\n"); 
		query.append(", '' AS AK_2H_OPR3" ).append("\n"); 
		query.append(", '' AS AK_40_OPR3" ).append("\n"); 
		query.append(", '' AS AK_4H_OPR3" ).append("\n"); 
		query.append(", '' AS AK_45_OPR3" ).append("\n"); 
		query.append(", '' AS BB_20_OPR3" ).append("\n"); 
		query.append(", '' AS BB_2H_OPR3" ).append("\n"); 
		query.append(", '' AS BB_40_OPR3" ).append("\n"); 
		query.append(", '' AS BB_4H_OPR3" ).append("\n"); 
		query.append(", '' AS BB_45_OPR3" ).append("\n"); 
		query.append(", '' AS DG_20_OPR4" ).append("\n"); 
		query.append(", '' AS DG_2H_OPR4" ).append("\n"); 
		query.append(", '' AS DG_40_OPR4" ).append("\n"); 
		query.append(", '' AS DG_4H_OPR4" ).append("\n"); 
		query.append(", '' AS DG_45_OPR4" ).append("\n"); 
		query.append(", '' AS RF_20_OPR4" ).append("\n"); 
		query.append(", '' AS RF_2H_OPR4" ).append("\n"); 
		query.append(", '' AS RF_40_OPR4" ).append("\n"); 
		query.append(", '' AS RF_4H_OPR4" ).append("\n"); 
		query.append(", '' AS RF_45_OPR4" ).append("\n"); 
		query.append(", '' AS AK_20_OPR4" ).append("\n"); 
		query.append(", '' AS AK_2H_OPR4" ).append("\n"); 
		query.append(", '' AS AK_40_OPR4" ).append("\n"); 
		query.append(", '' AS AK_4H_OPR4" ).append("\n"); 
		query.append(", '' AS AK_45_OPR4" ).append("\n"); 
		query.append(", '' AS BB_20_OPR4" ).append("\n"); 
		query.append(", '' AS BB_2H_OPR4" ).append("\n"); 
		query.append(", '' AS BB_40_OPR4" ).append("\n"); 
		query.append(", '' AS BB_4H_OPR4" ).append("\n"); 
		query.append(", '' AS BB_45_OPR4" ).append("\n"); 
		query.append(", '' AS DG_20_OPR5" ).append("\n"); 
		query.append(", '' AS DG_2H_OPR5" ).append("\n"); 
		query.append(", '' AS DG_40_OPR5" ).append("\n"); 
		query.append(", '' AS DG_4H_OPR5" ).append("\n"); 
		query.append(", '' AS DG_45_OPR5" ).append("\n"); 
		query.append(", '' AS RF_20_OPR5" ).append("\n"); 
		query.append(", '' AS RF_2H_OPR5" ).append("\n"); 
		query.append(", '' AS RF_40_OPR5" ).append("\n"); 
		query.append(", '' AS RF_4H_OPR5" ).append("\n"); 
		query.append(", '' AS RF_45_OPR5" ).append("\n"); 
		query.append(", '' AS AK_20_OPR5" ).append("\n"); 
		query.append(", '' AS AK_2H_OPR5" ).append("\n"); 
		query.append(", '' AS AK_40_OPR5" ).append("\n"); 
		query.append(", '' AS AK_4H_OPR5" ).append("\n"); 
		query.append(", '' AS AK_45_OPR5" ).append("\n"); 
		query.append(", '' AS BB_20_OPR5" ).append("\n"); 
		query.append(", '' AS BB_2H_OPR5" ).append("\n"); 
		query.append(", '' AS BB_40_OPR5" ).append("\n"); 
		query.append(", '' AS BB_4H_OPR5" ).append("\n"); 
		query.append(", '' AS BB_45_OPR5" ).append("\n"); 
		query.append(", '' AS DG_20_OPR6" ).append("\n"); 
		query.append(", '' AS DG_2H_OPR6" ).append("\n"); 
		query.append(", '' AS DG_40_OPR6" ).append("\n"); 
		query.append(", '' AS DG_4H_OPR6" ).append("\n"); 
		query.append(", '' AS DG_45_OPR6" ).append("\n"); 
		query.append(", '' AS RF_20_OPR6" ).append("\n"); 
		query.append(", '' AS RF_2H_OPR6" ).append("\n"); 
		query.append(", '' AS RF_40_OPR6" ).append("\n"); 
		query.append(", '' AS RF_4H_OPR6" ).append("\n"); 
		query.append(", '' AS RF_45_OPR6" ).append("\n"); 
		query.append(", '' AS AK_20_OPR6" ).append("\n"); 
		query.append(", '' AS AK_2H_OPR6" ).append("\n"); 
		query.append(", '' AS AK_40_OPR6" ).append("\n"); 
		query.append(", '' AS AK_4H_OPR6" ).append("\n"); 
		query.append(", '' AS AK_45_OPR6" ).append("\n"); 
		query.append(", '' AS BB_20_OPR6" ).append("\n"); 
		query.append(", '' AS BB_2H_OPR6" ).append("\n"); 
		query.append(", '' AS BB_40_OPR6" ).append("\n"); 
		query.append(", '' AS BB_4H_OPR6" ).append("\n"); 
		query.append(", '' AS BB_45_OPR6" ).append("\n"); 
		query.append(", '' AS DG_20_OPR7" ).append("\n"); 
		query.append(", '' AS DG_2H_OPR7" ).append("\n"); 
		query.append(", '' AS DG_40_OPR7" ).append("\n"); 
		query.append(", '' AS DG_4H_OPR7" ).append("\n"); 
		query.append(", '' AS DG_45_OPR7" ).append("\n"); 
		query.append(", '' AS RF_20_OPR7" ).append("\n"); 
		query.append(", '' AS RF_2H_OPR7" ).append("\n"); 
		query.append(", '' AS RF_40_OPR7" ).append("\n"); 
		query.append(", '' AS RF_4H_OPR7" ).append("\n"); 
		query.append(", '' AS RF_45_OPR7" ).append("\n"); 
		query.append(", '' AS AK_20_OPR7" ).append("\n"); 
		query.append(", '' AS AK_2H_OPR7" ).append("\n"); 
		query.append(", '' AS AK_40_OPR7" ).append("\n"); 
		query.append(", '' AS AK_4H_OPR7" ).append("\n"); 
		query.append(", '' AS AK_45_OPR7" ).append("\n"); 
		query.append(", '' AS BB_20_OPR7" ).append("\n"); 
		query.append(", '' AS BB_2H_OPR7" ).append("\n"); 
		query.append(", '' AS BB_40_OPR7" ).append("\n"); 
		query.append(", '' AS BB_4H_OPR7" ).append("\n"); 
		query.append(", '' AS BB_45_OPR7" ).append("\n"); 
		query.append(", '' AS DG_20_OPR8" ).append("\n"); 
		query.append(", '' AS DG_2H_OPR8" ).append("\n"); 
		query.append(", '' AS DG_40_OPR8" ).append("\n"); 
		query.append(", '' AS DG_4H_OPR8" ).append("\n"); 
		query.append(", '' AS DG_45_OPR8" ).append("\n"); 
		query.append(", '' AS RF_20_OPR8" ).append("\n"); 
		query.append(", '' AS RF_2H_OPR8" ).append("\n"); 
		query.append(", '' AS RF_40_OPR8" ).append("\n"); 
		query.append(", '' AS RF_4H_OPR8" ).append("\n"); 
		query.append(", '' AS RF_45_OPR8" ).append("\n"); 
		query.append(", '' AS AK_20_OPR8" ).append("\n"); 
		query.append(", '' AS AK_2H_OPR8" ).append("\n"); 
		query.append(", '' AS AK_40_OPR8" ).append("\n"); 
		query.append(", '' AS AK_4H_OPR8" ).append("\n"); 
		query.append(", '' AS AK_45_OPR8" ).append("\n"); 
		query.append(", '' AS BB_20_OPR8" ).append("\n"); 
		query.append(", '' AS BB_2H_OPR8" ).append("\n"); 
		query.append(", '' AS BB_40_OPR8" ).append("\n"); 
		query.append(", '' AS BB_4H_OPR8" ).append("\n"); 
		query.append(", '' AS BB_45_OPR8" ).append("\n"); 
		query.append(", '' AS DG_20_OPR9" ).append("\n"); 
		query.append(", '' AS DG_2H_OPR9" ).append("\n"); 
		query.append(", '' AS DG_40_OPR9" ).append("\n"); 
		query.append(", '' AS DG_4H_OPR9" ).append("\n"); 
		query.append(", '' AS DG_45_OPR9" ).append("\n"); 
		query.append(", '' AS RF_20_OPR9" ).append("\n"); 
		query.append(", '' AS RF_2H_OPR9" ).append("\n"); 
		query.append(", '' AS RF_40_OPR9" ).append("\n"); 
		query.append(", '' AS RF_4H_OPR9" ).append("\n"); 
		query.append(", '' AS RF_45_OPR9" ).append("\n"); 
		query.append(", '' AS AK_20_OPR9" ).append("\n"); 
		query.append(", '' AS AK_2H_OPR9" ).append("\n"); 
		query.append(", '' AS AK_40_OPR9" ).append("\n"); 
		query.append(", '' AS AK_4H_OPR9" ).append("\n"); 
		query.append(", '' AS AK_45_OPR9" ).append("\n"); 
		query.append(", '' AS BB_20_OPR9" ).append("\n"); 
		query.append(", '' AS BB_2H_OPR9" ).append("\n"); 
		query.append(", '' AS BB_40_OPR9" ).append("\n"); 
		query.append(", '' AS BB_4H_OPR9" ).append("\n"); 
		query.append(", '' AS BB_45_OPR9" ).append("\n"); 
		query.append(", '' AS DG_20_OPR10" ).append("\n"); 
		query.append(", '' AS DG_2H_OPR10" ).append("\n"); 
		query.append(", '' AS DG_40_OPR10" ).append("\n"); 
		query.append(", '' AS DG_4H_OPR10" ).append("\n"); 
		query.append(", '' AS DG_45_OPR10" ).append("\n"); 
		query.append(", '' AS RF_20_OPR10" ).append("\n"); 
		query.append(", '' AS RF_2H_OPR10" ).append("\n"); 
		query.append(", '' AS RF_40_OPR10" ).append("\n"); 
		query.append(", '' AS RF_4H_OPR10" ).append("\n"); 
		query.append(", '' AS RF_45_OPR10" ).append("\n"); 
		query.append(", '' AS AK_20_OPR10" ).append("\n"); 
		query.append(", '' AS AK_2H_OPR10" ).append("\n"); 
		query.append(", '' AS AK_40_OPR10" ).append("\n"); 
		query.append(", '' AS AK_4H_OPR10" ).append("\n"); 
		query.append(", '' AS AK_45_OPR10" ).append("\n"); 
		query.append(", '' AS BB_20_OPR10" ).append("\n"); 
		query.append(", '' AS BB_2H_OPR10" ).append("\n"); 
		query.append(", '' AS BB_40_OPR10" ).append("\n"); 
		query.append(", '' AS BB_4H_OPR10" ).append("\n"); 
		query.append(", '' AS BB_45_OPR10" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}