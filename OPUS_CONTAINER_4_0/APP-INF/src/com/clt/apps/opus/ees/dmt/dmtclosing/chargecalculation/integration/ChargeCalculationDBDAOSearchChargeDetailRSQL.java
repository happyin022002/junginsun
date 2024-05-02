/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchChargeDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOSearchChargeDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOSearchChargeDetailRSQL.Query
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchChargeDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_mvmt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchChargeDetailRSQL").append("\n"); 
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
		query.append("         SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append("		,@[bkg_no] AS BKG_NO" ).append("\n"); 
		query.append("        ,CNTR_NO" ).append("\n"); 
		query.append("        ,CNTR_CYC_NO" ).append("\n"); 
		query.append("        ,DMDT_TRF_CD" ).append("\n"); 
		query.append("        ,DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("        ,CHG_SEQ" ).append("\n"); 
		query.append("        ,TO_CHAR (C.FM_MVMT_DT, 'YYYYMMDDHH24MI') FM_MVMT_DT " ).append("\n"); 
		query.append("        ,FM_MVMT_STS_CD" ).append("\n"); 
		query.append("        ,FM_MVMT_YD_CD" ).append("\n"); 
		query.append("        ,TO_CHAR (C.TO_MVMT_DT, 'YYYYMMDD') TO_MVMT_DT " ).append("\n"); 
		query.append("        ,TO_MVMT_STS_CD" ).append("\n"); 
		query.append("        ,TO_MVMT_YD_CD" ).append("\n"); 
		query.append("        --,FX_FT_OVR_DYS" ).append("\n"); 
		query.append("        --,DMDT_CHG_STS_CD  ?? STS_CD, SCH_CHG_STS" ).append("\n"); 
		query.append("        --,DMDT_PRE_CHG_STS_CD ?? STS_CD, SCH_CHG_STS" ).append("\n"); 
		query.append("        ,DUL_TP_EXPT_FLG" ).append("\n"); 
		query.append("        ,OFC_CD" ).append("\n"); 
		query.append("        ,OFC_RHQ_CD" ).append("\n"); 
		query.append("        --,CUST_CNT_CD  ?? CNT_CD" ).append("\n"); 
		query.append("        ,CORR_RMK" ).append("\n"); 
		query.append("        --,DMDT_INV_NO" ).append("\n"); 
		query.append("        ,WEB_IND_FLG" ).append("\n"); 
		query.append("        --,UPD_USR_ID" ).append("\n"); 
		query.append("        --,UPD_OFC_CD" ).append("\n"); 
		query.append("		,CXL_BKG_CHG_FLG" ).append("\n"); 
		query.append("		,NVL(WEB_MTY_DT, '') AS WEB_MTY_DT" ).append("\n"); 
		query.append("		,(SELECT MST.CNTR_TPSZ_CD FROM MST_CONTAINER MST WHERE MST.CNTR_NO = C.CNTR_NO) CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM DMT_CHG_CALC C" ).append("\n"); 
		query.append("WHERE (SYS_AREA_GRP_ID,CNTR_NO,CNTR_CYC_NO) IN (" ).append("\n"); 
		query.append("      SELECT SYS_AREA_GRP_ID, CNTR_NO, CNTR_CYC_NO FROM DMT_CHG_BKG_CNTR" ).append("\n"); 
		query.append("      WHERE BKG_NO IN (@[bkg_no])" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("AND FM_MVMT_YD_CD = @[fm_mvmt_yd_cd]" ).append("\n"); 
		query.append("AND CNTR_NO = @[cntr_no] --'NYKU5660500'" ).append("\n"); 
		query.append("AND DMDT_TRF_CD = 'DMIF'" ).append("\n"); 

	}
}