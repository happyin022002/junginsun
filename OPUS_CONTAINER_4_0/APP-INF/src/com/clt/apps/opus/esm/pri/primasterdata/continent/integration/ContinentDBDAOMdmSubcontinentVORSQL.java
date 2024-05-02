/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContinentDBDAOMdmSubcontinentVORSQL.java
*@FileTitle : Continent-Subcontinent Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.14 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.continent.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JaeYeon Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContinentDBDAOMdmSubcontinentVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ContinentDBDAOMdmSubcontinentVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.primasterdata.continent.integration").append("\n"); 
		query.append("FileName : ContinentDBDAOMdmSubcontinentVORSQL").append("\n"); 
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
		query.append("SCONTI_CD" ).append("\n"); 
		query.append(",	SCONTI_NM" ).append("\n"); 
		query.append("FROM MDM_SUBCONTINENT" ).append("\n"); 
		query.append("WHERE	CONTI_CD = @[conti_cd]" ).append("\n"); 
		query.append("AND	DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY SCONTI_CD" ).append("\n"); 

	}
}