/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentRHQDBDAOUpdateSaqMonQta0161USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaAdjustmentRHQDBDAOUpdateSaqMonQta0161USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Excel Upload Save 처리
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentRHQDBDAOUpdateSaqMonQta0161USQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrt_rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_mon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lod_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqta_step_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sprt_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_rpb_rev",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqta_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentRHQDBDAOUpdateSaqMonQta0161USQL").append("\n"); 
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
		query.append("#if (${mqtaStepCd} == '08') " ).append("\n"); 
		query.append("	UPDATE SAQ_MON_QTA_LOD_TGT RHQ" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	UPDATE SAQ_MON_QTA_RHQ RHQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SET   RHQ.LOD_QTY = @[lod_qty]*${unit_flag}," ).append("\n"); 
		query.append("      RHQ.GRS_RPB_REV = @[grs_rpb_rev]/${unit_flag}," ).append("\n"); 
		query.append("      RHQ.UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("      RHQ.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE RHQ.MQTA_STEP_CD = @[mqta_step_cd]" ).append("\n"); 
		query.append("AND   RHQ.BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("AND   RHQ.BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append("AND   RHQ.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("AND   RHQ.DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND   RHQ.MQTA_VER_NO = @[mqta_ver_no]" ).append("\n"); 
		query.append("AND   RHQ.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("AND   RHQ.SPRT_GRP_CD = @[sprt_grp_cd]" ).append("\n"); 
		query.append("AND   RHQ.BSA_GRP_CD = @[bsa_grp_cd]" ).append("\n"); 
		query.append("#if (${mqtaStepCd} == '08') " ).append("\n"); 
		query.append("	AND   RHQ.SLS_RGN_OFC_CD = @[ctrt_rgn_ofc_cd]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	AND   RHQ.CTRT_RGN_OFC_CD = @[ctrt_rgn_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   RHQ.BSE_MON = @[bse_mon]" ).append("\n"); 
		query.append("#if (${mqtaStepCd} == '08') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inclPortFlag} == 'Y') " ).append("\n"); 
		query.append("	AND   RHQ.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("	AND   RHQ.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	AND   RHQ.POL_CD = '00000'" ).append("\n"); 
		query.append("	AND   RHQ.POD_CD = '00000'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}