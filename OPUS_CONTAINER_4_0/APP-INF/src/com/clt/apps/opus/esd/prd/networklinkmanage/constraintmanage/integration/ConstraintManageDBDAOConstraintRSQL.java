/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ConstraintManageDBDAOConstraintRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.08.18 김귀진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kIm kwi-jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintManageDBDAOConstraintRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Constraint
	  * </pre>
	  */
	public ConstraintManageDBDAOConstraintRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.integration ").append("\n"); 
		query.append("FileName : ConstraintManageDBDAOConstraintRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' loc" ).append("\n"); 
		query.append(",'' from_nd" ).append("\n"); 
		query.append(",'' to_nd" ).append("\n"); 
		query.append(",'' tlane" ).append("\n"); 
		query.append(",'' dir_cd" ).append("\n"); 
		query.append(",'' pol" ).append("\n"); 
		query.append(",'' tsport" ).append("\n"); 
		query.append(",'' pod" ).append("\n"); 
		query.append(",'' del" ).append("\n"); 
		query.append(",'' link_flg" ).append("\n"); 
		query.append(",'' svc" ).append("\n"); 
		query.append(",'' select1" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}