/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOInvoiceDBDAOFmsOffHireExpenseInterfaceUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.09.15 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi,Woo-Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDBDAOFmsOffHireExpenseInterfaceUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VMS에서 Off Hire 비용 정보를 수신 Insert/Update
	  * </pre>
	  */
	public TCharterIOInvoiceDBDAOFmsOffHireExpenseInterfaceUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offh_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doil_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offh_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_acc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offh_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onh_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDBDAOFmsOffHireExpenseInterfaceUSQL").append("\n"); 
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
		query.append("MERGE INTO FMS_OFFH_EXPN A" ).append("\n"); 
		query.append("USING (SELECT @[vsl_cd] VSL_CD," ).append("\n"); 
		query.append("@[offh_dt] OFFH_DT," ).append("\n"); 
		query.append("@[onh_dt] ONH_DT," ).append("\n"); 
		query.append("ROUND(TO_DATE(@[onh_dt], 'YYYYMMDD HH24MISS') - TO_DATE(@[offh_dt], 'YYYYMMDD HH24MISS'),4) OFFH_DUR_DYS," ).append("\n"); 
		query.append("@[flet_acc_tp_cd] FLET_ACC_TP_CD," ).append("\n"); 
		query.append("@[foil_qty] FOIL_QTY," ).append("\n"); 
		query.append("@[doil_qty] DOIL_QTY," ).append("\n"); 
		query.append("@[offh_rsn] OFFH_RSN," ).append("\n"); 
		query.append("@[offh_desc] OFFH_DESC," ).append("\n"); 
		query.append("@[delt_flg] DELT_FLG," ).append("\n"); 
		query.append("@[cre_usr_id] CRE_USR_ID," ).append("\n"); 
		query.append("@[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("FROM DUAL) B" ).append("\n"); 
		query.append("ON (A.VSL_CD = B.VSL_CD AND TO_CHAR(A.OFFH_DT,'YYYYMMDD HH24MISS') = B.OFFH_DT AND TO_CHAR(A.ONH_DT,'YYYYMMDD HH24MISS') = B.ONH_DT AND A.FLET_ACC_TP_CD = B.FLET_ACC_TP_CD AND B.DELT_FLG = 'Y')" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("A.OFFH_DUR_DYS = B.OFFH_DUR_DYS," ).append("\n"); 
		query.append("A.FOIL_QTY = B.FOIL_QTY," ).append("\n"); 
		query.append("A.DOIL_QTY = B.DOIL_QTY," ).append("\n"); 
		query.append("A.OFFH_RSN = B.OFFH_RSN," ).append("\n"); 
		query.append("A.OFFH_DESC = B.OFFH_DESC," ).append("\n"); 
		query.append("A.DELT_FLG = B.DELT_FLG," ).append("\n"); 
		query.append("A.UPD_DT = SYSDATE," ).append("\n"); 
		query.append("A.UPD_USR_ID = B.UPD_USR_ID" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT( VSL_CD," ).append("\n"); 
		query.append("OFFH_SEQ," ).append("\n"); 
		query.append("OFFH_DT," ).append("\n"); 
		query.append("ONH_DT," ).append("\n"); 
		query.append("OFFH_DUR_DYS," ).append("\n"); 
		query.append("FLET_ACC_TP_CD," ).append("\n"); 
		query.append("FOIL_QTY," ).append("\n"); 
		query.append("DOIL_QTY," ).append("\n"); 
		query.append("OFFH_RSN," ).append("\n"); 
		query.append("OFFH_DESC," ).append("\n"); 
		query.append("DELT_FLG," ).append("\n"); 
		query.append("ORG_OFFH_DT," ).append("\n"); 
		query.append("ORG_ONH_DT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT)" ).append("\n"); 
		query.append("VALUES( B.VSL_CD," ).append("\n"); 
		query.append("FMS_OFFH_SEQ.nextval," ).append("\n"); 
		query.append("TO_DATE(B.OFFH_DT,'YYYYMMDD HH24MISS')," ).append("\n"); 
		query.append("TO_DATE(B.ONH_DT,'YYYYMMDD HH24MISS')," ).append("\n"); 
		query.append("B.OFFH_DUR_DYS," ).append("\n"); 
		query.append("B.FLET_ACC_TP_CD," ).append("\n"); 
		query.append("B.FOIL_QTY," ).append("\n"); 
		query.append("B.DOIL_QTY," ).append("\n"); 
		query.append("B.OFFH_RSN," ).append("\n"); 
		query.append("B.OFFH_DESC," ).append("\n"); 
		query.append("B.DELT_FLG," ).append("\n"); 
		query.append("TO_DATE(B.OFFH_DT,'YYYYMMDD HH24MISS')," ).append("\n"); 
		query.append("TO_DATE(B.ONH_DT,'YYYYMMDD HH24MISS')," ).append("\n"); 
		query.append("B.CRE_USR_ID," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("B.UPD_USR_ID," ).append("\n"); 
		query.append("SYSDATE)" ).append("\n"); 

	}
}