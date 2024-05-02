/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingSplitCombineDBDAOsearchRfSplitRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.19
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2016.04.19 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSplitCombineDBDAOsearchRfSplitRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * reefer cargo split시 참고할 data를 조회한다.   
	  * </pre>
	  */
	public GeneralBookingSplitCombineDBDAOsearchRfSplitRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration").append("\n"); 
		query.append("FileName : GeneralBookingSplitCombineDBDAOsearchRfSplitRSQL").append("\n"); 
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
		query.append("select rc_seq--ROWNUM " ).append("\n"); 
		query.append("        , rf.cntr_no" ).append("\n"); 
		query.append("        , rf.cdo_temp" ).append("\n"); 
		query.append("        , cmdt.cmdt_nm       " ).append("\n"); 
		query.append("  from bkg_booking bkg, bkg_rf_cgo rf, mdm_commodity cmdt" ).append("\n"); 
		query.append(" where bkg.bkg_no = rf.bkg_no " ).append("\n"); 
		query.append("   and cmdt.cmdt_cd = rf.cmdt_cd(+)" ).append("\n"); 
		query.append("   and nvl(rf.spcl_cgo_apro_cd,'A') <> 'C'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_no} !='' )" ).append("\n"); 
		query.append("	and bkg.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY CNTR_NO, RC_SEQ" ).append("\n"); 

	}
}