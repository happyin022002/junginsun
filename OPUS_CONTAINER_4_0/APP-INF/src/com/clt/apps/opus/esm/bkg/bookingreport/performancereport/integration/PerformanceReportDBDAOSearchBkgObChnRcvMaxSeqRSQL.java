/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchBkgObChnRcvMaxSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.23
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.08.23 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjeong Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchBkgObChnRcvMaxSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBkgObChnRcvMaxSeq
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchBkgObChnRcvMaxSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_rcv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chn_edi_msg_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchBkgObChnRcvMaxSeqRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(RCV_LOG_SEQ) ,0) AS RCV_LOG_SEQ" ).append("\n"); 
		query.append("  FROM BKG_OB_CHN_RCV" ).append("\n"); 
		query.append(" WHERE CHN_EDI_MSG_TP_ID = @[chn_edi_msg_tp_id]" ).append("\n"); 
		query.append("   AND MSG_RCV_NO = @[msg_rcv_no]" ).append("\n"); 

	}
}