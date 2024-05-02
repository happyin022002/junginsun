/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DropOffTariffDBDAOSearchDodTariffContiRSQL.java
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

public class DropOffTariffDBDAOSearchDodTariffContiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDodTariffConti
	  * </pre>
	  */
	public DropOffTariffDBDAOSearchDodTariffContiRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rtn_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.integration").append("\n"); 
		query.append("FileName : DropOffTariffDBDAOSearchDodTariffContiRSQL").append("\n"); 
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
		query.append("SELECT A.CONTI_CD POL_CONTI_CD" ).append("\n"); 
		query.append("            FROM   MDM_CONTINENT A, MDM_SUBCONTINENT B, MDM_COUNTRY C" ).append("\n"); 
		query.append("            WHERE  1=1" ).append("\n"); 
		query.append("            AND    A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("            AND    A.CONTI_CD = B.CONTI_CD" ).append("\n"); 
		query.append("            AND    B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("            AND    B.SCONTI_CD = C.SCONTI_CD" ).append("\n"); 
		query.append("            AND    C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("            and    c.cnt_cd = @[s_cnt_cd]" ).append("\n"); 
		query.append("			and    a.conti_cd IN (SELECT A.CONTI_CD " ).append("\n"); 
		query.append("            FROM   MDM_CONTINENT A, MDM_SUBCONTINENT B, MDM_COUNTRY C" ).append("\n"); 
		query.append("            WHERE  1=1" ).append("\n"); 
		query.append("            AND    A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("            AND    A.CONTI_CD = B.CONTI_CD" ).append("\n"); 
		query.append("            AND    B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("            AND    B.SCONTI_CD = C.SCONTI_CD" ).append("\n"); 
		query.append("            AND    C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("            and    c.cnt_cd = substr(@[s_rtn_loc_cd], 0, 2))" ).append("\n"); 

	}
}