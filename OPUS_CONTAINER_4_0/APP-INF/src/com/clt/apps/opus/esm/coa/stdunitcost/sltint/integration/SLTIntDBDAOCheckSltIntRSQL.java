/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SLTIntDBDAOCheckSltIntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.25 
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

public class SLTIntDBDAOCheckSltIntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * P&L Report Item Insert 전 동일한 Key 를 가진 P&L Report Item 이 있는지 check
	  * ::: SJH.20150224.MOD : from만 같아도 dup임.., 20150225. 결국 뺌
	  *    : AND EFF_TO_YRMON = @[eff_to_yrmon]	
	  * </pre>
	  */
	public SLTIntDBDAOCheckSltIntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eff_fm_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.sltint.integration").append("\n"); 
		query.append("FileName : SLTIntDBDAOCheckSltIntRSQL").append("\n"); 
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
		query.append("SELECT NVL(SUM(CASE WHEN EFF_FM_YRMON = @[eff_fm_yrmon]" ).append("\n"); 
		query.append("                     AND DELT_FLG     = 'N' " ).append("\n"); 
		query.append("                    THEN 1 ELSE 0 END),0) AS CNT" ).append("\n"); 
		query.append("      ,NVL(MAX(RT_SEQ),0)+1               AS MAXSEQ" ).append("\n"); 
		query.append("   FROM COA_SLT_INTER_PRC_UT_COST " ).append("\n"); 
		query.append("  WHERE SLAN_CD    = @[slan_cd]" ).append("\n"); 
		query.append("    AND TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("    AND SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("    AND FM_CNT_CD  = @[fm_cnt_cd]" ).append("\n"); 
		query.append("    AND FM_PORT_CD = NVL(@[fm_port_cd], 'X')" ).append("\n"); 
		query.append("    AND TO_CNT_CD  = @[to_cnt_cd]" ).append("\n"); 
		query.append("    AND TO_PORT_CD = NVL(@[to_port_cd], 'X')" ).append("\n"); 
		query.append("    AND CGO_TP_CD  = @[cgo_tp_cd]" ).append("\n"); 

	}
}