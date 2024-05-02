/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingSplitCombineDBDAOsearchCntrListForCombineRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.08.19 전용진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun Yong Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSplitCombineDBDAOsearchCntrListForCombineRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCntrListForCombine
	  * </pre>
	  */
	public GeneralBookingSplitCombineDBDAOsearchCntrListForCombineRSQL(){
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
		query.append("FileName : GeneralBookingSplitCombineDBDAOsearchCntrListForCombineRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append(", CNTR_NO" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", (SELECT CNTR_SEAL_NO" ).append("\n"); 
		query.append("FROM BKG_CNTR_SEAL_NO SEAL" ).append("\n"); 
		query.append("WHERE SEAL.BKG_NO  = CNTR.BKG_NO" ).append("\n"); 
		query.append("AND SEAL.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("AND SEAL.CNTR_SEAL_SEQ = 1) SEAL_NO" ).append("\n"); 
		query.append(", PCK_QTY" ).append("\n"); 
		query.append(", CNTR_WGT" ).append("\n"); 
		query.append(", MEAS_QTY" ).append("\n"); 
		query.append(", RCV_TERM_CD" ).append("\n"); 
		query.append(", DE_TERM_CD" ).append("\n"); 
		query.append(", CNMV_STS_CD" ).append("\n"); 
		query.append("FROM BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}