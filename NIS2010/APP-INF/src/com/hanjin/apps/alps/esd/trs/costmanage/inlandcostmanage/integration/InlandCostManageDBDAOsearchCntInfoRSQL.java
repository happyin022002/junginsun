/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : InlandCostManageDBDAOsearchCntInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.04
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2012.06.04 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandCostManageDBDAOsearchCntInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCntInfo
	  * </pre>
	  */
	public InlandCostManageDBDAOsearchCntInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.integration").append("\n"); 
		query.append("FileName : InlandCostManageDBDAOsearchCntInfoRSQL").append("\n"); 
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
		query.append("SELECT B.CNT_NM" ).append("\n"); 
		query.append(",D.CONTI_NM" ).append("\n"); 
		query.append(",C.SCONTI_NM" ).append("\n"); 
		query.append(",B.EU_CNT_FLG" ).append("\n"); 
		query.append(",DECODE(E.DELT_FLG, 'Y', 'EUR', B.CURR_CD) CURR_CD" ).append("\n"); 
		query.append(",DECODE(E.DELT_FLG, 'Y', 'Euro', E.CURR_NM) CURR_NM" ).append("\n"); 
		query.append("FROM MDM_COUNTRY       B" ).append("\n"); 
		query.append(",MDM_SUBCONTINENT  C" ).append("\n"); 
		query.append(",MDM_CONTINENT     D" ).append("\n"); 
		query.append(",MDM_CURRENCY      E" ).append("\n"); 
		query.append("WHERE B.SCONTI_CD = C.SCONTI_CD(+)" ).append("\n"); 
		query.append("AND C.CONTI_CD  = D.CONTI_CD(+)" ).append("\n"); 
		query.append("AND B.CURR_CD   = E.CURR_CD(+)" ).append("\n"); 
		query.append("AND B.CNT_CD    = @[cnt_cd]" ).append("\n"); 

	}
}