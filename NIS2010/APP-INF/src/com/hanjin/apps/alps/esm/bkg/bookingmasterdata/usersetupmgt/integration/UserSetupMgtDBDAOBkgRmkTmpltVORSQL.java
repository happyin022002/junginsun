/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 최용준
*@LastVersion : 1.0
* 2009.04.29 최용준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author choi yong jun
 * @see 
 * @since J2EE 1.4
 */

public class UserSetupMgtDBDAOBkgRmkTmpltVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SELECT
	  * </pre>
	  */
	public UserSetupMgtDBDAOBkgRmkTmpltVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmplt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("select" ).append("\n"); 
		query.append("usr_id," ).append("\n"); 
		query.append("tmplt_tp_cd," ).append("\n"); 
		query.append("tmplt_seq," ).append("\n"); 
		query.append("tmplt_hdr_nm," ).append("\n"); 
		query.append("tmplt_ctnt" ).append("\n"); 
		query.append("from bkg_usr_tmplt" ).append("\n"); 
		query.append("where	usr_id = @[usr_id]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : ${comment}").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOBkgRmkTmpltVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}