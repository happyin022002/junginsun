/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InlandLinkManageDBDAOInlandLinkSPUpdateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.02 
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

public class InlandLinkManageDBDAOInlandLinkSPUpdateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public InlandLinkManageDBDAOInlandLinkSPUpdateUSQL(){
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
		params.put("trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnk_org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.inlandlinkmanage.integration").append("\n"); 
		query.append("FileName : InlandLinkManageDBDAOInlandLinkSPUpdateUSQL").append("\n"); 
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
		query.append("UPDATE PRD_INLND_ROUT_DTL D" ).append("\n"); 
		query.append("SET D.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("WHERE D.LNK_ORG_NOD_CD = @[lnk_org_nod_cd]" ).append("\n"); 
		query.append("AND D.LNK_DEST_NOD_CD = @[lnk_dest_nod_cd]" ).append("\n"); 
		query.append("AND D.TRSP_MOD_CD = @[trsp_mod_cd]" ).append("\n"); 
		query.append("AND D.VNDR_SEQ <> @[vndr_seq]" ).append("\n"); 
		query.append("AND NVL(D.INLND_ROUT_CMB_FLG, 'N') = 'N'" ).append("\n"); 

	}
}