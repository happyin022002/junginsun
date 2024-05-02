/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOSearchVesselFIArrivalNoticeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOSearchVesselFIArrivalNoticeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchVesselFIArrivalNotice
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOSearchVesselFIArrivalNoticeRSQL(){
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
		params.put("cstms_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOSearchVesselFIArrivalNoticeRSQL").append("\n"); 
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
		query.append("  X.* ," ).append("\n"); 
		query.append("  TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC(), TO_DATE(BKG_GET_TOKEN_FNC(EDI, 1),'YYYYMMDDHH24MISS')  , BKG_GET_TOKEN_FNC(EDI, 8) ), 'YYYYMMDD') AS EDI_RCV_DT," ).append("\n"); 
		query.append("  TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC(), TO_DATE(BKG_GET_TOKEN_FNC(EDI, 1),'YYYYMMDDHH24MISS')  , 'GMT' ), 'YYYY-MM-DD HH24:MI') AS EDI_RCV_DT_GMT," ).append("\n"); 
		query.append("  BKG_GET_TOKEN_FNC(EDI, 1) AS EDI_RCV_DT_MSG," ).append("\n"); 
		query.append("  BKG_GET_TOKEN_FNC(EDI, 2) AS EDI_RCV_SEQ," ).append("\n"); 
		query.append("  DECODE(BKG_GET_TOKEN_FNC(EDI, 3), 'A', 'Accepted', 'R', 'Rejected'" ).append("\n"); 
		query.append("                                  , 'CA', 'Add Info.', 'H', 'Hold'" ).append("\n"); 
		query.append("                                  , 'L', 'Release', 'D', 'Relase rejection') AS ACK," ).append("\n"); 
		query.append("  BKG_GET_TOKEN_FNC(EDI, 4) AS RESULT," ).append("\n"); 
		query.append("  BKG_GET_TOKEN_FNC(EDI, 5) AS SND_USR_ID," ).append("\n"); 
		query.append("  BKG_GET_TOKEN_FNC(EDI, 6) AS SND_DT," ).append("\n"); 
		query.append("  BKG_GET_TOKEN_FNC(EDI, 7) AS SND_DT_GMT," ).append("\n"); 
		query.append("  BKG_GET_TOKEN_FNC(EDI, 8) AS SND_OFC_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT VPS.VSL_CD||VPS.SKD_VOY_NO||VPS.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("      VPS.VSL_CD," ).append("\n"); 
		query.append("      VPS.SKD_VOY_NO," ).append("\n"); 
		query.append("      VPS.SKD_DIR_CD," ).append("\n"); 
		query.append("      TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC(), EV.UPD_DT, EV.UPD_OFC_CD ), 'YYYY-MM-DD HH24:MI') UPD_DT," ).append("\n"); 
		query.append("      TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC(), EV.UPD_DT, 'GMT'), 'YYYY-MM-DD HH24:MI') UPD_DT_GMT," ).append("\n"); 
		query.append("      EV.UPD_USR_ID," ).append("\n"); 
		query.append("      EV.UPD_OFC_CD," ).append("\n"); 
		query.append("      EV.CVY_REF_NO," ).append("\n"); 
		query.append("      EV.PORT_NET_NO," ).append("\n"); 
		query.append("      EV.CVY_REF_NO CVY_REF_NO_HIDDEN," ).append("\n"); 
		query.append("      VSL.VSL_ENG_NM, " ).append("\n"); 
		query.append("      VSL.CRR_CD," ).append("\n"); 
		query.append("      VSL.LLOYD_NO," ).append("\n"); 
		query.append("      CNT.CNT_CD||'-'||CNT.CNT_NM PICLB_DESC," ).append("\n"); 
		query.append("      '' N1ST_CLPT_CD," ).append("\n"); 
		query.append("      TO_CHAR(VPS.VPS_ETA_DT, 'YYYY-MM-DD HH24:MI') ETA_DT," ).append("\n"); 
		query.append("      TO_CHAR(VPS.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI') ETD_DT," ).append("\n"); 
		query.append("      TO_CHAR(ACT.ACT_ARR_DT, 'YYYY-MM-DD HH24:MI') ATA_DT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  -- 2010-12-15수정 : INIT_ETA_DT항목 추가" ).append("\n"); 
		query.append("	  	CASE WHEN XXX.CSTMS_ESTM_ARR_DT IS NOT NULL" ).append("\n"); 
		query.append("   	  	THEN " ).append("\n"); 
		query.append("            DECODE(VSL.CRR_CD, 'UAC', TO_CHAR(XXX.CSTMS_ESTM_ARR_DT, 'YYYY-MM-DD')|| ' 12:00', 'HPL', TO_CHAR(XXX.CSTMS_ESTM_ARR_DT, 'YYYY-MM-DD')|| ' 12:00', 'MSK', TO_CHAR(XXX.CSTMS_ESTM_ARR_DT, 'YYYY-MM-DD')|| ' 12:00', TO_CHAR(XXX.CSTMS_ESTM_ARR_DT, 'YYYY-MM-DD HH24')||':00')" ).append("\n"); 
		query.append("		ELSE " ).append("\n"); 
		query.append("            CASE WHEN VPS.SLAN_CD = 'TLS'" ).append("\n"); 
		query.append("                THEN" ).append("\n"); 
		query.append("                    CASE WHEN TO_CHAR(VPS.INIT_ETA_DT,'D') = '6'" ).append("\n"); 
		query.append("                        THEN" ).append("\n"); 
		query.append("                            TO_CHAR(VPS.INIT_ETA_DT, 'YYYY-MM-DD')|| ' 05:00'" ).append("\n"); 
		query.append("                        ELSE   " ).append("\n"); 
		query.append("                            TO_CHAR(TRUNC(VPS.INIT_ETA_DT, 'IW') + 4, 'YYYY-MM-DD') || ' 05:00' -- 월요일 기준" ).append("\n"); 
		query.append("                    END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 WHEN VPS.SLAN_CD = 'RFS' AND VPS.SKD_DIR_CD = 'N'" ).append("\n"); 
		query.append("                 THEN" ).append("\n"); 
		query.append("                      CASE WHEN TO_CHAR(VPS.INIT_ETA_DT,'D') = '5'" ).append("\n"); 
		query.append("                           THEN TO_CHAR(VPS.INIT_ETA_DT, 'YYYY-MM-DD')|| ' 04:00'" ).append("\n"); 
		query.append("                           ELSE TO_CHAR(TRUNC(VPS.INIT_ETA_DT, 'D') + 4, 'YYYY-MM-DD') || ' 04:00' -- 일요일 기준" ).append("\n"); 
		query.append("                      END" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("                 WHEN VPS.SLAN_CD = 'RFS' AND VPS.SKD_DIR_CD = 'S'" ).append("\n"); 
		query.append("                 THEN" ).append("\n"); 
		query.append("                      CASE WHEN TO_CHAR(VPS.INIT_ETA_DT,'D') = '1'" ).append("\n"); 
		query.append("                           THEN TO_CHAR(VPS.INIT_ETA_DT, 'YYYY-MM-DD')|| ' 04:00'" ).append("\n"); 
		query.append("                           ELSE TO_CHAR(TRUNC(VPS.INIT_ETA_DT, 'D'), 'YYYY-MM-DD') || ' 04:00'" ).append("\n"); 
		query.append("                      END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                ELSE " ).append("\n"); 
		query.append("                    DECODE(VSL.CRR_CD, 'UAC', TO_CHAR(VPS.INIT_ETA_DT, 'YYYY-MM-DD')|| ' 12:00', 'HPL', TO_CHAR(VPS.INIT_ETA_DT, 'YYYY-MM-DD')|| ' 12:00', 'MSK', TO_CHAR(VPS.INIT_ETA_DT, 'YYYY-MM-DD')|| ' 12:00', TO_CHAR(VPS.INIT_ETA_DT, 'YYYY-MM-DD HH24')||':00')" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("	  END AS INIT_ETA_DT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      (SELECT CSTMS_PORT_CD FROM BKG_CSTMS_EUR_BL A" ).append("\n"); 
		query.append("       WHERE A.VSL_CD = EV.VSL_CD" ).append("\n"); 
		query.append("       AND A.SKD_VOY_NO = EV.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND A.SKD_DIR_CD = EV.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND A.CSTMS_PORT_CD= EV.CSTMS_PORT_CD" ).append("\n"); 
		query.append("       AND ROWNUM=1" ).append("\n"); 
		query.append("       ) CSTMS_PORT_CD," ).append("\n"); 
		query.append("      (SELECT CSTMS_YD_CD FROM BKG_CSTMS_EUR_BL A" ).append("\n"); 
		query.append("       WHERE A.VSL_CD = EV.VSL_CD" ).append("\n"); 
		query.append("       AND A.SKD_VOY_NO = EV.SKD_vOY_NO" ).append("\n"); 
		query.append("       AND A.SKD_DIR_CD = EV.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND A.CSTMS_PORT_CD= EV.CSTMS_PORT_CD" ).append("\n"); 
		query.append("       AND ROWNUM=1" ).append("\n"); 
		query.append("       ) CSTMS_YD_CD," ).append("\n"); 
		query.append("	  EV.RVIS_CSTMS_YD_CD," ).append("\n"); 
		query.append("	  -- 2010-12-10수정 : NEW_PORT가 null인 경우 RVIS_N1ST_CLPT_CD를 SearchEu1stPortByVvd의 SQL을 차용하여 가져오도록 수정" ).append("\n"); 
		query.append("      -- 1105화면(Diversion Request)적용" ).append("\n"); 
		query.append("      NVL(EV.RVIS_N1ST_CLPT_CD," ).append("\n"); 
		query.append("      (SELECT RVIS_N1ST_CLPT_CD" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("              A.VPS_PORT_CD AS RVIS_N1ST_CLPT_CD," ).append("\n"); 
		query.append("              CASE WHEN LAG( EU ) OVER (PARTITION BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD" ).append("\n"); 
		query.append("                ORDER BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.CLPT_SEQ ) IS NULL" ).append("\n"); 
		query.append("              AND EU IS NOT NULL" ).append("\n"); 
		query.append("              AND CLPT_SEQ >1 THEN 'EU1ST' END EU_Flag" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                SELECT A.VSL_CD," ).append("\n"); 
		query.append("                  A.SKD_VOY_NO," ).append("\n"); 
		query.append("                  A.SKD_DIR_CD," ).append("\n"); 
		query.append("                  SLAN_CD ," ).append("\n"); 
		query.append("                  A.VPS_PORT_CD ," ).append("\n"); 
		query.append("                  A.YD_CD AS EU_1ST_PORT_YD_CD ," ).append("\n"); 
		query.append("                  ROW_NUMBER() OVER (PARTITION BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD" ).append("\n"); 
		query.append("                    ORDER BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.CLPT_SEQ ) CLPT_SEQ ," ).append("\n"); 
		query.append("                  B.ATTR_CTNT1 EU" ).append("\n"); 
		query.append("                FROM VSK_VSL_PORT_SKD A, BKG_CSTMS_CD_CONV_CTNT B" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                  AND A.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                  AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                  AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                  AND NVL(SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                  AND B.CSTMS_DIV_ID(+)='EU_MEMBER_CNT'" ).append("\n"); 
		query.append("                  AND B.CNT_CD(+) = 'EU'" ).append("\n"); 
		query.append("                  AND SUBSTR(A.VPS_PORT_CD, 1, 2) = B.ATTR_CTNT1(+) ) A )" ).append("\n"); 
		query.append("        WHERE EU_FLAG IS NOT NULL AND ROWNUM = 1)) AS RVIS_N1ST_CLPT_CD," ).append("\n"); 
		query.append("	  EV.DVS_RQST_SMT_FLG," ).append("\n"); 
		query.append("	 -- 2010-12-15수정 : AN_EDI_SVC_FLG항목 추가" ).append("\n"); 
		query.append("	 -- Transmission button 활성화 여부 검토 for A/N" ).append("\n"); 
		query.append("     (SELECT A.AN_EDI_SVC_FLG " ).append("\n"); 
		query.append("        FROM BKG_CSTMS_EUR_CD_STUP A" ).append("\n"); 
		query.append("        WHERE A.PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("          AND DECODE(A.TML_CD, 'ALL', @[cstms_yd_cd], A.TML_CD)= @[cstms_yd_cd]" ).append("\n"); 
		query.append("          AND ROWNUM=1 ) AS AN_EDI_SVC_FLG," ).append("\n"); 
		query.append("     -- 2010-12-15수정 : AN_EDI_SVC_FLG항목 추가" ).append("\n"); 
		query.append("	 -- Transmission button 활성화 여부 검토 for D/R" ).append("\n"); 
		query.append("     (SELECT A.DVS_RQST_EDI_SVC_FLG" ).append("\n"); 
		query.append("        FROM BKG_CSTMS_EUR_CD_STUP A" ).append("\n"); 
		query.append("        WHERE A.PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("          AND DECODE(A.TML_CD, 'ALL' , @[cstms_yd_cd], A.TML_CD)= @[cstms_yd_cd]" ).append("\n"); 
		query.append("          AND ROWNUM=1 ) AS DVS_RQST_EDI_SVC_FLG," ).append("\n"); 
		query.append("     (SELECT A.EUR_CSTMS_OFC_ID" ).append("\n"); 
		query.append("        FROM BKG_CSTMS_EUR_CD_STUP A" ).append("\n"); 
		query.append("        WHERE A.PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("          AND DECODE(A.TML_CD, 'ALL' , @[cstms_yd_cd], A.TML_CD)= @[cstms_yd_cd]" ).append("\n"); 
		query.append("          AND ROWNUM=1 ) AS N1ST_PORT_OFC_CD," ).append("\n"); 
		query.append("     (SELECT A.EUR_CSTMS_OFC_ID" ).append("\n"); 
		query.append("        FROM BKG_CSTMS_EUR_CD_STUP A" ).append("\n"); 
		query.append("        WHERE A.PORT_CD = SUBSTR(EV.RVIS_N1ST_CLPT_CD, 1, 5)" ).append("\n"); 
		query.append("          AND DECODE(A.TML_CD, 'ALL' , EV.RVIS_N1ST_CLPT_CD , A.TML_CD)= EV.RVIS_N1ST_CLPT_CD" ).append("\n"); 
		query.append("          AND ROWNUM=1 ) AS N1ST_PORT_OFC_CD_NEW," ).append("\n"); 
		query.append("      VPS.YD_CD TML_CD," ).append("\n"); 
		query.append("      YARD.YD_NM TML_NM," ).append("\n"); 
		query.append("      NVL(EV.LST_CLPT_CD, (" ).append("\n"); 
		query.append("            SELECT /*+ INDEX_DESC(K XAK4VSK_VSL_PORT_SKD) */VPS_PORT_CD" ).append("\n"); 
		query.append("            FROM VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("            WHERE K.VSL_CD = VPS.VSL_CD" ).append("\n"); 
		query.append("              AND K.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND K.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("              AND K.CLPT_SEQ < VPS.CLPT_SEQ" ).append("\n"); 
		query.append("              AND ROWNUM = 1 ) ) LST_CLPT_CD," ).append("\n"); 
		query.append("      NVL(EV.NXT_CLPT_CD, (" ).append("\n"); 
		query.append("            SELECT /*+ INDEX(K XAK4VSK_VSL_PORT_SKD) */VPS_PORT_CD" ).append("\n"); 
		query.append("            FROM VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("            WHERE K.VSL_CD = VPS.VSL_CD" ).append("\n"); 
		query.append("              AND K.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND K.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("              AND K.CLPT_SEQ > VPS.CLPT_SEQ" ).append("\n"); 
		query.append("              AND ROWNUM = 1 ) ) NXT_CLPT_CD," ).append("\n"); 
		query.append("      EV.ARR_PORT_CD," ).append("\n"); 
		query.append("      VSL.RGST_NO RGST_NO," ).append("\n"); 
		query.append("      TO_CHAR(VSL.RGST_DT, 'YYYY-MM-DD') RGST_DT," ).append("\n"); 
		query.append("      VSL.RGST_PORT_CD RGST_PORT_CD," ).append("\n"); 
		query.append("      VSL.GRS_RGST_TONG_WGT GRS_RGST_TONG_WGT," ).append("\n"); 
		query.append("      VSL.NET_RGST_TONG_WGT NET_RGST_TONG_WGT," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT (" ).append("\n"); 
		query.append("            SELECT TO_CHAR(MAX(CRE_DT),'YYYYMMDDHH24MISS')  ||','||MAX(EDI_RCV_SEQ)||','||MAX(ACK_RCV_STS_CD)||','||MAX(EUR_CSTMS_ACK_CD)" ).append("\n"); 
		query.append("              FROM BKG_CSTMS_ADV_EUR_RCV" ).append("\n"); 
		query.append("             WHERE RCV_TMS = NVL( ( SELECT RCV_TMS" ).append("\n"); 
		query.append("                                      FROM BKG_CSTMS_ADV_EUR_RCV" ).append("\n"); 
		query.append("                                      WHERE MSG_RCV_NO = SND.MSG_SND_NO" ).append("\n"); 
		query.append("                                        AND (ACK_RCV_STS_CD = 'H' AND EUR_CSTMS_ACK_CD = '361') )" ).append("\n"); 
		query.append("                                , ( SELECT MAX(RCV_TMS)" ).append("\n"); 
		query.append("                                      FROM BKG_CSTMS_ADV_EUR_RCV" ).append("\n"); 
		query.append("                                      WHERE MSG_RCV_NO = SND.MSG_SND_NO" ).append("\n"); 
		query.append("                                        AND (ACK_KND_ID != 'S' OR ACK_RCV_STS_CD != 'A') )" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("                    ) ||','|| SND.SND_USR_ID ||','||TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC(),SND.SND_DT, B.OFC_CD), 'YYYY-MM-DD HH24:MI')||','||TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC(),SND.SND_DT, 'GMT'), 'YYYY-MM-DD HH24:MI')||','|| B.OFC_CD" ).append("\n"); 
		query.append("        FROM BKG_CSTMS_ADV_EUR_SND SND, COM_USER B" ).append("\n"); 
		query.append("        where 1=1" ).append("\n"); 
		query.append("          AND SND.MSG_SND_NO = (" ).append("\n"); 
		query.append("            SELECT MAX(MSG_SND_NO)" ).append("\n"); 
		query.append("            FROM BKG_CSTMS_ADV_EUR_SND A" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("              AND VPS.VSL_CD= A.VSL_CD" ).append("\n"); 
		query.append("              AND VPS.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND VPS.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("              AND VPS.VPS_PORT_CD = A.CSTMS_PORT_CD" ).append("\n"); 
		query.append("#if (${eur_edi_msg_tp_id} == 'ARN')" ).append("\n"); 
		query.append("              AND A.EUR_EDI_MSG_TP_ID = 'ARN' -- or 345 or DIV " ).append("\n"); 
		query.append("#elseif (${eur_edi_msg_tp_id} == '347')" ).append("\n"); 
		query.append("              AND A.EUR_EDI_MSG_TP_ID = '347' -- or ARN or DIV " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("              AND A.EUR_EDI_MSG_TP_ID = 'DIV' -- or ARN or 347" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              ) " ).append("\n"); 
		query.append("			AND SND.SND_USR_ID = B.USR_ID) EDI," ).append("\n"); 
		query.append("      DECODE( EV.VSL_CD, NULL,'I','U') IBFLAG" ).append("\n"); 
		query.append("    FROM VSK_VSL_PORT_SKD VPS," ).append("\n"); 
		query.append("      VSK_ACT_PORT_SKD ACT," ).append("\n"); 
		query.append("	  MDM_COUNTRY CNT," ).append("\n"); 
		query.append("      MDM_VSL_CNTR VSL," ).append("\n"); 
		query.append("      MDM_YARD YARD," ).append("\n"); 
		query.append("      MDM_LOCATION LOC," ).append("\n"); 
		query.append("      BKG_VSL_DCHG_YD DCHG," ).append("\n"); 
		query.append("      BKG_CSTMS_EUR_VSL EV" ).append("\n"); 
		query.append("      ,(SELECT T1.CSTMS_ESTM_ARR_DT" ).append("\n"); 
		query.append("          FROM ( SELECT K.CSTMS_ESTM_ARR_DT" ).append("\n"); 
		query.append("                   FROM BKG_CSTMS_EUR_BL K " ).append("\n"); 
		query.append("                  WHERE K.CSTMS_ESTM_ARR_DT IS NOT NULL" ).append("\n"); 
		query.append("                    AND K.VSL_CD   = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                    AND K.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                    AND K.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                    AND K.CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("                    AND ROWNUM = 1" ).append("\n"); 
		query.append("               ) T1 RIGHT OUTER JOIN dual" ).append("\n"); 
		query.append("            ON T1.CSTMS_ESTM_ARR_DT IS NOT NULL" ).append("\n"); 
		query.append("      ) XXX    " ).append("\n"); 
		query.append("    WHERE VPS.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("      AND VPS.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("      AND VPS.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("      AND VPS.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("      AND VPS.VSL_CD = DCHG.VSL_CD(+)" ).append("\n"); 
		query.append("      AND VPS.SKD_VOY_NO = DCHG.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("      AND VPS.SKD_DIR_CD = DCHG.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("      AND VPS.VSL_CD = ACT.VSL_CD(+)" ).append("\n"); 
		query.append("      AND VPS.SKD_VOY_NO = ACT.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("      AND VPS.SKD_DIR_CD = ACT.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("      AND VPS.VPS_PORT_CD = ACT.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("      AND VPS.CLPT_IND_SEQ = ACT.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("      AND VPS.YD_CD = DCHG.YD_CD(+)" ).append("\n"); 
		query.append("      AND VPS.VPS_PORT_CD = LOC.LOC_CD" ).append("\n"); 
		query.append("      AND VPS.YD_CD = YARD.YD_CD" ).append("\n"); 
		query.append("      AND VPS.VPS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      AND VPS.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("      AND VPS.VSL_CD = EV.VSL_CD(+)" ).append("\n"); 
		query.append("      AND VPS.SKD_VOY_NO = EV.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("      AND VPS.SKD_DIR_CD = EV.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("      AND VPS.VPS_PORT_CD = EV.CSTMS_PORT_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      AND VSL.VSL_RGST_CNT_CD = CNT.CNT_CD) X" ).append("\n"); 

	}
}