/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationBLDBDAOremoveBkgHblCustByBkgDSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.07.07 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Yeoung Hee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOremoveBkgHblCustByBkgDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * delete
	  * </pre>
	  */
	public BLDocumentationBLDBDAOremoveBkgHblCustByBkgDSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("delete from bkg_hbl_cust" ).append("\n");
		query.append("where (BKG_NO,HBL_SEQ,BKG_CUST_TP_CD) in (select hcust.BKG_NO,hcust.HBL_SEQ,hcust.BKG_CUST_TP_CD" ).append("\n");
		query.append("from bkg_hbl hbl, bkg_container cntr, bkg_cntr_mf_desc cm, bkg_hbl_cust hcust" ).append("\n");
		query.append("where hbl.bkg_no = @[bkg_no]" ).append("\n");
		query.append("and hbl.bkg_no = cntr.bkg_no" ).append("\n");
		query.append("and hbl.bkg_no   = cm.bkg_no" ).append("\n");
		query.append("and cntr.cntr_no = cm.cntr_no" ).append("\n");
		query.append("and hbl.bkg_no   = hcust.bkg_no" ).append("\n");
		query.append("and hbl.HBL_SEQ  = hcust.HBL_SEQ" ).append("\n");
		query.append("and hbl.CNTR_MF_NO = cm.CNTR_MF_NO" ).append("\n");
		query.append("and cntr.CNTR_NO = @[cntr_no])" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration ").append("\n");
		query.append("FileName : BLDocumentationBLDBDAOremoveBkgHblCustByBkgDSQL").append("\n");
		query.append("*/").append("\n");
	}
}