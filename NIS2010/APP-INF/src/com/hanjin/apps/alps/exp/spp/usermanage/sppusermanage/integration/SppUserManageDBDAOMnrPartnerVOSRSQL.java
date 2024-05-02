/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SppUserManageDBDAOMnrPartnerVOSRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 안준상
*@LastVersion : 1.0
* 2009.08.07 안준상
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.exp.spp.usermanage.sppusermanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jsahn
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SppUserManageDBDAOMnrPartnerVOSRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * mnr contact info search
	  * </pre>
	  */
	public SppUserManageDBDAOMnrPartnerVOSRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sp_ptal_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.exp.spp.usermanage.sppusermanage.integration ").append("\n"); 
		query.append("FileName : SppUserManageDBDAOMnrPartnerVOSRSQL").append("\n"); 
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
		query.append("select 	mnr_prnr_cre_seq		," ).append("\n"); 
		query.append("mnr_prnr_cre_dtl_seq   ," ).append("\n"); 
		query.append("cnt_cd                 ," ).append("\n"); 
		query.append("ofc_cd                 ," ).append("\n"); 
		query.append("mnr_cntc_prnr_nm       ," ).append("\n"); 
		query.append("intl_phn_no            ," ).append("\n"); 
		query.append("phn_no                 ," ).append("\n"); 
		query.append("intl_fax_no            ," ).append("\n"); 
		query.append("fax_no                 ," ).append("\n"); 
		query.append("mnr_prnr_eml           ," ).append("\n"); 
		query.append("prmry_chk_flg          ," ).append("\n"); 
		query.append("cntc_div_cd            ," ).append("\n"); 
		query.append("mnr_prnr_addr          ," ).append("\n"); 
		query.append("mnr_prnr_rmk           ," ).append("\n"); 
		query.append("aply_flg               ," ).append("\n"); 
		query.append("cre_usr_id             ," ).append("\n"); 
		query.append("cre_dt                 ," ).append("\n"); 
		query.append("upd_usr_id             ," ).append("\n"); 
		query.append("upd_dt" ).append("\n"); 
		query.append("from MNR_PRNR_CNTC_PNT" ).append("\n"); 
		query.append("where mnr_prnr_cre_seq = (select mnr_prnr_cre_seq from mnr_partner where sp_ptal_id = @[sp_ptal_id])" ).append("\n"); 

	}
}