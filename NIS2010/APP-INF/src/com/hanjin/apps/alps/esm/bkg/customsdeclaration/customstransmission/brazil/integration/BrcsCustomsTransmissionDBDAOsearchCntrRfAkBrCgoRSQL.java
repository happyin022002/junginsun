/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BrcsCustomsTransmissionDBDAOsearchCntrRfAkBrCgoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BrcsCustomsTransmissionDBDAOsearchCntrRfAkBrCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container 정보 및 Reefer, Break bulk, Akward정보를 조회한다.
	  * 1. 2010.12.27 이수진 [CHM-201007774] EUR 24HR 관련 구주 세관 시스템 MRN 정보 추가 요청 (SITPRO, RoCS, ANCS and European Manifest Download) 작업
	  *    :  MRN 정보를 추가함
	  * 2. 2012.02.06 김보배 [CHM-201216024] [BKG] [EUR Import Manifest] 문자열 치환하는 특수문자 제거
	  * 3. 2012.04.03 김보배 [CHM-201217042] [BKG] [EUR Customs EDI화면] EXS MRN / Export MRN 추가 - U/I 및 Flat file 업데이트
	  * 4. 2015.03.25 이한나 [CHM-201534617] Europe Customs EDI - Special Cgo indicator 수정
	  * </pre>
	  */
	public BrcsCustomsTransmissionDBDAOsearchCntrRfAkBrCgoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.integration").append("\n"); 
		query.append("FileName : BrcsCustomsTransmissionDBDAOsearchCntrRfAkBrCgoRSQL").append("\n"); 
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
		query.append("    ,NVL(BC.PCK_QTY, 0) PKG " ).append("\n"); 
		query.append("    ,BC.WGT_UT_CD CNTR_WGT_UNIT " ).append("\n"); 
		query.append("	,DECODE(NVL(BC.WGT_UT_CD,' '),'LBS',ROUND(NVL(BC.CNTR_WGT,0)*0.4536,2),NVL(BC.CNTR_WGT,0)) CNTRWGT" ).append("\n"); 
		query.append("    ,'' CNTRGWGT -- 브라질 전용" ).append("\n"); 
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
		query.append("    ,(" ).append("\n"); 
		query.append("        SELECT CNTR_SEAL_NO" ).append("\n"); 
		query.append("        FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("        WHERE BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("        AND CNTR_NO = BC.CNTR_NO" ).append("\n"); 
		query.append("        AND CNTR_SEAL_SEQ > 0" ).append("\n"); 
		query.append("        AND ROWNUM = 1" ).append("\n"); 
		query.append("     ) SEALNBR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${cnt_gubun} == 'BR') " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ,DECODE(@[bkg_cgo_tp], 'F','F','M') FM_IND " ).append("\n"); 
		query.append("        ,@[bkg_spe_rf] RF_IND " ).append("\n"); 
		query.append("        ,@[bkg_spe_dg] DG_IND " ).append("\n"); 
		query.append("        ,@[bkg_spe_ak] AK_IND " ).append("\n"); 
		query.append("        ,@[bkg_spe_bb] BK_IND " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("        ,NVL(BC.MEAS_QTY, 0) MEASURE " ).append("\n"); 
		query.append("        ,BAC.GRS_WGT OVWGT " ).append("\n"); 
		query.append("        ,'' STWG_REQ " ).append("\n"); 
		query.append("        ,'' MVMT_REF_NO" ).append("\n"); 
		query.append("    #elseif (${cnt_gubun} == 'EUR') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,@[bkg_cgo_tp]                      FM_IND " ).append("\n"); 
		query.append("        ,BC.RC_FLG                      	RF_IND " ).append("\n"); 
		query.append("        ,BC.DCGO_FLG                    	DG_IND " ).append("\n"); 
		query.append("        ,BC.AWK_CGO_FLG                     AK_IND " ).append("\n"); 
		query.append("        ,BC.BB_CGO_FLG                      BK_IND " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ,DECODE(NVL(BC.MEAS_UT_CD,' '),'CBF'," ).append("\n"); 
		query.append("                 ROUND(NVL(BC.MEAS_QTY,0)*0.0283,3)," ).append("\n"); 
		query.append("                            NVL(BC.MEAS_QTY,0)) MEASURE" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        ,DECODE(nvl(BAC.WGT_UT_CD,' '),'LBS',ROUND(nvl(BAC.GRS_WGT,0)*0.4536,3),nvl(BAC.GRS_WGT,0))   OVWGT    " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        ,REPLACE(REPLACE(REPLACE(NVL(STWG_RQST_DESC, ' '), CHR(13)||CHR(10), ' '), CHR(9), ' '), CHR(10), ' ') STWG_REQ   " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("       , (SELECT MVMT_REF_NO" ).append("\n"); 
		query.append("             FROM BKG_CSTMS_EUR_BL" ).append("\n"); 
		query.append("            WHERE BL_NO = @[bkg_no]" ).append("\n"); 
		query.append("              AND   MSG_SND_NO = ( SELECT MAX(MSG_SND_NO)" ).append("\n"); 
		query.append("                                     FROM BKG_CSTMS_EUR_BL" ).append("\n"); 
		query.append("                                    WHERE BL_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                      AND MVMT_REF_NO IS NOT NULL" ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("           ) MVMT_REF_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       , (SELECT MVMT_REF_NO" ).append("\n"); 
		query.append("             FROM BKG_CSTMS_EUR_IO_BL" ).append("\n"); 
		query.append("            WHERE BL_NO = BC.BKG_NO" ).append("\n"); 
		query.append("            AND MSG_SND_NO = (" ).append("\n"); 
		query.append("            	SELECT MAX(MSG_SND_NO)" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_EUR_IO_BL" ).append("\n"); 
		query.append("                 WHERE BL_NO = BC.BKG_NO" ).append("\n"); 
		query.append("                   AND MVMT_REF_NO IS NOT NULL" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("          ) EXS_MRN" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("       , (SELECT CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("            FROM BKG_REFERENCE" ).append("\n"); 
		query.append("            WHERE BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("            AND BKG_REF_TP_CD = 'XMRN'" ).append("\n"); 
		query.append("            AND ROWNUM = 1" ).append("\n"); 
		query.append("         ) EXPORT_MRN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("    #else -- 추후 추가될 국가를 위해" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #end                                                                      		" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ,NVL(BRC.CDO_TEMP, 0) TEMP " ).append("\n"); 
		query.append("    ,'C' TUNIT " ).append("\n"); 
		query.append("    ,'' VENT -- BRC.CNTR_VENT_CD VENT " ).append("\n"); 
		query.append("    ,NVL(BC.MEAS_QTY, 0) MEAS_QTY" ).append("\n"); 
		query.append("    ,BC.MEAS_UT_CD MEASURE_UNIT " ).append("\n"); 
		query.append("    ,NVL(BC.RCV_TERM_CD,' ')||NVL(BC.DE_TERM_CD,' ') RDTYPE " ).append("\n"); 
		query.append("    ,@[cmdt_desc] CMDT_DESC " ).append("\n"); 
		query.append("    ,@[cmdt_cd] CMDT_CD " ).append("\n"); 
		query.append("    ,REPLACE(REPLACE(NVL(BRC.DIFF_RMK, ' '), CHR(13)||CHR(10), ' '), CHR(9), ' ') RF_REMARK " ).append("\n"); 
		query.append("    ,NVL(DECODE(BC.RD_CGO_FLG, 'Y', 1, 0), 0) RFDRY_IND " ).append("\n"); 
		query.append("    ,NVL(BAC.OVR_FWRD_LEN, 0) OVF " ).append("\n"); 
		query.append("    ,NVL(BAC.OVR_BKWD_LEN, 0) OVR " ).append("\n"); 
		query.append("    ,NVL(BAC.OVR_HGT, 0) OVH " ).append("\n"); 
		query.append("    ,NVL(BAC.OVR_LF_LEN, 0) OVLW " ).append("\n"); 
		query.append("    ,NVL(BAC.OVR_RT_LEN, 0) OVRW " ).append("\n"); 
		query.append("    ,BAC.WGT_UT_CD OVWGT_UNIT " ).append("\n"); 
		query.append("    ,NVL(BAC.OVR_VOID_SLT_QTY, 0) VOID_SLOT " ).append("\n"); 
		query.append("	,NVL(BC.SOC_FLG,'N') SOCIND " ).append("\n"); 
		query.append("    ,'' HAULAGE " ).append("\n"); 
		query.append("    ,NVL(BBC.GRS_WGT, 0) BKWGT " ).append("\n"); 
		query.append("    ,BBC.WGT_UT_CD BKWGTU " ).append("\n"); 
		query.append("    ,NVL(BBC.DIM_WDT, 0) BKW " ).append("\n"); 
		query.append("    ,NVL(BBC.DIM_HGT, 0) BKH " ).append("\n"); 
		query.append("    ,NVL(BBC.DIM_LEN, 0) BKL " ).append("\n"); 
		query.append("    ,MC.OWNR_CO_CD CNTROWN " ).append("\n"); 
		query.append("    ,MC.LSTM_CD CNTRTRM " ).append("\n"); 
		query.append("    ,BC.CNTR_NO     " ).append("\n"); 
		query.append("FROM  " ).append("\n"); 
		query.append("    BKG_CONTAINER     BC " ).append("\n"); 
		query.append("    ,BKG_RF_CGO       BRC " ).append("\n"); 
		query.append("    ,BKG_AWK_CGO      BAC " ).append("\n"); 
		query.append("    ,BKG_BB_CGO       BBC " ).append("\n"); 
		query.append("    ,MST_CONTAINER    MC " ).append("\n"); 
		query.append("    ,MDM_CNTR_TP_SZ   MCTS " ).append("\n"); 
		query.append("" ).append("\n"); 
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