/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentTradeDBDAOUpdateSaqMonQtaTrd0176USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.04
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.05.04 이상용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SangYong Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaAdjustmentTradeDBDAOUpdateSaqMonQtaTrd0176USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Excel Upload Save 처리
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentTradeDBDAOUpdateSaqMonQtaTrd0176USQL(){
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
		params.put("ctrt_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mqta_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentTradeDBDAOUpdateSaqMonQtaTrd0176USQL").append("\n"); 
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
		query.append("UPDATE SAQ_MON_QTA_TRD TRD" ).append("\n"); 
		query.append("SET   TRD.LOD_QTY = @[lod_qty]*${unit_flag}," ).append("\n"); 
		query.append("      TRD.GRS_RPB_REV = @[grs_rpb_rev]/${unit_flag}," ).append("\n"); 
		query.append("      TRD.UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("      TRD.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE TRD.MQTA_STEP_CD = @[mqta_step_cd]" ).append("\n"); 
		query.append("AND   TRD.BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("AND   TRD.BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append("AND   TRD.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("AND   TRD.DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND   TRD.MQTA_VER_NO = @[mqta_ver_no]" ).append("\n"); 
		query.append("AND   TRD.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("AND   TRD.SPRT_GRP_CD = @[sprt_grp_cd]" ).append("\n"); 
		query.append("AND   TRD.BSA_GRP_CD = @[bsa_grp_cd]" ).append("\n"); 
		query.append("AND   TRD.CTRT_RHQ_CD = @[ctrt_rhq_cd]" ).append("\n"); 
		query.append("AND   TRD.BSE_MON = @[bse_mon]" ).append("\n"); 

	}
}