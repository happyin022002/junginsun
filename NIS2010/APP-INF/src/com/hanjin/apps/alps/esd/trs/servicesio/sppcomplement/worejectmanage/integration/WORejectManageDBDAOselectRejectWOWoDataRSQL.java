/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WORejectManageDBDAOselectRejectWOWoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2009.11.05 양봉준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.worejectmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WORejectManageDBDAOselectRejectWOWoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * selectRejectWOWoData
	  * </pre>
	  */
	public WORejectManageDBDAOselectRejectWOWoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FORM_USR_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_WO_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_WO_OFC_CTY_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FORM_CRE_USR_ID",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.worejectmanage.integration").append("\n"); 
		query.append("FileName : WORejectManageDBDAOselectRejectWOWoDataRSQL").append("\n"); 
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
		query.append("'SEARCH02' as f_cmd," ).append("\n"); 
		query.append("@[FORM_CRE_USR_ID]	as FORM_CRE_USR_ID," ).append("\n"); 
		query.append("@[FORM_USR_OFC_CD] as FORM_USR_OFC_CD," ).append("\n"); 
		query.append("'Y' 		as issued," ).append("\n"); 
		query.append("'' 		as SCG_GRP_SEQ," ).append("\n"); 
		query.append("WO_VNDR_SEQ," ).append("\n"); 
		query.append("( SELECT" ).append("\n"); 
		query.append("DECODE(COUNT(*),0,'N','C')" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("TRSP_WO_OFC_CTY_CD= @[TRSP_WO_OFC_CTY_CD]" ).append("\n"); 
		query.append("AND TRSP_WO_SEQ= @[TRSP_WO_SEQ]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND NVL(WO_RJCT_FLG,'N') <> 'Y')" ).append("\n"); 
		query.append("AS WO_ISS_STS_CD," ).append("\n"); 
		query.append("TRSP_WO_OFC_CTY_CD," ).append("\n"); 
		query.append("TRSP_WO_SEQ," ).append("\n"); 
		query.append("'TRS'		as FAX_SYS_CD," ).append("\n"); 
		query.append("''			as FAX_APP_CD," ).append("\n"); 
		query.append("'N'		as FAX_BATCH_IND," ).append("\n"); 
		query.append("'Hanjin Shipping Work Order'	as FAX_TITLE," ).append("\n"); 
		query.append("''			as FAX_PARAM," ).append("\n"); 
		query.append("''			as FAX_RCV_INFO," ).append("\n"); 
		query.append("'Hanjin Shipping Work Order'	as EMAIL_TITLE," ).append("\n"); 
		query.append("'Dear  '||VNDR_LGL_ENG_NM ||" ).append("\n"); 
		query.append("'Please refer to the attached file.'||" ).append("\n"); 
		query.append("'You can also retrieve detailed information on this work order in the following web site http://partner.smlines.com/' ||" ).append("\n"); 
		query.append("'Thank you. \\n Hanjin Shipping '	 as EMAIL_CONTENTS," ).append("\n"); 
		query.append("DECODE(WO.WO_PRN_USE_FLG,'Y','PRN')	WO_PRN_USE_FLG," ).append("\n"); 
		query.append("DECODE(WO.WO_EML_USE_FLG,'Y','EML')	WO_EML_USE_FLG," ).append("\n"); 
		query.append("DECODE(WO.WO_FAX_USE_FLG,'Y','FAX')    WO_FAX_USE_FLG," ).append("\n"); 
		query.append("DECODE(WO.WO_EDI_USE_FLG,'Y','EDI')    WO_EDI_USE_FLG," ).append("\n"); 
		query.append("WO.RT_DP_USE_FLG		RT_DP_USE_FLG," ).append("\n"); 
		query.append("WO.CMDT_DP_USE_FLG		CMDT_DP_USE_FLG," ).append("\n"); 
		query.append("WO.PRE_DIS_USE_FLG		PRE_DIS_USE_FLG," ).append("\n"); 
		query.append("WO.WO_N1ST_EML			WO_N1ST_EML," ).append("\n"); 
		query.append("WO.WO_N2ND_EML			WO_N2ND_EML," ).append("\n"); 
		query.append("WO.WO_N3RD_EML			WO_N3RD_EML," ).append("\n"); 
		query.append("WO.WO_N1ST_FAX_NO		WO_N1ST_FAX_NO," ).append("\n"); 
		query.append("WO.WO_N2ND_FAX_NO		WO_N2ND_FAX_NO," ).append("\n"); 
		query.append("WO.WO_N3RD_FAX_NO		WO_N3RD_FAX_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_WRK_ORD WO, MDM_VENDOR VD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("WO.WO_VNDR_SEQ=VD.VNDR_SEQ (+)" ).append("\n"); 
		query.append("AND TRSP_WO_OFC_CTY_CD= @[TRSP_WO_OFC_CTY_CD]" ).append("\n"); 
		query.append("AND TRSP_WO_SEQ= @[TRSP_WO_SEQ]" ).append("\n"); 
		query.append("AND WO.DELT_FLG = 'N'" ).append("\n"); 

	}
}