/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CNTRInventoryReportDBDAOmodifyOptmStkUpdIdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CNTRInventoryReportDBDAOmodifyOptmStkUpdIdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2016-02-02
	  * Equipment Management > CNTR Inventory > Inventory Status > Land Inventory > Land Inventory with Optimum Stock 수정
	  * </pre>
	  */
	public CNTRInventoryReportDBDAOmodifyOptmStkUpdIdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration").append("\n"); 
		query.append("FileName : CNTRInventoryReportDBDAOmodifyOptmStkUpdIdUSQL").append("\n"); 
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
		query.append("UPDATE CIM_OPTM_STK_SMRY SET	" ).append("\n"); 
		query.append("  UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(", UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE OPTM_STK_MNG_TP_CD = 'F'" ).append("\n"); 
		query.append("  AND DMG_FLG = 'A'" ).append("\n"); 
		query.append("  AND TGT_YRWK = (SELECT MAX(TGT_YRWK) " ).append("\n"); 
		query.append("                    FROM CIM_OPTM_STK_SMRY" ).append("\n"); 
		query.append("                   WHERE OPTM_STK_MNG_TP_CD = 'F'" ).append("\n"); 
		query.append("                     AND DMG_FLG = 'A')" ).append("\n"); 
		query.append("  AND ECC_CD IN (SELECT ECC_CD " ).append("\n"); 
		query.append("                   FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("                  WHERE RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("                  GROUP BY  ECC_CD)" ).append("\n"); 

	}
}