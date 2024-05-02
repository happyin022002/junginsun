/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : OPMasterDBDAOSearchVslCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.19
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.08.19 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OPMasterDBDAOSearchVslCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Insert 전 Vessel 등록 유무 check
	  * </pre>
	  */
	public OPMasterDBDAOSearchVslCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.integration").append("\n"); 
		query.append("FileName : OPMasterDBDAOSearchVslCountRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD " ).append("\n"); 
		query.append("  FROM COA_VSL_RGST		" ).append("\n"); 
		query.append(" WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 

	}
}