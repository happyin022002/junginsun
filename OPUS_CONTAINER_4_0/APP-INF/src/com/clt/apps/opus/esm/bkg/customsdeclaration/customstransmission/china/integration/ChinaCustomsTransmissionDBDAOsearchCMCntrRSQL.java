/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAOsearchCMCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsTransmissionDBDAOsearchCMCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChinaCustomsTransmissionDBDAOsearchCMCntrRSQL
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOsearchCMCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration").append("\n"); 
		query.append("FileName : ChinaCustomsTransmissionDBDAOsearchCMCntrRSQL").append("\n"); 
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
		query.append("SELECT BCT.CNTR_NO," ).append("\n"); 
		query.append("       BMD.CNTR_MF_SEQ, --CM_SEQ" ).append("\n"); 
		query.append("       SUBSTR(BKG_SPCLCHAR_CONV_FNC(TRIM(REPLACE(REPLACE(UPPER(BMD.CNTR_MF_GDS_DESC), CHR(10), ' '), CHR(9), ' ')), 'J'), 1, 512) AS CNTR_MF_GDS_DESC, --CM_DESC1" ).append("\n"); 
		query.append("       SUBSTR(BKG_SPCLCHAR_CONV_FNC(TRIM(REPLACE(REPLACE(UPPER(BMD.CNTR_MF_MK_DESC), CHR(10), ' '), CHR(9), ' ')), 'J'), 1, 100) AS CNTR_MF_MK_DESC1," ).append("\n"); 
		query.append("       SUBSTR(BKG_SPCLCHAR_CONV_FNC(TRIM(REPLACE(REPLACE(UPPER(BMD.CNTR_MF_MK_DESC), CHR(10), ' '), CHR(9), ' ')), 'J'), 101, 100) AS CNTR_MF_MK_DESC2," ).append("\n"); 
		query.append("       SUBSTR(BKG_SPCLCHAR_CONV_FNC(TRIM(REPLACE(REPLACE(UPPER(BMD.CNTR_MF_MK_DESC), CHR(10), ' '), CHR(9), ' ')), 'J'), 201, 100) AS CNTR_MF_MK_DESC3," ).append("\n"); 
		query.append("       SUBSTR(BKG_SPCLCHAR_CONV_FNC(TRIM(REPLACE(REPLACE(UPPER(BMD.CNTR_MF_MK_DESC), CHR(10), ' '), CHR(9), ' ')), 'J'), 301, 100) AS CNTR_MF_MK_DESC4," ).append("\n"); 
		query.append("       SUBSTR(BKG_SPCLCHAR_CONV_FNC(TRIM(REPLACE(REPLACE(UPPER(BMD.CNTR_MF_MK_DESC), CHR(10), ' '), CHR(9), ' ')), 'J'), 401, 100) AS CNTR_MF_MK_DESC5," ).append("\n"); 
		query.append("       --BMD.CNTR_MF_WGT, --CM_WGT" ).append("\n"); 
		query.append("       TO_CHAR(DECODE(NVL(BMD.WGT_UT_CD,' '),'LBS',ROUND(NVL(BMD.CNTR_MF_WGT,0)*0.4536,3), NVL(BMD.CNTR_MF_WGT,0)),'FM999999990.000') AS CNTR_MF_WGT," ).append("\n"); 
		query.append("       BMD.PCK_QTY, --CM_PKG" ).append("\n"); 
		query.append("       NVL(CNV.CSTMS_PCK_TP_CD, BMD.PCK_TP_CD) AS PCK_TP_CD, --CM_PKG_U" ).append("\n"); 
		query.append("       BMD.RC_FLG, --CM_REEFER_IND" ).append("\n"); 
		query.append("       (SELECT CASE" ).append("\n"); 
		query.append("                  WHEN FDO_TEMP IS NOT NULL THEN FDO_TEMP" ).append("\n"); 
		query.append("                  WHEN CDO_TEMP <> 0 THEN CDO_TEMP" ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_CHN_RF" ).append("\n"); 
		query.append("         WHERE BL_NO = BKG.BL_NO" ).append("\n"); 
		query.append("           AND CNTR_NO = BMD.CNTR_NO" ).append("\n"); 
		query.append("           AND CHN_MF_SND_IND_CD = @[trans_mode] ) AS DO_TEMP, --CM_REEFER TEMPERATURE" ).append("\n"); 
		query.append("       (SELECT CASE" ).append("\n"); 
		query.append("                  WHEN FDO_TEMP IS NOT NULL THEN 'F'" ).append("\n"); 
		query.append("                  ELSE DECODE(CDO_TEMP, 0, '', 'C')" ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_CHN_RF" ).append("\n"); 
		query.append("         WHERE BL_NO = BKG.BL_NO" ).append("\n"); 
		query.append("           AND CNTR_NO = BMD.CNTR_NO" ).append("\n"); 
		query.append("           AND CHN_MF_SND_IND_CD = @[trans_mode] ) AS TEMP_UN, --CM_RUNIT TEMPERATURE UNIT" ).append("\n"); 
		query.append("        TO_CHAR(DECODE(NVL(BMD.MEAS_UT_CD,' '),'CBF',ROUND(NVL(BMD.MEAS_QTY,0)*0.0283,3), NVL(BMD.MEAS_QTY,0)),'FM999999990.000')  AS MEAS_QTY, /* 20060707 yong: CBF=>CBM로 환산 */" ).append("\n"); 
		query.append("       '1' AS GOODNO, --CM_GOODNO" ).append("\n"); 
		query.append("       BMD.DCGO_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CNTR_MF_DESC BMD," ).append("\n"); 
		query.append("       BKG_CONTAINER BCT," ).append("\n"); 
		query.append("       BKG_BOOKING BKG," ).append("\n"); 
		query.append("       BKG_CSTMS_PCK_TP_CONV CNV" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE BKG.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND BMD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("   AND BCT.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("   AND BCT.CNTR_NO = BMD.CNTR_NO" ).append("\n"); 
		query.append("   AND BMD.PCK_TP_CD = CNV.PCK_TP_CD(+)" ).append("\n"); 
		query.append("   AND CNV.CNT_CD(+) = 'CN'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ORDER BY BCT.CNTR_DP_SEQ," ).append("\n"); 
		query.append("          BMD.CNTR_MF_SEQ" ).append("\n"); 

	}
}