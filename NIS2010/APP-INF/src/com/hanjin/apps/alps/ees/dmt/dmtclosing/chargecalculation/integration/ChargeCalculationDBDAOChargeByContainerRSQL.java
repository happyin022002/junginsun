/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeCalculationDBDAOChargeByContainerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOChargeByContainerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOChargeByContainerRSQL.Query
	  * </pre>
	  */
	public ChargeCalculationDBDAOChargeByContainerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_chg_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOChargeByContainerRSQL").append("\n"); 
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
		query.append("SELECT    C.SYS_AREA_GRP_ID                                                                                                                 AS SVR_ID" ).append("\n"); 
		query.append("        , C.CNTR_NO" ).append("\n"); 
		query.append("        , B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , C.CNTR_CYC_NO" ).append("\n"); 
		query.append("        , C.DMDT_TRF_CD" ).append("\n"); 
		query.append("        , C.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("        , DECODE(C.CHG_SEQ, 1, 'G', 'B')                                                                                                    AS CHG_TYPE" ).append("\n"); 
		query.append("        , C.CHG_SEQ" ).append("\n"); 
		query.append("        , C.DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("		,(" ).append("\n"); 
		query.append("			SELECT  CASE " ).append("\n"); 
		query.append("						WHEN NVL(MAX(DD.DMDT_DELT_RQST_STS_CD), 'N') IN ('C','N') THEN 'N'" ).append("\n"); 
		query.append("						WHEN 0 < MAX((	" ).append("\n"); 
		query.append("									SELECT  COUNT(1)" ).append("\n"); 
		query.append("									  FROM  DMT_CHG_DELT_PATH " ).append("\n"); 
		query.append("									 WHERE  SYS_AREA_GRP_ID     = DD.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("									   AND  CNTR_NO             = DD.CNTR_NO" ).append("\n"); 
		query.append("									   AND  CNTR_CYC_NO         = DD.CNTR_CYC_NO" ).append("\n"); 
		query.append("									   AND  DMDT_TRF_CD         = DD.DMDT_TRF_CD" ).append("\n"); 
		query.append("									   AND  DMDT_CHG_LOC_DIV_CD = DD.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("									   AND  CHG_SEQ             = DD.CHG_SEQ" ).append("\n"); 
		query.append("									   AND  CHG_OFC_CD          = DD.CHG_OFC_CD" ).append("\n"); 
		query.append("									   AND  DELT_SEQ            = DD.DELT_SEQ" ).append("\n"); 
		query.append("									   AND  CHG_DELT_PATH_LVL  >=" ).append("\n"); 
		query.append("											(" ).append("\n"); 
		query.append("												SELECT  max(CHG_DELT_PATH_LVL)" ).append("\n"); 
		query.append("												  FROM  DMT_CHG_DELT_PATH" ).append("\n"); 
		query.append("												 WHERE  SYS_AREA_GRP_ID        = DD.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("												   AND  CNTR_NO                = DD.CNTR_NO" ).append("\n"); 
		query.append("												   AND  CNTR_CYC_NO            = DD.CNTR_CYC_NO" ).append("\n"); 
		query.append("												   AND  DMDT_TRF_CD            = DD.DMDT_TRF_CD" ).append("\n"); 
		query.append("												   AND  DMDT_CHG_LOC_DIV_CD    = DD.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("												   AND  CHG_SEQ                = DD.CHG_SEQ" ).append("\n"); 
		query.append("												   AND  CHG_OFC_CD             = DD.CHG_OFC_CD" ).append("\n"); 
		query.append("												   AND  DELT_SEQ               = DD.DELT_SEQ" ).append("\n"); 
		query.append("												   AND  CHG_DELT_PATH_CPLS_FLG = 'Y'" ).append("\n"); 
		query.append("											)" ).append("\n"); 
		query.append("									   and  CHG_DELT_STS_CD = 'A'" ).append("\n"); 
		query.append("								 )) THEN 'X'		--// Charge Deletion 요청 불가, Charge Deletion Cancel 불가" ).append("\n"); 
		query.append("						ELSE MAX(DD.DMDT_DELT_RQST_STS_CD)" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("						" ).append("\n"); 
		query.append("			  FROM  DMT_CHG_DELT_RQST_APRO DD" ).append("\n"); 
		query.append("			 WHERE  DD.SYS_AREA_GRP_ID     = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("			   AND	DD.CNTR_NO		       = C.CNTR_NO" ).append("\n"); 
		query.append("			   AND	DD.CNTR_CYC_NO		   = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("			   AND	DD.DMDT_TRF_CD		   = C.DMDT_TRF_CD" ).append("\n"); 
		query.append("			   AND	DD.DMDT_CHG_LOC_DIV_CD = C.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("			   AND	DD.CHG_SEQ			   = C.CHG_SEQ" ).append("\n"); 
		query.append("			   AND  DD.DELT_SEQ            = " ).append("\n"); 
		query.append("					( " ).append("\n"); 
		query.append("						SELECT  NVL(MAX(DS.DELT_SEQ), 0) " ).append("\n"); 
		query.append("						  FROM  DMT_CHG_DELT_RQST_APRO DS" ).append("\n"); 
		query.append("						 WHERE  DS.SYS_AREA_GRP_ID     = DD.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("						   AND  DS.CNTR_NO	           = DD.CNTR_NO" ).append("\n"); 
		query.append("						   AND  DS.CNTR_CYC_NO	       = DD.CNTR_CYC_NO" ).append("\n"); 
		query.append("						   AND  DS.DMDT_TRF_CD	       = DD.DMDT_TRF_CD" ).append("\n"); 
		query.append("						   AND  DS.DMDT_CHG_LOC_DIV_CD = DD.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("						   AND  DS.CHG_SEQ		       = DD.CHG_SEQ" ).append("\n"); 
		query.append("						   AND  DS.CHG_OFC_CD          = DD.CHG_OFC_CD  " ).append("\n"); 
		query.append("						   AND  DS.DMDT_DELT_RQST_STS_CD != 'C' " ).append("\n"); 
		query.append("					)  " ).append("\n"); 
		query.append("		 ) 																																   AS DMDT_DELT_RQST_STS_CD" ).append("\n"); 
		query.append("        ," ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT  ( SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("                        FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("                       WHERE INTG_CD_ID = 'CD03382' " ).append("\n"); 
		query.append("                         AND INTG_CD_VAL_CTNT = DD.DMDT_DELT_RQST_STS_CD ) AS INACT_STS_NM" ).append("\n"); 
		query.append("			  FROM  DMT_CHG_DELT_RQST_APRO DD" ).append("\n"); 
		query.append("			 WHERE  DD.SYS_AREA_GRP_ID     = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("			   AND	DD.CNTR_NO		       = C.CNTR_NO" ).append("\n"); 
		query.append("			   AND	DD.CNTR_CYC_NO		   = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("			   AND	DD.DMDT_TRF_CD		   = C.DMDT_TRF_CD" ).append("\n"); 
		query.append("			   AND	DD.DMDT_CHG_LOC_DIV_CD = C.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("			   AND	DD.CHG_SEQ			   = C.CHG_SEQ" ).append("\n"); 
		query.append("			   AND  DD.DELT_SEQ            =" ).append("\n"); 
		query.append("					( " ).append("\n"); 
		query.append("						SELECT  NVL(MAX(DS.DELT_SEQ), 0) " ).append("\n"); 
		query.append("						  FROM  DMT_CHG_DELT_RQST_APRO DS" ).append("\n"); 
		query.append("						 WHERE  DS.SYS_AREA_GRP_ID     = DD.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("						   AND  DS.CNTR_NO	           = DD.CNTR_NO" ).append("\n"); 
		query.append("						   AND  DS.CNTR_CYC_NO	       = DD.CNTR_CYC_NO" ).append("\n"); 
		query.append("						   AND  DS.DMDT_TRF_CD	       = DD.DMDT_TRF_CD" ).append("\n"); 
		query.append("						   AND  DS.DMDT_CHG_LOC_DIV_CD = DD.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("						   AND  DS.CHG_SEQ		       = DD.CHG_SEQ" ).append("\n"); 
		query.append("						   AND  DS.CHG_OFC_CD          = DD.CHG_OFC_CD  " ).append("\n"); 
		query.append("						   AND  DS.DMDT_DELT_RQST_STS_CD != 'C'" ).append("\n"); 
		query.append("					)  " ).append("\n"); 
		query.append("		 ) AS INACT_STS_NM" ).append("\n"); 
		query.append("		," ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("        SELECT  INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("        FROM    COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE   INTG_CD_ID          = 'CD01967'" ).append("\n"); 
		query.append("        AND	    INTG_CD_VAL_CTNT    = C.DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("        )                                                                                                                                  AS DMDT_CHG_STS_DESC" ).append("\n"); 
		query.append("        , B.BKG_NO" ).append("\n"); 
		query.append("        , B.BL_NO" ).append("\n"); 
		query.append("        , C.DMDT_INV_NO" ).append("\n"); 
		query.append("        , IM.DMDT_AR_IF_CD" ).append("\n"); 
		query.append("        , B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD                                                                                          AS VVD_CD" ).append("\n"); 
		query.append("        , TO_CHAR(V.VPS_ETA_DT,'YYYY-MM-DD')                                                                                                AS VPS_ETA_DT" ).append("\n"); 
		query.append("        , TO_CHAR(V.VPS_ETB_DT,'YYYY-MM-DD')                                                                                                AS VPS_ETB_DT" ).append("\n"); 
		query.append("        , TO_CHAR(V.VPS_ETD_DT,'YYYY-MM-DD')                                                                                                AS VPS_ETD_DT    " ).append("\n"); 
		query.append("        , BK.PRE_RLY_PORT_CD" ).append("\n"); 
		query.append("        , BK.PST_RLY_PORT_CD" ).append("\n"); 
		query.append("        , B.POR_CD" ).append("\n"); 
		query.append("        , B.POL_CD" ).append("\n"); 
		query.append("        , B.POD_CD" ).append("\n"); 
		query.append("        , B.DEL_CD" ).append("\n"); 
		query.append("        , B.BKG_RCV_TERM_CD || '/' || B.BKG_DE_TERM_CD                                                                                      AS RD_TERM_CD    " ).append("\n"); 
		query.append("        ," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT	/*+ INDEX_DESC(BKG_EUR_TRO XPKBKG_EUR_TRO) */" ).append("\n"); 
		query.append("                NVL(HLG_TP_CD, 'N')" ).append("\n"); 
		query.append("        FROM	BKG_EUR_TRO" ).append("\n"); 
		query.append("        WHERE	BKG_NO              = B.BKG_NO" ).append("\n"); 
		query.append("        AND     IO_BND_CD           = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("        AND     NVL(CXL_FLG, 'N')   = 'N'" ).append("\n"); 
		query.append("        AND     CNTR_NO	            = C.CNTR_NO" ).append("\n"); 
		query.append("        AND     ROWNUM              = 1" ).append("\n"); 
		query.append("        )                                                                                                                                   AS CH    " ).append("\n"); 
		query.append("        , B.SC_NO" ).append("\n"); 
		query.append("        , B.RFA_NO" ).append("\n"); 
		query.append("        , DECODE( BK.AGMT_ACT_CNT_CD||TRIM(TO_CHAR(BK.AGMT_ACT_CUST_SEQ, '000000')),'000000', NULL" ).append("\n"); 
		query.append("                 ,BK.AGMT_ACT_CNT_CD||TRIM(TO_CHAR(BK.AGMT_ACT_CUST_SEQ, '000000')) )                                                       AS ACUST" ).append("\n"); 
		query.append("        , B.CMDT_CD" ).append("\n"); 
		query.append("        ," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  CMDT_NM" ).append("\n"); 
		query.append("        FROM    MDM_COMMODITY" ).append("\n"); 
		query.append("        WHERE   CMDT_CD     = B.CMDT_CD" ).append("\n"); 
		query.append("        )                                                                                                                                   AS CMDT_NM" ).append("\n"); 
		query.append("        , B.REP_CMDT_CD" ).append("\n"); 
		query.append("        ," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  REP_CMDT_NM" ).append("\n"); 
		query.append("        FROM    MDM_REP_CMDT" ).append("\n"); 
		query.append("        WHERE   REP_CMDT_CD = B.REP_CMDT_CD" ).append("\n"); 
		query.append("        )                                                                                                                                   AS REP_CMDT_NM" ).append("\n"); 
		query.append("        , B.SLS_OFC_CD" ).append("\n"); 
		query.append("        ," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  BDD.EVNT_OFC_CD" ).append("\n"); 
		query.append("        FROM    BKG_DO     BDO," ).append("\n"); 
		query.append("                BKG_DO_DTL BDD" ).append("\n"); 
		query.append("        WHERE   BDO.BKG_NO          = BDD.BKG_NO" ).append("\n"); 
		query.append("        AND     BDO.BKG_NO          = B.BKG_NO" ).append("\n"); 
		query.append("        AND     BDD.RLSE_STS_CD IN ('R', 'I')" ).append("\n"); 
		query.append("        AND     ROWNUM              = 1" ).append("\n"); 
		query.append("        )                                                                                                                                   AS RLSE_OFC" ).append("\n"); 
		query.append("        , TO_CHAR((" ).append("\n"); 
		query.append("            SELECT  BDD.EVNT_DT" ).append("\n"); 
		query.append("            FROM    BKG_DO     BDO," ).append("\n"); 
		query.append("                    BKG_DO_DTL BDD" ).append("\n"); 
		query.append("            WHERE   BDO.BKG_NO        = BDD.BKG_NO" ).append("\n"); 
		query.append("            AND     BDO.BKG_NO        = B.BKG_NO" ).append("\n"); 
		query.append("            AND     BDD.RLSE_STS_CD IN ('R', 'I')" ).append("\n"); 
		query.append("            AND     ROWNUM = 1" ).append("\n"); 
		query.append("            ), 'YYYY-MM-DD HH24:MI')                                                                                                        AS RLSE_DT" ).append("\n"); 
		query.append("        , C.OFC_CD" ).append("\n"); 
		query.append("        , C.OFC_RHQ_CD" ).append("\n"); 
		query.append("        , TO_CHAR(C.FM_MVMT_DT, 'YYYY-MM-DD')                                                                                               AS FM_MVMT_DT" ).append("\n"); 
		query.append("        , TO_CHAR(C.TO_MVMT_DT, 'YYYY-MM-DD')                                                                                               AS TO_MVMT_DT" ).append("\n"); 
		query.append(" 		, TO_CHAR(C.FM_MVMT_DT, 'HH24:MI')                                                                                               	AS FM_MVMT_DT_TIME" ).append("\n"); 
		query.append("        , TO_CHAR(C.TO_MVMT_DT, 'HH24:MI')                                                                                               	AS TO_MVMT_DT_TIME" ).append("\n"); 
		query.append("        , C.FM_MVMT_YD_CD" ).append("\n"); 
		query.append("        , C.TO_MVMT_YD_CD" ).append("\n"); 
		query.append("        , C.FM_MVMT_STS_CD" ).append("\n"); 
		query.append("        , C.TO_MVMT_STS_CD" ).append("\n"); 
		query.append("        , C.WEB_IND_FLG" ).append("\n"); 
		query.append("        , DECODE(C.WEB_IND_FLG, 'Y', TO_CHAR(NVL(C.WEB_MTY_DT, C.TO_MVMT_DT), 'YYYY-MM-DD'), TO_CHAR(C.WEB_MTY_DT, 'YYYY-MM-DD'))           AS WEB_MTY_DT" ).append("\n"); 
		query.append("        , DECODE(C.WEB_IND_FLG, 'Y', TO_CHAR(NVL(C.FT_END_DT, C.TO_MVMT_DT) + 7, 'YYYY-MM-DD'), TO_CHAR(C.FT_END_DT + 7, 'YYYY-MM-DD'))   AS GRACE_END_DT" ).append("\n"); 
		query.append("        , TO_CHAR(C.FT_CMNC_DT, 'YYYY-MM-DD') FT_CMNC_DT" ).append("\n"); 
		query.append("        , TO_CHAR(C.FT_END_DT, 'YYYY-MM-DD') FT_END_DT" ).append("\n"); 
		query.append("        , C.FT_DYS" ).append("\n"); 
		query.append("        , C.FX_FT_OVR_DYS" ).append("\n"); 
		query.append("	    -- 조건추가(S) 2013.12.13" ).append("\n"); 
		query.append("		, TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(NVL(C.TO_MVMT_DT, C.FT_END_DT), 'YYYYMMDD'), 'YYYYMMDD') AS OVR_DUE" ).append("\n"); 
		query.append("        -- 조건추가(E)" ).append("\n"); 
		query.append("		, C.ORG_FT_OVR_DYS" ).append("\n"); 
		query.append("        , DECODE(B.DMDT_CNTR_TP_CD, 'D', 'DRY', 'R', 'REEFER', 'F', 'FLAT RACK', 'O', 'OPEN TOP', 'T', 'TANK', 'S', 'S.Open Top', 'A', 'A.Flatrack') AS DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append("        , B.DMDT_BKG_CGO_TP_CD   " ).append("\n"); 
		query.append("        , C.AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("        , C.BIL_AMT" ).append("\n"); 
		query.append("        , C.CORR_RMK" ).append("\n"); 
		query.append("        , C.BZC_TRF_SEQ" ).append("\n"); 
		query.append("        , NVL(C.BZC_DMDT_DE_TERM_CD, 'N')                                                                                                   AS BZC_DMDT_DE_TERM_CD " ).append("\n"); 
		query.append("        , C.BZC_TRF_GRP_SEQ" ).append("\n"); 
		query.append("        , C.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("        , C.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("        , C.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("        , C.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("        , C.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("        , C.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("        , C.FX_FT_OVR_DYS" ).append("\n"); 
		query.append("        , C.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("        , C.DMDT_TRF_APLY_TP_CD" ).append("\n"); 
		query.append("        ," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("        WHEN C.DMDT_TRF_APLY_TP_CD='G' THEN" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  DECODE(C.DMDT_CHG_LOC_DIV_CD, 'TSP', 'N|N|N', XCLD_SAT_FLG || '|' || XCLD_SUN_FLG || '|' ||XCLD_HOL_FLG) " ).append("\n"); 
		query.append("                FROM    DMT_TRF_GRP" ).append("\n"); 
		query.append("                WHERE   SYS_AREA_GRP_ID     = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                AND     DMDT_TRF_CD         = C.DMDT_TRF_CD" ).append("\n"); 
		query.append("                AND     TRF_SEQ             = C.BZC_TRF_SEQ" ).append("\n"); 
		query.append("                AND     DMDT_DE_TERM_CD     = NVL(C.BZC_DMDT_DE_TERM_CD, 'N')" ).append("\n"); 
		query.append("                AND     TRF_GRP_SEQ         = C.BZC_TRF_GRP_SEQ" ).append("\n"); 
		query.append("                )        " ).append("\n"); 
		query.append("        WHEN C.DMDT_TRF_APLY_TP_CD='B' THEN" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  DECODE(C.DMDT_CHG_LOC_DIV_CD, 'TSP', 'N|N|N', XCLD_SAT_FLG || '|' || XCLD_SUN_FLG || '|' ||XCLD_HOL_FLG) " ).append("\n"); 
		query.append("                FROM    DMT_RFA_EXPT_TRF_DTL" ).append("\n"); 
		query.append("                WHERE   RFA_EXPT_DAR_NO     = C.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("                AND     RFA_EXPT_MAPG_SEQ   = C.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("                AND     RFA_EXPT_VER_SEQ    = C.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("                AND     RFA_RQST_DTL_SEQ    = C.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("                AND     CVRG_CMB_SEQ        = 1" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        WHEN C.DMDT_TRF_APLY_TP_CD='S' THEN" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  DECODE(C.DMDT_CHG_LOC_DIV_CD, 'TSP', 'N|N|N', XCLD_SAT_FLG || '|' || XCLD_SUN_FLG || '|' ||XCLD_HOL_FLG) " ).append("\n"); 
		query.append("                FROM    DMT_SC_EXPT_GRP S," ).append("\n"); 
		query.append("                        PRI_SP_HDR      H" ).append("\n"); 
		query.append("                WHERE   S.PROP_NO           = H.PROP_NO" ).append("\n"); 
		query.append("                AND     H.SC_NO             = C.SC_NO" ).append("\n"); 
		query.append("                AND     S.SC_EXPT_VER_SEQ   = C.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("                AND     S.SC_EXPT_GRP_SEQ   = C.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        END" ).append("\n"); 
		query.append("        )                                                                                                                                           AS XCLD_FLGS" ).append("\n"); 
		query.append("        , BS.CUST_CNT_CD || TRIM(TO_CHAR(BS.CUST_SEQ, '000000'))                                                                                    AS SHIPPER_CD" ).append("\n"); 
		query.append("        , REPLACE(BS.CUST_NM, CHR(13) || CHR(10), ' ')                                                                                              AS SHIPPER_NM" ).append("\n"); 
		query.append("        , DECODE(BC.CUST_CNT_CD || TRIM(TO_CHAR(BC.CUST_SEQ, '000000')), '000000', NULL, BC.CUST_CNT_CD || TRIM(TO_CHAR(BC.CUST_SEQ, '000000')))    AS CNEE_CD" ).append("\n"); 
		query.append("        , REPLACE(BC.CUST_NM, CHR(13) || CHR(10), ' ')                                                                                              AS CNEE_NM" ).append("\n"); 
		query.append("        , DECODE(BN.CUST_CNT_CD || TRIM(TO_CHAR(BN.CUST_SEQ, '000000')), '000000', NULL, BN.CUST_CNT_CD || TRIM(TO_CHAR(BN.CUST_SEQ, '000000')))    AS NTFY_CD" ).append("\n"); 
		query.append("        , NVL(RTRIM(REPLACE(REPLACE(BN.CUST_NM, CHR(34), ''), CHR(13)||CHR(10), ' ')), '-')                                                         AS NTFY_NM" ).append("\n"); 
		query.append("        , DECODE(TRIM(TO_CHAR(C.VNDR_SEQ, '000000')), '000000', NULL, TRIM(TO_CHAR(C.VNDR_SEQ, '000000')))                                          AS SVC_PROVDR_CD" ).append("\n"); 
		query.append("        , MV.VNDR_LGL_ENG_NM SVC_PROVDR_NM" ).append("\n"); 
		query.append("        , C.OFC_TRNS_FLG" ).append("\n"); 
		query.append("        ," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  'C'" ).append("\n"); 
		query.append("        FROM    DUAL" ).append("\n"); 
		query.append("        WHERE   EXISTS  (" ).append("\n"); 
		query.append("                        SELECT  1" ).append("\n"); 
		query.append("                        FROM    BKG_ROLL_OVR R" ).append("\n"); 
		query.append("                        WHERE   R.BKG_NO            = B.BKG_NO" ).append("\n"); 
		query.append("                        AND     R.ROLL_OVR_RSN_CD   IN ( 'C','H' )" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("        )                                               AS ROLL_OVR" ).append("\n"); 
		query.append("        , C.DUL_TP_EXPT_FLG" ).append("\n"); 
		query.append("        , C.CXL_BKG_CHG_FLG" ).append("\n"); 
		query.append("        , NVL(IM.CRE_OFC_CD, C.OFC_CD)                  AS CRE_OFC_CD" ).append("\n"); 
		query.append("#if (${est_mk} != 'P') " ).append("\n"); 
		query.append("        , E.EXPT_DYS" ).append("\n"); 
		query.append("        , E.EXPT_COST_AMT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        , NVL(C.UCLM_FLG, 'N') AS UCLM_FLG" ).append("\n"); 
		query.append("        , TO_CHAR(C.BZC_TRF_APLY_DT    , 'YYYY-MM-DD')    AS BZC_TRF_APLY_DT" ).append("\n"); 
		query.append("        , TO_CHAR(C.SC_RFA_EXPT_APLY_DT, 'YYYY-MM-DD')    AS SC_RFA_EXPT_APLY_DT" ).append("\n"); 
		query.append("        , NVL(C.SC_RFA_EXPT_AMT, 0)                       AS SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append("		, DECODE((SELECT COUNT(A.CNTR_NO)" ).append("\n"); 
		query.append("    			FROM DMT_CHG_CALC A, " ).append("\n"); 
		query.append("        		DMT_CHG_DELT_RQST_APRO B" ).append("\n"); 
		query.append("    		WHERE A.SYS_AREA_GRP_ID=B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("        		AND A.CNTR_NO=B.CNTR_NO" ).append("\n"); 
		query.append("       			AND A.CNTR_CYC_NO=B.CNTR_CYC_NO" ).append("\n"); 
		query.append("        		AND A.DMDT_TRF_CD=B.DMDT_TRF_CD" ).append("\n"); 
		query.append("        		AND A.DMDT_CHG_LOC_DIV_CD=B.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("        		AND A.CHG_SEQ=B.CHG_SEQ" ).append("\n"); 
		query.append("		        AND A.CNTR_NO=@[cntr_no]" ).append("\n"); 
		query.append("		        AND A.CNTR_CYC_NO=@[cntr_cyc_no]" ).append("\n"); 
		query.append("		        AND A.DMDT_TRF_CD=@[dmdt_trf_cd]" ).append("\n"); 
		query.append("		        AND (DMDT_CHG_STS_CD='D'" ).append("\n"); 
		query.append("		            OR DMDT_DELT_RQST_STS_CD " ).append("\n"); 
		query.append("        		        IN('B', 'Q', 'H', 'R')" ).append("\n"); 
		query.append("		        )" ).append("\n"); 
		query.append("	    ), 0, 'N', 'Y') AS DR_CANCEL_BTN_FLG" ).append("\n"); 
		query.append("		,C.ORG_CHG_AMT" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	#if (${est_mk} == 'P') " ).append("\n"); 
		query.append("          DMT_CHG_PRE_CALC_BKG_CNTR  B" ).append("\n"); 
		query.append("        , DMT_CHG_PRE_CALC           C" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("          DMT_CHG_BKG_CNTR           B" ).append("\n"); 
		query.append("        , DMT_CHG_CALC               C" ).append("\n"); 
		query.append("        , DMT_EXPT_CHG_CALC          E" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("        , VSK_VSL_PORT_SKD           V" ).append("\n"); 
		query.append("        , DMT_INV_MN                 IM" ).append("\n"); 
		query.append("        , BKG_BOOKING                BK" ).append("\n"); 
		query.append("        , MDM_VENDOR                 MV" ).append("\n"); 
		query.append("        , BKG_CUSTOMER               BS" ).append("\n"); 
		query.append("        , BKG_CUSTOMER               BC" ).append("\n"); 
		query.append("        , BKG_CUSTOMER               BN" ).append("\n"); 
		query.append("WHERE	1=1" ).append("\n"); 
		query.append("AND     B.SYS_AREA_GRP_ID       = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND     B.CNTR_NO               = C.CNTR_NO" ).append("\n"); 
		query.append("AND     B.CNTR_CYC_NO           = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND     B.BKG_NO                = BK.BKG_NO" ).append("\n"); 
		query.append("AND     B.VSL_CD                = V.VSL_CD(+)" ).append("\n"); 
		query.append("AND     B.SKD_VOY_NO            = V.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND     B.SKD_DIR_CD            = V.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND     DECODE(SUBSTR(@[dmdt_trf_cd], 3, 1),'I', B.POD_CD, B.POL_CD) =	V.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("AND     C.VNDR_SEQ              = MV.VNDR_SEQ          (+)" ).append("\n"); 
		query.append("AND     C.DMDT_INV_NO           = IM.DMDT_INV_NO       (+)" ).append("\n"); 
		query.append("AND     B.BKG_NO                = BS.BKG_NO            (+)" ).append("\n"); 
		query.append("AND     'S'                     = BS.BKG_CUST_TP_CD    (+)" ).append("\n"); 
		query.append("AND     B.BKG_NO                = BC.BKG_NO            (+)" ).append("\n"); 
		query.append("AND     'C'                     = BC.BKG_CUST_TP_CD    (+)" ).append("\n"); 
		query.append("AND     B.BKG_NO                = BN.BKG_NO            (+)" ).append("\n"); 
		query.append("AND     'N'                     = BN.BKG_CUST_TP_CD    (+)" ).append("\n"); 
		query.append("AND     C.SYS_AREA_GRP_ID       = @[svr_id]" ).append("\n"); 
		query.append("AND     C.CNTR_NO               = @[cntr_no]" ).append("\n"); 
		query.append("AND     C.CNTR_CYC_NO           = @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND     C.DMDT_TRF_CD           = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND     C.DMDT_CHG_LOC_DIV_CD   = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND     C.CHG_SEQ               = @[chg_seq]" ).append("\n"); 
		query.append("AND     NOT (C.DUL_TP_EXPT_FLG  = 'Y' AND SUBSTR(C.DMDT_TRF_CD, 1, 1) = 'D')" ).append("\n"); 
		query.append("AND     C.DMDT_CHG_LOC_DIV_CD  <> 'SZP'" ).append("\n"); 
		query.append("#if (${est_mk} != 'P') " ).append("\n"); 
		query.append("AND     C.CNTR_NO               = E.CNTR_NO             (+)" ).append("\n"); 
		query.append("AND     C.CNTR_CYC_NO           = E.CNTR_CYC_NO         (+)" ).append("\n"); 
		query.append("AND     C.DMDT_TRF_CD           = E.DMDT_TRF_CD         (+)" ).append("\n"); 
		query.append("AND     C.DMDT_CHG_LOC_DIV_CD   = E.DMDT_CHG_LOC_DIV_CD (+)" ).append("\n"); 
		query.append("AND     C.CHG_SEQ               = E.CHG_SEQ             (+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}