/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PayableRentalCostDBDAOLseOpLseVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.06
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2014.03.06 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PayableRentalCostDBDAOLseOpLseVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Operation lease Invoice Creation
	  * Operation lease Invoice Creation시 Issue YearMonth 컬럼 추가   
	  * </pre>
	  */
	public PayableRentalCostDBDAOLseOpLseVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("if_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("libor_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_lse_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("int_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bil_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("co_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prin_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.integration").append("\n"); 
		query.append("FileName : PayableRentalCostDBDAOLseOpLseVOCSQL").append("\n"); 
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
		query.append("INSERT INTO LSE_OP_LSE (" ).append("\n"); 
		query.append("     AGMT_CTY_CD" ).append("\n"); 
		query.append("   , AGMT_SEQ" ).append("\n"); 
		query.append("   , OP_SEQ" ).append("\n"); 
		query.append("   , INV_NO" ).append("\n"); 
		query.append("   , VNDR_SEQ" ).append("\n"); 
		query.append("   , OP_LSE_STS_CD" ).append("\n"); 
		query.append("   , OP_LSE_QTY" ).append("\n"); 
		query.append("   , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("   , BIL_FM_DT" ).append("\n"); 
		query.append("   , BIL_TO_DT" ).append("\n"); 
		query.append("   , PAY_DT" ).append("\n"); 
		query.append("   , PRIN_AMT" ).append("\n"); 
		query.append("   , BAL_AMT" ).append("\n"); 
		query.append("   , INT_AMT" ).append("\n"); 
		query.append("   , LIBOR_AMT" ).append("\n"); 
		query.append("   , PAY_AMT" ).append("\n"); 
		query.append("   , AP_IF_FLG" ).append("\n"); 
		query.append("   , ISS_YRMON" ).append("\n"); 
		query.append("   , CURR_CD" ).append("\n"); 
		query.append("   , CO_OFC_CD" ).append("\n"); 
		query.append("   , IF_RGST_NO" ).append("\n"); 
		query.append("   , AGMT_REF_NO" ).append("\n"); 
		query.append("   , CRE_OFC_CD" ).append("\n"); 
		query.append("   , VSL_CD" ).append("\n"); 
		query.append("   , SKD_VOY_NO" ).append("\n"); 
		query.append("   , SKD_DIR_CD" ).append("\n"); 
		query.append("   , REV_DIR_CD" ).append("\n"); 
		query.append("   , VNDR_NM" ).append("\n"); 
		query.append("   , DIFF_RMK" ).append("\n"); 
		query.append("   , TTL_AMT" ).append("\n"); 
		query.append("   , CRE_USR_ID" ).append("\n"); 
		query.append("   , CRE_DT" ).append("\n"); 
		query.append("   , UPD_USR_ID" ).append("\n"); 
		query.append("   , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[agmt_cty_cd]   AS AGMT_CTY_CD" ).append("\n"); 
		query.append("     , @[agmt_seq]      AS AGMT_SEQ" ).append("\n"); 
		query.append("     , ( SELECT NVL(MAX(OP_SEQ), 0) + 1 " ).append("\n"); 
		query.append("         FROM   LSE_OP_LSE " ).append("\n"); 
		query.append("         WHERE  AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("         AND    AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("       ) AS OP_SEQ" ).append("\n"); 
		query.append("     , @[inv_no]        AS INV_NO" ).append("\n"); 
		query.append("     , @[vndr_seq]      AS VNDR_SEQ" ).append("\n"); 
		query.append("     , 'S'              AS OP_LSE_STS_CD" ).append("\n"); 
		query.append("     , @[op_lse_qty]    AS OP_LSE_QTY" ).append("\n"); 
		query.append("     , @[cntr_tpsz_cd]  AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , TO_DATE(@[bil_fm_dt], 'YYYYMMDD') AS BIL_FM_DT" ).append("\n"); 
		query.append("     , TO_DATE(@[bil_to_dt], 'YYYYMMDD') AS BIL_TO_DT" ).append("\n"); 
		query.append("     , TO_DATE(@[pay_dt], 'YYYYMMDD')    AS PAY_DT" ).append("\n"); 
		query.append("     , @[prin_amt]      AS PRIN_AMT" ).append("\n"); 
		query.append("     , @[bal_amt]       AS BAL_AMT" ).append("\n"); 
		query.append("     , @[int_amt]       AS INT_AMT" ).append("\n"); 
		query.append("     , @[libor_amt]     AS LIBOR_AMT" ).append("\n"); 
		query.append("     , @[pay_amt]       AS PAY_AMT" ).append("\n"); 
		query.append("     , 'N'              AS AP_IF_FLG" ).append("\n"); 
		query.append("     , TO_CHAR(TO_DATE(@[skd_voy_no], 'YYMM'), 'YYYYMM') AS ISS_YRMON" ).append("\n"); 
		query.append("     , @[curr_cd]       AS CURR_CD" ).append("\n"); 
		query.append("     , @[co_ofc_cd]     AS CO_OFC_CD" ).append("\n"); 
		query.append("     , @[if_rgst_no]    AS IF_RGST_NO" ).append("\n"); 
		query.append("     , B.REF_NO         AS AGMT_REF_NO" ).append("\n"); 
		query.append("     , @[cre_ofc_cd]    AS CRE_OFC_CD" ).append("\n"); 
		query.append("     , @[vsl_cd]        AS VSL_CD" ).append("\n"); 
		query.append("     , @[skd_voy_no]    AS SKD_VOY_NO" ).append("\n"); 
		query.append("     , @[skd_dir_cd]    AS SKD_DIR_CD" ).append("\n"); 
		query.append("     , @[rev_dir_cd]    AS REV_DIR_CD" ).append("\n"); 
		query.append("     , SUBSTR(C.VNDR_ABBR_NM, 0, 3) AS VNDR_NM" ).append("\n"); 
		query.append("     , @[diff_rmk]      AS DIFF_RMK" ).append("\n"); 
		query.append("     , 0                AS TTL_AMT" ).append("\n"); 
		query.append("     , @[usr_id]        AS CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE          AS CRE_DT" ).append("\n"); 
		query.append("     , @[usr_id]        AS UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE          AS UPD_DT" ).append("\n"); 
		query.append("FROM   LSE_AGREEMENT B" ).append("\n"); 
		query.append("     , MDM_VENDOR    C" ).append("\n"); 
		query.append("WHERE  C.VNDR_SEQ    = B.VNDR_SEQ" ).append("\n"); 
		query.append("AND    B.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND    B.AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("GROUP  BY B.REF_NO, C.VNDR_ABBR_NM" ).append("\n"); 

	}
}