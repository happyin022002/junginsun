/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : USDomesticDBDAODomesticMonthCopyDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.07
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2013.05.07 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.usdomestic.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USDomesticDBDAODomesticMonthCopyDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Domestic Saving Credit 월 단가 삭제
	  * </pre>
	  */
	public USDomesticDBDAODomesticMonthCopyDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_tar_mon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.usdomestic.integration ").append("\n"); 
		query.append("FileName : USDomesticDBDAODomesticMonthCopyDSQL").append("\n"); 
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
		query.append(" DELETE" ).append("\n"); 
		query.append("   FROM MAS_USA_DMST_UT_COST" ).append("\n"); 
		query.append("  WHERE COST_YRMON= @[f_tar_mon]" ).append("\n"); 

	}
}