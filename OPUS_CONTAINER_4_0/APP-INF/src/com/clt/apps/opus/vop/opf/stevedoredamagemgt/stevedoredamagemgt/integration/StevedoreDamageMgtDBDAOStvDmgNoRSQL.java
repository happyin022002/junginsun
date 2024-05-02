/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOStvDmgNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.13
*@LastModifier : 이석준
*@LastVersion : 1.0
* 2010.10.13 이석준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Joon(Suk-Joon) LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StevedoreDamageMgtDBDAOStvDmgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Stv_Dmg_No Select Query.
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOStvDmgNoRSQL(){
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
		query.append("Path : com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration").append("\n"); 
		query.append("FileName : StevedoreDamageMgtDBDAOStvDmgNoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	lpad(NVL(MAX(SUBSTR(STV_DMG_NO,9,3)),0)+1,3,'0') AS STV_DMG_SEQ " ).append("\n"); 
		query.append("FROM OPF_STV_DMG" ).append("\n"); 
		query.append("WHERE	STV_DMG_NO LIKE @[vsl_cd]||'%'" ).append("\n"); 

	}
}