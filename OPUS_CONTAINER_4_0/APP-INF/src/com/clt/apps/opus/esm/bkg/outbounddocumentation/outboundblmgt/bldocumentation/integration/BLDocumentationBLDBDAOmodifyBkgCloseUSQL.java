/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationBLDBDAOmodifyBkgCloseUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.10.28 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Yeoung Hee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOmodifyBkgCloseUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * bkg_bl_doc 테이블 수정
	  * </pre>
	  */
	public BLDocumentationBLDBDAOmodifyBkgCloseUSQL(){
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
		params.put("bkg_clz_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOmodifyBkgCloseUSQL").append("\n"); 
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
		query.append("update bkg_bl_doc" ).append("\n"); 
		query.append("set bkg_clz_flg = decode(@[bkg_clz_sts_cd], 'C', 'Y', 'N')" ).append("\n"); 
		query.append(", bkg_clz_cng_flg = decode(@[bkg_clz_sts_cd], 'C', bkg_clz_cng_flg, 'N')" ).append("\n"); 
		query.append(",upd_usr_id = @[usr_id]" ).append("\n"); 
		query.append(",upd_dt =sysdate" ).append("\n"); 
		query.append("where bkg_no in" ).append("\n"); 
		query.append("(select bk.bkg_no" ).append("\n"); 
		query.append("from bkg_booking bk, bkg_vvd vvd" ).append("\n"); 
		query.append("where bk.bkg_no = vvd.bkg_no" ).append("\n"); 
		query.append("and vvd.vsl_cd     = @[vsl_cd]" ).append("\n"); 
		query.append("and vvd.skd_voy_no = @[skd_voy_no]" ).append("\n"); 
		query.append("and vvd.skd_dir_cd = @[skd_dir_cd]" ).append("\n"); 
		query.append("and vvd.pol_cd     = @[pol_cd]" ).append("\n"); 
		query.append("and bk.bkg_ofc_cd  = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("and bk.pol_cd      = @[pol_cd])" ).append("\n"); 

	}
}