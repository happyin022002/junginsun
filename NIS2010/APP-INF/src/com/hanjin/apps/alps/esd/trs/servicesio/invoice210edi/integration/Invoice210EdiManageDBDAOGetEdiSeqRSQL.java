/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Invoice210EdiManageDBDAOGetEdiSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.12.01 손은주(TRS)
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice210edi.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun ju Son(TRS)
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Invoice210EdiManageDBDAOGetEdiSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getEdiSeq SELECT
	  * </pre>
	  */
	public Invoice210EdiManageDBDAOGetEdiSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoice210edi.integration").append("\n"); 
		query.append("FileName : Invoice210EdiManageDBDAOGetEdiSeqRSQL").append("\n"); 
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
		query.append("SELECT TRS_TRSP_INV_EDI_SEQ1.NEXTVAL TRSP_INV_EDI_SEQ FROM DUAL" ).append("\n"); 

	}
}