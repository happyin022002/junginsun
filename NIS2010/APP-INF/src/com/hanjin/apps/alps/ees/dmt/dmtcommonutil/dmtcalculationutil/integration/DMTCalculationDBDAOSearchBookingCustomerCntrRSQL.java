/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DMTCalculationDBDAOSearchBookingCustomerCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.10 
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

public class DMTCalculationDBDAOSearchBookingCustomerCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBookingCustomerCntr
	  * </pre>
	  */
	public DMTCalculationDBDAOSearchBookingCustomerCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOSearchBookingCustomerCntrRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT CNTR_NO ," ).append("\n"); 
		query.append("SUM(FX_FT_OVR_DYS) OVER() AS FX_FT_OVR_DYS ," ).append("\n"); 
		query.append("BZC_TRF_CURR_CD ," ).append("\n"); 
		query.append("SUM(BIL_AMT) OVER() AS BIL_AMT ," ).append("\n"); 
		query.append("FT_DYS ," ).append("\n"); 
		query.append("MAX(FT_END_DT) OVER() AS FT_END_DT" ).append("\n"); 
		query.append("FROM (SELECT C.CNTR_NO AS CNTR_NO" ).append("\n"); 
		query.append(",C.FX_FT_OVR_DYS AS FX_FT_OVR_DYS" ).append("\n"); 
		query.append(",C.BZC_TRF_CURR_CD AS BZC_TRF_CURR_CD" ).append("\n"); 
		query.append(",C.BIL_AMT AS BIL_AMT" ).append("\n"); 
		query.append(",SUM (C.FT_DYS) OVER (PARTITION BY C.SYS_AREA_GRP_ID, C.CNTR_NO, C.CNTR_CYC_NO, C.DMDT_TRF_CD, C.DMDT_CHG_LOC_DIV_CD)" ).append("\n"); 
		query.append("AS FT_DYS" ).append("\n"); 
		query.append(", MAX (TO_CHAR (DECODE(NVL(INVM.DMDT_AR_IF_CD, 'N'),'Y',C.TO_MVMT_DT, C.FT_END_DT), 'YYYYMMDD')) OVER (PARTITION BY C.SYS_AREA_GRP_ID, C.CNTR_NO, C.CNTR_CYC_NO, C.DMDT_TRF_CD, C.DMDT_CHG_LOC_DIV_CD) AS FT_END_DT" ).append("\n"); 
		query.append("--              ,MIN (TO_CHAR (C.FT_END_DT, 'YYYYMMDD')) OVER (PARTITION BY C.SYS_AREA_GRP_ID, C.CNTR_NO, C.CNTR_CYC_NO, C.DMDT_TRF_CD, C.DMDT_CHG_LOC_DIV_CD) AS FT_END_DT" ).append("\n"); 
		query.append("FROM DMT_CHG_CALC C, DMT_INV_MN  INVM" ).append("\n"); 
		query.append("WHERE (C.SYS_AREA_GRP_ID, C.CNTR_NO, C.CNTR_CYC_NO) IN (" ).append("\n"); 
		query.append("SELECT D.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(",D.CNTR_NO" ).append("\n"); 
		query.append(",D.CNTR_CYC_NO" ).append("\n"); 
		query.append("FROM DMT_CHG_BKG_CNTR D" ).append("\n"); 
		query.append("WHERE D.BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("AND C.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND C.DMDT_CHG_STS_CD IN ('F', 'C', 'I', 'L', 'N', 'U')" ).append("\n"); 
		query.append("AND (   (    C.DMDT_TRF_CD = 'DMIF'" ).append("\n"); 
		query.append("AND C.DMDT_CHG_LOC_DIV_CD = 'POD')" ).append("\n"); 
		query.append("OR (    C.DMDT_TRF_CD = 'CTIC'" ).append("\n"); 
		query.append("AND C.DMDT_CHG_LOC_DIV_CD = 'DEL')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND C.DMDT_INV_NO = INVM.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("AND NOT (C.DUL_TP_EXPT_FLG  = 'Y' AND SUBSTR(C.DMDT_TRF_CD, 1, 1) = 'D')" ).append("\n"); 
		query.append("AND C.DMDT_CHG_LOC_DIV_CD    <> 'SZP'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM < 2" ).append("\n"); 

	}
}