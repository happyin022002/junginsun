/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAOsearchCncusVvdInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.06
*@LastModifier :
*@LastVersion : 1.0
* 2010.05.06
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsTransmissionDBDAOsearchCncusVvdInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * ChinaVvdInfoVO
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOsearchCncusVvdInfoRSQL(){
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
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration").append("\n");
		query.append("FileName : ChinaCustomsTransmissionDBDAOsearchCncusVvdInfoRSQL").append("\n");
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
		query.append("SELECT  CALL_SGN_NO VSL_CALL_SGN_PORT_LOC_CD" ).append("\n");
		query.append("       ,PRE_CLPT_CD" ).append("\n");
		query.append("       ,NXT_CLPT_CD" ).append("\n");
		query.append("       ,TO_CHAR(MF_SND_DT, 'YYYY-MM-DD HH24:MI') AS MF_SND_DT" ).append("\n");
		query.append("       ,VSL_NM" ).append("\n");
		query.append("       ,TO_CHAR(ETD_DT, 'YYYY-MM-DD HH24:MI') AS ETD_DT" ).append("\n");
		query.append("       ,TO_CHAR(ETA_DT, 'YYYY-MM-DD HH24:MI') AS ETA_DT" ).append("\n");
		query.append("	   ,TO_CHAR(ETB_DT, 'YYYY-MM-DD HH24:MI') AS ETB_DT" ).append("\n");
		query.append("       ,(SELECT SIGN(ETA_DT - GLOBALDATE_PKG.TIME_CONV_FNC ('KRPUS', sysdate, @[loc_cd])) FROM DUAL) AS ETA_FLG" ).append("\n");
		query.append("	#if (${trans_mode} == 'O') " ).append("\n");
		query.append("       ,(SELECT SIGN(ETD_DT - GLOBALDATE_PKG.TIME_CONV_FNC ('KRPUS', sysdate, @[loc_cd])) FROM DUAL) AS ETD_FLG" ).append("\n");
		query.append("	#end" ).append("\n");
		query.append("FROM    BKG_CSTMS_CHN_VVD" ).append("\n");
		query.append("WHERE   1=1" ).append("\n");
		query.append("AND		CHN_MF_SND_IND_CD = DECODE(@[trans_mode], 'D', 'R', @[trans_mode])  /* Transmission 조회 시에만 사용하는 코드 값 */" ).append("\n");
		query.append("AND     VSL_CD 		= SUBSTR(@[vvd],1,4)" ).append("\n");
		query.append("AND     SKD_VOY_NO 	= SUBSTR(@[vvd],5,4)" ).append("\n");
		query.append("AND     SKD_DIR_CD 	= SUBSTR(@[vvd],9,1)" ).append("\n");
		query.append("AND     PORT_CD     = @[loc_cd]" ).append("\n");

	}
}