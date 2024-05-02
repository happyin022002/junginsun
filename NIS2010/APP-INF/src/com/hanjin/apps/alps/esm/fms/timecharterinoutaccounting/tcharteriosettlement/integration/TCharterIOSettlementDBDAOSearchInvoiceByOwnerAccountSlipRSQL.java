/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOSettlementDBDAOSearchInvoiceByOwnerAccountSlipRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.06.11 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOSettlementDBDAOSearchInvoiceByOwnerAccountSlipRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Invoice by Owner Account Slip
	  * </pre>
	  */
	public TCharterIOSettlementDBDAOSearchInvoiceByOwnerAccountSlipRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT 	(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL CD WHERE INTG_CD_ID = 'CD01513' AND INTG_CD_VAL_CTNT = FLET_CTRT_TP_CD) FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("FROM 	FMS_CONTRACT FC" ).append("\n"); 
		query.append("WHERE 	FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.fms.timecharterinoutaccounting.tcharteriosettlement.integration").append("\n"); 
		query.append("FileName : TCharterIOSettlementDBDAOSearchInvoiceByOwnerAccountSlipRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}