/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : Turn Time by Port
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.04.24 박광석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.integration ;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.support.db.ISQLTemplate;

/** 
 *
 * @author Prak Kwang Seok
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class CIMCommonDBDAOTypeSizeSequenceVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public CIMCommonDBDAOTypeSizeSequenceVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("SELECT  DP_SEQ, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM    CIM_TP_SZ_DP_SEQ" ).append("\n"); 
		query.append("ORDER BY  DP_SEQ" ).append("\n"); 

	}
}