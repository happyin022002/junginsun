/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActualCustomerPopupDBDAOSearchActualCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.common.actualcustomerpopup.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualCustomerPopupDBDAOSearchActualCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Actual Customer Popup에서 Customer 조회
	  * </pre>
	  */
	public ActualCustomerPopupDBDAOSearchActualCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sUSACustNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acCustSeq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acCustCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.common.actualcustomerpopup.integration ").append("\n"); 
		query.append("FileName : ActualCustomerPopupDBDAOSearchActualCustomerRSQL").append("\n"); 
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
		query.append("#if (${sCustInfoIndicator} == 'EUR')" ).append("\n"); 
		query.append("SELECT  A.ACT_CUST_ADDR_SEQ" ).append("\n"); 
		query.append(",A.FCTRY_NM" ).append("\n"); 
		query.append(",A.CNTC_PSON_NM" ).append("\n"); 
		query.append(",A.FCTRY_ADDR" ).append("\n"); 
		query.append(",A.ACT_CUST_PST_CD" ).append("\n"); 
		query.append(",A.CNTC_PSON_PHN_NO" ).append("\n"); 
		query.append(",A.CNTC_PSON_FAX_NO" ).append("\n"); 
		query.append(",A.CNTC_PSON_REQ_RMK" ).append("\n"); 
		query.append("FROM    TRS_TRSP_ACT_CUST_ADDR A" ).append("\n"); 
		query.append("WHERE   A.ACT_CUST_CNT_CD  = @[acCustCd]" ).append("\n"); 
		query.append("AND     A.ACT_CUST_SEQ     = @[acCustSeq]" ).append("\n"); 
		query.append("#elseif (${sCustInfoIndicator} == 'XEUR')" ).append("\n"); 
		query.append("SELECT   D.DFLT_ACT_CUST_FLG     IBCHECK" ).append("\n"); 
		query.append(", D.TRSP_ACT_CUST_SEQ     ACT_CUST_ADDR_SEQ" ).append("\n"); 
		query.append(", D.ACT_CUST_NM       FCTRY_NM" ).append("\n"); 
		query.append(", D.CNTC_PSON_NM        CNTC_PSON_NM" ).append("\n"); 
		query.append(", D.ACT_CUST_ADDR       FCTRY_ADDR" ).append("\n"); 
		query.append(", D.ACT_CUST_ZIP_CD     ACT_CUST_PST_CD" ).append("\n"); 
		query.append(", D.ACT_CUST_PHN_NO     CNTC_PSON_PHN_NO" ).append("\n"); 
		query.append(", D.ACT_CUST_FAX_NO     CNTC_PSON_FAX_NO" ).append("\n"); 
		query.append(", D.ACT_CUST_RMK        CNTC_PSON_REQ_RMK" ).append("\n"); 
		query.append("FROM     TRS_TRSP_USA_ACT_CUST_DTL   D" ).append("\n"); 
		query.append("WHERE    D.TRSP_ACT_CUST_NO  = @[sUSACustNo]" ).append("\n"); 
		query.append("AND      D.DELT_FLG          = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}