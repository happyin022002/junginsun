/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Jp24CustomsTransmissionDBDAOSearchEdiAdvJpVslSkdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.14 
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

public class Jp24CustomsTransmissionDBDAOSearchEdiAdvJpVslSkdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24CustomsTransmissionDBDAOSearchEdiAdvJpVslSkdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etd_time",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_split_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etd_date",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.integration").append("\n"); 
		query.append("FileName : Jp24CustomsTransmissionDBDAOSearchEdiAdvJpVslSkdRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       -- TYPE CODE" ).append("\n"); 
		query.append("       DECODE((SELECT JP_MSG_TP_ID" ).append("\n"); 
		query.append("                 FROM BKG_CSTMS_ADV_JP_rcv_LOG" ).append("\n"); 
		query.append("                WHERE JP_MSG_TP_ID = 'SATD'" ).append("\n"); 
		query.append("                  AND VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                  AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                  AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                  AND POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("                  AND SUBSTR(RCV_KEY_DAT_CTNT, 1, 5) = '00000'" ).append("\n"); 
		query.append("                  AND ROWNUM = 1), NULL, 9, 5) AS DATA00," ).append("\n"); 
		query.append("       -- SP CODE" ).append("\n"); 
		query.append("       RPAD(' ', 16, ' ') AS DATA01," ).append("\n"); 
		query.append("       -- VSL CODE" ).append("\n"); 
		query.append("       RPAD(J_SKD.CALL_SGN_NO, 9, ' ') AS DATA02," ).append("\n"); 
		query.append("       -- VOY CODE" ).append("\n"); 
		query.append("--       RPAD(J_SKD.SKD_VOY_NO||J_SKD.SKD_DIR_CD, 10, ' ') AS DATA03," ).append("\n"); 
		query.append("       RPAD(DECODE(J_SKD.IB_CSSM_VOY_NO, NULL, J_SKD.SKD_VOY_NO||J_SKD.SKD_DIR_CD, J_SKD.IB_CSSM_VOY_NO), 10, ' ') AS DATA03," ).append("\n"); 
		query.append("       -- CONSORTIUM VOYAGE NUMBER" ).append("\n"); 
		query.append("       RPAD(NVL(J_SKD.IB_CSSM_VOY_NO, ' '), 10, ' ') AS DATA04, " ).append("\n"); 
		query.append("       -- CARRIER CODE" ).append("\n"); 
		query.append("       COM_ConstantMgr_PKG.COM_getScacCode_FNC() AS DATA05," ).append("\n"); 
		query.append("       -- POL CODE" ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("          WHEN SUBSTR(L1.LOC_CD, 1, 2) = 'JP' THEN" ).append("\n"); 
		query.append("             NVL(H1.ATTR_CTNT2, L1.LOC_CD)" ).append("\n"); 
		query.append("          ELSE" ).append("\n"); 
		query.append("             DECODE(H1.ATTR_CTNT2, NULL, DECODE(SUBSTR(L1.LOC_CD, 1, 2), 'AW', 'AN', 'CS', 'CB', 'EU', 'ZY', 'KZ', 'KA', 'LI', 'ZY', 'RU', 'RS', 'TJ', 'TA', 'UA', 'UK', 'UZ', 'UB', 'YU', 'YE', SUBSTR(L1.LOC_CD, 1, 2))||'ZZZ', H1.ATTR_CTNT2)" ).append("\n"); 
		query.append("       END AS DATA06," ).append("\n"); 
		query.append("       -- POL SUFFIX" ).append("\n"); 
		query.append("--       RPAD(' ', 1, ' ') AS DATA07," ).append("\n"); 
		query.append("       DECODE(@[pol_split_no], '', ' ', @[pol_split_no]) AS DATA07," ).append("\n"); 
		query.append("       -- DT OF DEPARTURE" ).append("\n"); 
		query.append("--       TO_CHAR(J_SKD.ETD_DT, 'YYYYMMDD') AS DATA08," ).append("\n"); 
		query.append("--       REPLACE([etd_date], '-', '') AS DATA08," ).append("\n"); 
		query.append("       TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(L1.LOC_CD, TO_DATE(REPLACE(@[etd_date], '-', '')||REPLACE(@[etd_time], ':', ''), 'YYYYMMDDHH24MI'), 'GMT'), 'YYYYMMDD') AS DATA08," ).append("\n"); 
		query.append("       -- TIME OF DEPARTURE" ).append("\n"); 
		query.append("--       TO_CHAR(J_SKD.ETD_DT, 'HH24MI') AS DATA09," ).append("\n"); 
		query.append("--       REPLACE([etd_time], ':', '') AS DATA09," ).append("\n"); 
		query.append("       TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(L1.LOC_CD, TO_DATE(REPLACE(@[etd_date], '-', '')||REPLACE(@[etd_time], ':', ''), 'YYYYMMDDHH24MI'), 'GMT'), 'HH24MI') AS DATA09," ).append("\n"); 
		query.append("       -- GREENWICH TIME" ).append("\n"); 
		query.append("--       DECODE(SIGN(L1.GMT_HRS), -1, '-', '+')||DECODE(TRUNC(ABS(L1.GMT_HRS)/60), 0, '00', LPAD(TRUNC(ABS(L1.GMT_HRS)/60), 2, '0'))||LPAD((MOD(ABS(L1.GMT_HRS), 60)), 2, '0') AS DATA10," ).append("\n"); 
		query.append("       '00000' AS DATA10," ).append("\n"); 
		query.append("       -- RELAXED AREA ID" ).append("\n"); 
		query.append("       DECODE(JO_CD1, 'Y', 'Y', ' ') AS DATA11" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_JP_VSL_SKD J_SKD," ).append("\n"); 
		query.append("       MDM_LOCATION L1," ).append("\n"); 
		query.append("       BKG_CSTMS_CD_CONV_CTNT H1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE J_SKD.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND J_SKD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND J_SKD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("   AND J_SKD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("   AND H1.CNT_CD(+) = 'JP'" ).append("\n"); 
		query.append("   AND H1.CSTMS_DIV_ID(+) = 'JAPAN_LOC'" ).append("\n"); 
		query.append("   AND J_SKD.POL_CD = H1.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("   AND J_SKD.POL_CD = L1.LOC_CD(+)" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}