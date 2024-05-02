/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCommCalculationDBDAOModifyFFMasterEMSGUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.13
*@LastModifier :
*@LastVersion : 1.0
* 2012.08.13
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCommCalculationDBDAOModifyFFMasterEMSGUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * FFCommCalculationDBDAOModifyFFMasterEMSGUSQL
	  * </pre>
	  */
	public FFCommCalculationDBDAOModifyFFMasterEMSGUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ff_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ff_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_cmpn_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_cmpn_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ff_cmpn_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ff_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.integration").append("\n");
		query.append("FileName : FFCommCalculationDBDAOModifyFFMasterEMSGUSQL").append("\n");
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
		query.append("MERGE INTO ACM_FF_CMPN A " ).append("\n");
		query.append("USING ( SELECT @[bkg_no] BKG_NO, @[ff_cmpn_seq] FF_CMPN_SEQ, @[ff_cmpn_sts_cd] FF_CMPN_STS_CD, @[ff_cmpn_rmk] FF_CMPN_RMK, " ).append("\n");
		query.append("				 TO_DATE (@[trunk_etd_dt], 'YYYYMMDDHH24MISS') VSL_DEP_DT, " ).append("\n");
		query.append("				 @[bkg_ff_cnt_cd] BKG_FF_CNT_CD, TO_NUMBER(@[bkg_ff_seq]) BKG_FF_SEQ, @[ff_cnt_cd] FF_CNT_CD, TO_NUMBER(@[ff_seq]) FF_SEQ, 0 FF_CHG_AMT," ).append("\n");
		query.append("				 0 PPD_AMT, 0 CRNT_AMT, 0 IF_AMT, 'COMMISSION' UPD_USR_ID, SYSDATE UPD_DT, 'COMMISSION' CRE_USR_ID, SYSDATE CRE_DT " ).append("\n");
		query.append("	  	  FROM DUAL " ).append("\n");
		query.append("	    ) B" ).append("\n");
		query.append("ON ( A.BKG_NO = B.BKG_NO AND A.FF_CMPN_SEQ = B.FF_CMPN_SEQ) " ).append("\n");
		query.append("WHEN MATCHED THEN " ).append("\n");
		query.append("	 UPDATE SET A.FF_CMPN_STS_CD = B.FF_CMPN_STS_CD, A.FF_CMPN_RMK = B.FF_CMPN_RMK, " ).append("\n");
		query.append("	 			A.VSL_DEP_DT = B.VSL_DEP_DT, " ).append("\n");
		query.append("	 			A.BKG_FF_CNT_CD = B.BKG_FF_CNT_CD, A.BKG_FF_SEQ = B.BKG_FF_SEQ, A.UPD_DT = B.UPD_DT " ).append("\n");
		query.append("WHEN NOT MATCHED THEN " ).append("\n");
		query.append("	 INSERT (A.BKG_NO, A.FF_CMPN_SEQ, A.FF_CMPN_STS_CD, A.FF_CMPN_RMK, " ).append("\n");
		query.append("	 		 A.FF_CHG_AMT, A.PPD_AMT, A.CRNT_AMT, A.IF_AMT, " ).append("\n");
		query.append("	 		 A.VSL_DEP_DT, A.BKG_FF_CNT_CD, A.BKG_FF_SEQ, A.FF_CNT_CD, A.FF_SEQ, A.UPD_USR_ID, A.UPD_DT, A.CRE_USR_ID, A.CRE_DT) " ).append("\n");
		query.append("	 VALUES (B.BKG_NO, B.FF_CMPN_SEQ, B.FF_CMPN_STS_CD, B.FF_CMPN_RMK, " ).append("\n");
		query.append("	 		 B.FF_CHG_AMT, B.PPD_AMT, B.CRNT_AMT, B.IF_AMT, " ).append("\n");
		query.append("	 		 B.VSL_DEP_DT, B.BKG_FF_CNT_CD, B.BKG_FF_SEQ, B.FF_CNT_CD, B.FF_SEQ, B.UPD_USR_ID, B.UPD_DT, B.CRE_USR_ID, B.CRE_DT)" ).append("\n");

	}
}