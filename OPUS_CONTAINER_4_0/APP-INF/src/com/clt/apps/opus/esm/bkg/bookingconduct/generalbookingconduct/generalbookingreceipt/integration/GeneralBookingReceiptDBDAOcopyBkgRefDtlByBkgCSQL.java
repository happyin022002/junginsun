/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOcopyBkgRefDtlByBkgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.10.20 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Yeoung Hee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOcopyBkgRefDtlByBkgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * sourceBkg의 bkg_ref_dtl를 targetBkg로 복사한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOcopyBkgRefDtlByBkgCSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("targetBkg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOcopyBkgRefDtlByBkgCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_REF_DTL(BKG_NO" ).append("\n"); 
		query.append(",REF_SEQ" ).append("\n"); 
		query.append(",CUST_REF_TP_CD" ).append("\n"); 
		query.append(",DE_NO" ).append("\n"); 
		query.append(",PRT_NO" ).append("\n"); 
		query.append(",CPY_DESC_FLG" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",ITM_NO" ).append("\n"); 
		query.append(",ITM_DESC" ).append("\n"); 
		query.append(",PCK_QTY" ).append("\n"); 
		query.append(",PCK_TP_CD" ).append("\n"); 
		query.append(",CNTR_WGT" ).append("\n"); 
		query.append(",WGT_UT_CD" ).append("\n"); 
		query.append(",MEAS_QTY" ).append("\n"); 
		query.append(",MEAS_UT_CD" ).append("\n"); 
		query.append(",PO_NO" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("select @[targetBkg] BKG_NO" ).append("\n"); 
		query.append(",(select /*+index_desc ( bkg_ref_dtl XPKBKG_REF_DTL)*/" ).append("\n"); 
		query.append("(nvl(sum(REF_SEQ),0)+1)+ref.REF_SEQ" ).append("\n"); 
		query.append("from bkg_ref_dtl" ).append("\n"); 
		query.append("where REF_SEQ >= 0" ).append("\n"); 
		query.append("and rownum <= 1" ).append("\n"); 
		query.append("and bkg_no = @[targetBkg] )REF_SEQ" ).append("\n"); 
		query.append(",ref.CUST_REF_TP_CD" ).append("\n"); 
		query.append(",ref.DE_NO" ).append("\n"); 
		query.append(",ref.PRT_NO" ).append("\n"); 
		query.append(",ref.CPY_DESC_FLG" ).append("\n"); 
		query.append(",ref.CNTR_NO" ).append("\n"); 
		query.append(",ref.ITM_NO" ).append("\n"); 
		query.append(",ref.ITM_DESC" ).append("\n"); 
		query.append(",ref.PCK_QTY" ).append("\n"); 
		query.append(",ref.PCK_TP_CD" ).append("\n"); 
		query.append(",ref.CNTR_WGT" ).append("\n"); 
		query.append(",ref.WGT_UT_CD" ).append("\n"); 
		query.append(",ref.MEAS_QTY" ).append("\n"); 
		query.append(",ref.MEAS_UT_CD" ).append("\n"); 
		query.append(",ref.PO_NO" ).append("\n"); 
		query.append(",@[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append(",sysdate CRE_DT" ).append("\n"); 
		query.append(",@[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append(",sysdate UPD_DT" ).append("\n"); 
		query.append("from bkg_ref_dtl ref" ).append("\n"); 
		query.append("where ref.bkg_no =@[bkg_no]" ).append("\n"); 
		query.append("#if (${cntr_no}!='')" ).append("\n"); 
		query.append("and ref.cntr_no =@[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}