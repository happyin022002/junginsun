/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VietnamManifestListDownloadDBDAOSearchCustomsCNTRInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.21
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VietnamManifestListDownloadDBDAOSearchCustomsCNTRInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCustomsCNTRInfo
	  * </pre>
	  */
	public VietnamManifestListDownloadDBDAOSearchCustomsCNTRInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_gubun",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.integration").append("\n"); 
		query.append("FileName : VietnamManifestListDownloadDBDAOSearchCustomsCNTRInfoRSQL").append("\n"); 
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
		query.append("SELECT BC.CNTR_NO     CNTR_NBR" ).append("\n"); 
		query.append(",BC.CNTR_TPSZ_CD    CNTR_TYPE    " ).append("\n"); 
		query.append(",DECODE(BC.CNMV_STS_CD,'TS','6',DECODE(@[pol_gubun],'1','2','3')) CNTR_STATUS        -- 2-Export 3-Import 6-Transhipment" ).append("\n"); 
		query.append("--,DECODE(BC.CNTR_PRT_FLG,'N','5','Y','4') CNTR_FM_IND                                    -- 4-Empty  5-Full" ).append("\n"); 
		query.append(",(SELECT DECODE(BK.BKG_CGO_TP_CD, 'P', '4', '5') FROM BKG_BOOKING BK WHERE BK.BKG_NO = @[bkg_no]) CNTR_FM_IND  -- 4-Empty  5-Full" ).append("\n"); 
		query.append(",BC.CNTR_WGT    CNTR_G_WGT" ).append("\n"); 
		query.append(",NVL(BC.WGT_UT_CD, 'KGS')   CNTR_G_WGT_UNIT" ).append("\n"); 
		query.append(",MC.CNTR_TPSZ_TARE_WGT  CNTR_T_WGT" ).append("\n"); 
		query.append(",CASE WHEN MC.CNTR_TPSZ_TARE_WGT IS NOT NULL THEN 'KGM' ELSE '' END   CNTR_T_WGT_UNIT     --TARE WGT UNIT 기준 문의!!" ).append("\n"); 
		query.append(",NVL(BC.MEAS_QTY, 0), MEAS_QTY, NVL(BC.MEAS_UT_CD, 'CBM') MEAS_UT_CD" ).append("\n"); 
		query.append(",DECODE(BC.RC_FLG, 'Y', NVL2(RF.CDO_TEMP, RF.FDO_TEMP,RF.CDO_TEMP)) CNTR_TMP" ).append("\n"); 
		query.append(",DECODE(BC.RC_FLG, 'Y', DECODE(RF.CDO_TEMP, NULL, 'FAH', 'CEL')) AS CGO_TMP_UNIT       --CEL-celcius, FAH-fahrenheit    " ).append("\n"); 
		query.append("FROM BKG_CONTAINER BC, MDM_CNTR_TP_SZ MC, BKG_RF_CGO RF" ).append("\n"); 
		query.append("WHERE BC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND   BC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND   MC.CNTR_TPSZ_CD(+) = BC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND   BC.BKG_NO = RF.BKG_NO(+)" ).append("\n"); 
		query.append("AND   BC.CNTR_NO = RF.CNTR_NO(+)" ).append("\n"); 
		query.append("AND  (RF.RC_SEQ IS NULL OR " ).append("\n"); 
		query.append("      RF.RC_SEQ = (SELECT MAX(RC_SEQ) " ).append("\n"); 
		query.append("                   FROM BKG_RF_CGO" ).append("\n"); 
		query.append("                   WHERE BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("                   AND CNTR_NO = BC.CNTR_NO" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("     )" ).append("\n"); 

	}
}