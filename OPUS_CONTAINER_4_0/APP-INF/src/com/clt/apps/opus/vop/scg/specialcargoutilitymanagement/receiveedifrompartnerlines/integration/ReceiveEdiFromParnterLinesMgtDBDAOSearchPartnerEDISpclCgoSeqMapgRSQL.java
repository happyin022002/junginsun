/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ReceiveEdiFromParnterLinesMgtDBDAOSearchPartnerEDISpclCgoSeqMapgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveEdiFromParnterLinesMgtDBDAOSearchPartnerEDISpclCgoSeqMapgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Mapping Sequence for receiving partner EDI
	  * </pre>
	  */
	public ReceiveEdiFromParnterLinesMgtDBDAOSearchPartnerEDISpclCgoSeqMapgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration ").append("\n"); 
		query.append("FileName : ReceiveEdiFromParnterLinesMgtDBDAOSearchPartnerEDISpclCgoSeqMapgRSQL").append("\n"); 
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
		query.append("SELECT * FROM SCG_PRNR_SPCL_CGO_SEQ_MAPG" ).append("\n"); 

	}
}