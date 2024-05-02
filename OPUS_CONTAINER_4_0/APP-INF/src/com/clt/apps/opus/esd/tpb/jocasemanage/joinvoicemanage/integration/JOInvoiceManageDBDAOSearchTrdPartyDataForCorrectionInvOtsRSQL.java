/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOInvoiceManageDBDAOSearchTrdPartyDataForCorrectionInvOtsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2010.02.22 변종건
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Geon Byeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOInvoiceManageDBDAOSearchTrdPartyDataForCorrectionInvOtsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTrdPartyDataForCorrectionInvOts
	  * </pre>
	  */
	public JOInvoiceManageDBDAOSearchTrdPartyDataForCorrectionInvOtsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.integration").append("\n"); 
		query.append("FileName : JOInvoiceManageDBDAOSearchTrdPartyDataForCorrectionInvOtsRSQL").append("\n"); 
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
		query.append("SELECT B.N3PTY_NO" ).append("\n"); 
		query.append(",C.OTS_STS_CD" ).append("\n"); 
		query.append("FROM TPB_OTS_GRP B" ).append("\n"); 
		query.append(",TPB_OTS_GRP_STS C" ).append("\n"); 
		query.append("WHERE N3PTY_INV_NO = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("AND B.N3PTY_NO = C.N3PTY_NO" ).append("\n"); 
		query.append("AND C.OTS_STS_LST_FLG = 'Y'" ).append("\n"); 

	}
}