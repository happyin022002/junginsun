/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOsearchDelCdRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.27
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.06.27 조원주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOsearchDelCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Del_cd 가져오는 쿼리
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOsearchDelCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n");
		query.append("FileName : KorCustomsTransmissionDBDAOsearchDelCdRSQL").append("\n");
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
		query.append("SELECT SUBSTR(MIN(TO_CHAR(CLPT_SEQ,000)||VPS_PORT_CD),3) DEL_CD " ).append("\n");
		query.append("  FROM VSK_VSL_PORT_SKD " ).append("\n");
		query.append(" WHERE 1=1 " ).append("\n");
		query.append("   AND VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n");
		query.append("   AND SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n");
		query.append("   AND SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n");
		query.append("   AND VPS_ETD_DT > (SELECT MAX(VPS_ETD_DT) " ).append("\n");
		query.append("                       FROM VSK_VSL_PORT_SKD " ).append("\n");
		query.append("                       WHERE 1=1" ).append("\n");
		query.append("                         AND VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n");
		query.append("   						 AND SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n");
		query.append("   						 AND SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n");
		query.append("                         AND VPS_PORT_CD=@[pol_cd])" ).append("\n");
		query.append("   AND VPS_PORT_CD NOT LIKE 'KR%'" ).append("\n");

	}
}