/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CndExpCustomsTransmissionDBDAOsearchMdmVslCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndExpCustomsTransmissionDBDAOsearchMdmVslCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public CndExpCustomsTransmissionDBDAOsearchMdmVslCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndExpCustomsTransmissionDBDAOsearchMdmVslCntrRSQL").append("\n"); 
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
		query.append("	RF_RCPT_KNT" ).append("\n"); 
		query.append(",	RF_RCPT_MAX_KNT" ).append("\n"); 
		query.append(",	FBD_CAPA" ).append("\n"); 
		query.append(",	DPL_CAPA" ).append("\n"); 
		query.append(",	BLST_TNK_CAPA" ).append("\n"); 
		query.append(",	FOIL_CSM" ).append("\n"); 
		query.append(",	DOIL_CSM" ).append("\n"); 
		query.append(",	FRSH_WTR_CSM" ).append("\n"); 
		query.append(",	MN_ENG_RPM_PWR" ).append("\n"); 
		query.append(",	GNR_RPM_PWR" ).append("\n"); 
		query.append(",	VSL_HGT" ).append("\n"); 
		query.append(",	RGST_DT" ).append("\n"); 
		query.append(",	VSL_EDI_NM" ).append("\n"); 
		query.append(",	CO_CD" ).append("\n"); 
		query.append(",	VSL_CLZ_DT" ).append("\n"); 
		query.append(",	VSL_CRE_OFC_CD" ).append("\n"); 
		query.append(",	VSL_DELT_OFC_CD" ).append("\n"); 
		query.append(",	VSL_BLD_AREA_NM" ).append("\n"); 
		query.append(",	GNR_MKR_NM" ).append("\n"); 
		query.append(",	GNR_TP_DESC" ).append("\n"); 
		query.append(",	GNR_BHP_PWR" ).append("\n"); 
		query.append(",	BWTHST_MKR_NM" ).append("\n"); 
		query.append(",	BWTHST_TP_DESC" ).append("\n"); 
		query.append(",	BWTHST_BHP_PWR" ).append("\n"); 
		query.append(",	BWTHST_RPM_PWR" ).append("\n"); 
		query.append(",	LLOYD_NO" ).append("\n"); 
		query.append(",	VSL_LNCH_DT" ).append("\n"); 
		query.append(",	VSL_DE_DT" ).append("\n"); 
		query.append(",	VSL_KEL_LY_DT" ).append("\n"); 
		query.append(",	VSL_HL_NO" ).append("\n"); 
		query.append(",	TTL_TEU_KNT" ).append("\n"); 
		query.append(",	VSL_HTCH_KNT" ).append("\n"); 
		query.append(",	VSL_HLD_KNT" ).append("\n"); 
		query.append(",	VSL_RMK" ).append("\n"); 
		query.append(",	INTL_TONG_CERTI_FLG" ).append("\n"); 
		query.append(",	VSL_SFT_CSTRU_CERTI_EXP_DT" ).append("\n"); 
		query.append(",	VSL_SFT_RDO_CERTI_EXP_DT" ).append("\n"); 
		query.append(",	VSL_SFT_EQ_CERTI_EXP_DT" ).append("\n"); 
		query.append(",	VSL_LOD_LINE_CERTI_EXP_DT" ).append("\n"); 
		query.append(",	VSL_DERAT_CERTI_EXP_DT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	DELT_FLG" ).append("\n"); 
		query.append(",	EAI_EVNT_DT" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	VSL_ENG_NM" ).append("\n"); 
		query.append("--,	VSL_KRN_NM" ).append("\n"); 
		query.append(",	FOIL_CAPA" ).append("\n"); 
		query.append(",	DOIL_CAPA" ).append("\n"); 
		query.append(",	FRSH_WTR_CAPA" ).append("\n"); 
		query.append(",	CALL_SGN_NO" ).append("\n"); 
		query.append(",	RGST_NO" ).append("\n"); 
		query.append(",	PHN_NO" ).append("\n"); 
		query.append(",	FAX_NO" ).append("\n"); 
		query.append(",	TLX_NO" ).append("\n"); 
		query.append(",	VSL_EML" ).append("\n"); 
		query.append(",	PICLB_DESC" ).append("\n"); 
		query.append(",	RGST_PORT_CD" ).append("\n"); 
		query.append(",	CLSS_NO_RGST_AREA_NM" ).append("\n"); 
		query.append(",	VSL_CLSS_NO" ).append("\n"); 
		query.append(",	VSL_BLDR_NM" ).append("\n"); 
		query.append(",	LOA_LEN" ).append("\n"); 
		query.append(",	LBP_LEN" ).append("\n"); 
		query.append(",	VSL_WDT" ).append("\n"); 
		query.append(",	VSL_DPTH" ).append("\n"); 
		query.append(",	SMR_DRFT_HGT" ).append("\n"); 
		query.append(",	DWT_WGT" ).append("\n"); 
		query.append(",	LGT_SHP_TONG_WGT" ).append("\n"); 
		query.append(",	GRS_RGST_TONG_WGT" ).append("\n"); 
		query.append(",	NET_RGST_TONG_WGT" ).append("\n"); 
		query.append(",	PNM_GT_WGT" ).append("\n"); 
		query.append(",	PNM_NET_TONG_WGT" ).append("\n"); 
		query.append(",	SUZ_GT_WGT" ).append("\n"); 
		query.append(",	SUZ_NET_TONG_WGT" ).append("\n"); 
		query.append(",	MN_ENG_MKR_NM" ).append("\n"); 
		query.append(",	MN_ENG_TP_DESC" ).append("\n"); 
		query.append(",	MN_ENG_BHP_PWR" ).append("\n"); 
		query.append(",	VSL_OWN_IND_CD" ).append("\n"); 
		query.append(",	VSL_RGST_CNT_CD" ).append("\n"); 
		query.append(",	VSL_BLD_CD" ).append("\n"); 
		query.append(",	CRR_CD" ).append("\n"); 
		query.append(",	FDR_DIV_CD" ).append("\n"); 
		query.append(",	VSL_SVC_SPD" ).append("\n"); 
		query.append(",	MAX_SPD" ).append("\n"); 
		query.append(",	ECN_SPD" ).append("\n"); 
		query.append(",	CRW_KNT" ).append("\n"); 
		query.append(",	CNTR_DZN_CAPA" ).append("\n"); 
		query.append(",	CNTR_OP_CAPA" ).append("\n"); 
		query.append(",	CNTR_PNM_CAPA" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE	VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 

	}
}