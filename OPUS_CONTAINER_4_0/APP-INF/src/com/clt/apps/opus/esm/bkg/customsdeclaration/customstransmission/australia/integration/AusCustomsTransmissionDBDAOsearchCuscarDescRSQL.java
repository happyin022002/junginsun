/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AusCustomsTransmissionDBDAOsearchCuscarDescRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.28
*@LastModifier :
*@LastVersion : 1.0
* 2015.01.28
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

public class AusCustomsTransmissionDBDAOsearchCuscarDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public AusCustomsTransmissionDBDAOsearchCuscarDescRSQL(){
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
		query.append("FileName : AusCustomsTransmissionDBDAOsearchCuscarDescRSQL").append("\n");
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
		query.append("SELECT BKG_SPCLCHAR_CONV_FNC(TRIM(B.PCK_CMDT_DESC)||' '||TRIM(B.CNTR_CMDT_DESC)||' '||TRIM(M.CMDT_DESC), 'Y') AS DESCRIPTION" ).append("\n");
		query.append("" ).append("\n");
		query.append("  FROM BKG_BL_MK_DESC M," ).append("\n");
		query.append("       BKG_BL_DOC B" ).append("\n");
		query.append("" ).append("\n");
		query.append(" WHERE B.BKG_NO = @[bkg_no]" ).append("\n");
		query.append("   AND M.BKG_NO = B.BKG_NO" ).append("\n");

	}
}