/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchEdiEdoGenresHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchEdiEdoGenresHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDO 전송을 위한 헤더 정보를 조회한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchEdiEdoGenresHeaderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchEdiEdoGenresHeaderRSQL").append("\n"); 
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
		query.append("SELECT  '$$$MSGSTART:'                ||" ).append("\n"); 
		query.append("        'SSCOMC0001          '        ||" ).append("\n"); 
		query.append("        'KTNMFCSDO           '        ||" ).append("\n"); 
		query.append("        'GENRES    '                  ||" ).append("\n"); 
		query.append("         RPAD(NVL(TRIM('EDO'),' '),3) ||" ).append("\n"); 
		query.append("         TO_CHAR(SYSDATE,'rrmmdd')    ||" ).append("\n"); 
		query.append("         LTRIM(TO_CHAR(BKG_DO_EDI_SEQ.nextval,'00009'),' ') || CHR(13) ||CHR(10)" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}