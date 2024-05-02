/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOsearchVSLInfoInBKGRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.10.12 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOsearchVSLInfoInBKGRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * B/L Info 추가Data 가져오기 위해 Vessel정보를 추가로 조회한다.
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOsearchVSLInfoInBKGRSQL(){
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

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n");
		query.append("FileName : KorCustomsTransmissionDBDAOsearchVSLInfoInBKGRSQL").append("\n");
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
		query.append("SELECT NVL(VSL_CLSS_FLG,' ') VSL_FLAG" ).append("\n");
		query.append(", NVL(VSL_ENG_NM,' ') VSL_ENG_NM" ).append("\n");
		query.append(", NVL(CALL_SGN_NO,' ') VSL_CALL_SIGN" ).append("\n");
		query.append(", TO_CHAR(SYSDATE,'yyyy') IN_YEAR" ).append("\n");
		query.append(", NVL(VSL_ENG_NM,' ')||' '||SUBSTR(@[vvd],5,5) VSL_ENG_NM2" ).append("\n");
		query.append("FROM MDM_VSL_CNTR" ).append("\n");
		query.append("WHERE VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n");

	}
}