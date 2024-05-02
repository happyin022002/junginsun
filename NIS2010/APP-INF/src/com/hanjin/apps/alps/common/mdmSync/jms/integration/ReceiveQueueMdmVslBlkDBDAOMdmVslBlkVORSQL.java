/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceiveQueueMdmVslBlkDBDAOMdmVslBlkVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.27
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2010.01.27 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueMdmVslBlkDBDAOMdmVslBlkVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MdmVslBlkVO
	  * </pre>
	  */
	public ReceiveQueueMdmVslBlkDBDAOMdmVslBlkVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.mdmSync.jms.integration").append("\n"); 
		query.append("FileName : ReceiveQueueMdmVslBlkDBDAOMdmVslBlkVORSQL").append("\n"); 
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
		query.append("	'' VSL_CD" ).append("\n"); 
		query.append(",	'' VSL_CLSS_FLG" ).append("\n"); 
		query.append(",	'' VSL_ENG_NM" ).append("\n"); 
		query.append(",	'' VSL_KRN_NM" ).append("\n"); 
		query.append(",	'' FOIL_CAPA" ).append("\n"); 
		query.append(",	'' DOIL_CAPA" ).append("\n"); 
		query.append(",	'' FRSH_WTR_CAPA" ).append("\n"); 
		query.append(",	'' GRN_TONG_CAPA" ).append("\n"); 
		query.append(",	'' BAIL_TONG_CAPA" ).append("\n"); 
		query.append(",	'' TNK_TONG_CAPA" ).append("\n"); 
		query.append(",	'' CALL_SGN_NO" ).append("\n"); 
		query.append(",	'' RGST_PORT_CD" ).append("\n"); 
		query.append(",	'' VSL_BLDR_NM" ).append("\n"); 
		query.append(",	'' LOA_LEN" ).append("\n"); 
		query.append(",	'' SMR_DRFT_HGT" ).append("\n"); 
		query.append(",	'' LGT_SHP_TONG_WGT" ).append("\n"); 
		query.append(",	'' GRS_RGST_TONG_WGT" ).append("\n"); 
		query.append(",	'' NET_RGST_TONG_WGT" ).append("\n"); 
		query.append(",	'' PNM_GT_WGT" ).append("\n"); 
		query.append(",	'' PNM_NET_TONG_WGT" ).append("\n"); 
		query.append(",	'' SUZ_GT_WGT" ).append("\n"); 
		query.append(",	'' SUZ_NET_TONG_WGT" ).append("\n"); 
		query.append(",	'' MN_ENG_MKR_NM" ).append("\n"); 
		query.append(",	'' BLK_MN_ENG_TP_CD" ).append("\n"); 
		query.append(",	'' MN_ENG_BHP_PWR" ).append("\n"); 
		query.append(",	'' VSL_OWN_IND_CD" ).append("\n"); 
		query.append(",	'' VSL_RGST_CNT_CD" ).append("\n"); 
		query.append(",	'' VSL_BLD_DT" ).append("\n"); 
		query.append(",	'' LOA_UT_CD" ).append("\n"); 
		query.append(",	'' VSL_BM_WDT" ).append("\n"); 
		query.append(",	'' VSL_BM_UT_CD" ).append("\n"); 
		query.append(",	'' VSL_OWN_CUST_CNT_CD" ).append("\n"); 
		query.append(",	'' VSL_OWN_CUST_SEQ" ).append("\n"); 
		query.append(",	'' VSL_CGO_GR_NM" ).append("\n"); 
		query.append(",	'' VSL_CAPA_UT_CD" ).append("\n"); 
		query.append(",	'' VSL_DWT_UT_CD" ).append("\n"); 
		query.append(",	'' BLK_CRR_TP_CD" ).append("\n"); 
		query.append(",	'' VSL_DRFT_UT_CD" ).append("\n"); 
		query.append(",	'' SMR_TPC_TON_WGT" ).append("\n"); 
		query.append(",	'' WNT_TPC_TON_WGT" ).append("\n"); 
		query.append(",	'' TROP_TPC_TON_WGT" ).append("\n"); 
		query.append(",	'' BLST_WGT_SPD1" ).append("\n"); 
		query.append(",	'' LDN_WGT_SPD1" ).append("\n"); 
		query.append(",	'' BLST_WGT_SPD2" ).append("\n"); 
		query.append(",	'' LDN_WGT_SPD2" ).append("\n"); 
		query.append(",	'' FOIL_BLST_CSM1" ).append("\n"); 
		query.append(",	'' FOIL_LDN_CSM1" ).append("\n"); 
		query.append(",	'' FOIL_BLST_CSM2" ).append("\n"); 
		query.append(",	'' FOIL_LDN_CSM2" ).append("\n"); 
		query.append(",	'' PORT_FOIL_TON_CSM" ).append("\n"); 
		query.append(",	'' SEA_DOIL_TON_CSM" ).append("\n"); 
		query.append(",	'' PORT_IDLE_DOIL_TON_CSM" ).append("\n"); 
		query.append(",	'' PORT_WRK_DOIL_TON_CSM" ).append("\n"); 
		query.append(",	'' VSL_BUNK_UT_CD" ).append("\n"); 
		query.append(",	'' CONS_TON_WGT" ).append("\n"); 
		query.append(",	'' ENT_TP_CD" ).append("\n"); 
		query.append(",	'' WNT_DRFT_HGT" ).append("\n"); 
		query.append(",	'' TROP_DRFT_HGT" ).append("\n"); 
		query.append(",	'' SMR_DWT_WGT" ).append("\n"); 
		query.append(",	'' WNT_DWT_WGT" ).append("\n"); 
		query.append(",	'' TROP_DWT_WGT" ).append("\n"); 
		query.append(",	'' VSL_HTCH_KNT" ).append("\n"); 
		query.append(",	'' VSL_HLD_KNT" ).append("\n"); 
		query.append(",	'' BLK_VSL_CLSS_CD" ).append("\n"); 
		query.append(",	'' HT_FOIL_CSM" ).append("\n"); 
		query.append(",	'' PMP_OIL_KND_CD" ).append("\n"); 
		query.append(",	'' PMP_OIL_CSM" ).append("\n"); 
		query.append(",	'' CLN_OIL_KND_CD" ).append("\n"); 
		query.append(",	'' CLN_OIL_CSM" ).append("\n"); 
		query.append(",	'' LNCH_DT" ).append("\n"); 
		query.append(",	'' RGST_DT" ).append("\n"); 
		query.append(",	'' IMO_NO" ).append("\n"); 
		query.append(",	'' VSL_RMK" ).append("\n"); 
		query.append(",	'' CRE_USR_ID" ).append("\n"); 
		query.append(",	'' CRE_DT" ).append("\n"); 
		query.append(",	'' UPD_USR_ID" ).append("\n"); 
		query.append(",	'' UPD_DT" ).append("\n"); 
		query.append(",	'' DELT_FLG" ).append("\n"); 
		query.append(",	'' EAI_EVNT_DT" ).append("\n"); 
		query.append(",	'' VSL_OWN_CUST_NM" ).append("\n"); 
		query.append(",	'' BLK_VSL_DE_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}