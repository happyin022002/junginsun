/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OpfUtilDBDAOSearchRHQCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.opfcommon.opfutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OpfUtilDBDAOSearchRHQCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RHQ Code List
	  * </pre>
	  */
	public OpfUtilDBDAOSearchRHQCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.opfcommon.opfutil.integration").append("\n"); 
		query.append("FileName : OpfUtilDBDAOSearchRHQCodeListRSQL").append("\n"); 
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
		query.append("SELECT   MO.OFC_CD			AS NAME" ).append("\n"); 
		query.append("FROM     MDM_ORGANIZATION 	MO" ).append("\n"); 
		query.append("WHERE    MO.OFC_KND_CD    	= '2'" ).append("\n"); 
		query.append("AND      MO.OFC_TP_CD     	= 'HQ'" ).append("\n"); 
		query.append("AND      MO.DELT_FLG      	= 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--SELECT OFC_CD AS NAME FROM TABLE ( COM_OfficeCodeMgr_PKG.COM_getOfficeCodeList_FNC('000004', 'COM'))" ).append("\n"); 

	}
}