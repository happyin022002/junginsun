/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AusCustomsTransmissionDBDAOsearchMakeHeaderMRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.30
*@LastModifier :
*@LastVersion : 1.0
* 2014.12.30
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

public class AusCustomsTransmissionDBDAOsearchMakeHeaderMRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Flat File Header 생성
	  * </pre>
	  */
	public AusCustomsTransmissionDBDAOsearchMakeHeaderMRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration").append("\n");
		query.append("FileName : AusCustomsTransmissionDBDAOsearchMakeHeaderMRSQL").append("\n");
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
		query.append("SELECT '$$$MSGSTART:'||" ).append("\n");
		query.append("    RPAD(NVL(TRIM(COM_ConstantMgr_PKG.COM_getScacCode_FNC()),' '),20,' ')||" ).append("\n");
		query.append("    RPAD(NVL(TRIM('AUSCUS_N'),' '),20,' ')||" ).append("\n");
		query.append("    RPAD(NVL(TRIM('IFTMCS'),' '),10,' ')||" ).append("\n");
		query.append("    'BKC'||" ).append("\n");
		query.append("    TO_CHAR(sysdate,'rrmmdd')||" ).append("\n");
		query.append("			LTRIM(TO_CHAR(BKG_CSTM_EDI_SEQ.NEXTVAL,'000009'),' ') msg_header	" ).append("\n");
		query.append("FROM DUAL" ).append("\n");

	}
}