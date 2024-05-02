/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOsearchVesselArrivalFIRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.12
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2016.02.12 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24CustomsTransmissionDBDAOsearchVesselArrivalFIRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 핀란드 용 전송 로직
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOsearchVesselArrivalFIRSQL(){
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration").append("\n"); 
		query.append("FileName : Eur24CustomsTransmissionDBDAOsearchVesselArrivalFIRSQL").append("\n"); 
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
		query.append("SELECT 'BKG'||TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS') DOC_NO," ).append("\n"); 
		query.append("----''  CALL_REF_NO,----EUR.CVY_REF_NO CALL_REF_NO," ).append("\n"); 
		query.append("NVL((SELECT PORT_NET_NO FROM BKG_CSTMS_EUR_VSL EUV" ).append("\n"); 
		query.append("                     WHERE 1=1" ).append("\n"); 
		query.append("                       AND VSK.VSL_CD = EUV.VSL_CD(+)" ).append("\n"); 
		query.append("                       AND VSK.SKD_VOY_NO = EUV.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                       AND VSK.SKD_DIR_CD = EUV.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                       AND VSK.VPS_PORT_CD = EUV.CSTMS_PORT_CD(+)" ).append("\n"); 
		query.append("					   AND VSK.VPS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("                       AND ROWNUM = 1), '') CALL_REF_NO, " ).append("\n"); 
		query.append("(SELECT B.MSG_ACPT_REF_NO" ).append("\n"); 
		query.append("   FROM BKG_CSTMS_ADV_EUR_SND A, BKG_CSTMS_ADV_EUR_RCV B" ).append("\n"); 
		query.append("  WHERE A.EUR_EDI_MSG_TP_ID = '347'" ).append("\n"); 
		query.append("    AND A.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("    AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("    AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("    AND A.MSG_SND_NO = B.MSG_RCV_NO" ).append("\n"); 
		query.append("    AND A.MSG_SND_NO LIKE @[bl_no]||'%'" ).append("\n"); 
		query.append("    AND B.EUR_EDI_MSG_TP_ID = 'A'" ).append("\n"); 
		query.append("    AND B.ACK_RCV_STS_CD = 'A'" ).append("\n"); 
		query.append("    AND B.MSG_ACPT_REF_NO IS NOT NULL" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append(") AS CUSTOMS_REF," ).append("\n"); 
		query.append("  EUR.VSL_CD," ).append("\n"); 
		query.append("  EUR.SKD_VOY_NO," ).append("\n"); 
		query.append("  EUR.SKD_DIR_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${p_type} != 'FI') " ).append("\n"); 
		query.append("  EUR.VSL_CD||EUR.SKD_VOY_NO||EUR.SKD_DIR_CD||'.'||(" ).append("\n"); 
		query.append("    SELECT TRIM(TO_CHAR(COUNT(BL_NO) + 1, '000'))" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_ADV_EUR_SND" ).append("\n"); 
		query.append("    WHERE VSL_CD||SKD_VOY_NO||SKD_DIR_CD = @[vvd]" ).append("\n"); 
		query.append("      AND EUR_EDI_MSG_TP_ID = 'ARN')||'.3470' TRADE_REF_NO," ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("  @[bl_no]||'.'||(" ).append("\n"); 
		query.append("    SELECT TRIM(TO_CHAR(NVL2(FI_MSG_SND_NO, SUBSTR(FI_MSG_SND_NO,14,3)+1, 001), '000'))" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_EUR_BL" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("   AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("      AND VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("      AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("      AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("      AND CSTMS_PORT_CD =@[cstms_port_cd]" ).append("\n"); 
		query.append("    )||'.347' TRADE_REF_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  '1' PURPOSE_OF_CALL," ).append("\n"); 
		query.append("  EUR.VSL_CD||EUR.SKD_VOY_NO||EUR.SKD_DIR_CD CRN," ).append("\n"); 
		query.append("  '1' TRANS_MODE," ).append("\n"); 
		query.append("  '8' TRANS_TYPE_CD," ).append("\n"); 
		query.append("  VSL.LLOYD_NO LLOYD_NO," ).append("\n"); 
		query.append("  VSL.VSL_ENG_NM VSL_NAME," ).append("\n"); 
		query.append("  ----'' ORIGINAL_PORT,----EUR.N1ST_CLPT_CD ORIGINAL_PORT," ).append("\n"); 
		query.append("  NVL((SELECT N1ST_CLPT_CD FROM BKG_CSTMS_EUR_VSL EUV" ).append("\n"); 
		query.append("                     WHERE 1=1" ).append("\n"); 
		query.append("                       AND VSK.VSL_CD = EUV.VSL_CD(+)" ).append("\n"); 
		query.append("                       AND VSK.SKD_VOY_NO = EUV.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                       AND VSK.SKD_DIR_CD = EUV.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                       AND VSK.VPS_PORT_CD = EUV.CSTMS_PORT_CD(+)" ).append("\n"); 
		query.append("				       AND VSK.VPS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("                       AND ROWNUM = 1), '') ORIGINAL_PORT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  SUBSTR(EUR.CSTMS_PORT_CD, 1, 2) TRANS_NATION," ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  CASE WHEN XXX.CSTMS_ESTM_ARR_DT IS NOT NULL" ).append("\n"); 
		query.append("       THEN DECODE(VSL.CRR_CD, 'UAC', TO_CHAR(XXX.CSTMS_ESTM_ARR_DT, 'YYYYMMDD')|| '120000', 'HPL', TO_CHAR(XXX.CSTMS_ESTM_ARR_DT, 'YYYYMMDD')|| '120000', 'MSK', TO_CHAR(XXX.CSTMS_ESTM_ARR_DT, 'YYYYMMDD')|| '120000', TO_CHAR(XXX.CSTMS_ESTM_ARR_DT, 'YYYYMMDDHH24')||'0000')" ).append("\n"); 
		query.append("	   ELSE DECODE(VSL.CRR_CD, 'UAC', TO_CHAR(VSK.INIT_ETA_DT, 'YYYYMMDD')|| '120000', 'HPL', TO_CHAR(VSK.INIT_ETA_DT, 'YYYYMMDD')|| '120000', 'MSK', TO_CHAR(VSK.INIT_ETA_DT, 'YYYYMMDD')|| '120000', TO_CHAR(VSK.INIT_ETA_DT, 'YYYYMMDDHH24')||'0000')" ).append("\n"); 
		query.append("  END AS ETA," ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  CASE WHEN XXX.CSTMS_ESTM_ARR_DT IS NOT NULL" ).append("\n"); 
		query.append("       THEN DECODE(VSL.CRR_CD, 'UAC', TO_CHAR(XXX.CSTMS_ESTM_ARR_DT, 'YYYYMMDD')|| '120000', 'HPL', TO_CHAR(XXX.CSTMS_ESTM_ARR_DT, 'YYYYMMDD')|| '120000', 'MSK', TO_CHAR(XXX.CSTMS_ESTM_ARR_DT, 'YYYYMMDD')|| '120000', TO_CHAR(XXX.CSTMS_ESTM_ARR_DT, 'YYYYMMDDHH24')||'0000')" ).append("\n"); 
		query.append("	   ELSE " ).append("\n"); 
		query.append("       		CASE WHEN VSK.SLAN_CD = 'TLS'" ).append("\n"); 
		query.append("            	 THEN" ).append("\n"); 
		query.append("                	CASE WHEN TO_CHAR(VSK.INIT_ETA_DT,'D') = '6'" ).append("\n"); 
		query.append("                    	 THEN" ).append("\n"); 
		query.append("                        	TO_CHAR(VSK.INIT_ETA_DT, 'YYYYMMDD')|| '050000'" ).append("\n"); 
		query.append("                     	 ELSE   " ).append("\n"); 
		query.append("                        	TO_CHAR(TRUNC(VSK.INIT_ETA_DT, 'IW') + 4, 'YYYYMMDD') || '050000' -- 월요일 기준" ).append("\n"); 
		query.append("                	END" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("                 WHEN VSK.SLAN_CD = 'RFS' AND VSK.SKD_DIR_CD = 'N'" ).append("\n"); 
		query.append("                 THEN" ).append("\n"); 
		query.append("                      CASE WHEN TO_CHAR(VSK.INIT_ETA_DT,'D') = '5'" ).append("\n"); 
		query.append("                           THEN TO_CHAR(VSK.INIT_ETA_DT, 'YYYYMMDD')|| '040000'" ).append("\n"); 
		query.append("                           ELSE TO_CHAR(TRUNC(VSK.INIT_ETA_DT, 'D') + 4, 'YYYYMMDD') || '040000' -- 일요일 기준" ).append("\n"); 
		query.append("                      END" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("                 WHEN VSK.SLAN_CD = 'RFS' AND VSK.SKD_DIR_CD = 'S'" ).append("\n"); 
		query.append("                 THEN" ).append("\n"); 
		query.append("                      CASE WHEN TO_CHAR(VSK.INIT_ETA_DT,'D') = '1'" ).append("\n"); 
		query.append("                           THEN TO_CHAR(VSK.INIT_ETA_DT, 'YYYYMMDD')|| '040000'" ).append("\n"); 
		query.append("                           ELSE TO_CHAR(TRUNC(VSK.INIT_ETA_DT, 'D'), 'YYYYMMDD') || '040000'" ).append("\n"); 
		query.append("                      END" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("                 ELSE " ).append("\n"); 
		query.append("                	DECODE(VSL.CRR_CD, 'UAC', TO_CHAR(VSK.INIT_ETA_DT, 'YYYYMMDD')|| '120000', 'HPL', TO_CHAR(VSK.INIT_ETA_DT, 'YYYYMMDD')|| '120000', 'MSK', TO_CHAR(VSK.INIT_ETA_DT, 'YYYYMMDD')|| '120000', TO_CHAR(VSK.INIT_ETA_DT, 'YYYYMMDDHH24')||'0000')" ).append("\n"); 
		query.append("        	END" ).append("\n"); 
		query.append("  END AS ETA_EU," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  TO_CHAR(NVL(ACT.ACT_ARR_DT, VSK.VPS_ETA_DT), 'YYYYMMDD')||'000000' ATA," ).append("\n"); 
		query.append("  ----'' ETD,----TO_CHAR(EUR.ETD_DT, 'YYYYMMDDHH24MISS') ETD," ).append("\n"); 
		query.append("   NVL((SELECT TO_CHAR(EUV.ETD_DT, 'YYYYMMDDHH24MISS') FROM BKG_CSTMS_EUR_VSL EUV" ).append("\n"); 
		query.append("                     WHERE 1=1" ).append("\n"); 
		query.append("                       AND VSK.VSL_CD = EUV.VSL_CD(+)" ).append("\n"); 
		query.append("                       AND VSK.SKD_VOY_NO = EUV.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                       AND VSK.SKD_DIR_CD = EUV.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                       AND VSK.VPS_PORT_CD = EUV.CSTMS_PORT_CD(+)" ).append("\n"); 
		query.append("                       AND VSK.VPS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("                       AND ROWNUM = 1), TO_CHAR(VSK.VPS_ETD_DT, 'YYYYMMDDHH24MISS')) ETD," ).append("\n"); 
		query.append("  TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC ('KRPUS', SYSDATE, 'FIKTK'), 'YYYYMMDDHH24MISS') AS DTM_PRESENTATION," ).append("\n"); 
		query.append("  (SELECT A.EUR_CSTMS_OFC_ID" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_EUR_CD_STUP A" ).append("\n"); 
		query.append("    WHERE A.PORT_CD = EUR.CSTMS_PORT_CD" ).append("\n"); 
		query.append("      AND DECODE(A.TML_CD, 'ALL' , EUR.CSTMS_YD_CD, A.TML_CD)= EUR.CSTMS_YD_CD" ).append("\n"); 
		query.append("      AND ROWNUM=1) FIRST_OFFICE," ).append("\n"); 
		query.append("  'NLRTM' POSITION_OF_SHIP," ).append("\n"); 
		query.append("  ----'' PREV_PORT, ----EUR.LST_CLPT_CD PREV_PORT," ).append("\n"); 
		query.append(" NVL((SELECT EUV.LST_CLPT_CD FROM BKG_CSTMS_EUR_VSL EUV" ).append("\n"); 
		query.append("                     WHERE 1=1" ).append("\n"); 
		query.append("                       AND VSK.VSL_CD = EUV.VSL_CD(+)" ).append("\n"); 
		query.append("                       AND VSK.SKD_VOY_NO = EUV.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                       AND VSK.SKD_DIR_CD = EUV.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                       AND VSK.VPS_PORT_CD = EUV.CSTMS_PORT_CD(+)" ).append("\n"); 
		query.append("					   AND VSK.VPS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("                       AND ROWNUM = 1), (" ).append("\n"); 
		query.append("            SELECT /*+ INDEX_DESC(K XAK4VSK_VSL_PORT_SKD) */VPS_PORT_CD" ).append("\n"); 
		query.append("            FROM VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("            WHERE K.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("              AND K.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND K.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("              AND K.CLPT_SEQ < VSK.CLPT_SEQ" ).append("\n"); 
		query.append("              AND ROWNUM = 1 )) PREV_PORT," ).append("\n"); 
		query.append("  ----'' ARRIVAL_PORT, ----DECODE(SUBSTR(EUR.N1ST_CLPT_CD, 1, 2), 'NL', 'NLRTM', '') ARRIVAL_PORT," ).append("\n"); 
		query.append(" NVL((SELECT DECODE(SUBSTR(EUV.N1ST_CLPT_CD, 1, 2), 'NL', 'NLRTM', '') FROM BKG_CSTMS_EUR_VSL EUV" ).append("\n"); 
		query.append("                     WHERE 1=1" ).append("\n"); 
		query.append("                       AND VSK.VSL_CD = EUV.VSL_CD(+)" ).append("\n"); 
		query.append("                       AND VSK.SKD_VOY_NO = EUV.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                       AND VSK.SKD_DIR_CD = EUV.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                       AND VSK.VPS_PORT_CD = EUV.CSTMS_PORT_CD(+)" ).append("\n"); 
		query.append("					   AND VSK.VPS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("                       AND ROWNUM = 1), '') ARRIVAL_PORT," ).append("\n"); 
		query.append("  ----'' NEXT_PORT,----EUR.NXT_CLPT_CD NEXT_PORT," ).append("\n"); 
		query.append("NVL((SELECT EUV.NXT_CLPT_CD FROM BKG_CSTMS_EUR_VSL EUV" ).append("\n"); 
		query.append("                     WHERE 1=1" ).append("\n"); 
		query.append("                       AND VSK.VSL_CD = EUV.VSL_CD(+)" ).append("\n"); 
		query.append("                       AND VSK.SKD_VOY_NO = EUV.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                       AND VSK.SKD_DIR_CD = EUV.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                       AND VSK.VPS_PORT_CD = EUV.CSTMS_PORT_CD(+)" ).append("\n"); 
		query.append("					   AND VSK.VPS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("                       AND ROWNUM = 1), (" ).append("\n"); 
		query.append("            SELECT /*+ INDEX(K XAK4VSK_VSL_PORT_SKD) */VPS_PORT_CD" ).append("\n"); 
		query.append("            FROM VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("            WHERE K.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("              AND K.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND K.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("              AND K.CLPT_SEQ > VSK.CLPT_SEQ" ).append("\n"); 
		query.append("              AND ROWNUM = 1 )) NEXT_PORT," ).append("\n"); 
		query.append("  VSL.RGST_NO CERT_REG_NO," ).append("\n"); 
		query.append("  TO_CHAR(VSL.RGST_DT, 'YYYYMMDD') CERT_REG_DT," ).append("\n"); 
		query.append("  VSL.RGST_PORT_CD CERT_REG_LOC," ).append("\n"); 
		query.append("  VSL.GRS_RGST_TONG_WGT GROSS_TON," ).append("\n"); 
		query.append("  VSL.NET_RGST_TONG_WGT NET_TON," ).append("\n"); 
		query.append("  VSL.CRW_KNT NO_OF_CREW," ).append("\n"); 
		query.append("  '' NO_OF_PASSENGER," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${p_type} != 'FI')" ).append("\n"); 
		query.append("	'' AS ITEM_COUNT_TOTAL," ).append("\n"); 
		query.append("	'' AS PKG_COUNT_TOTAL," ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("  (SELECT COUNT(1)" ).append("\n"); 
		query.append("     FROM BKG_CSTMS_EUR_BL EB, BKG_CSTMS_EUR_CNTR_MF CM, BKG_VVD BV, BKG_BOOKING BK" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("      AND EB.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("      AND EB.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("      AND EB.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("      ----AND EB.POD_CD = cstms_port_cd" ).append("\n"); 
		query.append("      AND EB.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("      AND EB.VSL_CD = CM.VSL_CD" ).append("\n"); 
		query.append("      AND EB.SKD_VOY_NO = CM.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND EB.SKD_DIR_CD = CM.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND EB.BL_NO = CM.BL_NO" ).append("\n"); 
		query.append("      AND EB.CSTMS_PORT_CD = CM.CSTMS_PORT_CD" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      AND EB.BL_NO = BK.BL_NO" ).append("\n"); 
		query.append("      AND BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("      AND EB.VSL_CD = BV.VSL_CD" ).append("\n"); 
		query.append("      AND EB.SKD_VOY_NO = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND EB.SKD_DIR_CD = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND EB.POD_CD = BV.POD_CD" ).append("\n"); 
		query.append("      AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("      AND EB.MVMT_REF_NO IS NOT NULL" ).append("\n"); 
		query.append("      ) AS ITEM_COUNT_TOTAL," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  (SELECT SUM(EB.PCK_QTY) " ).append("\n"); 
		query.append("     FROM BKG_CSTMS_EUR_BL EB, BKG_VVD BV, BKG_BOOKING BK" ).append("\n"); 
		query.append("    WHERE 1=1 " ).append("\n"); 
		query.append("      AND EB.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("      AND EB.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("      AND EB.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)  " ).append("\n"); 
		query.append("     ----AND EB.POD_CD = cstms_port_cd" ).append("\n"); 
		query.append("      AND EB.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("      AND EB.BL_NO = BK.BL_NO" ).append("\n"); 
		query.append("      AND BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("      AND EB.VSL_CD = BV.VSL_CD" ).append("\n"); 
		query.append("      AND EB.SKD_VOY_NO = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND EB.SKD_DIR_CD = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND EB.POD_CD = BV.POD_CD" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("      AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ) AS PKG_COUNT_TOTAL," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  '' AS UNLOAD_IND," ).append("\n"); 
		query.append("  EUR.POD_CD AS UNLOAD_LOC," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  EUR.CSTMS_PORT_CD," ).append("\n"); 
		query.append("  STUP.CNTC_NM PT_CON_NAME," ).append("\n"); 
		query.append("  STUP.CNTC_PSN_NM PT_CON_CMPY," ).append("\n"); 
		query.append("  STUP.CNTC_EML PT_EM_NO," ).append("\n"); 
		query.append("  STUP.CNTC_PHN_NO PT_TEL_NO," ).append("\n"); 
		query.append("  STUP.CNTC_FAX_NO PT_FAX_NO" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR VSL," ).append("\n"); 
		query.append("  ----BKG_CSTMS_EUR_VSL EUR," ).append("\n"); 
		query.append("  BKG_CSTMS_EUR_BL EUR," ).append("\n"); 
		query.append("  VSK_VSL_PORT_SKD VSK," ).append("\n"); 
		query.append("  VSK_ACT_PORT_SKD ACT," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT CNTC_NM," ).append("\n"); 
		query.append("      CNTC_PSN_NM," ).append("\n"); 
		query.append("      CNTC_EML," ).append("\n"); 
		query.append("      CNTC_PHN_NO," ).append("\n"); 
		query.append("      CNTC_FAX_NO" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_EUR_CD_STUP A," ).append("\n"); 
		query.append("      BKG_CSTMS_EUR_BL B" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("      ----AND B.CSTMS_PORT_CD = cstms_port_cd" ).append("\n"); 
		query.append("      AND B.CSTMS_PORT_CD = A.PORT_CD" ).append("\n"); 
		query.append("      AND B.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("      AND B.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("      AND B.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("      AND A.TML_CD IN ('ALL', B.CSTMS_YD_CD )" ).append("\n"); 
		query.append("      AND ROWNUM = 1 ) STUP" ).append("\n"); 
		query.append("      ,(SELECT T1.CSTMS_ESTM_ARR_DT" ).append("\n"); 
		query.append("          FROM ( SELECT K.CSTMS_ESTM_ARR_DT" ).append("\n"); 
		query.append("                   FROM BKG_CSTMS_EUR_BL K " ).append("\n"); 
		query.append("                  WHERE K.CSTMS_ESTM_ARR_DT IS NOT NULL" ).append("\n"); 
		query.append("                    AND K.VSL_CD   = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                    AND K.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                    AND K.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                    AND K.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                    ----AND K.CSTMS_PORT_CD = cstms_port_cd" ).append("\n"); 
		query.append("                    AND ROWNUM = 1" ).append("\n"); 
		query.append("               ) T1 RIGHT OUTER JOIN dual" ).append("\n"); 
		query.append("            ON T1.CSTMS_ESTM_ARR_DT IS NOT NULL" ).append("\n"); 
		query.append("      ) XXX" ).append("\n"); 
		query.append("WHERE EUR.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("  AND EUR.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("  AND EUR.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("  AND EUR.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append(" ---- AND EUR.CSTMS_PORT_CD = " ).append("\n"); 
		query.append("  AND EUR.VSL_CD = VSK.VSL_CD(+)" ).append("\n"); 
		query.append("  AND EUR.SKD_VOY_NO = VSK.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("  AND EUR.SKD_DIR_CD = VSK.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("  AND EUR.CSTMS_PORT_CD = VSK.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("  AND VSK.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("  AND VSK.VSL_CD = ACT.VSL_CD(+)" ).append("\n"); 
		query.append("  AND VSK.SKD_VOY_NO = ACT.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("  AND VSK.SKD_DIR_CD = ACT.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("  AND VSK.VPS_PORT_CD = ACT.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("  AND VSK.CLPT_IND_SEQ = ACT.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("  AND EUR.BL_NO = @[bl_no]" ).append("\n"); 

	}
}