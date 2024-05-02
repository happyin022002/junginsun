/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BDRCorrectionDBDAOSearchCorrReplanRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.18
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2016.05.18 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BDRCorrectionDBDAOSearchCorrReplanRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * c/a 완료시 replan할 필요가 있는지 조회한다
	  * </pre>
	  */
	public BDRCorrectionDBDAOSearchCorrReplanRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.integration").append("\n"); 
		query.append("FileName : BDRCorrectionDBDAOSearchCorrReplanRSQL").append("\n"); 
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
		query.append("SELECT 1 ORD, 'REPLAN' OPERATION, NEW.BKG_NO, '' CNTR_NO, '' CNTR_PRT_FLG" ).append("\n"); 
		query.append("		, (SELECT ROUT_SEQ" ).append("\n"); 
		query.append("			 FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("			WHERE PCTL_NO = NEW.PCTL_NO -- (BKG이 가지고 있는 PCTLNO)" ).append("\n"); 
		query.append("			  AND PCTL_IO_BND_CD = 'T'" ).append("\n"); 
		query.append("		      AND ROWNUM =1) OCN_SEQ" ).append("\n"); 
		query.append("  FROM BKG_BOOKING OLD, BKG_BKG_HIS NEW" ).append("\n"); 
		query.append(" WHERE OLD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND OLD.BKG_NO = NEW.BKG_NO" ).append("\n"); 
		query.append("   AND NEW.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("   AND OLD.PCTL_NO <> NEW.PCTL_NO --PCTL_NO가 바뀌었으면 REPLAN 대상		" ).append("\n"); 
		query.append("   AND SUBSTR(NEW.PCTL_NO, 1, 1) <> 'Z' --OVER T/S BKG" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 2 ORD, 'CNTR_ATTACH' OPERATION, NEW.BKG_NO, NEW.CNTR_NO, NEW.CNTR_PRT_FLG, 0 OCN_SEQ" ).append("\n"); 
		query.append("  FROM (SELECT BKG_NO, CNTR_NO" ).append("\n"); 
		query.append("  		  FROM BKG_CNTR_HIS" ).append("\n"); 
		query.append("         WHERE BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("           AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("		 MINUS" ).append("\n"); 
		query.append("        SELECT BKG_NO, CNTR_NO" ).append("\n"); 
		query.append("  		  FROM BKG_CONTAINER" ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no]) CNTR" ).append("\n"); 
		query.append("	, BKG_CNTR_HIS NEW" ).append("\n"); 
		query.append(" WHERE NEW.BKG_NO  = CNTR.BKG_NO" ).append("\n"); 
		query.append("   AND NEW.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("   AND NEW.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 3 ORD, 'CNTR_DETACH' OPERATION, OLD.BKG_NO, OLD.CNTR_NO, OLD.CNTR_PRT_FLG, 0 OCN_SEQ" ).append("\n"); 
		query.append("  FROM (SELECT BKG_NO, CNTR_NO" ).append("\n"); 
		query.append("  		  FROM BKG_CONTAINER" ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		 MINUS" ).append("\n"); 
		query.append("        SELECT BKG_NO, CNTR_NO" ).append("\n"); 
		query.append("  		  FROM BKG_CNTR_HIS" ).append("\n"); 
		query.append("         WHERE BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("           AND CORR_NO = 'TMP0000001') CNTR" ).append("\n"); 
		query.append("	, BKG_CONTAINER OLD" ).append("\n"); 
		query.append(" WHERE OLD.BKG_NO  = CNTR.BKG_NO" ).append("\n"); 
		query.append("   AND OLD.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 5 ORD, 'CNTR_CONFIRM' OPERATION, CORR.BKG_NO, '' CNTR_NO, '' CNTR_PRT_FLG, 0 OCN_SEQ" ).append("\n"); 
		query.append("  FROM BKG_CORRECTION CORR, BKG_DOC_PROC_SKD CFM" ).append("\n"); 
		query.append(" WHERE CORR.BKG_NO = CFM.BKG_NO" ).append("\n"); 
		query.append("   AND CORR.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("   AND CFM.BKG_DOC_PROC_TP_CD = 'CNTR_CFM'" ).append("\n"); 
		query.append("   AND CFM.DOC_PERF_DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND CORR.CRE_DT < CFM.CRE_DT" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 6 ORD, 'SPCL_VVD_CHANGE' OPERATION, NEW.BKG_NO, '' CNTR_NO, '' CNTR_PRT_FLG, 0 OCN_SEQ" ).append("\n"); 
		query.append("  FROM BKG_BOOKING OLD, BKG_BKG_HIS NEW" ).append("\n"); 
		query.append(" WHERE OLD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND OLD.BKG_NO = NEW.BKG_NO" ).append("\n"); 
		query.append("   AND NEW.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("	--SPECIAL CARGO가 있을 경우" ).append("\n"); 
		query.append("   AND (EXISTS (SELECT 'Y' FROM BKG_DG_CGO_HIS  WHERE BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001' AND SPCL_CGO_APRO_CD <> 'C'" ).append("\n"); 
		query.append("				UNION ALL" ).append("\n"); 
		query.append("				SELECT 'Y' FROM BKG_RF_CGO_HIS  WHERE BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001' AND SPCL_CGO_APRO_CD <> 'C'" ).append("\n"); 
		query.append("				UNION ALL" ).append("\n"); 
		query.append("				SELECT 'Y' FROM BKG_AWK_CGO_HIS WHERE BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001' AND SPCL_CGO_APRO_CD <> 'C'" ).append("\n"); 
		query.append("				UNION ALL" ).append("\n"); 
		query.append("				SELECT 'Y' FROM BKG_BB_CGO_HIS  WHERE BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001' AND SPCL_CGO_APRO_CD <> 'C'" ).append("\n"); 
		query.append("				UNION ALL" ).append("\n"); 
		query.append("				SELECT 'Y' FROM BKG_STWG_CGO_HIS  WHERE BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001' AND SPCL_CGO_APRO_CD <> 'C' " ).append("\n"); 
		query.append("				) 	" ).append("\n"); 
		query.append("	    )" ).append("\n"); 
		query.append("	--VVD가 바뀌었으면" ).append("\n"); 
		query.append("   AND (EXISTS (SELECT BKG_NO, VSL_PRE_PST_CD, VSL_SEQ, VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("				  FROM BKG_VVD" ).append("\n"); 
		query.append(" 			     WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("			    MINUS" ).append("\n"); 
		query.append("			    SELECT BKG_NO, VSL_PRE_PST_CD, VSL_SEQ, VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("				  FROM BKG_VVD_HIS" ).append("\n"); 
		query.append("			     WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  				   AND CORR_NO = 'TMP0000001')" ).append("\n"); 
		query.append("		OR" ).append("\n"); 
		query.append("		EXISTS (SELECT BKG_NO, VSL_PRE_PST_CD, VSL_SEQ, VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("				  FROM BKG_VVD_HIS" ).append("\n"); 
		query.append("			     WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  				   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("			    MINUS" ).append("\n"); 
		query.append("			    SELECT BKG_NO, VSL_PRE_PST_CD, VSL_SEQ, VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("				  FROM BKG_VVD" ).append("\n"); 
		query.append(" 			     WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}