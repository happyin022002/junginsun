/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAOSearchSpaceControlInquiryOfficeCustomerListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpacecontrolinquiryDBDAOSearchSpaceControlInquiryOfficeCustomerListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2016.02.12  SKY[#7679] Forecast Input by SC/RFA Information
	  * 2016.03.18  Fcast 쿼리 로직 수정
	  * 2016.04.06 T/S 물량 가져오도록 수정
	  * 2016.04.20 Vessel Schedule 로직 추가
	  * 2016.05.12 SPC_GET_HC_RT_BSA_FNC : SKD_VOY_NO parm 추가
	  * 2016.07.12 SPC_BKG_V 제거
	  * 2016.07.19 #15529 AOC- JPN Issue cannot create BKG for T2 + Refeer
	  * 2016.07.25 booking 로직 수정 :cust_tp_cd 에 따른 shipper
	  * </pre>
	  */
	public SpacecontrolinquiryDBDAOSearchSpaceControlInquiryOfficeCustomerListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subtrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sales_office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpacecontrolinquiryDBDAOSearchSpaceControlInquiryOfficeCustomerListVORSQL").append("\n"); 
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
		query.append("WITH PARAM AS (" ).append("\n"); 
		query.append("    SELECT @[trade]        AS TRD_CD    ," ).append("\n"); 
		query.append("           @[subtrade]     AS SUB_TRD_CD," ).append("\n"); 
		query.append("           @[lane]         AS RLANE_CD  ," ).append("\n"); 
		query.append("           @[vsl_cd]       AS VSL_CD    ," ).append("\n"); 
		query.append("           @[skd_voy_no]   AS SKD_VOY_NO," ).append("\n"); 
		query.append("           @[skd_dir_cd]   AS SKD_DIR_CD," ).append("\n"); 
		query.append("           @[sales_office] AS OFC_CD    ," ).append("\n"); 
		query.append("           @[pol_pod]      AS CUST_TP_CD" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", VSL_PORT_SKD AS (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           V.TRD_CD    ," ).append("\n"); 
		query.append("           V.SUB_TRD_CD," ).append("\n"); 
		query.append("           V.RLANE_CD  ," ).append("\n"); 
		query.append("           V.VSL_CD    ," ).append("\n"); 
		query.append("           V.SKD_VOY_NO," ).append("\n"); 
		query.append("           V.SKD_DIR_CD," ).append("\n"); 
		query.append("           V.OFC_CD    ," ).append("\n"); 
		query.append("           NVL(VPS.YD_CD, VPS.VPS_PORT_CD) AS PORT_CD," ).append("\n"); 
		query.append("           VPS.CLPT_SEQ         AS PORT_SEQ," ).append("\n"); 
		query.append("           MAX(VPS.CLPT_SEQ) OVER (PARTITION BY NVL(VPS.YD_CD, VPS.VPS_PORT_CD), VPS.VSL_CD, VPS.SKD_VOY_NO, VPS.SKD_DIR_CD) AS MAX_SEQ," ).append("\n"); 
		query.append("           MIN(VPS.CLPT_SEQ) OVER (PARTITION BY NVL(VPS.YD_CD, VPS.VPS_PORT_CD), VPS.VSL_CD, VPS.SKD_VOY_NO, VPS.SKD_DIR_CD) AS MIN_SEQ," ).append("\n"); 
		query.append("           VPS.CLPT_IND_SEQ  AS CLPT_IND_SEQ," ).append("\n"); 
		query.append("           V.CUST_TP_CD" ).append("\n"); 
		query.append("      FROM " ).append("\n"); 
		query.append("           VSK_VSL_PORT_SKD VPS," ).append("\n"); 
		query.append("           PARAM              V" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND VPS.VSL_CD     = V.VSL_CD" ).append("\n"); 
		query.append("       AND VPS.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND VPS.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND NVL(VPS.SKD_CNG_STS_CD,'1') <> 'S'" ).append("\n"); 
		query.append("       AND VPS.VT_ADD_CALL_FLG IS  NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", VVD_POL_POD AS (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          SELECT " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 PL.TRD_CD        ," ).append("\n"); 
		query.append("                 PL.SUB_TRD_CD    ," ).append("\n"); 
		query.append("                 PL.RLANE_CD      ," ).append("\n"); 
		query.append("                 PL.VSL_CD        ," ).append("\n"); 
		query.append("                 PL.SKD_VOY_NO    ," ).append("\n"); 
		query.append("                 PL.SKD_DIR_CD    ," ).append("\n"); 
		query.append("                 PL.OFC_CD        ," ).append("\n"); 
		query.append("                 PL.PORT_CD       ," ).append("\n"); 
		query.append("                 PL.PORT_CD         AS POL_CD    ," ).append("\n"); 
		query.append("                 MAX(PL.PORT_SEQ)   AS POL_SEQ   ," ).append("\n"); 
		query.append("                 PL.CLPT_IND_SEQ    AS PL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                 PD.PORT_CD         AS POD_CD    ," ).append("\n"); 
		query.append("                 (CASE" ).append("\n"); 
		query.append("                       WHEN MAX(PL.PORT_SEQ) < MAX(PD.MIN_SEQ) THEN MAX(PD.MIN_SEQ)" ).append("\n"); 
		query.append("                                                               ELSE CASE" ).append("\n"); 
		query.append("                                                                         WHEN MAX(PL.PORT_SEQ) > MAX(PD.MIN_SEQ) THEN MAX(PD.MAX_SEQ)" ).append("\n"); 
		query.append("                                                                     END" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("                 ) AS POD_SEQ," ).append("\n"); 
		query.append("                 PD.CLPT_IND_SEQ   AS PD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                 PL.CUST_TP_CD" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            FROM    " ).append("\n"); 
		query.append("                 VSL_PORT_SKD     PD ," ).append("\n"); 
		query.append("                 VSL_PORT_SKD     PL" ).append("\n"); 
		query.append("           WHERE 1=1" ).append("\n"); 
		query.append("             AND PD.TRD_CD       = PL.TRD_CD" ).append("\n"); 
		query.append("             AND PD.SUB_TRD_CD   = PL.SUB_TRD_CD" ).append("\n"); 
		query.append("             AND PD.RLANE_CD     = PL.RLANE_CD" ).append("\n"); 
		query.append("             AND PD.VSL_CD       = PL.VSL_CD" ).append("\n"); 
		query.append("             AND PD.SKD_VOY_NO   = PL.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND PD.SKD_DIR_CD   = PL.SKD_DIR_CD" ).append("\n"); 
		query.append("             AND PD.PORT_CD      <> PL.PORT_CD" ).append("\n"); 
		query.append("             AND PD.PORT_SEQ      > PL.PORT_SEQ" ).append("\n"); 
		query.append("             AND (PL.PORT_SEQ = PL.MAX_SEQ  OR PD.PORT_SEQ < PL.MAX_SEQ )                     " ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("             GROUP BY " ).append("\n"); 
		query.append("                 PL.TRD_CD        ," ).append("\n"); 
		query.append("                 PL.SUB_TRD_CD    ," ).append("\n"); 
		query.append("                 PL.RLANE_CD      ," ).append("\n"); 
		query.append("                 PL.VSL_CD        ," ).append("\n"); 
		query.append("                 PL.SKD_VOY_NO    ," ).append("\n"); 
		query.append("                 PL.SKD_DIR_CD    ," ).append("\n"); 
		query.append("                 PL.PORT_CD       ," ).append("\n"); 
		query.append("                 PD.PORT_CD       ," ).append("\n"); 
		query.append("                 PL.OFC_CD        ," ).append("\n"); 
		query.append("                 PL.PORT_CD       ," ).append("\n"); 
		query.append("                 PL.CLPT_IND_SEQ  ," ).append("\n"); 
		query.append("                 PD.CLPT_IND_SEQ  ," ).append("\n"); 
		query.append("                 PL.CUST_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append(", FCT_DATA AS (" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("    SELECT /*+ ORDERED USE_NL(P Z PL PD) */" ).append("\n"); 
		query.append("           ROW_NUMBER() OVER ( PARTITION BY DECODE(Z.POL_YD_CD, NULL, 1, 2) ORDER BY NVL(SUM(Z.CFM_TTL_QTY), 0) DESC) AS IDX," ).append("\n"); 
		query.append("           DECODE(P.CUST_TP_CD,'S',Z.CUST_CNT_CD,Z.CTRT_CUST_CNT_CD) AS CUST_CNT_CD," ).append("\n"); 
		query.append("           DECODE(P.CUST_TP_CD,'S',Z.CUST_SEQ,Z.CTRT_CUST_SEQ) AS CUST_SEQ," ).append("\n"); 
		query.append("           DECODE(Z.POL_YD_CD, NULL, 'POD', 'POL') AS FLG    ," ).append("\n"); 
		query.append("           NVL(Z.POL_YD_CD, Z.POD_YD_CD)           AS PORT_CD," ).append("\n"); 
		query.append("           Z.SLS_OFC_CD AS OFC_CD," ).append("\n"); 
		query.append("           SUM(Z.CFM_TTL_QTY)     AS FCT_TEU," ).append("\n"); 
		query.append("           SUM(Z.CFM_40FT_HC_QTY) AS FCT_HC ," ).append("\n"); 
		query.append("           SUM(Z.CFM_45FT_HC_QTY) AS FCT_45 ," ).append("\n"); 
		query.append("           SUM(Z.CFM_53FT_QTY)    AS FCT_53 ," ).append("\n"); 
		query.append("           SUM(Z.CFM_RF_QTY)      AS FCT_RF ," ).append("\n"); 
		query.append("           SUM(Z.CFM_TTL_WGT)     AS FCT_WGT" ).append("\n"); 
		query.append("      FROM VVD_POL_POD        P," ).append("\n"); 
		query.append("           SPC_DLY_FCAST_CUST Z" ).append("\n"); 
		query.append("     WHERE Z.RLANE_CD         = P.RLANE_CD" ).append("\n"); 
		query.append("       AND Z.DIR_CD           = P.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND Z.VSL_CD           = P.VSL_CD" ).append("\n"); 
		query.append("       AND Z.SKD_VOY_NO       = P.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND Z.SKD_DIR_CD       = P.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND Z.SLS_OFC_CD       = P.OFC_CD" ).append("\n"); 
		query.append("       AND Z.TRD_CD           = P.TRD_CD" ).append("\n"); 
		query.append("       AND Z.SUB_TRD_CD       = P.SUB_TRD_CD" ).append("\n"); 
		query.append("       AND Z.POL_YD_CD        = P.POL_CD" ).append("\n"); 
		query.append("       AND Z.POD_YD_CD        = P.POD_CD" ).append("\n"); 
		query.append("       AND NVL(Z.POL_IND_SEQ,1) = NVL(P.PL_CLPT_IND_SEQ,1)" ).append("\n"); 
		query.append("       AND NVL(Z.POD_IND_SEQ,1) = NVL(P.PD_CLPT_IND_SEQ,1)" ).append("\n"); 
		query.append("       AND NVL(Z.CFM_TTL_QTY, 0) + NVL(Z.CFM_TTL_WGT, 0) + NVL(Z.CFM_40FT_HC_QTY,0) + NVL(Z.CFM_45FT_HC_QTY,0) + NVL(Z.CFM_RF_QTY,0) > 0" ).append("\n"); 
		query.append("  GROUP BY GROUPING SETS (" ).append("\n"); 
		query.append("                           (DECODE(P.CUST_TP_CD,'S',Z.CUST_CNT_CD,Z.CTRT_CUST_CNT_CD), DECODE(P.CUST_TP_CD,'S',Z.CUST_SEQ,Z.CTRT_CUST_SEQ), Z.SLS_OFC_CD, Z.POL_YD_CD)," ).append("\n"); 
		query.append("                           (DECODE(P.CUST_TP_CD,'S',Z.CUST_CNT_CD,Z.CTRT_CUST_CNT_CD), DECODE(P.CUST_TP_CD,'S',Z.CUST_SEQ,Z.CTRT_CUST_SEQ), Z.SLS_OFC_CD, Z.POD_YD_CD)" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", BKG_DATA AS (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("           ROW_NUMBER() OVER ( PARTITION BY LVL.IDX ORDER BY SUM(NVL(BKG_TTL_QTY, 0)) DESC) AS IDX," ).append("\n"); 
		query.append("           CUST_CNT_CD," ).append("\n"); 
		query.append("           CUST_SEQ   ," ).append("\n"); 
		query.append("           DECODE(LVL.IDX, 1, 'POL', 2, 'POD') AS FLG," ).append("\n"); 
		query.append("           DECODE(LVL.IDX, 1,  POL_CD, 2, POD_CD ) AS PORT_CD," ).append("\n"); 
		query.append("           SLS_OFC_CD AS OFC_CD," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'F', NVL(BKG_20FT_QTY,0) + NVL(BKG_40FT_QTY, 0)*2 + NVL(BKG_40FT_HC_QTY, 0)*SPC_GET_HC_RT_BSA_FNC(TRD_CD ,RLANE_CD ,SKD_DIR_CD ,VSL_CD ,SKD_VOY_NO,'D5') + NVL(BKG_45FT_HC_QTY, 0)*SPC_GET_HC_RT_BSA_FNC(TRD_CD ,RLANE_CD ,SKD_DIR_CD ,VSL_CD ,SKD_VOY_NO,'D7') + NVL(BKG_53FT_QTY, 0)*2  ,0 )) AS FIRM_TEU," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'F', BKG_20FT_QTY   , 0)) AS FIRM_20 ," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'F', BKG_40FT_QTY   , 0)) AS FIRM_40 ," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'F', BKG_40FT_HC_QTY, 0)) AS FIRM_HC ," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'F', BKG_45FT_HC_QTY, 0)) AS FIRM_45 ," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'F', BKG_53FT_QTY,    0)) AS FIRM_53 ," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'F', BKG_RF_QTY     , 0)) AS FIRM_RF ," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'F', BKG_TTL_WGT    , 0)) AS FIRM_WGT," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'W', NVL(BKG_20FT_QTY,0) + NVL(BKG_40FT_QTY, 0)*2 + NVL(BKG_40FT_HC_QTY, 0)*SPC_GET_HC_RT_BSA_FNC(TRD_CD ,RLANE_CD ,SKD_DIR_CD ,VSL_CD ,SKD_VOY_NO,'D5') + NVL(BKG_45FT_HC_QTY, 0)*SPC_GET_HC_RT_BSA_FNC(TRD_CD ,RLANE_CD ,SKD_DIR_CD ,VSL_CD ,SKD_VOY_NO,'D7') + NVL(BKG_53FT_QTY, 0)*2  ,0 )) AS WAIT_TEU," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'W', BKG_20FT_QTY   , 0)) AS WAIT_20 ," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'W', BKG_40FT_QTY   , 0)) AS WAIT_40 ," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'W', BKG_40FT_HC_QTY, 0)) AS WAIT_HC ," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'W', BKG_45FT_HC_QTY, 0)) AS WAIT_45 ," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'W', BKG_53FT_QTY,    0)) AS WAIT_53 ," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'W', BKG_RF_QTY     , 0)) AS WAIT_RF ," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'W', BKG_TTL_WGT    , 0)) AS WAIT_WGT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("              SELECT " ).append("\n"); 
		query.append("                     TRD_CD              ," ).append("\n"); 
		query.append("                     SUB_TRD_CD          ," ).append("\n"); 
		query.append("                     RLANE_CD      		 ," ).append("\n"); 
		query.append("                     VSL_CD        		 ," ).append("\n"); 
		query.append("                     SKD_VOY_NO    		 ," ).append("\n"); 
		query.append("                     SKD_DIR_CD    		 ," ).append("\n"); 
		query.append("                     POL_CD              ," ).append("\n"); 
		query.append("                     POD_CD              ," ).append("\n"); 
		query.append("                     SLS_OFC_CD          ," ).append("\n"); 
		query.append("                     TS_FLG              ," ).append("\n"); 
		query.append("                     BKG_STS_CD          ," ).append("\n"); 
		query.append("                     DECODE(CUST_TP_CD,'S',SUBSTR(SHPR_CD,1,2),SUBSTR(AGMT_CD,2,2)) AS CUST_CNT_CD," ).append("\n"); 
		query.append("                     DECODE(CUST_TP_CD,'S',SUBSTR(SHPR_CD,3),SUBSTR(AGMT_CD,4))     AS CUST_SEQ   ," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL,  1, 14), 0)) AS BKG_TTL_QTY    ," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL, 15, 14), 0)) AS BKG_20FT_QTY   ," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL, 29, 14), 0)) AS BKG_40FT_QTY   ," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL, 43, 14), 0)) AS BKG_40FT_HC_QTY," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL, 57, 14), 0)) AS BKG_45FT_HC_QTY," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL, 71, 14), 0)) AS BKG_53FT_QTY   ," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL, 85, 14), 0)) AS BKG_RF_QTY     ," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL, 99, 14), 0)) AS BKG_TTL_WGT" ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                        SELECT /*+ ORDERED USE_NL(VPP BV B D) USE_HASH(O) */" ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("                               VPP.TRD_CD        ," ).append("\n"); 
		query.append("                               VPP.SUB_TRD_CD    ," ).append("\n"); 
		query.append("                               VPP.RLANE_CD      ," ).append("\n"); 
		query.append("                               VPP.VSL_CD        ," ).append("\n"); 
		query.append("                               VPP.SKD_VOY_NO    ," ).append("\n"); 
		query.append("                               VPP.SKD_DIR_CD    ," ).append("\n"); 
		query.append("                               B.OB_SLS_OFC_CD AS SLS_OFC_CD ," ).append("\n"); 
		query.append("                               DECODE(BV.VSL_PRE_PST_CD, 'T', 'N', 'Y') AS TS_FLG ," ).append("\n"); 
		query.append("                               VPP.POL_CD              ," ).append("\n"); 
		query.append("                               VPP.POD_CD              ," ).append("\n"); 
		query.append("                               B.BKG_STS_CD            ," ).append("\n"); 
		query.append("                               DECODE(DECODE(SUBSTR(NVL(B.RFA_NO, 'DUM'),1,3), 'DUM', 'X', B.RFA_NO)||DECODE(SUBSTR(NVL(B.SC_NO, 'DUM'),1,3), 'DUM', 'X', B.SC_NO), 'XX', 'S', 'C')|| NVL(RTRIM(B.CTRT_CUST_CNT_CD), '  ')||B.CTRT_CUST_SEQ AS AGMT_CD," ).append("\n"); 
		query.append("                               (SELECT C.CUST_CNT_CD||C.CUST_SEQ SHPR_CD" ).append("\n"); 
		query.append("                                FROM BKG_CUSTOMER C" ).append("\n"); 
		query.append("                                WHERE B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                                AND C.BKG_CUST_TP_CD = 'S' ) AS SHPR_CD," ).append("\n"); 
		query.append("                               (" ).append("\n"); 
		query.append("                                  SELECT" ).append("\n"); 
		query.append("                                            TO_CHAR(SUM(DECODE(SAQ_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', 1, '5', SPC_GET_HC_RT_BSA_FNC(VPP.TRD_CD ,VPP.RLANE_CD ,VPP.SKD_DIR_CD ,VPP.VSL_CD ,VPP.SKD_VOY_NO,'D5'), '7', SPC_GET_HC_RT_BSA_FNC(VPP.TRD_CD ,VPP.RLANE_CD ,VPP.SKD_DIR_CD ,VPP.VSL_CD ,VPP.SKD_VOY_NO,'D7'), 2) * Q.OP_CNTR_QTY), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                         || TO_CHAR(SUM(DECODE(SAQ_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                         || TO_CHAR(SUM(DECODE(SAQ_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '4', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                         || TO_CHAR(SUM(DECODE(SAQ_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '5', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                         || TO_CHAR(SUM(DECODE(SAQ_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '7', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                         || TO_CHAR(SUM(DECODE(SAQ_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), 'W', Q.OP_CNTR_QTY, 0) + DECODE(SAQ_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), 'X', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                         || TO_CHAR(SUM(DECODE(SAQ_GET_CNTR_TP_FNC(Q.CNTR_TPSZ_CD), 'R', Q.OP_CNTR_QTY - Q.EQ_SUBST_CGO_QTY, 0) + DECODE(SAQ_GET_CNTR_TP_FNC(Q.CNTR_TPSZ_CD), 'T', Q.RC_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                         || TO_CHAR((D.ACT_WGT * DECODE(D.WGT_UT_CD, 'LBS', 0.00045, 0.001))" ).append("\n"); 
		query.append("                                                                 + SUM(Q.OP_CNTR_QTY * ( SELECT TS.CNTR_TPSZ_TARE_WGT" ).append("\n"); 
		query.append("                                                                                           FROM MDM_CNTR_TP_SZ TS" ).append("\n"); 
		query.append("                                                                                          WHERE TS.CNTR_TPSZ_CD = Q.CNTR_TPSZ_CD)) * 0.001, 'FM0000000000.000')" ).append("\n"); 
		query.append("                                    FROM BKG_QUANTITY Q" ).append("\n"); 
		query.append("                                   WHERE B.BKG_NO      = Q.BKG_NO" ).append("\n"); 
		query.append("                                     AND Q.OP_CNTR_QTY > 0" ).append("\n"); 
		query.append("                               ) AS VAL," ).append("\n"); 
		query.append("                               VPP.CUST_TP_CD" ).append("\n"); 
		query.append("                         FROM  " ).append("\n"); 
		query.append("                               VVD_POL_POD VPP," ).append("\n"); 
		query.append("                               BKG_VVD     BV ," ).append("\n"); 
		query.append("                               BKG_BOOKING B  ," ).append("\n"); 
		query.append("                               SPC_OFC_LVL O  , " ).append("\n"); 
		query.append("                               BKG_BL_DOC  D" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND (VPP.TRD_CD,VPP.SUB_TRD_CD,VPP.RLANE_CD)  =  (" ).append("\n"); 
		query.append("                                                                                        SELECT   B.TRD_CD,B.SUB_TRD_CD ,B.RLANE_CD" ).append("\n"); 
		query.append("                                                                                        FROM MDM_REV_LANE A,  MDM_DTL_REV_LANE B" ).append("\n"); 
		query.append("                                                                                        WHERE B.RLANE_CD = A.RLANE_CD" ).append("\n"); 
		query.append("                                                                                          AND B.RLANE_CD LIKE BV.SLAN_CD||'%'" ).append("\n"); 
		query.append("                                                                                          AND B.FM_CONTI_CD = (" ).append("\n"); 
		query.append("                                                                                                                SELECT MLOC.CONTI_CD" ).append("\n"); 
		query.append("                                                                                                                FROM MDM_LOCATION MLOC" ).append("\n"); 
		query.append("                                                                                                                WHERE MLOC.LOC_CD = BV.POL_CD " ).append("\n"); 
		query.append("                                                                                                              )" ).append("\n"); 
		query.append("                                                                                          AND B.TO_CONTI_CD = (" ).append("\n"); 
		query.append("                                                                                                                SELECT MLOC.CONTI_CD" ).append("\n"); 
		query.append("                                                                                                                FROM MDM_LOCATION MLOC" ).append("\n"); 
		query.append("                                                                                                                WHERE MLOC.LOC_CD = BV.POD_CD " ).append("\n"); 
		query.append("                                                                                                               )" ).append("\n"); 
		query.append("                                                                                          AND B.VSL_SLAN_DIR_CD = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                                          AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                                                                          AND ROWNUM = 1 " ).append("\n"); 
		query.append("                                                                                      ) " ).append("\n"); 
		query.append("                           AND O.OFC_TP_CD     IN ('BB', 'BA', 'BS')" ).append("\n"); 
		query.append("                           AND O.OFC_CD         = B.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("                           AND O.OFC_CD     = VPP.OFC_CD" ).append("\n"); 
		query.append("                           AND B.BKG_STS_CD    IN ('W', 'F')" ).append("\n"); 
		query.append("                           AND B.BKG_CGO_TP_CD IN ('F', 'B', 'R')" ).append("\n"); 
		query.append("                           AND B.BKG_NO         = BV.BKG_NO" ).append("\n"); 
		query.append("                           AND BV.VSL_CD        = VPP.VSL_CD" ).append("\n"); 
		query.append("                           AND BV.SKD_VOY_NO    = VPP.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND BV.SKD_DIR_CD    = VPP.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND BV.POL_YD_CD     = VPP.POL_CD                            " ).append("\n"); 
		query.append("                           AND BV.POD_YD_CD     = VPP.POD_CD                                                                                  " ).append("\n"); 
		query.append("                           AND B.BKG_NO         = D.BKG_NO" ).append("\n"); 
		query.append("                           AND NVL(VPP.PL_CLPT_IND_SEQ,'1') = NVL(BV.POL_CLPT_IND_SEQ,'1')" ).append("\n"); 
		query.append("                           AND NVL(VPP.PD_CLPT_IND_SEQ,'1') = NVL(BV.POD_CLPT_IND_SEQ,'1')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("           ) , " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           ( SELECT LEVEL AS IDX" ).append("\n"); 
		query.append("               FROM DUAL" ).append("\n"); 
		query.append("            CONNECT BY LEVEL <= 2" ).append("\n"); 
		query.append("           ) LVL" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        GROUP BY  CUST_CNT_CD  ," ).append("\n"); 
		query.append("                  CUST_SEQ     ," ).append("\n"); 
		query.append("                  LVL.IDX      ," ).append("\n"); 
		query.append("                  SLS_OFC_CD   ," ).append("\n"); 
		query.append("                  DECODE(LVL.IDX, 1,  POL_CD, 2, POD_CD )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", ALL_DATA AS (" ).append("\n"); 
		query.append("    SELECT Z.FLG," ).append("\n"); 
		query.append("           Z.IDX," ).append("\n"); 
		query.append("           NVL(TRIM(Z.CUST_CNT_CD), 'XX') AS CUST_CNT_CD," ).append("\n"); 
		query.append("           NVL(Z.CUST_SEQ, '999999')      AS CUST_SEQ   ," ).append("\n"); 
		query.append("           Z.PORT_CD    ," ).append("\n"); 
		query.append("           Z.OFC_CD     ," ).append("\n"); 
		query.append("           Z.FCT_TEU    ," ).append("\n"); 
		query.append("           Z.FCT_HC     ," ).append("\n"); 
		query.append("           Z.FCT_45     ," ).append("\n"); 
		query.append("           Z.FCT_53     ," ).append("\n"); 
		query.append("           Z.FCT_RF     ," ).append("\n"); 
		query.append("           Z.FCT_WGT    ," ).append("\n"); 
		query.append("           NULL FIRM_TEU," ).append("\n"); 
		query.append("           NULL FIRM_20 ," ).append("\n"); 
		query.append("           NULL FIRM_40 ," ).append("\n"); 
		query.append("           NULL FIRM_HC ," ).append("\n"); 
		query.append("           NULL FIRM_45 ," ).append("\n"); 
		query.append("           NULL FIRM_53 ," ).append("\n"); 
		query.append("           NULL FIRM_RF ," ).append("\n"); 
		query.append("           NULL FIRM_WGT," ).append("\n"); 
		query.append("           NULL WAIT_TEU," ).append("\n"); 
		query.append("           NULL WAIT_20 ," ).append("\n"); 
		query.append("           NULL WAIT_40 ," ).append("\n"); 
		query.append("           NULL WAIT_HC ," ).append("\n"); 
		query.append("           NULL WAIT_45 ," ).append("\n"); 
		query.append("           NULL WAIT_53 ," ).append("\n"); 
		query.append("           NULL WAIT_RF ," ).append("\n"); 
		query.append("           NULL WAIT_WGT" ).append("\n"); 
		query.append("      FROM FCT_DATA Z" ).append("\n"); 
		query.append("     WHERE IDX <= 500" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT Z.FLG," ).append("\n"); 
		query.append("           Z.IDX + 50 AS IDX," ).append("\n"); 
		query.append("           NVL(TRIM(Z.CUST_CNT_CD), 'XX') AS CUST_CNT_CD," ).append("\n"); 
		query.append("           DECODE(NVL(TRIM(Z.CUST_CNT_CD), 'XX'), 'XX',999999,Z.CUST_SEQ) AS CUST_SEQ," ).append("\n"); 
		query.append("           Z.PORT_CD   ," ).append("\n"); 
		query.append("           Z.OFC_CD    ," ).append("\n"); 
		query.append("           NULL FCT_TEU," ).append("\n"); 
		query.append("           NULL FCT_HC ," ).append("\n"); 
		query.append("           NULL FCT_45 ," ).append("\n"); 
		query.append("           NULL FCT_53 ," ).append("\n"); 
		query.append("           NULL FCT_RF ," ).append("\n"); 
		query.append("           NULL FCT_WGT," ).append("\n"); 
		query.append("           Z.FIRM_TEU  ," ).append("\n"); 
		query.append("           Z.FIRM_20   ," ).append("\n"); 
		query.append("           Z.FIRM_40   ," ).append("\n"); 
		query.append("           Z.FIRM_HC   ," ).append("\n"); 
		query.append("           Z.FIRM_45   ," ).append("\n"); 
		query.append("           Z.FIRM_53   ," ).append("\n"); 
		query.append("           Z.FIRM_RF   ," ).append("\n"); 
		query.append("           Z.FIRM_WGT  ," ).append("\n"); 
		query.append("           Z.WAIT_TEU  ," ).append("\n"); 
		query.append("           Z.WAIT_20   ," ).append("\n"); 
		query.append("           Z.WAIT_40   ," ).append("\n"); 
		query.append("           Z.WAIT_HC   ," ).append("\n"); 
		query.append("           Z.WAIT_45   ," ).append("\n"); 
		query.append("           Z.WAIT_53   ," ).append("\n"); 
		query.append("           Z.WAIT_RF   ," ).append("\n"); 
		query.append("           Z.WAIT_WGT" ).append("\n"); 
		query.append("      FROM BKG_DATA Z" ).append("\n"); 
		query.append("     WHERE IDX <= 500" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT " ).append("\n"); 
		query.append("         Z.FLG        ," ).append("\n"); 
		query.append("         Z.IDX AS ORD ," ).append("\n"); 
		query.append("         Z.CUST_CNT_CD," ).append("\n"); 
		query.append("         Z.CUST_SEQ   ," ).append("\n"); 
		query.append("         Z.CUST_CNT_CD||LTRIM(TO_CHAR(Z.CUST_SEQ, '000009')) AS CUST_CD," ).append("\n"); 
		query.append("         SAQ_CUST_NM_FNC(Z.CUST_CNT_CD, Z.CUST_SEQ)          AS CUST_NM," ).append("\n"); 
		query.append("         Z.PORT_CD ," ).append("\n"); 
		query.append("         Z.OFC_CD  ," ).append("\n"); 
		query.append("         NVL(Z.FCT_TEU, 0) + NVL(Z.FCT_HC, 0) * SPC_GET_HC_RT_BSA_FNC(@[trade] ,@[lane] ,@[skd_dir_cd] ,@[vsl_cd], @[skd_voy_no],'D5') + NVL(Z.FCT_45, 0) * SPC_GET_HC_RT_BSA_FNC(@[trade] ,@[lane] ,@[skd_dir_cd] ,@[vsl_cd], @[skd_voy_no], 'D7') + NVL(Z.FCT_53, 0) * 2 AS FC_TTL_TEU," ).append("\n"); 
		query.append("         Z.FCT_TEU ," ).append("\n"); 
		query.append("         Z.FCT_HC  ," ).append("\n"); 
		query.append("         Z.FCT_45  ," ).append("\n"); 
		query.append("         Z.FCT_53  ," ).append("\n"); 
		query.append("         Z.FCT_RF  ," ).append("\n"); 
		query.append("         Z.FCT_WGT ," ).append("\n"); 
		query.append("         NVL(Z.FIRM_TEU, 0) FIRM_TEU," ).append("\n"); 
		query.append("         Z.FIRM_20 ," ).append("\n"); 
		query.append("         Z.FIRM_40 ," ).append("\n"); 
		query.append("         Z.FIRM_HC ," ).append("\n"); 
		query.append("         Z.FIRM_45 ," ).append("\n"); 
		query.append("         Z.FIRM_53 ," ).append("\n"); 
		query.append("         Z.FIRM_RF ," ).append("\n"); 
		query.append("         Z.FIRM_WGT," ).append("\n"); 
		query.append("         NVL(Z.WAIT_TEU, 0) WAIT_TEU," ).append("\n"); 
		query.append("         Z.WAIT_20 ," ).append("\n"); 
		query.append("         Z.WAIT_40 ," ).append("\n"); 
		query.append("         Z.WAIT_HC ," ).append("\n"); 
		query.append("         Z.WAIT_45 ," ).append("\n"); 
		query.append("         Z.WAIT_53 ," ).append("\n"); 
		query.append("         Z.WAIT_RF ," ).append("\n"); 
		query.append("         Z.WAIT_WGT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            SELECT ROW_NUMBER() OVER ( PARTITION BY Z.FLG ORDER BY MIN(Z.IDX)) AS IDX," ).append("\n"); 
		query.append("                   MIN(Z.IDX) AS IDX2," ).append("\n"); 
		query.append("                   Z.FLG        ," ).append("\n"); 
		query.append("                   Z.CUST_CNT_CD," ).append("\n"); 
		query.append("                   Z.CUST_SEQ   ," ).append("\n"); 
		query.append("                   Z.PORT_CD    ," ).append("\n"); 
		query.append("                   Z.OFC_CD     ," ).append("\n"); 
		query.append("                   SUM(Z.FCT_TEU)  AS FCT_TEU ," ).append("\n"); 
		query.append("                   SUM(Z.FCT_HC)   AS FCT_HC  ," ).append("\n"); 
		query.append("                   SUM(Z.FCT_45)   AS FCT_45  ," ).append("\n"); 
		query.append("                   SUM(Z.FCT_53)   AS FCT_53  ," ).append("\n"); 
		query.append("                   SUM(Z.FCT_RF)   AS FCT_RF  ," ).append("\n"); 
		query.append("                   SUM(Z.FCT_WGT)  AS FCT_WGT ," ).append("\n"); 
		query.append("                   SUM(Z.FIRM_TEU) AS FIRM_TEU," ).append("\n"); 
		query.append("                   SUM(Z.FIRM_20)  AS FIRM_20 ," ).append("\n"); 
		query.append("                   SUM(Z.FIRM_40)  AS FIRM_40 ," ).append("\n"); 
		query.append("                   SUM(Z.FIRM_HC)  AS FIRM_HC ," ).append("\n"); 
		query.append("                   SUM(Z.FIRM_45)  AS FIRM_45 ," ).append("\n"); 
		query.append("                   SUM(Z.FIRM_53)  AS FIRM_53 ,                   " ).append("\n"); 
		query.append("                   SUM(Z.FIRM_RF)  AS FIRM_RF ," ).append("\n"); 
		query.append("                   SUM(Z.FIRM_WGT) AS FIRM_WGT," ).append("\n"); 
		query.append("                   SUM(Z.WAIT_TEU) AS WAIT_TEU," ).append("\n"); 
		query.append("                   SUM(Z.WAIT_20)  AS WAIT_20 ," ).append("\n"); 
		query.append("                   SUM(Z.WAIT_40)  AS WAIT_40 ," ).append("\n"); 
		query.append("                   SUM(Z.WAIT_HC)  AS WAIT_HC ," ).append("\n"); 
		query.append("                   SUM(Z.WAIT_45)  AS WAIT_45 ," ).append("\n"); 
		query.append("                   SUM(Z.WAIT_53)  AS WAIT_53 ," ).append("\n"); 
		query.append("                   SUM(Z.WAIT_RF)  AS WAIT_RF ," ).append("\n"); 
		query.append("                   SUM(Z.WAIT_WGT) AS WAIT_WGT" ).append("\n"); 
		query.append("              FROM ALL_DATA Z" ).append("\n"); 
		query.append("          GROUP BY Z.FLG        ," ).append("\n"); 
		query.append("                   Z.CUST_CNT_CD," ).append("\n"); 
		query.append("                   Z.CUST_SEQ   ," ).append("\n"); 
		query.append("                   Z.PORT_CD    ," ).append("\n"); 
		query.append("                   Z.OFC_CD" ).append("\n"); 
		query.append("          ORDER BY Z.FLG," ).append("\n"); 
		query.append("                   IDX" ).append("\n"); 
		query.append("         ) Z" ).append("\n"); 
		query.append("ORDER BY FLG    ," ).append("\n"); 
		query.append("         IDX    ," ).append("\n"); 
		query.append("         CUST_CD," ).append("\n"); 
		query.append("         CUST_NM," ).append("\n"); 
		query.append("         PORT_CD," ).append("\n"); 
		query.append("         OFC_CD" ).append("\n"); 

	}
}