/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingSplitCombineDBDAOsearchTroSplitRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.02
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.03.02 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSplitCombineDBDAOsearchTroSplitRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * tro split시 참고할 data를 조회한다.   
	  * </pre>
	  */
	public GeneralBookingSplitCombineDBDAOsearchTroSplitRSQL(){
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
		query.append("FileName : GeneralBookingSplitCombineDBDAOsearchTroSplitRSQL").append("\n"); 
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
		query.append("select mst.tro_seq" ).append("\n"); 
		query.append(", dtl.tro_sub_seq" ).append("\n"); 
		query.append(", dtl.cntr_tpsz_cd" ).append("\n"); 
		query.append(", '' hualage" ).append("\n"); 
		query.append(", mst.dor_loc_cd door" ).append("\n"); 
		query.append(", 'EUR' tro_tp" ).append("\n"); 
		query.append("from bkg_tro mst, bkg_tro_dtl dtl" ).append("\n"); 
		query.append("where mst.bkg_no      = dtl.bkg_no" ).append("\n"); 
		query.append("and mst.tro_seq     = dtl.tro_seq" ).append("\n"); 
		query.append("and mst.io_bnd_cd   = dtl.io_bnd_cd" ).append("\n"); 
		query.append("and mst.rtn_tro_flg = dtl.rtn_tro_flg" ).append("\n"); 
		query.append("and mst.cxl_flg	   = 'N'" ).append("\n"); 
		query.append("and dtl.cxl_flg	   = 'N'" ).append("\n"); 
		query.append("#if (${bkg_no} !='' )" ).append("\n"); 
		query.append("and mst.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and mst.io_bnd_cd   = 'O'" ).append("\n"); 
		query.append("and mst.rtn_tro_flg = 'N'" ).append("\n"); 
		query.append("union" ).append("\n"); 
		query.append("select mst.tro_seq" ).append("\n"); 
		query.append(", dtl.tro_sub_seq" ).append("\n"); 
		query.append(", mst.cntr_tpsz_cd" ).append("\n"); 
		query.append(", mst.hlg_tp_cd haulage" ).append("\n"); 
		query.append(", dtl.loc_cd door" ).append("\n"); 
		query.append(", 'GEN' tro_tp" ).append("\n"); 
		query.append("from bkg_eur_tro mst, bkg_eur_tro_dtl dtl" ).append("\n"); 
		query.append("where mst.bkg_no      = dtl.bkg_no" ).append("\n"); 
		query.append("and mst.tro_seq     = dtl.tro_seq" ).append("\n"); 
		query.append("and mst.io_bnd_cd   = dtl.io_bnd_cd" ).append("\n"); 
		query.append("and mst.cxl_flg	   = 'N'" ).append("\n"); 
		query.append("#if (${bkg_no} !='' )" ).append("\n"); 
		query.append("and mst.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and mst.io_bnd_cd   = 'O'" ).append("\n"); 

	}
}