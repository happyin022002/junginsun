/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CodeComboUtilDBDAOSearchComboListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.25
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2010.01.25 전재홍
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.lea.common.codecomboutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeon Jae Hong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodeComboUtilDBDAOSearchComboListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cost Code 목록조회
	  * </pre>
	  */
	public CodeComboUtilDBDAOSearchComboListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("maincosttypecode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.lea.common.codecomboutil.integration").append("\n"); 
		query.append("FileName : CodeComboUtilDBDAOSearchComboListRSQL").append("\n"); 
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
		query.append("#if (${costkind} == 'COST_KIND_MAIN')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* LEA Logistics Main Cost Type Code */" ).append("\n"); 
		query.append("SELECT    DISTINCT" ).append("\n"); 
		query.append("X.MN_COST_TP_CD 	AS CODE" ).append("\n"); 
		query.append(",    X.MN_COST_TP_CD 	AS NAME" ).append("\n"); 
		query.append("FROM      LEA_SUB_COST_TP 	X" ).append("\n"); 
		query.append("WHERE     X.DELT_FLG      	= 'N'" ).append("\n"); 
		query.append("AND       X.MN_COST_TP_CD 	IS NOT NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${costkind} == 'COST_KIND_SUB')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* LEA Logistics Sub Cost Type Code */" ).append("\n"); 
		query.append("#if (${maincosttypecode} != '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  X.SUB_COST_TP_CD  	AS CODE" ).append("\n"); 
		query.append(",	X.SUB_COST_TP_NM  	AS NAME" ).append("\n"); 
		query.append("FROM    LEA_SUB_COST_TP 	X" ).append("\n"); 
		query.append("WHERE   X.DELT_FLG      	= 'N'" ).append("\n"); 
		query.append("AND		X.MN_COST_TP_CD		= @[maincosttypecode]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  X.SUB_COST_TP_CD  	AS CODE" ).append("\n"); 
		query.append(",	X.SUB_COST_TP_NM  	AS NAME" ).append("\n"); 
		query.append("FROM    LEA_SUB_COST_TP 	X" ).append("\n"); 
		query.append("WHERE   X.DELT_FLG      	= 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}