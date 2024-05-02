/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchEdiRcvIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.16
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2012.08.16 문동선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dongsun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseRedeliveryOrderMgtDBDAOSearchEdiRcvIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI를 전송할 Reciever Id를 조회
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOSearchEdiRcvIdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchEdiRcvIdRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT EY.RCVR_TRD_PRNR_ID AS EDI_RCV_ID" ).append("\n"); 
		query.append("     , EY.PRNR_PORT_CD AS PORT_CD" ).append("\n"); 
		query.append("     , EY.PRNR_SUB_LNK_CD AS YD_CD" ).append("\n"); 
		query.append("  FROM BKG_EDI_TRD_PRNR_SUB_LNK EY" ).append("\n"); 
		query.append("     , BKG_EDI_SUB_LNK_MSG MSG" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("   AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("   AND EY.PRNR_SUB_LNK_DIV_CD = '1'" ).append("\n"); 
		query.append("   AND MSG.EDI_MSG_TP_ID      in ('301', 'RELRED')" ).append("\n"); 
		query.append("   AND MSG.MSG_TP_DESC = '1'" ).append("\n"); 
		query.append("   AND EY.PRNR_SUB_LNK_CD = @[yard_cd]" ).append("\n"); 
		query.append("   and MSG.EDI_MSG_IND_CD IN ('1', '2', '21')" ).append("\n"); 

	}
}