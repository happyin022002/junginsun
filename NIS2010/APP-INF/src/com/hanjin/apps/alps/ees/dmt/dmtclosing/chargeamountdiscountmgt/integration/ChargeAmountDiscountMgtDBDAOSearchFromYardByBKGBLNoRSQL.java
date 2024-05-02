/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchFromYardByBKGBLNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.07 
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

public class ChargeAmountDiscountMgtDBDAOSearchFromYardByBKGBLNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 BKG/B/L No. 의 Tariff Type(DMIF, DMOF) 의 Calculation Type 이 맞지 않을 경우 에러 메시지로 뿌려줄 Location Code 를 조회하는 쿼리
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchFromYardByBKGBLNoRSQL(){
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
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchFromYardByBKGBLNoRSQL").append("\n"); 
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
		query.append("SELECT	CASE" ).append("\n"); 
		query.append("WHEN SUBSTR(@[tariff], 3, 1) = 'I' THEN CHG_CNTR.DEL_CD" ).append("\n"); 
		query.append("WHEN SUBSTR(@[tariff], 3, 1) = 'O' THEN CHG_CNTR.POR_CD" ).append("\n"); 
		query.append("END LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	DMT_CHG_BKG_CNTR CHG_CNTR" ).append("\n"); 
		query.append(",	DMT_CHG_CALC CHG_CALC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("#if(${bkg_no} != '')" ).append("\n"); 
		query.append("CHG_CNTR.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#elseif(${bl_no} != '')" ).append("\n"); 
		query.append("CHG_CNTR.BKG_NO = (SELECT BKG_NO FROM BKG_BOOKING WHERE BL_NO = @[bl_no])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND CHG_CNTR.SYS_AREA_GRP_ID =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("FROM    COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("WHERE   CNT_CD =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN SUBSTR(@[tariff], 2, 1) = 'M' AND SUBSTR(@[tariff], 3, 1) = 'I'" ).append("\n"); 
		query.append("THEN SUBSTR(CHG_CNTR.POD_CD, 0, 2)" ).append("\n"); 
		query.append("WHEN SUBSTR(@[tariff], 2, 1) = 'M' AND SUBSTR(@[tariff], 3, 1) = 'O'" ).append("\n"); 
		query.append("THEN SUBSTR(CHG_CNTR.POL_CD, 0, 2)" ).append("\n"); 
		query.append("WHEN SUBSTR(@[tariff], 2, 1) = 'T' AND SUBSTR(@[tariff], 3, 1) = 'I'" ).append("\n"); 
		query.append("THEN SUBSTR(CHG_CNTR.DEL_CD, 0, 2)" ).append("\n"); 
		query.append("WHEN SUBSTR(@[tariff], 2, 1) = 'T' AND SUBSTR(@[tariff], 3, 1) = 'O'" ).append("\n"); 
		query.append("THEN SUBSTR(CHG_CNTR.POR_CD, 0, 2)" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND CO_IND_CD = 'H'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND CHG_CNTR.SYS_AREA_GRP_ID = CHG_CALC.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND CHG_CNTR.CNTR_NO = CHG_CALC.CNTR_NO" ).append("\n"); 
		query.append("AND CHG_CNTR.CNTR_CYC_NO = CHG_CALC.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND CHG_CALC.DMDT_TRF_CD = @[tariff]" ).append("\n"); 
		query.append("AND CHG_CALC.CHG_SEQ = 1" ).append("\n"); 

	}
}