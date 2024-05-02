/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FromDualDAOVOCreatorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.11.17 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FromDualDAOVOCreatorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO 생산을 위한 From Dual Query
	  * </pre>
	  */
	public FromDualDAOVOCreatorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.integration").append("\n"); 
		query.append("FileName : FromDualDAOVOCreatorRSQL").append("\n"); 
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
		query.append("--' ' VVD, ' ' IO_BND_CD, ' ' MRN_NO, ' ' PORT_CD, ' ' FROM_DT, ' ' TO_DT" ).append("\n"); 
		query.append("--, ' ' VSL_CD, ' ' SKD_VOY_NO, ' ' SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- ' ' VSL_CD, ' ' SKD_VOY_NO, ' ' SKD_DIR_CD, ' ' PORT_CD, ' ' MRN_NO, ' ' BKG_NO -- KorDischPrintCondVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' BL_NO, ' ' ACT_WGT, ' ' PCK_QTY, ' ' PCK_TP_CD," ).append("\n"); 
		query.append("--' ' CSTMS_DCHG_LOC_WH_CD, ' ' BONDED_WH, ' ' BONDED_TP," ).append("\n"); 
		query.append("--' ' CUST_NM, ' ' CNTR_NO, ' ' MRN_NO, ' ' MRN_CHK_NO, ' ' VSL_CD," ).append("\n"); 
		query.append("--' ' SKD_VOY_NO,  ' ' SKD_DIR_CD, ' ' PORT_CD, ' ' IO_BND_CD, ' ' CO_NM," ).append("\n"); 
		query.append("--' ' VSL_ENG_NM, ' ' VPS_ETB_DT, ' ' MF_SEQ_NO -- KorDischPrintListVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("' ' VSL_ENG_NM, ' ' SKD_VOY_NO, ' ' MRN_NO, ' ' CGO_TP_CD, ' ' LOC1_INFO, ' ' LOC2_INFO," ).append("\n"); 
		query.append("' ' VPS_ETB_DT, ' ' MSN_NO, ' ' BL_TP_CD, ' ' BL_NO, ' ' CNTR_INFO," ).append("\n"); 
		query.append("' ' CSTMS_DESC, ' ' PCK_QTY, ' ' TOT_WGT, ' ' IMDG_UN_NO, ' ' WH_NM, ' ' CALL_SGN_NO, ' ' CNT_NM," ).append("\n"); 
		query.append("' ' BKG_CUST_TP_CD, ' ' CUST_INFO," ).append("\n"); 
		query.append("' ' C_CUST_INFO, ' ' N_CUST_INFO, ' ' S_CUST_INFO, ' ' MRN_BL_TS_CD," ).append("\n"); 
		query.append("' ' VPS_ETD_DT  -- KorImpPrintListVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' BKG_NO, ' ' SKD_VOY_NO, ' ' POL_CD, ' ' POD_CD, ' ' FNL_POD_CD , ' ' VSL_CD, ' ' SKD_DIR_CD, ' ' PORT_CD," ).append("\n"); 
		query.append("--' ' MRN_BL_TS_CD, ' ' MRN_NO, ' ' IO_BND_CD  -- KorImpPrintCondVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--' ' VVD, ' ' BL_NO, ' ' SMT_NO, ' ' MSG_LOG_TP_ID, ' ' TP_CD, ' ' POL_CD, ' ' POD_CD, ' ' OFC_CD, ' ' USER_ID," ).append("\n"); 
		query.append("--' ' FROM_DT, ' ' TO_DT, ' ' SEARCH_TYPE -- KorRcvHistCondVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}