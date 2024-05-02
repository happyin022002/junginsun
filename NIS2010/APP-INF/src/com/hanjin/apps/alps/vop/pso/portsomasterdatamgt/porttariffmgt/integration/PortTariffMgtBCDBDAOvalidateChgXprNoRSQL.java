/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOvalidateChgXprNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.23 
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

public class PortTariffMgtBCDBDAOvalidateChgXprNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [CHM-201534260] BASE tariff등록시 object rate 는 반드시 포함되어야 함.
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOvalidateChgXprNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_xpr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_cnd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOvalidateChgXprNoRSQL").append("\n"); 
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
		query.append("SELECT X.CHK" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT CASE WHEN INSTR(B.FOML_SYS_DESC, @[exp_cnd] ) <> 0 THEN 'Y' " ).append("\n"); 
		query.append("            ELSE 'N' END  AS CHK" ).append("\n"); 
		query.append(" FROM PSO_CHG_XPR_DTL A,  PSO_FORMULA B" ).append("\n"); 
		query.append("WHERE A.FOML_NO    = B.FOML_NO" ).append("\n"); 
		query.append("  AND A.CHG_XPR_NO =  @[chg_xpr_no]" ).append("\n"); 
		query.append("  ORDER BY CHK ASC ) X" ).append("\n"); 
		query.append("  WHERE ROWNUM    = 1" ).append("\n"); 

	}
}