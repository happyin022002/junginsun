/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayableRentalCostDBDAOPayableChargeAuditRejectMasterUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.26
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.11.26 노정용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Nho Jung Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PayableRentalCostDBDAOPayableChargeAuditRejectMasterUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Charge Creation Reject 시 Chareg Creation Master 의 상태를 Audit 이전으로 update.
	  * </pre>
	  */
	public PayableRentalCostDBDAOPayableChargeAuditRejectMasterUSQL(){
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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.integration ").append("\n"); 
		query.append("FileName : PayableRentalCostDBDAOPayableChargeAuditRejectMasterUSQL").append("\n"); 
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
		query.append("UPDATE LSE_PAY_RNTL_CHG" ).append("\n"); 
		query.append("SET    LSE_PAY_RNTL_STS_CD = 'H'" ).append("\n"); 
		query.append(", LR_COST_AMT         = 0.0" ).append("\n"); 
		query.append(", CR_TTL_AMT          = 0.0" ).append("\n"); 
		query.append(", PAY_RNTL_COST_AMT   = 0.0" ).append("\n"); 
		query.append(", UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append(", UPD_DT     = SYSDATE" ).append("\n"); 
		query.append("WHERE  AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND    AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("AND    CHG_SEQ     = @[chg_seq]" ).append("\n"); 

	}
}