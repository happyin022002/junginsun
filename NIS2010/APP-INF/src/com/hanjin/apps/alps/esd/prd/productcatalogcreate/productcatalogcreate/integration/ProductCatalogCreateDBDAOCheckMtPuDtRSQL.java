/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOCheckMtPuDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.10
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2010.04.10 정선용
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

public class ProductCatalogCreateDBDAOCheckMtPuDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckMtPuDt
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOCheckMtPuDtRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mt_pu_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOCheckMtPuDtRSQL").append("\n"); 
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
		query.append("SELECT ARR_ST_DT,TO_DATE(@[mt_pu_dt], 'YYYYMMDD') MT_PU_DT," ).append("\n"); 
		query.append("CASE WHEN ARR_ST_DT - TO_DATE(@[mt_pu_dt], 'YYYYMMDD') < 0 THEN 'EXCEPTION'" ).append("\n"); 
		query.append("ELSE 'OK'" ).append("\n"); 
		query.append("END CHECK_MT_PU," ).append("\n"); 
		query.append("ROUND((ARR_ST_DT - TO_DATE(@[mt_pu_dt], 'YYYYMMDD'))*24) MT_TERM_HR" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_MST M ,PRD_PROD_CTL_ROUT_DTL D" ).append("\n"); 
		query.append("WHERE M.PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("AND M.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD ='O'" ).append("\n"); 
		query.append("and NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("and D.ORG_NOD_CD = D.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("and PCTL_SEQ = (" ).append("\n"); 
		query.append("select min(PCTL_SEQ) from PRD_PROD_CTL_rout_dtl T" ).append("\n"); 
		query.append("where T.pctl_no = D.pctl_no" ).append("\n"); 
		query.append("and T.pctl_seq = D.pctl_seq" ).append("\n"); 
		query.append("and T.PCTL_IO_BND_CD ='O'" ).append("\n"); 
		query.append("and T.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}