/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSearchEurTroRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOSearchEurTroRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransferOrderIssueDBDAOSearchEurTroRSQL
	  * 2010.10.19 신자영 [CHM-201006495-01] TRO (KOR) Status 변경 (User ID 및 정렬 순서)
	  * </pre>
	  */
	public TransferOrderIssueDBDAOSearchEurTroRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOSearchEurTroRSQL").append("\n"); 
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
		query.append("SELECT  TRO.BKG_NO" ).append("\n"); 
		query.append("        , TRO.IO_BND_CD" ).append("\n"); 
		query.append("	    , TRO.TRO_SEQ " ).append("\n"); 
		query.append("        , TRO.RQST_SUB_SEQ" ).append("\n"); 
		query.append("        , TRO.CNTR_NO" ).append("\n"); 
		query.append("        , TRO.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , TRO.CNTR_TPSZ_CD CNTR_TPSZ_CD_OLD " ).append("\n"); 
		query.append("        , (SELECT DECODE(COUNT(1), 0, 'N', 'Y') MULTI" ).append("\n"); 
		query.append("              FROM BKG_CONTAINER CNTR1 " ).append("\n"); 
		query.append("                    , BKG_BOOKING BK1" ).append("\n"); 
		query.append("                    , BKG_CONTAINER CNTR2 " ).append("\n"); 
		query.append("                    , BKG_BOOKING BK2" ).append("\n"); 
		query.append("             WHERE BK1.BKG_NO       = CNTR1.BKG_NO" ).append("\n"); 
		query.append("               AND BK2.BKG_NO       = CNTR2.BKG_NO" ).append("\n"); 
		query.append("			   AND BK1.BKG_NO       <>BK2.BKG_NO" ).append("\n"); 
		query.append("               AND CNTR1.CNTR_NO    = CNTR2.CNTR_NO " ).append("\n"); 
		query.append("               AND CNTR1.CNMV_ID_NO = CNTR2.CNMV_ID_NO" ).append("\n"); 
		query.append("               AND CNTR1.CNMV_CYC_NO= CNTR2.CNMV_CYC_NO   " ).append("\n"); 
		query.append("               AND CNTR1.CNMV_YR    = CNTR2.CNMV_YR" ).append("\n"); 
		query.append("               AND BK1.BKG_STS_CD   <> 'X'" ).append("\n"); 
		query.append("               AND BK2.BKG_STS_CD   <> 'X'" ).append("\n"); 
		query.append("               AND NVL(BK1.SPLIT_RSN_CD, 'N') <> 'M' " ).append("\n"); 
		query.append("               AND NVL(BK2.SPLIT_RSN_CD, 'N') <> 'M'" ).append("\n"); 
		query.append("			   AND BK1.BKG_NO		= TRO.BKG_NO" ).append("\n"); 
		query.append("               AND 'N'				= TRO.CXL_FLG" ).append("\n"); 
		query.append("			   AND 'I'				= TRO.IO_BND_CD" ).append("\n"); 
		query.append("               AND CNTR1.CNTR_NO    = TRO.CNTR_NO) CNTR_PRT_FLG" ).append("\n"); 
		query.append("        , RC_SEQ" ).append("\n"); 
		query.append("        , AWK_CGO_SEQ" ).append("\n"); 
		query.append("        , TRO.HLG_TP_CD" ).append("\n"); 
		query.append("        , TRO.HLG_TP_CD HLG_TP_CD_OLD " ).append("\n"); 
		query.append("        , TRO.CGO_WGT" ).append("\n"); 
		query.append("        , TRO.CNTR_PKUP_YD_CD" ).append("\n"); 
		query.append("        , TRO.CNTR_RTN_YD_CD" ).append("\n"); 
		query.append("        , TO_CHAR(TRO.CNTR_RTN_DT, 'YYYY-MM-DD') CNTR_RTN_DT" ).append("\n"); 
		query.append("        , TO_CHAR(TRO.CNTR_RTN_DT, 'HH24:MI') CNTR_RTN_DT_HHMI" ).append("\n"); 
		query.append("        , TRO.CMDT_CD TRO_CMDT_CD" ).append("\n"); 
		query.append("        , TRO.REP_CMDT_CD" ).append("\n"); 
		query.append("        , TRO.REP_CMDT_DESC REP_CMDT_NM" ).append("\n"); 
		query.append("        , TRO.BKG_TRSP_MZD_CD" ).append("\n"); 
		query.append("        , TO_CHAR(TRO.CNTR_PKUP_DT, 'YYYY-MM-DD') CNTR_PKUP_DT" ).append("\n"); 
		query.append("        , TO_CHAR(TRO.CNTR_PKUP_DT, 'HH24:MI') CNTR_PKUP_DT_HHMI        " ).append("\n"); 
		query.append("        , TRO.SPCL_INSTR_RMK" ).append("\n"); 
		query.append("        , TRO.CFM_FLG" ).append("\n"); 
		query.append("        , TO_CHAR(TRO.CFM_DT, 'YYYY-MM-DD HH24:MI') CFM_DT" ).append("\n"); 
		query.append("        , TRO.CFM_OFC_CD CFM_OFC_CD" ).append("\n"); 
		query.append("        , TRO.CFM_USR_ID CFM_USR_ID" ).append("\n"); 
		query.append("        , (SELECT USR_NM FROM COM_USER WHERE USR_ID = TRO.CFM_USR_ID) CFM_USR_NM" ).append("\n"); 
		query.append("--        , DECODE(TRO.CNTR_CFM_FLG, 'Y', TRO.SO_CTY_CD        ||TRIM(TO_CHAR(TRO.SO_SEQ_NO,  '00000009'))," ).append("\n"); 
		query.append("--									    SO.TRSP_SO_OFC_CTY_CD||TRIM(TO_CHAR(SO.TRSP_SO_SEQ, '00000009'))||" ).append("\n"); 
		query.append("--				DECODE((SELECT distinct so_plan.trsp_so_sts_cd" ).append("\n"); 
		query.append("--                           FROM sce_pln_so_list so_plan" ).append("\n"); 
		query.append("--                          WHERE so_plan.cop_no         = so.cop_no" ).append("\n"); 
		query.append("--                            AND so_plan.PCTL_IO_BND_CD = tro.io_bnd_cd" ).append("\n"); 
		query.append("--                            AND so_plan.COST_ACT_GRP_CD LIKE DECODE(tro.io_bnd_cd, 'O', 'OD', 'ID')||'%')" ).append("\n"); 
		query.append("--                           , 'F', '(FR)', '')) SO_NO" ).append("\n"); 
		query.append("--        , DECODE(TRO.CNTR_CFM_FLG, 'Y', TO_CHAR(TRO.CFM_UPD_DT, 'YYYY-MM-DD HH24:MI')," ).append("\n"); 
		query.append("--										TO_CHAR(SO.CRE_DT,      'YYYY-MM-DD HH24:MI')) SO_DT" ).append("\n"); 
		query.append("--        , DECODE(TRO.CNTR_CFM_FLG, 'Y', (SELECT OFC_CD FROM COM_USER WHERE USR_ID = TRO.CNTR_CFM_USR_ID)," ).append("\n"); 
		query.append("--										(SELECT OFC_CD FROM COM_USER WHERE USR_ID = SO.CRE_USR_ID)) SO_OFC_CD" ).append("\n"); 
		query.append("--        , DECODE(TRO.CNTR_CFM_FLG, 'Y', TRO.CNTR_CFM_USR_ID, SO.CRE_USR_ID) SO_USR_ID          " ).append("\n"); 
		query.append("--        , DECODE(TRO.CNTR_CFM_FLG, 'Y', (SELECT USR_NM FROM COM_USER WHERE USR_ID = TRO.CNTR_CFM_USR_ID)," ).append("\n"); 
		query.append("--									    (SELECT USR_NM FROM COM_USER WHERE USR_ID = SO.CRE_USR_ID)) SO_USR_NM" ).append("\n"); 
		query.append("        , DECODE(TRO.HLG_TP_CD, 'M', TRO.SO_CTY_CD || TRIM(TO_CHAR(TRO.SO_SEQ_NO,  '00000009'))" ).append("\n"); 
		query.append("                              , SO.TRSP_SO_OFC_CTY_CD || TRIM(TO_CHAR(SO.TRSP_SO_SEQ, '00000009')) || DECODE(TRSP_FRST_FLG, 'Y', '(FR)', '')) SO_NO" ).append("\n"); 
		query.append("--        , DECODE(TRO.HLG_TP_CD, 'M', TO_CHAR(TRO.CFM_UPD_DT, 'YYYY-MM-DD HH24:MI')," ).append("\n"); 
		query.append("--										TO_CHAR(SO.CRE_DT,      'YYYY-MM-DD HH24:MI')) SO_DT" ).append("\n"); 
		query.append("        , DECODE(TRO.HLG_TP_CD, 'M', TO_CHAR(CIM.STK_EVNT_DT, 'YYYY-MM-DD HH24:MI')," ).append("\n"); 
		query.append("										TO_CHAR(SO.LOCL_CRE_DT,      'YYYY-MM-DD HH24:MI')) SO_DT" ).append("\n"); 
		query.append("        , DECODE(TRO.HLG_TP_CD, 'M', (SELECT OFC_CD FROM COM_USER WHERE USR_ID = TRO.CNTR_CFM_USR_ID)," ).append("\n"); 
		query.append("										(SELECT OFC_CD FROM COM_USER WHERE USR_ID = SO.CRE_USR_ID)) SO_OFC_CD" ).append("\n"); 
		query.append("        , DECODE(TRO.HLG_TP_CD, 'M', TRO.CNTR_CFM_USR_ID, SO.CRE_USR_ID) SO_USR_ID          " ).append("\n"); 
		query.append("        , DECODE(TRO.HLG_TP_CD, 'M', (SELECT USR_NM FROM COM_USER WHERE USR_ID = TRO.CNTR_CFM_USR_ID)," ).append("\n"); 
		query.append("									    (SELECT USR_NM FROM COM_USER WHERE USR_ID = SO.CRE_USR_ID)) SO_USR_NM" ).append("\n"); 
		query.append("        , tro.T1_DOC_FLG" ).append("\n"); 
		query.append("        , tro.CSTMS_CLR_NO" ).append("\n"); 
		query.append("        --, tro.ALL_IN_RT_FLG" ).append("\n"); 
		query.append("        , tro.ALL_IN_RT_CD" ).append("\n"); 
		query.append("        , tro.CURR_CD" ).append("\n"); 
		query.append("        , TRIM(TO_CHAR(TRNS_REV_AMT, '999,999,999.99')) TRNS_REV_AMT" ).append("\n"); 
		query.append("		, TRIM(TO_CHAR(NMF_TRNS_REV_AMT, '999,999,999.99')) NON_TRNS_REV_AMT" ).append("\n"); 
		query.append("		, TRIM(TO_CHAR(ADD_REV_AMT, '999,999,999.99')) ADD_REV_AMT" ).append("\n"); 
		query.append("		, tro.ADD_REV_CHG_CD" ).append("\n"); 
		query.append("        , TRIM(TO_CHAR(ADD_REV_AMT2, '999,999,999.99')) ADD_REV_AMT2" ).append("\n"); 
		query.append("		, tro.ADD_REV_CHG_CD2" ).append("\n"); 
		query.append("        , TRIM(TO_CHAR(ADD_REV_AMT3, '999,999,999.99')) ADD_REV_AMT3" ).append("\n"); 
		query.append("		, tro.ADD_REV_CHG_CD3" ).append("\n"); 
		query.append("		, tro.ADD_REV_RMK" ).append("\n"); 
		query.append("        , tro.VAT_FLG" ).append("\n"); 
		query.append("        , tro.CXL_FLG" ).append("\n"); 
		query.append("		, tro.EUR_TRNS_TP_CD" ).append("\n"); 
		query.append("        , TRO.SPLIT_RMK" ).append("\n"); 
		query.append("        , CASE WHEN TRO.CNTR_TPSZ_CD IN (SELECT ATTR_CTNT1" ).append("\n"); 
		query.append("                                           FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("                                          WHERE HRD_CDG_ID = 'T1_REV_GLINE_TPSZ') THEN TRO.OPTM_STS_CD" ).append("\n"); 
		query.append("               ELSE 'A'" ).append("\n"); 
		query.append("           END AS OPTM_STS_CD " ).append("\n"); 
		query.append("        , TRO.NOT_OPTM_RSN" ).append("\n"); 
		query.append("  FROM BKG_EUR_TRO TRO" ).append("\n"); 
		query.append("       , TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("       , CIM_CNTR_STK CIM" ).append("\n"); 
		query.append(" WHERE TRO.BKG_NO     = @[bkg_no]" ).append("\n"); 
		query.append("   AND TRO.IO_BND_CD  = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND TRO.BKG_NO     = SO.BKG_NO(+)  " ).append("\n"); 
		query.append("   AND TRO.IO_BND_CD  = SO.TRSP_BND_CD(+)" ).append("\n"); 
		query.append("   AND TRO.TRO_SEQ    = SO.TRO_SEQ(+)" ).append("\n"); 
		query.append("--   AND '1'            = SO.TRO_SUB_SEQ(+)" ).append("\n"); 
		query.append("   AND 'N'            = SO.DELT_FLG(+)" ).append("\n"); 
		query.append("   AND TRO.BKG_NO     = CIM.BKG_NO(+)" ).append("\n"); 
		query.append("   AND TRO.SO_CTY_CD  = CIM.SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("   AND TRO.SO_SEQ_NO  = CIM.SO_SEQ(+)" ).append("\n"); 
		query.append("   AND SO.TRSP_COST_DTL_MOD_CD(+) ='DR'" ).append("\n"); 

	}
}