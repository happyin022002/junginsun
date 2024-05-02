/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOSearchRouteInfoByPctlNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOSearchRouteInfoByPctlNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRouteInfoByPctlNo
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOSearchRouteInfoByPctlNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOSearchRouteInfoByPctlNoRSQL").append("\n"); 
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
		query.append("SELECT POR_CD,POL_CD,POD_CD,DEL_CD,CNST_FLG," ).append("\n"); 
		query.append("(SELECT to_char(ARR_ST_DT,'yyyy-mm-dd') FROM PRD_PROD_CTL_ROUT_DTL P WHERE  P.PCTL_NO = D.PCTL_NO AND MTY_YD_FLG='Y' AND PCTL_IO_BND_CD='O'" ).append("\n"); 
		query.append(") MT_PU_DATE," ).append("\n"); 
		query.append("(SELECT to_char(MAX(ARR_ST_DT),'yyyy-mm-dd') FROM PRD_PROD_CTL_ROUT_DTL P WHERE  P.PCTL_NO = D.PCTL_NO AND PCTL_IO_BND_CD='I' AND NOD_LNK_DIV_CD = 'N' AND MTY_YD_FLG = 'N'" ).append("\n"); 
		query.append(") EST_ARR_DATE," ).append("\n"); 
		query.append("LTRIM (TO_CHAR (TRUNC (TTL_TZTM_HRS / 24, 0), '00'))  TRANSIT_DAY," ).append("\n"); 
		query.append("TTL_EXPN_AMT," ).append("\n"); 
		query.append("PCTL_NO,MTY_PKUP_YD_CD," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("TO_CHAR(min(ARR_ST_DT), 'YYYY-MM-DD')" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE  PCTL_NO = d.PCTL_NO" ).append("\n"); 
		query.append("AND TRSP_MOD_CD IN ('WD','VD')" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD = 'T'" ).append("\n"); 
		query.append(") LOAD_DT ," ).append("\n"); 
		query.append("(SELECT 'Y' chk FROM PRD_OCN_ROUT O ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT B0.ROUT_ORG_NOD_CD, B0.ROUT_DEST_NOD_CD, B0.ROUT_SEQ" ).append("\n"); 
		query.append("FROM (SELECT D.ROUT_ORG_NOD_CD, D.ROUT_DEST_NOD_CD, D.ROUT_SEQ, M.TTL_EXPN_AMT" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL D,PRD_PROD_CTL_MST M" ).append("\n"); 
		query.append("WHERE M.PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("AND 'DEHAM' IN (M.N1ST_TS_PORT_CD, M.N2ND_TS_PORT_CD, M.N3RD_TS_PORT_CD)" ).append("\n"); 
		query.append("AND M.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("AND D.PCTL_IO_BND_CD ='T'" ).append("\n"); 
		query.append(") B0," ).append("\n"); 
		query.append("(SELECT M.TTL_EXPN_AMT" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL D,PRD_PROD_CTL_MST M" ).append("\n"); 
		query.append("WHERE M.PCTL_NO LIKE SUBSTR(@[pctl_no],1,16)||'%'" ).append("\n"); 
		query.append("AND 'NLRTM' IN (M.N1ST_TS_PORT_CD, M.N2ND_TS_PORT_CD, M.N3RD_TS_PORT_CD)" ).append("\n"); 
		query.append("AND M.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("AND D.PCTL_IO_BND_CD ='T'" ).append("\n"); 
		query.append(") B1" ).append("\n"); 
		query.append("WHERE B0.TTL_EXPN_AMT > B1.TTL_EXPN_AMT" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND O.ORG_LOC_CD = B.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND O.DEST_LOC_CD = B.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND O.ROUT_SEQ <> B.ROUT_SEQ" ).append("\n"); 
		query.append("AND O.UPD_IND_CD  in ( 'S','T','A','V','G')" ).append("\n"); 
		query.append("AND 'NLRTM' NOT IN (O.ORG_LOC_CD, O.DEST_LOC_CD)" ).append("\n"); 
		query.append("AND 'NLRTM' IN (O.N1ST_POD_CD, O.N2ND_POD_CD, O.N3RD_POD_CD)" ).append("\n"); 
		query.append("AND NVL(O.N1ST_LANE_CD, 'X') <> 'CME'" ).append("\n"); 
		query.append("AND CASE" ).append("\n"); 
		query.append("when N4TH_POD_CD is not null then N4TH_POD_CD" ).append("\n"); 
		query.append("when N3RD_POD_CD is not null then N3RD_POD_CD" ).append("\n"); 
		query.append("when N2ND_POD_CD is not null then N2ND_POD_CD" ).append("\n"); 
		query.append("END NOT LIKE 'NO%'" ).append("\n"); 
		query.append("AND CASE" ).append("\n"); 
		query.append("when N4TH_POD_CD is not null then N4TH_POD_CD" ).append("\n"); 
		query.append("when N3RD_POD_CD is not null then N3RD_POD_CD" ).append("\n"); 
		query.append("when N2ND_POD_CD is not null then N2ND_POD_CD" ).append("\n"); 
		query.append("END NOT LIKE 'FI%'" ).append("\n"); 
		query.append("AND CASE" ).append("\n"); 
		query.append("when N4TH_POD_CD is not null then N4TH_POD_CD" ).append("\n"); 
		query.append("when N3RD_POD_CD is not null then N3RD_POD_CD" ).append("\n"); 
		query.append("when N2ND_POD_CD is not null then N2ND_POD_CD" ).append("\n"); 
		query.append("END NOT LIKE 'PL%'" ).append("\n"); 
		query.append("AND CASE" ).append("\n"); 
		query.append("when N4TH_POD_CD is not null then N4TH_POD_CD" ).append("\n"); 
		query.append("when N3RD_POD_CD is not null then N3RD_POD_CD" ).append("\n"); 
		query.append("when N2ND_POD_CD is not null then N2ND_POD_CD" ).append("\n"); 
		query.append("END NOT IN ('DKAAR', 'DKCPH', 'EETLL', 'LTKLJ', 'RULED'" ).append("\n"); 
		query.append(", 'SEGOT', 'SEHEL', 'SEGVX', 'SEMMA', 'SENRK'" ).append("\n"); 
		query.append(", 'SESTO', 'SESDJ')" ).append("\n"); 
		query.append("AND rownum = 1) HAM_RTM" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_MST D" ).append("\n"); 
		query.append("WHERE PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("ORDER BY PCTL_NO" ).append("\n"); 

	}
}