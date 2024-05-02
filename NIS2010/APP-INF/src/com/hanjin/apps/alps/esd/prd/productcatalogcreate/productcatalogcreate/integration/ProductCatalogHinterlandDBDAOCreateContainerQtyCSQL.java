/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ProductCatalogHinterlandDBDAOCreateContainerQtyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.19
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.06.19 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogHinterlandDBDAOCreateContainerQtyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Hinterland용 Container Qty를 생성한다.
	  * '0001', 'D2', '0003', 'D2', '0002', 'D4', '0004', 'D4' 로
	  * </pre>
	  */
	public ProductCatalogHinterlandDBDAOCreateContainerQtyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("hd_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogHinterlandDBDAOCreateContainerQtyCSQL").append("\n"); 
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
		query.append("select pctl_no" ).append("\n"); 
		query.append("     , decode(substr(pctl_no, -4), '0001', 'D2', '0004', 'D2', '0002', 'D4', '0005', 'D4', '0003' , 'D7', '0006', 'D7') CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , 1 PCTL_QTY" ).append("\n"); 
		query.append("     , NULL REV_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , NULL REV_PCTL_QTY" ).append("\n"); 
		query.append("     , NVL(@[cre_usr_id], 'SYSTEM') CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE CRE_DT" ).append("\n"); 
		query.append("     , NVL(@[cre_usr_id], 'SYSTEM') UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE UPD_DT" ).append("\n"); 
		query.append("from prd_prod_ctl_mst" ).append("\n"); 
		query.append("where pctl_no like @[hd_pctl_no] || '%'" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}