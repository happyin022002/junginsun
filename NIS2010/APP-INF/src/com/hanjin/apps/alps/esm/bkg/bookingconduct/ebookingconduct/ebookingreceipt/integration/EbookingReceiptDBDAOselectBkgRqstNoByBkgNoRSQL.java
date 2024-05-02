/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EbookingReceiptDBDAOselectBkgRqstNoByBkgNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.13
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.06.13 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EbookingReceiptDBDAOselectBkgRqstNoByBkgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgNo로 BkgRqst 정보를 조회한다.
	  * </pre>
	  */
	public EbookingReceiptDBDAOselectBkgRqstNoByBkgNoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EbookingReceiptDBDAOselectBkgRqstNoByBkgNoRSQL").append("\n"); 
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
		query.append("select XTER_SNDR_ID SENDER_ID" ).append("\n"); 
		query.append("	  ,XTER_RQST_NO RQST_NO" ).append("\n"); 
		query.append("	  ,XTER_RQST_SEQ RQST_SEQ" ).append("\n"); 
		query.append("  from bkg_xter_rqst_mst mst" ).append("\n"); 
		query.append(" where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("   and doc_tp_cd = 'B'" ).append("\n"); 
		query.append("   and rqst_dt = (select max(rqst_dt)" ).append("\n"); 
		query.append("                    from bkg_xter_rqst_mst mst2" ).append("\n"); 
		query.append("                   where mst.bkg_no = mst2.bkg_no" ).append("\n"); 
		query.append("                     and mst.doc_tp_cd = mst2.doc_tp_cd)" ).append("\n"); 

	}
}