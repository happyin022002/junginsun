/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SLTIntDBDAOSlotInternalPricingVORSQL.java
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

public class SLTIntDBDAOSlotInternalPricingVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * @20140916.SJH : COA_SLT_INTER_PRC_UT_COST 조회
	  * </pre>
	  */
	public SLTIntDBDAOSlotInternalPricingVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_eff_fm_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_slane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.sltint.integration").append("\n"); 
		query.append("FileName : SLTIntDBDAOSlotInternalPricingVORSQL").append("\n"); 
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
		query.append("SELECT RANK() OVER (ORDER BY SLAN_CD||TRD_CD||SUB_TRD_CD||FM_CNT_CD||FM_PORT_CD||TO_CNT_CD||TO_PORT_CD||CGO_TP_CD) GRP" ).append("\n"); 
		query.append("  	    ,MAX(RT_SEQ) OVER(PARTITION BY SLAN_CD||TRD_CD||SUB_TRD_CD||FM_CNT_CD||FM_PORT_CD||TO_CNT_CD||TO_PORT_CD||CGO_TP_CD) MAXSEQ" ).append("\n"); 
		query.append("  	    ,RT_SEQ" ).append("\n"); 
		query.append("  	    ,RT_SEQ                    RT_SEQ_ORG" ).append("\n"); 
		query.append("        ,SLAN_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("  	    ,SUB_TRD_CD" ).append("\n"); 
		query.append("  	    ,FM_CNT_CD" ).append("\n"); 
		query.append("  	    ,DECODE(TRIM(FM_PORT_CD), 'X', '', FM_PORT_CD) FM_PORT_CD" ).append("\n"); 
		query.append("  	    ,TO_CNT_CD" ).append("\n"); 
		query.append("  	    ,DECODE(TRIM(TO_PORT_CD), 'X', '', TO_PORT_CD) TO_PORT_CD	     " ).append("\n"); 
		query.append("  	    ,CGO_TP_CD" ).append("\n"); 
		query.append("  	    ,NVL(CNTR_20FT_RT_AMT,0)   CNTR_20FT_RT_AMT" ).append("\n"); 
		query.append("        ,NVL(CNTR_40FT_RT_AMT,0)   CNTR_40FT_RT_AMT" ).append("\n"); 
		query.append("        ,NVL(CNTR_HC_RT_AMT,0)     CNTR_HC_RT_AMT" ).append("\n"); 
		query.append("        ,NVL(CNTR_45FT_RT_AMT,0)   CNTR_45FT_RT_AMT" ).append("\n"); 
		query.append("        ,EFF_FM_YRMON" ).append("\n"); 
		query.append("        ,EFF_TO_YRMON" ).append("\n"); 
		query.append("        ,BAT_FLG								--SJH.20141216.ADD" ).append("\n"); 
		query.append("   FROM COA_SLT_INTER_PRC_UT_COST " ).append("\n"); 
		query.append("  WHERE 1=1" ).append("\n"); 
		query.append("    AND SLAN_CD    = NVL(@[f_slane_cd], SLAN_CD)" ).append("\n"); 
		query.append("    AND TRD_CD     = NVL(@[f_trd_cd], TRD_CD)" ).append("\n"); 
		query.append("    AND SUB_TRD_CD = NVL(@[f_sub_trd_cd], SUB_TRD_CD)" ).append("\n"); 
		query.append("    #if (${f_fm_port_cd} != '')" ).append("\n"); 
		query.append("      #if (${f_fm_len} == '2')" ).append("\n"); 
		query.append("      AND FM_CNT_CD LIKE @[f_fm_port_cd]||'%'" ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("      AND FM_PORT_CD LIKE @[f_fm_port_cd]||'%'" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_to_port_cd} != '')" ).append("\n"); 
		query.append("      #if (${f_to_len} == '2')" ).append("\n"); 
		query.append("      AND TO_CNT_CD LIKE @[f_to_port_cd]||'%'" ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("      AND TO_PORT_CD LIKE @[f_to_port_cd]||'%'" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    AND CGO_TP_CD  = NVL(@[f_cgo_tp_cd], CGO_TP_CD)" ).append("\n"); 
		query.append("    #if (${f_eff_fm_yrmon} != '')" ).append("\n"); 
		query.append("    AND NVL(EFF_TO_YRMON,'999912') >= @[f_eff_fm_yrmon]		--SJH.20141110.MOD, 20141224.MOD : NULL가능" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("  ORDER BY SLAN_CD, TRD_CD, SUB_TRD_CD, FM_PORT_CD, FM_CNT_CD, TO_PORT_CD, TO_CNT_CD, CGO_TP_CD, EFF_FM_YRMON, EFF_TO_YRMON, RT_SEQ" ).append("\n"); 

	}
}