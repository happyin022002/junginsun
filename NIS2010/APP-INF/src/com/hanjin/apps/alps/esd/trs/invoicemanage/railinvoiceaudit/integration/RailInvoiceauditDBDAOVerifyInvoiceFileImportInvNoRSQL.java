/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RailInvoiceauditDBDAOVerifyInvoiceFileImportInvNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.08
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2015.01.08 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailInvoiceauditDBDAOVerifyInvoiceFileImportInvNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice 번호와 Vendor Code의 정합성 체크
	  * </pre>
	  */
	public RailInvoiceauditDBDAOVerifyInvoiceFileImportInvNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntrNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wblDt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("railRoadCode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.integration").append("\n"); 
		query.append("FileName : RailInvoiceauditDBDAOVerifyInvoiceFileImportInvNoRSQL").append("\n"); 
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
		query.append("SELECT																			" ).append("\n"); 
		query.append("	WRK.INV_NO,																	" ).append("\n"); 
		query.append("	DTL.EQ_NO																	" ).append("\n"); 
		query.append("FROM																			" ).append("\n"); 
		query.append("	TRS_TRSP_RAIL_INV_DTL DTL													" ).append("\n"); 
		query.append(",	TRS_TRSP_RAIL_INV_WRK WRK													" ).append("\n"); 
		query.append("WHERE																			" ).append("\n"); 
		query.append("	DTL.PAY_FLG						='Y'										" ).append("\n"); 
		query.append("AND WRK.TRSP_INV_AUD_STS_CD			IN ('RA','CF', 'AR', 'IF', 'PD')					" ).append("\n"); 
		query.append("AND DTL.EQ_NO						= @[cntrNo]											" ).append("\n"); 
		query.append("AND DTL.INV_VNDR_SEQ				= @[railRoadCode]											" ).append("\n"); 
		query.append("AND DTL.WBL_DT 						= TO_DATE(@[wblDt], 'YYYYMMDD') 					" ).append("\n"); 
		query.append("AND WRK.INV_NO						= DTL.INV_NO								" ).append("\n"); 
		query.append("AND WRK.INV_VNDR_SEQ				= DTL.INV_VNDR_SEQ" ).append("\n"); 

	}
}