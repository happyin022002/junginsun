/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOcopySplitCopyRefByBkgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.09.29 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOcopySplitCopyRefByBkgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * sourceBkg의 bkg_reference를 targetBkg로 복사한다. split시 forwarder ref와 fmc no를 복사한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOcopySplitCopyRefByBkgCSQL(){
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
		params.put("targetBkg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration ").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOcopySplitCopyRefByBkgCSQL").append("\n"); 
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
		query.append("insert into bkg_reference(BKG_NO" ).append("\n"); 
		query.append(",REF_SEQ" ).append("\n"); 
		query.append(",BKG_REF_TP_CD" ).append("\n"); 
		query.append(",CUST_REF_NO_CTNT" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",CNTR_MF_SEQ" ).append("\n"); 
		query.append(",CPY_DESC_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("select @[targetBkg] BKG_NO" ).append("\n"); 
		query.append(",(select /*+index_desc ( bkg_reference XPKBKG_REFERENCE)*/" ).append("\n"); 
		query.append("(nvl(sum(REF_SEQ),0)+1)+ref.REF_SEQ" ).append("\n"); 
		query.append("from bkg_reference" ).append("\n"); 
		query.append("where REF_SEQ >= 0" ).append("\n"); 
		query.append("and rownum <= 1" ).append("\n"); 
		query.append("and bkg_no = @[targetBkg] )REF_SEQ" ).append("\n"); 
		query.append(",ref.BKG_REF_TP_CD" ).append("\n"); 
		query.append(",ref.CUST_REF_NO_CTNT" ).append("\n"); 
		query.append(",ref.CNTR_NO" ).append("\n"); 
		query.append(",ref.CNTR_MF_SEQ" ).append("\n"); 
		query.append(",ref.CPY_DESC_FLG" ).append("\n"); 
		query.append(",@[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append(",sysdate CRE_DT" ).append("\n"); 
		query.append(",@[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append(",sysdate UPD_DT" ).append("\n"); 
		query.append("from bkg_reference ref" ).append("\n"); 
		query.append("where ref.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and ref.bkg_ref_tp_cd in ('FMCN', 'FFNO')" ).append("\n"); 

	}
}