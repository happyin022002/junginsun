/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TESeBillingManageBizType004DBDAOValidateEDIInvoice01RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.13
*@LastModifier : 이 용 호
*@LastVersion : 1.0
* 2014.10.13 이 용 호
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

public class TESeBillingManageBizType004DBDAOValidateEDIInvoice01RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI로 접수된 Invoice의 유효성을 체크한다.
	  * </pre>
	  */
	public TESeBillingManageBizType004DBDAOValidateEDIInvoice01RSQL(){
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
		query.append("FileName : TESeBillingManageBizType004DBDAOValidateEDIInvoice01RSQL").append("\n"); 
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
		query.append("	, Y.EDI_VNDR_CHK" ).append("\n"); 
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
		query.append("	, Y.DTL_INV_AMT_CHK" ).append("\n"); 
		query.append("	, Y.DTL_VOL_QTY_CHK" ).append("\n"); 
		query.append("	, Y.DTL_VVD_CHK" ).append("\n"); 
		query.append("	, Y.CNTR_LIST_VVD_CHK" ).append("\n"); 
		query.append("    , Y.HIT_DTL_IO_BND_CD_CHK" ).append("\n"); 
		query.append("	, Y.DTL_IO_BND_CD_CHK" ).append("\n"); 
		query.append("	, Y.CNTR_STY_CD_CHK" ).append("\n"); 
		query.append("	, Y.CNTR_IO_BND_CD_CHK" ).append("\n"); 
		query.append("	, Y.CNTR_CNTR_NO_CHK" ).append("\n"); 
		query.append("	, Y.INV_GATE_IN_TM_MSG" ).append("\n"); 
		query.append("	, Y.INV_GATE_OUT_TM_MSG" ).append("\n"); 
		query.append("	, Y.GATE_IN_OUT_DT_CHK" ).append("\n"); 
		query.append("	, Y.FREE_POOL_WRK_DT_CHK" ).append("\n"); 
		query.append("	, Y.FREE_POOL_VOL_QTY_CHK" ).append("\n"); 
		query.append("	, Y.AUTO_FREE_POOL_MODE_CHK" ).append("\n"); 
		query.append("	, Y.AUTO_FREE_POOL_WORK_DT_CHK" ).append("\n"); 
		query.append("	, Y.AUTO_FREE_POOL_VOL_QTY_CHK" ).append("\n"); 
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
		query.append("		, MAX(DTL_RATE_CHK)       DTL_RATE_CHK" ).append("\n"); 
		query.append("		, MAX(DTL_INV_AMT_CHK)    DTL_INV_AMT_CHK" ).append("\n"); 
		query.append("		, MAX(DTL_VOL_QTY_CHK)    DTL_VOL_QTY_CHK" ).append("\n"); 
		query.append("		, MAX(DTL_VVD_CHK)        DTL_VVD_CHK" ).append("\n"); 
		query.append("		, MAX(CNTR_LIST_VVD_CHK)  CNTR_LIST_VVD_CHK" ).append("\n"); 
		query.append("		, MAX(HIT_DTL_IO_BND_CD_CHK)  HIT_DTL_IO_BND_CD_CHK" ).append("\n"); 
		query.append("        , MAX(DTL_IO_BND_CD_CHK)  DTL_IO_BND_CD_CHK" ).append("\n"); 
		query.append("		, MAX(CNTR_STY_CD_CHK)    CNTR_STY_CD_CHK" ).append("\n"); 
		query.append("		, MAX(CNTR_IO_BND_CD_CHK) CNTR_IO_BND_CD_CHK" ).append("\n"); 
		query.append("		, MAX(CNTR_CNTR_NO_CHK)   CNTR_CNTR_NO_CHK" ).append("\n"); 
		query.append("		, MAX(INV_GATE_IN_TM_MSG) INV_GATE_IN_TM_MSG" ).append("\n"); 
		query.append("		, MAX(INV_GATE_OUT_TM_MSG) INV_GATE_OUT_TM_MSG" ).append("\n"); 
		query.append("		, MAX(GATE_IN_OUT_DT_CHK) GATE_IN_OUT_DT_CHK" ).append("\n"); 
		query.append("		, MAX(FREE_POOL_WRK_DT_CHK) FREE_POOL_WRK_DT_CHK" ).append("\n"); 
		query.append("		, MAX(FREE_POOL_VOL_QTY_CHK) FREE_POOL_VOL_QTY_CHK" ).append("\n"); 
		query.append("		, MAX(AUTO_FREE_POOL_MODE_CHK) AUTO_FREE_POOL_MODE_CHK" ).append("\n"); 
		query.append("		, MAX(AUTO_FREE_POOL_WORK_DT_CHK) AUTO_FREE_POOL_WORK_DT_CHK" ).append("\n"); 
		query.append("		, MAX(AUTO_FREE_POOL_VOL_QTY_CHK) AUTO_FREE_POOL_VOL_QTY_CHK" ).append("\n"); 
		query.append("		, MAX(RF_COST_CD_TPSZ_CHK) RF_COST_CD_TPSZ_CHK" ).append("\n"); 
		query.append("		, MAX(EDI_VNDR_CHK) EDI_VNDR_CHK" ).append("\n"); 
		query.append("		, MAX(CNTR_LIST_KNT) CNTR_LIST_KNT" ).append("\n"); 
		query.append("		, MAX(DTL_LIST_KNT) DTL_LIST_KNT" ).append("\n"); 
		query.append("	FROM	(SELECT /***  HDR INFO ***/" ).append("\n"); 
		query.append("			CASE	WHEN H.TML_INV_TP_CD IS NULL" ).append("\n"); 
		query.append("				THEN 'INVOICE TYPE IS MISSING'" ).append("\n"); 
		query.append("				WHEN H.VNDR_SEQ IN ('158002','114776') AND  H.TML_INV_TP_CD NOT IN('MA','MK','MR','SC','SE','SF')" ).append("\n"); 
		query.append("				THEN 'WRONG INVOICE TYPE'" ).append("\n"); 
		query.append("				WHEN H.VNDR_SEQ IN ('180020','186666') AND H.TML_INV_TP_CD NOT IN('TM','ST')" ).append("\n"); 
		query.append("				THEN 'WRONG INVOICE TYPE'" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("			END TML_INV_TP_CD_CHK" ).append("\n"); 
		query.append("			, CASE	WHEN H.INV_OFC_CD   IS NULL THEN 'INVOICE OFFICE IS MISSING'" ).append("\n"); 
		query.append("				WHEN IO.OFC_CD      IS NULL THEN 'WRONG INVOICE OFFICE'" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("			END INV_OFC_CD_CHK" ).append("\n"); 
		query.append("			, CASE WHEN H.COST_OFC_CD  IS NULL THEN 'COST OFFICE IS MISSING'" ).append("\n"); 
		query.append("				WHEN CO.OFC_CD      IS NULL THEN 'WRONG COST OFFICE'" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("			END COST_OFC_CD_CHK" ).append("\n"); 
		query.append("			, CASE	WHEN H.VNDR_SEQ     IS NULL THEN 'S/P CODE IS MISSING'" ).append("\n"); 
		query.append("				WHEN V.VNDR_SEQ     IS NULL THEN 'WRONG S/P CODE'" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("			END VNDR_SEQ_CHK" ).append("\n"); 
		query.append("			, CASE	WHEN H.YD_CD        IS NULL THEN 'YARD CODE IS MISSING'" ).append("\n"); 
		query.append("				WHEN Y.YD_CD        IS NULL THEN 'WRONG YARD CODE'" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("			END YD_CD_CHK" ).append("\n"); 
		query.append("			, CASE	WHEN H.INV_NO       IS NULL THEN 'INVOICE No. IS MISSING'" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("			END INV_NO_CHK" ).append("\n"); 
		query.append("			, CASE	WHEN H.CURR_CD      IS NULL THEN 'CURRENCY IS MISSING'" ).append("\n"); 
		query.append("				WHEN MC.CURR_CD     IS NULL THEN 'WRONG CURRENCY'" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("			END CURR_CD_CHK" ).append("\n"); 
		query.append("			, CASE	WHEN H.TTL_INV_AMT  IS NULL THEN 'TOTAL INVOICE AMOUNT IS MISSING'" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("			END TTL_INV_AMT_CHK" ).append("\n"); 
		query.append("			, CASE	WHEN H.ISS_DT  IS NULL THEN 'ISSUE DATE IS MISSING'" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("			END ISS_DT_CHK" ).append("\n"); 
		query.append("			/*** DTL ***/" ).append("\n"); 
		query.append("			, CASE	WHEN H.VNDR_SEQ IN ('158002','114776') AND H.TML_INV_TP_CD IN('MR') AND D.TML_EDI_SO_DTL_SEQ IS NOT NULL" ).append("\n"); 
		query.append("				THEN	CASE	WHEN D.LGS_COST_CD  IS NULL THEN 'TARIFF IS MISSING AT COST LIST'" ).append("\n"); 
		query.append("						WHEN TC.LGS_COST_CD IS NULL THEN 'WRONG TARIFF AT COST LIST'" ).append("\n"); 
		query.append("						ELSE ''" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("				WHEN H.VNDR_SEQ IN ('180020','186666') AND H.TML_INV_TP_CD IN('TM') AND D.TML_EDI_SO_DTL_SEQ IS NOT NULL" ).append("\n"); 
		query.append("				THEN	CASE	WHEN D.LGS_COST_CD  IS NULL THEN 'TARIFF IS MISSING AT COST LIST'" ).append("\n"); 
		query.append("						WHEN TC.LGS_COST_CD IS NULL THEN 'WRONG TARIFF AT COST LIST'" ).append("\n"); 
		query.append("						ELSE ''" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("			END DTL_LGS_COST_CD_CHK" ).append("\n"); 
		query.append("			, CASE	WHEN H.VNDR_SEQ IN ('180020','186666') AND H.TML_INV_TP_CD IN('TM') AND D.TML_EDI_SO_DTL_SEQ IS NOT NULL AND D.CTRT_RT IS NULL -- HJNC/HJGT는 TM만 수동 비용이 가능하다." ).append("\n"); 
		query.append("				    THEN 'RATE IS MISSING AT COST LIST'" ).append("\n"); 
		query.append("                    WHEN H.VNDR_SEQ IN ('158002','114776') AND H.TML_INV_TP_CD IN('MR') AND D.TML_EDI_SO_DTL_SEQ IS NOT NULL AND D.CTRT_RT IS NULL  -- HIT/YICT는 MR만 수동 비용이 가능하다." ).append("\n"); 
		query.append("                    THEN 'RATE IS MISSING AT COST LIST'" ).append("\n"); 
		query.append("			END DTL_RATE_CHK" ).append("\n"); 
		query.append("			, CASE	WHEN H.VNDR_SEQ IN ('158002','114776') AND H.TML_INV_TP_CD IN('MR') AND D.TML_EDI_SO_DTL_SEQ IS NOT NULL" ).append("\n"); 
		query.append("				    THEN CASE WHEN D.INV_AMT IS NULL THEN 'INVOICE AMOUNT IS MISSING AT COST LIST'" ).append("\n"); 
		query.append("						 ELSE ''" ).append("\n"); 
		query.append("					     END" ).append("\n"); 
		query.append("			END DTL_INV_AMT_CHK" ).append("\n"); 
		query.append("			, CASE	WHEN H.VNDR_SEQ IN ('180020','186666') AND H.TML_INV_TP_CD IN('TM') AND D.TML_EDI_SO_DTL_SEQ IS NOT NULL AND D.CALC_VOL_QTY IS NULL -- HJNC/HJGT는 TM만 수동 비용이 가능하다." ).append("\n"); 
		query.append("				THEN 'VOLUME QTY IS MISSING AT COST LIST'" ).append("\n"); 
		query.append("                WHEN H.VNDR_SEQ IN ('158002','114776') AND H.TML_INV_TP_CD IN('MR') AND D.TML_EDI_SO_DTL_SEQ IS NOT NULL AND D.CALC_VOL_QTY IS NULL -- HIT/YICT는 MR만 수동 비용이 가능하다." ).append("\n"); 
		query.append("				THEN 'VOLUME QTY IS MISSING AT COST LIST'" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("			END DTL_VOL_QTY_CHK" ).append("\n"); 
		query.append("			, CASE	WHEN H.VNDR_SEQ IN ('158002','114776') AND H.TML_INV_TP_CD IN('MA','MK','MR')" ).append("\n"); 
		query.append("				    THEN CASE WHEN H.IO_IND_CD IS NULL" ).append("\n"); 
		query.append("						      THEN 'I/O BOUND IS MISSING AT COST LIST'" ).append("\n"); 
		query.append("						      WHEN H.IO_IND_CD NOT IN('I','O','B')" ).append("\n"); 
		query.append("						      THEN 'WRONG I/O BOUND'" ).append("\n"); 
		query.append("						      ELSE ''" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("			END HIT_DTL_IO_BND_CD_CHK" ).append("\n"); 
		query.append("            , CASE WHEN H.VNDR_SEQ IN ('180020','186666') AND H.TML_INV_TP_CD IN('TM') AND D.TML_EDI_SO_DTL_SEQ IS NOT NULL" ).append("\n"); 
		query.append("			       THEN	CASE WHEN D.IO_BND_CD IS NULL" ).append("\n"); 
		query.append("					         THEN 'I/O BOUND IS MISSING AT COST LIST'" ).append("\n"); 
		query.append("					         WHEN D.IO_BND_CD NOT IN('I','O')" ).append("\n"); 
		query.append("					         THEN 'WRONG I/O BOUND AT COST LIST'" ).append("\n"); 
		query.append("					         ELSE ''" ).append("\n"); 
		query.append("				        END" ).append("\n"); 
		query.append("			ELSE ''" ).append("\n"); 
		query.append("			END DTL_IO_BND_CD_CHK" ).append("\n"); 
		query.append("			, CASE	WHEN H.VNDR_SEQ IN ('158002','114776') AND H.TML_INV_TP_CD IN('MR')" ).append("\n"); 
		query.append("					AND D.TML_EDI_SO_DTL_SEQ IS NOT NULL AND H.IO_IND_CD IS NOT NULL AND H.IO_IND_CD IN('I','O','B')" ).append("\n"); 
		query.append("				THEN	CASE	WHEN H.IO_IND_CD IN('I') AND D.IB_VVD_CD IS NULL" ).append("\n"); 
		query.append("						THEN 'VVD IS MISSING AT COST LIST'" ).append("\n"); 
		query.append("						WHEN H.IO_IND_CD IN('O') AND D.OB_VVD_CD IS NULL" ).append("\n"); 
		query.append("						THEN 'VVD IS MISSING AT COST LIST'" ).append("\n"); 
		query.append("						WHEN H.IO_IND_CD IN('B') AND (D.IB_VVD_CD IS NULL OR D.OB_VVD_CD IS NULL)" ).append("\n"); 
		query.append("						THEN 'VVD IS MISSING AT COST LIST'" ).append("\n"); 
		query.append("						ELSE ''" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("				WHEN H.VNDR_SEQ IN ('180020','186666') AND H.TML_INV_TP_CD IN('TM') AND D.TML_EDI_SO_DTL_SEQ IS NOT NULL" ).append("\n"); 
		query.append("				THEN	CASE	WHEN D.VSL_CD IS NULL AND D.SKD_VOY_NO IS NULL AND D.SKD_DIR_CD IS NULL" ).append("\n"); 
		query.append("						THEN 'VVD MISSING AT COST LIST'" ).append("\n"); 
		query.append("						WHEN D.VSL_CD IS NULL OR D.SKD_VOY_NO IS NULL OR D.SKD_DIR_CD IS NULL" ).append("\n"); 
		query.append("						THEN 'WRONG VVD AT COST LIST'" ).append("\n"); 
		query.append("						ELSE ''" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("			END DTL_VVD_CHK" ).append("\n"); 
		query.append("			/*** CNTR LIST ***/" ).append("\n"); 
		query.append("			, CASE	WHEN H.VNDR_SEQ IN ('158002','114776') AND H.TML_INV_TP_CD IN('MA','MK') AND C.TML_EDI_SO_CNTR_LIST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("					AND H.IO_IND_CD IS NOT NULL AND H.IO_IND_CD IN('I','O','B')" ).append("\n"); 
		query.append("				THEN	CASE	WHEN H.IO_IND_CD IN('I') AND C.IB_VVD_CD IS NULL" ).append("\n"); 
		query.append("						THEN 'VVD IS MISSING AT CNTR_LIST'" ).append("\n"); 
		query.append("						WHEN H.IO_IND_CD IN('O') AND C.OB_VVD_CD IS NULL" ).append("\n"); 
		query.append("						THEN 'VVD IS MISSING AT CNTR_LIST'" ).append("\n"); 
		query.append("						WHEN H.IO_IND_CD IN('B') AND (C.IB_VVD_CD IS NULL OR C.OB_VVD_CD IS NULL)" ).append("\n"); 
		query.append("						THEN 'VVD IS MISSING AT CNTR_LIST'" ).append("\n"); 
		query.append("						ELSE ''" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("				WHEN H.VNDR_SEQ IN ('180020','186666') AND H.TML_INV_TP_CD IN('TM') AND C.TML_EDI_SO_CNTR_LIST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("				THEN	CASE	WHEN C.VSL_CD IS NULL AND C.SKD_VOY_NO IS NULL AND C.SKD_DIR_CD IS NULL" ).append("\n"); 
		query.append("						THEN 'VVD MISSING AT COST LIST'" ).append("\n"); 
		query.append("						WHEN C.VSL_CD IS NULL OR C.SKD_VOY_NO IS NULL OR C.SKD_DIR_CD IS NULL" ).append("\n"); 
		query.append("						THEN 'WRONG VVD AT COST LIST'" ).append("\n"); 
		query.append("						ELSE ''" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("			END CNTR_LIST_VVD_CHK" ).append("\n"); 
		query.append("			, CASE	WHEN  H.VNDR_SEQ IN ('158002','114776') AND H.TML_INV_TP_CD IN('MA','MK','SC','SE') AND C.TML_EDI_SO_CNTR_LIST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("				THEN	CASE	WHEN C.CNTR_STY_CD IS NULL" ).append("\n"); 
		query.append("						THEN 'FULL/EMPTY IS MISSING AT CNTR LIST'" ).append("\n"); 
		query.append("						WHEN C.CNTR_STY_CD NOT IN('F','M')" ).append("\n"); 
		query.append("						THEN 'WRONG FULL/EMPTY AT CNTR LIST'" ).append("\n"); 
		query.append("						ELSE ''" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("				WHEN  H.VNDR_SEQ IN ('180020','186666') AND H.TML_INV_TP_CD IN('TM') AND C.TML_EDI_SO_CNTR_LIST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("				THEN	CASE	WHEN C.CNTR_STY_CD IS NULL" ).append("\n"); 
		query.append("						THEN 'FULL/EMPTY IS MISSING AT CNTR LIST'" ).append("\n"); 
		query.append("						WHEN C.CNTR_STY_CD NOT IN('F','M')" ).append("\n"); 
		query.append("						THEN 'WRONG FULL/EMPTY AT CNTR LIST'" ).append("\n"); 
		query.append("						ELSE ''" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("			END  CNTR_STY_CD_CHK" ).append("\n"); 
		query.append("			, CASE	WHEN  H.VNDR_SEQ IN ('158002','114776') AND H.TML_INV_TP_CD IN('MA','MK') AND C.TML_EDI_SO_CNTR_LIST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("				THEN	CASE	WHEN C.IO_BND_CD IS NULL" ).append("\n"); 
		query.append("						THEN 'I/O BOUND IS MISSING AT CNTR LIST'" ).append("\n"); 
		query.append("						WHEN C.IO_BND_CD NOT IN('I','O','B')" ).append("\n"); 
		query.append("						THEN 'WRONG I/O BOUND AT CNTR LIST'" ).append("\n"); 
		query.append("						ELSE ''" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("			WHEN  H.VNDR_SEQ IN ('180020','186666') AND H.TML_INV_TP_CD IN('TM') AND C.TML_EDI_SO_CNTR_LIST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("			THEN	CASE	WHEN C.IO_BND_CD IS NULL" ).append("\n"); 
		query.append("					THEN 'I/O BOUND IS MISSING AT CNTR LIST'" ).append("\n"); 
		query.append("					WHEN C.IO_BND_CD NOT IN('I','O')" ).append("\n"); 
		query.append("					THEN 'WRONG I/O BOUND AT CNTR LIST'" ).append("\n"); 
		query.append("					ELSE ''" ).append("\n"); 
		query.append("				END" ).append("\n"); 
		query.append("			ELSE ''" ).append("\n"); 
		query.append("			END CNTR_IO_BND_CD_CHK" ).append("\n"); 
		query.append("			, CASE	WHEN  H.VNDR_SEQ IN ('158002','114776') AND H.TML_INV_TP_CD IN('MA','MK','SC','SE') AND C.TML_EDI_SO_CNTR_LIST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("				THEN	CASE	WHEN C.CNTR_NO IS NULL" ).append("\n"); 
		query.append("						THEN 'CNTR NO IS MISSING AT CNTR LIST'" ).append("\n"); 
		query.append("						ELSE ''" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("				WHEN  H.VNDR_SEQ IN ('180020','186666') AND H.TML_INV_TP_CD IN('TM') AND C.TML_EDI_SO_CNTR_LIST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("				THEN	CASE	WHEN C.CNTR_NO IS NULL THEN 'CNTR NO IS MISSING AT CNTR LIST'" ).append("\n"); 
		query.append("						ELSE ''" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("			END CNTR_CNTR_NO_CHK" ).append("\n"); 
		query.append("			, CASE	WHEN  H.VNDR_SEQ IN ('158002','114776') AND H.TML_INV_TP_CD IN('SC','SE') AND C.TML_EDI_SO_CNTR_LIST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("					AND C.INV_GATE_IN_TM_MSG  IS NULL" ).append("\n"); 
		query.append("				    THEN 'GATE IN DATE IS MISSING'" ).append("\n"); 
		query.append("                    WHEN  H.VNDR_SEQ IN ('186666') AND H.TML_INV_TP_CD IN('ST') AND C.TML_EDI_SO_CNTR_LIST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("					AND C.INV_GATE_IN_TM_MSG  IS NULL" ).append("\n"); 
		query.append("				    THEN 'GATE IN DATE IS MISSING'" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("			 END INV_GATE_IN_TM_MSG" ).append("\n"); 
		query.append("			, CASE	WHEN  H.VNDR_SEQ IN ('158002','114776') AND H.TML_INV_TP_CD IN('SC','SE') AND C.TML_EDI_SO_CNTR_LIST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("					AND C.INV_GATE_OUT_TM_MSG  IS NULL" ).append("\n"); 
		query.append("				    THEN 'GATE OUT DATE IS MISSING'" ).append("\n"); 
		query.append("                    WHEN  H.VNDR_SEQ IN ('186666') AND H.TML_INV_TP_CD IN('ST') AND C.TML_EDI_SO_CNTR_LIST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("					AND C.INV_GATE_OUT_TM_MSG  IS NULL" ).append("\n"); 
		query.append("                    THEN 'GATE OUT DATE IS MISSING'" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("			 END INV_GATE_OUT_TM_MSG" ).append("\n"); 
		query.append("			, CASE	WHEN  H.VNDR_SEQ IN ('158002','114776') AND H.TML_INV_TP_CD IN('SC','SE') AND C.TML_EDI_SO_CNTR_LIST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("					AND C.INV_GATE_OUT_TM_MSG < C.INV_GATE_IN_TM_MSG" ).append("\n"); 
		query.append("                    THEN 'WRONG GATE IN/OUT DATE'" ).append("\n"); 
		query.append("                    WHEN  H.VNDR_SEQ IN ('186666') AND H.TML_INV_TP_CD IN('ST') AND C.TML_EDI_SO_CNTR_LIST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("                    AND C.INV_GATE_OUT_TM_MSG < C.INV_GATE_IN_TM_MSG" ).append("\n"); 
		query.append("				    THEN 'WRONG GATE IN/OUT DATE'" ).append("\n"); 
		query.append("				    ELSE ''" ).append("\n"); 
		query.append("			 END GATE_IN_OUT_DT_CHK" ).append("\n"); 
		query.append("			, CASE	WHEN  H.VNDR_SEQ IN ('158002','114776') AND H.TML_INV_TP_CD IN('SF') AND C.TML_EDI_SO_CNTR_LIST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("					AND C.WRK_DT IS NULL" ).append("\n"); 
		query.append("				    THEN 'WORKING DATE IS MISSING'" ).append("\n"); 
		query.append("				    --WHEN  H.VNDR_SEQ IN ('180020') AND H.TML_INV_TP_CD IN('ST') AND C.TML_EDI_SO_CNTR_LIST_SEQ IS NOT NULL  --HJNC의 ST는 FP만 대상으로 한다.(ST미발생으로 미사용중)" ).append("\n"); 
		query.append("					--AND C.WRK_DT IS NULL" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("			 END FREE_POOL_WRK_DT_CHK" ).append("\n"); 
		query.append("			, CASE	WHEN  H.VNDR_SEQ IN ('158002','114776') AND H.TML_INV_TP_CD IN('SF') AND C.TML_EDI_SO_CNTR_LIST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("					AND C.INV_VOL_QTY IS NULL" ).append("\n"); 
		query.append("				THEN 'VOLUME QUANTITY IS MISSING'" ).append("\n"); 
		query.append("				--WHEN  H.VNDR_SEQ IN ('180020') AND H.TML_INV_TP_CD IN('ST') AND C.TML_EDI_SO_CNTR_LIST_SEQ IS NOT NULL --HJNC의 ST는 FP만 대상으로 한다.(ST미발생으로 미사용중)" ).append("\n"); 
		query.append("				--	AND C.INV_VOL_QTY IS NULL" ).append("\n"); 
		query.append("				--THEN 'VOLUME QUANTITY IS MISSING'" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("			 END FREE_POOL_VOL_QTY_CHK" ).append("\n"); 
		query.append("			 /*** AUTO FREE POOL LIST ***/" ).append("\n"); 
		query.append("			--, CASE	WHEN  H.VNDR_SEQ IN ('180020') AND H.TML_INV_TP_CD IN('ST') AND F.TML_EDI_SO_AUTO_FP_LIST_SEQ IS NOT NULL  " ).append("\n"); 
		query.append("			--		AND F.FP_CALC_PRD_CD IS NULL" ).append("\n"); 
		query.append("			--	THEN 'FREEPOOL MODE IS MISSING'" ).append("\n"); 
		query.append("			--	WHEN  H.VNDR_SEQ IN ('180020') AND H.TML_INV_TP_CD IN('ST') AND F.TML_EDI_SO_AUTO_FP_LIST_SEQ IS NOT NULL  " ).append("\n"); 
		query.append("			--		AND F.FP_CALC_PRD_CD NOT IN ('M','D')" ).append("\n"); 
		query.append("			--	THEN 'WRONG FREEPOOL MODE'" ).append("\n"); 
		query.append("			--	ELSE ''" ).append("\n"); 
		query.append("			--END AUTO_FREE_POOL_MODE_CHK" ).append("\n"); 
		query.append("            , '' AUTO_FREE_POOL_MODE_CHK --HJNC의 ST는 FP만 대상으로 한다.(ST미발생으로 미사용중- 추가 요청시 개발 예정)" ).append("\n"); 
		query.append("			--, CASE	WHEN  H.VNDR_SEQ IN ('180020') AND H.TML_INV_TP_CD IN('ST') AND F.TML_EDI_SO_AUTO_FP_LIST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("			--		AND F.WRK_DT IS NULL" ).append("\n"); 
		query.append("			--	THEN 'WORKING DATE IS MISSING'" ).append("\n"); 
		query.append("			--	ELSE ''" ).append("\n"); 
		query.append("			--END AUTO_FREE_POOL_WORK_DT_CHK" ).append("\n"); 
		query.append("            , '' AUTO_FREE_POOL_WORK_DT_CHK --HJNC의 ST는 FP만 대상으로 한다.(ST미발생으로 미사용중- 추가 요청시 개발 예정)" ).append("\n"); 
		query.append("			--, CASE	WHEN  H.VNDR_SEQ IN ('180020') AND H.TML_INV_TP_CD IN('ST') AND F.TML_EDI_SO_AUTO_FP_LIST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("			--	AND F.INV_VOL_QTY IS NULL" ).append("\n"); 
		query.append("			--	THEN 'VOLUME QUANTITY IS MISSING'" ).append("\n"); 
		query.append("			--	ELSE ''" ).append("\n"); 
		query.append("			--END AUTO_FREE_POOL_VOL_QTY_CHK" ).append("\n"); 
		query.append("            , '' AUTO_FREE_POOL_VOL_QTY_CHK --HJNC의 ST는 FP만 대상으로 한다.(ST미발생으로 미사용중- 추가 요청시 개발 예정)" ).append("\n"); 
		query.append("			-- CHM-201432352 [TESLEA] 철도운송 RF 화물 Genset 관련 Cost Code 생성 (TMRFGR) 추가 - 4347-10-13" ).append("\n"); 
		query.append("			, CASE WHEN D.LGS_COST_CD IS NOT NULL AND D.LGS_COST_CD IN ('SVSCRF','TMRFGO','TMRFMO','TMRFPL','TMRFPT','TMRFXX','TMRFGR') " ).append("\n"); 
		query.append("				   AND (TES_GET_EDI_CNTR_TPSZ_CD_FNC(H.VNDR_SEQ,D.CNTR_TPSZ_CD) IS NULL OR SUBSTR(TES_GET_EDI_CNTR_TPSZ_CD_FNC(H.VNDR_SEQ,D.CNTR_TPSZ_CD),1,1) != 'R')" ).append("\n"); 
		query.append("				   THEN 'WRONG CONTAINER TYPE SIZE AT COST LIST'" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("			   END RF_COST_CD_TPSZ_CHK" ).append("\n"); 
		query.append("			, CASE WHEN H.VNDR_SEQ NOT IN ('158002','114776','180020','186666','176307') -- 여기에 있는 S/P만 EDI를 허용한다." ).append("\n"); 
		query.append("				THEN 'S/P NOT ALLOWED'" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("				END EDI_VNDR_CHK" ).append("\n"); 
		query.append("			, H.VNDR_SEQ, H.INV_NO" ).append("\n"); 
		query.append("			, COUNT(C.TML_EDI_SO_CNTR_LIST_SEQ) OVER () AS CNTR_LIST_KNT" ).append("\n"); 
		query.append("			, COUNT(D.TML_EDI_SO_DTL_SEQ) OVER () AS DTL_LIST_KNT" ).append("\n"); 
		query.append("		 FROM    TES_EDI_SO_HDR H" ).append("\n"); 
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