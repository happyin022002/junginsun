/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOCheckBalanceChargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOCheckBalanceChargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Balance Charge 가 있는 CNTR 인지 체크하는 쿼리
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOCheckBalanceChargeRSQL(){
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOCheckBalanceChargeRSQL").append("\n"); 
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
		query.append("SELECT	COUNT(CALC.SYS_AREA_GRP_ID)" ).append("\n"); 
		query.append("FROM	DMT_CHG_BKG_CNTR BKG_CNTR" ).append("\n"); 
		query.append(",	DMT_CHG_CALC CALC" ).append("\n"); 
		query.append("WHERE	BKG_CNTR.SYS_AREA_GRP_ID = CALC.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND	BKG_CNTR.CNTR_NO = CALC.CNTR_NO" ).append("\n"); 
		query.append("AND BKG_CNTR.CNTR_CYC_NO = CALC.CNTR_CYC_NO" ).append("\n"); 
		query.append("#if(${bkg_no} != '')" ).append("\n"); 
		query.append("AND BKG_CNTR.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${bl_no} != '')" ).append("\n"); 
		query.append("AND BKG_CNTR.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND CHG_SEQ > 1" ).append("\n"); 

	}
}