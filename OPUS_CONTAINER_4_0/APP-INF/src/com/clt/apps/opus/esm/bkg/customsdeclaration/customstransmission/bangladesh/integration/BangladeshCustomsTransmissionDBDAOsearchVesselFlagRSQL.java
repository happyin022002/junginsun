/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BangladeshCustomsTransmissionDBDAOsearchVesselFlagRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.27
*@LastModifier :
*@LastVersion : 1.0
* 2013.06.27
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.bangladesh.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BangladeshCustomsTransmissionDBDAOsearchVesselFlagRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Vessel 등록 포트의 국가 설명
	  * </pre>
	  */
	public BangladeshCustomsTransmissionDBDAOsearchVesselFlagRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.bangladesh.integration").append("\n");
		query.append("FileName : BangladeshCustomsTransmissionDBDAOsearchVesselFlagRSQL").append("\n");
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
		query.append("SELECT NVL(VSL_RGST_CNT_CD, ' ') AS VSL_CNT_CD, " ).append("\n");
		query.append("       NVL(LLOYD_NO, ' ') VSL_IMO_CD, " ).append("\n");
		query.append("       (" ).append("\n");
		query.append("        SELECT NVL(CNT_NM, ' ')" ).append("\n");
		query.append("        FROM MDM_COUNTRY B" ).append("\n");
		query.append("        WHERE CNT_CD = VSL_RGST_CNT_CD" ).append("\n");
		query.append("        ) CNT_NM" ).append("\n");
		query.append("FROM MDM_VSL_CNTR" ).append("\n");
		query.append("WHERE VSL_CD = @[vsl_cd]" ).append("\n");

	}
}