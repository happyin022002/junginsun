/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchOfcCdFromRhqDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.22
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.10.22 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchOfcCdFromRhqDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchOfcCdFromRhqData
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchOfcCdFromRhqDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("searchcon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchOfcCdFromRhqDataRSQL").append("\n"); 
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
		query.append("#if (${searchcon} == 'NOTHQ')" ).append("\n"); 
		query.append("SELECT A.OFC_CD AS CD_ID" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.OFC_CD IN (" ).append("\n"); 
		query.append("SELECT A.OFC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT M.OFC_CD from  MDM_ORGANIZATION M" ).append("\n"); 
		query.append("WHERE M.OFC_CD <> M.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append(") )" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY A.OFC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT  DISTINCT A.OFC_CD AS CD_ID, A.OFC_ENG_NM AS CD_DESC" ).append("\n"); 
		query.append("FROM  MDM_ORGANIZATION  A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${searchcon} != '' && ${searchcon} != 'A')" ).append("\n"); 
		query.append("AND A.AR_HD_QTR_OFC_CD LIKE '%'|| NVL(@[searchcon],'') ||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}