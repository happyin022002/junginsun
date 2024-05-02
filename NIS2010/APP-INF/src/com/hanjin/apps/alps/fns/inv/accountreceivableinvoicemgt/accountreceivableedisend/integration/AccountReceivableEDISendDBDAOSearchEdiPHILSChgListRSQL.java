/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchEdiPHILSChgListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.12
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2013.02.12 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchEdiPHILSChgListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PHILS EDI Charge Amount List
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchEdiPHILSChgListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchEdiPHILSChgListRSQL").append("\n"); 
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
		query.append("SELECT CHG.CHG_CD," ).append("\n"); 
		query.append("  CHG.CURR_CD," ).append("\n"); 
		query.append("  CHG.PER_TP_CD," ).append("\n"); 
		query.append("  CHG.TRF_RT_AMT," ).append("\n"); 
		query.append("  CHG.RAT_AS_CNTR_QTY," ).append("\n"); 
		query.append(" ( SELECT SUM(B.CHG_AMT) CHG_AMT" ).append("\n"); 
		query.append("   FROM INV_AR_MN A, INV_AR_CHG B" ).append("\n"); 
		query.append("   WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("   AND A.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("   AND A.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("   AND A.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("   AND A.ACT_CUST_SEQ =  @[act_cust_seq]" ).append("\n"); 
		query.append("   AND A.INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("   AND A.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("   AND B.CHG_CD = CHG.CHG_CD" ).append("\n"); 
		query.append("   AND B.CURR_CD = CHG.CURR_CD" ).append("\n"); 
		query.append("   )AS CHG_AMT" ).append("\n"); 
		query.append("FROM INV_AR_CHG CHG," ).append("\n"); 
		query.append("  (SELECT BL_SRC_NO, MAX(AR_IF_NO) AR_IF_NO" ).append("\n"); 
		query.append("   FROM INV_AR_MN" ).append("\n"); 
		query.append("   WHERE AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("     AND ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("     AND ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("     AND INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("     AND REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("     AND BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("   GROUP BY BL_SRC_NO" ).append("\n"); 
		query.append("  ) MN" ).append("\n"); 
		query.append("WHERE CHG.AR_IF_NO = MN.AR_IF_NO" ).append("\n"); 

	}
}