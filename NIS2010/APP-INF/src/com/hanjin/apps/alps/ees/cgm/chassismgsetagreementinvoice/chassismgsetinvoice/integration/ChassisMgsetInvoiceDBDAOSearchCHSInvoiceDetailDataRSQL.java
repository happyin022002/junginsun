/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOSearchCHSInvoiceDetailDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.09.23 김창식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM CHANG SIK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOSearchCHSInvoiceDetailDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetInvoiceDB.SearchCHSInvoiceDetailData
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOSearchCHSInvoiceDetailDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration ").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOSearchCHSInvoiceDetailDataRSQL").append("\n"); 
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
		query.append("A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6,'0') AS AGMT_NO," ).append("\n"); 
		query.append("A.EQ_NO," ).append("\n"); 
		query.append("(SELECT C.EQ_TPSZ_CD" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT C" ).append("\n"); 
		query.append("WHERE C.EQ_NO = A.EQ_NO" ).append("\n"); 
		query.append(") AS EQ_TPSZ_CD," ).append("\n"); 
		query.append("A.CHG_CD," ).append("\n"); 
		query.append("A.COST_CD," ).append("\n"); 
		query.append("A.ACCT_CD," ).append("\n"); 
		query.append("'USD' AS CURR_CD," ).append("\n"); 
		query.append("A.PAY_TAX_AMT," ).append("\n"); 
		query.append("A.PAY_CR_AMT," ).append("\n"); 
		query.append("A.PAY_LSE_CHG_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CGM_LSE_CHG_DTL A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND A.PAY_INV_SEQ = @[pay_inv_seq]" ).append("\n"); 

	}
}