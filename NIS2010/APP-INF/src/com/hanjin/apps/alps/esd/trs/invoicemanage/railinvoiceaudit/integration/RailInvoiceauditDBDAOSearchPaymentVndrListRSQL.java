/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailInvoiceauditDBDAOSearchPaymentVndrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.08.27 박준용
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

public class RailInvoiceauditDBDAOSearchPaymentVndrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rail Invoice Payment Vendor 정보 조회
	  * </pre>
	  */
	public RailInvoiceauditDBDAOSearchPaymentVndrListRSQL(){
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
		params.put("railRoadCode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.integration").append("\n"); 
		query.append("FileName : RailInvoiceauditDBDAOSearchPaymentVndrListRSQL").append("\n"); 
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
		query.append("V.VNDR_SEQ," ).append("\n"); 
		query.append("V.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("COUNT(*)" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_RAIL_INV_WRK" ).append("\n"); 
		query.append("WHERE INV_NO = @[invNo]" ).append("\n"); 
		query.append("AND INV_VNDR_SEQ = V.PRNT_VNDR_SEQ" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append(") FLAG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_VENDOR V" ).append("\n"); 
		query.append("WHERE V.VNDR_SEQ = (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("PRNT_VNDR_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_VENDOR" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = @[railRoadCode]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}