/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DMTCalculationDBDAOSearchCustomerInvListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.31
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2010.03.31 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOSearchCustomerInvListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCustomerInvList
	  * </pre>
	  */
	public DMTCalculationDBDAOSearchCustomerInvListRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOSearchCustomerInvListRSQL").append("\n"); 
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
		query.append("SELECT DECODE (A.DMDT_INV_STS_CD,'I','Y','N') AS DMDT_INV_STS_CD" ).append("\n"); 
		query.append(",A.DMDT_AR_IF_CD" ).append("\n"); 
		query.append(",TO_CHAR(C.FM_MVMT_DT, 'YYYYMMDD') AS FT_END_DT" ).append("\n"); 
		query.append(",TO_CHAR(C.TO_MVMT_DT, 'YYYYMMDD') AS TO_MVMT_DT" ).append("\n"); 
		query.append(",A.INV_CURR_CD" ).append("\n"); 
		query.append(",B.CNTR_INV_AMT AS INV_CHG_AMT" ).append("\n"); 
		query.append(",A.BKG_NO" ).append("\n"); 
		query.append(",C.CNTR_NO" ).append("\n"); 
		query.append(",C.DMDT_TRF_CD" ).append("\n"); 
		query.append(",CASE WHEN A.DMDT_AR_IF_CD = 'Y' THEN B.BIL_AMT ELSE 0 END AS BIL_AMT" ).append("\n"); 
		query.append("FROM DMT_INV_MN A" ).append("\n"); 
		query.append(",DMT_INV_DTL B" ).append("\n"); 
		query.append(",DMT_CHG_CALC C" ).append("\n"); 
		query.append("WHERE A.DMDT_INV_NO = B.DMDT_INV_NO" ).append("\n"); 
		query.append("AND A.CRE_OFC_CD = B.CRE_OFC_CD" ).append("\n"); 
		query.append("AND B.SYS_AREA_GRP_ID = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND B.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("AND B.CNTR_CYC_NO = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND B.DMDT_TRF_CD = C.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND B.DMDT_CHG_LOC_DIV_CD = C.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("AND B.CHG_SEQ = C.CHG_SEQ" ).append("\n"); 
		query.append("AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND (C.SYS_AREA_GRP_ID, C.CNTR_NO, C.CNTR_CYC_NO) IN (" ).append("\n"); 
		query.append("SELECT D.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(",D.CNTR_NO" ).append("\n"); 
		query.append(",D.CNTR_CYC_NO" ).append("\n"); 
		query.append("FROM DMT_CHG_BKG_CNTR D" ).append("\n"); 
		query.append("WHERE D.BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("AND C.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND C.DMDT_CHG_STS_CD IN ('F', 'C', 'I', 'L', 'N', 'U')" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("( C.DMDT_TRF_CD = 'DMIF' AND C.DMDT_CHG_LOC_DIV_CD = 'POD' )" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("( C.DMDT_TRF_CD = 'CTIC' AND C.DMDT_CHG_LOC_DIV_CD = 'DEL' )" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}