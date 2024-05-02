/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DropOffTariffDBDAORemoveDodTariffDataDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.26
*@LastModifier : 윤용상
*@LastVersion : 1.0
* 2015.11.26 윤용상
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YOON Yong-Sang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DropOffTariffDBDAORemoveDodTariffDataDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DodTariff 정보 수정
	  * </pre>
	  */
	public DropOffTariffDBDAORemoveDodTariffDataDSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.integration").append("\n"); 
		query.append("FileName : DropOffTariffDBDAORemoveDodTariffDataDSQL").append("\n"); 
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
		query.append("DELETE DOD_DRP_OFF_CHG_TRF" ).append("\n"); 
		query.append(" where 1=1" ).append("\n"); 
		query.append("   and DRP_OFF_CHG_TRF_SEQ = @[drp_off_chg_trf_seq]" ).append("\n"); 
		query.append("   and NOT EXISTS (select 'X' from DOD_DRP_OFF_CHG " ).append("\n"); 
		query.append("                    where DRP_OFF_CHG_TRF_SEQ = @[drp_off_chg_trf_seq]" ).append("\n"); 
		query.append("                       or DRP_OFF_CHG_TRF_SPCL_SEQ = @[drp_off_chg_trf_seq]" ).append("\n"); 
		query.append("                   )" ).append("\n"); 

	}
}