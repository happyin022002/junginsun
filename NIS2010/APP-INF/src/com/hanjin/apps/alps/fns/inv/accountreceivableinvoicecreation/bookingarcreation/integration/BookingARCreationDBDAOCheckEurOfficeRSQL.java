/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingARCreationDBDAOCheckEurOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOCheckEurOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BookingARCreationDBDAOCheckEurOfficeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOCheckEurOfficeRSQL").append("\n"); 
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
		query.append("SELECT L.CNT_CD" ).append("\n"); 
		query.append("  FROM MDM_ORGANIZATION O" ).append("\n"); 
		query.append("       ,MDM_LOCATION    L" ).append("\n"); 
		query.append("       ,MDM_COUNTRY     C" ).append("\n"); 
		query.append("       ,INV_AR_EU_CNT_VAT E" ).append("\n"); 
		query.append(" WHERE O.LOC_CD = L.LOC_CD" ).append("\n"); 
		query.append("   AND L.CNT_CD = C.CNT_CD" ).append("\n"); 
		query.append("   AND L.CNT_CD = E.CNT_CD" ).append("\n"); 
		query.append("   AND NVL(C.EU_CNT_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("   AND O.OFC_CD = DECODE(@[ofc_cd],'PRGSC','HAMSC','WRPSC','HAMSC','BUDSC','HAMSC',@[ofc_cd])" ).append("\n"); 
		query.append("   AND NVL(E.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("   AND @[sail_arr_dt] BETWEEN E.INV_EURO_VAT_ST_DT AND NVL(E.INV_EURO_VAT_END_DT,'99991231')" ).append("\n"); 

	}
}