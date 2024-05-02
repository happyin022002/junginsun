/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SetupDBDAOVslClassSubCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.05
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.01.05 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.setup.setup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SetupDBDAOVslClassSubCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SetupDBDAOVslClassSubCodeRSQL
	  * </pre>
	  */
	public SetupDBDAOVslClassSubCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_vsl_clss_capa",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.setup.setup.integration").append("\n"); 
		query.append("FileName : SetupDBDAOVslClassSubCodeRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT T2.VSL_CLSS_SUB_CD FROM MDM_VSL_CNTR T1, FCM_VSL_CNTR_RGST T2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T1.VSL_CD=T2.VSL_CD" ).append("\n"); 
		query.append("AND T1.CNTR_DZN_CAPA=@[cntr_vsl_clss_capa]" ).append("\n"); 
		query.append("ORDER BY T2.VSL_CLSS_SUB_CD" ).append("\n"); 

	}
}