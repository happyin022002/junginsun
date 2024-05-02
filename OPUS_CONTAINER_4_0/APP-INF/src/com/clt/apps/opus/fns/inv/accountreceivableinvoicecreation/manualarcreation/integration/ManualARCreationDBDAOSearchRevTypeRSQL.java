/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.05.19 정휘택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Hwi Taek
 * @see 
 * @since J2EE 1.4
 */

public class ManualARCreationDBDAOSearchRevTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRevType
	  * </pre>
	  */
	public ManualARCreationDBDAOSearchRevTypeRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT NVL(TML_INV_ISS_FLG, 'N') TML_INV_ISS_FLG" ).append("\n"); 
		query.append("FROM INV_AR_STUP_OFC" ).append("\n"); 
		query.append("WHERE AR_OFC_CD = NVL(@[ofc_cd], '')" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration").append("\n"); 
		query.append("FileName : ManualARCreationDBDAOSearchRevTypeRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}