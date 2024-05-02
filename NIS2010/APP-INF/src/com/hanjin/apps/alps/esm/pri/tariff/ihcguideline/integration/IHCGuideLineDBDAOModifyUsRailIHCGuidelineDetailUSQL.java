/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : IHCGuideLineDBDAOModifyUsRailIHCGuidelineDetailUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.26
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2012.12.26 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IHCGuideLineDBDAOModifyUsRailIHCGuidelineDetailUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Modify US Rail IHC Guideline Detail
	  * </pre>
	  */
	public IHCGuideLineDBDAOModifyUsRailIHCGuidelineDetailUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_20ft_rail_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_port_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ihc_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ihc_trf_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_40ft_rail_frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hub_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration").append("\n"); 
		query.append("FileName : IHCGuideLineDBDAOModifyUsRailIHCGuidelineDetailUSQL").append("\n"); 
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
		query.append("UPDATE PRI_TRF_IHC_RT" ).append("\n"); 
		query.append("   SET GLINE_20FT_RAIL_FRT_RT_AMT = @[gline_20ft_rail_frt_rt_amt]" ).append("\n"); 
		query.append("     , GLINE_40FT_RAIL_FRT_RT_AMT = @[gline_40ft_rail_frt_rt_amt]" ).append("\n"); 
		query.append("	 , GLINE_20FT_FRT_RT_AMT = NVL(@[gline_20ft_rail_frt_rt_amt],0) + NVL(GLINE_20FT_TRK_FRT_RT_AMT,0)" ).append("\n"); 
		query.append("     , GLINE_40FT_FRT_RT_AMT = NVL(@[gline_40ft_rail_frt_rt_amt],0) + NVL(GLINE_40FT_TRK_FRT_RT_AMT,0)" ).append("\n"); 
		query.append("     , N1ST_CMNC_AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("     , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("     , UPD_DT     = SYSDATE" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("  AND ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("  AND IHC_TRF_NO = @[ihc_trf_no]" ).append("\n"); 
		query.append("  AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("  AND IHC_CGO_TP_CD = @[ihc_cgo_tp_cd]" ).append("\n"); 
		query.append("  AND HUB_LOC_CD = @[hub_loc_cd]" ).append("\n"); 
		query.append("  AND BSE_PORT_LOC_CD = @[bse_port_loc_cd]" ).append("\n"); 
		query.append("  AND PRC_TRSP_MOD_CD IN ('A','R')" ).append("\n"); 
		query.append("  AND OPTM_TRSP_MOD_FLG = 'Y'" ).append("\n"); 
		query.append("  AND SRC_INFO_CD <> 'AD'" ).append("\n"); 

	}
}