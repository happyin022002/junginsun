/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OffdockCYInvoiceManageDBDAOSearchCalcCostTMNLListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.02
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OffdockCYInvoiceManageDBDAOSearchCalcCostTMNLListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCalcCostTMNLList
	  * </pre>
	  */
	public OffdockCYInvoiceManageDBDAOSearchCalcCostTMNLListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration").append("\n"); 
		query.append("FileName : OffdockCYInvoiceManageDBDAOSearchCalcCostTMNLListRSQL").append("\n"); 
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
		query.append("SELECT ROWNUM TMP_DTL_SEQ,						     					" ).append("\n"); 
		query.append("D.TML_SO_OFC_CTY_CD   ,                              " ).append("\n"); 
		query.append("D.TML_SO_SEQ          ,                              " ).append("\n"); 
		query.append("D.TML_SO_DTL_SEQ      ,                              " ).append("\n"); 
		query.append("D.CALC_COST_GRP_CD    ,                              " ).append("\n"); 
		query.append("DECODE(D.CALC_TP_CD, 'A', D.CALC_TP_CD, (DECODE(D.SEMI_AUTO_CALC_FLG, 'Y','S', D.CALC_TP_CD))) CALC_TP_CD          ,                              " ).append("\n"); 
		query.append("D.VSL_CD              ,                               " ).append("\n"); 
		query.append("D.SKD_VOY_NO          ,                              " ).append("\n"); 
		query.append("D.SKD_DIR_CD          ,                              " ).append("\n"); 
		query.append("D.FINC_VSL_CD,                              		 " ).append("\n"); 
		query.append("D.FINC_SKD_VOY_NO     ,                              " ).append("\n"); 
		query.append("D.FINC_SKD_DIR_CD     ,                              " ).append("\n"); 
		query.append("D.IOC_CD              ,                              " ).append("\n"); 
		query.append("D.LANE_CD             ,                              " ).append("\n"); 
		query.append("D.IO_BND_CD           ,                              " ).append("\n"); 
		query.append("D.LGS_COST_CD         ,                              " ).append("\n"); 
		query.append("D.LGS_COST_CD  LGS_COST_CD2 ,                       " ).append("\n"); 
		query.append("D.ACCT_CD             ,                              " ).append("\n"); 
		query.append("D.ATB_DT              ,                              " ).append("\n"); 
		query.append("D.CNTR_NO             ,                              " ).append("\n"); 
		query.append("D.CNTR_TPSZ_CD        ,                              " ).append("\n"); 
		query.append("D.CALC_VOL_QTY        ,                              " ).append("\n"); 
		query.append("D.FM_TR_VOL_VAL       ,                              " ).append("\n"); 
		query.append("D.TO_TR_VOL_VAL       ,                              " ).append("\n"); 
		query.append("D.RVIS_VOL_QTY        ,                              " ).append("\n"); 
		query.append("D.DCGO_IND_CD         ,                              " ).append("\n"); 
		query.append("D.STAY_DYS            ,                              " ).append("\n"); 
		query.append("D.FREE_DYS            ,                              " ).append("\n"); 
		query.append("D.FREE_DY_XCLD_DYS    ,                             " ).append("\n"); 
		query.append("D.OVR_DYS             ,                              " ).append("\n"); 
		query.append("D.TML_WRK_DY_CD       ,                              " ).append("\n"); 
		query.append("D.WRK_DT              ,                              " ).append("\n"); 
		query.append("D.STK_VOL_QTY         ,                              " ).append("\n"); 
		query.append("D.FP_TEU_QTY          ,                              " ).append("\n"); 
		query.append("D.INV_VOL_QTY         ,                              " ).append("\n"); 
		query.append("D.DIFF_VOL_QTY        ,                              " ).append("\n"); 
		query.append("D.OVR_VOL_QTY         ,                              " ).append("\n"); 
		query.append("D.VOL_TR_UT_CD        ,                              " ).append("\n"); 
		query.append("D.CTRT_RT             ,                              " ).append("\n"); 
		query.append("D.REF_VNDR_SEQ        ,                              " ).append("\n"); 
		query.append("D.CALC_AMT            ,                              " ).append("\n"); 
		query.append("D.INV_AMT             ,                             " ).append("\n"); 
		query.append("D.TML_CRR_CD          ,                              " ).append("\n"); 
		query.append("D.CALC_RMK            ,                              " ).append("\n"); 
		query.append("D.N3PTY_FLG           ,                              " ).append("\n"); 
		query.append("D.TML_AGMT_OFC_CTY_CD ,                             " ).append("\n"); 
		query.append("D.TML_AGMT_SEQ        ,                             " ).append("\n"); 
		query.append("D.TML_AGMT_VER_NO     ,                             " ).append("\n"); 
		query.append("D.CURR_CD             ,                             " ).append("\n"); 
		query.append("D.INV_XCH_RT          ,                             " ).append("\n"); 
		query.append("D.RC_FLG              ,                             " ).append("\n"); 
		query.append("D.REV_YRMON           ," ).append("\n"); 
		query.append("D.RF_MNTR_DYS		  ," ).append("\n"); 
		query.append("D.PLG_TERM_DYS PLUG_TERM," ).append("\n"); 
		query.append("D.SEMI_AUTO_CALC_FLG  ," ).append("\n"); 
		query.append("NVL((SELECT RMK_CHK_FLG FROM TES_TML_SO_COST C WHERE C.LGS_COST_CD = D.LGS_COST_CD),'N') RMK_CHK_FLG," ).append("\n"); 
		query.append("D.TML_TRNS_MOD_CD	  ," ).append("\n"); 
		query.append("-- [CHM-201642291]Agreement/invoice에서 Cost Code Description 추가" ).append("\n"); 
		query.append("NVL((SELECT LGS_COST_ABBR_NM FROM TES_LGS_COST T WHERE T.LGS_COST_CD = D.LGS_COST_CD),'') LGS_COST_ABBR_NM   " ).append("\n"); 
		query.append("		 ,D.IDA_SAC_CD   " ).append("\n"); 
		query.append("		 ,D.IDA_PAY_TP_CD" ).append("\n"); 
		query.append("		 ,D.IDA_CGST_RTO " ).append("\n"); 
		query.append("		 ,D.IDA_CGST_AMT " ).append("\n"); 
		query.append("		 ,D.IDA_SGST_RTO " ).append("\n"); 
		query.append("		 ,D.IDA_SGST_AMT " ).append("\n"); 
		query.append("		 ,D.IDA_IGST_RTO " ).append("\n"); 
		query.append("		 ,D.IDA_IGST_AMT " ).append("\n"); 
		query.append("	     ,D.IDA_UGST_RTO " ).append("\n"); 
		query.append("	     ,D.IDA_UGST_AMT " ).append("\n"); 
		query.append("		 ,D.IDA_GST_RTO  " ).append("\n"); 
		query.append("		 ,D.IDA_GST_AMT                             " ).append("\n"); 
		query.append("FROM TES_TML_SO_HDR H, TES_TML_SO_DTL D                    " ).append("\n"); 
		query.append("WHERE 1=1                                                  " ).append("\n"); 
		query.append("AND H.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD        " ).append("\n"); 
		query.append("AND H.TML_SO_SEQ = D.TML_SO_SEQ                      " ).append("\n"); 
		query.append("AND D.CALC_COST_GRP_CD = 'TM'                         " ).append("\n"); 
		query.append("AND D.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND D.TML_SO_SEQ = @[tml_so_seq]                      " ).append("\n"); 
		query.append("AND NVL(D.DELT_FLG,'N') <> 'Y'  -- [CHM-201538267]ODCY Invoice에서 Auto Calculated된 Row삭제 가능하도록 로직 수정(조아영 D 2010-10-06)           " ).append("\n"); 
		query.append("--ORDER BY D.CALC_COST_GRP_CD ASC, D.CALC_TP_CD ASC, D.LGS_COST_CD ASC, D.CNTR_TPSZ_CD ASC, D.IO_BND_CD ASC, D.CTRT_RT ASC" ).append("\n"); 
		query.append("ORDER BY CALC_TP_CD, LGS_COST_CD, CNTR_TPSZ_CD" ).append("\n"); 

	}
}