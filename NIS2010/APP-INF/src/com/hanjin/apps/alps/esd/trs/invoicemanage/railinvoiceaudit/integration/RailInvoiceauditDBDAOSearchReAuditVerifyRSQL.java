/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailInvoiceauditDBDAOSearchReAuditVerifyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.09.03 박준용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailInvoiceauditDBDAOSearchReAuditVerifyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ReAudit에 대한 Verify 조회
	  * </pre>
	  */
	public RailInvoiceauditDBDAOSearchReAuditVerifyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wbl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("railRoadCode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.integration").append("\n"); 
		query.append("FileName : RailInvoiceauditDBDAOSearchReAuditVerifyRSQL").append("\n"); 
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
		query.append("WRK.INV_NO," ).append("\n"); 
		query.append("DTL.EQ_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_RAIL_INV_DTL DTL" ).append("\n"); 
		query.append(",	TRS_TRSP_RAIL_INV_WRK WRK" ).append("\n"); 
		query.append("WHERE DTL.PAY_FLG				='Y'" ).append("\n"); 
		query.append("AND   WRK.TRSP_INV_AUD_STS_CD	IN ('CF', 'AR', 'IF','PD')" ).append("\n"); 
		query.append("AND   DTL.EQ_NO					= @[eq_no]" ).append("\n"); 
		query.append("AND   DTL.WBL_DT 				= TO_DATE(@[wbl_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("AND   WRK.INV_NO				= DTL.INV_NO" ).append("\n"); 
		query.append("AND   WRK.INV_VNDR_SEQ			= DTL.INV_VNDR_SEQ" ).append("\n"); 
		query.append("AND	  WRK.INV_VNDR_SEQ			=  @[railRoadCode]" ).append("\n"); 
		query.append("AND	  WRK.INV_NO				<> @[invNo]" ).append("\n"); 

	}
}