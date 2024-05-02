/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InlandLinkManageDBDAOdeleteInlandRoutMstUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.08.13 김귀진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandlinkmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kIm kwi-jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandLinkManageDBDAOdeleteInlandRoutMstUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * deleteInlandRoutMst
	  * </pre>
	  */
	public InlandLinkManageDBDAOdeleteInlandRoutMstUSQL(){
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
		params.put("usrId",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.inlandlinkmanage.integration ").append("\n"); 
		query.append("FileName : InlandLinkManageDBDAOdeleteInlandRoutMstUSQL").append("\n"); 
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
		query.append("UPDATE PRD_INLND_ROUT_MST M" ).append("\n"); 
		query.append("SET DELT_FLG= 'Y'," ).append("\n"); 
		query.append("INLND_ROUT_N2ND_RMK='DELETE BY EACH LINK'," ).append("\n"); 
		query.append("UPD_USR_ID = @[usrId]," ).append("\n"); 
		query.append("UPD_DT= SYSDATE" ).append("\n"); 
		query.append("WHERE EXISTS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD,ROUT_SEQ" ).append("\n"); 
		query.append("FROM PRD_INLND_ROUT_DTL" ).append("\n"); 
		query.append("WHERE LNK_ORG_NOD_CD= @[lnk_org_nod_cd] AND" ).append("\n"); 
		query.append("LNK_DEST_NOD_CD = @[lnk_dest_nod_cd] AND" ).append("\n"); 
		query.append("TRSP_MOD_CD = @[trsp_mod_cd]" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append("WHERE M.ROUT_ORG_NOD_CD= D.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND M.ROUT_DEST_NOD_CD=D.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND M.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}