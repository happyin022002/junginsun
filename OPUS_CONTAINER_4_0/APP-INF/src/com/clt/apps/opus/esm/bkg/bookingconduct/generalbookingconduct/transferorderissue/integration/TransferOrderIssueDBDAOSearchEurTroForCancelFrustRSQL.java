/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSearchEurTroForCancelFrustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOSearchEurTroForCancelFrustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransferOrderIssueDBDAOSearchEurTroForCancelFrustRSQL
	  * </pre>
	  */
	public TransferOrderIssueDBDAOSearchEurTroForCancelFrustRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOSearchEurTroForCancelFrustRSQL").append("\n"); 
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
		query.append("SELECT MST.TRO_SEQ" ).append("\n"); 
		query.append("        , MST.CNTR_NO" ).append("\n"); 
		query.append("        , MST.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("--      , DECODE(NVL(SO.TRSP_SO_OFC_CTY_CD, 'X'), 'X', 'No', 'Yes') SO_FLG" ).append("\n"); 
		query.append("--		, DECODE(MST.CFM_FLG, 'Y', DECODE(NVL(MST.SO_CTY_CD, 'X'), 'X', DECODE(NVL(SO.TRSP_SO_OFC_CTY_CD, 'X'), 'X', 'No', 'Yes'), 'Yes'), 'No') SO_FLG" ).append("\n"); 
		query.append("        , DECODE(NVL(DECODE(MST.HLG_TP_CD, 'M', MST.SO_CTY_CD        ||TRIM(TO_CHAR(MST.SO_SEQ_NO,  '00000009'))," ).append("\n"); 
		query.append("									    SO.TRSP_SO_OFC_CTY_CD||TRIM(TO_CHAR(SO.TRSP_SO_SEQ, '00000009'))||" ).append("\n"); 
		query.append("				DECODE((SELECT distinct so_plan.trsp_so_sts_cd" ).append("\n"); 
		query.append("                           FROM sce_pln_so_list so_plan" ).append("\n"); 
		query.append("                          WHERE so_plan.cop_no         = so.cop_no" ).append("\n"); 
		query.append("                            AND so_plan.PCTL_IO_BND_CD = MST.io_bnd_cd" ).append("\n"); 
		query.append("                            AND so_plan.COST_ACT_GRP_CD LIKE DECODE(MST.io_bnd_cd, 'O', 'OD', 'ID')||'%')" ).append("\n"); 
		query.append("                           , 'F', '(FR)', '')), '*'), '*', 'No', 'Yes') SO_FLG" ).append("\n"); 
		query.append("--        , DECODE((SELECT distinct so_plan.trsp_so_sts_cd" ).append("\n"); 
		query.append("--                    FROM sce_pln_so_list so_plan" ).append("\n"); 
		query.append("--                   WHERE so_plan.cop_no         = so.cop_no" ).append("\n"); 
		query.append("--                     AND so_plan.PCTL_IO_BND_CD = MST.io_bnd_cd" ).append("\n"); 
		query.append("--                     AND so_plan.COST_ACT_GRP_CD LIKE DECODE(MST.io_bnd_cd, 'O', 'OD', 'ID')||'%')" ).append("\n"); 
		query.append("--                   , 'F', 'Fr', 'I', 'Yes', 'No')  WO_FLG" ).append("\n"); 
		query.append("--      2010.11.04 W/O의 상태 조회 로직 변경" ).append("\n"); 
		query.append("        , DECODE(DECODE(SO.TRSP_SO_STS_CD, 'I', 'Yes', 'No'), 'Yes', DECODE(NVL(SO.TRSP_FRST_FLG, 'N'), 'Y', 'Fr', 'Yes'), 'No') WO_FLG" ).append("\n"); 
		query.append("        , DECODE(NVL(MST.CXL_FLG, 'N'), 'Y', 'Yes', 'No') CXL_FLG" ).append("\n"); 
		query.append("        , '' CXL_FLG_CHK" ).append("\n"); 
		query.append("        , DECODE(EUR_TRNS_TP_CD, 'FR', 'Yes', 'No') FRUSTRATE" ).append("\n"); 
		query.append("        , '' FRUSTRATE_CHK" ).append("\n"); 
		query.append("        , MST.CURR_CD" ).append("\n"); 
		query.append("        , MST.NMF_TRNS_REV_AMT NON_TRNS_REV_AMT" ).append("\n"); 
		query.append("        , MST.BKG_NO" ).append("\n"); 
		query.append("        , MST.IO_BND_CD" ).append("\n"); 
		query.append("        , MST.ACT_CNT_CD " ).append("\n"); 
		query.append("        , MST.ACT_CUST_SEQ " ).append("\n"); 
		query.append("        , MST.HLG_TP_CD " ).append("\n"); 
		query.append("        , DECODE(NVL(SO.TRSP_SO_OFC_CTY_CD, 'X'), 'X', CFM_USR_ID, NULL) CFM_USR_ID" ).append("\n"); 
		query.append("        , DECODE(NVL(SO.TRSP_SO_OFC_CTY_CD, 'X'), 'X', (SELECT OFC_CD " ).append("\n"); 
		query.append("														  FROM COM_USER USR " ).append("\n"); 
		query.append(" 														 WHERE USR.USR_ID = MST.CFM_USR_ID), NULL) OFC_CD" ).append("\n"); 
		query.append("        , DECODE(NVL(SO.TRSP_SO_OFC_CTY_CD, 'X'), 'X', TO_CHAR(CFM_DT, 'YYYY-MM-DD'), NULL) CFM_UPD_DT" ).append("\n"); 
		query.append("        , '' CORR_NO" ).append("\n"); 
		query.append("        , '' UPD_USR_ID" ).append("\n"); 
		query.append("		,SO.TRSP_SO_OFC_CTY_CD||TRIM(TO_CHAR(SO.TRSP_SO_SEQ, '00000009')) AS TRS_SO_NO" ).append("\n"); 
		query.append("  FROM BKG_EUR_TRO MST" ).append("\n"); 
		query.append("       , TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append(" WHERE MST.BKG_NO    = @[bkg_no]" ).append("\n"); 
		query.append("   AND MST.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND MST.CXL_FLG   = 'N'" ).append("\n"); 
		query.append("   AND MST.BKG_NO     = SO.BKG_NO(+)" ).append("\n"); 
		query.append("   AND MST.IO_BND_CD  = SO.TRSP_BND_CD(+)" ).append("\n"); 
		query.append("   AND MST.TRO_SEQ    = SO.TRO_SEQ(+)" ).append("\n"); 
		query.append("--   AND '1'            = SO.TRO_SUB_SEQ(+)" ).append("\n"); 
		query.append("   AND 'N'            = SO.DELT_FLG(+)" ).append("\n"); 

	}
}