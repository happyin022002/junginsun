/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ActualCustomerPopupDBDAOSearchActualCustomerNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.24
*@LastModifier : 김종호
*@LastVersion : 1.0
* 2012.04.24 김종호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.actualcustomerpopup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Ho Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualCustomerPopupDBDAOSearchActualCustomerNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Actual Customer Name 조회
	  * </pre>
	  */
	public ActualCustomerPopupDBDAOSearchActualCustomerNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.common.actualcustomerpopup.integration").append("\n"); 
		query.append("FileName : ActualCustomerPopupDBDAOSearchActualCustomerNameRSQL").append("\n"); 
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
		query.append(" " ).append("\n"); 
		query.append("SELECT M.CUST_LGL_ENG_NM FCTRY_NM," ).append("\n"); 
		query.append("  A.FCTRY_ADDR FCTRY_ADDR" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER M ," ).append("\n"); 
		query.append("  TRS_TRSP_ACT_CUST_ADDR A" ).append("\n"); 
		query.append("WHERE M.CUST_CNT_CD||M.CUST_SEQ = @[act_cust_cd]" ).append("\n"); 
		query.append("  AND M.CUST_CNT_CD = A.ACT_CUST_CNT_CD (+)" ).append("\n"); 
		query.append("  AND M.CUST_SEQ = A.ACT_CUST_SEQ (+)" ).append("\n"); 
		query.append("  AND NVL(M.NMD_CUST_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("  AND 1 = A.ACT_CUST_ADDR_SEQ (+)" ).append("\n"); 
		query.append("  AND M.DELT_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${sCustInfoIndicator} == 'XEUR')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT D.ACT_CUST_NM FCTRY_NM," ).append("\n"); 
		query.append("  D.ACT_CUST_ADDR FCTRY_ADDR" ).append("\n"); 
		query.append("FROM TRS_TRSP_USA_ACT_CUST C," ).append("\n"); 
		query.append("  TRS_TRSP_USA_ACT_CUST_DTL D" ).append("\n"); 
		query.append("WHERE C.ACT_CUST_CNT_CD||C.ACT_CUST_SEQ = @[act_cust_cd]" ).append("\n"); 
		query.append("  AND C.TRSP_ACT_CUST_NO=D.TRSP_ACT_CUST_NO" ).append("\n"); 
		query.append("  AND C.DELT_FLG='N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}