/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OceanLinkManageDBDAOSearchOceanLinkRHQRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.09.16 김귀진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kIm kwi-jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanLinkManageDBDAOSearchOceanLinkRHQRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOceanLinkRHQ
	  * </pre>
	  */
	public OceanLinkManageDBDAOSearchOceanLinkRHQRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_to",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.integration ").append("\n"); 
		query.append("FileName : OceanLinkManageDBDAOSearchOceanLinkRHQRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("vsl_slan_cd," ).append("\n"); 
		query.append("lnk_org_loc_cd fromloc," ).append("\n"); 
		query.append("substr(lnk_org_nod_cd,6,2) orgyard," ).append("\n"); 
		query.append("lnk_dest_loc_cd toloc," ).append("\n"); 
		query.append("substr(lnk_dest_nod_cd,6,2) destyard," ).append("\n"); 
		query.append("tztm_hrs, fdr_freq_knt," ).append("\n"); 
		query.append("pctl_io_bnd_cd," ).append("\n"); 
		query.append("skd_dir_cd," ).append("\n"); 
		query.append("vndr_seq," ).append("\n"); 
		query.append("(select vndr_lgl_eng_nm from mdm_vendor mv where mv.vndr_seq = pf.vndr_seq) vndrnm," ).append("\n"); 
		query.append("lnk_rmk," ).append("\n"); 
		query.append("sun_st_flg," ).append("\n"); 
		query.append("mon_st_flg," ).append("\n"); 
		query.append("tue_st_flg," ).append("\n"); 
		query.append("wed_st_flg," ).append("\n"); 
		query.append("thu_st_flg," ).append("\n"); 
		query.append("fri_st_flg," ).append("\n"); 
		query.append("sat_st_flg" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM   PRD_FDR_LNK PF" ).append("\n"); 
		query.append("WHERE  nvl(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    LNK_ORG_LOC_CD LIKE  @[port_fm] ||'%'" ).append("\n"); 
		query.append("AND    LNK_DEST_LOC_CD LIKE @[port_to] ||'%'" ).append("\n"); 

	}
}