/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceivableRentalCostDBDAOARInterfaceInvoiceCancelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.04
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.01.04 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceivableRentalCostDBDAOARInterfaceInvoiceCancelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Cancel 자료의 AR Interface Main 정보를 조회합니다.
	  * </pre>
	  */
	public ReceivableRentalCostDBDAOARInterfaceInvoiceCancelRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.integration").append("\n"); 
		query.append("FileName : ReceivableRentalCostDBDAOARInterfaceInvoiceCancelRSQL").append("\n"); 
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
		query.append("SELECT  A.BL_SRC_NO, A.INV_SRC_NO, A.CUST_CNT_CD, A.CUST_SEQ," ).append("\n"); 
		query.append("A.OFC_CD, A.IF_SRC_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD," ).append("\n"); 
		query.append("A.SVC_SCP_CD, A.SAIL_DT, A.SAIL_ARR_DT, A.DUE_DT, A.GL_EFF_DT," ).append("\n"); 
		query.append("A.SLAN_CD, A.IO_BND_CD, A.TRNK_VSL_CD, A.TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("A.TRNK_SKD_DIR_CD, A.POR_CD, A.POL_CD, A.POD_CD, A.DEL_CD," ).append("\n"); 
		query.append("A.BKG_TEU_QTY, A.BKG_FEU_QTY, A.INV_REF_NO," ).append("\n"); 
		query.append("@[cre_usr_id] AS CRE_USR_ID, SYSDATE AS CRE_DT," ).append("\n"); 
		query.append("@[cre_usr_id] AS UPD_USR_ID, SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM    INV_AR_IF_MN A" ).append("\n"); 
		query.append("WHERE   A.SRC_IF_DT = @[src_if_dt]" ).append("\n"); 
		query.append("AND     A.SRC_IF_SEQ = @[src_if_seq]" ).append("\n"); 

	}
}