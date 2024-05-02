/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOMultiSpcAlocPolPodRmkUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.14
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2015.01.14 신자영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHIN JA YOUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOMultiSpcAlocPolPodRmkUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPC_ALOC_POL_POD의 지정된 ibflag 값에 따라 DB에 반영한다.(수정).
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOMultiSpcAlocPolPodRmkUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("account_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spc_ctrl_aloc_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("us_mod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spc_ctrl_aloc_pod_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spc_ctrl_aloc_pol_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOMultiSpcAlocPolPodRmkUSQL").append("\n"); 
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
		query.append("UPDATE SPC_ALOC_POL_POD  " ).append("\n"); 
		query.append("   SET" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '0000000' && ${pod_cd} != '0000000' && ${rmk_size} > 0 && ${pod_rmk_size} <= 0)" ).append("\n"); 
		query.append("       SPC_CTRL_ALOC_POD_RMK = @[spc_ctrl_aloc_rmk]," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '0000000' && ${pod_cd} != '0000000' && ${rmk_size} > 0 && ${pod_rmk_size} > 0)" ).append("\n"); 
		query.append("       SPC_CTRL_ALOC_POD_RMK = @[spc_ctrl_aloc_rmk]," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '0000000' && ${pod_cd} != '0000000' && ${rmk_size} <= 0 && ${pol_rmk_size} <= 0)" ).append("\n"); 
		query.append("       SPC_CTRL_ALOC_POD_RMK = @[spc_ctrl_aloc_pod_rmk]," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '0000000' && ${pod_cd} != '0000000' && ${pol_rmk_size} > 0 && ${pod_rmk_size} > 0)" ).append("\n"); 
		query.append("       SPC_CTRL_ALOC_POD_RMK = @[spc_ctrl_aloc_pol_rmk]," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '0000000' && ${pod_cd} != '0000000' && ${pol_rmk_size} > 0 && ${pod_rmk_size} <= 0)" ).append("\n"); 
		query.append("       SPC_CTRL_ALOC_POD_RMK = @[spc_ctrl_aloc_pol_rmk]," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("       UPD_DT     = SYSDATE" ).append("\n"); 
		query.append(" WHERE RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("   AND DIR_CD     = @[dir_cd]" ).append("\n"); 
		query.append("   AND VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("   AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND SLS_OFC_CD = @[sls_ofc_cd]" ).append("\n"); 
		query.append("   AND IOC_CD     = 'I'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '0000000' && ${pod_cd} != '0000000')" ).append("\n"); 
		query.append("   AND POL_YD_CD  = @[pol_cd]" ).append("\n"); 
		query.append("   AND POD_YD_CD  = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_yd_cd} != '0000000' && ${pod_yd_cd} == '0000000')" ).append("\n"); 
		query.append("   AND POL_YD_CD  = @[pol_yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   -- Allocation 세분화 관련 추가" ).append("\n"); 
		query.append("   AND CUST_CNT_CD = DECODE(@[account_cd], 'OTHERS', 'XX', SUBSTR(@[account_cd], 1, 2))" ).append("\n"); 
		query.append("   AND CUST_SEQ = DECODE(@[account_cd], 'OTHERS', '999999', SUBSTR(@[account_cd], 3, 6))" ).append("\n"); 
		query.append("   AND CTRT_NO  = @[ctrt_no]" ).append("\n"); 
		query.append("   AND USA_BKG_MOD_CD = DECODE(@[us_mod], 'OTHERS', 'OTH',  @[us_mod])" ).append("\n"); 
		query.append("   AND TS_FLG     = @[ts_flg]" ).append("\n"); 
		query.append("   AND MNL_FLG    = @[mnl_flg]" ).append("\n"); 
		query.append("   AND IOC_CD     = DECODE(@[ioc_cd], 'OCN', 'O', 'T-OCN', 'O', 'I')" ).append("\n"); 

	}
}