/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeCalculationDBDAODeleteBookingChargeByBookingDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.05 
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

public class ChargeCalculationDBDAODeleteBookingChargeByBookingDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAODeleteBookingChargeByBookingDSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAODeleteBookingChargeByBookingDSQL(){
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
		params.put("batch_cntr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAODeleteBookingChargeByBookingDSQL").append("\n"); 
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
		query.append("DELETE FROM DMT_CHG_BKG_CNTR" ).append("\n"); 
		query.append("WHERE ROWID" ).append("\n"); 
		query.append("	IN" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		SELECT ROWID" ).append("\n"); 
		query.append("		FROM DMT_CHG_BKG_CNTR A" ).append("\n"); 
		query.append("		WHERE BKG_NO	= @[bkg_no]" ).append("\n"); 
		query.append("#if (${batch_cntr} != '')" ).append("\n"); 
		query.append("		AND CNTR_NO = @[batch_cntr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		AND NOT EXISTS ( SELECT 'Y' FROM DMT_CHG_CALC B" ).append("\n"); 
		query.append("	                      WHERE A.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("	                        AND A.CNTR_NO         = B.CNTR_NO" ).append("\n"); 
		query.append("	                        AND A.CNTR_CYC_NO     = B.CNTR_CYC_NO )" ).append("\n"); 
		query.append("	 )" ).append("\n"); 

	}
}