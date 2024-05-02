/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReceiveQueueMdmZnDtlDBDAOMdmZnDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.10.05 김귀진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kIm kwi-jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueMdmZnDtlDBDAOMdmZnDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MdmZnDtl
	  * </pre>
	  */
	public ReceiveQueueMdmZnDtlDBDAOMdmZnDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.mdmSync.jms.integration ").append("\n"); 
		query.append("FileName : ReceiveQueueMdmZnDtlDBDAOMdmZnDtlRSQL").append("\n"); 
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
		query.append("zn_cd	   ,zn_seq	   ,zip_cd     ,dstr_nm    ,cre_usr_id ," ).append("\n"); 
		query.append("cre_dt     ,upd_usr_id ,upd_dt     ,eai_evnt_dt" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM mdm_zn_dtl" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("ROWNUM = 1" ).append("\n"); 

	}
}