/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UserSetupMgtDBDAOBkgUsrTmpltVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.05.19 전용진
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
 * @since J2EE 1.4
 */

public class UserSetupMgtDBDAOBkgUsrTmpltVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update
	  * </pre>
	  */
	public UserSetupMgtDBDAOBkgUsrTmpltVOUSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmplt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmplt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmplt_hdr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "2,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmplt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("update bkg_usr_tmplt set" ).append("\n"); 
		query.append("tmplt_tp_cd = @[tmplt_tp_cd]," ).append("\n"); 
		query.append("tmplt_hdr_nm = @[tmplt_hdr_nm]," ).append("\n"); 
		query.append("tmplt_ctnt = @[tmplt_ctnt]," ).append("\n"); 
		query.append("upd_usr_id = @[upd_usr_id]," ).append("\n"); 
		query.append("upd_dt = sysdate" ).append("\n"); 
		query.append("where	usr_id = @[usr_id]" ).append("\n"); 
		query.append("and	tmplt_tp_cd = @[tmplt_tp_cd]" ).append("\n"); 
		query.append("and	tmplt_seq = @[tmplt_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOBkgUsrTmpltVOUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}