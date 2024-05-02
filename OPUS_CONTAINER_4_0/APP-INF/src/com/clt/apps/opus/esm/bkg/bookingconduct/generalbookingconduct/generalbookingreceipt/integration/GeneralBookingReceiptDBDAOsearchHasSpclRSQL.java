/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOsearchHasSpclRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.13
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2015.08.13 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOsearchHasSpclRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Special Cargo 존재여부
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOsearchHasSpclRSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOsearchHasSpclRSQL").append("\n"); 
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
		query.append("select count(1) cnt" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("    select max(dg.dcgo_seq) dcgo_Seq" ).append("\n"); 
		query.append("            , max(rf.rc_seq) rc_seq" ).append("\n"); 
		query.append("            , max(awk.awk_cgo_seq) awk_cgo_seq" ).append("\n"); 
		query.append("            , max(bb.bb_cgo_seq) bb_cgo_seq" ).append("\n"); 
		query.append("            , max(ss.stwg_seq) stwg_seq" ).append("\n"); 
		query.append("      from bkg_booking bk, bkg_dg_cgo dg, bkg_rf_cgo rf, bkg_awk_cgo awk, bkg_bb_cgo bb, bkg_stwg_cgo ss" ).append("\n"); 
		query.append("     where bk.bkg_no        = dg.bkg_no(+)" ).append("\n"); 
		query.append("       and bk.bkg_no        = rf.bkg_no(+)" ).append("\n"); 
		query.append("       and bk.bkg_no        = awk.bkg_no(+)" ).append("\n"); 
		query.append("       and bk.bkg_no        = bb.bkg_no(+)" ).append("\n"); 
		query.append("       and bk.bkg_no        = ss.bkg_no(+)" ).append("\n"); 
		query.append("       and bk.bkg_no        = @[bkg_no]" ).append("\n"); 
		query.append("	   and dg.spcl_cgo_apro_cd(+)  <> 'C'" ).append("\n"); 
		query.append("	   and rf.spcl_cgo_apro_cd(+)  <> 'C'" ).append("\n"); 
		query.append("	   and awk.spcl_cgo_apro_cd(+) <> 'C'" ).append("\n"); 
		query.append("	   and bb.spcl_cgo_apro_cd(+)  <> 'C'" ).append("\n"); 
		query.append("	   and ss.spcl_cgo_apro_cd(+)  <> 'C'" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("where dcgo_seq      is not null " ).append("\n"); 
		query.append("   or rc_seq        is not null" ).append("\n"); 
		query.append("   or awk_cgo_seq   is not null" ).append("\n"); 
		query.append("   or bb_cgo_seq    is not null" ).append("\n"); 
		query.append("   or stwg_seq    is not null" ).append("\n"); 

	}
}