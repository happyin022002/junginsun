/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.04.27 박광석
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

public class CIMCommonDBDAOCIMCommonDBCheckLocationMdmYardRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public CIMCommonDBDAOCIMCommonDBCheckLocationMdmYardRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locCD",new String[]{arrTmp[0],arrTmp[1]});
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
		query.append("SELECT YD_CD " ).append("\n"); 
		query.append("FROM  MDM_YARD" ).append("\n"); 
		query.append("WHERE YD_CD = @[locCD]" ).append("\n"); 
	}
}