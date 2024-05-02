/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOCheckDupTariffBKGBLNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.03 
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

public class ChargeAmountDiscountMgtDBDAOCheckDupTariffBKGBLNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff Type 과 BKG  또는 B/L No. 가 중복되는지 체크하는 쿼리
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOCheckDupTariffBKGBLNoRSQL(){
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
		params.put("tariff",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOCheckDupTariffBKGBLNoRSQL").append("\n"); 
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
		query.append("SELECT	ADJ_RQST_DTL.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    DMT_AFT_BKG_ADJ_RQST ADJ_RQST" ).append("\n"); 
		query.append("    ,   DMT_AFT_BKG_ADJ_RQST_DTL ADJ_RQST_DTL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE   ADJ_RQST.DMDT_EXPT_RQST_STS_CD IN ('T','R', 'A','F','G','H','M','I','O')" ).append("\n"); 
		query.append("    AND ADJ_RQST.AFT_EXPT_DAR_NO = ADJ_RQST_DTL.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("    AND ADJ_RQST_DTL.DMDT_TRF_CD = @[tariff]" ).append("\n"); 
		query.append("#if(${bkg_no} != '')" ).append("\n"); 
		query.append("    AND ADJ_RQST_DTL.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#elseif(${bl_no} != '')" ).append("\n"); 
		query.append("    AND ADJ_RQST_DTL.BKG_NO = (SELECT BKG_NO FROM BKG_BOOKING WHERE BL_NO = @[bl_no])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}