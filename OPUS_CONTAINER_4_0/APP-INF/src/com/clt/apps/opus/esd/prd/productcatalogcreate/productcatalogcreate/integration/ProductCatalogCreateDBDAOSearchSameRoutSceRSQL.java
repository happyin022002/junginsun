/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOSearchSameRoutSceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.25
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.11.25 정선용
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

public class ProductCatalogCreateDBDAOSearchSameRoutSceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSameRoutSce
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOSearchSameRoutSceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_term",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_trsp_mode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_pkup_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ocn_str",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_tro_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mt_pu",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mt_rtn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_tro_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d_term",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_str",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ib_trsp_mode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_str",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOSearchSameRoutSceRSQL").append("\n"); 
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
		query.append("SELECT PCTL_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT H.PCTL_NO," ).append("\n"); 
		query.append("NVL(BC.RCV_TERM_CD,M.BKG_RCV_TERM_CD)  BKG_RCV_TERM_CD," ).append("\n"); 
		query.append("NVL(BC.DE_TERM_CD,M.BKG_DE_TERM_CD)    BKG_DE_TERM_CD" ).append("\n"); 
		query.append("FROM SCE_COP_HDR H,PRD_PROD_CTL_MST M,SCE_COP_DTL PU, SCE_COP_DTL RTN, BKG_CONTAINER BC, PRD_PROD_CTL_ROUT_DTL O,PRD_PROD_CTL_ROUT_DTL I" ).append("\n"); 
		query.append("WHERE H.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND NVL(H.UMCH_STS_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("AND H.CNTR_NO = BC.CNTR_NO(+)" ).append("\n"); 
		query.append("AND H.BKG_NO = BC.BKG_NO(+)" ).append("\n"); 
		query.append("AND NVL(H.COP_STS_CD,'N') <> 'X'" ).append("\n"); 
		query.append("AND H.COP_NO = PU.COP_NO(+)" ).append("\n"); 
		query.append("AND PU.ACT_CD(+) = 'MOTYDO'" ).append("\n"); 
		query.append("AND PU.ACT_DT(+) IS NOT NULL" ).append("\n"); 
		query.append("AND H.COP_NO = RTN.COP_NO(+)" ).append("\n"); 
		query.append("AND RTN.ACT_CD(+) = 'MITYAD'" ).append("\n"); 
		query.append("AND RTN.ACT_DT(+) IS NOT NULL" ).append("\n"); 
		query.append("AND H.PCTL_NO = O.PCTL_NO" ).append("\n"); 
		query.append("AND O.PCTL_SEQ =1" ).append("\n"); 
		query.append("AND H.PCTL_NO =I.PCTL_NO" ).append("\n"); 
		query.append("AND I.PCTL_SEQ = (SELECT /*+ INDEX_DESC (I2 XPKPRD_PROD_CTL_ROUT_DTL)  */" ).append("\n"); 
		query.append("PCTL_SEQ" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL I2" ).append("\n"); 
		query.append("WHERE I2.PCTL_NO = I.PCTL_NO" ).append("\n"); 
		query.append("AND I2.PCTL_IO_BND_CD ='I'" ).append("\n"); 
		query.append("AND ROWNUM =1)" ).append("\n"); 
		query.append("AND NVL(PRD_GET_INLND_ROUT_STR_FNC(O.ROUT_ORG_NOD_CD,O.ROUT_DEST_NOD_CD,O.ROUT_SEQ),'%') LIKE REGEXP_REPLACE(@[out_str],'-...-','-')||'%'" ).append("\n"); 
		query.append("AND NVL(PRD_GET_INLND_ROUT_STR_FNC(I.ROUT_ORG_NOD_CD,I.ROUT_DEST_NOD_CD,I.ROUT_SEQ),'%') LIKE REGEXP_REPLACE(@[in_str],'-...-','-')||'%'" ).append("\n"); 
		query.append("AND NVL(PRD_GET_OCN_LINK_STR_FNC(H.COP_NO),'%') LIKE REGEXP_REPLACE(@[ocn_str],'-...-','-')||'%'" ).append("\n"); 
		query.append("AND NVL(PU.NOD_CD(+),'N') = NVL(@[mt_pu],NVL(PU.NOD_CD(+),'N'))" ).append("\n"); 
		query.append("AND NVL(RTN.NOD_CD(+),'N') = NVL(@[mt_rtn],NVL(RTN.NOD_CD(+),'N'))" ).append("\n"); 
		query.append("AND NVL(H.OB_TRO_FLG,'N') = NVL(@[ob_tro_flg],'N')" ).append("\n"); 
		query.append("AND NVL(H.IB_TRO_FLG,'N') = NVL(@[ib_tro_flg],'N')" ).append("\n"); 
		query.append("AND H.POR_NOD_CD = NVL(@[por_nod_cd],H.POR_NOD_CD)" ).append("\n"); 
		query.append("AND H.POL_NOD_CD = NVL(@[pol_nod_cd],H.POL_NOD_CD)" ).append("\n"); 
		query.append("AND H.DEL_NOD_CD = NVL(@[del_nod_cd],H.DEL_NOD_CD)" ).append("\n"); 
		query.append("AND M.FULL_RTN_YD_CD =NVL(@[full_rtn_yd_cd],M.FULL_RTN_YD_CD)" ).append("\n"); 
		query.append("AND M.FULL_PKUP_YD_CD =NVL(@[full_pkup_yd_cd],M.FULL_PKUP_YD_CD)" ).append("\n"); 
		query.append("AND NVL(@[ob_trsp_mode],'N') = NVL((SELECT TRSP_MOD_CD" ).append("\n"); 
		query.append("FROM PRD_INLND_ROUT_MST" ).append("\n"); 
		query.append("WHERE ROUT_ORG_NOD_CD =  O.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND  ROUT_DEST_NOD_CD =  O.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND ROUT_SEQ = O.ROUT_SEQ),'N')" ).append("\n"); 
		query.append("AND NVL(@[ib_trsp_mode],'N') = NVL((SELECT TRSP_MOD_CD" ).append("\n"); 
		query.append("FROM PRD_INLND_ROUT_MST" ).append("\n"); 
		query.append("WHERE ROUT_ORG_NOD_CD =  I.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND  ROUT_DEST_NOD_CD =  I.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND ROUT_SEQ = I.ROUT_SEQ),'N')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE BKG_RCV_TERM_CD =  @[r_term]" ).append("\n"); 
		query.append("AND BKG_DE_TERM_CD  = @[d_term]" ).append("\n"); 
		query.append("AND ROWNUM =1" ).append("\n"); 

	}
}