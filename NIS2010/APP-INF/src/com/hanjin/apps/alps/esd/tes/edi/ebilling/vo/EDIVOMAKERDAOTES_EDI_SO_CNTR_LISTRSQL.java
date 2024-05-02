/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EDIVOMAKERDAOTES_EDI_SO_CNTR_LISTRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.18
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.vo ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EDIVOMAKERDAOTES_EDI_SO_CNTR_LISTRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TES_EDI_SO_CNTR_LIST
	  * </pre>
	  */
	public EDIVOMAKERDAOTES_EDI_SO_CNTR_LISTRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.edi.ebilling.vo ").append("\n"); 
		query.append("FileName : EDIVOMAKERDAOTES_EDI_SO_CNTR_LISTRSQL").append("\n"); 
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
		query.append("TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(", TML_EDI_SO_SEQ" ).append("\n"); 
		query.append(", TML_EDI_SO_CNTR_LIST_SEQ" ).append("\n"); 
		query.append(", CNTR_NO" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", CNTR_STY_CD" ).append("\n"); 
		query.append(", IO_BND_CD" ).append("\n"); 
		query.append(", VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", SKD_DIR_CD" ).append("\n"); 
		query.append(", IB_VVD_CD" ).append("\n"); 
		query.append(", OB_VVD_CD" ).append("\n"); 
		query.append(", INV_VOL_QTY" ).append("\n"); 
		query.append(", WRK_DT" ).append("\n"); 
		query.append(", INV_GATE_IN_TM_MSG" ).append("\n"); 
		query.append(", INV_GATE_OUT_TM_MSG" ).append("\n"); 
		query.append(", CNTR_RMK" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", CALL_SGN_NO" ).append("\n"); 
		query.append(", LLOYD_NO" ).append("\n"); 
		query.append(", IMO_NO" ).append("\n"); 
		query.append(", CUST_REF_NO_CTNT" ).append("\n"); 
		query.append(", MTCH_MOD_CD" ).append("\n"); 
		query.append(", ATB_DT" ).append("\n"); 
		query.append("FROM TES_EDI_SO_CNTR_LIST" ).append("\n"); 

	}
}