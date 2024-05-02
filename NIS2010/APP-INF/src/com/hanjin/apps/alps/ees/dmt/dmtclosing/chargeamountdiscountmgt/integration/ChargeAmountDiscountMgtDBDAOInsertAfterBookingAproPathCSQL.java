/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOInsertAfterBookingAproPathCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.26
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOInsertAfterBookingAproPathCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAOInsertAfterBookingAproPathCSQL
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOInsertAfterBookingAproPathCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOInsertAfterBookingAproPathCSQL").append("\n"); 
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
		query.append("INSERT INTO DMT_AFT_BKG_APRO_PATH	" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	    AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("	   ,AFT_BKG_PATH_CD" ).append("\n"); 
		query.append("	   ,AFT_BKG_PATH_LVL" ).append("\n"); 
		query.append("	   ,DMDT_EXPT_RQST_STS_CD" ).append("\n"); 
		query.append("	   ,AFT_BKG_PATH_CPLS_FLG" ).append("\n"); 
		query.append("	   ,CRE_USR_ID" ).append("\n"); 
		query.append("	   ,CRE_DT" ).append("\n"); 
		query.append("	   ,UPD_USR_ID" ).append("\n"); 
		query.append("	   ,UPD_DT" ).append("\n"); 
		query.append("	   ,APRO_OFC_CD" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("SELECT  @[aft_expt_dar_no]" ).append("\n"); 
		query.append("       ,ATTR_CTNT1			--// AFT_BKG_PATH_CD (BBOPIC, BBGMGR,...HDOECD, HDOCEO) " ).append("\n"); 
		query.append("	   ,HRD_CDG_ID_SEQ		--// AFT_BKG_PATH_LVL" ).append("\n"); 
		query.append("	   ,''					--// DMDT_EXPT_RQST_STS_CD (승인처리시 상태값이 입력됨)" ).append("\n"); 
		query.append("	   ,'Y'					--// AFT_BKG_PATH_CPLS_FLG (기존 SETUP 화면 사용시 확장을 위해서 'Y' 로 설정함)" ).append("\n"); 
		query.append("	   ,@[upd_usr_id]		--// CRE_USR_ID" ).append("\n"); 
		query.append("	   ,SYSDATE				--// CRE_DT" ).append("\n"); 
		query.append("	   ,@[upd_usr_id]		--// UPD_USR_ID" ).append("\n"); 
		query.append("	   ,SYSDATE	   			--// UPD_DT" ).append("\n"); 
		query.append("	   ,NVL(" ).append("\n"); 
		query.append("				ATTR_CTNT5" ).append("\n"); 
		query.append("			   ,(" ).append("\n"); 
		query.append("					SELECT  OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("					  FROM  MAS_OFC_LVL" ).append("\n"); 
		query.append("					 WHERE  OFC_CD = NVL(" ).append("\n"); 
		query.append("											( " ).append("\n"); 
		query.append("												SELECT  OFC_CD " ).append("\n"); 
		query.append("												  FROM  DMT_CHG_CALC" ).append("\n"); 
		query.append("												 WHERE  (SYS_AREA_GRP_ID, CNTR_NO,CNTR_CYC_NO, DMDT_TRF_CD, DMDT_CHG_LOC_DIV_CD, CHG_SEQ) = " ).append("\n"); 
		query.append("														(" ).append("\n"); 
		query.append("															SELECT  SYS_AREA_GRP_ID, CNTR_NO, CNTR_CYC_NO, DMDT_TRF_CD, DMDT_CHG_LOC_DIV_CD, CHG_SEQ " ).append("\n"); 
		query.append("															  FROM  DMT_AFT_BKG_CNTR" ).append("\n"); 
		query.append("															 WHERE  AFT_EXPT_DAR_NO      = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("															   AND  NVL(RQST_DC_AMT, 0) != 0" ).append("\n"); 
		query.append("															   AND  ROWNUM               = 1 " ).append("\n"); 
		query.append("														)" ).append("\n"); 
		query.append("											)" ).append("\n"); 
		query.append("										   ,( " ).append("\n"); 
		query.append("												SELECT  OFC_CD " ).append("\n"); 
		query.append("												  FROM  DMT_CHG_CALC" ).append("\n"); 
		query.append("												 WHERE  (CNTR_NO, CNTR_CYC_NO, DMDT_TRF_CD, DMDT_CHG_LOC_DIV_CD, CHG_SEQ) = " ).append("\n"); 
		query.append("														(" ).append("\n"); 
		query.append("															SELECT  CNTR_NO, CNTR_CYC_NO, DMDT_TRF_CD, DMDT_CHG_LOC_DIV_CD, CHG_SEQ " ).append("\n"); 
		query.append("															  FROM  DMT_AFT_BKG_CNTR" ).append("\n"); 
		query.append("															 WHERE  AFT_EXPT_DAR_NO      = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("															   AND  NVL(RQST_DC_AMT, 0) != 0" ).append("\n"); 
		query.append("															   AND  ROWNUM               = 1 " ).append("\n"); 
		query.append("														)" ).append("\n"); 
		query.append("												   AND  ROWNUM = 1" ).append("\n"); 
		query.append("											)" ).append("\n"); 
		query.append("										)" ).append("\n"); 
		query.append("					   AND  TO_CHAR(SYSDATE, 'YYYYMM') BETWEEN OFC_APLY_FM_YRMON AND OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("					   AND  ROWNUM = 1 " ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("	    )					--// APRO_OFC_CD" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("  FROM  DMT_HRD_CDG_CTNT" ).append("\n"); 
		query.append(" WHERE  HRD_CDG_ID  = 'AFT_BKG_APRO_PATH'" ).append("\n"); 
		query.append("   AND  TO_NUMBER(ATTR_CTNT4) <= 		--// DC AMOUNT" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT  SUM(DC_AMT)" ).append("\n"); 
		query.append("			  FROM  (" ).append("\n"); 
		query.append("						SELECT  BKG_NO" ).append("\n"); 
		query.append("							   ,ROUND(SUM(T2.RQST_DC_AMT) / T1.AFT_BKG_XCH_RT,2) DC_AMT" ).append("\n"); 
		query.append("							   " ).append("\n"); 
		query.append("						  FROM  DMT_AFT_BKG_ADJ_RQST_DTL 	T1" ).append("\n"); 
		query.append("							   ,DMT_AFT_BKG_CNTR 			T2" ).append("\n"); 
		query.append("							   " ).append("\n"); 
		query.append("						 WHERE  T1.AFT_EXPT_DAR_NO  = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("						   AND  T1.AFT_EXPT_DAR_NO  = T2.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("						   AND  T1.AFT_EXPT_ADJ_SEQ = T2.AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append("						   " ).append("\n"); 
		query.append("						GROUP BY T1.BKG_NO, T1.AFT_BKG_XCH_RT " ).append("\n"); 
		query.append("					) " ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("ORDER BY HRD_CDG_ID_SEQ" ).append("\n"); 

	}
}