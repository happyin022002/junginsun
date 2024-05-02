/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchRhqOfcCdDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.03
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2011.03.03 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author MyoungSinPark
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchRhqOfcCdDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRhqOfcCdData
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchRhqOfcCdDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchRhqOfcCdDataRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT AR_HD_QTR_OFC_CD AS HQ_OFC" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("#if(${searchcon} == 'TRUEHEADOFCFALSE')" ).append("\n"); 
		query.append("WHERE AR_HD_QTR_OFC_CD <> COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC()" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT MNR_CD_ID AS HQ_OFC" ).append("\n"); 
		query.append("FROM MNR_GEN_CD" ).append("\n"); 
		query.append("WHERE PRNT_CD_ID = 'HOOFC'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("#elseif (${searchcon} == 'ALLFALSE')" ).append("\n"); 
		query.append("WHERE AR_HD_QTR_OFC_CD <> COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC()" ).append("\n"); 
		query.append("#elseif (${searchcon} == 'TRUE')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT MNR_CD_ID AS HQ_OFC" ).append("\n"); 
		query.append("FROM MNR_GEN_CD" ).append("\n"); 
		query.append("WHERE PRNT_CD_ID = 'HOOFC'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") A , MDM_ORGANIZATION B" ).append("\n"); 
		query.append("WHERE B.OFC_CD = A.HQ_OFC" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY B.OFC_CD" ).append("\n"); 

	}
}