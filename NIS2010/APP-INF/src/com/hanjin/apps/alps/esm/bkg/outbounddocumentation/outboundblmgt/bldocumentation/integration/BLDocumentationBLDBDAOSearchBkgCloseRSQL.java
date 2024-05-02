/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationBLDBDAOSearchBkgCloseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.31
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.12.31 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOSearchBkgCloseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 bkg이 close 되었는지 조회한다.
	  * </pre>
	  */
	public BLDocumentationBLDBDAOSearchBkgCloseRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOSearchBkgCloseRSQL").append("\n"); 
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
		query.append("select decode(BKG_CLZ_STS_CD, 'C', 'Y', 'N') BKG_CLZ_FLG" ).append("\n"); 
		query.append("from bkg_booking bk, bkg_vvd vvd, BKG_COFF_TM coff" ).append("\n"); 
		query.append("where bk.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and bk.bkg_no = vvd.bkg_no" ).append("\n"); 
		query.append("and bk.pol_cd = vvd.pol_cd" ).append("\n"); 
		query.append("and vvd.vsl_pre_pst_cd in ('S','T')" ).append("\n"); 
		query.append("and vvd.vsl_cd           = coff.vsl_cd (+)" ).append("\n"); 
		query.append("and vvd.skd_voy_no       = coff.skd_voy_no(+)" ).append("\n"); 
		query.append("and vvd.skd_dir_cd       = coff.skd_dir_cd(+)" ).append("\n"); 
		query.append("and vvd.pol_cd           = coff.pol_cd(+)" ).append("\n"); 
		query.append("and vvd.pol_clpt_ind_seq = coff.clpt_ind_seq(+)" ).append("\n"); 

	}
}