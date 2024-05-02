/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TOTFindCodeDBDAOTotLaneByTrdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.07
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.12.07 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Chang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TOTFindCodeDBDAOTotLaneByTrdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * trade에 해당하는 lane을 조회
	  * </pre>
	  */
	public TOTFindCodeDBDAOTotLaneByTrdVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("super_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("super_cd1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.integration").append("\n"); 
		query.append("FileName : TOTFindCodeDBDAOTotLaneByTrdVORSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A.VSL_SLAN_CD CODE" ).append("\n"); 
		query.append("FROM TOT_LANE_TRD A, TOT_LANE B" ).append("\n"); 
		query.append("WHERE A.STL_YRMON = @[super_cd1]" ).append("\n"); 
		query.append("AND A.TRD_CD = @[super_cd2]" ).append("\n"); 
		query.append("AND A.VSL_SLAN_CD = B.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND B.DELT_FLG ='N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY A.VSL_SLAN_CD" ).append("\n"); 

	}
}