/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonCodeDBDAOSearchTPBSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.12
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.11.12 최 선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.common.combo.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonCodeDBDAOSearchTPBSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTPBSeq
	  * </pre>
	  */
	public CommonCodeDBDAOSearchTPBSeqRSQL(){
		SetQuery();
		
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.common.combo.integration ").append("\n"); 
		query.append("FileName : CommonCodeDBDAOSearchTPBSeqRSQL").append("\n"); 
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
	public void SetQuery(){
		query.append("SELECT tpb_ots_dtl_seq1.NEXTVAL AS ots_dtl_seq" ).append("\n");
		query.append("  FROM DUAL" ).append("\n");
		query.append(" WHERE ROWNUM = 1" ).append("\n");
	}
}