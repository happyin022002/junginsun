/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOinsertPsoChargeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.16
*@LastModifier : 서관영
*@LastVersion : 1.0
* 2013.04.16 서관영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seo Kwan Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOinsertPsoChargeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice 정보중 PSO Charge의 데이터를 생성한다.
	  * -----------------------------------------------------------
	  * ** 변경 이력 **
	  * -----------------------------------------------------------
	  * [CHM-201005061-01]
	  * Issue Date 선택 조건 변경
	  * - 일단 전도금(110911)의 경우 Creation Date(SYSDATE)
	  * - 운하통항비(511911)의 경우 ETD Date
	  * -----------------------------------------------------------
	  * 
	  * [CHM-201324034] 
	  * - Port Charge Invoice Creation화면에서 
	  *   Invoice No. 마지막 자리 공백 입력 안 되도록 수정
	  * - 2013/04/16 
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOinsertPsoChargeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_ddct_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_whld_tax_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_net_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pso_chg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_tax_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_term_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acpt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pso_trns_slp_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOinsertPsoChargeCSQL").append("\n"); 
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
		query.append("INSERT INTO PSO_CHARGE (" ).append("\n"); 
		query.append("	ISS_CTY_CD" ).append("\n"); 
		query.append(",	SO_SEQ" ).append("\n"); 
		query.append(",	YD_CD" ).append("\n"); 
		query.append(",	VNDR_SEQ" ).append("\n"); 
		query.append(",	COST_OFC_CD" ).append("\n"); 
		query.append(",	INV_OFC_CD" ).append("\n"); 
		query.append(",	INV_NO" ).append("\n"); 
		query.append(",	CURR_CD" ).append("\n"); 
		query.append(",	TTL_LOCL_AMT" ).append("\n"); 
		query.append(",	TTL_USD_AMT" ).append("\n"); 
		query.append(",	INV_LOCL_AMT" ).append("\n"); 
		query.append(",	LOCL_TAX_AMT" ).append("\n"); 
		query.append(",	LOCL_NET_AMT" ).append("\n"); 
		query.append(",	LOCL_DDCT_AMT" ).append("\n"); 
		query.append(",	LOCL_WHLD_TAX_AMT" ).append("\n"); 
		query.append(",	ACPT_DT" ).append("\n"); 
		query.append(",	ISS_DT" ).append("\n"); 
		query.append(",	EFF_DT" ).append("\n"); 
		query.append(",	PAY_TERM_DYS" ).append("\n"); 
		query.append(",	DUE_DT" ).append("\n"); 
		query.append(",	AP_EFF_DT" ).append("\n"); 
		query.append(",	PSO_CHG_STS_CD" ).append("\n"); 
		query.append(",	INV_RGST_NO" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	PSO_TRNS_SLP_CTNT" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	NVL((SELECT /*+INDEX_DESC(T1 XPKPSO_CHARGE)*/" ).append("\n"); 
		query.append("	ISS_CTY_CD FROM PSO_CHARGE T1" ).append("\n"); 
		query.append("	WHERE T1.ISS_CTY_CD = SUBSTR(@[inv_ofc_cd], 1, 3)" ).append("\n"); 
		query.append("	AND T1.SO_SEQ >= 0 " ).append("\n"); 
		query.append("	AND ROWNUM<=1), SUBSTR(@[inv_ofc_cd], 1, 3))" ).append("\n"); 
		query.append(",	NVL((SELECT /*+INDEX_DESC(T1 XPKPSO_CHARGE)*/" ).append("\n"); 
		query.append("	SO_SEQ FROM PSO_CHARGE T1" ).append("\n"); 
		query.append("	WHERE T1.ISS_CTY_CD = SUBSTR(@[inv_ofc_cd], 1, 3)" ).append("\n"); 
		query.append("	AND T1.SO_SEQ >= 0 " ).append("\n"); 
		query.append("	AND ROWNUM<=1), 0)+1" ).append("\n"); 
		query.append(",	@[yd_cd]" ).append("\n"); 
		query.append(",	@[vndr_seq]" ).append("\n"); 
		query.append(",	@[cost_ofc_cd]" ).append("\n"); 
		query.append(",	@[inv_ofc_cd]" ).append("\n"); 
		query.append(",	RTRIM(@[inv_no])" ).append("\n"); 
		query.append(",	@[curr_cd]" ).append("\n"); 
		query.append(",	@[ttl_locl_amt]" ).append("\n"); 
		query.append(",	@[ttl_usd_amt]" ).append("\n"); 
		query.append(",	@[inv_locl_amt]" ).append("\n"); 
		query.append(",	@[locl_tax_amt]" ).append("\n"); 
		query.append(",	@[locl_net_amt]" ).append("\n"); 
		query.append(",	@[locl_ddct_amt]" ).append("\n"); 
		query.append(",	@[locl_whld_tax_amt]" ).append("\n"); 
		query.append(",	NVL(TO_DATE(@[acpt_dt],'YYYY-MM-DD'), sysdate)" ).append("\n"); 
		query.append(",	NVL(TO_DATE(@[iss_dt],'YYYY-MM-DD'), DECODE(@[pso_trns_slp_ctnt], 'GO', SYSDATE,  	-- 전도금(110911)의 경우 생성일" ).append("\n"); 
		query.append("											'AA', (SELECT MIN(VPS_ETD_DT)				-- 운하통항비(511911)의 경우 ETD" ).append("\n"); 
		query.append("											FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("										   WHERE VSL_CD = SUBSTR(@[inv_no],3,4)" ).append("\n"); 
		query.append("											 AND SKD_VOY_NO = SUBSTR(@[inv_no],7,4)" ).append("\n"); 
		query.append("											 AND SKD_DIR_CD = SUBSTR(@[inv_no],11,1)" ).append("\n"); 
		query.append("											 AND VPS_PORT_CD = SUBSTR(@[yd_cd],1,5)" ).append("\n"); 
		query.append("										)))" ).append("\n"); 
		query.append(",	NVL(TO_DATE(@[eff_dt],'YYYY-MM-DD'), sysdate)" ).append("\n"); 
		query.append(",	NVL(@[pay_term_dys], 30)" ).append("\n"); 
		query.append(",	TO_DATE(@[due_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	TO_DATE(@[ap_eff_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	@[pso_chg_sts_cd]" ).append("\n"); 
		query.append(",	@[inv_rgst_no]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[pso_trns_slp_ctnt]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}