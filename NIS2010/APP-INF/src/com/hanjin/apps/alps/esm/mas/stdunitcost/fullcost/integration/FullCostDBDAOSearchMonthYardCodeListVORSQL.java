/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FullCostDBDAOSearchMonthYardCodeListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2009.10.13 박수훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.fullcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SOO HOON PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FullCostDBDAOSearchMonthYardCodeListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRD_PORT_TML_MTX, MDM_YARD 테이블의 데이터 조회 
	  * </pre>
	  */
	public FullCostDBDAOSearchMonthYardCodeListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.fullcost.integration").append("\n"); 
		query.append("FileName : FullCostDBDAOSearchMonthYardCodeListVORSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A.TML_CD AS NOD_CD" ).append("\n"); 
		query.append(",B.YD_NM" ).append("\n"); 
		query.append(",A.VSL_SLAN_CD AS SLAN_CD" ).append("\n"); 
		query.append(",A.SKD_DIR_CD" ).append("\n"); 
		query.append(",'' AS SEL_CHECK" ).append("\n"); 
		query.append("FROM PRD_PORT_TML_MTX A,MDM_YARD B" ).append("\n"); 
		query.append("WHERE A.TML_CD = B.YD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_loc_cd} != '')" ).append("\n"); 
		query.append("AND A.PORT_CD  = @[f_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_slan_cd} != '')" ).append("\n"); 
		query.append("AND A.VSL_SLAN_CD = @[f_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY NOD_CD" ).append("\n"); 
		query.append(",SLAN_CD" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 

	}
}