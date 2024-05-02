/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : LongstayingUnclaimEQFlaggingDBDAOsearchCorDraftRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.19
*@LastModifier : 한성호
*@LastVersion : 1.0
* 2012.09.19 한성호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Han sung ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LongstayingUnclaimEQFlaggingDBDAOsearchCorDraftRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COR draft를 조회한다.
	  * * 2012.09.19 신자영 [CHM-201220003-01] L/S U/C CREATION - COR DRAFT 기능 개발
	  * </pre>
	  */
	public LongstayingUnclaimEQFlaggingDBDAOsearchCorDraftRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration").append("\n"); 
		query.append("FileName : LongstayingUnclaimEQFlaggingDBDAOsearchCorDraftRSQL").append("\n"); 
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
		query.append("SELECT     DECODE(NO, 1, 'B/L No'                   )" ).append("\n"); 
		query.append("|| DECODE(NO, 2, 'Sales Office'             )" ).append("\n"); 
		query.append("|| DECODE(NO, 3, 'Vessel/VVD'               )" ).append("\n"); 
		query.append("|| DECODE(NO, 4, 'Shipper'                  )" ).append("\n"); 
		query.append("|| DECODE(NO, 5, 'Consignee'                )" ).append("\n"); 
		query.append("|| DECODE(NO, 6, 'Notify'                   )" ).append("\n"); 
		query.append("|| DECODE(NO, 7, 'Container Quantity'       )" ).append("\n"); 
		query.append("|| DECODE(NO, 8, 'S. Days(Average)'         )" ).append("\n"); 
		query.append("|| DECODE(NO, 9, 'Commodity'                )" ).append("\n"); 
		query.append("|| DECODE(NO, 10, 'OFT Terms'                )" ).append("\n"); 
		query.append("|| DECODE(NO, 11, 'Demurrage as of Today'   )" ).append("\n"); 
		query.append("|| DECODE(NO, 12, 'Reason of U/C or L/S'    )" ).append("\n"); 
		query.append("|| DECODE(NO, 13, 'D/O Issuance Status'     )" ).append("\n"); 
		query.append("|| DECODE(NO, 14, 'Actions taken by Dest.'  )" ).append("\n"); 
		query.append("|| ' '     AS title" ).append("\n"); 
		query.append(",    DECODE(NO, 1, C1) || DECODE(NO, 2, C2) || DECODE(NO, 3, C3)  || DECODE(NO, 4, C4)  || DECODE(NO, 5, C5)" ).append("\n"); 
		query.append("|| DECODE(NO, 6, C6) || DECODE(NO, 7, C7) || DECODE(NO, 8, C8)  || DECODE(NO, 9, C9)  || DECODE(NO, 10, C10)" ).append("\n"); 
		query.append("|| DECODE(NO, 11, C11) || DECODE(NO, 12, C12) || DECODE(NO, 13, C13) || DECODE(NO, 14, C14) ||' '   AS contents" ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("SELECT  C1, MAX(C2) C2, MAX(C3) C3, MAX(C4) C4, MAX(C5) C5, MAX(C6) C6" ).append("\n"); 
		query.append(", SUBSTR(XMLAGG(XMLELEMENT(x,', '||C7||'') ORDER BY C1).EXTRACT('//text()').GetStringVal(), 3) C7" ).append("\n"); 
		query.append(", ROUND(SUM(C8) / COUNT(C1)) C8, MAX(C9) C9, MAX(C10) C10," ).append("\n"); 
		query.append("SUM(C11) ||' '|| MAX(C15)  C11, MAX(C15) C15," ).append("\n"); 
		query.append("MAX(C12) C12, MAX(C13) C13, MAX(C14) C14" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  BL_NO AS C1," ).append("\n"); 
		query.append("SOFC AS C2," ).append("\n"); 
		query.append("VVD AS C3," ).append("\n"); 
		query.append("SHPR AS C4," ).append("\n"); 
		query.append("CNEE AS C5," ).append("\n"); 
		query.append("NTFY AS C6," ).append("\n"); 
		query.append("CNTR_TPSZ_CD || ' ' || 'X' || ' ' || COUNT(CNTR_NO) AS C7," ).append("\n"); 
		query.append("ROUND (SUM(STAY_DAYS) / COUNT(CNTR_NO)) AS C8," ).append("\n"); 
		query.append("REP_CMDT_NM AS C9," ).append("\n"); 
		query.append("OFT_TERM AS C10," ).append("\n"); 
		query.append("--SUM(DEM) ||' '|| MAX(CUR) AS C11," ).append("\n"); 
		query.append("SUM(DEM) C11," ).append("\n"); 
		query.append("MAX(CUR) C15," ).append("\n"); 
		query.append("MAX(RES) AS C12," ).append("\n"); 
		query.append("DO AS C13," ).append("\n"); 
		query.append("ACT AS C14" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(	SELECT  A.BL_NO BL_NO" ).append("\n"); 
		query.append(",A.OB_SLS_OFC_CD SOFC" ).append("\n"); 
		query.append(",(SELECT F.VSL_CD||F.SKD_VOY_NO||F.SKD_DIR_CD  FROM BKG_VVD F WHERE F.VSL_PRE_PST_CD  = 'T' AND F.BKG_NO = A.BKG_NO) VVD" ).append("\n"); 
		query.append(",REPLACE(SUBSTR(B.CUST_NM,1,50),CHR(13)||chr(10),' ') SHPR" ).append("\n"); 
		query.append(",REPLACE(SUBSTR(C.CUST_NM,1,50),CHR(13)||chr(10),' ')  CNEE" ).append("\n"); 
		query.append(",REPLACE(SUBSTR(D.CUST_NM,1,50),CHR(13)||chr(10),' ')  NTFY" ).append("\n"); 
		query.append(",E.CNTR_NO" ).append("\n"); 
		query.append(",E.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",CEIL(SYSDATE  - E.CNMV_DT) STAY_DAYS" ).append("\n"); 
		query.append(",(SELECT D.CMDT_NM FROM MDM_COMMODITY D WHERE  A.CMDT_CD = D.CMDT_CD) REP_CMDT_NM" ).append("\n"); 
		query.append(",(SELECT R.FRT_TERM_CD FROM BKG_RATE R WHERE R.BKG_NO = A.BKG_NO) OFT_TERM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",T.BIL_AMT DEM, T.BZC_TRF_CURR_CD CUR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*                     ,(SELECT C1.BIL_AMT" ).append("\n"); 
		query.append("FROM DMT_CHG_BKG_CNTR B," ).append("\n"); 
		query.append("DMT_CHG_CALC  C" ).append("\n"); 
		query.append("WHERE   B.SYS_AREA_GRP_ID = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND B.CNTR_NO           = C.CNTR_NO" ).append("\n"); 
		query.append("AND B.CNTR_CYC_NO       = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND B.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("AND C.DMDT_TRF_CD   = 'DMIF'" ).append("\n"); 
		query.append("AND C.DMDT_CHG_STS_CD   IN ('A', 'F', 'C', 'I', 'L', 'E',  'N', 'U', 'D')" ).append("\n"); 
		query.append("AND NOT (C.DUL_TP_EXPT_FLG  = 'Y' AND SUBSTR(C.DMDT_TRF_CD, 1, 1) = 'D')" ).append("\n"); 
		query.append("AND C.DMDT_CHG_LOC_DIV_CD <> 'SZP'" ).append("\n"); 
		query.append(") DEM" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",DECODE(E.UCLM_LS_DIV_CD,NULL,'',E.UCLM_RSN) RES" ).append("\n"); 
		query.append(",'' DO" ).append("\n"); 
		query.append(",'' ACT" ).append("\n"); 
		query.append("FROM BKG_BOOKING A, BKG_CUSTOMER B, BKG_CUSTOMER C, BKG_CUSTOMER D, MST_CONTAINER E," ).append("\n"); 
		query.append("(SELECT B.BKG_NO,  B.CNTR_NO, C.BIL_AMT, C.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("FROM DMT_CHG_BKG_CNTR B," ).append("\n"); 
		query.append("DMT_CHG_CALC  C" ).append("\n"); 
		query.append("WHERE   B.SYS_AREA_GRP_ID = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND B.CNTR_NO           = C.CNTR_NO" ).append("\n"); 
		query.append("AND B.CNTR_CYC_NO       = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("--AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("--AND B.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("AND C.DMDT_TRF_CD   = 'DMIF'" ).append("\n"); 
		query.append("AND C.DMDT_CHG_STS_CD   IN ('A', 'F', 'C', 'I', 'L', 'E',  'N', 'U', 'D')" ).append("\n"); 
		query.append("AND NOT (C.DUL_TP_EXPT_FLG  = 'Y' AND SUBSTR(C.DMDT_TRF_CD, 1, 1) = 'D')" ).append("\n"); 
		query.append("AND C.DMDT_CHG_LOC_DIV_CD <> 'SZP'" ).append("\n"); 
		query.append(")  T" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("AND A.BKG_NO  = C.BKG_NO(+)" ).append("\n"); 
		query.append("AND A.BKG_NO  = D.BKG_NO(+)" ).append("\n"); 
		query.append("AND B.BKG_CUST_TP_CD(+) ='S'" ).append("\n"); 
		query.append("AND C.BKG_CUST_TP_CD(+) ='C'" ).append("\n"); 
		query.append("AND D.BKG_CUST_TP_CD(+) ='N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_NO IN (" ).append("\n"); 
		query.append("#foreach ($user_bkgNos IN ${inBkgNos})" ).append("\n"); 
		query.append("#if($velocityCount < $inBkgNos.size())" ).append("\n"); 
		query.append("'$user_bkgNos'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$user_bkgNos'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND E.CNTR_NO IN (" ).append("\n"); 
		query.append("#foreach ($user_cntrNos IN ${inCntrNos})" ).append("\n"); 
		query.append("#if($velocityCount < $inCntrNos.size())" ).append("\n"); 
		query.append("'$user_cntrNos'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$user_cntrNos'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND T.BKG_NO (+) = E.BKG_NO" ).append("\n"); 
		query.append("AND T.CNTR_NO (+) = E.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY BL_NO," ).append("\n"); 
		query.append("SOFC," ).append("\n"); 
		query.append("VVD," ).append("\n"); 
		query.append("SHPR," ).append("\n"); 
		query.append("CNEE," ).append("\n"); 
		query.append("NTFY," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("REP_CMDT_NM," ).append("\n"); 
		query.append("OFT_TERM," ).append("\n"); 
		query.append("DEM," ).append("\n"); 
		query.append("RES," ).append("\n"); 
		query.append("DO," ).append("\n"); 
		query.append("ACT" ).append("\n"); 
		query.append("-- ORDER BY 1" ).append("\n"); 
		query.append("ORDER BY  SOFC" ).append("\n"); 
		query.append("-- 추가" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("GROUP BY C1" ).append("\n"); 
		query.append("-- 추가" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") T," ).append("\n"); 
		query.append("(SELECT (CPY_NO + 1) AS NO FROM COM_CPY_NO WHERE CPY_NO <= 14)" ).append("\n"); 

	}
}