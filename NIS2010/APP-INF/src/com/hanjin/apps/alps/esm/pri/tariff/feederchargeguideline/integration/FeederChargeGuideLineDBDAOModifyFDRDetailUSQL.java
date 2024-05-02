/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FeederChargeGuideLineDBDAOModifyFDRDetailUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FeederChargeGuideLineDBDAOModifyFDRDetailUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Modify FDR Detail
	  * 
	  * * History
	  * 2013.03.16 [CHM-201534279] 전지예 Pricing Feeder/IHC tariff 45" 칼럼 추가 안
	  * </pre>
	  */
	public FeederChargeGuideLineDBDAOModifyFDRDetailUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_cmnc_amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_info_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_rf_20ft_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_40ft_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_20ft_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_rf_40ft_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fdr_rt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_45ft_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_svc_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.integration").append("\n"); 
		query.append("FileName : FeederChargeGuideLineDBDAOModifyFDRDetailUSQL").append("\n"); 
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
		query.append("UPDATE PRI_TRF_FDR_RT" ).append("\n"); 
		query.append("   SET GLINE_20FT_FRT_RT_AMT     = @[gline_20ft_frt_rt_amt]" ).append("\n"); 
		query.append("     , GLINE_40FT_FRT_RT_AMT     = @[gline_40ft_frt_rt_amt]" ).append("\n"); 
		query.append("     , GLINE_45FT_FRT_RT_AMT    = @[gline_45ft_frt_rt_amt] -- 45' Cost 추가" ).append("\n"); 
		query.append("     , GLINE_RF_20FT_FRT_RT_AMT  = @[gline_rf_20ft_frt_rt_amt]" ).append("\n"); 
		query.append("     , GLINE_RF_40FT_FRT_RT_AMT  = @[gline_rf_40ft_frt_rt_amt]" ).append("\n"); 
		query.append("     , RC_SVC_FLG                = @[rc_svc_flg]" ).append("\n"); 
		query.append("     , N1ST_CMNC_AMDT_SEQ        = @[n1st_cmnc_amdt_seq]" ).append("\n"); 
		query.append("     , SRC_INFO_CD               = @[src_info_cd]" ).append("\n"); 
		query.append("     , FDR_RT_RMK                = @[fdr_rt_rmk]" ).append("\n"); 
		query.append("     , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("     , UPD_DT     = SYSDATE" ).append("\n"); 
		query.append(" WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND FDR_TRF_NO = @[fdr_trf_no]" ).append("\n"); 
		query.append("   AND AMDT_SEQ   = @[amdt_seq]" ).append("\n"); 
		query.append("   AND RT_SEQ     = @[rt_seq]" ).append("\n"); 
		query.append("   AND ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 

	}
}