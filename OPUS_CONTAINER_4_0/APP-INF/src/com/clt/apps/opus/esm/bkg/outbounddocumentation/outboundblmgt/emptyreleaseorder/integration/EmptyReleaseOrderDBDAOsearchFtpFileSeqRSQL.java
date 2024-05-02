/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EmptyReleaseOrderDBDAOsearchFtpFileSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.29
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2015.07.29 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE, do hyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseOrderDBDAOsearchFtpFileSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EmptyReleaseOrderDBDAOsearchFtpFileSeqRSQL
	  * </pre>
	  */
	public EmptyReleaseOrderDBDAOsearchFtpFileSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.integration ").append("\n"); 
		query.append("FileName : EmptyReleaseOrderDBDAOsearchFtpFileSeqRSQL").append("\n"); 
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
		query.append("SELECT LPAD(BKG_LDF_FILE_SEQ.NEXTVAL, 4, '0') AS FILE_SEQ FROM DUAL" ).append("\n"); 

	}
}