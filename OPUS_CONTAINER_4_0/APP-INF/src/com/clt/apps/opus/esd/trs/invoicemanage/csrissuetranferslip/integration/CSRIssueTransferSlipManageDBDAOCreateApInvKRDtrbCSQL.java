/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOCreateApInvKRDtrbCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOCreateApInvKRDtrbCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AP Detail 테이블에 자료 입력(KR)
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOCreateApInvKRDtrbCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CSR_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_INV_AUD_STS_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CNT_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_TAX_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CRE_USR_ID",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_VNDR_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOCreateApInvKRDtrbCSQL").append("\n"); 
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
		query.append("INSERT INTO		AP_INV_DTRB (																						" ).append("\n"); 
		query.append("		CSR_NO		                                                                        " ).append("\n"); 
		query.append("	,	TRSP_SO_TP_CD                                                                      	" ).append("\n"); 
		query.append("	,	SO_OFC_CTY_CD                                                                      	" ).append("\n"); 
		query.append("	,	SO_SEQ                                                                      		" ).append("\n"); 
		query.append("	,	LINE_SEQ				                                                        	" ).append("\n"); 
		query.append("	,	LINE_NO					                                                        	" ).append("\n"); 
		query.append("	,	LINE_TP_LU_CD                                                                   	" ).append("\n"); 
		query.append("	,	INV_AMT																				" ).append("\n"); 
		query.append("	,	INV_DESC																			" ).append("\n"); 
		query.append("	,	INV_TAX_CD																			" ).append("\n"); 
		query.append("	,	DTRB_COA_CO_CD																		" ).append("\n"); 
		query.append("	,	DTRB_COA_RGN_CD																		" ).append("\n"); 
		query.append("	,	DTRB_COA_CTR_CD																		" ).append("\n"); 
		query.append("	,	DTRB_COA_ACCT_CD																	" ).append("\n"); 
		query.append("	,	DTRB_COA_VVD_CD																		" ).append("\n"); 
		query.append("	,	DTRB_COA_INTER_CO_CD																" ).append("\n"); 
		query.append("	,	DTRB_COA_FTU_N1ST_CD																" ).append("\n"); 
		query.append("	,	DTRB_COA_FTU_N2ND_CD																" ).append("\n"); 
		query.append("	,	ATTR_CATE_NM																		" ).append("\n"); 
		query.append("	,	ATTR_CTNT1																			" ).append("\n"); 
		query.append("	,	ATTR_CTNT2																			" ).append("\n"); 
		query.append("	,	ATTR_CTNT3																			" ).append("\n"); 
		query.append("	,	ATTR_CTNT4																			" ).append("\n"); 
		query.append("	,	ATTR_CTNT5																			" ).append("\n"); 
		query.append("	,	ATTR_CTNT6																			" ).append("\n"); 
		query.append("	,	ATTR_CTNT7																			" ).append("\n"); 
		query.append("	,	ATTR_CTNT8																			" ).append("\n"); 
		query.append("	,	ATTR_CTNT9																			" ).append("\n"); 
		query.append("	,	ATTR_CTNT10																			" ).append("\n"); 
		query.append("	,	ATTR_CTNT11																			" ).append("\n"); 
		query.append("	,	ATTR_CTNT12																			" ).append("\n"); 
		query.append("	,	ATTR_CTNT13																			" ).append("\n"); 
		query.append("	,	ATTR_CTNT14																			" ).append("\n"); 
		query.append("	,	ATTR_CTNT15																			" ).append("\n"); 
		query.append("	,	BKG_NO																				" ).append("\n"); 
		query.append("	,	CNTR_TPSZ_CD																		" ).append("\n"); 
		query.append("	,	ACT_VVD_CD																			" ).append("\n"); 
		query.append("	,	PLN_SCTR_DIV_CD																		" ).append("\n"); 
		query.append("	,	SO_CRR_CD																			" ).append("\n"); 
		query.append("	,	YD_CD																				" ).append("\n"); 
		query.append("	,	FTU_USE_CTNT1																		" ).append("\n"); 
		query.append("	,	FTU_USE_CTNT2																		" ).append("\n"); 
		query.append("	,	FTU_USE_CTNT3																		" ).append("\n"); 
		query.append("	,	FTU_USE_CTNT4																		" ).append("\n"); 
		query.append("	,	FTU_USE_CTNT5                                                                       " ).append("\n"); 
		query.append("	,	CRE_DT																				" ).append("\n"); 
		query.append("	,	CRE_USR_ID																			" ).append("\n"); 
		query.append("	,	EAI_EVNT_DT			                                                            	" ).append("\n"); 
		query.append(")                                                                                                " ).append("\n"); 
		query.append("SELECT	CSR_NO																				" ).append("\n"); 
		query.append("	,	TRSP_SO_TP_CD			TRSP_SO_TP_CD												" ).append("\n"); 
		query.append("	,	TRSP_SO_OFC_CTY_CD		SO_OFC_CTY_CD												" ).append("\n"); 
		query.append("	,	TRSP_SO_SEQ				SO_SEQ														" ).append("\n"); 
		query.append("	,	(SELECT MAX(LINE_SEQ)+1 FROM AP_INV_DTRB WHERE CSR_NO = @[CSR_NO] ) LINE_SEQ				" ).append("\n"); 
		query.append("	,	(SELECT MAX(LINE_NO)+1  FROM AP_INV_DTRB WHERE CSR_NO = @[CSR_NO] ) LINE_NO					" ).append("\n"); 
		query.append("	,	LINE_TP_LU_CD																		" ).append("\n"); 
		query.append("	,	CSR_AMT					INV_AMT														" ).append("\n"); 
		query.append("	,	INV_DESC																			" ).append("\n"); 
		query.append("	,	INV_TAX_CD																			" ).append("\n"); 
		query.append("	,	DTRB_COA_CO_CD																		" ).append("\n"); 
		query.append("	,	DTRB_COA_RGN_CD																		" ).append("\n"); 
		query.append("	,	DTRB_COA_CTR_CD																		" ).append("\n"); 
		query.append("	,	DTRB_COA_ACCT_CD																	" ).append("\n"); 
		query.append("	,	DTRB_COA_VVD_CD																		" ).append("\n"); 
		query.append("	,	DTRB_COA_INTER_CO_CD																" ).append("\n"); 
		query.append("	,	DTRB_COA_FTU_N1ST_CD																" ).append("\n"); 
		query.append("	,	DTRB_COA_FTU_N2ND_CD																" ).append("\n"); 
		query.append("	,	ATTR_CATE_NM																		" ).append("\n"); 
		query.append("	,	ATTR_CTNT1																			" ).append("\n"); 
		query.append("	,	ATTR_CTNT2																			" ).append("\n"); 
		query.append("	,	ATTR_CTNT3																			" ).append("\n"); 
		query.append("	,	ATTR_CTNT4																			" ).append("\n"); 
		query.append("	,	ATTR_CTNT5																			" ).append("\n"); 
		query.append("	,	ATTR_CTNT6																			" ).append("\n"); 
		query.append("	,	ATTR_CTNT7																			" ).append("\n"); 
		query.append("	,	ATTR_CTNT8																			" ).append("\n"); 
		query.append("	,	ATTR_CTNT9																			" ).append("\n"); 
		query.append("	,	ATTR_CTNT10																			" ).append("\n"); 
		query.append("	,	ATTR_CTNT11																			" ).append("\n"); 
		query.append("	,	ATTR_CTNT12																			" ).append("\n"); 
		query.append("	,	ATTR_CTNT13																			" ).append("\n"); 
		query.append("	,DECODE(K.DTRB_COA_VVD_CD, '0000000000', 'COM', NVL(" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT O.SLAN_CD " ).append("\n"); 
		query.append("			FROM AR_MST_REV_VVD O" ).append("\n"); 
		query.append("			WHERE O.VSL_CD = substr(K.DTRB_COA_VVD_CD, 1, 4)" ).append("\n"); 
		query.append("			AND O.SKD_VOY_NO = substr(K.DTRB_COA_VVD_CD, 5, 4)" ).append("\n"); 
		query.append("			AND O.SKD_DIR_CD = substr(K.DTRB_COA_VVD_CD, 9, 1)" ).append("\n"); 
		query.append("			AND O.RLANE_DIR_CD = substr(K.DTRB_COA_VVD_CD, 10, 1)		" ).append("\n"); 
		query.append("		) , 'COM')" ).append("\n"); 
		query.append("	 )	ATTR_CTNT14				" ).append("\n"); 
		query.append("	,	ATTR_CTNT15																			" ).append("\n"); 
		query.append("	,	BKG_NO																				" ).append("\n"); 
		query.append("	,	CNTR_TPSZ_CD																		" ).append("\n"); 
		query.append("	,	ACT_VVD_CD																			" ).append("\n"); 
		query.append("	,	PLN_SCTR_DIV_CD																		" ).append("\n"); 
		query.append("	,	SO_CRR_CD																			" ).append("\n"); 
		query.append("	,	YD_CD																				" ).append("\n"); 
		query.append("	,	FTU_USE_CTNT1																		" ).append("\n"); 
		query.append("	,	FTU_USE_CTNT2																		" ).append("\n"); 
		query.append("	,	FTU_USE_CTNT3																		" ).append("\n"); 
		query.append("	,	FTU_USE_CTNT4																		" ).append("\n"); 
		query.append("	,	FTU_USE_CTNT5																		" ).append("\n"); 
		query.append("	,	CRE_DT																				" ).append("\n"); 
		query.append("	,	CRE_USR_ID																			" ).append("\n"); 
		query.append("	,	EAI_EVNT_DT																			" ).append("\n"); 
		query.append("FROM (																					" ).append("\n"); 
		query.append("	SELECT		CSR_NO																	" ).append("\n"); 
		query.append("		,	TRSP_SO_TP_CD															" ).append("\n"); 
		query.append("		,	TRSP_SO_OFC_CTY_CD														" ).append("\n"); 
		query.append("		,	TRSP_SO_SEQ																" ).append("\n"); 
		query.append("		,	LINE_SEQ																" ).append("\n"); 
		query.append("		,	LINE_NO																	" ).append("\n"); 
		query.append("		,	LINE_TP_LU_CD															" ).append("\n"); 
		query.append("		,	CSR_AMT																	" ).append("\n"); 
		query.append("		,	INV_DESC																" ).append("\n"); 
		query.append("		,	INV_TAX_CD																" ).append("\n"); 
		query.append("		,	DTRB_COA_CO_CD															" ).append("\n"); 
		query.append("		,	DTRB_COA_RGN_CD															" ).append("\n"); 
		query.append("		,	DTRB_COA_CTR_CD															" ).append("\n"); 
		query.append("		,	DTRB_COA_ACCT_CD														" ).append("\n"); 
		query.append("		,	DTRB_COA_VVD_CD															" ).append("\n"); 
		query.append("		,	DTRB_COA_INTER_CO_CD													" ).append("\n"); 
		query.append("		,	DTRB_COA_FTU_N1ST_CD													" ).append("\n"); 
		query.append("		,	DTRB_COA_FTU_N2ND_CD													" ).append("\n"); 
		query.append("		,	ATTR_CATE_NM															" ).append("\n"); 
		query.append("		,	ATTR_CTNT1																" ).append("\n"); 
		query.append("		,	ATTR_CTNT2																" ).append("\n"); 
		query.append("		,	ATTR_CTNT3																" ).append("\n"); 
		query.append("		,	ATTR_CTNT4																" ).append("\n"); 
		query.append("		,	ATTR_CTNT5																" ).append("\n"); 
		query.append("		,	ATTR_CTNT6																" ).append("\n"); 
		query.append("		,	ATTR_CTNT7																" ).append("\n"); 
		query.append("		,	ATTR_CTNT8																" ).append("\n"); 
		query.append("		,	ATTR_CTNT9																" ).append("\n"); 
		query.append("		,	ATTR_CTNT10																" ).append("\n"); 
		query.append("		,	ATTR_CTNT11																" ).append("\n"); 
		query.append("		,	ATTR_CTNT12																" ).append("\n"); 
		query.append("		,	ATTR_CTNT13																" ).append("\n"); 
		query.append("		,	ATTR_CTNT14																" ).append("\n"); 
		query.append("		,	ATTR_CTNT15																" ).append("\n"); 
		query.append("		,	BKG_NO																	" ).append("\n"); 
		query.append("		,	CNTR_TPSZ_CD															" ).append("\n"); 
		query.append("		,	ACT_VVD_CD																" ).append("\n"); 
		query.append("		,	PLN_SCTR_DIV_CD															" ).append("\n"); 
		query.append("		,	SO_CRR_CD																" ).append("\n"); 
		query.append("		,	YD_CD																	" ).append("\n"); 
		query.append("		,	FTU_USE_CTNT1															" ).append("\n"); 
		query.append("		,	FTU_USE_CTNT2															" ).append("\n"); 
		query.append("		,	FTU_USE_CTNT3															" ).append("\n"); 
		query.append("		,	FTU_USE_CTNT4															" ).append("\n"); 
		query.append("		,	FTU_USE_CTNT5															" ).append("\n"); 
		query.append("		,	CRE_DT																	" ).append("\n"); 
		query.append("		,	CRE_USR_ID																" ).append("\n"); 
		query.append("		,	EAI_EVNT_DT																" ).append("\n"); 
		query.append("	FROM	(																		" ).append("\n"); 
		query.append("			SELECT 	@[CSR_NO]           				CSR_NO											" ).append("\n"); 
		query.append("				,	TRSP_SO_TP_CD																" ).append("\n"); 
		query.append("				,	TRSP_SO_OFC_CTY_CD															" ).append("\n"); 
		query.append("				,	TRSP_SO_SEQ																	" ).append("\n"); 
		query.append("				,	''          				LINE_SEQ										" ).append("\n"); 
		query.append("				,	''            				LINE_NO											" ).append("\n"); 
		query.append("				,	'TAX'						LINE_TP_LU_CD									" ).append("\n"); 
		query.append("				,	NVL(SUM(CSR_AMT),0)			CSR_AMT											" ).append("\n"); 
		query.append("				,	(SELECT ACCT_ENG_NM	FROM MDM_ACCOUNT WHERE ACCT_CD = '111811' )   INV_DESC			" ).append("\n"); 
		query.append("				,	CASE WHEN @[TRSP_INV_AUD_STS_CD] = 'CF'	 THEN 	" ).append("\n"); 
		query.append("						(SELECT SLD.LU_DESC" ).append("\n"); 
		query.append("							FROM sco_lu_hdr SLH, SCO_LU_DTL SLD" ).append("\n"); 
		query.append("								WHERE SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("								AND SLH.LU_TP_CD = 'AP TAX CODE'" ).append("\n"); 
		query.append("								AND NVL(SLD.enbl_flg , 'Y') = 'Y'" ).append("\n"); 
		query.append("								AND NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE AND SLH.LU_APPL_CD = 'SAP'" ).append("\n"); 
		query.append("								AND SLD.ATTR_CTNT2= 'Y'" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("						ELSE @[INV_TAX_CD] END	INV_TAX_CD						" ).append("\n"); 
		query.append("				,	'01'						DTRB_COA_CO_CD									" ).append("\n"); 
		query.append("				,	MAX(DTRB_COA_RGN_CD)		DTRB_COA_RGN_CD									" ).append("\n"); 
		query.append("				,	MAX(DTRB_COA_CTR_CD)		DTRB_COA_CTR_CD									" ).append("\n"); 
		query.append("				,	'111811'							DTRB_COA_ACCT_CD								" ).append("\n"); 
		query.append("				,	'0000000000'				DTRB_COA_VVD_CD									" ).append("\n"); 
		query.append("				,	MAX(DTRB_COA_INTER_CO_CD)	DTRB_COA_INTER_CO_CD							" ).append("\n"); 
		query.append("				,	'000000'                    DTRB_COA_FTU_N1ST_CD							" ).append("\n"); 
		query.append("				,	'000000'                    DTRB_COA_FTU_N2ND_CD							" ).append("\n"); 
		query.append("				,	'111811'					ATTR_CATE_NM									" ).append("\n"); 
		query.append("				,	MAX(ATTR_CTNT1)				ATTR_CTNT1																				" ).append("\n"); 
		query.append("				,	MAX(ATTR_CTNT2)				ATTR_CTNT2																				" ).append("\n"); 
		query.append("				,	MAX(ATTR_CTNT3)				ATTR_CTNT3																				" ).append("\n"); 
		query.append("				,	NULL                        ATTR_CTNT4																				" ).append("\n"); 
		query.append("				,	NULL                        ATTR_CTNT5																				" ).append("\n"); 
		query.append("				,	NULL                        ATTR_CTNT6																				" ).append("\n"); 
		query.append("				,	NULL                        ATTR_CTNT7																				" ).append("\n"); 
		query.append("				,	NULL			            ATTR_CTNT8																				" ).append("\n"); 
		query.append("				,	NULL                        ATTR_CTNT9																				" ).append("\n"); 
		query.append("				,	NULL                        ATTR_CTNT10																				" ).append("\n"); 
		query.append("				,	MAX(ATTR_CTNT11)            ATTR_CTNT11																				" ).append("\n"); 
		query.append("				,	MAX(ATTR_CTNT12)            ATTR_CTNT12																				" ).append("\n"); 
		query.append("				,	NULL            			ATTR_CTNT13																				" ).append("\n"); 
		query.append("				,	NULL                        ATTR_CTNT14																				" ).append("\n"); 
		query.append("				,	NULL                        ATTR_CTNT15																				" ).append("\n"); 
		query.append("				,	NULL                        BKG_NO																					" ).append("\n"); 
		query.append("				,	NULL                        CNTR_TPSZ_CD																			" ).append("\n"); 
		query.append("				,	NULL                        ACT_VVD_CD																				" ).append("\n"); 
		query.append("				,	NULL                        PLN_SCTR_DIV_CD																			" ).append("\n"); 
		query.append("				,	NULL                        SO_CRR_CD																				" ).append("\n"); 
		query.append("				,	NULL                        YD_CD																					" ).append("\n"); 
		query.append("				,	NULL                        FTU_USE_CTNT1																			" ).append("\n"); 
		query.append("				,	NULL                        FTU_USE_CTNT2																			" ).append("\n"); 
		query.append("				,	NULL                        FTU_USE_CTNT3																			" ).append("\n"); 
		query.append("				,	NULL                        FTU_USE_CTNT4																			" ).append("\n"); 
		query.append("				,	NULL                        FTU_USE_CTNT5																			" ).append("\n"); 
		query.append("				,	SYSDATE                     CRE_DT																					" ).append("\n"); 
		query.append("				,	@[CRE_USR_ID]                   		CRE_USR_ID																				" ).append("\n"); 
		query.append("				,	''                          EAI_EVNT_DT																				" ).append("\n"); 
		query.append("		FROM	(																													" ).append("\n"); 
		query.append("					SELECT		INV_WRK.INV_VAT_AMT						CSR_AMT															" ).append("\n"); 
		query.append("							,	NULL	TRSP_SO_TP_CD																					" ).append("\n"); 
		query.append("							,	NULL	TRSP_SO_OFC_CTY_CD																				" ).append("\n"); 
		query.append("							,	NULL	TRSP_SO_SEQ																						" ).append("\n"); 
		query.append("							,	FINC_RGN_CD								DTRB_COA_RGN_CD													" ).append("\n"); 
		query.append("							,	AP_CTR_CD								DTRB_COA_CTR_CD													" ).append("\n"); 
		query.append("							,	NVL(SUBS_CO_CD,'00')					DTRB_COA_INTER_CO_CD											" ).append("\n"); 
		query.append("							,	SVC_ORD.INV_NO							ATTR_CTNT1														" ).append("\n"); 
		query.append("							,	TO_CHAR(INV_WRK.INV_ISS_DT,'YYYYMMDD')  ATTR_CTNT2														" ).append("\n"); 
		query.append("							,	MDM_ORG.LOC_CD							ATTR_CTNT3	" ).append("\n"); 
		query.append("							,	TO_CHAR(INV_WRK.INV_ISS_DT,'YYYYMMDD')  ATTR_CTNT11														" ).append("\n"); 
		query.append("							,	MDM_ORG.LOC_CD							ATTR_CTNT12												" ).append("\n"); 
		query.append("					FROM		TRS_TRSP_INV_WRK						INV_WRK																			" ).append("\n"); 
		query.append("							,	MDM_ACCOUNT								ACCT_NM																			" ).append("\n"); 
		query.append("							,	TRS_TRSP_SVC_ORD						SVC_ORD																			" ).append("\n"); 
		query.append("							,	MDM_ORGANIZATION						MDM_ORG																			" ).append("\n"); 
		query.append("							,	MDM_VENDOR								MDM_VNDR																		" ).append("\n"); 
		query.append("					WHERE		ACCT_NM.ACCT_CD							= SVC_ORD.ACCT_CD																" ).append("\n"); 
		query.append("					AND			INV_WRK.INV_NO							= SVC_ORD.INV_NO																" ).append("\n"); 
		query.append("					AND			INV_WRK.INV_VNDR_SEQ					= SVC_ORD.INV_VNDR_SEQ															" ).append("\n"); 
		query.append("					AND			MDM_ORG.OFC_CD							= INV_WRK.CRE_OFC_CD															" ).append("\n"); 
		query.append("					AND			MDM_VNDR.VNDR_SEQ						= SVC_ORD.INV_VNDR_SEQ															" ).append("\n"); 
		query.append("#if ($INV_NO.size() > 0) " ).append("\n"); 
		query.append("					AND	INV_WRK.INV_NO IN  (" ).append("\n"); 
		query.append("	#foreach( ${key} in ${INV_NO}) " ).append("\n"); 
		query.append("		#if($velocityCount < $INV_NO.size()) " ).append("\n"); 
		query.append("			'$key', " ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			'$key' " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("					AND			INV_WRK.INV_VNDR_SEQ					= @[INV_VNDR_SEQ]                                   											" ).append("\n"); 
		query.append("					AND			TRSP_INV_AUD_STS_CD						= @[TRSP_INV_AUD_STS_CD]" ).append("\n"); 
		query.append("					AND			NVL(SVC_ORD.DELT_FLG,'N')   			= 'N'                              																	" ).append("\n"); 
		query.append("					AND			NVL(INV_HLD_FLG,'N')    				= 'N'     																		" ).append("\n"); 
		query.append("					AND			INV_WRK.DELT_FLG        				= 'N'       																	" ).append("\n"); 
		query.append("					AND			'JP'									=  @[CNT_CD]" ).append("\n"); 
		query.append("					GROUP BY    INV_WRK.INV_VAT_AMT																						" ).append("\n"); 
		query.append("							,	FINC_RGN_CD																								" ).append("\n"); 
		query.append("							,	AP_CTR_CD																								" ).append("\n"); 
		query.append("							,	NVL(SUBS_CO_CD,'00')																					" ).append("\n"); 
		query.append("							,	SVC_ORD.INV_NO																							" ).append("\n"); 
		query.append("							,	TO_CHAR(INV_WRK.INV_ISS_DT,'YYYYMMDD')																	" ).append("\n"); 
		query.append("							,	MDM_ORG.LOC_CD																							" ).append("\n"); 
		query.append("		) A																																" ).append("\n"); 
		query.append("		GROUP BY 	TRSP_SO_TP_CD,	TRSP_SO_OFC_CTY_CD,	TRSP_SO_SEQ,	DTRB_COA_RGN_CD																										" ).append("\n"); 
		query.append("	) 																																			" ).append("\n"); 
		query.append(") K" ).append("\n"); 

	}
}