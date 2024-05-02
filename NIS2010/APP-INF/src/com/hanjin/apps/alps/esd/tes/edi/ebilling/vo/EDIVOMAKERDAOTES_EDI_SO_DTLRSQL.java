/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EDIVOMAKERDAOTES_EDI_SO_DTLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.13
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.13 
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

public class EDIVOMAKERDAOTES_EDI_SO_DTLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TES_EDI_SO_DTL
	  * </pre>
	  */
	public EDIVOMAKERDAOTES_EDI_SO_DTLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.edi.ebilling.vo").append("\n"); 
		query.append("FileName : EDIVOMAKERDAOTES_EDI_SO_DTLRSQL").append("\n"); 
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
		query.append(", TML_EDI_SO_DTL_SEQ" ).append("\n"); 
		query.append(", LGS_COST_CD" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", VOL_TR_UT_CD" ).append("\n"); 
		query.append(", CTRT_RT" ).append("\n"); 
		query.append(", INV_AMT" ).append("\n"); 
		query.append(", INV_XCH_RT" ).append("\n"); 
		query.append(", STAY_DYS" ).append("\n"); 
		query.append(", OVR_DYS" ).append("\n"); 
		query.append(", OVR_VOL_QTY" ).append("\n"); 
		query.append(", WRK_DT" ).append("\n"); 
		query.append(", INV_VOL_QTY" ).append("\n"); 
		query.append(", STK_VOL_QTY" ).append("\n"); 
		query.append(", FP_TEU_QTY" ).append("\n"); 
		query.append(", DCGO_IND_CD" ).append("\n"); 
		query.append(", RC_FLG" ).append("\n"); 
		query.append(", TML_WRK_DY_CD" ).append("\n"); 
		query.append(", IOC_CD" ).append("\n"); 
		query.append(", TML_TRNS_MOD_CD" ).append("\n"); 
		query.append(", LANE_CD" ).append("\n"); 
		query.append(", TML_CRR_CD" ).append("\n"); 
		query.append(", CALC_VOL_QTY" ).append("\n"); 
		query.append(", RVIS_VOL_QTY" ).append("\n"); 
		query.append(", IO_BND_CD" ).append("\n"); 
		query.append(", VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", SKD_DIR_CD" ).append("\n"); 
		query.append(", IB_VVD_CD" ).append("\n"); 
		query.append(", OB_VVD_CD" ).append("\n"); 
		query.append(", TRF_DESC" ).append("\n"); 
		query.append(", CALC_RMK" ).append("\n"); 
		query.append(", FREE_DYS" ).append("\n"); 
		query.append(", FREE_DY_XCLD_DYS" ).append("\n"); 
		query.append(", RF_MNTR_DYS" ).append("\n"); 
		query.append(", EDI_SO_DTL_ID" ).append("\n"); 
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
		query.append("FROM TES_EDI_SO_DTL" ).append("\n"); 

	}
}