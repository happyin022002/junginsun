/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOUpdatePrdDtlByMtPuDtValidateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.30
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.11.30 정선용
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

public class ProductCatalogCreateDBDAOUpdatePrdDtlByMtPuDtValidateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdatePrdDtlByMtPuDtValidate
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOUpdatePrdDtlByMtPuDtValidateUSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOUpdatePrdDtlByMtPuDtValidateUSQL").append("\n"); 
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
		query.append("--UPDATE PRD_PROD_CTL_ROUT_DTL D" ).append("\n"); 
		query.append("--SET PCTL_NO = 'X'|| SUBSTR(PCTL_NO,2)" ).append("\n"); 
		query.append("DELETE  PRD_PROD_CTL_ROUT_DTL D" ).append("\n"); 
		query.append("WHERE D.PCTL_NO IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT PCTL_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT M.PCTL_NO,ARR_ST_DT,TO_DATE(@[mt_pu_dt], 'YYYYMMDD') MT_PU_DT," ).append("\n"); 
		query.append("CASE WHEN ARR_ST_DT - TO_DATE(@[mt_pu_dt], 'YYYYMMDD') < 0 THEN 'EXCEPTION'" ).append("\n"); 
		query.append("ELSE 'OK'" ).append("\n"); 
		query.append("END CHECK_MT_PU" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_MST M ,PRD_PROD_CTL_ROUT_DTL D" ).append("\n"); 
		query.append("WHERE M.PCTL_NO = @[pctl_no] -- 'B091126000010891%'" ).append("\n"); 
		query.append("AND M.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("AND M.MTY_PKUP_YD_CD = D.ORG_NOD_CD" ).append("\n"); 
		query.append("AND D.NOD_LNK_DIV_CD='N'" ).append("\n"); 
		query.append("AND D.MTY_YD_FLG='Y'" ).append("\n"); 
		query.append(") WHERE CHECK_MT_PU='EXCEPTION'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}