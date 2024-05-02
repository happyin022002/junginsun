/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TESInterfaceManageDBDAOGetSoSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 이정혜
*@LastVersion : 1.0
* 2009.11.06 이정혜
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tesinterface.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HARRY
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESInterfaceManageDBDAOGetSoSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetSoSeq
	  * </pre>
	  */
	public TESInterfaceManageDBDAOGetSoSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.tesinterface.integration ").append("\n"); 
		query.append("FileName : TESInterfaceManageDBDAOGetSoSeqRSQL").append("\n"); 
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
		query.append("SELECT TES_EDI_SO_HDR_SEQ.NEXTVAL SO_MAX_SEQ FROM DUAL" ).append("\n"); 

	}
}