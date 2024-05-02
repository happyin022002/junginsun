/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCProposalMainDBDAORsltPropMnDlRecVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.08
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2015.09.08 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sunghwan Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAORsltPropMnDlRecVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * A
	  * </pre>
	  */
	public SCProposalMainDBDAORsltPropMnDlRecVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration ").append("\n"); 
		query.append("FileName : SCProposalMainDBDAORsltPropMnDlRecVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append(" '' SC_NO" ).append("\n"); 
		query.append(",'' SCRN_EVNT_SEQ" ).append("\n"); 
		query.append(",'' PRNT_SCRN_EVNT_SEQ" ).append("\n"); 
		query.append(",'' PROP_NO" ).append("\n"); 
		query.append(",'' AMDT_SEQ" ).append("\n"); 
		query.append(",'' LGIN_USR_IP" ).append("\n"); 
		query.append(",'' SCRN_OPN_GDT" ).append("\n"); 
		query.append(",'' SP_PRN_EVNT_TP_CD" ).append("\n"); 
		query.append(",'' SP_SCRN_EVNT_PGM_CD" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append(",'' CRE_OFC_CD" ).append("\n"); 
		query.append(",'' CRE_DT" ).append("\n"); 
		query.append(",'' UPD_USR_ID" ).append("\n"); 
		query.append(",'' UPD_DT " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}