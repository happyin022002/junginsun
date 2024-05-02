/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RepCommodityDBDAOSearchRepCommodityListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.06
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2010.07.06 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.repcommodity.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HAM DAE SUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepCommodityDBDAOSearchRepCommodityListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RepCommodity의 모든 목록을 가져온다.
	  * </pre>
	  */
	public RepCommodityDBDAOSearchRepCommodityListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_cmdt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.repcommodity.integration").append("\n"); 
		query.append("FileName : RepCommodityDBDAOSearchRepCommodityListRSQL").append("\n"); 
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
		query.append("SELECT rep_cmdt_cd," ).append("\n"); 
		query.append("rep_cmdt_nm" ).append("\n"); 
		query.append("FROM mdm_rep_cmdt" ).append("\n"); 
		query.append("WHERE 1 = 1 AND nvl(delt_flg,'N') <> 'Y'" ).append("\n"); 
		query.append("#if(${rep_cmdt_cd} != '')" ).append("\n"); 
		query.append("AND rep_cmdt_cd LIKE @[rep_cmdt_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${rep_cmdt_nm} != '')" ).append("\n"); 
		query.append("AND rep_cmdt_nm LIKE '%' || @[rep_cmdt_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("order by rep_cmdt_cd" ).append("\n"); 

	}
}