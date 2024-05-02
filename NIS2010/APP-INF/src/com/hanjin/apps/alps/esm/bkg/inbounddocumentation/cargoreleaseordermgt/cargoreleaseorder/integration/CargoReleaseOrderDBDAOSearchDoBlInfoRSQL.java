/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : CargoReleaseOrderDBDAOSearchDoBlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.15
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchDoBlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * D/O Release를 위한 기본 Reference정보를 조회한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchDoBlInfoRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchDoBlInfoRSQL").append("\n"); 
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
		query.append("SELECT  BKG_NO" ).append("\n"); 
		query.append("      , BL_NO" ).append("\n"); 
		query.append("      , POR_CD" ).append("\n"); 
		query.append("      , POL_CD" ).append("\n"); 
		query.append("      , POD_CD" ).append("\n"); 
		query.append("      , DEL_CD" ).append("\n"); 
		query.append("      , DEL_NOD_CD" ).append("\n"); 
		query.append("      , DE_TERM_CD" ).append("\n"); 
		query.append("      , DE_TERM_DESC" ).append("\n"); 
		query.append("      , ARRIVAL_VESSEL" ).append("\n"); 
		query.append("-- VVD 조회 조건 추가 Start (18.03.15 하대성)" ).append("\n"); 
		query.append("	  , VVD" ).append("\n"); 
		query.append("-- VVD 조회 조건 추가 End (18.03.15 하대성)" ).append("\n"); 
		query.append("      , TO_CHAR( NVL(DECODE( SUBQ.POD_CD, 'BEANR', AVVD.ETA_DT, 'NLRTM', RVVD.VVD_ETA_DT), SUBQ.VPS_ETA_DT ), 'YYYY-MM-DD HH24:MI', 'NLS_DATE_LANGUAGE = ENGLISH') AS VPS_ETA_DT" ).append("\n"); 
		query.append("      , PCK_QTY             -- PKG 1" ).append("\n"); 
		query.append("      , PCK_TP_CD           -- PKG 2" ).append("\n"); 
		query.append("      , ACT_WGT             -- WGT 1" ).append("\n"); 
		query.append("      , WGT_UT_CD           -- WGT 2" ).append("\n"); 
		query.append("      , MEAS_QTY            -- MEA 1" ).append("\n"); 
		query.append("      , MEAS_UT_CD          -- MEA 2" ).append("\n"); 
		query.append("      , SOC_FLG             -- SOC" ).append("\n"); 
		query.append("      , SPLIT_FLG           -- SPLIT_FLG" ).append("\n"); 
		query.append("      , REP_CMDT_NM" ).append("\n"); 
		query.append("      , NVL( IDA_DO_YD_NM, NVL(DECODE(SUBQ.POD_CD,'BEANR', AHDG.ATTR_CTNT1, 'NLRTM', RCNV.ATTR_CTNT3), YD.YD_NM)) AS DSCH_LOC" ).append("\n"); 
		query.append("      , PKUP_YD_CD" ).append("\n"); 
		query.append("      , IDA_DO_YD_CD" ).append("\n"); 
		query.append("      , CNTR_PRT_FLG         -- PARTIAL" ).append("\n"); 
		query.append("      , CCUST_NM" ).append("\n"); 
		query.append("      , CCUST_ADDR" ).append("\n"); 
		query.append("      , NCUST_NM" ).append("\n"); 
		query.append("      , NCUST_ADDR" ).append("\n"); 
		query.append("      , SCUST_NM" ).append("\n"); 
		query.append("      , SCUST_ADDR" ).append("\n"); 
		query.append("      , CALL_SGN_NO" ).append("\n"); 
		query.append("--    , BL_TP_CD" ).append("\n"); 
		query.append("      , OBL_ISS_RMK" ).append("\n"); 
		query.append("      , SUBQ.LCLOBLISSUEFLG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT BKGM.BKG_NO                                            AS BKG_NO     -- BKG_NO" ).append("\n"); 
		query.append("             , BKGM.BL_NO                                             AS BL_NO      -- BL_NO" ).append("\n"); 
		query.append("           --, DECODE(BISS.OBL_SRND_FLG,'Y','S', BKGM.BL_TP_CD)       AS BL_TP_CD" ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("             , MAX(NVL(VSL_SEQ,0)) OVER (PARTITION BY BKGM.BKG_NO )   AS MAX_VSL_SEQ       " ).append("\n"); 
		query.append("             , NVL(VSL_SEQ,0)                                         AS VSL_SEQ      -- VSL_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             , BKGM.POR_CD         AS POR_CD     -- POR" ).append("\n"); 
		query.append("             , BKGM.POL_CD         AS POL_CD     -- POL" ).append("\n"); 
		query.append("             , BKGM.POD_CD         AS POD_CD     -- POD" ).append("\n"); 
		query.append("             , BKGM.DEL_CD         AS DEL_CD     -- DEL" ).append("\n"); 
		query.append("             , SUBSTR(BKGM.DEL_NOD_CD,6,2)          AS DEL_NOD_CD     -- DEL 2" ).append("\n"); 
		query.append("             , BKGM.DE_TERM_CD     AS DE_TERM_CD -- DE_TERM" ).append("\n"); 
		query.append("             , (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD00765' AND INTG_CD_VAL_CTNT = BKGM.DE_TERM_CD) AS DE_TERM_DESC" ).append("\n"); 
		query.append("             , NVL(ANTC.VSL_NM, CVSL.VSL_ENG_NM||' '|| BVVD.SKD_VOY_NO || BVVD.SKD_DIR_CD ) AS ARRIVAL_VESSEL -- ARRIVAL VESSEL" ).append("\n"); 
		query.append("-- VVD 조회 조건 추가 Start (18.03.15 하대성)" ).append("\n"); 
		query.append("			 , BVVD.VSL_CD || BVVD.SKD_VOY_NO || BVVD.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("-- VVD 조회 조건 추가 End (18.03.15 하대성)" ).append("\n"); 
		query.append("             , NVL(ANTC.POD_ARR_DT, VSKD.VPS_ETA_DT) AS VPS_ETA_DT               -- ETA" ).append("\n"); 
		query.append("             , BDOC.PCK_QTY        AS PCK_QTY    -- PKG 1" ).append("\n"); 
		query.append("             , BDOC.PCK_TP_CD      AS PCK_TP_CD  -- PKG 2" ).append("\n"); 
		query.append("             , BDOC.ACT_WGT        AS ACT_WGT    -- WGT 1" ).append("\n"); 
		query.append("             , BDOC.WGT_UT_CD      AS WGT_UT_CD  -- WGT 2" ).append("\n"); 
		query.append("             , BDOC.MEAS_QTY       AS MEAS_QTY   -- MEA 1" ).append("\n"); 
		query.append("             , BDOC.MEAS_UT_CD     AS MEAS_UT_CD -- MEA 2" ).append("\n"); 
		query.append("             , BKGM.SOC_FLG        AS SOC_FLG    -- SOC" ).append("\n"); 
		query.append("             , DECODE(BKGM.BKG_CRE_TP_CD,'S','Y',SPLIT_FLG)           AS SPLIT_FLG  -- SPLIT_FLG" ).append("\n"); 
		query.append("             , CMDT.REP_CMDT_NM                                       AS REP_CMDT_NM" ).append("\n"); 
		query.append("             , NVL(ANTC.PKUP_YD_CD,VSKD.YD_CD)                        AS PKUP_YD_CD" ).append("\n"); 
		query.append("             , BDRF.IDA_DO_YD_CD                                      AS IDA_DO_YD_CD" ).append("\n"); 
		query.append("             , BHDG.ATTR_CTNT2 || BHDG.ATTR_CTNT3 || BHDG.ATTR_CTNT4  AS IDA_DO_YD_NM" ).append("\n"); 
		query.append("    --       , YD.YD_NM            AS DSCH_LOC" ).append("\n"); 
		query.append("             , (SELECT DECODE(COUNT(1), 1, 'Y', 'N') FROM BKG_CONTAINER CNTR WHERE CNTR.BKG_NO = BKGM.BKG_NO AND CNTR_PRT_FLG ='Y' AND ROWNUM = 1 )  AS CNTR_PRT_FLG -- PARTIAL" ).append("\n"); 
		query.append("             , CCST.CUST_NM        AS CCUST_NM" ).append("\n"); 
		query.append("             , CCST.CUST_ADDR      AS CCUST_ADDR" ).append("\n"); 
		query.append("             , NCST.CUST_NM        AS NCUST_NM" ).append("\n"); 
		query.append("             , NCST.CUST_ADDR      AS NCUST_ADDR" ).append("\n"); 
		query.append("             , SCST.CUST_NM        AS SCUST_NM" ).append("\n"); 
		query.append("             , SCST.CUST_ADDR      AS SCUST_ADDR" ).append("\n"); 
		query.append("             , CVSL.CALL_SGN_NO    AS CALL_SGN_NO" ).append("\n"); 
		query.append("             , BVVD.VSL_CD         AS VSL_CD" ).append("\n"); 
		query.append("             , BVVD.SKD_VOY_NO     AS SKD_VOY_NO" ).append("\n"); 
		query.append("             , BVVD.SKD_DIR_CD     AS SKD_DIR_CD" ).append("\n"); 
		query.append("             , BISS.OBL_ISS_RMK    AS OBL_ISS_RMK" ).append("\n"); 
		query.append("             ,( SELECT DECODE( COUNT(*),0,'N','Y') " ).append("\n"); 
		query.append("                FROM BKG_BOOKING BKGM" ).append("\n"); 
		query.append("                     LEFT OUTER JOIN BKG_BL_ISS BISS" ).append("\n"); 
		query.append("                     ON ( BISS.BKG_NO =  BKGM.BKG_NO" ).append("\n"); 
		query.append("                          AND BISS.OBL_SRND_FLG <> 'Y'" ).append("\n"); 
		query.append("                          AND BISS.OBL_RDEM_FLG <> 'Y'" ).append("\n"); 
		query.append("                     ) " ).append("\n"); 
		query.append("                WHERE  BKGM.BKG_NO IN ( SELECT BKG2.BKG_NO" ).append("\n"); 
		query.append("                                        FROM BKG_CONTAINER CNTR1," ).append("\n"); 
		query.append("                                             BKG_BOOKING BKG1, " ).append("\n"); 
		query.append("                                             BKG_BOOKING BKG2, " ).append("\n"); 
		query.append("                                             BKG_CONTAINER CNTR2" ).append("\n"); 
		query.append("                                        WHERE CNTR1.BKG_NO        = @[bkg_no]          -- cntr1 " ).append("\n"); 
		query.append("                                        AND   CNTR1.CNTR_PRT_FLG  = 'Y'" ).append("\n"); 
		query.append("                                        AND   CNTR1.BKG_NO        = BKG1.BKG_NO    -- bkg1" ).append("\n"); 
		query.append("                                        AND   BKG1.BKG_STS_CD     <> 'X'" ).append("\n"); 
		query.append("                                        AND   BKG1.VSL_CD         = BKG2.VSL_CD        -- bkg2" ).append("\n"); 
		query.append("                                        AND   BKG1.SKD_VOY_NO     = BKG2.SKD_VOY_NO" ).append("\n"); 
		query.append("                                        AND   BKG1.SKD_DIR_CD     = BKG2.SKD_DIR_CD" ).append("\n"); 
		query.append("                                        AND   BKG1.POL_CD         = BKG2.POL_CD" ).append("\n"); 
		query.append("                                        AND   BKG1.BKG_NO         <> BKG2.BKG_NO  " ).append("\n"); 
		query.append("                                        AND   BKG2.BKG_STS_CD     <> 'X'" ).append("\n"); 
		query.append("                                        AND   CNTR2.BKG_NO        = BKG2.BKG_NO    -- cntr2" ).append("\n"); 
		query.append("                                        AND   CNTR2.CNTR_NO       = CNTR1.CNTR_NO" ).append("\n"); 
		query.append("                                        AND   CNTR2.CNTR_PRT_FLG  = 'Y' )                " ).append("\n"); 
		query.append("                AND    BKGM.BL_TP_CD <> 'W' ) AS LCLOBLISSUEFLG" ).append("\n"); 
		query.append("          FROM BKG_BOOKING      BKGM" ).append("\n"); 
		query.append("              LEFT OUTER JOIN BKG_VVD BVVD ON (     " ).append("\n"); 
		query.append("                   BKGM.BKG_NO = BVVD.BKG_NO" ).append("\n"); 
		query.append("               AND BKGM.POD_CD = BVVD.POD_CD" ).append("\n"); 
		query.append("               AND BVVD.VSL_PRE_PST_CD IN ('T','U')" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("             LEFT OUTER JOIN VSK_VSL_PORT_SKD VSKD ON(" ).append("\n"); 
		query.append("                   VSKD.VSL_CD       = BVVD.VSL_CD" ).append("\n"); 
		query.append("               AND VSKD.SKD_VOY_NO   = BVVD.SKD_VOY_NO " ).append("\n"); 
		query.append("               AND VSKD.SKD_DIR_CD   = BVVD.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND VSKD.VPS_PORT_CD  = BVVD.POD_CD" ).append("\n"); 
		query.append("               AND VSKD.CLPT_IND_SEQ = BVVD.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("             LEFT OUTER JOIN BKG_BL_ISS BISS ON (" ).append("\n"); 
		query.append("                BISS.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("             JOIN BKG_BL_DOC   BDOC ON (" ).append("\n"); 
		query.append("              BDOC.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("             JOIN BKG_CUSTOMER     SCST ON (" ).append("\n"); 
		query.append("                   SCST.BKG_NO         = BKGM.BKG_NO" ).append("\n"); 
		query.append("               AND SCST.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("             JOIN BKG_CUSTOMER     CCST ON (" ).append("\n"); 
		query.append("                   CCST.BKG_NO         = BKGM.BKG_NO" ).append("\n"); 
		query.append("               AND CCST.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("             JOIN BKG_CUSTOMER     NCST ON (" ).append("\n"); 
		query.append("                   NCST.BKG_NO         = BKGM.BKG_NO" ).append("\n"); 
		query.append("               AND NCST.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("             LEFT OUTER JOIN BKG_ARR_NTC      ANTC ON (" ).append("\n"); 
		query.append("                BKGM.BKG_NO = ANTC.BKG_NO " ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("             LEFT OUTER JOIN MDM_REP_CMDT     CMDT ON (" ).append("\n"); 
		query.append("                BKGM.REP_CMDT_CD = CMDT.REP_CMDT_CD" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("             LEFT OUTER JOIN  MDM_VSL_CNTR     CVSL ON (" ).append("\n"); 
		query.append("                BVVD.VSL_CD = CVSL.VSL_CD" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("             LEFT OUTER JOIN  BKG_DO_REF       BDRF ON (" ).append("\n"); 
		query.append("                BKGM.BKG_NO = BDRF.BKG_NO" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("             LEFT OUTER JOIN  BKG_HRD_CDG_CTNT BHDG ON (" ).append("\n"); 
		query.append("                    BHDG.HRD_CDG_ID  = 'IDA_DO_YD_CD' " ).append("\n"); 
		query.append("                AND BHDG.ATTR_CTNT1  = BDRF.IDA_DO_YD_CD" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("         WHERE BKGM.BKG_NO         = @[bkg_no]    -- INPUT PARAM        " ).append("\n"); 
		query.append("     ) SUBQ LEFT OUTER JOIN MDM_YARD YD " ).append("\n"); 
		query.append("                         ON ( YD.YD_CD  =  SUBQ.PKUP_YD_CD )-- Discharge Location" ).append("\n"); 
		query.append("            LEFT OUTER JOIN BKG_CSTMS_ANR_VVD  AVVD  -- ANRBS" ).append("\n"); 
		query.append("                         ON ( SUBQ.POD_CD = 'BEANR' AND AVVD.VSL_CD = SUBQ.VSL_CD" ).append("\n"); 
		query.append("                                                    AND AVVD.SKD_VOY_NO = SUBQ.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                    AND AVVD.SKD_DIR_CD = SUBQ.SKD_DIR_CD )" ).append("\n"); 
		query.append("            LEFT OUTER JOIN BKG_HRD_CDG_CTNT AHDG     -- ANRBS SUB CODE" ).append("\n"); 
		query.append("                         ON ( SUBQ.POD_CD = 'BEANR' AND AHDG.HRD_CDG_ID = 'ANR_CSTMS_BRTH_CD'" ).append("\n"); 
		query.append("                                                    AND AHDG.ATTR_CTNT2 = AVVD.BRTH_DESC )" ).append("\n"); 
		query.append("            LEFT OUTER JOIN BKG_CSTMS_RTM_VSL  RVVD  -- NLRTM" ).append("\n"); 
		query.append("                         ON ( SUBQ.POD_CD = 'NLRTM' AND RVVD.VSL_CD      = SUBQ.VSL_CD" ).append("\n"); 
		query.append("                                                    AND RVVD.SKD_VOY_NO  = SUBQ.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                    AND RVVD.SKD_DIR_CD  = SUBQ.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                    AND RVVD.VSL_CALL_REF_STS_CD <> 'C' )" ).append("\n"); 
		query.append("            LEFT OUTER JOIN BKG_CSTMS_CD_CONV_CTNT RCNV  -- NLRTM SUB" ).append("\n"); 
		query.append("                         ON ( SUBQ.POD_CD = 'NLRTM' AND RCNV.CNT_CD = 'NL'" ).append("\n"); 
		query.append("                                                    AND RCNV.CSTMS_DIV_ID = 'BERTH_CD'" ).append("\n"); 
		query.append("                                                    AND RCNV.ATTR_CTNT1 = RVVD.BRTH_CTNT)" ).append("\n"); 
		query.append("    WHERE VSL_SEQ=MAX_VSL_SEQ" ).append("\n"); 

	}
}