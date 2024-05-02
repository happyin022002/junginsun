/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOsearchTrunkVvdFromPrdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.25
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.01.25 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOsearchTrunkVvdFromPrdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * prd_prod_ctl_mst에서 trunk vvd를 조회한다
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOsearchTrunkVvdFromPrdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOsearchTrunkVvdFromPrdRSQL").append("\n"); 
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
		query.append("select TRNK_VSL_CD        VSL_CD" ).append("\n"); 
		query.append(", TRNK_SKD_VOY_NO SKD_VOY_NO" ).append("\n"); 
		query.append(", TRNK_SKD_DIR_CD SKD_DIR_CD" ).append("\n"); 
		query.append(", POR_CD" ).append("\n"); 
		query.append(", POR_NOD_CD" ).append("\n"); 
		query.append(", POL_CD" ).append("\n"); 
		query.append(", POL_NOD_CD" ).append("\n"); 
		query.append(", POD_CD" ).append("\n"); 
		query.append(", POD_NOD_CD" ).append("\n"); 
		query.append(", DEL_CD" ).append("\n"); 
		query.append(", DEL_NOD_CD" ).append("\n"); 
		query.append(", (select VSL_CD||SKD_VOY_NO||SKD_DIR_CD" ).append("\n"); 
		query.append("from prd_prod_ctl_rout_dtl dtl" ).append("\n"); 
		query.append("where dtl.pctl_no = MST.PCTL_NO" ).append("\n"); 
		query.append("and DTL.pctl_seq    = (select min(pctl_seq)" ).append("\n"); 
		query.append("from prd_prod_ctl_rout_dtl SEQ" ).append("\n"); 
		query.append("where SEQ.pctl_no        = DTL.PCTL_NO" ).append("\n"); 
		query.append("and SEQ.TRSP_MOD_CD    in ('VD','WD')" ).append("\n"); 
		query.append("and SEQ.PCTL_IO_BND_CD = 'T')) first_vvd" ).append("\n"); 
		query.append(", (SELECT SKD.VSL_SLAN_CD" ).append("\n"); 
		query.append("FROM VSK_VSL_SKD SKD" ).append("\n"); 
		query.append("WHERE SKD.VSL_CD     = MST.TRNK_VSL_CD" ).append("\n"); 
		query.append("AND SKD.SKD_VOY_NO = MST.TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("AND SKD.SKD_DIR_CD = MST.TRNK_SKD_DIR_CD) TRNK_SLAN_CD" ).append("\n"); 
		query.append("from prd_prod_ctl_mst MST" ).append("\n"); 
		query.append("where pctl_no = @[pctl_no]" ).append("\n"); 

	}
}