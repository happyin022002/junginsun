/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransferOrderIssueDBDAOmakeTroMstVORSQL.java
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

public class TransferOrderIssueDBDAOmakeTroMstVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransferOrderIssueDBDAOmakeTroMstVORSQL
	  * </pre>
	  */
	public TransferOrderIssueDBDAOmakeTroMstVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOmakeTroMstVORSQL").append("\n"); 
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
		query.append("SELECT  ZN_CD" ).append("\n"); 
		query.append(", CXL_FLG" ).append("\n"); 
		query.append(", OWNR_TRK_FLG" ).append("\n"); 
		query.append(", CNTC_PHN_NO" ).append("\n"); 
		query.append(", CNTC_PSON_NM" ).append("\n"); 
		query.append(", CNTC_FAX_NO" ).append("\n"); 
		query.append(", CNTC_MPHN_NO" ).append("\n"); 
		query.append(", RCV_TERM_CD" ).append("\n"); 
		query.append(", RQST_DT" ).append("\n"); 
		query.append(", DOR_PST_NO" ).append("\n"); 
		query.append(", SO_FLG" ).append("\n"); 
		query.append(", TRO_SEQ" ).append("\n"); 
		query.append(", DOR_LOC_CD" ).append("\n"); 
		query.append(", CFM_DT" ).append("\n"); 
		query.append(", CFM_FLG" ).append("\n"); 
		query.append(", DIFF_RMK" ).append("\n"); 
		query.append(", BIZ_RGST_NO" ).append("\n"); 
		query.append(", ACT_SHPR_CNT_CD" ).append("\n"); 
		query.append(", ACT_SHPR_NM" ).append("\n"); 
		query.append(", ACT_SHPR_SEQ" ).append("\n"); 
		query.append(", ACT_SHPR_ADDR" ).append("\n"); 
		query.append(", ACT_SHPR_PHN_NO" ).append("\n"); 
		query.append(", BKG_NO" ).append("\n"); 
		query.append(", IO_BND_CD" ).append("\n"); 
		query.append(", RTN_TRO_FLG" ).append("\n"); 
		query.append(", RQST_USR_ID" ).append("\n"); 
		query.append(", PCTL_NO" ).append("\n"); 
		query.append(", SO_ACT_CUST_NO" ).append("\n"); 
		query.append(", SO_ACT_CUST_SEQ" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append("-- ADD CUSTOM" ).append("\n"); 
		query.append(", '' ACK_STS_CD" ).append("\n"); 
		query.append(", '' CFM_FLG_OLD" ).append("\n"); 
		query.append(", '' CXL_FLG_OLD" ).append("\n"); 
		query.append("FROM BKG_TRO" ).append("\n"); 

	}
}