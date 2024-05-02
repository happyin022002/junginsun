/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AusCustomsTransmissionDBDAOsearchDgInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.14
*@LastModifier :
*@LastVersion : 1.0
* 2015.01.14
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

public class AusCustomsTransmissionDBDAOsearchDgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public AusCustomsTransmissionDBDAOsearchDgInfoRSQL(){
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
		query.append("FileName : AusCustomsTransmissionDBDAOsearchDgInfoRSQL").append("\n");
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
		query.append("SELECT NVL(SUBSTR(DC.IMDG_CLSS_CD, 1, 7), ' ') AS IMDG_CLSS_CD," ).append("\n");
		query.append("       '' AS IMO_PAGE_NO," ).append("\n");
		query.append("       '' AS HAZARD_CD," ).append("\n");
		query.append("       NVL(DC.IMDG_UN_NO, ' ') AS IMDG_UN_NO," ).append("\n");
		query.append("       ROUND(DC.FLSH_PNT_CDO_TEMP, 3) AS FLASH_POINT," ).append("\n");
		query.append("       '' AS FLASH_POINT_UNIT," ).append("\n");
		query.append("       NVL(DC.IMDG_PCK_GRP_CD, ' ') AS IMDG_PCK_GRP_CD," ).append("\n");
		query.append("       NVL(SUBSTR(DC.EMS_NO, 1, 6), ' ') AS EMS_NO," ).append("\n");
		query.append("       '' AS MFAG," ).append("\n");
		query.append("       '' AS TREM_CARD_NO" ).append("\n");
		query.append("" ).append("\n");
		query.append("FROM BKG_DG_CGO DC," ).append("\n");
		query.append("     BKG_BOOKING BB" ).append("\n");
		query.append("" ).append("\n");
		query.append("WHERE BB.BKG_NO = @[bkg_no]" ).append("\n");
		query.append("  AND BB.BKG_NO = DC.BKG_NO" ).append("\n");

	}
}