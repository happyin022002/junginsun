/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BLDocumentationBLDBDAOModifyCaStartUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOModifyCaStartUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLDocumentationBLDBDAOModifyCaStartUSQL
	  * </pre>
	  */
	public BLDocumentationBLDBDAOModifyCaStartUSQL(){
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
		params.put("ca_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOModifyCaStartUSQL").append("\n"); 
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
		query.append("UPDATE BKG_BL_DOC" ).append("\n"); 
		query.append("   SET CORR_NO     = @[ca_no]" ).append("\n"); 
		query.append("     , CORR_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("     , CORR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("     , CORR_N1ST_DT = NVL(CORR_N1ST_DT, GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(), SYSDATE, BKG_COM_USER_LOC_FNC(@[usr_id])))" ).append("\n"); 
		query.append("     , CORR_DT  = GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(), SYSDATE, BKG_COM_USER_LOC_FNC(@[usr_id]))" ).append("\n"); 
		query.append(" 	 , CORR_GDT = GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(), sysdate, 'GMT')" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}