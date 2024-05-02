/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSearchCntrNormalTpszRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOSearchCntrNormalTpszRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Normal TPSZ Search
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSearchCntrNormalTpszRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration ").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSearchCntrNormalTpszRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT PPT_CD" ).append("\n"); 
		query.append("     , ATTR_CTNT2 AS TGT_NORMAL_TPSZ" ).append("\n"); 
		query.append("  FROM JOO_COM_PPT" ).append("\n"); 
		query.append(" WHERE PPT_CD = @[ppt_cd]" ).append("\n"); 
		query.append("   AND ATTR_CTNT2 IS NOT NULL" ).append("\n"); 
		query.append(" ORDER BY ATTR_CTNT2" ).append("\n"); 

	}
}