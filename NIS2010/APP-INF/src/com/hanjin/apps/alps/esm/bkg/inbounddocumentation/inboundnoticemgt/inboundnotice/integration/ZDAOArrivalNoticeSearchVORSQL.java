/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ZDAOArrivalNoticeSearchVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.16
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2010.04.16 박성호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Sungho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ZDAOArrivalNoticeSearchVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 0381 검색조건
	  * </pre>
	  */
	public ZDAOArrivalNoticeSearchVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ZDAOArrivalNoticeSearchVORSQL").append("\n"); 
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
		query.append("/* 0381, 0001 검색조건 */" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  '' VVD" ).append("\n"); 
		query.append(", '' VSL_CD " ).append("\n"); 
		query.append(", '' SKD_VOY_NO " ).append("\n"); 
		query.append(", '' SKD_DIR_CD " ).append("\n"); 
		query.append(", '' VPS_ETA_DT_START " ).append("\n"); 
		query.append(", '' VPS_ETA_DT_END " ).append("\n"); 
		query.append(", '' POD_ETA_DT " ).append("\n"); 
		query.append(", '' POD_CD " ).append("\n"); 
		query.append(", '' DEL_CD " ).append("\n"); 
		query.append(", '' BL_NO" ).append("\n"); 
		query.append(", '' CUST_CNT_CD" ).append("\n"); 
		query.append(", '' CUST_SEQ " ).append("\n"); 
		query.append(", '' SCH_TP " ).append("\n"); 
		query.append(", '' USR_ID " ).append("\n"); 
		query.append(", '' BKG_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append(", '' NTC_TP_CD" ).append("\n"); 
		query.append(", '' NTC_KND_CD " ).append("\n"); 
		query.append(", '' OFC_CD " ).append("\n"); 
		query.append(", '' SND_DT_FM" ).append("\n"); 
		query.append(", '' SND_DT_TO" ).append("\n"); 
		query.append(", '' SND_USR_ID " ).append("\n"); 
		query.append(", '' EQ_CTRL_OFC_CD " ).append("\n"); 
		query.append(", '' PAGE_NO" ).append("\n"); 
		query.append(", '' EXCEL_FLG" ).append("\n"); 
		query.append(", '' TS_FLG " ).append("\n"); 
		query.append(", '' IS_VALIDATED " ).append("\n"); 
		query.append(", '' CUST_REF_NO" ).append("\n"); 
		query.append(", '' CNTR_NO" ).append("\n"); 
		query.append(", '' CUST_NM" ).append("\n"); 
		query.append(", '' POL_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}