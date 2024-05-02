/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchContainerListAppliedAfterExceptionByDARNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOSearchContainerListAppliedAfterExceptionByDARNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking 에 속한 Container 중, After Exception 적용된 Container 를 조회하는 쿼리
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchContainerListAppliedAfterExceptionByDARNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchContainerListAppliedAfterExceptionByDARNoRSQL").append("\n"); 
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
		query.append("SELECT	CHG_CALC.CNTR_NO" ).append("\n"); 
		query.append(",	CHG_CALC.CNTR_CYC_NO" ).append("\n"); 
		query.append(",	CHG_CALC.DMDT_TRF_CD" ).append("\n"); 
		query.append(",	TO_CHAR(CHG_CALC.FT_END_DT, 'YYYYMMDD') FT_END_DT" ).append("\n"); 
		query.append("FROM	DMT_CHG_BKG_CNTR CHG_CNTR" ).append("\n"); 
		query.append(",	DMT_CHG_CALC CHG_CALC" ).append("\n"); 
		query.append("WHERE	CHG_CNTR.CNTR_NO = CHG_CALC.CNTR_NO" ).append("\n"); 
		query.append("AND CHG_CNTR.CNTR_CYC_NO = CHG_CALC.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND CHG_CNTR.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND CHG_CALC.DMDT_TRF_CD IN ('DMIF', 'DTIC')" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("SUBSTR(CHG_CALC.FM_MVMT_YD_CD, 1, 5) = 'KRPUS'" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("SUBSTR(CHG_CALC.FM_MVMT_YD_CD, 1, 5) = 'KRKAN'" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("SUBSTR(CHG_CALC.FM_MVMT_YD_CD, 1, 5) = 'KRINC'" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("SUBSTR(CHG_CALC.FM_MVMT_YD_CD, 1, 5) = 'KRPYT'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND	CHG_CALC.AFT_EXPT_DAR_NO = @[aft_expt_dar_no]" ).append("\n"); 

	}
}