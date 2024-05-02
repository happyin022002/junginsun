/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.23
*@LastModifier : 김정훈
*@LastVersion : 1.0
* 2009.04.23 김정훈
* 1.0 Creation
=========================================================*/
package com.hanjin.sample.basic ;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong-Hoon, Kim
 * @see 
 * @since J2EE 1.4 
 */
public class GlobalTransactionISQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI 로 각 모듈별 정보를 전송 후 그 이력을 생성하는 쿼리
	  * </pre>
	  */
	public GlobalTransactionISQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.sample.ftp.send.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOAddEDIHistoryCSQL").append("\n"); 
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
		query.append("insert into enis_log values (sysdate, '1','1','1')" ).append("\n"); 

	}
}