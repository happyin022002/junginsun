/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOsearchJapanDGDetailInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.26
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.03.26 조원주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOsearchJapanDGDetailInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * flat file Japan Danger cargo detail 정보 조회 쿼리
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOsearchJapanDGDetailInfoRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n");
		query.append("FileName : JapanTerminalTransmissionDBDAOsearchJapanDGDetailInfoRSQL").append("\n");
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
		query.append("--CNTR_TPSZ_CD:5" ).append("\n");
		query.append("----IMDG_CLSS_CD:5" ).append("\n");
		query.append("------IMDG_UN_NO, IMDG_PCK_GRP_CD:10" ).append("\n");
		query.append("" ).append("\n");
		query.append("SELECT IMDG_UN_NO, IMDG_PCK_GRP_CD" ).append("\n");
		query.append("FROM BKG_TML_EDI_JP_DG_CGO" ).append("\n");
		query.append("WHERE BKG_NO     = @[bkg_no]" ).append("\n");
		query.append("AND BKG_SKD_SEQ = 0" ).append("\n");
		query.append("AND CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n");
		query.append("AND IMDG_CLSS_CD = @[imdg_clss_cd]" ).append("\n");
		query.append("GROUP BY IMDG_UN_NO, IMDG_PCK_GRP_CD" ).append("\n");

	}
}