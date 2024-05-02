/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOcopyAkDimByBkgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOcopyAkDimByBkgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * copyAkDimByBkg
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOcopyAkDimByBkgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mst_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOcopyAkDimByBkgCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_AWK_DIM(BKG_NO" ).append("\n"); 
		query.append(", AWK_CGO_SEQ" ).append("\n"); 
		query.append(", DIM_SEQ" ).append("\n"); 
		query.append(", DIM_LEN" ).append("\n"); 
		query.append(", DIM_WDT" ).append("\n"); 
		query.append(", DIM_HGT" ).append("\n"); 
		query.append(", INDIV_PCK_WGT" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT)" ).append("\n"); 
		query.append("SELECT @[mst_bkg_no] BKG_NO" ).append("\n"); 
		query.append(",(SELECT /*+index_desc (bkg_awk_dim XPKBKG_AWK_DIM)*/" ).append("\n"); 
		query.append("NVL(SUM(AWK_CGO_SEQ),0)+DIM.AWK_CGO_SEQ" ).append("\n"); 
		query.append("FROM BKG_AWK_DIM" ).append("\n"); 
		query.append("WHERE AWK_CGO_SEQ >= 0" ).append("\n"); 
		query.append("AND ROWNUM <= 1" ).append("\n"); 
		query.append("AND BKG_NO = @[mst_bkg_no]) AWK_CGO_SEQ" ).append("\n"); 
		query.append(", DIM_SEQ" ).append("\n"); 
		query.append(", DIM_LEN" ).append("\n"); 
		query.append(", DIM_WDT" ).append("\n"); 
		query.append(", DIM_HGT" ).append("\n"); 
		query.append(", INDIV_PCK_WGT" ).append("\n"); 
		query.append(", @[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append("FROM BKG_AWK_DIM DIM" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND DIM.AWK_CGO_SEQ IN ( SELECT AWK_CGO_SEQ" ).append("\n"); 
		query.append("FROM BKG_AWK_CGO AK" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND (CNTR_NO IS NULL" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("CNTR_NO NOT IN (SELECT NVL(CNTR_NO, 'X')" ).append("\n"); 
		query.append("FROM BKG_AWK_CGO" ).append("\n"); 
		query.append("WHERE BKG_NO = @[mst_bkg_no])" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}