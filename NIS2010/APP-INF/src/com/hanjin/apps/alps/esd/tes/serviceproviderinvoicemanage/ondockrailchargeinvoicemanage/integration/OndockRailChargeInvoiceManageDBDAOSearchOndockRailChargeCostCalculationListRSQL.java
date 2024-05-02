/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OndockRailChargeInvoiceManageDBDAOSearchOndockRailChargeCostCalculationListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.03
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OndockRailChargeInvoiceManageDBDAOSearchOndockRailChargeCostCalculationListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOndockRailChargeCostCalculationList
	  * </pre>
	  */
	public OndockRailChargeInvoiceManageDBDAOSearchOndockRailChargeCostCalculationListRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration").append("\n"); 
		query.append("FileName : OndockRailChargeInvoiceManageDBDAOSearchOndockRailChargeCostCalculationListRSQL").append("\n"); 
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
		query.append("SELECT   TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("		 ,TML_SO_SEQ" ).append("\n"); 
		query.append("		 ,TML_SO_DTL_SEQ" ).append("\n"); 
		query.append("		 ,CALC_COST_GRP_CD" ).append("\n"); 
		query.append("		 ,DECODE(D.CALC_TP_CD, 'A', D.CALC_TP_CD, (DECODE(D.SEMI_AUTO_CALC_FLG, 'Y','S', D.CALC_TP_CD))) CALC_TP_CD" ).append("\n"); 
		query.append("		 ,VSL_CD" ).append("\n"); 
		query.append("		 ,SKD_VOY_NO" ).append("\n"); 
		query.append("		 ,SKD_DIR_CD " ).append("\n"); 
		query.append("		 ,VSL_CD||SKD_VOY_NO||SKD_DIR_CD 	VVD_NO" ).append("\n"); 
		query.append("		 ,FINC_VSL_CD" ).append("\n"); 
		query.append("		 ,FINC_SKD_VOY_NO" ).append("\n"); 
		query.append("		 ,FINC_SKD_DIR_CD" ).append("\n"); 
		query.append("		 ,IOC_CD" ).append("\n"); 
		query.append("		 ,LANE_CD" ).append("\n"); 
		query.append("		 ,IO_BND_CD" ).append("\n"); 
		query.append("		 ,LGS_COST_CD" ).append("\n"); 
		query.append("		 ,LGS_COST_CD 				LGS_COST_CD2" ).append("\n"); 
		query.append("		 ,ACCT_CD" ).append("\n"); 
		query.append("		 ,TO_CHAR(ATB_DT,'YYYYMMDD') ATB_DT" ).append("\n"); 
		query.append("		 ,CNTR_NO" ).append("\n"); 
		query.append("		 ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		 ,CNTR_TPSZ_CD				CNTR_TPSZ_CD2" ).append("\n"); 
		query.append("		 ,CALC_VOL_QTY" ).append("\n"); 
		query.append("		 ,FM_TR_VOL_VAL" ).append("\n"); 
		query.append("		 ,TO_TR_VOL_VAL" ).append("\n"); 
		query.append("		 ,RVIS_VOL_QTY" ).append("\n"); 
		query.append("		 ,DCGO_IND_CD" ).append("\n"); 
		query.append("		 ,STAY_DYS" ).append("\n"); 
		query.append("		 ,FREE_DYS" ).append("\n"); 
		query.append("		 ,OVR_DYS" ).append("\n"); 
		query.append("		 ,TML_WRK_DY_CD" ).append("\n"); 
		query.append("		 ,FP_CALC_PRD_CD" ).append("\n"); 
		query.append("		 ,WRK_DT" ).append("\n"); 
		query.append("		 ,TML_WRK_DY_CD" ).append("\n"); 
		query.append("		 ,STK_VOL_QTY" ).append("\n"); 
		query.append("		 ,FP_TEU_QTY" ).append("\n"); 
		query.append("		 ,INV_VOL_QTY" ).append("\n"); 
		query.append("		 ,DIFF_VOL_QTY" ).append("\n"); 
		query.append("		 ,OVR_VOL_QTY" ).append("\n"); 
		query.append("		 ,VOL_TR_UT_CD" ).append("\n"); 
		query.append("		 ,CTRT_RT" ).append("\n"); 
		query.append("		 ,LPAD(REF_VNDR_SEQ,6,'0') REF_VNDR_SEQ" ).append("\n"); 
		query.append("		 ,CALC_AMT" ).append("\n"); 
		query.append("		 ,INV_AMT" ).append("\n"); 
		query.append("		 ,TML_CRR_CD" ).append("\n"); 
		query.append("		 ,CALC_RMK" ).append("\n"); 
		query.append("		 ,CURR_CD" ).append("\n"); 
		query.append("		 ,INV_XCH_RT" ).append("\n"); 
		query.append("		 ,N3PTY_FLG" ).append("\n"); 
		query.append("		 ,TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("		 ,TML_AGMT_SEQ" ).append("\n"); 
		query.append("		 ,TML_AGMT_VER_NO" ).append("\n"); 
		query.append("         ,NVL((SELECT RMK_CHK_FLG FROM TES_TML_SO_COST C WHERE C.LGS_COST_CD = D.LGS_COST_CD),'N') RMK_CHK_FLG " ).append("\n"); 
		query.append("		 ,IDA_SAC_CD   " ).append("\n"); 
		query.append("		 ,IDA_PAY_TP_CD" ).append("\n"); 
		query.append("		 ,IDA_CGST_RTO " ).append("\n"); 
		query.append("		 ,IDA_CGST_AMT " ).append("\n"); 
		query.append("		 ,IDA_SGST_RTO " ).append("\n"); 
		query.append("		 ,IDA_SGST_AMT " ).append("\n"); 
		query.append("		 ,IDA_IGST_RTO " ).append("\n"); 
		query.append("		 ,IDA_IGST_AMT " ).append("\n"); 
		query.append("	     ,IDA_UGST_RTO " ).append("\n"); 
		query.append("	     ,IDA_UGST_AMT " ).append("\n"); 
		query.append("		 ,IDA_GST_RTO  " ).append("\n"); 
		query.append("		 ,IDA_GST_AMT  " ).append("\n"); 
		query.append(" FROM    TES_TML_SO_DTL D" ).append("\n"); 
		query.append(" WHERE   TML_SO_OFC_CTY_CD   = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append(" AND     TML_SO_SEQ          = @[tml_so_seq]" ).append("\n"); 
		query.append(" ORDER BY CALC_TP_CD, LGS_COST_CD, CNTR_TPSZ_CD, IO_BND_CD, WRK_DT, DCGO_IND_CD,FM_TR_VOL_VAL, TO_TR_VOL_VAL," ).append("\n"); 
		query.append("		   VOL_TR_UT_CD , CTRT_RT, VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 

	}
}