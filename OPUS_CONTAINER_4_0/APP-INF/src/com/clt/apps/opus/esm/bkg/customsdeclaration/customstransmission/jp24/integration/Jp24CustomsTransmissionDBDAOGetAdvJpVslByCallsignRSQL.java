/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Jp24CustomsTransmissionDBDAOGetAdvJpVslByCallsignRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.17
*@LastModifier :
*@LastVersion : 1.0
* 2015.02.17
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Jp24CustomsTransmissionDBDAOGetAdvJpVslByCallsignRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public Jp24CustomsTransmissionDBDAOGetAdvJpVslByCallsignRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jp_msg_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_cssm_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.integration").append("\n");
		query.append("FileName : Jp24CustomsTransmissionDBDAOGetAdvJpVslByCallsignRSQL").append("\n");
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
		query.append("SELECT SKD.VSL_CD," ).append("\n");
		query.append("       SKD.SKD_VOY_NO," ).append("\n");
		query.append("       SKD.SKD_DIR_CD," ).append("\n");
		query.append("       (SELECT A.POL_CD" ).append("\n");
		query.append("          FROM BKG_CSTMS_ADV_JP_SND_LOG A" ).append("\n");
		query.append("         WHERE A.JP_SND_LOG_ID = @[jp_msg_tp_id]" ).append("\n");
		query.append("           AND A.VSL_CD = SKD.VSL_CD" ).append("\n");
		query.append("           AND A.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n");
		query.append("           AND A.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n");
		query.append("           AND A.SND_DT = (SELECT MAX(SND_DT)" ).append("\n");
		query.append("                             FROM BKG_CSTMS_ADV_JP_SND_LOG SND" ).append("\n");
		query.append("                            WHERE SND.JP_SND_LOG_ID = @[jp_msg_tp_id]" ).append("\n");
		query.append("                              AND SND.VSL_CD = SKD.VSL_CD" ).append("\n");
		query.append("                              AND SND.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n");
		query.append("                              AND SND.SKD_DIR_CD = SKD.SKD_DIR_CD)" ).append("\n");
		query.append("           AND ROWNUM = 1) AS POL_CD" ).append("\n");
		query.append("" ).append("\n");
		query.append("  FROM (SELECT /*+ INDEX_SS(SKD XPKBKG_CSTMS_ADV_JP_VSL_SKD) */" ).append("\n");
		query.append("               VSL_CD," ).append("\n");
		query.append("               SKD_VOY_NO," ).append("\n");
		query.append("               SKD_DIR_CD" ).append("\n");
		query.append("" ).append("\n");
		query.append("          FROM BKG_CSTMS_ADV_JP_VSL_SKD" ).append("\n");
		query.append("" ).append("\n");
		query.append("         WHERE CALL_SGN_NO = @[call_sgn_no]" ).append("\n");
		query.append("           AND IB_CSSM_VOY_NO = @[ib_cssm_voy_no]" ).append("\n");
		query.append("           AND ROWNUM = 1) SKD" ).append("\n");

	}
}