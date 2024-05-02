/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchRprInvOfcCdDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2010.03.15 함형석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HamHyungSeok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchRprInvOfcCdDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralCodeSearchMgtDBDAOsearchRprInvOfcCdDataRSQL
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchRprInvOfcCdDataRSQL(){
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
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchRprInvOfcCdDataRSQL").append("\n"); 
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
		query.append("SELECT B.OFC_CD AS CD_ID, B.OFC_ENG_NM AS CD_DESC" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("  SELECT D.OFC_CD" ).append("\n"); 
		query.append("  FROM   MNR_OFC_GEN_INFO D" ).append("\n"); 
		query.append("  WHERE  D.UPPR_OFC_CD  =  @[searchcon]" ).append("\n"); 
		query.append("	 AND    D.MNR_GRP_TP_CD = 'OFC'" ).append("\n"); 
		query.append("	 AND    D.COST_CD       = 'RPRINV'" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT @[searchcon] OFC_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") A , MDM_ORGANIZATION B" ).append("\n"); 
		query.append("WHERE B.OFC_CD = A.OFC_CD" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY B.OFC_CD" ).append("\n"); 

	}
}