/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : INVCommonDBDAOSearchVslNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.invcommon.invcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class INVCommonDBDAOSearchVslNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchVslName
	  * </pre>
	  */
	public INVCommonDBDAOSearchVslNameRSQL(){
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
		query.append("Path : com.clt.apps.opus.fns.inv.invcommon.invcommon.integration ").append("\n"); 
		query.append("FileName : INVCommonDBDAOSearchVslNameRSQL").append("\n"); 
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
		query.append("SELECT A.VSL_ENG_NM" ).append("\n"); 
		query.append("FROM   MDM_VSL_CNTR A, VSK_VSL_SKD B" ).append("\n"); 
		query.append("WHERE  A.VSL_CD = B.VSL_CD " ).append("\n"); 
		query.append("AND    B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD = @[vvd]" ).append("\n"); 
		query.append("AND    A.DELT_FLG = 'N'" ).append("\n"); 

	}
}