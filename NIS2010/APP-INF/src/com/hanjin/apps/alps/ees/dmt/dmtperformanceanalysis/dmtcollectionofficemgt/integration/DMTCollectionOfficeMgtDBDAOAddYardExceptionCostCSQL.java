/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DMTCollectionOfficeMgtDBDAOAddYardExceptionCostCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.03
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2012.12.03 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCollectionOfficeMgtDBDAOAddYardExceptionCostCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Yard Exception Cost 등록
	  * </pre>
	  */
	public DMTCollectionOfficeMgtDBDAOAddYardExceptionCostCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cost_cy_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_cost_40ft_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cost_20ft_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_calc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_cost_20ft_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cost_stk_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("otr_cost_40ft_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("otr_cost_20ft_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cost_dor_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cost_40ft_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.integration").append("\n"); 
		query.append("FileName : DMTCollectionOfficeMgtDBDAOAddYardExceptionCostCSQL").append("\n"); 
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
		query.append("INSERT INTO DMT_YD_EXPT_COST (" ).append("\n"); 
		query.append("   YD_CD                 " ).append("\n"); 
		query.append("  ,YD_EXPT_COST_SEQ      " ).append("\n"); 
		query.append("  ,DMDT_OFC_CD           " ).append("\n"); 
		query.append("  ,CFM_FLG               " ).append("\n"); 
		query.append("  ,CURR_CD " ).append("\n"); 
		query.append("  ,DMDT_CALC_TP_CD                  " ).append("\n"); 
		query.append("  ,TML_COST_20FT_RT_AMT  " ).append("\n"); 
		query.append("  ,TML_COST_40FT_RT_AMT  " ).append("\n"); 
		query.append("  ,CNTR_COST_20FT_RT_AMT " ).append("\n"); 
		query.append("  ,CNTR_COST_40FT_RT_AMT" ).append("\n"); 
		query.append("  ,CNTR_COST_STK_AMT " ).append("\n"); 
		query.append("  ,CHG_COST_CY_RT_AMT " ).append("\n"); 
		query.append("  ,CHG_COST_DOR_RT_AMT " ).append("\n"); 
		query.append("  ,OTR_COST_20FT_RT_AMT  " ).append("\n"); 
		query.append("  ,OTR_COST_40FT_RT_AMT  " ).append("\n"); 
		query.append("  ,EFF_DT                " ).append("\n"); 
		query.append("  ,EXP_DT                " ).append("\n"); 
		query.append("  ,CRE_USR_ID            " ).append("\n"); 
		query.append("  ,CRE_DT                " ).append("\n"); 
		query.append("  ,CRE_OFC_CD            " ).append("\n"); 
		query.append("  ,UPD_USR_ID            " ).append("\n"); 
		query.append("  ,UPD_DT                " ).append("\n"); 
		query.append("  ,UPD_OFC_CD            " ).append("\n"); 
		query.append("  ) VALUES( " ).append("\n"); 
		query.append("    @[yd_cd]" ).append("\n"); 
		query.append("  , (SELECT nvl(max(YD_EXPT_COST_SEQ),0) + 1 FROM DMT_YD_EXPT_COST WHERE yd_cd = @[yd_cd])" ).append("\n"); 
		query.append("  , (SELECT DMDT_OFC_CD FROM  MDM_YARD WHERE YD_CD = @[yd_cd])      " ).append("\n"); 
		query.append("  , 'N'               " ).append("\n"); 
		query.append("  , @[curr_cd] " ).append("\n"); 
		query.append("  , NVL(@[dmdt_calc_tp_cd], (SELECT /*+ INDEX_DESC( TB DMT_CALC_TP XPKDMT_CALC_TP) */" ).append("\n"); 
		query.append("                                            TB.DMDT_CALC_TP_CD" ).append("\n"); 
		query.append("                                      FROM  DMT_CALC_TP TB ," ).append("\n"); 
		query.append("                                            MDM_LOCATION TC" ).append("\n"); 
		query.append("                                      WHERE TC.LOC_CD = SUBSTR(@[yd_cd],1,5)" ).append("\n"); 
		query.append("                                      AND   ( TB.CNT_CD   =  TC.CNT_CD OR TB.CNT_CD = ' ' )" ).append("\n"); 
		query.append("                                      AND   ( TB.RGN_CD   =  TC.RGN_CD OR TB.RGN_CD = ' ' )" ).append("\n"); 
		query.append("                                      AND   ( TB.STE_CD   =  TC.STE_CD OR TB.STE_CD = ' ' )" ).append("\n"); 
		query.append("                                      AND   ( TB.LOC_CD   =  TC.LOC_CD OR TB.LOC_CD = ' ' )" ).append("\n"); 
		query.append("                                      AND   TB.IO_BND_CD  =  'I'" ).append("\n"); 
		query.append("                                      AND   TB.CALC_TP_SEQ = ( SELECT /*+ INDEX_DESC( TD XPKDMT_CALC_TP) */" ).append("\n"); 
		query.append("                                                                    TD.CALC_TP_SEQ" ).append("\n"); 
		query.append("                                                             FROM   DMT_CALC_TP  TD" ).append("\n"); 
		query.append("                                                             WHERE  ( TD.CNT_CD = TC.CNT_CD   OR  TD.CNT_CD = ' ' )" ).append("\n"); 
		query.append("                                                             AND    ( TD.RGN_CD = TC.RGN_CD   OR  TD.RGN_CD = ' ' )" ).append("\n"); 
		query.append("                                                             AND    ( TD.STE_CD = TC.STE_CD   OR  TD.STE_CD = ' ' )" ).append("\n"); 
		query.append("                                                             AND    ( TD.LOC_CD = TC.LOC_CD   OR  TD.LOC_CD = ' ' )" ).append("\n"); 
		query.append("                                                             AND    TD.IO_BND_CD =  'I'" ).append("\n"); 
		query.append("                                                             AND    ROWNUM = 1" ).append("\n"); 
		query.append("                                                             )" ).append("\n"); 
		query.append("                                      AND  ROWNUM = 1))" ).append("\n"); 
		query.append("  , @[tml_cost_20ft_rt_amt]  " ).append("\n"); 
		query.append("  , @[tml_cost_40ft_rt_amt]  " ).append("\n"); 
		query.append("  , @[cntr_cost_20ft_rt_amt] " ).append("\n"); 
		query.append("  , @[cntr_cost_40ft_rt_amt]" ).append("\n"); 
		query.append("  , @[cntr_cost_stk_amt]   " ).append("\n"); 
		query.append("  , @[chg_cost_cy_rt_amt]" ).append("\n"); 
		query.append("  , @[chg_cost_dor_rt_amt]" ).append("\n"); 
		query.append("  , @[otr_cost_20ft_rt_amt]  " ).append("\n"); 
		query.append("  , @[otr_cost_40ft_rt_amt]" ).append("\n"); 
		query.append("  , TO_DATE(@[eff_dt],'YYYY-MM-DD')               " ).append("\n"); 
		query.append("  , TO_DATE(@[exp_dt],'YYYY-MM-DD')                 " ).append("\n"); 
		query.append("  , @[cre_usr_id]            " ).append("\n"); 
		query.append("  , NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]),SYSDATE)                " ).append("\n"); 
		query.append("  , @[cre_ofc_cd]            " ).append("\n"); 
		query.append("  , @[upd_usr_id]            " ).append("\n"); 
		query.append("  , NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[upd_ofc_cd]),SYSDATE)                " ).append("\n"); 
		query.append("  , @[upd_ofc_cd]            " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}