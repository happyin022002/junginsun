/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOSearchYardChargeRemarkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.06 
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

public class PortTariffMgtBCDBDAOSearchYardChargeRemarkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PortTariffMgtBCDBDAOSearchYardChargeRemarkRSQL
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOSearchYardChargeRemarkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chg_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOSearchYardChargeRemarkRSQL").append("\n"); 
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
		query.append("select  YD_CHG_NO" ).append("\n"); 
		query.append("       ,YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("       ,PORT_TRF_RMK" ).append("\n"); 
		query.append("  from  PSO_YD_CHG" ).append("\n"); 
		query.append(" where  YD_CHG_NO = @[yd_chg_no]" ).append("\n"); 
		query.append("   and  YD_CHG_VER_SEQ = @[yd_chg_ver_seq]" ).append("\n"); 

	}
}