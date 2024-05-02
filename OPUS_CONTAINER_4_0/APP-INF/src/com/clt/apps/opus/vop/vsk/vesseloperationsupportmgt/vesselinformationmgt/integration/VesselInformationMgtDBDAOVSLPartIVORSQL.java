/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VesselInformationMgtDBDAOVSLPartIVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.07
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselInformationMgtDBDAOVSLPartIVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public VesselInformationMgtDBDAOVSLPartIVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.integration").append("\n"); 
		query.append("FileName : VesselInformationMgtDBDAOVSLPartIVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	MVC.CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append(",	MVC.RF_RCPT_KNT" ).append("\n"); 
		query.append(",	MVC.RF_RCPT_MAX_KNT" ).append("\n"); 
		query.append(",	MVC.FBD_CAPA" ).append("\n"); 
		query.append(",	MVC.DPL_CAPA" ).append("\n"); 
		query.append(",	MVC.BLST_TNK_CAPA" ).append("\n"); 
		query.append(",	MVC.FOIL_CSM" ).append("\n"); 
		query.append(",	MVC.DOIL_CSM" ).append("\n"); 
		query.append(",	MVC.FRSH_WTR_CSM" ).append("\n"); 
		query.append(",	MVC.MN_ENG_RPM_PWR" ).append("\n"); 
		query.append(",	MVC.GNR_RPM_PWR" ).append("\n"); 
		query.append(",	MVC.VSL_HGT" ).append("\n"); 
		query.append(",	TO_CHAR(MVC.RGST_DT,'ddMonyy', 'NLS_DATE_LANGUAGE=American') RGST_DT" ).append("\n"); 
		query.append(",	MVC.VSL_EDI_NM" ).append("\n"); 
		query.append(",	MVC.CO_CD" ).append("\n"); 
		query.append(",	MVC.VSL_CLZ_DT" ).append("\n"); 
		query.append(",	MVC.VSL_CRE_OFC_CD" ).append("\n"); 
		query.append(",	MVC.VSL_DELT_OFC_CD" ).append("\n"); 
		query.append(",	MVC.VSL_BLD_AREA_NM" ).append("\n"); 
		query.append(",	MVC.GNR_MKR_NM" ).append("\n"); 
		query.append(",	MVC.GNR_TP_DESC" ).append("\n"); 
		query.append(",	MVC.GNR_BHP_PWR" ).append("\n"); 
		query.append(",	MVC.BWTHST_MKR_NM" ).append("\n"); 
		query.append(",	MVC.BWTHST_TP_DESC" ).append("\n"); 
		query.append(",	MVC.BWTHST_BHP_PWR" ).append("\n"); 
		query.append(",	MVC.BWTHST_RPM_PWR" ).append("\n"); 
		query.append(",	MVC.LLOYD_NO" ).append("\n"); 
		query.append(",	TO_CHAR(MVC.VSL_LNCH_DT,'ddMonyy', 'NLS_DATE_LANGUAGE=American') VSL_LNCH_DT" ).append("\n"); 
		query.append(",	TO_CHAR(MVC.VSL_DE_DT,'ddMonyy', 'NLS_DATE_LANGUAGE=American') VSL_DE_DT" ).append("\n"); 
		query.append(",	TO_CHAR(MVC.VSL_KEL_LY_DT,'ddMonyy', 'NLS_DATE_LANGUAGE=American') VSL_KEL_LY_DT" ).append("\n"); 
		query.append(",	MVC.VSL_HL_NO" ).append("\n"); 
		query.append(",	MVC.TTL_TEU_KNT" ).append("\n"); 
		query.append(",	MVC.VSL_HTCH_KNT" ).append("\n"); 
		query.append(",	MVC.VSL_HLD_KNT" ).append("\n"); 
		query.append(",	MVC.VSL_RMK" ).append("\n"); 
		query.append(",	MVC.INTL_TONG_CERTI_FLG" ).append("\n"); 
		query.append(",	MVC.VSL_SFT_CSTRU_CERTI_EXP_DT" ).append("\n"); 
		query.append(",	MVC.VSL_SFT_RDO_CERTI_EXP_DT" ).append("\n"); 
		query.append(",	MVC.VSL_SFT_EQ_CERTI_EXP_DT" ).append("\n"); 
		query.append(",	MVC.VSL_LOD_LINE_CERTI_EXP_DT" ).append("\n"); 
		query.append(",	MVC.VSL_DERAT_CERTI_EXP_DT" ).append("\n"); 
		query.append(",	MVC.CRE_USR_ID" ).append("\n"); 
		query.append(",	MVC.CRE_DT" ).append("\n"); 
		query.append(",	MVC.UPD_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(MVC.UPD_DT,'yyyy-mm-dd hh24:mi') UPD_DT" ).append("\n"); 
		query.append(",	MVC.DELT_FLG" ).append("\n"); 
		query.append(",	MVC.EAI_EVNT_DT" ).append("\n"); 
		query.append(",	MVC.VSL_CD" ).append("\n"); 
		query.append(",	'' VSL_CLSS_CD" ).append("\n"); 
		query.append(",	MVC.VSL_ENG_NM" ).append("\n"); 
		query.append(",	MVC.FOIL_CAPA" ).append("\n"); 
		query.append(",	MVC.DOIL_CAPA" ).append("\n"); 
		query.append(",	MVC.FRSH_WTR_CAPA" ).append("\n"); 
		query.append(",	MVC.CALL_SGN_NO" ).append("\n"); 
		query.append(",	MVC.RGST_NO" ).append("\n"); 
		query.append(",	MVC.PHN_NO" ).append("\n"); 
		query.append(",	MVC.FAX_NO" ).append("\n"); 
		query.append(",	MVC.TLX_NO" ).append("\n"); 
		query.append(",	MVC.VSL_EML" ).append("\n"); 
		query.append(",	MVC.PICLB_DESC" ).append("\n"); 
		query.append(",	ML.LOC_NM||', '||MC2.CNT_NM RGST_PORT_CD" ).append("\n"); 
		query.append(",	MVC.CLSS_NO_RGST_AREA_NM" ).append("\n"); 
		query.append(",	MVC.VSL_CLSS_NO" ).append("\n"); 
		query.append(",	MVC.VSL_BLDR_NM" ).append("\n"); 
		query.append(",	MVC.LOA_LEN" ).append("\n"); 
		query.append(",	MVC.LBP_LEN" ).append("\n"); 
		query.append(",	MVC.VSL_WDT" ).append("\n"); 
		query.append(",	MVC.VSL_DPTH" ).append("\n"); 
		query.append(",	MVC.SMR_DRFT_HGT" ).append("\n"); 
		query.append(",	MVC.DWT_WGT" ).append("\n"); 
		query.append(",	MVC.LGT_SHP_TONG_WGT" ).append("\n"); 
		query.append(",	MVC.GRS_RGST_TONG_WGT" ).append("\n"); 
		query.append(",	MVC.NET_RGST_TONG_WGT" ).append("\n"); 
		query.append(",	MVC.PNM_GT_WGT" ).append("\n"); 
		query.append(",	MVC.PNM_NET_TONG_WGT" ).append("\n"); 
		query.append(",	MVC.SUZ_GT_WGT" ).append("\n"); 
		query.append(",	MVC.SUZ_NET_TONG_WGT" ).append("\n"); 
		query.append(",	MVC.MN_ENG_MKR_NM" ).append("\n"); 
		query.append(",	MVC.MN_ENG_TP_DESC" ).append("\n"); 
		query.append(",	MVC.MN_ENG_BHP_PWR" ).append("\n"); 
		query.append(",	DECODE(MVC.VSL_OWN_IND_CD,'O','OWNER','C','CHARTER') AS VSL_OWN_IND_CD" ).append("\n"); 
		query.append(",	MVC.VSL_RGST_CNT_CD" ).append("\n"); 
		query.append(",	DECODE(MVC.VSL_BLD_CD,'N','NEW','U','USED') AS VSL_BLD_CD" ).append("\n"); 
		query.append(",	MVC.CRR_CD" ).append("\n"); 
		query.append(",	MVC.FDR_DIV_CD" ).append("\n"); 
		query.append(",	MVC.VSL_SVC_SPD" ).append("\n"); 
		query.append(",	MVC.MAX_SPD" ).append("\n"); 
		query.append(",	MVC.ECN_SPD" ).append("\n"); 
		query.append(",	MVC.CRW_KNT" ).append("\n"); 
		query.append(",	MVC.CNTR_DZN_CAPA" ).append("\n"); 
		query.append(",	MVC.CNTR_OP_CAPA" ).append("\n"); 
		query.append(",	MVC.CNTR_PNM_CAPA" ).append("\n"); 
		query.append(",	VC.CRR_NM AS CRR_FULL_NM" ).append("\n"); 
		query.append(",	MC1.CNT_CD||'-'||MC1.CNT_NM AS CNT_NM" ).append("\n"); 
		query.append(",   'CNTR' AS VSL_TYPE" ).append("\n"); 
		query.append("FROM   MDM_VSL_CNTR MVC" ).append("\n"); 
		query.append(",      MDM_CARRIER  VC" ).append("\n"); 
		query.append(",      MDM_COUNTRY  MC1" ).append("\n"); 
		query.append(",      MDM_COUNTRY  MC2" ).append("\n"); 
		query.append(",      MDM_LOCATION ML" ).append("\n"); 
		query.append("WHERE MVC.CRR_CD = VC.CRR_CD(+)" ).append("\n"); 
		query.append("AND   MVC.VSL_RGST_CNT_CD = MC1.CNT_CD(+)" ).append("\n"); 
		query.append("AND   SUBSTR(MVC.RGST_PORT_CD,1,2) = MC2.CNT_CD(+)" ).append("\n"); 
		query.append("AND   MVC.RGST_PORT_CD = ML.LOC_CD(+)" ).append("\n"); 
		query.append("AND   MVC.VSL_CD = @[vsl_cd]" ).append("\n"); 

	}
}