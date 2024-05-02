/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PortTariffMgtBCDBDAORemoveTariffFromPsoChgXprDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.10 
* 1.0 Creation
* 
* History
* 2014.03.12 박다은 CHM-201429104 [PSO] Tariff Attribute 내 불필요 Tariff 삭제 기능 요청
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAORemoveTariffFromPsoChgXprDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSO_CHG_XPR 에서 Tariff 정보를 삭제한다.
	  * </pre>
	  */
	public PortTariffMgtBCDBDAORemoveTariffFromPsoChgXprDSQL(){
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
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration ").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAORemoveTariffFromPsoChgXprDSQL").append("\n"); 
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
		query.append("DELETE PSO_CHG_XPR " ).append("\n"); 
		query.append(" WHERE CHG_XPR_NO IN (" ).append("\n"); 
		query.append("                        SELECT CHG_XPR_NO " ).append("\n"); 
		query.append("                          FROM PSO_YD_CHG_XPR      " ).append("\n"); 
		query.append("                         WHERE YD_CHG_NO = @[yd_chg_no] " ).append("\n"); 
		query.append("                           AND YD_CHG_VER_SEQ = @[yd_chg_ver_seq]" ).append("\n"); 
		query.append("                       ) " ).append("\n"); 

	}
}