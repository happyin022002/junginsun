/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PRICommonDBDAORgnNmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.09 이승준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung Jun Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAORgnNmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Region nm select
	  * </pre>
	  */
	public PRICommonDBDAORgnNmRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT A.RGN_CD AS CD," ).append("\n"); 
		query.append("A.RGN_NM AS NM" ).append("\n"); 
		query.append("FROM MDM_REGION A" ).append("\n"); 
		query.append("WHERE A.RGN_CD= @[cd]" ).append("\n"); 
		query.append("AND A.DELT_FLG ='N'" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration ").append("\n"); 
		query.append("FileName : PRICommonDBDAORgnNmRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}