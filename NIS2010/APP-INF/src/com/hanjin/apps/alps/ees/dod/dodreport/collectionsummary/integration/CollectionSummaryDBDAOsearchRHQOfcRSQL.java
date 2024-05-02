/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CollectionSummaryDBDAOsearchRHQOfcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CollectionSummaryDBDAOsearchRHQOfcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Combo Box용 RHQ Offcie 조회
	  * </pre>
	  */
	public CollectionSummaryDBDAOsearchRHQOfcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.integration").append("\n"); 
		query.append("FileName : CollectionSummaryDBDAOsearchRHQOfcRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append(" A.OFC_CD AS OFFICE" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT    DISTINCT" ).append("\n"); 
		query.append("              DECODE(X.AR_HD_QTR_OFC_CD,'SELIB',1,'TYOIB',2,'HAMRU',3,'NYCRA',4,'SHARC',5,'SINRS',6,'VVOIA',7,9) AS RUM" ).append("\n"); 
		query.append("             ,X.AR_HD_QTR_OFC_CD AS OFC_CD    " ).append("\n"); 
		query.append("    FROM      MDM_ORGANIZATION   X" ).append("\n"); 
		query.append("    WHERE     X.OFC_KND_CD        = '2'" ).append("\n"); 
		query.append("    AND       X.AR_HD_QTR_OFC_CD  IS NOT NULL" ).append("\n"); 
		query.append("    AND       X.DELT_FLG = 'N'" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("ORDER BY RUM ASC " ).append("\n"); 

	}
}