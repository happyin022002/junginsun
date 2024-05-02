/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingExptClrRqstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.22 
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

public class ChargeAmountDiscountMgtDBDAOSearchAfterBookingExptClrRqstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAOSearchAfterBookingExptClrRqst
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchAfterBookingExptClrRqstRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingExptClrRqstRSQL").append("\n"); 
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
		query.append("SELECT NVL(C.BKG_NO, B.BKG_NO) BKG_NO, " ).append("\n"); 
		query.append("       NVL(C.CNTR_NO, B.CNTR_NO) CNTR_NO," ).append("\n"); 
		query.append("       NVL(C.DMDT_CHG_STS_CD, A.DMDT_CHG_STS_CD) DMDT_CHG_STS_CD," ).append("\n"); 
		query.append("       TO_CHAR(C.CGOR_DT,'YYYYMMDD') CGOR_DT, " ).append("\n"); 
		query.append("       TO_CHAR(C.MCNTR_RTN_DT,'YYYYMMDD') MCNTR_RTN_DT" ).append("\n"); 
		query.append("FROM DMT_AFT_BKG_EXPT_CLR_RQST C, DMT_CHG_CALC A, DMT_CHG_BKG_CNTR B" ).append("\n"); 
		query.append("WHERE C.AFT_EXPT_DAR_NO(+) = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("AND C.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("AND C.CNTR_NO(+) = B.CNTR_NO" ).append("\n"); 
		query.append("AND A.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("AND A.CNTR_CYC_NO = B.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND A.DMDT_TRF_CD = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND A.DMDT_CHG_STS_CD = 'L'" ).append("\n"); 

	}
}