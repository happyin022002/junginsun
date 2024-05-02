/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CalculateDBDAORsltPriPrsBatCalculateVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.26
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.03.26 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CalculateDBDAORsltPriPrsBatCalculateVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Used Route CASE Info
	  * </pre>
	  */
	public CalculateDBDAORsltPriPrsBatCalculateVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.integration").append("\n"); 
		query.append("FileName : CalculateDBDAORsltPriPrsBatCalculateVORSQL").append("\n"); 
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
		query.append("SELECT PARA_INFO_CTNT, PRS_BAT_ID FROM PRI_PRS_BAT WHERE PGM_NO = 'ESM_PRI_T001'" ).append("\n"); 

	}
}