/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ProductCatalogHinterlandDBDAOCopyRfContainerQtyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.28
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.28 
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

public class ProductCatalogHinterlandDBDAOCopyRfContainerQtyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ProductCatalogHinterlandDBDAOCopyRfContainerQtyCSQL
	  * </pre>
	  */
	public ProductCatalogHinterlandDBDAOCopyRfContainerQtyCSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogHinterlandDBDAOCopyRfContainerQtyCSQL").append("\n"); 
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
		query.append("INSERT INTO PRD_PROD_CTL_QTY" ).append("\n"); 
		query.append("(PCTL_NO, CNTR_TPSZ_CD, PCTL_QTY" ).append("\n"); 
		query.append(" , REV_CNTR_TPSZ_CD, REV_PCTL_QTY" ).append("\n"); 
		query.append(" , CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("select @[hd_pctl_no] ||LPAD(TO_NUMBER(SUBSTR(@[max_pctl_no], -4))+TO_NUMBER(SUBSTR(PCTL_NO, -4)) ,4,'0') pctl_no" ).append("\n"); 
		query.append("     ,  'R'||DECODE(SUBSTR(CNTR_TPSZ_CD, -1), '4','5', SUBSTR(CNTR_TPSZ_CD, -1))  CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , 1 PCTL_QTY" ).append("\n"); 
		query.append("     , NULL REV_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , NULL REV_PCTL_QTY" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE UPD_DT" ).append("\n"); 
		query.append("from PRD_PROD_CTL_QTY" ).append("\n"); 
		query.append("where PCTL_NO LIKE DECODE(@[hd_pctl_no], NULL, NULL, @[hd_pctl_no] || '%')" ).append("\n"); 

	}
}