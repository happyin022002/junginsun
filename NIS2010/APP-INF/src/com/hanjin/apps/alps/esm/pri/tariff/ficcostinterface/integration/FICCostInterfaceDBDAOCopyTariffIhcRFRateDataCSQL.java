/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : FICCostInterfaceDBDAOCopyTariffIhcRFRateDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.14
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FICCostInterfaceDBDAOCopyTariffIhcRFRateDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CopyTariffIhcRFRateData
	  * 2013.02.07 [CHM-201322859] 서미진 copy 시 weight 컬럼 추가
	  * </pre>
	  */
	public FICCostInterfaceDBDAOCopyTariffIhcRFRateDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ori_ihc_trf_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ori_amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ori_svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.integration").append("\n"); 
		query.append("FileName : FICCostInterfaceDBDAOCopyTariffIhcRFRateDataCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_TRF_IHC_RT (" ).append("\n"); 
		query.append("            SVC_SCP_CD" ).append("\n"); 
		query.append("          , ORG_DEST_TP_CD  " ).append("\n"); 
		query.append("          , IHC_TRF_NO" ).append("\n"); 
		query.append("          , AMDT_SEQ" ).append("\n"); 
		query.append("          , IHC_CGO_TP_CD" ).append("\n"); 
		query.append("          , RT_SEQ        " ).append("\n"); 
		query.append("          , N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("          , PNT_LOC_CD" ).append("\n"); 
		query.append("          , PNT_NOD_CD" ).append("\n"); 
		query.append("          , HUB_LOC_CD" ).append("\n"); 
		query.append("          , HUB_NOD_CD" ).append("\n"); 
		query.append("          , BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("          , BSE_PORT_NOD_CD" ).append("\n"); 
		query.append("          , RCV_DE_TERM_CD" ).append("\n"); 
		query.append("          , PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("          , GLINE_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("          , GLINE_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("          , COST_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("          , COST_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("          , LOCL_CURR_COST_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("          , LOCL_CURR_COST_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("          , IHC_COST_LOC_GRP_NO" ).append("\n"); 
		query.append("          , TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("          , TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("          , TRSP_20FT_AGMT_WGT" ).append("\n"); 
		query.append("          , TRSP_40FT_AGMT_WGT " ).append("\n"); 
		query.append("          , MTY_TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("          , MTY_TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("          , TML_20FT_COST_AMT" ).append("\n"); 
		query.append("          , TML_40FT_COST_AMT" ).append("\n"); 
		query.append("          , MB_20FT_RTO" ).append("\n"); 
		query.append("          , MB_40FT_RTO" ).append("\n"); 
		query.append("          , GLINE_DG_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("          , GLINE_DG_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("          , GLINE_OVR_WGT_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("          , GLINE_OVR_WGT_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("          , ORG_COST_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("          , ORG_COST_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("          , GLINE_LOCL_CURR_20FT_AMT" ).append("\n"); 
		query.append("          , GLINE_LOCL_CURR_40FT_AMT" ).append("\n"); 
		query.append("          , GLINE_LOCL_CURR_DG_20FT_AMT" ).append("\n"); 
		query.append("          , GLINE_LOCL_CURR_DG_40FT_AMT" ).append("\n"); 
		query.append("          , GLINE_LOCL_CURR_OVR_20FT_AMT" ).append("\n"); 
		query.append("          , GLINE_LOCL_CURR_OVR_40FT_AMT" ).append("\n"); 
		query.append("          , OPTM_TRSP_MOD_FLG          " ).append("\n"); 
		query.append("          , SRC_INFO_CD" ).append("\n"); 
		query.append("          , IHC_RT_RMK" ).append("\n"); 
		query.append("          , DCGO_SVC_FLG" ).append("\n"); 
		query.append("          , PRC_TRF_CRE_TP_CD" ).append("\n"); 
		query.append("          , LOCL_CURR_CD" ).append("\n"); 
		query.append("          , USA_COST_TRF_SVC_MOD_CD" ).append("\n"); 
		query.append("          , CRE_USR_ID" ).append("\n"); 
		query.append("          , CRE_DT" ).append("\n"); 
		query.append("          , UPD_USR_ID" ).append("\n"); 
		query.append("          , UPD_DT" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("    SELECT @[svc_scp_cd]" ).append("\n"); 
		query.append("         , @[org_dest_tp_cd]" ).append("\n"); 
		query.append("         , @[ihc_trf_no] " ).append("\n"); 
		query.append("         , '0'" ).append("\n"); 
		query.append("         , 'RF' AS IHC_CGO_TP_CD" ).append("\n"); 
		query.append("         , ROWNUM RT_SEQ" ).append("\n"); 
		query.append("         , '0' AS N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("         , PNT_LOC_CD" ).append("\n"); 
		query.append("         , PNT_NOD_CD" ).append("\n"); 
		query.append("         , HUB_LOC_CD" ).append("\n"); 
		query.append("         , HUB_NOD_CD" ).append("\n"); 
		query.append("         , BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("         , BSE_PORT_NOD_CD" ).append("\n"); 
		query.append("         , RCV_DE_TERM_CD" ).append("\n"); 
		query.append("         , PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("         , GLINE_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("         , GLINE_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("         , COST_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("         , COST_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("         , LOCL_CURR_COST_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("         , LOCL_CURR_COST_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("         , IHC_COST_LOC_GRP_NO" ).append("\n"); 
		query.append("         , TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("         , TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("         , TRSP_20FT_AGMT_WGT" ).append("\n"); 
		query.append("         , TRSP_40FT_AGMT_WGT" ).append("\n"); 
		query.append("         , MTY_TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("         , MTY_TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("         , TML_20FT_COST_AMT" ).append("\n"); 
		query.append("         , TML_40FT_COST_AMT" ).append("\n"); 
		query.append("         , MB_20FT_RTO" ).append("\n"); 
		query.append("         , MB_40FT_RTO" ).append("\n"); 
		query.append("         , GLINE_DG_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("         , GLINE_DG_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("         , GLINE_OVR_WGT_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("         , GLINE_OVR_WGT_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("         , ORG_COST_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("         , ORG_COST_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("         , GLINE_LOCL_CURR_20FT_AMT" ).append("\n"); 
		query.append("         , GLINE_LOCL_CURR_40FT_AMT" ).append("\n"); 
		query.append("         , GLINE_LOCL_CURR_DG_20FT_AMT" ).append("\n"); 
		query.append("         , GLINE_LOCL_CURR_DG_40FT_AMT" ).append("\n"); 
		query.append("         , GLINE_LOCL_CURR_OVR_20FT_AMT" ).append("\n"); 
		query.append("         , GLINE_LOCL_CURR_OVR_40FT_AMT" ).append("\n"); 
		query.append("         , OPTM_TRSP_MOD_FLG         " ).append("\n"); 
		query.append("         , 'NW' AS SRC_INFO_CD" ).append("\n"); 
		query.append("         , IHC_RT_RMK          " ).append("\n"); 
		query.append("         , DCGO_SVC_FLG" ).append("\n"); 
		query.append("		 , PRC_TRF_CRE_TP_CD" ).append("\n"); 
		query.append("         , LOCL_CURR_CD " ).append("\n"); 
		query.append("         , USA_COST_TRF_SVC_MOD_CD" ).append("\n"); 
		query.append("         , @[cre_usr_id]" ).append("\n"); 
		query.append("         , SYSDATE" ).append("\n"); 
		query.append("         , @[upd_usr_id]" ).append("\n"); 
		query.append("         , SYSDATE         " ).append("\n"); 
		query.append("      FROM PRI_TRF_IHC_RT  " ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND SVC_SCP_CD       = @[ori_svc_scp_cd] " ).append("\n"); 
		query.append("       AND ORG_DEST_TP_CD   = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("       AND IHC_TRF_NO       = @[ori_ihc_trf_no]" ).append("\n"); 
		query.append("       AND AMDT_SEQ         = @[ori_amdt_seq]" ).append("\n"); 
		query.append("       AND IHC_CGO_TP_CD    = 'RF'" ).append("\n"); 
		query.append("       AND SRC_INFO_CD <> 'AD'" ).append("\n"); 

	}
}