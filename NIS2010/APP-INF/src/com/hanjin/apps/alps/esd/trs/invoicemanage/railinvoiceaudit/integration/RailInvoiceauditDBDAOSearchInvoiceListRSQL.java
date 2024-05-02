/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RailInvoiceauditDBDAOSearchInvoiceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.31
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.03.31 박준용
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

public class RailInvoiceauditDBDAOSearchInvoiceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchInvoiceList SELECT
	  * </pre>
	  */
	public RailInvoiceauditDBDAOSearchInvoiceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.integration").append("\n"); 
		query.append("FileName : RailInvoiceauditDBDAOSearchInvoiceListRSQL").append("\n"); 
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
		query.append("W.INV_VNDR_SEQ    ," ).append("\n"); 
		query.append("V.VNDR_ABBR_NM    ," ).append("\n"); 
		query.append("D.INV_ORG_NOD_NM  ," ).append("\n"); 
		query.append("D.INV_DEST_NOD_NM ," ).append("\n"); 
		query.append("D.INV_CURR_CD     ," ).append("\n"); 
		query.append("D.INV_BZC_AMT NON_BIL_INV_AMT ," ).append("\n"); 
		query.append("D.INV_BIL_AMT     ," ).append("\n"); 
		query.append("W.INV_NO          ," ).append("\n"); 
		query.append("W.TRSP_INV_AUD_STS_CD ," ).append("\n"); 
		query.append("CASE D.CRNT_TRSP_RAIL_INV_AUD_CD WHEN 'I' THEN CASE WHEN W.PAY_DT IS NOT NULL THEN 'Y' ELSE 'N' END ELSE 'N' END NON_BILL ," ).append("\n"); 
		query.append("TO_CHAR(D.WBL_DT , 'YYYYMMDD') WBL_DT ," ).append("\n"); 
		query.append("TO_CHAR(W.PAY_DT , 'YYYYMMDD') PAY_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_RAIL_INV_WRK W ," ).append("\n"); 
		query.append("MDM_VENDOR            V ," ).append("\n"); 
		query.append("TRS_TRSP_RAIL_INV_DTL D" ).append("\n"); 
		query.append("WHERE W.INV_NO       = D.INV_NO" ).append("\n"); 
		query.append("AND   W.DELT_FLG     ='N'" ).append("\n"); 
		query.append("AND   W.INV_VNDR_SEQ = D.INV_VNDR_SEQ" ).append("\n"); 
		query.append("AND   D.EQ_NO        = @[eq_no]" ).append("\n"); 
		query.append("AND   D.INV_VNDR_SEQ = @[rail_road_code]" ).append("\n"); 
		query.append("AND   V.VNDR_SEQ     = W.INV_VNDR_SEQ" ).append("\n"); 
		query.append("AND   D.LOCL_CRE_DT BETWEEN ADD_MONTHS(SYSDATE, -12) AND SYSDATE" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("WBL_DT ASC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}