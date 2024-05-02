/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DMTCollectionOfficeMgtDBDAOModifyYardExceptionCostUSQL.java
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

public class DMTCollectionOfficeMgtDBDAOModifyYardExceptionCostUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Yard Exception Cost 수정.
	  * </pre>
	  */
	public DMTCollectionOfficeMgtDBDAOModifyYardExceptionCostUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_expt_cost_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tml_cost_20ft_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.integration").append("\n"); 
		query.append("FileName : DMTCollectionOfficeMgtDBDAOModifyYardExceptionCostUSQL").append("\n"); 
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
		query.append("UPDATE DMT_YD_EXPT_COST " ).append("\n"); 
		query.append("SET CURR_CD                =  @[curr_cd] ,               " ).append("\n"); 
		query.append("    TML_COST_20FT_RT_AMT   =  @[tml_cost_20ft_rt_amt], " ).append("\n"); 
		query.append("    TML_COST_40FT_RT_AMT   =  @[tml_cost_40ft_rt_amt], " ).append("\n"); 
		query.append("    CNTR_COST_20FT_RT_AMT  =  @[cntr_cost_20ft_rt_amt]," ).append("\n"); 
		query.append("    CNTR_COST_40FT_RT_AMT  =  @[cntr_cost_40ft_rt_amt]," ).append("\n"); 
		query.append("    CNTR_COST_STK_AMT      =  @[cntr_cost_stk_amt],  " ).append("\n"); 
		query.append("    CHG_COST_CY_RT_AMT     =  @[chg_cost_cy_rt_amt]," ).append("\n"); 
		query.append("    CHG_COST_DOR_RT_AMT    =  @[chg_cost_dor_rt_amt]," ).append("\n"); 
		query.append("    OTR_COST_20FT_RT_AMT   =  @[otr_cost_20ft_rt_amt], " ).append("\n"); 
		query.append("    OTR_COST_40FT_RT_AMT   =  @[otr_cost_40ft_rt_amt], " ).append("\n"); 
		query.append("    DMDT_CALC_TP_CD        =  @[dmdt_calc_tp_cd], " ).append("\n"); 
		query.append("    EFF_DT                 =  TO_DATE(@[eff_dt],'YYYY-MM-DD'),               " ).append("\n"); 
		query.append("    EXP_DT                 =  TO_DATE(@[exp_dt],'YYYY-MM-DD'),               " ).append("\n"); 
		query.append("    UPD_USR_ID             =  @[upd_usr_id],           " ).append("\n"); 
		query.append("    UPD_DT                 =  NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[upd_ofc_cd]),SYSDATE),               " ).append("\n"); 
		query.append("    UPD_OFC_CD             =  @[upd_ofc_cd]            " ).append("\n"); 
		query.append("WHERE YD_CD = @[yd_cd]           " ).append("\n"); 
		query.append("AND   YD_EXPT_COST_SEQ = @[yd_expt_cost_seq]" ).append("\n"); 

	}
}