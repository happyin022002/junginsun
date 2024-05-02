/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UserSetupMgtDBDAOBkgUsrTmpltVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.10 전용진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun Yong Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserSetupMgtDBDAOBkgUsrTmpltVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert   
	  * </pre>
	  */
	public UserSetupMgtDBDAOBkgUsrTmpltVOCSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmplt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmplt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tmplt_hdr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("insert into bkg_usr_tmplt (" ).append("\n"); 
		query.append("usr_id," ).append("\n"); 
		query.append("tmplt_tp_cd," ).append("\n"); 
		query.append("tmplt_seq," ).append("\n"); 
		query.append("tmplt_hdr_nm," ).append("\n"); 
		query.append("tmplt_ctnt," ).append("\n"); 
		query.append("cre_usr_id," ).append("\n"); 
		query.append("cre_dt," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(") values(" ).append("\n"); 
		query.append("@[usr_id]," ).append("\n"); 
		query.append("@[tmplt_tp_cd]," ).append("\n"); 
		query.append("nvl((select /*+ index_desc(bkg_usr_tmplt XPKBKG_USR_TMPLT)  */" ).append("\n"); 
		query.append("tmplt_seq" ).append("\n"); 
		query.append("from bkg_usr_tmplt" ).append("\n"); 
		query.append("where usr_id = @[usr_id]" ).append("\n"); 
		query.append("and   tmplt_tp_cd = @[tmplt_tp_cd]" ).append("\n"); 
		query.append("and   rownum = 1),0)+1," ).append("\n"); 
		query.append("@[tmplt_hdr_nm]," ).append("\n"); 
		query.append("@[tmplt_ctnt]," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("sysdate," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOBkgUsrTmpltVOCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}