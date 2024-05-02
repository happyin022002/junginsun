/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchChargeNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.18 
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

public class BookingARCreationDBDAOSearchChargeNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchChargeNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchChargeNameRSQL").append("\n"); 
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
		query.append("SELECT CHG_NM  " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("       SELECT NUM, CHG_NM " ).append("\n"); 
		query.append("       FROM (" ).append("\n"); 
		query.append("              SELECT 1 NUM, DECODE(@[chg_cd],'JOP','TERMINAL STEVEDORAGE','CRC', 'MIS. REVENUE(CNTR) - EQ RENTAL',CHG_NM) CHG_NM" ).append("\n"); 
		query.append("              FROM   MDM_CHARGE" ).append("\n"); 
		query.append("              WHERE  CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("              UNION ALL" ).append("\n"); 
		query.append("              SELECT (CHG_SEQ+1) NUM, CHG_DESC_CONV_CTNT CHG_NM" ).append("\n"); 
		query.append("              FROM   INV_CHG_DESC_CONV" ).append("\n"); 
		query.append("              WHERE  AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("              AND    CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("              AND    NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    ORDER BY NUM DESC )" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

	}
}