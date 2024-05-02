/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RegionDBDAOTotalRegionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.region.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RegionDBDAOTotalRegionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public RegionDBDAOTotalRegionRSQL(){
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
		params.put("rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.region.integration").append("\n"); 
		query.append("FileName : RegionDBDAOTotalRegionRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM mdm_region A, mdm_country B" ).append("\n"); 
		query.append("WHERE 1 = 1 AND A.cnt_cd = B.cnt_cd" ).append("\n"); 
		query.append("AND nvl(A.delt_flg,'N') <> 'Y'" ).append("\n"); 
		query.append("#if (${cnt_cd} != '')" ).append("\n"); 
		query.append("AND A.cnt_cd like @[cnt_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rgn_cd} != '')" ).append("\n"); 
		query.append("AND A.rgn_cd like @[rgn_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND NVL(B.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 

	}
}