/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VoMakeDAOFACCommCalculationInfoVORSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.16
*@LastModifier :
*@LastVersion : 1.0
* 2012.05.16
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VoMakeDAOFACCommCalculationInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public VoMakeDAOFACCommCalculationInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.vo").append("\n");
		query.append("FileName : VoMakeDAOFACCommCalculationInfoVORSQL").append("\n");
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
		query.append("SELECT" ).append("\n");
		query.append(" '' POR_CD" ).append("\n");
		query.append(", '' POR_RGN_CD" ).append("\n");
		query.append(", '' POR_CNT_CD" ).append("\n");
		query.append(", '' POR_STE_CD" ).append("\n");
		query.append(", '' POR_SCONTI_CD" ).append("\n");
		query.append(", '' POR_CONTI_CD" ).append("\n");
		query.append(", '' POR_FINC_CTRL_OFC_CD" ).append("\n");
		query.append(", '' POR_AR_OFC_CD" ).append("\n");
		query.append(", '' POR_AP_OFC_CD" ).append("\n");
		query.append(", '' POL_CD" ).append("\n");
		query.append(", '' POL_RGN_CD" ).append("\n");
		query.append(", '' POL_CNT_CD" ).append("\n");
		query.append(", '' POL_STE_CD" ).append("\n");
		query.append(", '' POL_SCONTI_CD" ).append("\n");
		query.append(", '' POL_CONTI_CD" ).append("\n");
		query.append(", '' POL_FINC_CTRL_OFC_CD" ).append("\n");
		query.append(", '' POL_AR_OFC_CD" ).append("\n");
		query.append(", '' POL_AP_OFC_CD" ).append("\n");
		query.append(", '' POD_CD" ).append("\n");
		query.append(", '' POD_RGN_CD" ).append("\n");
		query.append(", '' POD_CNT_CD" ).append("\n");
		query.append(", '' POD_STE_CD" ).append("\n");
		query.append(", '' POD_SCONTI_CD" ).append("\n");
		query.append(", '' POD_CONTI_CD" ).append("\n");
		query.append(", '' POD_FINC_CTRL_OFC_CD" ).append("\n");
		query.append(", '' POD_AR_OFC_CD" ).append("\n");
		query.append(", '' POD_AP_OFC_CD" ).append("\n");
		query.append(", '' DEL_CD" ).append("\n");
		query.append(", '' DEL_RGN_CD" ).append("\n");
		query.append(", '' DEL_CNT_CD" ).append("\n");
		query.append(", '' DEL_STE_CD" ).append("\n");
		query.append(", '' DEL_SCONTI_CD" ).append("\n");
		query.append(", '' DEL_CONTI_CD" ).append("\n");
		query.append(", '' DEL_FINC_CTRL_OFC_CD" ).append("\n");
		query.append(", '' DEL_AR_OFC_CD" ).append("\n");
		query.append(", '' DEL_AP_OFC_CD" ).append("\n");
		query.append(", '' RCV_TERM_CD" ).append("\n");
		query.append(", '' DE_TERM_CD" ).append("\n");
		query.append(", '' BKG_OFC_CD" ).append("\n");
		query.append(", '' BKG_FINC_CTRL_OFC_CD" ).append("\n");
		query.append(", '' BKG_AR_OFC_CD" ).append("\n");
		query.append(", '' BKG_OFC_LOC_CD" ).append("\n");
		query.append(", '' BKG_SLS_OFC_CD" ).append("\n");
		query.append(", '' BKG_STS_CD" ).append("\n");
		query.append(", '' BKG_CGO_TP_CD" ).append("\n");
		query.append(", '' CMDT_CD" ).append("\n");
		query.append(", '' REP_CMDT_CD" ).append("\n");
		query.append(", '' BL_NO" ).append("\n");
		query.append(", '' DBL_BKG_FLG" ).append("\n");
		query.append(", '' BKG_SHPR_OWNR_FLG" ).append("\n");
		query.append(", '' BKG_CRE_DT" ).append("\n");
		query.append(", '' BKG_OFC_AGN_CD" ).append("\n");
		query.append(", '' SPCL_DG_CGO_FLG" ).append("\n");
		query.append(", '' SPCL_RC_FLG" ).append("\n");
		query.append(", '' SPCL_AWK_CGO_FLG" ).append("\n");
		query.append(", '' SPCL_BB_CGO_FLG" ).append("\n");
		query.append(", '' PRE_RLY_PORT_CD" ).append("\n");
		query.append(", '' PST_RLY_PORT_CD" ).append("\n");
		query.append(", '' BSL_DEL_OFC_CD" ).append("\n");
		query.append(", '' BSL_DEL_AR_OFC_CD" ).append("\n");
		query.append(", '' BSL_DEL_AP_OFC_CD" ).append("\n");
		query.append(", '' CTRT_OFC_CD" ).append("\n");
		query.append(", '' SC_NO" ).append("\n");
		query.append(", '' RFA_NO" ).append("\n");
		query.append(", '' BKG_SVC_SCP_CD" ).append("\n");
		query.append(", '' SVC_SCP_CHECK" ).append("\n");
		query.append(", '' COVERED_CHECK" ).append("\n");
		query.append(", '' SHPR_CNT_CD" ).append("\n");
		query.append(", '' SHPR_CUST_SEQ" ).append("\n");
		query.append(", '' FF_CNT_CD" ).append("\n");
		query.append(", '' FF_CUST_SEQ" ).append("\n");
		query.append(", '' FMC_NO" ).append("\n");
		query.append(", '' FF_FMC_CHECK_FLAG" ).append("\n");
		query.append(", '' REFERENCE_NO" ).append("\n");
		query.append(", '' SH_FF_CHECK_FLAG" ).append("\n");
		query.append(", '' FF_CHECK" ).append("\n");
		query.append("FROM DUAL" ).append("\n");

	}
}