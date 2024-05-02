/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StatusCondDAORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusCondDAORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StatusCond
	  * </pre>
	  */
	public StatusCondDAORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.vo").append("\n"); 
		query.append("FileName : StatusCondDAORSQL").append("\n"); 
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
		query.append("  '' CLASS_CD " ).append("\n"); 
		query.append(", '' PERIOD " ).append("\n"); 
		query.append(", '' FROM_PERIOD" ).append("\n"); 
		query.append(", '' TO_PERIOD" ).append("\n"); 
		query.append(", '' AREA" ).append("\n"); 
		query.append(", '' STATUS" ).append("\n"); 
		query.append(", '' VT  -- Class Cd" ).append("\n"); 
		query.append(", '' PAGE_NO " ).append("\n"); 
		query.append(", '' HDLR_OFC_CD -- HOFC" ).append("\n"); 
		query.append(", '' HDLR_USR_ID -- Handler" ).append("\n"); 
		query.append(", '' MGR_USR_ID  -- Manager" ).append("\n"); 
		query.append(", '' HNDL_OFC_CD" ).append("\n"); 
		query.append(", '' LABL_CLM_PTY_NO -- Liable Party" ).append("\n"); 
		query.append(", '' SVEY_CLM_PTY_NO -- Surveyor" ).append("\n"); 
		query.append(", '' FMAL_CLM_RCV_OFC_CD -- ROFC" ).append("\n"); 
		query.append(", '' CLMT_CLM_PTY_NO -- Claimant" ).append("\n"); 
		query.append(", '' CLMT_CLM_AGN_PTY_NO -- Claimant's Agent" ).append("\n"); 
		query.append(", '' SLV_CLM_PTY_NO -- Salvager" ).append("\n"); 
		query.append(", '' INSUR_CLM_PTY_NO -- Insurer" ).append("\n"); 
		query.append(", '' CLM_STL_AUTH_USR_ID -- APPROVER " ).append("\n"); 
		query.append(", '' TRNK_REF_VVD_NO -- VVD" ).append("\n"); 
		query.append(", '' POR_CD -- POR" ).append("\n"); 
		query.append(", '' POL_CD -- POL" ).append("\n"); 
		query.append(", '' POD_CD -- POD" ).append("\n"); 
		query.append(", '' DEL_CD -- DEL" ).append("\n"); 
		query.append(", '' FVD  -- FVD" ).append("\n"); 
		query.append(", '' N1ST_PRE_TS_LOC_CD -- PRE_POT" ).append("\n"); 
		query.append(", '' N1ST_PST_TS_LOC_CD -- PST_POT" ).append("\n"); 
		query.append(", '' CRR_TERM_CD " ).append("\n"); 
		query.append(", '' INCI_PLC_TP_CD" ).append("\n"); 
		query.append(", '' SLAN_CD" ).append("\n"); 
		query.append(", '' CLM_CGO_TP_CD" ).append("\n"); 
		query.append(", '' CGO_CLM_TP_CD" ).append("\n"); 
		query.append(", '' MJR_CLM_DMG_LSS_CD" ).append("\n"); 
		query.append(", '' N3RD_LABL_PTY_CD" ).append("\n"); 
		query.append(", '' LIT" ).append("\n"); 
		query.append(", '' CGO_CLM_STL_TP_CD" ).append("\n"); 
		query.append(", '' FROM_CLMT_USD_AMT" ).append("\n"); 
		query.append(", '' TO_CLMT_USD_AMT" ).append("\n"); 
		query.append(", '' FROM_CGO_CLM_STL_USD_AMT" ).append("\n"); 
		query.append(", '' TO_CGO_CLM_STL_USD_AMT" ).append("\n"); 
		query.append(", '' CGO_CLM_INCI_NO" ).append("\n"); 
		query.append(", '' REPORT_ID -- Report Id" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}