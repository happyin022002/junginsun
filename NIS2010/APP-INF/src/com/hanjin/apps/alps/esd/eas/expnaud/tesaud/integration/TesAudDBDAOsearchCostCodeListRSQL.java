/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TesAudDBDAOsearchCostCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.23
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.03.23 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.tesaud.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TesAudDBDAOsearchCostCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCostCodeList
	  * </pre>
	  */
	public TesAudDBDAOsearchCostCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.expnaud.tesaud.integration").append("\n"); 
		query.append("FileName : TesAudDBDAOsearchCostCodeListRSQL").append("\n"); 
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
		query.append("SELECT	LGS_COST_CD" ).append("\n"); 
		query.append("FROM	TES_TML_SO_COST" ).append("\n"); 
		query.append("WHERE	1	= 1" ).append("\n"); 
		query.append("#if (${tml_inv_tp_cd} == 'OF') " ).append("\n"); 
		query.append("AND		FDCK_CY_STO_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tml_inv_tp_cd} == 'ST') " ).append("\n"); 
		query.append("AND		STO_INV_FLG = 'Y'	 " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}