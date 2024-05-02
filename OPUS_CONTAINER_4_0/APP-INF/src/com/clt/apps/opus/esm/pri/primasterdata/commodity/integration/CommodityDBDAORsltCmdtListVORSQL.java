/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CommodityDBDAORsltCmdtListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.commodity.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommodityDBDAORsltCmdtListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * commodity 조회
	  * </pre>
	  */
	public CommodityDBDAORsltCmdtListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.primasterdata.commodity.integration").append("\n"); 
		query.append("FileName : CommodityDBDAORsltCmdtListVORSQL").append("\n"); 
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
		query.append("	CMDT_CD," ).append("\n"); 
		query.append("	CMDT_NM," ).append("\n"); 
		query.append("	REP_CMDT_CD" ).append("\n"); 
		query.append("FROM MDM_COMMODITY" ).append("\n"); 
		query.append("WHERE 	DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${cmdt_cd} != \"\")" ).append("\n"); 
		query.append("AND CMDT_CD LIKE @[cmdt_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cmdt_nm} != \"\") " ).append("\n"); 
		query.append("AND UPPER(CMDT_NM) LIKE '%' || UPPER(@[cmdt_nm]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY CMDT_CD, CMDT_NM" ).append("\n"); 

	}
}