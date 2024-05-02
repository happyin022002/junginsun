/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InlandLinkManageDBDAOMultiAgmtNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.04
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandlinkmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandLinkManageDBDAOMultiAgmtNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiAgmtNo
	  * </pre>
	  */
	public InlandLinkManageDBDAOMultiAgmtNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnk_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnk_org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.inlandlinkmanage.integration").append("\n"); 
		query.append("FileName : InlandLinkManageDBDAOMultiAgmtNoUSQL").append("\n"); 
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
		query.append("UPDATE prd_inlnd_each_lnk l " ).append("\n"); 
		query.append("SET upd_usr_id = @[upd_usr_id] , " ).append("\n"); 
		query.append("  upd_dt = sysdate, " ).append("\n"); 
		query.append("  trsp_agmt_ofc_cty_cd = @[cty_cd], " ).append("\n"); 
		query.append("  trsp_agmt_seq = to_number( @[i_agmt_no] ) " ).append("\n"); 
		query.append("WHERE l.lnk_org_nod_cd = @[lnk_org_nod_cd]" ).append("\n"); 
		query.append("  AND l.lnk_dest_nod_cd = @[lnk_dest_nod_cd]" ).append("\n"); 
		query.append("  AND SUBSTR (l.lnk_org_nod_cd, 1, 2) IN ('US', 'CA' )    " ).append("\n"); 
		query.append("  AND SUBSTR (l.lnk_dest_nod_cd, 1, 2) IN ('US', 'CA' )   " ).append("\n"); 
		query.append("  AND l.trsp_mod_cd = @[trsp_mod_cd] " ).append("\n"); 
		query.append("  AND L.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 

	}
}