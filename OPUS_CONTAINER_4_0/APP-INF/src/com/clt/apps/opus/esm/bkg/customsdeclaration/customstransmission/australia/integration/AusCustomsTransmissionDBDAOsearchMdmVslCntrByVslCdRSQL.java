/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AusCustomsTransmissionDBDAOsearchMdmVslCntrByVslCdRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.26
*@LastModifier :
*@LastVersion : 1.0
* 2014.12.26
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

public class AusCustomsTransmissionDBDAOsearchMdmVslCntrByVslCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public AusCustomsTransmissionDBDAOsearchMdmVslCntrByVslCdRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration").append("\n");
		query.append("FileName : AusCustomsTransmissionDBDAOsearchMdmVslCntrByVslCdRSQL").append("\n");
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
		query.append("SELECT CALL_SGN_NO," ).append("\n");
		query.append("       LLOYD_NO," ).append("\n");
		query.append("       VSL_ENG_NM," ).append("\n");
		query.append("       VSL_RGST_CNT_CD" ).append("\n");
		query.append("" ).append("\n");
		query.append("  FROM MDM_VSL_CNTR" ).append("\n");
		query.append("" ).append("\n");
		query.append(" WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n");

	}
}