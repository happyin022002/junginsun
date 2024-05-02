/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOSetMtPuDtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2010.01.22 정선용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author sun yong Jung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOSetMtPuDtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * mt pu dt를 입력받은 값으로 바꿔준다.
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOSetMtPuDtUSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration ").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOSetMtPuDtUSQL").append("\n"); 
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
		query.append("MERGE INTO PRD_PROD_CTL_ROUT_DTL D" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("SELECT PCTL_NO, PCTL_SEQ,ORG_NOD_CD,DEST_NOD_CD,--ARR_ST_DT,DEP_FSH_DT,TZ_DWLL_TM_HRS," ).append("\n"); 
		query.append("CASE WHEN PCTL_SEQ IN (1,2) THEN TO_DATE(@[mt_pu_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("ELSE ARR_ST_DT" ).append("\n"); 
		query.append("END ARR_ST_DT," ).append("\n"); 
		query.append("CASE WHEN PCTL_SEQ =1 THEN TO_DATE(@[mt_pu_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("ELSE DEP_FSH_DT" ).append("\n"); 
		query.append("END DEP_FSH_DT," ).append("\n"); 
		query.append("CASE WHEN PCTL_SEQ =2 THEN TZ_DWLL_TM_HRS+ ROUND((ARR_ST_DT - TO_DATE(@[mt_pu_dt], 'YYYYMMDD'))*24)" ).append("\n"); 
		query.append("ELSE TZ_DWLL_TM_HRS" ).append("\n"); 
		query.append("END TZ_DWLL_TM_HRS" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD ='O'" ).append("\n"); 
		query.append("AND PCTL_SEQ IN (1,2)" ).append("\n"); 
		query.append(") T ON (" ).append("\n"); 
		query.append("D.PCTL_NO = T.PCTL_NO" ).append("\n"); 
		query.append("AND D.PCTL_SEQ = T.PCTL_SEQ" ).append("\n"); 
		query.append("AND D.ORG_NOD_CD = T.ORG_NOD_CD" ).append("\n"); 
		query.append("AND D.DEST_NOD_CD = T.DEST_NOD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET ARR_ST_DT= T.ARR_ST_DT" ).append("\n"); 
		query.append(", DEP_FSH_DT= T.DEP_FSH_DT" ).append("\n"); 
		query.append(", TZ_DWLL_TM_HRS= T.TZ_DWLL_TM_HRS" ).append("\n"); 

	}
}