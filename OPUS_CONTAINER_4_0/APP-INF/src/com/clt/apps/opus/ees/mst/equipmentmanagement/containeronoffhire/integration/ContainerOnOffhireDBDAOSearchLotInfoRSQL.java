/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOSearchLotInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.25
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.04.25 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOSearchLotInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchLotInfo
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOSearchLotInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lot_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lot_pln_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lot_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOSearchLotInfoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("     MST_COMMON_PKG.MST_AGMT_NO_CONV_FNC(LOT.AGMT_CTY_CD, LOT.AGMT_SEQ) AS AGMT_NO" ).append("\n"); 
		query.append("    ,LOT.AGMT_CTY_CD    AS AGMT_CTY_CD" ).append("\n"); 
		query.append("    ,LOT.AGMT_SEQ       AS AGMT_SEQ" ).append("\n"); 
		query.append("    ,AGR.LSTM_CD        AS LSTM_CD" ).append("\n"); 
		query.append("    ,TO_CHAR(AGR.LST_EFF_DT,'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(AGR.LST_EXP_DT,'YYYY-MM-DD') AS EXP_DT " ).append("\n"); 
		query.append("    ,AGR.VNDR_SEQ               AS VNDR_SEQ " ).append("\n"); 
		query.append("    ,VEN.VNDR_LGL_ENG_NM        AS VNDR_LGL_ENG_NM " ).append("\n"); 
		query.append("    ,LOT.CNTR_SPEC_NO           AS CNTR_SPEC_NO" ).append("\n"); 
		query.append("    ,LOT.CNTR_TPSZ_CD           AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    ,LOT.MFT_VNDR_SEQ	        AS MFT_VNDR_SEQ" ).append("\n"); 
		query.append("    ,VEN2.VNDR_ABBR_NM          AS VNDR_ABBR_NM" ).append("\n"); 
		query.append("    ,LOT.FCTRY_SPEC_NO" ).append("\n"); 
		query.append("    ,LOT.LOT_LOC_CD" ).append("\n"); 
		query.append("    ,TO_CHAR(LOT.MFT_DT,'YYYY-MM-DD') AS MFT_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(LOT.DE_DT ,'YYYY-MM-DD') AS DE_DT" ).append("\n"); 
		query.append("    ,LOT.FM_SER_NO" ).append("\n"); 
		query.append("    ,LOT.TO_SER_NO" ).append("\n"); 
		query.append("    ,DECODE(LENGTH(LOT.DE_YRMON),6,SUBSTR(LOT.DE_YRMON,0,4) || '-' || SUBSTR(LOT.DE_YRMON,5,8),'') AS DE_YRMON" ).append("\n"); 
		query.append("    ,LOT.PLST_FLR_FLG" ).append("\n"); 
		query.append("    ,LOT.CNTR_HNGR_RCK_CD" ).append("\n"); 
		query.append("    ,LOT.FA_IF_GRP_STS_CD" ).append("\n"); 
		query.append("    ,LOT.CERTI_NO" ).append("\n"); 
		query.append("    ,LOT.APRO_CSC_NO" ).append("\n"); 
		query.append("    ,LOT.APRO_TIR_NO" ).append("\n"); 
		query.append("    ,LOT.APRO_UIC_NO" ).append("\n"); 
		query.append("    ,LOT.APRO_TCT_NO" ).append("\n"); 
		query.append("    ,SPEC.CNTR_MTRL_CD" ).append("\n"); 
		query.append("    ,MST_COMMON_PKG.MST_VNDR_SEQ_CONV_FNC(LOT.MFT_VNDR_SEQ) AS MFT_VNDR_SEQ" ).append("\n"); 
		query.append("    ,LOT.LOT_CNTR_PFX_CD" ).append("\n"); 
		query.append("    ,TO_NUMBER(LOT.TO_SER_NO) - TO_NUMBER(LOT.FM_SER_NO) + 1 AS RANGE_COUNT" ).append("\n"); 
		query.append("    ,LOT.DIFF_RMK" ).append("\n"); 
		query.append("    ,LOT.AGMT_CTY_CD || LOT.AGMT_SEQ  AS ORG_AGMT_NO" ).append("\n"); 
		query.append("    ,TO_CHAR(LOT.MFT_DT,'YYYY-MM-DD')  AS ORG_MFT_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(LOT.DE_DT ,'YYYY-MM-DD')  AS ORG_DE_DT" ).append("\n"); 
		query.append("    ,LOT.CNTR_HNGR_RCK_CD AS ORG_CNTR_HNGR_RCK_CD" ).append("\n"); 
		query.append("    ,LOT.PLST_FLR_FLG 	AS ORG_PLST_FLR_FLG" ).append("\n"); 
		query.append("    ,LOT.FCTRY_SPEC_NO 	AS ORG_FCTRY_SPEC_NO" ).append("\n"); 
		query.append("    ,DECODE(LENGTH(LOT.DE_YRMON),6,SUBSTR(LOT.DE_YRMON,0,4) || '-' || SUBSTR(LOT.DE_YRMON,5,8),'') AS ORG_DE_YRMON" ).append("\n"); 
		query.append("    ,LOT.CERTI_NO    AS ORG_CERTI_NO" ).append("\n"); 
		query.append("	,LOT.RF_TP_CD    AS UNIT_TYPE" ).append("\n"); 
		query.append("    ,LOT.RF_MKR_SEQ" ).append("\n"); 
		query.append("    ,LOT.RF_MDL_NM" ).append("\n"); 
		query.append("    ,LOT.RF_RFR_NO" ).append("\n"); 
		query.append("    ,LOT.MIN_TEMP" ).append("\n"); 
		query.append("    ,LOT.MAX_TEMP" ).append("\n"); 
		query.append("    ,LOT.RF_MKR_SEQ  AS ORG_RF_MKR_SEQ" ).append("\n"); 
		query.append("    ,LOT.RF_MDL_NM   AS ORG_RF_MDL_NM" ).append("\n"); 
		query.append("    ,LOT.RF_RFR_NO   AS ORG_RF_RFR_NO" ).append("\n"); 
		query.append("    ,LOT.MIN_TEMP    AS ORG_MIN_TEMP" ).append("\n"); 
		query.append("    ,LOT.MAX_TEMP    AS ORG_MAX_TEMP" ).append("\n"); 
		query.append("	,LOT.RF_HUMID_CTRL_VAL_CD    AS RF_HUMID_CTRL_VAL_CD" ).append("\n"); 
		query.append("	,LOT.RF_CMPR_CTNT    		 AS	RF_CMPR_CTNT " ).append("\n"); 
		query.append("	,LOT.MFT_YD_CD				 AS MFT_YD_CD" ).append("\n"); 
		query.append("    ,TO_CHAR(LOT.DE_DT ,'HH24:MI')  AS P_TIME" ).append("\n"); 
		query.append("FROM    MST_CNTR_LOT LOT," ).append("\n"); 
		query.append("        LSE_AGREEMENT AGR," ).append("\n"); 
		query.append("        MDM_VENDOR VEN," ).append("\n"); 
		query.append("        MDM_VENDOR VEN2," ).append("\n"); 
		query.append("        MST_CNTR_SPEC SPEC" ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("AND LOT.LOT_PLN_YR      = @[lot_pln_yr]" ).append("\n"); 
		query.append("AND LOT.LOT_LOC_CD      = @[lot_loc_cd]" ).append("\n"); 
		query.append("AND LOT.CNTR_TPSZ_CD    = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("AND LOT.LOT_SEQ         = @[lot_seq]" ).append("\n"); 
		query.append("AND LOT.AGMT_CTY_CD     = AGR.AGMT_CTY_CD(+)" ).append("\n"); 
		query.append("AND LOT.AGMT_SEQ        = AGR.AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND AGR.VNDR_SEQ        = VEN.VNDR_SEQ" ).append("\n"); 
		query.append("AND LOT.MFT_VNDR_SEQ    = VEN2.VNDR_SEQ" ).append("\n"); 
		query.append("AND LOT.CNTR_SPEC_NO    = SPEC.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("AND LOT.OWN_CNTR_FLG 	= 'Y'" ).append("\n"); 

	}
}