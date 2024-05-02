/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SriLankaCustomsTransmissionDBDAOsearchMakeHeaderVesselRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SriLankaCustomsTransmissionDBDAOsearchMakeHeaderVesselRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Header 생성
	  * </pre>
	  */
	public SriLankaCustomsTransmissionDBDAOsearchMakeHeaderVesselRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.integration").append("\n"); 
		query.append("FileName : SriLankaCustomsTransmissionDBDAOsearchMakeHeaderVesselRSQL").append("\n"); 
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
		query.append("    RPAD(NVL(TRIM('SMLM_SLK'),' '),20,' ')||" ).append("\n"); 
		query.append("    RPAD(NVL(TRIM('SRILANKACUSTOMS'),' '),20,' ')||" ).append("\n"); 
		query.append("    RPAD(NVL(TRIM('VSLREG'),' '),10,' ')||" ).append("\n"); 
		query.append("    'BKC'||" ).append("\n"); 
		query.append("    TO_CHAR(sysdate,'rrmmdd')||" ).append("\n"); 
		query.append("			LTRIM(TO_CHAR(BKG_CSTM_EDI_SEQ.NEXTVAL,'000009'),' ') msg_header	" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}