/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOAddTpbInvCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.26
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.11.26 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOAddTpbInvCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSO-TPB Interface할 billing type 정보를 생성합니다.
	  * 
	  * ===================================
	  * * 2012.11.26 진마리아 CHM-201220618-01 TPB 비용 정보 지정시 해당 정보를 TPB IF용 테이블에 저장하고 제어함
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOAddTpbInvCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_bil_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("so_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOAddTpbInvCSQL").append("\n"); 
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
		query.append("INSERT INTO PSO_N3RD_PTY_IF (" ).append("\n"); 
		query.append("   ISS_CTY_CD" ).append("\n"); 
		query.append(",  SO_SEQ" ).append("\n"); 
		query.append(",  SO_DTL_SEQ" ).append("\n"); 
		query.append(",  IF_SEQ" ).append("\n"); 
		query.append(",  N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append(",  IF_OFC_CD" ).append("\n"); 
		query.append(",  COST_OFC_CD" ).append("\n"); 
		query.append(",  INV_NO" ).append("\n"); 
		query.append(",  VSL_CD" ).append("\n"); 
		query.append(",  SKD_VOY_NO" ).append("\n"); 
		query.append(",  SKD_DIR_CD" ).append("\n"); 
		query.append(",  YD_CD" ).append("\n"); 
		query.append(",  VNDR_CNT_CD" ).append("\n"); 
		query.append(",  VNDR_SEQ" ).append("\n"); 
		query.append(",  IF_CURR_CD" ).append("\n"); 
		query.append(",  IF_AMT" ).append("\n"); 
		query.append(",  IF_RMK" ).append("\n"); 
		query.append(",  ACCT_CD" ).append("\n"); 
		query.append(",  LGS_COST_CD" ).append("\n"); 
		query.append(",  VPS_ETD_DT" ).append("\n"); 
		query.append(",  IF_USR_ID" ).append("\n"); 
		query.append(",  IF_DT" ).append("\n"); 
		query.append(",  IF_FLG" ).append("\n"); 
		query.append(",  CRE_USR_ID" ).append("\n"); 
		query.append(",  CRE_DT" ).append("\n"); 
		query.append(",  UPD_USR_ID" ).append("\n"); 
		query.append(",  UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("   @[iss_cty_cd]" ).append("\n"); 
		query.append(",  DECODE(@[so_seq], null, (SELECT /*+INDEX_DESC(T1 XPKPSO_CHARGE)*/" ).append("\n"); 
		query.append("   SO_SEQ FROM PSO_CHARGE T1" ).append("\n"); 
		query.append("   WHERE T1.ISS_CTY_CD = @[iss_cty_cd]" ).append("\n"); 
		query.append("   AND T1.SO_SEQ >= 0 " ).append("\n"); 
		query.append("   AND ROWNUM<=1), @[so_seq])" ).append("\n"); 
		query.append(",  (SELECT /*+INDEX_DESC(T1 XPKPSO_CHG_DTL)*/" ).append("\n"); 
		query.append("   SO_DTL_SEQ FROM PSO_CHG_DTL T1" ).append("\n"); 
		query.append("   WHERE T1.ISS_CTY_CD = @[iss_cty_cd]" ).append("\n"); 
		query.append("   AND T1.SO_SEQ = DECODE(@[so_seq], null, (SELECT /*+INDEX_DESC(T1 XPKPSO_CHARGE)*/" ).append("\n"); 
		query.append("                                            SO_SEQ FROM PSO_CHARGE T1" ).append("\n"); 
		query.append("                                            WHERE T1.ISS_CTY_CD = @[iss_cty_cd]" ).append("\n"); 
		query.append("                                            AND T1.SO_SEQ >= 0 " ).append("\n"); 
		query.append("                                            AND ROWNUM<=1), @[so_seq])" ).append("\n"); 
		query.append("   AND N3PTY_BIL_IF_FLG = 'Y'" ).append("\n"); 
		query.append("   AND ROWNUM<=1)" ).append("\n"); 
		query.append(",  TO_CHAR(SYSDATE,'YYYYMMDD')||'0001'" ).append("\n"); 
		query.append(",  @[n3pty_bil_tp_cd]" ).append("\n"); 
		query.append(",  @[if_ofc_cd]" ).append("\n"); 
		query.append(",  @[cost_ofc_cd]" ).append("\n"); 
		query.append(",  @[inv_no]" ).append("\n"); 
		query.append(",  @[vsl_cd]" ).append("\n"); 
		query.append(",  @[skd_voy_no]" ).append("\n"); 
		query.append(",  @[skd_dir_cd]" ).append("\n"); 
		query.append(",  @[yd_cd]" ).append("\n"); 
		query.append(",  (SELECT VNDR_CNT_CD FROM MDM_VENDOR WHERE VNDR_SEQ=@[vndr_seq])" ).append("\n"); 
		query.append(",  @[vndr_seq]" ).append("\n"); 
		query.append(",  @[if_curr_cd]" ).append("\n"); 
		query.append(",  @[if_amt]" ).append("\n"); 
		query.append(",  @[if_rmk]" ).append("\n"); 
		query.append(",  @[acct_cd]" ).append("\n"); 
		query.append(",  @[lgs_cost_cd]" ).append("\n"); 
		query.append(",  (SELECT MIN(VPS_ETD_DT)" ).append("\n"); 
		query.append("   FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("   WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("   AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND YD_CD = @[yd_cd])" ).append("\n"); 
		query.append(",  @[if_usr_id]" ).append("\n"); 
		query.append(",  SYSDATE" ).append("\n"); 
		query.append(",  'N'" ).append("\n"); 
		query.append(",  @[cre_usr_id]" ).append("\n"); 
		query.append(",  SYSDATE" ).append("\n"); 
		query.append(",  @[cre_usr_id]" ).append("\n"); 
		query.append(",  SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}