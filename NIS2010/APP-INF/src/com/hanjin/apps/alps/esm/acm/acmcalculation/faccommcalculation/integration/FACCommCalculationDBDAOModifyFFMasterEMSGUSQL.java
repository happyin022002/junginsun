/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACCommCalculationDBDAOModifyFFMasterEMSGUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACCommCalculationDBDAOModifyFFMasterEMSGUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FACCommCalculationDBDAOModifyFFMasterEMSGUSQL
	  * </pre>
	  */
	public FACCommCalculationDBDAOModifyFFMasterEMSGUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trunk_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ff_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ff_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration").append("\n"); 
		query.append("FileName : FACCommCalculationDBDAOModifyFFMasterEMSGUSQL").append("\n"); 
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
		query.append("MERGE INTO ACM_FAC_COMM A " ).append("\n"); 
		query.append("USING ( SELECT @[bkg_no] BKG_NO, @[fac_seq] FAC_SEQ, @[fac_sts_cd] FAC_STS_CD, @[fac_rmk] FAC_RMK, " ).append("\n"); 
		query.append("				 TO_DATE (@[trunk_etd_dt], 'YYYYMMDDHH24MISS') VSL_DEP_DT, @[sls_ofc_cd] SLS_OFC_CD, " ).append("\n"); 
		query.append("				 @[bkg_ff_cnt_cd] BKG_FF_CNT_CD, DECODE(@[bkg_ff_seq],'*',0,@[bkg_ff_seq]) BKG_FF_SEQ, " ).append("\n"); 
		query.append("				 0 PPD_AMT, 0 CRNT_AMT, 0 IF_AMT, (SELECT NVL(C.AR_OFC_CD, @[sls_ofc_cd]) FROM MDM_ORGANIZATION C WHERE C.OFC_CD = @[sls_ofc_cd])  AS AR_OFC_CD, SYSDATE UPD_DT, 'COMMISSION' UPD_USR_ID, SYSDATE CRE_DT, 'COMMISSION' CRE_USR_ID " ).append("\n"); 
		query.append("	  	  FROM DUAL " ).append("\n"); 
		query.append("	    ) B " ).append("\n"); 
		query.append("ON ( A.BKG_NO = B.BKG_NO AND A.FAC_SEQ = B.FAC_SEQ) " ).append("\n"); 
		query.append("WHEN MATCHED THEN " ).append("\n"); 
		query.append("	 UPDATE SET A.FAC_STS_CD = B.FAC_STS_CD, A.FAC_RMK = B.FAC_RMK, " ).append("\n"); 
		query.append("	 			A.VSL_DEP_DT = B.VSL_DEP_DT, A.SLS_OFC_CD = B.SLS_OFC_CD, A.AR_OFC_CD = B.AR_OFC_CD, " ).append("\n"); 
		query.append("	 			A.BKG_FF_CNT_CD = B.BKG_FF_CNT_CD, A.BKG_FF_SEQ = B.BKG_FF_SEQ, A.UPD_DT = B.UPD_DT " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("	 INSERT (A.BKG_NO, A.FAC_SEQ, A.FAC_STS_CD, A.FAC_RMK, " ).append("\n"); 
		query.append("	 		 A.PPD_AMT, A.CRNT_AMT, A.IF_AMT, " ).append("\n"); 
		query.append("	 		 A.VSL_DEP_DT, A.SLS_OFC_CD, A.BKG_FF_CNT_CD, A.BKG_FF_SEQ, A.AR_OFC_CD, A.UPD_DT, A.UPD_USR_ID, A.CRE_DT, A.CRE_USR_ID) " ).append("\n"); 
		query.append("	 VALUES (B.BKG_NO, B.FAC_SEQ, B.FAC_STS_CD, B.FAC_RMK, " ).append("\n"); 
		query.append("	 		 B.PPD_AMT, B.CRNT_AMT, B.IF_AMT, " ).append("\n"); 
		query.append("	 		 B.VSL_DEP_DT, B.SLS_OFC_CD, B.BKG_FF_CNT_CD, B.BKG_FF_SEQ, B.AR_OFC_CD, B.UPD_DT, B.UPD_USR_ID, B.CRE_DT, B.CRE_USR_ID)" ).append("\n"); 

	}
}