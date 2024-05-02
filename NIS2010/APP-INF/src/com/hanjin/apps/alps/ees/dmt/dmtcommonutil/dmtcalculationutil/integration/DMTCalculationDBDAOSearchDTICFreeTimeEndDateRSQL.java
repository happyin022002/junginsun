/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCalculationDBDAOSearchDTICFreeTimeEndDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.29
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.12.29 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOSearchDTICFreeTimeEndDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDTICFreeTimeEndDate
	  * </pre>
	  */
	public DMTCalculationDBDAOSearchDTICFreeTimeEndDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_chg_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOSearchDTICFreeTimeEndDateRSQL").append("\n"); 
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
		query.append("SELECT /*+ USE_NL( C M D ) */" ).append("\n"); 
		query.append("MIN (TO_CHAR (C.FT_END_DT, 'YYYYMMDD')) DTIC_FT_END" ).append("\n"); 
		query.append(",TO_CHAR (NVL (SUM (C.FX_FT_OVR_DYS), 0)) DTIC_FT_OVER" ).append("\n"); 
		query.append("FROM DMT_CHG_CALC C" ).append("\n"); 
		query.append(",DMT_INV_MN M" ).append("\n"); 
		query.append(",DMT_INV_DTL D" ).append("\n"); 
		query.append("WHERE C.SYS_AREA_GRP_ID     = @[svr_id]" ).append("\n"); 
		query.append("AND C.CNTR_NO    	     = @[cntr_no]" ).append("\n"); 
		query.append("AND C.CNTR_CYC_NO         = @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND C.DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND C.DMDT_TRF_CD         = 'DTIC'" ).append("\n"); 
		query.append("AND C.SYS_AREA_GRP_ID     = D.SYS_AREA_GRP_ID (+)" ).append("\n"); 
		query.append("AND C.CNTR_NO             = D.CNTR_NO   (+)" ).append("\n"); 
		query.append("AND C.CNTR_CYC_NO         = D.CNTR_CYC_NO  (+)" ).append("\n"); 
		query.append("AND C.DMDT_TRF_CD         = D.DMDT_TRF_CD  (+)" ).append("\n"); 
		query.append("AND C.DMDT_CHG_LOC_DIV_CD = D.DMDT_CHG_LOC_DIV_CD(+)" ).append("\n"); 
		query.append("AND C.CHG_SEQ             = D.CHG_SEQ   (+)" ).append("\n"); 
		query.append("AND D.DMDT_INV_NO         =   M.DMDT_INV_NO" ).append("\n"); 
		query.append("AND D.CRE_OFC_CD          =   M.CRE_OFC_CD" ).append("\n"); 
		query.append("AND NVL(M.DMDT_AR_IF_CD, 'N') <> 'Y'" ).append("\n"); 

	}
}