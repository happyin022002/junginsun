/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchBkgForSpclRqstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.25
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.05.25 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Daeyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchBkgForSpclRqstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vvd변경시 spcl cargo rqst를 위해 bkg data를 조회한다.
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchBkgForSpclRqstRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchBkgForSpclRqstRSQL").append("\n"); 
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
		query.append("select bk.bkg_no" ).append("\n"); 
		query.append(", bk.por_cd" ).append("\n"); 
		query.append(", bk.del_cd" ).append("\n"); 
		query.append(", bk.rcv_term_cd bkg_rcv_term_cd" ).append("\n"); 
		query.append(", bk.de_term_cd bkg_de_term_cd" ).append("\n"); 
		query.append(", 'DG' spcl_cgo_cate_cd" ).append("\n"); 
		query.append(", count(1) dcgo_qty" ).append("\n"); 
		query.append(", 0 rc_qty" ).append("\n"); 
		query.append(", 0 awk_cgo_qty" ).append("\n"); 
		query.append(", 0 bb_cgo_qty" ).append("\n"); 
		query.append("from bkg_booking bk" ).append("\n"); 
		query.append(", bkg_dg_cgo dg" ).append("\n"); 
		query.append("where bk.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and bk.bkg_no = dg.bkg_no" ).append("\n"); 
		query.append("#if(${rqst_type} == 'SPLIT')" ).append("\n"); 
		query.append("and NVL(dg.SPCL_CGO_APRO_CD,'#') in ('R', 'P') --split일 때는 request, pending에 대해서만 재REQUEST" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("and NVL(dg.SPCL_CGO_APRO_CD,'#') in ('Y', 'R', 'P') --요청/승인됐던 건에 대해서 재REQUEST" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("group by bk.bkg_no" ).append("\n"); 
		query.append(", bk.por_cd" ).append("\n"); 
		query.append(", bk.del_cd" ).append("\n"); 
		query.append(", bk.rcv_term_cd" ).append("\n"); 
		query.append(", bk.de_term_cd" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("select bk.bkg_no" ).append("\n"); 
		query.append(", bk.por_cd" ).append("\n"); 
		query.append(", bk.del_cd" ).append("\n"); 
		query.append(", bk.rcv_term_cd bkg_rcv_term_cd" ).append("\n"); 
		query.append(", bk.de_term_cd bkg_de_term_cd" ).append("\n"); 
		query.append(", 'RF' spcl_cgo_cate_cd" ).append("\n"); 
		query.append(", 0 dcgo_qty" ).append("\n"); 
		query.append(", count(1) rc_qty" ).append("\n"); 
		query.append(", 0 awk_cgo_qty" ).append("\n"); 
		query.append(", 0 bb_cgo_qty" ).append("\n"); 
		query.append("from bkg_booking bk" ).append("\n"); 
		query.append(", bkg_rf_cgo rf" ).append("\n"); 
		query.append("where bk.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and bk.bkg_no = rf.bkg_no" ).append("\n"); 
		query.append("#if(${rqst_type} == 'SPLIT')" ).append("\n"); 
		query.append("and NVL(rf.SPCL_CGO_APRO_CD,'#') in ('R', 'P') --split일 때는 request, pending에 대해서만 재REQUEST" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("and NVL(rf.SPCL_CGO_APRO_CD,'#') in ('Y', 'R', 'P') --요청/승인됐던 건에 대해서 재REQUEST" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("group by bk.bkg_no" ).append("\n"); 
		query.append(", bk.por_cd" ).append("\n"); 
		query.append(", bk.del_cd" ).append("\n"); 
		query.append(", bk.rcv_term_cd" ).append("\n"); 
		query.append(", bk.de_term_cd" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("select bk.bkg_no" ).append("\n"); 
		query.append(", bk.por_cd" ).append("\n"); 
		query.append(", bk.del_cd" ).append("\n"); 
		query.append(", bk.rcv_term_cd bkg_rcv_term_cd" ).append("\n"); 
		query.append(", bk.de_term_cd bkg_de_term_cd" ).append("\n"); 
		query.append(", 'AK' spcl_cgo_cate_cd" ).append("\n"); 
		query.append(", 0 dcgo_qty" ).append("\n"); 
		query.append(", 0 rc_qty" ).append("\n"); 
		query.append(", count(1) awk_cgo_qty" ).append("\n"); 
		query.append(", 0 bb_cgo_qty" ).append("\n"); 
		query.append("from bkg_booking bk" ).append("\n"); 
		query.append(", bkg_awk_cgo ak" ).append("\n"); 
		query.append("where bk.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and bk.bkg_no = ak.bkg_no" ).append("\n"); 
		query.append("#if(${rqst_type} == 'SPLIT')" ).append("\n"); 
		query.append("and NVL(ak.SPCL_CGO_APRO_CD,'#') in ('R', 'P') --split일 때는 request, pending에 대해서만 재REQUEST" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("and NVL(ak.SPCL_CGO_APRO_CD,'#') in ('Y', 'R', 'P') --요청/승인됐던 건에 대해서 재REQUEST" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("group by bk.bkg_no" ).append("\n"); 
		query.append(", bk.por_cd" ).append("\n"); 
		query.append(", bk.del_cd" ).append("\n"); 
		query.append(", bk.rcv_term_cd" ).append("\n"); 
		query.append(", bk.de_term_cd" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("select bk.bkg_no" ).append("\n"); 
		query.append(", bk.por_cd" ).append("\n"); 
		query.append(", bk.del_cd" ).append("\n"); 
		query.append(", bk.rcv_term_cd bkg_rcv_term_cd" ).append("\n"); 
		query.append(", bk.de_term_cd bkg_de_term_cd" ).append("\n"); 
		query.append(", 'BB' spcl_cgo_cate_cd" ).append("\n"); 
		query.append(", 0 dcgo_qty" ).append("\n"); 
		query.append(", 0 rc_qty" ).append("\n"); 
		query.append(", 0 awk_cgo_qty" ).append("\n"); 
		query.append(", count(1)  bb_cgo_qty" ).append("\n"); 
		query.append("from bkg_booking bk" ).append("\n"); 
		query.append(", bkg_bb_cgo bb" ).append("\n"); 
		query.append("where bk.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and bk.bkg_no = bb.bkg_no" ).append("\n"); 
		query.append("#if(${rqst_type} == 'SPLIT')" ).append("\n"); 
		query.append("and NVL(bb.SPCL_CGO_APRO_CD,'#') in ('R', 'P') --split일 때는 request, pending에 대해서만 재REQUEST" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("and NVL(bb.SPCL_CGO_APRO_CD,'#') in ('Y', 'R', 'P') --요청/승인됐던 건에 대해서 재REQUEST" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("group by bk.bkg_no" ).append("\n"); 
		query.append(", bk.por_cd" ).append("\n"); 
		query.append(", bk.del_cd" ).append("\n"); 
		query.append(", bk.rcv_term_cd" ).append("\n"); 
		query.append(", bk.de_term_cd" ).append("\n"); 

	}
}