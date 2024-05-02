/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BLIssuanceDBDAOModifyBlIssByBkgNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOModifyBlIssByBkgNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyBlIssByBkgNo
	  * </pre>
	  */
	public BLIssuanceDBDAOModifyBlIssByBkgNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration ").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOModifyBlIssByBkgNoUSQL").append("\n"); 
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
		query.append("UPDATE BKG_BL_ISS  " ).append("\n"); 
		query.append("	SET    BL_PRF_SHPR_FLG   = 'Y'" ).append("\n"); 
		query.append("          ,      BL_PRF_SHPR_OFC_CD = (SELECT U.OFC_CD FROM COM_USER U WHERE U.USR_ID = @[upd_usr_id])" ).append("\n"); 
		query.append("          ,      BL_PRF_SHPR_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("          ,      BL_PRF_SHPR_DT     = SYSDATE" ).append("\n"); 
		query.append("          ,      UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("          ,      UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}