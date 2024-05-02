/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PayableRentalCostDBDAOLessorInvoiceFileImportAgreementNoByCtrtNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.01
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.06.01 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PayableRentalCostDBDAOLessorInvoiceFileImportAgreementNoByCtrtNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Agreement No. by Contract No.
	  * </pre>
	  */
	public PayableRentalCostDBDAOLessorInvoiceFileImportAgreementNoByCtrtNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("costMonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.integration").append("\n"); 
		query.append("FileName : PayableRentalCostDBDAOLessorInvoiceFileImportAgreementNoByCtrtNoRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT LA.AGMT_CTY_CD||LA.AGMT_SEQ AS AGMT_NO" ).append("\n"); 
		query.append("FROM LSE_AGREEMENT_V LA" ).append("\n"); 
		query.append("WHERE LSE_CTRT_NO = @[lse_ctrt_no]" ).append("\n"); 
		query.append("AND TRUNC(LAST_DAY(TO_DATE(@[costMonth], 'YYYYMM'))) BETWEEN DECODE(LA.AGMT_LST_VER_SEQ, 1, NVL(LA.BLD_UP_DT, LA.LST_EFF_DT), LA.LST_EFF_DT) AND NVL(LA.BLD_DWN_END_DT, LA.LST_EXP_DT)" ).append("\n"); 

	}
}