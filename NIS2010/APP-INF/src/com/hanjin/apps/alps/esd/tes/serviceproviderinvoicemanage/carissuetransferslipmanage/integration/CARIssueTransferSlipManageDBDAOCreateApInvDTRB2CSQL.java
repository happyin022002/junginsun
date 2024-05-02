/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOCreateApInvDTRB2CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOCreateApInvDTRB2CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateApInvDTRB2
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOCreateApInvDTRB2CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("new_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("New_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_csr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOCreateApInvDTRB2CSQL").append("\n"); 
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
		query.append("INSERT INTO AP_INV_DTRB (" ).append("\n"); 
		query.append(" CSR_NO," ).append("\n"); 
		query.append(" LINE_SEQ," ).append("\n"); 
		query.append(" LINE_NO," ).append("\n"); 
		query.append(" LINE_TP_LU_CD," ).append("\n"); 
		query.append(" INV_AMT," ).append("\n"); 
		query.append(" INV_DESC," ).append("\n"); 
		query.append(" INV_TAX_CD," ).append("\n"); 
		query.append(" DTRB_COA_CO_CD," ).append("\n"); 
		query.append(" DTRB_COA_RGN_CD," ).append("\n"); 
		query.append(" DTRB_COA_CTR_CD," ).append("\n"); 
		query.append(" DTRB_COA_ACCT_CD," ).append("\n"); 
		query.append(" DTRB_COA_VVD_CD," ).append("\n"); 
		query.append(" DTRB_COA_INTER_CO_CD," ).append("\n"); 
		query.append(" DTRB_COA_FTU_N1ST_CD," ).append("\n"); 
		query.append(" DTRB_COA_FTU_N2ND_CD," ).append("\n"); 
		query.append(" ATTR_CATE_NM," ).append("\n"); 
		query.append(" ATTR_CTNT1," ).append("\n"); 
		query.append(" ATTR_CTNT2," ).append("\n"); 
		query.append(" ATTR_CTNT3," ).append("\n"); 
		query.append(" ATTR_CTNT4," ).append("\n"); 
		query.append(" ATTR_CTNT5," ).append("\n"); 
		query.append(" ATTR_CTNT6," ).append("\n"); 
		query.append(" ATTR_CTNT7," ).append("\n"); 
		query.append(" ATTR_CTNT8," ).append("\n"); 
		query.append(" ATTR_CTNT9," ).append("\n"); 
		query.append(" ATTR_CTNT10," ).append("\n"); 
		query.append(" ATTR_CTNT11," ).append("\n"); 
		query.append(" ATTR_CTNT12," ).append("\n"); 
		query.append(" ATTR_CTNT13," ).append("\n"); 
		query.append(" ATTR_CTNT14," ).append("\n"); 
		query.append(" ATTR_CTNT15," ).append("\n"); 
		query.append(" BKG_NO," ).append("\n"); 
		query.append(" CNTR_TPSZ_CD," ).append("\n"); 
		query.append(" ACT_VVD_CD," ).append("\n"); 
		query.append(" PLN_SCTR_DIV_CD," ).append("\n"); 
		query.append(" SO_CRR_CD," ).append("\n"); 
		query.append(" YD_CD," ).append("\n"); 
		query.append(" FTU_USE_CTNT1," ).append("\n"); 
		query.append(" FTU_USE_CTNT2," ).append("\n"); 
		query.append(" FTU_USE_CTNT3," ).append("\n"); 
		query.append(" FTU_USE_CTNT4," ).append("\n"); 
		query.append(" FTU_USE_CTNT5," ).append("\n"); 
		query.append(" CRE_DT," ).append("\n"); 
		query.append(" CRE_USR_ID," ).append("\n"); 
		query.append(" EAI_EVNT_DT" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append(" SELECT CSR_NO," ).append("\n"); 
		query.append(" LINE_SEQ," ).append("\n"); 
		query.append(" ROWNUM LINE_NO," ).append("\n"); 
		query.append(" LINE_TP_LU_CD," ).append("\n"); 
		query.append(" INV_AMT," ).append("\n"); 
		query.append(" INV_DESC," ).append("\n"); 
		query.append(" INV_TAX_CD," ).append("\n"); 
		query.append(" DTRB_COA_CO_CD," ).append("\n"); 
		query.append(" DTRB_COA_RGN_CD," ).append("\n"); 
		query.append(" DTRB_COA_CTR_CD," ).append("\n"); 
		query.append(" DTRB_COA_ACCT_CD," ).append("\n"); 
		query.append(" DTRB_COA_VVD_CD," ).append("\n"); 
		query.append(" DTRB_COA_INTER_CO_CD," ).append("\n"); 
		query.append(" DTRB_COA_FTU_N1ST_CD," ).append("\n"); 
		query.append(" DTRB_COA_FTU_N2ND_CD," ).append("\n"); 
		query.append(" ATTR_CATE_NM," ).append("\n"); 
		query.append(" ATTR_CTNT1||'_'||AP_INV_DTRB_SEQ1.NEXTVAL  ATTR_CTNT1," ).append("\n"); 
		query.append(" ATTR_CTNT2," ).append("\n"); 
		query.append(" ATTR_CTNT3," ).append("\n"); 
		query.append(" ATTR_CTNT4," ).append("\n"); 
		query.append(" ATTR_CTNT5," ).append("\n"); 
		query.append(" ATTR_CTNT6," ).append("\n"); 
		query.append(" ATTR_CTNT7," ).append("\n"); 
		query.append(" ATTR_CTNT8," ).append("\n"); 
		query.append(" ATTR_CTNT9," ).append("\n"); 
		query.append(" ATTR_CTNT10," ).append("\n"); 
		query.append(" ATTR_CTNT11," ).append("\n"); 
		query.append(" ATTR_CTNT12," ).append("\n"); 
		query.append(" ATTR_CTNT13," ).append("\n"); 
		query.append(" ATTR_CTNT14," ).append("\n"); 
		query.append(" ATTR_CTNT15," ).append("\n"); 
		query.append(" BKG_NO," ).append("\n"); 
		query.append(" CNTR_TPSZ_CD," ).append("\n"); 
		query.append(" ACT_VVD_CD," ).append("\n"); 
		query.append(" PLN_SCTR_DIV_CD," ).append("\n"); 
		query.append(" SO_CRR_CD," ).append("\n"); 
		query.append(" YD_CD," ).append("\n"); 
		query.append(" FTU_USE_CTNT1," ).append("\n"); 
		query.append(" FTU_USE_CTNT2," ).append("\n"); 
		query.append(" FTU_USE_CTNT3," ).append("\n"); 
		query.append(" FTU_USE_CTNT4," ).append("\n"); 
		query.append(" FTU_USE_CTNT5," ).append("\n"); 
		query.append(" CRE_DT," ).append("\n"); 
		query.append(" CRE_USR_ID," ).append("\n"); 
		query.append(" EAI_EVNT_DT" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("	 SELECT" ).append("\n"); 
		query.append("	 @[new_csr_no] CSR_NO," ).append("\n"); 
		query.append("	 LINE_SEQ," ).append("\n"); 
		query.append("	 '' LINE_NO," ).append("\n"); 
		query.append("	 LINE_TP_LU_CD," ).append("\n"); 
		query.append("	 -INV_AMT INV_AMT," ).append("\n"); 
		query.append("	 INV_DESC," ).append("\n"); 
		query.append("	 INV_TAX_CD," ).append("\n"); 
		query.append("	 DTRB_COA_CO_CD," ).append("\n"); 
		query.append("	 DTRB_COA_RGN_CD," ).append("\n"); 
		query.append("	 DTRB_COA_CTR_CD," ).append("\n"); 
		query.append("	 DTRB_COA_ACCT_CD," ).append("\n"); 
		query.append("	 DTRB_COA_VVD_CD," ).append("\n"); 
		query.append("	 DTRB_COA_INTER_CO_CD," ).append("\n"); 
		query.append("	 DTRB_COA_FTU_N1ST_CD," ).append("\n"); 
		query.append("	 DTRB_COA_FTU_N2ND_CD," ).append("\n"); 
		query.append("	 ATTR_CATE_NM," ).append("\n"); 
		query.append("	 'SELCOT_'||ATTR_CTNT1 ATTR_CTNT1," ).append("\n"); 
		query.append("	 ATTR_CTNT2," ).append("\n"); 
		query.append("	 ATTR_CTNT3," ).append("\n"); 
		query.append("	 ATTR_CTNT4," ).append("\n"); 
		query.append("	 ATTR_CTNT5," ).append("\n"); 
		query.append("	 ATTR_CTNT6," ).append("\n"); 
		query.append("	 ATTR_CTNT7," ).append("\n"); 
		query.append("	 ATTR_CTNT8," ).append("\n"); 
		query.append("	 ATTR_CTNT9," ).append("\n"); 
		query.append("	 ATTR_CTNT10," ).append("\n"); 
		query.append("	 ATTR_CTNT11," ).append("\n"); 
		query.append("	 ATTR_CTNT12," ).append("\n"); 
		query.append("	 ATTR_CTNT13," ).append("\n"); 
		query.append("	 ATTR_CTNT14," ).append("\n"); 
		query.append("	 ATTR_CTNT15," ).append("\n"); 
		query.append("	 BKG_NO," ).append("\n"); 
		query.append("	 CNTR_TPSZ_CD," ).append("\n"); 
		query.append("	 ACT_VVD_CD," ).append("\n"); 
		query.append("	 PLN_SCTR_DIV_CD," ).append("\n"); 
		query.append("	 SO_CRR_CD," ).append("\n"); 
		query.append("	 YD_CD," ).append("\n"); 
		query.append("	 FTU_USE_CTNT1," ).append("\n"); 
		query.append("	 FTU_USE_CTNT2," ).append("\n"); 
		query.append("	 FTU_USE_CTNT3," ).append("\n"); 
		query.append("	 FTU_USE_CTNT4," ).append("\n"); 
		query.append("	 FTU_USE_CTNT5," ).append("\n"); 
		query.append("	 SYSDATE CRE_DT," ).append("\n"); 
		query.append("	 @[usr_id] CRE_USR_ID," ).append("\n"); 
		query.append("	 EAI_EVNT_DT" ).append("\n"); 
		query.append("	 FROM   AP_INV_DTRB" ).append("\n"); 
		query.append("	 WHERE  CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("	 AND    BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	 AND    DTRB_COA_VVD_CD = @[old_vsl_cd]||@[old_skd_voy_no]||@[old_skd_dir_cd]||@[old_rev_dir_cd]" ).append("\n"); 
		query.append("	 UNION ALL" ).append("\n"); 
		query.append("	 SELECT" ).append("\n"); 
		query.append("	 @[new_csr_no] CSR_NO," ).append("\n"); 
		query.append("	 LINE_SEQ," ).append("\n"); 
		query.append("	 '' LINE_NO," ).append("\n"); 
		query.append("	 LINE_TP_LU_CD," ).append("\n"); 
		query.append("	 INV_AMT INV_AMT," ).append("\n"); 
		query.append("	 INV_DESC," ).append("\n"); 
		query.append("	 INV_TAX_CD," ).append("\n"); 
		query.append("	 DTRB_COA_CO_CD," ).append("\n"); 
		query.append("	 DTRB_COA_RGN_CD," ).append("\n"); 
		query.append("	 DTRB_COA_CTR_CD," ).append("\n"); 
		query.append("	 DTRB_COA_ACCT_CD," ).append("\n"); 
		query.append("	 @[New_vsl_cd]||@[new_skd_voy_no]||@[new_skd_dir_cd]||@[new_rev_dir_cd] DTRB_COA_VVD_CD," ).append("\n"); 
		query.append("	 DTRB_COA_INTER_CO_CD," ).append("\n"); 
		query.append("	 DTRB_COA_FTU_N1ST_CD," ).append("\n"); 
		query.append("	 DTRB_COA_FTU_N2ND_CD," ).append("\n"); 
		query.append("	 ATTR_CATE_NM," ).append("\n"); 
		query.append("	 'SELCOT_'||ATTR_CTNT1 ATTR_CTNT1," ).append("\n"); 
		query.append("	 ATTR_CTNT2," ).append("\n"); 
		query.append("	 ATTR_CTNT3," ).append("\n"); 
		query.append("	 ATTR_CTNT4," ).append("\n"); 
		query.append("	 ATTR_CTNT5," ).append("\n"); 
		query.append("	 ATTR_CTNT6," ).append("\n"); 
		query.append("	 ATTR_CTNT7," ).append("\n"); 
		query.append("	 ATTR_CTNT8," ).append("\n"); 
		query.append("	 ATTR_CTNT9," ).append("\n"); 
		query.append("	 ATTR_CTNT10," ).append("\n"); 
		query.append("	 ATTR_CTNT11," ).append("\n"); 
		query.append("	 ATTR_CTNT12," ).append("\n"); 
		query.append("	 ATTR_CTNT13," ).append("\n"); 
		query.append("	 ATTR_CTNT14," ).append("\n"); 
		query.append("	 ATTR_CTNT15," ).append("\n"); 
		query.append("	 BKG_NO," ).append("\n"); 
		query.append("	 CNTR_TPSZ_CD," ).append("\n"); 
		query.append("	 ACT_VVD_CD," ).append("\n"); 
		query.append("	 PLN_SCTR_DIV_CD," ).append("\n"); 
		query.append("	 SO_CRR_CD," ).append("\n"); 
		query.append("	 YD_CD," ).append("\n"); 
		query.append("	 FTU_USE_CTNT1," ).append("\n"); 
		query.append("	 FTU_USE_CTNT2," ).append("\n"); 
		query.append("	 FTU_USE_CTNT3," ).append("\n"); 
		query.append("	 FTU_USE_CTNT4," ).append("\n"); 
		query.append("	 FTU_USE_CTNT5," ).append("\n"); 
		query.append("	 SYSDATE CRE_DT," ).append("\n"); 
		query.append("	 @[usr_id] CRE_USR_ID," ).append("\n"); 
		query.append("	 EAI_EVNT_DT" ).append("\n"); 
		query.append("	 FROM   AP_INV_DTRB" ).append("\n"); 
		query.append("	 WHERE  CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("	 AND    BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	 AND    DTRB_COA_VVD_CD = @[old_vsl_cd]||@[old_skd_voy_no]||@[old_skd_dir_cd]||@[old_rev_dir_cd]" ).append("\n"); 
		query.append(" )" ).append("\n"); 

	}
}