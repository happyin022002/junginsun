/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DVFactorMgtDBDAOsearchContainerSealNoCreationChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.18
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.18 
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

public class DVFactorMgtDBDAOsearchContainerSealNoCreationChkRSQL implements ISQLTemplate{

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
	public DVFactorMgtDBDAOsearchContainerSealNoCreationChkRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seal_no_pfx_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_ser_rng_seal_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_ser_rng_seal_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.integration").append("\n"); 
		query.append("FileName : DVFactorMgtDBDAOsearchContainerSealNoCreationChkRSQL").append("\n"); 
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
		query.append("LPAD(A.N1ST_SER_RNG_SEAL_NO, 10, '0') AS N1ST_SER_RNG_SEAL_NO," ).append("\n"); 
		query.append("LPAD(A.LST_SER_RNG_SEAL_NO, 10, '0') AS LST_SER_RNG_SEAL_NO," ).append("\n"); 
		query.append("A.CRE_USR_ID," ).append("\n"); 
		query.append("A.CRE_DT," ).append("\n"); 
		query.append("A.UPD_USR_ID," ).append("\n"); 
		query.append("A.UPD_DT," ).append("\n"); 
		query.append("A.SEAL_KND_NM," ).append("\n"); 
		query.append("A.N1ST_SER_RNG_SEAL_NO||'~'||A.LST_SER_RNG_SEAL_NO AS RMK," ).append("\n"); 
		query.append("A.PLN_YRMON AS FR_YEAR" ).append("\n"); 
		query.append("FROM MNR_SEAL_PLN A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A.PLN_YRMON = @[fr_year]||@[pln_month]" ).append("\n"); 
		query.append("#if (${seal_no_pfx_nm} != '')" ).append("\n"); 
		query.append("AND A.SEAL_NO_PFX_NM = @[seal_no_pfx_nm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND ((@[n1st_ser_rng_seal_no] BETWEEN TO_NUMBER(A.N1ST_SER_RNG_SEAL_NO) AND TO_NUMBER(A.LST_SER_RNG_SEAL_NO))" ).append("\n"); 
		query.append("OR (@[lst_ser_rng_seal_no] BETWEEN TO_NUMBER(A.N1ST_SER_RNG_SEAL_NO) AND TO_NUMBER(A.LST_SER_RNG_SEAL_NO)))" ).append("\n"); 
		query.append("#if (${rmk} == 'Y')" ).append("\n"); 
		query.append("AND LENGTH(@[n1st_ser_rng_seal_no]) = LENGTH(A.N1ST_SER_RNG_SEAL_NO)" ).append("\n"); 
		query.append("AND LENGTH(@[lst_ser_rng_seal_no]) = LENGTH(A.LST_SER_RNG_SEAL_NO)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rmk} == '')" ).append("\n"); 
		query.append("AND SUBSTR(A.N1ST_SER_RNG_SEAL_NO, 1,1) <> '0'" ).append("\n"); 
		query.append("AND SUBSTR(A.LST_SER_RNG_SEAL_NO, 1,1) <> '0'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}