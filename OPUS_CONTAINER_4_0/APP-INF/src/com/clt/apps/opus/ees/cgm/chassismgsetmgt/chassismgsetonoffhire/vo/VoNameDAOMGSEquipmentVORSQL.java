/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VoNameDAOMGSEquipmentVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.04.23 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VoNameDAOMGSEquipmentVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MGSEquipmentINVO
	  * </pre>
	  */
	public VoNameDAOMGSEquipmentVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo").append("\n"); 
		query.append("FileName : VoNameDAOMGSEquipmentVORSQL").append("\n"); 
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
		query.append("'' AS CRE_DT" ).append("\n"); 
		query.append(", '' AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(", '' AS MGST_FUEL_CAPA" ).append("\n"); 
		query.append(", '' AS CRNT_YD_CD" ).append("\n"); 
		query.append(", '' AS BARE_CHK" ).append("\n"); 
		query.append(", '' AS ONH_DT" ).append("\n"); 
		query.append(", '' AS MGST_WARR_END_DT" ).append("\n"); 
		query.append(", '' AS EQ_NO" ).append("\n"); 
		query.append(", '' AS CNTR_CHK" ).append("\n"); 
		query.append(", '' AS MGST_RUN_HRS_UPD_DT" ).append("\n"); 
		query.append(", '' AS ONH_OFC_CD" ).append("\n"); 
		query.append(", '' AS EQ_SPEC_NO" ).append("\n"); 
		query.append(", '' AS UPD_USR_ID" ).append("\n"); 
		query.append(", '' AS AGREEMENT_NO" ).append("\n"); 
		query.append(", '' AS UPD_DT" ).append("\n"); 
		query.append(", '' AS AGMT_REF_NO" ).append("\n"); 
		query.append(", '' AS MGST_RUN_HRS" ).append("\n"); 
		query.append(", '' AS DAMAGE_CHK" ).append("\n"); 
		query.append(", '' AS ATCH_CHS" ).append("\n"); 
		query.append(", '' AS ATCH_CNTR" ).append("\n"); 
		query.append(", '' AS MGST_MCHN_SER_NO" ).append("\n"); 
		query.append(", '' AS MGST_VLTG_CAPA" ).append("\n"); 
		query.append(", '' AS AGMT_LSTM_CD" ).append("\n"); 
		query.append(", '' AS ACIAC_DIV_CD" ).append("\n"); 
		query.append(", '' AS EQ_KND_CD" ).append("\n"); 
		query.append(", '' AS EQ_TPSZ_CD" ).append("\n"); 
		query.append(", '' AS MFT_DT" ).append("\n"); 
		query.append(", '' AS CHS_CHK" ).append("\n"); 
		query.append(", '' AS CRE_USR_ID" ).append("\n"); 
		query.append(", '' AS VNDR_SEQ" ).append("\n"); 
		query.append(", '' AS MASTER_SAVE_FLAG" ).append("\n"); 
		query.append(", '' AS ORG_ATCH_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}