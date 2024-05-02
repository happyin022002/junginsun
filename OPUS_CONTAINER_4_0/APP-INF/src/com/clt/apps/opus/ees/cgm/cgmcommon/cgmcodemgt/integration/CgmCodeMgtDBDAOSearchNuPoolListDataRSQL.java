/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CgmCodeMgtDBDAOSearchNuPoolListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.03.24 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmCodeMgtDBDAOSearchNuPoolListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CgmCodeMgtDB.SearchMovementStatusListData
	  * </pre>
	  */
	public CgmCodeMgtDBDAOSearchNuPoolListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.integration").append("\n"); 
		query.append("FileName : CgmCodeMgtDBDAOSearchNuPoolListDataRSQL").append("\n"); 
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
		query.append("SELECT  AGMT_OFC_CTY_CD||LPAD(A.AGMT_SEQ,6,'0')  AS CODE1" ).append("\n"); 
		query.append(", A.AGMT_REF_NO   || ' ' ||   B.VNDR_LGL_ENG_NM AS DESC1" ).append("\n"); 
		query.append("FROM CGM_AGREEMENT A" ).append("\n"); 
		query.append(", MDM_VENDOR  B" ).append("\n"); 
		query.append("WHERE A.AGMT_LSTM_CD='NP'" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("AND A.LST_VER_FLG ='Y'" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 

	}
}