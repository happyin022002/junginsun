/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AusCustomsTransmissionDBDAOsearchContainerDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2010.03.09 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM SEUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AusCustomsTransmissionDBDAOsearchContainerDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 호주세관 및 항만청으로 전송할 Manifest Container Description 정보를 조회한다.
	  * </pre>
	  */
	public AusCustomsTransmissionDBDAOsearchContainerDescRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.integration").append("\n"); 
		query.append("FileName : AusCustomsTransmissionDBDAOsearchContainerDescRSQL").append("\n"); 
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
		query.append("SELECT   " ).append("\n"); 
		query.append("		'' d_cmdt," ).append("\n"); 
		query.append("		NVL(A.PCK_TP_CD,'') d_punit," ).append("\n"); 
		query.append("		NVL(A.PCK_QTY,0) d_pkg," ).append("\n"); 
		query.append("		DECODE(NVL(A.WGT_UT_CD,''),'LBS',ROUND(NVL(A.CNTR_MF_WGT,0)*0.4536,3),NVL(A.CNTR_MF_WGT,0)) d_wgt," ).append("\n"); 
		query.append("		DECODE(NVL(A.MEAS_UT_CD,''),'CBF',ROUND(NVL(A.MEAS_QTY,0)*0.0283,3),NVL(A.MEAS_QTY,0)) d_meas," ).append("\n"); 
		query.append("		TRANSLATE(NVL(B.CSTMS_DESC,' '),CHR(13)||CHR(10),' ') d_desc," ).append("\n"); 
		query.append("		DECODE(A.CNTR_MF_MK_DESC,NULL,''," ).append("\n"); 
		query.append("		REPLACE(A.CNTR_MF_MK_DESC,CHR(13)||CHR(10),CHR(10)))  d_mark" ).append("\n"); 
		query.append("FROM  BKG_CNTR_MF_DESC A, BKG_BL_DOC B" ).append("\n"); 
		query.append("WHERE	A.BKG_NO        = @[bkg_no] " ).append("\n"); 
		query.append("AND	A.BKG_NO        = B.BKG_NO " ).append("\n"); 
		query.append("AND	A.CNTR_NO       = @[cntr_no]" ).append("\n"); 

	}
}