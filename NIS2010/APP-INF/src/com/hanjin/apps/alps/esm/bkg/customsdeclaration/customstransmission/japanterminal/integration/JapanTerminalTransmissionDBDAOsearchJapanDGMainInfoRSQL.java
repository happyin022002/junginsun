/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOsearchJapanDGMainInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.23
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2013.01.23 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sangbo La
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOsearchJapanDGMainInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * flat file Japan Container Danger Main Info 조회 쿼리
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOsearchJapanDGMainInfoRSQL(){
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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n"); 
		query.append("FileName : JapanTerminalTransmissionDBDAOsearchJapanDGMainInfoRSQL").append("\n"); 
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
		query.append("--CLAS          C	3	0				DANGER_CGO.DG_UNNO	BKG_TML_EDI_JP_DG_CGO" ).append("\n"); 
		query.append("--" ).append("\n"); 
		query.append("--UNBR    		C	4	UN No.				DANGER_CGO.DG_IMO_CLASS	BKG_TML_EDI_JP_DG_CGO" ).append("\n"); 
		query.append("--PKGGRP          		C	1	PKG GROUP				DANGER_CGO.DG_PACK_GP1||DANGER_CGO.DG_PACK_GP2||DANGER_CGO.DG_PACK_GP3	BKG_TML_EDI_JP_DG_CGO" ).append("\n"); 
		query.append("--" ).append("\n"); 
		query.append("--CNTR_TPSZ_CD:5" ).append("\n"); 
		query.append("----IMDG_CLSS_CD:5" ).append("\n"); 
		query.append("------IMDG_UN_NO, IMDG_PCK_GRP_CD:10" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT CNTR_TPSZ_CD, IMDG_CLSS_CD" ).append("\n"); 
		query.append("FROM BKG_TML_EDI_JP_DG_CGO" ).append("\n"); 
		query.append("WHERE BKG_NO LIKE SUBSTR(@[bkg_no], 1, 10)||'%'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("AND BKG_SKD_SEQ = 0" ).append("\n"); 
		query.append("GROUP BY CNTR_TPSZ_CD, IMDG_CLSS_CD" ).append("\n"); 

	}
}