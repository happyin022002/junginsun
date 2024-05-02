/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOsearchCntrRfAkCgoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
	  * 
	  * 1. 2010.12.27 이수진 [CHM-201007774] EUR 24HR 관련 구주 세관 시스템 MRN 정보 추가 요청
	  *    : MRN  정보, NOD_DEMURRAGE_FREETIME 정보 추가
	  * 
	  * 2. 2011.01.25 이수진 [CHM-201007774] EUR 24HR 관련 구주 세관 시스템 MRN 정보 추가 요청
	  *    : NOD_DEMURRAGE_FREETIME 항목의 TYPE을 'YYYYMMDD'로 변경
	  * 
	  * 3. 2011.4.1 경종윤 [CHM-201007774] EUR 24HR 관련 구주 세관 시스템 MRN 정보 추가 요청
	  *    : MRN정보 제거
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
		params.put("bkg_spe_dg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_spe_ak",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_spe_bb",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_spe_rf",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("    BC.CNTR_NO CNTRNBR " ).append("\n"); 
		query.append("    ,BC.PCK_TP_CD PUNIT " ).append("\n"); 
		query.append("    ,BC.PCK_QTY PKG " ).append("\n"); 
		query.append("    ,BC.WGT_UT_CD CNTR_WGT_UNIT " ).append("\n"); 
		query.append("	,DECODE(NVL(BC.WGT_UT_CD,' '),'LBS',ROUND(NVL(BC.CNTR_WGT,0)*0.4536,2),NVL(BC.CNTR_WGT,0)) CNTRWGT" ).append("\n"); 
		query.append("    ,'' CNTRGWGT " ).append("\n"); 
		query.append("    ,(	" ).append("\n"); 
		query.append("        SELECT DECODE(NVL(S.TARE_WGT, 0), 0" ).append("\n"); 
		query.append("                                        , DECODE(NVL(MDM.CNTR_TPSZ_TARE_WGT, 0), 0" ).append("\n"); 
		query.append("                                        , DECODE(M.CNTR_TPSZ_CD, 'T2', 3600, 'T4', 5200, 0) " ).append("\n"); 
		query.append("                                        , MDM.CNTR_TPSZ_TARE_WGT)" ).append("\n"); 
		query.append("                                        , S.TARE_WGT  ) TARE_WGT" ).append("\n"); 
		query.append("        FROM MST_CONTAINER M, MST_CNTR_SPEC S, MDM_CNTR_TP_SZ MDM" ).append("\n"); 
		query.append("        WHERE M.CNTR_NO           =   BC.CNTR_NO" ).append("\n"); 
		query.append("        AND   M.CNTR_SPEC_NO      =   S.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("        AND   M.CNTR_TPSZ_CD      =   MDM.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    ) CNTRTRW " ).append("\n"); 
		query.append("    ,BC.CNTR_TPSZ_CD CNTRTYPE " ).append("\n"); 
		query.append("	,TO_CHAR(BC.VGM_VRFY_DT,'YYYYMMDDHH24MI') VGM_VRFY_DT" ).append("\n"); 
		query.append("	,DECODE(NVL(BC.VGM_WGT_UT_CD, 0), 'LBS', ROUND (NVL(BC.VGM_WGT, 0)*0.4536, 3), NVL(BC.VGM_WGT, 0)) VGM_WGT" ).append("\n"); 
		query.append("	,'KGS' VGM_WGT_UT_CD" ).append("\n"); 
		query.append("	,BC.VGM_VRFY_SIG_CTNT" ).append("\n"); 
		query.append("    ,BC.VGM_MZD_TP_CD" ).append("\n"); 
		query.append("	,(" ).append("\n"); 
		query.append("        SELECT CNTR_SEAL_NO" ).append("\n"); 
		query.append("        FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("        WHERE BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("        AND CNTR_NO = BC.CNTR_NO" ).append("\n"); 
		query.append("        AND CNTR_SEAL_SEQ > 0" ).append("\n"); 
		query.append("        AND ROWNUM = 1" ).append("\n"); 
		query.append("     ) SEALNBR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,DECODE(@[bkg_cgo_tp], 'F','F','M') FM_IND " ).append("\n"); 
		query.append("    ,@[bkg_spe_rf] RF_IND " ).append("\n"); 
		query.append("    ,@[bkg_spe_dg] DG_IND " ).append("\n"); 
		query.append("    ,@[bkg_spe_ak] AK_IND " ).append("\n"); 
		query.append("    ,@[bkg_spe_bb] BK_IND " ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("    --,BC.MEAS_UT_CD MEASURE " ).append("\n"); 
		query.append("    ,NVL(BAC.GRS_WGT, 0) OVWGT " ).append("\n"); 
		query.append("    ,'' STWG_REQ " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ,NVL(BRC.CDO_TEMP, 0) TEMP " ).append("\n"); 
		query.append("    ,'C' TUNIT " ).append("\n"); 
		query.append("    ,'' VENT -- BRC.CNTR_VENT_CD VENT (요놈 필드 없음)" ).append("\n"); 
		query.append("    ,BC.MEAS_QTY  MEASURE" ).append("\n"); 
		query.append("    ,BC.MEAS_UT_CD MEASURE_UNIT " ).append("\n"); 
		query.append("    ,NVL(BC.RCV_TERM_CD,' ')||NVL(BC.DE_TERM_CD,' ') RDTYPE " ).append("\n"); 
		query.append("    ,@[cmdt_desc] CMDT_DESC " ).append("\n"); 
		query.append("    ,@[cmdt_cd] CMDT_CD " ).append("\n"); 
		query.append("    ,REPLACE(NVL(BRC.DIFF_RMK,' '),CHR(13)||CHR(10),' ') AS RF_REMARK " ).append("\n"); 
		query.append("    ,@[bkg_spe_rd] RFDRY_IND " ).append("\n"); 
		query.append("    ,NVL(BAC.OVR_FWRD_LEN, 0) OVF " ).append("\n"); 
		query.append("    ,NVL(BAC.OVR_BKWD_LEN, 0) OVR " ).append("\n"); 
		query.append("    ,NVL(BAC.OVR_HGT, 0) OVH " ).append("\n"); 
		query.append("    ,NVL(BAC.OVR_LF_LEN, 0) OVLW " ).append("\n"); 
		query.append("    ,NVL(BAC.OVR_RT_LEN, 0) OVRW " ).append("\n"); 
		query.append("    ,BAC.WGT_UT_CD OVWGT_UNIT " ).append("\n"); 
		query.append("    ,NVL(BAC.OVR_VOID_SLT_QTY, 0) VOID_SLOT " ).append("\n"); 
		query.append("    ,NVL(BC.SOC_FLG,'N') SOCIND " ).append("\n"); 
		query.append("    ,'' HAULAGE " ).append("\n"); 
		query.append("    ,NVL(BBC.GRS_WGT, 0) BKWGT " ).append("\n"); 
		query.append("    ,BBC.WGT_UT_CD BKWGTU " ).append("\n"); 
		query.append("    ,NVL(BBC.DIM_WDT, 0) BKW " ).append("\n"); 
		query.append("    ,NVL(BBC.DIM_HGT, 0) BKH " ).append("\n"); 
		query.append("    ,NVL(BBC.DIM_LEN, 0) BKL " ).append("\n"); 
		query.append("    ,MC.OWNR_CO_CD CNTROWN " ).append("\n"); 
		query.append("    ,MC.LSTM_CD CNTRTRM " ).append("\n"); 
		query.append("    ,BC.CNTR_NO " ).append("\n"); 
		query.append("    ,(SELECT MAX( DECODE( NVL(INV.DMDT_AR_IF_CD,'N'),'Y',TO_CHAR(CALC.TO_MVMT_DT,'YYYYMMDD'),'N',TO_CHAR(CALC.FT_END_DT, 'YYYYMMDD')))           " ).append("\n"); 
		query.append("        FROM DMT_CHG_BKG_CNTR BCNTR" ).append("\n"); 
		query.append("            ,DMT_CHG_CALC CALC" ).append("\n"); 
		query.append("            ,DMT_INV_MN INV" ).append("\n"); 
		query.append("      WHERE BCNTR.BKG_NO  = BC.BKG_NO" ).append("\n"); 
		query.append("        AND BCNTR.CNTR_NO = BC.CNTR_NO" ).append("\n"); 
		query.append("        AND CALC.SYS_AREA_GRP_ID         = BCNTR.SYS_AREA_GRP_ID " ).append("\n"); 
		query.append("        AND CALC.CNTR_NO                 = BCNTR.CNTR_NO " ).append("\n"); 
		query.append("        AND CALC.CNTR_CYC_NO             = BCNTR.CNTR_CYC_NO " ).append("\n"); 
		query.append("        AND CALC.DMDT_TRF_CD             IN ('DMIF', 'CTIC')" ).append("\n"); 
		query.append("        AND CALC.DMDT_CHG_LOC_DIV_CD NOT IN ('TSP', 'SZP')" ).append("\n"); 
		query.append("        AND CALC.DUL_TP_EXPT_FLG = 'N'" ).append("\n"); 
		query.append("        AND CALC.DMDT_INV_NO = INV.DMDT_INV_NO(+)) NOD_DEM_FT" ).append("\n"); 
		query.append("    ,BC.CNTR_PRT_FLG  AS PL_IND" ).append("\n"); 
		query.append("FROM  " ).append("\n"); 
		query.append("    BKG_CONTAINER   BC " ).append("\n"); 
		query.append("    ,BKG_RF_CGO     BRC " ).append("\n"); 
		query.append("    ,BKG_AWK_CGO    BAC " ).append("\n"); 
		query.append("    ,BKG_BB_CGO     BBC " ).append("\n"); 
		query.append("    ,MST_CONTAINER  MC " ).append("\n"); 
		query.append("    ,MDM_CNTR_TP_SZ MCTS " ).append("\n"); 
		query.append("WHERE  BC.BKG_NO        =   @[bkg_no]" ).append("\n"); 
		query.append("AND  BC.BKG_NO          =   BRC.BKG_NO       (+) " ).append("\n"); 
		query.append("AND  BC.CNTR_NO         =   BRC.CNTR_NO      (+) " ).append("\n"); 
		query.append("AND  BC.BKG_NO          =   BAC.BKG_NO       (+) " ).append("\n"); 
		query.append("AND  BC.CNTR_NO         =   BAC.CNTR_NO      (+) " ).append("\n"); 
		query.append("AND  BC.BKG_NO          =   BBC.BKG_NO       (+) " ).append("\n"); 
		query.append("AND  BC.CNTR_NO         =   MC.CNTR_NO       (+) " ).append("\n"); 
		query.append("AND  BC.CNTR_TPSZ_CD    =   MCTS.CNTR_TPSZ_CD (+)" ).append("\n"); 

	}
}