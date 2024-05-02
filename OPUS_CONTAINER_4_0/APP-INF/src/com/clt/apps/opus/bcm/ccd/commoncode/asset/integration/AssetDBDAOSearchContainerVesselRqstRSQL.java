/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AssetDBDAOSearchContainerVesselRqstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.asset.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AssetDBDAOSearchContainerVesselRqstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Request Container Vessel 정보를 조회한다.
	  * </pre>
	  */
	public AssetDBDAOSearchContainerVesselRqstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.asset.integration").append("\n"); 
		query.append("FileName : AssetDBDAOSearchContainerVesselRqstRSQL").append("\n"); 
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
		query.append("SELECT RQST_NO " ).append("\n"); 
		query.append("	  ,VSL_CD" ).append("\n"); 
		query.append("      ,VSL_CLSS_FLG" ).append("\n"); 
		query.append("      ,VSL_ENG_NM" ).append("\n"); 
		query.append("      ,VSL_LOCL_NM" ).append("\n"); 
		query.append("      ,FOIL_CAPA" ).append("\n"); 
		query.append("      ,DOIL_CAPA" ).append("\n"); 
		query.append("      ,FRSH_WTR_CAPA" ).append("\n"); 
		query.append("      ,CALL_SGN_NO" ).append("\n"); 
		query.append("      ,RGST_NO" ).append("\n"); 
		query.append("      ,PHN_NO" ).append("\n"); 
		query.append("      ,FAX_NO" ).append("\n"); 
		query.append("      ,TLX_NO" ).append("\n"); 
		query.append("      ,VSL_EML" ).append("\n"); 
		query.append("      ,PICLB_DESC" ).append("\n"); 
		query.append("      ,RGST_PORT_CD" ).append("\n"); 
		query.append("      ,CLSS_NO_RGST_AREA_NM" ).append("\n"); 
		query.append("      ,VSL_CLSS_NO" ).append("\n"); 
		query.append("      ,VSL_BLDR_NM" ).append("\n"); 
		query.append("      ,LOA_LEN" ).append("\n"); 
		query.append("      ,LBP_LEN" ).append("\n"); 
		query.append("      ,VSL_WDT" ).append("\n"); 
		query.append("      ,VSL_DPTH" ).append("\n"); 
		query.append("      ,SMR_DRFT_HGT" ).append("\n"); 
		query.append("      ,DWT_WGT" ).append("\n"); 
		query.append("      ,LGT_SHP_TONG_WGT" ).append("\n"); 
		query.append("      ,GRS_RGST_TONG_WGT" ).append("\n"); 
		query.append("      ,NET_RGST_TONG_WGT" ).append("\n"); 
		query.append("      ,PNM_GT_WGT" ).append("\n"); 
		query.append("      ,PNM_NET_TONG_WGT" ).append("\n"); 
		query.append("      ,SUZ_GT_WGT" ).append("\n"); 
		query.append("      ,SUZ_NET_TONG_WGT" ).append("\n"); 
		query.append("      ,MN_ENG_MKR_NM" ).append("\n"); 
		query.append("      ,MN_ENG_TP_DESC" ).append("\n"); 
		query.append("      ,MN_ENG_BHP_PWR" ).append("\n"); 
		query.append("      ,VSL_OWN_IND_CD" ).append("\n"); 
		query.append("      ,VSL_RGST_CNT_CD" ).append("\n"); 
		query.append("      ,VSL_BLD_CD" ).append("\n"); 
		query.append("      ,CRR_CD" ).append("\n"); 
		query.append("      ,FDR_DIV_CD" ).append("\n"); 
		query.append("      ,VSL_SVC_SPD" ).append("\n"); 
		query.append("      ,MAX_SPD" ).append("\n"); 
		query.append("      ,ECN_SPD" ).append("\n"); 
		query.append("      ,CRW_KNT" ).append("\n"); 
		query.append("      ,CNTR_DZN_CAPA" ).append("\n"); 
		query.append("      ,CNTR_OP_CAPA" ).append("\n"); 
		query.append("      ,CNTR_PNM_CAPA" ).append("\n"); 
		query.append("      ,CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("      ,RF_RCPT_KNT" ).append("\n"); 
		query.append("      ,RF_RCPT_MAX_KNT" ).append("\n"); 
		query.append("      ,FBD_CAPA" ).append("\n"); 
		query.append("      ,DPL_CAPA" ).append("\n"); 
		query.append("      ,BLST_TNK_CAPA" ).append("\n"); 
		query.append("      ,FOIL_CSM" ).append("\n"); 
		query.append("      ,DOIL_CSM" ).append("\n"); 
		query.append("      ,FRSH_WTR_CSM" ).append("\n"); 
		query.append("      ,MN_ENG_RPM_PWR" ).append("\n"); 
		query.append("      ,GNR_RPM_PWR" ).append("\n"); 
		query.append("      ,VSL_HGT" ).append("\n"); 
		query.append("      ,TO_CHAR(RGST_DT,'YYYY-MM-DD') AS RGST_DT" ).append("\n"); 
		query.append("      ,VSL_EDI_NM" ).append("\n"); 
		query.append("      ,CO_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(TO_DATE(VSL_CLZ_DT,'YYYYMMDD'),'YYYY-MM-DD') AS VSL_CLZ_DT" ).append("\n"); 
		query.append("      ,VSL_CRE_OFC_CD" ).append("\n"); 
		query.append("      ,VSL_DELT_OFC_CD" ).append("\n"); 
		query.append("      ,VSL_BLD_AREA_NM" ).append("\n"); 
		query.append("      ,GNR_MKR_NM" ).append("\n"); 
		query.append("      ,GNR_TP_DESC" ).append("\n"); 
		query.append("      ,GNR_BHP_PWR" ).append("\n"); 
		query.append("      ,BWTHST_MKR_NM" ).append("\n"); 
		query.append("      ,BWTHST_TP_DESC" ).append("\n"); 
		query.append("      ,BWTHST_BHP_PWR" ).append("\n"); 
		query.append("      ,BWTHST_RPM_PWR" ).append("\n"); 
		query.append("      ,LLOYD_NO" ).append("\n"); 
		query.append("      ,TO_CHAR(VSL_LNCH_DT,'YYYY-MM-DD') AS VSL_LNCH_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(VSL_DE_DT,'YYYY-MM-DD') AS VSL_DE_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(VSL_KEL_LY_DT,'YYYY-MM-DD') AS VSL_KEL_LY_DT" ).append("\n"); 
		query.append("      ,VSL_HL_NO" ).append("\n"); 
		query.append("      ,TTL_TEU_KNT" ).append("\n"); 
		query.append("      ,VSL_HTCH_KNT" ).append("\n"); 
		query.append("      ,VSL_HLD_KNT" ).append("\n"); 
		query.append("      ,VSL_RMK" ).append("\n"); 
		query.append("      ,INTL_TONG_CERTI_FLG" ).append("\n"); 
		query.append("      ,MADN_VOY_SUZ_NET_TONG_WGT" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("      ,DELT_FLG" ).append("\n"); 
		query.append("      ,MODI_VSL_CD" ).append("\n"); 
		query.append("      ,MODI_VSL_OPR_TP_CD" ).append("\n"); 
		query.append("FROM   MDM_VSL_CNTR_RQST" ).append("\n"); 
		query.append("WHERE  RQST_NO = @[rqst_no]" ).append("\n"); 

	}
}