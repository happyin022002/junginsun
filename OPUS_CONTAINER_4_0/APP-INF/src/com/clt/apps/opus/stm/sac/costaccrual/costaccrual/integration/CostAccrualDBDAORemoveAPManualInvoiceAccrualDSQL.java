/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CostAccrualDBDAORemoveAPManualInvoiceAccrualDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sac.costaccrual.costaccrual.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostAccrualDBDAORemoveAPManualInvoiceAccrualDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AP Manual Accrual 에 대한 I/F된 내역에 대해서 추정 서버로 I/F가 안 된 경우 삭제 처리가 가능토록 처리
	  * </pre>
	  */
	public CostAccrualDBDAORemoveAPManualInvoiceAccrualDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_yymm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sac.costaccrual.costaccrual.integration ").append("\n"); 
		query.append("FileName : CostAccrualDBDAORemoveAPManualInvoiceAccrualDSQL").append("\n"); 
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
		query.append("DELETE  FROM GL_ESTM_IF_ERP  GEIE" ).append("\n"); 
		query.append("WHERE   GEIE.EXE_YRMON = @[gl_yymm]" ).append("\n"); 
		query.append("AND     GEIE.SYS_SRC_ID = 'SAP'" ).append("\n"); 
		query.append("AND     GEIE.WO_NO = @[csr_no]" ).append("\n"); 
		query.append("AND     NVL(GEIE.IF_FLG, 'N') <> 'Y'" ).append("\n"); 

	}
}