/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RegionDBDAOSearchRegionListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.06
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2010.07.06 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.region.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HAM DAE SUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RegionDBDAOSearchRegionListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public RegionDBDAOSearchRegionListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.region.integration").append("\n"); 
		query.append("FileName : RegionDBDAOSearchRegionListRSQL").append("\n"); 
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
		query.append("SELECT rgn_cd," ).append("\n"); 
		query.append("rgn_nm," ).append("\n"); 
		query.append("cnt_cd," ).append("\n"); 
		query.append("sconti_cd" ).append("\n"); 
		query.append("FROM (	SELECT ROW_NUMBER() OVER (ORDER BY A.rgn_cd ASC) no," ).append("\n"); 
		query.append("A.rgn_cd," ).append("\n"); 
		query.append("A.rgn_nm," ).append("\n"); 
		query.append("A.cnt_cd," ).append("\n"); 
		query.append("B.sconti_cd" ).append("\n"); 
		query.append("FROM mdm_region A, mdm_country B" ).append("\n"); 
		query.append("WHERE 1 = 1 AND A.cnt_cd = B.cnt_cd" ).append("\n"); 
		query.append("AND nvl(A.delt_flg,'N') <> 'Y'" ).append("\n"); 
		query.append("#if (${cnt_cd} != '')" ).append("\n"); 
		query.append("AND A.cnt_cd like @[cnt_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rgn_cd} != '')" ).append("\n"); 
		query.append("AND A.rgn_cd like @[rgn_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") a" ).append("\n"); 
		query.append("WHERE no BETWEEN @[startpart] AND @[endpart]" ).append("\n"); 

	}
}