/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ManualARCreationDBDAOsearchMRIInterfaceNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualARCreationDBDAOsearchMRIInterfaceNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ManualARCreationDBDAOsearchMRIInterfaceNoRSQL
	  * </pre>
	  */
	public ManualARCreationDBDAOsearchMRIInterfaceNoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration").append("\n"); 
		query.append("FileName : ManualARCreationDBDAOsearchMRIInterfaceNoRSQL").append("\n"); 
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
		query.append("SELECT IF_PFX_CD||'M'||SUBSTR(IF_YR, 3, 2)||TO_CHAR(LPAD(MRI_MAX_SEQ + 1, 5, '0'))  MRI_MAX_SEQ" ).append("\n"); 
		query.append("FROM INV_AR_MRI_IF_NO" ).append("\n"); 
		query.append("WHERE IF_PFX_CD = SUBSTR(@[ofc_cd], 1, 3)" ).append("\n"); 
		query.append("AND IF_YR = TO_CHAR(SYSDATE, 'YYYY')" ).append("\n"); 
		query.append("FOR UPDATE" ).append("\n"); 

	}
}