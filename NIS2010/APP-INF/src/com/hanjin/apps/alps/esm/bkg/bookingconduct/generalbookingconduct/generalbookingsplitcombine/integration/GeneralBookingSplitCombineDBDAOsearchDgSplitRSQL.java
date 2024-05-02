/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GeneralBookingSplitCombineDBDAOsearchDgSplitRSQL.java
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

public class GeneralBookingSplitCombineDBDAOsearchDgSplitRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * danger cargo split시 참고할 data를 조회한다.   
	  * </pre>
	  */
	public GeneralBookingSplitCombineDBDAOsearchDgSplitRSQL(){
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
		query.append("FileName : GeneralBookingSplitCombineDBDAOsearchDgSplitRSQL").append("\n"); 
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
		query.append("select dg.dcgo_seq" ).append("\n"); 
		query.append("        , dg.dg_cntr_seq" ).append("\n"); 
		query.append("        , dg.cntr_no" ).append("\n"); 
		query.append("        , dg.cntr_cgo_seq" ).append("\n"); 
		query.append("        , dg.imdg_un_no" ).append("\n"); 
		query.append("        , dg.imdg_clss_cd" ).append("\n"); 
		query.append("  from bkg_booking bkg, BKG_DG_CGO dg" ).append("\n"); 
		query.append(" where bkg.bkg_no = dg.bkg_no " ).append("\n"); 
		query.append("   and nvl(dg.spcl_cgo_apro_cd, 'X') <> 'C'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_no} !='' )" ).append("\n"); 
		query.append("	and bkg.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY CNTR_NO, DG_CNTR_SEQ, DCGO_SEQ" ).append("\n"); 

	}
}