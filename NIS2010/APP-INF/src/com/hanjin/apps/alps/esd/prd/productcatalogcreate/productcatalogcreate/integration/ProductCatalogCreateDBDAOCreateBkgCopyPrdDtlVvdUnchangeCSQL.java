/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOCreateBkgCopyPrdDtlVvdUnchangeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.09.17 정선용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author sun yong Jung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOCreateBkgCopyPrdDtlVvdUnchangeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateBkgCopyPrdDtlVvdUnchange
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOCreateBkgCopyPrdDtlVvdUnchangeCSQL(){
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
		params.put("hd_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration ").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOCreateBkgCopyPrdDtlVvdUnchangeCSQL").append("\n"); 
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
		query.append("INSERT INTO" ).append("\n"); 
		query.append("PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("PCTL_NO,PCTL_SEQ,ORG_NOD_CD,DEST_NOD_CD,NOD_LNK_DIV_CD," ).append("\n"); 
		query.append("PCTL_IO_BND_CD,TRSP_MOD_CD,PCTL_WTR_DIV_CD,ORG_NOD_TP_CD,DEST_NOD_TP_CD," ).append("\n"); 
		query.append("MTY_YD_FLG,ARR_ST_DT,DEP_FSH_DT,TZ_DWLL_TM_HRS,N1ST_VNDR_SEQ," ).append("\n"); 
		query.append("N2ND_VNDR_SEQ,N3RD_VNDR_SEQ,VSL_SLAN_CD,CRR_CD,VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO,SKD_DIR_CD,GEN_AVAL_SPC,D7_AVAL_SPC,RF_AVAL_SPC," ).append("\n"); 
		query.append("--CUST_NOMI_TRKR_FLG," ).append("\n"); 
		query.append("INLND_ROUT_INV_BIL_PATT_CD,INLND_ROUT_CMB_FLG,ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("ROUT_SEQ," ).append("\n"); 
		query.append("CNST_FLG, ORG_CLPT_IND_SEQ, DEST_CLPT_IND_SEQ, RAIL_CRR_TP_CD," ).append("\n"); 
		query.append("INLND_ROUT_INCL_STTL_FLG, TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ, AGMT_REF_NO," ).append("\n"); 
		query.append("CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[hd_pctl_no]||lpad(@[copy_cnt],4,0),PCTL_SEQ,ORG_NOD_CD,DEST_NOD_CD,NOD_LNK_DIV_CD," ).append("\n"); 
		query.append("PCTL_IO_BND_CD,TRSP_MOD_CD,PCTL_WTR_DIV_CD,ORG_NOD_TP_CD,DEST_NOD_TP_CD," ).append("\n"); 
		query.append("MTY_YD_FLG,ARR_ST_DT,DEP_FSH_DT,TZ_DWLL_TM_HRS,N1ST_VNDR_SEQ," ).append("\n"); 
		query.append("N2ND_VNDR_SEQ,N3RD_VNDR_SEQ,VSL_SLAN_CD,CRR_CD,VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO,SKD_DIR_CD,GEN_AVAL_SPC,D7_AVAL_SPC,RF_AVAL_SPC," ).append("\n"); 
		query.append("--CUST_NOMI_TRKR_FLG," ).append("\n"); 
		query.append("INLND_ROUT_INV_BIL_PATT_CD,INLND_ROUT_CMB_FLG,ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("ROUT_SEQ," ).append("\n"); 
		query.append("CNST_FLG, ORG_CLPT_IND_SEQ, DEST_CLPT_IND_SEQ, RAIL_CRR_TP_CD," ).append("\n"); 
		query.append("INLND_ROUT_INCL_STTL_FLG, TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ, AGMT_REF_NO," ).append("\n"); 
		query.append("@[cre_usr_id], sysdate, @[cre_usr_id], sysdate" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE PCTL_NO = @[bkg_pctl_no]" ).append("\n"); 

	}
}