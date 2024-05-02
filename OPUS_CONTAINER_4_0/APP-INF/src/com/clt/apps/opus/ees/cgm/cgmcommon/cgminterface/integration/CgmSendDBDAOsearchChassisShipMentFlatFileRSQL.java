/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CgmSendDBDAOsearchChassisShipMentFlatFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgminterface.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmSendDBDAOsearchChassisShipMentFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CgmSendDBDAOsearchChassisShipMentFlatFileRSQL
	  * </pre>
	  */
	public CgmSendDBDAOsearchChassisShipMentFlatFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fw_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fw_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.cgmcommon.cgminterface.integration").append("\n"); 
		query.append("FileName : CgmSendDBDAOsearchChassisShipMentFlatFileRSQL").append("\n"); 
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
		query.append("WITH PARAM AS " ).append("\n"); 
		query.append("/* INBOUND */" ).append("\n"); 
		query.append("  (SELECT 'IM' IMEX," ).append("\n"); 
		query.append("               BK.BL_NO," ).append("\n"); 
		query.append("               TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(BK.BKG_OFC_CD, BK.BKG_CRE_DT, 'GMT'), 'YYYYMMDDHH24MI') BL_DT," ).append("\n"); 
		query.append("               BK.BKG_NO BKG_NO," ).append("\n"); 
		query.append("               '' BKG_DT," ).append("\n"); 
		query.append("               ' ' TRANS_TP," ).append("\n"); 
		query.append("               (CASE WHEN (SELECT DECODE(MAX(BT.BKG_NO), NULL, 'MH' , 'CH')" ).append("\n"); 
		query.append("                                   FROM BKG_TRO BT" ).append("\n"); 
		query.append("                                  WHERE BT.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                    AND BT.IO_BND_CD = 'I') = 'CH' THEN 'CH'" ).append("\n"); 
		query.append("                    WHEN BK.DE_TERM_CD = 'D' THEN 'CH'" ).append("\n"); 
		query.append("               ELSE 'MH' " ).append("\n"); 
		query.append("               END) MD," ).append("\n"); 
		query.append("               TO_CHAR(VS.VPS_ETA_DT, 'YYYYMMDDHH24MI') ETA," ).append("\n"); 
		query.append("               TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(BK.POD_CD, VS.VPS_ETA_DT, 'GMT'), 'YYYYMMDDHH24MI') ETA_GMT," ).append("\n"); 
		query.append("               '' ETD," ).append("\n"); 
		query.append("               '' ETD_GMT," ).append("\n"); 
		query.append("               BK.POD_CD ARR_LOC," ).append("\n"); 
		query.append("               '' DEP_LOC," ).append("\n"); 
		query.append("               BC.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("               SUBSTR(BC.CNTR_NO, 11, 1) CNTR_CHK," ).append("\n"); 
		query.append("               BC.CNTR_TPSZ_CD CNTR_TP," ).append("\n"); 
		query.append("               (SELECT BCU.CUST_CNT_CD||TRIM(TO_CHAR(BCU.CUST_SEQ, 'FM000000'))" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER BCU" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO = BCU.BKG_NO" ).append("\n"); 
		query.append("                   AND BCU.BKG_CUST_TP_CD = 'S') SHPR_CD," ).append("\n"); 
		query.append("               (SELECT BCU.CUST_NM" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER BCU" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO = BCU.BKG_NO" ).append("\n"); 
		query.append("                   AND BCU.BKG_CUST_TP_CD = 'S') SHPR_NM," ).append("\n"); 
		query.append("               (SELECT BCU.CUST_CNT_CD||TRIM(TO_CHAR(BCU.CUST_SEQ, 'FM000000'))" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER BCU" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO = BCU.BKG_NO" ).append("\n"); 
		query.append("                   AND BCU.BKG_CUST_TP_CD = 'F') FW_CD," ).append("\n"); 
		query.append("               (SELECT BCU.CUST_NM" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER BCU" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO = BCU.BKG_NO" ).append("\n"); 
		query.append("                   AND BCU.BKG_CUST_TP_CD = 'F') FW_NM," ).append("\n"); 
		query.append("               (SELECT BCU.CUST_CNT_CD||TRIM(TO_CHAR(BCU.CUST_SEQ, 'FM000000'))" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER BCU" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO = BCU.BKG_NO" ).append("\n"); 
		query.append("                   AND BCU.BKG_CUST_TP_CD = 'C') CNEE_CD," ).append("\n"); 
		query.append("               (SELECT BCU.CUST_NM" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER BCU" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO = BCU.BKG_NO" ).append("\n"); 
		query.append("                   AND BCU.BKG_CUST_TP_CD = 'C') CNEE_NM," ).append("\n"); 
		query.append("               BK.POD_CD DEST_IM," ).append("\n"); 
		query.append("               '' DEST_EX," ).append("\n"); 
		query.append("               BK.FULL_PKUP_YD_CD EQREL," ).append("\n"); 
		query.append("               '' EQRTN," ).append("\n"); 
		query.append("               BK.SLAN_CD POD_SVC," ).append("\n"); 
		query.append("               '' POL_SVC," ).append("\n"); 
		query.append("               BK.VSL_CD POD_VSL," ).append("\n"); 
		query.append("               '' POL_VSL," ).append("\n"); 
		query.append("               BK.SKD_VOY_NO POD_VOY," ).append("\n"); 
		query.append("               '' POL_VOY," ).append("\n"); 
		query.append("               DECODE(BK.SC_NO, NULL, NVL(BK.RFA_NO, BK.TAA_NO), BK.SC_NO) CONTRACT," ).append("\n"); 
		query.append("               CD.NOD_CD" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BK," ).append("\n"); 
		query.append("               BKG_CONTAINER BC," ).append("\n"); 
		query.append("               BKG_VVD BV," ).append("\n"); 
		query.append("               VSK_VSL_PORT_SKD VS," ).append("\n"); 
		query.append("               SCE_COP_HDR CH," ).append("\n"); 
		query.append("               SCE_COP_DTL CD" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("           AND BK.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("           AND BK.POD_CD = BV.POD_CD" ).append("\n"); 
		query.append("           AND BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("           AND BV.VSL_CD = VS.VSL_CD" ).append("\n"); 
		query.append("           AND BV.SKD_VOY_NO = VS.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND BV.SKD_DIR_CD = VS.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND BV.POD_CD = VS.VPS_PORT_CD" ).append("\n"); 
		query.append("           AND BV.POD_CLPT_IND_SEQ = VS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("           AND BC.BKG_NO = CH.BKG_NO" ).append("\n"); 
		query.append("           AND BC.CNTR_NO = CH.CNTR_NO" ).append("\n"); 
		query.append("           AND CH.COP_NO = CD.COP_NO" ).append("\n"); 
		query.append("           AND BV.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("           AND BK.POD_CD LIKE 'US%'" ).append("\n"); 
		query.append("           AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("           AND BK.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("           AND CD.ACT_CD IN ('FITYAD'," ).append("\n"); 
		query.append("                       'FITYDO'," ).append("\n"); 
		query.append("                       'FITSAD'," ).append("\n"); 
		query.append("                       'FITMAD'," ).append("\n"); 
		query.append("                       'FITMDO'," ).append("\n"); 
		query.append("                       'FITRAD'," ).append("\n"); 
		query.append("                       'FITRDO'," ).append("\n"); 
		query.append("                       'FITZAD')" ).append("\n"); 
		query.append("           AND VS.VPS_ETA_DT BETWEEN TRUNC(SYSDATE)- 7 AND TRUNC(SYSDATE) + 0.99999  " ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("SELECT 'IM' IMEX," ).append("\n"); 
		query.append("               BK.BL_NO," ).append("\n"); 
		query.append("               TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(BK.BKG_OFC_CD, BK.BKG_CRE_DT, 'GMT'), 'YYYYMMDDHH24MI') BL_DT," ).append("\n"); 
		query.append("               BK.BKG_NO BKG_NO," ).append("\n"); 
		query.append("               '' BKG_DT," ).append("\n"); 
		query.append("               ' ' TRANS_TP," ).append("\n"); 
		query.append("               (CASE WHEN (SELECT DECODE(MAX(BT.BKG_NO), NULL, 'MH' , 'CH')" ).append("\n"); 
		query.append("                                   FROM BKG_TRO BT" ).append("\n"); 
		query.append("                                  WHERE BT.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                    AND BT.IO_BND_CD = 'I') = 'CH' THEN 'CH'" ).append("\n"); 
		query.append("                    WHEN BK.DE_TERM_CD = 'D' THEN 'CH'" ).append("\n"); 
		query.append("               ELSE 'MH' " ).append("\n"); 
		query.append("               END) MD," ).append("\n"); 
		query.append("               TO_CHAR(VS.VPS_ETA_DT, 'YYYYMMDDHH24MI') ETA," ).append("\n"); 
		query.append("               TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(BK.POD_CD, VS.VPS_ETA_DT, 'GMT'), 'YYYYMMDDHH24MI') ETA_GMT," ).append("\n"); 
		query.append("               '' ETD," ).append("\n"); 
		query.append("               '' ETD_GMT," ).append("\n"); 
		query.append("               BK.POD_CD ARR_LOC," ).append("\n"); 
		query.append("               '' DEP_LOC," ).append("\n"); 
		query.append("               BC.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("               SUBSTR(BC.CNTR_NO, 11, 1) CNTR_CHK," ).append("\n"); 
		query.append("               BC.CNTR_TPSZ_CD CNTR_TP," ).append("\n"); 
		query.append("               (SELECT BCU.CUST_CNT_CD||TRIM(TO_CHAR(BCU.CUST_SEQ, 'FM000000'))" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER BCU" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO = BCU.BKG_NO" ).append("\n"); 
		query.append("                   AND BCU.BKG_CUST_TP_CD = 'S') SHPR_CD," ).append("\n"); 
		query.append("               (SELECT BCU.CUST_NM" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER BCU" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO = BCU.BKG_NO" ).append("\n"); 
		query.append("                   AND BCU.BKG_CUST_TP_CD = 'S') SHPR_NM," ).append("\n"); 
		query.append("               (SELECT BCU.CUST_CNT_CD||TRIM(TO_CHAR(BCU.CUST_SEQ, 'FM000000'))" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER BCU" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO = BCU.BKG_NO" ).append("\n"); 
		query.append("                   AND BCU.BKG_CUST_TP_CD = 'F') FW_CD," ).append("\n"); 
		query.append("               (SELECT BCU.CUST_NM" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER BCU" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO = BCU.BKG_NO" ).append("\n"); 
		query.append("                   AND BCU.BKG_CUST_TP_CD = 'F') FW_NM," ).append("\n"); 
		query.append("               (SELECT BCU.CUST_CNT_CD||TRIM(TO_CHAR(BCU.CUST_SEQ, 'FM000000'))" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER BCU" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO = BCU.BKG_NO" ).append("\n"); 
		query.append("                   AND BCU.BKG_CUST_TP_CD = 'C') CNEE_CD," ).append("\n"); 
		query.append("               (SELECT BCU.CUST_NM" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER BCU" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO = BCU.BKG_NO" ).append("\n"); 
		query.append("                   AND BCU.BKG_CUST_TP_CD = 'C') CNEE_NM," ).append("\n"); 
		query.append("               BK.POD_CD DEST_IM," ).append("\n"); 
		query.append("               '' DEST_EX," ).append("\n"); 
		query.append("               BK.FULL_PKUP_YD_CD EQREL," ).append("\n"); 
		query.append("               '' EQRTN," ).append("\n"); 
		query.append("               BK.SLAN_CD POD_SVC," ).append("\n"); 
		query.append("               '' POL_SVC," ).append("\n"); 
		query.append("               BK.VSL_CD POD_VSL," ).append("\n"); 
		query.append("               '' POL_VSL," ).append("\n"); 
		query.append("               BK.SKD_VOY_NO POD_VOY," ).append("\n"); 
		query.append("               '' POL_VOY," ).append("\n"); 
		query.append("               DECODE(BK.SC_NO, NULL, NVL(BK.RFA_NO, BK.TAA_NO), BK.SC_NO) CONTRACT," ).append("\n"); 
		query.append("               CD.NOD_CD" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BK," ).append("\n"); 
		query.append("               BKG_CONTAINER BC," ).append("\n"); 
		query.append("               BKG_VVD BV," ).append("\n"); 
		query.append("               VSK_VSL_PORT_SKD VS," ).append("\n"); 
		query.append("               SCE_COP_HDR CH," ).append("\n"); 
		query.append("               SCE_COP_DTL CD" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("           AND BK.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("           AND BK.POD_CD = BV.POD_CD" ).append("\n"); 
		query.append("           AND BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("           AND BV.VSL_CD = VS.VSL_CD" ).append("\n"); 
		query.append("           AND BV.SKD_VOY_NO = VS.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND BV.SKD_DIR_CD = VS.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND BV.POD_CD = VS.VPS_PORT_CD" ).append("\n"); 
		query.append("           AND BV.POD_CLPT_IND_SEQ = VS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("           AND BC.BKG_NO = CH.BKG_NO" ).append("\n"); 
		query.append("           AND BC.CNTR_NO = CH.CNTR_NO" ).append("\n"); 
		query.append("           AND CH.COP_NO = CD.COP_NO" ).append("\n"); 
		query.append("           AND BV.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("           AND BK.DEL_CD LIKE 'US%'" ).append("\n"); 
		query.append("           AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("           AND BK.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("           AND CD.ACT_CD IN ('FITYAD'," ).append("\n"); 
		query.append("                       'FITYDO'," ).append("\n"); 
		query.append("                       'FITSAD'," ).append("\n"); 
		query.append("                       'FITMAD'," ).append("\n"); 
		query.append("                       'FITMDO'," ).append("\n"); 
		query.append("                       'FITRAD'," ).append("\n"); 
		query.append("                       'FITRDO'," ).append("\n"); 
		query.append("                       'FITZAD')" ).append("\n"); 
		query.append("          AND VS.VPS_ETA_DT BETWEEN TRUNC(SYSDATE)- 7 AND TRUNC(SYSDATE) + 0.99999" ).append("\n"); 
		query.append("         UNION " ).append("\n"); 
		query.append("/* OUTBOUND */" ).append("\n"); 
		query.append("SELECT 'EX' IMEX," ).append("\n"); 
		query.append("               '' BL_NO," ).append("\n"); 
		query.append("               '' BL_DT," ).append("\n"); 
		query.append("               BK.BKG_NO," ).append("\n"); 
		query.append("               TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(BK.BKG_OFC_CD, BK.BKG_CRE_DT, 'GMT'), 'YYYYMMDDHH24MI') BKG_DT," ).append("\n"); 
		query.append("               ' ' TRANS_TP," ).append("\n"); 
		query.append("               (CASE WHEN (SELECT DECODE(MAX(BT.BKG_NO), NULL, 'MH' , 'CH')" ).append("\n"); 
		query.append("                                   FROM BKG_TRO BT" ).append("\n"); 
		query.append("                                  WHERE BT.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                    AND BT.IO_BND_CD = 'O') = 'CH' THEN 'CH'" ).append("\n"); 
		query.append("                    WHEN BK.RCV_TERM_CD = 'D' THEN 'CH'" ).append("\n"); 
		query.append("               ELSE 'MH' " ).append("\n"); 
		query.append("               END) MD," ).append("\n"); 
		query.append("               '' ETA," ).append("\n"); 
		query.append("               '' ETA_GMT," ).append("\n"); 
		query.append("               TO_CHAR(VS.VPS_ETD_DT, 'YYYYMMDDHH24MI') ETD," ).append("\n"); 
		query.append("               TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(BK.POL_CD, VS.VPS_ETD_DT, 'GMT'), 'YYYYMMDDHH24MI') ETD_GMT," ).append("\n"); 
		query.append("               '' ARR_LOC," ).append("\n"); 
		query.append("               BK.POL_CD DEP_LOC," ).append("\n"); 
		query.append("               BC.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("               SUBSTR(BC.CNTR_NO, 11, 1) CNTR_CHK," ).append("\n"); 
		query.append("               BC.CNTR_TPSZ_CD CNTR_TP," ).append("\n"); 
		query.append("               (SELECT BCU.CUST_CNT_CD||TRIM(TO_CHAR(BCU.CUST_SEQ, 'FM000000'))" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER BCU" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO = BCU.BKG_NO" ).append("\n"); 
		query.append("                   AND BCU.BKG_CUST_TP_CD = 'S') SHPR_CD," ).append("\n"); 
		query.append("               (SELECT BCU.CUST_NM" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER BCU" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO = BCU.BKG_NO" ).append("\n"); 
		query.append("                   AND BCU.BKG_CUST_TP_CD = 'S') SHPR_NM," ).append("\n"); 
		query.append("               (SELECT BCU.CUST_CNT_CD||TRIM(TO_CHAR(BCU.CUST_SEQ, 'FM000000'))" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER BCU" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO = BCU.BKG_NO" ).append("\n"); 
		query.append("                   AND BCU.BKG_CUST_TP_CD = 'F') FW_CD," ).append("\n"); 
		query.append("               (SELECT BCU.CUST_NM" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER BCU" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO = BCU.BKG_NO" ).append("\n"); 
		query.append("                   AND BCU.BKG_CUST_TP_CD = 'F') FW_NM," ).append("\n"); 
		query.append("               (SELECT BCU.CUST_CNT_CD||TRIM(TO_CHAR(BCU.CUST_SEQ, 'FM000000'))" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER BCU" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO = BCU.BKG_NO" ).append("\n"); 
		query.append("                   AND BCU.BKG_CUST_TP_CD = 'C') CNEE_CD," ).append("\n"); 
		query.append("               (SELECT BCU.CUST_NM" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER BCU" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO = BCU.BKG_NO" ).append("\n"); 
		query.append("                   AND BCU.BKG_CUST_TP_CD = 'C') CNEE_NM," ).append("\n"); 
		query.append("               '' DEST_IM," ).append("\n"); 
		query.append("               BK.POL_CD DEST_EX," ).append("\n"); 
		query.append("               '' EQREL," ).append("\n"); 
		query.append("               BK.FULL_RTN_YD_CD EQRTN," ).append("\n"); 
		query.append("               '' POD_SVC," ).append("\n"); 
		query.append("               BK.SLAN_CD POL_SVC," ).append("\n"); 
		query.append("               '' POD_VSL," ).append("\n"); 
		query.append("               BK.VSL_CD POL_VSL," ).append("\n"); 
		query.append("               '' POD_VOY," ).append("\n"); 
		query.append("               BK.SKD_VOY_NO POL_VOY," ).append("\n"); 
		query.append("               DECODE(BK.SC_NO, NULL, NVL(BK.RFA_NO, BK.TAA_NO), BK.SC_NO) CONTRACT," ).append("\n"); 
		query.append("               CD.NOD_CD" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BK," ).append("\n"); 
		query.append("               BKG_CONTAINER BC," ).append("\n"); 
		query.append("               BKG_VVD BV," ).append("\n"); 
		query.append("               VSK_VSL_PORT_SKD VS," ).append("\n"); 
		query.append("               SCE_COP_HDR CH," ).append("\n"); 
		query.append("               SCE_COP_DTL CD -- CGM_POOL_LOC_MTCH " ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("           AND BK.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("           AND BK.POL_CD = BV.POL_CD" ).append("\n"); 
		query.append("           AND BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("           AND BV.VSL_CD = VS.VSL_CD(+)" ).append("\n"); 
		query.append("           AND BV.SKD_VOY_NO = VS.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("           AND BV.SKD_DIR_CD = VS.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("           AND BV.POL_CD = VS.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("           AND BV.POL_CLPT_IND_SEQ = VS.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("           AND BC.BKG_NO = CH.BKG_NO" ).append("\n"); 
		query.append("           AND BC.CNTR_NO = CH.CNTR_NO" ).append("\n"); 
		query.append("           AND CH.COP_NO = CD.COP_NO" ).append("\n"); 
		query.append("           AND BV.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("           AND BK.POR_CD LIKE 'US%'" ).append("\n"); 
		query.append("           AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("           AND BK.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("           AND CD.ACT_CD IN ('FOTRAD'," ).append("\n"); 
		query.append("                       'FOTRDO'," ).append("\n"); 
		query.append("                       'FOTMAD'," ).append("\n"); 
		query.append("                       'FOTMDO'," ).append("\n"); 
		query.append("                       'FOTSDO'," ).append("\n"); 
		query.append("                       'FOTYAD'," ).append("\n"); 
		query.append("                       'FOTYDO'," ).append("\n"); 
		query.append("                       'MOTZAD')" ).append("\n"); 
		query.append("           AND DECODE(BK.BKG_STS_CD, 'A', TRUNC(SYSDATE) , VS.VPS_ETD_DT) >= TRUNC(SYSDATE)" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("SELECT 'EX' IMEX," ).append("\n"); 
		query.append("               '' BL_NO," ).append("\n"); 
		query.append("               '' BL_DT," ).append("\n"); 
		query.append("               BK.BKG_NO," ).append("\n"); 
		query.append("               TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(BK.BKG_OFC_CD, BK.BKG_CRE_DT, 'GMT'), 'YYYYMMDDHH24MI') BKG_DT," ).append("\n"); 
		query.append("               ' ' TRANS_TP," ).append("\n"); 
		query.append("               (CASE WHEN (SELECT DECODE(MAX(BT.BKG_NO), NULL, 'MH' , 'CH')" ).append("\n"); 
		query.append("                                   FROM BKG_TRO BT" ).append("\n"); 
		query.append("                                  WHERE BT.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                    AND BT.IO_BND_CD = 'O') = 'CH' THEN 'CH'" ).append("\n"); 
		query.append("                    WHEN BK.RCV_TERM_CD = 'D' THEN 'CH'" ).append("\n"); 
		query.append("               ELSE 'MH' " ).append("\n"); 
		query.append("               END) MD," ).append("\n"); 
		query.append("               '' ETA," ).append("\n"); 
		query.append("               '' ETA_GMT," ).append("\n"); 
		query.append("               TO_CHAR(VS.VPS_ETD_DT, 'YYYYMMDDHH24MI') ETD," ).append("\n"); 
		query.append("               TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(BK.POL_CD, VS.VPS_ETD_DT, 'GMT'), 'YYYYMMDDHH24MI') ETD_GMT," ).append("\n"); 
		query.append("               '' ARR_LOC," ).append("\n"); 
		query.append("               BK.POL_CD DEP_LOC," ).append("\n"); 
		query.append("               BC.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("               SUBSTR(BC.CNTR_NO, 11, 1) CNTR_CHK," ).append("\n"); 
		query.append("               BC.CNTR_TPSZ_CD CNTR_TP," ).append("\n"); 
		query.append("               (SELECT BCU.CUST_CNT_CD||TRIM(TO_CHAR(BCU.CUST_SEQ, 'FM000000'))" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER BCU" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO = BCU.BKG_NO" ).append("\n"); 
		query.append("                   AND BCU.BKG_CUST_TP_CD = 'S') SHPR_CD," ).append("\n"); 
		query.append("               (SELECT BCU.CUST_NM" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER BCU" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO = BCU.BKG_NO" ).append("\n"); 
		query.append("                   AND BCU.BKG_CUST_TP_CD = 'S') SHPR_NM," ).append("\n"); 
		query.append("               (SELECT BCU.CUST_CNT_CD||TRIM(TO_CHAR(BCU.CUST_SEQ, 'FM000000'))" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER BCU" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO = BCU.BKG_NO" ).append("\n"); 
		query.append("                   AND BCU.BKG_CUST_TP_CD = 'F') FW_CD," ).append("\n"); 
		query.append("               (SELECT BCU.CUST_NM" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER BCU" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO = BCU.BKG_NO" ).append("\n"); 
		query.append("                   AND BCU.BKG_CUST_TP_CD = 'F') FW_NM," ).append("\n"); 
		query.append("               (SELECT BCU.CUST_CNT_CD||TRIM(TO_CHAR(BCU.CUST_SEQ, 'FM000000'))" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER BCU" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO = BCU.BKG_NO" ).append("\n"); 
		query.append("                   AND BCU.BKG_CUST_TP_CD = 'C') CNEE_CD," ).append("\n"); 
		query.append("               (SELECT BCU.CUST_NM" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER BCU" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO = BCU.BKG_NO" ).append("\n"); 
		query.append("                   AND BCU.BKG_CUST_TP_CD = 'C') CNEE_NM," ).append("\n"); 
		query.append("               '' DEST_IM," ).append("\n"); 
		query.append("               BK.POL_CD DEST_EX," ).append("\n"); 
		query.append("               '' EQREL," ).append("\n"); 
		query.append("               BK.FULL_RTN_YD_CD EQRTN," ).append("\n"); 
		query.append("               '' POD_SVC," ).append("\n"); 
		query.append("               BK.SLAN_CD POL_SVC," ).append("\n"); 
		query.append("               '' POD_VSL," ).append("\n"); 
		query.append("               BK.VSL_CD POL_VSL," ).append("\n"); 
		query.append("               '' POD_VOY," ).append("\n"); 
		query.append("               BK.SKD_VOY_NO POL_VOY," ).append("\n"); 
		query.append("               DECODE(BK.SC_NO, NULL, NVL(BK.RFA_NO, BK.TAA_NO), BK.SC_NO) CONTRACT," ).append("\n"); 
		query.append("               CD.NOD_CD" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BK," ).append("\n"); 
		query.append("               BKG_CONTAINER BC," ).append("\n"); 
		query.append("               BKG_VVD BV," ).append("\n"); 
		query.append("               VSK_VSL_PORT_SKD VS," ).append("\n"); 
		query.append("               SCE_COP_HDR CH," ).append("\n"); 
		query.append("               SCE_COP_DTL CD -- CGM_POOL_LOC_MTCH " ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("           AND BK.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("           AND BK.POL_CD = BV.POL_CD" ).append("\n"); 
		query.append("           AND BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("           AND BV.VSL_CD = VS.VSL_CD(+)" ).append("\n"); 
		query.append("           AND BV.SKD_VOY_NO = VS.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("           AND BV.SKD_DIR_CD = VS.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("           AND BV.POL_CD = VS.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("           AND BV.POL_CLPT_IND_SEQ = VS.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("           AND BC.BKG_NO = CH.BKG_NO" ).append("\n"); 
		query.append("           AND BC.CNTR_NO = CH.CNTR_NO" ).append("\n"); 
		query.append("           AND CH.COP_NO = CD.COP_NO" ).append("\n"); 
		query.append("           AND BV.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("           AND BK.POL_CD LIKE 'US%'" ).append("\n"); 
		query.append("           AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("           AND BK.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("           AND CD.ACT_CD IN ('FOTRAD'," ).append("\n"); 
		query.append("                       'FOTRDO'," ).append("\n"); 
		query.append("                       'FOTMAD'," ).append("\n"); 
		query.append("                       'FOTMDO'," ).append("\n"); 
		query.append("                       'FOTSDO'," ).append("\n"); 
		query.append("                       'FOTYAD'," ).append("\n"); 
		query.append("                       'FOTYDO'," ).append("\n"); 
		query.append("                       'MOTZAD')" ).append("\n"); 
		query.append("           AND DECODE(BK.BKG_STS_CD, 'A', TRUNC(SYSDATE) , VS.VPS_ETD_DT) >= TRUNC(SYSDATE)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT DISTINCT A.*" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("(SELECT PL.EDI_ID RECEIVER," ).append("\n"); 
		query.append("       P.IMEX," ).append("\n"); 
		query.append("       PL.CHSS_POOL_CD AS POOL_CD," ).append("\n"); 
		query.append("       P.BL_NO," ).append("\n"); 
		query.append("       P.BL_DT," ).append("\n"); 
		query.append("       DECODE(P.IMEX, 'IM', DECODE(P.BKG_NO, P.BL_NO, NULL, P.BKG_NO), P.BKG_NO) BKG_NO," ).append("\n"); 
		query.append("       P.BKG_DT," ).append("\n"); 
		query.append("       P.TRANS_TP," ).append("\n"); 
		query.append("       P.MD \"MODE\"," ).append("\n"); 
		query.append("       P.ETA," ).append("\n"); 
		query.append("       P.ETA_GMT," ).append("\n"); 
		query.append("       P.ETD," ).append("\n"); 
		query.append("       P.ETD_GMT," ).append("\n"); 
		query.append("       P.ARR_LOC," ).append("\n"); 
		query.append("       P.DEP_LOC," ).append("\n"); 
		query.append("       P.CNTR_NO," ).append("\n"); 
		query.append("       P.CNTR_CHK," ).append("\n"); 
		query.append("       P.CNTR_TP," ).append("\n"); 
		query.append("       P.SHPR_CD," ).append("\n"); 
		query.append("       REPLACE(REPLACE(P.SHPR_NM, CHR(10), ''), CHR(12), '') SHPR_NM," ).append("\n"); 
		query.append("       P.FW_CD," ).append("\n"); 
		query.append("       REPLACE(REPLACE(P.FW_NM, CHR(10), ''), CHR(12), '') FW_NM," ).append("\n"); 
		query.append("       P.CNEE_CD," ).append("\n"); 
		query.append("       REPLACE(REPLACE(P.CNEE_NM, CHR(10), ''), CHR(12), '') CNEE_NM," ).append("\n"); 
		query.append("       P.DEST_IM," ).append("\n"); 
		query.append("       P.DEST_EX," ).append("\n"); 
		query.append("       P.EQREL," ).append("\n"); 
		query.append("       P.EQRTN," ).append("\n"); 
		query.append("       P.POD_SVC," ).append("\n"); 
		query.append("       P.POL_SVC," ).append("\n"); 
		query.append("       P.POD_VSL," ).append("\n"); 
		query.append("       P.POL_VSL," ).append("\n"); 
		query.append("       P.POD_VOY," ).append("\n"); 
		query.append("       P.POL_VOY," ).append("\n"); 
		query.append("       P.CONTRACT" ).append("\n"); 
		query.append("  FROM PARAM P, CGM_POOL_CHSS_LOC PL" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND P.NOD_CD LIKE 'US%'" ).append("\n"); 
		query.append("   AND P.NOD_CD = PL.OWN_YD_CD" ).append("\n"); 
		query.append("   AND PL.POOL_MGMT_CO_CD IS NOT NULL" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND RECEIVER = @[fw_cd]" ).append("\n"); 
		query.append("  AND POOL_CD = @[fw_nm]" ).append("\n"); 

	}
}