/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : NewZealandCustomsTransmissionDBDAOSearchCustomsCNTRInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NewZealandCustomsTransmissionDBDAOSearchCustomsCNTRInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public NewZealandCustomsTransmissionDBDAOSearchCustomsCNTRInfoRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.integration").append("\n"); 
		query.append("FileName : NewZealandCustomsTransmissionDBDAOSearchCustomsCNTRInfoRSQL").append("\n"); 
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
		query.append("SELECT BC.CNTR_NO CNTRNBR ," ).append("\n"); 
		query.append("--       DECODE(SUBSTR(BC.CNTR_TPSZ_CD, 2, 1), '2', '22', '3', '25', '4', '42', '5', '45', '6', '92', '7', '95', '8', '92', '9', '95', '95') CNTRSIZE," ).append("\n"); 
		query.append("       NVL(SUBSTR(CNTR_TPSZ_ISO_CD, 1, 2), '') CNTRSIZE," ).append("\n"); 
		query.append("--       DECODE(SUBSTR(BC.CNTR_TPSZ_CD, 1, 1), 'D', 'GP', 'R', 'RT', 'O', 'UT', 'S', 'UT', 'F', 'PF', 'A', 'PF', 'P', 'PF', 'T', 'TN', 'GP') CNTRTYPE," ).append("\n"); 
		query.append("       NVL(SUBSTR(CNTR_TPSZ_ISO_CD, 3, 4), '') CNTRTYPE," ).append("\n"); 
		query.append("       (SELECT CASE" ).append("\n"); 
		query.append("                 WHEN BK.BKG_CGO_TP_CD = 'P' THEN 'E'" ).append("\n"); 
		query.append("                 WHEN bc.BB_CGO_FLG = 'Y' THEN 'B'" ).append("\n"); 
		query.append("                 WHEN bc.CNTR_PRT_FLG = 'Y' THEN 'L'" ).append("\n"); 
		query.append("                 ELSE 'F'" ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("         WHERE BK.BKG_NO = @[bkg_no]) CNTR_FM_IND," ).append("\n"); 
		query.append("       BC.CNTR_WGT CNTR_G_WGT," ).append("\n"); 
		query.append("       NVL(BC.WGT_UT_CD, 'KGS') CNTR_G_WGT_UNIT," ).append("\n"); 
		query.append("       NVL(BC.MEAS_QTY, 0) MEAS_QTY," ).append("\n"); 
		query.append("       NVL(BC.MEAS_UT_CD, 'CBM') MEAS_UT_CD ," ).append("\n"); 
		query.append("       MC.CNTR_TPSZ_TARE_WGT CNTR_T_WGT ," ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("         WHEN MC.CNTR_TPSZ_TARE_WGT IS NOT NULL THEN 'KGM'" ).append("\n"); 
		query.append("         ELSE ''" ).append("\n"); 
		query.append("       END CNTR_T_WGT_UNIT," ).append("\n"); 
		query.append("       DECODE(BC.RC_FLG, 'Y', NVL2(RF.CDO_TEMP, RF.FDO_TEMP, RF.CDO_TEMP)) CNTR_TMP ," ).append("\n"); 
		query.append("       DECODE(BC.RC_FLG, 'Y', DECODE(RF.CDO_TEMP, NULL, 'FAH', 'CEL')) AS CGO_TMP_UNIT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CONTAINER BC," ).append("\n"); 
		query.append("       MDM_CNTR_TP_SZ MC," ).append("\n"); 
		query.append("       BKG_RF_CGO RF" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE BC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND MC.CNTR_TPSZ_CD(+) = BC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("   AND BC.BKG_NO = RF.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BC.CNTR_NO = RF.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND (RF.RC_SEQ IS NULL" ).append("\n"); 
		query.append("            OR RF.RC_SEQ = (SELECT MAX(RC_SEQ)" ).append("\n"); 
		query.append("                              FROM BKG_RF_CGO" ).append("\n"); 
		query.append("                             WHERE BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("                               AND CNTR_NO = BC.CNTR_NO ) )" ).append("\n"); 

	}
}