/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DVFactorMgtDBDAOsearchContainerSealNoCreationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.16
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DVFactorMgtDBDAOsearchContainerSealNoCreationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * --------------------------------------------------------
	  * History
	  * 2011.11.29 김상수 [CHM-201114696-01] ALPS > MNR > Seal management creation 화면과 inquiry 화면 - Seal No의 prefix만 별도 컬럼으로 분리
	  *                                                           - MNR_SEAL_PLN 테이블에 Serial Range 값을 분리하여 저장, 조회
	  *                                                           - 해당 컬럼명을 사용하는 js및 쿼리, VO 전면수정
	  * </pre>
	  */
	public DVFactorMgtDBDAOsearchContainerSealNoCreationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_month",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_year",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.integration").append("\n"); 
		query.append("FileName : DVFactorMgtDBDAOsearchContainerSealNoCreationRSQL").append("\n"); 
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
		query.append("SELECT A.PLN_YRMON," ).append("\n"); 
		query.append("A.PLN_SEQ," ).append("\n"); 
		query.append("A.OFC_CD," ).append("\n"); 
		query.append("LPAD(A.VNDR_SEQ, 6, '0') AS VNDR_SEQ," ).append("\n"); 
		query.append("(SELECT VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_VENDOR" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = A.VNDR_SEQ) AS VNDR_NM," ).append("\n"); 
		query.append("A.CNTR_SEAL_LOST_QTY," ).append("\n"); 
		query.append("A.N1ST_SER_RNG_SEAL_NO AS N1ST_SER_RNG_SEAL_NO," ).append("\n"); 
		query.append("A.LST_SER_RNG_SEAL_NO AS LST_SER_RNG_SEAL_NO," ).append("\n"); 
		query.append("TO_NUMBER(A.LST_SER_RNG_SEAL_NO) - TO_NUMBER(A.N1ST_SER_RNG_SEAL_NO) + 1 AS PLN_QTY," ).append("\n"); 
		query.append("A.CRE_USR_ID," ).append("\n"); 
		query.append("A.CRE_DT," ).append("\n"); 
		query.append("A.UPD_USR_ID," ).append("\n"); 
		query.append("A.UPD_DT," ).append("\n"); 
		query.append("A.SEAL_KND_NM," ).append("\n"); 
		query.append("A.SEAL_NO_PFX_NM," ).append("\n"); 
		query.append("A.SEAL_NO_PFX_NM AS SEAL_NO_PFX_NM0" ).append("\n"); 
		query.append("FROM MNR_SEAL_PLN A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${fr_year} != '')" ).append("\n"); 
		query.append("AND A.PLN_YRMON = @[fr_year]||@[pln_month]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}