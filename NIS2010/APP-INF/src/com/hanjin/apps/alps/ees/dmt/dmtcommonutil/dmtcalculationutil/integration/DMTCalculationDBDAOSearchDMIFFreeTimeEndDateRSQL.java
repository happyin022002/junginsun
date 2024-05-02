/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCalculationDBDAOSearchDMIFFreeTimeEndDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.08
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOSearchDMIFFreeTimeEndDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDMIFFreeTimeEndDate
	  * </pre>
	  */
	public DMTCalculationDBDAOSearchDMIFFreeTimeEndDateRSQL(){
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
		query.append("FileName : DMTCalculationDBDAOSearchDMIFFreeTimeEndDateRSQL").append("\n"); 
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
		query.append("#if (${dmdt_trf_cd} == 'DMIF')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT MAX (TO_CHAR (FT_END_DT, 'YYYYMMDD')) DMIF_FT_END" ).append("\n"); 
		query.append("FROM DMT_CHG_CALC" ).append("\n"); 
		query.append("WHERE SYS_AREA_GRP_ID = @[svr_id]" ).append("\n"); 
		query.append("AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND CNTR_CYC_NO = @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND DMDT_TRF_CD = 'DMIF'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${dmdt_trf_cd} == 'DTIC')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT MAX (DECODE (NVL (M.DMDT_AR_IF_CD, 'N')" ).append("\n"); 
		query.append(",'Y', TO_CHAR (C.TO_MVMT_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append(",'N', TO_CHAR (C.FT_END_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append(")) DMIF_FT_END" ).append("\n"); 
		query.append("FROM DMT_CHG_CALC C" ).append("\n"); 
		query.append(",DMT_INV_MN M" ).append("\n"); 
		query.append("WHERE C.DMDT_INV_NO = M.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("AND C.SYS_AREA_GRP_ID = @[svr_id]" ).append("\n"); 
		query.append("AND C.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND C.CNTR_CYC_NO = @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND C.DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND C.DMDT_TRF_CD = 'DMIF'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}