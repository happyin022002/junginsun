/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EDIVOMAKERDAOTES_EDI_SO_HDRRSQL.java
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

public class EDIVOMAKERDAOTES_EDI_SO_HDRRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TES_EDI_SO_HDR
	  * </pre>
	  */
	public EDIVOMAKERDAOTES_EDI_SO_HDRRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.edi.ebilling.vo ").append("\n"); 
		query.append("FileName : EDIVOMAKERDAOTES_EDI_SO_HDRRSQL").append("\n"); 
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
		query.append(", TML_INV_TP_CD" ).append("\n"); 
		query.append(", TML_INV_STS_CD" ).append("\n"); 
		query.append(", TML_INV_RJCT_STS_CD" ).append("\n"); 
		query.append(", INV_OFC_CD" ).append("\n"); 
		query.append(", COST_OFC_CD" ).append("\n"); 
		query.append(", VNDR_SEQ" ).append("\n"); 
		query.append(", YD_CD" ).append("\n"); 
		query.append(", INV_NO" ).append("\n"); 
		query.append(", CURR_CD" ).append("\n"); 
		query.append(", RCV_DT" ).append("\n"); 
		query.append(", ISS_DT" ).append("\n"); 
		query.append(", TTL_INV_AMT" ).append("\n"); 
		query.append(", VAT_AMT" ).append("\n"); 
		query.append(", WHLD_TAX_AMT" ).append("\n"); 
		query.append(", ATCH_TP_CD" ).append("\n"); 
		query.append(", IO_IND_CD" ).append("\n"); 
		query.append(", TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(", TML_SO_SEQ" ).append("\n"); 
		query.append(", DELT_FLG" ).append("\n"); 
		query.append(", IB_VVD_CD" ).append("\n"); 
		query.append(", OB_VVD_CD" ).append("\n"); 
		query.append(", INV_RJCT_RMK" ).append("\n"); 
		query.append(", STO_DYS_IND_CD" ).append("\n"); 
		query.append(", VLD_CHK_FLG" ).append("\n"); 
		query.append(", LOCL_CRE_DT" ).append("\n"); 
		query.append(", LOCL_UPD_DT" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", FM_PRD_DT" ).append("\n"); 
		query.append(", TO_PRD_DT" ).append("\n"); 
		query.append(", TML_INV_EDI_SEQ" ).append("\n"); 
		query.append(", FLT_FILE_MSG_ID" ).append("\n"); 
		query.append(", SNDR_ID" ).append("\n"); 
		query.append(", RCVR_ID" ).append("\n"); 
		query.append(", EDI_MSG" ).append("\n"); 
		query.append(", EDI_RCV_RULE_MN_SEQ" ).append("\n"); 
		query.append(", ATB_DT" ).append("\n"); 
		query.append("FROM TES_EDI_SO_HDR" ).append("\n"); 

	}
}