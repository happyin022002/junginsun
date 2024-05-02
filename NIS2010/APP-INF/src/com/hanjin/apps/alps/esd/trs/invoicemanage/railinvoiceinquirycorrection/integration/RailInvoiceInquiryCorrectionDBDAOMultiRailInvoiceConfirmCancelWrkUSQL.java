/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailInvoiceInquiryCorrectionDBDAOMultiRailInvoiceConfirmCancelWrkUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.11.20 박준용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceinquirycorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailInvoiceInquiryCorrectionDBDAOMultiRailInvoiceConfirmCancelWrkUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * multiRailInvoiceConfirmCancel UPDATE
	  * </pre>
	  */
	public RailInvoiceInquiryCorrectionDBDAOMultiRailInvoiceConfirmCancelWrkUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usrOfcCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usrId",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invAudStsCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceinquirycorrection.integration").append("\n"); 
		query.append("FileName : RailInvoiceInquiryCorrectionDBDAOMultiRailInvoiceConfirmCancelWrkUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_RAIL_INV_WRK" ).append("\n"); 
		query.append("SET    TRSP_INV_AUD_STS_CD = @[invAudStsCd]," ).append("\n"); 
		query.append("INV_HLD_FLG         = 'N'," ).append("\n"); 
		query.append("UPD_USR_ID          = @[usrId]," ).append("\n"); 
		query.append("LOCL_UPD_DT         = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[usrOfcCd])" ).append("\n"); 
		query.append("WHERE  INV_NO              = @[inv_no]" ).append("\n"); 
		query.append("AND    INV_VNDR_SEQ        = @[inv_vndr_seq]" ).append("\n"); 

	}
}