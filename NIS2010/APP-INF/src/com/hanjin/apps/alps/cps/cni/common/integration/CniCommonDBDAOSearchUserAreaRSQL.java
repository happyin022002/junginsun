/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CniCommonDBDAOSearchUserAreaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.03.09 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.common.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CniCommonDBDAOSearchUserAreaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 사용자 AREA
	  * </pre>
	  */
	public CniCommonDBDAOSearchUserAreaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.common.integration ").append("\n"); 
		query.append("FileName : CniCommonDBDAOSearchUserAreaRSQL").append("\n"); 
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
		query.append("    CLM_AREA_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    CNI_AREA_OFC" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    OFC_CD = @[ofc_cd]" ).append("\n"); 

	}
}