/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonDBDAOMaxMin52RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.07.28 정은호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOMaxMin52RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_WK_PRD 의 PLN_WK 의 기준년도(+1)의  최소값과 최대값 조회
	  * </pre>
	  */
	public CommonDBDAOMaxMin52RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curYear",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmpYear",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOMaxMin52RSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("MAXVAL," ).append("\n"); 
		query.append("MINVAL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'${curYear}'||MAX(PLN_WK) MAXVAL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PLN_YR = @[curYear]" ).append("\n"); 
		query.append(") A ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'${tmpYear}'||MIN(PLN_WK) MINVAL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PLN_YR = @[tmpYear]" ).append("\n"); 
		query.append(") B" ).append("\n"); 

	}
}