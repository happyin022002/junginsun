/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileEsvReeferRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewEdiDBDAOsearchFlatFileEsvReeferRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchFlatFileEsvReefer
	  * </pre>
	  */
	public WorkOrderPreviewEdiDBDAOsearchFlatFileEsvReeferRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileEsvReeferRSQL").append("\n"); 
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
		query.append("SELECT T1.* " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  SELECT NVL(B.FDO_TEMP, B.CDO_TEMP) AS TEMP" ).append("\n"); 
		query.append("        ,DECODE(B.FDO_TEMP, NULL, DECODE(B.CDO_TEMP, NULL, '', 'C'), 'F') AS TEMP_UNIT" ).append("\n"); 
		query.append("        ,CASE WHEN (NVL(B.VENT_RTO, 0) > 0 OR NVL(B.CBM_PER_HR_QTY, 0) > 0) THEN 'Open'" ).append("\n"); 
		query.append("             ELSE 'Closed'" ).append("\n"); 
		query.append("         END VENT" ).append("\n"); 
		query.append("        ,DECODE(B.CNTR_VENT_TP_CD, 'P', B.VENT_RTO, 'C', B.CBM_PER_HR_QTY) AS VENT_NO" ).append("\n"); 
		query.append("        ,DECODE(B.CNTR_VENT_TP_CD, 'P', '', 'C', 'CubicMeterPerHour') AS VENT_UNIT" ).append("\n"); 
		query.append("        ,B.HUMID_NO AS HUMIDITY" ).append("\n"); 
		query.append("        ,DECODE(B.CNTR_DRN_CD, 'O', 'Open', 'Closed') AS DRAIN_HOLE" ).append("\n"); 
		query.append("        ,B.PWR_SPL_CBL_FLG AS GENSET" ).append("\n"); 
		query.append("        ,REPLACE(REPLACE(B.DIFF_RMK, CHR(13), ''), CHR(10), '') as REMARK" ).append("\n"); 
		query.append("    FROM BKG_RF_CGO       B" ).append("\n"); 
		query.append("        ,BKG_EUR_TRO      TRO" ).append("\n"); 
		query.append("        ,TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("   WHERE 1 = 1" ).append("\n"); 
		query.append("     AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     AND NVL2(@[cntr_no], B.CNTR_NO, 'XX') = NVL(@[cntr_no], 'XX')" ).append("\n"); 
		query.append("     AND NVL2(@[cntr_tpsz], B.CNTR_TPSZ_CD, 'XX') = NVL(@[cntr_tpsz], 'XX')" ).append("\n"); 
		query.append("     AND B.BKG_NO = TRO.BKG_NO" ).append("\n"); 
		query.append("     AND B.RC_SEQ = TRO.RC_SEQ" ).append("\n"); 
		query.append("     AND TRO.BKG_NO = SO.BKG_NO" ).append("\n"); 
		query.append("     AND TRO.IO_BND_CD = SO.TRSP_BND_CD" ).append("\n"); 
		query.append("     AND TRO.TRO_SEQ = SO.TRO_SEQ" ).append("\n"); 
		query.append("     AND TRO.RQST_SUB_SEQ = SO.TRO_SUB_SEQ" ).append("\n"); 
		query.append("     AND SUBSTR(SO.COST_ACT_GRP_CD, 1, 2) = 'OD'" ).append("\n"); 
		query.append("     AND SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("     AND SO.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("  UNION" ).append("\n"); 
		query.append("  SELECT NVL(B.FDO_TEMP, B.CDO_TEMP) AS TEMP" ).append("\n"); 
		query.append("        ,DECODE(B.FDO_TEMP, NULL, DECODE(B.CDO_TEMP, NULL, '', 'C'), 'F') AS TEMP_UNIT" ).append("\n"); 
		query.append("        ,CASE  WHEN (NVL(B.VENT_RTO, 0) > 0 OR NVL(B.CBM_PER_HR_QTY, 0) > 0) THEN 'Open'" ).append("\n"); 
		query.append("             ELSE 'Closed'" ).append("\n"); 
		query.append("         END VENT" ).append("\n"); 
		query.append("        ,DECODE(B.CNTR_VENT_TP_CD, 'P', B.VENT_RTO, 'C', B.CBM_PER_HR_QTY) AS VENT_NO" ).append("\n"); 
		query.append("        ,DECODE(B.CNTR_VENT_TP_CD, 'P', '', 'C', 'CubicMeterPerHour') AS VENT_UNIT" ).append("\n"); 
		query.append("        ,B.HUMID_NO AS HUMIDITY" ).append("\n"); 
		query.append("        ,DECODE(B.CNTR_DRN_CD, 'O', 'Open', 'Closed') AS DRAIN_HOLE" ).append("\n"); 
		query.append("        ,B.PWR_SPL_CBL_FLG AS GENSET" ).append("\n"); 
		query.append("        ,REPLACE(REPLACE(B.DIFF_RMK, CHR(13), ''), CHR(10), '') as REMARK" ).append("\n"); 
		query.append("    FROM BKG_RF_CGO       B" ).append("\n"); 
		query.append("        ,TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("   WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     AND NVL2(@[cntr_no], B.CNTR_NO, 'XX') = NVL(@[cntr_no], 'XX')" ).append("\n"); 
		query.append("     AND NVL2(@[cntr_tpsz], B.CNTR_TPSZ_CD, 'XX') = NVL(@[cntr_tpsz], 'XX')" ).append("\n"); 
		query.append("     AND B.BKG_NO = SO.BKG_NO" ).append("\n"); 
		query.append("     AND SUBSTR(SO.COST_ACT_GRP_CD, 1, 2) <> 'OD'" ).append("\n"); 
		query.append("     AND SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("     AND SO.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append(") T1 RIGHT OUTER JOIN DUAL" ).append("\n"); 
		query.append("  ON 1 = 1" ).append("\n"); 

	}
}