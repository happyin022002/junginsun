/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CommonDBDAOCheckVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.10
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOCheckVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력된 항차가 KRPUS를 기항하는지 확인한다.
	  * </pre>
	  */
	public CommonDBDAOCheckVvdRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.spc.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOCheckVvdRSQL").append("\n"); 
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
		query.append("SELECT NVL(SUM(1) , 0)" ).append("\n"); 
		query.append("  FROM VSK_VSL_SKD V" ).append("\n"); 
		query.append(" WHERE V.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND V.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND V.SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 'A' " ).append("\n"); 
		query.append("                 FROM VSK_PF_SKD_DTL D" ).append("\n"); 
		query.append("                WHERE D.VSL_SLAN_CD  = V.VSL_SLAN_CD" ).append("\n"); 
		query.append("                  AND D.PF_SVC_TP_CD = V.PF_SKD_TP_CD" ).append("\n"); 
		query.append("                  AND D.SKD_DIR_CD   = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND D.PORT_CD      = 'KRPUS')" ).append("\n"); 

	}
}