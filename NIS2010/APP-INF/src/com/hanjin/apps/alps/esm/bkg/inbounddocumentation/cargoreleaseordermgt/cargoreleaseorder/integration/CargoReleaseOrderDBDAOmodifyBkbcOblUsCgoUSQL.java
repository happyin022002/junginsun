/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOmodifyBkbcOblUsCgoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOmodifyBkbcOblUsCgoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ....
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOmodifyBkbcOblUsCgoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_rdem_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgor_team_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOmodifyBkbcOblUsCgoUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CGO_RLSE" ).append("\n"); 
		query.append("   SET OBL_RDEM_FLG    = DECODE(@[cgor_team_cd],'S',@[obl_rdem_flg]," ).append("\n"); 
		query.append("                                 (SELECT SUBSTR(MAX(LPAD(HIS_SEQ,3,'000')||NVL(OBL_RDEM_FLG,'N')),-1)" ).append("\n"); 
		query.append("                                    FROM BKG_CGO_RLSE_HIS" ).append("\n"); 
		query.append("                                   WHERE BL_NO = @[bl_no]))," ).append("\n"); 
		query.append("       OBL_RDEM_LST_DT = GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',sysdate,GLOBALDATE_PKG.GET_LOCCD_FNC('NYCSC') )," ).append("\n"); 
		query.append("       UPD_USR_ID      = @[evnt_usr_id], " ).append("\n"); 
		query.append("       UPD_DT          = SYSDATE        " ).append("\n"); 
		query.append(" WHERE BL_NO           = @[bl_no]" ).append("\n"); 

	}
}