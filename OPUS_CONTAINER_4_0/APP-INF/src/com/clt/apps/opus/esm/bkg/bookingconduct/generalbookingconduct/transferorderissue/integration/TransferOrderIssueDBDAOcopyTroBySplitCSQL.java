/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TransferOrderIssueDBDAOcopyTroBySplitCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.02
*@LastModifier : 
*@LastVersion : 1.0
* 2010.09.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOcopyTroBySplitCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * copyTroBySplit
	  * </pre>
	  */
	public TransferOrderIssueDBDAOcopyTroBySplitCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("target_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("source_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOcopyTroBySplitCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("INTO BKG_TRO" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(",IO_BND_CD" ).append("\n"); 
		query.append(",RTN_TRO_FLG" ).append("\n"); 
		query.append(",TRO_SEQ" ).append("\n"); 
		query.append(",RCV_TERM_CD" ).append("\n"); 
		query.append(",RQST_DT" ).append("\n"); 
		query.append(",RQST_USR_ID" ).append("\n"); 
		query.append(",OWNR_TRK_FLG" ).append("\n"); 
		query.append(",ACT_SHPR_CNT_CD" ).append("\n"); 
		query.append(",ACT_SHPR_SEQ" ).append("\n"); 
		query.append(",ACT_SHPR_NM" ).append("\n"); 
		query.append(",ACT_SHPR_PHN_NO" ).append("\n"); 
		query.append(",ACT_SHPR_ADDR" ).append("\n"); 
		query.append(",ZN_CD" ).append("\n"); 
		query.append(",DOR_LOC_CD" ).append("\n"); 
		query.append(",DOR_PST_NO" ).append("\n"); 
		query.append(",BIZ_RGST_NO" ).append("\n"); 
		query.append(",CFM_FLG" ).append("\n"); 
		query.append(",CFM_DT" ).append("\n"); 
		query.append(",DIFF_RMK" ).append("\n"); 
		query.append(",CNTC_PSON_NM" ).append("\n"); 
		query.append(",CNTC_FAX_NO" ).append("\n"); 
		query.append(",CNTC_PHN_NO" ).append("\n"); 
		query.append(",CNTC_MPHN_NO" ).append("\n"); 
		query.append(",CXL_FLG" ).append("\n"); 
		query.append(",SO_FLG" ).append("\n"); 
		query.append(",SO_ACT_CUST_NO" ).append("\n"); 
		query.append(",SO_ACT_CUST_SEQ" ).append("\n"); 
		query.append(",PCTL_NO" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",POL_CD" ).append("\n"); 
		query.append(",POD_CD" ).append("\n"); 
		query.append(",TRO_BKG_NO" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("@[target_bkg_no]" ).append("\n"); 
		query.append(",A.IO_BND_CD" ).append("\n"); 
		query.append(",A.RTN_TRO_FLG" ).append("\n"); 
		query.append(",A.TRO_SEQ" ).append("\n"); 
		query.append(",A.RCV_TERM_CD" ).append("\n"); 
		query.append(",A.RQST_DT" ).append("\n"); 
		query.append(",A.RQST_USR_ID" ).append("\n"); 
		query.append(",A.OWNR_TRK_FLG" ).append("\n"); 
		query.append(",A.ACT_SHPR_CNT_CD" ).append("\n"); 
		query.append(",A.ACT_SHPR_SEQ" ).append("\n"); 
		query.append(",A.ACT_SHPR_NM" ).append("\n"); 
		query.append(",A.ACT_SHPR_PHN_NO" ).append("\n"); 
		query.append(",A.ACT_SHPR_ADDR" ).append("\n"); 
		query.append(",A.ZN_CD" ).append("\n"); 
		query.append(",A.DOR_LOC_CD" ).append("\n"); 
		query.append(",A.DOR_PST_NO" ).append("\n"); 
		query.append(",A.BIZ_RGST_NO" ).append("\n"); 
		query.append(",A.CFM_FLG" ).append("\n"); 
		query.append(",A.CFM_DT" ).append("\n"); 
		query.append(",A.DIFF_RMK" ).append("\n"); 
		query.append(",A.CNTC_PSON_NM" ).append("\n"); 
		query.append(",A.CNTC_FAX_NO" ).append("\n"); 
		query.append(",A.CNTC_PHN_NO" ).append("\n"); 
		query.append(",A.CNTC_MPHN_NO" ).append("\n"); 
		query.append(",A.CXL_FLG" ).append("\n"); 
		query.append(",A.SO_FLG" ).append("\n"); 
		query.append(",A.SO_ACT_CUST_NO" ).append("\n"); 
		query.append(",A.SO_ACT_CUST_SEQ" ).append("\n"); 
		query.append(",A.PCTL_NO" ).append("\n"); 
		query.append(",A.VSL_CD" ).append("\n"); 
		query.append(",A.SKD_VOY_NO" ).append("\n"); 
		query.append(",A.SKD_DIR_CD" ).append("\n"); 
		query.append(",A.POL_CD" ).append("\n"); 
		query.append(",A.POD_CD" ).append("\n"); 
		query.append(",A.TRO_BKG_NO" ).append("\n"); 
		query.append(",@[usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append("FROM BKG_TRO A" ).append("\n"); 
		query.append(",SCE_TRO_MAPG B" ).append("\n"); 
		query.append("WHERE A.BKG_NO = @[source_bkg_no]" ).append("\n"); 
		query.append("AND B.BKG_NO = @[target_bkg_no]" ).append("\n"); 
		query.append("AND A.IO_BND_CD = B.IO_BND_CD" ).append("\n"); 
		query.append("AND A.TRO_SEQ = B.TRO_SEQ" ).append("\n"); 
		query.append("AND A.CFM_FLG = 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}