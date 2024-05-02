/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ZDAOPkupNtcManualListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.11
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2010.02.11 박미옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mi Ok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ZDAOPkupNtcManualListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pickup Notice Manual List VO - 박미옥
	  * </pre>
	  */
	public ZDAOPkupNtcManualListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ZDAOPkupNtcManualListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	'' ERR_FLAG" ).append("\n"); 
		query.append(",	'' BL_NO" ).append("\n"); 
		query.append(",	'' VVD" ).append("\n"); 
		query.append(",	'' POD_CD" ).append("\n"); 
		query.append(",	'' DEL_CD" ).append("\n"); 
		query.append(",	'' DE_TERM_CD" ).append("\n"); 
		query.append(",	'' CUST_CD" ).append("\n"); 
		query.append(",	'' BKG_CUST_TP_CD" ).append("\n"); 
		query.append(",	'' BKG_NO" ).append("\n"); 
		query.append(",	'' NTC_SEQ" ).append("\n"); 
		query.append(",	'' PKUP_NTC_TP_CD" ).append("\n"); 
		query.append(",	'' PKUP_NTC_FOM_CD" ).append("\n"); 
		query.append(",	'' BKG_CUST_TP_CD" ).append("\n"); 
		query.append(",	'' CUST_CNT_CD" ).append("\n"); 
		query.append(",	'' CUST_SEQ" ).append("\n"); 
		query.append(",	'' CUST_NM" ).append("\n"); 
		query.append("--,	PKUP_NTC_EVNT_DT" ).append("\n"); 
		query.append("--,	EXP_SND_DT" ).append("\n"); 
		query.append(",	'' CNTR_NO" ).append("\n"); 
		query.append(",	'' RAIL_LOD_DT" ).append("\n"); 
		query.append(",	'' NTFC_DT" ).append("\n"); 
		query.append(",	'' FRT_CLT_FLG" ).append("\n"); 
		query.append(",	'' OBL_CLT_FLG" ).append("\n"); 
		query.append(",	'' CSTMS_CLR_FLG" ).append("\n"); 
		query.append(",	'' PKUP_NO" ).append("\n"); 
		query.append(",	'' RAIL_RMP_FREE_DYS" ).append("\n"); 
		query.append(",	'' LST_FREE_DT" ).append("\n"); 
		query.append(",	'' EDI_322_MVMT_CD" ).append("\n"); 
		query.append(",	'' PKUP_YD_CD" ).append("\n"); 
		query.append(",	'' RTN_YD_CD" ).append("\n"); 
		query.append(",	'' DOR_TRKR_WO_FLG" ).append("\n"); 
		query.append(",	'' PKUP_NTC_SND_STS_CD" ).append("\n"); 
		query.append(",	'' IBD_TRSP_HUB_CD" ).append("\n"); 
		query.append(",	'' DIFF_RMK" ).append("\n"); 
		query.append(",	'' PKUP_AVAL_DT" ).append("\n"); 
		query.append(",	'' CRE_USR_ID" ).append("\n"); 
		query.append("--,	CRE_DT" ).append("\n"); 
		query.append(",	'' UPD_USR_ID" ).append("\n"); 
		query.append("--,	UPD_DT" ).append("\n"); 
		query.append(",	'' TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(",	'' TRSP_SO_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}