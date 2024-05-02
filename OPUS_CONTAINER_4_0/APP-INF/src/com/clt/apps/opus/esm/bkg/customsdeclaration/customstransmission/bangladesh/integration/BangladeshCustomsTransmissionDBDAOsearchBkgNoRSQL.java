/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BangladeshCustomsTransmissionDBDAOsearchBkgNoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.16
*@LastModifier :
*@LastVersion : 1.0
* 2013.05.16
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

public class BangladeshCustomsTransmissionDBDAOsearchBkgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 방글라데시 세관 신고용 B/L의 Booking Number 및 Cargo Type Code 를 조회한다.
	  * </pre>
	  */
	public BangladeshCustomsTransmissionDBDAOsearchBkgNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.bangladesh.integration").append("\n");
		query.append("FileName : BangladeshCustomsTransmissionDBDAOsearchBkgNoRSQL").append("\n");
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
		query.append("SELECT BKG_NO, BKG_CGO_TP_CD        " ).append("\n");
		query.append("        FROM  BKG_BOOKING" ).append("\n");
		query.append("        WHERE BL_NO      = SUBSTR(TRIM(@[bl_no]),5,12)	" ).append("\n");

	}
}