/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InterfaceScheduleToExternalScnDBDAOCheckExistKntForSpecificVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternalscn.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceScheduleToExternalScnDBDAOCheckExistKntForSpecificVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD 존재유무체크
	  * </pre>
	  */
	public InterfaceScheduleToExternalScnDBDAOCheckExistKntForSpecificVVDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternalscn.integration").append("\n"); 
		query.append("FileName : InterfaceScheduleToExternalScnDBDAOCheckExistKntForSpecificVVDRSQL").append("\n"); 
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
		query.append("SELECT		COUNT(1)			AS KNT" ).append("\n"); 
		query.append("FROM		VSK_VSL_SKD			VS" ).append("\n"); 
		query.append("WHERE		VS.VSL_CD			= @[vsl_cd]" ).append("\n"); 
		query.append("AND			VS.SKD_VOY_NO		= @[skd_voy_no]" ).append("\n"); 
		query.append("AND			VS.SKD_DIR_CD		= @[skd_dir_cd]" ).append("\n"); 

	}
}