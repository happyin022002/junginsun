/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOmodifySpclQtyUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.09.02 이병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Byung Kyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOmodifySpclQtyUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifySpclQty
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOmodifySpclQtyUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOmodifySpclQtyUSQL").append("\n"); 
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
		query.append("UPDATE BKG_QUANTITY SET" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${spcl_tp} == 'DG')" ).append("\n"); 
		query.append("DCGO_QTY = (select sum(cntr_vol_qty) from bkg_dg_cgo" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	CNTR_TPSZ_CD = @[cntr_tpsz_cd])" ).append("\n"); 
		query.append("#elseif (${spclTp} == 'AWK')" ).append("\n"); 
		query.append("AWK_CGO_QTY = (select sum(cntr_vol_qty) from bkg_awk_cgo" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	CNTR_TPSZ_CD = @[cntr_tpsz_cd])" ).append("\n"); 
		query.append("#elseif (${spclTp} == 'RF')" ).append("\n"); 
		query.append("RC_QTY = (select sum(cntr_vol_qty) from bkg_rf_cgo" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	CNTR_TPSZ_CD = @[cntr_tpsz_cd])" ).append("\n"); 
		query.append("#elseif (${spclTp} == 'BB')" ).append("\n"); 
		query.append("BB_CGO_QTY = (select sum(cntr_vol_qty) from bkg_bb_cgo" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	CNTR_TPSZ_CD = @[cntr_tpsz_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 

	}
}