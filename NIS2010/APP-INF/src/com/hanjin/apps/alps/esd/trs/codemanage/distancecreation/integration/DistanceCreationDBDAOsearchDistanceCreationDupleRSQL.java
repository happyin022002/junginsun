/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DistanceCreationDBDAOsearchDistanceCreationDupleRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2009.11.20 양봉준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.distancecreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DistanceCreationDBDAOsearchDistanceCreationDupleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDistanceCreationDuple
	  * </pre>
	  */
	public DistanceCreationDBDAOsearchDistanceCreationDupleRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.distancecreation.integration").append("\n"); 
		query.append("FileName : DistanceCreationDBDAOsearchDistanceCreationDupleRSQL").append("\n"); 
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
		query.append("count(*) duple2" ).append("\n"); 
		query.append("FROM TRS_AGMT_DIST A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.HJL_NO IS NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${fm_nod_cd} != '' && ${to_nod_cd} != '')" ).append("\n"); 
		query.append("AND A.fm_nod_cd = @[fm_nod_cd]" ).append("\n"); 
		query.append("AND A.to_nod_cd = @[to_nod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${fm_nod_cd} == '' || ${to_nod_cd} == '')" ).append("\n"); 
		query.append("AND 1=2" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}