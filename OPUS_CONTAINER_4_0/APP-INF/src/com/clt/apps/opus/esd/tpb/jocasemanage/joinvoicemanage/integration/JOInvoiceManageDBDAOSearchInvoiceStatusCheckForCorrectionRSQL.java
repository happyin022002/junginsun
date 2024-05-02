/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOInvoiceManageDBDAOSearchInvoiceStatusCheckForCorrectionRSQL.java
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

public class JOInvoiceManageDBDAOSearchInvoiceStatusCheckForCorrectionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchInvoiceStatusCheckForCorrection
	  * </pre>
	  */
	public JOInvoiceManageDBDAOSearchInvoiceStatusCheckForCorrectionRSQL(){
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
		query.append("FileName : JOInvoiceManageDBDAOSearchInvoiceStatusCheckForCorrectionRSQL").append("\n"); 
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
		query.append("SELECT NVL(R.N3PTY_INV_STS_CD,'N') VALIDYN" ).append("\n"); 
		query.append("FROM TPB_INV_RVIS R, TPB_INVOICE V" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND R.N3PTY_INV_NO = V.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND V.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND R.N3PTY_INV_STS_CD IN ('A','C') /* A : 현재 버전 AR I/F; C : 현재 */" ).append("\n"); 
		query.append("AND R.N3PTY_INV_NO = @[s_n3pty_inv_no]" ).append("\n"); 

	}
}