/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransferOrderIssueDBDAOmakeTroDtlVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.09
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.12.09 이남경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Nam Kyung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOmakeTroDtlVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TroDtlVO 생성용 [CustomVO]
	  * </pre>
	  */
	public TransferOrderIssueDBDAOmakeTroDtlVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOmakeTroDtlVORSQL").append("\n"); 
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
		query.append("BKG_NO" ).append("\n"); 
		query.append(",   'N' DEL" ).append("\n"); 
		query.append(",	IO_BND_CD" ).append("\n"); 
		query.append(",	RTN_TRO_FLG" ).append("\n"); 
		query.append(",	TRO_SEQ" ).append("\n"); 
		query.append(",	TRO_SUB_SEQ" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	TRO_QTY" ).append("\n"); 
		query.append(",	'' CNTR_TPSZ_CD_OLD" ).append("\n"); 
		query.append(",	'' TRO_QTY_OLD" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	DOR_ARR_DT" ).append("\n"); 
		query.append(",   '' DOR_ARR_DT_HHMI" ).append("\n"); 
		query.append(",	PKUP_LOC_CD" ).append("\n"); 
		query.append(",	PKUP_YD_CD" ).append("\n"); 
		query.append(",	RTN_LOC_CD" ).append("\n"); 
		query.append(",	RTN_YD_CD" ).append("\n"); 
		query.append(",	CMDT_CD" ).append("\n"); 
		query.append(",	'' CMDT_NM" ).append("\n"); 
		query.append(",	PCTL_NO" ).append("\n"); 
		query.append(",	CXL_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",   '' TRSP_SO_NO" ).append("\n"); 
		query.append(",   '' SO_CRE_DT" ).append("\n"); 
		query.append(",   '' SO_CRE_USR_ID" ).append("\n"); 
		query.append(",   '' SO_USR_NM" ).append("\n"); 
		query.append(",	'' CXL_FLG_OLD" ).append("\n"); 
		query.append("FROM BKG_TRO_DTL" ).append("\n"); 

	}
}