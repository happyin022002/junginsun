/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FillInEquipmentNoDBDAOsearchFillInEquipmentNoExcelPrintRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FillInEquipmentNoDBDAOsearchFillInEquipmentNoExcelPrintRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Fill In Equipment No Excel 자료 조회.
	  * </pre>
	  */
	public FillInEquipmentNoDBDAOsearchFillInEquipmentNoExcelPrintRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration").append("\n"); 
		query.append("FileName : FillInEquipmentNoDBDAOsearchFillInEquipmentNoExcelPrintRSQL").append("\n"); 
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
		query.append("DISTINCT 	BC.CNTR_NO," ).append("\n"); 
		query.append("BC.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("(SELECT CNTR_TPSZ_RMK FROM MDM_CNTR_TP_SZ WHERE CNTR_TPSZ_CD = BC.CNTR_TPSZ_CD) AS EQ_TPSZ_NM," ).append("\n"); 
		query.append("BK.BKG_NO," ).append("\n"); 
		query.append("BK.BKG_STS_CD  BKG_STATUS_CD," ).append("\n"); 
		query.append("(SELECT	INTG_CD_VAL_DP_DESC	FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE	INTG_CD_ID = 'CD00769'" ).append("\n"); 
		query.append("AND	INTG_CD_VAL_CTNT = BK.BKG_STS_CD) BKG_STATUS_NM," ).append("\n"); 
		query.append("BK.BL_NO bl_no" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT  S.TRSP_SO_OFC_CTY_CD, S.TRSP_SO_SEQ," ).append("\n"); 
		query.append("S.TRSP_WO_OFC_CTY_CD, S.TRSP_WO_SEQ," ).append("\n"); 
		query.append("S.TRSP_COST_DTL_MOD_CD,S.BKG_NO, S.EQ_TPSZ_CD" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD S" ).append("\n"); 
		query.append("WHERE S.TRSP_WO_OFC_CTY_CD IS NOT NULL" ).append("\n"); 
		query.append("AND S.TRSP_WO_SEQ IS NOT NULL  ) SO," ).append("\n"); 
		query.append("TRS_TRSP_WRK_ORD WO," ).append("\n"); 
		query.append("BKG_BOOKING BK	," ).append("\n"); 
		query.append("BKG_CONTAINER BC" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND WO.TRSP_WO_OFC_CTY_CD = SO.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND WO.TRSP_WO_SEQ = SO.TRSP_WO_SEQ" ).append("\n"); 
		query.append("AND WO.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND SO.TRSP_COST_DTL_MOD_CD = 'DR'" ).append("\n"); 
		query.append("and bc.cntr_tpsz_cd = so.EQ_TPSZ_CD" ).append("\n"); 
		query.append("AND SO.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("AND BC.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_STS_CD != 'X'" ).append("\n"); 
		query.append("#if ($trsp_so_ofc_cty_cd.size() > 0)" ).append("\n"); 
		query.append("AND (so.trsp_so_ofc_cty_cd,so.trsp_so_seq) in (" ).append("\n"); 
		query.append("#foreach($sonoKey in ${trsp_so_ofc_cty_cd})" ).append("\n"); 
		query.append("#if($velocityCount < $trsp_so_ofc_cty_cd.size())" ).append("\n"); 
		query.append("(substr('$sonoKey',0,3),to_number(substr('$sonoKey',4,length('$sonoKey'))))," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("(substr('$sonoKey',0,3),to_number(substr('$sonoKey',4,length('$sonoKey'))))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY     bc.cntr_no    asc" ).append("\n"); 

	}
}