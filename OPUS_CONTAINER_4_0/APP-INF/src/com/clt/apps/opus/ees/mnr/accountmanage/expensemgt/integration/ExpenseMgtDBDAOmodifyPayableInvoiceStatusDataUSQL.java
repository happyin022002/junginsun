/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ExpenseMgtDBDAOmodifyPayableInvoiceStatusDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.25
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2010.02.25 함형석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HamHyungSeok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExpenseMgtDBDAOmodifyPayableInvoiceStatusDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ExpenseMgtDBDAOmodifyPayableInvoiceStatusDataUSQL
	  * </pre>
	  */
	public ExpenseMgtDBDAOmodifyPayableInvoiceStatusDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_inv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.integration").append("\n"); 
		query.append("FileName : ExpenseMgtDBDAOmodifyPayableInvoiceStatusDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_PAY_INV_WRK SET  " ).append("\n"); 
		query.append("	MNR_INV_STS_CD = @[mnr_inv_sts_cd]" ).append("\n"); 
		query.append("    ,INV_RGST_NO = ''" ).append("\n"); 
		query.append("	,UPD_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("    ,INV_CFM_DT = TO_DATE(@[inv_cfm_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("    ,CFM_DT = TO_DATE(@[cfm_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("	,UPD_DT = sysdate" ).append("\n"); 
		query.append("WHERE PAY_INV_SEQ = @[pay_inv_seq]" ).append("\n"); 

	}
}