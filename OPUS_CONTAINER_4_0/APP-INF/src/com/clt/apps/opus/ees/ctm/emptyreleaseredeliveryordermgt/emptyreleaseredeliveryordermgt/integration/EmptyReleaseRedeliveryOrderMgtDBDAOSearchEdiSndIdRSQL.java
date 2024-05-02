/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchEdiSndIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.07
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseRedeliveryOrderMgtDBDAOSearchEdiSndIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI를 전송할 Sender Id를 조회
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOSearchEdiSndIdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchEdiSndIdRSQL").append("\n"); 
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
		query.append("SELECT SNDR_TRD_PRNR_ID HOST_TP_ID" ).append("\n"); 
		query.append("  FROM BKG_EDI_TRD_PRNR_SUB_LNK EY" ).append("\n"); 
		query.append("                            , BKG_EDI_SUB_LNK_MSG MSG" ).append("\n"); 
		query.append(" WHERE EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("   AND EY.RCVR_TRD_PRNR_ID = @[rcv_id]" ).append("\n"); 
		query.append("   AND EDI_MSG_TP_ID <> 'COPRAR'" ).append("\n"); 
		query.append("   AND MSG_TP_DESC   = '1'" ).append("\n"); 
		query.append("   AND rownum        = 1    " ).append("\n"); 

	}
}