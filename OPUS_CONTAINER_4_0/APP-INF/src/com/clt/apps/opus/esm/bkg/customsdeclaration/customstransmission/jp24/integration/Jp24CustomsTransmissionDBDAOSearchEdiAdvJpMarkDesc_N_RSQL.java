/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Jp24CustomsTransmissionDBDAOSearchEdiAdvJpMarkDesc_N_RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Jp24CustomsTransmissionDBDAOSearchEdiAdvJpMarkDesc_N_RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24CustomsTransmissionDBDAOSearchEdiAdvJpMarkDesc_N_RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_split_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.integration").append("\n"); 
		query.append("FileName : Jp24CustomsTransmissionDBDAOSearchEdiAdvJpMarkDesc_N_RSQL").append("\n"); 
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
		query.append("SELECT --64.Goods Description (350)" ).append("\n"); 
		query.append("       RPAD(DECODE(TRIM(DBMS_LOB.SUBSTR(MK.BL_DESC||H.HAMO_CD_DESC, 350, 1)), 'N/M', MK.BL_DESC, NVL(MK.BL_DESC||' '||H.HAMO_CD_DESC, 'N/M')), 350, ' ') AS DATA00," ).append("\n"); 
		query.append("       --65.HS Code (The First 4-digit) (6)" ).append("\n"); 
		query.append("       RPAD(NVL(MK.CMDT_HS_CD, ' '), 6, ' ') AS DATA01," ).append("\n"); 
		query.append("       --66.Marks and Numbers (140)" ).append("\n"); 
		query.append("       REPLACE(RPAD(DECODE(TRIM(DBMS_LOB.SUBSTR(MK.DIFF_RMK, 140, 1)), 'N/M', 'NO MARK', '.', 'NO MARK', '..', 'NO MARK', '...', 'NO MARK', TRIM(DBMS_LOB.SUBSTR(MK.DIFF_RMK, 140, 1))), 140, ' '), CHR(10), '#%&') AS DATA02," ).append("\n"); 
		query.append("       --67.Number of Packages (8)" ).append("\n"); 
		query.append("       LPAD(CASE WHEN TO_CHAR(NVL(A.PCK_QTY, 0), 'FM99999999') < 0.99999 THEN '1' ELSE TO_CHAR(NVL(A.PCK_QTY, 0), 'FM99999999') END, 8, ' ') AS DATA03," ).append("\n"); 
		query.append("       --68.Number of Packages Unit Code (3)" ).append("\n"); 
		query.append("       RPAD(DECODE(P.CSTMS_PCK_TP_CD, NULL, 'ZZ', P.CSTMS_PCK_TP_CD), 3, ' ') AS DATA04," ).append("\n"); 
		query.append("       --69.Gross Weight (10)" ).append("\n"); 
		query.append("       LPAD(TO_CHAR(NVL(A.GRS_WGT, 0), 'FM999990.000'), 10, ' ') AS DATA05," ).append("\n"); 
		query.append("       --70.Weight Unit Code (3)" ).append("\n"); 
		query.append("       DECODE(NVL(A.WGT_UT_CD, 'KGS'), 'LBS', 'LBR', 'KGS', 'KGM', A.WGT_UT_CD) AS DATA06," ).append("\n"); 
		query.append("       --71.Net Weight (10)" ).append("\n"); 
		query.append("       RPAD(' ', 10, ' ') AS DATA07," ).append("\n"); 
		query.append("       --72.Weight Unit Code (3)" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA08," ).append("\n"); 
		query.append("       --73.Measurement (10)" ).append("\n"); 
		query.append("       LPAD(TO_CHAR(NVL(A.MEAS_QTY, 0), 'FM999990.000'), 10, ' ') AS DATA09," ).append("\n"); 
		query.append("       --74.Measurement Unit Code (3)" ).append("\n"); 
		query.append("       DECODE(NVL(A.MEAS_UT_CD, 'CBM'), 'CMF', 'FTQ', 'MTQ') AS DATA10," ).append("\n"); 
		query.append("       --75.Country of Origin Code (2)" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA11," ).append("\n"); 
		query.append("       --76.Special Cargo Code (3)" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA12," ).append("\n"); 
		query.append("       --77.IMDG Class (4) x5" ).append("\n"); 
		query.append("       RPAD(NVL(A.IMDG_CLSS_CD, ' '), 4, ' ') AS DATA13," ).append("\n"); 
		query.append("       --78.UN No. (4)" ).append("\n"); 
		query.append("       RPAD(NVL(A.IMDG_UN_NO, ' '), 4, ' ') AS DATA14," ).append("\n"); 
		query.append("       --77.IMDG Class (4)" ).append("\n"); 
		query.append("       RPAD(NVL(A.IMDG_CLSS_CD, ' '), 4, ' ') AS DATA15," ).append("\n"); 
		query.append("       --78.UN No. (4)" ).append("\n"); 
		query.append("       RPAD(NVL(A.IMDG_UN_NO, ' '), 4, ' ') AS DATA16," ).append("\n"); 
		query.append("       --77.IMDG Class (4)" ).append("\n"); 
		query.append("       RPAD(NVL(A.IMDG_CLSS_CD, ' '), 4, ' ') AS DATA17," ).append("\n"); 
		query.append("       --78.UN No. (4)" ).append("\n"); 
		query.append("       RPAD(NVL(A.IMDG_UN_NO, ' '), 4, ' ') AS DATA18," ).append("\n"); 
		query.append("       --77.IMDG Class (4)" ).append("\n"); 
		query.append("       RPAD(NVL(A.IMDG_CLSS_CD, ' '), 4, ' ') AS DATA19," ).append("\n"); 
		query.append("       --78.UN No. (4)" ).append("\n"); 
		query.append("       RPAD(NVL(A.IMDG_UN_NO, ' '), 4, ' ') AS DATA20," ).append("\n"); 
		query.append("       --77.IMDG Class (4)" ).append("\n"); 
		query.append("       RPAD(NVL(A.IMDG_CLSS_CD, ' '), 4, ' ') AS DATA21," ).append("\n"); 
		query.append("       --78.UN No. (4)" ).append("\n"); 
		query.append("       RPAD(NVL(A.IMDG_UN_NO, ' '), 4, ' ') AS DATA22," ).append("\n"); 
		query.append("       --79.Freight (18)" ).append("\n"); 
		query.append("       RPAD(' ', 18, ' ') AS DATA23," ).append("\n"); 
		query.append("       --80.Freight Currency Code (3)" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA24," ).append("\n"); 
		query.append("       --81.Value (18)" ).append("\n"); 
		query.append("       RPAD(' ', 18, ' ') AS DATA25," ).append("\n"); 
		query.append("       --82.Value Currency Code (3)" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA26," ).append("\n"); 
		query.append("       --83.General CustomsTransit ApprovalNumber (11)" ).append("\n"); 
		query.append("       RPAD(' ', 11, ' ') AS DATA27," ).append("\n"); 
		query.append("       --84.Temporary Discharge Identifier (3)" ).append("\n"); 
		query.append("       RPAD(DECODE(NVL(A.LOCL_TS_IND_CD, 'L'), 'T', '28 ', ' '), 3, ' ') AS DATA28," ).append("\n"); 
		query.append("       --85.Reason for Temporary Discharge Code (3)" ).append("\n"); 
		query.append("       RPAD(DECODE(NVL(A.LOCL_TS_IND_CD, ' '), 'T', NVL(A.JP_CSTMS_TRNS_CD, ' '), ' '), 3, ' ') AS DATA29," ).append("\n"); 
		query.append("       --86.Duration of Temporary Discharge (2)" ).append("\n"); 
		query.append("       DECODE(NVL(A.LOCL_TS_IND_CD, ' '), 'T', SUBSTR(TO_CHAR(NVL(A.LMT_NO, 0), '99'), 2), '  ') AS DATA30," ).append("\n"); 
		query.append("       --87.Estimated Start Date of Transportation (8)" ).append("\n"); 
		query.append("       RPAD(' ', 8, ' ') AS DATA31," ).append("\n"); 
		query.append("       --88.Estimated Finish Date of Transportation (8)" ).append("\n"); 
		query.append("       RPAD(' ', 8, ' ') AS DATA32," ).append("\n"); 
		query.append("       --89.Code of Transportation Mode of Separate Transit/In-Bond Transportation of Temporary Discharge Cargo (2)" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA33," ).append("\n"); 
		query.append("       --90.Arrival Place Code (5)" ).append("\n"); 
		query.append("       RPAD(' ', 5, ' ') AS DATA34," ).append("\n"); 
		query.append("       --91.Arrival Place Name (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA35," ).append("\n"); 
		query.append("       --92.Code of Other Relevant Laws and Ordinances (2) x5" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA36," ).append("\n"); 
		query.append("       --92.Code of Other Relevant Laws and Ordinances (2)" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA37," ).append("\n"); 
		query.append("       --92.Code of Other Relevant Laws and Ordinances (2)" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA38," ).append("\n"); 
		query.append("       --92.Code of Other Relevant Laws and Ordinances (2)" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA39," ).append("\n"); 
		query.append("       --92.Code of Other Relevant Laws and Ordinances (2)" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA40," ).append("\n"); 
		query.append("       --93.Remark (140)" ).append("\n"); 
		query.append("       RPAD(' ', 140, ' ') AS DATA41," ).append("\n"); 
		query.append("       --94.Reference Number for Internal Use (20)" ).append("\n"); 
		query.append("       RPAD(' ', 20, ' ') AS DATA42" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_JP_BL A," ).append("\n"); 
		query.append("       BKG_CSTMS_ADV_JP_MK MK," ).append("\n"); 
		query.append("       BKG_CSTMS_PCK_TP_CONV P," ).append("\n"); 
		query.append("       BKG_HAMO_TRF H" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND A.BL_SPLIT_NO = NVL(@[bl_split_no], '  ')" ).append("\n"); 
		query.append("   AND A.BL_NO = MK.BL_NO" ).append("\n"); 
		query.append("   AND A.BL_SPLIT_NO = MK.BL_SPLIT_NO" ).append("\n"); 
		query.append("   AND A.PCK_TP_CD = P.PCK_TP_CD(+)" ).append("\n"); 
		query.append("   AND MK.CMDT_HS_CD = H.HAMO_TRF_CD(+)" ).append("\n"); 
		query.append("   AND H.HAMO_TP_CD(+) = 'H'" ).append("\n"); 
		query.append("   AND P.CNT_CD(+) = 'JP'" ).append("\n"); 

	}
}