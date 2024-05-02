/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VoyagePerformanceMgtDBDAOCheckVvdInvalidRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.voyageperformancemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VoyagePerformanceMgtDBDAOCheckVvdInvalidRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD 유효성검사
	  * </pre>
	  */
	public VoyagePerformanceMgtDBDAOCheckVvdInvalidRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.voyageperformancemgt.integration").append("\n"); 
		query.append("FileName : VoyagePerformanceMgtDBDAOCheckVvdInvalidRSQL").append("\n"); 
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
		query.append("SELECT   COUNT(1) AS VVD_RTN" ).append("\n"); 
		query.append("FROM     VSK_VSL_SKD   X" ).append("\n"); 
		query.append("WHERE    X.VSL_CD      = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND      X.SKD_VOY_NO  = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND      X.SKD_DIR_CD  = SUBSTR(@[vvd],9)" ).append("\n"); 

	}
}