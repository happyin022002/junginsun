/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSearchEurTroListForCfmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.30 
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

public class TransferOrderIssueDBDAOSearchEurTroListForCfmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransferOrderIssueDBDAOSearchEurTroListForCfmRSQL
	  * </pre>
	  */
	public TransferOrderIssueDBDAOSearchEurTroListForCfmRSQL(){
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
		query.append("FileName : TransferOrderIssueDBDAOSearchEurTroListForCfmRSQL").append("\n"); 
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
		query.append("        , LPAD(MST.TRO_SEQ, 3, '0') TRO_SEQ_DISP" ).append("\n"); 
		query.append("        , MST.CNTR_NO" ).append("\n"); 
		query.append("        , DECODE(MST.CFM_FLG, 'Y', 'Yes', 'No') CFM_FLG" ).append("\n"); 
		query.append("        , MST.CURR_CD " ).append("\n"); 
		query.append("        , MST.CORR_NO" ).append("\n"); 
		query.append("        , TRIM(TO_CHAR(MST.NMF_TRNS_REV_AMT, '999,999,999.99')) TRNS_REV_AMT " ).append("\n"); 
		query.append("        --, DECODE(ALL_IN_RT_FLG, 'Y', 'Yes', 'No') ALL_IN_RT_FLG " ).append("\n"); 
		query.append("        , DECODE(MST.ALL_IN_RT_CD, 'Y', 'Yes', 'No') ALL_IN_RT_CD " ).append("\n"); 
		query.append("        , DECODE(MST.T1_DOC_FLG, 'Y', 'Yes', 'No') T1_DOC_FLG " ).append("\n"); 
		query.append("        , DECODE(MST.VAT_FLG, 'Y', 'Yes', 'No') VAT_FLG " ).append("\n"); 
		query.append("        , MST.CXL_FLG" ).append("\n"); 
		query.append("        , MST.UPD_USR_ID" ).append("\n"); 
		query.append("        , MST.UPD_DT" ).append("\n"); 
		query.append("        , MST.BKG_NO" ).append("\n"); 
		query.append("        , MST.IO_BND_CD" ).append("\n"); 
		query.append("        , MST.HLG_TP_CD " ).append("\n"); 
		query.append("        , MST.CFM_DT" ).append("\n"); 
		query.append("        , '' PAYER_CNT_CD" ).append("\n"); 
		query.append("        , '' PAYER_SEQ" ).append("\n"); 
		query.append("        , DECODE(MST.CFM_FLG, 'Y', 'Yes', 'No') CFM_FLG_OLD " ).append("\n"); 
		query.append("        , MST.BKG_TRSP_MZD_CD " ).append("\n"); 
		query.append("        , MST.CNTR_PKUP_YD_CD " ).append("\n"); 
		query.append("        , MST.CNTR_RTN_YD_CD " ).append("\n"); 
		query.append("        , DTL.ZN_CD" ).append("\n"); 
		query.append("		, MST.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		, TRIM(TO_CHAR(MST.ADD_REV_AMT, '999,999,999.99')) ADD_REV_AMT" ).append("\n"); 
		query.append("		, MST.ADD_REV_CHG_CD" ).append("\n"); 
		query.append("		, TRIM(TO_CHAR(MST.ADD_REV_AMT2, '999,999,999.99')) ADD_REV_AMT2" ).append("\n"); 
		query.append("		, MST.ADD_REV_CHG_CD2" ).append("\n"); 
		query.append("		, TRIM(TO_CHAR(MST.ADD_REV_AMT3, '999,999,999.99')) ADD_REV_AMT3" ).append("\n"); 
		query.append("		, MST.ADD_REV_CHG_CD3" ).append("\n"); 
		query.append("		, NVL(DTL.TRO_SUB_SEQ, 1) AS TRO_SUB_SEQ" ).append("\n"); 
		query.append("        , MST.OPTM_STS_CD" ).append("\n"); 
		query.append("        , MST.NOT_OPTM_RSN" ).append("\n"); 
		query.append("		, NVL((SELECT 'Y' FROM BKG_EUR_TRO_DG_SEQ WHERE BKG_NO = MST.BKG_NO AND IO_BND_CD = MST.IO_BND_CD AND TRO_SEQ = MST.TRO_SEQ AND ROWNUM =1 ),'N') DG_FLG" ).append("\n"); 
		query.append("        , DTL.LOC_CD" ).append("\n"); 
		query.append("        , (SELECT POD_CD FROM BKG_BOOKING WHERE BKG_NO = MST.BKG_NO ) POD_CD" ).append("\n"); 
		query.append("        , DECODE(NVL(RC_SEQ,0),0,'N','Y') RC_FLG" ).append("\n"); 
		query.append("        , DECODE(NVL(AWK_CGO_SEQ,0),0,'N','Y') AWK_CGO_FLG" ).append("\n"); 
		query.append("  FROM BKG_EUR_TRO MST" ).append("\n"); 
		query.append("      ,(SELECT *" ).append("\n"); 
		query.append("          FROM (SELECT BKG_NO" ).append("\n"); 
		query.append("                      ,IO_BND_CD" ).append("\n"); 
		query.append("                      ,TRO_SEQ" ).append("\n"); 
		query.append("                      ,TRO_SUB_SEQ" ).append("\n"); 
		query.append("                      ,ZN_CD" ).append("\n"); 
		query.append("                      ,LOC_CD" ).append("\n"); 
		query.append("                      ,DENSE_RANK() OVER (PARTITION BY BKG_NO, IO_BND_CD, TRO_SEQ ORDER BY BKG_NO, IO_BND_CD, TRO_SEQ, TRO_SUB_SEQ) RK" ).append("\n"); 
		query.append("                      ,DENSE_RANK() OVER (PARTITION BY BKG_NO, IO_BND_CD, TRO_SEQ ORDER BY BKG_NO, IO_BND_CD, TRO_SEQ, TRO_SUB_SEQ DESC) RK2" ).append("\n"); 
		query.append("                  FROM BKG_EUR_TRO_DTL" ).append("\n"); 
		query.append("                 WHERE BKG_NO    = @[bkg_no]" ).append("\n"); 
		query.append("                   AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("                   AND DOR_ADDR_TP_CD = 'D')" ).append("\n"); 
		query.append("         WHERE DECODE(IO_BND_CD, 'O', RK, RK2) = 1) DTL" ).append("\n"); 
		query.append(" WHERE MST.BKG_NO    = @[bkg_no]" ).append("\n"); 
		query.append("   AND MST.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND MST.CXL_FLG = 'N'" ).append("\n"); 
		query.append("   AND MST.BKG_NO = DTL.BKG_NO (+)" ).append("\n"); 
		query.append("   AND MST.IO_BND_CD = DTL.IO_BND_CD (+)" ).append("\n"); 
		query.append("   AND MST.TRO_SEQ = DTL.TRO_SEQ (+)" ).append("\n"); 
		query.append(" ORDER BY MST.TRO_SEQ" ).append("\n"); 

	}
}