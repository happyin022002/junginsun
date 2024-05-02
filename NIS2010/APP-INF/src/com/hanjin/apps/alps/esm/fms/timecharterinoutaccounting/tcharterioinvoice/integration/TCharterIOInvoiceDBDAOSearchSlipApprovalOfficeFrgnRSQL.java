/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TCharterIOInvoiceDBDAOSearchSlipApprovalOfficeFrgnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDBDAOSearchSlipApprovalOfficeFrgnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Slip Approval 승인 시에 Office 및 User 테이블에서 필요 항목 조회한다
	  * </pre>
	  */
	public TCharterIOInvoiceDBDAOSearchSlipApprovalOfficeFrgnRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDBDAOSearchSlipApprovalOfficeFrgnRSQL").append("\n"); 
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
		query.append("SELECT O.FINC_RGN_CD, O.AP_CTR_CD, O.AR_HD_QTR_OFC_CD, U.USR_NM, U.OFC_CD, U.USR_EML" ).append("\n"); 
		query.append("FROM   MDM_ORGANIZATION O, COM_USER U" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND   (U.USR_ID = @[usr_id] OR U.EP_ID = @[usr_id])" ).append("\n"); 
		query.append("AND    U.OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 

	}
}