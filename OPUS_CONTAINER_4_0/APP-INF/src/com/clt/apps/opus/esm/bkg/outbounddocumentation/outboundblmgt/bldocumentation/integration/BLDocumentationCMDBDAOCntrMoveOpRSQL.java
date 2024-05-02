/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLDocumentationCMDBDAOCntrMoveOpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.25
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.06.25 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOCntrMoveOpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Movement 에서 Status 가 OP 로 전송되는 대상 조회
	  * </pre>
	  */
	public BLDocumentationCMDBDAOCntrMoveOpRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration ").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOCntrMoveOpRSQL").append("\n"); 
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
		query.append("/* CntrMoveOpInfoVO */" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	'' BKG_NO," ).append("\n"); 
		query.append("	'' CNTR_NO," ).append("\n"); 
		query.append("	'' MVMT_STS_CD," ).append("\n"); 
		query.append("	'' CFM_FLG" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}