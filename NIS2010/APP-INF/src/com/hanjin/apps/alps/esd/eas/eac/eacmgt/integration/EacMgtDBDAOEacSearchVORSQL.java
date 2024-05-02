/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOEacSearchVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.07
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.07 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOEacSearchVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EAC 조회조건에 사용되는 공통VO
	  * </pre>
	  */
	public EacMgtDBDAOEacSearchVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOEacSearchVORSQL").append("\n"); 
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
		query.append("SELECT '' AS CODE_CD" ).append("\n"); 
		query.append("     , '' AS CODE_NM" ).append("\n"); 
		query.append("     , '' AS CODE_KEY" ).append("\n"); 
		query.append("     , '' AS EAC_EXPN_TP_CD" ).append("\n"); 
		query.append("     , '' AS N3PTY_EXPN_TP_CD" ).append("\n"); 
		query.append("     , '' AS S_EAC_EXPN_TP_CD" ).append("\n"); 
		query.append("     , '' AS EAC_TYPE1" ).append("\n"); 
		query.append("     , '' AS OFFCE_LVL" ).append("\n"); 
		query.append("     , '' AS OFC_CD" ).append("\n"); 
		query.append("     , '' AS OFC_TP_CD -- OFFICE LVL H:HO, R:HQ , O:기타" ).append("\n"); 
		query.append("     , '' AS VNDR_SEQ" ).append("\n"); 
		query.append("     , '' AS VNDR_NM " ).append("\n"); 
		query.append("     , '' AS RESPB_OFC_CD" ).append("\n"); 
		query.append("     , '' AS ISFLAG" ).append("\n"); 
		query.append("     , '' AS YD_CD" ).append("\n"); 
		query.append("     , '' AS CNT_CD" ).append("\n"); 
		query.append("     , '' AS RHQ_OFC_CD" ).append("\n"); 
		query.append("     , '' AS BIL_CURR_CD" ).append("\n"); 
		query.append("     , '' AS BIL_CURR_CD1" ).append("\n"); 
		query.append("     , '' AS N3PTY_SRC_DT" ).append("\n"); 
		query.append("     , '' AS CURR_CD" ).append("\n"); 
		query.append("     , '' AS USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("     , '' AS S_RHQ_OFC_CD" ).append("\n"); 
		query.append("     , '' AS S_OFC_CD" ).append("\n"); 
		query.append("     , '' AS S_CNT_CD" ).append("\n"); 
		query.append("     , '' AS S_VNDR_SEQ" ).append("\n"); 
		query.append("     , '' AS G_VNDR_SEQ" ).append("\n"); 
		query.append("     , '' AS OFC_TP_CD" ).append("\n"); 
		query.append("     , '' AS VNDR_CNTC_PNT_SEQ" ).append("\n"); 
		query.append("     , '' AS VNDR_CNTC_PNT_NM" ).append("\n"); 
		query.append("     , '' AS CNT" ).append("\n"); 
		query.append("     , '' AS N3PTY_SRC_NO" ).append("\n"); 
		query.append("     , '' AS EAC_NO" ).append("\n"); 
		query.append("     , '' AS BKG_NO" ).append("\n"); 
		query.append("     , '' AS BL_NO" ).append("\n"); 
		query.append("     , '' AS N3PTY_NO" ).append("\n"); 
		query.append("     , '' AS RW_AUTH_CD" ).append("\n"); 
		query.append("     , '' AS CONTACT_POINT_EXISTS" ).append("\n"); 
		query.append("     , '' AS EAC_STS_CD" ).append("\n"); 
		query.append("     , '' AS USR_ID" ).append("\n"); 
		query.append("     , '' AS EAC_APRO_RSN" ).append("\n"); 
		query.append("     , '' AS S_TRD_PARTY_VAL" ).append("\n"); 
		query.append("     , '' AS S_VNDR_CUST_DIV_CD" ).append("\n"); 
		query.append("     , '' AS VAL" ).append("\n"); 
		query.append("     , '' AS EML_SUBJ_CTNT" ).append("\n"); 
		query.append("     , '' AS EML_CTNT" ).append("\n"); 
		query.append("     , '' AS S_EAC_REG_USR_ID" ).append("\n"); 
		query.append("     , '' AS S_EAC_TP_CD" ).append("\n"); 
		query.append("     , '' AS S_EAC_BIL_TP_CD" ).append("\n"); 
		query.append("     , '' AS S_EAC_INP_FM_DT" ).append("\n"); 
		query.append("     , '' AS S_EAC_INP_TO_DT" ).append("\n"); 
		query.append("     , '' AS S_KEYWORD" ).append("\n"); 
		query.append("     , '' AS S_EAC_STS_CD" ).append("\n"); 
		query.append("     , '' AS S_EAC_YRMON" ).append("\n"); 
		query.append("     , '' AS S_INV_AUD_USD_AMT" ).append("\n"); 
		query.append("     , '' AS S_EAC_DUP" ).append("\n"); 
		query.append("     , '' AS S_TPB_DUP" ).append("\n"); 
		query.append("     , '' AS OFCLEVEL" ).append("\n"); 
		query.append("     , '' AS SORTKEY" ).append("\n"); 
		query.append("     , '' AS USR_EXIST_FLAG" ).append("\n"); 
		query.append("     , '' AS USR_EML" ).append("\n"); 
		query.append("     , '' AS OFC_EXIST_FLAG" ).append("\n"); 
		query.append("     , '' AS NTC_CC_RCV_EML" ).append("\n"); 
		query.append("     , '' AS S_EAC_YRMON_FM" ).append("\n"); 
		query.append("     , '' AS S_EAC_YRMON_TO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}