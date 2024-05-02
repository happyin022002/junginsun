/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MexCustomsTransmissionDBDAOsearchContainerInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.06
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.01.06 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM MINJUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MexCustomsTransmissionDBDAOsearchContainerInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DWKIM, 0370, MxCntrVO
	  * </pre>
	  */
	public MexCustomsTransmissionDBDAOsearchContainerInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.integration").append("\n"); 
		query.append("FileName : MexCustomsTransmissionDBDAOsearchContainerInfoRSQL").append("\n"); 
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
		query.append("    NVL(BC.CNTR_NO, ' ') CNTRNBR " ).append("\n"); 
		query.append("    ,NVL(BC.PCK_TP_CD, ' ') PUNIT " ).append("\n"); 
		query.append("    ,NVL(BC.PCK_QTY, 0) PKG" ).append("\n"); 
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
		query.append("    ,NVL(BC.CNTR_TPSZ_CD, ' ') CNTRTYPE " ).append("\n"); 
		query.append("    --,NVL(BCSN.CNTR_SEAL_NO, ' ') SEALNBR " ).append("\n"); 
		query.append("    ,BKG_JOIN_FNC(CURSOR(" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT CNTR_SEAL_NO " ).append("\n"); 
		query.append("              FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("             WHERE BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("              AND CNTR_NO = BC.CNTR_NO" ).append("\n"); 
		query.append("              AND CNTR_SEAL_SEQ > 0" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("     ),'@') SEALNBR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,NVL(BRC.CDO_TEMP, 0) TEMP" ).append("\n"); 
		query.append("    ,'' VENT -- BRC.CNTR_VENT_CD VENT " ).append("\n"); 
		query.append("	,NVL(BC.MEAS_QTY,0) MEASURE" ).append("\n"); 
		query.append("	,NVL(BC.MEAS_UT_CD,' ') MEASURE_UNIT  " ).append("\n"); 
		query.append("	,NVL(BC.RCV_TERM_CD,' ')||NVL(BC.DE_TERM_CD,' ') RDTYPE " ).append("\n"); 
		query.append("    ,BKG_TOKEN_NL_FNC(NVL(BRC.DIFF_RMK ,' '),0,'') RF_REMARK" ).append("\n"); 
		query.append("    ,NVL(BAC.OVR_FWRD_LEN, 0) OVF " ).append("\n"); 
		query.append("    ,NVL(BAC.OVR_BKWD_LEN, 0) OVR " ).append("\n"); 
		query.append("    ,NVL(BAC.OVR_HGT, 0) OVH " ).append("\n"); 
		query.append("    ,NVL(BAC.OVR_LF_LEN, 0) OVLW " ).append("\n"); 
		query.append("    ,NVL(BAC.OVR_RT_LEN, 0) OVRW " ).append("\n"); 
		query.append("    ,NVL(BAC.WGT_UT_CD, ' ') OVWGT_UNIT " ).append("\n"); 
		query.append("	,nvl(BAC.GRS_WGT,0)   OVWGT " ).append("\n"); 
		query.append("    ,NVL(BAC.OVR_VOID_SLT_QTY, 0) VOID_SLOT" ).append("\n"); 
		query.append("    ,NVL(BC.SOC_FLG,'N') SOCIND " ).append("\n"); 
		query.append("    ,NVL(BBC.GRS_WGT, 0) BKWGT " ).append("\n"); 
		query.append("    ,NVL(BBC.WGT_UT_CD, ' ') BKWGTU " ).append("\n"); 
		query.append("    ,NVL(BBC.DIM_WDT, 0) BKW " ).append("\n"); 
		query.append("    ,NVL(BBC.DIM_HGT, 0) BKH " ).append("\n"); 
		query.append("    ,NVL(BBC.DIM_LEN, 0) BKL " ).append("\n"); 
		query.append("    ,NVL(MC.OWNR_CO_CD, ' ') CNTROWN " ).append("\n"); 
		query.append("    ,NVL(MC.LSTM_CD, ' ' ) CNTRTRM " ).append("\n"); 
		query.append("    ,BC.CNTR_NO " ).append("\n"); 
		query.append("FROM  " ).append("\n"); 
		query.append("    BKG_CONTAINER   BC " ).append("\n"); 
		query.append("    ,BKG_RF_CGO     BRC " ).append("\n"); 
		query.append("    ,BKG_AWK_CGO    BAC " ).append("\n"); 
		query.append("    ,BKG_BB_CGO     BBC " ).append("\n"); 
		query.append("    ,MST_CONTAINER  MC " ).append("\n"); 
		query.append("    ,MDM_CNTR_TP_SZ MCTS" ).append("\n"); 
		query.append("WHERE  BC.BKG_NO        =   @[bkg_no]" ).append("\n"); 
		query.append("AND	 BBC.BB_CGO_SEQ(+)	=	1" ).append("\n"); 
		query.append("AND  BC.BKG_NO          =   BRC.BKG_NO       (+) " ).append("\n"); 
		query.append("AND  BC.CNTR_NO         =   BRC.CNTR_NO      (+) " ).append("\n"); 
		query.append("AND  BC.BKG_NO          =   BAC.BKG_NO       (+) " ).append("\n"); 
		query.append("AND  BC.CNTR_NO         =   BAC.CNTR_NO      (+) " ).append("\n"); 
		query.append("AND  BC.BKG_NO          =   BBC.BKG_NO       (+) " ).append("\n"); 
		query.append("AND  BC.CNTR_NO         =   MC.CNTR_NO       (+) " ).append("\n"); 
		query.append("AND  BC.CNTR_TPSZ_CD    =   MCTS.CNTR_TPSZ_CD (+)" ).append("\n"); 

	}
}