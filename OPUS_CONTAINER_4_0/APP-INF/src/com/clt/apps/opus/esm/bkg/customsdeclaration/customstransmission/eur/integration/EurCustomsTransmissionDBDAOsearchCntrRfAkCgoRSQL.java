/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOsearchCntrRfAkCgoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOsearchCntrRfAkCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container 정보 및 Reefer, Break bulk, Akward정보를 조회한다.
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOsearchCntrRfAkCgoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_spe_rd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOsearchCntrRfAkCgoRSQL").append("\n"); 
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
		query.append("SELECT TB.*" ).append("\n"); 
		query.append("      ,TO_CHAR(CNTRWGT_T + CNTRTRW_T, 'FM999999999999990.000') AS CNTRGWGT" ).append("\n"); 
		query.append("      ,TO_CHAR(CNTRWGT_T,             'FM999999999999990.000') AS CNTRWGT" ).append("\n"); 
		query.append("      ,TO_CHAR(CNTRTRW_T,             'FM999999999999990.000') AS CNTRTRW" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT BC.CNTR_NO   AS CNTRNBR" ).append("\n"); 
		query.append("      ,BC.PCK_TP_CD AS PUNIT" ).append("\n"); 
		query.append("      ,BC.PCK_QTY   AS PKG" ).append("\n"); 
		query.append("      ,BC.WGT_UT_CD AS CNTR_WGT_UNIT" ).append("\n"); 
		query.append("      ,DECODE(BC.WGT_UT_CD,'LBS',ROUND(NVL(BC.CNTR_WGT,0)*0.4536, 3),NVL(BC.CNTR_WGT,0)) AS CNTRWGT_T" ).append("\n"); 
		query.append("      ,(SELECT DECODE(NVL(S.TARE_WGT, 0), 0" ).append("\n"); 
		query.append("                                          , DECODE(NVL(MDM.CNTR_TPSZ_TARE_WGT, 0), 0" ).append("\n"); 
		query.append("                                          , DECODE(M.CNTR_TPSZ_CD, 'T2', 3600, 'T4', 5200, 0)" ).append("\n"); 
		query.append("                                          , MDM.CNTR_TPSZ_TARE_WGT)" ).append("\n"); 
		query.append("                                          , S.TARE_WGT  ) TARE_WGT" ).append("\n"); 
		query.append("          FROM MST_CONTAINER  M" ).append("\n"); 
		query.append("              ,MST_CNTR_SPEC  S" ).append("\n"); 
		query.append("              ,MDM_CNTR_TP_SZ MDM" ).append("\n"); 
		query.append("         WHERE M.CNTR_NO      = BC.CNTR_NO" ).append("\n"); 
		query.append("           AND M.CNTR_SPEC_NO = S.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("           AND M.CNTR_TPSZ_CD = MDM.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ) AS CNTRTRW_T" ).append("\n"); 
		query.append("      ,BC.CNTR_TPSZ_CD AS CNTRTYPE" ).append("\n"); 
		query.append("      ,(SELECT CNTR_SEAL_NO" ).append("\n"); 
		query.append("          FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("         WHERE BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("           AND CNTR_NO = BC.CNTR_NO" ).append("\n"); 
		query.append("           AND CNTR_SEAL_SEQ > 0" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) AS SEALNBR" ).append("\n"); 
		query.append("      ,DECODE(@[bkg_cgo_tp], 'F','F','M') AS FM_IND" ).append("\n"); 
		query.append("      ,BC.RC_FLG AS RF_IND" ).append("\n"); 
		query.append("      ,BC.DCGO_FLG AS DG_IND" ).append("\n"); 
		query.append("      ,BC.BB_CGO_FLG AS BK_IND" ).append("\n"); 
		query.append("      ,BC.AWK_CGO_FLG AS AK_IND" ).append("\n"); 
		query.append("      ,NVL(BAC.GRS_WGT, 0) AS OVWGT" ).append("\n"); 
		query.append("--      ,'' AS STWG_REQ" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL A" ).append("\n"); 
		query.append("              ,BKG_STWG_CGO    B" ).append("\n"); 
		query.append("         WHERE A.INTG_CD_ID = 'CD02146'" ).append("\n"); 
		query.append("           AND A.INTG_CD_VAL_CTNT = B.STWG_CD" ).append("\n"); 
		query.append("           AND TO_CHAR(SYSDATE, 'YYYYMMDD') BETWEEN A.APLY_ST_DT AND A.APLY_END_DT" ).append("\n"); 
		query.append("           AND B.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("        ) AS STWG_REQ" ).append("\n"); 
		query.append("      ,BRC.CDO_TEMP AS TEMP" ).append("\n"); 
		query.append("      ,DECODE(BRC.CDO_TEMP, NULL, '', 'C') AS TUNIT" ).append("\n"); 
		query.append("      ,DECODE(BRC.CNTR_VENT_TP_CD, 'P', BRC.VENT_RTO||' %', 'C', BRC.CBM_PER_HR_QTY||' CMH', '')  AS VENT" ).append("\n"); 
		query.append("      ,BC.MEAS_QTY   AS MEASURE" ).append("\n"); 
		query.append("      ,BC.MEAS_UT_CD AS MEASURE_UNIT" ).append("\n"); 
		query.append("      ,NVL(BC.RCV_TERM_CD,' ')||NVL(BC.DE_TERM_CD,' ') AS RDTYPE" ).append("\n"); 
		query.append("      ,@[cmdt_desc]  AS CMDT_DESC" ).append("\n"); 
		query.append("      ,@[cmdt_cd]    AS CMDT_CD" ).append("\n"); 
		query.append("      ,BKG_TOKEN_NL_FNC(NVL(BRC.DIFF_RMK,' '),0,'') AS RF_REMARK" ).append("\n"); 
		query.append("      ,@[bkg_spe_rd] AS RFDRY_IND" ).append("\n"); 
		query.append("      ,NVL(BAC.OVR_FWRD_LEN, 0) AS OVF" ).append("\n"); 
		query.append("      ,NVL(BAC.OVR_BKWD_LEN, 0) AS OVR" ).append("\n"); 
		query.append("      ,NVL(BAC.OVR_HGT, 0) AS OVH" ).append("\n"); 
		query.append("      ,NVL(BAC.OVR_LF_LEN, 0) AS OVLW" ).append("\n"); 
		query.append("      ,NVL(BAC.OVR_RT_LEN, 0) AS OVRW" ).append("\n"); 
		query.append("      ,BAC.WGT_UT_CD AS OVWGT_UNIT" ).append("\n"); 
		query.append("      ,NVL(BAC.OVR_VOID_SLT_QTY, 0) AS VOID_SLOT" ).append("\n"); 
		query.append("      ,NVL(BC.SOC_FLG,'N') AS SOCIND" ).append("\n"); 
		query.append("      ,'' AS HAULAGE" ).append("\n"); 
		query.append("      ,NVL(BBC.GRS_WGT, 0) AS BKWGT" ).append("\n"); 
		query.append("      ,BBC.WGT_UT_CD AS BKWGTU" ).append("\n"); 
		query.append("      ,NVL(BBC.DIM_WDT, 0) AS BKW" ).append("\n"); 
		query.append("      ,NVL(BBC.DIM_HGT, 0) AS BKH" ).append("\n"); 
		query.append("      ,NVL(BBC.DIM_LEN, 0) AS BKL" ).append("\n"); 
		query.append("      ,MC.OWNR_CO_CD AS CNTROWN" ).append("\n"); 
		query.append("      ,MC.LSTM_CD AS CNTRTRM" ).append("\n"); 
		query.append("      ,BC.CNTR_NO" ).append("\n"); 
		query.append("      ,(SELECT MAX( DECODE( NVL(INV.DMDT_AR_IF_CD,'N'),'Y',TO_CHAR(CALC.TO_MVMT_DT,'YYYYMMDD'),'N',TO_CHAR(CALC.FT_END_DT, 'YYYYMMDD')))" ).append("\n"); 
		query.append("          FROM DMT_CHG_BKG_CNTR BCNTR" ).append("\n"); 
		query.append("              ,DMT_CHG_CALC CALC" ).append("\n"); 
		query.append("              ,DMT_INV_MN INV" ).append("\n"); 
		query.append("        WHERE BCNTR.BKG_NO  = BC.BKG_NO" ).append("\n"); 
		query.append("          AND BCNTR.CNTR_NO = BC.CNTR_NO" ).append("\n"); 
		query.append("          AND CALC.SYS_AREA_GRP_ID         = BCNTR.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("          AND CALC.CNTR_NO                 = BCNTR.CNTR_NO" ).append("\n"); 
		query.append("          AND CALC.CNTR_CYC_NO             = BCNTR.CNTR_CYC_NO" ).append("\n"); 
		query.append("          AND CALC.DMDT_TRF_CD             IN ('DMIF', 'CTIC')" ).append("\n"); 
		query.append("          AND CALC.DMDT_CHG_LOC_DIV_CD NOT IN ('TSP', 'SZP')" ).append("\n"); 
		query.append("          AND CALC.DUL_TP_EXPT_FLG = 'N'" ).append("\n"); 
		query.append("          AND CALC.DMDT_INV_NO = INV.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("       ) AS NOD_DEM_FT" ).append("\n"); 
		query.append("      ,BC.CNTR_PRT_FLG AS PL_IND" ).append("\n"); 
		query.append("  FROM BKG_CONTAINER   BC" ).append("\n"); 
		query.append("      ,BKG_RF_CGO      BRC" ).append("\n"); 
		query.append("      ,BKG_AWK_CGO     BAC" ).append("\n"); 
		query.append("      ,BKG_BB_CGO      BBC" ).append("\n"); 
		query.append("      ,MST_CONTAINER   MC" ).append("\n"); 
		query.append("      ,MDM_CNTR_TP_SZ  MCTS" ).append("\n"); 
		query.append(" WHERE BC.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("   AND BC.BKG_NO       = BRC.BKG_NO       (+)" ).append("\n"); 
		query.append("   AND BC.CNTR_NO      = BRC.CNTR_NO      (+)" ).append("\n"); 
		query.append("   AND BC.BKG_NO       = BAC.BKG_NO       (+)" ).append("\n"); 
		query.append("   AND BC.CNTR_NO      = BAC.CNTR_NO      (+)" ).append("\n"); 
		query.append("   AND BC.BKG_NO       = BBC.BKG_NO       (+)" ).append("\n"); 
		query.append("   AND BC.CNTR_NO      = MC.CNTR_NO       (+)" ).append("\n"); 
		query.append("   AND BC.CNTR_TPSZ_CD = MCTS.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     ) TB" ).append("\n"); 

	}
}