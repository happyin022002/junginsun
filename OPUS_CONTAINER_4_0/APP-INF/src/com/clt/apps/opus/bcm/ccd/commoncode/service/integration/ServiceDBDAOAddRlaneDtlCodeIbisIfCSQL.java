/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ServiceDBDAOAddRlaneDtlCodeIbisIfCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.service.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ServiceDBDAOAddRlaneDtlCodeIbisIfCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ServiceDBDAOAddRlaneDtlCodeIbisIfCSQL(){
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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dtl_delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_mnpl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dmnt_leg_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.service.integration ").append("\n"); 
		query.append("FileName : ServiceDBDAOAddRlaneDtlCodeIbisIfCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_DTL_REV_LANE_IBIS_IF" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("   DTL_RLANE_IBIS_IF_SEQ, " ).append("\n"); 
		query.append("   RLANE_CD, " ).append("\n"); 
		query.append("   VSL_SLAN_DIR_CD, " ).append("\n"); 
		query.append("   IOC_CD, " ).append("\n"); 
		query.append("   FM_CONTI_CD, " ).append("\n"); 
		query.append("   TO_CONTI_CD, " ).append("\n"); 
		query.append("   TRD_CD, " ).append("\n"); 
		query.append("   SUB_TRD_CD, " ).append("\n"); 
		query.append("   CRE_USR_ID, " ).append("\n"); 
		query.append("   CRE_DT, " ).append("\n"); 
		query.append("   UPD_USR_ID, " ).append("\n"); 
		query.append("   UPD_DT, " ).append("\n"); 
		query.append("   DELT_FLG, " ).append("\n"); 
		query.append("   DMNT_LEG_FLG," ).append("\n"); 
		query.append("   IF_MNPL_CD" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("  MDM_DTL_REV_LANE_IBIS_IF_SEQ.NEXTVAL," ).append("\n"); 
		query.append("  @[rlane_cd]," ).append("\n"); 
		query.append("  @[vsl_slan_dir_cd]," ).append("\n"); 
		query.append("  @[ioc_cd]," ).append("\n"); 
		query.append("  @[fm_conti_cd]," ).append("\n"); 
		query.append("  @[to_conti_cd]," ).append("\n"); 
		query.append("  @[trd_cd]," ).append("\n"); 
		query.append("  @[sub_trd_cd]," ).append("\n"); 
		query.append("  @[user_id]," ).append("\n"); 
		query.append("  SYSDATE," ).append("\n"); 
		query.append("  @[user_id]," ).append("\n"); 
		query.append("  SYSDATE," ).append("\n"); 
		query.append("  @[dtl_delt_flg]," ).append("\n"); 
		query.append("  @[dmnt_leg_flg]," ).append("\n"); 
		query.append("  @[if_mnpl_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}