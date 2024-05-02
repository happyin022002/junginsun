/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOCreateBkgCopyPrdMstVvdUnchangeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.15
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.11.15 정선용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author sun yong Jung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOCreateBkgCopyPrdMstVvdUnchangeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateBkgCopyPrdMstVvdUnchange
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOCreateBkgCopyPrdMstVvdUnchangeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("copy_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_ofc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOCreateBkgCopyPrdMstVvdUnchangeCSQL").append("\n"); 
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
		query.append("INSERT INTO PRD_PROD_CTL_MST" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("PCTL_NO,MTY_PKUP_YD_CD,POR_CD," ).append("\n"); 
		query.append("POR_NOD_CD,POL_CD,N1ST_TS_PORT_CD,N2ND_TS_PORT_CD,N3RD_TS_PORT_CD," ).append("\n"); 
		query.append("POD_CD,DEL_CD,DEL_NOD_CD,MTY_RTN_YD_CD,TTL_TZTM_HRS," ).append("\n"); 
		query.append("TTL_EXPN_AMT,TRNK_AVAL_SPC," ).append("\n"); 
		query.append("OB_ITCHG_CTNT,IB_ITCHG_CTNT,TRNK_VSL_CD,TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("TRNK_SKD_DIR_CD,N1ST_VSL_LODG_DUE_DT,MCNTR_DOR_ARR_DUE_DT,CNST_FLG,BKG_CGO_TP_CD," ).append("\n"); 
		query.append("BKG_RCV_TERM_CD,BKG_DE_TERM_CD, SHPR_CNT_CD," ).append("\n"); 
		query.append("SHPR_SEQ,CNEE_CNT_CD,CNEE_SEQ, SC_NO, RFA_NO," ).append("\n"); 
		query.append("DG_CLSS_CD,DG_SPCL_FLG,RF_SPCL_FLG," ).append("\n"); 
		query.append("SPCL_AWK_CGO_FLG,BB_SPCL_FLG,RD_SPCL_FLG,HNGR_SPCL_FLG,SOC_FLG," ).append("\n"); 
		query.append("EQ_SUBST_FLG,BKG_WGT,BKG_WGT_UT_CD," ).append("\n"); 
		query.append("SLS_OFC_CD,BKG_OFC_CD," ).append("\n"); 
		query.append("SC_OFC_CD,RFA_OFC_CD, PRM_CUST_FLG,ROUT_CNST_SEQ, CRE_USR_ID,CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID,UPD_DT, REP_CMDT_CD, CMDT_CD, FULL_RTN_YD_CD, POL_NOD_CD, POD_NOD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[hd_pctl_no]||lpad(@[copy_cnt],4,0), MTY_PKUP_YD_CD,POR_CD," ).append("\n"); 
		query.append("POR_NOD_CD,POL_CD,N1ST_TS_PORT_CD,N2ND_TS_PORT_CD,N3RD_TS_PORT_CD," ).append("\n"); 
		query.append("POD_CD,DEL_CD,DEL_NOD_CD,MTY_RTN_YD_CD,TTL_TZTM_HRS," ).append("\n"); 
		query.append("TTL_EXPN_AMT,TRNK_AVAL_SPC," ).append("\n"); 
		query.append("OB_ITCHG_CTNT,IB_ITCHG_CTNT,TRNK_VSL_CD,TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("TRNK_SKD_DIR_CD,N1ST_VSL_LODG_DUE_DT,MCNTR_DOR_ARR_DUE_DT,CNST_FLG,BKG_CGO_TP_CD," ).append("\n"); 
		query.append("BKG_RCV_TERM_CD,BKG_DE_TERM_CD,SHPR_CNT_CD," ).append("\n"); 
		query.append("SHPR_SEQ,CNEE_CNT_CD,CNEE_SEQ,NVL(@[sc_no],SC_NO),NVL(@[rfa_no],RFA_NO)," ).append("\n"); 
		query.append("DG_CLSS_CD,DG_SPCL_FLG,RF_SPCL_FLG," ).append("\n"); 
		query.append("SPCL_AWK_CGO_FLG,BB_SPCL_FLG,RD_SPCL_FLG,HNGR_SPCL_FLG,SOC_FLG," ).append("\n"); 
		query.append("EQ_SUBST_FLG,BKG_WGT,BKG_WGT_UT_CD," ).append("\n"); 
		query.append("SLS_OFC_CD,BKG_OFC_CD," ).append("\n"); 
		query.append("NVL(@[sc_ofc],SC_OFC_CD),NVL(@[rfa_ofc],RFA_OFC_CD),PRM_CUST_FLG, ROUT_CNST_SEQ, @[cre_usr_id],SYSDATE," ).append("\n"); 
		query.append("@[cre_usr_id],SYSDATE, REP_CMDT_CD, CMDT_CD, FULL_RTN_YD_CD, POL_NOD_CD, POD_NOD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_MST" ).append("\n"); 
		query.append("WHERE PCTL_NO = @[bkg_pctl_no]" ).append("\n"); 

	}
}