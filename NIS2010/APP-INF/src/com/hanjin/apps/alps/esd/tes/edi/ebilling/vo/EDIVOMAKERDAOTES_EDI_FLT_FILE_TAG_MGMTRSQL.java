/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EDIVOMAKERDAOTES_EDI_FLT_FILE_TAG_MGMTRSQL.java
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

public class EDIVOMAKERDAOTES_EDI_FLT_FILE_TAG_MGMTRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TES_EDI_FLT_FILE_TAG_MGMT
	  * </pre>
	  */
	public EDIVOMAKERDAOTES_EDI_FLT_FILE_TAG_MGMTRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.edi.ebilling.vo").append("\n"); 
		query.append("FileName : EDIVOMAKERDAOTES_EDI_FLT_FILE_TAG_MGMTRSQL").append("\n"); 
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
		query.append(", EDI_VNDR_SEQ" ).append("\n"); 
		query.append(", FLT_FILE_TAG_NM" ).append("\n"); 
		query.append(", TBL_NM" ).append("\n"); 
		query.append(", TBL_VO_NM" ).append("\n"); 
		query.append(", HDR_TAG_FLG" ).append("\n"); 
		query.append(", SAV_SEQ" ).append("\n"); 
		query.append(", PRNT_TAG_NM" ).append("\n"); 
		query.append(", TAG_VLD_KNT" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", MNL_CNTR_RCV_TAG_FLG" ).append("\n"); 
		query.append("FROM TES_EDI_RCV_FLT_FILE_TAG" ).append("\n"); 

	}
}