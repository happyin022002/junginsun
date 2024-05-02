/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACCommCalculationDBDAORemoveACMAgnCommTrspDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.12
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACCommCalculationDBDAORemoveACMAgnCommTrspDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FACCommCalculationDBDAORemoveACMAgnCommTrspDSQL
	  * </pre>
	  */
	public FACCommCalculationDBDAORemoveACMAgnCommTrspDSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration").append("\n"); 
		query.append("FileName : FACCommCalculationDBDAORemoveACMAgnCommTrspDSQL").append("\n"); 
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
		query.append("DELETE" ).append("\n"); 
		query.append("  FROM ACM_AGN_COMM_TRSP" ).append("\n"); 
		query.append(" WHERE" ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("       AGN_CD," ).append("\n"); 
		query.append("       AC_TP_CD," ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       AC_SEQ" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("    IN" ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("           SELECT" ).append("\n"); 
		query.append("                  BKG_NO," ).append("\n"); 
		query.append("                  AGN_CD," ).append("\n"); 
		query.append("                  AC_TP_CD," ).append("\n"); 
		query.append("                  IO_BND_CD," ).append("\n"); 
		query.append("                  AC_SEQ " ).append("\n"); 
		query.append("             FROM ACM_AGN_COMM" ).append("\n"); 
		query.append("            WHERE AC_STS_CD" ).append("\n"); 
		query.append("               IN" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                  'CE', 'CS', 'CM', 'CA', 'IC'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("              AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     )" ).append("\n"); 

	}
}