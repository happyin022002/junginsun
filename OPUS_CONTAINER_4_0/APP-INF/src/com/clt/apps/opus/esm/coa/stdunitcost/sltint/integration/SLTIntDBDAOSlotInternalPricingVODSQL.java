/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SLTIntDBDAOSlotInternalPricingVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.26 
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

public class SLTIntDBDAOSlotInternalPricingVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * @20140917.SJH : Slot Internal Pricing 정보를 삭제한다.
	  * </pre>
	  */
	public SLTIntDBDAOSlotInternalPricingVODSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : SLTIntDBDAOSlotInternalPricingVODSQL").append("\n"); 
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
		query.append("UPDATE COA_SLT_INTER_PRC_UT_COST " ).append("\n"); 
		query.append("   SET DELT_FLG   = 'Y'" ).append("\n"); 
		query.append("      ,BAT_FLG    = NULL			--SJH.20141226.ADD" ).append("\n"); 
		query.append("      ,UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT     = SYSDATE" ).append("\n"); 
		query.append(" WHERE SLAN_CD    = @[slan_cd]   " ).append("\n"); 
		query.append("   AND TRD_CD     = @[trd_cd]    " ).append("\n"); 
		query.append("   AND SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("   AND FM_CNT_CD  = @[fm_cnt_cd] " ).append("\n"); 
		query.append("   AND TO_CNT_CD  = @[to_cnt_cd] " ).append("\n"); 
		query.append("   AND FM_PORT_CD = NVL(@[fm_port_cd], 'X')" ).append("\n"); 
		query.append("   AND TO_PORT_CD = NVL(@[to_port_cd], 'X')" ).append("\n"); 
		query.append("   AND CGO_TP_CD  = @[cgo_tp_cd] " ).append("\n"); 
		query.append("   AND RT_SEQ     = @[rt_seq]" ).append("\n"); 

	}
}