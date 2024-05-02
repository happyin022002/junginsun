/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InlandLinkManageDBDAOIsAgmtNoRightRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.30
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2010.09.30 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandlinkmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandLinkManageDBDAOIsAgmtNoRightRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IsAgmtNoRight
	  * </pre>
	  */
	public InlandLinkManageDBDAOIsAgmtNoRightRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vnd_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.inlandlinkmanage.integration").append("\n"); 
		query.append("FileName : InlandLinkManageDBDAOIsAgmtNoRightRSQL").append("\n"); 
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
		query.append("SELECT AGMT_REF_NO from TRS_AGMT_HDR a ,TRS_AGMT_APLY_VNDR AV" ).append("\n"); 
		query.append("WHERE a.TRSP_AGMT_OFC_CTY_CD = @[cty_cd]" ).append("\n"); 
		query.append("AND   a.TRSP_AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("AND   av.VNDR_SEQ = @[vnd_seq]" ).append("\n"); 
		query.append("AND   a.TRSP_AGMT_OFC_CTY_CD = av.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   a.TRSP_AGMT_SEQ = av.TRSP_AGMT_SEQ" ).append("\n"); 

	}
}