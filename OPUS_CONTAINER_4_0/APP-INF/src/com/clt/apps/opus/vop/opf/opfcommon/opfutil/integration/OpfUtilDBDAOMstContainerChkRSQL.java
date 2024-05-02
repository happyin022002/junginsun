/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OpfUtilDBDAOMstContainerChkRSQL.java
*@FileTitle : Basic Information for Loading Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.23
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.12.23 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.opfcommon.opfutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OpfUtilDBDAOMstContainerChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MST_CONTAINER 테이블에서 Container No의 Validation을 Check한다.
	  * </pre>
	  */
	public OpfUtilDBDAOMstContainerChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.opfcommon.opfutil.integration").append("\n"); 
		query.append("FileName : OpfUtilDBDAOMstContainerChkRSQL").append("\n"); 
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
		query.append("SELECT 	C.CNTR_NO AS VAL" ).append("\n"); 
		query.append("FROM 	MST_CONTAINER C" ).append("\n"); 
		query.append("WHERE 	C.CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}