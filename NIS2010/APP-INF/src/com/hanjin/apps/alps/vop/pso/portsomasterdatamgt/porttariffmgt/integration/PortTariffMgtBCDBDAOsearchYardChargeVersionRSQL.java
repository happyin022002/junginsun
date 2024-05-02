/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOsearchYardChargeVersionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOsearchYardChargeVersionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchYardChargeVersion
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOsearchYardChargeVersionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOsearchYardChargeVersionRSQL").append("\n"); 
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
		query.append("select  YD_CHG_VER_SEQ AS RN" ).append("\n"); 
		query.append("       ,YD_CHG_NO" ).append("\n"); 
		query.append("       ,YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("       ,PORT_TRF_URL" ).append("\n"); 
		query.append("       ,PORT_TRF_RMK" ).append("\n"); 
		query.append("       ,UPD_USR_ID" ).append("\n"); 
		query.append("       ,TO_CHAR(UPD_DT, 'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append("  from  PSO_YD_CHG" ).append("\n"); 
		query.append(" where  YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("   and  VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("   and  LGS_COST_CD = @[lgs_cost_cd]" ).append("\n"); 
		query.append("   and  TO_CHAR(EFF_DT, 'YYYY-MM-DD') =  regexp_substr(@[eff_dt], '[^~]+', 1, 1)" ).append("\n"); 
		query.append("   and  TO_CHAR(EXP_DT, 'YYYY-MM-DD') =  regexp_substr(@[eff_dt], '[^~]+', 1, 2)" ).append("\n"); 
		query.append("order by YD_CHG_VER_SEQ desc" ).append("\n"); 

	}
}