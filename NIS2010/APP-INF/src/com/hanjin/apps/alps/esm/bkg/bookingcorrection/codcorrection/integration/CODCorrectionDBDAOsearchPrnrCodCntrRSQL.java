/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CODCorrectionDBDAOsearchPrnrCodCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.02.24 류대영
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

public class CODCorrectionDBDAOsearchPrnrCodCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public CODCorrectionDBDAOsearchPrnrCodCntrRSQL(){
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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.integration").append("\n"); 
		query.append("FileName : CODCorrectionDBDAOsearchPrnrCodCntrRSQL").append("\n"); 
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
		query.append("select CNTR_NO" ).append("\n"); 
		query.append(", (select cntr_tpsz_cd from mst_container mst where mst.cntr_no = cntr.cntr_no) cntr_tpsz_cd" ).append("\n"); 
		query.append(", to_char(cntr_wgt, '999,999,990.000') cntr_wgt" ).append("\n"); 
		query.append(", DCGO_FLG" ).append("\n"); 
		query.append(", BB_CGO_FLG" ).append("\n"); 
		query.append(", AWK_CGO_FLG" ).append("\n"); 
		query.append(", RC_FLG" ).append("\n"); 
		query.append(", soc_flg" ).append("\n"); 
		query.append(", nvl(CNTR_STWG_NO, '') cntr_stwg_no" ).append("\n"); 
		query.append("from bkg_cod_cntr cntr" ).append("\n"); 
		query.append("where bkg_no       = @[bkg_no]" ).append("\n"); 
		query.append("and cod_rqst_seq = @[cod_rqst_seq]" ).append("\n"); 
		query.append("and COD_SLCT_FLG = 'Y'" ).append("\n"); 

	}
}