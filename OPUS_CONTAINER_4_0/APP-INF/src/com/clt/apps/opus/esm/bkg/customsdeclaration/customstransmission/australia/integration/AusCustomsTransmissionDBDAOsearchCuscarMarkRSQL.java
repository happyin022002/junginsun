/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AusCustomsTransmissionDBDAOsearchCuscarMarkRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.29
*@LastModifier :
*@LastVersion : 1.0
* 2014.12.29
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AusCustomsTransmissionDBDAOsearchCuscarMarkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public AusCustomsTransmissionDBDAOsearchCuscarMarkRSQL(){
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

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration").append("\n");
		query.append("FileName : AusCustomsTransmissionDBDAOsearchCuscarMarkRSQL").append("\n");
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
		query.append("SELECT BKG_SPCLCHAR_CONV_FNC(SUBSTR(MD.MK_DESC, 1, 35), 'Y') AS MARK01," ).append("\n");
		query.append("       BKG_SPCLCHAR_CONV_FNC(SUBSTR(MD.MK_DESC, 36, 35), 'Y') AS MARK02," ).append("\n");
		query.append("       BKG_SPCLCHAR_CONV_FNC(SUBSTR(MD.MK_DESC, 71, 35), 'Y') AS MARK03," ).append("\n");
		query.append("       BKG_SPCLCHAR_CONV_FNC(SUBSTR(MD.MK_DESC, 106, 35), 'Y') AS MARK04," ).append("\n");
		query.append("       BKG_SPCLCHAR_CONV_FNC(SUBSTR(MD.MK_DESC, 141, 35), 'Y') AS MARK05," ).append("\n");
		query.append("       BKG_SPCLCHAR_CONV_FNC(SUBSTR(MD.MK_DESC, 176, 35), 'Y') AS MARK06," ).append("\n");
		query.append("       BKG_SPCLCHAR_CONV_FNC(SUBSTR(MD.MK_DESC, 211, 35), 'Y') AS MARK07," ).append("\n");
		query.append("       BKG_SPCLCHAR_CONV_FNC(SUBSTR(MD.MK_DESC, 246, 35), 'Y') AS MARK08," ).append("\n");
		query.append("       BKG_SPCLCHAR_CONV_FNC(SUBSTR(MD.MK_DESC, 281, 35), 'Y') AS MARK09," ).append("\n");
		query.append("       BKG_SPCLCHAR_CONV_FNC(SUBSTR(MD.MK_DESC, 316, 35), 'Y') AS MARK10" ).append("\n");
		query.append("" ).append("\n");
		query.append("  FROM BKG_BL_MK_DESC MD" ).append("\n");
		query.append("" ).append("\n");
		query.append(" WHERE MD.BKG_NO = @[bkg_no]" ).append("\n");
		query.append("   AND MD.MK_DESC IS NOT NULL" ).append("\n");

	}
}