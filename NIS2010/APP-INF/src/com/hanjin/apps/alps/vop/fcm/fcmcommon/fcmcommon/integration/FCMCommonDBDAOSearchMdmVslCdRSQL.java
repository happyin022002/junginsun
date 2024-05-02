/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : FCMCommonDBDAOSearchMdmVslCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.28
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.12.28 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.fcmcommon.fcmcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FCMCommonDBDAOSearchMdmVslCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM에 존재하는 vsl code인지 check한다.
	  * </pre>
	  */
	public FCMCommonDBDAOSearchMdmVslCdRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.vop.fcm.fcmcommon.fcmcommon.integration").append("\n"); 
		query.append("FileName : FCMCommonDBDAOSearchMdmVslCdRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${vsl_cd} != '') " ).append("\n"); 
		query.append("AND VSL_CD=@[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}