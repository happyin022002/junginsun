/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchPoNoByShipRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchPoNoByShipRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Ship ID의 Purchase Other Number와 그외 number 정보를 조회한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchPoNoByShipRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchPoNoByShipRSQL").append("\n"); 
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
		query.append("#if (${popuptpcd} == 'S')" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("'' BKG_NO" ).append("\n"); 
		query.append(",'' REF_SEQ" ).append("\n"); 
		query.append(",'' DE_NO" ).append("\n"); 
		query.append(",'' SHP_REF_NO" ).append("\n"); 
		query.append(",'' PRT_NO" ).append("\n"); 
		query.append(",'' CNTR_NO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append(" BKG_NO," ).append("\n"); 
		query.append(" REF_SEQ," ).append("\n"); 
		query.append(" DE_NO," ).append("\n"); 
		query.append(" SHP_REF_NO," ).append("\n"); 
		query.append(" PRT_NO," ).append("\n"); 
		query.append(" CNTR_NO" ).append("\n"); 
		query.append("FROM BKG_REF_DTL" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("AND (   DE_NO IS NOT NULL" ).append("\n"); 
		query.append("     OR PRT_NO IS NOT NULL" ).append("\n"); 
		query.append("     OR SHP_REF_NO IS NOT NULL)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}