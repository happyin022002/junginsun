/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingSplitCombineDBDAOsearchBkgListForCombineByBkgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSplitCombineDBDAOsearchBkgListForCombineByBkgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgListForCombineByBkg
	  * </pre>
	  */
	public GeneralBookingSplitCombineDBDAOsearchBkgListForCombineByBkgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration").append("\n"); 
		query.append("FileName : GeneralBookingSplitCombineDBDAOsearchBkgListForCombineByBkgRSQL").append("\n"); 
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
		query.append("SELECT BK.BKG_NO" ).append("\n"); 
		query.append(", BK.BL_NO" ).append("\n"); 
		query.append(", BK.BKG_STS_CD" ).append("\n"); 
		query.append(", REPLACE(CUST.CUST_NM, CHR(13)||CHR(10), ' ') CUST_NM" ).append("\n"); 
		query.append(", BK.POR_CD" ).append("\n"); 
		query.append(", SUBSTR(BK.POR_NOD_CD, 6, 2) POR_NOD_CD" ).append("\n"); 
		query.append(", BK.POL_CD" ).append("\n"); 
		query.append(", SUBSTR(BK.POL_NOD_CD, 6, 2) POL_NOD_CD" ).append("\n"); 
		query.append(", BK.POD_CD" ).append("\n"); 
		query.append(", SUBSTR(BK.POD_NOD_CD, 6, 2) POD_NOD_CD" ).append("\n"); 
		query.append(", BK.DEL_CD" ).append("\n"); 
		query.append(", SUBSTR(BK.DEL_NOD_CD, 6, 2) DEL_NOD_CD" ).append("\n"); 
		query.append(", BKG_JOIN_FNC( CURSOR(SELECT CNTR_TPSZ_CD||'-'||LTRIM(TO_CHAR(SUM(CNTR_VOL_QTY),'990.99'))" ).append("\n"); 
		query.append("FROM BKG_CONTAINER" ).append("\n"); 
		query.append("WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("GROUP BY CNTR_TPSZ_CD)) CNTR_VOL" ).append("\n"); 
		query.append(", BK.VSL_CD||BK.SKD_VOY_NO||BK.SKD_DIR_CD VVD" ).append("\n"); 
		query.append(", CUST.CUST_CNT_CD||CUST.CUST_SEQ CUST_CD" ).append("\n"); 
		query.append(", BL.BDR_FLG" ).append("\n"); 
		query.append(", (SELECT CUST_CNT_CD||CUST_SEQ FROM BKG_CUSTOMER BROKER WHERE BROKER.BKG_CUST_TP_CD = 'B' AND BROKER.BKG_NO = BK.BKG_NO) BROKER" ).append("\n"); 
		query.append(", BK.BKG_OFC_CD" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK" ).append("\n"); 
		query.append(", BKG_BL_DOC BL" ).append("\n"); 
		query.append(", BKG_CUSTOMER CUST" ).append("\n"); 
		query.append(", BKG_VVD VVD" ).append("\n"); 
		query.append(", BKG_BL_ISS ISS" ).append("\n"); 
		query.append("WHERE BK.BKG_NO            = CUST.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_NO			= BL.BKG_NO" ).append("\n"); 
		query.append("AND CUST.BKG_CUST_TP_CD  = 'S'" ).append("\n"); 
		query.append("AND BK.BKG_NO			= ISS.BKG_NO(+)" ).append("\n"); 
		query.append("AND BK.BKG_NO            = VVD.BKG_NO" ).append("\n"); 
		query.append("AND BK.POL_CD            = VVD.POL_CD" ).append("\n"); 
		query.append("AND VVD.VSL_PRE_PST_CD   IN ('S', 'T')" ).append("\n"); 
		query.append("AND BK.BKG_STS_CD        <> 'X'        --cancel 제외" ).append("\n"); 
		query.append("AND BK.BKG_CGO_TP_CD     <> 'P'        --empty repo 제외" ).append("\n"); 
		query.append("AND nvl(ISS.OBL_ISS_FLG(+), 'N') = 'N' --B/L ISSUE 되면 제외" ).append("\n"); 
		query.append("AND NVL(BK.SPLIT_RSN_CD, 'X') <> 'M'   --memo split mst 제외" ).append("\n"); 
		query.append("AND (BK.BKG_NO IN (" ).append("\n"); 
		query.append("#foreach( ${bkg_no} in ${bkg_no_list})" ).append("\n"); 
		query.append("#if($velocityCount < $bkg_no_list.size()) '$bkg_no', #else '$bkg_no' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR BK.BL_NO IN (" ).append("\n"); 
		query.append("#foreach( ${bl_no} in ${bl_no_list})" ).append("\n"); 
		query.append("#if($velocityCount < $bkg_no_list.size()) '$bl_no', #else '$bl_no' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("))" ).append("\n"); 

	}
}