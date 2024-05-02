/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GeneralBookingSplitCombineDBDAOsearchAkSplitRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.22
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.10.22 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSplitCombineDBDAOsearchAkSplitRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * awkward cargo split시 참고할 data를 조회한다.   
	  * </pre>
	  */
	public GeneralBookingSplitCombineDBDAOsearchAkSplitRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration").append("\n"); 
		query.append("FileName : GeneralBookingSplitCombineDBDAOsearchAkSplitRSQL").append("\n"); 
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
		query.append("select awk_cgo_seq --ROWNUM awk_cgo_seq" ).append("\n"); 
		query.append("        , awk.cntr_no" ).append("\n"); 
		query.append("        , cmdt.cmdt_nm" ).append("\n"); 
		query.append("        , awk.ttl_dim_len" ).append("\n"); 
		query.append("        , awk.ttl_dim_wdt" ).append("\n"); 
		query.append("        , awk.ttl_dim_hgt" ).append("\n"); 
		query.append("        , grs_wgt" ).append("\n"); 
		query.append("  from bkg_booking bkg, bkg_awk_cgo awk, mdm_commodity cmdt" ).append("\n"); 
		query.append(" where bkg.bkg_no = awk.bkg_no " ).append("\n"); 
		query.append("   and cmdt.cmdt_cd = awk.cmdt_cd(+)" ).append("\n"); 
		query.append("   and nvl(awk.spcl_cgo_apro_cd, 'X') <> 'C'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_no} !='' )" ).append("\n"); 
		query.append("	and bkg.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY CNTR_NO, AWK_CGO_SEQ" ).append("\n"); 

	}
}