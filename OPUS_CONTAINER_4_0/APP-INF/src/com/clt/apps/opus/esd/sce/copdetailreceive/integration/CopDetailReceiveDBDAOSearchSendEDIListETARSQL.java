/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchSendEDIListETARSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchSendEDIListETARSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSendEDIListETA
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchSendEDIListETARSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchSendEDIListETARSQL").append("\n"); 
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
		query.append("select  f.cre_usr_id, h.bkg_no" ).append("\n"); 
		query.append("from bkg_bkg_vvd v, sce_flt_file_no_gen f" ).append("\n"); 
		query.append("where   v.vsl_cd       = substr(@[vsl_cd], 1, 4)" ).append("\n"); 
		query.append("and     v.skd_voy_no   = substr(@[skd_voy_no], 5, 4)" ).append("\n"); 
		query.append("and     v.skd_dir_cd   = substr(@[skd_dir_cd], 9, 1)" ).append("\n"); 
		query.append("and     v.bkg_no       = f.bkg_no" ).append("\n"); 
		query.append("and     f.rslt_flg     = 'N'" ).append("\n"); 
		query.append("and     f.cre_usr_id   = @[cre_usr_id]" ).append("\n"); 

	}
}