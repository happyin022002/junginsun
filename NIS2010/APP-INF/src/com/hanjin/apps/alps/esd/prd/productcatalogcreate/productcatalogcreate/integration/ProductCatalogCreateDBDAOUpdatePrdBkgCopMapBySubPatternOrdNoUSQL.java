/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOUpdatePrdBkgCopMapBySubPatternOrdNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2010.04.23 정선용
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

public class ProductCatalogCreateDBDAOUpdatePrdBkgCopMapBySubPatternOrdNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 부패턴 pc 업데이트
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOUpdatePrdBkgCopMapBySubPatternOrdNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_mapg_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cop_patt_ord_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOUpdatePrdBkgCopMapBySubPatternOrdNoUSQL").append("\n"); 
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
		query.append("UPDATE PRD_BKG_COP_MAP" ).append("\n"); 
		query.append("SET PCTL_NO = (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CASE WHEN PCTL_NO IS NULL THEN" ).append("\n"); 
		query.append("(SELECT PCTL_NO FROM PRD_PROD_CTL_MST WHERE PCTL_NO LIKE @[hd_pctl_no]||'%' AND ROWNUM =1)" ).append("\n"); 
		query.append("WHEN PCTL_NO IS NOT NULL THEN" ).append("\n"); 
		query.append("PCTL_NO" ).append("\n"); 
		query.append("END PCTL_NO" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL D" ).append("\n"); 
		query.append("WHERE PCTL_NO LIKE @[hd_pctl_no]||'%' --부패턴으로 생긴PC" ).append("\n"); 
		query.append("AND (ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD,ROUT_SEQ ) =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD,ROUT_SEQ" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE PCTL_NO=( --주패턴의 PC로 부터 OCN ROUT PK를 찾기위해" ).append("\n"); 
		query.append("SELECT PCTL_NO" ).append("\n"); 
		query.append("FROM PRD_BKG_COP_MAP" ).append("\n"); 
		query.append("WHERE COP_MAPG_SEQ=@[cop_mapg_seq]" ).append("\n"); 
		query.append("AND COP_PATT_ORD_NO ='1'" ).append("\n"); 
		query.append("AND ROWNUM=1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD='T'" ).append("\n"); 
		query.append("AND ROWNUM=1" ).append("\n"); 
		query.append(")---R1003160148278600002" ).append("\n"); 
		query.append("AND ROWNUM =1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND  COP_MAPG_SEQ =@[cop_mapg_seq]" ).append("\n"); 
		query.append("AND COP_PATT_ORD_NO = @[cop_patt_ord_no]" ).append("\n"); 

	}
}