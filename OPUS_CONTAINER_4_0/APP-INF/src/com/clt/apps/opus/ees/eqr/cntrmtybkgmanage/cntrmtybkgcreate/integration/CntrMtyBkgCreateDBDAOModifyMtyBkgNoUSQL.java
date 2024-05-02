/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrMtyBkgCreateDBDAOModifyMtyBkgNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.21
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrMtyBkgCreateDBDAOModifyMtyBkgNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG NO UPDATE 처리
	  * </pre>
	  */
	public CntrMtyBkgCreateDBDAOModifyMtyBkgNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_exe_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration").append("\n"); 
		query.append("FileName : CntrMtyBkgCreateDBDAOModifyMtyBkgNoUSQL").append("\n"); 
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
		query.append("UPDATE EQR_CTRL_MTY_BKG_EXE" ).append("\n"); 
		query.append("SET MTY_BKG_NO		  = @[mty_bkg_no]" ).append("\n"); 
		query.append("   ,OLD_BKG_GRP_NO	  = @[mty_bkg_no]" ).append("\n"); 
		query.append("   ,MTY_BKG_FLG       = 'Y'" ).append("\n"); 
		query.append("   ,MTY_BKG_SPLIT_FLG = 'N'   " ).append("\n"); 
		query.append("   ,UPD_USR_ID		  = @[upd_usr_id]" ).append("\n"); 
		query.append("   ,UPD_DT			  = SYSDATE" ).append("\n"); 
		query.append("WHERE TRSP_MOD_CD  = @[trsp_mod_cd]" ).append("\n"); 
		query.append("AND   VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("AND	  SKD_VOY_NO   = @[skd_voy_no]" ).append("\n"); 
		query.append("AND	  SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND	  BKG_EXE_SEQ  = @[bkg_exe_seq]" ).append("\n"); 
		query.append("AND   MTY_BKG_NO IS NULL" ).append("\n"); 

	}
}