/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SLTIntDBDAOSlotInternalPricingVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.sltint.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SLTIntDBDAOSlotInternalPricingVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * @20140917.SJH : COA_SLT_INTER_PRC_UT_COST 테이블의 데이터 삽입
	  * </pre>
	  */
	public SLTIntDBDAOSlotInternalPricingVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_fm_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_hc_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_45ft_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_20ft_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_40ft_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_to_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.sltint.integration").append("\n"); 
		query.append("FileName : SLTIntDBDAOSlotInternalPricingVOCSQL").append("\n"); 
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
		query.append("MERGE INTO COA_SLT_INTER_PRC_UT_COST B1" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("       SELECT '1' FROM DUAL " ).append("\n"); 
		query.append("	  ) B2	" ).append("\n"); 
		query.append("ON (     B1.SLAN_CD     = @[slan_cd]" ).append("\n"); 
		query.append("	 AND B1.TRD_CD      = @[trd_cd]    						" ).append("\n"); 
		query.append("	 AND B1.SUB_TRD_CD  = @[sub_trd_cd]" ).append("\n"); 
		query.append("     AND B1.FM_CNT_CD   = @[fm_cnt_cd]" ).append("\n"); 
		query.append("     AND B1.TO_CNT_CD   = @[to_cnt_cd] " ).append("\n"); 
		query.append("     AND B1.FM_PORT_CD  = NVL(@[fm_port_cd], 'X')" ).append("\n"); 
		query.append("     AND B1.TO_PORT_CD  = NVL(@[to_port_cd], 'X')" ).append("\n"); 
		query.append("     AND B1.CGO_TP_CD   = @[cgo_tp_cd]      " ).append("\n"); 
		query.append("     AND B1.EFF_FM_YRMON= @[eff_fm_yrmon]" ).append("\n"); 
		query.append("     AND B1.DELT_FLG    = 'N' ) " ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("      UPDATE " ).append("\n"); 
		query.append("         SET CNTR_20FT_RT_AMT  = @[cntr_20ft_rt_amt]" ).append("\n"); 
		query.append("            ,CNTR_40FT_RT_AMT  = @[cntr_40ft_rt_amt]" ).append("\n"); 
		query.append("            ,CNTR_HC_RT_AMT    = @[cntr_hc_rt_amt] " ).append("\n"); 
		query.append("            ,CNTR_45FT_RT_AMT  = @[cntr_45ft_rt_amt]" ).append("\n"); 
		query.append("            ,EFF_TO_YRMON      = @[eff_to_yrmon]" ).append("\n"); 
		query.append("            ,BAT_FLG           = 'Y'					--SJH.20141216.ADD" ).append("\n"); 
		query.append("            ,UPD_USR_ID        = @[upd_usr_id]" ).append("\n"); 
		query.append("            ,UPD_DT            = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("      INSERT (SLAN_CD         " ).append("\n"); 
		query.append("             ,TRD_CD          " ).append("\n"); 
		query.append("             ,SUB_TRD_CD      " ).append("\n"); 
		query.append("             ,FM_CNT_CD       " ).append("\n"); 
		query.append("             ,TO_CNT_CD       " ).append("\n"); 
		query.append("             ,FM_PORT_CD      " ).append("\n"); 
		query.append("             ,TO_PORT_CD      " ).append("\n"); 
		query.append("             ,CGO_TP_CD       " ).append("\n"); 
		query.append("             ,RT_SEQ          " ).append("\n"); 
		query.append("             ,EFF_FM_YRMON    " ).append("\n"); 
		query.append("             ,EFF_TO_YRMON    " ).append("\n"); 
		query.append("             ,CNTR_20FT_RT_AMT" ).append("\n"); 
		query.append("             ,CNTR_40FT_RT_AMT" ).append("\n"); 
		query.append("             ,CNTR_HC_RT_AMT  " ).append("\n"); 
		query.append("             ,CNTR_45FT_RT_AMT" ).append("\n"); 
		query.append("             ,BAT_FLG									--SJH.20141216.ADD" ).append("\n"); 
		query.append("             ,DELT_FLG        " ).append("\n"); 
		query.append("             ,CRE_USR_ID      " ).append("\n"); 
		query.append("             ,CRE_DT          " ).append("\n"); 
		query.append("             ,UPD_USR_ID      " ).append("\n"); 
		query.append("             ,UPD_DT) " ).append("\n"); 
		query.append("      VALUES (@[slan_cd]         " ).append("\n"); 
		query.append("             ,@[trd_cd]          " ).append("\n"); 
		query.append("             ,@[sub_trd_cd]      " ).append("\n"); 
		query.append("             ,@[fm_cnt_cd]        " ).append("\n"); 
		query.append("             ,@[to_cnt_cd]       " ).append("\n"); 
		query.append("             ,NVL(@[fm_port_cd], 'X')" ).append("\n"); 
		query.append("             ,NVL(@[to_port_cd], 'X')" ).append("\n"); 
		query.append("             ,@[cgo_tp_cd]       " ).append("\n"); 
		query.append("             ,@[rt_seq]" ).append("\n"); 
		query.append("             ,@[eff_fm_yrmon]" ).append("\n"); 
		query.append("             ,@[eff_to_yrmon]" ).append("\n"); 
		query.append("             ,@[cntr_20ft_rt_amt]" ).append("\n"); 
		query.append("             ,@[cntr_40ft_rt_amt]" ).append("\n"); 
		query.append("             ,@[cntr_hc_rt_amt]  " ).append("\n"); 
		query.append("             ,@[cntr_45ft_rt_amt]" ).append("\n"); 
		query.append("             ,'Y'										--SJH.20141216.ADD" ).append("\n"); 
		query.append("             ,'N'" ).append("\n"); 
		query.append("             ,@[cre_usr_id]" ).append("\n"); 
		query.append("             ,SYSDATE" ).append("\n"); 
		query.append("             ,@[upd_usr_id]" ).append("\n"); 
		query.append("             ,SYSDATE)" ).append("\n"); 

	}
}