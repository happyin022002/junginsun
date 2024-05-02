/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOCreateBkgCopyPrdActGrpDtlVvdUnchangeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.15
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.11.15 정선용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author sun yong Jung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOCreateBkgCopyPrdActGrpDtlVvdUnchangeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateBkgCopyPrdActGrpDtlVvdUnchange
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOCreateBkgCopyPrdActGrpDtlVvdUnchangeCSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOCreateBkgCopyPrdActGrpDtlVvdUnchangeCSQL").append("\n"); 
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
		query.append("INSERT INTO  PRD_PROD_CTL_ACT_GRP_DTL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("PCTL_NO, COST_ACT_GRP_SEQ, COST_ACT_GRP_CD, COST_ACT_GRP_TP_CD, VSL_SLAN_CD," ).append("\n"); 
		query.append("CTRL_OFC_CD, PCTL_COST_MOD_CD, PCTL_IO_BND_CD, N1ST_NOD_CD, N1ST_NOD_TP_CD," ).append("\n"); 
		query.append("N1ST_NOD_PLN_DT, N2ND_NOD_CD, N3RD_NOD_CD, N4TH_NOD_CD, TRSP_MOD_CD," ).append("\n"); 
		query.append("N1ST_LNK_DIST, N1ST_LNK_DIST_UT_CD, N2ND_LNK_DIST, N2ND_LNK_DIST_UT_CD, N3RD_LNK_DIST," ).append("\n"); 
		query.append("N3RD_DIST_UT_CD, N1ST_VNDR_SEQ, N2ND_VNDR_SEQ, N3RD_VNDR_SEQ, INLND_ROUT_INV_BIL_PATT_CD," ).append("\n"); 
		query.append("N1ST_RAIL_CRR_TP_CD, N2ND_RAIL_CRR_TP_CD, N3RD_RAIL_CRR_TP_CD," ).append("\n"); 
		query.append("PRE_NOD_CD, PRE_VNDR_SEQ, NXT_NOD_CD, NXT_VNDR_SEQ," ).append("\n"); 
		query.append("TRSP_SO_STS_CD, ROUT_ORG_NOD_CD, ROUT_DEST_NOD_CD, ROUT_SEQ ," ).append("\n"); 
		query.append("INV_BIL_PATT_DIV_FLG" ).append("\n"); 
		query.append(",INLND_ROUT_INCL_STTL_FLG, N1ST_TRSP_AGMT_SEQ, N2ND_TRSP_AGMT_SEQ, N3RD_TRSP_AGMT_SEQ," ).append("\n"); 
		query.append("N1ST_AGMT_REF_NO, N2ND_AGMT_REF_NO, N3RD_AGMT_REF_NO, N1ST_TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("N2ND_TRSP_AGMT_OFC_CTY_CD, N3RD_TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT, DOR_ARR_DT, LST_NOD_ARR_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[hd_pctl_no]||lpad(@[copy_cnt],4,0),COST_ACT_GRP_SEQ, COST_ACT_GRP_CD, COST_ACT_GRP_TP_CD, VSL_SLAN_CD," ).append("\n"); 
		query.append("CTRL_OFC_CD, PCTL_COST_MOD_CD, PCTL_IO_BND_CD, N1ST_NOD_CD, N1ST_NOD_TP_CD," ).append("\n"); 
		query.append("N1ST_NOD_PLN_DT, N2ND_NOD_CD, N3RD_NOD_CD, N4TH_NOD_CD, TRSP_MOD_CD," ).append("\n"); 
		query.append("N1ST_LNK_DIST, N1ST_LNK_DIST_UT_CD, N2ND_LNK_DIST, N2ND_LNK_DIST_UT_CD, N3RD_LNK_DIST," ).append("\n"); 
		query.append("N3RD_DIST_UT_CD, N1ST_VNDR_SEQ, N2ND_VNDR_SEQ, N3RD_VNDR_SEQ, INLND_ROUT_INV_BIL_PATT_CD," ).append("\n"); 
		query.append("N1ST_RAIL_CRR_TP_CD, N2ND_RAIL_CRR_TP_CD, N3RD_RAIL_CRR_TP_CD," ).append("\n"); 
		query.append("PRE_NOD_CD, PRE_VNDR_SEQ, NXT_NOD_CD, NXT_VNDR_SEQ," ).append("\n"); 
		query.append("TRSP_SO_STS_CD, ROUT_ORG_NOD_CD, ROUT_DEST_NOD_CD, ROUT_SEQ," ).append("\n"); 
		query.append("INV_BIL_PATT_DIV_FLG" ).append("\n"); 
		query.append(",INLND_ROUT_INCL_STTL_FLG, N1ST_TRSP_AGMT_SEQ, N2ND_TRSP_AGMT_SEQ, N3RD_TRSP_AGMT_SEQ," ).append("\n"); 
		query.append("N1ST_AGMT_REF_NO, N2ND_AGMT_REF_NO, N3RD_AGMT_REF_NO, N1ST_TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("N2ND_TRSP_AGMT_OFC_CTY_CD, N3RD_TRSP_AGMT_OFC_CTY_CD ," ).append("\n"); 
		query.append("@[cre_usr_id], sysdate, @[upd_usr_id], sysdate, DOR_ARR_DT, LST_NOD_ARR_DT" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ACT_GRP_DTL" ).append("\n"); 
		query.append("WHERE PCTL_NO = @[bkg_pctl_no]" ).append("\n"); 

	}
}