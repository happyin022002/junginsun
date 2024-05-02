/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceivableRentalCostDBDAOARInterfaceChargeCancelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.04
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.01.04 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceivableRentalCostDBDAOARInterfaceChargeCancelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Cancel 자료의 AR Interface Charge 정보를 조회합니다.
	  * </pre>
	  */
	public ReceivableRentalCostDBDAOARInterfaceChargeCancelRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_if_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_if_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.integration").append("\n"); 
		query.append("FileName : ReceivableRentalCostDBDAOARInterfaceChargeCancelRSQL").append("\n"); 
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
		query.append("SELECT  A.CHG_SEQ, A.CURR_CD, A.CHG_CD, A.CHG_FULL_NM," ).append("\n"); 
		query.append("A.PER_TP_CD, - A.TRF_RT_AMT AS TRF_RT_AMT," ).append("\n"); 
		query.append("A.RAT_AS_CNTR_QTY, - A.CHG_AMT AS CHG_AMT," ).append("\n"); 
		query.append("A.INV_XCH_RT, A.TVA_FLG, A.REP_CHG_CD, A.CHG_RMK," ).append("\n"); 
		query.append("@[cre_usr_id] AS CRE_USR_ID, SYSDATE AS CRE_DT," ).append("\n"); 
		query.append("@[cre_usr_id] AS UPD_USR_ID, SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM    INV_AR_IF_CHG A" ).append("\n"); 
		query.append("WHERE   A.SRC_IF_DT = @[src_if_dt]" ).append("\n"); 
		query.append("AND     A.SRC_IF_SEQ = @[src_if_seq]" ).append("\n"); 

	}
}