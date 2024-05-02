/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOBkgContainerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.01
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.01 
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

public class SpecialCargoReceiptDBDAOBkgContainerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgContainer_combo
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOBkgContainerRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOBkgContainerRSQL").append("\n"); 
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
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CNTR_NO val" ).append("\n"); 
		query.append(", 	CNTR_NO name" ).append("\n"); 
		query.append(", 	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", 	CNTR_VOL_QTY" ).append("\n"); 
		query.append(", 	RCV_TERM_CD" ).append("\n"); 
		query.append(", 	DE_TERM_CD" ).append("\n"); 
		query.append("FROM BKG_CNTR_HIS" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("and CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT CNTR_NO val" ).append("\n"); 
		query.append(",CNTR_NO name" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",CNTR_VOL_QTY" ).append("\n"); 
		query.append(",RCV_TERM_CD" ).append("\n"); 
		query.append(",DE_TERM_CD" ).append("\n"); 
		query.append("FROM BKG_CONTAINER A1" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("FROM BKG_BOOKING A2" ).append("\n"); 
		query.append(",BKG_QTY_DTL A3" ).append("\n"); 
		query.append("WHERE A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("AND A2.BKG_NO = A3.BKG_NO" ).append("\n"); 
		query.append("AND CASE WHEN A2.FLEX_HGT_FLG = 'Y' AND A1.CNTR_TPSZ_CD = 'D5' THEN 'D4' ELSE A1.CNTR_TPSZ_CD END" ).append("\n"); 
		query.append("= CASE WHEN A2.FLEX_HGT_FLG = 'Y' AND A3.CNTR_TPSZ_CD = 'D5' THEN 'D4' ELSE A3.CNTR_TPSZ_CD END" ).append("\n"); 
		query.append("#if (${spcl_tp} == 'DG')" ).append("\n"); 
		query.append("AND A2.DCGO_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${spcl_tp} == 'AWK')" ).append("\n"); 
		query.append("AND A2.AWK_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${spcl_tp} == 'BB')" ).append("\n"); 
		query.append("AND A2.BB_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${spcl_tp} == 'RF')" ).append("\n"); 
		query.append("AND A2.RC_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}