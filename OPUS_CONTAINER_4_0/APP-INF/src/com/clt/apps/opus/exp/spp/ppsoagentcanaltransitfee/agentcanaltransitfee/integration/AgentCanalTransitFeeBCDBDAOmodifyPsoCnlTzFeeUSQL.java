/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgentCanalTransitFeeBCDBDAOmodifyPsoCnlTzFeeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 안준상
*@LastVersion : 1.0
* 2010.02.19 안준상
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jsahn
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgentCanalTransitFeeBCDBDAOmodifyPsoCnlTzFeeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyPsoCnlTzFee02
	  * </pre>
	  */
	public AgentCanalTransitFeeBCDBDAOmodifyPsoCnlTzFeeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnl_tz_bztp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tr_vol_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnl_tz_proc_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("suz_net_tong_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.integration").append("\n"); 
		query.append("FileName : AgentCanalTransitFeeBCDBDAOmodifyPsoCnlTzFeeUSQL").append("\n"); 
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
		query.append("UPDATE PSO_CNL_TZ_FEE" ).append("\n"); 
		query.append("SET  NTC_YRMON		   = @[ntc_yrmon]" ).append("\n"); 
		query.append(",CNL_TZ_PROC_STS_CD = @[cnl_tz_proc_sts_cd]" ).append("\n"); 
		query.append(",SUZ_NET_TONG_WGT   = @[suz_net_tong_wgt]" ).append("\n"); 
		query.append(",LOCL_XCH_RT   	   = @[locl_xch_rt]" ).append("\n"); 
		query.append(",TR_VOL_VAL   	   = @[tr_vol_val]" ).append("\n"); 
		query.append(",SCG_RT_AMT   	   = @[scg_rt_amt]" ).append("\n"); 
		query.append(",REV_YRMON   	   = @[rev_yrmon]" ).append("\n"); 
		query.append(",RQST_USR_ID        = @[rqst_usr_id]" ).append("\n"); 
		query.append("#if (${cnl_tz_proc_sts_cd} == 'Q')" ).append("\n"); 
		query.append(",RQST_DT            = SYSDATE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",UPD_USR_ID         = @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT             = SYSDATE" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND PSO_BZTP_CD    = 5" ).append("\n"); 
		query.append("AND VSL_CD         = @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO     = @[skd_voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD     = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND YD_CD          = @[yd_cd]" ).append("\n"); 
		query.append("AND CALL_SEQ       = @[call_seq]" ).append("\n"); 
		query.append("AND CNL_TZ_BZTP_CD = @[cnl_tz_bztp_cd]  --'E', 'I'" ).append("\n"); 
		query.append("AND VNDR_SEQ       = @[vndr_seq]" ).append("\n"); 

	}
}