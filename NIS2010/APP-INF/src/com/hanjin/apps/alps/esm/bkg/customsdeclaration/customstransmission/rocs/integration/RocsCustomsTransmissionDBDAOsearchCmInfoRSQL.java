/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RocsCustomsTransmissionDBDAOsearchCmInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RocsCustomsTransmissionDBDAOsearchCmInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROCS(ROTTERDAM) 세관 신고용
	  * </pre>
	  */
	public RocsCustomsTransmissionDBDAOsearchCmInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_crn_number",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.rocs.integration").append("\n"); 
		query.append("FileName : RocsCustomsTransmissionDBDAOsearchCmInfoRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(EDI_SEQ) CM_SEQ_NO," ).append("\n"); 
		query.append("TO_CHAR(PCK_QTY) CM_PKG_NO," ).append("\n"); 
		query.append("PCK_TP_CD CM_PKG_CD," ).append("\n"); 
		query.append("SUBSTR(HAMO_TRF_CD,1,4) CM_HS_CD," ).append("\n"); 
		query.append("REPLACE(CNTR_MF_DESC, CHR(13)||CHR(10),' ') CM_DESC," ).append("\n"); 
		query.append("TO_CHAR(DECODE(CNTR_WGT_UT_CD, 'LBS', ROUND(NVL(CNTR_MF_WGT,0)*0.4536,0), CNTR_MF_WGT) ) CM_WGT," ).append("\n"); 
		query.append("'KGS' CM_WGT_U," ).append("\n"); 
		query.append("CNTR_NO CM_CNTR_NO" ).append("\n"); 
		query.append("FROM	 BKG_CSTMS_RTM_CGO_MF" ).append("\n"); 
		query.append("WHERE	 VSL_CALL_REF_NO = @[frm_crn_number]" ).append("\n"); 
		query.append("AND	 BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("ORDER BY EDI_SEQ" ).append("\n"); 

	}
}