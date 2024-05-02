/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchBkgForCopyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.28
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
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
		query.append("		 BKG_NO" ).append("\n"); 
		query.append("	   , VSL_CD||SKD_VOY_NO||SKD_DIR_CD BKG_TRUNK_VVD" ).append("\n"); 
		query.append("	   , POR_CD" ).append("\n"); 
		query.append("	   , POL_CD" ).append("\n"); 
		query.append("	   , POD_CD" ).append("\n"); 
		query.append("	   , DEL_CD" ).append("\n"); 
		query.append("	   , RFA_NO RFA_NO" ).append("\n"); 
		query.append("	   , RFA_NO RFA_NO_OLD" ).append("\n"); 
		query.append("       , SC_NO SC_NO" ).append("\n"); 
		query.append("       , SC_NO SC_NO_OLD" ).append("\n"); 
		query.append("       , TAA_NO TAA_NO" ).append("\n"); 
		query.append("	   , TAA_NO TAA_NO_OLD" ).append("\n"); 
		query.append("       , DCGO_FLG" ).append("\n"); 
		query.append("       , RC_FLG" ).append("\n"); 
		query.append("       , AWK_CGO_FLG" ).append("\n"); 
		query.append("       , BB_CGO_FLG" ).append("\n"); 
		query.append("       , DECODE(STWG_CD,NULL,'N','','N','Y') STOWAGE_FLG" ).append("\n"); 
		query.append("       , HNGR_FLG" ).append("\n"); 
		query.append("       , DECODE(STOP_OFF_LOC_CD,NULL,'N','','N','Y') STOP_OFF_FLG" ).append("\n"); 
		query.append("       , DECODE(RAIL_BLK_CD,NULL,'N','','N','Y') BULK_RAIL_FLG" ).append("\n"); 
		query.append("       , SPCL_HIDE_FLG" ).append("\n"); 
		query.append("       , FD_GRD_FLG" ).append("\n"); 
		query.append("       , PRCT_FLG" ).append("\n"); 
		query.append("       , DECODE(XTER_RMK,NULL,'N','','N','Y') REMARK_FLG	" ).append("\n"); 
		query.append("	   , '' PCTL_NO		   " ).append("\n"); 
		query.append("	   , '' HOT_DE_FLG" ).append("\n"); 
		query.append("       , DECODE(FUMG_LOC_CD,NULL,'N','','N','Y') FUMG_FLG" ).append("\n"); 
		query.append("       , SPCL_HIDE_LNR_FLG" ).append("\n"); 
		query.append("       , CRR_SOC_FLG" ).append("\n"); 
		query.append("       , VEH_CMDT_FLG" ).append("\n"); 
		query.append("	   , XTER_RMK" ).append("\n"); 
		query.append("FROM	BKG_BOOKING" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}