/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DVFactorMgtDBDAOsearchContainerSealInquiryCountRSQL.java
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

public class DVFactorMgtDBDAOsearchContainerSealInquiryCountRSQL implements ISQLTemplate{

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
	public DVFactorMgtDBDAOsearchContainerSealInquiryCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_mm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_mm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_yy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_yy",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.integration").append("\n"); 
		query.append("FileName : DVFactorMgtDBDAOsearchContainerSealInquiryCountRSQL").append("\n"); 
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
		query.append("WITH LV_SEAL_NO AS" ).append("\n"); 
		query.append("(SELECT SEAL_NO_PFX_NM||DECODE(IS_CHR,1,LPAD(CNTR_SEAL_NO,LST_LEN,'0'),CNTR_SEAL_NO) AS CNTR_SEAL_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT A.SEAL_NO_PFX_NM,(TO_NUMBER(A.N1ST_SER_RNG_SEAL_NO) + B.SEQ - 1) AS CNTR_SEAL_NO," ).append("\n"); 
		query.append("DECODE(SUBSTR(A.LST_SER_RNG_SEAL_NO,1,1),'0',1,0) IS_CHR," ).append("\n"); 
		query.append("LENGTH(A.LST_SER_RNG_SEAL_NO) LST_LEN" ).append("\n"); 
		query.append("FROM (SELECT SEAL_NO_PFX_NM," ).append("\n"); 
		query.append("N1ST_SER_RNG_SEAL_NO," ).append("\n"); 
		query.append("LST_SER_RNG_SEAL_NO," ).append("\n"); 
		query.append("TO_NUMBER(LST_SER_RNG_SEAL_NO) - TO_NUMBER(N1ST_SER_RNG_SEAL_NO) + 1 AS PLN_QTY" ).append("\n"); 
		query.append("FROM MNR_SEAL_PLN) A," ).append("\n"); 
		query.append("(SELECT LEVEL AS SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("CONNECT BY LEVEL <= (SELECT MAX(TO_NUMBER(LST_SER_RNG_SEAL_NO) - TO_NUMBER(N1ST_SER_RNG_SEAL_NO) + 1)" ).append("\n"); 
		query.append("FROM MNR_SEAL_PLN" ).append("\n"); 
		query.append("WHERE PLN_YRMON BETWEEN @[fr_yy]||@[fr_mm] AND @[to_yy]||@[to_mm])) B" ).append("\n"); 
		query.append("WHERE B.SEQ <= A.PLN_QTY)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT COUNT(*) AS OUT_QTY" ).append("\n"); 
		query.append("FROM (SELECT DISTINCT CNTR_SEAL_NO" ).append("\n"); 
		query.append("FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("WHERE CRE_DT BETWEEN TO_DATE(@[fr_yy]||@[fr_mm]||'01', 'YYYYMMDD') AND LAST_DAY(TO_DATE(@[to_yy]||@[to_mm]||'01', 'YYYYMMDD')) + 0.99999" ).append("\n"); 
		query.append("MINUS SELECT CNTR_SEAL_NO" ).append("\n"); 
		query.append("FROM LV_SEAL_NO)" ).append("\n"); 

	}
}