/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOInvoiceDAOSearchInvoiceDetailNewSeqInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDAOSearchInvoiceDetailNewSeqInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FMS_INV_DTL New inv_dtl_seq 조회.
	  * </pre>
	  */
	public TCharterIOInvoiceDAOSearchInvoiceDetailNewSeqInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_iss_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOSearchInvoiceDetailNewSeqInfoRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(INV_DTL_SEQ)+1, 1) AS NEW_INV_DTL_SEQ" ).append("\n"); 
		query.append("  FROM FMS_INV_DTL" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("   AND FLET_ISS_TP_CD = @[flet_iss_tp_cd]" ).append("\n"); 
		query.append("   AND INV_SEQ = (CASE WHEN NVL(@[inv_seq],0) = 0 THEN (SELECT MAX(NVL(INV_SEQ,1))" ).append("\n"); 
		query.append("                                                  FROM FMS_INVOICE" ).append("\n"); 
		query.append("                                                 WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("                                                   AND FLET_ISS_TP_CD = @[flet_iss_tp_cd])" ).append("\n"); 
		query.append("                       ELSE TO_NUMBER(NVL(@[inv_seq],0))" ).append("\n"); 
		query.append("                  END)" ).append("\n"); 

	}
}