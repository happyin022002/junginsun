/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SurchargeInputInquiryDBDAOsearchSurchargeInputInquiryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.01
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.11.01 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.surchargeinputinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurchargeInputInquiryDBDAOsearchSurchargeInputInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSurchargeInputInquiryList
	  * </pre>
	  */
	public SurchargeInputInquiryDBDAOsearchSurchargeInputInquiryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_SO_OFC_CTY_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_SO_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.surchargeinputinquiry.integration").append("\n"); 
		query.append("FileName : SurchargeInputInquiryDBDAOsearchSurchargeInputInquiryListRSQL").append("\n"); 
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
		query.append("SELECT											 " ).append("\n"); 
		query.append(" A.TRSP_SO_OFC_CTY_CD							,	 " ).append("\n"); 
		query.append(" A.TRSP_SO_SEQ									,	 " ).append("\n"); 
		query.append(" A.LGS_COST_CD									,	 " ).append("\n"); 
		query.append(" B.LGS_COST_FULL_NM							,	 " ).append("\n"); 
		query.append(" A.SCG_AMT										,	 " ).append("\n"); 
		query.append(" A.DRY_RUN_RLBL_PTY_TP_CD						,	 " ).append("\n"); 
		query.append(" A.FNE_CUZ_DESC								,	 " ).append("\n"); 
		query.append(" A.FUMG_COST_TP_CD								,	 " ).append("\n"); 
		query.append(" A.MGST_TPSZ_CD								,	 " ).append("\n"); 
		query.append(" A.INSP_RF_PTI_CSTMS_TP_CD						,	 " ).append("\n"); 
		query.append(" A.LFTG_KNT									,	 " ).append("\n"); 
		query.append(" A.LFTG_CUZ_DESC								,	 " ).append("\n"); 
		query.append(" A.STOP_LOC_NOD_CD								,	 " ).append("\n"); 
		query.append(" A.GRS_WGT										,	 " ).append("\n"); 
		query.append(" TO_CHAR(A.INCRT_DT, 'YYYYMMDD') INCRT_DT		,	 " ).append("\n"); 
		query.append(" A.SCL_STOP_PLC_NOD_CD							,	 " ).append("\n"); 
		query.append(" A.STO_DYS										,	 " ).append("\n"); 
		query.append(" A.OB_BKG_NO									,	 " ).append("\n"); 
		query.append(" A.WT_HRS										,	 " ).append("\n"); 
		query.append(" A.OTR_RMK										,	 " ).append("\n"); 
		query.append(" A.INV_SCG_AMT									,	 " ).append("\n"); 
		query.append(" A.INV_DRY_RUN_RLBL_PTY_TP_CD					,	 " ).append("\n"); 
		query.append(" A.INV_FNE_CUZ_DESC							,	 " ).append("\n"); 
		query.append(" A.INV_FUMG_COST_TP_CD							,	 " ).append("\n"); 
		query.append(" A.INV_MGST_TPSZ_CD							,	 " ).append("\n"); 
		query.append(" A.INV_INSP_RF_PTI_CSTMS_TP_CD					,	 " ).append("\n"); 
		query.append(" A.INV_LFTG_KNT								,	 " ).append("\n"); 
		query.append(" A.INV_LFTG_CUZ_DESC							,	 " ).append("\n"); 
		query.append(" A.INV_STOP_LOC_NOD_CD							,	 " ).append("\n"); 
		query.append(" A.INV_GRS_WGT									,	 " ).append("\n"); 
		query.append(" TO_CHAR(A.INV_INCRT_DT, 'YYYYMMDD') INV_INCRT_DT	,	 " ).append("\n"); 
		query.append(" A.INV_SCL_STOP_PLC_NOD_CD						,	 " ).append("\n"); 
		query.append(" A.INV_STO_DYS									,	 " ).append("\n"); 
		query.append(" A.INV_OB_BKG_NO								,	 " ).append("\n"); 
		query.append(" A.INV_WT_HRS									,	 " ).append("\n"); 
		query.append(" A.INV_OTR_RMK									,	 " ).append("\n"); 
		query.append(" A.N3PTY_BIL_FLG								,	 " ).append("\n"); 
		query.append(" A.CUST_CNT_CD									,	 " ).append("\n"); 
		query.append(" A.CUST_SEQ									,	 " ).append("\n"); 
		query.append(" A.N3PTY_VNDR_SEQ								,	 " ).append("\n"); 
		query.append(" A.N3PTY_OFC_CD								,	 " ).append("\n"); 
		query.append(" A.N3PTY_AMT									,	 " ).append("\n"); 
		query.append(" A.N3PTY_DESC									,	 " ).append("\n"); 
		query.append(" A.CRE_OFC_CD									,	 " ).append("\n"); 
		query.append(" A.CRE_USR_ID									,	 " ).append("\n"); 
		query.append(" TO_CHAR(A.LOCL_CRE_DT, 'YYYYMMDD') CRE_DT		," ).append("\n"); 
		query.append(" TO_CHAR(A.INCUR_DT, 'YYYYMMDD')	INCUR_DT	," ).append("\n"); 
		query.append(" A.CHSS_NO										," ).append("\n"); 
		query.append(" TO_CHAR(A.INV_INCUR_DT, 'YYYYMMDD') INV_INCUR_DT," ).append("\n"); 
		query.append(" A.INV_CHSS_NO	                                ," ).append("\n"); 
		query.append(" A.SCG_DTL_SEQ                                  ," ).append("\n"); 
		query.append(" A.CURR_CD                                      ," ).append("\n"); 
		query.append(" A.ORG_SCG_AMT " ).append("\n"); 
		query.append(" FROM TRS_TRSP_SCG_DTL	A						,	 " ).append("\n"); 
		query.append(" TES_LGS_COST	B									 " ).append("\n"); 
		query.append("  WHERE A.TRSP_SO_OFC_CTY_CD					= @[TRSP_SO_OFC_CTY_CD]" ).append("\n"); 
		query.append(" AND A.TRSP_SO_SEQ								= @[TRSP_SO_SEQ]" ).append("\n"); 
		query.append(" AND A.LGS_COST_CD = B.LGS_COST_CD(+)			 	 " ).append("\n"); 
		query.append(" AND SUBSTR(A.LGS_COST_CD, 3, 2)	<> 'FU'" ).append("\n"); 

	}
}