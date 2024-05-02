/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestListDBDAOsearchFirstTmpBlNoAssignRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.23 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchFirstTmpBlNoAssignRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 초기 BL No 생성
	  * </pre>
	  */
	public KorManifestListDBDAOsearchFirstTmpBlNoAssignRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ").append("\n"); 
		query.append("FileName : KorManifestListDBDAOsearchFirstTmpBlNoAssignRSQL").append("\n"); 
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
		query.append("SELECT 'PUS'||DECODE(MM,1,'A',2,'B',3,'C',4,'D',5,'E',6,'F',7,'G',8,'H',9,'I',10,'J',11,'K','L')||TO_CHAR(YY)||DD||TO_CHAR(SYSDATE,'MISS') BL_NO" ).append("\n"); 
		query.append("FROM   (SELECT SUBSTR(TO_CHAR(SYSDATE,'YYYYMMDD'),3,2)YY," ).append("\n"); 
		query.append("TO_NUMBER(SUBSTR(TO_CHAR(SYSDATE,'YYYYMMDD'),5,2))MM," ).append("\n"); 
		query.append("SUBSTR(TO_CHAR(SYSDATE,'YYYYMMDD'),7,2) DD" ).append("\n"); 
		query.append("FROM   DUAL)" ).append("\n"); 

	}
}