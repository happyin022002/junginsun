/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommRequestDBDAOAddAcmAgnBkgInfoHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.26
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.10.26 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOAddAcmAgnBkgInfoHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddAcmAgnBkgInfoHis
	  * </pre>
	  */
	public AGNCommRequestDBDAOAddAcmAgnBkgInfoHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("calc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOAddAcmAgnBkgInfoHisCSQL").append("\n"); 
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
		query.append("insert into ACM_AGN_BKG_INFO_HIS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("BKG_NO,CALC_NO,BL_NO,BL_NO_TP,BL_TP_CD,BKG_STS_CD,BKG_CGO_TP_CD,BL_CVRD_TP_CD,CHN_BKG_AGN_CD,BKG_OFC_CD,CLT_OFC_CD,BKG_CRE_DT,BDR_FLG,BDR_DT,POR_CD,POR_FINC_CTRL_OFC_CD,POR_AR_OFC_CD,POL_CD,POL_FINC_CTRL_OFC_CD,POL_AR_OFC_CD,POD_CD,POD_FINC_CTRL_OFC_CD,POD_AR_OFC_CD,DEL_CD,DEL_FINC_CTRL_OFC_CD,DEL_AR_OFC_CD,BKG_RCV_TERM_CD,BKG_DE_TERM_CD,TRD_CD,SLAN_CD,RLANE_CD,REV_VVD_CD,TRNK_SLAN_CD,TRNK_RLANE_CD,TRNK_VSL_CD,TRNK_SKD_VOY_NO,TRNK_SKD_DIR_CD,TRNK_REV_DIR_CD,SVC_SCP_CD,PRE_PORT_CD,PST_PORT_CD,FMC_NO,PPD_OFRT_AMT,PPD_CHG_AMT,CLT_OFRT_AMT,CLT_CHG_AMT,COMM_PROC_RSLT_RSN,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT,SHPR_CNT_CD,SHPR_SEQ,FRT_FWRD_CNT_CD,FRT_FWRD_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("select BKG_NO,@[calc_no] AS CALC_NO,BL_NO,BL_NO_TP,BL_TP_CD,BKG_STS_CD,BKG_CGO_TP_CD,BL_CVRD_TP_CD,CHN_BKG_AGN_CD,BKG_OFC_CD,CLT_OFC_CD,BKG_CRE_DT,BDR_FLG,BDR_DT,POR_CD,POR_FINC_CTRL_OFC_CD,POR_AR_OFC_CD,POL_CD,POL_FINC_CTRL_OFC_CD,POL_AR_OFC_CD,POD_CD,POD_FINC_CTRL_OFC_CD,POD_AR_OFC_CD,DEL_CD,DEL_FINC_CTRL_OFC_CD,DEL_AR_OFC_CD,BKG_RCV_TERM_CD,BKG_DE_TERM_CD,TRD_CD,SLAN_CD,RLANE_CD,REV_VVD_CD,TRNK_SLAN_CD,TRNK_RLANE_CD,TRNK_VSL_CD,TRNK_SKD_VOY_NO,TRNK_SKD_DIR_CD,TRNK_REV_DIR_CD,SVC_SCP_CD,PRE_PORT_CD,PST_PORT_CD,FMC_NO,PPD_OFRT_AMT,PPD_CHG_AMT,CLT_OFRT_AMT,CLT_CHG_AMT,COMM_PROC_RSLT_RSN,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT,SHPR_CNT_CD,SHPR_SEQ,FRT_FWRD_CNT_CD,FRT_FWRD_SEQ" ).append("\n"); 
		query.append("from ACM_AGN_BKG_INFO I" ).append("\n"); 
		query.append("where 1=1" ).append("\n"); 
		query.append("and BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}