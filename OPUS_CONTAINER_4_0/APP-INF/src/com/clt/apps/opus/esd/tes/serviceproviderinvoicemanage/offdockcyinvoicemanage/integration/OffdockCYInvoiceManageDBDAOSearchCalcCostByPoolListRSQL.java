/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OffdockCYInvoiceManageDBDAOsearchCalcCostByPoolListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 이정혜
*@LastVersion : 1.0
* 2009.08.10 이정혜
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HARRY
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OffdockCYInvoiceManageDBDAOSearchCalcCostByPoolListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * a
	  * </pre>
	  */
	public OffdockCYInvoiceManageDBDAOSearchCalcCostByPoolListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration ").append("\n"); 
		query.append("FileName : OffdockCYInvoiceManageDBDAOsearchCalcCostByPoolListRSQL").append("\n"); 
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
		query.append("SELECT ROWNUM TMP_DTL_SEQ," ).append("\n"); 
		query.append("D.TML_SO_OFC_CTY_CD   ," ).append("\n"); 
		query.append("D.TML_SO_SEQ          ," ).append("\n"); 
		query.append("D.TML_SO_DTL_SEQ      ," ).append("\n"); 
		query.append("D.CALC_COST_GRP_CD    ," ).append("\n"); 
		query.append("D.CALC_TP_CD          ," ).append("\n"); 
		query.append("D.VSL_CD              ," ).append("\n"); 
		query.append("D.SKD_VOY_NO          ," ).append("\n"); 
		query.append("D.SKD_DIR_CD          ," ).append("\n"); 
		query.append("D.FINC_VSL_CD," ).append("\n"); 
		query.append("D.FINC_SKD_VOY_NO     ," ).append("\n"); 
		query.append("D.FINC_SKD_DIR_CD     ," ).append("\n"); 
		query.append("D.IOC_CD              ," ).append("\n"); 
		query.append("D.LANE_CD             ," ).append("\n"); 
		query.append("D.IO_BND_CD           ," ).append("\n"); 
		query.append("D.LGS_COST_CD         ," ).append("\n"); 
		query.append("D.LGS_COST_CD  LGS_COST_CD2 ," ).append("\n"); 
		query.append("D.ACCT_CD             ," ).append("\n"); 
		query.append("D.ATB_DT              ," ).append("\n"); 
		query.append("D.CNTR_NO             ," ).append("\n"); 
		query.append("D.CNTR_TPSZ_CD        ," ).append("\n"); 
		query.append("D.CALC_VOL_QTY        ," ).append("\n"); 
		query.append("D.FM_TR_VOL_VAL       ," ).append("\n"); 
		query.append("D.TO_TR_VOL_VAL       ," ).append("\n"); 
		query.append("D.RVIS_VOL_QTY        ," ).append("\n"); 
		query.append("D.DCGO_IND_CD         ," ).append("\n"); 
		query.append("D.STAY_DYS            ," ).append("\n"); 
		query.append("D.FREE_DYS            ," ).append("\n"); 
		query.append("D.FREE_DY_XCLD_DYS    ," ).append("\n"); 
		query.append("D.OVR_DYS             ," ).append("\n"); 
		query.append("D.TML_WRK_DY_CD       ," ).append("\n"); 
		query.append("D.WRK_DT              ," ).append("\n"); 
		query.append("D.STK_VOL_QTY         ," ).append("\n"); 
		query.append("D.FP_TEU_QTY          ," ).append("\n"); 
		query.append("D.INV_VOL_QTY         ," ).append("\n"); 
		query.append("D.DIFF_VOL_QTY        ," ).append("\n"); 
		query.append("D.OVR_VOL_QTY         ," ).append("\n"); 
		query.append("D.VOL_TR_UT_CD        ," ).append("\n"); 
		query.append("D.CTRT_RT             ," ).append("\n"); 
		query.append("D.REF_VNDR_SEQ        ," ).append("\n"); 
		query.append("D.CALC_AMT            ," ).append("\n"); 
		query.append("D.INV_AMT             ," ).append("\n"); 
		query.append("D.TML_CRR_CD          ," ).append("\n"); 
		query.append("D.CALC_RMK            ," ).append("\n"); 
		query.append("D.N3PTY_FLG           ," ).append("\n"); 
		query.append("D.TML_AGMT_OFC_CTY_CD ," ).append("\n"); 
		query.append("D.TML_AGMT_SEQ        ," ).append("\n"); 
		query.append("D.TML_AGMT_VER_NO     ," ).append("\n"); 
		query.append("D.CURR_CD             ," ).append("\n"); 
		query.append("D.INV_XCH_RT          ," ).append("\n"); 
		query.append("D.RC_FLG              ," ).append("\n"); 
		query.append("D.REV_YRMON" ).append("\n"); 
		query.append("FROM TES_TML_SO_HDR H, TES_TML_SO_DTL D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND H.TML_SO_SEQ = D.TML_SO_SEQ" ).append("\n"); 
		query.append("AND D.CALC_COST_GRP_CD = 'SP'" ).append("\n"); 
		query.append("AND D.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND D.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("ORDER BY D.CALC_COST_GRP_CD ASC, D.CALC_TP_CD ASC, D.LGS_COST_CD ASC, D.CNTR_TPSZ_CD ASC, D.IO_BND_CD ASC, D.CTRT_RT ASC" ).append("\n"); 

	}
}