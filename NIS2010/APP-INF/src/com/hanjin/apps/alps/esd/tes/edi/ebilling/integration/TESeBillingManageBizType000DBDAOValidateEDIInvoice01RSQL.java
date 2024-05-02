/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TESeBillingManageBizType000DBDAOValidateEDIInvoice01RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.27
*@LastModifier : 이 용 호
*@LastVersion : 1.0
* 2014.11.27 이 용 호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESeBillingManageBizType000DBDAOValidateEDIInvoice01RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI invoice data 유효성 확인
	  * </pre>
	  */
	public TESeBillingManageBizType000DBDAOValidateEDIInvoice01RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_edi_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_edi_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.edi.ebilling.integration").append("\n"); 
		query.append("FileName : TESeBillingManageBizType000DBDAOValidateEDIInvoice01RSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	CASE WHEN (NVL((SELECT COUNT(H.INV_NO)" ).append("\n"); 
		query.append("			FROM TES_TML_SO_HDR H" ).append("\n"); 
		query.append("			WHERE NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("			AND H.TML_INV_STS_CD IN ('R','C','A','P','D')" ).append("\n"); 
		query.append("			AND H.VNDR_SEQ = Y.VNDR_SEQ " ).append("\n"); 
		query.append("			AND H.INV_NO = Y.INV_NO),0) >= 1" ).append("\n"); 
		query.append("		OR NVL((SELECT COUNT(H.INV_NO)" ).append("\n"); 
		query.append("			FROM TES_EDI_SO_HDR H" ).append("\n"); 
		query.append("			WHERE NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("			AND H.TML_INV_STS_CD IN ('R')" ).append("\n"); 
		query.append("			AND NVL(H.TML_INV_RJCT_STS_CD,'N') = 'NL'" ).append("\n"); 
		query.append("			AND NVL(H.VLD_CHK_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("			AND H.TML_SO_OFC_CTY_CD IS NULL " ).append("\n"); 
		query.append("			AND H.TML_SO_SEQ IS NULL" ).append("\n"); 
		query.append("			AND H.VNDR_SEQ = Y.VNDR_SEQ AND H.INV_NO = Y.INV_NO),0) >= 1)" ).append("\n"); 
		query.append("		THEN 'INVOICE DUPLICATED'" ).append("\n"); 
		query.append("		ELSE ''" ).append("\n"); 
		query.append("	END DUP_CHK" ).append("\n"); 
		query.append("	, Y.TML_INV_TP_CD_CHK" ).append("\n"); 
		query.append("	, Y.INV_OFC_CD_CHK" ).append("\n"); 
		query.append("	, Y.COST_OFC_CD_CHK" ).append("\n"); 
		query.append("	, Y.VNDR_SEQ_CHK" ).append("\n"); 
		query.append("	, Y.YD_CD_CHK" ).append("\n"); 
		query.append("	, Y.INV_NO_CHK" ).append("\n"); 
		query.append("	, Y.CURR_CD_CHK" ).append("\n"); 
		query.append("	, Y.TTL_INV_AMT_CHK" ).append("\n"); 
		query.append("    , Y.ISS_DT_CHK" ).append("\n"); 
		query.append("	, Y.DTL_RATE_CHK" ).append("\n"); 
		query.append("	, Y.DTL_LGS_COST_CD_CHK" ).append("\n"); 
		query.append("	, Y.DTL_MNL_COST_CD_CHK" ).append("\n"); 
		query.append("	, Y.DTL_INV_AMT_CHK" ).append("\n"); 
		query.append("	, Y.DTL_VOL_QTY_CHK" ).append("\n"); 
		query.append("	, Y.DTL_STAY_DYS_CHK" ).append("\n"); 
		query.append("	, Y.DTL_VVD_CHK" ).append("\n"); 
		query.append("	, Y.CNTR_LIST_VVD_CHK" ).append("\n"); 
		query.append("	, Y.DTL_IO_BND_CD_CHK" ).append("\n"); 
		query.append("	, Y.CNTR_STY_CD_CHK" ).append("\n"); 
		query.append("	, Y.CNTR_IO_BND_CD_CHK" ).append("\n"); 
		query.append("	, Y.CNTR_CNTR_NO_CHK" ).append("\n"); 
		query.append("	, Y.INV_GATE_IN_TM_MSG" ).append("\n"); 
		query.append("	, Y.INV_GATE_OUT_TM_MSG" ).append("\n"); 
		query.append("	, Y.GATE_IN_OUT_DT_CHK" ).append("\n"); 
		query.append("	, Y.RF_COST_CD_TPSZ_CHK    " ).append("\n"); 
		query.append("	, CASE WHEN (NVL(Y.CNTR_LIST_KNT,0) + NVL(Y.DTL_LIST_KNT,0)) <= 0" ).append("\n"); 
		query.append("	       THEN 'NO DATA FOUND'" ).append("\n"); 
		query.append("	       ELSE ''" ).append("\n"); 
		query.append("	  END BODY_CHK" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("	SELECT	MAX(VNDR_SEQ)           VNDR_SEQ" ).append("\n"); 
		query.append("		, MAX(INV_NO)             INV_NO" ).append("\n"); 
		query.append("		, MAX(TML_INV_TP_CD_CHK)  TML_INV_TP_CD_CHK" ).append("\n"); 
		query.append("		, MAX(INV_OFC_CD_CHK)     INV_OFC_CD_CHK" ).append("\n"); 
		query.append("		, MAX(COST_OFC_CD_CHK)    COST_OFC_CD_CHK" ).append("\n"); 
		query.append("		, MAX(VNDR_SEQ_CHK)       VNDR_SEQ_CHK" ).append("\n"); 
		query.append("		, MAX(YD_CD_CHK)          YD_CD_CHK" ).append("\n"); 
		query.append("		, MAX(INV_NO_CHK)         INV_NO_CHK" ).append("\n"); 
		query.append("		, MAX(CURR_CD_CHK)        CURR_CD_CHK" ).append("\n"); 
		query.append("		, MAX(TTL_INV_AMT_CHK)    TTL_INV_AMT_CHK" ).append("\n"); 
		query.append("        , MAX(ISS_DT_CHK)         ISS_DT_CHK" ).append("\n"); 
		query.append("		, MAX(DTL_LGS_COST_CD_CHK) DTL_LGS_COST_CD_CHK" ).append("\n"); 
		query.append("		, MAX(DTL_MNL_COST_CD_CHK) DTL_MNL_COST_CD_CHK" ).append("\n"); 
		query.append("		, MAX(DTL_RATE_CHK)       DTL_RATE_CHK" ).append("\n"); 
		query.append("		, MAX(DTL_INV_AMT_CHK)    DTL_INV_AMT_CHK" ).append("\n"); 
		query.append("		, MAX(DTL_VOL_QTY_CHK)    DTL_VOL_QTY_CHK" ).append("\n"); 
		query.append("		, MAX(DTL_STAY_DYS_CHK)   DTL_STAY_DYS_CHK" ).append("\n"); 
		query.append("		, MAX(DTL_VVD_CHK)        DTL_VVD_CHK" ).append("\n"); 
		query.append("		, MAX(CNTR_LIST_VVD_CHK)  CNTR_LIST_VVD_CHK" ).append("\n"); 
		query.append("        , MAX(DTL_IO_BND_CD_CHK)  DTL_IO_BND_CD_CHK" ).append("\n"); 
		query.append("		, MAX(CNTR_STY_CD_CHK)    CNTR_STY_CD_CHK" ).append("\n"); 
		query.append("		, MAX(CNTR_IO_BND_CD_CHK) CNTR_IO_BND_CD_CHK" ).append("\n"); 
		query.append("		, MAX(CNTR_CNTR_NO_CHK)   CNTR_CNTR_NO_CHK" ).append("\n"); 
		query.append("		, MAX(INV_GATE_IN_TM_MSG) INV_GATE_IN_TM_MSG" ).append("\n"); 
		query.append("		, MAX(INV_GATE_OUT_TM_MSG) INV_GATE_OUT_TM_MSG" ).append("\n"); 
		query.append("		, MAX(GATE_IN_OUT_DT_CHK) GATE_IN_OUT_DT_CHK" ).append("\n"); 
		query.append("		, MAX(RF_COST_CD_TPSZ_CHK) RF_COST_CD_TPSZ_CHK" ).append("\n"); 
		query.append("		, MAX(CNTR_LIST_KNT) CNTR_LIST_KNT" ).append("\n"); 
		query.append("		, MAX(DTL_LIST_KNT) DTL_LIST_KNT" ).append("\n"); 
		query.append("	FROM	( " ).append("\n"); 
		query.append("			SELECT /***  HDR INFO ***/" ).append("\n"); 
		query.append("			DISTINCT" ).append("\n"); 
		query.append("			CASE " ).append("\n"); 
		query.append("			WHEN H.TML_INV_TP_CD IS NULL" ).append("\n"); 
		query.append("			THEN 'INVOICE TYPE MISSING'" ).append("\n"); 
		query.append("			WHEN H.TML_INV_TP_CD NOT IN('TM','ST','OF','ON')" ).append("\n"); 
		query.append("			THEN 'WRONG INVOICE TYPE'" ).append("\n"); 
		query.append("			ELSE ''" ).append("\n"); 
		query.append("			END TML_INV_TP_CD_CHK," ).append("\n"); 
		query.append("			CASE " ).append("\n"); 
		query.append("			WHEN H.INV_OFC_CD   IS NULL " ).append("\n"); 
		query.append("			THEN 'INVOICE OFFICE MISSING'" ).append("\n"); 
		query.append("			WHEN IO.OFC_CD      IS NULL " ).append("\n"); 
		query.append("			THEN 'WRONG INVOICE OFFICE'" ).append("\n"); 
		query.append("			ELSE ''" ).append("\n"); 
		query.append("			END INV_OFC_CD_CHK," ).append("\n"); 
		query.append("			CASE " ).append("\n"); 
		query.append("			WHEN H.COST_OFC_CD  IS NULL " ).append("\n"); 
		query.append("			THEN 'COST OFFICE MISSING'" ).append("\n"); 
		query.append("			WHEN CO.OFC_CD      IS NULL " ).append("\n"); 
		query.append("			THEN 'WRONG COST OFFICE'" ).append("\n"); 
		query.append("			ELSE ''" ).append("\n"); 
		query.append("			END COST_OFC_CD_CHK," ).append("\n"); 
		query.append("			CASE " ).append("\n"); 
		query.append("			WHEN H.VNDR_SEQ     IS NULL " ).append("\n"); 
		query.append("			THEN 'S/P CODE MISSING'" ).append("\n"); 
		query.append("			WHEN V.VNDR_SEQ     IS NULL " ).append("\n"); 
		query.append("			THEN 'WRONG S/P CODE'" ).append("\n"); 
		query.append("			ELSE ''" ).append("\n"); 
		query.append("			END VNDR_SEQ_CHK," ).append("\n"); 
		query.append("			CASE " ).append("\n"); 
		query.append("			WHEN H.YD_CD        IS NULL " ).append("\n"); 
		query.append("			THEN 'YARD CODE MISSING'" ).append("\n"); 
		query.append("			WHEN Y.YD_CD        IS NULL " ).append("\n"); 
		query.append("			THEN 'WRONG YARD CODE'" ).append("\n"); 
		query.append("			ELSE ''" ).append("\n"); 
		query.append("			END YD_CD_CHK," ).append("\n"); 
		query.append("			CASE " ).append("\n"); 
		query.append("			WHEN H.INV_NO       IS NULL " ).append("\n"); 
		query.append("			THEN 'INVOICE No. MISSING'" ).append("\n"); 
		query.append("			ELSE ''" ).append("\n"); 
		query.append("			END INV_NO_CHK," ).append("\n"); 
		query.append("			CASE " ).append("\n"); 
		query.append("			WHEN H.CURR_CD      IS NULL " ).append("\n"); 
		query.append("			THEN 'CURRENCY MISSING'" ).append("\n"); 
		query.append("			WHEN MC.CURR_CD     IS NULL " ).append("\n"); 
		query.append("			THEN 'WRONG CURRENCY'" ).append("\n"); 
		query.append("			ELSE ''" ).append("\n"); 
		query.append("			END CURR_CD_CHK," ).append("\n"); 
		query.append("			CASE " ).append("\n"); 
		query.append("			WHEN H.TTL_INV_AMT  IS NULL " ).append("\n"); 
		query.append("			THEN 'TOTAL INVOICE AMOUNT MISSING'" ).append("\n"); 
		query.append("			ELSE ''" ).append("\n"); 
		query.append("			END TTL_INV_AMT_CHK," ).append("\n"); 
		query.append("			CASE " ).append("\n"); 
		query.append("			WHEN H.ISS_DT  IS NULL " ).append("\n"); 
		query.append("			THEN 'ISSUE DATE MISSING'" ).append("\n"); 
		query.append("			ELSE ''" ).append("\n"); 
		query.append("			END ISS_DT_CHK," ).append("\n"); 
		query.append("			/*** DTL ***/" ).append("\n"); 
		query.append("			CASE " ).append("\n"); 
		query.append("			WHEN D.TML_EDI_SO_DTL_SEQ IS NOT NULL" ).append("\n"); 
		query.append("			THEN" ).append("\n"); 
		query.append("				CASE " ).append("\n"); 
		query.append("				WHEN D.LGS_COST_CD IS NULL " ).append("\n"); 
		query.append("				THEN 'TARIFF MISSING AT DTL LIST'" ).append("\n"); 
		query.append("				WHEN TC.LGS_COST_CD IS NULL " ).append("\n"); 
		query.append("				THEN 'WRONG TARIFF AT DTL LIST'" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("				END" ).append("\n"); 
		query.append("			ELSE ''" ).append("\n"); 
		query.append("			END DTL_LGS_COST_CD_CHK," ).append("\n"); 
		query.append("			CASE " ).append("\n"); 
		query.append("			WHEN D.TML_EDI_SO_DTL_SEQ IS NOT NULL" ).append("\n"); 
		query.append("			THEN" ).append("\n"); 
		query.append("				CASE " ).append("\n"); 
		query.append("				WHEN TC.COST_CALC_MZD_CD IS NOT NULL AND COST_CALC_MZD_CD <> 'M'" ).append("\n"); 
		query.append("				THEN 'AUTOMATIC AUDIT COST CODE FOUND AT DTL LIST'" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("				END" ).append("\n"); 
		query.append("			ELSE ''" ).append("\n"); 
		query.append("			END DTL_MNL_COST_CD_CHK," ).append("\n"); 
		query.append("			CASE " ).append("\n"); 
		query.append("			WHEN D.TML_EDI_SO_DTL_SEQ IS NOT NULL AND D.CTRT_RT IS NULL" ).append("\n"); 
		query.append("			THEN 'RATE MISSING AT DTL LIST'" ).append("\n"); 
		query.append("			END DTL_RATE_CHK," ).append("\n"); 
		query.append("			CASE " ).append("\n"); 
		query.append("			WHEN D.TML_EDI_SO_DTL_SEQ IS NOT NULL" ).append("\n"); 
		query.append("			THEN " ).append("\n"); 
		query.append("				CASE " ).append("\n"); 
		query.append("				WHEN D.INV_AMT IS NULL " ).append("\n"); 
		query.append("				THEN 'INVOICE AMOUNT MISSING AT DTL LIST'" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("				END" ).append("\n"); 
		query.append("			END DTL_INV_AMT_CHK," ).append("\n"); 
		query.append("			CASE " ).append("\n"); 
		query.append("			WHEN H.TML_INV_TP_CD IN('TM') AND D.TML_EDI_SO_DTL_SEQ IS NOT NULL AND D.CALC_VOL_QTY IS NULL" ).append("\n"); 
		query.append("			THEN 'VOLUME QTY MISSING AT DTL LIST'" ).append("\n"); 
		query.append("			ELSE ''" ).append("\n"); 
		query.append("			END DTL_VOL_QTY_CHK," ).append("\n"); 
		query.append("			CASE " ).append("\n"); 
		query.append("			WHEN H.TML_INV_TP_CD IN('ST') AND D.TML_EDI_SO_DTL_SEQ IS NOT NULL AND D.STAY_DYS IS NULL" ).append("\n"); 
		query.append("			THEN 'STAY DAYS MISSING AT DTL LIST'" ).append("\n"); 
		query.append("			ELSE ''" ).append("\n"); 
		query.append("			END DTL_STAY_DYS_CHK," ).append("\n"); 
		query.append("            CASE " ).append("\n"); 
		query.append("			WHEN H.TML_INV_TP_CD IN('TM') AND D.TML_EDI_SO_DTL_SEQ IS NOT NULL" ).append("\n"); 
		query.append("			THEN" ).append("\n"); 
		query.append("				CASE " ).append("\n"); 
		query.append("				WHEN D.IO_BND_CD IS NULL" ).append("\n"); 
		query.append("				THEN 'I/O BOUND MISSING AT DTL LIST'" ).append("\n"); 
		query.append("				WHEN D.IO_BND_CD NOT IN('I','O')" ).append("\n"); 
		query.append("				THEN 'WRONG I/O BOUND AT DTL LIST'" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("				END" ).append("\n"); 
		query.append("			ELSE ''" ).append("\n"); 
		query.append("			END DTL_IO_BND_CD_CHK," ).append("\n"); 
		query.append("			CASE " ).append("\n"); 
		query.append("			WHEN H.TML_INV_TP_CD IN('TM') AND D.TML_EDI_SO_DTL_SEQ IS NOT NULL" ).append("\n"); 
		query.append("			THEN" ).append("\n"); 
		query.append("				CASE " ).append("\n"); 
		query.append("--				WHEN D.VSL_CD IS NULL AND D.SKD_VOY_NO IS NULL AND D.SKD_DIR_CD IS NULL" ).append("\n"); 
		query.append("--				THEN 'VVD MISSING AT DTL LIST'" ).append("\n"); 
		query.append("				WHEN (D.VSL_CD IS NULL OR D.SKD_VOY_NO IS NULL OR D.SKD_DIR_CD IS NULL)" ).append("\n"); 
		query.append("				THEN 'WRONG VVD AT DTL LIST'" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("				END" ).append("\n"); 
		query.append("			ELSE ''" ).append("\n"); 
		query.append("			END DTL_VVD_CHK," ).append("\n"); 
		query.append("        	CASE" ).append("\n"); 
		query.append("			WHEN D.TML_EDI_SO_DTL_SEQ IS NOT NULL" ).append("\n"); 
		query.append("			THEN " ).append("\n"); 
		query.append("                CASE " ).append("\n"); 
		query.append("				-- CHM-201432352 [TESLEA] 철도운송 RF 화물 Genset 관련 Cost Code 생성 (TMRFGR) 추가 - 4347-10-13" ).append("\n"); 
		query.append("                WHEN D.LGS_COST_CD IS NOT NULL AND D.LGS_COST_CD IN ('SVSCRF','TMRFGO','TMRFMO','TMRFPL','TMRFPT','TMRFXX','TMRFGR')" ).append("\n"); 
		query.append("                THEN " ).append("\n"); 
		query.append("                    CASE" ).append("\n"); 
		query.append("                    WHEN D.CNTR_TPSZ_CD IS NOT NULL" ).append("\n"); 
		query.append("                    THEN " ).append("\n"); 
		query.append("                        CASE" ).append("\n"); 
		query.append("                        WHEN TES_GET_EDI_CNTR_TPSZ_CD_FNC(H.VNDR_SEQ,D.CNTR_TPSZ_CD) IS NULL OR SUBSTR(TES_GET_EDI_CNTR_TPSZ_CD_FNC(H.VNDR_SEQ,D.CNTR_TPSZ_CD),1,1) != 'R'" ).append("\n"); 
		query.append("                        THEN 'WRONG REEFER CONTAINER TYPE SIZE AT DTL LIST'" ).append("\n"); 
		query.append("                        ELSE ''" ).append("\n"); 
		query.append("                        END " ).append("\n"); 
		query.append("                    ELSE " ).append("\n"); 
		query.append("                        CASE " ).append("\n"); 
		query.append("                        WHEN D.CNTR_NO IS NOT NULL" ).append("\n"); 
		query.append("                        THEN " ).append("\n"); 
		query.append("                            CASE" ).append("\n"); 
		query.append("                            WHEN TES_GET_EDI_CNTR_TPSZ_CD_FNC(H.VNDR_SEQ,D.CNTR_TPSZ_CD,D.CNTR_NO) IS NULL OR SUBSTR(TES_GET_EDI_CNTR_TPSZ_CD_FNC(H.VNDR_SEQ,D.CNTR_TPSZ_CD,D.CNTR_NO),1,1) != 'R'" ).append("\n"); 
		query.append("                            THEN 'WRONG REEFER CONTAINER TYPE SIZE AT DTL LIST'" ).append("\n"); 
		query.append("                            ELSE ''" ).append("\n"); 
		query.append("                            END" ).append("\n"); 
		query.append("                        ELSE 'WRONG CONTAINER TPSZ CODE AT DTL LIST'" ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("                    END" ).append("\n"); 
		query.append("                ELSE ''" ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("			ELSE ''" ).append("\n"); 
		query.append("			END RF_COST_CD_TPSZ_CHK," ).append("\n"); 
		query.append("			/*** CNTR LIST ***/" ).append("\n"); 
		query.append("			CASE " ).append("\n"); 
		query.append("			WHEN H.TML_INV_TP_CD IN('TM') AND C.TML_EDI_SO_CNTR_LIST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("			THEN" ).append("\n"); 
		query.append("				CASE " ).append("\n"); 
		query.append("--				WHEN C.VSL_CD IS NULL AND C.SKD_VOY_NO IS NULL AND C.SKD_DIR_CD IS NULL" ).append("\n"); 
		query.append("--				THEN 'VVD MISSING AT CNTR LIST'" ).append("\n"); 
		query.append("				WHEN (C.VSL_CD IS NULL OR C.SKD_VOY_NO IS NULL OR C.SKD_DIR_CD IS NULL)" ).append("\n"); 
		query.append("				THEN 'WRONG VVD AT CNTR LIST'" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("				END" ).append("\n"); 
		query.append("			ELSE ''" ).append("\n"); 
		query.append("			END CNTR_LIST_VVD_CHK," ).append("\n"); 
		query.append("			CASE " ).append("\n"); 
		query.append("			WHEN H.TML_INV_TP_CD IN('TM') AND C.TML_EDI_SO_CNTR_LIST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("			THEN" ).append("\n"); 
		query.append("				CASE " ).append("\n"); 
		query.append("				WHEN C.CNTR_STY_CD IS NULL" ).append("\n"); 
		query.append("				THEN 'FULL/EMPTY MISSING AT CNTR LIST'" ).append("\n"); 
		query.append("				WHEN C.CNTR_STY_CD NOT IN('F','M')" ).append("\n"); 
		query.append("				THEN 'WRONG FULL/EMPTY AT CNTR LIST'" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("				END" ).append("\n"); 
		query.append("			ELSE ''" ).append("\n"); 
		query.append("			END CNTR_STY_CD_CHK," ).append("\n"); 
		query.append("			CASE " ).append("\n"); 
		query.append("			WHEN  H.TML_INV_TP_CD IN('TM') AND C.TML_EDI_SO_CNTR_LIST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("			THEN " ).append("\n"); 
		query.append("				CASE " ).append("\n"); 
		query.append("				WHEN C.IO_BND_CD IS NULL" ).append("\n"); 
		query.append("				THEN 'I/O BOUND MISSING AT CNTR LIST'" ).append("\n"); 
		query.append("				WHEN C.IO_BND_CD NOT IN('I','O')" ).append("\n"); 
		query.append("				THEN 'WRONG I/O BOUND AT CNTR LIST'" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("				END" ).append("\n"); 
		query.append("			ELSE ''" ).append("\n"); 
		query.append("			END CNTR_IO_BND_CD_CHK," ).append("\n"); 
		query.append("			CASE " ).append("\n"); 
		query.append("			WHEN C.TML_EDI_SO_CNTR_LIST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("			THEN " ).append("\n"); 
		query.append("				CASE " ).append("\n"); 
		query.append("				WHEN C.CNTR_NO IS NULL " ).append("\n"); 
		query.append("				THEN 'CNTR NO IS MISSING AT CNTR LIST'" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("				END" ).append("\n"); 
		query.append("			ELSE ''" ).append("\n"); 
		query.append("			END CNTR_CNTR_NO_CHK," ).append("\n"); 
		query.append("			CASE " ).append("\n"); 
		query.append("			WHEN H.TML_INV_TP_CD IN('ST') AND C.TML_EDI_SO_CNTR_LIST_SEQ IS NOT NULL " ).append("\n"); 
		query.append("			THEN " ).append("\n"); 
		query.append("				CASE" ).append("\n"); 
		query.append("				WHEN C.INV_GATE_IN_TM_MSG IS NULL " ).append("\n"); 
		query.append("				THEN 'GATE IN DATE MISSING'" ).append("\n"); 
		query.append("				WHEN C.INV_GATE_IN_TM_MSG IS NOT NULL AND LENGTH(C.INV_GATE_IN_TM_MSG) NOT IN (8,12)" ).append("\n"); 
		query.append("				THEN 'WRONG GATE IN DATE FORMAT'" ).append("\n"); 
		query.append("				END" ).append("\n"); 
		query.append("			ELSE ''" ).append("\n"); 
		query.append("  		    END INV_GATE_IN_TM_MSG," ).append("\n"); 
		query.append("			CASE " ).append("\n"); 
		query.append("			WHEN H.TML_INV_TP_CD IN('ST') AND C.TML_EDI_SO_CNTR_LIST_SEQ IS NOT NULL " ).append("\n"); 
		query.append("            THEN " ).append("\n"); 
		query.append("				CASE" ).append("\n"); 
		query.append("				WHEN C.INV_GATE_OUT_TM_MSG  IS NULL " ).append("\n"); 
		query.append("				THEN 'GATE OUT DATE MISSING'" ).append("\n"); 
		query.append("				WHEN C.INV_GATE_OUT_TM_MSG IS NOT NULL AND LENGTH(C.INV_GATE_OUT_TM_MSG) NOT IN (8,12)" ).append("\n"); 
		query.append("				THEN 'WRONG GATE OUT DATE FORMAT'" ).append("\n"); 
		query.append("				END" ).append("\n"); 
		query.append("			ELSE ''" ).append("\n"); 
		query.append("			END INV_GATE_OUT_TM_MSG," ).append("\n"); 
		query.append("			CASE " ).append("\n"); 
		query.append("			WHEN H.TML_INV_TP_CD IN('ST') AND C.TML_EDI_SO_CNTR_LIST_SEQ IS NOT NULL " ).append("\n"); 
		query.append("			THEN " ).append("\n"); 
		query.append("				CASE" ).append("\n"); 
		query.append("				WHEN C.INV_GATE_IN_TM_MSG IS NOT NULL AND LENGTH(C.INV_GATE_IN_TM_MSG) NOT IN (8,12) " ).append("\n"); 
		query.append("					 AND C.INV_GATE_OUT_TM_MSG IS NOT NULL AND LENGTH(C.INV_GATE_OUT_TM_MSG) NOT IN (8,12) " ).append("\n"); 
		query.append("					 AND C.INV_GATE_OUT_TM_MSG < C.INV_GATE_IN_TM_MSG" ).append("\n"); 
		query.append("				THEN 'WRONG GATE IN/OUT DATE'" ).append("\n"); 
		query.append("				END" ).append("\n"); 
		query.append("			ELSE ''" ).append("\n"); 
		query.append("			END GATE_IN_OUT_DT_CHK," ).append("\n"); 
		query.append("			H.VNDR_SEQ, " ).append("\n"); 
		query.append("			H.INV_NO," ).append("\n"); 
		query.append("			COUNT(C.TML_EDI_SO_CNTR_LIST_SEQ) OVER () AS CNTR_LIST_KNT," ).append("\n"); 
		query.append("			COUNT(D.TML_EDI_SO_DTL_SEQ) OVER () AS DTL_LIST_KNT" ).append("\n"); 
		query.append("		 FROM TES_EDI_SO_HDR H" ).append("\n"); 
		query.append("			, TES_EDI_SO_DTL D" ).append("\n"); 
		query.append("			, TES_EDI_SO_CNTR_LIST C" ).append("\n"); 
		query.append("			, TES_EDI_SO_AUTO_FREE_POOL F" ).append("\n"); 
		query.append("			, MDM_VENDOR V" ).append("\n"); 
		query.append("			, MDM_YARD Y" ).append("\n"); 
		query.append("			, MDM_ORGANIZATION IO" ).append("\n"); 
		query.append("			, MDM_ORGANIZATION CO" ).append("\n"); 
		query.append("			, MDM_CURRENCY MC" ).append("\n"); 
		query.append("			, TES_TML_SO_COST TC" ).append("\n"); 
		query.append("		 WHERE	H.TML_EDI_SO_OFC_CTY_CD	= @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("		 AND	H.TML_EDI_SO_SEQ 		= @[tml_edi_so_seq]" ).append("\n"); 
		query.append("		 AND	H.VNDR_SEQ = V.VNDR_SEQ(+)" ).append("\n"); 
		query.append("		 AND	H.YD_CD = Y.YD_CD(+)" ).append("\n"); 
		query.append("		 AND	H.INV_OFC_CD = IO.OFC_CD(+)" ).append("\n"); 
		query.append("		 AND	H.COST_OFC_CD = CO.OFC_CD(+)" ).append("\n"); 
		query.append("		 AND	H.CURR_CD = MC.CURR_CD(+)" ).append("\n"); 
		query.append("		 AND	D.LGS_COST_CD = TC.LGS_COST_CD(+)" ).append("\n"); 
		query.append("		 AND	H.TML_EDI_SO_OFC_CTY_CD = D.TML_EDI_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("		 AND	H.TML_EDI_SO_SEQ = D.TML_EDI_SO_SEQ(+)" ).append("\n"); 
		query.append("		 AND	H.TML_EDI_SO_OFC_CTY_CD = C.TML_EDI_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("		 AND	H.TML_EDI_SO_SEQ = C.TML_EDI_SO_SEQ(+)" ).append("\n"); 
		query.append("		 AND	H.TML_EDI_SO_OFC_CTY_CD = F.TML_EDI_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("		 AND	H.TML_EDI_SO_SEQ = F.TML_EDI_SO_SEQ(+)" ).append("\n"); 
		query.append("		) X " ).append("\n"); 
		query.append("	) Y" ).append("\n"); 

	}
}