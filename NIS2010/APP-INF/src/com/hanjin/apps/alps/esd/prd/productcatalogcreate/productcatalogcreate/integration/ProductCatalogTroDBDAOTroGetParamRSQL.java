/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ProductCatalogTroDBDAOTroGetParamRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 조용인
*@LastVersion : 1.0
* 2010.03.24 조용인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author cho yong in
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogTroDBDAOTroGetParamRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TroGetParam
	  * </pre>
	  */
	public ProductCatalogTroDBDAOTroGetParamRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogTroDBDAOTroGetParamRSQL").append("\n"); 
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
		query.append("SELECT  H.PCTL_NO," ).append("\n"); 
		query.append("H.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("NVL(BC.RCV_TERM_CD,M.BKG_RCV_TERM_CD)  BKG_RCV_TERM_CD," ).append("\n"); 
		query.append("NVL(BC.DE_TERM_CD,M.BKG_DE_TERM_CD)    BKG_DE_TERM_CD," ).append("\n"); 
		query.append("(SELECT FM_NOD_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT FM_NOD_CD" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("WHERE  COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND TRIM(DOR_NOD_CD) IS NOT NULL" ).append("\n"); 
		query.append("AND TRSP_BND_CD ='O'" ).append("\n"); 
		query.append("AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT NOD_CD" ).append("\n"); 
		query.append("FROM SCE_COP_DTL" ).append("\n"); 
		query.append("WHERE COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND ACT_CD = 'MOTYDO'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM =1 ) MT_PU," ).append("\n"); 
		query.append("(SELECT TO_NOD_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT TO_NOD_CD" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("WHERE  COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND TRIM(DOR_NOD_CD) IS NOT NULL" ).append("\n"); 
		query.append("AND TRSP_BND_CD ='I'" ).append("\n"); 
		query.append("AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT NOD_CD" ).append("\n"); 
		query.append("FROM SCE_COP_DTL" ).append("\n"); 
		query.append("WHERE COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND ACT_CD = 'MITYAD'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM =1 ) MT_RTN," ).append("\n"); 
		query.append("(SELECT (CASE WHEN T.TRSP_BND_CD = 'I' AND T.COST_ACT_GRP_SEQ = (SELECT MIN(COST_ACT_GRP_SEQ)" ).append("\n"); 
		query.append("FROM SCE_PLN_SO_LIST" ).append("\n"); 
		query.append("WHERE COP_NO = S.COP_NO" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD ='I')" ).append("\n"); 
		query.append("THEN 'N'" ).append("\n"); 
		query.append("WHEN T.TRSP_BND_CD = 'O' AND T.COST_ACT_GRP_SEQ = (SELECT MAX(COST_ACT_GRP_SEQ)" ).append("\n"); 
		query.append("FROM SCE_PLN_SO_LIST" ).append("\n"); 
		query.append("WHERE COP_NO = S.COP_NO" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD ='O')" ).append("\n"); 
		query.append("THEN 'N'" ).append("\n"); 
		query.append("END ) INCL_SHTL_SO_FLG" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD T , SCE_COP_HDR S" ).append("\n"); 
		query.append("WHERE T.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND T.TRSP_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND NVL(T.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND T.COP_NO =S.COP_NO" ).append("\n"); 
		query.append("AND ROWNUM =1 ) INCL_SHTL_SO_FLG," ).append("\n"); 
		query.append("D.ROUT_ORG_NOD_CD,D.ROUT_DEST_NOD_CD,D.ROUT_SEQ," ).append("\n"); 
		query.append("(SELECT TO_CHAR(MAX(ARR_ST_DT),'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE PCTL_NO =H.PCTL_NO" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD ='O') CCT ," ).append("\n"); 
		query.append("(SELECT TO_CHAR(MIN(ARR_ST_DT),'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE PCTL_NO =H.PCTL_NO" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD ='T') POL_T," ).append("\n"); 
		query.append("(SELECT TO_CHAR(MIN(ARR_ST_DT),'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE PCTL_NO =H.PCTL_NO" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD ='I') POD_T" ).append("\n"); 
		query.append("FROM SCE_COP_HDR H, BKG_CONTAINER BC, PRD_PROD_CTL_MST M, PRD_PROD_CTL_ROUT_DTL D" ).append("\n"); 
		query.append("WHERE H.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND H.PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("AND H.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("AND D.PCTL_IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND H.BKG_NO = BC.BKG_NO(+)" ).append("\n"); 
		query.append("AND H.CNTR_NO = BC.CNTR_NO(+)" ).append("\n"); 
		query.append("AND ROWNUM =1" ).append("\n"); 

	}
}