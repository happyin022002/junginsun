/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOInvoiceDBDAOFmsInvoiceInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.07.17 최우석
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

public class TCharterIOInvoiceDBDAOFmsInvoiceInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VMS에서 CDAM 정산 데이터 Select
	  * </pre>
	  */
	public TCharterIOInvoiceDBDAOFmsInvoiceInterfaceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDBDAOFmsInvoiceInterfaceRSQL").append("\n"); 
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
		query.append("SELECT 'VMS002-0001' LIFID," ).append("\n"); 
		query.append("TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS') SEQ," ).append("\n"); 
		query.append("TO_CHAR(EE.TTL_CNT) TOTAL_COUNT," ).append("\n"); 
		query.append("TO_CHAR(ROWNUM) ROW_COUNT," ).append("\n"); 
		query.append("TO_CHAR(BB.EFF_DT,'YYYYMMDD') H_INV_STDD," ).append("\n"); 
		query.append("TO_CHAR(BB.EXP_DT,'YYYYMMDD') H_INV_ENDDD," ).append("\n"); 
		query.append("CC.ACCT_CD H_ACCT_CD," ).append("\n"); 
		query.append("HJSEAI_PKG.h_encode(DD.ACCT_ITM_NM) H_ACCT_NM," ).append("\n"); 
		query.append("CC.CURR_CD H_CURR_CD," ).append("\n"); 
		query.append("TO_CHAR(CC.INV_AMT) H_INVD_AMT" ).append("\n"); 
		query.append("FROM FMS_CONTRACT AA," ).append("\n"); 
		query.append("FMS_INVOICE BB," ).append("\n"); 
		query.append("FMS_INV_DTL CC," ).append("\n"); 
		query.append("FMS_ACCT_ITM DD," ).append("\n"); 
		query.append("(SELECT COUNT(C.INV_AMT) TTL_CNT" ).append("\n"); 
		query.append("FROM FMS_CONTRACT A," ).append("\n"); 
		query.append("FMS_INVOICE B," ).append("\n"); 
		query.append("FMS_INV_DTL C" ).append("\n"); 
		query.append("WHERE A.FLET_CTRT_NO = B.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND B.FLET_ISS_TP_CD = C.FLET_ISS_TP_CD" ).append("\n"); 
		query.append("AND B.FLET_CTRT_NO = C.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND B.INV_SEQ = C.INV_SEQ" ).append("\n"); 
		query.append("AND B.FLET_ISS_TP_CD = 'OFF'" ).append("\n"); 
		query.append("AND (TO_CHAR(B.EFF_DT,'YYYYMMDD') BETWEEN @[eff_dt] AND @[exp_dt]" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("TO_CHAR(B.EXP_DT,'YYYYMMDD') BETWEEN @[eff_dt] AND @[exp_dt])) EE" ).append("\n"); 
		query.append("WHERE AA.FLET_CTRT_NO = BB.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND BB.FLET_ISS_TP_CD = CC.FLET_ISS_TP_CD" ).append("\n"); 
		query.append("AND BB.FLET_CTRT_NO = CC.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND BB.INV_SEQ = CC.INV_SEQ" ).append("\n"); 
		query.append("AND CC.ACCT_CD = DD.ACCT_CD" ).append("\n"); 
		query.append("AND CC.ACCT_ITM_SEQ = DD.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("AND BB.FLET_ISS_TP_CD = 'OFF'" ).append("\n"); 
		query.append("AND (TO_CHAR(BB.EFF_DT,'YYYYMMDD') BETWEEN @[eff_dt] AND @[exp_dt]" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("TO_CHAR(BB.EXP_DT,'YYYYMMDD') BETWEEN @[eff_dt] AND @[exp_dt])" ).append("\n"); 
		query.append("AND AA.VSL_CD = @[vsl_cd]" ).append("\n"); 

	}
}