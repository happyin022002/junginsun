/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnersAccountDBDAOOwnOfficeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.ownersaccount.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnersAccountDBDAOOwnOfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Owner's Account Office 조회
	  * </pre>
	  */
	public OwnersAccountDBDAOOwnOfficeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("off_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.ownersaccount.integration").append("\n"); 
		query.append("FileName : OwnersAccountDBDAOOwnOfficeListRSQL").append("\n"); 
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
		query.append("#if (${off_cd} == 'SELADG')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append(" A.OFC_CD AS OFFICE" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT    DISTINCT" ).append("\n"); 
		query.append("              @[off_cd] AS OFFICE" ).append("\n"); 
		query.append("              ,DECODE(X.AR_HD_QTR_OFC_CD,'HAMRU',1,'NYCRA',2,'SHARC',3,'SINRS',4,'SELIB',5,'TYOIB',6,'VVOIA',7,9) AS RUM" ).append("\n"); 
		query.append("             ,X.AR_HD_QTR_OFC_CD	AS OFC_CD    " ).append("\n"); 
		query.append("    FROM      MDM_ORGANIZATION  	X" ).append("\n"); 
		query.append("    WHERE     X.OFC_KND_CD       	= '2'" ).append("\n"); 
		query.append("    AND       X.AR_HD_QTR_OFC_CD 	IS NOT NULL" ).append("\n"); 
		query.append("    AND       X.DELT_FLG = 'N'" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.OFFICE = @[off_cd]" ).append("\n"); 
		query.append("ORDER BY RUM ASC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append(" A.OFC_CD AS OFFICE" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT DISTINCT @[off_cd] AS OFFICE, ROWNUM AS RUM, OFC_CD" ).append("\n"); 
		query.append("    FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("    WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("    CONNECT BY PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("    START WITH OFC_CD = DECODE(@[off_cd],'SELADG','XXXXX',@[off_cd])   " ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.OFFICE = @[off_cd]" ).append("\n"); 
		query.append("ORDER BY RUM ASC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}