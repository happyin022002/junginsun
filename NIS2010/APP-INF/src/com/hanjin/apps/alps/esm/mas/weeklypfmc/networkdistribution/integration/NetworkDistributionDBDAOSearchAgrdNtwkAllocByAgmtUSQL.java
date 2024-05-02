/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : NetworkDistributionDBDAOSearchAgrdNtwkAllocByAgmtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.09
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkDistributionDBDAOSearchAgrdNtwkAllocByAgmtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [CSR #1763] [ALPS MAS] 약정율 대상항차별 매뉴얼 수정건
	  * </pre>
	  */
	public NetworkDistributionDBDAOSearchAgrdNtwkAllocByAgmtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agrd_expn_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fx_expn_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.integration").append("\n"); 
		query.append("FileName : NetworkDistributionDBDAOSearchAgrdNtwkAllocByAgmtUSQL").append("\n"); 
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
		query.append("UPDATE MAS_ALOC_AGMT_EXPN" ).append("\n"); 
		query.append("   SET AGRD_EXPN_AMT = @[agrd_expn_amt]" ).append("\n"); 
		query.append("     , OVR_USD_AMT   = @[ovr_usd_amt]" ).append("\n"); 
		query.append("     , FX_EXPN_AMT   = @[fx_expn_amt]" ).append("\n"); 
		query.append("     , UPD_USR_ID    = @[upd_usr_id]" ).append("\n"); 
		query.append("     , UPD_DT        = SYSDATE" ).append("\n"); 
		query.append(" WHERE FM_TRD_CD     = @[fm_trd_cd]" ).append("\n"); 
		query.append("   AND FM_RLANE_CD   = @[fm_rlane_cd]" ).append("\n"); 
		query.append("   AND FM_IOC_CD     = @[fm_ioc_cd]" ).append("\n"); 
		query.append("   AND FM_VSL_CD     = SUBSTR(@[fm_vvd], 1, 4)" ).append("\n"); 
		query.append("   AND FM_SKD_VOY_NO = SUBSTR(@[fm_vvd], 5, 4)" ).append("\n"); 
		query.append("   AND FM_DIR_CD     = SUBSTR(@[fm_vvd], 9, 1)" ).append("\n"); 
		query.append("   AND TO_TRD_CD     = @[to_trd_cd]" ).append("\n"); 
		query.append("   AND TO_RLANE_CD   = @[to_rlane_cd]" ).append("\n"); 
		query.append("   AND TO_IOC_CD     = @[to_ioc_cd]" ).append("\n"); 
		query.append("   AND TO_VSL_CD     = SUBSTR(@[to_vvd], 1, 4)" ).append("\n"); 
		query.append("   AND TO_SKD_VOY_NO = SUBSTR(@[to_vvd], 5, 4)" ).append("\n"); 
		query.append("   AND TO_DIR_CD     = SUBSTR(@[to_vvd], 9, 1)" ).append("\n"); 

	}
}