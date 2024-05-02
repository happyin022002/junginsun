/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOCreateChgRevenueVVDForApInvDTRBCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 김진
*@LastVersion : 1.0
* 2009.12.01 김진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOCreateChgRevenueVVDForApInvDTRBCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateChgRevenueVVDForApInvDTRB
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOCreateChgRevenueVVDForApInvDTRBCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("NEW_CSR_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("DTRB_COA_VVD_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("OLD_SKD_VOY_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("BKG_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("OLD_CSR_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("OLD_VSL_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("OLD_REV_DIR_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CRE_USR_ID",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("OLD_SKD_DIR_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CRE_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration ").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOCreateChgRevenueVVDForApInvDTRBCSQL").append("\n"); 
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
		query.append("CSR_NO" ).append("\n"); 
		query.append(",	LINE_SEQ" ).append("\n"); 
		query.append(",	LINE_NO" ).append("\n"); 
		query.append(",	LINE_TP_LU_CD" ).append("\n"); 
		query.append(",	INV_AMT" ).append("\n"); 
		query.append(",	INV_DESC" ).append("\n"); 
		query.append(",	INV_TAX_CD" ).append("\n"); 
		query.append(",	DTRB_COA_CO_CD" ).append("\n"); 
		query.append(",	DTRB_COA_RGN_CD" ).append("\n"); 
		query.append(",	DTRB_COA_CTR_CD" ).append("\n"); 
		query.append(",	DTRB_COA_ACCT_CD" ).append("\n"); 
		query.append(",	DTRB_COA_VVD_CD" ).append("\n"); 
		query.append(",	DTRB_COA_INTER_CO_CD" ).append("\n"); 
		query.append(",	DTRB_COA_FTU_N1ST_CD" ).append("\n"); 
		query.append(",	DTRB_COA_FTU_N2ND_CD" ).append("\n"); 
		query.append(",	ATTR_CATE_NM" ).append("\n"); 
		query.append(",	ATTR_CTNT1" ).append("\n"); 
		query.append(",	ATTR_CTNT2" ).append("\n"); 
		query.append(",	ATTR_CTNT3" ).append("\n"); 
		query.append(",	ATTR_CTNT4" ).append("\n"); 
		query.append(",	ATTR_CTNT5" ).append("\n"); 
		query.append(",	ATTR_CTNT6" ).append("\n"); 
		query.append(",	ATTR_CTNT7" ).append("\n"); 
		query.append(",	ATTR_CTNT8" ).append("\n"); 
		query.append(",	ATTR_CTNT9" ).append("\n"); 
		query.append(",	ATTR_CTNT10" ).append("\n"); 
		query.append(",	ATTR_CTNT11" ).append("\n"); 
		query.append(",	ATTR_CTNT12" ).append("\n"); 
		query.append(",	ATTR_CTNT13" ).append("\n"); 
		query.append(",	ATTR_CTNT14" ).append("\n"); 
		query.append(",	ATTR_CTNT15" ).append("\n"); 
		query.append(",	BKG_NO" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	ACT_VVD_CD" ).append("\n"); 
		query.append(",	PLN_SCTR_DIV_CD" ).append("\n"); 
		query.append(",	SO_CRR_CD" ).append("\n"); 
		query.append(",	YD_CD" ).append("\n"); 
		query.append(",	FTU_USE_CTNT1" ).append("\n"); 
		query.append(",	FTU_USE_CTNT2" ).append("\n"); 
		query.append(",	FTU_USE_CTNT3" ).append("\n"); 
		query.append(",	FTU_USE_CTNT4" ).append("\n"); 
		query.append(",	FTU_USE_CTNT5" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	EAI_EVNT_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[NEW_CSR_NO]            							NEW_CSR_NO" ).append("\n"); 
		query.append(",	ROWNUM       							LINE_SEQ" ).append("\n"); 
		query.append(",	LINE_NO" ).append("\n"); 
		query.append(",	LINE_TP_LU_CD" ).append("\n"); 
		query.append(",	INV_AMT" ).append("\n"); 
		query.append(",	INV_DESC" ).append("\n"); 
		query.append(",	INV_TAX_CD" ).append("\n"); 
		query.append(",	DTRB_COA_CO_CD" ).append("\n"); 
		query.append(",	DTRB_COA_RGN_CD" ).append("\n"); 
		query.append(",	DTRB_COA_CTR_CD" ).append("\n"); 
		query.append(",	DTRB_COA_ACCT_CD" ).append("\n"); 
		query.append(",	DTRB_COA_VVD_CD" ).append("\n"); 
		query.append(",	DTRB_COA_INTER_CO_CD" ).append("\n"); 
		query.append(",	DTRB_COA_FTU_N1ST_CD" ).append("\n"); 
		query.append(",	DTRB_COA_FTU_N2ND_CD" ).append("\n"); 
		query.append(",	ATTR_CATE_NM" ).append("\n"); 
		query.append(",	'SELCOL_'||ATTR_CTNT1||'_'||AP_INV_DTRB_SEQ1.NEXTVAL	ATTR_CTNT1      /* invoice no. 'SELCOL_'||ATTR_CTNT1 */" ).append("\n"); 
		query.append(",	ATTR_CTNT2" ).append("\n"); 
		query.append(",	ATTR_CTNT3" ).append("\n"); 
		query.append(",	ATTR_CTNT4" ).append("\n"); 
		query.append(",	ATTR_CTNT5" ).append("\n"); 
		query.append(",	ATTR_CTNT6" ).append("\n"); 
		query.append(",	ATTR_CTNT7" ).append("\n"); 
		query.append(",	ATTR_CTNT8" ).append("\n"); 
		query.append(",	ATTR_CTNT9" ).append("\n"); 
		query.append(",	ATTR_CTNT10" ).append("\n"); 
		query.append(",	ATTR_CTNT11" ).append("\n"); 
		query.append(",	ATTR_CTNT12" ).append("\n"); 
		query.append(",	ATTR_CTNT13" ).append("\n"); 
		query.append(",	ATTR_CTNT14" ).append("\n"); 
		query.append(",	ATTR_CTNT15" ).append("\n"); 
		query.append(",	BKG_NO" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	ACT_VVD_CD" ).append("\n"); 
		query.append(",	PLN_SCTR_DIV_CD" ).append("\n"); 
		query.append(",	SO_CRR_CD" ).append("\n"); 
		query.append(",	YD_CD" ).append("\n"); 
		query.append(",	FTU_USE_CTNT1" ).append("\n"); 
		query.append(",	FTU_USE_CTNT2" ).append("\n"); 
		query.append(",	FTU_USE_CTNT3" ).append("\n"); 
		query.append(",	FTU_USE_CTNT4" ).append("\n"); 
		query.append(",	FTU_USE_CTNT5" ).append("\n"); 
		query.append(",	GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[CRE_OFC_CD]) 	CRE_DT" ).append("\n"); 
		query.append(",	@[CRE_USR_ID]                                    	CRE_USR_ID" ).append("\n"); 
		query.append(",	EAI_EVNT_DT" ).append("\n"); 
		query.append("FROM      (" ).append("\n"); 
		query.append("SELECT    * FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("LINE_SEQ" ).append("\n"); 
		query.append(",	LINE_NO" ).append("\n"); 
		query.append(",	LINE_TP_LU_CD" ).append("\n"); 
		query.append(",	INV_AMT * (-1)      		INV_AMT" ).append("\n"); 
		query.append(",	INV_DESC" ).append("\n"); 
		query.append(",	INV_TAX_CD" ).append("\n"); 
		query.append(",	DTRB_COA_CO_CD" ).append("\n"); 
		query.append(",	DTRB_COA_RGN_CD" ).append("\n"); 
		query.append(",	DTRB_COA_CTR_CD" ).append("\n"); 
		query.append(",	DTRB_COA_ACCT_CD" ).append("\n"); 
		query.append(",	DTRB_COA_VVD_CD" ).append("\n"); 
		query.append(",	DTRB_COA_INTER_CO_CD" ).append("\n"); 
		query.append(",	DTRB_COA_FTU_N1ST_CD" ).append("\n"); 
		query.append(",	DTRB_COA_FTU_N2ND_CD" ).append("\n"); 
		query.append(",	ATTR_CATE_NM" ).append("\n"); 
		query.append(",	ATTR_CTNT1      							/* invoice no. 'SELCOL_'||ATTR_CTNT1 */" ).append("\n"); 
		query.append(",	ATTR_CTNT2" ).append("\n"); 
		query.append(",	ATTR_CTNT3" ).append("\n"); 
		query.append(",	ATTR_CTNT4" ).append("\n"); 
		query.append(",	ATTR_CTNT5" ).append("\n"); 
		query.append(",	ATTR_CTNT6" ).append("\n"); 
		query.append(",	ATTR_CTNT7" ).append("\n"); 
		query.append(",	ATTR_CTNT8" ).append("\n"); 
		query.append(",	ATTR_CTNT9" ).append("\n"); 
		query.append(",	ATTR_CTNT10" ).append("\n"); 
		query.append(",	ATTR_CTNT11" ).append("\n"); 
		query.append(",	ATTR_CTNT12" ).append("\n"); 
		query.append(",	ATTR_CTNT13" ).append("\n"); 
		query.append(",	ATTR_CTNT14" ).append("\n"); 
		query.append(",	ATTR_CTNT15" ).append("\n"); 
		query.append(",	BKG_NO" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	ACT_VVD_CD" ).append("\n"); 
		query.append(",	PLN_SCTR_DIV_CD" ).append("\n"); 
		query.append(",	SO_CRR_CD" ).append("\n"); 
		query.append(",	YD_CD" ).append("\n"); 
		query.append(",	FTU_USE_CTNT1" ).append("\n"); 
		query.append(",	FTU_USE_CTNT2" ).append("\n"); 
		query.append(",	FTU_USE_CTNT3" ).append("\n"); 
		query.append(",	FTU_USE_CTNT4" ).append("\n"); 
		query.append(",	FTU_USE_CTNT5" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	EAI_EVNT_DT" ).append("\n"); 
		query.append("FROM      		AP_INV_DTRB     		D" ).append("\n"); 
		query.append("WHERE     		D.CSR_NO        		= @[OLD_CSR_NO]		/* Old Csr No		*/" ).append("\n"); 
		query.append("AND       		D.BKG_NO        		= @[BKG_NO]		/* Old Bkg No		*/" ).append("\n"); 
		query.append("AND       		D.DTRB_COA_VVD_CD 		= @[DTRB_COA_VVD_CD]		/* Old R.VVD		*/" ).append("\n"); 
		query.append("ORDER BY  		D.LINE_SEQ      		ASC" ).append("\n"); 
		query.append(", 	D.LINE_NO       		ASC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT    * FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("D.LINE_SEQ" ).append("\n"); 
		query.append(",	D.LINE_NO" ).append("\n"); 
		query.append(",	D.LINE_TP_LU_CD" ).append("\n"); 
		query.append(",	D.INV_AMT" ).append("\n"); 
		query.append(",	D.INV_DESC" ).append("\n"); 
		query.append(",	D.INV_TAX_CD" ).append("\n"); 
		query.append(",	D.DTRB_COA_CO_CD" ).append("\n"); 
		query.append(",	D.DTRB_COA_RGN_CD" ).append("\n"); 
		query.append(",	D.DTRB_COA_CTR_CD" ).append("\n"); 
		query.append(",	D.DTRB_COA_ACCT_CD" ).append("\n"); 
		query.append(",	R.NEW_VSL_CD||R.NEW_SKD_VOY_NO||R.NEW_SKD_DIR_CD||R.NEW_REV_DIR_CD  DTRB_COA_VVD_CD        /* changed R.VVD */" ).append("\n"); 
		query.append(",	D.DTRB_COA_INTER_CO_CD" ).append("\n"); 
		query.append(",	D.DTRB_COA_FTU_N1ST_CD" ).append("\n"); 
		query.append(",	D.DTRB_COA_FTU_N2ND_CD" ).append("\n"); 
		query.append(",	D.ATTR_CATE_NM" ).append("\n"); 
		query.append(",	D.ATTR_CTNT1          								/* invoice no. 'SELCOL_'||ATTR_CTNT1 */" ).append("\n"); 
		query.append(",	D.ATTR_CTNT2" ).append("\n"); 
		query.append(",	D.ATTR_CTNT3" ).append("\n"); 
		query.append(",	D.ATTR_CTNT4" ).append("\n"); 
		query.append(",	D.ATTR_CTNT5" ).append("\n"); 
		query.append(",	D.ATTR_CTNT6" ).append("\n"); 
		query.append(",	D.ATTR_CTNT7" ).append("\n"); 
		query.append(",	D.ATTR_CTNT8" ).append("\n"); 
		query.append(",	D.ATTR_CTNT9" ).append("\n"); 
		query.append(",	D.ATTR_CTNT10" ).append("\n"); 
		query.append(",	D.ATTR_CTNT11" ).append("\n"); 
		query.append(",	D.ATTR_CTNT12" ).append("\n"); 
		query.append(",	D.ATTR_CTNT13" ).append("\n"); 
		query.append(",	D.ATTR_CTNT14" ).append("\n"); 
		query.append(",	D.ATTR_CTNT15" ).append("\n"); 
		query.append(",	D.BKG_NO" ).append("\n"); 
		query.append(",	D.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	R.NEW_VSL_CD||R.NEW_SKD_VOY_NO||R.NEW_SKD_DIR_CD||R.NEW_REV_DIR_CD  ACT_VVD_CD          /* changed R.VVD */" ).append("\n"); 
		query.append(",	D.PLN_SCTR_DIV_CD" ).append("\n"); 
		query.append(",	D.SO_CRR_CD" ).append("\n"); 
		query.append(",	D.YD_CD" ).append("\n"); 
		query.append(",	D.FTU_USE_CTNT1" ).append("\n"); 
		query.append(",	D.FTU_USE_CTNT2" ).append("\n"); 
		query.append(",	D.FTU_USE_CTNT3" ).append("\n"); 
		query.append(",	D.FTU_USE_CTNT4" ).append("\n"); 
		query.append(",	D.FTU_USE_CTNT5" ).append("\n"); 
		query.append(",	D.CRE_DT" ).append("\n"); 
		query.append(",	D.CRE_USR_ID" ).append("\n"); 
		query.append(",	D.EAI_EVNT_DT" ).append("\n"); 
		query.append("FROM      		AP_INV_DTRB     		D" ).append("\n"); 
		query.append(", 	LEA_REV_VVD_CNG 		R" ).append("\n"); 
		query.append("WHERE    		D.CSR_NO        		= R.CSR_NO" ).append("\n"); 
		query.append("AND       		D.BKG_NO        		= R.BKG_NO" ).append("\n"); 
		query.append("AND       	   (R.NEW_REV_YRMON    		IS NULL" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("R.NEW_REV_YRMON   		<> R.OLD_REV_YRMON" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND       		D.CSR_NO        		= @[OLD_CSR_NO]        /* Old Csr No		*/" ).append("\n"); 
		query.append("AND       		D.BKG_NO        		= @[BKG_NO]        /* Old Bkg No		*/" ).append("\n"); 
		query.append("AND       		R.OLD_VSL_CD    		= @[OLD_VSL_CD]        /* Old Vsl No		*/" ).append("\n"); 
		query.append("AND       		R.OLD_SKD_VOY_NO		= @[OLD_SKD_VOY_NO]        /* Old Skd Voy No	*/" ).append("\n"); 
		query.append("AND       		R.OLD_SKD_DIR_CD		= @[OLD_SKD_DIR_CD]        /* Old Skd Dir Cd	*/" ).append("\n"); 
		query.append("AND       		R.OLD_REV_DIR_CD		= @[OLD_REV_DIR_CD]        /* Old Rev Dir Cd	*/" ).append("\n"); 
		query.append("ORDER BY  		D.LINE_SEQ    			ASC" ).append("\n"); 
		query.append(",  	D.LINE_NO     			ASC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}