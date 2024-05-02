/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AncsManifestListDownloadDBDAOsearchAncsManifestTransmitVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.03
*@LastModifier : 
*@LastVersion : 1.0
* 2011.01.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsManifestListDownloadDBDAOsearchAncsManifestTransmitVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 1. 2011.01.03 이수진 [CHM-201007774] EUR 24HR 관련 구주 세관 시스템 MRN 정보 추가 요청
	  *    BL Inquiry 화면에서 첫번째 Sheet 조회시 나온 데이타를 FlatFile 작성시 사용하자고 VO SQL로 작성함.
	  * </pre>
	  */
	public AncsManifestListDownloadDBDAOsearchAncsManifestTransmitVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration").append("\n"); 
		query.append("FileName : AncsManifestListDownloadDBDAOsearchAncsManifestTransmitVORSQL").append("\n"); 
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
		query.append("SELECT	  '' SVC_RQST_NO" ).append("\n"); 
		query.append(", '' CNEE_ADDR" ).append("\n"); 
		query.append(", '' FLAT_TYPE" ).append("\n"); 
		query.append(", '' BL_ACK" ).append("\n"); 
		query.append(", '' PREV_DOCNO" ).append("\n"); 
		query.append(", '' CM_PCK_QTY" ).append("\n"); 
		query.append(", '' BL_ACK2" ).append("\n"); 
		query.append(", '' ANR_MSG_STS_CD" ).append("\n"); 
		query.append(", '' LLOYD_CD" ).append("\n"); 
		query.append(", '' CNTR_MF_WGT" ).append("\n"); 
		query.append(", '' BL_NO" ).append("\n"); 
		query.append(", '' POL_CD" ).append("\n"); 
		query.append(", '' CNTR_ACK2" ).append("\n"); 
		query.append(", '' CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", '' WGT_UT_CD" ).append("\n"); 
		query.append(", '' BRTH_DESC" ).append("\n"); 
		query.append(", '' CNTR_SEQ" ).append("\n"); 
		query.append(", '' CNTR_WGT_UT_CD" ).append("\n"); 
		query.append(", '' CNTR_ACK" ).append("\n"); 
		query.append(", '' MF_DESC" ).append("\n"); 
		query.append(", '' VVD_SEQ" ).append("\n"); 
		query.append(", '' CNTR_PCK_TP_CD" ).append("\n"); 
		query.append(", '' PRE_RLY_PORT_CD" ).append("\n"); 
		query.append(", '' DEL_CD" ).append("\n"); 
		query.append(", '' MSG_TP_CD" ).append("\n"); 
		query.append(", '' RD_TERM" ).append("\n"); 
		query.append(", '' VVD" ).append("\n"); 
		query.append(", '' POD_CD" ).append("\n"); 
		query.append(", '' BKG_NO" ).append("\n"); 
		query.append(", '' NTFY_NAME" ).append("\n"); 
		query.append(", '' FAX_NO" ).append("\n"); 
		query.append(", '' PST_RLY_PORT_CD" ).append("\n"); 
		query.append(", '' DECL_FLG" ).append("\n"); 
		query.append(", '' CNTR_WGT_QTY" ).append("\n"); 
		query.append(", '' POR_CD" ).append("\n"); 
		query.append(", '' SHPR_NAME" ).append("\n"); 
		query.append(", '' BDR_FLG" ).append("\n"); 
		query.append(", '' MSG_SEQ" ).append("\n"); 
		query.append(", '' KIND" ).append("\n"); 
		query.append(", '' ACT_WGT_UT_CD" ).append("\n"); 
		query.append(", '' SHPR_ADDR" ).append("\n"); 
		query.append(", '' CNTR_MF_DESC" ).append("\n"); 
		query.append(", '' CM_CNTR_NO" ).append("\n"); 
		query.append(", '' PCK_QTY" ).append("\n"); 
		query.append(", '' PCK_TP_CD" ).append("\n"); 
		query.append(", '' BL_LAST_EDI" ).append("\n"); 
		query.append(", '' ANR_DECL_NO" ).append("\n"); 
		query.append(", '' BL_LAST_EDI2" ).append("\n"); 
		query.append(", '' S3" ).append("\n"); 
		query.append(", '' CNTR_LAST_EDI2" ).append("\n"); 
		query.append(", '' CNTR_ANR_MSG_STS_CD" ).append("\n"); 
		query.append(", '' NTFY_ADDR" ).append("\n"); 
		query.append(", '' S2" ).append("\n"); 
		query.append(", '' S1" ).append("\n"); 
		query.append(", '' ACT_WGT" ).append("\n"); 
		query.append(", '' NTFY_EML" ).append("\n"); 
		query.append(", '' CM_PCK_TP_CD" ).append("\n"); 
		query.append(", '' CNEE_NAME" ).append("\n"); 
		query.append(", '' CNTR_NO" ).append("\n"); 
		query.append(", '' SEQUENCE" ).append("\n"); 
		query.append(", '' CNTR_PCK_QTY" ).append("\n"); 
		query.append(", '' CNTR_LAST_EDI" ).append("\n"); 
		query.append(", '' CNTR_FM" ).append("\n"); 
		query.append(", '' MRN_NO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}