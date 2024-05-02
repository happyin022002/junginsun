/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOCreateQtyCACSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.20
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.04.20 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Daeyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOCreateQtyCACSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralBookingReceiptDBDAOCreateQtyCACSQL
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOCreateQtyCACSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOCreateQtyCACSQL").append("\n"); 
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
		query.append("#if (${copy_type_cd} == 'BKG')" ).append("\n"); 
		query.append("INSERT INTO BKG_QUANTITY (" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_QTY_HIS (" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(", CORR_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", OP_CNTR_QTY" ).append("\n"); 
		query.append(", ACT_CNTR_QTY" ).append("\n"); 
		query.append(", DCGO_QTY" ).append("\n"); 
		query.append(", AWK_CGO_QTY" ).append("\n"); 
		query.append(", RC_QTY" ).append("\n"); 
		query.append(", BB_CGO_QTY" ).append("\n"); 
		query.append(", SOC_QTY" ).append("\n"); 
		query.append(", EQ_SUBST_CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append(", MER_HNGR_QTY" ).append("\n"); 
		query.append(", CRR_HNGR_QTY" ).append("\n"); 
		query.append(", CRR_HNGR_SGL_BAR_QTY" ).append("\n"); 
		query.append(", CRR_HNGR_DBL_BAR_QTY" ).append("\n"); 
		query.append(", CRR_HNGR_TPL_BAR_QTY" ).append("\n"); 
		query.append(", ORG_CNTR_QTY" ).append("\n"); 
		query.append(", DEST_CNTR_QTY" ).append("\n"); 
		query.append(", OB_TRO_QTY" ).append("\n"); 
		query.append(", IB_TRO_QTY" ).append("\n"); 
		query.append(", FLEX_HGT_FLG" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${copy_type_cd} == 'BKG')" ).append("\n"); 
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("#elseif (${copy_type_cd} == 'TEMP')" ).append("\n"); 
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append(", 'TMP0000001' CORR_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append(", @[ca_no] CORR_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", OP_CNTR_QTY" ).append("\n"); 
		query.append(", ACT_CNTR_QTY" ).append("\n"); 
		query.append(", DCGO_QTY" ).append("\n"); 
		query.append(", AWK_CGO_QTY" ).append("\n"); 
		query.append(", RC_QTY" ).append("\n"); 
		query.append(", BB_CGO_QTY" ).append("\n"); 
		query.append(", SOC_QTY" ).append("\n"); 
		query.append(", EQ_SUBST_CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append(", MER_HNGR_QTY" ).append("\n"); 
		query.append(", CRR_HNGR_QTY" ).append("\n"); 
		query.append(", CRR_HNGR_SGL_BAR_QTY" ).append("\n"); 
		query.append(", CRR_HNGR_DBL_BAR_QTY" ).append("\n"); 
		query.append(", CRR_HNGR_TPL_BAR_QTY" ).append("\n"); 
		query.append(", ORG_CNTR_QTY" ).append("\n"); 
		query.append(", DEST_CNTR_QTY" ).append("\n"); 
		query.append(", OB_TRO_QTY" ).append("\n"); 
		query.append(", IB_TRO_QTY" ).append("\n"); 
		query.append(", FLEX_HGT_FLG" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append("#if (${copy_type_cd} == 'BKG')" ).append("\n"); 
		query.append("FROM BKG_QTY_HIS" ).append("\n"); 
		query.append("WHERE BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("FROM BKG_QUANTITY" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}