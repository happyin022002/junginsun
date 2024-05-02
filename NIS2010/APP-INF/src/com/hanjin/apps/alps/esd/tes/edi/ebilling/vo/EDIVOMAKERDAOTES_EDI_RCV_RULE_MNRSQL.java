/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EDIVOMAKERDAOTES_EDI_RCV_RULE_MNRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EDIVOMAKERDAOTES_EDI_RCV_RULE_MNRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public EDIVOMAKERDAOTES_EDI_RCV_RULE_MNRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.edi.ebilling.vo").append("\n"); 
		query.append("FileName : EDIVOMAKERDAOTES_EDI_RCV_RULE_MNRSQL").append("\n"); 
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
		query.append("EDI_RCV_RULE_MN_SEQ" ).append("\n"); 
		query.append(", SNDR_ID" ).append("\n"); 
		query.append(", RCVR_ID" ).append("\n"); 
		query.append(", CFM_FLG" ).append("\n"); 
		query.append(", CFM_DT" ).append("\n"); 
		query.append(", DELT_FLG" ).append("\n"); 
		query.append(", DELT_DT" ).append("\n"); 
		query.append(", INV_TAG_NM" ).append("\n"); 
		query.append(", INIT_INV_TAG_VAL_CHK_FLG" ).append("\n"); 
		query.append(", INIT_ALL_TAG_VAL_CHK_FLG" ).append("\n"); 
		query.append(", EDI_RMK" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append("FROM TES_EDI_RCV_RULE_MN" ).append("\n"); 

	}
}