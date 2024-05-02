/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RailInvoiceauditDBDAOVerifyInvoiceFileImportInvNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_road_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wbl_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.integration").append("\n"); 
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
		query.append("SELECT WRK.INV_NO" ).append("\n"); 
		query.append("      ,DTL.EQ_NO" ).append("\n"); 
		query.append("  FROM TRS_TRSP_RAIL_INV_DTL DTL" ).append("\n"); 
		query.append("      ,TRS_TRSP_RAIL_INV_WRK WRK" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND WRK.TRSP_INV_AUD_STS_CD IN ('SV','CF', 'AR', 'IF', 'PD')" ).append("\n"); 
		query.append("   AND DTL.EQ_NO LIKE CASE WHEN LENGTH(@[cntr_no]) >= 10 THEN SUBSTR(@[cntr_no], 0, 10) || '%' END" ).append("\n"); 
		query.append("   AND DTL.INV_VNDR_SEQ = @[rail_road_code]" ).append("\n"); 
		query.append("   AND DTL.WBL_DT = TO_DATE(@[wbl_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("   AND WRK.INV_NO = DTL.INV_NO" ).append("\n"); 
		query.append("   AND WRK.INV_VNDR_SEQ = DTL.INV_VNDR_SEQ" ).append("\n"); 

	}
}