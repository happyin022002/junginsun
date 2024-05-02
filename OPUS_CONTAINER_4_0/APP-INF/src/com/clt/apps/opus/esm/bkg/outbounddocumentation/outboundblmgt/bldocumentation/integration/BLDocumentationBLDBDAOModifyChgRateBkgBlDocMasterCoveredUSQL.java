/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLDocumentationBLDBDAOModifyChgRateBkgBlDocMasterCoveredUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2010.03.09 이진서
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jin Seo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOModifyChgRateBkgBlDocMasterCoveredUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyChgRateBkgBlDocMasterCovered
	  * </pre>
	  */
	public BLDocumentationBLDBDAOModifyChgRateBkgBlDocMasterCoveredUSQL(){
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOModifyChgRateBkgBlDocMasterCoveredUSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("#if (${caflag} == 'Y')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("BKG_BL_DOC_HIS" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("MST_CVRD_BL_NO =  ''" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("#if (${mcflag} == 'M')" ).append("\n"); 
		query.append("MST_CVRD_BL_NO =  @[bl_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("BKG_NO =  @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("BKG_BL_DOC" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("MST_CVRD_BL_NO =  ''" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("#if (${mcflag} == 'M')" ).append("\n"); 
		query.append("MST_CVRD_BL_NO =  @[bl_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("BKG_NO =  @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}