/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ProductCatalogHinterlandDBDAOCopyRfActivityGroupCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.21
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogHinterlandDBDAOCopyRfActivityGroupCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ProductCatalogHinterlandDBDAOCopyRfActivityGroupCSQL
	  * </pre>
	  */
	public ProductCatalogHinterlandDBDAOCopyRfActivityGroupCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration ").append("\n"); 
		query.append("FileName : ProductCatalogHinterlandDBDAOCopyRfActivityGroupCSQL").append("\n"); 
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
		query.append("INSERT INTO PRD_PROD_CTL_ACT_GRP_DTL" ).append("\n"); 
		query.append("(pctl_no" ).append("\n"); 
		query.append(",COST_ACT_GRP_SEQ,COST_ACT_GRP_CD,COST_ACT_GRP_TP_CD,VSL_SLAN_CD,CTRL_OFC_CD,PCTL_COST_MOD_CD,PCTL_IO_BND_CD" ).append("\n"); 
		query.append(",N1ST_NOD_CD,N1ST_NOD_TP_CD,N1ST_NOD_PLN_DT,N2ND_NOD_CD,N3RD_NOD_CD,N4TH_NOD_CD,TRSP_MOD_CD,N1ST_LNK_DIST" ).append("\n"); 
		query.append(",N1ST_LNK_DIST_UT_CD,N2ND_LNK_DIST,N2ND_LNK_DIST_UT_CD,N3RD_LNK_DIST,N3RD_DIST_UT_CD,N1ST_VNDR_SEQ,N2ND_VNDR_SEQ" ).append("\n"); 
		query.append(",N3RD_VNDR_SEQ,INLND_ROUT_INV_BIL_PATT_CD,N1ST_RAIL_CRR_TP_CD,N2ND_RAIL_CRR_TP_CD,N3RD_RAIL_CRR_TP_CD,PRE_NOD_CD" ).append("\n"); 
		query.append(",PRE_VNDR_SEQ,NXT_NOD_CD,NXT_VNDR_SEQ,TRSP_SO_STS_CD,ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD,ROUT_SEQ,INV_BIL_PATT_DIV_FLG" ).append("\n"); 
		query.append(",INLND_ROUT_INCL_STTL_FLG,N1ST_TRSP_AGMT_SEQ,N2ND_TRSP_AGMT_SEQ,N3RD_TRSP_AGMT_SEQ,N1ST_AGMT_REF_NO,N2ND_AGMT_REF_NO" ).append("\n"); 
		query.append(",N3RD_AGMT_REF_NO,N1ST_TRSP_AGMT_OFC_CTY_CD,N2ND_TRSP_AGMT_OFC_CTY_CD,N3RD_TRSP_AGMT_OFC_CTY_CD,DOR_ARR_DT" ).append("\n"); 
		query.append(",LST_NOD_ARR_DT,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT)" ).append("\n"); 
		query.append("select @[hd_pctl_no]||LPAD(TO_NUMBER(SUBSTR(@[max_pctl_no], -4))+TO_NUMBER(SUBSTR(PCTL_NO, -4)) ,4,'0') pctl_no" ).append("\n"); 
		query.append(",COST_ACT_GRP_SEQ,COST_ACT_GRP_CD,COST_ACT_GRP_TP_CD,VSL_SLAN_CD,CTRL_OFC_CD,PCTL_COST_MOD_CD,PCTL_IO_BND_CD" ).append("\n"); 
		query.append(",N1ST_NOD_CD,N1ST_NOD_TP_CD,N1ST_NOD_PLN_DT,N2ND_NOD_CD,N3RD_NOD_CD,N4TH_NOD_CD,TRSP_MOD_CD,N1ST_LNK_DIST" ).append("\n"); 
		query.append(",N1ST_LNK_DIST_UT_CD,N2ND_LNK_DIST,N2ND_LNK_DIST_UT_CD,N3RD_LNK_DIST,N3RD_DIST_UT_CD,N1ST_VNDR_SEQ,N2ND_VNDR_SEQ" ).append("\n"); 
		query.append(",N3RD_VNDR_SEQ,INLND_ROUT_INV_BIL_PATT_CD,N1ST_RAIL_CRR_TP_CD,N2ND_RAIL_CRR_TP_CD,N3RD_RAIL_CRR_TP_CD,PRE_NOD_CD" ).append("\n"); 
		query.append(",PRE_VNDR_SEQ,NXT_NOD_CD,NXT_VNDR_SEQ,TRSP_SO_STS_CD,ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD,ROUT_SEQ,INV_BIL_PATT_DIV_FLG" ).append("\n"); 
		query.append(",INLND_ROUT_INCL_STTL_FLG,N1ST_TRSP_AGMT_SEQ,N2ND_TRSP_AGMT_SEQ,N3RD_TRSP_AGMT_SEQ,N1ST_AGMT_REF_NO,N2ND_AGMT_REF_NO" ).append("\n"); 
		query.append(",N3RD_AGMT_REF_NO,N1ST_TRSP_AGMT_OFC_CTY_CD,N2ND_TRSP_AGMT_OFC_CTY_CD,N3RD_TRSP_AGMT_OFC_CTY_CD,DOR_ARR_DT" ).append("\n"); 
		query.append(",LST_NOD_ARR_DT,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT" ).append("\n"); 
		query.append("from PRD_PROD_CTL_ACT_GRP_DTL" ).append("\n"); 
		query.append("where  PCTL_NO LIKE DECODE(@[hd_pctl_no], NULL, NULL, @[hd_pctl_no] || '%')" ).append("\n"); 

	}
}