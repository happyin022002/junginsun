/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FeederChargeGuideLineDBDAOCheckLocCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.05
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.06.05 이은섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun-Sup Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FeederChargeGuideLineDBDAOCheckLocCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_LOCATION에 LOC_CD가 존재하는지 체크
	  * </pre>
	  */
	public FeederChargeGuideLineDBDAOCheckLocCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.integration ").append("\n"); 
		query.append("FileName : FeederChargeGuideLineDBDAOCheckLocCodeRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("  FROM MDM_LOCATION A" ).append("\n"); 
		query.append(" WHERE A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("       AND LOC_CD = @[loc_cd]" ).append("\n"); 

	}
}