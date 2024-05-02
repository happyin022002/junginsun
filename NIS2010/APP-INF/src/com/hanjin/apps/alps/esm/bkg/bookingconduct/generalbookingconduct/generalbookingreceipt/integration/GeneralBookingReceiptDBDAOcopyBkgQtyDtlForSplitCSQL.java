/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOcopyBkgQtyDtlForSplitCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2011.06.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOcopyBkgQtyDtlForSplitCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * sourceBkg의 bkg_qty_dtl를 targetBkg로 복사한다.
	  * 2011.06.08 이일민 [CHM-201110982-01] e-SI & DPCS BKG Split & Combine 기능 구현 요청
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOcopyBkgQtyDtlForSplitCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("targetBkg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOcopyBkgQtyDtlForSplitCSQL").append("\n"); 
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
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("INSERT INTO BKG_QTY_DTL_HIS (" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_QTY_DTL (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append(",      CORR_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", SUBST_SEQ" ).append("\n"); 
		query.append(", RCV_TERM_CD" ).append("\n"); 
		query.append(", DE_TERM_CD" ).append("\n"); 
		query.append(", OP_CNTR_QTY" ).append("\n"); 
		query.append(", AWK_CGO_FLG" ).append("\n"); 
		query.append(", DCGO_FLG" ).append("\n"); 
		query.append(", RC_FLG" ).append("\n"); 
		query.append(", BB_CGO_FLG" ).append("\n"); 
		query.append(", SOC_FLG" ).append("\n"); 
		query.append(", CRR_HNGR_SGL_BAR_USE_FLG" ).append("\n"); 
		query.append(", CRR_HNGR_DBL_BAR_USE_FLG" ).append("\n"); 
		query.append(", EQ_SUBST_CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", DRY_CGO_FLG" ).append("\n"); 
		query.append(", CRR_HNGR_FLG" ).append("\n"); 
		query.append(", MER_HNGR_FLG" ).append("\n"); 
		query.append(", CRR_HNGR_TPL_BAR_USE_FLG" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT)" ).append("\n"); 
		query.append("select @[targetBkg]" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", SUBST_SEQ" ).append("\n"); 
		query.append(", RCV_TERM_CD" ).append("\n"); 
		query.append(", DE_TERM_CD" ).append("\n"); 
		query.append(", OP_CNTR_QTY" ).append("\n"); 
		query.append(", AWK_CGO_FLG" ).append("\n"); 
		query.append(", DCGO_FLG" ).append("\n"); 
		query.append(", RC_FLG" ).append("\n"); 
		query.append(", BB_CGO_FLG" ).append("\n"); 
		query.append(", SOC_FLG" ).append("\n"); 
		query.append(", CRR_HNGR_SGL_BAR_USE_FLG" ).append("\n"); 
		query.append(", CRR_HNGR_DBL_BAR_USE_FLG" ).append("\n"); 
		query.append(", EQ_SUBST_CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", DRY_CGO_FLG" ).append("\n"); 
		query.append(", CRR_HNGR_FLG" ).append("\n"); 
		query.append(", MER_HNGR_FLG" ).append("\n"); 
		query.append(", CRR_HNGR_TPL_BAR_USE_FLG" ).append("\n"); 
		query.append(", @[usr_id]" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append(", @[usr_id]" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append("from bkg_qty_dtl" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and cntr_tpsz_cd = @[cntr_tpsz_cd]" ).append("\n"); 

	}
}