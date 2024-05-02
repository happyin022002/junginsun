/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAOsearchCncusCntrRSQL.java
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

public class ChinaCustomsTransmissionDBDAOsearchCncusCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOsearchCncusCntrRSQL(){
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
		query.append("FileName : ChinaCustomsTransmissionDBDAOsearchCncusCntrRSQL").append("\n"); 
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
		query.append("SELECT SC.BL_NO," ).append("\n"); 
		query.append("       SC.CNTR_NO," ).append("\n"); 
		query.append("       MAX(SC.CNTR_NO||CHR(9)" ).append("\n"); 
		query.append("       ||BKG_JOIN_FNC(CURSOR((SELECT CNTR_SEAL_NO" ).append("\n"); 
		query.append("                                FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("                               WHERE BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                 AND CNTR_NO = SC.CNTR_NO" ).append("\n"); 
		query.append("                                 AND CNTR_SEAL_SEQ > 0)), '@')||CHR(9)" ).append("\n"); 
		query.append("       ||BKG_JOIN_FNC(CURSOR((SELECT NVL(SEAL_KND_CD, ' ')" ).append("\n"); 
		query.append("                                FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("                               WHERE BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                 AND CNTR_NO = SC.CNTR_NO" ).append("\n"); 
		query.append("                                 AND CNTR_SEAL_SEQ > 0)), '@')||CHR(9)" ).append("\n"); 
		query.append("       ||BKG_JOIN_FNC(CURSOR((SELECT NVL(SEAL_PTY_TP_CD, ' ')" ).append("\n"); 
		query.append("                                FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("                               WHERE BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                 AND CNTR_NO = SC.CNTR_NO" ).append("\n"); 
		query.append("                                 AND CNTR_SEAL_SEQ > 0)), '@')||CHR(9)" ).append("\n"); 
		query.append("       ||ISO.CNTR_TPSZ_ISO_CD||CHR(9)" ).append("\n"); 
		query.append("       ||DECODE(SC.FULL_MTY_CD, 'F', '8', '4')||CHR(9)" ).append("\n"); 
		query.append("       ||TO_CHAR(SC.CNTR_WGT,'FM999999990.000')||CHR(9)" ).append("\n"); 
		query.append("       ||DECODE(NVL(SPEC.TARE_WGT, 0), 0, DECODE(NVL(ISO.CNTR_TPSZ_TARE_WGT, 0), 0, DECODE(CNTR.CNTR_TPSZ_CD, 'T2', 3600, 'T4', 5200, 0), ISO.CNTR_TPSZ_TARE_WGT), SPEC.TARE_WGT)||CHR(9)" ).append("\n"); 
		query.append("       ||SCA.OVR_DIM_FNT_LEN||CHR(9)" ).append("\n"); 
		query.append("       ||SCA.OVR_DIM_REAR_LEN||CHR(9)" ).append("\n"); 
		query.append("       ||SCA.OVR_HGT||CHR(9)" ).append("\n"); 
		query.append("       ||SCA.OVR_DIM_LF_LEN||CHR(9)" ).append("\n"); 
		query.append("       ||SCA.OVR_DIM_RT_LEN||CHR(9)" ).append("\n"); 
		query.append("       ||TO_CHAR(SC.CNTR_MEAS_QTY, 'FM999999990.000')||CHR(9)" ).append("\n"); 
		query.append("       ||'1'||CHR(9)" ).append("\n"); 
		query.append("       ||SC.PCK_QTY||CHR(9)" ).append("\n"); 
		query.append("       ||DECODE(CNTR.LSTM_CD, 'SH', '2', '1')) AS CNTR_DATA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_CHN_CNTR SC," ).append("\n"); 
		query.append("       BKG_CSTMS_SEAL_NO SL," ).append("\n"); 
		query.append("       BKG_CSTMS_CHN_AWK SCA," ).append("\n"); 
		query.append("       MST_CONTAINER CNTR," ).append("\n"); 
		query.append("       MST_CNTR_SPEC SPEC," ).append("\n"); 
		query.append("       MDM_CNTR_TP_SZ ISO," ).append("\n"); 
		query.append("       BKG_BOOKING BKG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE SC.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND SC.CHN_MF_SND_IND_CD = @[trans_mode]" ).append("\n"); 
		query.append("   AND SC.BL_NO = SL.BL_NO(+)" ).append("\n"); 
		query.append("   AND SC.CNTR_NO = SL.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND SL.CNT_CD(+) = 'CN'" ).append("\n"); 
		query.append("   AND SL.CSTMS_DIV_ID(+) = 'CTM'" ).append("\n"); 
		query.append("   AND SC.CHN_MF_SND_IND_CD = SCA.CHN_MF_SND_IND_CD(+)" ).append("\n"); 
		query.append("   AND SC.BL_NO = SCA.BL_NO(+)" ).append("\n"); 
		query.append("   AND SC.CNTR_NO = SCA.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND SC.CNTR_NO = CNTR.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND CNTR.CNTR_SPEC_NO = SPEC.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("   AND CNTR.CNTR_TPSZ_CD = ISO.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("   AND BKG.BL_NO = SC.BL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" GROUP BY SC.BL_NO," ).append("\n"); 
		query.append("          SC.CNTR_NO" ).append("\n"); 

	}
}