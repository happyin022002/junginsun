/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchBkgForCopyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.14
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2015.12.14 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchBkgForCopyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Copy용 Booking정보를 조회한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchBkgForCopyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchBkgForCopyRSQL").append("\n"); 
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
		query.append("		 BK.BKG_NO" ).append("\n"); 
		query.append("	   , BK.VSL_CD||BK.SKD_VOY_NO||BK.SKD_DIR_CD BKG_TRUNK_VVD" ).append("\n"); 
		query.append("	   , BK.POR_CD" ).append("\n"); 
		query.append("	   , BK.POL_CD" ).append("\n"); 
		query.append("	   , BK.POD_CD" ).append("\n"); 
		query.append("	   , BK.DEL_CD" ).append("\n"); 
		query.append("	   , BK.RFA_NO RFA_NO" ).append("\n"); 
		query.append("	   , BK.RFA_NO RFA_NO_OLD" ).append("\n"); 
		query.append("       , BK.SC_NO SC_NO" ).append("\n"); 
		query.append("       , BK.SC_NO SC_NO_OLD" ).append("\n"); 
		query.append("       , BK.TAA_NO TAA_NO" ).append("\n"); 
		query.append("	   , BK.TAA_NO TAA_NO_OLD" ).append("\n"); 
		query.append("       , BK.DCGO_FLG" ).append("\n"); 
		query.append("       , BK.RC_FLG" ).append("\n"); 
		query.append("       , BK.AWK_CGO_FLG" ).append("\n"); 
		query.append("       , BK.BB_CGO_FLG" ).append("\n"); 
		query.append("--       , DECODE(STWG_CD,NULL,'N','','N','Y') STOWAGE_FLG" ).append("\n"); 
		query.append("       , DECODE(ST.STWG_CD,NULL,'N','','N','Y') STOWAGE_FLG" ).append("\n"); 
		query.append("       , BK.HNGR_FLG" ).append("\n"); 
		query.append("       , DECODE(BK.STOP_OFF_LOC_CD,NULL,'N','','N','Y') STOP_OFF_FLG" ).append("\n"); 
		query.append("       , DECODE(BK.RAIL_BLK_CD,NULL,'N','','N','Y') BULK_RAIL_FLG" ).append("\n"); 
		query.append("       , BK.HOT_DE_FLG" ).append("\n"); 
		query.append("       , BK.SPCL_HIDE_FLG" ).append("\n"); 
		query.append("       , BK.FD_GRD_FLG" ).append("\n"); 
		query.append("       , BK.PRCT_FLG" ).append("\n"); 
		query.append("       , DECODE(BK.XTER_RMK,NULL,'N','','N','Y') REMARK_FLG	" ).append("\n"); 
		query.append("	   , '' PCTL_NO" ).append("\n"); 
		query.append("	   , BK.BKG_CTRL_PTY_CUST_CNT_CD" ).append("\n"); 
		query.append("	   , BK.BKG_CTRL_PTY_CUST_SEQ" ).append("\n"); 
		query.append("	   , BK.BKG_WT_CHK_FLG" ).append("\n"); 
		query.append("	   , BK.EDI_HLD_FLG" ).append("\n"); 
		query.append("FROM	BKG_BOOKING BK" ).append("\n"); 
		query.append("		,BKG_STWG_CGO ST" ).append("\n"); 
		query.append("WHERE	BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND		BK.BKG_NO = ST.BKG_NO(+)" ).append("\n"); 
		query.append("AND		1		  = ST.STWG_SEQ(+)" ).append("\n"); 

	}
}