/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOaddXterRefenceCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2010.06.08 
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

public class GeneralBookingReceiptDBDAOaddXterRefenceCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addXterRefence
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOaddXterRefenceCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOaddXterRefenceCSQL").append("\n"); 
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
		query.append("insert into bkg_reference" ).append("\n"); 
		query.append("(BKG_NO" ).append("\n"); 
		query.append(", REF_SEQ" ).append("\n"); 
		query.append(", BKG_REF_TP_CD" ).append("\n"); 
		query.append(", CUST_REF_NO_CTNT" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT)" ).append("\n"); 
		query.append("select @[bkg_no]" ).append("\n"); 
		query.append(", (select nvl(max(REF_SEQ), 0) + 1 from bkg_reference where bkg_no = @[bkg_no]) ref_seq" ).append("\n"); 
		query.append(", decode(@[doc_tp_cd], 'B', decode(@[no], 1, 'EBRF', 2, 'EBSH', 'EBFF')" ).append("\n"); 
		query.append(", decode(@[no], 1, 'ESRF', 2, 'ESSH', 'ESFF')) bkg_ref_tp_cd" ).append("\n"); 
		query.append(", decode(@[doc_tp_cd], 'B', decode(@[no], 1, mst.xter_rqst_no --EBRF" ).append("\n"); 
		query.append(", 2, DECODE(mst.xter_sndr_id,'SEANACCS',mst.cust_ref_no,mst.SHPR_REF_NO)  --EBSH" ).append("\n"); 
		query.append(", mst.FWRD_REF_NO)    --EBFF" ).append("\n"); 
		query.append(", decode(@[no], 1, mst.xter_rqst_no --EBRF" ).append("\n"); 
		query.append(", 2, DECODE(mst.xter_sndr_id,'SEANACCS',mst.cust_ref_no,mst.SHPR_REF_NO)  --EBSH" ).append("\n"); 
		query.append(", mst.FWRD_REF_NO)) cust_ref_no    --EBFF" ).append("\n"); 
		query.append(", @[usr_id]" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append(", @[usr_id]" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append("from bkg_xter_rqst_mst mst" ).append("\n"); 
		query.append("where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("and xter_rqst_seq= @[rqst_seq]" ).append("\n"); 

	}
}