/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CLLCDLManifestDBDAOremoveEdiTmpTblDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.13
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.08.13 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOremoveEdiTmpTblDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_CSTMS_TML_EDI_TMP 및 BKG_CSTMS_TML_EDI_GEN_TMP 테이블의 내역을 삭제 한다.
	  * </pre>
	  */
	public CLLCDLManifestDBDAOremoveEdiTmpTblDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration ").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOremoveEdiTmpTblDSQL").append("\n"); 
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
		query.append("#if (${delTblFlg} != 'EDI_TMP')" ).append("\n"); 
		query.append("	DELETE FROM BKG_CSTMS_TML_EDI_GEN_TMP" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	DELETE FROM BKG_CSTMS_TML_EDI_TMP" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}