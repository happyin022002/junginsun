/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CODCorrectionDBDAOsearchCodCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.01.07 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CODCorrectionDBDAOsearchCodCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * bkg_cod_cost을 조회한다.
	  * </pre>
	  */
	public CODCorrectionDBDAOsearchCodCostRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkgNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("codRqstSeq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.integration").append("\n"); 
		query.append("FileName : CODCorrectionDBDAOsearchCodCostRSQL").append("\n"); 
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
		query.append("select COST_CD_RQST_SEQ" ).append("\n"); 
		query.append(", chg_cd" ).append("\n"); 
		query.append(", curr_cd" ).append("\n"); 
		query.append(", chg_ut_amt" ).append("\n"); 
		query.append(", rat_as_qty" ).append("\n"); 
		query.append(", rat_ut_cd" ).append("\n"); 
		query.append(", chg_amt" ).append("\n"); 
		query.append(", frt_term_cd" ).append("\n"); 
		query.append(", cgo_cate_cd" ).append("\n"); 
		query.append(", decode(nvl(cntr_cgo_tp_cd, 'F'), 'F', 'Full', 'P', 'Empty', 'Full') cntr_cgo_tp_cd" ).append("\n"); 
		query.append("from bkg_cod_cost" ).append("\n"); 
		query.append("where bkg_no = @[bkgNo]" ).append("\n"); 
		query.append("and cod_rqst_seq = @[codRqstSeq]" ).append("\n"); 

	}
}