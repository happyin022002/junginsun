/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DropOffTariffDBDAOModifyConfirmDodTariffListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DropOffTariffDBDAOModifyConfirmDodTariffListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DOD Tariff 를 confirm 한다.
	  * </pre>
	  */
	public DropOffTariffDBDAOModifyConfirmDodTariffListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drp_off_chg_trf_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drp_off_chg_trf_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drp_off_chg_trf_cfm_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.integration").append("\n"); 
		query.append("FileName : DropOffTariffDBDAOModifyConfirmDodTariffListUSQL").append("\n"); 
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
		query.append("UPDATE DOD_DRP_OFF_CHG_TRF" ).append("\n"); 
		query.append("SET DRP_OFF_CHG_TRF_CFM_USR_ID = @[drp_off_chg_trf_cfm_usr_id]" ).append("\n"); 
		query.append("	,DRP_OFF_CHG_TRF_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("	,DRP_OFF_CHG_TRF_CFM_DT = sysdate" ).append("\n"); 
		query.append("	,DRP_OFF_CHG_TRF_RMK = @[drp_off_chg_trf_rmk]" ).append("\n"); 
		query.append("WHERE DRP_OFF_CHG_TRF_SEQ = @[drp_off_chg_trf_seq]" ).append("\n"); 

	}
}