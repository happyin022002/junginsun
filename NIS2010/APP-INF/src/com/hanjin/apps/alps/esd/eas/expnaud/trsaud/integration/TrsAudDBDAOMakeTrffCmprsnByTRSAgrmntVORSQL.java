/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TrsAudDBDAOMakeTrffCmprsnByTRSAgrmntVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.27
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.04.27 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.trsaud.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsAudDBDAOMakeTrffCmprsnByTRSAgrmntVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO for Tariff Comparison by TRS Agreement
	  * </pre>
	  */
	public TrsAudDBDAOMakeTrffCmprsnByTRSAgrmntVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.expnaud.trsaud.integration").append("\n"); 
		query.append("FileName : TrsAudDBDAOMakeTrffCmprsnByTRSAgrmntVORSQL").append("\n"); 
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
		query.append("SELECT	" ).append("\n"); 
		query.append("		 ''	S_RHQ_OFC_CD" ).append("\n"); 
		query.append("		,''	S_WO_OFC_CD" ).append("\n"); 
		query.append("		,''	S_FM_YRMON" ).append("\n"); 
		query.append("		,''	S_TO_YRMON" ).append("\n"); 
		query.append("		,''	S_SO_TP_CD" ).append("\n"); 
		query.append("		,''	S_TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("		,''	S_TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("		,''	S_TRSP_BND_CD" ).append("\n"); 
		query.append("		,''	S_FM_NOD_CD" ).append("\n"); 
		query.append("		,''	S_VIA_NOD_CD" ).append("\n"); 
		query.append("		,''	S_TO_NOD_CD" ).append("\n"); 
		query.append("		,''	S_DOR_NOD_CD" ).append("\n"); 
		query.append("		,''	WO_RHQ_CD" ).append("\n"); 
		query.append("		,''	WO_OFC_CD" ).append("\n"); 
		query.append("		,''	INLND_COST_YRMON" ).append("\n"); 
		query.append("		,''	TRSP_SO_TP_CD" ).append("\n"); 
		query.append("		,''	TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("		,'' TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("		,''	TRSP_BND_CD" ).append("\n"); 
		query.append("		,''	FM_NOD_CD" ).append("\n"); 
		query.append("		,''	VIA_NOD_CD" ).append("\n"); 
		query.append("		,''	TO_NOD_CD" ).append("\n"); 
		query.append("		,''	DOR_NOD_CD" ).append("\n"); 
		query.append("		,''	VNDR_SEQ" ).append("\n"); 
		query.append("		,''	VNDR_NM" ).append("\n"); 
		query.append("		,''	AGMT_CURR_CD" ).append("\n"); 
		query.append("		,''	AGMT_20FT_DRY_AMT" ).append("\n"); 
		query.append("		,''	AGMT_40FT_DRY_AMT" ).append("\n"); 
		query.append("		,''	AGMT_20FT_RF_AMT" ).append("\n"); 
		query.append("		,''	AGMT_40FT_RF_AMT" ).append("\n"); 
		query.append("		,''	AGMT_20FT_DRY_USD_AMT" ).append("\n"); 
		query.append("		,''	AGMT_40FT_DRY_USD_AMT" ).append("\n"); 
		query.append("		,''	AGMT_20FT_RF_USD_AMT" ).append("\n"); 
		query.append("		,''	AGMT_40FT_RF_USD_AMT" ).append("\n"); 
		query.append("		,''	TRSP_AVG_20FT_DRY_USD_AMT" ).append("\n"); 
		query.append("		,''	TRSP_AVG_40FT_DRY_USD_AMT" ).append("\n"); 
		query.append("		,''	TRSP_AVG_20FT_RF_USD_AMT" ).append("\n"); 
		query.append("		,''	TRSP_AVG_40FT_RF_USD_AMT" ).append("\n"); 
		query.append("		,''	SO_20FT_VOL_KNT" ).append("\n"); 
		query.append("		,''	SO_40FT_VOL_KNT" ).append("\n"); 
		query.append("		,''	SO_TEU_QTY" ).append("\n"); 
		query.append("		,''	SO_BX_QTY" ).append("\n"); 
		query.append("     	,'' WO_CURR_CD" ).append("\n"); 
		query.append("     	,'' WO_20FT_DRY_AVG_AMT" ).append("\n"); 
		query.append("     	,'' WO_40FT_DRY_AVG_AMT" ).append("\n"); 
		query.append("     	,'' WO_45FT_DRY_AVG_AMT" ).append("\n"); 
		query.append("     	,'' WO_20FT_RF_AVG_AMT" ).append("\n"); 
		query.append("     	,'' WO_40FT_RF_AVG_AMT" ).append("\n"); 
		query.append("     	,'' WO_20FT_DG_AVG_AMT" ).append("\n"); 
		query.append("     	,'' WO_40FT_DG_AVG_AMT" ).append("\n"); 
		query.append("     	,'' WO_20FT_AWK_AVG_AMT" ).append("\n"); 
		query.append("     	,'' WO_40FT_AWK_AVG_AMT" ).append("\n"); 
		query.append("FROM 	DUAL" ).append("\n"); 

	}
}