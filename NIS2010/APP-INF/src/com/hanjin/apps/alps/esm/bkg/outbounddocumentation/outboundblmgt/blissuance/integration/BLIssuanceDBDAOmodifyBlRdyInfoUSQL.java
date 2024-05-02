/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BLIssuanceDBDAOmodifyBlRdyInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.28
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2013.01.28 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOmodifyBlRdyInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyBlRdyInfo update 쿼리
	  * </pre>
	  */
	public BLIssuanceDBDAOmodifyBlRdyInfoUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_ready_office",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOmodifyBlRdyInfoUSQL").append("\n"); 
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
		query.append("UPDATE BKG_BL_ISS BBI" ).append("\n"); 
		query.append("SET BBI.BL_RDY_FLG = 'Y'" ).append("\n"); 
		query.append("    ,BBI.BL_RDY_OFC_CD = @[bl_ready_office]" ).append("\n"); 
		query.append("    ,BBI.BL_RDY_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("    ,BBI.BL_RDY_DT = SYSDATE" ).append("\n"); 
		query.append("    ,BBI.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("    ,BBI.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE BBI.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}