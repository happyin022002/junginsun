/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RepairMgtDBDAOsearchExtraWOHeaderDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.21
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2011.09.21 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.core.layer.integration.DAO;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOsearchExtraWOHeaderDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchExtraWOHeaderDatan select
	  * </pre>
	  */
	public RepairMgtDBDAOsearchExtraWOHeaderDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_ord_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_ord_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_wo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_of_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOsearchExtraWOHeaderDataRSQL").append("\n"); 
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
		query.append("         A.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,A.MNR_ORD_SEQ" ).append("\n"); 
		query.append("        ,A.EQ_KND_CD" ).append("\n"); 
		query.append("        ,A.MNR_GRP_TP_CD" ).append("\n"); 
		query.append("        ,A.MNR_WO_TP_CD" ).append("\n"); 
		query.append("        ,A.COST_CD" ).append("\n"); 
		query.append("        ,A.TRSM_MOD_CD" ).append("\n"); 
		query.append("        ,A.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,A.AGMT_SEQ" ).append("\n"); 
		query.append("        ,A.AGMT_VER_NO" ).append("\n"); 
		query.append("        ,A.CURR_CD" ).append("\n"); 
		query.append("        ,A.MNR_AGMT_AMT" ).append("\n"); 
		query.append("        ,A.MNR_WRK_AMT" ).append("\n"); 
		query.append("        ,A.INV_AMT" ).append("\n"); 
		query.append("        ,A.ORD_ISS_OFC_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),A.MNR_ORD_SND_DT,@[cost_ofc_cd]), 'yyyy-mm-dd') MNR_ORD_SND_DT" ).append("\n"); 
		query.append("        ,A.COST_OFC_CD" ).append("\n"); 
		query.append("        ,A.VNDR_SEQ" ).append("\n"); 
		query.append("        ,A.SPR_PRT_SPL_TP_CD" ).append("\n"); 
		query.append("        ,A.VSL_CD" ).append("\n"); 
		query.append("        ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),A.SPR_PRT_BRTH_DT,@[cost_ofc_cd]), 'yyyy-mm-dd') SPR_PRT_BRTH_DT" ).append("\n"); 
		query.append("        ,A.SPR_PRT_SPL_YD_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),A.SPR_PRT_SPL_DT,@[cost_ofc_cd]), 'yyyy-mm-dd') SPR_PRT_SPL_DT" ).append("\n"); 
		query.append("        ,A.ORD_HDR_RMK" ).append("\n"); 
		query.append("		,A.FILE_SEQ" ).append("\n"); 
		query.append("        ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),A.MNR_INP_DT,@[cost_ofc_cd]), 'yyyy-mm-dd') MNR_INP_DT" ).append("\n"); 
		query.append("        ,A.CRE_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),A.CRE_DT,@[cost_ofc_cd]), 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append("		,MNR_COMMON_PKG.MNR_CONV_AGMT_NO_FNC(A.AGMT_OFC_CTY_CD, A.AGMT_SEQ) AS AGMT_NO" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("FROM MNR_ORD_HDR A" ).append("\n"); 
		query.append("WHERE A.MNR_ORD_OFC_CTY_CD = @[mnr_ord_ofc_cty_cd]" ).append("\n"); 
		query.append("AND   A.MNR_ORD_SEQ = @[mnr_ord_seq]" ).append("\n"); 
		query.append("AND   A.MNR_WO_TP_CD = @[mnr_wo_tp_cd]" ).append("\n"); 
		query.append("#if (${f_gubuns} != 'popup')" ).append("\n"); 
		query.append("AND   A.COST_OFC_CD = @[cost_of_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}