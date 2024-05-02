/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TurnTimePerformanceMgtDBDDAOsearchYardListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.13
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TurnTimePerformanceMgtDBDDAOsearchYardListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchYardList
	  * </pre>
	  */
	public TurnTimePerformanceMgtDBDDAOsearchYardListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.integration ").append("\n"); 
		query.append("FileName : TurnTimePerformanceMgtDBDDAOsearchYardListRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(YD_CD, 6, 2) YD_CD" ).append("\n"); 
		query.append("FROM  MDM_YARD" ).append("\n"); 
		query.append("WHERE LOC_CD = @[pol]" ).append("\n"); 
		query.append("AND   YD_FCTY_TP_MRN_TML_FLG = 'Y'" ).append("\n"); 
		query.append("AND   DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY SUBSTR(YD_CD, 6, 2)" ).append("\n"); 

	}
}