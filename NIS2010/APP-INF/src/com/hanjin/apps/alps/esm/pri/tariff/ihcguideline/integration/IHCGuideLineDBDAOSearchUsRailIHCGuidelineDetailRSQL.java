/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : IHCGuideLineDBDAOSearchUsRailIHCGuidelineDetailRSQL.java
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

public class IHCGuideLineDBDAOSearchUsRailIHCGuidelineDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search US Rail IHC Guideline Detail
	  * </pre>
	  */
	public IHCGuideLineDBDAOSearchUsRailIHCGuidelineDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : IHCGuideLineDBDAOSearchUsRailIHCGuidelineDetailRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT RT.HUB_LOC_CD" ).append("\n"); 
		query.append("              , LOC.LOC_NM AS PNT_LOC_NM" ).append("\n"); 
		query.append("              , RT.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("              , RT.BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("              , RT.COST_20FT_RAIL_FRT_RT_AMT" ).append("\n"); 
		query.append("              , RT.COST_40FT_RAIL_FRT_RT_AMT" ).append("\n"); 
		query.append(" FROM PRI_TRF_IHC_RT RT" ).append("\n"); 
		query.append("    , MDM_LOCATION LOC" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND RT.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("  AND RT.ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("  AND RT.IHC_TRF_NO = @[ihc_trf_no]" ).append("\n"); 
		query.append("  AND RT.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("  AND RT.IHC_CGO_TP_CD = @[ihc_cgo_tp_cd]" ).append("\n"); 
		query.append("  AND RT.RCV_DE_TERM_CD = @[rcv_de_term_cd]" ).append("\n"); 
		query.append("  AND RT.HUB_LOC_CD = LOC.LOC_CD" ).append("\n"); 
		query.append("  AND RT.OPTM_TRSP_MOD_FLG = 'Y'" ).append("\n"); 
		query.append("  AND RT.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("  AND RT.PRC_TRSP_MOD_CD IN ('R','B')" ).append("\n"); 
		query.append("ORDER BY RT.HUB_LOC_CD, RT.BSE_PORT_LOC_CD" ).append("\n"); 

	}
}