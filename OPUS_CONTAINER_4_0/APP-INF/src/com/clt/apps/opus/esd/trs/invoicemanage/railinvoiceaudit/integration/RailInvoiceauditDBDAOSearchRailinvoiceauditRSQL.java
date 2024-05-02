/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailInvoiceauditDBDAOSearchRailinvoiceauditRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.09.09 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailInvoiceauditDBDAOSearchRailinvoiceauditRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RailInvoice에 대한 Vendor, Rate 조회
	  * </pre>
	  */
	public RailInvoiceauditDBDAOSearchRailinvoiceauditRSQL(){
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
		params.put("invVndrSeq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.integration").append("\n"); 
		query.append("FileName : RailInvoiceauditDBDAOSearchRailinvoiceauditRSQL").append("\n"); 
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
		query.append("TRSP_INV_AUD_STS_CD," ).append("\n"); 
		query.append("WO_VNDR_SEQ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_VENDOR" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = WO_VNDR_SEQ" ).append("\n"); 
		query.append(") WO_VNDR_NM," ).append("\n"); 
		query.append("INV_VNDR_SEQ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_VENDOR" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = INV_VNDR_SEQ" ).append("\n"); 
		query.append(") INV_VNDR_NM," ).append("\n"); 
		query.append("TO_CHAR(INV_RCV_DT, 'YYYYMMDD') INV_RCV_DT," ).append("\n"); 
		query.append("TO_CHAR(INV_ISS_DT, 'YYYYMMDD') INV_ISS_DT," ).append("\n"); 
		query.append("INV_CURR_CD," ).append("\n"); 
		query.append("INV_BZC_AMT," ).append("\n"); 
		query.append("INV_VAT_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_RAIL_INV_WRK" ).append("\n"); 
		query.append("WHERE INV_NO = @[invNo]" ).append("\n"); 
		query.append("AND   INV_VNDR_SEQ = @[invVndrSeq]" ).append("\n"); 
		query.append("AND   DELT_FLG = 'N'" ).append("\n"); 

	}
}