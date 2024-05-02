/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MstMgmtDBDAORemoveMdmUsrAuthVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MstMgmtDBDAORemoveMdmUsrAuthVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MdmUsrAuthVO 정보를 삭제한다.
	  * </pre>
	  */
	public MstMgmtDBDAORemoveMdmUsrAuthVODSQL(){
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
		params.put("mst_dat_subj_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.integration ").append("\n"); 
		query.append("FileName : MstMgmtDBDAORemoveMdmUsrAuthVODSQL").append("\n"); 
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
		query.append("DELETE FROM MDM_USR_AUTH" ).append("\n"); 
		query.append("WHERE USR_ID = @[usr_id]" ).append("\n"); 
		query.append("AND MST_DAT_SUBJ_CD = @[mst_dat_subj_cd]" ).append("\n"); 

	}
}