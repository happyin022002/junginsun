/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOsearchJapanDGInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.23
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2013.01.23 나상보
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sangbo La
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOsearchJapanDGInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * flat file Danger Info (MAR_POLL, IMO_LIMIT)
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOsearchJapanDGInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n");
		query.append("FileName : JapanTerminalTransmissionDBDAOsearchJapanDGInfoRSQL").append("\n");
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
		query.append("SELECT CNTR_TPSZ_CD, MAX(DECODE(MRN_POLUT_FLG,'Y','1','')) MAR_POLL , MAX(DECODE(IMDG_LMT_QTY_FLG,'Y','1','')) IMO_LIMIT" ).append("\n");
		query.append("FROM BKG_TML_EDI_JP_DG_CGO" ).append("\n");
		query.append("WHERE BKG_NO LIKE SUBSTR(@[bkg_no], 1, 10)||'%'" ).append("\n");
		query.append("AND CNTR_TPSZ_CD=@[cntr_tpsz_cd]" ).append("\n");
		query.append("AND BKG_SKD_SEQ = 0" ).append("\n");
		query.append("GROUP BY CNTR_TPSZ_CD" ).append("\n");

	}
}