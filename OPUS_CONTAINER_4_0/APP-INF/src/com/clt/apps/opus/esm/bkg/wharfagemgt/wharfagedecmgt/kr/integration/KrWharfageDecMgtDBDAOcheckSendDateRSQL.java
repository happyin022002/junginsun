/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOcheckSendDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.29
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOcheckSendDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 부산으로 입항 하는 모선에 대하여 날짜 체크
	  * 
	  * 조건:
	  * 1. 부산입항
	  * 2. empty가 포함
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOcheckSendDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOcheckSendDateRSQL").append("\n"); 
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
		query.append("SELECT	MAX(DT_CHK) DT_CHK," ).append("\n"); 
		query.append("        MAX(ETA_DT) ETA_DT," ).append("\n"); 
		query.append("        MAX(FR_INDT) FR_INDT," ).append("\n"); 
		query.append("        CASE WHEN MAX(EMPTY_CHK) > 0 THEN 'Y' ELSE 'N' END EMPTY_CHK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 	DECODE(SIGN(VPS_ETA_DT - SYSDATE + 25),1,'N',0,'N','Y') DT_CHK," ).append("\n"); 
		query.append("       	TO_CHAR(VPS_ETA_DT, 'YYYY-MM-DD') ETA_DT," ).append("\n"); 
		query.append("       	TO_CHAR(TRUNC(SYSDATE - VPS_ETA_DT)) FR_INDT," ).append("\n"); 
		query.append("		0 EMPTY_CHK" ).append("\n"); 
		query.append(" FROM  	VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append(" WHERE 	VSL_CD 		= SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append(" AND 	SKD_VOY_NO 	= SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append(" AND 	SKD_DIR_CD 	= SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append(" AND 	VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append(" AND 	ROWNUM = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 	'' DT_CHK, " ).append("\n"); 
		query.append("        '' ETA_DT," ).append("\n"); 
		query.append("        '' FR_INDT," ).append("\n"); 
		query.append("        COUNT(*) EMPTY_CHK" ).append("\n"); 
		query.append("        FROM BKG_KR_WHF_BL WHF, BKG_BOOKING BKG" ).append("\n"); 
		query.append(" WHERE 	WHF.BKG_NO	= BKG.BKG_NO" ).append("\n"); 
		query.append(" AND 	WHF.VSL_CD 		= SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append(" AND 	WHF.SKD_VOY_NO 	= SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append(" AND 	WHF.SKD_DIR_CD 	= SUBSTR(@[vvd], 9, 4)" ).append("\n"); 
		query.append(" AND 	WHF.WHF_POD_CD 	= @[port_cd]" ).append("\n"); 
		query.append(" AND 	WHF.WHF_BND_CD 	IN ('II','IT')" ).append("\n"); 
		query.append(" AND	BKG.BKG_CGO_TP_CD IN ('P','R')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}