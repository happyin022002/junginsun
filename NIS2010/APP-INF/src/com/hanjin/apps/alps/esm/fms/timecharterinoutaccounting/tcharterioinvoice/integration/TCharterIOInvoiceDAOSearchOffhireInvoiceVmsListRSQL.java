/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TCharterIOInvoiceDAOSearchOffhireInvoiceVmsListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.06
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDAOSearchOffhireInvoiceVmsListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOInvoiceDAOSearchOffhireInvoiceVmsListRSQL
	  * </pre>
	  */
	public TCharterIOInvoiceDAOSearchOffhireInvoiceVmsListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_slp_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onh_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOSearchOffhireInvoiceVmsListRSQL").append("\n"); 
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
		query.append("VSL_CD," ).append("\n"); 
		query.append("OFFH_SEQ," ).append("\n"); 
		query.append("TO_CHAR(OFFH_DT,'YYYYMMDD') OFFH_DT_DAY," ).append("\n"); 
		query.append("TO_CHAR(OFFH_DT,'HH24:MI') OFFH_DT_TIME," ).append("\n"); 
		query.append("TO_CHAR(ONH_DT,'YYYYMMDD') ONH_DT_DAY," ).append("\n"); 
		query.append("TO_CHAR(ONH_DT,'HH24:MI') ONH_DT_TIME," ).append("\n"); 
		query.append("OFFH_DUR_DYS," ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD01524'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = FLET_ACC_TP_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1) FLET_ACC_TP_CD," ).append("\n"); 
		query.append("FOIL_QTY," ).append("\n"); 
		query.append("FOIL_PRC," ).append("\n"); 
		query.append("DOIL_QTY," ).append("\n"); 
		query.append("DOIL_PRC," ).append("\n"); 
		query.append("CSR_SLP_FLG," ).append("\n"); 
		query.append("OFFH_RSN," ).append("\n"); 
		query.append("OFFH_DESC," ).append("\n"); 
		query.append("(SELECT OFFH_SEQ" ).append("\n"); 
		query.append("FROM FMS_INVOICE FI" ).append("\n"); 
		query.append("WHERE FI.VSL_CD = FO.VSL_CD" ).append("\n"); 
		query.append("AND FI.OFFH_SEQ = FO.OFFH_SEQ" ).append("\n"); 
		query.append("AND FI.FLET_ISS_TP_CD = 'OFF'" ).append("\n"); 
		query.append("AND FI.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND ROWNUM = 1) USE_FLG" ).append("\n"); 
		query.append("FROM FMS_OFFH_EXPN FO" ).append("\n"); 
		query.append("WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${flet_acc_tp_cd} != '')" ).append("\n"); 
		query.append("AND FLET_ACC_TP_CD = @[flet_acc_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${csr_slp_flg} != '')" ).append("\n"); 
		query.append("AND CSR_SLP_FLG = @[csr_slp_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${offh_dt} != '')" ).append("\n"); 
		query.append("AND OFFH_DT >= TO_DATE(REPLACE(@[offh_dt],'-',''),'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("AND OFFH_DT <= TO_DATE(REPLACE(@[onh_dt],'-',''),'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT 'Y'" ).append("\n"); 
		query.append("FROM FMS_OFFH_EXPN" ).append("\n"); 
		query.append("WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#if(${flet_acc_tp_cd} != '')" ).append("\n"); 
		query.append("AND FLET_ACC_TP_CD = @[flet_acc_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${csr_slp_flg} != '')" ).append("\n"); 
		query.append("AND CSR_SLP_FLG = @[csr_slp_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${offh_dt} != '')" ).append("\n"); 
		query.append("AND OFFH_DT >= TO_DATE(REPLACE(@[offh_dt],'-',''),'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("AND OFFH_DT <= TO_DATE(REPLACE(@[onh_dt],'-',''),'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND CSR_SLP_FLG = 'N'" ).append("\n"); 
		query.append("AND DELT_FLG = 'Y')" ).append("\n"); 

	}
}