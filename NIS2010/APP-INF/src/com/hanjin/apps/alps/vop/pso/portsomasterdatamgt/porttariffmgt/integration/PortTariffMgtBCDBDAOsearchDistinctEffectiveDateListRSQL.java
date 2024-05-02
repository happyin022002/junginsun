/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOsearchDistinctEffectiveDateListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.10
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.12.10 정명훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOsearchDistinctEffectiveDateListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDistinctEffectiveDateList
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOsearchDistinctEffectiveDateListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOsearchDistinctEffectiveDateListRSQL").append("\n"); 
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
		query.append("SELECT ROWNUM RN" ).append("\n"); 
		query.append(",EFF_DT" ).append("\n"); 
		query.append(",EXP_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT   DISTINCT TO_CHAR(EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append(",TO_CHAR(EXP_DT, 'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("FROM   pso_yd_chg" ).append("\n"); 
		query.append("WHERE       YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("AND VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND LGS_COST_CD = @[lgs_cost_cd]" ).append("\n"); 
		query.append("#if(${year} != '')" ).append("\n"); 
		query.append("--2009.12.10:jmh" ).append("\n"); 
		query.append("AND EFF_DT <= TO_DATE(@[year] || '1231', 'YYYYMMDD')    -- end_dt" ).append("\n"); 
		query.append("AND EXP_DT >= TO_DATE(@[year] || '0101', 'YYYYMMDD')    -- start_dt" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY 1 DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}